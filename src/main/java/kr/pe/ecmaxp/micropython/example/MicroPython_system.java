package kr.pe.ecmaxp.micropython.example;

import kotlin.Pair;
import kr.pe.ecmaxp.thumbjk.Callback;
import kr.pe.ecmaxp.thumbjk.KotlinCPU;
import kr.pe.ecmaxp.thumbjk.InterruptHandler;
import kr.pe.ecmaxp.thumbsk.Memory;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

import static kr.pe.ecmaxp.thumbsk.helper.RegisterIndex.*;

abstract public class MicroPython_system extends MicroPython_link
{
    public MicroPython_system(@NotNull Memory memory)
    {
        super(memory);
    }

    // function: Function(address=134341252, size=276, name='__aeabi_uidiv', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(_udivsi3.o)', has_indirect=False)
    protected void __aeabi_uidiv(int offset) throws Exception
    {
        while (true)
        {
            pc = __aeabi_uidiv + offset;
            switch (offset)
            {
                case 0:
                    r2 = movs(r2, 0);
                    r3 = lsrs(r0, 1);
                    cmp(r3, r1);
                    if (blo()) {
                        offset = 242;
                        continue;
                    }
                case 8:
                    r3 = lsrs(r0, 4);
                    cmp(r3, r1);
                    if (blo()) {
                        offset = 206;
                        continue;
                    }
                case 14:
                    r3 = lsrs(r0, 8);
                    cmp(r3, r1);
                    if (blo()) {
                        offset = 158;
                        continue;
                    }
                case 20:
                    r3 = lsrs(r0, 12);
                    cmp(r3, r1);
                    if (blo()) {
                        offset = 108;
                        continue;
                    }
                case 26:
                    r3 = lsrs(r0, 16);
                    cmp(r3, r1);
                    if (blo()) {
                        offset = 60;
                        continue;
                    }
                case 32:
                    r2 = movs(r2, 255);
                    r1 = lsls(r1, 8);
                    r2 = rev(r2);
                    r3 = lsrs(r0, 16);
                    cmp(r3, r1);
                    if (blo()) {
                        offset = 50;
                        continue;
                    }
                case 44:
                    r2 = asrs(r2, 8);
                    r1 = lsls(r1, 8);
                    if (beq()) {
                        offset = 254;
                        continue;
                    }
                case 50:
                    r3 = lsrs(r0, 12);
                    cmp(r3, r1);
                    if (blo()) {
                        offset = 108;
                        continue;
                    }
                case 56:
                    step();
                    offset = 60;
                    continue;
                case 58:
                    r1 = lsrs(r1, 8);
                case 60:
                    r3 = lsrs(r0, 15);
                    cmp(r3, r1);
                    if (blo()) {
                        offset = 70;
                        continue;
                    }
                case 66:
                    r3 = lsls(r1, 15);
                    r0 = subs(r0, r3);
                case 70:
                    r2 = adcs(r2, r2);
                    r3 = lsrs(r0, 14);
                    cmp(r3, r1);
                    if (blo()) {
                        offset = 82;
                        continue;
                    }
                case 78:
                    r3 = lsls(r1, 14);
                    r0 = subs(r0, r3);
                case 82:
                    r2 = adcs(r2, r2);
                    r3 = lsrs(r0, 13);
                    cmp(r3, r1);
                    if (blo()) {
                        offset = 94;
                        continue;
                    }
                case 90:
                    r3 = lsls(r1, 13);
                    r0 = subs(r0, r3);
                case 94:
                    r2 = adcs(r2, r2);
                    r3 = lsrs(r0, 12);
                    cmp(r3, r1);
                    if (blo()) {
                        offset = 106;
                        continue;
                    }
                case 102:
                    r3 = lsls(r1, 12);
                    r0 = subs(r0, r3);
                case 106:
                    r2 = adcs(r2, r2);
                case 108:
                    r3 = lsrs(r0, 11);
                    cmp(r3, r1);
                    if (blo()) {
                        offset = 118;
                        continue;
                    }
                case 114:
                    r3 = lsls(r1, 11);
                    r0 = subs(r0, r3);
                case 118:
                    r2 = adcs(r2, r2);
                    r3 = lsrs(r0, 10);
                    cmp(r3, r1);
                    if (blo()) {
                        offset = 130;
                        continue;
                    }
                case 126:
                    r3 = lsls(r1, 10);
                    r0 = subs(r0, r3);
                case 130:
                    r2 = adcs(r2, r2);
                    r3 = lsrs(r0, 9);
                    cmp(r3, r1);
                    if (blo()) {
                        offset = 142;
                        continue;
                    }
                case 138:
                    r3 = lsls(r1, 9);
                    r0 = subs(r0, r3);
                case 142:
                    r2 = adcs(r2, r2);
                    r3 = lsrs(r0, 8);
                    cmp(r3, r1);
                    if (blo()) {
                        offset = 154;
                        continue;
                    }
                case 150:
                    r3 = lsls(r1, 8);
                    r0 = subs(r0, r3);
                case 154:
                    r2 = adcs(r2, r2);
                    if (bhs()) {
                        offset = 58;
                        continue;
                    }
                case 158:
                    r3 = lsrs(r0, 7);
                    cmp(r3, r1);
                    if (blo()) {
                        offset = 168;
                        continue;
                    }
                case 164:
                    r3 = lsls(r1, 7);
                    r0 = subs(r0, r3);
                case 168:
                    r2 = adcs(r2, r2);
                    r3 = lsrs(r0, 6);
                    cmp(r3, r1);
                    if (blo()) {
                        offset = 180;
                        continue;
                    }
                case 176:
                    r3 = lsls(r1, 6);
                    r0 = subs(r0, r3);
                case 180:
                    r2 = adcs(r2, r2);
                    r3 = lsrs(r0, 5);
                    cmp(r3, r1);
                    if (blo()) {
                        offset = 192;
                        continue;
                    }
                case 188:
                    r3 = lsls(r1, 5);
                    r0 = subs(r0, r3);
                case 192:
                    r2 = adcs(r2, r2);
                    r3 = lsrs(r0, 4);
                    cmp(r3, r1);
                    if (blo()) {
                        offset = 204;
                        continue;
                    }
                case 200:
                    r3 = lsls(r1, 4);
                    r0 = subs(r0, r3);
                case 204:
                    r2 = adcs(r2, r2);
                case 206:
                    r3 = lsrs(r0, 3);
                    cmp(r3, r1);
                    if (blo()) {
                        offset = 216;
                        continue;
                    }
                case 212:
                    r3 = lsls(r1, 3);
                    r0 = subs(r0, r3);
                case 216:
                    r2 = adcs(r2, r2);
                    r3 = lsrs(r0, 2);
                    cmp(r3, r1);
                    if (blo()) {
                        offset = 228;
                        continue;
                    }
                case 224:
                    r3 = lsls(r1, 2);
                    r0 = subs(r0, r3);
                case 228:
                    r2 = adcs(r2, r2);
                    r3 = lsrs(r0, 1);
                    cmp(r3, r1);
                    if (blo()) {
                        offset = 240;
                        continue;
                    }
                case 236:
                    r3 = lsls(r1, 1);
                    r0 = subs(r0, r3);
                case 240:
                    r2 = adcs(r2, r2);
                case 242:
                    r1 = subs(r0, r1);
                    if (bhs()) {
                        offset = 248;
                        continue;
                    }
                case 246:
                    r1 = mov(r0);
                case 248:
                    r2 = adcs(r2, r2);
                    r0 = mov(r2);
                    bx(lr);
                    return;
                case 254:
                    step();
                    offset = 256;
                    continue;
                case 256:
                    push(true, r0);
                    r0 = movs(r0, 0);
                    bl(this::__aeabi_idiv0, __aeabi_uidiv + 264 | 1, 264);
                    return;
                case 264:
                    pop(true, R1);
                    return;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134341520, size=8, name='__aeabi_uidivmod', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(_udivsi3.o)', has_indirect=False)
    protected void __aeabi_uidivmod(int offset) throws Exception
    {
        while (true)
        {
            pc = __aeabi_uidivmod + offset;
            switch (offset)
            {
                case 0:
                    cmp(r1, 0);
                    if (beq(256)) return;
                case 4:
                    b(this::__aeabi_uidiv);
                    return;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134341528, size=468, name='__divsi3', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(_divsi3.o)', has_indirect=False)
    protected void __divsi3(int offset) throws Exception
    {
        while (true)
        {
            pc = __divsi3 + offset;
            switch (offset)
            {
                case 0:
                    r3 = mov(r0);
                    r3 = orrs(r3, r1);
                    if (bmi()) {
                        offset = 262;
                        continue;
                    }
                case 6:
                    r2 = movs(r2, 0);
                    r3 = lsrs(r0, 1);
                    cmp(r3, r1);
                    if (blo()) {
                        offset = 248;
                        continue;
                    }
                case 14:
                    r3 = lsrs(r0, 4);
                    cmp(r3, r1);
                    if (blo()) {
                        offset = 212;
                        continue;
                    }
                case 20:
                    r3 = lsrs(r0, 8);
                    cmp(r3, r1);
                    if (blo()) {
                        offset = 164;
                        continue;
                    }
                case 26:
                    r3 = lsrs(r0, 12);
                    cmp(r3, r1);
                    if (blo()) {
                        offset = 114;
                        continue;
                    }
                case 32:
                    r3 = lsrs(r0, 16);
                    cmp(r3, r1);
                    if (blo()) {
                        offset = 66;
                        continue;
                    }
                case 38:
                    r2 = movs(r2, 255);
                    r1 = lsls(r1, 8);
                    r2 = rev(r2);
                    r3 = lsrs(r0, 16);
                    cmp(r3, r1);
                    if (blo()) {
                        offset = 56;
                        continue;
                    }
                case 50:
                    r2 = asrs(r2, 8);
                    r1 = lsls(r1, 8);
                    if (beq()) {
                        offset = 260;
                        continue;
                    }
                case 56:
                    r3 = lsrs(r0, 12);
                    cmp(r3, r1);
                    if (blo()) {
                        offset = 114;
                        continue;
                    }
                case 62:
                    step();
                    offset = 66;
                    continue;
                case 64:
                    r1 = lsrs(r1, 8);
                case 66:
                    r3 = lsrs(r0, 15);
                    cmp(r3, r1);
                    if (blo()) {
                        offset = 76;
                        continue;
                    }
                case 72:
                    r3 = lsls(r1, 15);
                    r0 = subs(r0, r3);
                case 76:
                    r2 = adcs(r2, r2);
                    r3 = lsrs(r0, 14);
                    cmp(r3, r1);
                    if (blo()) {
                        offset = 88;
                        continue;
                    }
                case 84:
                    r3 = lsls(r1, 14);
                    r0 = subs(r0, r3);
                case 88:
                    r2 = adcs(r2, r2);
                    r3 = lsrs(r0, 13);
                    cmp(r3, r1);
                    if (blo()) {
                        offset = 100;
                        continue;
                    }
                case 96:
                    r3 = lsls(r1, 13);
                    r0 = subs(r0, r3);
                case 100:
                    r2 = adcs(r2, r2);
                    r3 = lsrs(r0, 12);
                    cmp(r3, r1);
                    if (blo()) {
                        offset = 112;
                        continue;
                    }
                case 108:
                    r3 = lsls(r1, 12);
                    r0 = subs(r0, r3);
                case 112:
                    r2 = adcs(r2, r2);
                case 114:
                    r3 = lsrs(r0, 11);
                    cmp(r3, r1);
                    if (blo()) {
                        offset = 124;
                        continue;
                    }
                case 120:
                    r3 = lsls(r1, 11);
                    r0 = subs(r0, r3);
                case 124:
                    r2 = adcs(r2, r2);
                    r3 = lsrs(r0, 10);
                    cmp(r3, r1);
                    if (blo()) {
                        offset = 136;
                        continue;
                    }
                case 132:
                    r3 = lsls(r1, 10);
                    r0 = subs(r0, r3);
                case 136:
                    r2 = adcs(r2, r2);
                    r3 = lsrs(r0, 9);
                    cmp(r3, r1);
                    if (blo()) {
                        offset = 148;
                        continue;
                    }
                case 144:
                    r3 = lsls(r1, 9);
                    r0 = subs(r0, r3);
                case 148:
                    r2 = adcs(r2, r2);
                    r3 = lsrs(r0, 8);
                    cmp(r3, r1);
                    if (blo()) {
                        offset = 160;
                        continue;
                    }
                case 156:
                    r3 = lsls(r1, 8);
                    r0 = subs(r0, r3);
                case 160:
                    r2 = adcs(r2, r2);
                    if (bhs()) {
                        offset = 64;
                        continue;
                    }
                case 164:
                    r3 = lsrs(r0, 7);
                    cmp(r3, r1);
                    if (blo()) {
                        offset = 174;
                        continue;
                    }
                case 170:
                    r3 = lsls(r1, 7);
                    r0 = subs(r0, r3);
                case 174:
                    r2 = adcs(r2, r2);
                    r3 = lsrs(r0, 6);
                    cmp(r3, r1);
                    if (blo()) {
                        offset = 186;
                        continue;
                    }
                case 182:
                    r3 = lsls(r1, 6);
                    r0 = subs(r0, r3);
                case 186:
                    r2 = adcs(r2, r2);
                    r3 = lsrs(r0, 5);
                    cmp(r3, r1);
                    if (blo()) {
                        offset = 198;
                        continue;
                    }
                case 194:
                    r3 = lsls(r1, 5);
                    r0 = subs(r0, r3);
                case 198:
                    r2 = adcs(r2, r2);
                    r3 = lsrs(r0, 4);
                    cmp(r3, r1);
                    if (blo()) {
                        offset = 210;
                        continue;
                    }
                case 206:
                    r3 = lsls(r1, 4);
                    r0 = subs(r0, r3);
                case 210:
                    r2 = adcs(r2, r2);
                case 212:
                    r3 = lsrs(r0, 3);
                    cmp(r3, r1);
                    if (blo()) {
                        offset = 222;
                        continue;
                    }
                case 218:
                    r3 = lsls(r1, 3);
                    r0 = subs(r0, r3);
                case 222:
                    r2 = adcs(r2, r2);
                    r3 = lsrs(r0, 2);
                    cmp(r3, r1);
                    if (blo()) {
                        offset = 234;
                        continue;
                    }
                case 230:
                    r3 = lsls(r1, 2);
                    r0 = subs(r0, r3);
                case 234:
                    r2 = adcs(r2, r2);
                    r3 = lsrs(r0, 1);
                    cmp(r3, r1);
                    if (blo()) {
                        offset = 246;
                        continue;
                    }
                case 242:
                    r3 = lsls(r1, 1);
                    r0 = subs(r0, r3);
                case 246:
                    r2 = adcs(r2, r2);
                case 248:
                    r1 = subs(r0, r1);
                    if (bhs()) {
                        offset = 254;
                        continue;
                    }
                case 252:
                    r1 = mov(r0);
                case 254:
                    r2 = adcs(r2, r2);
                    r0 = mov(r2);
                    bx(lr);
                    return;
                case 260:
                    step();
                    offset = 450;
                    continue;
                case 262:
                    r2 = lsrs(r1, 31);
                    if (beq()) {
                        offset = 268;
                        continue;
                    }
                case 266:
                    r1 = rsbs(r1);
                case 268:
                    r3 = asrs(r0, 32);
                    if (blo()) {
                        offset = 274;
                        continue;
                    }
                case 272:
                    r0 = rsbs(r0);
                case 274:
                    r3 = eors(r3, r2);
                    r2 = movs(r2, 0);
                    r12 = mov(r3);
                    r3 = lsrs(r0, 4);
                    cmp(r3, r1);
                    if (blo()) {
                        offset = 378;
                        continue;
                    }
                case 286:
                    r3 = lsrs(r0, 8);
                    cmp(r3, r1);
                    if (blo()) {
                        offset = 330;
                        continue;
                    }
                case 292:
                    r2 = movs(r2, 252);
                    r1 = lsls(r1, 6);
                    r2 = rev(r2);
                    r3 = lsrs(r0, 8);
                    cmp(r3, r1);
                    if (blo()) {
                        offset = 330;
                        continue;
                    }
                case 304:
                    r1 = lsls(r1, 6);
                    r2 = asrs(r2, 6);
                    cmp(r3, r1);
                    if (blo()) {
                        offset = 330;
                        continue;
                    }
                case 312:
                    r1 = lsls(r1, 6);
                    r2 = asrs(r2, 6);
                    cmp(r3, r1);
                    if (blo()) {
                        offset = 330;
                        continue;
                    }
                case 320:
                    r1 = lsls(r1, 6);
                    if (beq()) {
                        offset = 442;
                        continue;
                    }
                case 324:
                    r2 = asrs(r2, 6);
                    step();
                    offset = 330;
                    continue;
                case 328:
                    r1 = lsrs(r1, 6);
                case 330:
                    r3 = lsrs(r0, 7);
                    cmp(r3, r1);
                    if (blo()) {
                        offset = 340;
                        continue;
                    }
                case 336:
                    r3 = lsls(r1, 7);
                    r0 = subs(r0, r3);
                case 340:
                    r2 = adcs(r2, r2);
                    r3 = lsrs(r0, 6);
                    cmp(r3, r1);
                    if (blo()) {
                        offset = 352;
                        continue;
                    }
                case 348:
                    r3 = lsls(r1, 6);
                    r0 = subs(r0, r3);
                case 352:
                    r2 = adcs(r2, r2);
                    r3 = lsrs(r0, 5);
                    cmp(r3, r1);
                    if (blo()) {
                        offset = 364;
                        continue;
                    }
                case 360:
                    r3 = lsls(r1, 5);
                    r0 = subs(r0, r3);
                case 364:
                    r2 = adcs(r2, r2);
                    r3 = lsrs(r0, 4);
                    cmp(r3, r1);
                    if (blo()) {
                        offset = 376;
                        continue;
                    }
                case 372:
                    r3 = lsls(r1, 4);
                    r0 = subs(r0, r3);
                case 376:
                    r2 = adcs(r2, r2);
                case 378:
                    r3 = lsrs(r0, 3);
                    cmp(r3, r1);
                    if (blo()) {
                        offset = 388;
                        continue;
                    }
                case 384:
                    r3 = lsls(r1, 3);
                    r0 = subs(r0, r3);
                case 388:
                    r2 = adcs(r2, r2);
                    r3 = lsrs(r0, 2);
                    cmp(r3, r1);
                    if (blo()) {
                        offset = 400;
                        continue;
                    }
                case 396:
                    r3 = lsls(r1, 2);
                    r0 = subs(r0, r3);
                case 400:
                    r2 = adcs(r2, r2);
                    if (bhs()) {
                        offset = 328;
                        continue;
                    }
                case 404:
                    r3 = lsrs(r0, 1);
                    cmp(r3, r1);
                    if (blo()) {
                        offset = 414;
                        continue;
                    }
                case 410:
                    r3 = lsls(r1, 1);
                    r0 = subs(r0, r3);
                case 414:
                    r2 = adcs(r2, r2);
                    r1 = subs(r0, r1);
                    if (bhs()) {
                        offset = 422;
                        continue;
                    }
                case 420:
                    r1 = mov(r0);
                case 422:
                    r3 = mov(r12);
                    r2 = adcs(r2, r2);
                    r3 = asrs(r3, 1);
                    r0 = mov(r2);
                    if (blo()) {
                        offset = 436;
                        continue;
                    }
                case 432:
                    r0 = rsbs(r0);
                    cmp(r3, 0);
                case 436:
                    if (bpl()) {
                        offset = 440;
                        continue;
                    }
                case 438:
                    r1 = rsbs(r1);
                case 440:
                    bx(lr);
                    return;
                case 442:
                    r3 = mov(r12);
                    r3 = asrs(r3, 1);
                    if (blo()) {
                        offset = 450;
                        continue;
                    }
                case 448:
                    r0 = rsbs(r0);
                case 450:
                    push(true, r0);
                    r0 = movs(r0, 0);
                    bl(this::__aeabi_idiv0, __divsi3 + 458 | 1, 458);
                    return;
                case 458:
                    pop(true, R1);
                    return;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134341988, size=8, name='__aeabi_idivmod', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(_divsi3.o)', has_indirect=False)
    protected void __aeabi_idivmod(int offset) throws Exception
    {
        while (true)
        {
            pc = __aeabi_idivmod + offset;
            switch (offset)
            {
                case 0:
                    cmp(r1, 0);
                    if (beq(450)) return;
                case 4:
                    b(this::__divsi3);
                    return;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134341996, size=4, name='__aeabi_idiv0', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(_dvmd_tls.o)', has_indirect=False)
    protected void __aeabi_idiv0(int offset) throws Exception
    {
        assert offset == 0;
        pc = __aeabi_idiv0 + offset;
        bx(lr);
    }

    // function: Function(address=134342000, size=116, name='__aeabi_cfrcmple', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(_arm_cmpsf2.o)', has_indirect=False)
    protected void __aeabi_cfrcmple(int offset) throws Exception
    {
        assert offset == 0;
        pc = __aeabi_cfrcmple + offset;
        r12 = mov(r0);
        r0 = adds(r1, 0);
        r1 = mov(r12);
        b(this::__aeabi_cfcmpeq);
    }

    // function: Function(address=134342008, size=16, name='__aeabi_cfcmpeq', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(_arm_cmpsf2.o)', has_indirect=False)
    protected void __aeabi_cfcmpeq(int offset) throws Exception
    {
        while (true)
        {
            pc = __aeabi_cfcmpeq + offset;
            switch (offset)
            {
                case 0:
                    push(true, r0, r1, r2, r3, r4);
                    bl(this::__ltsf2, __aeabi_cfcmpeq + 6 | 1, 6);
                    return;
                case 6:
                    cmp(r0, 0);
                    if (bmi()) {
                        offset = 14;
                        continue;
                    }
                case 10:
                    r1 = movs(r1, 0);
                    cmn(r0, r1);
                case 14:
                    pop(true, R0, R1, R2, R3, R4);
                    return;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134342024, size=12, name='__aeabi_fcmpeq', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(_arm_cmpsf2.o)', has_indirect=False)
    protected void __aeabi_fcmpeq(int offset) throws Exception
    {
        while (true)
        {
            pc = __aeabi_fcmpeq + offset;
            switch (offset)
            {
                case 0:
                    push(true, r4);
                    bl(this::__eqsf2, __aeabi_fcmpeq + 6 | 1, 6);
                    return;
                case 6:
                    r0 = rsbs(r0);
                    r0 = adds(r0, 1);
                    pop(true, R4);
                    return;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134342036, size=20, name='__aeabi_fcmplt', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(_arm_cmpsf2.o)', has_indirect=False)
    protected void __aeabi_fcmplt(int offset) throws Exception
    {
        while (true)
        {
            pc = __aeabi_fcmplt + offset;
            switch (offset)
            {
                case 0:
                    push(true, r4);
                    bl(this::__ltsf2, __aeabi_fcmplt + 6 | 1, 6);
                    return;
                case 6:
                    cmp(r0, 0);
                    if (blt()) {
                        offset = 14;
                        continue;
                    }
                case 10:
                    r0 = movs(r0, 0);
                    pop(true, R4);
                    return;
                case 14:
                    r0 = movs(r0, 1);
                    pop(true, R4);
                    return;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134342056, size=20, name='__aeabi_fcmple', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(_arm_cmpsf2.o)', has_indirect=False)
    protected void __aeabi_fcmple(int offset) throws Exception
    {
        while (true)
        {
            pc = __aeabi_fcmple + offset;
            switch (offset)
            {
                case 0:
                    push(true, r4);
                    bl(this::__ltsf2, __aeabi_fcmple + 6 | 1, 6);
                    return;
                case 6:
                    cmp(r0, 0);
                    if (ble()) {
                        offset = 14;
                        continue;
                    }
                case 10:
                    r0 = movs(r0, 0);
                    pop(true, R4);
                    return;
                case 14:
                    r0 = movs(r0, 1);
                    pop(true, R4);
                    return;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134342076, size=20, name='__aeabi_fcmpgt', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(_arm_cmpsf2.o)', has_indirect=False)
    protected void __aeabi_fcmpgt(int offset) throws Exception
    {
        while (true)
        {
            pc = __aeabi_fcmpgt + offset;
            switch (offset)
            {
                case 0:
                    push(true, r4);
                    bl(this::__gesf2, __aeabi_fcmpgt + 6 | 1, 6);
                    return;
                case 6:
                    cmp(r0, 0);
                    if (bgt()) {
                        offset = 14;
                        continue;
                    }
                case 10:
                    r0 = movs(r0, 0);
                    pop(true, R4);
                    return;
                case 14:
                    r0 = movs(r0, 1);
                    pop(true, R4);
                    return;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134342096, size=20, name='__aeabi_fcmpge', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(_arm_cmpsf2.o)', has_indirect=False)
    protected void __aeabi_fcmpge(int offset) throws Exception
    {
        while (true)
        {
            pc = __aeabi_fcmpge + offset;
            switch (offset)
            {
                case 0:
                    push(true, r4);
                    bl(this::__gesf2, __aeabi_fcmpge + 6 | 1, 6);
                    return;
                case 6:
                    cmp(r0, 0);
                    if (bge()) {
                        offset = 14;
                        continue;
                    }
                case 10:
                    r0 = movs(r0, 0);
                    pop(true, R4);
                    return;
                case 14:
                    r0 = movs(r0, 1);
                    pop(true, R4);
                    return;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134342116, size=48, name='__fixunssfsi', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(_fixunssfsi.o)', has_indirect=False)
    protected void __fixunssfsi(int offset) throws Exception
    {
        while (true)
        {
            pc = __fixunssfsi + offset;
            switch (offset)
            {
                case 0:
                    r1 = movs(r1, 158);
                    push(true, r4);
                    r1 = lsls(r1, 23);
                    r4 = adds(r0, 0);
                    bl(this::__aeabi_fcmpge, __fixunssfsi + 12 | 1, 12);
                    return;
                case 12:
                    cmp(r0, 0);
                    if (bne()) {
                        offset = 24;
                        continue;
                    }
                case 16:
                    r0 = adds(r4, 0);
                    bl(this::__aeabi_f2iz, __fixunssfsi + 22 | 1, 22);
                    return;
                case 22:
                    pop(true, R4);
                    return;
                case 24:
                    r1 = movs(r1, 158);
                    r0 = adds(r4, 0);
                    r1 = lsls(r1, 23);
                    bl(this::__aeabi_fsub, __fixunssfsi + 34 | 1, 34);
                    return;
                case 34:
                    bl(this::__aeabi_f2iz, __fixunssfsi + 38 | 1, 38);
                    return;
                case 38:
                    r3 = movs(r3, 128);
                    r3 = lsls(r3, 24);
                    r12 = mov(r3);
                    r0 = add(r0, r12);
                    step();
                    offset = 22;
                    continue;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134342164, size=820, name='__aeabi_fadd', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(addsf3.o)', has_indirect=False)
    protected void __aeabi_fadd(int offset) throws Exception
    {
        while (true)
        {
            pc = __aeabi_fadd + offset;
            switch (offset)
            {
                case 0:
                    push(true, r3, r4, r5, r6, r7);
                    r7 = mov(r8);
                    lr = mov(r9);
                    r3 = lsls(r0, 9);
                    r3 = lsrs(r3, 9);
                    r4 = lsls(r0, 1);
                    r2 = lsrs(r0, 31);
                    r12 = mov(r3);
                    r0 = lsls(r1, 1);
                    r5 = lsls(r3, 3);
                    r3 = lsls(r1, 9);
                    r4 = lsrs(r4, 24);
                    r3 = lsrs(r3, 9);
                    r0 = lsrs(r0, 24);
                    push(true, r7);
                    r8 = mov(r3);
                    r6 = movs(r6, r4);
                    r9 = mov(r2);
                    r1 = lsrs(r1, 31);
                    r3 = lsls(r3, 3);
                    r7 = subs(r4, r0);
                    cmp(r2, r1);
                    if (beq()) {
                        offset = 130;
                        continue;
                    }
                case 46:
                    cmp(r7, 0);
                    if (ble()) {
                        offset = 94;
                        continue;
                    }
                case 50:
                    cmp(r0, 0);
                    if (bne()) {
                        offset = 204;
                        continue;
                    }
                case 54:
                    cmp(r3, 0);
                    if (beq()) {
                        offset = 60;
                        continue;
                    }
                case 58:
                    step();
                    offset = 360;
                    continue;
                case 60:
                    r5 = lsrs(r5, 3);
                    cmp(r4, 255);
                    if (bne()) {
                        offset = 68;
                        continue;
                    }
                case 66:
                    step();
                    offset = 342;
                    continue;
                case 68:
                    r3 = lsls(r5, 9);
                    r3 = lsrs(r3, 9);
                    r6 = uxtb(r4);
                case 74:
                    r3 = lsls(r3, 9);
                    r6 = lsls(r6, 23);
                    r0 = lsrs(r3, 9);
                    r0 = orrs(r0, r6);
                    r2 = lsls(r2, 31);
                    r0 = orrs(r0, r2);
                    pop(false, R2, R3);
                    r8 = mov(r2);
                    r9 = mov(r3);
                    pop(true, R3, R4, R5, R6, R7);
                    return;
                case 94:
                    cmp(r7, 0);
                    if (beq()) {
                        offset = 100;
                        continue;
                    }
                case 98:
                    step();
                    offset = 372;
                    continue;
                case 100:
                    r0 = adds(r4, 1);
                    r0 = uxtb(r0);
                    cmp(r0, 1);
                    if (bgt()) {
                        offset = 110;
                        continue;
                    }
                case 108:
                    step();
                    offset = 476;
                    continue;
                case 110:
                    r6 = subs(r5, r3);
                    r2 = lsls(r6, 5);
                    if (bpl()) {
                        offset = 118;
                        continue;
                    }
                case 116:
                    step();
                    offset = 514;
                    continue;
                case 118:
                    cmp(r6, 0);
                    if (bne()) {
                        offset = 246;
                        continue;
                    }
                case 122:
                    r2 = movs(r2, 0);
                    r6 = movs(r6, 0);
                    r3 = movs(r3, 0);
                    step();
                    offset = 74;
                    continue;
                case 130:
                    cmp(r7, 0);
                    if (bgt()) {
                        offset = 136;
                        continue;
                    }
                case 134:
                    step();
                    offset = 438;
                    continue;
                case 136:
                    cmp(r0, 0);
                    if (beq()) {
                        offset = 328;
                        continue;
                    }
                case 140:
                    cmp(r4, 255);
                    if (beq()) {
                        offset = 338;
                        continue;
                    }
                case 144:
                    r2 = movs(r2, 128);
                    r2 = lsls(r2, 19);
                    r3 = orrs(r3, r2);
                case 150:
                    cmp(r7, 27);
                    if (ble()) {
                        offset = 156;
                        continue;
                    }
                case 154:
                    step();
                    offset = 630;
                    continue;
                case 156:
                    r2 = movs(r2, 32);
                    r2 = subs(r2, r7);
                    r0 = movs(r0, r3);
                    r3 = lsls(r3, r2);
                    r0 = lsrs(r0, r7);
                    r2 = subs(r3, 1);
                    r3 = sbcs(r3, r2);
                    r3 = orrs(r3, r0);
                case 172:
                    r5 = adds(r5, r3);
                case 174:
                    r3 = lsls(r5, 5);
                    if (bpl()) {
                        offset = 426;
                        continue;
                    }
                case 178:
                    r4 = adds(r4, 1);
                    cmp(r4, 255);
                    if (bne()) {
                        offset = 186;
                        continue;
                    }
                case 184:
                    step();
                    offset = 554;
                    continue;
                case 186:
                    r2 = movs(r2, 1);
                    r6 = movs(r6, 7);
                    r2 = ands(r2, r5);
                    r3 = lsrs(r5, 1);
                    r5 = ldr(__aeabi_fadd + 812);
                    r5 = ands(r5, r3);
                    r5 = orrs(r5, r2);
                    r6 = ands(r6, r5);
                    step();
                    offset = 288;
                    continue;
                case 204:
                    cmp(r4, 255);
                    if (beq()) {
                        offset = 60;
                        continue;
                    }
                case 208:
                    r2 = movs(r2, 128);
                    r2 = lsls(r2, 19);
                    r3 = orrs(r3, r2);
                case 214:
                    cmp(r7, 27);
                    if (ble()) {
                        offset = 220;
                        continue;
                    }
                case 218:
                    step();
                    offset = 578;
                    continue;
                case 220:
                    r2 = movs(r2, 32);
                    r2 = subs(r2, r7);
                    r1 = movs(r1, r3);
                    r3 = lsls(r3, r2);
                    r1 = lsrs(r1, r7);
                    r2 = subs(r3, 1);
                    r3 = sbcs(r3, r2);
                    r3 = orrs(r3, r1);
                case 236:
                    r5 = subs(r5, r3);
                case 238:
                    r3 = lsls(r5, 5);
                    if (bpl()) {
                        offset = 426;
                        continue;
                    }
                case 242:
                    r5 = lsls(r5, 6);
                    r6 = lsrs(r5, 6);
                case 246:
                    r0 = movs(r0, r6);
                    bl(this::__clzsi2, __aeabi_fadd + 252 | 1, 252);
                    return;
                case 252:
                    r0 = subs(r0, 5);
                    r6 = lsls(r6, r0);
                    cmp(r4, r0);
                    if (bgt()) {
                        offset = 464;
                        continue;
                    }
                case 260:
                    r4 = subs(r0, r4);
                    r3 = movs(r3, r6);
                    r0 = movs(r0, 32);
                    r4 = adds(r4, 1);
                    r3 = lsrs(r3, r4);
                    r4 = subs(r0, r4);
                    r6 = lsls(r6, r4);
                    r5 = subs(r6, 1);
                    r6 = sbcs(r6, r5);
                    r3 = orrs(r3, r6);
                    r6 = movs(r6, 7);
                    r5 = movs(r5, r3);
                    r4 = movs(r4, 0);
                    r6 = ands(r6, r3);
                case 288:
                    r2 = movs(r2, 1);
                    r3 = mov(r9);
                    r2 = ands(r2, r3);
                    cmp(r6, 0);
                    if (beq()) {
                        offset = 308;
                        continue;
                    }
                case 298:
                    r3 = movs(r3, 15);
                    r3 = ands(r3, r5);
                    cmp(r3, 4);
                    if (beq()) {
                        offset = 308;
                        continue;
                    }
                case 306:
                    r5 = adds(r5, 4);
                case 308:
                    r3 = lsls(r5, 5);
                    if (bmi()) {
                        offset = 314;
                        continue;
                    }
                case 312:
                    step();
                    offset = 60;
                    continue;
                case 314:
                    r4 = adds(r4, 1);
                    r6 = uxtb(r4);
                    cmp(r4, 255);
                    if (bne()) {
                        offset = 418;
                        continue;
                    }
                case 322:
                    r6 = movs(r6, 255);
                    r3 = movs(r3, 0);
                    step();
                    offset = 74;
                    continue;
                case 328:
                    cmp(r3, 0);
                    if (bne()) {
                        offset = 498;
                        continue;
                    }
                case 332:
                    cmp(r4, 255);
                    if (beq()) {
                        offset = 338;
                        continue;
                    }
                case 336:
                    step();
                    offset = 60;
                    continue;
                case 338:
                    r2 = movs(r2, r1);
                    r5 = lsrs(r5, 3);
                case 342:
                    cmp(r5, 0);
                    if (beq()) {
                        offset = 322;
                        continue;
                    }
                case 346:
                    r3 = movs(r3, 128);
                    r3 = lsls(r3, 15);
                    r3 = orrs(r3, r5);
                    r3 = lsls(r3, 9);
                    r3 = lsrs(r3, 9);
                    r6 = movs(r6, 255);
                    step();
                    offset = 74;
                    continue;
                case 360:
                    r7 = subs(r7, 1);
                    cmp(r7, 0);
                    if (beq()) {
                        offset = 236;
                        continue;
                    }
                case 366:
                    cmp(r4, 255);
                    if (bne()) {
                        offset = 214;
                        continue;
                    }
                case 370:
                    step();
                    offset = 60;
                    continue;
                case 372:
                    cmp(r4, 0);
                    if (beq()) {
                        offset = 520;
                        continue;
                    }
                case 376:
                    cmp(r0, 255);
                    if (beq()) {
                        offset = 592;
                        continue;
                    }
                case 380:
                    r4 = movs(r4, 128);
                    r4 = lsls(r4, 19);
                    r2 = rsbs(r7);
                    r5 = orrs(r5, r4);
                case 388:
                    cmp(r2, 27);
                    if (ble()) {
                        offset = 394;
                        continue;
                    }
                case 392:
                    step();
                    offset = 790;
                    continue;
                case 394:
                    r4 = movs(r4, r5);
                    r6 = movs(r6, 32);
                    r4 = lsrs(r4, r2);
                    r2 = subs(r6, r2);
                    r5 = lsls(r5, r2);
                    r2 = subs(r5, 1);
                    r5 = sbcs(r5, r2);
                    r5 = orrs(r5, r4);
                case 410:
                    r5 = subs(r3, r5);
                    r4 = movs(r4, r0);
                    r9 = mov(r1);
                    step();
                    offset = 238;
                    continue;
                case 418:
                    r3 = lsls(r5, 6);
                    r3 = lsrs(r3, 9);
                    step();
                    offset = 74;
                    continue;
                case 424:
                    r4 = movs(r4, 0);
                case 426:
                    r2 = movs(r2, 1);
                    r3 = mov(r9);
                    r2 = ands(r2, r3);
                    r3 = lsls(r5, 29);
                    if (bne()) {
                        offset = 298;
                        continue;
                    }
                case 436:
                    step();
                    offset = 60;
                    continue;
                case 438:
                    cmp(r7, 0);
                    if (bne()) {
                        offset = 562;
                        continue;
                    }
                case 442:
                    r4 = adds(r4, 1);
                    r0 = uxtb(r4);
                    cmp(r0, 1);
                    if (ble()) {
                        offset = 600;
                        continue;
                    }
                case 450:
                    cmp(r4, 255);
                    if (beq()) {
                        offset = 322;
                        continue;
                    }
                case 454:
                    r6 = movs(r6, 7);
                    r5 = adds(r5, r3);
                    r5 = lsrs(r5, 1);
                    r6 = ands(r6, r5);
                    step();
                    offset = 288;
                    continue;
                case 464:
                    r3 = movs(r3, 7);
                    r5 = ldr(__aeabi_fadd + 816);
                    r4 = subs(r4, r0);
                    r5 = ands(r5, r6);
                    r6 = ands(r6, r3);
                    step();
                    offset = 288;
                    continue;
                case 476:
                    cmp(r4, 0);
                    if (bne()) {
                        offset = 536;
                        continue;
                    }
                case 480:
                    cmp(r5, 0);
                    if (bne()) {
                        offset = 706;
                        continue;
                    }
                case 484:
                    cmp(r3, 0);
                    if (bne()) {
                        offset = 490;
                        continue;
                    }
                case 488:
                    step();
                    offset = 800;
                    continue;
                case 490:
                    r2 = movs(r2, r1);
                    r5 = movs(r5, r3);
                    r4 = movs(r4, r7);
                    step();
                    offset = 60;
                    continue;
                case 498:
                    r7 = subs(r7, 1);
                    cmp(r7, 0);
                    if (bne()) {
                        offset = 506;
                        continue;
                    }
                case 504:
                    step();
                    offset = 172;
                    continue;
                case 506:
                    cmp(r4, 255);
                    if (beq()) {
                        offset = 512;
                        continue;
                    }
                case 510:
                    step();
                    offset = 150;
                    continue;
                case 512:
                    step();
                    offset = 338;
                    continue;
                case 514:
                    r6 = subs(r3, r5);
                    r9 = mov(r1);
                    step();
                    offset = 246;
                    continue;
                case 520:
                    cmp(r5, 0);
                    if (bne()) {
                        offset = 582;
                        continue;
                    }
                case 524:
                    r2 = movs(r2, r1);
                    cmp(r0, 255);
                    if (beq()) {
                        offset = 594;
                        continue;
                    }
                case 530:
                    r4 = movs(r4, r0);
                    r5 = movs(r5, r3);
                    step();
                    offset = 60;
                    continue;
                case 536:
                    cmp(r5, 0);
                    if (bne()) {
                        offset = 728;
                        continue;
                    }
                case 540:
                    cmp(r3, 0);
                    if (bne()) {
                        offset = 592;
                        continue;
                    }
                case 544:
                    r3 = movs(r3, 128);
                    r2 = movs(r2, 0);
                    r3 = lsls(r3, 15);
                    r6 = movs(r6, 255);
                    step();
                    offset = 74;
                    continue;
                case 554:
                    r2 = movs(r2, r1);
                    r6 = movs(r6, 255);
                    r3 = movs(r3, 0);
                    step();
                    offset = 74;
                    continue;
                case 562:
                    cmp(r4, 0);
                    if (bne()) {
                        offset = 634;
                        continue;
                    }
                case 566:
                    cmp(r5, 0);
                    if (bne()) {
                        offset = 776;
                        continue;
                    }
                case 570:
                    cmp(r0, 255);
                    if (bne()) {
                        offset = 530;
                        continue;
                    }
                case 574:
                    r5 = movs(r5, r3);
                    step();
                    offset = 338;
                    continue;
                case 578:
                    r3 = movs(r3, 1);
                    step();
                    offset = 236;
                    continue;
                case 582:
                    r2 = adds(r7, 1);
                    if (beq()) {
                        offset = 410;
                        continue;
                    }
                case 586:
                    r2 = mvns(r2, r7);
                    cmp(r0, 255);
                    if (bne()) {
                        offset = 388;
                        continue;
                    }
                case 592:
                    r2 = movs(r2, r1);
                case 594:
                    r5 = movs(r5, r3);
                    r4 = movs(r4, 255);
                    step();
                    offset = 60;
                    continue;
                case 600:
                    cmp(r6, 0);
                    if (bne()) {
                        offset = 672;
                        continue;
                    }
                case 604:
                    cmp(r5, 0);
                    if (beq()) {
                        offset = 768;
                        continue;
                    }
                case 608:
                    cmp(r3, 0);
                    if (beq()) {
                        offset = 766;
                        continue;
                    }
                case 612:
                    r5 = adds(r5, r3);
                    r3 = lsls(r5, 5);
                    if (bpl()) {
                        offset = 424;
                        continue;
                    }
                case 618:
                    r3 = ldr(__aeabi_fadd + 816);
                    r6 = adds(r6, 7);
                    r6 = ands(r6, r5);
                    r4 = movs(r4, 1);
                    r5 = ands(r5, r3);
                    step();
                    offset = 288;
                    continue;
                case 630:
                    r3 = movs(r3, 1);
                    step();
                    offset = 172;
                    continue;
                case 634:
                    cmp(r0, 255);
                    if (beq()) {
                        offset = 574;
                        continue;
                    }
                case 638:
                    r4 = movs(r4, 128);
                    r4 = lsls(r4, 19);
                    r7 = rsbs(r7);
                    r5 = orrs(r5, r4);
                case 646:
                    cmp(r7, 27);
                    if (bgt()) {
                        offset = 806;
                        continue;
                    }
                case 650:
                    r6 = movs(r6, 32);
                    r6 = subs(r6, r7);
                    r4 = movs(r4, r5);
                    r5 = lsls(r5, r6);
                    r4 = lsrs(r4, r7);
                    r2 = subs(r5, 1);
                    r5 = sbcs(r5, r2);
                    r5 = orrs(r5, r4);
                case 666:
                    r5 = adds(r5, r3);
                    r4 = movs(r4, r0);
                    step();
                    offset = 174;
                    continue;
                case 672:
                    cmp(r5, 0);
                    if (beq()) {
                        offset = 574;
                        continue;
                    }
                case 676:
                    cmp(r3, 0);
                    if (bne()) {
                        offset = 682;
                        continue;
                    }
                case 680:
                    step();
                    offset = 338;
                    continue;
                case 682:
                    r1 = movs(r1, 128);
                    r0 = mov(r12);
                    r1 = lsls(r1, 15);
                    tst(r0, r1);
                    if (beq()) {
                        offset = 700;
                        continue;
                    }
                case 692:
                    r0 = mov(r8);
                    tst(r0, r1);
                    if (bne()) {
                        offset = 700;
                        continue;
                    }
                case 698:
                    r5 = movs(r5, r3);
                case 700:
                    r1 = movs(r1, 1);
                    r1 = ands(r1, r2);
                    step();
                    offset = 338;
                    continue;
                case 706:
                    cmp(r3, 0);
                    if (bne()) {
                        offset = 712;
                        continue;
                    }
                case 710:
                    step();
                    offset = 60;
                    continue;
                case 712:
                    r2 = subs(r5, r3);
                    r0 = lsls(r2, 5);
                    if (bpl()) {
                        offset = 794;
                        continue;
                    }
                case 718:
                    r6 = movs(r6, 7);
                    r5 = subs(r3, r5);
                    r6 = ands(r6, r5);
                    r9 = mov(r1);
                    step();
                    offset = 288;
                    continue;
                case 728:
                    r4 = movs(r4, 255);
                    cmp(r3, 0);
                    if (bne()) {
                        offset = 736;
                        continue;
                    }
                case 734:
                    step();
                    offset = 60;
                    continue;
                case 736:
                    r2 = movs(r2, 128);
                    r0 = mov(r12);
                    r2 = lsls(r2, 15);
                    tst(r0, r2);
                    if (beq()) {
                        offset = 756;
                        continue;
                    }
                case 746:
                    r0 = mov(r8);
                    tst(r0, r2);
                    if (bne()) {
                        offset = 756;
                        continue;
                    }
                case 752:
                    r5 = movs(r5, r3);
                    r9 = mov(r1);
                case 756:
                    r2 = movs(r2, 1);
                    r3 = mov(r9);
                    r4 = movs(r4, 255);
                    r2 = ands(r2, r3);
                    step();
                    offset = 60;
                    continue;
                case 766:
                    r3 = movs(r3, r5);
                case 768:
                    r5 = lsrs(r3, 3);
                    r2 = movs(r2, r1);
                    r4 = movs(r4, 0);
                    step();
                    offset = 68;
                    continue;
                case 776:
                    r2 = adds(r7, 1);
                    if (beq()) {
                        offset = 666;
                        continue;
                    }
                case 780:
                    r7 = mvns(r7, r7);
                    cmp(r0, 255);
                    if (bne()) {
                        offset = 646;
                        continue;
                    }
                case 786:
                    r5 = movs(r5, r3);
                    step();
                    offset = 338;
                    continue;
                case 790:
                    r5 = movs(r5, 1);
                    step();
                    offset = 410;
                    continue;
                case 794:
                    r5 = subs(r2, 0);
                    if (beq()) {
                        offset = 800;
                        continue;
                    }
                case 798:
                    step();
                    offset = 426;
                    continue;
                case 800:
                    r2 = movs(r2, 0);
                    r3 = movs(r3, 0);
                    step();
                    offset = 74;
                    continue;
                case 806:
                    r5 = movs(r5, 1);
                    step();
                    offset = 666;
                    continue;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134342984, size=548, name='__aeabi_fdiv', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(divsf3.o)', has_indirect=False)
    protected void __aeabi_fdiv(int offset) throws Exception
    {
        while (true)
        {
            pc = __aeabi_fdiv + offset;
            switch (offset)
            {
                case 0:
                    push(true, r3, r4, r5, r6, r7);
                    r7 = mov(r10);
                    r6 = mov(r9);
                    r5 = mov(r8);
                    lr = mov(r11);
                    r4 = lsls(r0, 9);
                    push(true, r5, r6, r7);
                    r6 = lsls(r0, 1);
                    r8 = mov(r1);
                    r4 = lsrs(r4, 9);
                    r6 = lsrs(r6, 24);
                    r7 = lsrs(r0, 31);
                    cmp(r6, 0);
                    if (beq()) {
                        offset = 228;
                        continue;
                    }
                case 28:
                    cmp(r6, 255);
                    if (beq()) {
                        offset = 106;
                        continue;
                    }
                case 32:
                    r3 = movs(r3, 128);
                    r4 = lsls(r4, 3);
                    r3 = lsls(r3, 19);
                    r4 = orrs(r4, r3);
                    r3 = movs(r3, 0);
                    r9 = mov(r3);
                    r11 = mov(r3);
                    r6 = subs(r6, 127);
                case 48:
                    r3 = mov(r8);
                    r2 = mov(r8);
                    r5 = lsls(r3, 9);
                    r2 = lsrs(r2, 31);
                    r3 = lsls(r3, 1);
                    r5 = lsrs(r5, 9);
                    r3 = lsrs(r3, 24);
                    r8 = mov(r2);
                    r10 = mov(r2);
                    if (beq()) {
                        offset = 272;
                        continue;
                    }
                case 68:
                    cmp(r3, 255);
                    if (beq()) {
                        offset = 244;
                        continue;
                    }
                case 72:
                    r2 = movs(r2, 128);
                    r1 = movs(r1, 0);
                    r5 = lsls(r5, 3);
                    r2 = lsls(r2, 19);
                    r3 = subs(r3, 127);
                    r5 = orrs(r5, r2);
                    r6 = subs(r6, r3);
                case 86:
                    r3 = mov(r8);
                    r2 = mov(r9);
                    r3 = eors(r3, r7);
                    cmp(r2, 15);
                    if (bls()) {
                        offset = 98;
                        continue;
                    }
                case 96:
                    step();
                    offset = 382;
                    continue;
                case 98:
                    r0 = ldr(__aeabi_fdiv + 536); // rodata;
                    r2 = lsls(r2, 2);
                    r2 = ldr(r0 + r2);
                    pc = mov(r2);
                    autob(pc); // auto;
                    return;
                case 106:
                    cmp(r4, 0);
                    if (bne()) {
                        offset = 280;
                        continue;
                    }
                case 110:
                    r3 = movs(r3, 8);
                    r9 = mov(r3);
                    r3 = subs(r3, 6);
                    r6 = movs(r6, 255);
                    r11 = mov(r3);
                    step();
                    offset = 48;
                    continue;
                case 140:
                    r0 = movs(r0, r6);
                    r0 = adds(r0, 127);
                    cmp(r0, 0);
                    if (ble()) {
                        offset = 214;
                        continue;
                    }
                case 148:
                    r2 = lsls(r5, 29);
                    if (beq()) {
                        offset = 162;
                        continue;
                    }
                case 152:
                    r2 = movs(r2, 15);
                    r2 = ands(r2, r5);
                    cmp(r2, 4);
                    if (beq()) {
                        offset = 162;
                        continue;
                    }
                case 160:
                    r5 = adds(r5, 4);
                case 162:
                    r2 = lsls(r5, 4);
                    if (bpl()) {
                        offset = 174;
                        continue;
                    }
                case 166:
                    r0 = movs(r0, r6);
                    r2 = ldr(__aeabi_fdiv + 540);
                    r0 = adds(r0, 128);
                    r5 = ands(r5, r2);
                case 174:
                    cmp(r0, 254);
                    if (bgt()) {
                        offset = 186;
                        continue;
                    }
                case 178:
                    r4 = lsls(r5, 6);
                    r4 = lsrs(r4, 9);
                    r2 = uxtb(r0);
                    step();
                    offset = 190;
                    continue;
                case 186:
                    r2 = movs(r2, 255);
                    r4 = movs(r4, 0);
                case 190:
                    r4 = lsls(r4, 9);
                    r2 = lsls(r2, 23);
                    r0 = lsrs(r4, 9);
                    r3 = lsls(r3, 31);
                    r0 = orrs(r0, r2);
                    r0 = orrs(r0, r3);
                    pop(false, R2, R3, R4, R5);
                    r8 = mov(r2);
                    r9 = mov(r3);
                    r10 = mov(r4);
                    r11 = mov(r5);
                    pop(true, R3, R4, R5, R6, R7);
                    return;
                case 214:
                    r2 = movs(r2, 1);
                    r0 = subs(r2, r0);
                    cmp(r0, 27);
                    if (ble()) {
                        offset = 472;
                        continue;
                    }
                case 222:
                    r2 = movs(r2, 0);
                    r4 = movs(r4, 0);
                    step();
                    offset = 190;
                    continue;
                case 228:
                    cmp(r4, 0);
                    if (bne()) {
                        offset = 292;
                        continue;
                    }
                case 232:
                    r3 = movs(r3, 4);
                    r9 = mov(r3);
                    r3 = subs(r3, 3);
                    r6 = movs(r6, 0);
                    r11 = mov(r3);
                    step();
                    offset = 48;
                    continue;
                case 244:
                    r6 = subs(r6, 255);
                    cmp(r5, 0);
                    if (bne()) {
                        offset = 316;
                        continue;
                    }
                case 250:
                    r1 = movs(r1, 2);
                case 252:
                    r3 = mov(r8);
                    r2 = mov(r9);
                    r3 = eors(r3, r7);
                    r2 = orrs(r2, r1);
                    cmp(r2, 15);
                    if (bhi()) {
                        offset = 186;
                        continue;
                    }
                case 264:
                    r0 = ldr(__aeabi_fdiv + 544);
                    r2 = lsls(r2, 2);
                    r2 = ldr(r0 + r2);
                    pc = mov(r2);
                    autob(pc); // auto;
                    return;
                case 272:
                    cmp(r5, 0);
                    if (bne()) {
                        offset = 328;
                        continue;
                    }
                case 276:
                    r1 = movs(r1, 1);
                    step();
                    offset = 252;
                    continue;
                case 280:
                    r3 = movs(r3, 12);
                    r9 = mov(r3);
                    r3 = subs(r3, 9);
                    r6 = movs(r6, 255);
                    r11 = mov(r3);
                    step();
                    offset = 48;
                    continue;
                case 292:
                    r0 = movs(r0, r4);
                    bl(this::__clzsi2, __aeabi_fdiv + 298 | 1, 298);
                    return;
                case 298:
                    r6 = movs(r6, 118);
                    r3 = subs(r0, 5);
                    r4 = lsls(r4, r3);
                    r3 = movs(r3, 0);
                    r6 = rsbs(r6);
                    r6 = subs(r6, r0);
                    r9 = mov(r3);
                    r11 = mov(r3);
                    step();
                    offset = 48;
                    continue;
                case 316:
                    r2 = mov(r9);
                    r3 = movs(r3, 3);
                    r2 = orrs(r2, r3);
                    r9 = mov(r2);
                    r1 = movs(r1, 3);
                    step();
                    offset = 86;
                    continue;
                case 328:
                    r0 = movs(r0, r5);
                    bl(this::__clzsi2, __aeabi_fdiv + 334 | 1, 334);
                    return;
                case 334:
                    r3 = subs(r0, 5);
                    r6 = adds(r6, r0);
                    r5 = lsls(r5, r3);
                    r6 = adds(r6, 118);
                    r1 = movs(r1, 0);
                    step();
                    offset = 86;
                    continue;
                case 382:
                    r2 = lsls(r4, 5);
                    r4 = lsls(r5, 5);
                    cmp(r2, r4);
                    if (bhs()) {
                        offset = 464;
                        continue;
                    }
                case 390:
                    r1 = movs(r1, 27);
                    r5 = movs(r5, 0);
                    r6 = subs(r6, 1);
                case 396:
                    r7 = movs(r7, 1);
                case 398:
                    r0 = movs(r0, r2);
                    r5 = lsls(r5, 1);
                    r2 = lsls(r2, 1);
                    cmp(r0, 0);
                    if (blt()) {
                        offset = 412;
                        continue;
                    }
                case 408:
                    cmp(r4, r2);
                    if (bhi()) {
                        offset = 416;
                        continue;
                    }
                case 412:
                    r2 = subs(r2, r4);
                    r5 = orrs(r5, r7);
                case 416:
                    r1 = subs(r1, 1);
                    cmp(r1, 0);
                    if (bne()) {
                        offset = 398;
                        continue;
                    }
                case 422:
                    r4 = movs(r4, r2);
                    r2 = subs(r4, 1);
                    r4 = sbcs(r4, r2);
                    r5 = orrs(r5, r4);
                    step();
                    offset = 140;
                    continue;
                case 464:
                    r2 = subs(r2, r4);
                    r1 = movs(r1, 26);
                    r5 = movs(r5, 1);
                    step();
                    offset = 396;
                    continue;
                case 472:
                    r6 = adds(r6, 158);
                    r2 = movs(r2, r5);
                    r5 = lsls(r5, r6);
                    r4 = movs(r4, r5);
                    r2 = lsrs(r2, r0);
                    r5 = subs(r4, 1);
                    r4 = sbcs(r4, r5);
                    r4 = orrs(r4, r2);
                    r2 = lsls(r4, 29);
                    if (beq()) {
                        offset = 502;
                        continue;
                    }
                case 492:
                    r2 = movs(r2, 15);
                    r2 = ands(r2, r4);
                    cmp(r2, 4);
                    if (beq()) {
                        offset = 502;
                        continue;
                    }
                case 500:
                    r4 = adds(r4, 4);
                case 502:
                    r2 = lsls(r4, 5);
                    if (bmi()) {
                        offset = 514;
                        continue;
                    }
                case 506:
                    r4 = lsls(r4, 6);
                    r4 = lsrs(r4, 9);
                    r2 = movs(r2, 0);
                    step();
                    offset = 190;
                    continue;
                case 514:
                    r2 = movs(r2, 1);
                    r4 = movs(r4, 0);
                    step();
                    offset = 190;
                    continue;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134343532, size=80, name='__eqsf2', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(eqsf2.o)', has_indirect=False)
    protected void __eqsf2(int offset) throws Exception
    {
        while (true)
        {
            pc = __eqsf2 + offset;
            switch (offset)
            {
                case 0:
                    push(true, r4, r5, r6);
                    r2 = lsls(r0, 1);
                    r6 = lsls(r1, 9);
                    r4 = lsls(r1, 1);
                    r5 = lsls(r0, 9);
                    r5 = lsrs(r5, 9);
                    r2 = lsrs(r2, 24);
                    r3 = lsrs(r0, 31);
                    r6 = lsrs(r6, 9);
                    r4 = lsrs(r4, 24);
                    r1 = lsrs(r1, 31);
                    cmp(r2, 255);
                    if (beq()) {
                        offset = 58;
                        continue;
                    }
                case 26:
                    cmp(r4, 255);
                    if (beq()) {
                        offset = 66;
                        continue;
                    }
                case 30:
                    r0 = movs(r0, 1);
                    cmp(r2, r4);
                    if (beq()) {
                        offset = 38;
                        continue;
                    }
                case 36:
                    pop(true, R4, R5, R6);
                    return;
                case 38:
                    cmp(r5, r6);
                    if (bne()) {
                        offset = 36;
                        continue;
                    }
                case 42:
                    cmp(r3, r1);
                    if (beq()) {
                        offset = 74;
                        continue;
                    }
                case 46:
                    cmp(r2, 0);
                    if (bne()) {
                        offset = 36;
                        continue;
                    }
                case 50:
                    r0 = movs(r0, r5);
                    r5 = subs(r0, 1);
                    r0 = sbcs(r0, r5);
                    step();
                    offset = 36;
                    continue;
                case 58:
                    r0 = movs(r0, 1);
                    cmp(r5, 0);
                    if (bne()) {
                        offset = 36;
                        continue;
                    }
                case 64:
                    step();
                    offset = 26;
                    continue;
                case 66:
                    r0 = movs(r0, 1);
                    cmp(r6, 0);
                    if (bne()) {
                        offset = 36;
                        continue;
                    }
                case 72:
                    step();
                    offset = 30;
                    continue;
                case 74:
                    r0 = movs(r0, 0);
                    step();
                    offset = 36;
                    continue;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134343612, size=156, name='__gesf2', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(gesf2.o)', has_indirect=False)
    protected void __gesf2(int offset) throws Exception
    {
        while (true)
        {
            pc = __gesf2 + offset;
            switch (offset)
            {
                case 0:
                    push(true, r4, r5, r6);
                    r2 = lsls(r1, 1);
                    r6 = lsls(r1, 9);
                    r5 = lsls(r0, 9);
                    r4 = lsls(r0, 1);
                    r5 = lsrs(r5, 9);
                    r4 = lsrs(r4, 24);
                    r3 = lsrs(r0, 31);
                    r6 = lsrs(r6, 9);
                    r2 = lsrs(r2, 24);
                    r1 = lsrs(r1, 31);
                    cmp(r4, 255);
                    if (beq()) {
                        offset = 70;
                        continue;
                    }
                case 26:
                    cmp(r2, 255);
                    if (beq()) {
                        offset = 60;
                        continue;
                    }
                case 30:
                    cmp(r4, 0);
                    if (bne()) {
                        offset = 78;
                        continue;
                    }
                case 34:
                    cmp(r2, 0);
                    if (bne()) {
                        offset = 42;
                        continue;
                    }
                case 38:
                    cmp(r6, 0);
                    if (beq()) {
                        offset = 100;
                        continue;
                    }
                case 42:
                    cmp(r5, 0);
                    if (beq()) {
                        offset = 88;
                        continue;
                    }
                case 46:
                    cmp(r3, r1);
                    if (beq()) {
                        offset = 130;
                        continue;
                    }
                case 50:
                    r0 = movs(r0, 2);
                    r3 = subs(r3, 1);
                    r0 = ands(r0, r3);
                    r0 = subs(r0, 1);
                case 58:
                    pop(true, R4, R5, R6);
                    return;
                case 60:
                    cmp(r6, 0);
                    if (beq()) {
                        offset = 30;
                        continue;
                    }
                case 64:
                    r0 = movs(r0, 2);
                    r0 = rsbs(r0);
                    step();
                    offset = 58;
                    continue;
                case 70:
                    cmp(r5, 0);
                    if (bne()) {
                        offset = 64;
                        continue;
                    }
                case 74:
                    cmp(r2, 255);
                    if (beq()) {
                        offset = 108;
                        continue;
                    }
                case 78:
                    cmp(r2, 0);
                    if (bne()) {
                        offset = 112;
                        continue;
                    }
                case 82:
                    cmp(r6, 0);
                    if (beq()) {
                        offset = 50;
                        continue;
                    }
                case 86:
                    step();
                    offset = 112;
                    continue;
                case 88:
                    r3 = movs(r3, 1);
                    r1 = subs(r1, 1);
                    r1 = bics(r1, r3);
                    r0 = movs(r0, r1);
                    r0 = adds(r0, 1);
                    step();
                    offset = 58;
                    continue;
                case 100:
                    r0 = movs(r0, 0);
                    cmp(r5, 0);
                    if (beq()) {
                        offset = 58;
                        continue;
                    }
                case 106:
                    step();
                    offset = 50;
                    continue;
                case 108:
                    cmp(r6, 0);
                    if (bne()) {
                        offset = 64;
                        continue;
                    }
                case 112:
                    cmp(r3, r1);
                    if (bne()) {
                        offset = 50;
                        continue;
                    }
                case 116:
                    cmp(r4, r2);
                    if (ble()) {
                        offset = 132;
                        continue;
                    }
                case 120:
                    r1 = movs(r1, 2);
                    r0 = subs(r3, 1);
                    r0 = ands(r0, r1);
                    r0 = subs(r0, 1);
                    step();
                    offset = 58;
                    continue;
                case 130:
                    r4 = movs(r4, 0);
                case 132:
                    cmp(r2, r4);
                    if (bgt()) {
                        offset = 146;
                        continue;
                    }
                case 136:
                    cmp(r5, r6);
                    if (bhi()) {
                        offset = 50;
                        continue;
                    }
                case 140:
                    r0 = movs(r0, 0);
                    cmp(r5, r6);
                    if (bhs()) {
                        offset = 58;
                        continue;
                    }
                case 146:
                    r0 = subs(r3, 1);
                    r3 = movs(r3, 1);
                    r0 = bics(r0, r3);
                    r0 = adds(r0, 1);
                    step();
                    offset = 58;
                    continue;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134343768, size=160, name='__ltsf2', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(lesf2.o)', has_indirect=False)
    protected void __ltsf2(int offset) throws Exception
    {
        while (true)
        {
            pc = __ltsf2 + offset;
            switch (offset)
            {
                case 0:
                    push(true, r4, r5);
                    r2 = lsls(r0, 1);
                    r4 = lsls(r0, 9);
                    r5 = lsls(r1, 9);
                    r3 = lsrs(r0, 31);
                    r0 = lsls(r1, 1);
                    r4 = lsrs(r4, 9);
                    r2 = lsrs(r2, 24);
                    r5 = lsrs(r5, 9);
                    r0 = lsrs(r0, 24);
                    r1 = lsrs(r1, 31);
                    cmp(r2, 255);
                    if (beq()) {
                        offset = 64;
                        continue;
                    }
                case 26:
                    cmp(r0, 255);
                    if (beq()) {
                        offset = 56;
                        continue;
                    }
                case 30:
                    cmp(r2, 0);
                    if (bne()) {
                        offset = 72;
                        continue;
                    }
                case 34:
                    cmp(r0, 0);
                    if (bne()) {
                        offset = 90;
                        continue;
                    }
                case 38:
                    cmp(r5, 0);
                    if (bne()) {
                        offset = 90;
                        continue;
                    }
                case 42:
                    cmp(r4, 0);
                    if (beq()) {
                        offset = 134;
                        continue;
                    }
                case 46:
                    r0 = movs(r0, 2);
                    r3 = subs(r3, 1);
                    r0 = ands(r0, r3);
                    r0 = subs(r0, 1);
                    step();
                    offset = 134;
                    continue;
                case 56:
                    cmp(r5, 0);
                    if (beq()) {
                        offset = 30;
                        continue;
                    }
                case 60:
                    r0 = movs(r0, 2);
                    step();
                    offset = 134;
                    continue;
                case 64:
                    cmp(r4, 0);
                    if (bne()) {
                        offset = 60;
                        continue;
                    }
                case 68:
                    cmp(r0, 255);
                    if (beq()) {
                        offset = 136;
                        continue;
                    }
                case 72:
                    cmp(r0, 0);
                    if (bne()) {
                        offset = 140;
                        continue;
                    }
                case 76:
                    cmp(r5, 0);
                    if (bne()) {
                        offset = 140;
                        continue;
                    }
                case 80:
                    r0 = movs(r0, 2);
                    r3 = subs(r3, 1);
                    r0 = ands(r0, r3);
                    r0 = subs(r0, 1);
                    step();
                    offset = 134;
                    continue;
                case 90:
                    cmp(r4, 0);
                    if (beq()) {
                        offset = 124;
                        continue;
                    }
                case 94:
                    cmp(r3, r1);
                    if (bne()) {
                        offset = 46;
                        continue;
                    }
                case 98:
                    r2 = movs(r2, 0);
                case 100:
                    cmp(r0, r2);
                    if (bgt()) {
                        offset = 114;
                        continue;
                    }
                case 104:
                    cmp(r4, r5);
                    if (bhi()) {
                        offset = 46;
                        continue;
                    }
                case 108:
                    r0 = movs(r0, 0);
                    cmp(r4, r5);
                    if (bhs()) {
                        offset = 134;
                        continue;
                    }
                case 114:
                    r0 = subs(r3, 1);
                    r3 = movs(r3, 1);
                    r0 = bics(r0, r3);
                    r0 = adds(r0, 1);
                    step();
                    offset = 134;
                    continue;
                case 124:
                    r3 = movs(r3, 1);
                    r1 = subs(r1, 1);
                    r1 = bics(r1, r3);
                    r0 = movs(r0, r1);
                    r0 = adds(r0, 1);
                case 134:
                    pop(true, R4, R5);
                    return;
                case 136:
                    cmp(r5, 0);
                    if (bne()) {
                        offset = 60;
                        continue;
                    }
                case 140:
                    cmp(r3, r1);
                    if (bne()) {
                        offset = 46;
                        continue;
                    }
                case 144:
                    cmp(r2, r0);
                    if (ble()) {
                        offset = 100;
                        continue;
                    }
                case 148:
                    r1 = movs(r1, 2);
                    r0 = subs(r3, 1);
                    r0 = ands(r0, r1);
                    r0 = subs(r0, 1);
                    step();
                    offset = 134;
                    continue;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134343928, size=612, name='__aeabi_fmul', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(mulsf3.o)', has_indirect=False)
    protected void __aeabi_fmul(int offset) throws Exception
    {
        while (true)
        {
            pc = __aeabi_fmul + offset;
            switch (offset)
            {
                case 0:
                    push(true, r4, r5, r6, r7);
                case 2:
                    r6 = mov(r9);
                case 4:
                    r7 = mov(r10);
                case 6:
                    r5 = mov(r8);
                case 8:
                    lr = mov(r11);
                case 10:
                    push(true, r5, r6, r7);
                case 12:
                    r3 = lsls(r0, 9);
                case 14:
                    r3 = lsrs(r3, 9);
                case 16:
                    r5 = lsls(r0, 1);
                case 18:
                    sp = sub(sp, 12);
                case 20:
                    r7 = adds(r1, 0);
                case 22:
                    r9 = mov(r3);
                case 24:
                    r5 = lsrs(r5, 24);
                case 26:
                    r6 = lsrs(r0, 31);
                case 28:
                    cmp(r5, 0);
                case 30:
                    if (beq()) {
                        offset = 208;
                        continue;
                    }
                case 32:
                    cmp(r5, 255);
                case 34:
                    if (beq()) {
                        offset = 110;
                        continue;
                    }
                case 36:
                    r0 = movs(r0, 128);
                case 38:
                    r3 = lsls(r3, 3);
                case 40:
                    r0 = lsls(r0, 19);
                case 42:
                    r0 = orrs(r0, r3);
                case 44:
                    r3 = movs(r3, 0);
                case 46:
                    r9 = mov(r0);
                case 48:
                    r10 = mov(r3);
                case 50:
                    r11 = mov(r3);
                case 52:
                    r5 = subs(r5, 127);
                case 54:
                    r4 = lsls(r7, 9);
                case 56:
                    r2 = lsls(r7, 1);
                case 58:
                    r3 = lsrs(r7, 31);
                case 60:
                    r4 = lsrs(r4, 9);
                case 62:
                    r2 = lsrs(r2, 24);
                case 64:
                    r8 = mov(r3);
                case 66:
                    if (beq()) {
                        offset = 140;
                        continue;
                    }
                case 68:
                    cmp(r2, 255);
                case 70:
                    if (beq()) {
                        offset = 224;
                        continue;
                    }
                case 72:
                    r3 = lsls(r4, 3);
                case 74:
                    r4 = movs(r4, 128);
                case 76:
                    r0 = movs(r0, 0);
                case 78:
                    r4 = lsls(r4, 19);
                case 80:
                    r2 = subs(r2, 127);
                case 82:
                    r4 = orrs(r4, r3);
                case 84:
                    r5 = adds(r5, r2);
                case 86:
                    r3 = adds(r5, 1);
                case 88:
                    r7 = mov(r8);
                case 90:
                    str(sp + 4, r3);
                case 92:
                    r3 = mov(r10);
                case 94:
                    r7 = eors(r7, r6);
                case 96:
                    r2 = movs(r2, r7);
                case 98:
                    cmp(r3, 15);
                case 100:
                    if (bhi()) {
                        offset = 248;
                        continue;
                    }
                case 102:
                    r1 = ldr(__aeabi_fmul + 604); // rodata;
                case 104:
                    r3 = lsls(r3, 2);
                case 106:
                    r3 = ldr(r1 + r3);
                case 108:
                    pc = mov(r3);
                    autob(pc); // auto;
                    return;
                case 110:
                    cmp(r3, 0);
                case 112:
                    if (beq()) {
                        offset = 116;
                        continue;
                    }
                case 114:
                    step();
                    offset = 384;
                    continue;
                case 116:
                    r3 = adds(r3, 8);
                case 118:
                    r10 = mov(r3);
                case 120:
                    r3 = subs(r3, 6);
                case 122:
                    r11 = mov(r3);
                case 124:
                    r4 = lsls(r7, 9);
                case 126:
                    r2 = lsls(r7, 1);
                case 128:
                    r3 = lsrs(r7, 31);
                case 130:
                    r5 = movs(r5, 255);
                case 132:
                    r4 = lsrs(r4, 9);
                case 134:
                    r2 = lsrs(r2, 24);
                case 136:
                    r8 = mov(r3);
                case 138:
                    if (bne()) {
                        offset = 68;
                        continue;
                    }
                case 140:
                    cmp(r4, 0);
                case 142:
                    if (beq()) {
                        offset = 146;
                        continue;
                    }
                case 144:
                    step();
                    offset = 436;
                    continue;
                case 146:
                    r2 = mov(r10);
                case 148:
                    r3 = movs(r3, 1);
                case 150:
                    r2 = orrs(r2, r3);
                case 152:
                    r10 = mov(r2);
                case 154:
                    r0 = movs(r0, 1);
                case 156:
                    step();
                    offset = 86;
                    continue;
                case 158:
                    r4 = mov(r9);
                case 160:
                    r0 = mov(r11);
                case 162:
                    r7 = movs(r7, r2);
                case 164:
                    cmp(r0, 2);
                case 166:
                    if (beq()) {
                        offset = 242;
                        continue;
                    }
                case 168:
                    cmp(r0, 3);
                case 170:
                    if (bne()) {
                        offset = 174;
                        continue;
                    }
                case 172:
                    step();
                    offset = 590;
                    continue;
                case 174:
                    r2 = movs(r2, 0);
                case 176:
                    r3 = movs(r3, 0);
                case 178:
                    cmp(r0, 1);
                case 180:
                    if (bne()) {
                        offset = 338;
                        continue;
                    }
                case 182:
                    r0 = lsls(r3, 9);
                case 184:
                    r2 = lsls(r2, 23);
                case 186:
                    r0 = lsrs(r0, 9);
                case 188:
                    r7 = lsls(r7, 31);
                case 190:
                    r0 = orrs(r0, r2);
                case 192:
                    r0 = orrs(r0, r7);
                case 194:
                    sp = add(sp, 12);
                case 196:
                    pop(false, R2, R3, R4, R5);
                case 198:
                    r8 = mov(r2);
                case 200:
                    r9 = mov(r3);
                case 202:
                    r10 = mov(r4);
                case 204:
                    r11 = mov(r5);
                case 206:
                    pop(true, R4, R5, R6, R7);
                    return;
                case 208:
                    cmp(r3, 0);
                case 210:
                    if (bne()) {
                        offset = 396;
                        continue;
                    }
                case 212:
                    r3 = movs(r3, 4);
                case 214:
                    r10 = mov(r3);
                case 216:
                    r3 = subs(r3, 3);
                case 218:
                    r5 = movs(r5, 0);
                case 220:
                    r11 = mov(r3);
                case 222:
                    step();
                    offset = 54;
                    continue;
                case 224:
                    r5 = adds(r5, 255);
                case 226:
                    cmp(r4, 0);
                case 228:
                    if (bne()) {
                        offset = 424;
                        continue;
                    }
                case 230:
                    r2 = mov(r10);
                case 232:
                    r3 = movs(r3, 2);
                case 234:
                    r2 = orrs(r2, r3);
                case 236:
                    r10 = mov(r2);
                case 238:
                    r0 = movs(r0, 2);
                case 240:
                    step();
                    offset = 86;
                    continue;
                case 242:
                    r2 = movs(r2, 255);
                case 244:
                    r3 = movs(r3, 0);
                case 246:
                    step();
                    offset = 182;
                    continue;
                case 248:
                    r3 = mov(r9);
                case 250:
                    r3 = lsrs(r3, 16);
                case 252:
                    r12 = mov(r3);
                case 254:
                    r3 = mov(r9);
                case 256:
                    r6 = lsls(r4, 16);
                case 258:
                    r6 = lsrs(r6, 16);
                case 260:
                    r0 = lsls(r3, 16);
                case 262:
                    r1 = mov(r12);
                case 264:
                    r3 = movs(r3, r6);
                case 266:
                    r2 = lsrs(r4, 16);
                case 268:
                    r4 = mov(r12);
                case 270:
                    r0 = lsrs(r0, 16);
                case 272:
                    r3 = muls(r0, r3);
                case 274:
                    r6 = muls(r1, r6);
                case 276:
                    r0 = muls(r2, r0);
                case 278:
                    r4 = muls(r2, r4);
                case 280:
                    r0 = adds(r0, r6);
                case 282:
                    r2 = lsrs(r3, 16);
                case 284:
                    r2 = adds(r2, r0);
                case 286:
                    cmp(r6, r2);
                case 288:
                    if (bls()) {
                        offset = 298;
                        continue;
                    }
                case 290:
                    r1 = movs(r1, 128);
                case 292:
                    r1 = lsls(r1, 9);
                case 294:
                    r12 = mov(r1);
                case 296:
                    r4 = add(r4, r12);
                case 298:
                    r3 = lsls(r3, 16);
                case 300:
                    r3 = lsrs(r3, 16);
                case 302:
                    r0 = lsls(r2, 16);
                case 304:
                    r0 = adds(r0, r3);
                case 306:
                    r3 = lsls(r0, 6);
                case 308:
                    r6 = subs(r3, 1);
                case 310:
                    r3 = sbcs(r3, r6);
                case 312:
                    r0 = lsrs(r0, 26);
                case 314:
                    r0 = orrs(r0, r3);
                case 316:
                    r3 = lsrs(r2, 16);
                case 318:
                    r3 = adds(r3, r4);
                case 320:
                    r3 = lsls(r3, 6);
                case 322:
                    r3 = orrs(r3, r0);
                case 324:
                    r4 = movs(r4, r3);
                case 326:
                    r3 = lsls(r4, 4);
                case 328:
                    if (bpl()) {
                        offset = 574;
                        continue;
                    }
                case 330:
                    r3 = movs(r3, 1);
                case 332:
                    r2 = lsrs(r4, 1);
                case 334:
                    r4 = ands(r4, r3);
                case 336:
                    r4 = orrs(r4, r2);
                case 338:
                    r2 = ldr(sp + 4);
                case 340:
                    r2 = adds(r2, 127);
                case 342:
                    cmp(r2, 0);
                case 344:
                    if (ble()) {
                        offset = 502;
                        continue;
                    }
                case 346:
                    r3 = lsls(r4, 29);
                case 348:
                    if (beq()) {
                        offset = 360;
                        continue;
                    }
                case 350:
                    r3 = movs(r3, 15);
                case 352:
                    r3 = ands(r3, r4);
                case 354:
                    cmp(r3, 4);
                case 356:
                    if (beq()) {
                        offset = 360;
                        continue;
                    }
                case 358:
                    r4 = adds(r4, 4);
                case 360:
                    r3 = lsls(r4, 4);
                case 362:
                    if (bpl()) {
                        offset = 372;
                        continue;
                    }
                case 364:
                    r3 = ldr(__aeabi_fmul + 608);
                case 366:
                    r2 = ldr(sp + 4);
                case 368:
                    r4 = ands(r4, r3);
                case 370:
                    r2 = adds(r2, 128);
                case 372:
                    cmp(r2, 254);
                case 374:
                    if (bgt()) {
                        offset = 242;
                        continue;
                    }
                case 376:
                    r3 = lsls(r4, 6);
                case 378:
                    r3 = lsrs(r3, 9);
                case 380:
                    r2 = uxtb(r2);
                case 382:
                    step();
                    offset = 182;
                    continue;
                case 384:
                    r3 = movs(r3, 12);
                case 386:
                    r10 = mov(r3);
                case 388:
                    r3 = subs(r3, 9);
                case 390:
                    r5 = movs(r5, 255);
                case 392:
                    r11 = mov(r3);
                case 394:
                    step();
                    offset = 54;
                    continue;
                case 396:
                    r0 = movs(r0, r3);
                case 398:
                    bl(this::__clzsi2, __aeabi_fmul + 402 | 1, 402);
                    return;
                case 400:
                    crash(); // error;
                    return;
                case 402:
                    r2 = mov(r9);
                case 404:
                    r3 = subs(r0, 5);
                case 406:
                    r5 = movs(r5, 118);
                case 408:
                    r2 = lsls(r2, r3);
                case 410:
                    r3 = movs(r3, 0);
                case 412:
                    r5 = rsbs(r5);
                case 414:
                    r9 = mov(r2);
                case 416:
                    r5 = subs(r5, r0);
                case 418:
                    r10 = mov(r3);
                case 420:
                    r11 = mov(r3);
                case 422:
                    step();
                    offset = 54;
                    continue;
                case 424:
                    r2 = mov(r10);
                case 426:
                    r3 = movs(r3, 3);
                case 428:
                    r2 = orrs(r2, r3);
                case 430:
                    r10 = mov(r2);
                case 432:
                    r0 = movs(r0, 3);
                case 434:
                    step();
                    offset = 86;
                    continue;
                case 436:
                    r0 = movs(r0, r4);
                case 438:
                    bl(this::__clzsi2, __aeabi_fmul + 442 | 1, 442);
                    return;
                case 440:
                    crash(); // error;
                    return;
                case 442:
                    r3 = subs(r0, 5);
                case 444:
                    r5 = subs(r5, r0);
                case 446:
                    r4 = lsls(r4, r3);
                case 448:
                    r5 = subs(r5, 118);
                case 450:
                    r0 = movs(r0, 0);
                case 452:
                    step();
                    offset = 86;
                    continue;
                case 454:
                    r3 = movs(r3, 128);
                case 456:
                    r7 = movs(r7, 0);
                case 458:
                    r3 = lsls(r3, 15);
                case 460:
                    r2 = movs(r2, 255);
                case 462:
                    step();
                    offset = 182;
                    continue;
                case 464:
                    r2 = mov(r8);
                case 466:
                    step();
                    offset = 162;
                    continue;
                case 468:
                    r4 = mov(r9);
                case 470:
                    r2 = movs(r2, r6);
                case 472:
                    r0 = mov(r11);
                case 474:
                    step();
                    offset = 162;
                    continue;
                case 476:
                    r3 = movs(r3, 128);
                case 478:
                    r2 = mov(r9);
                case 480:
                    r3 = lsls(r3, 15);
                case 482:
                    tst(r2, r3);
                case 484:
                    if (beq()) {
                        offset = 556;
                        continue;
                    }
                case 486:
                    tst(r4, r3);
                case 488:
                    if (bne()) {
                        offset = 556;
                        continue;
                    }
                case 490:
                    r3 = orrs(r3, r4);
                case 492:
                    r3 = lsls(r3, 9);
                case 494:
                    r3 = lsrs(r3, 9);
                case 496:
                    r7 = mov(r8);
                case 498:
                    r2 = movs(r2, 255);
                case 500:
                    step();
                    offset = 182;
                    continue;
                case 502:
                    r3 = movs(r3, 1);
                case 504:
                    r2 = subs(r3, r2);
                case 506:
                    cmp(r2, 27);
                case 508:
                    if (bgt()) {
                        offset = 578;
                        continue;
                    }
                case 510:
                    r3 = movs(r3, r4);
                case 512:
                    r1 = ldr(sp + 4);
                case 514:
                    r3 = lsrs(r3, r2);
                case 516:
                    r1 = adds(r1, 158);
                case 518:
                    r4 = lsls(r4, r1);
                case 520:
                    r2 = movs(r2, r3);
                case 522:
                    r3 = movs(r3, r4);
                case 524:
                    r4 = subs(r3, 1);
                case 526:
                    r3 = sbcs(r3, r4);
                case 528:
                    r3 = orrs(r3, r2);
                case 530:
                    r2 = lsls(r3, 29);
                case 532:
                    if (beq()) {
                        offset = 544;
                        continue;
                    }
                case 534:
                    r2 = movs(r2, 15);
                case 536:
                    r2 = ands(r2, r3);
                case 538:
                    cmp(r2, 4);
                case 540:
                    if (beq()) {
                        offset = 544;
                        continue;
                    }
                case 542:
                    r3 = adds(r3, 4);
                case 544:
                    r2 = lsls(r3, 5);
                case 546:
                    if (bmi()) {
                        offset = 584;
                        continue;
                    }
                case 548:
                    r3 = lsls(r3, 6);
                case 550:
                    r3 = lsrs(r3, 9);
                case 552:
                    r2 = movs(r2, 0);
                case 554:
                    step();
                    offset = 182;
                    continue;
                case 556:
                    r3 = movs(r3, 128);
                case 558:
                    r2 = mov(r9);
                case 560:
                    r3 = lsls(r3, 15);
                case 562:
                    r3 = orrs(r3, r2);
                case 564:
                    r3 = lsls(r3, 9);
                case 566:
                    r3 = lsrs(r3, 9);
                case 568:
                    r7 = movs(r7, r6);
                case 570:
                    r2 = movs(r2, 255);
                case 572:
                    step();
                    offset = 182;
                    continue;
                case 574:
                    str(sp + 4, r5);
                case 576:
                    step();
                    offset = 338;
                    continue;
                case 578:
                    r2 = movs(r2, 0);
                case 580:
                    r3 = movs(r3, 0);
                case 582:
                    step();
                    offset = 182;
                    continue;
                case 584:
                    r2 = movs(r2, 1);
                    r3 = movs(r3, 0);
                    step();
                    offset = 182;
                    continue;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134344540, size=904, name='__aeabi_fsub', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(subsf3.o)', has_indirect=False)
    protected void __aeabi_fsub(int offset) throws Exception
    {
        while (true)
        {
            pc = __aeabi_fsub + offset;
            switch (offset)
            {
                case 0:
                    push(true, r3, r4, r5, r6, r7);
                    r7 = mov(r8);
                    lr = mov(r9);
                    r4 = lsls(r0, 1);
                    r2 = lsrs(r0, 31);
                    push(true, r7);
                    r7 = lsls(r0, 9);
                    r0 = lsls(r1, 9);
                    r0 = lsrs(r0, 9);
                    r12 = mov(r0);
                    r6 = mov(r12);
                    r0 = lsls(r1, 1);
                    r7 = lsrs(r7, 9);
                    r4 = lsrs(r4, 24);
                    r6 = lsls(r6, 3);
                    r5 = movs(r5, r4);
                    r8 = mov(r2);
                    r3 = lsls(r7, 3);
                    r0 = lsrs(r0, 24);
                    r1 = lsrs(r1, 31);
                    r9 = mov(r6);
                    cmp(r0, 255);
                    if (bne()) {
                        offset = 48;
                        continue;
                    }
                case 46:
                    step();
                    offset = 316;
                    continue;
                case 48:
                    r6 = movs(r6, 1);
                    r1 = eors(r1, r6);
                case 52:
                    r6 = subs(r4, r0);
                    cmp(r1, r2);
                    if (beq()) {
                        offset = 234;
                        continue;
                    }
                case 58:
                    cmp(r6, 0);
                    if (ble()) {
                        offset = 198;
                        continue;
                    }
                case 62:
                    cmp(r0, 0);
                    if (beq()) {
                        offset = 68;
                        continue;
                    }
                case 66:
                    step();
                    offset = 324;
                    continue;
                case 68:
                    r1 = mov(r9);
                    cmp(r1, 0);
                    if (bne()) {
                        offset = 76;
                        continue;
                    }
                case 74:
                    step();
                    offset = 418;
                    continue;
                case 76:
                    r6 = subs(r6, 1);
                    cmp(r6, 0);
                    if (beq()) {
                        offset = 84;
                        continue;
                    }
                case 82:
                    step();
                    offset = 580;
                    continue;
                case 84:
                    r3 = subs(r3, r1);
                case 86:
                    r2 = lsls(r3, 5);
                    if (bmi()) {
                        offset = 92;
                        continue;
                    }
                case 90:
                    step();
                    offset = 372;
                    continue;
                case 92:
                    r3 = lsls(r3, 6);
                    r4 = lsrs(r3, 6);
                case 96:
                    r0 = movs(r0, r4);
                    bl(this::__clzsi2, __aeabi_fsub + 102 | 1, 102);
                    return;
                case 102:
                    r0 = subs(r0, 5);
                    r4 = lsls(r4, r0);
                    cmp(r5, r0);
                    if (ble()) {
                        offset = 112;
                        continue;
                    }
                case 110:
                    step();
                    offset = 536;
                    continue;
                case 112:
                    r5 = subs(r0, r5);
                    r3 = movs(r3, r4);
                    r0 = movs(r0, 32);
                    r5 = adds(r5, 1);
                    r3 = lsrs(r3, r5);
                    r5 = subs(r0, r5);
                    r4 = lsls(r4, r5);
                    r2 = subs(r4, 1);
                    r4 = sbcs(r4, r2);
                    r3 = orrs(r3, r4);
                    r4 = movs(r4, 7);
                    r5 = movs(r5, 0);
                    r4 = ands(r4, r3);
                case 138:
                    r2 = movs(r2, 1);
                    r1 = mov(r8);
                    r2 = ands(r2, r1);
                    cmp(r4, 0);
                    if (beq()) {
                        offset = 158;
                        continue;
                    }
                case 148:
                    r1 = movs(r1, 15);
                    r1 = ands(r1, r3);
                    cmp(r1, 4);
                    if (beq()) {
                        offset = 158;
                        continue;
                    }
                case 156:
                    r3 = adds(r3, 4);
                case 158:
                    r1 = lsls(r3, 5);
                    if (bmi()) {
                        offset = 164;
                        continue;
                    }
                case 162:
                    step();
                    offset = 422;
                    continue;
                case 164:
                    r5 = adds(r5, 1);
                    r4 = uxtb(r5);
                    cmp(r5, 255);
                    if (beq()) {
                        offset = 174;
                        continue;
                    }
                case 172:
                    step();
                    offset = 502;
                    continue;
                case 174:
                    r4 = movs(r4, 255);
                    r3 = movs(r3, 0);
                case 178:
                    r3 = lsls(r3, 9);
                    r4 = lsls(r4, 23);
                    r0 = lsrs(r3, 9);
                    r2 = lsls(r2, 31);
                    r0 = orrs(r0, r4);
                    r0 = orrs(r0, r2);
                    pop(false, R2, R3);
                    r8 = mov(r2);
                    r9 = mov(r3);
                    pop(true, R3, R4, R5, R6, R7);
                    return;
                case 198:
                    cmp(r6, 0);
                    if (bne()) {
                        offset = 436;
                        continue;
                    }
                case 202:
                    r0 = adds(r4, 1);
                    r0 = uxtb(r0);
                    cmp(r0, 1);
                    if (bgt()) {
                        offset = 212;
                        continue;
                    }
                case 210:
                    step();
                    offset = 548;
                    continue;
                case 212:
                    r2 = mov(r9);
                    r4 = subs(r3, r2);
                    r2 = lsls(r4, 5);
                    if (bpl()) {
                        offset = 222;
                        continue;
                    }
                case 220:
                    step();
                    offset = 588;
                    continue;
                case 222:
                    cmp(r4, 0);
                    if (bne()) {
                        offset = 96;
                        continue;
                    }
                case 226:
                    r2 = movs(r2, 0);
                    r4 = movs(r4, 0);
                    r3 = movs(r3, 0);
                    step();
                    offset = 178;
                    continue;
                case 234:
                    cmp(r6, 0);
                    if (bgt()) {
                        offset = 240;
                        continue;
                    }
                case 238:
                    step();
                    offset = 508;
                    continue;
                case 240:
                    cmp(r0, 0);
                    if (beq()) {
                        offset = 386;
                        continue;
                    }
                case 244:
                    cmp(r4, 255);
                    if (beq()) {
                        offset = 396;
                        continue;
                    }
                case 248:
                    r2 = movs(r2, 128);
                    r0 = mov(r9);
                    r2 = lsls(r2, 19);
                    r0 = orrs(r0, r2);
                    r9 = mov(r0);
                case 258:
                    r2 = movs(r2, 1);
                    cmp(r6, 27);
                    if (bgt()) {
                        offset = 284;
                        continue;
                    }
                case 264:
                    r0 = movs(r0, 32);
                    r4 = mov(r9);
                    r0 = subs(r0, r6);
                    r4 = lsls(r4, r0);
                    r2 = mov(r9);
                    r0 = movs(r0, r4);
                    r2 = lsrs(r2, r6);
                    r4 = subs(r0, 1);
                    r0 = sbcs(r0, r4);
                    r2 = orrs(r2, r0);
                case 284:
                    r3 = adds(r3, r2);
                case 286:
                    r2 = lsls(r3, 5);
                    if (bpl()) {
                        offset = 372;
                        continue;
                    }
                case 290:
                    r5 = adds(r5, 1);
                    cmp(r5, 255);
                    if (bne()) {
                        offset = 298;
                        continue;
                    }
                case 296:
                    step();
                    offset = 636;
                    continue;
                case 298:
                    r2 = movs(r2, 1);
                    r4 = movs(r4, 7);
                    r1 = ldr(__aeabi_fsub + 896);
                    r2 = ands(r2, r3);
                    r3 = lsrs(r3, 1);
                    r3 = ands(r3, r1);
                    r3 = orrs(r3, r2);
                    r4 = ands(r4, r3);
                    step();
                    offset = 138;
                    continue;
                case 316:
                    cmp(r6, 0);
                    if (beq()) {
                        offset = 322;
                        continue;
                    }
                case 320:
                    step();
                    offset = 52;
                    continue;
                case 322:
                    step();
                    offset = 48;
                    continue;
                case 324:
                    cmp(r4, 255);
                    if (beq()) {
                        offset = 498;
                        continue;
                    }
                case 328:
                    r2 = movs(r2, 128);
                    r1 = mov(r9);
                    r2 = lsls(r2, 19);
                    r1 = orrs(r1, r2);
                    r9 = mov(r1);
                case 338:
                    r2 = movs(r2, 1);
                    cmp(r6, 27);
                    if (bgt()) {
                        offset = 364;
                        continue;
                    }
                case 344:
                    r1 = movs(r1, 32);
                    r0 = mov(r9);
                    r1 = subs(r1, r6);
                    r0 = lsls(r0, r1);
                    r2 = mov(r9);
                    r1 = movs(r1, r0);
                    r2 = lsrs(r2, r6);
                    r0 = subs(r1, 1);
                    r1 = sbcs(r1, r0);
                    r2 = orrs(r2, r1);
                case 364:
                    r3 = subs(r3, r2);
                    r2 = lsls(r3, 5);
                    if (bpl()) {
                        offset = 372;
                        continue;
                    }
                case 370:
                    step();
                    offset = 92;
                    continue;
                case 372:
                    r2 = movs(r2, 1);
                    r1 = mov(r8);
                    r2 = ands(r2, r1);
                    r1 = lsls(r3, 29);
                    if (beq()) {
                        offset = 384;
                        continue;
                    }
                case 382:
                    step();
                    offset = 148;
                    continue;
                case 384:
                    step();
                    offset = 422;
                    continue;
                case 386:
                    r0 = mov(r9);
                    cmp(r0, 0);
                    if (bne()) {
                        offset = 570;
                        continue;
                    }
                case 392:
                    cmp(r4, 255);
                    if (bne()) {
                        offset = 422;
                        continue;
                    }
                case 396:
                    r3 = lsrs(r3, 3);
                case 398:
                    cmp(r3, 0);
                    if (bne()) {
                        offset = 404;
                        continue;
                    }
                case 402:
                    step();
                    offset = 174;
                    continue;
                case 404:
                    r0 = movs(r0, 128);
                    r0 = lsls(r0, 15);
                    r3 = orrs(r3, r0);
                    r3 = lsls(r3, 9);
                    r3 = lsrs(r3, 9);
                    r4 = movs(r4, 255);
                    step();
                    offset = 178;
                    continue;
                case 418:
                    cmp(r4, 255);
                    if (beq()) {
                        offset = 498;
                        continue;
                    }
                case 422:
                    r3 = lsrs(r3, 3);
                    cmp(r5, 255);
                    if (beq()) {
                        offset = 398;
                        continue;
                    }
                case 428:
                    r3 = lsls(r3, 9);
                    r3 = lsrs(r3, 9);
                    r4 = uxtb(r5);
                    step();
                    offset = 178;
                    continue;
                case 436:
                    cmp(r4, 0);
                    if (beq()) {
                        offset = 596;
                        continue;
                    }
                case 440:
                    cmp(r0, 255);
                    if (beq()) {
                        offset = 494;
                        continue;
                    }
                case 444:
                    r4 = movs(r4, 128);
                    r4 = lsls(r4, 19);
                    r2 = rsbs(r6);
                    r3 = orrs(r3, r4);
                case 452:
                    cmp(r2, 27);
                    if (ble()) {
                        offset = 458;
                        continue;
                    }
                case 456:
                    step();
                    offset = 852;
                    continue;
                case 458:
                    r4 = movs(r4, r3);
                    r5 = movs(r5, 32);
                    r4 = lsrs(r4, r2);
                    r2 = subs(r5, r2);
                    r3 = lsls(r3, r2);
                    r2 = subs(r3, 1);
                    r3 = sbcs(r3, r2);
                    r3 = orrs(r3, r4);
                case 474:
                    r2 = mov(r9);
                    r5 = movs(r5, r0);
                    r3 = subs(r2, r3);
                    r8 = mov(r1);
                    step();
                    offset = 86;
                    continue;
                case 484:
                    r2 = adds(r6, 1);
                    if (beq()) {
                        offset = 474;
                        continue;
                    }
                case 488:
                    r2 = mvns(r2, r6);
                    cmp(r0, 255);
                    if (bne()) {
                        offset = 452;
                        continue;
                    }
                case 494:
                    r2 = movs(r2, r1);
                case 496:
                    r3 = mov(r9);
                case 498:
                    r5 = movs(r5, 255);
                    step();
                    offset = 422;
                    continue;
                case 502:
                    r3 = lsls(r3, 6);
                    r3 = lsrs(r3, 9);
                    step();
                    offset = 178;
                    continue;
                case 508:
                    cmp(r6, 0);
                    if (bne()) {
                        offset = 644;
                        continue;
                    }
                case 512:
                    r5 = adds(r4, 1);
                    r1 = uxtb(r5);
                    cmp(r1, 1);
                    if (ble()) {
                        offset = 660;
                        continue;
                    }
                case 520:
                    cmp(r5, 255);
                    if (bne()) {
                        offset = 526;
                        continue;
                    }
                case 524:
                    step();
                    offset = 174;
                    continue;
                case 526:
                    r4 = movs(r4, 7);
                    r3 = add(r3, r9);
                    r3 = lsrs(r3, 1);
                    r4 = ands(r4, r3);
                    step();
                    offset = 138;
                    continue;
                case 536:
                    r2 = movs(r2, 7);
                    r3 = ldr(__aeabi_fsub + 900);
                    r5 = subs(r5, r0);
                    r3 = ands(r3, r4);
                    r4 = ands(r4, r2);
                    step();
                    offset = 138;
                    continue;
                case 548:
                    cmp(r4, 0);
                    if (bne()) {
                        offset = 612;
                        continue;
                    }
                case 552:
                    cmp(r3, 0);
                    if (bne()) {
                        offset = 802;
                        continue;
                    }
                case 556:
                    r3 = mov(r9);
                    cmp(r3, 0);
                    if (bne()) {
                        offset = 564;
                        continue;
                    }
                case 562:
                    step();
                    offset = 856;
                    continue;
                case 564:
                    r2 = movs(r2, r1);
                    r5 = movs(r5, 0);
                    step();
                    offset = 422;
                    continue;
                case 570:
                    r6 = subs(r6, 1);
                    cmp(r6, 0);
                    if (bne()) {
                        offset = 628;
                        continue;
                    }
                case 576:
                    r3 = add(r3, r9);
                    step();
                    offset = 286;
                    continue;
                case 580:
                    cmp(r4, 255);
                    if (bne()) {
                        offset = 338;
                        continue;
                    }
                case 584:
                    r5 = movs(r5, 255);
                    step();
                    offset = 422;
                    continue;
                case 588:
                    r2 = mov(r9);
                    r8 = mov(r1);
                    r4 = subs(r2, r3);
                    step();
                    offset = 96;
                    continue;
                case 596:
                    cmp(r3, 0);
                    if (bne()) {
                        offset = 484;
                        continue;
                    }
                case 600:
                    r2 = movs(r2, r1);
                    cmp(r0, 255);
                    if (beq()) {
                        offset = 496;
                        continue;
                    }
                case 606:
                    r5 = movs(r5, r0);
                    r3 = mov(r9);
                    step();
                    offset = 422;
                    continue;
                case 612:
                    cmp(r3, 0);
                    if (bne()) {
                        offset = 764;
                        continue;
                    }
                case 616:
                    r3 = mov(r9);
                    cmp(r3, 0);
                    if (beq()) {
                        offset = 862;
                        continue;
                    }
                case 622:
                    r2 = movs(r2, r1);
                    r5 = movs(r5, 255);
                    step();
                    offset = 422;
                    continue;
                case 628:
                    cmp(r4, 255);
                    if (beq()) {
                        offset = 634;
                        continue;
                    }
                case 632:
                    step();
                    offset = 258;
                    continue;
                case 634:
                    step();
                    offset = 396;
                    continue;
                case 636:
                    r2 = movs(r2, r1);
                    r4 = movs(r4, 255);
                    r3 = movs(r3, 0);
                    step();
                    offset = 178;
                    continue;
                case 644:
                    cmp(r4, 0);
                    if (bne()) {
                        offset = 692;
                        continue;
                    }
                case 648:
                    cmp(r3, 0);
                    if (bne()) {
                        offset = 828;
                        continue;
                    }
                case 652:
                    cmp(r0, 255);
                    if (bne()) {
                        offset = 606;
                        continue;
                    }
                case 656:
                    r3 = mov(r9);
                    step();
                    offset = 396;
                    continue;
                case 660:
                    cmp(r4, 0);
                    if (bne()) {
                        offset = 730;
                        continue;
                    }
                case 664:
                    cmp(r3, 0);
                    if (beq()) {
                        offset = 844;
                        continue;
                    }
                case 668:
                    r1 = mov(r9);
                    cmp(r1, 0);
                    if (beq()) {
                        offset = 842;
                        continue;
                    }
                case 674:
                    r3 = add(r3, r9);
                    r2 = lsls(r3, 5);
                    if (bpl()) {
                        offset = 890;
                        continue;
                    }
                case 680:
                    r4 = movs(r4, 7);
                    r2 = ldr(__aeabi_fsub + 900);
                    r4 = ands(r4, r3);
                    r5 = movs(r5, 1);
                    r3 = ands(r3, r2);
                    step();
                    offset = 138;
                    continue;
                case 692:
                    cmp(r0, 255);
                    if (beq()) {
                        offset = 656;
                        continue;
                    }
                case 696:
                    r2 = movs(r2, 128);
                    r2 = lsls(r2, 19);
                    r6 = rsbs(r6);
                    r3 = orrs(r3, r2);
                case 704:
                    cmp(r6, 27);
                    if (bgt()) {
                        offset = 876;
                        continue;
                    }
                case 708:
                    r5 = movs(r5, 32);
                    r5 = subs(r5, r6);
                    r2 = movs(r2, r3);
                    r3 = lsls(r3, r5);
                    r2 = lsrs(r2, r6);
                    r4 = subs(r3, 1);
                    r3 = sbcs(r3, r4);
                    r3 = orrs(r3, r2);
                case 724:
                    r3 = add(r3, r9);
                    r5 = movs(r5, r0);
                    step();
                    offset = 286;
                    continue;
                case 730:
                    cmp(r3, 0);
                    if (beq()) {
                        offset = 656;
                        continue;
                    }
                case 734:
                    r1 = mov(r9);
                    cmp(r1, 0);
                    if (bne()) {
                        offset = 742;
                        continue;
                    }
                case 740:
                    step();
                    offset = 396;
                    continue;
                case 742:
                    r1 = movs(r1, 128);
                    r1 = lsls(r1, 15);
                    tst(r7, r1);
                    if (bne()) {
                        offset = 752;
                        continue;
                    }
                case 750:
                    step();
                    offset = 396;
                    continue;
                case 752:
                    r0 = mov(r12);
                    tst(r0, r1);
                    if (beq()) {
                        offset = 760;
                        continue;
                    }
                case 758:
                    step();
                    offset = 396;
                    continue;
                case 760:
                    r3 = mov(r9);
                    step();
                    offset = 396;
                    continue;
                case 764:
                    r0 = mov(r9);
                    r5 = movs(r5, 255);
                    cmp(r0, 0);
                    if (bne()) {
                        offset = 774;
                        continue;
                    }
                case 772:
                    step();
                    offset = 422;
                    continue;
                case 774:
                    r2 = movs(r2, 128);
                    r2 = lsls(r2, 15);
                    tst(r7, r2);
                    if (beq()) {
                        offset = 792;
                        continue;
                    }
                case 782:
                    r0 = mov(r12);
                    tst(r0, r2);
                    if (bne()) {
                        offset = 792;
                        continue;
                    }
                case 788:
                    r3 = mov(r9);
                    r8 = mov(r1);
                case 792:
                    r2 = movs(r2, 1);
                    r1 = mov(r8);
                    r5 = movs(r5, 255);
                    r2 = ands(r2, r1);
                    step();
                    offset = 422;
                    continue;
                case 802:
                    r0 = mov(r9);
                    cmp(r0, 0);
                    if (beq()) {
                        offset = 872;
                        continue;
                    }
                case 808:
                    r2 = subs(r3, r0);
                    r0 = lsls(r2, 5);
                    if (bpl()) {
                        offset = 880;
                        continue;
                    }
                case 814:
                    r2 = mov(r9);
                    r4 = movs(r4, 7);
                    r3 = subs(r2, r3);
                    r4 = ands(r4, r3);
                    r8 = mov(r1);
                    r5 = movs(r5, 0);
                    step();
                    offset = 138;
                    continue;
                case 828:
                    r4 = adds(r6, 1);
                    if (beq()) {
                        offset = 724;
                        continue;
                    }
                case 832:
                    r6 = mvns(r6, r6);
                    cmp(r0, 255);
                    if (bne()) {
                        offset = 704;
                        continue;
                    }
                case 838:
                    r3 = mov(r9);
                    step();
                    offset = 396;
                    continue;
                case 842:
                    r9 = mov(r3);
                case 844:
                    r3 = mov(r9);
                    r5 = movs(r5, 0);
                    r3 = lsrs(r3, 3);
                    step();
                    offset = 428;
                    continue;
                case 852:
                    r3 = movs(r3, 1);
                    step();
                    offset = 474;
                    continue;
                case 856:
                    r2 = movs(r2, 0);
                    r3 = movs(r3, 0);
                    step();
                    offset = 178;
                    continue;
                case 862:
                    r3 = movs(r3, 128);
                    r2 = movs(r2, 0);
                    r3 = lsls(r3, 15);
                    r4 = movs(r4, 255);
                    step();
                    offset = 178;
                    continue;
                case 872:
                    r5 = movs(r5, 0);
                    step();
                    offset = 422;
                    continue;
                case 876:
                    r3 = movs(r3, 1);
                    step();
                    offset = 724;
                    continue;
                case 880:
                    cmp(r2, 0);
                    if (beq()) {
                        offset = 856;
                        continue;
                    }
                case 884:
                    r3 = movs(r3, r2);
                    r5 = movs(r5, 0);
                    step();
                    offset = 372;
                    continue;
                case 890:
                    r5 = movs(r5, 0);
                    step();
                    offset = 372;
                    continue;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134345444, size=44, name='__aeabi_fcmpun', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(unordsf2.o)', has_indirect=False)
    protected void __aeabi_fcmpun(int offset) throws Exception
    {
        while (true)
        {
            pc = __aeabi_fcmpun + offset;
            switch (offset)
            {
                case 0:
                    r2 = lsls(r0, 9);
                    r3 = lsls(r1, 9);
                    r0 = lsls(r0, 1);
                    r1 = lsls(r1, 1);
                    r2 = lsrs(r2, 9);
                    r3 = lsrs(r3, 9);
                    r1 = lsrs(r1, 24);
                    r0 = lsrs(r0, 24);
                    cmp(r0, 255);
                    if (beq()) {
                        offset = 34;
                        continue;
                    }
                case 20:
                    r0 = movs(r0, 0);
                    cmp(r1, 255);
                    if (bne()) {
                        offset = 32;
                        continue;
                    }
                case 26:
                    r0 = movs(r0, r3);
                    r3 = subs(r0, 1);
                    r0 = sbcs(r0, r3);
                case 32:
                    bx(lr);
                    return;
                case 34:
                    r0 = subs(r0, 254);
                    cmp(r2, 0);
                    if (bne()) {
                        offset = 32;
                        continue;
                    }
                case 40:
                    step();
                    offset = 20;
                    continue;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134345488, size=64, name='__aeabi_f2iz', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(fixsfsi.o)', has_indirect=False)
    protected void __aeabi_f2iz(int offset) throws Exception
    {
        while (true)
        {
            pc = __aeabi_f2iz + offset;
            switch (offset)
            {
                case 0:
                    r1 = lsls(r0, 9);
                    r2 = lsls(r0, 1);
                    r3 = lsrs(r0, 31);
                    r1 = lsrs(r1, 9);
                    r2 = lsrs(r2, 24);
                    r0 = movs(r0, 0);
                    cmp(r2, 126);
                    if (bls()) {
                        offset = 44;
                        continue;
                    }
                case 16:
                    cmp(r2, 157);
                    if (bhi()) {
                        offset = 46;
                        continue;
                    }
                case 20:
                    r0 = movs(r0, 128);
                    r0 = lsls(r0, 16);
                    r1 = orrs(r1, r0);
                    cmp(r2, 149);
                    if (bgt()) {
                        offset = 52;
                        continue;
                    }
                case 30:
                    r0 = movs(r0, 150);
                    r2 = subs(r0, r2);
                    r1 = lsrs(r1, r2);
                case 36:
                    r0 = rsbs(r1);
                    cmp(r3, 0);
                    if (bne()) {
                        offset = 44;
                        continue;
                    }
                case 42:
                    r0 = movs(r0, r1);
                case 44:
                    bx(lr);
                    return;
                case 46:
                    r2 = ldr(__aeabi_f2iz + 60);
                    r0 = adds(r3, r2);
                    step();
                    offset = 44;
                    continue;
                case 52:
                    r2 = subs(r2, 150);
                    r1 = lsls(r1, r2);
                    step();
                    offset = 36;
                    continue;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134345552, size=148, name='__aeabi_i2f', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(floatsisf.o)', has_indirect=False)
    protected void __aeabi_i2f(int offset) throws Exception
    {
        while (true)
        {
            pc = __aeabi_i2f + offset;
            switch (offset)
            {
                case 0:
                    push(true, r4, r5, r6);
                    cmp(r0, 0);
                    if (beq()) {
                        offset = 130;
                        continue;
                    }
                case 6:
                    r3 = asrs(r0, 31);
                    r5 = adds(r0, r3);
                    r5 = eors(r5, r3);
                    r4 = lsrs(r0, 31);
                    r0 = movs(r0, r5);
                    bl(this::__clzsi2, __aeabi_i2f + 20 | 1, 20);
                    return;
                case 20:
                    r2 = movs(r2, 158);
                    r2 = subs(r2, r0);
                    cmp(r2, 150);
                    if (bgt()) {
                        offset = 44;
                        continue;
                    }
                case 28:
                    r2 = uxtb(r2);
                    cmp(r0, 8);
                    if (ble()) {
                        offset = 138;
                        continue;
                    }
                case 34:
                    r0 = subs(r0, 8);
                    r5 = lsls(r5, r0);
                    r0 = lsls(r5, 9);
                    r0 = lsrs(r0, 9);
                    step();
                    offset = 116;
                    continue;
                case 44:
                    cmp(r2, 153);
                    if (ble()) {
                        offset = 72;
                        continue;
                    }
                case 48:
                    r3 = movs(r3, 5);
                    r1 = movs(r1, r5);
                    r3 = subs(r3, r0);
                    r1 = lsrs(r1, r3);
                    r3 = movs(r3, r0);
                    r3 = adds(r3, 27);
                    r5 = lsls(r5, r3);
                    r3 = movs(r3, r5);
                    r5 = subs(r3, 1);
                    r3 = sbcs(r3, r5);
                    r1 = orrs(r1, r3);
                    r5 = movs(r5, r1);
                case 72:
                    cmp(r0, 5);
                    if (ble()) {
                        offset = 80;
                        continue;
                    }
                case 76:
                    r3 = subs(r0, 5);
                    r5 = lsls(r5, r3);
                case 80:
                    r3 = movs(r3, r5);
                    r1 = ldr(__aeabi_i2f + 144);
                    r3 = ands(r3, r1);
                    r6 = lsls(r5, 29);
                    if (beq()) {
                        offset = 110;
                        continue;
                    }
                case 90:
                    r6 = movs(r6, 15);
                    r5 = ands(r5, r6);
                    cmp(r5, 4);
                    if (beq()) {
                        offset = 110;
                        continue;
                    }
                case 98:
                    r3 = adds(r3, 4);
                    r5 = lsls(r3, 5);
                    if (bpl()) {
                        offset = 110;
                        continue;
                    }
                case 104:
                    r2 = movs(r2, 159);
                    r3 = ands(r3, r1);
                    r2 = subs(r2, r0);
                case 110:
                    r3 = lsls(r3, 6);
                    r0 = lsrs(r3, 9);
                    r2 = uxtb(r2);
                case 116:
                    r0 = lsls(r0, 9);
                    r2 = lsls(r2, 23);
                    r0 = lsrs(r0, 9);
                    r4 = lsls(r4, 31);
                    r0 = orrs(r0, r2);
                    r0 = orrs(r0, r4);
                    pop(true, R4, R5, R6);
                    return;
                case 130:
                    r4 = movs(r4, 0);
                    r2 = movs(r2, 0);
                    r0 = movs(r0, 0);
                    step();
                    offset = 116;
                    continue;
                case 138:
                    r0 = lsls(r5, 9);
                    r0 = lsrs(r0, 9);
                    step();
                    offset = 116;
                    continue;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134345700, size=128, name='__aeabi_ui2f', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(floatunsisf.o)', has_indirect=False)
    protected void __aeabi_ui2f(int offset) throws Exception
    {
        while (true)
        {
            pc = __aeabi_ui2f + offset;
            switch (offset)
            {
                case 0:
                    push(true, r4, r5, r6);
                    r4 = subs(r0, 0);
                    if (beq()) {
                        offset = 112;
                        continue;
                    }
                case 6:
                    bl(this::__clzsi2, __aeabi_ui2f + 10 | 1, 10);
                    return;
                case 10:
                    r2 = movs(r2, 158);
                    r2 = subs(r2, r0);
                    cmp(r2, 150);
                    if (bgt()) {
                        offset = 34;
                        continue;
                    }
                case 18:
                    r2 = uxtb(r2);
                    cmp(r0, 8);
                    if (ble()) {
                        offset = 118;
                        continue;
                    }
                case 24:
                    r0 = subs(r0, 8);
                    r4 = lsls(r4, r0);
                    r0 = lsls(r4, 9);
                    r0 = lsrs(r0, 9);
                    step();
                    offset = 102;
                    continue;
                case 34:
                    cmp(r2, 153);
                    if (ble()) {
                        offset = 58;
                        continue;
                    }
                case 38:
                    r3 = movs(r3, r0);
                    r1 = movs(r1, r4);
                    r3 = adds(r3, 27);
                    r1 = lsls(r1, r3);
                    r3 = subs(r1, 1);
                    r1 = sbcs(r1, r3);
                    r3 = movs(r3, 5);
                    r3 = subs(r3, r0);
                    r4 = lsrs(r4, r3);
                    r4 = orrs(r4, r1);
                case 58:
                    cmp(r0, 5);
                    if (ble()) {
                        offset = 66;
                        continue;
                    }
                case 62:
                    r3 = subs(r0, 5);
                    r4 = lsls(r4, r3);
                case 66:
                    r3 = movs(r3, r4);
                    r1 = ldr(__aeabi_ui2f + 124);
                    r3 = ands(r3, r1);
                    r5 = lsls(r4, 29);
                    if (beq()) {
                        offset = 96;
                        continue;
                    }
                case 76:
                    r5 = movs(r5, 15);
                    r4 = ands(r4, r5);
                    cmp(r4, 4);
                    if (beq()) {
                        offset = 96;
                        continue;
                    }
                case 84:
                    r3 = adds(r3, 4);
                    r4 = lsls(r3, 5);
                    if (bpl()) {
                        offset = 96;
                        continue;
                    }
                case 90:
                    r2 = movs(r2, 159);
                    r3 = ands(r3, r1);
                    r2 = subs(r2, r0);
                case 96:
                    r3 = lsls(r3, 6);
                    r0 = lsrs(r3, 9);
                    r2 = uxtb(r2);
                case 102:
                    r0 = lsls(r0, 9);
                    r2 = lsls(r2, 23);
                    r0 = lsrs(r0, 9);
                    r0 = orrs(r0, r2);
                    pop(true, R4, R5, R6);
                    return;
                case 112:
                    r2 = movs(r2, 0);
                    r0 = movs(r0, 0);
                    step();
                    offset = 102;
                    continue;
                case 118:
                    r0 = lsls(r4, 9);
                    r0 = lsrs(r0, 9);
                    step();
                    offset = 102;
                    continue;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134345828, size=116, name='__aeabi_i2d', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(floatsidf.o)', has_indirect=False)
    protected void __aeabi_i2d(int offset) throws Exception
    {
        while (true)
        {
            pc = __aeabi_i2d + offset;
            switch (offset)
            {
                case 0:
                    push(true, r4, r5, r6);
                    cmp(r0, 0);
                    if (beq()) {
                        offset = 98;
                        continue;
                    }
                case 6:
                    r3 = asrs(r0, 31);
                    r5 = adds(r0, r3);
                    r5 = eors(r5, r3);
                    r4 = lsrs(r0, 31);
                    r0 = movs(r0, r5);
                    bl(this::__clzsi2, __aeabi_i2d + 20 | 1, 20);
                    return;
                case 20:
                    r3 = ldr(__aeabi_i2d + 108);
                    r3 = subs(r3, r0);
                    r3 = lsls(r3, 21);
                    r3 = lsrs(r3, 21);
                    cmp(r0, 10);
                    if (ble()) {
                        offset = 76;
                        continue;
                    }
                case 32:
                    r0 = subs(r0, 11);
                    r5 = lsls(r5, r0);
                    r2 = movs(r2, 0);
                    r5 = lsls(r5, 12);
                    r5 = lsrs(r5, 12);
                case 42:
                    r1 = movs(r1, 0);
                    r0 = movs(r0, r2);
                    r5 = lsls(r5, 12);
                    r2 = lsrs(r1, 20);
                    r5 = lsrs(r5, 12);
                    r2 = lsls(r2, 20);
                    r2 = orrs(r2, r5);
                    r5 = ldr(__aeabi_i2d + 112);
                    r3 = lsls(r3, 20);
                    r2 = ands(r2, r5);
                    r3 = orrs(r3, r2);
                    r3 = lsls(r3, 1);
                    r4 = lsls(r4, 31);
                    r3 = lsrs(r3, 1);
                    r3 = orrs(r3, r4);
                    r1 = movs(r1, r3);
                    pop(true, R4, R5, R6);
                    return;
                case 76:
                    r2 = movs(r2, r0);
                    r1 = movs(r1, r5);
                    r2 = adds(r2, 21);
                    r1 = lsls(r1, r2);
                    r2 = movs(r2, r1);
                    r1 = movs(r1, 11);
                    r0 = subs(r1, r0);
                    r5 = lsrs(r5, r0);
                    r5 = lsls(r5, 12);
                    r5 = lsrs(r5, 12);
                    step();
                    offset = 42;
                    continue;
                case 98:
                    r4 = movs(r4, 0);
                    r3 = movs(r3, 0);
                    r5 = movs(r5, 0);
                    r2 = movs(r2, 0);
                    step();
                    offset = 42;
                    continue;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134345944, size=164, name='__aeabi_f2d', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(extendsfdf2.o)', has_indirect=False)
    protected void __aeabi_f2d(int offset) throws Exception
    {
        while (true)
        {
            pc = __aeabi_f2d + offset;
            switch (offset)
            {
                case 0:
                    r1 = lsls(r0, 1);
                    r1 = lsrs(r1, 24);
                    r3 = adds(r1, 1);
                    push(true, r4, r5, r6);
                    r3 = uxtb(r3);
                    r6 = lsls(r0, 9);
                    r5 = lsrs(r6, 9);
                    r4 = lsrs(r0, 31);
                    cmp(r3, 1);
                    if (ble()) {
                        offset = 62;
                        continue;
                    }
                case 20:
                    r3 = movs(r3, 224);
                    r3 = lsls(r3, 2);
                    r5 = lsls(r5, 29);
                    r6 = lsrs(r6, 12);
                    r3 = adds(r1, r3);
                case 30:
                    r1 = movs(r1, 0);
                    r2 = lsrs(r1, 20);
                    r0 = movs(r0, r5);
                    r2 = lsls(r2, 20);
                    r5 = ldr(__aeabi_f2d + 152);
                    r2 = orrs(r2, r6);
                    r3 = lsls(r3, 21);
                    r2 = ands(r2, r5);
                    r3 = lsrs(r3, 1);
                    r3 = orrs(r3, r2);
                    r3 = lsls(r3, 1);
                    r4 = lsls(r4, 31);
                    r3 = lsrs(r3, 1);
                    r3 = orrs(r3, r4);
                    r1 = movs(r1, r3);
                    pop(true, R4, R5, R6);
                    return;
                case 62:
                    cmp(r1, 0);
                    if (bne()) {
                        offset = 108;
                        continue;
                    }
                case 66:
                    cmp(r5, 0);
                    if (beq()) {
                        offset = 132;
                        continue;
                    }
                case 70:
                    r0 = movs(r0, r5);
                    bl(this::__clzsi2, __aeabi_f2d + 76 | 1, 76);
                    return;
                case 76:
                    cmp(r0, 10);
                    if (bgt()) {
                        offset = 138;
                        continue;
                    }
                case 80:
                    r3 = movs(r3, 11);
                    r2 = movs(r2, r5);
                    r3 = subs(r3, r0);
                    r2 = lsrs(r2, r3);
                    r3 = movs(r3, r0);
                    r3 = adds(r3, 21);
                    r5 = lsls(r5, r3);
                case 94:
                    r3 = ldr(__aeabi_f2d + 156);
                    r2 = lsls(r2, 12);
                    r3 = subs(r3, r0);
                    r3 = lsls(r3, 21);
                    r6 = lsrs(r2, 12);
                    r3 = lsrs(r3, 21);
                    step();
                    offset = 30;
                    continue;
                case 108:
                    cmp(r5, 0);
                    if (beq()) {
                        offset = 126;
                        continue;
                    }
                case 112:
                    r2 = lsrs(r6, 12);
                    r6 = movs(r6, 128);
                    r6 = lsls(r6, 12);
                    r5 = lsls(r5, 29);
                    r6 = orrs(r6, r2);
                    r3 = ldr(__aeabi_f2d + 160);
                    step();
                    offset = 30;
                    continue;
                case 126:
                    r3 = ldr(__aeabi_f2d + 160);
                    r6 = movs(r6, 0);
                    step();
                    offset = 30;
                    continue;
                case 132:
                    r3 = movs(r3, 0);
                    r6 = movs(r6, 0);
                    step();
                    offset = 30;
                    continue;
                case 138:
                    r3 = movs(r3, r0);
                    r2 = movs(r2, r5);
                    r3 = subs(r3, 11);
                    r2 = lsls(r2, r3);
                    r5 = movs(r5, 0);
                    step();
                    offset = 94;
                    continue;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134346108, size=264, name='__aeabi_d2f', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(truncdfsf2.o)', has_indirect=False)
    protected void __aeabi_d2f(int offset) throws Exception
    {
        while (true)
        {
            pc = __aeabi_d2f + offset;
            switch (offset)
            {
                case 0:
                    push(true, r4, r5, r6, r7);
                    r4 = lsls(r1, 1);
                    r4 = lsrs(r4, 21);
                    r3 = lsls(r1, 12);
                    r2 = adds(r4, 1);
                    r3 = lsrs(r3, 9);
                    r6 = lsrs(r0, 29);
                    r2 = lsls(r2, 21);
                    r1 = lsrs(r1, 31);
                    r6 = orrs(r6, r3);
                    r5 = lsls(r0, 3);
                    r2 = lsrs(r2, 21);
                    cmp(r2, 1);
                    if (ble()) {
                        offset = 112;
                        continue;
                    }
                case 28:
                    r3 = ldr(__aeabi_d2f + 252);
                    r7 = adds(r4, r3);
                    cmp(r7, 254);
                    if (bgt()) {
                        offset = 94;
                        continue;
                    }
                case 36:
                    cmp(r7, 0);
                    if (ble()) {
                        offset = 160;
                        continue;
                    }
                case 40:
                    r0 = lsls(r0, 6);
                    r3 = subs(r0, 1);
                    r0 = sbcs(r0, r3);
                    r2 = movs(r2, 7);
                    r3 = lsls(r6, 3);
                    r5 = lsrs(r5, 29);
                    r3 = orrs(r3, r0);
                    r3 = orrs(r3, r5);
                    r2 = ands(r2, r3);
                case 58:
                    cmp(r2, 0);
                    if (beq()) {
                        offset = 72;
                        continue;
                    }
                case 62:
                    r2 = movs(r2, 15);
                    r2 = ands(r2, r3);
                    cmp(r2, 4);
                    if (beq()) {
                        offset = 72;
                        continue;
                    }
                case 70:
                    r3 = adds(r3, 4);
                case 72:
                    r2 = movs(r2, 128);
                    r2 = lsls(r2, 19);
                    r2 = ands(r2, r3);
                    if (beq()) {
                        offset = 154;
                        continue;
                    }
                case 80:
                    r7 = adds(r7, 1);
                    r2 = uxtb(r7);
                    cmp(r7, 255);
                    if (beq()) {
                        offset = 94;
                        continue;
                    }
                case 88:
                    r3 = lsls(r3, 6);
                    r0 = lsrs(r3, 9);
                    step();
                    offset = 98;
                    continue;
                case 94:
                    r2 = movs(r2, 255);
                    r0 = movs(r0, 0);
                case 98:
                    r0 = lsls(r0, 9);
                    r2 = lsls(r2, 23);
                    r0 = lsrs(r0, 9);
                    r1 = lsls(r1, 31);
                    r0 = orrs(r0, r2);
                    r0 = orrs(r0, r1);
                    pop(true, R4, R5, R6, R7);
                    return;
                case 112:
                    r5 = orrs(r5, r6);
                    cmp(r4, 0);
                    if (bne()) {
                        offset = 128;
                        continue;
                    }
                case 118:
                    cmp(r5, 0);
                    if (bne()) {
                        offset = 144;
                        continue;
                    }
                case 122:
                    r2 = movs(r2, 0);
                    r0 = movs(r0, 0);
                    step();
                    offset = 98;
                    continue;
                case 128:
                    cmp(r5, 0);
                    if (beq()) {
                        offset = 94;
                        continue;
                    }
                case 132:
                    r0 = movs(r0, 128);
                    r0 = lsls(r0, 15);
                    r0 = orrs(r0, r6);
                    r2 = movs(r2, 255);
                    step();
                    offset = 98;
                    continue;
                case 142:
                    r4 = movs(r4, 0);
                case 144:
                    r3 = movs(r3, 0);
                case 146:
                    r3 = lsls(r3, 9);
                    r0 = lsrs(r3, 9);
                    r2 = uxtb(r4);
                    step();
                    offset = 98;
                    continue;
                case 154:
                    r3 = lsrs(r3, 3);
                    r4 = movs(r4, r7);
                    step();
                    offset = 146;
                    continue;
                case 160:
                    r3 = movs(r3, r7);
                    r3 = adds(r3, 23);
                    if (blt()) {
                        offset = 142;
                        continue;
                    }
                case 166:
                    r3 = movs(r3, 128);
                    r3 = lsls(r3, 16);
                    r3 = orrs(r3, r6);
                    r6 = movs(r6, 30);
                    r6 = subs(r6, r7);
                    cmp(r6, 31);
                    if (ble()) {
                        offset = 222;
                        continue;
                    }
                case 180:
                    r2 = movs(r2, 2);
                    r2 = rsbs(r2);
                    r7 = subs(r2, r7);
                    r2 = movs(r2, r3);
                    r2 = lsrs(r2, r7);
                    r7 = movs(r7, r2);
                    cmp(r6, 32);
                    if (beq()) {
                        offset = 206;
                        continue;
                    }
                case 196:
                    r2 = ldr(__aeabi_d2f + 256);
                    r12 = mov(r2);
                    r4 = add(r4, r12);
                    r3 = lsls(r3, r4);
                    r5 = orrs(r5, r3);
                case 206:
                    r3 = movs(r3, r5);
                    r5 = subs(r3, 1);
                    r3 = sbcs(r3, r5);
                    r2 = movs(r2, 7);
                    r3 = orrs(r3, r7);
                    r2 = ands(r2, r3);
                    r7 = movs(r7, 0);
                    step();
                    offset = 58;
                    continue;
                case 222:
                    r2 = ldr(__aeabi_d2f + 260);
                    r0 = movs(r0, r5);
                    r2 = adds(r4, r2);
                    r5 = lsls(r5, r2);
                    r3 = lsls(r3, r2);
                    r4 = subs(r5, 1);
                    r5 = sbcs(r5, r4);
                    r0 = lsrs(r0, r6);
                    r2 = movs(r2, 7);
                    r3 = orrs(r3, r5);
                    r3 = orrs(r3, r0);
                    r2 = ands(r2, r3);
                    r7 = movs(r7, 0);
                    step();
                    offset = 58;
                    continue;
                default:
                    crash();
            }
        }
    }

    // function: Function(address=134346372, size=60, name='__clzsi2', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(_clzsi2.o)', has_indirect=False)
    protected void __clzsi2(int offset) throws Exception
    {
        while (true)
        {
            pc = __clzsi2 + offset;
            switch (offset)
            {
                case 0:
                    r1 = movs(r1, 28);
                    r3 = movs(r3, 1);
                    r3 = lsls(r3, 16);
                    cmp(r0, r3);
                    if (blo()) {
                        offset = 14;
                        continue;
                    }
                case 10:
                    r0 = lsrs(r0, 16);
                    r1 = subs(r1, 16);
                case 14:
                    r3 = lsrs(r3, 8);
                    cmp(r0, r3);
                    if (blo()) {
                        offset = 24;
                        continue;
                    }
                case 20:
                    r0 = lsrs(r0, 8);
                    r1 = subs(r1, 8);
                case 24:
                    r3 = lsrs(r3, 4);
                    cmp(r0, r3);
                    if (blo()) {
                        offset = 34;
                        continue;
                    }
                case 30:
                    r0 = lsrs(r0, 4);
                    r1 = subs(r1, 4);
                case 34:
                    r2 = add(pc, 10); // pc + 8;
                    r0 = ldrb(r2 + r0);
                    r0 = adds(r0, r1);
                    bx(lr);
                    return;
                default:
                    crash();
            }
        }
    }

} // MicroPython_system
