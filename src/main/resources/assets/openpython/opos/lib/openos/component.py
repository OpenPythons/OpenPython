from ucomponent import invoke, invokes, get_methods, get_doc, get_list, get_type, get_slot

import event
import sys

_list = list

__all__ = ['Component', 'is_available', 'get_primary', 'get_primary_checked', 'set_primary', 'guard']

primaries = {}


class ComponentMethod:
    __slots__ = "component", "name"

    def __init__(self, component, name):
        self.component = component
        self.name = name

    def __call__(self, *args):
        return invoke(self.component.address, self.name, *args)

    def call(self, *args):
        return self(*args)  # alias

    def _call(self, *args):
        return invokes(self.component.address, self.name, *args)

    def _guard_call(self, count, *args):
        return guard(self._call(*args), count)

    @property
    def __doc__(self):
        return doc(self.component.address, self.name)

    def __repr__(self):
        doc = self.__doc__
        if doc:
            doc = "\n" + doc.replace(" -- ", "\n")
        else:
            doc = ""

        return "ComponentMethod<{0!r}, {1!r}>{2}".format(self.component, self.name, doc)


class Component:
    __slots__ = "address",

    def __init__(self, address):
        self.address = address

    @property
    def type(self):
        return get_type(self.address)

    @property
    def slot(self):
        return get_slot(self.address)

    def __getattr__(self, name):
        return ComponentMethod(self, name)

    def __dir__(self):
        return dir(object()) + ["address", "type", "slot"] + methods(self.address)

    def __repr__(self):
        return "Component<{0}:{1}>".format(self.type, self.address)


def doc(address: str, method: str):
    return get_doc(address, method)


# noinspection PyShadowingBuiltins
def list(filter: str = None, exact: bool = True):
    if filter is None:
        return [proxy(address) for address in get_list()]
    elif exact:
        return [proxy(address) for address in get_list(filter)]
    else:
        return [proxy(address)
                for address, component_type
                in get_list().items()
                if filter in component_type]


def methods(address: str) -> _list:
    return _list(get_methods(address))


def proxy(address: str):
    return Component(address)


def type(address: str):
    return get_type(address)


def slot(address: str) -> int:
    slot = get_slot(address)
    return slot if slot is not None else -1


def fields(address: str):
    raise NotImplementedError


def get(address: str, component_type: str):
    size = len(address)

    for addr, compType in get_list(component_type):
        if addr[:size] == address:
            return proxy(addr)

    raise Exception("no such component")


def is_available(component_type: str):
    return primaries.get(component_type) is not None


def get_primary(component_type: str) -> Component:
    return primaries.get(component_type)


def get_primary_checked(component_type: str) -> Component:
    if not is_available(component_type):
        raise Exception("no primary {!r} available".format(component_type))

    return primaries[component_type]


def load_primary(component_type: str) -> Component:
    return primaries.get(component_type)


def set_primary(component_type: str, address: str):
    primaries[component_type] = proxy(address)


def guard(result, count: int):
    if isinstance(result, tuple):
        return result + (None,) * (count - len(result))
    else:
        return (result,) + (None,) * (count - 1)


@event.on("component_added")
def on_component_added(_, address, component_type):
    prev = primaries.get(component_type)
    if prev is None:
        primaries[component_type] = proxy(address)


@event.on("component_removed")
def on_component_removed(_, address, component_type):
    prev = primaries.get(component_type)
    if prev is not None and prev.address == address:
        del primaries[component_type]


def __getattr__(name: str) -> Component:
    return get_primary_checked(name)


def setup():
    for address, component_type in get_list().items():
        if not is_available(component_type):
            set_primary(component_type, address)


def import_component(component_type: str, module_name: str) -> Component:
    component = get_primary(component_type)
    if component is None:
        del sys.modules[module_name]
        raise ImportError("component {!r} is missing; import {!r} failed".format(component_type, module_name))

    return component
