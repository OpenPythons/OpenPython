package kr.pe.ecmaxp.openpie.arch.micropython

/*
 * This file is part of the MicroPython project, http://micropython.org/
 *
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 Damien P. George
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
const val MP_OK = 0 // ?
const val MP_EPERM = 1 // Operation not permitted
const val MP_ENOENT = 2 // No such file or directory
const val MP_ESRCH = 3 // No such process
const val MP_EINTR = 4 // Interrupted system call
const val MP_EIO = 5 // I/O error
const val MP_ENXIO = 6 // No such device or address
const val MP_E2BIG = 7 // Argument list too long
const val MP_ENOEXEC = 8 // Exec format error
const val MP_EBADF = 9 // Bad file number
const val MP_ECHILD = 10 // No child processes
const val MP_EAGAIN = 11 // Try again
const val MP_ENOMEM = 12 // Out of memory
const val MP_EACCES = 13 // Permission denied
const val MP_EFAULT = 14 // Bad address
const val MP_ENOTBLK = 15 // Block device required
const val MP_EBUSY = 16 // Device or resource busy
const val MP_EEXIST = 17 // File exists
const val MP_EXDEV = 18 // Cross-device link
const val MP_ENODEV = 19 // No such device
const val MP_ENOTDIR = 20 // Not a directory
const val MP_EISDIR = 21 // Is a directory
const val MP_EINVAL = 22 // Invalid argument
const val MP_ENFILE = 23 // File table overflow
const val MP_EMFILE = 24 // Too many open files
const val MP_ENOTTY = 25 // Not a typewriter
const val MP_ETXTBSY = 26 // Text file busy
const val MP_EFBIG = 27 // File too large
const val MP_ENOSPC = 28 // No space left on device
const val MP_ESPIPE = 29 // Illegal seek
const val MP_EROFS = 30 // Read-only file system
const val MP_EMLINK = 31 // Too many links
const val MP_EPIPE = 32 // Broken pipe
const val MP_EDOM = 33 // Math argument out of domain of func
const val MP_ERANGE = 34 // Math args not representable
const val MP_EWOULDBLOCK = MP_EAGAIN // Operation would block
const val MP_EOPNOTSUPP = 95 // Operation not supported on transport endpoint
const val MP_EAFNOSUPPORT = 97 // Address family not supported by protocol
const val MP_EADDRINUSE = 98 // Address already in use
const val MP_ECONNABORTED = 103 // Software caused connection abort
const val MP_ECONNRESET = 104 // Connection reset by peer
const val MP_ENOBUFS = 105 // No buffer space available
const val MP_EISCONN = 106 // Transport endpoint is already connected
const val MP_ENOTCONN = 107 // Transport endpoint is not connected
const val MP_ETIMEDOUT = 110 // Connection timed out
const val MP_ECONNREFUSED = 111 // Connection refused
const val MP_EHOSTUNREACH = 113 // No route to host
const val MP_EALREADY = 114 // Operation already in progress
const val MP_EINPROGRESS = 115 // Operation now in progress
