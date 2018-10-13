try:
    import usys as sys
except ImportError:
    import sys

    sys.modules["usys"] = sys


def spawn(path):
    context = {'__name__': '__main__', '__path__': path}

    try:
        # noinspection PyUnresolvedReferences
        execfile(path, context)
    except SystemExit as e:
        return e.code

    return 0
