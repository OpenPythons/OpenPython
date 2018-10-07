package kr.pe.ecmaxp.openpie.arch.consts

const val SYS_DEBUG = 1

const val SYS_CONTROL = 2
const val SYS_CONTROL_SHUTDOWN = 1
const val SYS_CONTROL_REBOOT = 2
const val SYS_CONTROL_CRASH = 3
const val SYS_CONTROL_RETURN = 4

const val SYS_SIGNAL = 3
const val SYS_SIGNAL_REQUEST = 1
const val SYS_SIGNAL_PENDING = 2

const val SYS_INVOKE = 4

const val SYS_REQUEST = 5
const val SYS_REQUEST_COMPONENTS = 1
const val SYS_REQUEST_METHODS = 2
const val SYS_REQUEST_ANNOTATIONS = 3

const val SYS_INFO = 6
const val SYS_INFO_VERSION = 1
const val SYS_INFO_RAM_SIZE = 2

const val SYS_TIMER = 7
const val SYS_TIMER_TICKS_MS = 1
const val SYS_TIMER_TICKS_US = 2

const val SYS_VFS = 8
const val SYS_VFS_OPEN = 1
const val SYS_VFS_VALID = 2
const val SYS_VFS_REPR = 3
const val SYS_VFS_CLOSE = 4
const val SYS_VFS_READ = 5
const val SYS_VFS_WRITE = 6
const val SYS_VFS_SEEK = 7
const val SYS_VFS_FLUSH = 8
