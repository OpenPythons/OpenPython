from urandom import *

from time import ticks_us as _ticks_us

seed(_ticks_us())
del _ticks_us


# micropython-lib #

def shuffle(seq):
    l = len(seq)
    for i in range(l):
        j = randrange(l)
        seq[i], seq[j] = seq[j], seq[i]
