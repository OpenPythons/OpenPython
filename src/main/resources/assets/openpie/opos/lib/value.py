import uvalue


class Value:
    pass


def value_hook(raw_object):
    return raw_object


def setup():
    uvalue.hook_value(value_hook)
