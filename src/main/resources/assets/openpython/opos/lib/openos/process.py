# https://github.com/MightyPirates/OpenComputers/blob/master-MC1.12/
# - src/main/resources/assets/opencomputers/loot/openos/lib/process.lua

try:
    import usys as sys
except ImportError:
    import sys

    sys.modules["usys"] = sys
    # sys.modules["sys"] = sys


class Process:
    def __init__(self, context):
        self.context = context


_current_proccess = Process({})


def spawn(path):
    global _current_proccess
    context = {'__name__': '__main__', '__path__': path}

    proc = Process({})
    parent_proc, _current_proccess = _current_proccess, proc

    try:
        # noinspection PyUnresolvedReferences
        execfile(path, context)
    except SystemExit as e:
        return e.code
    finally:
        _current_proccess = parent_proc

    return 0


def current_process():
    return _current_proccess
