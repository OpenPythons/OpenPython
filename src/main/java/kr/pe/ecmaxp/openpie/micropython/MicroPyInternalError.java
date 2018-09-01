package kr.pe.ecmaxp.openpie.micropython;

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
@SuppressWarnings({"unused", "WeakerAccess"})
public class MicroPyInternalError
{
    private MicroPyInternalError()
    {
    }

    public static final int MP_EPERM = 1; // Operation not permitted
    public static final int MP_ENOENT = 2; // No such file or directory
    public static final int MP_ESRCH = 3; // No such process
    public static final int MP_EINTR = 4; // Interrupted system call
    public static final int MP_EIO = 5; // I/O error
    public static final int MP_ENXIO = 6; // No such device or address
    public static final int MP_E2BIG = 7; // Argument list too long
    public static final int MP_ENOEXEC = 8; // Exec format error
    public static final int MP_EBADF = 9; // Bad file number
    public static final int MP_ECHILD = 10; // No child processes
    public static final int MP_EAGAIN = 11; // Try again
    public static final int MP_ENOMEM = 12; // Out of memory
    public static final int MP_EACCES = 13; // Permission denied
    public static final int MP_EFAULT = 14; // Bad address
    public static final int MP_ENOTBLK = 15; // Block device required
    public static final int MP_EBUSY = 16; // Device or resource busy
    public static final int MP_EEXIST = 17; // File exists
    public static final int MP_EXDEV = 18; // Cross-device link
    public static final int MP_ENODEV = 19; // No such device
    public static final int MP_ENOTDIR = 20; // Not a directory
    public static final int MP_EISDIR = 21; // Is a directory
    public static final int MP_EINVAL = 22; // Invalid argument
    public static final int MP_ENFILE = 23; // File table overflow
    public static final int MP_EMFILE = 24; // Too many open files
    public static final int MP_ENOTTY = 25; // Not a typewriter
    public static final int MP_ETXTBSY = 26; // Text file busy
    public static final int MP_EFBIG = 27; // File too large
    public static final int MP_ENOSPC = 28; // No space left on device
    public static final int MP_ESPIPE = 29; // Illegal seek
    public static final int MP_EROFS = 30; // Read-only file system
    public static final int MP_EMLINK = 31; // Too many links
    public static final int MP_EPIPE = 32; // Broken pipe
    public static final int MP_EDOM = 33; // Math argument out of domain of func
    public static final int MP_ERANGE = 34; // Math args not representable
    public static final int MP_EWOULDBLOCK = MP_EAGAIN; // Operation would block
    public static final int MP_EOPNOTSUPP = 95; // Operation not supported on transport endpoint
    public static final int MP_EAFNOSUPPORT = 97; // Address family not supported by protocol
    public static final int MP_EADDRINUSE = 98; // Address already in use
    public static final int MP_ECONNABORTED = 103; // Software caused connection abort
    public static final int MP_ECONNRESET = 104; // Connection reset by peer
    public static final int MP_ENOBUFS = 105; // No buffer space available
    public static final int MP_EISCONN = 106; // Transport endpoint is already connected
    public static final int MP_ENOTCONN = 107; // Transport endpoint is not connected
    public static final int MP_ETIMEDOUT = 110; // Connection timed out
    public static final int MP_ECONNREFUSED = 111; // Connection refused
    public static final int MP_EHOSTUNREACH = 113; // No route to host
    public static final int MP_EALREADY = 114; // Operation already in progress
    public static final int MP_EINPROGRESS = 115; // Operation now in progress

}
