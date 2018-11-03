# https://github.com/MightyPirates/OpenComputers/blob/master-MC1.12/
# src/main/resources/assets/opencomputers/loot/openos/lib/internet.lua

import component

robot = component.import_component("robot", __name__)


def request(url: str, data=None, headers: dict = None):
    internet = component.get_primary("internet")

    post = None
    if data is None:
        pass
    elif isinstance(data, (str, bytes)):
        post = data
    elif isinstance(data, dict):
        post = "&".join("{}={}".format(key, value) for key, value in data.items())
    else:
        raise TypeError

    return internet.request(url, post, headers)


def socket(address, port):
    internet = component.get_primary("internet")
    return internet.socket(address, port)


def open(address, port):
    internet = component.get_primary("internet")
    return internet.open(address, port)
