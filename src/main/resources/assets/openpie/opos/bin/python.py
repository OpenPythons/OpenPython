import computer
import micropython
import uos
from ucode import repl_input, repl_compile, repl_call


class Command:
    def __init__(self, func):
        self.func = func

    def __call__(self, *args, **kwargs):
        return self.func(*args, **kwargs)

    def __repr__(self):
        result = self.func()
        if result is None:
            # monitor.heightPos -= 1
            return ""
        else:
            return result


def _listdir(path="/"):
    print([path for path, *_ in uos.ilistdir(path)])


def _cls():
    pass
    # monitor.widthPos = 1
    # monitor.heightPos = 1
    # gpu.fill(1, 1, monitor.widthSize, monitor.heightSize, " ")


def mem_info():
    import gc
    gc.collect()
    micropython.mem_info()


def _show(name=None):
    if name is None:
        help("modules")
        return

    module = __import__(name)
    help(module)


commands = dict(
    listdir=Command(_listdir),
    cls=Command(_cls),
    mem=Command(mem_info),
    help=Command(help),
    show=Command(_show),
    reboot=Command(computer.reboot),
)


def main():
    context = {"__name__": "<shell>"}
    context.update(commands)

    while True:
        try:
            code = repl_input()
        except Exception as e:
            print(type(e).__name__, e)
            continue

        if code == 'exit':
            break

        try:
            func = repl_compile(code, context)
        except SystemExit as e:
            return e.args[0] if e.args else 0
        except Exception as e:
            print(type(e).__name__, e)
            continue

        try:
            repl_call(func, context)
        except BaseException as e:
            print(type(e).__name__, e)


if __name__ == '__main__':
    main()
