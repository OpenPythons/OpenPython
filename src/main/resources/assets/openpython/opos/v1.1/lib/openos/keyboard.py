# https://github.com/MightyPirates/OpenComputers/blob/master-MC1.12/
# - src/main/resources/assets/opencomputers/loot/openos/lib/keyboard.lua
# - src/main/resources/assets/opencomputers/loot/openos/lib/core/full_keyboard.lua

import component
from micropython import const

keyboards_pressed_chars = {}
keyboards_pressed_codes = {}

__all__ = ["get_keyboard_address", "get_pressed_codes", "get_pressed_chars",
           "is_alt_down", "is_control", "is_control_down", "is_key_down", "is_shift_down"]

_LMENU = const(0x38)
_RMENU = const(0xB8)
_LCONTROL = const(0x1D)
_RCONTROL = const(0x9D)
_LSHIFT = const(0x2A)
_RSHIFT = const(0x36)


class KEYS:
    N1 = 0x02
    N2 = 0x03
    N3 = 0x04
    N4 = 0x05
    N5 = 0x06
    N6 = 0x07
    N7 = 0x08
    N8 = 0x09
    N9 = 0x0A
    N0 = 0x0B
    A = 0x1E
    B = 0x30
    C = 0x2E
    D = 0x20
    E = 0x12
    F = 0x21
    G = 0x22
    H = 0x23
    I = 0x17
    J = 0x24
    K = 0x25
    L = 0x26
    M = 0x32
    N = 0x31
    O = 0x18
    P = 0x19
    Q = 0x10
    R = 0x13
    S = 0x1F
    T = 0x14
    U = 0x16
    V = 0x2F
    W = 0x11
    X = 0x2D
    Y = 0x15
    Z = 0x2C

    APOSTROPHE = 0x28
    AT = 0x91
    BACK = 0x0E  # BACKSPACE
    BACKSLASH = 0x2B
    CAPITAL = 0x3A  # CAPSLOCK
    COLON = 0x92
    COMMA = 0x33
    ENTER = 0x1C
    EQUALS = 0x0D
    GRAVE = 0x29  # ACCENT GRAVE
    LBRACKET = 0x1A
    LCONTROL = 0x1D
    LMENU = 0x38  # LEFT ALT
    LSHIFT = 0x2A
    MINUS = 0x0C
    NUMLOCK = 0x45
    PAUSE = 0xC5
    PERIOD = 0x34
    RBRACKET = 0x1B
    RCONTROL = 0x9D
    RMENU = 0xB8  # RIGHT ALT
    RSHIFT = 0x36
    SCROLL = 0x46  # SCROLL LOCK
    SEMICOLON = 0x27
    SLASH = 0x35  # / ON MAIN KEYBOARD
    SPACE = 0x39
    STOP = 0x95
    TAB = 0x0F
    UNDERLINE = 0x93

    # KEYPAD (AND NUMPAD WITH NUMLOCK OFF)
    UP = 0xC8
    DOWN = 0xD0
    LEFT = 0xCB
    RIGHT = 0xCD
    HOME = 0xC7
    END = 0xCF
    PAGEUP = 0xC9
    PAGEDOWN = 0xD1
    INSERT = 0xD2
    DELETE = 0xD3

    # FUNCTION KEYS
    F1 = 0x3B
    F2 = 0x3C
    F3 = 0x3D
    F4 = 0x3E
    F5 = 0x3F
    F6 = 0x40
    F7 = 0x41
    F8 = 0x42
    F9 = 0x43
    F10 = 0x44
    F11 = 0x57
    F12 = 0x58
    F13 = 0x64
    F14 = 0x65
    F15 = 0x66
    F16 = 0x67
    F17 = 0x68
    F18 = 0x69
    F19 = 0x71

    # JAPANESE KEYBOARDS
    KANA = 0x70
    KANJI = 0x94
    CONVERT = 0x79
    NOCONVERT = 0x7B
    YEN = 0x7D
    CIRCUMFLEX = 0x90
    AX = 0x96

    # NUMPAD
    NUMPAD0 = 0x52
    NUMPAD1 = 0x4F
    NUMPAD2 = 0x50
    NUMPAD3 = 0x51
    NUMPAD4 = 0x4B
    NUMPAD5 = 0x4C
    NUMPAD6 = 0x4D
    NUMPAD7 = 0x47
    NUMPAD8 = 0x48
    NUMPAD9 = 0x49
    NUMPADMUL = 0x37
    NUMPADDIV = 0xB5
    NUMPADSUB = 0x4A
    NUMPADADD = 0x4E
    NUMPADDECIMAL = 0x53
    NUMPADCOMMA = 0xB3
    NUMPADENTER = 0x9C
    NUMPADEQUALS = 0x8D

    def __init__(self):
        index = {}
        for name in dir(self):
            value = getattr(self, name)
            if isinstance(value, int):
                if name.startswith("N") and len(name) == 2:
                    index[name[1:]] = value
                    index[name] = value
                    index[value] = name
                elif len(name) == 1:
                    index[name.upper()] = value
                    index[name.lower()] = value
                    index[value] = name
                else:
                    index[name] = value
                    index[value] = name

        self._index = index

    def __getitem__(self, item):
        return self._index[item]


KEYS = KEYS()

assert _LMENU == KEYS.LMENU
assert _RMENU == KEYS.RMENU
assert _LCONTROL == KEYS.LCONTROL
assert _RCONTROL == KEYS.RCONTROL
assert _LSHIFT == KEYS.LSHIFT
assert _RSHIFT == KEYS.RSHIFT


def get_keyboard_address(address=None):
    if address is not None:
        return address

    keyboard = component.get_primary("keyboard")
    if keyboard is not None:
        return keyboard.address

    return None


def get_pressed_codes(address=None):
    address = get_keyboard_address(address)
    return keyboards_pressed_codes.get(address) if address else None


def get_pressed_chars(address=None):
    address = get_keyboard_address(address)
    return keyboards_pressed_chars.get(address) if address else None


def is_alt_down(address=None) -> bool:
    pressed_codes = get_pressed_codes(address)
    return (pressed_codes.get(_LMENU) or pressed_codes.get(_RMENU)) \
        if pressed_codes is not None else False


def is_control(char: int) -> bool:
    return ((char < 0x20) or (0x7F <= char <= 0x9F)) if isinstance(char, int) else False


def is_control_down(address=None) -> bool:
    pressed_codes = get_pressed_codes(address)
    return pressed_codes.get(_LCONTROL) or pressed_codes.get(_RCONTROL) \
        if pressed_codes is not None else False


def is_key_down(char_or_code, address=None) -> bool:
    if isinstance(char_or_code, str):
        pressed_chars = get_pressed_chars(address)
        return bool(pressed_chars.get(char_or_code)) \
            if pressed_chars is not None else False
    else:
        pressed_codes = get_pressed_codes(address)
        return bool(pressed_codes.get(char_or_code)) \
            if pressed_codes is not None else False


def is_shift_down(address=None):
    pressed_codes = get_pressed_codes(address)
    return pressed_codes.get(_LSHIFT) or pressed_codes.get(_RSHIFT) \
        if pressed_codes is not None else False
