from uimp import new_module

import sys

sys_module = new_module('sys')

for name in dir(sys):
    obj = getattr(sys, name)
    setattr(sys_module, name, obj)

sys.modules['sys'] = sys_module
sys.modules['usys'] = sys
