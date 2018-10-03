def spawn(path):
    context = {'__name__': '__main__'}

    try:
        # noinspection PyUnresolvedReferences
        execfile(path, context)
    except SystemExit as e:
        return e.code

    return 0
