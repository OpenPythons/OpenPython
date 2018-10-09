import uos

from filesystem import FileSystem

uos.umount('/')
uos.mount(FileSystem(__path__), '/')
