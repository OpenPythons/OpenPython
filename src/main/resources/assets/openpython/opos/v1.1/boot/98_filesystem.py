import uos

import computer
from filesystem import FileSystem

uos.umount('/')
uos.mount(FileSystem(__path__, root=True), '/')
uos.mount(FileSystem(computer.tmp_address()), '/tmp')
