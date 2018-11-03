# https://github.com/MightyPirates/OpenComputers/blob/master-MC1.12/
# - src/main/resources/assets/opencomputers/loot/openos/lib/sides.lua

from micropython import const

__all__ = ["BOTTOM", "TOP", "BACK", "FRONT", "RIGHT", "LEFT"]

BOTTOM = const(0)
TOP = const(1)
BACK = const(2)
FRONT = const(3)
RIGHT = const(4)
LEFT = const(5)

# alias
NEGY = DOWN = BOTTOM
POSY = UP = TOP
NEGZ = NORTH = BACK
POSZ = SOUTH = FORWARD = FRONT
NEGX = WEST = RIGHT
POSX = EAST = LEFT

# alias for lowercase
negy = down = bottom = BOTTOM
posy = up = top = TOP
negz = north = back = BACK
posz = south = forward = front = FRONT
negx = west = right = RIGHT
posx = east = left = LEFT
