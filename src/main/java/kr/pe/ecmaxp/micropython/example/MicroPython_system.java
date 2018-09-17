package kr.pe.ecmaxp.micropython.example;

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

    // function: Function(address=134341656, size=276, name='__aeabi_uidiv', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(_udivsi3.o)', has_indirect=False)
    protected void __aeabi_uidiv(int offset) throws Exception
    {
        pc = __aeabi_uidiv + offset;
        switch (offset)
        {
            case 0:
                r2 = movs(r2, 0);
                r3 = lsrs(r0, 1);
                cmp(r3, r1);
                if (blo(242)) return;
            case 8:
                r3 = lsrs(r0, 4);
                cmp(r3, r1);
                if (blo(206)) return;
            case 14:
                r3 = lsrs(r0, 8);
                cmp(r3, r1);
                if (blo(158)) return;
            case 20:
                r3 = lsrs(r0, 12);
                cmp(r3, r1);
                if (blo(108)) return;
            case 26:
                r3 = lsrs(r0, 16);
                cmp(r3, r1);
                if (blo(60)) return;
            case 32:
                r2 = movs(r2, 255);
                r1 = lsls(r1, 8);
                r2 = rev(r2);
                r3 = lsrs(r0, 16);
                cmp(r3, r1);
                if (blo(50)) return;
            case 44:
                r2 = asrs(r2, 8);
                r1 = lsls(r1, 8);
                if (beq(254)) return;
            case 50:
                r3 = lsrs(r0, 12);
                cmp(r3, r1);
                if (blo(108)) return;
            case 56:
                b(null, 60);
                return;
            case 58:
                r1 = lsrs(r1, 8);
            case 60:
                r3 = lsrs(r0, 15);
                cmp(r3, r1);
                if (blo(70)) return;
            case 66:
                r3 = lsls(r1, 15);
                r0 = subs(r0, r3);
            case 70:
                r2 = adcs(r2, r2);
                r3 = lsrs(r0, 14);
                cmp(r3, r1);
                if (blo(82)) return;
            case 78:
                r3 = lsls(r1, 14);
                r0 = subs(r0, r3);
            case 82:
                r2 = adcs(r2, r2);
                r3 = lsrs(r0, 13);
                cmp(r3, r1);
                if (blo(94)) return;
            case 90:
                r3 = lsls(r1, 13);
                r0 = subs(r0, r3);
            case 94:
                r2 = adcs(r2, r2);
                r3 = lsrs(r0, 12);
                cmp(r3, r1);
                if (blo(106)) return;
            case 102:
                r3 = lsls(r1, 12);
                r0 = subs(r0, r3);
            case 106:
                r2 = adcs(r2, r2);
            case 108:
                r3 = lsrs(r0, 11);
                cmp(r3, r1);
                if (blo(118)) return;
            case 114:
                r3 = lsls(r1, 11);
                r0 = subs(r0, r3);
            case 118:
                r2 = adcs(r2, r2);
                r3 = lsrs(r0, 10);
                cmp(r3, r1);
                if (blo(130)) return;
            case 126:
                r3 = lsls(r1, 10);
                r0 = subs(r0, r3);
            case 130:
                r2 = adcs(r2, r2);
                r3 = lsrs(r0, 9);
                cmp(r3, r1);
                if (blo(142)) return;
            case 138:
                r3 = lsls(r1, 9);
                r0 = subs(r0, r3);
            case 142:
                r2 = adcs(r2, r2);
                r3 = lsrs(r0, 8);
                cmp(r3, r1);
                if (blo(154)) return;
            case 150:
                r3 = lsls(r1, 8);
                r0 = subs(r0, r3);
            case 154:
                r2 = adcs(r2, r2);
                if (bhs(58)) return;
            case 158:
                r3 = lsrs(r0, 7);
                cmp(r3, r1);
                if (blo(168)) return;
            case 164:
                r3 = lsls(r1, 7);
                r0 = subs(r0, r3);
            case 168:
                r2 = adcs(r2, r2);
                r3 = lsrs(r0, 6);
                cmp(r3, r1);
                if (blo(180)) return;
            case 176:
                r3 = lsls(r1, 6);
                r0 = subs(r0, r3);
            case 180:
                r2 = adcs(r2, r2);
                r3 = lsrs(r0, 5);
                cmp(r3, r1);
                if (blo(192)) return;
            case 188:
                r3 = lsls(r1, 5);
                r0 = subs(r0, r3);
            case 192:
                r2 = adcs(r2, r2);
                r3 = lsrs(r0, 4);
                cmp(r3, r1);
                if (blo(204)) return;
            case 200:
                r3 = lsls(r1, 4);
                r0 = subs(r0, r3);
            case 204:
                r2 = adcs(r2, r2);
            case 206:
                r3 = lsrs(r0, 3);
                cmp(r3, r1);
                if (blo(216)) return;
            case 212:
                r3 = lsls(r1, 3);
                r0 = subs(r0, r3);
            case 216:
                r2 = adcs(r2, r2);
                r3 = lsrs(r0, 2);
                cmp(r3, r1);
                if (blo(228)) return;
            case 224:
                r3 = lsls(r1, 2);
                r0 = subs(r0, r3);
            case 228:
                r2 = adcs(r2, r2);
                r3 = lsrs(r0, 1);
                cmp(r3, r1);
                if (blo(240)) return;
            case 236:
                r3 = lsls(r1, 1);
                r0 = subs(r0, r3);
            case 240:
                r2 = adcs(r2, r2);
            case 242:
                r1 = subs(r0, r1);
                if (bhs(248)) return;
            case 246:
                r1 = mov(r0);
            case 248:
                r2 = adcs(r2, r2);
                r0 = mov(r2);
                bx(lr);
                return;
            case 254:
                b(null, 256);
                return;
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

    // function: Function(address=134341924, size=8, name='__aeabi_uidivmod', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(_udivsi3.o)', has_indirect=False)
    protected void __aeabi_uidivmod(int offset) throws Exception
    {
        pc = __aeabi_uidivmod + offset;
        switch (offset)
        {
            case 0:
                cmp(r1, 0);
                if (beq(this::__aeabi_uidiv, 256)) return;
            case 4:
                b(this::__aeabi_uidiv);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134341932, size=468, name='__divsi3', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(_divsi3.o)', has_indirect=False)
    protected void __divsi3(int offset) throws Exception
    {
        pc = __divsi3 + offset;
        switch (offset)
        {
            case 0:
                r3 = mov(r0);
                r3 = orrs(r3, r1);
                if (bmi(262)) return;
            case 6:
                r2 = movs(r2, 0);
                r3 = lsrs(r0, 1);
                cmp(r3, r1);
                if (blo(248)) return;
            case 14:
                r3 = lsrs(r0, 4);
                cmp(r3, r1);
                if (blo(212)) return;
            case 20:
                r3 = lsrs(r0, 8);
                cmp(r3, r1);
                if (blo(164)) return;
            case 26:
                r3 = lsrs(r0, 12);
                cmp(r3, r1);
                if (blo(114)) return;
            case 32:
                r3 = lsrs(r0, 16);
                cmp(r3, r1);
                if (blo(66)) return;
            case 38:
                r2 = movs(r2, 255);
                r1 = lsls(r1, 8);
                r2 = rev(r2);
                r3 = lsrs(r0, 16);
                cmp(r3, r1);
                if (blo(56)) return;
            case 50:
                r2 = asrs(r2, 8);
                r1 = lsls(r1, 8);
                if (beq(260)) return;
            case 56:
                r3 = lsrs(r0, 12);
                cmp(r3, r1);
                if (blo(114)) return;
            case 62:
                b(null, 66);
                return;
            case 64:
                r1 = lsrs(r1, 8);
            case 66:
                r3 = lsrs(r0, 15);
                cmp(r3, r1);
                if (blo(76)) return;
            case 72:
                r3 = lsls(r1, 15);
                r0 = subs(r0, r3);
            case 76:
                r2 = adcs(r2, r2);
                r3 = lsrs(r0, 14);
                cmp(r3, r1);
                if (blo(88)) return;
            case 84:
                r3 = lsls(r1, 14);
                r0 = subs(r0, r3);
            case 88:
                r2 = adcs(r2, r2);
                r3 = lsrs(r0, 13);
                cmp(r3, r1);
                if (blo(100)) return;
            case 96:
                r3 = lsls(r1, 13);
                r0 = subs(r0, r3);
            case 100:
                r2 = adcs(r2, r2);
                r3 = lsrs(r0, 12);
                cmp(r3, r1);
                if (blo(112)) return;
            case 108:
                r3 = lsls(r1, 12);
                r0 = subs(r0, r3);
            case 112:
                r2 = adcs(r2, r2);
            case 114:
                r3 = lsrs(r0, 11);
                cmp(r3, r1);
                if (blo(124)) return;
            case 120:
                r3 = lsls(r1, 11);
                r0 = subs(r0, r3);
            case 124:
                r2 = adcs(r2, r2);
                r3 = lsrs(r0, 10);
                cmp(r3, r1);
                if (blo(136)) return;
            case 132:
                r3 = lsls(r1, 10);
                r0 = subs(r0, r3);
            case 136:
                r2 = adcs(r2, r2);
                r3 = lsrs(r0, 9);
                cmp(r3, r1);
                if (blo(148)) return;
            case 144:
                r3 = lsls(r1, 9);
                r0 = subs(r0, r3);
            case 148:
                r2 = adcs(r2, r2);
                r3 = lsrs(r0, 8);
                cmp(r3, r1);
                if (blo(160)) return;
            case 156:
                r3 = lsls(r1, 8);
                r0 = subs(r0, r3);
            case 160:
                r2 = adcs(r2, r2);
                if (bhs(64)) return;
            case 164:
                r3 = lsrs(r0, 7);
                cmp(r3, r1);
                if (blo(174)) return;
            case 170:
                r3 = lsls(r1, 7);
                r0 = subs(r0, r3);
            case 174:
                r2 = adcs(r2, r2);
                r3 = lsrs(r0, 6);
                cmp(r3, r1);
                if (blo(186)) return;
            case 182:
                r3 = lsls(r1, 6);
                r0 = subs(r0, r3);
            case 186:
                r2 = adcs(r2, r2);
                r3 = lsrs(r0, 5);
                cmp(r3, r1);
                if (blo(198)) return;
            case 194:
                r3 = lsls(r1, 5);
                r0 = subs(r0, r3);
            case 198:
                r2 = adcs(r2, r2);
                r3 = lsrs(r0, 4);
                cmp(r3, r1);
                if (blo(210)) return;
            case 206:
                r3 = lsls(r1, 4);
                r0 = subs(r0, r3);
            case 210:
                r2 = adcs(r2, r2);
            case 212:
                r3 = lsrs(r0, 3);
                cmp(r3, r1);
                if (blo(222)) return;
            case 218:
                r3 = lsls(r1, 3);
                r0 = subs(r0, r3);
            case 222:
                r2 = adcs(r2, r2);
                r3 = lsrs(r0, 2);
                cmp(r3, r1);
                if (blo(234)) return;
            case 230:
                r3 = lsls(r1, 2);
                r0 = subs(r0, r3);
            case 234:
                r2 = adcs(r2, r2);
                r3 = lsrs(r0, 1);
                cmp(r3, r1);
                if (blo(246)) return;
            case 242:
                r3 = lsls(r1, 1);
                r0 = subs(r0, r3);
            case 246:
                r2 = adcs(r2, r2);
            case 248:
                r1 = subs(r0, r1);
                if (bhs(254)) return;
            case 252:
                r1 = mov(r0);
            case 254:
                r2 = adcs(r2, r2);
                r0 = mov(r2);
                bx(lr);
                return;
            case 260:
                b(null, 450);
                return;
            case 262:
                r2 = lsrs(r1, 31);
                if (beq(268)) return;
            case 266:
                r1 = rsbs(r1);
            case 268:
                r3 = asrs(r0, 32);
                if (blo(274)) return;
            case 272:
                r0 = rsbs(r0);
            case 274:
                r3 = eors(r3, r2);
                r2 = movs(r2, 0);
                r12 = mov(r3);
                r3 = lsrs(r0, 4);
                cmp(r3, r1);
                if (blo(378)) return;
            case 286:
                r3 = lsrs(r0, 8);
                cmp(r3, r1);
                if (blo(330)) return;
            case 292:
                r2 = movs(r2, 252);
                r1 = lsls(r1, 6);
                r2 = rev(r2);
                r3 = lsrs(r0, 8);
                cmp(r3, r1);
                if (blo(330)) return;
            case 304:
                r1 = lsls(r1, 6);
                r2 = asrs(r2, 6);
                cmp(r3, r1);
                if (blo(330)) return;
            case 312:
                r1 = lsls(r1, 6);
                r2 = asrs(r2, 6);
                cmp(r3, r1);
                if (blo(330)) return;
            case 320:
                r1 = lsls(r1, 6);
                if (beq(442)) return;
            case 324:
                r2 = asrs(r2, 6);
                b(null, 330);
                return;
            case 328:
                r1 = lsrs(r1, 6);
            case 330:
                r3 = lsrs(r0, 7);
                cmp(r3, r1);
                if (blo(340)) return;
            case 336:
                r3 = lsls(r1, 7);
                r0 = subs(r0, r3);
            case 340:
                r2 = adcs(r2, r2);
                r3 = lsrs(r0, 6);
                cmp(r3, r1);
                if (blo(352)) return;
            case 348:
                r3 = lsls(r1, 6);
                r0 = subs(r0, r3);
            case 352:
                r2 = adcs(r2, r2);
                r3 = lsrs(r0, 5);
                cmp(r3, r1);
                if (blo(364)) return;
            case 360:
                r3 = lsls(r1, 5);
                r0 = subs(r0, r3);
            case 364:
                r2 = adcs(r2, r2);
                r3 = lsrs(r0, 4);
                cmp(r3, r1);
                if (blo(376)) return;
            case 372:
                r3 = lsls(r1, 4);
                r0 = subs(r0, r3);
            case 376:
                r2 = adcs(r2, r2);
            case 378:
                r3 = lsrs(r0, 3);
                cmp(r3, r1);
                if (blo(388)) return;
            case 384:
                r3 = lsls(r1, 3);
                r0 = subs(r0, r3);
            case 388:
                r2 = adcs(r2, r2);
                r3 = lsrs(r0, 2);
                cmp(r3, r1);
                if (blo(400)) return;
            case 396:
                r3 = lsls(r1, 2);
                r0 = subs(r0, r3);
            case 400:
                r2 = adcs(r2, r2);
                if (bhs(328)) return;
            case 404:
                r3 = lsrs(r0, 1);
                cmp(r3, r1);
                if (blo(414)) return;
            case 410:
                r3 = lsls(r1, 1);
                r0 = subs(r0, r3);
            case 414:
                r2 = adcs(r2, r2);
                r1 = subs(r0, r1);
                if (bhs(422)) return;
            case 420:
                r1 = mov(r0);
            case 422:
                r3 = mov(r12);
                r2 = adcs(r2, r2);
                r3 = asrs(r3, 1);
                r0 = mov(r2);
                if (blo(436)) return;
            case 432:
                r0 = rsbs(r0);
                cmp(r3, 0);
            case 436:
                if (bpl(440)) return;
            case 438:
                r1 = rsbs(r1);
            case 440:
                bx(lr);
                return;
            case 442:
                r3 = mov(r12);
                r3 = asrs(r3, 1);
                if (blo(450)) return;
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

    // function: Function(address=134342392, size=8, name='__aeabi_idivmod', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(_divsi3.o)', has_indirect=False)
    protected void __aeabi_idivmod(int offset) throws Exception
    {
        pc = __aeabi_idivmod + offset;
        switch (offset)
        {
            case 0:
                cmp(r1, 0);
                if (beq(this::__divsi3, 450)) return;
            case 4:
                b(this::__divsi3);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134342400, size=4, name='__aeabi_idiv0', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(_dvmd_tls.o)', has_indirect=False)
    protected void __aeabi_idiv0(int offset) throws Exception
    {
        assert offset == 0;
        pc = __aeabi_idiv0 + offset;
        bx(lr);
    }

    // function: Function(address=134342404, size=116, name='__aeabi_cfrcmple', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(_arm_cmpsf2.o)', has_indirect=False)
    protected void __aeabi_cfrcmple(int offset) throws Exception
    {
        assert offset == 0;
        pc = __aeabi_cfrcmple + offset;
        r12 = mov(r0);
        r0 = adds(r1, 0);
        r1 = mov(r12);
        b(this::__aeabi_cfcmpeq);
    }

    // function: Function(address=134342412, size=16, name='__aeabi_cfcmpeq', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(_arm_cmpsf2.o)', has_indirect=False)
    protected void __aeabi_cfcmpeq(int offset) throws Exception
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
                if (bmi(14)) return;
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

    // function: Function(address=134342428, size=12, name='__aeabi_fcmpeq', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(_arm_cmpsf2.o)', has_indirect=False)
    protected void __aeabi_fcmpeq(int offset) throws Exception
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

    // function: Function(address=134342440, size=20, name='__aeabi_fcmplt', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(_arm_cmpsf2.o)', has_indirect=False)
    protected void __aeabi_fcmplt(int offset) throws Exception
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
                if (blt(14)) return;
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

    // function: Function(address=134342460, size=20, name='__aeabi_fcmple', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(_arm_cmpsf2.o)', has_indirect=False)
    protected void __aeabi_fcmple(int offset) throws Exception
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
                if (ble(14)) return;
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

    // function: Function(address=134342480, size=20, name='__aeabi_fcmpgt', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(_arm_cmpsf2.o)', has_indirect=False)
    protected void __aeabi_fcmpgt(int offset) throws Exception
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
                if (bgt(14)) return;
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

    // function: Function(address=134342500, size=20, name='__aeabi_fcmpge', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(_arm_cmpsf2.o)', has_indirect=False)
    protected void __aeabi_fcmpge(int offset) throws Exception
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
                if (bge(14)) return;
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

    // function: Function(address=134342520, size=48, name='__fixunssfsi', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(_fixunssfsi.o)', has_indirect=False)
    protected void __fixunssfsi(int offset) throws Exception
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
                if (bne(24)) return;
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
                b(null, 22);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134342568, size=820, name='__aeabi_fadd', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(addsf3.o)', has_indirect=False)
    protected void __aeabi_fadd(int offset) throws Exception
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
                if (beq(130)) return;
            case 46:
                cmp(r7, 0);
                if (ble(94)) return;
            case 50:
                cmp(r0, 0);
                if (bne(204)) return;
            case 54:
                cmp(r3, 0);
                if (beq(60)) return;
            case 58:
                b(null, 360);
                return;
            case 60:
                r5 = lsrs(r5, 3);
                cmp(r4, 255);
                if (bne(68)) return;
            case 66:
                b(null, 342);
                return;
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
                if (beq(100)) return;
            case 98:
                b(null, 372);
                return;
            case 100:
                r0 = adds(r4, 1);
                r0 = uxtb(r0);
                cmp(r0, 1);
                if (bgt(110)) return;
            case 108:
                b(null, 476);
                return;
            case 110:
                r6 = subs(r5, r3);
                r2 = lsls(r6, 5);
                if (bpl(118)) return;
            case 116:
                b(null, 514);
                return;
            case 118:
                cmp(r6, 0);
                if (bne(246)) return;
            case 122:
                r2 = movs(r2, 0);
                r6 = movs(r6, 0);
                r3 = movs(r3, 0);
                b(null, 74);
                return;
            case 130:
                cmp(r7, 0);
                if (bgt(136)) return;
            case 134:
                b(null, 438);
                return;
            case 136:
                cmp(r0, 0);
                if (beq(328)) return;
            case 140:
                cmp(r4, 255);
                if (beq(338)) return;
            case 144:
                r2 = movs(r2, 128);
                r2 = lsls(r2, 19);
                r3 = orrs(r3, r2);
            case 150:
                cmp(r7, 27);
                if (ble(156)) return;
            case 154:
                b(null, 630);
                return;
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
                if (bpl(426)) return;
            case 178:
                r4 = adds(r4, 1);
                cmp(r4, 255);
                if (bne(186)) return;
            case 184:
                b(null, 554);
                return;
            case 186:
                r2 = movs(r2, 1);
                r6 = movs(r6, 7);
                r2 = ands(r2, r5);
                r3 = lsrs(r5, 1);
                r5 = ldr(__aeabi_fadd + 812);
                r5 = ands(r5, r3);
                r5 = orrs(r5, r2);
                r6 = ands(r6, r5);
                b(null, 288);
                return;
            case 204:
                cmp(r4, 255);
                if (beq(60)) return;
            case 208:
                r2 = movs(r2, 128);
                r2 = lsls(r2, 19);
                r3 = orrs(r3, r2);
            case 214:
                cmp(r7, 27);
                if (ble(220)) return;
            case 218:
                b(null, 578);
                return;
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
                if (bpl(426)) return;
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
                if (bgt(464)) return;
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
                if (beq(308)) return;
            case 298:
                r3 = movs(r3, 15);
                r3 = ands(r3, r5);
                cmp(r3, 4);
                if (beq(308)) return;
            case 306:
                r5 = adds(r5, 4);
            case 308:
                r3 = lsls(r5, 5);
                if (bmi(314)) return;
            case 312:
                b(null, 60);
                return;
            case 314:
                r4 = adds(r4, 1);
                r6 = uxtb(r4);
                cmp(r4, 255);
                if (bne(418)) return;
            case 322:
                r6 = movs(r6, 255);
                r3 = movs(r3, 0);
                b(null, 74);
                return;
            case 328:
                cmp(r3, 0);
                if (bne(498)) return;
            case 332:
                cmp(r4, 255);
                if (beq(338)) return;
            case 336:
                b(null, 60);
                return;
            case 338:
                r2 = movs(r2, r1);
                r5 = lsrs(r5, 3);
            case 342:
                cmp(r5, 0);
                if (beq(322)) return;
            case 346:
                r3 = movs(r3, 128);
                r3 = lsls(r3, 15);
                r3 = orrs(r3, r5);
                r3 = lsls(r3, 9);
                r3 = lsrs(r3, 9);
                r6 = movs(r6, 255);
                b(null, 74);
                return;
            case 360:
                r7 = subs(r7, 1);
                cmp(r7, 0);
                if (beq(236)) return;
            case 366:
                cmp(r4, 255);
                if (bne(214)) return;
            case 370:
                b(null, 60);
                return;
            case 372:
                cmp(r4, 0);
                if (beq(520)) return;
            case 376:
                cmp(r0, 255);
                if (beq(592)) return;
            case 380:
                r4 = movs(r4, 128);
                r4 = lsls(r4, 19);
                r2 = rsbs(r7);
                r5 = orrs(r5, r4);
            case 388:
                cmp(r2, 27);
                if (ble(394)) return;
            case 392:
                b(null, 790);
                return;
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
                b(null, 238);
                return;
            case 418:
                r3 = lsls(r5, 6);
                r3 = lsrs(r3, 9);
                b(null, 74);
                return;
            case 424:
                r4 = movs(r4, 0);
            case 426:
                r2 = movs(r2, 1);
                r3 = mov(r9);
                r2 = ands(r2, r3);
                r3 = lsls(r5, 29);
                if (bne(298)) return;
            case 436:
                b(null, 60);
                return;
            case 438:
                cmp(r7, 0);
                if (bne(562)) return;
            case 442:
                r4 = adds(r4, 1);
                r0 = uxtb(r4);
                cmp(r0, 1);
                if (ble(600)) return;
            case 450:
                cmp(r4, 255);
                if (beq(322)) return;
            case 454:
                r6 = movs(r6, 7);
                r5 = adds(r5, r3);
                r5 = lsrs(r5, 1);
                r6 = ands(r6, r5);
                b(null, 288);
                return;
            case 464:
                r3 = movs(r3, 7);
                r5 = ldr(__aeabi_fadd + 816);
                r4 = subs(r4, r0);
                r5 = ands(r5, r6);
                r6 = ands(r6, r3);
                b(null, 288);
                return;
            case 476:
                cmp(r4, 0);
                if (bne(536)) return;
            case 480:
                cmp(r5, 0);
                if (bne(706)) return;
            case 484:
                cmp(r3, 0);
                if (bne(490)) return;
            case 488:
                b(null, 800);
                return;
            case 490:
                r2 = movs(r2, r1);
                r5 = movs(r5, r3);
                r4 = movs(r4, r7);
                b(null, 60);
                return;
            case 498:
                r7 = subs(r7, 1);
                cmp(r7, 0);
                if (bne(506)) return;
            case 504:
                b(null, 172);
                return;
            case 506:
                cmp(r4, 255);
                if (beq(512)) return;
            case 510:
                b(null, 150);
                return;
            case 512:
                b(null, 338);
                return;
            case 514:
                r6 = subs(r3, r5);
                r9 = mov(r1);
                b(null, 246);
                return;
            case 520:
                cmp(r5, 0);
                if (bne(582)) return;
            case 524:
                r2 = movs(r2, r1);
                cmp(r0, 255);
                if (beq(594)) return;
            case 530:
                r4 = movs(r4, r0);
                r5 = movs(r5, r3);
                b(null, 60);
                return;
            case 536:
                cmp(r5, 0);
                if (bne(728)) return;
            case 540:
                cmp(r3, 0);
                if (bne(592)) return;
            case 544:
                r3 = movs(r3, 128);
                r2 = movs(r2, 0);
                r3 = lsls(r3, 15);
                r6 = movs(r6, 255);
                b(null, 74);
                return;
            case 554:
                r2 = movs(r2, r1);
                r6 = movs(r6, 255);
                r3 = movs(r3, 0);
                b(null, 74);
                return;
            case 562:
                cmp(r4, 0);
                if (bne(634)) return;
            case 566:
                cmp(r5, 0);
                if (bne(776)) return;
            case 570:
                cmp(r0, 255);
                if (bne(530)) return;
            case 574:
                r5 = movs(r5, r3);
                b(null, 338);
                return;
            case 578:
                r3 = movs(r3, 1);
                b(null, 236);
                return;
            case 582:
                r2 = adds(r7, 1);
                if (beq(410)) return;
            case 586:
                r2 = mvns(r2, r7);
                cmp(r0, 255);
                if (bne(388)) return;
            case 592:
                r2 = movs(r2, r1);
            case 594:
                r5 = movs(r5, r3);
                r4 = movs(r4, 255);
                b(null, 60);
                return;
            case 600:
                cmp(r6, 0);
                if (bne(672)) return;
            case 604:
                cmp(r5, 0);
                if (beq(768)) return;
            case 608:
                cmp(r3, 0);
                if (beq(766)) return;
            case 612:
                r5 = adds(r5, r3);
                r3 = lsls(r5, 5);
                if (bpl(424)) return;
            case 618:
                r3 = ldr(__aeabi_fadd + 816);
                r6 = adds(r6, 7);
                r6 = ands(r6, r5);
                r4 = movs(r4, 1);
                r5 = ands(r5, r3);
                b(null, 288);
                return;
            case 630:
                r3 = movs(r3, 1);
                b(null, 172);
                return;
            case 634:
                cmp(r0, 255);
                if (beq(574)) return;
            case 638:
                r4 = movs(r4, 128);
                r4 = lsls(r4, 19);
                r7 = rsbs(r7);
                r5 = orrs(r5, r4);
            case 646:
                cmp(r7, 27);
                if (bgt(806)) return;
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
                b(null, 174);
                return;
            case 672:
                cmp(r5, 0);
                if (beq(574)) return;
            case 676:
                cmp(r3, 0);
                if (bne(682)) return;
            case 680:
                b(null, 338);
                return;
            case 682:
                r1 = movs(r1, 128);
                r0 = mov(r12);
                r1 = lsls(r1, 15);
                tst(r0, r1);
                if (beq(700)) return;
            case 692:
                r0 = mov(r8);
                tst(r0, r1);
                if (bne(700)) return;
            case 698:
                r5 = movs(r5, r3);
            case 700:
                r1 = movs(r1, 1);
                r1 = ands(r1, r2);
                b(null, 338);
                return;
            case 706:
                cmp(r3, 0);
                if (bne(712)) return;
            case 710:
                b(null, 60);
                return;
            case 712:
                r2 = subs(r5, r3);
                r0 = lsls(r2, 5);
                if (bpl(794)) return;
            case 718:
                r6 = movs(r6, 7);
                r5 = subs(r3, r5);
                r6 = ands(r6, r5);
                r9 = mov(r1);
                b(null, 288);
                return;
            case 728:
                r4 = movs(r4, 255);
                cmp(r3, 0);
                if (bne(736)) return;
            case 734:
                b(null, 60);
                return;
            case 736:
                r2 = movs(r2, 128);
                r0 = mov(r12);
                r2 = lsls(r2, 15);
                tst(r0, r2);
                if (beq(756)) return;
            case 746:
                r0 = mov(r8);
                tst(r0, r2);
                if (bne(756)) return;
            case 752:
                r5 = movs(r5, r3);
                r9 = mov(r1);
            case 756:
                r2 = movs(r2, 1);
                r3 = mov(r9);
                r4 = movs(r4, 255);
                r2 = ands(r2, r3);
                b(null, 60);
                return;
            case 766:
                r3 = movs(r3, r5);
            case 768:
                r5 = lsrs(r3, 3);
                r2 = movs(r2, r1);
                r4 = movs(r4, 0);
                b(null, 68);
                return;
            case 776:
                r2 = adds(r7, 1);
                if (beq(666)) return;
            case 780:
                r7 = mvns(r7, r7);
                cmp(r0, 255);
                if (bne(646)) return;
            case 786:
                r5 = movs(r5, r3);
                b(null, 338);
                return;
            case 790:
                r5 = movs(r5, 1);
                b(null, 410);
                return;
            case 794:
                r5 = subs(r2, 0);
                if (beq(800)) return;
            case 798:
                b(null, 426);
                return;
            case 800:
                r2 = movs(r2, 0);
                r3 = movs(r3, 0);
                b(null, 74);
                return;
            case 806:
                r5 = movs(r5, 1);
                b(null, 666);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134343388, size=548, name='__aeabi_fdiv', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(divsf3.o)', has_indirect=False)
    protected void __aeabi_fdiv(int offset) throws Exception
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
                if (beq(228)) return;
            case 28:
                cmp(r6, 255);
                if (beq(106)) return;
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
                if (beq(272)) return;
            case 68:
                cmp(r3, 255);
                if (beq(244)) return;
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
                if (bls(98)) return;
            case 96:
                b(null, 382);
                return;
            case 98:
                r0 = ldr(__aeabi_fdiv + 536); // rodata__2;
                r2 = lsls(r2, 2);
                r2 = ldr(r0 + r2);
                pc = mov(r2);
                b(pc); // auto;
                return;
            case 106:
                cmp(r4, 0);
                if (bne(280)) return;
            case 110:
                r3 = movs(r3, 8);
                r9 = mov(r3);
                r3 = subs(r3, 6);
                r6 = movs(r6, 255);
                r11 = mov(r3);
                b(null, 48);
                return;
            case 140:
                r0 = movs(r0, r6);
                r0 = adds(r0, 127);
                cmp(r0, 0);
                if (ble(214)) return;
            case 148:
                r2 = lsls(r5, 29);
                if (beq(162)) return;
            case 152:
                r2 = movs(r2, 15);
                r2 = ands(r2, r5);
                cmp(r2, 4);
                if (beq(162)) return;
            case 160:
                r5 = adds(r5, 4);
            case 162:
                r2 = lsls(r5, 4);
                if (bpl(174)) return;
            case 166:
                r0 = movs(r0, r6);
                r2 = ldr(__aeabi_fdiv + 540);
                r0 = adds(r0, 128);
                r5 = ands(r5, r2);
            case 174:
                cmp(r0, 254);
                if (bgt(186)) return;
            case 178:
                r4 = lsls(r5, 6);
                r4 = lsrs(r4, 9);
                r2 = uxtb(r0);
                b(null, 190);
                return;
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
                if (ble(472)) return;
            case 222:
                r2 = movs(r2, 0);
                r4 = movs(r4, 0);
                b(null, 190);
                return;
            case 228:
                cmp(r4, 0);
                if (bne(292)) return;
            case 232:
                r3 = movs(r3, 4);
                r9 = mov(r3);
                r3 = subs(r3, 3);
                r6 = movs(r6, 0);
                r11 = mov(r3);
                b(null, 48);
                return;
            case 244:
                r6 = subs(r6, 255);
                cmp(r5, 0);
                if (bne(316)) return;
            case 250:
                r1 = movs(r1, 2);
            case 252:
                r3 = mov(r8);
                r2 = mov(r9);
                r3 = eors(r3, r7);
                r2 = orrs(r2, r1);
                cmp(r2, 15);
                if (bhi(186)) return;
            case 264:
                r0 = ldr(__aeabi_fdiv + 544);
                r2 = lsls(r2, 2);
                r2 = ldr(r0 + r2);
                pc = mov(r2);
                b(pc); // auto;
                return;
            case 272:
                cmp(r5, 0);
                if (bne(328)) return;
            case 276:
                r1 = movs(r1, 1);
                b(null, 252);
                return;
            case 280:
                r3 = movs(r3, 12);
                r9 = mov(r3);
                r3 = subs(r3, 9);
                r6 = movs(r6, 255);
                r11 = mov(r3);
                b(null, 48);
                return;
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
                b(null, 48);
                return;
            case 316:
                r2 = mov(r9);
                r3 = movs(r3, 3);
                r2 = orrs(r2, r3);
                r9 = mov(r2);
                r1 = movs(r1, 3);
                b(null, 86);
                return;
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
                b(null, 86);
                return;
            case 382:
                r2 = lsls(r4, 5);
                r4 = lsls(r5, 5);
                cmp(r2, r4);
                if (bhs(464)) return;
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
                if (blt(412)) return;
            case 408:
                cmp(r4, r2);
                if (bhi(416)) return;
            case 412:
                r2 = subs(r2, r4);
                r5 = orrs(r5, r7);
            case 416:
                r1 = subs(r1, 1);
                cmp(r1, 0);
                if (bne(398)) return;
            case 422:
                r4 = movs(r4, r2);
                r2 = subs(r4, 1);
                r4 = sbcs(r4, r2);
                r5 = orrs(r5, r4);
                b(null, 140);
                return;
            case 464:
                r2 = subs(r2, r4);
                r1 = movs(r1, 26);
                r5 = movs(r5, 1);
                b(null, 396);
                return;
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
                if (beq(502)) return;
            case 492:
                r2 = movs(r2, 15);
                r2 = ands(r2, r4);
                cmp(r2, 4);
                if (beq(502)) return;
            case 500:
                r4 = adds(r4, 4);
            case 502:
                r2 = lsls(r4, 5);
                if (bmi(514)) return;
            case 506:
                r4 = lsls(r4, 6);
                r4 = lsrs(r4, 9);
                r2 = movs(r2, 0);
                b(null, 190);
                return;
            case 514:
                r2 = movs(r2, 1);
                r4 = movs(r4, 0);
                b(null, 190);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134343936, size=80, name='__eqsf2', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(eqsf2.o)', has_indirect=False)
    protected void __eqsf2(int offset) throws Exception
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
                if (beq(58)) return;
            case 26:
                cmp(r4, 255);
                if (beq(66)) return;
            case 30:
                r0 = movs(r0, 1);
                cmp(r2, r4);
                if (beq(38)) return;
            case 36:
                pop(true, R4, R5, R6);
                return;
            case 38:
                cmp(r5, r6);
                if (bne(36)) return;
            case 42:
                cmp(r3, r1);
                if (beq(74)) return;
            case 46:
                cmp(r2, 0);
                if (bne(36)) return;
            case 50:
                r0 = movs(r0, r5);
                r5 = subs(r0, 1);
                r0 = sbcs(r0, r5);
                b(null, 36);
                return;
            case 58:
                r0 = movs(r0, 1);
                cmp(r5, 0);
                if (bne(36)) return;
            case 64:
                b(null, 26);
                return;
            case 66:
                r0 = movs(r0, 1);
                cmp(r6, 0);
                if (bne(36)) return;
            case 72:
                b(null, 30);
                return;
            case 74:
                r0 = movs(r0, 0);
                b(null, 36);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134344016, size=156, name='__gesf2', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(gesf2.o)', has_indirect=False)
    protected void __gesf2(int offset) throws Exception
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
                if (beq(70)) return;
            case 26:
                cmp(r2, 255);
                if (beq(60)) return;
            case 30:
                cmp(r4, 0);
                if (bne(78)) return;
            case 34:
                cmp(r2, 0);
                if (bne(42)) return;
            case 38:
                cmp(r6, 0);
                if (beq(100)) return;
            case 42:
                cmp(r5, 0);
                if (beq(88)) return;
            case 46:
                cmp(r3, r1);
                if (beq(130)) return;
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
                if (beq(30)) return;
            case 64:
                r0 = movs(r0, 2);
                r0 = rsbs(r0);
                b(null, 58);
                return;
            case 70:
                cmp(r5, 0);
                if (bne(64)) return;
            case 74:
                cmp(r2, 255);
                if (beq(108)) return;
            case 78:
                cmp(r2, 0);
                if (bne(112)) return;
            case 82:
                cmp(r6, 0);
                if (beq(50)) return;
            case 86:
                b(null, 112);
                return;
            case 88:
                r3 = movs(r3, 1);
                r1 = subs(r1, 1);
                r1 = bics(r1, r3);
                r0 = movs(r0, r1);
                r0 = adds(r0, 1);
                b(null, 58);
                return;
            case 100:
                r0 = movs(r0, 0);
                cmp(r5, 0);
                if (beq(58)) return;
            case 106:
                b(null, 50);
                return;
            case 108:
                cmp(r6, 0);
                if (bne(64)) return;
            case 112:
                cmp(r3, r1);
                if (bne(50)) return;
            case 116:
                cmp(r4, r2);
                if (ble(132)) return;
            case 120:
                r1 = movs(r1, 2);
                r0 = subs(r3, 1);
                r0 = ands(r0, r1);
                r0 = subs(r0, 1);
                b(null, 58);
                return;
            case 130:
                r4 = movs(r4, 0);
            case 132:
                cmp(r2, r4);
                if (bgt(146)) return;
            case 136:
                cmp(r5, r6);
                if (bhi(50)) return;
            case 140:
                r0 = movs(r0, 0);
                cmp(r5, r6);
                if (bhs(58)) return;
            case 146:
                r0 = subs(r3, 1);
                r3 = movs(r3, 1);
                r0 = bics(r0, r3);
                r0 = adds(r0, 1);
                b(null, 58);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134344172, size=160, name='__ltsf2', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(lesf2.o)', has_indirect=False)
    protected void __ltsf2(int offset) throws Exception
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
                if (beq(64)) return;
            case 26:
                cmp(r0, 255);
                if (beq(56)) return;
            case 30:
                cmp(r2, 0);
                if (bne(72)) return;
            case 34:
                cmp(r0, 0);
                if (bne(90)) return;
            case 38:
                cmp(r5, 0);
                if (bne(90)) return;
            case 42:
                cmp(r4, 0);
                if (beq(134)) return;
            case 46:
                r0 = movs(r0, 2);
                r3 = subs(r3, 1);
                r0 = ands(r0, r3);
                r0 = subs(r0, 1);
                b(null, 134);
                return;
            case 56:
                cmp(r5, 0);
                if (beq(30)) return;
            case 60:
                r0 = movs(r0, 2);
                b(null, 134);
                return;
            case 64:
                cmp(r4, 0);
                if (bne(60)) return;
            case 68:
                cmp(r0, 255);
                if (beq(136)) return;
            case 72:
                cmp(r0, 0);
                if (bne(140)) return;
            case 76:
                cmp(r5, 0);
                if (bne(140)) return;
            case 80:
                r0 = movs(r0, 2);
                r3 = subs(r3, 1);
                r0 = ands(r0, r3);
                r0 = subs(r0, 1);
                b(null, 134);
                return;
            case 90:
                cmp(r4, 0);
                if (beq(124)) return;
            case 94:
                cmp(r3, r1);
                if (bne(46)) return;
            case 98:
                r2 = movs(r2, 0);
            case 100:
                cmp(r0, r2);
                if (bgt(114)) return;
            case 104:
                cmp(r4, r5);
                if (bhi(46)) return;
            case 108:
                r0 = movs(r0, 0);
                cmp(r4, r5);
                if (bhs(134)) return;
            case 114:
                r0 = subs(r3, 1);
                r3 = movs(r3, 1);
                r0 = bics(r0, r3);
                r0 = adds(r0, 1);
                b(null, 134);
                return;
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
                if (bne(60)) return;
            case 140:
                cmp(r3, r1);
                if (bne(46)) return;
            case 144:
                cmp(r2, r0);
                if (ble(100)) return;
            case 148:
                r1 = movs(r1, 2);
                r0 = subs(r3, 1);
                r0 = ands(r0, r1);
                r0 = subs(r0, 1);
                b(null, 134);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134344332, size=612, name='__aeabi_fmul', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(mulsf3.o)', has_indirect=False)
    protected void __aeabi_fmul(int offset) throws Exception
    {
        pc = __aeabi_fmul + offset;
        switch (offset)
        {
            case 0:
                push(true, r4, r5, r6, r7);
                r6 = mov(r9);
                r7 = mov(r10);
                r5 = mov(r8);
                lr = mov(r11);
                push(true, r5, r6, r7);
                r3 = lsls(r0, 9);
                r3 = lsrs(r3, 9);
                r5 = lsls(r0, 1);
                sp = sub(sp, 12);
                r7 = adds(r1, 0);
                r9 = mov(r3);
                r5 = lsrs(r5, 24);
                r6 = lsrs(r0, 31);
                cmp(r5, 0);
                if (beq(208)) return;
            case 32:
                cmp(r5, 255);
                if (beq(110)) return;
            case 36:
                r0 = movs(r0, 128);
                r3 = lsls(r3, 3);
                r0 = lsls(r0, 19);
                r0 = orrs(r0, r3);
                r3 = movs(r3, 0);
                r9 = mov(r0);
                r10 = mov(r3);
                r11 = mov(r3);
                r5 = subs(r5, 127);
            case 54:
                r4 = lsls(r7, 9);
                r2 = lsls(r7, 1);
                r3 = lsrs(r7, 31);
                r4 = lsrs(r4, 9);
                r2 = lsrs(r2, 24);
                r8 = mov(r3);
                if (beq(140)) return;
            case 68:
                cmp(r2, 255);
                if (beq(224)) return;
            case 72:
                r3 = lsls(r4, 3);
                r4 = movs(r4, 128);
                r0 = movs(r0, 0);
                r4 = lsls(r4, 19);
                r2 = subs(r2, 127);
                r4 = orrs(r4, r3);
                r5 = adds(r5, r2);
            case 86:
                r3 = adds(r5, 1);
                r7 = mov(r8);
                str(sp + 4, r3);
                r3 = mov(r10);
                r7 = eors(r7, r6);
                r2 = movs(r2, r7);
                cmp(r3, 15);
                if (bhi(248)) return;
            case 102:
                r1 = ldr(__aeabi_fmul + 604); // rodata__3;
                r3 = lsls(r3, 2);
                r3 = ldr(r1 + r3);
                pc = mov(r3);
                b(pc); // auto;
                return;
            case 110:
                cmp(r3, 0);
                if (beq(116)) return;
            case 114:
                b(null, 384);
                return;
            case 116:
                r3 = adds(r3, 8);
                r10 = mov(r3);
                r3 = subs(r3, 6);
                r11 = mov(r3);
                r4 = lsls(r7, 9);
                r2 = lsls(r7, 1);
                r3 = lsrs(r7, 31);
                r5 = movs(r5, 255);
                r4 = lsrs(r4, 9);
                r2 = lsrs(r2, 24);
                r8 = mov(r3);
                if (bne(68)) return;
            case 140:
                cmp(r4, 0);
                if (beq(146)) return;
            case 144:
                b(null, 436);
                return;
            case 146:
                r2 = mov(r10);
                r3 = movs(r3, 1);
                r2 = orrs(r2, r3);
                r10 = mov(r2);
                r0 = movs(r0, 1);
                b(null, 86);
                return;
            case 182:
                r0 = lsls(r3, 9);
                r2 = lsls(r2, 23);
                r0 = lsrs(r0, 9);
                r7 = lsls(r7, 31);
                r0 = orrs(r0, r2);
                r0 = orrs(r0, r7);
                sp = add(sp, 12);
                pop(false, R2, R3, R4, R5);
                r8 = mov(r2);
                r9 = mov(r3);
                r10 = mov(r4);
                r11 = mov(r5);
                pop(true, R4, R5, R6, R7);
                return;
            case 208:
                cmp(r3, 0);
                if (bne(396)) return;
            case 212:
                r3 = movs(r3, 4);
                r10 = mov(r3);
                r3 = subs(r3, 3);
                r5 = movs(r5, 0);
                r11 = mov(r3);
                b(null, 54);
                return;
            case 224:
                r5 = adds(r5, 255);
                cmp(r4, 0);
                if (bne(424)) return;
            case 230:
                r2 = mov(r10);
                r3 = movs(r3, 2);
                r2 = orrs(r2, r3);
                r10 = mov(r2);
                r0 = movs(r0, 2);
                b(null, 86);
                return;
            case 242:
                r2 = movs(r2, 255);
                r3 = movs(r3, 0);
                b(null, 182);
                return;
            case 248:
                r3 = mov(r9);
                r3 = lsrs(r3, 16);
                r12 = mov(r3);
                r3 = mov(r9);
                r6 = lsls(r4, 16);
                r6 = lsrs(r6, 16);
                r0 = lsls(r3, 16);
                r1 = mov(r12);
                r3 = movs(r3, r6);
                r2 = lsrs(r4, 16);
                r4 = mov(r12);
                r0 = lsrs(r0, 16);
                r3 = muls(r0, r3);
                r6 = muls(r1, r6);
                r0 = muls(r2, r0);
                r4 = muls(r2, r4);
                r0 = adds(r0, r6);
                r2 = lsrs(r3, 16);
                r2 = adds(r2, r0);
                cmp(r6, r2);
                if (bls(298)) return;
            case 290:
                r1 = movs(r1, 128);
                r1 = lsls(r1, 9);
                r12 = mov(r1);
                r4 = add(r4, r12);
            case 298:
                r3 = lsls(r3, 16);
                r3 = lsrs(r3, 16);
                r0 = lsls(r2, 16);
                r0 = adds(r0, r3);
                r3 = lsls(r0, 6);
                r6 = subs(r3, 1);
                r3 = sbcs(r3, r6);
                r0 = lsrs(r0, 26);
                r0 = orrs(r0, r3);
                r3 = lsrs(r2, 16);
                r3 = adds(r3, r4);
                r3 = lsls(r3, 6);
                r3 = orrs(r3, r0);
                r4 = movs(r4, r3);
                r3 = lsls(r4, 4);
                if (bpl(574)) return;
            case 330:
                r3 = movs(r3, 1);
                r2 = lsrs(r4, 1);
                r4 = ands(r4, r3);
                r4 = orrs(r4, r2);
            case 338:
                r2 = ldr(sp + 4);
                r2 = adds(r2, 127);
                cmp(r2, 0);
                if (ble(502)) return;
            case 346:
                r3 = lsls(r4, 29);
                if (beq(360)) return;
            case 350:
                r3 = movs(r3, 15);
                r3 = ands(r3, r4);
                cmp(r3, 4);
                if (beq(360)) return;
            case 358:
                r4 = adds(r4, 4);
            case 360:
                r3 = lsls(r4, 4);
                if (bpl(372)) return;
            case 364:
                r3 = ldr(__aeabi_fmul + 608);
                r2 = ldr(sp + 4);
                r4 = ands(r4, r3);
                r2 = adds(r2, 128);
            case 372:
                cmp(r2, 254);
                if (bgt(242)) return;
            case 376:
                r3 = lsls(r4, 6);
                r3 = lsrs(r3, 9);
                r2 = uxtb(r2);
                b(null, 182);
                return;
            case 384:
                r3 = movs(r3, 12);
                r10 = mov(r3);
                r3 = subs(r3, 9);
                r5 = movs(r5, 255);
                r11 = mov(r3);
                b(null, 54);
                return;
            case 396:
                r0 = movs(r0, r3);
                bl(this::__clzsi2, __aeabi_fmul + 402 | 1, 402);
                return;
            case 402:
                r2 = mov(r9);
                r3 = subs(r0, 5);
                r5 = movs(r5, 118);
                r2 = lsls(r2, r3);
                r3 = movs(r3, 0);
                r5 = rsbs(r5);
                r9 = mov(r2);
                r5 = subs(r5, r0);
                r10 = mov(r3);
                r11 = mov(r3);
                b(null, 54);
                return;
            case 424:
                r2 = mov(r10);
                r3 = movs(r3, 3);
                r2 = orrs(r2, r3);
                r10 = mov(r2);
                r0 = movs(r0, 3);
                b(null, 86);
                return;
            case 436:
                r0 = movs(r0, r4);
                bl(this::__clzsi2, __aeabi_fmul + 442 | 1, 442);
                return;
            case 442:
                r3 = subs(r0, 5);
                r5 = subs(r5, r0);
                r4 = lsls(r4, r3);
                r5 = subs(r5, 118);
                r0 = movs(r0, 0);
                b(null, 86);
                return;
            case 502:
                r3 = movs(r3, 1);
                r2 = subs(r3, r2);
                cmp(r2, 27);
                if (bgt(578)) return;
            case 510:
                r3 = movs(r3, r4);
                r1 = ldr(sp + 4);
                r3 = lsrs(r3, r2);
                r1 = adds(r1, 158);
                r4 = lsls(r4, r1);
                r2 = movs(r2, r3);
                r3 = movs(r3, r4);
                r4 = subs(r3, 1);
                r3 = sbcs(r3, r4);
                r3 = orrs(r3, r2);
                r2 = lsls(r3, 29);
                if (beq(544)) return;
            case 534:
                r2 = movs(r2, 15);
                r2 = ands(r2, r3);
                cmp(r2, 4);
                if (beq(544)) return;
            case 542:
                r3 = adds(r3, 4);
            case 544:
                r2 = lsls(r3, 5);
                if (bmi(584)) return;
            case 548:
                r3 = lsls(r3, 6);
                r3 = lsrs(r3, 9);
                r2 = movs(r2, 0);
                b(null, 182);
                return;
            case 574:
                str(sp + 4, r5);
                b(null, 338);
                return;
            case 578:
                r2 = movs(r2, 0);
                r3 = movs(r3, 0);
                b(null, 182);
                return;
            case 584:
                r2 = movs(r2, 1);
                r3 = movs(r3, 0);
                b(null, 182);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134344944, size=904, name='__aeabi_fsub', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(subsf3.o)', has_indirect=False)
    protected void __aeabi_fsub(int offset) throws Exception
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
                if (bne(48)) return;
            case 46:
                b(null, 316);
                return;
            case 48:
                r6 = movs(r6, 1);
                r1 = eors(r1, r6);
            case 52:
                r6 = subs(r4, r0);
                cmp(r1, r2);
                if (beq(234)) return;
            case 58:
                cmp(r6, 0);
                if (ble(198)) return;
            case 62:
                cmp(r0, 0);
                if (beq(68)) return;
            case 66:
                b(null, 324);
                return;
            case 68:
                r1 = mov(r9);
                cmp(r1, 0);
                if (bne(76)) return;
            case 74:
                b(null, 418);
                return;
            case 76:
                r6 = subs(r6, 1);
                cmp(r6, 0);
                if (beq(84)) return;
            case 82:
                b(null, 580);
                return;
            case 84:
                r3 = subs(r3, r1);
            case 86:
                r2 = lsls(r3, 5);
                if (bmi(92)) return;
            case 90:
                b(null, 372);
                return;
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
                if (ble(112)) return;
            case 110:
                b(null, 536);
                return;
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
                if (beq(158)) return;
            case 148:
                r1 = movs(r1, 15);
                r1 = ands(r1, r3);
                cmp(r1, 4);
                if (beq(158)) return;
            case 156:
                r3 = adds(r3, 4);
            case 158:
                r1 = lsls(r3, 5);
                if (bmi(164)) return;
            case 162:
                b(null, 422);
                return;
            case 164:
                r5 = adds(r5, 1);
                r4 = uxtb(r5);
                cmp(r5, 255);
                if (beq(174)) return;
            case 172:
                b(null, 502);
                return;
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
                if (bne(436)) return;
            case 202:
                r0 = adds(r4, 1);
                r0 = uxtb(r0);
                cmp(r0, 1);
                if (bgt(212)) return;
            case 210:
                b(null, 548);
                return;
            case 212:
                r2 = mov(r9);
                r4 = subs(r3, r2);
                r2 = lsls(r4, 5);
                if (bpl(222)) return;
            case 220:
                b(null, 588);
                return;
            case 222:
                cmp(r4, 0);
                if (bne(96)) return;
            case 226:
                r2 = movs(r2, 0);
                r4 = movs(r4, 0);
                r3 = movs(r3, 0);
                b(null, 178);
                return;
            case 234:
                cmp(r6, 0);
                if (bgt(240)) return;
            case 238:
                b(null, 508);
                return;
            case 240:
                cmp(r0, 0);
                if (beq(386)) return;
            case 244:
                cmp(r4, 255);
                if (beq(396)) return;
            case 248:
                r2 = movs(r2, 128);
                r0 = mov(r9);
                r2 = lsls(r2, 19);
                r0 = orrs(r0, r2);
                r9 = mov(r0);
            case 258:
                r2 = movs(r2, 1);
                cmp(r6, 27);
                if (bgt(284)) return;
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
                if (bpl(372)) return;
            case 290:
                r5 = adds(r5, 1);
                cmp(r5, 255);
                if (bne(298)) return;
            case 296:
                b(null, 636);
                return;
            case 298:
                r2 = movs(r2, 1);
                r4 = movs(r4, 7);
                r1 = ldr(__aeabi_fsub + 896);
                r2 = ands(r2, r3);
                r3 = lsrs(r3, 1);
                r3 = ands(r3, r1);
                r3 = orrs(r3, r2);
                r4 = ands(r4, r3);
                b(null, 138);
                return;
            case 316:
                cmp(r6, 0);
                if (beq(322)) return;
            case 320:
                b(null, 52);
                return;
            case 322:
                b(null, 48);
                return;
            case 324:
                cmp(r4, 255);
                if (beq(498)) return;
            case 328:
                r2 = movs(r2, 128);
                r1 = mov(r9);
                r2 = lsls(r2, 19);
                r1 = orrs(r1, r2);
                r9 = mov(r1);
            case 338:
                r2 = movs(r2, 1);
                cmp(r6, 27);
                if (bgt(364)) return;
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
                if (bpl(372)) return;
            case 370:
                b(null, 92);
                return;
            case 372:
                r2 = movs(r2, 1);
                r1 = mov(r8);
                r2 = ands(r2, r1);
                r1 = lsls(r3, 29);
                if (beq(384)) return;
            case 382:
                b(null, 148);
                return;
            case 384:
                b(null, 422);
                return;
            case 386:
                r0 = mov(r9);
                cmp(r0, 0);
                if (bne(570)) return;
            case 392:
                cmp(r4, 255);
                if (bne(422)) return;
            case 396:
                r3 = lsrs(r3, 3);
            case 398:
                cmp(r3, 0);
                if (bne(404)) return;
            case 402:
                b(null, 174);
                return;
            case 404:
                r0 = movs(r0, 128);
                r0 = lsls(r0, 15);
                r3 = orrs(r3, r0);
                r3 = lsls(r3, 9);
                r3 = lsrs(r3, 9);
                r4 = movs(r4, 255);
                b(null, 178);
                return;
            case 418:
                cmp(r4, 255);
                if (beq(498)) return;
            case 422:
                r3 = lsrs(r3, 3);
                cmp(r5, 255);
                if (beq(398)) return;
            case 428:
                r3 = lsls(r3, 9);
                r3 = lsrs(r3, 9);
                r4 = uxtb(r5);
                b(null, 178);
                return;
            case 436:
                cmp(r4, 0);
                if (beq(596)) return;
            case 440:
                cmp(r0, 255);
                if (beq(494)) return;
            case 444:
                r4 = movs(r4, 128);
                r4 = lsls(r4, 19);
                r2 = rsbs(r6);
                r3 = orrs(r3, r4);
            case 452:
                cmp(r2, 27);
                if (ble(458)) return;
            case 456:
                b(null, 852);
                return;
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
                b(null, 86);
                return;
            case 484:
                r2 = adds(r6, 1);
                if (beq(474)) return;
            case 488:
                r2 = mvns(r2, r6);
                cmp(r0, 255);
                if (bne(452)) return;
            case 494:
                r2 = movs(r2, r1);
            case 496:
                r3 = mov(r9);
            case 498:
                r5 = movs(r5, 255);
                b(null, 422);
                return;
            case 502:
                r3 = lsls(r3, 6);
                r3 = lsrs(r3, 9);
                b(null, 178);
                return;
            case 508:
                cmp(r6, 0);
                if (bne(644)) return;
            case 512:
                r5 = adds(r4, 1);
                r1 = uxtb(r5);
                cmp(r1, 1);
                if (ble(660)) return;
            case 520:
                cmp(r5, 255);
                if (bne(526)) return;
            case 524:
                b(null, 174);
                return;
            case 526:
                r4 = movs(r4, 7);
                r3 = add(r3, r9);
                r3 = lsrs(r3, 1);
                r4 = ands(r4, r3);
                b(null, 138);
                return;
            case 536:
                r2 = movs(r2, 7);
                r3 = ldr(__aeabi_fsub + 900);
                r5 = subs(r5, r0);
                r3 = ands(r3, r4);
                r4 = ands(r4, r2);
                b(null, 138);
                return;
            case 548:
                cmp(r4, 0);
                if (bne(612)) return;
            case 552:
                cmp(r3, 0);
                if (bne(802)) return;
            case 556:
                r3 = mov(r9);
                cmp(r3, 0);
                if (bne(564)) return;
            case 562:
                b(null, 856);
                return;
            case 564:
                r2 = movs(r2, r1);
                r5 = movs(r5, 0);
                b(null, 422);
                return;
            case 570:
                r6 = subs(r6, 1);
                cmp(r6, 0);
                if (bne(628)) return;
            case 576:
                r3 = add(r3, r9);
                b(null, 286);
                return;
            case 580:
                cmp(r4, 255);
                if (bne(338)) return;
            case 584:
                r5 = movs(r5, 255);
                b(null, 422);
                return;
            case 588:
                r2 = mov(r9);
                r8 = mov(r1);
                r4 = subs(r2, r3);
                b(null, 96);
                return;
            case 596:
                cmp(r3, 0);
                if (bne(484)) return;
            case 600:
                r2 = movs(r2, r1);
                cmp(r0, 255);
                if (beq(496)) return;
            case 606:
                r5 = movs(r5, r0);
                r3 = mov(r9);
                b(null, 422);
                return;
            case 612:
                cmp(r3, 0);
                if (bne(764)) return;
            case 616:
                r3 = mov(r9);
                cmp(r3, 0);
                if (beq(862)) return;
            case 622:
                r2 = movs(r2, r1);
                r5 = movs(r5, 255);
                b(null, 422);
                return;
            case 628:
                cmp(r4, 255);
                if (beq(634)) return;
            case 632:
                b(null, 258);
                return;
            case 634:
                b(null, 396);
                return;
            case 636:
                r2 = movs(r2, r1);
                r4 = movs(r4, 255);
                r3 = movs(r3, 0);
                b(null, 178);
                return;
            case 644:
                cmp(r4, 0);
                if (bne(692)) return;
            case 648:
                cmp(r3, 0);
                if (bne(828)) return;
            case 652:
                cmp(r0, 255);
                if (bne(606)) return;
            case 656:
                r3 = mov(r9);
                b(null, 396);
                return;
            case 660:
                cmp(r4, 0);
                if (bne(730)) return;
            case 664:
                cmp(r3, 0);
                if (beq(844)) return;
            case 668:
                r1 = mov(r9);
                cmp(r1, 0);
                if (beq(842)) return;
            case 674:
                r3 = add(r3, r9);
                r2 = lsls(r3, 5);
                if (bpl(890)) return;
            case 680:
                r4 = movs(r4, 7);
                r2 = ldr(__aeabi_fsub + 900);
                r4 = ands(r4, r3);
                r5 = movs(r5, 1);
                r3 = ands(r3, r2);
                b(null, 138);
                return;
            case 692:
                cmp(r0, 255);
                if (beq(656)) return;
            case 696:
                r2 = movs(r2, 128);
                r2 = lsls(r2, 19);
                r6 = rsbs(r6);
                r3 = orrs(r3, r2);
            case 704:
                cmp(r6, 27);
                if (bgt(876)) return;
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
                b(null, 286);
                return;
            case 730:
                cmp(r3, 0);
                if (beq(656)) return;
            case 734:
                r1 = mov(r9);
                cmp(r1, 0);
                if (bne(742)) return;
            case 740:
                b(null, 396);
                return;
            case 742:
                r1 = movs(r1, 128);
                r1 = lsls(r1, 15);
                tst(r7, r1);
                if (bne(752)) return;
            case 750:
                b(null, 396);
                return;
            case 752:
                r0 = mov(r12);
                tst(r0, r1);
                if (beq(760)) return;
            case 758:
                b(null, 396);
                return;
            case 760:
                r3 = mov(r9);
                b(null, 396);
                return;
            case 764:
                r0 = mov(r9);
                r5 = movs(r5, 255);
                cmp(r0, 0);
                if (bne(774)) return;
            case 772:
                b(null, 422);
                return;
            case 774:
                r2 = movs(r2, 128);
                r2 = lsls(r2, 15);
                tst(r7, r2);
                if (beq(792)) return;
            case 782:
                r0 = mov(r12);
                tst(r0, r2);
                if (bne(792)) return;
            case 788:
                r3 = mov(r9);
                r8 = mov(r1);
            case 792:
                r2 = movs(r2, 1);
                r1 = mov(r8);
                r5 = movs(r5, 255);
                r2 = ands(r2, r1);
                b(null, 422);
                return;
            case 802:
                r0 = mov(r9);
                cmp(r0, 0);
                if (beq(872)) return;
            case 808:
                r2 = subs(r3, r0);
                r0 = lsls(r2, 5);
                if (bpl(880)) return;
            case 814:
                r2 = mov(r9);
                r4 = movs(r4, 7);
                r3 = subs(r2, r3);
                r4 = ands(r4, r3);
                r8 = mov(r1);
                r5 = movs(r5, 0);
                b(null, 138);
                return;
            case 828:
                r4 = adds(r6, 1);
                if (beq(724)) return;
            case 832:
                r6 = mvns(r6, r6);
                cmp(r0, 255);
                if (bne(704)) return;
            case 838:
                r3 = mov(r9);
                b(null, 396);
                return;
            case 842:
                r9 = mov(r3);
            case 844:
                r3 = mov(r9);
                r5 = movs(r5, 0);
                r3 = lsrs(r3, 3);
                b(null, 428);
                return;
            case 852:
                r3 = movs(r3, 1);
                b(null, 474);
                return;
            case 856:
                r2 = movs(r2, 0);
                r3 = movs(r3, 0);
                b(null, 178);
                return;
            case 862:
                r3 = movs(r3, 128);
                r2 = movs(r2, 0);
                r3 = lsls(r3, 15);
                r4 = movs(r4, 255);
                b(null, 178);
                return;
            case 872:
                r5 = movs(r5, 0);
                b(null, 422);
                return;
            case 876:
                r3 = movs(r3, 1);
                b(null, 724);
                return;
            case 880:
                cmp(r2, 0);
                if (beq(856)) return;
            case 884:
                r3 = movs(r3, r2);
                r5 = movs(r5, 0);
                b(null, 372);
                return;
            case 890:
                r5 = movs(r5, 0);
                b(null, 372);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134345848, size=44, name='__aeabi_fcmpun', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(unordsf2.o)', has_indirect=False)
    protected void __aeabi_fcmpun(int offset) throws Exception
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
                if (beq(34)) return;
            case 20:
                r0 = movs(r0, 0);
                cmp(r1, 255);
                if (bne(32)) return;
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
                if (bne(32)) return;
            case 40:
                b(null, 20);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134345892, size=64, name='__aeabi_f2iz', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(fixsfsi.o)', has_indirect=False)
    protected void __aeabi_f2iz(int offset) throws Exception
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
                if (bls(44)) return;
            case 16:
                cmp(r2, 157);
                if (bhi(46)) return;
            case 20:
                r0 = movs(r0, 128);
                r0 = lsls(r0, 16);
                r1 = orrs(r1, r0);
                cmp(r2, 149);
                if (bgt(52)) return;
            case 30:
                r0 = movs(r0, 150);
                r2 = subs(r0, r2);
                r1 = lsrs(r1, r2);
            case 36:
                r0 = rsbs(r1);
                cmp(r3, 0);
                if (bne(44)) return;
            case 42:
                r0 = movs(r0, r1);
            case 44:
                bx(lr);
                return;
            case 46:
                r2 = ldr(__aeabi_f2iz + 60);
                r0 = adds(r3, r2);
                b(null, 44);
                return;
            case 52:
                r2 = subs(r2, 150);
                r1 = lsls(r1, r2);
                b(null, 36);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134345956, size=148, name='__aeabi_i2f', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(floatsisf.o)', has_indirect=False)
    protected void __aeabi_i2f(int offset) throws Exception
    {
        pc = __aeabi_i2f + offset;
        switch (offset)
        {
            case 0:
                push(true, r4, r5, r6);
                cmp(r0, 0);
                if (beq(130)) return;
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
                if (bgt(44)) return;
            case 28:
                r2 = uxtb(r2);
                cmp(r0, 8);
                if (ble(138)) return;
            case 34:
                r0 = subs(r0, 8);
                r5 = lsls(r5, r0);
                r0 = lsls(r5, 9);
                r0 = lsrs(r0, 9);
                b(null, 116);
                return;
            case 44:
                cmp(r2, 153);
                if (ble(72)) return;
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
                if (ble(80)) return;
            case 76:
                r3 = subs(r0, 5);
                r5 = lsls(r5, r3);
            case 80:
                r3 = movs(r3, r5);
                r1 = ldr(__aeabi_i2f + 144);
                r3 = ands(r3, r1);
                r6 = lsls(r5, 29);
                if (beq(110)) return;
            case 90:
                r6 = movs(r6, 15);
                r5 = ands(r5, r6);
                cmp(r5, 4);
                if (beq(110)) return;
            case 98:
                r3 = adds(r3, 4);
                r5 = lsls(r3, 5);
                if (bpl(110)) return;
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
                b(null, 116);
                return;
            case 138:
                r0 = lsls(r5, 9);
                r0 = lsrs(r0, 9);
                b(null, 116);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134346104, size=128, name='__aeabi_ui2f', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(floatunsisf.o)', has_indirect=False)
    protected void __aeabi_ui2f(int offset) throws Exception
    {
        pc = __aeabi_ui2f + offset;
        switch (offset)
        {
            case 0:
                push(true, r4, r5, r6);
                r4 = subs(r0, 0);
                if (beq(112)) return;
            case 6:
                bl(this::__clzsi2, __aeabi_ui2f + 10 | 1, 10);
                return;
            case 10:
                r2 = movs(r2, 158);
                r2 = subs(r2, r0);
                cmp(r2, 150);
                if (bgt(34)) return;
            case 18:
                r2 = uxtb(r2);
                cmp(r0, 8);
                if (ble(118)) return;
            case 24:
                r0 = subs(r0, 8);
                r4 = lsls(r4, r0);
                r0 = lsls(r4, 9);
                r0 = lsrs(r0, 9);
                b(null, 102);
                return;
            case 34:
                cmp(r2, 153);
                if (ble(58)) return;
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
                if (ble(66)) return;
            case 62:
                r3 = subs(r0, 5);
                r4 = lsls(r4, r3);
            case 66:
                r3 = movs(r3, r4);
                r1 = ldr(__aeabi_ui2f + 124);
                r3 = ands(r3, r1);
                r5 = lsls(r4, 29);
                if (beq(96)) return;
            case 76:
                r5 = movs(r5, 15);
                r4 = ands(r4, r5);
                cmp(r4, 4);
                if (beq(96)) return;
            case 84:
                r3 = adds(r3, 4);
                r4 = lsls(r3, 5);
                if (bpl(96)) return;
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
                b(null, 102);
                return;
            case 118:
                r0 = lsls(r4, 9);
                r0 = lsrs(r0, 9);
                b(null, 102);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134346232, size=116, name='__aeabi_i2d', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(floatsidf.o)', has_indirect=False)
    protected void __aeabi_i2d(int offset) throws Exception
    {
        pc = __aeabi_i2d + offset;
        switch (offset)
        {
            case 0:
                push(true, r4, r5, r6);
                cmp(r0, 0);
                if (beq(98)) return;
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
                if (ble(76)) return;
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
                b(null, 42);
                return;
            case 98:
                r4 = movs(r4, 0);
                r3 = movs(r3, 0);
                r5 = movs(r5, 0);
                r2 = movs(r2, 0);
                b(null, 42);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134346348, size=164, name='__aeabi_f2d', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(extendsfdf2.o)', has_indirect=False)
    protected void __aeabi_f2d(int offset) throws Exception
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
                if (ble(62)) return;
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
                if (bne(108)) return;
            case 66:
                cmp(r5, 0);
                if (beq(132)) return;
            case 70:
                r0 = movs(r0, r5);
                bl(this::__clzsi2, __aeabi_f2d + 76 | 1, 76);
                return;
            case 76:
                cmp(r0, 10);
                if (bgt(138)) return;
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
                b(null, 30);
                return;
            case 108:
                cmp(r5, 0);
                if (beq(126)) return;
            case 112:
                r2 = lsrs(r6, 12);
                r6 = movs(r6, 128);
                r6 = lsls(r6, 12);
                r5 = lsls(r5, 29);
                r6 = orrs(r6, r2);
                r3 = ldr(__aeabi_f2d + 160);
                b(null, 30);
                return;
            case 126:
                r3 = ldr(__aeabi_f2d + 160);
                r6 = movs(r6, 0);
                b(null, 30);
                return;
            case 132:
                r3 = movs(r3, 0);
                r6 = movs(r6, 0);
                b(null, 30);
                return;
            case 138:
                r3 = movs(r3, r0);
                r2 = movs(r2, r5);
                r3 = subs(r3, 11);
                r2 = lsls(r2, r3);
                r5 = movs(r5, 0);
                b(null, 94);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134346512, size=264, name='__aeabi_d2f', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(truncdfsf2.o)', has_indirect=False)
    protected void __aeabi_d2f(int offset) throws Exception
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
                if (ble(112)) return;
            case 28:
                r3 = ldr(__aeabi_d2f + 252);
                r7 = adds(r4, r3);
                cmp(r7, 254);
                if (bgt(94)) return;
            case 36:
                cmp(r7, 0);
                if (ble(160)) return;
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
                if (beq(72)) return;
            case 62:
                r2 = movs(r2, 15);
                r2 = ands(r2, r3);
                cmp(r2, 4);
                if (beq(72)) return;
            case 70:
                r3 = adds(r3, 4);
            case 72:
                r2 = movs(r2, 128);
                r2 = lsls(r2, 19);
                r2 = ands(r2, r3);
                if (beq(154)) return;
            case 80:
                r7 = adds(r7, 1);
                r2 = uxtb(r7);
                cmp(r7, 255);
                if (beq(94)) return;
            case 88:
                r3 = lsls(r3, 6);
                r0 = lsrs(r3, 9);
                b(null, 98);
                return;
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
                if (bne(128)) return;
            case 118:
                cmp(r5, 0);
                if (bne(144)) return;
            case 122:
                r2 = movs(r2, 0);
                r0 = movs(r0, 0);
                b(null, 98);
                return;
            case 128:
                cmp(r5, 0);
                if (beq(94)) return;
            case 132:
                r0 = movs(r0, 128);
                r0 = lsls(r0, 15);
                r0 = orrs(r0, r6);
                r2 = movs(r2, 255);
                b(null, 98);
                return;
            case 142:
                r4 = movs(r4, 0);
            case 144:
                r3 = movs(r3, 0);
            case 146:
                r3 = lsls(r3, 9);
                r0 = lsrs(r3, 9);
                r2 = uxtb(r4);
                b(null, 98);
                return;
            case 154:
                r3 = lsrs(r3, 3);
                r4 = movs(r4, r7);
                b(null, 146);
                return;
            case 160:
                r3 = movs(r3, r7);
                r3 = adds(r3, 23);
                if (blt(142)) return;
            case 166:
                r3 = movs(r3, 128);
                r3 = lsls(r3, 16);
                r3 = orrs(r3, r6);
                r6 = movs(r6, 30);
                r6 = subs(r6, r7);
                cmp(r6, 31);
                if (ble(222)) return;
            case 180:
                r2 = movs(r2, 2);
                r2 = rsbs(r2);
                r7 = subs(r2, r7);
                r2 = movs(r2, r3);
                r2 = lsrs(r2, r7);
                r7 = movs(r7, r2);
                cmp(r6, 32);
                if (beq(206)) return;
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
                b(null, 58);
                return;
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
                b(null, 58);
                return;
            default:
                crash();
        }
    }

    // function: Function(address=134346776, size=60, name='__clzsi2', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(_clzsi2.o)', has_indirect=False)
    protected void __clzsi2(int offset) throws Exception
    {
        pc = __clzsi2 + offset;
        switch (offset)
        {
            case 0:
                r1 = movs(r1, 28);
                r3 = movs(r3, 1);
                r3 = lsls(r3, 16);
                cmp(r0, r3);
                if (blo(14)) return;
            case 10:
                r0 = lsrs(r0, 16);
                r1 = subs(r1, 16);
            case 14:
                r3 = lsrs(r3, 8);
                cmp(r0, r3);
                if (blo(24)) return;
            case 20:
                r0 = lsrs(r0, 8);
                r1 = subs(r1, 8);
            case 24:
                r3 = lsrs(r3, 4);
                cmp(r0, r3);
                if (blo(34)) return;
            case 30:
                r0 = lsrs(r0, 4);
                r1 = subs(r1, 4);
            case 34:
                r2 = adr(pc, 8);
                r0 = ldrb(r2 + r0);
                r0 = adds(r0, r1);
                bx(lr);
                return;
            default:
                crash();
        }
    }

} // MicroPython_system
