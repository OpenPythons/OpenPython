# https://github.com/MightyPirates/OpenComputers/blob/master-MC1.12/
# - src/main/resources/assets/opencomputers/loot/openos/lib/tty.lua
import component
import computer
import event
import re

__all__ = "window",

screen_cache = {}
gpu_intercept = {}


class Viewport:
    def __init__(self, width, height, dx, dy, x, y):
        self.width = width
        self.height = height
        self.dx = dx
        self.dy = dy
        self.x = x
        self.y = y

    def update_size(self, width, height):
        self.width = width
        self.height = height

    def copy(self):
        return Viewport(self.width, self.height, self.dx, self.dy, self.x, self.y)

    def unpack(self):
        return self.width, self.height, self.dx, self.dy, self.x, self.y


class Window:
    def __init__(self):
        self.gpu = None
        self.keyboard = None
        self.viewport = Viewport(None, None, 0, 0, 0, 1)
        self.fullscreen = True
        self.blink = True
        self.output_buffer = ""
        self.nowarp = False

    @property
    def screen(self):
        return self.gpu.getScreen() if self.gpu else None


class Stream:
    class Cursor:
        def __init__(self, sy=0):
            self.sy = sy
            self.tails = {}

    def read(self):
        pass

    def write(self, value):
        segment_regex = re.compile("([\27\t\r\n\a\b])")

        update_viewport()

        gpu = window.gpu
        viewport = window.viewport
        window.output_buffer += value
        cursor = self.Cursor()
        beeped = False

        while True:
            cursor.sy += self.scroll()
            if not window.output_buffer:
                break

            ansi_print = ""
            x, y = get_cursor()

            segment = window.output_buffer[:viewport.width]

            m = segment_regex.search(buf)
            segment = ansi_print + m.group(0) if m else buf
            ei = m.end() if m else None
            delim = m.group(1) if m else None

            if segment:
                gpu_x = x + viewport.dx
                gpu_y = y + viewport.dy
                tail = ""
                wlen_needed = len(segment)
                wlen_remaining = viewport.width - x + 1
                if wlen_remaining < wlen_needed:
                    segment = segment[:wlen_remaining]
                    wlen_needed = len(segment)
                    tail = " " if wlen_needed < wlen_remaining else ""
                    cursor.tails[gpu_y - cursor.sy] = tail
                    if not window.nowarp:
                        ei = len(segment)
                        delim = "\n"

                gpu.set(gpu_x, gpu_y, segment + tail)
                x += wlen_needed

            window.output_buffer = (
                window.output_buffer[ei:]
                if ei
                else window.output_buffer[viewport.width:]
            )

            if delim is None:
                pass
            elif delim == "\r":
                x = 1
            elif delim == "\n":
                x = 1
                y = y + 1
            elif delim == "\b":
                x = x - 1
            elif delim == "\a" and not beeped:
                computer.beep()
                beeped = True
            elif delim == "\27":
                window.output_buffer = delim + window.output_buffer

            set_cursor(x, y)

        return cursor.sy

    def clear(self):
        pass

    def scroll(self, lines=None):
        viewport = window.viewport
        if not lines:
            if viewport.y < 1:
                lines = viewport.y - 1
            elif viewport.y > viewport.height:
                lines = viewport.y - viewport.height
            else:
                return 0

        gpu = window.gpu
        if not gpu:
            return 0

        lines = max(min(lines, viewport.height), -viewport.height)

        abs_lines = abs(lines)
        box_height = viewport.height - abs_lines
        fill_top = viewport.dy + 1 + (lines < 0 and 0 or box_height)

        gpu.copy(viewport.dx + 1, viewport.dy + 1 + max(0, lines), viewport.width, box_height, 0, -lines)
        gpu.fill(viewport.dx + 1, fill_top, viewport.width, abs_lines, ' ')

        set_cursor(viewport.x, max(1, min(viewport.y, viewport.height)))
        return lines


window = Window()
stream = Stream()


def update_viewport():
    screen = window.screen
    if window.fullscreen and screen and not screen_cache.get(screen):
        screen_cache[screen] = True
        width, height = window.gpu.getViewport()
        window.viewport.update_size(width, height)


def get_viewport():
    update_viewport()
    return window.viewport.copy()


def set_viewport(width, height, dx=0, dy=0, x=1, y=1):
    window.viewport = Viewport(width, height, dx, dy, x, y)


def gpu():
    return window.gpu


def clear():
    stream.clear()
    set_cursor(1, 1)


def isAvailable():
    return window.screen is not None


def get_cursor():
    viewport = window.viewport
    return viewport.x, viewport.y


def set_cursor(x, y):
    viewport = window.viewport
    viewport.x, viewport.y = x, y


def bind(gpu):
    if not gpu_intercept.get(gpu):
        gpu_intercept[gpu] = True

        _setResolution, _setViewport = gpu.setResolution, gpu.setViewport

        def setResolution(*args):
            screen_reset(gpu)
            return _setResolution(*args)

        def setViewport(*args):
            screen_reset(gpu)
            return _setViewport(*args)

        gpu.setResolution = setResolution
        gpu.setViewport = setViewport

    if window.gpu is not gpu:
        window.gpu = gpu
        window.keyboard = None
        update_viewport()

    screen_reset(gpu)


def keyboard():
    if window.keyboard:
        return window.keyboard

    system_keyboard = component.get_primary("keyboard").address if component.is_available("keyboard") else None
    screen = window.screen

    if not screen:
        return "no_system_keyboard"

    if component.is_available("screen") and component.get_primary("screen").address == screen:
        window.keyboard = system_keyboard
    else:
        window.keyboard = component.Component(screen).getKeyboards() or system_keyboard

    return window.keyboard


def screen():
    return window.screen


@event.on("screen_resized")
def screen_reset_event(_name, gpu_addr, screen_addr):
    screen_cache[gpu_addr] = None


def screen_reset(gpu):
    screen_cache[gpu.address] = None
