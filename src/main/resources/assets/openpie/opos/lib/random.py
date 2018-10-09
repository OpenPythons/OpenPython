from urandom import *

from time import ticks_us as _ticks_us

seed(_ticks_us())
del _ticks_us
