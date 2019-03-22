from uio import FileIO

import errno
import ocpath
from component import Component

forced_cd = False


class FileSystem:
    def __init__(self, address, root=False):
        self.fs = Component(address)
        self.address = address
        self.readonly = self.fs.isReadOnly()
        self.cwd = "/" if root else ''
        self.root = root

    # noinspection PyUnusedLocal
    def mount(self, readonly, mkfs):
        self.readonly = self.fs.isReadOnly() or readonly

    def umount(self):
        pass

    def ilistdir(self, dir):
        for name in self.fs.list(dir):
            if self.fs.isDirectory(dir + "/" + name):
                yield (name, 0x4000, 0, -1)
            else:
                size = self.fs.size(name)
                yield (name, 0x8000, 0, size)

    def guard_readonly(self):
        if self.readonly:
            raise OSError(errno.EPERM)

    def chdir(self, dir):
        path = ocpath.join(self.cwd, dir)
        path = ocpath.normpath(path)
        path = path.rstrip(ocpath.sep)

        if not path:
            path = "/" if self.root else "'"
        elif '..' == path or ('..' + ocpath.sep) in path:
            path = "/" if self.root else ""

        if not forced_cd and not self.fs.isDirectory(path):
            raise OSError(errno.ENOTDIR)

        self.cwd = path

    def getcwd(self):
        return self.cwd

    def mkdir(self, path):
        self.guard_readonly()
        result = self.fs.makeDirectory(path)
        if not result:
            exists = self.fs.exists(path)
            if self.fs.isDirectory(path):
                raise OSError(errno.EISDIR)
            elif exists:  # file
                raise OSError(errno.EEXIST)

            raise OSError(errno.ENOENT)

    def remove(self, path):
        self.guard_readonly()
        self.fs.remove(path)

    def rename(self, old_path, new_path):
        self.guard_readonly()
        result = self.fs.rename(old_path, new_path)
        if not result:
            raise OSError(errno.ENOENT)

    def rmdir(self, path):
        self.guard_readonly()
        if not self.fs.isDirectory(path):
            if self.fs.exists(path):
                # is file
                raise OSError(errno.EEXIST)

            raise OSError(errno.ENOENT)

        result = self.fs.remove(path)
        if not result:
            raise OSError(errno.ENOENT)

    def stat(self, path):
        if not self.fs.exists(path):
            raise OSError(errno.ENOENT)

        is_dir = self.fs.isDirectory(path)
        size = self.fs.size(path) if not is_dir else 0
        mtime = self.fs.lastModified(path)

        return (
            0x4000 if is_dir else 0x8000,  # st_mode
            hash(path),  # st_ino
            hash(self.address),  # dev
            1,  # nlink
            0,  # uid: root
            0,  # gid: root
            size,  # size
            mtime,  # atime
            mtime,  # mtime
            mtime,  # ctime
        )

    # noinspection PyUnusedLocal
    def statvfs(self, path):
        used = self.fs.spaceUsed()
        total = self.fs.spaceTotal()
        free = total - used

        return (
            1,  # f_bsize
            1,  # f_frsize
            used,  # f_blocks
            free,  # f_bfree
            free,  # f_bavail
            used,  # f_files
            free,  # f_ffree
            free,  # f_favail
            0,  # f_flag
            256,  # f_namemax
        )

    def open(self, file, mode):
        # TODO: nomalize mode
        return FileIO(self.fs.address, file, mode)

    def __repr__(self):
        return "<FileSystem: {!r}>".format(self.address)
