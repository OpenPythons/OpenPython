# noinspection PyUnresolvedReferences
from ucomputer import *
import ucomputer
import utime


def address():
    return ucomputer.get_computer_address()


def uptime():
    return utime.time_up()


def pull_signal(seconds):
    signal = ucomputer.pop_signal(int(seconds * 20))
    if signal is None:
        return None

    name, args = signal
    return (name,) + args
