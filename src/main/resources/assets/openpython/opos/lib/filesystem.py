from uio import FileIO

from component import Component, list


class FileSystem:
    def __init__(self, address):
        self.fs = Component(address)
        self.address = address
        self.readonly = self.fs.isReadOnly()
        self.cwd = "/"

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

    def chdir(self, dir):
        if not self.fs.isDirectory(dir):
            raise OSError(1)

        self.cwd = dir

    def getcwd(self):
        return self.cwd

    def mkdir(self, path):
        if self.readonly:
            raise OSError(1)

        result = self.fs.makeDirectory(path)
        if not result:
            exists = self.fs.exists(path)
            if self.fs.isDirectory(path):
                raise OSError(1)
            elif exists:  # file
                raise OSError(1)

            raise OSError(1)

    def remove(self, path):
        if self.readonly:
            raise OSError(1)

        self.fs.remove(path)

    def rename(self, old_path, new_path):
        if self.readonly:
            raise OSError(1)

        result = self.fs.rename(old_path, new_path)
        if not result:
            raise OSError(1)

    def rmdir(self, path):
        if self.readonly:
            raise OSError(1)

        if not self.fs.isDirectory(path):
            if self.fs.exists(path):
                # is file
                raise OSError(1)

            raise OSError(1)

        result = self.fs.remove(path)
        if not result:
            raise OSError(1)

    def stat(self, path):
        if not self.fs.exists(path):
            raise OSError(1)

        is_dir = self.fs.isDirectory(path)
        size = self.fs.size(path) if not is_dir else 0
        mtime = self.fs.lastModified(path)

        return (
            0x4000 if is_dir else 0x8000,  # st_mode
            0,  # st_ino
            0,  # dev
            0,  # nlink
            0,  # uid: root
            0,  # gid: root
            size,  # size
            mtime,  # atime
            mtime,  # mtime
            mtime,  # ctime
        )

    # noinspection PyUnusedLocal
    def statvfs(self, path):
        return (
            0,  # f_bsize
            0,  # f_frsize
            0,  # f_blocks
            0,  # f_bfree
            0,  # f_bavail
            0,  # f_files
            0,  # f_ffree
            0,  # f_favail
            0,  # f_flag
            256,  # f_namemax
        )

    def open(self, file, mode):
        # TODO: nomalize mode
        return FileIO(self.fs.address, file, mode)

    def __repr__(self):
        return "<FileSystem: {!r}>".format(self.address)
