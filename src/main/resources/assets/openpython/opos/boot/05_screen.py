import machine

import component
from monitor import Monitor, _set_monitor

gpu = component.get_primary("gpu")

screen = None
for screen in component.list("screen"):
    if screen.getKeyboards():
        component.set_primary("screen", screen.address)
        break

if gpu and screen:
    monitor = Monitor(gpu)
    gpu.bind(screen.address)
    w, h = gpu.maxResolution()
    monitor.w, monitor.h = w, h
    gpu.setResolution(w, h)
    gpu.setBackground(0x000000)
    gpu.setForeground(0xFFFFFF)
    gpu.fill(1, 1, w, h, " ")


    @machine.hook_stdout
    def print_handler(string):
        try:
            for char in string:
                monitor.put(char)
        except BaseException as e:
            machine.debug("print_handler exc =? %s: %s" % (type(e).__name__, e))


    _set_monitor(monitor)
