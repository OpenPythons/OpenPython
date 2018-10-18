import sys

from ucode import MICROPY_GIT_TAG, MICROPY_BUILD_DATE, MICROPY_HW_BOARD_NAME, MICROPY_HW_MCU_NAME
from ucode import repl_input, repl_compile, repl_call


def main():
    context = {"__name__": "<shell>"}

    print("MicroPython",
          MICROPY_GIT_TAG,
          "on", MICROPY_BUILD_DATE + ";",
          MICROPY_HW_BOARD_NAME,
          "with", MICROPY_HW_MCU_NAME)

    try:
        # noinspection PyStatementEffect
        help
    except NameError:
        pass
    else:
        print("Type \"help()\" for more information.")

    while True:
        try:
            code = repl_input()
        except Exception as e:
            print(type(e).__name__, e)
            continue

        if code == 'exit':
            break

        try:
            func = repl_compile(code, context)
        except BaseException as e:
            sys.print_exception(e)
            continue

        try:
            repl_call(func, context)
        except SystemExit as e:
            return e.args[0] if e.args else 0
        except BaseException as e:
            sys.print_exception(e)


if __name__ == '__main__':
    main()
