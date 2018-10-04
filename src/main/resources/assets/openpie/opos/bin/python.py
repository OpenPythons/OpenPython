from machine import repl_input, repl_compile, repl_call


def main():
    # noinspection PyUnresolvedReferences
    context = {"__name__": "<shell>"}
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
        except Exception as e:
            print(type(e).__name__, e)
            continue

        try:
            repl_call(func, context)
        except BaseException as e:
            print(type(e).__name__, e)


if __name__ == '__main__':
    main()
