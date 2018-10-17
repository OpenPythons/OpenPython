import uvalue
from uvalue import *

__all__ = ["Value", "setup"]


class ValueMethod:
    def __init__(self, value, name):
        self.value = value
        self.name = name

    def __call__(self, *args):
        return invoke(self.value._uvalue, self.name, *args)

    @property
    def __doc__(self):
        return doc(self.value._uvalue, self.name)

    def __repr__(self):
        doc = self.__doc__
        if doc:
            doc = "\n" + doc.replace(" -- ", "\n")
        else:
            doc = ""

        return "ValueMethod<{0!r}, {1!r}>{2}".format(self.value._uvalue, self.name, doc)


class ValueCloseMethod(ValueMethod):
    def __call__(self, *args):
        result = ValueMethod.__call__(self, *args)
        self.value.dispose()
        return result


class Value:
    def __init__(self, uvalue):
        self._uvalue = uvalue

    def __dir__(self):
        return dir(object()) + ["__dir__", "__getattr__", "__doc__", "__str__", "__repr__", "__bool__", "__del__",
                                "dispose", "_uvalue"] + list(methods(self._uvalue))

    def __getattr__(self, name):
        return ValueMethod(self, name) if name != "close" else ValueCloseMethod(self, "close")

    def __str__(self):
        return doc(self._uvalue) if self else repr(self)

    def __repr__(self):
        return "Value<{0}>".format(doc(self._uvalue) if self else None)

    def __bool__(self):
        return self._uvalue.value is not None

    def __del__(self):
        self._uvalue.dispose()

    def dispose(self):
        self._uvalue.dispose()


def value_hook(raw_object):
    return Value(raw_object)


def setup():
    uvalue.hook_value(value_hook)
