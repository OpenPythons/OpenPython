import uos

import computer
from filesystem import FileSystem

uos.umount('/')
uos.mount(FileSystem(__path__), '/')
uos.mount(FileSystem(computer.get_tmp_address()), '/tmp')
