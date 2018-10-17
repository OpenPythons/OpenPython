from ucomponent import invoke, get_methods, get_doc, get_list

__all__ = ['Component', 'get_component', 'find_components', 'components']

PRIMARY_COMPONENTS = {}


class ComponentMethod:
    def __init__(self, component, name):
        self.component = component
        self.name = name

    def __call__(self, *args):
        return invoke(self.component.address, self.name, *args)

    @property
    def __doc__(self):
        return get_doc(self.component.address, self.name)

    def __repr__(self):
        doc = self.__doc__
        if doc:
            doc = "\n" + doc.replace(" -- ", "\n")
        else:
            doc = ""

        return "ComponentMethod<{0!r}, {1!r}>{2}".format(self.component, self.name, doc)


class Component:
    def __init__(self, address, type):
        self.address = address
        self.type = type

    def __getattr__(self, name):
        return ComponentMethod(self, name)

    def __dir__(self):
        return dir(object()) + ["address", "type"] + list(get_methods(self.address))

    def __repr__(self):
        return "Component<{0}:{1}>".format(self.type, self.address)


components = get_list  # TODO: ?


def set_primary(compoent):
    PRIMARY_COMPONENTS[compoent.type] = compoent


def get_component(component_type):
    component = PRIMARY_COMPONENTS.get(component_type)
    if component:
        return component

    for address in get_list(component_type):
        component = Component(address, component_type)
        set_primary(component)
        return component

    return None


# alias
get = get_component


def find_components(component_type):
    return [Component(address, component_type) for address in get_list(component_type)]


# alias
find = find_components
