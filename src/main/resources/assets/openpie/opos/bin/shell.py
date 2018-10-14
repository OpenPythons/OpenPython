import uos

import computer
from shell import spawn

commands = {}


class State:
    prompt = "> "


def command(func):
    commands[func.__name__] = func


@command
def hello(state):
    print("hello world!")
    return 0


@command
def dir(state, path=None):
    seq = uos.listdir() if path is None else uos.listdir(path)
    for name in seq:
        print(name, end="    ")
    print()

    return 0


@command
def cd(state, path):
    uos.chdir(path)
    return 0


@command
def cwd(state):
    print(uos.getcwd())
    return 0


@command
def reboot(state):
    computer.reboot()
    return 0


@command
def python(state):
    spawn("/bin/python.py")
    return


def main():
    # noinspection PyUnresolvedReferences
    state = State()
    while True:
        line = input(state.prompt)
        tokens = line.split()
        if not tokens:
            continue

        cmd, *args = tokens
        if cmd == "exit" or cmd == "quit":
            break

        func = commands.get(cmd)
        if func is None:
            print(cmd, "Not Found!")
            continue

        try:
            code = func(state, *args)
        except Exception as e:
            print(type(e).__name__, e)
            code = 1

        if code:
            print("code:", code)


if __name__ == '__main__':
    main()
