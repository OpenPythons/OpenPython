import os
import shell


def main():
    while True:
        command, *args = input(os.getcwd() + "> ").split()
        if command == "exit":
            break
        elif command == "cd":
            try:
                os.chdir(args[0] if args else '.')
            except OSError as e:
                print("fail", e)
        else:
            programs = os.listdir('/bin')
            filename = command + '.py'
            if filename in programs:
                progpath = os.path.join('/bin', filename)
                exitcode = shell.spawn(progpath, *args)
                print("exitcode:", exitcode)
            else:
                print("Program not found:", filename)


if __name__ == '__main__':
    main()
