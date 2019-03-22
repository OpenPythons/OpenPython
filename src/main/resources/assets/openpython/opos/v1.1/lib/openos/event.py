# https://github.com/MightyPirates/OpenComputers/blob/master-MC1.12/
# - src/main/resources/assets/opencomputers/loot/openos/lib/event.lua
# - src/main/resources/assets/opencomputers/loot/openos/lib/core/full_event.lua

import sys

import computer
import machine
import process
from computer import pull_signal

__all__ = ["Handlers", "on", "listen", "pull", "pull_filtered", "pull_multiple", "cancel", "ignore"]

INF = sys.maxsize
ALWAYS = None
TIMER = False
EMPTY = ()

last_interrupt = -1

keyboard = None


class Handler:
    def __init__(self, key, callback, interval: float = None, times=None):
        self.key = key
        self.callback = callback
        self.times = times
        self.interval = interval  # timer
        self.timeout = None if interval is None else computer.uptime() + interval  # timer


class Handlers:
    def __init__(self):
        self.callback_by_event = {}
        self.registered = {}

    def register(self, handler: Handler):
        self.registered[id(handler)] = handler

        seq = self.callback_by_event.setdefault(handler.key, [])
        seq.append(handler)

        return id(handler)

    def unregister(self, handler: Handler):
        handler = self.registered.pop(id(handler), None)
        if handler is not None:
            key = handler.key
            seq = self.callback_by_event[key]  # type: list
            seq.remove(handler)
            if not seq:
                del self.callback_by_event[key]

        return handler is None

    def iter_all_handlers(self):
        return self.registered.values()

    def get_handlers(self, name):
        return self.callback_by_event.get(name) or EMPTY

    def unregister_by_id(self, timer_id):
        handler = self.registered.get(timer_id)
        return self.unregister(handler)


handlers = Handlers()


def register(key, callback, interval=None, times=None, opt_handlers: Handlers = None):
    opt_handlers = opt_handlers if opt_handlers is not None else handlers
    handler = Handler(key, callback, interval, times)
    return opt_handlers.register(handler)


def create_plain_filter(name, *args):
    def func(sname, *sargs):
        if name != sname:
            return False

        for arg, sarg in zip(args, sargs):
            if arg is not None and arg != sarg:
                return False

        return True

    return func


def create_multiple_filter(*args):
    def func(name, *_):
        for arg in args:
            if arg == name:
                return True

        return False

    return func


def signal_handler(ticks):
    global last_interrupt
    current_time = computer.uptime()
    interrupting = (
            current_time - last_interrupt > 1 and
            keyboard.is_control_down() and
            keyboard.is_key_down(keyboard.KEYS.c)
    ) if keyboard else False

    if interrupting:
        last_interrupt = current_time
        if keyboard and keyboard.is_alt_down():
            process.current_process().signal("INTERRUPTED")

        push("interrupted", current_time)

    removes = set()
    signal = pull_signal(ticks)

    def process_handler(etype, signal):
        for handler in handlers.get_handlers(etype):  # type: Handler
            is_timer = handler.timeout is not None
            if is_timer and current_time < handler.timeout:
                continue

            if handler.times is not None:
                handler.times -= 1
                if handler.times <= 0:
                    removes.add(handler)
                elif handler.interval is not None:
                    handler.timeout = current_time + handler.interval

            try:
                name, args = signal
                result = handler.callback(name, *args)
            except BaseException as e:
                on_error(e)
            else:
                if result is False:
                    removes.add(handler)

    process_handler(TIMER, None)
    for handler in removes:
        handlers.unregister(handler)

    if signal is None:
        return

    removes = set()
    name, *args = signal
    process_handler(ALWAYS, signal)
    process_handler(name, signal)

    for handler in removes:
        handlers.unregister(handler)

    return signal


def on(name):
    def wrapper(callback):
        listen(name, callback)
        return callback

    return wrapper


def listen(name, callback):
    for handler in handlers.registered.values():
        if handler.key == name and handler.callback == callback:
            return False

    return register(name, callback)


def ignore(name, callback):
    removes = set()
    for handler in handlers.iter_all_handlers():
        if handler.key == name and handler.callback == callback:
            removes.add(handler)
            break  # ..?

    for handler in removes:
        handlers.unregister(handler)

    return len(removes) > 0


def timer(interval: float, callback, times: int):
    return register(TIMER, callback, interval, times)


def cancel(timer_id):
    return handlers.unregister_by_id(timer_id)


def push(name, *args):
    computer.push_signal(name, *args)


def pull(first, *args):
    if isinstance(first, str):
        return pull_filtered(create_plain_filter(first, *args))
    else:
        return pull_filtered(first, create_plain_filter(*args))


def pull_filtered(first, second=None):
    seconds = INF
    func = None

    if callable(first) and second is None:
        func = first
    elif callable(second):
        seconds = first
        func = second

    deadline = computer.uptime() + seconds
    while computer.uptime() < deadline:
        closest = deadline
        for handler in handlers.iter_all_handlers():
            if handler.timeout is not None:
                closest = min(closest, handler.timeout)

        signal = computer.pull_signal(closest - computer.uptime())
        if signal is None:
            continue

        if func(*signal):
            return signal


def pull_multiple(first, *args):
    if isinstance(first, int):
        return pull_filtered(first, create_multiple_filter(*args))
    else:
        return pull_filtered(create_multiple_filter(first, *args))


def on_error(e):
    machine.debug("signal_handler exc => %s: %s" % (type(e).__name__, e))


def setup():
    global keyboard

    def pull_signal(seconds):
        ticks = sys.maxsize if seconds == INF else int(seconds * 20)
        return signal_handler(ticks)

    # noinspection PyUnresolvedReferences
    import keyboard

    computer.pull_signal = pull_signal
    machine.hook_signal(signal_handler)


def wait(ticks):
    signal_handler(ticks)
