# noinspection PyUnresolvedReferences
import gc

import ucomputer
import utime


def address():
    return ucomputer.get_computer_address()


def tmp_address():
    return ucomputer.get_tmp_address()


def free_memory():
    return gc.mem_free()


def total_memory():
    return gc.mem_alloc() + gc.mem_free()


def uptime():
    return utime.time_up()


def shutdown(reboot: bool = False):
    if reboot:
        ucomputer.reboot()
    else:
        ucomputer.shutdown()

    raise NotImplementedError("invalid behavior")


def reboot():
    ucomputer.reboot()
    raise NotImplementedError("invalid behavior")


def get_boot_address() -> str:
    import component

    # noinspection PyUnresolvedReferences
    eeprom = component.eeprom
    return eeprom.getData().decode()


def set_boot_address(address: str):
    import component

    # noinspection PyUnresolvedReferences
    eeprom = component.eeprom
    eeprom.setData(address.encode())


def runlevel():
    return 1


def users():
    return ucomputer.get_users()


def add_user(user: str):
    return ucomputer.add_user(user)


def remove_user(user: str):
    return ucomputer.remove_user(user)


def push_signal(name, *args):
    ucomputer.push_signal(name, *args)


def pull_signal(seconds):
    signal = ucomputer.pop_signal(int(seconds * 20))
    if signal is None:
        return None

    name, args = signal
    return (name,) + args


def beep(frequency=None, duration=None):
    return ucomputer.beep(frequency, duration)
