# https://github.com/MightyPirates/OpenComputers/blob/master-MC1.12/
# - src/main/resources/assets/opencomputers/loot/openos/lib/process.lua

import sys


class Process:
    def __init__(self, pid, context, environ, parent, args):
        self.pid = pid
        self.context = context
        self.environ = environ
        self.parent = parent
        self.args = args
        self.tcwd = None


_pid = 1
_callbacks = []
_current_process = _init_process = Process(
    pid=_pid,
    context={'__name__': '<init.py>', '__path__': '/init.py'},
    environ={},
    parent=None,
    args=['/init.py'],
)


def spawn(path, *args, environ=None):
    global _current_process, _pid

    _pid += 1

    proc = Process(
        pid=_pid,
        context={'__name__': '__main__', '__path__': path},
        environ={} if environ is None else {},
        parent=_current_process,
        args=list(args),
    )

    _current_process = proc

    for enter_callback, _ in _callbacks:
        enter_callback(proc)

    try:
        # noinspection PyUnresolvedReferences
        execfile(path, proc.context)
    except SystemExit as e:
        return e.code
    finally:
        for _, leave_callback in _callbacks:
            leave_callback(proc)

        _current_process = proc.parent

    return 0


def init_process():
    return _init_process


def current_process():
    assert _current_process is not None
    return _current_process


def walk_process(proc=None):
    proc = _current_process if proc is None else proc
    assert proc is not None
    while proc is not None and proc.parent is not proc:
        yield proc
        proc = proc.parent


def _install_hook(enter_callback, leave_callback):
    _callbacks.append((enter_callback, leave_callback))


def _sys_getattr(name: str):
    if name == "argv":
        return _current_process.args

    raise AttributeError("{!r} object has no attribute {!r}".format('module', name))


def setup():
    import os
    import filesystem
    sys.__getattr__ = _sys_getattr

    def enter_proc(proc):
        proc.parent.tcwd = os.getcwd()

    def leave_proc(proc):
        prev_forced_cd, filesystem.forced_cd = filesystem.forced_cd, True

        try:
            os.chdir(proc.parent.tcwd)
        finally:
            filesystem.forced_cd = prev_forced_cd

    _install_hook(enter_proc, leave_proc)
