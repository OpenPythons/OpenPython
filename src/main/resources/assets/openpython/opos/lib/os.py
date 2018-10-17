from uos import *

import ocpath as path
from ocpath import curdir, pardir, sep, extsep, altsep, pathsep, linesep, defpath, devnull

__all__ = [
    # uos.*
    "chdir", "getcwd", "ilistdir", "listdir", "mkdir", "remove", "rmdir", "rename", "stat", "statvfs", "sync",
    "urandom", "dupterm", "mount", "umount",
    # ocpath
    "path",
    # ocpath.*
    "curdir", "pardir", "sep", "extsep", "altsep", "pathsep", "linesep", "defpath", "devnull",
    # os
    "name", "Environ", "environ", "getenv"
]

name = "oc"


class Environ:
    def __init__(self, default):
        self.data = default

    def __getitem__(self, item):
        return self.data[item]

    def __setitem__(self, key, value):
        self.data[key] = value

    def __delitem__(self, key):
        del self.data[key]

    def __contains__(self, item):
        return item in self.data

    def get(self, default=None):
        return self.data.get(default)


environ = Environ({
    "TMPDIR": "/tmp",
    "PATH": defpath,
    "PWD": "/",  # TODO: dynamic
    "HOME": "/home",
    "_": "<current program>"
})


def getenv(name):
    return environ.get(name)
