from component import get_component, find_components
from monitor import Monitor, _set_monitor
import machine

gpu = get_component("gpu")

screen = None
for screen in find_components("screen"):
    if screen.getKeyboards():
        break

if gpu and screen:
    monitor = Monitor(gpu.address, gpu.type)
    monitor.bind(screen.address)
    w, h = monitor.maxResolution()
    monitor.setResolution(w, h)
    monitor.setBackground(0x000000)
    monitor.setForeground(0xFFFFFF)
    monitor.fill(1, 1, w, h, " ")


    @machine.hook_print
    def print_handler(string):
        try:
            for char in string:
                monitor.put(char)
        except BaseException as e:
            machine.debug("print_handler exc =? %s: %s" % (type(e).__name__, e))


    _set_monitor(monitor)
