import machine

import event
import value

buf = []


@machine.hook_stdin
def input_handler():
    while not buf:
        event.wait(10)

    return int(buf.pop(0))


@event.register("key_down")
def handle_key_down(_0, _1, char, *_):
    buf.append(char)


event.setup()
value.setup()
