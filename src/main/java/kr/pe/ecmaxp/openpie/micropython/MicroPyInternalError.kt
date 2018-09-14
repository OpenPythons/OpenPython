package kr.pe.ecmaxp.openpie.micropython

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
object MicroPyInternalError {

    val MP_EPERM = 1 // Operation not permitted
    val MP_ENOENT = 2 // No such file or directory
    val MP_ESRCH = 3 // No such process
    val MP_EINTR = 4 // Interrupted system call
    val MP_EIO = 5 // I/O error
    val MP_ENXIO = 6 // No such device or address
    val MP_E2BIG = 7 // Argument list too long
    val MP_ENOEXEC = 8 // Exec format error
    val MP_EBADF = 9 // Bad file number
    val MP_ECHILD = 10 // No child processes
    val MP_EAGAIN = 11 // Try again
    val MP_ENOMEM = 12 // Out of memory
    val MP_EACCES = 13 // Permission denied
    val MP_EFAULT = 14 // Bad address
    val MP_ENOTBLK = 15 // Block device required
    val MP_EBUSY = 16 // Device or resource busy
    val MP_EEXIST = 17 // File exists
    val MP_EXDEV = 18 // Cross-device link
    val MP_ENODEV = 19 // No such device
    val MP_ENOTDIR = 20 // Not a directory
    val MP_EISDIR = 21 // Is a directory
    val MP_EINVAL = 22 // Invalid argument
    val MP_ENFILE = 23 // File table overflow
    val MP_EMFILE = 24 // Too many open files
    val MP_ENOTTY = 25 // Not a typewriter
    val MP_ETXTBSY = 26 // Text file busy
    val MP_EFBIG = 27 // File too large
    val MP_ENOSPC = 28 // No space left on device
    val MP_ESPIPE = 29 // Illegal seek
    val MP_EROFS = 30 // Read-only file system
    val MP_EMLINK = 31 // Too many links
    val MP_EPIPE = 32 // Broken pipe
    val MP_EDOM = 33 // Math argument out of domain of func
    val MP_ERANGE = 34 // Math args not representable
    val MP_EWOULDBLOCK = MP_EAGAIN // Operation would block
    val MP_EOPNOTSUPP = 95 // Operation not supported on transport endpoint
    val MP_EAFNOSUPPORT = 97 // Address family not supported by protocol
    val MP_EADDRINUSE = 98 // Address already in use
    val MP_ECONNABORTED = 103 // Software caused connection abort
    val MP_ECONNRESET = 104 // Connection reset by peer
    val MP_ENOBUFS = 105 // No buffer space available
    val MP_EISCONN = 106 // Transport endpoint is already connected
    val MP_ENOTCONN = 107 // Transport endpoint is not connected
    val MP_ETIMEDOUT = 110 // Connection timed out
    val MP_ECONNREFUSED = 111 // Connection refused
    val MP_EHOSTUNREACH = 113 // No route to host
    val MP_EALREADY = 114 // Operation already in progress
    val MP_EINPROGRESS = 115 // Operation now in progress

}
