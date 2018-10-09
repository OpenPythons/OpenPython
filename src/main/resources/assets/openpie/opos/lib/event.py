import machine

__all__ = ["register", "unregister", "setup"]

registered = {}


def signal_handler(ticks):
    signal = machine.signal(ticks)
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


def register(name):
    def wrapper(func):
        handlers = registered.setdefault(name, [])
        handlers.append(func)
        return func

    return wrapper


def unregister(name, func):
    handlers = registered.setdefault(name, [])
    handlers.remove(func)


def setup():
    machine.hook_signal(signal_handler)


def wait(ticks):
    signal_handler(ticks)
