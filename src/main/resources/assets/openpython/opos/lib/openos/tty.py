# https://github.com/MightyPirates/OpenComputers/blob/master-MC1.12/
# - src/main/resources/assets/opencomputers/loot/openos/lib/tty.lua

import event

__all__ = "window"

screen_cache = {}
gpu_intercept = {}


class Window:
    def __init__(self):
        self.fullscreen = True
        self.blink = True
        self.dx = 0
        self.dy = 0
        self.x = 0
        self.y = 1
        self.width = None
        self.height = None
        self.output_buffer = ""
        self.stream = None
        self.gpu = None

    @property
    def screen(self):
        return self.gpu.getScreen() if self.gpu else None

    def get_viewport(self):
        screen = self.screen
        if self.fullscreen and screen and not screen_cache[screen]:
            screen_cache[screen] = True
            self.height, self.height = self.gpu.getViewPort()

        return self.width, self.height, self.dx, self.dy, self.x, self.y

    def clear(self):
        self.stream.scroll(None)
        self.set_cursor(1, 1)

    def is_available(self):
        return bool(self.gpu and self.screen)

    def bind(self, gpu):


class WindowStream:
    def read(self):
        pass

    def write(self, value):
        pass


window = Window()


@event.on("screen_resized")
def screen_reset(_name, gpu, addr):
    pass
