from computer import pop_signal
import machine

__all__ = ["register", "unregister", "setup"]

event = {}
handlers = {}
lastInterrupt = None

registered = {}


def signal_handler(ticks):
    signal = pop_signal(ticks)
    if not signal:
        return

    name, args = signal
    handlers = registered.get(name)
    if not handlers:
        return

    for handler in handlers:
        try:
            handler(*args)
        except BaseException as e:
            machine.debug("signal_handler exc => %s: %s" % (type(e).__name__, e))


def listen(name, callback):
    handlers = registered.setdefault(name, [])
    if callback in handlers:
        return False

    handlers.append(callback)
    return True


def ignore(name, callback):
    handlers = registered.get(name)  # type: list
    if not handlers:
        return False

    if callback not in handlers:
        return False

    handlers.remove(callback)
    return True


def timer(interval, callback, times):
    # event.register(false, callback, interval, times)
    handler = {
        "key": key,
    }


def register(name):
    def wrapper(callback):
        listen(name, callback)
        return callback

    return wrapper


def unregister(name, func):
    handlers = registered.setdefault(name, [])
    handlers.remove(func)


def setup():
    machine.hook_signal(signal_handler)


def wait(ticks):
    signal_handler(ticks)
