package junicorn;


interface HookHandler
{
    int handle(HookRecord record, Unicorn uc, long arg1, long arg2, long arg3, long arg4) throws UnicornException;
}