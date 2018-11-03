from micropython import const

import component
import random
from sides import *

robot = component.import_component("robot", __name__)

__all__ = [
    # General
    "name", "get_light_color", "set_light_color",

    # World
    "detect",

    # Inventory
    "slot", "compare", "drop", "place", "suck",

    # Tool
    "durability", "swing", "use",

    # Movement
    "move", "forward", "back", "up", "down", "turn",

    # Tank
    "tank", "compare_fluid", "drain", "fill",
]

# check sides.py
DOWN = const(0)
UP = const(1)
BACK = const(2)
FRONT = const(3)


class SidedMethod:
    def __init__(self, func):
        self.func = func

    def __doc__(self):
        return self.func.__doc__

    # __str__, __repr__ later

    def __call__(self, *args):
        return self.front(*args)

    def front(self, *args):
        return self.func(FRONT, *args)

    def up(self, *args):
        return self.func(UP, *args)

    def down(self, *args):
        return self.func(DOWN, *args)


class SidedContextMethod:
    def __init__(self, func, context_func):
        self.func = func
        self.context_func = context_func

    def __doc__(self):
        return self.func.__doc__

    # __str__, __repr__ later

    def __call__(self, *args):
        return self.front(*args)

    def front(self, *args):
        with self.context_func():
            return self.func(FRONT, *args)

    def up(self, *args):
        with self.context_func():
            return self.func(UP, *args)

    def down(self, *args):
        with self.context_func():
            return self.func(DOWN, *args)




class RobotResult:
    def __init__(self, result):
        self.result = result

    @property
    def success(self):
        return self.result[0]

    @property
    def reason(self):
        return self.result[1] if len(self.result) >= 2 else None

    def unwarp(self):
        if not self:
            raise Exception(self.reason)

        return True

    def __bool__(self):
        return bool(self.success)

    @classmethod
    def proxy(cls, method):
        # noinspection PyProtectedMember
        func = method._call

        return lambda *args: cls(func(*args))

    def __repr__(self):
        if self:
            return "<Success>"
        else:
            if self.reason is None:
                return "<Failure>"
            else:
                return "<Failure: {!r}>".format(self.reason)


def all_slots():
    pass


# General
def name():
    return robot.name()


def get_light_color() -> int:
    return robot.getLightColor()


def set_light_color(color: int):
    return robot.setLightColor(color)


# World
detect = SidedMethod(robot.detect)


# Inventory
class SlotContext:
    def __init__(self, slot):
        self.slot = slot
        self.selected = None

    def __enter__(self):
        self.selected = robot.select()
        robot.select(self.slot)

    def __exit__(self, exc_type, exc_val, exc_tb):
        robot.select(self.slot)


class Slot:
    @classmethod
    def selected(cls):
        return robot.select()

    @classmethod
    def size(cls):
        return robot.inventorySize()

    def __init__(self, slot):
        self.slot = slot

    def __int__(self):
        return self.slot

    def select(self):
        success = robot.select(self.slot) == self.slot
        if success:
            _SELECTED_SLOT = self.slot

        return success

    @property
    def count(self):
        return robot.count(self.slot)

    @property
    def space(self):
        return robot.space(self.slot)

    def context(self):
        return SlotContext(self.slot)

    def compare_to(self, another_slot):
        with self.context():
            return robot.compareTo(another_slot)

    def transfer(self, new_slot, count: int):
        with self.context():
            return robot.transferTo(new_slot, count)

    @property
    def compare(self):
        return SidedContextMethod(robot.compare, self.context)

    @property
    def drop(self):
        return SidedContextMethod(robot.drop, self.context)

    @property
    def place(self):
        return SidedContextMethod(robot.place, self.context)

    @property
    def suck(self):
        return SidedContextMethod(robot.suck, self.context)


slot = Slot

# Inventory + World
compare = SidedMethod(robot.compare)
drop = SidedMethod(robot.drop)
place = SidedMethod(RobotResult.proxy(robot.place))
suck = SidedMethod(robot.suck)

# Tool
durability = robot.durability
swing = SidedMethod(RobotResult.proxy(robot.swing))
use = SidedMethod(RobotResult.proxy(robot.use))


# Movement


class Move:
    def __init__(self):
        self._move = RobotResult.proxy(robot.move)

    def forward(self):
        return self._move(FRONT)

    def back(self):
        return self._move(BACK)

    def up(self):
        return self._move(UP)

    def down(self):
        return self._move(DOWN)


move = Move()
forward = move.forward
back = move.back
up = move.up
down = move.down


class Turn:
    def __init__(self):
        self._turn = RobotResult.proxy(robot.turn)

    def left(self):
        return self._turn(False)

    def right(self):
        return self._turn(True)

    def around(self):
        turn = random.random() > 0.5
        return self._turn(turn) and self._turn(turn)


turn = Turn()


# Tank
class TankContext:
    def __init__(self, tank):
        self.tank = tank
        self.selected = None

    def __enter__(self):
        self.selected = robot.selectTank()
        robot.selectTank(self.tank)

    def __exit__(self, exc_type, exc_val, exc_tb):
        robot.selectTank(self.tank)


class Tank:
    @classmethod
    def selected(cls):
        return robot.selectTank()

    def __init__(self, slot):
        self.tank = slot

    def __int__(self):
        return self.tank

    def select(self):
        return robot.selectTank(self.tank) == self.tank

    @property
    def level(self):
        return robot.tankLevel(self.tank)

    @property
    def space(self):
        return robot.tankSpace(self.tank)

    def context(self):
        return TankContext(self.tank)

    def compare_to(self, another_tank):
        with self.context():
            return robot.compareFluidTo(another_tank)

    def transfer(self, new_tank, count: int):
        with self.context():
            return robot.transferFluidTo(new_tank, count)

    @property
    def compare(self):
        return SidedContextMethod(robot.compareFluid, self.context)

    @property
    def drain(self):
        return SidedContextMethod(robot.drain, self.context)

    @property
    def fill(self):
        return SidedContextMethod(robot.fill, self.context)


tank = Tank

compare_fluid = SidedMethod(robot.compareFluid)
drain = SidedMethod(robot.drain)
fill = SidedMethod(robot.fill)
