#!micropython


def main():
    globals().pop('main')
    from ucomponent import invoke, components
    from ucomputer import crash, get_computer_address

    def component(t):
        seq = components(t)
        return seq[0] if seq else None

    def check_bootable(filesystems, address):
        return address in filesystems and invoke(address, 'exists', '/init.py')

    eeprom = __path__
    filesystems = components("filesystem")

    address = invoke(eeprom, 'getData').decode()
    if not check_bootable(filesystems, address):
        invoke(__path__, 'setData', b'')
        for address in filesystems:
            if check_bootable(filesystems, address):
                invoke(eeprom, 'setData', address.encode())
                break
        else:
            crash("no bootable medium found")

    computer = get_computer_address()
    invoke(computer, 'beep', 1000, 0.2)

    gpu = component("gpu")
    monitor = component("monitor")
    if gpu and monitor:
        invoke(gpu, "bind", monitor)

    def load(address):
        handle = invoke(address, 'open', '/init.py', 'r')
        buffer = []

        try:
            while True:
                buf = invoke(address, 'read', handle, 4096)
                if not buf: break
                buffer.append(buf)
        finally:
            invoke(address, 'close', handle)
            handle.dispose()

        content = b"".join(buffer)
        return content.decode()

    content = load(address)
    context = {'__name__': '__main__', '__path__': address}
    func = compile(content, '/init.py', "exec")
    exec(func, context)


if __name__ == '__main__':
    main()
