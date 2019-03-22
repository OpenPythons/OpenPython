import builtins
import sys


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
