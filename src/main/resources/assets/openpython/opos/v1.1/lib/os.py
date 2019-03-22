import uos
from ucollections import namedtuple
from uos import *

import ocpath as path
from ocpath import curdir, pardir, sep, extsep, altsep, pathsep, defpath, devnull
from process import current_process, walk_process

__all__ = [
    # uos.*
    "chdir", "getcwd", "ilistdir", "listdir", "mkdir", "remove", "rmdir", "rename", "stat", "statvfs", "sync",
    "urandom", "dupterm", "mount", "umount",
    # ocpath
    # "path",
    # ocpath.*
    "curdir", "pardir", "sep", "extsep", "altsep", "pathsep", "defpath", "devnull",
    # os
    "name", "Environ", "environ", "getenv", "path"
]

stat_result = namedtuple("os.stat_result", (
    "st_mode", "st_ino", "st_dev", "st_nlink",
    "st_uid", "st_gid",
    "st_size",
    "st_atime", "st_mtime", "st_ctime"
))

vfs_result = namedtuple("os.vfs_result", (
    "f_bsize", "f_frsize",
    "f_blocks", "f_bfree",
    "f_bavail", "f_files",
    "f_ffree", "f_favail",
    "f_flag",
    "f_namemax",
))


def stat(p):
    r = uos.stat(p)
    return stat_result(*r)


def vfsstat(p):
    r = uos.statvfs(p)
    return vfs_result(*r)


name = "oc"
linesep = '\n'


def listdir(p=None):
    return uos.listdir(getcwd() if p is None else path.join(getcwd(), p))


class Environ:
    def __getitem__(self, item):
        value = self.get(item)
        if value is None:
            raise KeyError(item)

        return value

    def __setitem__(self, key, value):
        proc = current_process()
        proc.environ[key] = value

    def __delitem__(self, key):
        for proc in walk_process():
            if key in proc.environ:
                proc = current_process()
                proc.environ[key] = None
                break

    def __contains__(self, item):
        value = self.get(item)
        return value is not None

    def get(self, key, default=None):
        for proc in walk_process():
            if key in proc.environ:
                return proc.environ[key]

        return default


environ = Environ()


def getenv(name):
    return environ.get(name)


def setup():
    from process import init_process
    proc = init_process()
    proc.environ = {
        "TMPDIR": "/tmp",
        "PATH": defpath,
        "HOME": "/home",
        "_": "/init.py",
    }
