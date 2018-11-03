import builtins

import event
import machine
import sys

last_input = []
buf = []


def check_key_down(name, *_):
    return name == "key_down"


@machine.hook_stdin
def input_handler():
    while True:
        signal = event.pull_filtered(1, check_key_down)
        if signal is not None:
            _name, _address, char, code, _user = signal
            if char:
                return int(char)


# noinspection PyShadowingBuiltins
def input(prompt=None):
    if prompt is not None:
        print(prompt, end="")

    read = sys.stdin.read
    write = sys.stdout.write
    buf = []
    ignore = 0
    while True:
        ch = read(1)
        if ignore > 0:
            ignore -= 1
            continue

        if ch == '\n':
            write(ch)
            break
        elif ch == '\b':
            if buf:
                buf.pop()
                write(ch + "---")
            continue
        else:
            write(ch)
            buf.append(ch)

    return ''.join(buf)


builtins.input = input
