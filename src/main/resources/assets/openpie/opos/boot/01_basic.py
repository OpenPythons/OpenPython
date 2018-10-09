import machine

import event

buf = []


@machine.hook_input
def input_handler():
    while not buf:
        event.wait(10)

    return int(buf.pop(0))


@event.register("key_down")
def handle_key_down(_1, char, *_):
    buf.append(char)



event.setup()
