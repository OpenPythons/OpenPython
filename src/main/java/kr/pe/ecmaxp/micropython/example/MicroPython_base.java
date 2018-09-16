package kr.pe.ecmaxp.micropython.example;

import kr.pe.ecmaxp.thumbjk.KotlinCPU;
import kr.pe.ecmaxp.thumbsk.CPU;
import org.jetbrains.annotations.NotNull;

abstract public class MicroPython_base extends KotlinCPU
{
    public MicroPython_base(@NotNull CPU cpu)
    {
        super(cpu);
    }

    // function: Function(address=134217740, size=20, name='nlr_push_tail', path='build/py/nlr.o', joint_set={0}, stop_set={14})
    abstract protected void nlr_push_tail(int offset) throws Exception;
    protected int nlr_push_tail = 0x0800000c;
    public void nlr_push_tail() throws Exception
    {
        call(this.nlr_push_tail, this::nlr_push_tail);
    }


    // function: Function(address=134217760, size=16, name='nlr_pop', path='build/py/nlr.o', joint_set={0}, stop_set={8})
    abstract protected void nlr_pop(int offset) throws Exception;
    protected int nlr_pop = 0x08000020;
    public void nlr_pop() throws Exception
    {
        call(this.nlr_pop, this::nlr_pop);
    }


    // function: Function(address=134217776, size=40, name='nlr_push', path='build/py/nlrthumb.o', joint_set={0}, stop_set={34})
    abstract protected void nlr_push(int offset) throws Exception;
    protected int nlr_push = 0x08000030;
    public void nlr_push() throws Exception
    {
        call(this.nlr_push, this::nlr_push);
    }


    // function: Function(address=134217816, size=68, name='nlr_jump', path='build/py/nlrthumb.o', joint_set={0, 10, 14}, stop_set={10, 60})
    abstract protected void nlr_jump(int offset) throws Exception;
    protected int nlr_jump = 0x08000058;
    public void nlr_jump() throws Exception
    {
        call(this.nlr_jump, this::nlr_jump);
    }


    // function: Function(address=134217884, size=64, name='m_malloc', path='build/py/malloc.o', joint_set={0, 10, 14, 18, 54, 24, 56}, stop_set={56})
    abstract protected void m_malloc(int offset) throws Exception;
    protected int m_malloc = 0x0800009c;
    public void m_malloc() throws Exception
    {
        call(this.m_malloc, this::m_malloc);
    }


    // function: Function(address=134217948, size=48, name='m_malloc_maybe', path='build/py/malloc.o', joint_set={0, 10, 40, 42}, stop_set={42})
    abstract protected void m_malloc_maybe(int offset) throws Exception;
    protected int m_malloc_maybe = 0x080000dc;
    public void m_malloc_maybe() throws Exception
    {
        call(this.m_malloc_maybe, this::m_malloc_maybe);
    }


    // function: Function(address=134217996, size=8, name='m_malloc0', path='build/py/malloc.o', joint_set={0, 6}, stop_set={6})
    abstract protected void m_malloc0(int offset) throws Exception;
    protected int m_malloc0 = 0x0800010c;
    public void m_malloc0() throws Exception
    {
        call(this.m_malloc0, this::m_malloc0);
    }


    // function: Function(address=134218004, size=68, name='m_realloc', path='build/py/malloc.o', joint_set={0, 14, 60, 18, 22, 28, 62}, stop_set={62})
    abstract protected void m_realloc(int offset) throws Exception;
    protected int m_realloc = 0x08000114;
    public void m_realloc() throws Exception
    {
        call(this.m_realloc, this::m_realloc);
    }


    // function: Function(address=134218072, size=64, name='m_realloc_maybe', path='build/py/malloc.o', joint_set={0, 14, 18, 54, 22, 56}, stop_set={56})
    abstract protected void m_realloc_maybe(int offset) throws Exception;
    protected int m_realloc_maybe = 0x08000158;
    public void m_realloc_maybe() throws Exception
    {
        call(this.m_realloc_maybe, this::m_realloc_maybe);
    }


    // function: Function(address=134218136, size=28, name='m_free', path='build/py/malloc.o', joint_set={0, 8}, stop_set={20})
    abstract protected void m_free(int offset) throws Exception;
    protected int m_free = 0x08000198;
    public void m_free() throws Exception
    {
        call(this.m_free, this::m_free);
    }


    // function: Function(address=134218164, size=16, name='m_get_total_bytes_allocated', path='build/py/malloc.o', joint_set={0}, stop_set={8})
    abstract protected void m_get_total_bytes_allocated(int offset) throws Exception;
    protected int m_get_total_bytes_allocated = 0x080001b4;
    public void m_get_total_bytes_allocated() throws Exception
    {
        call(this.m_get_total_bytes_allocated, this::m_get_total_bytes_allocated);
    }


    // function: Function(address=134218180, size=16, name='m_get_current_bytes_allocated', path='build/py/malloc.o', joint_set={0}, stop_set={8})
    abstract protected void m_get_current_bytes_allocated(int offset) throws Exception;
    protected int m_get_current_bytes_allocated = 0x080001c4;
    public void m_get_current_bytes_allocated() throws Exception
    {
        call(this.m_get_current_bytes_allocated, this::m_get_current_bytes_allocated);
    }


    // function: Function(address=134218196, size=16, name='m_get_peak_bytes_allocated', path='build/py/malloc.o', joint_set={0}, stop_set={8})
    abstract protected void m_get_peak_bytes_allocated(int offset) throws Exception;
    protected int m_get_peak_bytes_allocated = 0x080001d4;
    public void m_get_peak_bytes_allocated() throws Exception
    {
        call(this.m_get_peak_bytes_allocated, this::m_get_peak_bytes_allocated);
    }


    // function: Function(address=134218212, size=240, name='gc_mark_subtree', path='build/py/gc.o', joint_set={0, 32, 224, 192, 100, 90, 38, 108, 78, 142, 174, 210, 148, 84, 154, 60}, stop_set={232, 172, 222, 208})
    abstract protected void gc_mark_subtree(int offset) throws Exception;
    protected int gc_mark_subtree = 0x080001e4;
    public void gc_mark_subtree() throws Exception
    {
        call(this.gc_mark_subtree, this::gc_mark_subtree);
    }


    // function: Function(address=134218452, size=128, name='gc_init', path='build/py/gc.o', joint_set={0, 26, 90, 74}, stop_set={122})
    abstract protected void gc_init(int offset) throws Exception;
    protected int gc_init = 0x080002d4;
    public void gc_init() throws Exception
    {
        call(this.gc_init, this::gc_init);
    }


    // function: Function(address=134218580, size=20, name='gc_lock', path='build/py/gc.o', joint_set={0}, stop_set={12})
    abstract protected void gc_lock(int offset) throws Exception;
    protected int gc_lock = 0x08000354;
    public void gc_lock() throws Exception
    {
        call(this.gc_lock, this::gc_lock);
    }


    // function: Function(address=134218600, size=20, name='gc_unlock', path='build/py/gc.o', joint_set={0}, stop_set={12})
    abstract protected void gc_unlock(int offset) throws Exception;
    protected int gc_unlock = 0x08000368;
    public void gc_unlock() throws Exception
    {
        call(this.gc_unlock, this::gc_unlock);
    }


    // function: Function(address=134218620, size=20, name='gc_is_locked', path='build/py/gc.o', joint_set={0}, stop_set={14})
    abstract protected void gc_is_locked(int offset) throws Exception;
    protected int gc_is_locked = 0x0800037c;
    public void gc_is_locked() throws Exception
    {
        call(this.gc_is_locked, this::gc_is_locked);
    }


    // function: Function(address=134218640, size=276, name='gc_collect_start', path='build/py/gc.o', joint_set={0, 224, 128, 160, 58, 64, 154, 168, 218, 138, 72, 236, 270, 176, 80, 122, 252, 254}, stop_set={234, 252, 270})
    abstract protected void gc_collect_start(int offset) throws Exception;
    protected int gc_collect_start = 0x08000390;
    public void gc_collect_start() throws Exception
    {
        call(this.gc_collect_start, this::gc_collect_start);
    }


    // function: Function(address=134218916, size=136, name='gc_collect_root', path='build/py/gc.o', joint_set={0, 96, 128, 36, 102, 44, 14, 112, 54, 30}, stop_set={128, 110})
    abstract protected void gc_collect_root(int offset) throws Exception;
    protected int gc_collect_root = 0x080004a4;
    public void gc_collect_root() throws Exception
    {
        call(this.gc_collect_root, this::gc_collect_root);
    }


    // function: Function(address=134219052, size=412, name='gc_collect_end', path='build/py/gc.o', joint_set={0, 388, 150, 284, 160, 34, 38, 300, 48, 178, 182, 310, 56, 186, 316, 192, 320, 328, 332, 76, 82, 88, 222, 94, 352, 228, 106, 112, 118, 374, 248}, stop_set={386, 110, 176, 148, 406, 246, 86})
    abstract protected void gc_collect_end(int offset) throws Exception;
    protected int gc_collect_end = 0x0800052c;
    public void gc_collect_end() throws Exception
    {
        call(this.gc_collect_end, this::gc_collect_end);
    }


    // function: Function(address=134219464, size=280, name='gc_info', path='build/py/gc.o', joint_set={0, 260, 136, 140, 144, 148, 154, 160, 162, 166, 170, 176, 184, 188, 196, 76, 94, 222, 98, 102, 238, 112, 118, 250, 254}, stop_set={258, 236, 174, 272, 182, 248, 220})
    abstract protected void gc_info(int offset) throws Exception;
    protected int gc_info = 0x080006c8;
    public void gc_info() throws Exception
    {
        call(this.gc_info, this::gc_info);
    }


    // function: Function(address=134219744, size=460, name='gc_alloc', path='build/py/gc.o', joint_set={0, 128, 386, 134, 264, 136, 142, 22, 150, 158, 418, 34, 290, 166, 172, 48, 304, 434, 180, 440, 186, 190, 446, 66, 340, 214, 90, 220, 96, 102, 108, 110, 238, 240, 124, 242, 116, 122, 380, 254}, stop_set={450, 134, 122, 108, 238, 432, 438, 88, 218, 444})
    abstract protected void gc_alloc(int offset) throws Exception;
    protected int gc_alloc = 0x080007e0;
    public void gc_alloc() throws Exception
    {
        call(this.gc_alloc, this::gc_alloc);
    }


    // function: Function(address=134220204, size=132, name='gc_free', path='build/py/gc.o', joint_set={0, 64, 14, 78, 18, 120, 122}, stop_set={120, 124})
    abstract protected void gc_free(int offset) throws Exception;
    protected int gc_free = 0x080009ac;
    public void gc_free() throws Exception
    {
        call(this.gc_free, this::gc_free);
    }


    // function: Function(address=134220336, size=108, name='gc_nbytes', path='build/py/gc.o', joint_set={0, 96, 98, 38, 72, 74, 12, 26}, stop_set={100})
    abstract protected void gc_nbytes(int offset) throws Exception;
    protected int gc_nbytes = 0x08000a30;
    public void gc_nbytes() throws Exception
    {
        call(this.gc_nbytes, this::gc_nbytes);
    }


    // function: Function(address=134220444, size=680, name='gc_realloc', path='build/py/gc.o', joint_set={0, 128, 514, 388, 516, 262, 390, 138, 522, 268, 140, 526, 144, 528, 274, 146, 276, 148, 22, 662, 664, 20, 538, 410, 156, 158, 36, 550, 40, 168, 552, 184, 442, 328, 332, 460, 462, 78, 80, 598, 470, 346, 602, 220, 478, 482, 102, 618, 236, 240, 244, 246, 124}, stop_set={672, 480, 514, 388, 260, 550, 460, 238, 526, 78, 146, 274, 468, 20, 662, 156})
    abstract protected void gc_realloc(int offset) throws Exception;
    protected int gc_realloc = 0x08000a9c;
    public void gc_realloc() throws Exception
    {
        call(this.gc_realloc, this::gc_realloc);
    }


    // function: Function(address=134221124, size=316, name='gc_dump_info', path='build/py/gc.o', joint_set={0, 128, 132, 260, 136, 276, 154, 158, 286, 160, 164, 168, 172, 178, 186, 196, 198, 70, 88, 92, 222, 96, 104, 238, 110, 252}, stop_set={258, 296, 170, 274, 184, 250, 284})
    abstract protected void gc_dump_info(int offset) throws Exception;
    protected int gc_dump_info = 0x08000d44;
    public void gc_dump_info() throws Exception
    {
        call(this.gc_dump_info, this::gc_dump_info);
    }


    // function: Function(address=134221440, size=452, name='gc_dump_alloc_table', path='build/py/gc.o', joint_set={0, 130, 260, 266, 272, 146, 278, 154, 284, 34, 290, 296, 170, 44, 46, 176, 178, 184, 314, 58, 318, 322, 194, 328, 78, 336, 82, 212, 86, 88, 218, 350, 96, 354, 358, 232, 234, 362, 110, 366, 370, 374, 248, 126, 254}, stop_set={320, 352, 312, 356, 326, 360, 232, 364, 44, 368, 372, 316, 376, 56, 348, 152})
    abstract protected void gc_dump_alloc_table(int offset) throws Exception;
    protected int gc_dump_alloc_table = 0x08000e80;
    public void gc_dump_alloc_table() throws Exception
    {
        call(this.gc_dump_alloc_table, this::gc_dump_alloc_table);
    }


    // function: Function(address=134221892, size=16, name='mp_pystack_init', path='build/py/pystack.o', joint_set={0}, stop_set={8})
    abstract protected void mp_pystack_init(int offset) throws Exception;
    protected int mp_pystack_init = 0x08001044;
    public void mp_pystack_init() throws Exception
    {
        call(this.mp_pystack_init, this::mp_pystack_init);
    }


    // function: Function(address=134221908, size=48, name='mp_pystack_alloc', path='build/py/pystack.o', joint_set={0, 34, 20, 30}, stop_set={36, 30})
    abstract protected void mp_pystack_alloc(int offset) throws Exception;
    protected int mp_pystack_alloc = 0x08001054;
    public void mp_pystack_alloc() throws Exception
    {
        call(this.mp_pystack_alloc, this::mp_pystack_alloc);
    }


    // function: Function(address=134221956, size=28, name='find_qstr', path='build/py/qstr.o', joint_set={0, 10, 20, 4}, stop_set={18, 22})
    abstract protected void find_qstr(int offset) throws Exception;
    protected int find_qstr = 0x08001084;
    public void find_qstr() throws Exception
    {
        call(this.find_qstr, this::find_qstr);
    }


    // function: Function(address=134221984, size=36, name='qstr_compute_hash', path='build/py/qstr.o', joint_set={0, 4, 8, 14, 16, 18}, stop_set={16, 28})
    abstract protected void qstr_compute_hash(int offset) throws Exception;
    protected int qstr_compute_hash = 0x080010a0;
    public void qstr_compute_hash() throws Exception
    {
        call(this.qstr_compute_hash, this::qstr_compute_hash);
    }


    // function: Function(address=134222020, size=24, name='qstr_init', path='build/py/qstr.o', joint_set={0}, stop_set={14})
    abstract protected void qstr_init(int offset) throws Exception;
    protected int qstr_init = 0x080010c4;
    public void qstr_init() throws Exception
    {
        call(this.qstr_init, this::qstr_init);
    }


    // function: Function(address=134222044, size=108, name='qstr_find_strn', path='build/py/qstr.o', joint_set={0, 98, 66, 40, 72, 12, 46, 50, 82, 18, 86, 22, 26, 94}, stop_set={96, 24, 48, 100})
    abstract protected void qstr_find_strn(int offset) throws Exception;
    protected int qstr_find_strn = 0x080010dc;
    public void qstr_find_strn() throws Exception
    {
        call(this.qstr_find_strn, this::qstr_find_strn);
    }


    // function: Function(address=134222152, size=296, name='qstr_from_strn', path='build/py/qstr.o', joint_set={0, 136, 266, 138, 12, 142, 16, 18, 150, 286, 162, 34, 52, 58, 188, 62, 210, 84, 86, 226, 98, 104, 234, 106, 240, 112, 246, 120, 126}, stop_set={16, 290, 148, 244})
    abstract protected void qstr_from_strn(int offset) throws Exception;
    protected int qstr_from_strn = 0x08001148;
    public void qstr_from_strn() throws Exception
    {
        call(this.qstr_from_strn, this::qstr_from_strn);
    }


    // function: Function(address=134222448, size=18, name='qstr_from_str', path='build/py/qstr.o', joint_set={0, 8, 16}, stop_set={16})
    abstract protected void qstr_from_str(int offset) throws Exception;
    protected int qstr_from_str = 0x08001270;
    public void qstr_from_str() throws Exception
    {
        call(this.qstr_from_str, this::qstr_from_str);
    }


    // function: Function(address=134222466, size=16, name='qstr_hash', path='build/py/qstr.o', joint_set={0, 6}, stop_set={14})
    abstract protected void qstr_hash(int offset) throws Exception;
    protected int qstr_hash = 0x08001282;
    public void qstr_hash() throws Exception
    {
        call(this.qstr_hash, this::qstr_hash);
    }


    // function: Function(address=134222482, size=10, name='qstr_len', path='build/py/qstr.o', joint_set={0, 6}, stop_set={8})
    abstract protected void qstr_len(int offset) throws Exception;
    protected int qstr_len = 0x08001292;
    public void qstr_len() throws Exception
    {
        call(this.qstr_len, this::qstr_len);
    }


    // function: Function(address=134222492, size=10, name='qstr_str', path='build/py/qstr.o', joint_set={0, 6}, stop_set={8})
    abstract protected void qstr_str(int offset) throws Exception;
    protected int qstr_str = 0x0800129c;
    public void qstr_str() throws Exception
    {
        call(this.qstr_str, this::qstr_str);
    }


    // function: Function(address=134222502, size=16, name='qstr_data', path='build/py/qstr.o', joint_set={0, 8}, stop_set={14})
    abstract protected void qstr_data(int offset) throws Exception;
    protected int qstr_data = 0x080012a6;
    public void qstr_data() throws Exception
    {
        call(this.qstr_data, this::qstr_data);
    }


    // function: Function(address=134222520, size=120, name='qstr_pool_info', path='build/py/qstr.o', joint_set={0, 96, 34, 44, 76, 80, 86, 24, 28}, stop_set={42, 108, 94})
    abstract protected void qstr_pool_info(int offset) throws Exception;
    protected int qstr_pool_info = 0x080012b8;
    public void qstr_pool_info() throws Exception
    {
        call(this.qstr_pool_info, this::qstr_pool_info);
    }


    // function: Function(address=134222640, size=68, name='qstr_dump_data', path='build/py/qstr.o', joint_set={0, 32, 36, 6, 10, 16, 48, 18, 28}, stop_set={16, 48, 34})
    abstract protected void qstr_dump_data(int offset) throws Exception;
    protected int qstr_dump_data = 0x08001330;
    public void qstr_dump_data() throws Exception
    {
        call(this.qstr_dump_data, this::qstr_dump_data);
    }


    // function: Function(address=134222708, size=56, name='vstr_ensure_extra', path='build/py/vstr.o', joint_set={0, 44, 14, 48, 20, 28}, stop_set={48, 24})
    abstract protected void vstr_ensure_extra(int offset) throws Exception;
    protected int vstr_ensure_extra = 0x08001374;
    public void vstr_ensure_extra() throws Exception
    {
        call(this.vstr_ensure_extra, this::vstr_ensure_extra);
    }


    // function: Function(address=134222764, size=36, name='vstr_add_strn', path='build/py/vstr.o', joint_set={0, 28, 14}, stop_set={34})
    abstract protected void vstr_add_strn(int offset) throws Exception;
    protected int vstr_add_strn = 0x080013ac;
    public void vstr_add_strn() throws Exception
    {
        call(this.vstr_add_strn, this::vstr_add_strn);
    }


    // function: Function(address=134222800, size=48, name='vstr_ins_blank_bytes_constprop_2', path='build/py/vstr.o', joint_set={0, 36, 12, 14, 22}, stop_set={46})
    abstract protected void vstr_ins_blank_bytes_constprop_2(int offset) throws Exception;
    protected int vstr_ins_blank_bytes_constprop_2 = 0x080013d0;
    public void vstr_ins_blank_bytes_constprop_2() throws Exception
    {
        call(this.vstr_ins_blank_bytes_constprop_2, this::vstr_ins_blank_bytes_constprop_2);
    }


    // function: Function(address=134222848, size=34, name='vstr_init', path='build/py/vstr.o', joint_set={0, 8, 10, 22}, stop_set={32})
    abstract protected void vstr_init(int offset) throws Exception;
    protected int vstr_init = 0x08001400;
    public void vstr_init() throws Exception
    {
        call(this.vstr_init, this::vstr_init);
    }


    // function: Function(address=134222882, size=16, name='vstr_init_len', path='build/py/vstr.o', joint_set={0, 12}, stop_set={14})
    abstract protected void vstr_init_len(int offset) throws Exception;
    protected int vstr_init_len = 0x08001422;
    public void vstr_init_len() throws Exception
    {
        call(this.vstr_init_len, this::vstr_init_len);
    }


    // function: Function(address=134222898, size=18, name='vstr_init_fixed_buf', path='build/py/vstr.o', joint_set={0}, stop_set={16})
    abstract protected void vstr_init_fixed_buf(int offset) throws Exception;
    protected int vstr_init_fixed_buf = 0x08001432;
    public void vstr_init_fixed_buf() throws Exception
    {
        call(this.vstr_init_fixed_buf, this::vstr_init_fixed_buf);
    }


    // function: Function(address=134222916, size=24, name='vstr_init_print', path='build/py/vstr.o', joint_set={0, 10}, stop_set={16})
    abstract protected void vstr_init_print(int offset) throws Exception;
    protected int vstr_init_print = 0x08001444;
    public void vstr_init_print() throws Exception
    {
        call(this.vstr_init_print, this::vstr_init_print);
    }


    // function: Function(address=134222940, size=24, name='vstr_clear', path='build/py/vstr.o', joint_set={0, 18, 10}, stop_set={22})
    abstract protected void vstr_clear(int offset) throws Exception;
    protected int vstr_clear = 0x0800145c;
    public void vstr_clear() throws Exception
    {
        call(this.vstr_clear, this::vstr_clear);
    }


    // function: Function(address=134222964, size=22, name='vstr_new', path='build/py/vstr.o', joint_set={0, 10, 18}, stop_set={20})
    abstract protected void vstr_new(int offset) throws Exception;
    protected int vstr_new = 0x08001474;
    public void vstr_new() throws Exception
    {
        call(this.vstr_new, this::vstr_new);
    }


    // function: Function(address=134222986, size=30, name='vstr_free', path='build/py/vstr.o', joint_set={0, 6, 12, 20, 28}, stop_set={28})
    abstract protected void vstr_free(int offset) throws Exception;
    protected int vstr_free = 0x0800148a;
    public void vstr_free() throws Exception
    {
        call(this.vstr_free, this::vstr_free);
    }


    // function: Function(address=134223016, size=48, name='vstr_extend', path='build/py/vstr.o', joint_set={0, 32, 20, 12}, stop_set={16, 42})
    abstract protected void vstr_extend(int offset) throws Exception;
    protected int vstr_extend = 0x080014a8;
    public void vstr_extend() throws Exception
    {
        call(this.vstr_extend, this::vstr_extend);
    }


    // function: Function(address=134223064, size=22, name='vstr_add_len', path='build/py/vstr.o', joint_set={0, 10}, stop_set={20})
    abstract protected void vstr_add_len(int offset) throws Exception;
    protected int vstr_add_len = 0x080014d8;
    public void vstr_add_len() throws Exception
    {
        call(this.vstr_add_len, this::vstr_add_len);
    }


    // function: Function(address=134223086, size=30, name='vstr_null_terminated_str', path='build/py/vstr.o', joint_set={0, 18, 12}, stop_set={28})
    abstract protected void vstr_null_terminated_str(int offset) throws Exception;
    protected int vstr_null_terminated_str = 0x080014ee;
    public void vstr_null_terminated_str() throws Exception
    {
        call(this.vstr_null_terminated_str, this::vstr_null_terminated_str);
    }


    // function: Function(address=134223116, size=14, name='vstr_add_byte', path='build/py/vstr.o', joint_set={0, 10}, stop_set={12})
    abstract protected void vstr_add_byte(int offset) throws Exception;
    protected int vstr_add_byte = 0x0800150c;
    public void vstr_add_byte() throws Exception
    {
        call(this.vstr_add_byte, this::vstr_add_byte);
    }


    // function: Function(address=134223132, size=152, name='vstr_add_char', path='build/py/vstr.o', joint_set={0, 64, 10, 44, 110, 16, 18, 50, 116, 20, 86, 94}, stop_set={108, 18, 140, 62})
    abstract protected void vstr_add_char(int offset) throws Exception;
    protected int vstr_add_char = 0x0800151c;
    public void vstr_add_char() throws Exception
    {
        call(this.vstr_add_char, this::vstr_add_char);
    }


    // function: Function(address=134223284, size=24, name='vstr_add_str', path='build/py/vstr.o', joint_set={0, 12, 22}, stop_set={22})
    abstract protected void vstr_add_str(int offset) throws Exception;
    protected int vstr_add_str = 0x080015b4;
    public void vstr_add_str() throws Exception
    {
        call(this.vstr_add_str, this::vstr_add_str);
    }


    // function: Function(address=134223308, size=12, name='vstr_ins_byte', path='build/py/vstr.o', joint_set={0, 8}, stop_set={10})
    abstract protected void vstr_ins_byte(int offset) throws Exception;
    protected int vstr_ins_byte = 0x080015cc;
    public void vstr_ins_byte() throws Exception
    {
        call(this.vstr_ins_byte, this::vstr_ins_byte);
    }


    // function: Function(address=134223320, size=12, name='vstr_ins_char', path='build/py/vstr.o', joint_set={0, 8}, stop_set={10})
    abstract protected void vstr_ins_char(int offset) throws Exception;
    protected int vstr_ins_char = 0x080015d8;
    public void vstr_ins_char() throws Exception
    {
        call(this.vstr_ins_char, this::vstr_ins_char);
    }


    // function: Function(address=134223332, size=16, name='vstr_cut_tail_bytes', path='build/py/vstr.o', joint_set={0, 8, 12, 6}, stop_set={10, 14})
    abstract protected void vstr_cut_tail_bytes(int offset) throws Exception;
    protected int vstr_cut_tail_bytes = 0x080015e4;
    public void vstr_cut_tail_bytes() throws Exception
    {
        call(this.vstr_cut_tail_bytes, this::vstr_cut_tail_bytes);
    }


    // function: Function(address=134223348, size=46, name='vstr_cut_out_bytes', path='build/py/vstr.o', joint_set={0, 38, 14, 20, 22, 24}, stop_set={44, 22})
    abstract protected void vstr_cut_out_bytes(int offset) throws Exception;
    protected int vstr_cut_out_bytes = 0x080015f4;
    public void vstr_cut_out_bytes() throws Exception
    {
        call(this.vstr_cut_out_bytes, this::vstr_cut_out_bytes);
    }


    // function: Function(address=134223394, size=12, name='plat_print_strn', path='build/py/mpprint.o', joint_set={0, 10}, stop_set={10})
    abstract protected void plat_print_strn(int offset) throws Exception;
    protected int plat_print_strn = 0x08001622;
    public void plat_print_strn() throws Exception
    {
        call(this.plat_print_strn, this::plat_print_strn);
    }


    // function: Function(address=134223406, size=30, name='mp_print_str', path='build/py/mpprint.o', joint_set={0, 16, 26, 12}, stop_set={28})
    abstract protected void mp_print_str(int offset) throws Exception;
    protected int mp_print_str = 0x0800162e;
    public void mp_print_str() throws Exception
    {
        call(this.mp_print_str, this::mp_print_str);
    }


    // function: Function(address=134223436, size=184, name='mp_print_strn', path='build/py/mpprint.o', joint_set={0, 138, 144, 146, 152, 156, 28, 32, 162, 166, 38, 170, 46, 54, 58, 60, 68, 70, 88, 94, 108, 112, 114, 120, 122}, stop_set={164, 168, 172, 142, 150, 154})
    abstract protected void mp_print_strn(int offset) throws Exception;
    protected int mp_print_strn = 0x0800164c;
    public void mp_print_strn() throws Exception
    {
        call(this.mp_print_strn, this::mp_print_strn);
    }


    // function: Function(address=134223620, size=218, name='mp_print_int', path='build/py/mpprint.o', joint_set={0, 136, 142, 158, 32, 36, 166, 42, 50, 56, 188, 66, 194, 70, 198, 202, 206, 212, 86, 94, 96, 100, 102, 104, 108, 120}, stop_set={192, 200, 94, 216})
    abstract protected void mp_print_int(int offset) throws Exception;
    protected int mp_print_int = 0x08001704;
    public void mp_print_int() throws Exception
    {
        call(this.mp_print_int, this::mp_print_int);
    }


    // function: Function(address=134223840, size=576, name='mp_print_mp_int', path='build/py/mpprint.o', joint_set={0, 512, 256, 130, 518, 262, 394, 138, 524, 266, 526, 142, 402, 276, 534, 150, 152, 408, 536, 24, 28, 548, 36, 294, 550, 426, 42, 556, 48, 304, 562, 436, 54, 312, 442, 314, 186, 60, 446, 190, 320, 68, 70, 328, 74, 332, 204, 80, 466, 472, 344, 88, 220, 92, 98, 228, 102, 230, 490, 362, 364, 492, 250, 108, 368, 112, 124, 500, 118, 248, 506, 380}, stop_set={516, 228, 260, 136, 554, 524, 274, 564, 254, 248, 122, 510})
    abstract protected void mp_print_mp_int(int offset) throws Exception;
    protected int mp_print_mp_int = 0x080017e0;
    public void mp_print_mp_int() throws Exception
    {
        call(this.mp_print_mp_int, this::mp_print_mp_int);
    }


    // function: Function(address=134224416, size=138, name='mp_print_float', path='build/py/mpprint.o', joint_set={0, 98, 68, 132, 76, 46, 114, 52, 86, 22, 58, 28}, stop_set={136})
    abstract protected void mp_print_float(int offset) throws Exception;
    protected int mp_print_float = 0x08001a20;
    public void mp_print_float() throws Exception
    {
        call(this.mp_print_float, this::mp_print_float);
    }


    // function: Function(address=134224556, size=672, name='mp_vprintf', path='build/py/mpprint.o', joint_set={0, 130, 134, 522, 10, 394, 138, 654, 270, 272, 400, 18, 146, 404, 276, 22, 278, 534, 408, 280, 540, 284, 30, 542, 286, 28, 162, 418, 292, 294, 424, 426, 556, 174, 46, 178, 54, 56, 442, 186, 12, 62, 318, 576, 66, 452, 324, 70, 326, 580, 196, 330, 208, 466, 472, 602, 474, 94, 222, 610, 482, 356, 612, 656, 230, 102, 100, 362, 98, 364, 110, 368, 498, 114, 372, 118, 246, 632, 122, 126}, stop_set={132, 392, 520, 654, 270, 144, 276, 660, 28, 292, 554, 440, 60, 316, 578, 68, 220, 92, 480, 610, 354, 228, 108, 496, 116, 124})
    abstract protected void mp_vprintf(int offset) throws Exception;
    protected int mp_vprintf = 0x08001aac;
    public void mp_vprintf() throws Exception
    {
        call(this.mp_vprintf, this::mp_vprintf);
    }


    // function: Function(address=134225228, size=22, name='mp_printf', path='build/py/mpprint.o', joint_set={0, 14}, stop_set={20})
    abstract protected void mp_printf(int offset) throws Exception;
    protected int mp_printf = 0x08001d4c;
    public void mp_printf() throws Exception
    {
        call(this.mp_printf, this::mp_printf);
    }


    // function: Function(address=134225250, size=54, name='utf8_get_char', path='build/py/unicode.o', joint_set={0, 34, 38, 10, 44, 16, 20, 24}, stop_set={42, 36, 52})
    abstract protected void utf8_get_char(int offset) throws Exception;
    protected int utf8_get_char = 0x08001d62;
    public void utf8_get_char() throws Exception
    {
        call(this.utf8_get_char, this::utf8_get_char);
    }


    // function: Function(address=134225304, size=18, name='utf8_next_char', path='build/py/unicode.o', joint_set={0, 4, 12, 14}, stop_set={16, 12})
    abstract protected void utf8_next_char(int offset) throws Exception;
    protected int utf8_next_char = 0x08001d98;
    public void utf8_next_char() throws Exception
    {
        call(this.utf8_next_char, this::utf8_next_char);
    }


    // function: Function(address=134225322, size=30, name='utf8_ptr_to_index', path='build/py/unicode.o', joint_set={0, 10, 14, 6}, stop_set={28, 12})
    abstract protected void utf8_ptr_to_index(int offset) throws Exception;
    protected int utf8_ptr_to_index = 0x08001daa;
    public void utf8_ptr_to_index() throws Exception
    {
        call(this.utf8_ptr_to_index, this::utf8_ptr_to_index);
    }


    // function: Function(address=134225352, size=32, name='utf8_charlen', path='build/py/unicode.o', joint_set={0, 16, 10, 14}, stop_set={30, 14})
    abstract protected void utf8_charlen(int offset) throws Exception;
    protected int utf8_charlen = 0x08001dc8;
    public void utf8_charlen() throws Exception
    {
        call(this.utf8_charlen, this::utf8_charlen);
    }


    // function: Function(address=134225384, size=24, name='unichar_isspace', path='build/py/unicode.o', joint_set={0, 14, 6}, stop_set={16})
    abstract protected void unichar_isspace(int offset) throws Exception;
    protected int unichar_isspace = 0x08001de8;
    public void unichar_isspace() throws Exception
    {
        call(this.unichar_isspace, this::unichar_isspace);
    }


    // function: Function(address=134225408, size=24, name='unichar_isalpha', path='build/py/unicode.o', joint_set={0, 14, 6}, stop_set={16})
    abstract protected void unichar_isalpha(int offset) throws Exception;
    protected int unichar_isalpha = 0x08001e00;
    public void unichar_isalpha() throws Exception
    {
        call(this.unichar_isalpha, this::unichar_isalpha);
    }


    // function: Function(address=134225432, size=24, name='unichar_isdigit', path='build/py/unicode.o', joint_set={0, 14, 6}, stop_set={16})
    abstract protected void unichar_isdigit(int offset) throws Exception;
    protected int unichar_isdigit = 0x08001e18;
    public void unichar_isdigit() throws Exception
    {
        call(this.unichar_isdigit, this::unichar_isdigit);
    }


    // function: Function(address=134225456, size=24, name='unichar_isxdigit', path='build/py/unicode.o', joint_set={0, 14, 6}, stop_set={16})
    abstract protected void unichar_isxdigit(int offset) throws Exception;
    protected int unichar_isxdigit = 0x08001e30;
    public void unichar_isxdigit() throws Exception
    {
        call(this.unichar_isxdigit, this::unichar_isxdigit);
    }


    // function: Function(address=134225480, size=32, name='unichar_isident', path='build/py/unicode.o', joint_set={0, 24, 18, 6}, stop_set={26})
    abstract protected void unichar_isident(int offset) throws Exception;
    protected int unichar_isident = 0x08001e48;
    public void unichar_isident() throws Exception
    {
        call(this.unichar_isident, this::unichar_isident);
    }


    // function: Function(address=134225512, size=24, name='unichar_isupper', path='build/py/unicode.o', joint_set={0, 14, 6}, stop_set={16})
    abstract protected void unichar_isupper(int offset) throws Exception;
    protected int unichar_isupper = 0x08001e68;
    public void unichar_isupper() throws Exception
    {
        call(this.unichar_isupper, this::unichar_isupper);
    }


    // function: Function(address=134225536, size=24, name='unichar_islower', path='build/py/unicode.o', joint_set={0, 14, 6}, stop_set={16})
    abstract protected void unichar_islower(int offset) throws Exception;
    protected int unichar_islower = 0x08001e80;
    public void unichar_islower() throws Exception
    {
        call(this.unichar_islower, this::unichar_islower);
    }


    // function: Function(address=134225560, size=18, name='unichar_tolower', path='build/py/unicode.o', joint_set={0, 8, 12, 14}, stop_set={16})
    abstract protected void unichar_tolower(int offset) throws Exception;
    protected int unichar_tolower = 0x08001e98;
    public void unichar_tolower() throws Exception
    {
        call(this.unichar_tolower, this::unichar_tolower);
    }


    // function: Function(address=134225578, size=18, name='unichar_toupper', path='build/py/unicode.o', joint_set={0, 8, 12, 14}, stop_set={16})
    abstract protected void unichar_toupper(int offset) throws Exception;
    protected int unichar_toupper = 0x08001eaa;
    public void unichar_toupper() throws Exception
    {
        call(this.unichar_toupper, this::unichar_toupper);
    }


    // function: Function(address=134225596, size=14, name='unichar_xdigit_value', path='build/py/unicode.o', joint_set={0, 12, 6}, stop_set={12})
    abstract protected void unichar_xdigit_value(int offset) throws Exception;
    protected int unichar_xdigit_value = 0x08001ebc;
    public void unichar_xdigit_value() throws Exception
    {
        call(this.unichar_xdigit_value, this::unichar_xdigit_value);
    }


    // function: Function(address=134225610, size=78, name='utf8_check', path='build/py/unicode.o', joint_set={0, 64, 36, 70, 40, 74, 44, 12, 48, 16, 52, 22, 24, 30}, stop_set={72, 42, 76, 22, 62})
    abstract protected void utf8_check(int offset) throws Exception;
    protected int utf8_check = 0x08001eca;
    public void utf8_check() throws Exception
    {
        call(this.utf8_check, this::utf8_check);
    }


    // function: Function(address=134225688, size=20, name='mpn_remove_trailing_zeros', path='build/py/mpz.o', joint_set={0, 12, 6}, stop_set={18})
    abstract protected void mpn_remove_trailing_zeros(int offset) throws Exception;
    protected int mpn_remove_trailing_zeros = 0x08001f18;
    public void mpn_remove_trailing_zeros() throws Exception
    {
        call(this.mpn_remove_trailing_zeros, this::mpn_remove_trailing_zeros);
    }


    // function: Function(address=134225708, size=62, name='text_mpn_shr', path='build/py/mpz.o', joint_set={0, 36, 10, 52, 22, 58, 30}, stop_set={60})
    abstract protected void text_mpn_shr(int offset) throws Exception;
    protected int text_mpn_shr = 0x08001f2c;
    public void text_mpn_shr() throws Exception
    {
        call(this.text_mpn_shr, this::text_mpn_shr);
    }


    // function: Function(address=134225770, size=88, name='text_mpn_add', path='build/py/mpz.o', joint_set={0, 34, 72, 44, 14, 48, 18, 54, 30}, stop_set={86, 52, 70})
    abstract protected void text_mpn_add(int offset) throws Exception;
    protected int text_mpn_add = 0x08001f6a;
    public void text_mpn_add() throws Exception
    {
        call(this.text_mpn_add, this::text_mpn_add);
    }


    // function: Function(address=134225858, size=80, name='text_mpn_sub', path='build/py/mpz.o', joint_set={0, 64, 32, 40, 42, 14, 18, 28}, stop_set={40, 78, 62})
    abstract protected void text_mpn_sub(int offset) throws Exception;
    protected int text_mpn_sub = 0x08001fc2;
    public void text_mpn_sub() throws Exception
    {
        call(this.text_mpn_sub, this::text_mpn_sub);
    }


    // function: Function(address=134225940, size=112, name='mpn_xor_neg', path='build/py/mpz.o', joint_set={0, 68, 36, 102, 40, 42, 18, 22, 58, 30}, stop_set={104, 40, 100})
    abstract protected void mpn_xor_neg(int offset) throws Exception;
    protected int mpn_xor_neg = 0x08002014;
    public void mpn_xor_neg() throws Exception
    {
        call(this.mpn_xor_neg, this::mpn_xor_neg);
    }


    // function: Function(address=134226052, size=50, name='mpz_need_dig', path='build/py/mpz.o', joint_set={0, 34, 10, 12, 48, 22, 26}, stop_set={48})
    abstract protected void mpz_need_dig(int offset) throws Exception;
    protected int mpz_need_dig = 0x08002084;
    public void mpz_need_dig() throws Exception
    {
        call(this.mpz_need_dig, this::mpz_need_dig);
    }


    // function: Function(address=134226102, size=76, name='mpz_clone', path='build/py/mpz.o', joint_set={0, 10, 72, 58}, stop_set={74})
    abstract protected void mpz_clone(int offset) throws Exception;
    protected int mpz_clone = 0x080020b6;
    public void mpz_clone() throws Exception
    {
        call(this.mpz_clone, this::mpz_clone);
    }


    // function: Function(address=134226178, size=44, name='mpn_cmp_part_1', path='build/py/mpz.o', joint_set={0, 34, 40, 8, 12, 14, 16, 28, 30}, stop_set={38, 42, 32, 14})
    abstract protected void mpn_cmp_part_1(int offset) throws Exception;
    protected int mpn_cmp_part_1 = 0x08002102;
    public void mpn_cmp_part_1() throws Exception
    {
        call(this.mpn_cmp_part_1, this::mpn_cmp_part_1);
    }


    // function: Function(address=134226222, size=28, name='mpz_free', path='build/py/mpz.o', joint_set={0, 26, 18, 6}, stop_set={26})
    abstract protected void mpz_free(int offset) throws Exception;
    protected int mpz_free = 0x0800212e;
    public void mpz_free() throws Exception
    {
        call(this.mpz_free, this::mpz_free);
    }


    // function: Function(address=134226250, size=58, name='mpz_set_from_int_part_4', path='build/py/mpz.o', joint_set={0, 34, 36, 42, 12, 20, 26, 30}, stop_set={56, 34, 40})
    abstract protected void mpz_set_from_int_part_4(int offset) throws Exception;
    protected int mpz_set_from_int_part_4 = 0x0800214a;
    public void mpz_set_from_int_part_4() throws Exception
    {
        call(this.mpz_set_from_int_part_4, this::mpz_set_from_int_part_4);
    }


    // function: Function(address=134226308, size=10, name='mpz_init_zero', path='build/py/mpz.o', joint_set={0}, stop_set={8})
    abstract protected void mpz_init_zero(int offset) throws Exception;
    protected int mpz_init_zero = 0x08002184;
    public void mpz_init_zero() throws Exception
    {
        call(this.mpz_init_zero, this::mpz_init_zero);
    }


    // function: Function(address=134226318, size=26, name='mpz_deinit', path='build/py/mpz.o', joint_set={0, 24, 12, 6}, stop_set={24})
    abstract protected void mpz_deinit(int offset) throws Exception;
    protected int mpz_deinit = 0x0800218e;
    public void mpz_deinit() throws Exception
    {
        call(this.mpz_deinit, this::mpz_deinit);
    }


    // function: Function(address=134226344, size=46, name='mpz_set', path='build/py/mpz.o', joint_set={0, 12, 44}, stop_set={44})
    abstract protected void mpz_set(int offset) throws Exception;
    protected int mpz_set = 0x080021a8;
    public void mpz_set() throws Exception
    {
        call(this.mpz_set, this::mpz_set);
    }


    // function: Function(address=134226390, size=16, name='mpz_set_from_int', path='build/py/mpz.o', joint_set={0, 6, 8, 10, 14}, stop_set={8, 14})
    abstract protected void mpz_set_from_int(int offset) throws Exception;
    protected int mpz_set_from_int = 0x080021d6;
    public void mpz_set_from_int() throws Exception
    {
        call(this.mpz_set_from_int, this::mpz_set_from_int);
    }


    // function: Function(address=134226406, size=20, name='mpz_init_from_int', path='build/py/mpz.o', joint_set={0, 10, 18}, stop_set={18})
    abstract protected void mpz_init_from_int(int offset) throws Exception;
    protected int mpz_init_from_int = 0x080021e6;
    public void mpz_init_from_int() throws Exception
    {
        call(this.mpz_init_from_int, this::mpz_init_from_int);
    }


    // function: Function(address=134226426, size=42, name='mpz_init_fixed_from_int', path='build/py/mpz.o', joint_set={0, 40}, stop_set={40})
    abstract protected void mpz_init_fixed_from_int(int offset) throws Exception;
    protected int mpz_init_fixed_from_int = 0x080021fa;
    public void mpz_init_fixed_from_int() throws Exception
    {
        call(this.mpz_init_fixed_from_int, this::mpz_init_fixed_from_int);
    }


    // function: Function(address=134226468, size=88, name='mpz_set_from_ll', path='build/py/mpz.o', joint_set={0, 40, 44, 18, 50, 52, 30, 26, 62}, stop_set={50, 60, 86})
    abstract protected void mpz_set_from_ll(int offset) throws Exception;
    protected int mpz_set_from_ll = 0x08002224;
    public void mpz_set_from_ll() throws Exception
    {
        call(this.mpz_set_from_ll, this::mpz_set_from_ll);
    }


    // function: Function(address=134226556, size=190, name='mpz_set_from_float', path='build/py/mpz.o', joint_set={0, 32, 34, 130, 100, 162, 38, 134, 58, 172, 108, 60, 120, 50, 54, 152, 90, 28, 158}, stop_set={32, 170, 188, 58})
    abstract protected void mpz_set_from_float(int offset) throws Exception;
    protected int mpz_set_from_float = 0x0800227c;
    public void mpz_set_from_float() throws Exception
    {
        call(this.mpz_set_from_float, this::mpz_set_from_float);
    }


    // function: Function(address=134226746, size=164, name='mpz_set_from_str', path='build/py/mpz.o', joint_set={0, 64, 34, 130, 100, 32, 106, 74, 138, 120, 142, 48, 80, 82, 84, 116, 54, 24, 90, 60}, stop_set={128, 162, 140, 58, 62})
    abstract protected void mpz_set_from_str(int offset) throws Exception;
    protected int mpz_set_from_str = 0x0800233a;
    public void mpz_set_from_str() throws Exception
    {
        call(this.mpz_set_from_str, this::mpz_set_from_str);
    }


    // function: Function(address=134226910, size=106, name='mpz_set_from_bytes', path='build/py/mpz.o', joint_set={0, 32, 66, 68, 72, 44, 14, 48, 20, 90, 62}, stop_set={104, 64})
    abstract protected void mpz_set_from_bytes(int offset) throws Exception;
    protected int mpz_set_from_bytes = 0x080023de;
    public void mpz_set_from_bytes() throws Exception
    {
        call(this.mpz_set_from_bytes, this::mpz_set_from_bytes);
    }


    // function: Function(address=134227016, size=70, name='mpz_cmp', path='build/py/mpz.o', joint_set={0, 64, 36, 42, 12, 48, 20, 56, 60, 62}, stop_set={68, 62})
    abstract protected void mpz_cmp(int offset) throws Exception;
    protected int mpz_cmp = 0x08002448;
    public void mpz_cmp() throws Exception
    {
        call(this.mpz_cmp, this::mpz_cmp);
    }


    // function: Function(address=134227086, size=22, name='mpz_abs_inpl', path='build/py/mpz.o', joint_set={0, 8, 12}, stop_set={20})
    abstract protected void mpz_abs_inpl(int offset) throws Exception;
    protected int mpz_abs_inpl = 0x0800248e;
    public void mpz_abs_inpl() throws Exception
    {
        call(this.mpz_abs_inpl, this::mpz_abs_inpl);
    }


    // function: Function(address=134227108, size=32, name='mpz_neg_inpl', path='build/py/mpz.o', joint_set={0, 8, 12}, stop_set={30})
    abstract protected void mpz_neg_inpl(int offset) throws Exception;
    protected int mpz_neg_inpl = 0x080024a4;
    public void mpz_neg_inpl() throws Exception
    {
        call(this.mpz_neg_inpl, this::mpz_neg_inpl);
    }


    // function: Function(address=134227140, size=110, name='mpz_not_inpl', path='build/py/mpz.o', joint_set={0, 100, 40, 72, 42, 8, 12, 76, 18, 84, 54, 26}, stop_set={40, 74, 108})
    abstract protected void mpz_not_inpl(int offset) throws Exception;
    protected int mpz_not_inpl = 0x080024c4;
    public void mpz_not_inpl() throws Exception
    {
        call(this.mpz_not_inpl, this::mpz_not_inpl);
    }


    // function: Function(address=134227252, size=208, name='mpz_shl_inpl', path='build/py/mpz.o', joint_set={0, 32, 96, 130, 164, 134, 200, 44, 92, 16, 144, 20, 56, 58, 28}, stop_set={202, 162, 198, 30})
    abstract protected void mpz_shl_inpl(int offset) throws Exception;
    protected int mpz_shl_inpl = 0x08002534;
    public void mpz_shl_inpl() throws Exception
    {
        call(this.mpz_shl_inpl, this::mpz_shl_inpl);
    }


    // function: Function(address=134227460, size=194, name='mpz_shr_inpl', path='build/py/mpz.o', joint_set={0, 128, 134, 136, 16, 20, 150, 28, 32, 160, 36, 170, 48, 180, 184, 188, 72, 88, 94, 98, 104, 126}, stop_set={192, 134, 182, 186, 30})
    abstract protected void mpz_shr_inpl(int offset) throws Exception;
    protected int mpz_shr_inpl = 0x08002604;
    public void mpz_shr_inpl() throws Exception
    {
        call(this.mpz_shr_inpl, this::mpz_shr_inpl);
    }


    // function: Function(address=134227654, size=116, name='mpz_add_inpl', path='build/py/mpz.o', joint_set={0, 98, 36, 72, 48, 16, 114, 18, 56, 26, 92, 30}, stop_set={90, 114})
    abstract protected void mpz_add_inpl(int offset) throws Exception;
    protected int mpz_add_inpl = 0x080026c6;
    public void mpz_add_inpl() throws Exception
    {
        call(this.mpz_add_inpl, this::mpz_add_inpl);
    }


    // function: Function(address=134227770, size=130, name='mpz_sub_inpl', path='build/py/mpz.o', joint_set={0, 128, 34, 98, 106, 42, 78, 112, 16, 30, 54, 22, 62, 94}, stop_set={104, 128})
    abstract protected void mpz_sub_inpl(int offset) throws Exception;
    protected int mpz_sub_inpl = 0x0800273a;
    public void mpz_sub_inpl() throws Exception
    {
        call(this.mpz_sub_inpl, this::mpz_sub_inpl);
    }


    // function: Function(address=134227900, size=310, name='mpz_and_inpl', path='build/py/mpz.o', joint_set={0, 268, 18, 24, 34, 40, 46, 182, 58, 186, 62, 70, 200, 206, 78, 212, 84, 104, 234, 112, 254}, stop_set={232, 82, 308, 102})
    abstract protected void mpz_and_inpl(int offset) throws Exception;
    protected int mpz_and_inpl = 0x080027bc;
    public void mpz_and_inpl() throws Exception
    {
        call(this.mpz_and_inpl, this::mpz_and_inpl);
    }


    // function: Function(address=134228210, size=296, name='mpz_or_inpl', path='build/py/mpz.o', joint_set={0, 128, 264, 140, 18, 148, 24, 34, 42, 48, 68, 72, 204, 208, 82, 86, 218, 230, 104, 112, 250}, stop_set={228, 294, 138, 110, 126})
    abstract protected void mpz_or_inpl(int offset) throws Exception;
    protected int mpz_or_inpl = 0x080028f2;
    public void mpz_or_inpl() throws Exception
    {
        call(this.mpz_or_inpl, this::mpz_or_inpl);
    }


    // function: Function(address=134228506, size=218, name='mpz_xor_inpl', path='build/py/mpz.o', joint_set={0, 128, 98, 164, 166, 70, 40, 74, 108, 140, 174, 46, 208, 112, 18, 52, 84, 24, 88}, stop_set={164, 138, 110, 216, 126})
    abstract protected void mpz_xor_inpl(int offset) throws Exception;
    protected int mpz_xor_inpl = 0x08002a1a;
    public void mpz_xor_inpl() throws Exception
    {
        call(this.mpz_xor_inpl, this::mpz_xor_inpl);
    }


    // function: Function(address=134228724, size=262, name='mpz_mul_inpl', path='build/py/mpz.o', joint_set={0, 256, 134, 138, 16, 144, 146, 22, 26, 154, 30, 160, 34, 166, 40, 48, 50, 62, 200, 76, 206, 214, 222, 112, 244, 118}, stop_set={260, 164, 144, 242, 28, 254})
    abstract protected void mpz_mul_inpl(int offset) throws Exception;
    protected int mpz_mul_inpl = 0x08002af4;
    public void mpz_mul_inpl() throws Exception
    {
        call(this.mpz_mul_inpl, this::mpz_mul_inpl);
    }


    // function: Function(address=134228986, size=132, name='mpz_pow_inpl', path='build/py/mpz.o', joint_set={0, 64, 130, 32, 100, 70, 38, 40, 106, 12, 46, 78, 112, 20, 54, 118, 24, 26, 88, 120}, stop_set={24, 38, 130, 118})
    abstract protected void mpz_pow_inpl(int offset) throws Exception;
    protected int mpz_pow_inpl = 0x08002bfa;
    public void mpz_pow_inpl() throws Exception
    {
        call(this.mpz_pow_inpl, this::mpz_pow_inpl);
    }


    // function: Function(address=134229120, size=688, name='mpz_divmod_inpl', path='build/py/mpz.o', joint_set={0, 384, 130, 646, 390, 392, 266, 142, 528, 658, 20, 406, 152, 408, 414, 288, 162, 36, 678, 552, 426, 172, 560, 176, 52, 180, 184, 60, 448, 320, 578, 204, 588, 332, 212, 598, 88, 472, 90, 354, 100, 360, 104, 362, 492, 112, 368, 498, 506, 244, 114, 630, 502, 250, 636, 382}, stop_set={382, 644, 676, 390, 424, 360, 586, 682, 174, 526, 656, 596, 182, 406, 412, 446})
    abstract protected void mpz_divmod_inpl(int offset) throws Exception;
    protected int mpz_divmod_inpl = 0x08002c80;
    public void mpz_divmod_inpl() throws Exception
    {
        call(this.mpz_divmod_inpl, this::mpz_divmod_inpl);
    }


    // function: Function(address=134229808, size=182, name='mpz_pow3_inpl', path='build/py/mpz.o', joint_set={0, 132, 138, 144, 18, 150, 24, 156, 158, 30, 38, 168, 42, 46, 180, 54, 60, 66, 74, 82, 88, 98, 108, 120}, stop_set={156, 180, 44})
    abstract protected void mpz_pow3_inpl(int offset) throws Exception;
    protected int mpz_pow3_inpl = 0x08002f30;
    public void mpz_pow3_inpl() throws Exception
    {
        call(this.mpz_pow3_inpl, this::mpz_pow3_inpl);
    }


    // function: Function(address=134229990, size=40, name='mpz_hash', path='build/py/mpz.o', joint_set={0, 32, 14, 22, 28, 30}, stop_set={38, 30})
    abstract protected void mpz_hash(int offset) throws Exception;
    protected int mpz_hash = 0x08002fe6;
    public void mpz_hash() throws Exception
    {
        call(this.mpz_hash, this::mpz_hash);
    }


    // function: Function(address=134230032, size=56, name='mpz_as_int_checked', path='build/py/mpz.o', joint_set={0, 32, 38, 46, 14, 18, 24, 26, 30}, stop_set={48, 44, 30})
    abstract protected void mpz_as_int_checked(int offset) throws Exception;
    protected int mpz_as_int_checked = 0x08003010;
    public void mpz_as_int_checked() throws Exception
    {
        call(this.mpz_as_int_checked, this::mpz_as_int_checked);
    }


    // function: Function(address=134230088, size=142, name='mpz_as_bytes', path='build/py/mpz.o', joint_set={0, 34, 100, 134, 40, 74, 108, 14, 18, 84, 118, 56, 122, 60}, stop_set={120, 72, 140})
    abstract protected void mpz_as_bytes(int offset) throws Exception;
    protected int mpz_as_bytes = 0x08003048;
    public void mpz_as_bytes() throws Exception
    {
        call(this.mpz_as_bytes, this::mpz_as_bytes);
    }


    // function: Function(address=134230230, size=60, name='mpz_as_float', path='build/py/mpz.o', joint_set={0, 34, 36, 44, 14, 52, 22, 58, 28}, stop_set={58, 34})
    abstract protected void mpz_as_float(int offset) throws Exception;
    protected int mpz_as_float = 0x080030d6;
    public void mpz_as_float() throws Exception
    {
        call(this.mpz_as_float, this::mpz_as_float);
    }


    // function: Function(address=134230290, size=288, name='mpz_as_str_inpl', path='build/py/mpz.o', joint_set={0, 130, 264, 136, 142, 144, 278, 152, 24, 284, 32, 162, 166, 174, 46, 178, 50, 184, 56, 188, 64, 66, 194, 200, 76, 206, 210, 86, 214, 224, 228, 102, 106, 250, 240, 112, 244, 118, 122, 254}, stop_set={64, 226, 262, 48, 242, 276, 252, 222, 286})
    abstract protected void mpz_as_str_inpl(int offset) throws Exception;
    protected int mpz_as_str_inpl = 0x08003112;
    public void mpz_as_str_inpl() throws Exception
    {
        call(this.mpz_as_str_inpl, this::mpz_as_str_inpl);
    }


    // function: Function(address=134230578, size=22, name='mp_reader_mem_readbyte', path='build/py/reader.o', joint_set={0, 16, 14, 8}, stop_set={20, 14})
    abstract protected void mp_reader_mem_readbyte(int offset) throws Exception;
    protected int mp_reader_mem_readbyte = 0x08003232;
    public void mp_reader_mem_readbyte() throws Exception
    {
        call(this.mp_reader_mem_readbyte, this::mp_reader_mem_readbyte);
    }


    // function: Function(address=134230600, size=26, name='mp_reader_mem_close', path='build/py/reader.o', joint_set={0, 16, 10, 24}, stop_set={24})
    abstract protected void mp_reader_mem_close(int offset) throws Exception;
    protected int mp_reader_mem_close = 0x08003248;
    public void mp_reader_mem_close() throws Exception
    {
        call(this.mp_reader_mem_close, this::mp_reader_mem_close);
    }


    // function: Function(address=134230628, size=48, name='mp_reader_new_mem', path='build/py/reader.o', joint_set={0, 16}, stop_set={36})
    abstract protected void mp_reader_new_mem(int offset) throws Exception;
    protected int mp_reader_new_mem = 0x08003264;
    public void mp_reader_new_mem() throws Exception
    {
        call(this.mp_reader_new_mem, this::mp_reader_new_mem);
    }


    // function: Function(address=134230676, size=80, name='is_string_or_bytes', path='build/py/lexer.o', joint_set={0, 64, 34, 38, 70, 8, 42, 76, 12, 48, 16, 56, 26}, stop_set={62, 78})
    abstract protected void is_string_or_bytes(int offset) throws Exception;
    protected int is_string_or_bytes = 0x08003294;
    public void is_string_or_bytes() throws Exception
    {
        call(this.is_string_or_bytes, this::is_string_or_bytes);
    }


    // function: Function(address=134230756, size=96, name='next_char', path='build/py/lexer.o', joint_set={0, 64, 70, 74, 42, 10, 78, 80, 18, 50, 86, 58, 92}, stop_set={94, 78})
    abstract protected void next_char(int offset) throws Exception;
    protected int next_char = 0x080032e4;
    public void next_char() throws Exception
    {
        call(this.next_char, this::next_char);
    }


    // function: Function(address=134230852, size=102, name='skip_whitespace', path='build/py/lexer.o', joint_set={0, 10, 16, 20, 24, 28, 34, 40, 44, 48, 52, 58, 60, 66, 72, 78, 82, 84, 88, 94, 100}, stop_set={100, 42, 18, 82, 58})
    abstract protected void skip_whitespace(int offset) throws Exception;
    protected int skip_whitespace = 0x08003344;
    public void skip_whitespace() throws Exception
    {
        call(this.skip_whitespace, this::skip_whitespace);
    }


    // function: Function(address=134230956, size=1420, name='mp_lexer_to_next', path='build/py/lexer.o', joint_set={0, 514, 1026, 1032, 524, 1020, 14, 1036, 532, 1044, 538, 1052, 28, 544, 36, 40, 554, 1066, 44, 558, 564, 1076, 54, 568, 56, 1080, 60, 64, 578, 1090, 70, 588, 1102, 592, 596, 1108, 598, 602, 606, 1120, 96, 610, 98, 614, 1126, 1128, 104, 618, 620, 1132, 1136, 626, 114, 630, 1142, 632, 122, 1148, 640, 1154, 646, 1158, 138, 1164, 656, 1168, 1170, 148, 666, 1180, 670, 1182, 674, 162, 164, 678, 170, 682, 1198, 688, 176, 692, 180, 1204, 184, 698, 1210, 190, 1216, 706, 196, 1220, 198, 710, 712, 1226, 718, 1230, 722, 210, 1236, 726, 216, 1242, 732, 220, 734, 1248, 226, 740, 1252, 230, 744, 748, 236, 1262, 752, 240, 1268, 246, 1270, 762, 1274, 764, 254, 1280, 772, 1286, 776, 264, 266, 1290, 270, 1294, 786, 276, 280, 286, 1310, 804, 294, 1320, 298, 810, 812, 1326, 304, 1332, 822, 1336, 316, 828, 1340, 834, 324, 838, 330, 842, 336, 1360, 340, 1364, 342, 856, 1368, 348, 1372, 350, 862, 1376, 356, 868, 1382, 1380, 360, 362, 874, 1388, 368, 880, 886, 378, 896, 386, 900, 392, 396, 398, 910, 912, 404, 412, 928, 930, 422, 934, 426, 938, 428, 942, 434, 948, 952, 956, 446, 960, 452, 454, 966, 458, 970, 460, 972, 466, 978, 980, 984, 474, 988, 484, 998, 488, 1002, 492, 494, 1006, 498, 500, 1012, 504, 1018, 508}, stop_set={770, 1018, 1146, 1288, 136, 396, 910, 1168, 786, 402, 1042, 410, 668, 1180, 672, 676, 420, 932, 38, 680, 552, 810, 426, 168, 690, 1074, 820, 1334, 182, 58, 452, 964, 710, 196, 1224, 458, 970, 590, 978, 1370, 732, 348, 1246, 736, 612, 1380, 486, 742, 360, 1126, 234, 1386, 1396, 628, 1272, 762})
    abstract protected void mp_lexer_to_next(int offset) throws Exception;
    protected int mp_lexer_to_next = 0x080033ac;
    public void mp_lexer_to_next() throws Exception
    {
        call(this.mp_lexer_to_next, this::mp_lexer_to_next);
    }


    // function: Function(address=134232376, size=122, name='mp_lexer_new', path='build/py/lexer.o', joint_set={0, 96, 68, 102, 108, 16, 84, 116, 56, 90}, stop_set={120})
    abstract protected void mp_lexer_new(int offset) throws Exception;
    protected int mp_lexer_new = 0x08003938;
    public void mp_lexer_new() throws Exception
    {
        call(this.mp_lexer_new, this::mp_lexer_new);
    }


    // function: Function(address=134232498, size=26, name='mp_lexer_new_from_str_len', path='build/py/lexer.o', joint_set={0, 10, 22}, stop_set={24})
    abstract protected void mp_lexer_new_from_str_len(int offset) throws Exception;
    protected int mp_lexer_new_from_str_len = 0x080039b2;
    public void mp_lexer_new_from_str_len() throws Exception
    {
        call(this.mp_lexer_new_from_str_len, this::mp_lexer_new_from_str_len);
    }


    // function: Function(address=134232524, size=32, name='mp_lexer_new_from_file', path='build/py/lexer.o', joint_set={0, 18, 12, 28}, stop_set={30})
    abstract protected void mp_lexer_new_from_file(int offset) throws Exception;
    protected int mp_lexer_new_from_file = 0x080039cc;
    public void mp_lexer_new_from_file() throws Exception
    {
        call(this.mp_lexer_new_from_file, this::mp_lexer_new_from_file);
    }


    // function: Function(address=134232556, size=40, name='mp_lexer_free', path='build/py/lexer.o', joint_set={0, 38, 6, 20, 30}, stop_set={38})
    abstract protected void mp_lexer_free(int offset) throws Exception;
    protected int mp_lexer_free = 0x080039ec;
    public void mp_lexer_free() throws Exception
    {
        call(this.mp_lexer_free, this::mp_lexer_free);
    }


    // function: Function(address=134232596, size=14, name='pop_result', path='build/py/parse.o', joint_set={0}, stop_set={12})
    abstract protected void pop_result(int offset) throws Exception;
    protected int pop_result = 0x08003a14;
    public void pop_result() throws Exception
    {
        call(this.pop_result, this::pop_result);
    }


    // function: Function(address=134232612, size=20, name='peek_result', path='build/py/parse.o', joint_set={0}, stop_set={14})
    abstract protected void peek_result(int offset) throws Exception;
    protected int peek_result = 0x08003a24;
    public void peek_result() throws Exception
    {
        call(this.peek_result, this::peek_result);
    }


    // function: Function(address=134232632, size=112, name='parser_alloc', path='build/py/parse.o', joint_set={0, 66, 98, 38, 72, 74, 12, 44, 82, 22, 56, 94}, stop_set={92, 110})
    abstract protected void parser_alloc(int offset) throws Exception;
    protected int parser_alloc = 0x08003a38;
    public void parser_alloc() throws Exception
    {
        call(this.parser_alloc, this::parser_alloc);
    }


    // function: Function(address=134232744, size=48, name='push_result_node', path='build/py/parse.o', joint_set={0, 34, 26, 14}, stop_set={46})
    abstract protected void push_result_node(int offset) throws Exception;
    protected int push_result_node = 0x08003aa8;
    public void push_result_node() throws Exception
    {
        call(this.push_result_node, this::push_result_node);
    }


    // function: Function(address=134232792, size=70, name='push_rule', path='build/py/parse.o', joint_set={0, 18, 38, 30}, stop_set={68})
    abstract protected void push_rule(int offset) throws Exception;
    protected int push_rule = 0x08003ad8;
    public void push_rule() throws Exception
    {
        call(this.push_rule, this::push_rule);
    }


    // function: Function(address=134232862, size=16, name='push_rule_from_arg', path='build/py/parse.o', joint_set={0, 14}, stop_set={14})
    abstract protected void push_rule_from_arg(int offset) throws Exception;
    protected int push_rule_from_arg = 0x08003b1e;
    public void push_rule_from_arg() throws Exception
    {
        call(this.push_rule_from_arg, this::push_rule_from_arg);
    }


    // function: Function(address=134232880, size=224, name='push_result_token', path='build/py/parse.o', joint_set={0, 132, 146, 18, 154, 26, 32, 162, 166, 172, 48, 178, 180, 52, 54, 184, 188, 60, 190, 64, 196, 68, 198, 74, 206, 208, 80, 82, 86, 98, 102, 106, 120, 122}, stop_set={66, 100, 206, 80, 144, 212, 182, 188})
    abstract protected void push_result_token(int offset) throws Exception;
    protected int push_result_token = 0x08003b30;
    public void push_result_token() throws Exception
    {
        call(this.push_result_token, this::push_result_token);
    }


    // function: Function(address=134233104, size=24, name='mp_parse_node_is_const_false', path='build/py/parse.o', joint_set={0, 8, 20, 14}, stop_set={22})
    abstract protected void mp_parse_node_is_const_false(int offset) throws Exception;
    protected int mp_parse_node_is_const_false = 0x08003c10;
    public void mp_parse_node_is_const_false() throws Exception
    {
        call(this.mp_parse_node_is_const_false, this::mp_parse_node_is_const_false);
    }


    // function: Function(address=134233128, size=26, name='mp_parse_node_is_const_true', path='build/py/parse.o', joint_set={0, 8, 22, 14}, stop_set={24})
    abstract protected void mp_parse_node_is_const_true(int offset) throws Exception;
    protected int mp_parse_node_is_const_true = 0x08003c28;
    public void mp_parse_node_is_const_true() throws Exception
    {
        call(this.mp_parse_node_is_const_true, this::mp_parse_node_is_const_true);
    }


    // function: Function(address=134233156, size=80, name='mp_parse_node_get_int_maybe', path='build/py/parse.o', joint_set={0, 38, 10, 48, 20, 24, 62, 58, 30}, stop_set={72, 22})
    abstract protected void mp_parse_node_get_int_maybe(int offset) throws Exception;
    protected int mp_parse_node_get_int_maybe = 0x08003c44;
    public void mp_parse_node_get_int_maybe() throws Exception
    {
        call(this.mp_parse_node_get_int_maybe, this::mp_parse_node_get_int_maybe);
    }


    // function: Function(address=134233236, size=972, name='push_result_rule', path='build/py/parse.o', joint_set={0, 518, 528, 16, 22, 538, 26, 30, 544, 32, 548, 40, 42, 554, 556, 50, 564, 568, 56, 576, 64, 68, 72, 586, 78, 594, 82, 84, 86, 604, 94, 610, 612, 104, 622, 624, 120, 634, 122, 636, 128, 642, 644, 134, 136, 650, 652, 656, 144, 658, 152, 666, 668, 158, 162, 682, 170, 686, 180, 694, 182, 186, 190, 192, 708, 200, 714, 202, 208, 214, 216, 732, 220, 224, 742, 230, 232, 750, 238, 242, 754, 760, 248, 256, 772, 262, 776, 266, 780, 272, 788, 790, 278, 284, 796, 798, 288, 292, 806, 300, 816, 306, 310, 824, 826, 830, 832, 320, 326, 838, 840, 334, 848, 850, 342, 348, 864, 354, 868, 870, 364, 880, 886, 888, 378, 892, 382, 896, 898, 388, 906, 908, 398, 914, 916, 406, 920, 412, 926, 416, 930, 424, 938, 442, 448, 452, 456, 466, 470, 474, 476, 480, 484, 486, 492, 500, 506, 510}, stop_set={896, 642, 774, 134, 650, 906, 396, 656, 914, 788, 918, 666, 796, 286, 30, 928, 546, 290, 40, 554, 950, 54, 824, 190, 830, 324, 710, 838, 200, 848, 214, 474, 610, 868, 484, 230, 622, 240, 886, 634})
    abstract protected void push_result_rule(int offset) throws Exception;
    protected int push_result_rule = 0x08003c94;
    public void push_result_rule() throws Exception
    {
        call(this.push_result_rule, this::push_result_rule);
    }


    // function: Function(address=134234208, size=40, name='mp_parse_node_extract_list', path='build/py/parse.o', joint_set={0, 32, 8, 12, 14, 18, 24}, stop_set={38, 12, 22})
    abstract protected void mp_parse_node_extract_list(int offset) throws Exception;
    protected int mp_parse_node_extract_list = 0x08004060;
    public void mp_parse_node_extract_list() throws Exception
    {
        call(this.mp_parse_node_extract_list, this::mp_parse_node_extract_list);
    }


    // function: Function(address=134234248, size=872, name='mp_parse', path='build/py/parse.o', joint_set={0, 524, 530, 536, 26, 544, 40, 554, 560, 564, 566, 56, 568, 572, 62, 580, 68, 70, 582, 592, 82, 84, 600, 602, 90, 92, 604, 614, 616, 620, 622, 630, 634, 636, 638, 642, 130, 646, 136, 648, 650, 658, 668, 670, 160, 674, 164, 678, 680, 168, 170, 682, 178, 694, 702, 704, 708, 202, 714, 204, 720, 220, 222, 734, 226, 234, 748, 240, 244, 758, 248, 760, 252, 768, 770, 266, 270, 274, 788, 284, 800, 806, 296, 304, 820, 310, 312, 826, 828, 318, 328, 336, 338, 342, 346, 362, 370, 376, 380, 384, 388, 392, 398, 402, 406, 418, 420, 422, 426, 438, 444, 458, 470, 474, 482, 488, 494, 498, 500, 504}, stop_set={768, 646, 272, 400, 534, 418, 678, 552, 680, 168, 818, 310, 440, 826, 702, 832, 706, 580, 202, 336, 340, 90, 220, 614, 492, 620, 498, 242, 502, 758, 634})
    abstract protected void mp_parse(int offset) throws Exception;
    protected int mp_parse = 0x08004088;
    public void mp_parse() throws Exception
    {
        call(this.mp_parse, this::mp_parse);
    }


    // function: Function(address=134235120, size=24, name='mp_parse_tree_clear', path='build/py/parse.o', joint_set={0, 4, 8, 10, 20}, stop_set={8, 22})
    abstract protected void mp_parse_tree_clear(int offset) throws Exception;
    protected int mp_parse_tree_clear = 0x080043f0;
    public void mp_parse_tree_clear() throws Exception
    {
        call(this.mp_parse_tree_clear, this::mp_parse_tree_clear);
    }


    // function: Function(address=134235144, size=76, name='scope_new', path='build/py/scope.o', joint_set={0, 32, 64, 36, 42, 16, 58, 28}, stop_set={68, 62})
    abstract protected void scope_new(int offset) throws Exception;
    protected int scope_new = 0x08004408;
    public void scope_new() throws Exception
    {
        call(this.scope_new, this::scope_new);
    }


    // function: Function(address=134235220, size=24, name='scope_free', path='build/py/scope.o', joint_set={0, 14, 22}, stop_set={22})
    abstract protected void scope_free(int offset) throws Exception;
    protected int scope_free = 0x08004454;
    public void scope_free() throws Exception
    {
        call(this.scope_free, this::scope_free);
    }


    // function: Function(address=134235244, size=32, name='scope_find', path='build/py/scope.o', joint_set={0, 8, 12, 14, 16, 28}, stop_set={14, 30})
    abstract protected void scope_find(int offset) throws Exception;
    protected int scope_find = 0x0800446c;
    public void scope_find() throws Exception
    {
        call(this.scope_find, this::scope_find);
    }


    // function: Function(address=134235276, size=70, name='scope_find_or_add_id', path='build/py/scope.o', joint_set={0, 66, 38, 12, 46, 18, 26}, stop_set={68})
    abstract protected void scope_find_or_add_id(int offset) throws Exception;
    protected int scope_find_or_add_id = 0x0800448c;
    public void scope_find_or_add_id() throws Exception
    {
        call(this.scope_find_or_add_id, this::scope_find_or_add_id);
    }


    // function: Function(address=134235346, size=18, name='scope_find_global', path='build/py/scope.o', joint_set={0, 2, 8, 12, 14}, stop_set={16, 12})
    abstract protected void scope_find_global(int offset) throws Exception;
    protected int scope_find_global = 0x080044d2;
    public void scope_find_global() throws Exception
    {
        call(this.scope_find_global, this::scope_find_global);
    }


    // function: Function(address=134235364, size=88, name='scope_find_local_and_close_over', path='build/py/scope.o', joint_set={0, 36, 12, 44, 76, 50, 18, 82, 24, 62, 58, 28, 30}, stop_set={16, 28, 86})
    abstract protected void scope_find_local_and_close_over(int offset) throws Exception;
    protected int scope_find_local_and_close_over = 0x080044e4;
    public void scope_find_local_and_close_over() throws Exception
    {
        call(this.scope_find_local_and_close_over, this::scope_find_local_and_close_over);
    }


    // function: Function(address=134235452, size=20, name='compile_increase_except_level', path='build/py/compile.o', joint_set={0, 16, 18}, stop_set={18})
    abstract protected void compile_increase_except_level(int offset) throws Exception;
    protected int compile_increase_except_level = 0x0800453c;
    public void compile_increase_except_level() throws Exception
    {
        call(this.compile_increase_except_level, this::compile_increase_except_level);
    }


    // function: Function(address=134235472, size=60, name='apply_to_single_or_list', path='build/py/compile.o', joint_set={0, 36, 38, 12, 18, 52, 26, 30}, stop_set={58, 36, 50})
    abstract protected void apply_to_single_or_list(int offset) throws Exception;
    protected int apply_to_single_or_list = 0x08004550;
    public void apply_to_single_or_list() throws Exception
    {
        call(this.apply_to_single_or_list, this::apply_to_single_or_list);
    }


    // function: Function(address=134235532, size=20, name='compile_del_stmt', path='build/py/compile.o', joint_set={0, 12}, stop_set={12})
    abstract protected void compile_del_stmt(int offset) throws Exception;
    protected int compile_del_stmt = 0x0800458c;
    public void compile_del_stmt() throws Exception
    {
        call(this.compile_del_stmt, this::compile_del_stmt);
    }


    // function: Function(address=134235552, size=20, name='compile_import_name', path='build/py/compile.o', joint_set={0, 12}, stop_set={12})
    abstract protected void compile_import_name(int offset) throws Exception;
    protected int compile_import_name = 0x080045a0;
    public void compile_import_name() throws Exception
    {
        call(this.compile_import_name, this::compile_import_name);
    }


    // function: Function(address=134235572, size=44, name='scope_new_and_link', path='build/py/compile.o', joint_set={0, 32, 34, 40, 14, 28, 30}, stop_set={42, 30})
    abstract protected void scope_new_and_link(int offset) throws Exception;
    protected int scope_new_and_link = 0x080045b4;
    public void scope_new_and_link() throws Exception
    {
        call(this.scope_new_and_link, this::scope_new_and_link);
    }


    // function: Function(address=134235616, size=16, name='compile_trailer_period', path='build/py/compile.o', joint_set={0, 14}, stop_set={14})
    abstract protected void compile_trailer_period(int offset) throws Exception;
    protected int compile_trailer_period = 0x080045e0;
    public void compile_trailer_period() throws Exception
    {
        call(this.compile_trailer_period, this::compile_trailer_period);
    }


    // function: Function(address=134235632, size=12, name='compile_const_object', path='build/py/compile.o', joint_set={0, 10}, stop_set={10})
    abstract protected void compile_const_object(int offset) throws Exception;
    protected int compile_const_object = 0x080045f0;
    public void compile_const_object() throws Exception
    {
        call(this.compile_const_object, this::compile_const_object);
    }


    // function: Function(address=134235644, size=160, name='close_over_variables_etc', path='build/py/compile.o', joint_set={0, 96, 68, 132, 122, 36, 72, 136, 106, 108, 112, 48, 16, 52, 86, 24, 154, 124, 152}, stop_set={152, 50, 158, 70})
    abstract protected void close_over_variables_etc(int offset) throws Exception;
    protected int close_over_variables_etc = 0x080045fc;
    public void close_over_variables_etc() throws Exception
    {
        call(this.close_over_variables_etc, this::close_over_variables_etc);
    }


    // function: Function(address=134235804, size=92, name='compile_funcdef_lambdef', path='build/py/compile.o', joint_set={0, 36, 72, 42, 48, 84, 54, 60, 30}, stop_set={84})
    abstract protected void compile_funcdef_lambdef(int offset) throws Exception;
    protected int compile_funcdef_lambdef = 0x0800469c;
    public void compile_funcdef_lambdef() throws Exception
    {
        call(this.compile_funcdef_lambdef, this::compile_funcdef_lambdef);
    }


    // function: Function(address=134235896, size=40, name='compile_lambdef', path='build/py/compile.o', joint_set={0, 38, 12, 24, 26}, stop_set={38})
    abstract protected void compile_lambdef(int offset) throws Exception;
    protected int compile_lambdef = 0x080046f8;
    public void compile_lambdef() throws Exception
    {
        call(this.compile_lambdef, this::compile_lambdef);
    }


    // function: Function(address=134235936, size=42, name='compile_funcdef_helper', path='build/py/compile.o', joint_set={0, 38, 14, 22, 24}, stop_set={40})
    abstract protected void compile_funcdef_helper(int offset) throws Exception;
    protected int compile_funcdef_helper = 0x08004720;
    public void compile_funcdef_helper() throws Exception
    {
        call(this.compile_funcdef_helper, this::compile_funcdef_helper);
    }


    // function: Function(address=134235978, size=20, name='compile_error_set_line_isra_0', path='build/py/compile.o', joint_set={0, 6, 10, 14, 18}, stop_set={18})
    abstract protected void compile_error_set_line_isra_0(int offset) throws Exception;
    protected int compile_error_set_line_isra_0 = 0x0800474a;
    public void compile_error_set_line_isra_0() throws Exception
    {
        call(this.compile_error_set_line_isra_0, this::compile_error_set_line_isra_0);
    }


    // function: Function(address=134236000, size=40, name='compile_syntax_error', path='build/py/compile.o', joint_set={0, 32, 12, 20}, stop_set={32})
    abstract protected void compile_syntax_error(int offset) throws Exception;
    protected int compile_syntax_error = 0x08004760;
    public void compile_syntax_error() throws Exception
    {
        call(this.compile_syntax_error, this::compile_syntax_error);
    }


    // function: Function(address=134236040, size=16, name='compile_star_expr', path='build/py/compile.o', joint_set={0, 8}, stop_set={8})
    abstract protected void compile_star_expr(int offset) throws Exception;
    protected int compile_star_expr = 0x08004788;
    public void compile_star_expr() throws Exception
    {
        call(this.compile_star_expr, this::compile_star_expr);
    }


    // function: Function(address=134236056, size=64, name='compile_break_cont_stmt', path='build/py/compile.o', joint_set={0, 42, 44, 12, 16, 22, 28}, stop_set={48, 42})
    abstract protected void compile_break_cont_stmt(int offset) throws Exception;
    protected int compile_break_cont_stmt = 0x08004798;
    public void compile_break_cont_stmt() throws Exception
    {
        call(this.compile_break_cont_stmt, this::compile_break_cont_stmt);
    }


    // function: Function(address=134236120, size=168, name='compile_scope_func_lambda_param_isra_5', path='build/py/compile.o', joint_set={0, 130, 136, 140, 18, 20, 152, 28, 30, 38, 40, 46, 54, 60, 62, 66, 76, 82, 86, 94, 100, 104, 110, 120}, stop_set={98, 134, 138, 84, 52, 150, 28, 158})
    abstract protected void compile_scope_func_lambda_param_isra_5(int offset) throws Exception;
    protected int compile_scope_func_lambda_param_isra_5 = 0x080047d8;
    public void compile_scope_func_lambda_param_isra_5() throws Exception
    {
        call(this.compile_scope_func_lambda_param_isra_5, this::compile_scope_func_lambda_param_isra_5);
    }


    // function: Function(address=134236288, size=12, name='compile_scope_lambda_param', path='build/py/compile.o', joint_set={0, 10}, stop_set={10})
    abstract protected void compile_scope_lambda_param(int offset) throws Exception;
    protected int compile_scope_lambda_param = 0x08004880;
    public void compile_scope_lambda_param() throws Exception
    {
        call(this.compile_scope_lambda_param, this::compile_scope_lambda_param);
    }


    // function: Function(address=134236300, size=12, name='compile_scope_func_param', path='build/py/compile.o', joint_set={0, 10}, stop_set={10})
    abstract protected void compile_scope_func_param(int offset) throws Exception;
    protected int compile_scope_func_param = 0x0800488c;
    public void compile_scope_func_param() throws Exception
    {
        call(this.compile_scope_func_param, this::compile_scope_func_param);
    }


    // function: Function(address=134236312, size=30, name='compile_yield_from_isra_6', path='build/py/compile.o', joint_set={0, 28, 12, 20}, stop_set={28})
    abstract protected void compile_yield_from_isra_6(int offset) throws Exception;
    protected int compile_yield_from_isra_6 = 0x08004898;
    public void compile_yield_from_isra_6() throws Exception
    {
        call(this.compile_yield_from_isra_6, this::compile_yield_from_isra_6);
    }


    // function: Function(address=134236342, size=34, name='compile_await_object_method', path='build/py/compile.o', joint_set={0, 24, 32, 12}, stop_set={32})
    abstract protected void compile_await_object_method(int offset) throws Exception;
    protected int compile_await_object_method = 0x080048b6;
    public void compile_await_object_method() throws Exception
    {
        call(this.compile_await_object_method, this::compile_await_object_method);
    }


    // function: Function(address=134236376, size=36, name='compile_load_id', path='build/py/compile.o', joint_set={0, 10, 16, 18, 28}, stop_set={16, 28})
    abstract protected void compile_load_id(int offset) throws Exception;
    protected int compile_load_id = 0x080048d8;
    public void compile_load_id() throws Exception
    {
        call(this.compile_load_id, this::compile_load_id);
    }


    // function: Function(address=134236412, size=36, name='compile_store_id', path='build/py/compile.o', joint_set={0, 10, 16, 18, 28}, stop_set={16, 28})
    abstract protected void compile_store_id(int offset) throws Exception;
    protected int compile_store_id = 0x080048fc;
    public void compile_store_id() throws Exception
    {
        call(this.compile_store_id, this::compile_store_id);
    }


    // function: Function(address=134236448, size=22, name='compile_funcdef', path='build/py/compile.o', joint_set={0, 12, 20}, stop_set={20})
    abstract protected void compile_funcdef(int offset) throws Exception;
    protected int compile_funcdef = 0x08004920;
    public void compile_funcdef() throws Exception
    {
        call(this.compile_funcdef, this::compile_funcdef);
    }


    // function: Function(address=134236472, size=36, name='compile_delete_id', path='build/py/compile.o', joint_set={0, 10, 16, 18, 28}, stop_set={16, 28})
    abstract protected void compile_delete_id(int offset) throws Exception;
    protected int compile_delete_id = 0x08004938;
    public void compile_delete_id() throws Exception
    {
        call(this.compile_delete_id, this::compile_delete_id);
    }


    // function: Function(address=134236508, size=200, name='compile_node', path='build/py/compile.o', joint_set={0, 132, 8, 140, 14, 146, 150, 158, 160, 34, 38, 168, 46, 48, 56, 62, 64, 66, 70, 72, 76, 86, 90, 94, 102, 104, 112, 114, 120, 126}, stop_set={70, 102, 46, 112, 144, 184, 124, 158})
    abstract protected void compile_node(int offset) throws Exception;
    protected int compile_node = 0x0800495c;
    public void compile_node() throws Exception
    {
        call(this.compile_node, this::compile_node);
    }


    // function: Function(address=134236708, size=388, name='c_assign', path='build/py/compile.o', joint_set={0, 256, 130, 262, 264, 268, 140, 14, 272, 150, 22, 280, 286, 30, 160, 290, 34, 38, 296, 168, 40, 172, 44, 46, 302, 178, 310, 182, 312, 58, 316, 60, 320, 64, 322, 68, 196, 198, 328, 332, 78, 206, 80, 208, 338, 340, 84, 344, 88, 216, 92, 220, 98, 354, 228, 226, 102, 360, 250, 234, 364, 236, 106, 240, 370, 114, 374, 246, 376, 122}, stop_set={320, 100, 38, 358, 262, 234, 44, 78, 206, 368, 338, 180, 374, 278, 314, 382})
    abstract protected void c_assign(int offset) throws Exception;
    protected int c_assign = 0x08004a24;
    public void c_assign() throws Exception
    {
        call(this.c_assign, this::c_assign);
    }


    // function: Function(address=134237096, size=212, name='c_assign_tuple', path='build/py/compile.o', joint_set={0, 128, 134, 144, 148, 24, 30, 166, 38, 170, 48, 50, 178, 182, 56, 186, 190, 64, 194, 200, 72, 202, 76, 78, 84, 94, 96, 102, 112, 118}, stop_set={168, 200, 206, 110, 180, 116})
    abstract protected void c_assign_tuple(int offset) throws Exception;
    protected int c_assign_tuple = 0x08004ba8;
    public void c_assign_tuple() throws Exception
    {
        call(this.c_assign_tuple, this::c_assign_tuple);
    }


    // function: Function(address=134237308, size=228, name='c_if_cond', path='build/py/compile.o', joint_set={0, 130, 134, 138, 14, 20, 148, 24, 28, 156, 30, 36, 40, 44, 174, 52, 182, 184, 56, 188, 60, 64, 196, 200, 206, 78, 208, 82, 216, 90, 94, 226, 106, 108, 126}, stop_set={128, 194, 226, 106, 206, 54, 182, 28})
    abstract protected void c_if_cond(int offset) throws Exception;
    protected int c_if_cond = 0x08004c7c;
    public void c_if_cond() throws Exception
    {
        call(this.c_if_cond, this::c_if_cond);
    }


    // function: Function(address=134237536, size=178, name='compile_scope_comp_iter', path='build/py/compile.o', joint_set={0, 130, 142, 146, 154, 28, 162, 36, 46, 176, 48, 52, 60, 68, 76, 82, 90, 98, 104, 106, 118, 120}, stop_set={104, 118, 144, 176})
    abstract protected void compile_scope_comp_iter(int offset) throws Exception;
    protected int compile_scope_comp_iter = 0x08004d60;
    public void compile_scope_comp_iter() throws Exception
    {
        call(this.compile_scope_comp_iter, this::compile_scope_comp_iter);
    }


    // function: Function(address=134237716, size=168, name='check_for_doc_string', path='build/py/compile.o', joint_set={0, 128, 8, 136, 16, 144, 148, 24, 156, 30, 158, 162, 34, 38, 42, 52, 60, 68, 74, 82, 84, 94, 102, 108, 112, 116, 122, 124}, stop_set={162, 110, 82, 122, 156})
    abstract protected void check_for_doc_string(int offset) throws Exception;
    protected int check_for_doc_string = 0x08004e14;
    public void check_for_doc_string() throws Exception
    {
        call(this.check_for_doc_string, this::check_for_doc_string);
    }


    // function: Function(address=134237884, size=448, name='compile_scope', path='build/py/compile.o', joint_set={0, 384, 258, 256, 132, 392, 266, 140, 400, 272, 146, 150, 278, 408, 26, 156, 286, 160, 416, 32, 36, 292, 422, 164, 424, 168, 298, 42, 46, 436, 310, 54, 184, 316, 62, 318, 320, 192, 68, 70, 198, 328, 204, 76, 206, 336, 338, 82, 212, 342, 90, 220, 98, 354, 358, 232, 106, 108, 366, 238, 112, 116, 374, 246, 252}, stop_set={318, 68, 422, 106, 204, 336, 436, 316, 158})
    abstract protected void compile_scope(int offset) throws Exception;
    protected int compile_scope = 0x08004ebc;
    public void compile_scope() throws Exception
    {
        call(this.compile_scope, this::compile_scope);
    }


    // function: Function(address=134238332, size=22, name='compile_dictorsetmaker_item', path='build/py/compile.o', joint_set={0, 12, 20}, stop_set={20})
    abstract protected void compile_dictorsetmaker_item(int offset) throws Exception;
    protected int compile_dictorsetmaker_item = 0x0800507c;
    public void compile_dictorsetmaker_item() throws Exception
    {
        call(this.compile_dictorsetmaker_item, this::compile_dictorsetmaker_item);
    }


    // function: Function(address=134238354, size=132, name='compile_subscript', path='build/py/compile.o', joint_set={0, 130, 14, 20, 22, 28, 36, 42, 50, 52, 58, 66, 74, 76, 80, 84, 90, 92, 96, 104, 110, 116, 122}, stop_set={130, 40, 108, 50, 120, 90})
    abstract protected void compile_subscript(int offset) throws Exception;
    protected int compile_subscript = 0x08005092;
    public void compile_subscript() throws Exception
    {
        call(this.compile_subscript, this::compile_subscript);
    }


    // function: Function(address=134238486, size=20, name='compile_trailer_bracket', path='build/py/compile.o', joint_set={0, 10, 18}, stop_set={18})
    abstract protected void compile_trailer_bracket(int offset) throws Exception;
    protected int compile_trailer_bracket = 0x08005116;
    public void compile_trailer_bracket() throws Exception
    {
        call(this.compile_trailer_bracket, this::compile_trailer_bracket);
    }


    // function: Function(address=134238506, size=66, name='text_c_tuple', path='build/py/compile.o', joint_set={0, 36, 38, 12, 48, 16, 18, 50, 22, 30, 62}, stop_set={48, 64})
    abstract protected void text_c_tuple(int offset) throws Exception;
    protected int text_c_tuple = 0x0800512a;
    public void text_c_tuple() throws Exception
    {
        call(this.text_c_tuple, this::text_c_tuple);
    }


    // function: Function(address=134238572, size=12, name='compile_generic_tuple', path='build/py/compile.o', joint_set={0, 10}, stop_set={10})
    abstract protected void compile_generic_tuple(int offset) throws Exception;
    protected int compile_generic_tuple = 0x0800516c;
    public void compile_generic_tuple() throws Exception
    {
        call(this.compile_generic_tuple, this::compile_generic_tuple);
    }


    // function: Function(address=134238584, size=140, name='compile_while_stmt', path='build/py/compile.o', joint_set={0, 128, 96, 64, 136, 72, 42, 108, 46, 80, 88, 60}, stop_set={138})
    abstract protected void compile_while_stmt(int offset) throws Exception;
    protected int compile_while_stmt = 0x08005178;
    public void compile_while_stmt() throws Exception
    {
        call(this.compile_while_stmt, this::compile_while_stmt);
    }


    // function: Function(address=134238724, size=18, name='compile_yield_stmt', path='build/py/compile.o', joint_set={0, 16, 10}, stop_set={16})
    abstract protected void compile_yield_stmt(int offset) throws Exception;
    protected int compile_yield_stmt = 0x08005204;
    public void compile_yield_stmt() throws Exception
    {
        call(this.compile_yield_stmt, this::compile_yield_stmt);
    }


    // function: Function(address=134238744, size=260, name='c_del_stmt', path='build/py/compile.o', joint_set={0, 6, 134, 138, 142, 14, 22, 24, 154, 28, 156, 160, 34, 166, 172, 44, 178, 52, 186, 58, 190, 64, 194, 74, 206, 80, 210, 88, 222, 96, 226, 230, 104, 238, 112, 242, 120, 122, 252}, stop_set={224, 136, 240, 252, 22, 120, 154, 188})
    abstract protected void c_del_stmt(int offset) throws Exception;
    protected int c_del_stmt = 0x08005218;
    public void c_del_stmt() throws Exception
    {
        call(this.c_del_stmt, this::c_del_stmt);
    }


    // function: Function(address=134239004, size=54, name='compile_generic_all_nodes', path='build/py/compile.o', joint_set={0, 34, 12, 16, 48, 50, 28}, stop_set={48, 52})
    abstract protected void compile_generic_all_nodes(int offset) throws Exception;
    protected int compile_generic_all_nodes = 0x0800531c;
    public void compile_generic_all_nodes() throws Exception
    {
        call(this.compile_generic_all_nodes, this::compile_generic_all_nodes);
    }


    // function: Function(address=134239058, size=18, name='compile_power', path='build/py/compile.o', joint_set={0, 8, 16}, stop_set={16})
    abstract protected void compile_power(int offset) throws Exception;
    protected int compile_power = 0x08005352;
    public void compile_power() throws Exception
    {
        call(this.compile_power, this::compile_power);
    }


    // function: Function(address=134239076, size=228, name='compile_if_stmt', path='build/py/compile.o', joint_set={0, 130, 138, 142, 20, 24, 156, 160, 40, 48, 178, 54, 186, 58, 192, 64, 196, 70, 202, 76, 206, 80, 214, 88, 222, 96, 108, 112, 122}, stop_set={226, 140})
    abstract protected void compile_if_stmt(int offset) throws Exception;
    protected int compile_if_stmt = 0x08005364;
    public void compile_if_stmt() throws Exception
    {
        call(this.compile_if_stmt, this::compile_if_stmt);
    }


    // function: Function(address=134239304, size=74, name='compile_comprehension', path='build/py/compile.o', joint_set={0, 40, 72, 60, 14, 48, 52, 26, 28}, stop_set={72})
    abstract protected void compile_comprehension(int offset) throws Exception;
    protected int compile_comprehension = 0x08005448;
    public void compile_comprehension() throws Exception
    {
        call(this.compile_comprehension, this::compile_comprehension);
    }


    // function: Function(address=134239378, size=136, name='compile_atom_bracket', path='build/py/compile.o', joint_set={0, 132, 10, 14, 20, 22, 28, 38, 44, 48, 56, 58, 64, 70, 74, 80, 88, 98, 102, 108, 110, 118, 126}, stop_set={96, 130, 68, 134, 108, 20})
    abstract protected void compile_atom_bracket(int offset) throws Exception;
    protected int compile_atom_bracket = 0x08005492;
    public void compile_atom_bracket() throws Exception
    {
        call(this.compile_atom_bracket, this::compile_atom_bracket);
    }


    // function: Function(address=134239516, size=344, name='compile_trailer_paren_helper', path='build/py/compile.o', joint_set={0, 128, 258, 264, 136, 268, 140, 144, 276, 148, 24, 152, 158, 286, 34, 162, 168, 40, 298, 296, 172, 44, 178, 50, 52, 308, 310, 184, 58, 320, 64, 194, 66, 72, 204, 208, 80, 82, 216, 92, 94, 224, 126, 104, 232, 110, 242, 120, 250, 254}, stop_set={256, 160, 320, 64, 230, 166, 296, 266, 138, 206, 92, 80, 146, 50, 308, 248, 284})
    abstract protected void compile_trailer_paren_helper(int offset) throws Exception;
    protected int compile_trailer_paren_helper = 0x0800551c;
    public void compile_trailer_paren_helper() throws Exception
    {
        call(this.compile_trailer_paren_helper, this::compile_trailer_paren_helper);
    }


    // function: Function(address=134239860, size=86, name='compile_classdef_helper', path='build/py/compile.o', joint_set={0, 70, 72, 42, 14, 50, 82, 20, 22, 56, 28, 62}, stop_set={84})
    abstract protected void compile_classdef_helper(int offset) throws Exception;
    protected int compile_classdef_helper = 0x08005674;
    public void compile_classdef_helper() throws Exception
    {
        call(this.compile_classdef_helper, this::compile_classdef_helper);
    }


    // function: Function(address=134239946, size=22, name='compile_classdef', path='build/py/compile.o', joint_set={0, 12, 20}, stop_set={20})
    abstract protected void compile_classdef(int offset) throws Exception;
    protected int compile_classdef = 0x080056ca;
    public void compile_classdef() throws Exception
    {
        call(this.compile_classdef, this::compile_classdef);
    }


    // function: Function(address=134239968, size=14, name='compile_trailer_paren', path='build/py/compile.o', joint_set={0, 12}, stop_set={12})
    abstract protected void compile_trailer_paren(int offset) throws Exception;
    protected int compile_trailer_paren = 0x080056e0;
    public void compile_trailer_paren() throws Exception
    {
        call(this.compile_trailer_paren, this::compile_trailer_paren);
    }


    // function: Function(address=134239984, size=264, name='compile_decorated', path='build/py/compile.o', joint_set={0, 256, 132, 140, 146, 20, 150, 30, 158, 162, 36, 48, 178, 182, 56, 186, 60, 198, 80, 210, 212, 222, 96, 102, 230, 104, 234, 110, 242, 244, 118, 124, 126}, stop_set={160, 258, 232, 242, 180, 148, 58, 124})
    abstract protected void compile_decorated(int offset) throws Exception;
    protected int compile_decorated = 0x080056f0;
    public void compile_decorated() throws Exception
    {
        call(this.compile_decorated, this::compile_decorated);
    }


    // function: Function(address=134240248, size=304, name='compile_atom_brace', path='build/py/compile.o', joint_set={0, 256, 260, 132, 138, 140, 12, 270, 16, 272, 144, 22, 150, 280, 24, 282, 156, 30, 32, 290, 164, 170, 42, 174, 52, 186, 60, 192, 66, 70, 74, 204, 210, 84, 216, 220, 94, 222, 230, 102, 232, 106, 238, 242, 114, 246, 250, 124}, stop_set={248, 162, 68, 294, 230, 172, 240, 22, 280, 30})
    abstract protected void compile_atom_brace(int offset) throws Exception;
    protected int compile_atom_brace = 0x080057f8;
    public void compile_atom_brace() throws Exception
    {
        call(this.compile_atom_brace, this::compile_atom_brace);
    }


    // function: Function(address=134240552, size=164, name='compile_funcdef_lambdef_param', path='build/py/compile.o', joint_set={0, 130, 136, 138, 12, 142, 144, 22, 26, 28, 158, 32, 38, 40, 44, 50, 56, 64, 66, 70, 76, 90, 98, 104, 114, 122}, stop_set={64, 68, 136, 142, 26, 158})
    abstract protected void compile_funcdef_lambdef_param(int offset) throws Exception;
    protected int compile_funcdef_lambdef_param = 0x08005928;
    public void compile_funcdef_lambdef_param() throws Exception
    {
        call(this.compile_funcdef_lambdef_param, this::compile_funcdef_lambdef_param);
    }


    // function: Function(address=134240716, size=300, name='compile_atom_expr_normal', path='build/py/compile.o', joint_set={0, 134, 266, 12, 140, 18, 278, 152, 26, 284, 156, 34, 290, 162, 44, 174, 54, 184, 64, 196, 74, 80, 208, 210, 216, 88, 96, 100, 232, 110, 112, 242, 120, 126, 254}, stop_set={160, 292, 154, 110, 118, 282})
    abstract protected void compile_atom_expr_normal(int offset) throws Exception;
    protected int compile_atom_expr_normal = 0x080059cc;
    public void compile_atom_expr_normal() throws Exception
    {
        call(this.compile_atom_expr_normal, this::compile_atom_expr_normal);
    }


    // function: Function(address=134241016, size=76, name='compile_term', path='build/py/compile.o', joint_set={0, 32, 66, 40, 20, 24, 56, 60, 30}, stop_set={70, 30})
    abstract protected void compile_term(int offset) throws Exception;
    protected int compile_term = 0x08005af8;
    public void compile_term() throws Exception
    {
        call(this.compile_term, this::compile_term);
    }


    // function: Function(address=134241092, size=58, name='compile_binary_op', path='build/py/compile.o', joint_set={0, 32, 34, 46, 22, 54, 26}, stop_set={56, 32})
    abstract protected void compile_binary_op(int offset) throws Exception;
    protected int compile_binary_op = 0x08005b44;
    public void compile_binary_op() throws Exception
    {
        call(this.compile_binary_op, this::compile_binary_op);
    }


    // function: Function(address=134241152, size=440, name='compile_expr_stmt', path='build/py/compile.o', joint_set={0, 258, 386, 264, 392, 136, 396, 140, 270, 12, 402, 274, 404, 148, 146, 18, 152, 282, 26, 412, 156, 288, 416, 32, 292, 420, 422, 40, 300, 172, 430, 432, 176, 306, 52, 182, 312, 58, 316, 60, 192, 194, 66, 324, 68, 198, 332, 204, 78, 76, 210, 340, 84, 86, 346, 92, 94, 224, 226, 354, 376, 230, 360, 106, 236, 366, 240, 116, 248, 124}, stop_set={224, 66, 420, 76, 430, 432, 402, 84, 150, 58, 92, 414})
    abstract protected void compile_expr_stmt(int offset) throws Exception;
    protected int compile_expr_stmt = 0x08005b80;
    public void compile_expr_stmt() throws Exception
    {
        call(this.compile_expr_stmt, this::compile_expr_stmt);
    }


    // function: Function(address=134241592, size=42, name='compile_factor_2', path='build/py/compile.o', joint_set={0, 34, 40, 12, 24}, stop_set={40})
    abstract protected void compile_factor_2(int offset) throws Exception;
    protected int compile_factor_2 = 0x08005d38;
    public void compile_factor_2() throws Exception
    {
        call(this.compile_factor_2, this::compile_factor_2);
    }


    // function: Function(address=134241634, size=20, name='compile_not_test_2', path='build/py/compile.o', joint_set={0, 10, 18}, stop_set={18})
    abstract protected void compile_not_test_2(int offset) throws Exception;
    protected int compile_not_test_2 = 0x08005d62;
    public void compile_not_test_2() throws Exception
    {
        call(this.compile_not_test_2, this::compile_not_test_2);
    }


    // function: Function(address=134241654, size=80, name='compile_or_and_test', path='build/py/compile.o', joint_set={0, 32, 68, 38, 78, 46, 48, 60}, stop_set={46, 78})
    abstract protected void compile_or_and_test(int offset) throws Exception;
    protected int compile_or_and_test = 0x08005d76;
    public void compile_or_and_test() throws Exception
    {
        call(this.compile_or_and_test, this::compile_or_and_test);
    }


    // function: Function(address=134241736, size=200, name='compile_comparison', path='build/py/compile.o', joint_set={0, 136, 16, 146, 150, 24, 154, 158, 32, 36, 168, 42, 172, 46, 184, 60, 192, 68, 76, 82, 88, 96, 98, 108, 112, 118, 124}, stop_set={96, 194, 170})
    abstract protected void compile_comparison(int offset) throws Exception;
    protected int compile_comparison = 0x08005dc8;
    public void compile_comparison() throws Exception
    {
        call(this.compile_comparison, this::compile_comparison);
    }


    // function: Function(address=134241936, size=80, name='compile_test_if_expr', path='build/py/compile.o', joint_set={0, 36, 70, 44, 78, 52, 28, 62}, stop_set={78})
    abstract protected void compile_test_if_expr(int offset) throws Exception;
    protected int compile_test_if_expr = 0x08005e90;
    public void compile_test_if_expr() throws Exception
    {
        call(this.compile_test_if_expr, this::compile_test_if_expr);
    }


    // function: Function(address=134242016, size=672, name='compile_for_stmt', path='build/py/compile.o', joint_set={0, 512, 514, 18, 20, 26, 28, 34, 36, 558, 46, 48, 566, 56, 58, 574, 68, 70, 582, 592, 80, 82, 600, 606, 98, 610, 104, 106, 618, 626, 116, 632, 122, 124, 130, 132, 136, 138, 652, 654, 144, 146, 660, 150, 662, 156, 172, 174, 178, 182, 192, 194, 260, 268, 276, 284, 292, 298, 308, 316, 324, 332, 340, 348, 356, 360, 366, 374, 376, 382, 392, 410, 416, 422, 428, 436, 450, 462, 470, 476, 482, 488, 496, 500, 504}, stop_set={512, 192, 130, 56, 68, 34, 26, 136, 104, 172, 46, 144, 80, 498, 18, 660, 664, 122})
    abstract protected void compile_for_stmt(int offset) throws Exception;
    protected int compile_for_stmt = 0x08005ee0;
    public void compile_for_stmt() throws Exception
    {
        call(this.compile_for_stmt, this::compile_for_stmt);
    }


    // function: Function(address=134242688, size=150, name='compile_with_stmt_helper', path='build/py/compile.o', joint_set={0, 132, 102, 122, 40, 70, 142, 110, 80, 46, 60, 16, 148, 86, 22, 54, 26, 124}, stop_set={24, 122, 148})
    abstract protected void compile_with_stmt_helper(int offset) throws Exception;
    protected int compile_with_stmt_helper = 0x08006180;
    public void compile_with_stmt_helper() throws Exception
    {
        call(this.compile_with_stmt_helper, this::compile_with_stmt_helper);
    }


    // function: Function(address=134242838, size=32, name='compile_with_stmt', path='build/py/compile.o', joint_set={0, 18, 30}, stop_set={30})
    abstract protected void compile_with_stmt(int offset) throws Exception;
    protected int compile_with_stmt = 0x08006216;
    public void compile_with_stmt() throws Exception
    {
        call(this.compile_with_stmt, this::compile_with_stmt);
    }


    // function: Function(address=134242872, size=412, name='compile_try_except', path='build/py/compile.o', joint_set={0, 130, 264, 138, 140, 398, 272, 404, 280, 32, 288, 292, 38, 166, 172, 46, 302, 52, 180, 182, 308, 312, 60, 192, 320, 68, 196, 74, 202, 332, 208, 338, 212, 344, 88, 220, 352, 96, 228, 360, 236, 108, 370, 114, 244, 374, 122, 252, 382}, stop_set={290, 404, 310, 138})
    abstract protected void compile_try_except(int offset) throws Exception;
    protected int compile_try_except = 0x08006238;
    public void compile_try_except() throws Exception
    {
        call(this.compile_try_except, this::compile_try_except);
    }


    // function: Function(address=134243284, size=128, name='compile_try_finally', path='build/py/compile.o', joint_set={0, 64, 34, 70, 38, 106, 110, 78, 46, 86, 54, 94, 28, 126}, stop_set={108, 126})
    abstract protected void compile_try_finally(int offset) throws Exception;
    protected int compile_try_finally = 0x080063d4;
    public void compile_try_finally() throws Exception
    {
        call(this.compile_try_finally, this::compile_try_finally);
    }


    // function: Function(address=134243412, size=106, name='compile_try_stmt', path='build/py/compile.o', joint_set={0, 34, 100, 36, 40, 74, 76, 16, 52, 88, 26, 60, 62}, stop_set={104, 34, 74, 86})
    abstract protected void compile_try_stmt(int offset) throws Exception;
    protected int compile_try_stmt = 0x08006454;
    public void compile_try_stmt() throws Exception
    {
        call(this.compile_try_stmt, this::compile_try_stmt);
    }


    // function: Function(address=134243518, size=498, name='compile_async_with_stmt_helper', path='build/py/compile.o', joint_set={0, 256, 382, 262, 392, 268, 142, 400, 16, 278, 406, 152, 22, 26, 284, 412, 158, 292, 166, 424, 172, 430, 50, 52, 180, 308, 436, 314, 188, 60, 62, 446, 194, 324, 454, 70, 72, 330, 204, 78, 338, 466, 84, 212, 468, 346, 92, 476, 222, 354, 482, 228, 102, 234, 362, 490, 112, 240, 368, 496, 118, 374, 250, 126}, stop_set={70, 496, 466, 50, 24, 60})
    abstract protected void compile_async_with_stmt_helper(int offset) throws Exception;
    protected int compile_async_with_stmt_helper = 0x080064be;
    public void compile_async_with_stmt_helper() throws Exception
    {
        call(this.compile_async_with_stmt_helper, this::compile_async_with_stmt_helper);
    }


    // function: Function(address=134244016, size=358, name='compile_async_stmt', path='build/py/compile.o', joint_set={0, 128, 136, 264, 270, 144, 16, 278, 22, 154, 286, 160, 32, 36, 294, 168, 40, 42, 176, 182, 314, 188, 60, 322, 68, 198, 330, 76, 332, 206, 216, 344, 222, 228, 356, 236, 112, 244, 122, 252}, stop_set={40, 34, 356, 330})
    abstract protected void compile_async_stmt(int offset) throws Exception;
    protected int compile_async_stmt = 0x080066b0;
    public void compile_async_stmt() throws Exception
    {
        call(this.compile_async_stmt, this::compile_async_stmt);
    }


    // function: Function(address=134244376, size=92, name='compile_yield_expr', path='build/py/compile.o', joint_set={0, 68, 38, 76, 12, 78, 46, 48, 16, 52, 86, 22, 24, 60, 30}, stop_set={46, 86, 76, 22})
    abstract protected void compile_yield_expr(int offset) throws Exception;
    protected int compile_yield_expr = 0x08006818;
    public void compile_yield_expr() throws Exception
    {
        call(this.compile_yield_expr, this::compile_yield_expr);
    }


    // function: Function(address=134244468, size=112, name='compile_return_stmt', path='build/py/compile.o', joint_set={0, 96, 34, 102, 104, 40, 42, 72, 12, 48, 80, 18, 20, 86, 56, 26, 94}, stop_set={40, 18, 102, 106})
    abstract protected void compile_return_stmt(int offset) throws Exception;
    protected int compile_return_stmt = 0x08006874;
    public void compile_return_stmt() throws Exception
    {
        call(this.compile_return_stmt, this::compile_return_stmt);
    }


    // function: Function(address=134244580, size=62, name='compile_atom_paren', path='build/py/compile.o', joint_set={0, 34, 36, 8, 40, 44, 14, 48, 20, 54, 56, 28, 30}, stop_set={34, 60, 42, 54})
    abstract protected void compile_atom_paren(int offset) throws Exception;
    protected int compile_atom_paren = 0x080068e4;
    public void compile_atom_paren() throws Exception
    {
        call(this.compile_atom_paren, this::compile_atom_paren);
    }


    // function: Function(address=134244644, size=44, name='compile_atom_expr_await', path='build/py/compile.o', joint_set={0, 38, 12, 16, 22, 24, 30}, stop_set={38, 22})
    abstract protected void compile_atom_expr_await(int offset) throws Exception;
    protected int compile_atom_expr_await = 0x08006924;
    public void compile_atom_expr_await() throws Exception
    {
        call(this.compile_atom_expr_await, this::compile_atom_expr_await);
    }


    // function: Function(address=134244688, size=92, name='compile_assert_stmt', path='build/py/compile.o', joint_set={0, 34, 68, 44, 76, 18, 50, 84, 56}, stop_set={84})
    abstract protected void compile_assert_stmt(int offset) throws Exception;
    protected int compile_assert_stmt = 0x08006950;
    public void compile_assert_stmt() throws Exception
    {
        call(this.compile_assert_stmt, this::compile_assert_stmt);
    }


    // function: Function(address=134244780, size=58, name='compile_raise_stmt', path='build/py/compile.o', joint_set={0, 36, 38, 10, 44, 46, 14, 54, 22, 28}, stop_set={56, 44})
    abstract protected void compile_raise_stmt(int offset) throws Exception;
    protected int compile_raise_stmt = 0x080069ac;
    public void compile_raise_stmt() throws Exception
    {
        call(this.compile_raise_stmt, this::compile_raise_stmt);
    }


    // function: Function(address=134244840, size=192, name='compile_global_nonlocal_stmt', path='build/py/compile.o', joint_set={0, 130, 134, 138, 14, 148, 24, 156, 32, 164, 38, 166, 42, 172, 54, 58, 64, 86, 98, 102, 110, 122, 126}, stop_set={40, 164, 132, 174})
    abstract protected void compile_global_nonlocal_stmt(int offset) throws Exception;
    protected int compile_global_nonlocal_stmt = 0x080069e8;
    public void compile_global_nonlocal_stmt() throws Exception
    {
        call(this.compile_global_nonlocal_stmt, this::compile_global_nonlocal_stmt);
    }


    // function: Function(address=134245032, size=256, name='do_import_name_isra_19', path='build/py/compile.o', joint_set={0, 128, 136, 10, 12, 16, 22, 152, 160, 32, 166, 46, 48, 182, 56, 186, 64, 200, 72, 76, 80, 208, 212, 86, 218, 92, 104, 232, 110, 242, 116, 122}, stop_set={74, 14, 206, 78, 248, 184})
    abstract protected void do_import_name_isra_19(int offset) throws Exception;
    protected int do_import_name_isra_19 = 0x08006aa8;
    public void do_import_name_isra_19() throws Exception
    {
        call(this.do_import_name_isra_19, this::do_import_name_isra_19);
    }


    // function: Function(address=134245288, size=284, name='compile_import_from', path='build/py/compile.o', joint_set={0, 130, 260, 262, 268, 142, 144, 272, 18, 148, 22, 152, 26, 156, 160, 34, 38, 172, 48, 176, 54, 184, 58, 192, 72, 202, 204, 76, 212, 84, 216, 218, 94, 104, 234, 236, 114, 118, 122, 254}, stop_set={128, 234, 270, 274, 146, 116, 150, 216, 154})
    abstract protected void compile_import_from(int offset) throws Exception;
    protected int compile_import_from = 0x08006ba8;
    public void compile_import_from() throws Exception
    {
        call(this.compile_import_from, this::compile_import_from);
    }


    // function: Function(address=134245572, size=44, name='compile_dotted_as_name', path='build/py/compile.o', joint_set={0, 34, 42, 14, 22}, stop_set={42})
    abstract protected void compile_dotted_as_name(int offset) throws Exception;
    protected int compile_dotted_as_name = 0x08006cc4;
    public void compile_dotted_as_name() throws Exception
    {
        call(this.compile_dotted_as_name, this::compile_dotted_as_name);
    }


    // function: Function(address=134245616, size=602, name='mp_compile', path='build/py/compile.o', joint_set={0, 512, 134, 390, 140, 270, 528, 146, 274, 532, 402, 22, 150, 534, 278, 280, 410, 284, 160, 418, 290, 548, 166, 422, 298, 172, 556, 174, 48, 304, 178, 54, 566, 310, 438, 442, 314, 188, 574, 318, 64, 322, 324, 68, 454, 198, 584, 196, 74, 202, 588, 330, 76, 80, 466, 86, 598, 342, 472, 470, 214, 348, 476, 94, 220, 96, 352, 480, 224, 102, 358, 104, 362, 108, 508, 366, 492, 236, 240, 372, 500, 118, 506, 380}, stop_set={312, 388, 420, 102, 478, 440, 328, 586, 200, 172, 174, 526, 532, 600, 350})
    abstract protected void mp_compile(int offset) throws Exception;
    protected int mp_compile = 0x08006cf0;
    public void mp_compile() throws Exception
    {
        call(this.mp_compile, this::mp_compile);
    }


    // function: Function(address=134246218, size=34, name='mp_emit_common_get_id_for_load', path='build/py/emitcommon.o', joint_set={0, 16, 32, 24}, stop_set={32})
    abstract protected void mp_emit_common_get_id_for_load(int offset) throws Exception;
    protected int mp_emit_common_get_id_for_load = 0x08006f4a;
    public void mp_emit_common_get_id_for_load() throws Exception
    {
        call(this.mp_emit_common_get_id_for_load, this::mp_emit_common_get_id_for_load);
    }


    // function: Function(address=134246252, size=50, name='mp_emit_common_get_id_for_modification', path='build/py/emitcommon.o', joint_set={0, 32, 36, 40, 14, 46, 22, 26, 28, 30}, stop_set={48, 34, 30})
    abstract protected void mp_emit_common_get_id_for_modification(int offset) throws Exception;
    protected int mp_emit_common_get_id_for_modification = 0x08006f6c;
    public void mp_emit_common_get_id_for_modification() throws Exception
    {
        call(this.mp_emit_common_get_id_for_modification, this::mp_emit_common_get_id_for_modification);
    }


    // function: Function(address=134246302, size=60, name='mp_emit_common_id_op', path='build/py/emitcommon.o', joint_set={0, 32, 34, 38, 46, 16, 48, 22, 56}, stop_set={32, 58, 54})
    abstract protected void mp_emit_common_id_op(int offset) throws Exception;
    protected int mp_emit_common_id_op = 0x08006f9e;
    public void mp_emit_common_id_op() throws Exception
    {
        call(this.mp_emit_common_id_op, this::mp_emit_common_id_op);
    }


    // function: Function(address=134246362, size=62, name='emit_write_uint', path='build/py/emitbc.o', joint_set={0, 38, 42, 14, 52, 26}, stop_set={50, 60})
    abstract protected void emit_write_uint(int offset) throws Exception;
    protected int emit_write_uint = 0x08006fda;
    public void emit_write_uint() throws Exception
    {
        call(this.emit_write_uint, this::emit_write_uint);
    }


    // function: Function(address=134246424, size=26, name='emit_get_cur_to_write_code_info', path='build/py/emitbc.o', joint_set={0, 16, 18, 12}, stop_set={16, 24})
    abstract protected void emit_get_cur_to_write_code_info(int offset) throws Exception;
    protected int emit_get_cur_to_write_code_info = 0x08007018;
    public void emit_get_cur_to_write_code_info() throws Exception
    {
        call(this.emit_get_cur_to_write_code_info, this::emit_get_cur_to_write_code_info);
    }


    // function: Function(address=134246450, size=14, name='emit_write_code_info_byte', path='build/py/emitbc.o', joint_set={0, 10}, stop_set={12})
    abstract protected void emit_write_code_info_byte(int offset) throws Exception;
    protected int emit_write_code_info_byte = 0x08007032;
    public void emit_write_code_info_byte() throws Exception
    {
        call(this.emit_write_code_info_byte, this::emit_write_code_info_byte);
    }


    // function: Function(address=134246464, size=30, name='emit_get_cur_to_write_bytecode', path='build/py/emitbc.o', joint_set={0, 16, 18, 12}, stop_set={16, 28})
    abstract protected void emit_get_cur_to_write_bytecode(int offset) throws Exception;
    protected int emit_get_cur_to_write_bytecode = 0x08007040;
    public void emit_get_cur_to_write_bytecode() throws Exception
    {
        call(this.emit_get_cur_to_write_bytecode, this::emit_get_cur_to_write_bytecode);
    }


    // function: Function(address=134246494, size=14, name='emit_write_bytecode_byte', path='build/py/emitbc.o', joint_set={0, 10}, stop_set={12})
    abstract protected void emit_write_bytecode_byte(int offset) throws Exception;
    protected int emit_write_bytecode_byte = 0x0800705e;
    public void emit_write_bytecode_byte() throws Exception
    {
        call(this.emit_write_bytecode_byte, this::emit_write_bytecode_byte);
    }


    // function: Function(address=134246508, size=28, name='emit_write_bytecode_byte_uint', path='build/py/emitbc.o', joint_set={0, 10, 20}, stop_set={20})
    abstract protected void emit_write_bytecode_byte_uint(int offset) throws Exception;
    protected int emit_write_bytecode_byte_uint = 0x0800706c;
    public void emit_write_bytecode_byte_uint() throws Exception
    {
        call(this.emit_write_bytecode_byte_uint, this::emit_write_bytecode_byte_uint);
    }


    // function: Function(address=134246536, size=42, name='emit_write_bytecode_byte_raw_code', path='build/py/emitbc.o', joint_set={0, 40, 36, 30}, stop_set={40})
    abstract protected void emit_write_bytecode_byte_raw_code(int offset) throws Exception;
    protected int emit_write_bytecode_byte_raw_code = 0x08007088;
    public void emit_write_bytecode_byte_raw_code() throws Exception
    {
        call(this.emit_write_bytecode_byte_raw_code, this::emit_write_bytecode_byte_raw_code);
    }


    // function: Function(address=134246578, size=12, name='mp_emit_bc_delete_local', path='build/py/emitbc.o', joint_set={0, 10}, stop_set={10})
    abstract protected void mp_emit_bc_delete_local(int offset) throws Exception;
    protected int mp_emit_bc_delete_local = 0x080070b2;
    public void mp_emit_bc_delete_local() throws Exception
    {
        call(this.mp_emit_bc_delete_local, this::mp_emit_bc_delete_local);
    }


    // function: Function(address=134246590, size=22, name='emit_write_bytecode_byte_qstr', path='build/py/emitbc.o', joint_set={0, 12}, stop_set={20})
    abstract protected void emit_write_bytecode_byte_qstr(int offset) throws Exception;
    protected int emit_write_bytecode_byte_qstr = 0x080070be;
    public void emit_write_bytecode_byte_qstr() throws Exception
    {
        call(this.emit_write_bytecode_byte_qstr, this::emit_write_bytecode_byte_qstr);
    }


    // function: Function(address=134246612, size=42, name='emit_write_bytecode_byte_unsigned_label', path='build/py/emitbc.o', joint_set={0, 26, 32, 12}, stop_set={40})
    abstract protected void emit_write_bytecode_byte_unsigned_label(int offset) throws Exception;
    protected int emit_write_bytecode_byte_unsigned_label = 0x080070d4;
    public void emit_write_bytecode_byte_unsigned_label() throws Exception
    {
        call(this.emit_write_bytecode_byte_unsigned_label, this::emit_write_bytecode_byte_unsigned_label);
    }


    // function: Function(address=134246656, size=48, name='emit_write_bytecode_byte_signed_label', path='build/py/emitbc.o', joint_set={0, 26, 32, 12}, stop_set={40})
    abstract protected void emit_write_bytecode_byte_signed_label(int offset) throws Exception;
    protected int emit_write_bytecode_byte_signed_label = 0x08007100;
    public void emit_write_bytecode_byte_signed_label() throws Exception
    {
        call(this.emit_write_bytecode_byte_signed_label, this::emit_write_bytecode_byte_signed_label);
    }


    // function: Function(address=134246704, size=38, name='emit_write_bytecode_byte_obj_constprop_8', path='build/py/emitbc.o', joint_set={0, 24, 36, 30}, stop_set={36})
    abstract protected void emit_write_bytecode_byte_obj_constprop_8(int offset) throws Exception;
    protected int emit_write_bytecode_byte_obj_constprop_8 = 0x08007130;
    public void emit_write_bytecode_byte_obj_constprop_8() throws Exception
    {
        call(this.emit_write_bytecode_byte_obj_constprop_8, this::emit_write_bytecode_byte_obj_constprop_8);
    }


    // function: Function(address=134246742, size=10, name='emit_bc_new', path='build/py/emitbc.o', joint_set={0, 8}, stop_set={8})
    abstract protected void emit_bc_new(int offset) throws Exception;
    protected int emit_bc_new = 0x08007156;
    public void emit_bc_new() throws Exception
    {
        call(this.emit_bc_new, this::emit_bc_new);
    }


    // function: Function(address=134246752, size=16, name='emit_bc_set_max_num_labels', path='build/py/emitbc.o', joint_set={0, 12}, stop_set={14})
    abstract protected void emit_bc_set_max_num_labels(int offset) throws Exception;
    protected int emit_bc_set_max_num_labels = 0x08007160;
    public void emit_bc_set_max_num_labels() throws Exception
    {
        call(this.emit_bc_set_max_num_labels, this::emit_bc_set_max_num_labels);
    }


    // function: Function(address=134246768, size=24, name='emit_bc_free', path='build/py/emitbc.o', joint_set={0, 14, 22}, stop_set={22})
    abstract protected void emit_bc_free(int offset) throws Exception;
    protected int emit_bc_free = 0x08007170;
    public void emit_bc_free() throws Exception
    {
        call(this.emit_bc_free, this::emit_bc_free);
    }


    // function: Function(address=134246792, size=288, name='mp_emit_bc_start_pass', path='build/py/emitbc.o', joint_set={0, 128, 256, 270, 144, 272, 278, 152, 282, 158, 166, 38, 40, 176, 50, 186, 60, 192, 70, 200, 80, 208, 210, 90, 222, 100, 230, 104, 234, 118, 248, 254}, stop_set={198, 232, 268, 208, 280, 282})
    abstract protected void mp_emit_bc_start_pass(int offset) throws Exception;
    protected int mp_emit_bc_start_pass = 0x08007188;
    public void mp_emit_bc_start_pass() throws Exception
    {
        call(this.mp_emit_bc_start_pass, this::mp_emit_bc_start_pass);
    }


    // function: Function(address=134247080, size=88, name='mp_emit_bc_end_pass', path='build/py/emitbc.o', joint_set={0, 64, 66, 68, 72, 40, 10, 16, 86, 26}, stop_set={66, 86})
    abstract protected void mp_emit_bc_end_pass(int offset) throws Exception;
    protected int mp_emit_bc_end_pass = 0x080072a8;
    public void mp_emit_bc_end_pass() throws Exception
    {
        call(this.mp_emit_bc_end_pass, this::mp_emit_bc_end_pass);
    }


    // function: Function(address=134247168, size=10, name='mp_emit_bc_last_emit_was_return_value', path='build/py/emitbc.o', joint_set={0}, stop_set={8})
    abstract protected void mp_emit_bc_last_emit_was_return_value(int offset) throws Exception;
    protected int mp_emit_bc_last_emit_was_return_value = 0x08007300;
    public void mp_emit_bc_last_emit_was_return_value() throws Exception
    {
        call(this.mp_emit_bc_last_emit_was_return_value, this::mp_emit_bc_last_emit_was_return_value);
    }


    // function: Function(address=134247178, size=28, name='mp_emit_bc_adjust_stack_size', path='build/py/emitbc.o', joint_set={0, 6, 20, 22, 26}, stop_set={26})
    abstract protected void mp_emit_bc_adjust_stack_size(int offset) throws Exception;
    protected int mp_emit_bc_adjust_stack_size = 0x0800730a;
    public void mp_emit_bc_adjust_stack_size() throws Exception
    {
        call(this.mp_emit_bc_adjust_stack_size, this::mp_emit_bc_adjust_stack_size);
    }


    // function: Function(address=134247206, size=50, name='mp_emit_bc_load_local', path='build/py/emitbc.o', joint_set={0, 34, 36, 14, 48, 18, 22}, stop_set={48, 34})
    abstract protected void mp_emit_bc_load_local(int offset) throws Exception;
    protected int mp_emit_bc_load_local = 0x08007326;
    public void mp_emit_bc_load_local() throws Exception
    {
        call(this.mp_emit_bc_load_local, this::mp_emit_bc_load_local);
    }


    // function: Function(address=134247256, size=48, name='mp_emit_bc_load_global', path='build/py/emitbc.o', joint_set={0, 34, 42, 16, 26}, stop_set={42})
    abstract protected void mp_emit_bc_load_global(int offset) throws Exception;
    protected int mp_emit_bc_load_global = 0x08007358;
    public void mp_emit_bc_load_global() throws Exception
    {
        call(this.mp_emit_bc_load_global, this::mp_emit_bc_load_global);
    }


    // function: Function(address=134247304, size=52, name='mp_emit_bc_store_local', path='build/py/emitbc.o', joint_set={0, 36, 38, 16, 50, 20, 24}, stop_set={50, 36})
    abstract protected void mp_emit_bc_store_local(int offset) throws Exception;
    protected int mp_emit_bc_store_local = 0x08007388;
    public void mp_emit_bc_store_local() throws Exception
    {
        call(this.mp_emit_bc_store_local, this::mp_emit_bc_store_local);
    }


    // function: Function(address=134247356, size=32, name='mp_emit_bc_store_global', path='build/py/emitbc.o', joint_set={0, 16, 30}, stop_set={30})
    abstract protected void mp_emit_bc_store_global(int offset) throws Exception;
    protected int mp_emit_bc_store_global = 0x080073bc;
    public void mp_emit_bc_store_global() throws Exception
    {
        call(this.mp_emit_bc_store_global, this::mp_emit_bc_store_global);
    }


    // function: Function(address=134247388, size=28, name='mp_emit_bc_delete_global', path='build/py/emitbc.o', joint_set={0, 16, 26}, stop_set={26})
    abstract protected void mp_emit_bc_delete_global(int offset) throws Exception;
    protected int mp_emit_bc_delete_global = 0x080073dc;
    public void mp_emit_bc_delete_global() throws Exception
    {
        call(this.mp_emit_bc_delete_global, this::mp_emit_bc_delete_global);
    }


    // function: Function(address=134247416, size=60, name='emit_bc_call_function_method_helper', path='build/py/emitbc.o', joint_set={0, 34, 40, 46, 48, 54, 26}, stop_set={58, 46})
    abstract protected void emit_bc_call_function_method_helper(int offset) throws Exception;
    protected int emit_bc_call_function_method_helper = 0x080073f8;
    public void emit_bc_call_function_method_helper() throws Exception
    {
        call(this.emit_bc_call_function_method_helper, this::emit_bc_call_function_method_helper);
    }


    // function: Function(address=134247476, size=152, name='mp_emit_bc_set_source_line', path='build/py/emitbc.o', joint_set={0, 32, 66, 98, 90, 38, 74, 106, 46, 48, 80, 18, 82, 52, 116, 114, 24, 56, 124, 62}, stop_set={104, 142, 46})
    abstract protected void mp_emit_bc_set_source_line(int offset) throws Exception;
    protected int mp_emit_bc_set_source_line = 0x08007434;
    public void mp_emit_bc_set_source_line() throws Exception
    {
        call(this.mp_emit_bc_set_source_line, this::mp_emit_bc_set_source_line);
    }


    // function: Function(address=134247628, size=32, name='mp_emit_bc_label_assign', path='build/py/emitbc.o', joint_set={0, 12, 18, 22, 30}, stop_set={30})
    abstract protected void mp_emit_bc_label_assign(int offset) throws Exception;
    protected int mp_emit_bc_label_assign = 0x080074cc;
    public void mp_emit_bc_label_assign() throws Exception
    {
        call(this.mp_emit_bc_label_assign, this::mp_emit_bc_label_assign);
    }


    // function: Function(address=134247660, size=56, name='mp_emit_bc_import', path='build/py/emitbc.o', joint_set={0, 32, 34, 42, 12, 46, 18, 54}, stop_set={32, 54})
    abstract protected void mp_emit_bc_import(int offset) throws Exception;
    protected int mp_emit_bc_import = 0x080074ec;
    public void mp_emit_bc_import() throws Exception
    {
        call(this.mp_emit_bc_import, this::mp_emit_bc_import);
    }


    // function: Function(address=134247716, size=56, name='mp_emit_bc_load_const_tok', path='build/py/emitbc.o', joint_set={0, 34, 36, 38, 12, 44, 46, 16, 20, 26}, stop_set={48, 34, 44})
    abstract protected void mp_emit_bc_load_const_tok(int offset) throws Exception;
    protected int mp_emit_bc_load_const_tok = 0x08007524;
    public void mp_emit_bc_load_const_tok() throws Exception
    {
        call(this.mp_emit_bc_load_const_tok, this::mp_emit_bc_load_const_tok);
    }


    // function: Function(address=134247772, size=144, name='mp_emit_bc_load_const_small_int', path='build/py/emitbc.o', joint_set={0, 96, 34, 32, 68, 134, 104, 42, 12, 108, 76, 80, 50, 84, 20, 118, 86, 122, 126}, stop_set={32, 132, 142, 116, 120})
    abstract protected void mp_emit_bc_load_const_small_int(int offset) throws Exception;
    protected int mp_emit_bc_load_const_small_int = 0x0800755c;
    public void mp_emit_bc_load_const_small_int() throws Exception
    {
        call(this.mp_emit_bc_load_const_small_int, this::mp_emit_bc_load_const_small_int);
    }


    // function: Function(address=134247916, size=24, name='mp_emit_bc_load_const_str', path='build/py/emitbc.o', joint_set={0, 12, 22}, stop_set={22})
    abstract protected void mp_emit_bc_load_const_str(int offset) throws Exception;
    protected int mp_emit_bc_load_const_str = 0x080075ec;
    public void mp_emit_bc_load_const_str() throws Exception
    {
        call(this.mp_emit_bc_load_const_str, this::mp_emit_bc_load_const_str);
    }


    // function: Function(address=134247940, size=22, name='mp_emit_bc_load_const_obj', path='build/py/emitbc.o', joint_set={0, 12, 20}, stop_set={20})
    abstract protected void mp_emit_bc_load_const_obj(int offset) throws Exception;
    protected int mp_emit_bc_load_const_obj = 0x08007604;
    public void mp_emit_bc_load_const_obj() throws Exception
    {
        call(this.mp_emit_bc_load_const_obj, this::mp_emit_bc_load_const_obj);
    }


    // function: Function(address=134247962, size=20, name='mp_emit_bc_load_null', path='build/py/emitbc.o', joint_set={0, 10, 18}, stop_set={18})
    abstract protected void mp_emit_bc_load_null(int offset) throws Exception;
    protected int mp_emit_bc_load_null = 0x0800761a;
    public void mp_emit_bc_load_null() throws Exception
    {
        call(this.mp_emit_bc_load_null, this::mp_emit_bc_load_null);
    }


    // function: Function(address=134247982, size=36, name='mp_emit_bc_load_method', path='build/py/emitbc.o', joint_set={0, 18, 34}, stop_set={34})
    abstract protected void mp_emit_bc_load_method(int offset) throws Exception;
    protected int mp_emit_bc_load_method = 0x0800762e;
    public void mp_emit_bc_load_method() throws Exception
    {
        call(this.mp_emit_bc_load_method, this::mp_emit_bc_load_method);
    }


    // function: Function(address=134248018, size=20, name='mp_emit_bc_load_build_class', path='build/py/emitbc.o', joint_set={0, 10, 18}, stop_set={18})
    abstract protected void mp_emit_bc_load_build_class(int offset) throws Exception;
    protected int mp_emit_bc_load_build_class = 0x08007652;
    public void mp_emit_bc_load_build_class() throws Exception
    {
        call(this.mp_emit_bc_load_build_class, this::mp_emit_bc_load_build_class);
    }


    // function: Function(address=134248038, size=20, name='mp_emit_bc_dup_top', path='build/py/emitbc.o', joint_set={0, 10, 18}, stop_set={18})
    abstract protected void mp_emit_bc_dup_top(int offset) throws Exception;
    protected int mp_emit_bc_dup_top = 0x08007666;
    public void mp_emit_bc_dup_top() throws Exception
    {
        call(this.mp_emit_bc_dup_top, this::mp_emit_bc_dup_top);
    }


    // function: Function(address=134248058, size=20, name='mp_emit_bc_dup_top_two', path='build/py/emitbc.o', joint_set={0, 10, 18}, stop_set={18})
    abstract protected void mp_emit_bc_dup_top_two(int offset) throws Exception;
    protected int mp_emit_bc_dup_top_two = 0x0800767a;
    public void mp_emit_bc_dup_top_two() throws Exception
    {
        call(this.mp_emit_bc_dup_top_two, this::mp_emit_bc_dup_top_two);
    }


    // function: Function(address=134248078, size=22, name='mp_emit_bc_pop_top', path='build/py/emitbc.o', joint_set={0, 12, 20}, stop_set={20})
    abstract protected void mp_emit_bc_pop_top(int offset) throws Exception;
    protected int mp_emit_bc_pop_top = 0x0800768e;
    public void mp_emit_bc_pop_top() throws Exception
    {
        call(this.mp_emit_bc_pop_top, this::mp_emit_bc_pop_top);
    }


    // function: Function(address=134248100, size=20, name='mp_emit_bc_rot_two', path='build/py/emitbc.o', joint_set={0, 10, 18}, stop_set={18})
    abstract protected void mp_emit_bc_rot_two(int offset) throws Exception;
    protected int mp_emit_bc_rot_two = 0x080076a4;
    public void mp_emit_bc_rot_two() throws Exception
    {
        call(this.mp_emit_bc_rot_two, this::mp_emit_bc_rot_two);
    }


    // function: Function(address=134248120, size=80, name='mp_emit_bc_attr', path='build/py/emitbc.o', joint_set={0, 34, 26, 68, 42, 10, 44, 48, 16, 20, 52, 58}, stop_set={72, 42})
    abstract protected void mp_emit_bc_attr(int offset) throws Exception;
    protected int mp_emit_bc_attr = 0x080076b8;
    public void mp_emit_bc_attr() throws Exception
    {
        call(this.mp_emit_bc_attr, this::mp_emit_bc_attr);
    }


    // function: Function(address=134248200, size=20, name='mp_emit_bc_rot_three', path='build/py/emitbc.o', joint_set={0, 10, 18}, stop_set={18})
    abstract protected void mp_emit_bc_rot_three(int offset) throws Exception;
    protected int mp_emit_bc_rot_three = 0x08007708;
    public void mp_emit_bc_rot_three() throws Exception
    {
        call(this.mp_emit_bc_rot_three, this::mp_emit_bc_rot_three);
    }


    // function: Function(address=134248220, size=52, name='mp_emit_bc_subscr', path='build/py/emitbc.o', joint_set={0, 32, 38, 8, 14, 48, 16, 22, 24, 28}, stop_set={50, 22})
    abstract protected void mp_emit_bc_subscr(int offset) throws Exception;
    protected int mp_emit_bc_subscr = 0x0800771c;
    public void mp_emit_bc_subscr() throws Exception
    {
        call(this.mp_emit_bc_subscr, this::mp_emit_bc_subscr);
    }


    // function: Function(address=134248272, size=24, name='mp_emit_bc_jump', path='build/py/emitbc.o', joint_set={0, 12, 22}, stop_set={22})
    abstract protected void mp_emit_bc_jump(int offset) throws Exception;
    protected int mp_emit_bc_jump = 0x08007750;
    public void mp_emit_bc_jump() throws Exception
    {
        call(this.mp_emit_bc_jump, this::mp_emit_bc_jump);
    }


    // function: Function(address=134248296, size=34, name='mp_emit_bc_pop_jump_if', path='build/py/emitbc.o', joint_set={0, 32, 16, 24, 26}, stop_set={32})
    abstract protected void mp_emit_bc_pop_jump_if(int offset) throws Exception;
    protected int mp_emit_bc_pop_jump_if = 0x08007768;
    public void mp_emit_bc_pop_jump_if() throws Exception
    {
        call(this.mp_emit_bc_pop_jump_if, this::mp_emit_bc_pop_jump_if);
    }


    // function: Function(address=134248330, size=34, name='mp_emit_bc_jump_if_or_pop', path='build/py/emitbc.o', joint_set={0, 32, 16, 24, 26}, stop_set={32})
    abstract protected void mp_emit_bc_jump_if_or_pop(int offset) throws Exception;
    protected int mp_emit_bc_jump_if_or_pop = 0x0800778a;
    public void mp_emit_bc_jump_if_or_pop() throws Exception
    {
        call(this.mp_emit_bc_jump_if_or_pop, this::mp_emit_bc_jump_if_or_pop);
    }


    // function: Function(address=134248364, size=100, name='mp_emit_bc_unwind_jump', path='build/py/emitbc.o', joint_set={0, 34, 26, 68, 70, 42, 78, 16, 50, 22, 58, 94}, stop_set={68, 94})
    abstract protected void mp_emit_bc_unwind_jump(int offset) throws Exception;
    protected int mp_emit_bc_unwind_jump = 0x080077ac;
    public void mp_emit_bc_unwind_jump() throws Exception
    {
        call(this.mp_emit_bc_unwind_jump, this::mp_emit_bc_unwind_jump);
    }


    // function: Function(address=134248464, size=36, name='mp_emit_bc_setup_block', path='build/py/emitbc.o', joint_set={0, 34, 14, 16, 24}, stop_set={34})
    abstract protected void mp_emit_bc_setup_block(int offset) throws Exception;
    protected int mp_emit_bc_setup_block = 0x08007810;
    public void mp_emit_bc_setup_block() throws Exception
    {
        call(this.mp_emit_bc_setup_block, this::mp_emit_bc_setup_block);
    }


    // function: Function(address=134248500, size=22, name='mp_emit_bc_end_finally', path='build/py/emitbc.o', joint_set={0, 12, 20}, stop_set={20})
    abstract protected void mp_emit_bc_end_finally(int offset) throws Exception;
    protected int mp_emit_bc_end_finally = 0x08007834;
    public void mp_emit_bc_end_finally() throws Exception
    {
        call(this.mp_emit_bc_end_finally, this::mp_emit_bc_end_finally);
    }


    // function: Function(address=134248522, size=38, name='mp_emit_bc_get_iter', path='build/py/emitbc.o', joint_set={0, 36, 22, 28, 30}, stop_set={36})
    abstract protected void mp_emit_bc_get_iter(int offset) throws Exception;
    protected int mp_emit_bc_get_iter = 0x0800784a;
    public void mp_emit_bc_get_iter() throws Exception
    {
        call(this.mp_emit_bc_get_iter, this::mp_emit_bc_get_iter);
    }


    // function: Function(address=134248560, size=24, name='mp_emit_bc_for_iter', path='build/py/emitbc.o', joint_set={0, 12, 22}, stop_set={22})
    abstract protected void mp_emit_bc_for_iter(int offset) throws Exception;
    protected int mp_emit_bc_for_iter = 0x08007870;
    public void mp_emit_bc_for_iter() throws Exception
    {
        call(this.mp_emit_bc_for_iter, this::mp_emit_bc_for_iter);
    }


    // function: Function(address=134248584, size=12, name='mp_emit_bc_for_iter_end', path='build/py/emitbc.o', joint_set={0, 10}, stop_set={10})
    abstract protected void mp_emit_bc_for_iter_end(int offset) throws Exception;
    protected int mp_emit_bc_for_iter_end = 0x08007888;
    public void mp_emit_bc_for_iter_end() throws Exception
    {
        call(this.mp_emit_bc_for_iter_end, this::mp_emit_bc_for_iter_end);
    }


    // function: Function(address=134248596, size=20, name='mp_emit_bc_pop_block', path='build/py/emitbc.o', joint_set={0, 10, 18}, stop_set={18})
    abstract protected void mp_emit_bc_pop_block(int offset) throws Exception;
    protected int mp_emit_bc_pop_block = 0x08007894;
    public void mp_emit_bc_pop_block() throws Exception
    {
        call(this.mp_emit_bc_pop_block, this::mp_emit_bc_pop_block);
    }


    // function: Function(address=134248616, size=54, name='mp_emit_bc_with_cleanup', path='build/py/emitbc.o', joint_set={0, 34, 10, 42, 18, 52, 26}, stop_set={52})
    abstract protected void mp_emit_bc_with_cleanup(int offset) throws Exception;
    protected int mp_emit_bc_with_cleanup = 0x080078a8;
    public void mp_emit_bc_with_cleanup() throws Exception
    {
        call(this.mp_emit_bc_with_cleanup, this::mp_emit_bc_with_cleanup);
    }


    // function: Function(address=134248670, size=20, name='mp_emit_bc_pop_except', path='build/py/emitbc.o', joint_set={0, 10, 18}, stop_set={18})
    abstract protected void mp_emit_bc_pop_except(int offset) throws Exception;
    protected int mp_emit_bc_pop_except = 0x080078de;
    public void mp_emit_bc_pop_except() throws Exception
    {
        call(this.mp_emit_bc_pop_except, this::mp_emit_bc_pop_except);
    }


    // function: Function(address=134248690, size=26, name='mp_emit_bc_unary_op', path='build/py/emitbc.o', joint_set={0, 24, 12}, stop_set={24})
    abstract protected void mp_emit_bc_unary_op(int offset) throws Exception;
    protected int mp_emit_bc_unary_op = 0x080078f2;
    public void mp_emit_bc_unary_op() throws Exception
    {
        call(this.mp_emit_bc_unary_op, this::mp_emit_bc_unary_op);
    }


    // function: Function(address=134248716, size=68, name='mp_emit_bc_binary_op', path='build/py/emitbc.o', joint_set={0, 32, 40, 10, 44, 16, 20, 52, 60, 62}, stop_set={66, 60})
    abstract protected void mp_emit_bc_binary_op(int offset) throws Exception;
    protected int mp_emit_bc_binary_op = 0x0800790c;
    public void mp_emit_bc_binary_op() throws Exception
    {
        call(this.mp_emit_bc_binary_op, this::mp_emit_bc_binary_op);
    }


    // function: Function(address=134248784, size=40, name='mp_emit_bc_build', path='build/py/emitbc.o', joint_set={0, 34, 36, 14, 20}, stop_set={34, 38})
    abstract protected void mp_emit_bc_build(int offset) throws Exception;
    protected int mp_emit_bc_build = 0x08007950;
    public void mp_emit_bc_build() throws Exception
    {
        call(this.mp_emit_bc_build, this::mp_emit_bc_build);
    }


    // function: Function(address=134248824, size=22, name='mp_emit_bc_store_map', path='build/py/emitbc.o', joint_set={0, 12, 20}, stop_set={20})
    abstract protected void mp_emit_bc_store_map(int offset) throws Exception;
    protected int mp_emit_bc_store_map = 0x08007978;
    public void mp_emit_bc_store_map() throws Exception
    {
        call(this.mp_emit_bc_store_map, this::mp_emit_bc_store_map);
    }


    // function: Function(address=134248846, size=52, name='mp_emit_bc_store_comp', path='build/py/emitbc.o', joint_set={0, 40, 42, 10, 44, 14, 48, 18, 26}, stop_set={40, 50, 46})
    abstract protected void mp_emit_bc_store_comp(int offset) throws Exception;
    protected int mp_emit_bc_store_comp = 0x0800798e;
    public void mp_emit_bc_store_comp() throws Exception
    {
        call(this.mp_emit_bc_store_comp, this::mp_emit_bc_store_comp);
    }


    // function: Function(address=134248898, size=24, name='mp_emit_bc_unpack_sequence', path='build/py/emitbc.o', joint_set={0, 12, 22}, stop_set={22})
    abstract protected void mp_emit_bc_unpack_sequence(int offset) throws Exception;
    protected int mp_emit_bc_unpack_sequence = 0x080079c2;
    public void mp_emit_bc_unpack_sequence() throws Exception
    {
        call(this.mp_emit_bc_unpack_sequence, this::mp_emit_bc_unpack_sequence);
    }


    // function: Function(address=134248922, size=28, name='mp_emit_bc_unpack_ex', path='build/py/emitbc.o', joint_set={0, 26, 14}, stop_set={26})
    abstract protected void mp_emit_bc_unpack_ex(int offset) throws Exception;
    protected int mp_emit_bc_unpack_ex = 0x080079da;
    public void mp_emit_bc_unpack_ex() throws Exception
    {
        call(this.mp_emit_bc_unpack_ex, this::mp_emit_bc_unpack_ex);
    }


    // function: Function(address=134248950, size=42, name='mp_emit_bc_make_function', path='build/py/emitbc.o', joint_set={0, 36, 14, 18, 22, 28, 30}, stop_set={40, 28})
    abstract protected void mp_emit_bc_make_function(int offset) throws Exception;
    protected int mp_emit_bc_make_function = 0x080079f6;
    public void mp_emit_bc_make_function() throws Exception
    {
        call(this.mp_emit_bc_make_function, this::mp_emit_bc_make_function);
    }


    // function: Function(address=134248992, size=54, name='mp_emit_bc_make_closure', path='build/py/emitbc.o', joint_set={0, 32, 40, 42, 14, 48, 22, 26}, stop_set={40, 52})
    abstract protected void mp_emit_bc_make_closure(int offset) throws Exception;
    protected int mp_emit_bc_make_closure = 0x08007a20;
    public void mp_emit_bc_make_closure() throws Exception
    {
        call(this.mp_emit_bc_make_closure, this::mp_emit_bc_make_closure);
    }


    // function: Function(address=134249046, size=18, name='mp_emit_bc_call_function', path='build/py/emitbc.o', joint_set={0, 16}, stop_set={16})
    abstract protected void mp_emit_bc_call_function(int offset) throws Exception;
    protected int mp_emit_bc_call_function = 0x08007a56;
    public void mp_emit_bc_call_function() throws Exception
    {
        call(this.mp_emit_bc_call_function, this::mp_emit_bc_call_function);
    }


    // function: Function(address=134249064, size=20, name='mp_emit_bc_call_method', path='build/py/emitbc.o', joint_set={0, 18}, stop_set={18})
    abstract protected void mp_emit_bc_call_method(int offset) throws Exception;
    protected int mp_emit_bc_call_method = 0x08007a68;
    public void mp_emit_bc_call_method() throws Exception
    {
        call(this.mp_emit_bc_call_method, this::mp_emit_bc_call_method);
    }


    // function: Function(address=134249084, size=26, name='mp_emit_bc_return_value', path='build/py/emitbc.o', joint_set={0, 24, 12}, stop_set={24})
    abstract protected void mp_emit_bc_return_value(int offset) throws Exception;
    protected int mp_emit_bc_return_value = 0x08007a7c;
    public void mp_emit_bc_return_value() throws Exception
    {
        call(this.mp_emit_bc_return_value, this::mp_emit_bc_return_value);
    }


    // function: Function(address=134249110, size=28, name='mp_emit_bc_raise_varargs', path='build/py/emitbc.o', joint_set={0, 12, 20}, stop_set={26})
    abstract protected void mp_emit_bc_raise_varargs(int offset) throws Exception;
    protected int mp_emit_bc_raise_varargs = 0x08007a96;
    public void mp_emit_bc_raise_varargs() throws Exception
    {
        call(this.mp_emit_bc_raise_varargs, this::mp_emit_bc_raise_varargs);
    }


    // function: Function(address=134249138, size=34, name='mp_emit_bc_yield', path='build/py/emitbc.o', joint_set={0, 32, 12}, stop_set={32})
    abstract protected void mp_emit_bc_yield(int offset) throws Exception;
    protected int mp_emit_bc_yield = 0x08007ab2;
    public void mp_emit_bc_yield() throws Exception
    {
        call(this.mp_emit_bc_yield, this::mp_emit_bc_yield);
    }


    // function: Function(address=134249172, size=10, name='mp_emit_bc_start_except_handler', path='build/py/emitbc.o', joint_set={0, 8}, stop_set={8})
    abstract protected void mp_emit_bc_start_except_handler(int offset) throws Exception;
    protected int mp_emit_bc_start_except_handler = 0x08007ad4;
    public void mp_emit_bc_start_except_handler() throws Exception
    {
        call(this.mp_emit_bc_start_except_handler, this::mp_emit_bc_start_except_handler);
    }


    // function: Function(address=134249182, size=12, name='mp_emit_bc_end_except_handler', path='build/py/emitbc.o', joint_set={0, 10}, stop_set={10})
    abstract protected void mp_emit_bc_end_except_handler(int offset) throws Exception;
    protected int mp_emit_bc_end_except_handler = 0x08007ade;
    public void mp_emit_bc_end_except_handler() throws Exception
    {
        call(this.mp_emit_bc_end_except_handler, this::mp_emit_bc_end_except_handler);
    }


    // function: Function(address=134249196, size=1208, name='mp_format_float', path='build/py/formatfloat.o', joint_set={0, 1026, 514, 518, 1034, 522, 1036, 1038, 530, 1046, 22, 538, 26, 542, 1054, 1060, 548, 36, 552, 556, 44, 1072, 48, 1078, 566, 56, 1080, 570, 60, 1086, 576, 578, 1090, 66, 582, 1096, 1098, 74, 1102, 78, 592, 1104, 598, 600, 1112, 604, 1116, 606, 1118, 1122, 100, 612, 1126, 1132, 1140, 1144, 1148, 638, 126, 1152, 130, 644, 1158, 138, 142, 656, 1168, 1172, 664, 1178, 674, 162, 1188, 680, 172, 1196, 1200, 690, 178, 186, 698, 700, 704, 194, 706, 198, 716, 724, 216, 730, 220, 222, 736, 740, 744, 234, 748, 238, 240, 758, 254, 770, 260, 774, 266, 268, 790, 792, 282, 288, 294, 296, 808, 298, 302, 814, 818, 308, 310, 826, 316, 830, 836, 326, 840, 330, 848, 340, 344, 856, 858, 352, 356, 870, 874, 364, 880, 370, 882, 888, 890, 382, 388, 390, 396, 398, 404, 410, 416, 418, 932, 426, 938, 940, 946, 952, 444, 964, 456, 968, 460, 974, 984, 476, 478, 990, 992, 996, 998, 1004, 494, 1012, 1016, 506, 1020}, stop_set={1156, 900, 396, 1166, 528, 1170, 408, 672, 416, 1186, 294, 678, 170, 42, 1200, 308, 950, 184, 58, 698, 962, 966, 1096, 714, 972, 1102, 722, 598, 982, 214, 1116, 604, 990, 1120, 996, 872, 1130, 1002, 746, 880, 1142, 1146, 380, 1150})
    abstract protected void mp_format_float(int offset) throws Exception;
    protected int mp_format_float = 0x08007aec;
    public void mp_format_float() throws Exception
    {
        call(this.mp_format_float, this::mp_format_float);
    }


    // function: Function(address=134250404, size=122, name='mp_parse_num_base', path='build/py/parsenumbase.o', joint_set={0, 8, 18, 22, 34, 36, 40, 44, 48, 50, 54, 58, 62, 68, 72, 84, 88, 92, 96, 100, 104, 108, 120}, stop_set={98, 38, 52, 86, 120, 60})
    abstract protected void mp_parse_num_base(int offset) throws Exception;
    protected int mp_parse_num_base = 0x08007fa4;
    public void mp_parse_num_base() throws Exception
    {
        call(this.mp_parse_num_base, this::mp_parse_num_base);
    }


    // function: Function(address=134250528, size=32, name='unlikely_raise_exc', path='build/py/parsenum.o', joint_set={0, 8, 22}, stop_set={24})
    abstract protected void unlikely_raise_exc(int offset) throws Exception;
    protected int unlikely_raise_exc = 0x08008020;
    public void unlikely_raise_exc() throws Exception
    {
        call(this.unlikely_raise_exc, this::unlikely_raise_exc);
    }


    // function: Function(address=134250560, size=296, name='mp_parse_num_integer', path='build/py/parsenum.o', joint_set={0, 258, 132, 140, 272, 16, 146, 150, 22, 154, 28, 30, 158, 162, 34, 40, 174, 46, 178, 52, 54, 190, 64, 194, 70, 74, 202, 80, 208, 82, 212, 88, 92, 226, 102, 230, 232, 236, 112, 242, 252, 246, 248, 124}, stop_set={256, 160, 228, 276, 246, 24, 156})
    abstract protected void mp_parse_num_integer(int offset) throws Exception;
    protected int mp_parse_num_integer = 0x08008040;
    public void mp_parse_num_integer() throws Exception
    {
        call(this.mp_parse_num_integer, this::mp_parse_num_integer);
    }


    // function: Function(address=134250856, size=632, name='mp_parse_num_decimal', path='build/py/parsenum.o', joint_set={0, 514, 518, 520, 12, 524, 526, 16, 18, 532, 24, 536, 540, 30, 544, 36, 550, 40, 556, 46, 48, 562, 564, 568, 58, 64, 66, 582, 74, 588, 76, 590, 596, 84, 86, 600, 602, 94, 102, 110, 118, 126, 134, 136, 142, 146, 154, 160, 164, 170, 172, 180, 182, 190, 192, 196, 202, 208, 212, 214, 222, 228, 230, 244, 248, 256, 264, 268, 274, 278, 280, 294, 302, 306, 312, 320, 328, 332, 354, 362, 366, 374, 382, 388, 394, 398, 402, 406, 412, 416, 420, 424, 428, 436, 440, 446, 448, 452, 456, 462, 470, 476, 484, 488, 492, 496, 502, 504, 508}, stop_set={518, 524, 140, 144, 400, 16, 410, 542, 158, 422, 554, 170, 46, 562, 180, 190, 64, 580, 454, 330, 74, 588, 594, 212, 468, 84, 600, 602, 352, 490, 494, 500})
    abstract protected void mp_parse_num_decimal(int offset) throws Exception;
    protected int mp_parse_num_decimal = 0x08008168;
    public void mp_parse_num_decimal() throws Exception
    {
        call(this.mp_parse_num_decimal, this::mp_parse_num_decimal);
    }


    // function: Function(address=134251488, size=24, name='mp_emit_glue_new_raw_code', path='build/py/emitglue.o', joint_set={0, 8}, stop_set={22})
    abstract protected void mp_emit_glue_new_raw_code(int offset) throws Exception;
    protected int mp_emit_glue_new_raw_code = 0x080083e0;
    public void mp_emit_glue_new_raw_code() throws Exception
    {
        call(this.mp_emit_glue_new_raw_code, this::mp_emit_glue_new_raw_code);
    }


    // function: Function(address=134251512, size=44, name='mp_emit_glue_assign_bytecode', path='build/py/emitglue.o', joint_set={0}, stop_set={36})
    abstract protected void mp_emit_glue_assign_bytecode(int offset) throws Exception;
    protected int mp_emit_glue_assign_bytecode = 0x080083f8;
    public void mp_emit_glue_assign_bytecode() throws Exception
    {
        call(this.mp_emit_glue_assign_bytecode, this::mp_emit_glue_assign_bytecode);
    }


    // function: Function(address=134251556, size=32, name='mp_make_function_from_raw_code', path='build/py/emitglue.o', joint_set={0, 16, 26, 22}, stop_set={26})
    abstract protected void mp_make_function_from_raw_code(int offset) throws Exception;
    protected int mp_make_function_from_raw_code = 0x08008424;
    public void mp_make_function_from_raw_code() throws Exception
    {
        call(this.mp_make_function_from_raw_code, this::mp_make_function_from_raw_code);
    }


    // function: Function(address=134251588, size=42, name='mp_make_closure_from_raw_code', path='build/py/emitglue.o', joint_set={0, 40, 16, 20, 24}, stop_set={40})
    abstract protected void mp_make_closure_from_raw_code(int offset) throws Exception;
    protected int mp_make_closure_from_raw_code = 0x08008444;
    public void mp_make_closure_from_raw_code() throws Exception
    {
        call(this.mp_make_closure_from_raw_code, this::mp_make_closure_from_raw_code);
    }


    // function: Function(address=134251630, size=26, name='read_bytes', path='build/py/persistentcode.o', joint_set={0, 8, 12, 14}, stop_set={24, 12})
    abstract protected void read_bytes(int offset) throws Exception;
    protected int read_bytes = 0x0800846e;
    public void read_bytes() throws Exception
    {
        call(this.read_bytes, this::read_bytes);
    }


    // function: Function(address=134251656, size=30, name='read_uint', path='build/py/persistentcode.o', joint_set={0, 8, 26}, stop_set={28})
    abstract protected void read_uint(int offset) throws Exception;
    protected int read_uint = 0x08008488;
    public void read_uint() throws Exception
    {
        call(this.read_uint, this::read_uint);
    }


    // function: Function(address=134251686, size=48, name='load_qstr', path='build/py/persistentcode.o', joint_set={0, 34, 8, 44, 14, 26}, stop_set={46})
    abstract protected void load_qstr(int offset) throws Exception;
    protected int load_qstr = 0x080084a6;
    public void load_qstr() throws Exception
    {
        call(this.load_qstr, this::load_qstr);
    }


    // function: Function(address=134251736, size=416, name='load_raw_code', path='build/py/persistentcode.o', joint_set={0, 260, 388, 390, 10, 266, 138, 396, 142, 16, 272, 148, 278, 156, 28, 286, 38, 44, 300, 176, 306, 186, 316, 192, 326, 200, 330, 206, 80, 336, 86, 214, 344, 220, 352, 224, 98, 354, 356, 104, 362, 236, 112, 242, 372, 250, 254}, stop_set={352, 388, 270, 240, 370, 402, 284})
    abstract protected void load_raw_code(int offset) throws Exception;
    protected int load_raw_code = 0x080084d8;
    public void load_raw_code() throws Exception
    {
        call(this.load_raw_code, this::load_raw_code);
    }


    // function: Function(address=134252152, size=68, name='mp_raw_code_load', path='build/py/persistentcode.o', joint_set={0, 32, 38, 44, 14, 50, 20, 26}, stop_set={40, 60})
    abstract protected void mp_raw_code_load(int offset) throws Exception;
    protected int mp_raw_code_load = 0x08008678;
    public void mp_raw_code_load() throws Exception
    {
        call(this.mp_raw_code_load, this::mp_raw_code_load);
    }


    // function: Function(address=134252220, size=20, name='mp_raw_code_load_file', path='build/py/persistentcode.o', joint_set={0, 16, 10}, stop_set={18})
    abstract protected void mp_raw_code_load_file(int offset) throws Exception;
    protected int mp_raw_code_load_file = 0x080086bc;
    public void mp_raw_code_load_file() throws Exception
    {
        call(this.mp_raw_code_load_file, this::mp_raw_code_load_file);
    }


    // function: Function(address=134252240, size=120, name='mp_init', path='build/py/runtime.o', joint_set={0, 32, 68, 6, 78, 58}, stop_set={96})
    abstract protected void mp_init(int offset) throws Exception;
    protected int mp_init = 0x080086d0;
    public void mp_init() throws Exception
    {
        call(this.mp_init, this::mp_init);
    }


    // function: Function(address=134252360, size=2, name='mp_deinit', path='build/py/runtime.o', joint_set={0}, stop_set={0})
    abstract protected void mp_deinit(int offset) throws Exception;
    protected int mp_deinit = 0x08008748;
    public void mp_deinit() throws Exception
    {
        call(this.mp_deinit, this::mp_deinit);
    }


    // function: Function(address=134252364, size=104, name='mp_load_global', path='build/py/runtime.o', joint_set={0, 64, 68, 38, 78, 46, 82, 50, 52, 54, 24, 28}, stop_set={52, 78, 84})
    abstract protected void mp_load_global(int offset) throws Exception;
    protected int mp_load_global = 0x0800874c;
    public void mp_load_global() throws Exception
    {
        call(this.mp_load_global, this::mp_load_global);
    }


    // function: Function(address=134252468, size=48, name='mp_load_name', path='build/py/runtime.o', joint_set={0, 32, 34, 36, 42, 14, 28}, stop_set={34, 42})
    abstract protected void mp_load_name(int offset) throws Exception;
    protected int mp_load_name = 0x080087b4;
    public void mp_load_name() throws Exception
    {
        call(this.mp_load_name, this::mp_load_name);
    }


    // function: Function(address=134252516, size=44, name='mp_load_build_class', path='build/py/runtime.o', joint_set={0, 32, 14, 16, 18, 28}, stop_set={16, 34})
    abstract protected void mp_load_build_class(int offset) throws Exception;
    protected int mp_load_build_class = 0x080087e4;
    public void mp_load_build_class() throws Exception
    {
        call(this.mp_load_build_class, this::mp_load_build_class);
    }


    // function: Function(address=134252560, size=24, name='mp_store_name', path='build/py/runtime.o', joint_set={0, 18}, stop_set={18})
    abstract protected void mp_store_name(int offset) throws Exception;
    protected int mp_store_name = 0x08008810;
    public void mp_store_name() throws Exception
    {
        call(this.mp_store_name, this::mp_store_name);
    }


    // function: Function(address=134252584, size=24, name='mp_delete_name', path='build/py/runtime.o', joint_set={0, 16}, stop_set={16})
    abstract protected void mp_delete_name(int offset) throws Exception;
    protected int mp_delete_name = 0x08008828;
    public void mp_delete_name() throws Exception
    {
        call(this.mp_delete_name, this::mp_delete_name);
    }


    // function: Function(address=134252608, size=24, name='mp_store_global', path='build/py/runtime.o', joint_set={0, 18}, stop_set={18})
    abstract protected void mp_store_global(int offset) throws Exception;
    protected int mp_store_global = 0x08008840;
    public void mp_store_global() throws Exception
    {
        call(this.mp_store_global, this::mp_store_global);
    }


    // function: Function(address=134252632, size=24, name='mp_delete_global', path='build/py/runtime.o', joint_set={0, 16}, stop_set={16})
    abstract protected void mp_delete_global(int offset) throws Exception;
    protected int mp_delete_global = 0x08008858;
    public void mp_delete_global() throws Exception
    {
        call(this.mp_delete_global, this::mp_delete_global);
    }


    // function: Function(address=134252656, size=264, name='mp_unary_op', path='build/py/runtime.o', joint_set={0, 134, 138, 10, 16, 148, 20, 22, 26, 154, 32, 162, 38, 40, 170, 44, 174, 48, 50, 182, 58, 188, 190, 62, 66, 196, 70, 202, 78, 212, 86, 90, 94, 224, 228, 102, 110, 238, 114, 122, 126}, stop_set={224, 160, 120, 238, 92, 112, 84, 24, 56, 188})
    abstract protected void mp_unary_op(int offset) throws Exception;
    protected int mp_unary_op = 0x08008870;
    public void mp_unary_op() throws Exception
    {
        call(this.mp_unary_op, this::mp_unary_op);
    }


    // function: Function(address=134252920, size=60, name='mp_call_function_n_kw', path='build/py/runtime.o', joint_set={0, 36, 40, 14, 20, 26}, stop_set={50, 36})
    abstract protected void mp_call_function_n_kw(int offset) throws Exception;
    protected int mp_call_function_n_kw = 0x08008978;
    public void mp_call_function_n_kw() throws Exception
    {
        call(this.mp_call_function_n_kw, this::mp_call_function_n_kw);
    }


    // function: Function(address=134252980, size=14, name='mp_call_function_0', path='build/py/runtime.o', joint_set={0, 12}, stop_set={12})
    abstract protected void mp_call_function_0(int offset) throws Exception;
    protected int mp_call_function_0 = 0x080089b4;
    public void mp_call_function_0() throws Exception
    {
        call(this.mp_call_function_0, this::mp_call_function_0);
    }


    // function: Function(address=134252994, size=16, name='mp_call_function_1', path='build/py/runtime.o', joint_set={0, 14}, stop_set={14})
    abstract protected void mp_call_function_1(int offset) throws Exception;
    protected int mp_call_function_1 = 0x080089c2;
    public void mp_call_function_1() throws Exception
    {
        call(this.mp_call_function_1, this::mp_call_function_1);
    }


    // function: Function(address=134253012, size=64, name='checked_fun_call', path='build/py/runtime.o', joint_set={0, 38, 42, 14, 20, 54, 26}, stop_set={38, 54})
    abstract protected void checked_fun_call(int offset) throws Exception;
    protected int checked_fun_call = 0x080089d4;
    public void checked_fun_call() throws Exception
    {
        call(this.checked_fun_call, this::checked_fun_call);
    }


    // function: Function(address=134253076, size=30, name='mp_call_method_n_kw', path='build/py/runtime.o', joint_set={0, 28}, stop_set={28})
    abstract protected void mp_call_method_n_kw(int offset) throws Exception;
    protected int mp_call_method_n_kw = 0x08008a14;
    public void mp_call_method_n_kw() throws Exception
    {
        call(this.mp_call_method_n_kw, this::mp_call_method_n_kw);
    }


    // function: Function(address=134253108, size=172, name='mp_convert_member_lookup', path='build/py/runtime.o', joint_set={0, 130, 12, 20, 24, 26, 32, 36, 40, 42, 48, 54, 58, 68, 72, 78, 82, 88, 94, 100, 106, 112, 118}, stop_set={128, 134, 46, 24, 56})
    abstract protected void mp_convert_member_lookup(int offset) throws Exception;
    protected int mp_convert_member_lookup = 0x08008a34;
    public void mp_convert_member_lookup() throws Exception
    {
        call(this.mp_convert_member_lookup, this::mp_convert_member_lookup);
    }


    // function: Function(address=134253280, size=104, name='mp_load_method_maybe', path='build/py/runtime.o', joint_set={0, 96, 66, 32, 38, 44, 60, 80, 18, 50, 84, 24, 26, 28}, stop_set={96, 26, 58, 42})
    abstract protected void mp_load_method_maybe(int offset) throws Exception;
    protected int mp_load_method_maybe = 0x08008ae0;
    public void mp_load_method_maybe() throws Exception
    {
        call(this.mp_load_method_maybe, this::mp_load_method_maybe);
    }


    // function: Function(address=134253384, size=80, name='mp_load_method', path='build/py/runtime.o', joint_set={0, 32, 38, 12, 44, 48, 18, 54, 24, 62}, stop_set={44, 62, 60})
    abstract protected void mp_load_method(int offset) throws Exception;
    protected int mp_load_method = 0x08008b48;
    public void mp_load_method() throws Exception
    {
        call(this.mp_load_method, this::mp_load_method);
    }


    // function: Function(address=134253464, size=24, name='mp_load_attr', path='build/py/runtime.o', joint_set={0, 8, 16, 18, 22}, stop_set={16, 22})
    abstract protected void mp_load_attr(int offset) throws Exception;
    protected int mp_load_attr = 0x08008b98;
    public void mp_load_attr() throws Exception
    {
        call(this.mp_load_attr, this::mp_load_attr);
    }


    // function: Function(address=134253488, size=68, name='mp_load_method_protected', path='build/py/runtime.o', joint_set={0, 32, 36, 40, 44, 18, 54, 22, 58}, stop_set={60, 38})
    abstract protected void mp_load_method_protected(int offset) throws Exception;
    protected int mp_load_method_protected = 0x08008bb0;
    public void mp_load_method_protected() throws Exception
    {
        call(this.mp_load_method_protected, this::mp_load_method_protected);
    }


    // function: Function(address=134253556, size=72, name='mp_store_attr', path='build/py/runtime.o', joint_set={0, 38, 12, 44, 18, 56, 60}, stop_set={56, 60})
    abstract protected void mp_store_attr(int offset) throws Exception;
    protected int mp_store_attr = 0x08008bf4;
    public void mp_store_attr() throws Exception
    {
        call(this.mp_store_attr, this::mp_store_attr);
    }


    // function: Function(address=134253628, size=112, name='mp_getiter', path='build/py/runtime.o', joint_set={0, 96, 32, 38, 70, 10, 74, 48, 20, 84, 86, 54, 24, 30, 60, 94}, stop_set={70, 98, 84, 94})
    abstract protected void mp_getiter(int offset) throws Exception;
    protected int mp_getiter = 0x08008c3c;
    public void mp_getiter() throws Exception
    {
        call(this.mp_getiter, this::mp_getiter);
    }


    // function: Function(address=134253740, size=76, name='mp_iternext_allow_raise', path='build/py/runtime.o', joint_set={0, 64, 36, 8, 46, 14, 48, 18, 20, 54, 30}, stop_set={64, 18, 46})
    abstract protected void mp_iternext_allow_raise(int offset) throws Exception;
    protected int mp_iternext_allow_raise = 0x08008cac;
    public void mp_iternext_allow_raise() throws Exception
    {
        call(this.mp_iternext_allow_raise, this::mp_iternext_allow_raise);
    }


    // function: Function(address=134253816, size=128, name='mp_iternext', path='build/py/runtime.o', joint_set={0, 96, 34, 68, 102, 10, 74, 44, 76, 28, 60, 16, 112, 50, 86, 22, 56, 90, 92}, stop_set={112, 32, 92, 74})
    abstract protected void mp_iternext(int offset) throws Exception;
    protected int mp_iternext = 0x08008cf8;
    public void mp_iternext() throws Exception
    {
        call(this.mp_iternext, this::mp_iternext);
    }


    // function: Function(address=134253944, size=628, name='mp_call_prepare_args_n_kw_var', path='build/py/runtime.o', joint_set={0, 384, 512, 518, 264, 394, 522, 398, 14, 146, 20, 532, 406, 410, 282, 540, 156, 158, 544, 290, 166, 168, 302, 558, 176, 178, 436, 308, 182, 438, 312, 566, 56, 444, 572, 574, 62, 192, 326, 198, 584, 70, 76, 334, 208, 338, 596, 214, 344, 88, 474, 348, 224, 354, 100, 486, 106, 110, 496, 368, 240, 502, 374, 246, 250, 124, 126}, stop_set={608, 288, 166, 190, 176, 180, 472, 156, 382})
    abstract protected void mp_call_prepare_args_n_kw_var(int offset) throws Exception;
    protected int mp_call_prepare_args_n_kw_var = 0x08008d78;
    public void mp_call_prepare_args_n_kw_var() throws Exception
    {
        call(this.mp_call_prepare_args_n_kw_var, this::mp_call_prepare_args_n_kw_var);
    }


    // function: Function(address=134254572, size=36, name='mp_call_method_n_kw_var', path='build/py/runtime.o', joint_set={0, 8, 20}, stop_set={28})
    abstract protected void mp_call_method_n_kw_var(int offset) throws Exception;
    protected int mp_call_method_n_kw_var = 0x08008fec;
    public void mp_call_method_n_kw_var() throws Exception
    {
        call(this.mp_call_method_n_kw_var, this::mp_call_method_n_kw_var);
    }


    // function: Function(address=134254608, size=168, name='mp_unpack_sequence', path='build/py/runtime.o', joint_set={0, 130, 134, 140, 12, 20, 26, 34, 40, 42, 48, 52, 56, 70, 76, 82, 90, 94, 98, 104, 108, 112}, stop_set={128, 68, 102, 140, 54})
    abstract protected void mp_unpack_sequence(int offset) throws Exception;
    protected int mp_unpack_sequence = 0x08009010;
    public void mp_unpack_sequence() throws Exception
    {
        call(this.mp_unpack_sequence, this::mp_unpack_sequence);
    }


    // function: Function(address=134254776, size=264, name='mp_unpack_ex', path='build/py/runtime.o', joint_set={0, 130, 136, 144, 146, 18, 152, 26, 156, 32, 162, 40, 174, 48, 178, 184, 56, 186, 62, 192, 196, 76, 212, 86, 218, 220, 92, 94, 232, 108, 242, 118, 124}, stop_set={230, 106, 210, 242, 116, 184, 218, 92})
    abstract protected void mp_unpack_ex(int offset) throws Exception;
    protected int mp_unpack_ex = 0x080090b8;
    public void mp_unpack_ex() throws Exception
    {
        call(this.mp_unpack_ex, this::mp_unpack_ex);
    }


    // function: Function(address=134255040, size=60, name='mp_make_raise_obj', path='build/py/runtime.o', joint_set={0, 36, 8, 40, 12, 48, 24, 26, 30}, stop_set={48, 28})
    abstract protected void mp_make_raise_obj(int offset) throws Exception;
    protected int mp_make_raise_obj = 0x080091c0;
    public void mp_make_raise_obj() throws Exception
    {
        call(this.mp_make_raise_obj, this::mp_make_raise_obj);
    }


    // function: Function(address=134255100, size=244, name='mp_resume', path='build/py/runtime.o', joint_set={0, 132, 138, 140, 16, 144, 148, 22, 152, 158, 34, 164, 38, 170, 46, 178, 50, 184, 64, 194, 68, 200, 78, 208, 84, 214, 218, 96, 224, 98, 108, 110, 114, 120, 124}, stop_set={226, 36, 198, 138, 112, 146, 216, 62})
    abstract protected void mp_resume(int offset) throws Exception;
    protected int mp_resume = 0x080091fc;
    public void mp_resume() throws Exception
    {
        call(this.mp_resume, this::mp_resume);
    }


    // function: Function(address=134255344, size=36, name='mp_import_name', path='build/py/runtime.o', joint_set={0, 28}, stop_set={30})
    abstract protected void mp_import_name(int offset) throws Exception;
    protected int mp_import_name = 0x080092f0;
    public void mp_import_name() throws Exception
    {
        call(this.mp_import_name, this::mp_import_name);
    }


    // function: Function(address=134255380, size=204, name='mp_import_from', path='build/py/runtime.o', joint_set={0, 32, 128, 36, 100, 70, 42, 138, 14, 78, 48, 146, 180, 52, 22, 120, 90, 62}, stop_set={32, 182})
    abstract protected void mp_import_from(int offset) throws Exception;
    protected int mp_import_from = 0x08009314;
    public void mp_import_from() throws Exception
    {
        call(this.mp_import_from, this::mp_import_from);
    }


    // function: Function(address=134255584, size=58, name='mp_import_all', path='build/py/runtime.o', joint_set={0, 36, 6, 42, 12, 14, 54, 24, 28}, stop_set={56, 12})
    abstract protected void mp_import_all(int offset) throws Exception;
    protected int mp_import_all = 0x080093e0;
    public void mp_import_all() throws Exception
    {
        call(this.mp_import_all, this::mp_import_all);
    }


    // function: Function(address=134255644, size=108, name='mp_parse_compile_execute', path='build/py/runtime.o', joint_set={0, 34, 66, 70, 72, 76, 48, 90, 60, 30}, stop_set={88, 100})
    abstract protected void mp_parse_compile_execute(int offset) throws Exception;
    protected int mp_parse_compile_execute = 0x0800941c;
    public void mp_parse_compile_execute() throws Exception
    {
        call(this.mp_parse_compile_execute, this::mp_parse_compile_execute);
    }


    // function: Function(address=134255752, size=20, name='mp_raise_msg', path='build/py/runtime.o', joint_set={0, 6, 10, 14, 18}, stop_set={10, 18})
    abstract protected void mp_raise_msg(int offset) throws Exception;
    protected int mp_raise_msg = 0x08009488;
    public void mp_raise_msg() throws Exception
    {
        call(this.mp_raise_msg, this::mp_raise_msg);
    }


    // function: Function(address=134255772, size=44, name='m_malloc_fail', path='build/py/runtime.o', joint_set={0, 8, 14, 20, 28}, stop_set={16, 28})
    abstract protected void m_malloc_fail(int offset) throws Exception;
    protected int m_malloc_fail = 0x0800949c;
    public void m_malloc_fail() throws Exception
    {
        call(this.m_malloc_fail, this::m_malloc_fail);
    }


    // function: Function(address=134255816, size=16, name='mp_raise_ValueError', path='build/py/runtime.o', joint_set={0}, stop_set={6})
    abstract protected void mp_raise_ValueError(int offset) throws Exception;
    protected int mp_raise_ValueError = 0x080094c8;
    public void mp_raise_ValueError() throws Exception
    {
        call(this.mp_raise_ValueError, this::mp_raise_ValueError);
    }


    // function: Function(address=134255832, size=944, name='mp_binary_op', path='build/py/runtime.o', joint_set={0, 512, 518, 522, 524, 14, 18, 532, 22, 536, 26, 540, 30, 542, 548, 38, 42, 556, 46, 50, 564, 54, 56, 568, 572, 60, 576, 578, 66, 70, 586, 588, 78, 82, 596, 84, 602, 90, 606, 608, 98, 614, 108, 620, 622, 116, 630, 632, 636, 638, 130, 646, 134, 648, 654, 658, 146, 660, 150, 152, 666, 670, 160, 164, 166, 172, 174, 182, 184, 704, 192, 194, 710, 200, 202, 204, 718, 208, 722, 210, 724, 214, 728, 216, 218, 732, 734, 222, 224, 228, 744, 234, 748, 236, 750, 240, 242, 756, 246, 760, 762, 252, 254, 768, 258, 770, 260, 772, 264, 266, 778, 780, 782, 270, 276, 790, 280, 792, 282, 284, 796, 286, 804, 294, 810, 300, 308, 820, 310, 824, 314, 826, 316, 828, 320, 322, 834, 326, 328, 840, 332, 336, 852, 854, 344, 346, 858, 860, 352, 356, 870, 358, 364, 368, 882, 370, 884, 886, 374, 376, 890, 382, 386, 388, 902, 392, 394, 398, 400, 914, 918, 408, 418, 434, 442, 448, 452, 462, 472, 476, 482, 486, 490, 492, 498, 504}, stop_set={768, 130, 770, 516, 900, 392, 522, 778, 780, 398, 912, 272, 658, 20, 916, 790, 534, 280, 150, 922, 540, 284, 670, 172, 48, 308, 54, 182, 440, 824, 570, 826, 446, 576, 192, 326, 200, 586, 722, 82, 852, 214, 344, 380, 474, 858, 732, 350, 222, 480, 868, 362, 234, 620, 748, 496, 882, 884, 252, 502, 630, 760, 636})
    abstract protected void mp_binary_op(int offset) throws Exception;
    protected int mp_binary_op = 0x080094d8;
    public void mp_binary_op() throws Exception
    {
        call(this.mp_binary_op, this::mp_binary_op);
    }


    // function: Function(address=134256776, size=16, name='mp_raise_TypeError', path='build/py/runtime.o', joint_set={0}, stop_set={6})
    abstract protected void mp_raise_TypeError(int offset) throws Exception;
    protected int mp_raise_TypeError = 0x08009888;
    public void mp_raise_TypeError() throws Exception
    {
        call(this.mp_raise_TypeError, this::mp_raise_TypeError);
    }


    // function: Function(address=134256792, size=24, name='mp_raise_OSError', path='build/py/runtime.o', joint_set={0, 14}, stop_set={14})
    abstract protected void mp_raise_OSError(int offset) throws Exception;
    protected int mp_raise_OSError = 0x08009898;
    public void mp_raise_OSError() throws Exception
    {
        call(this.mp_raise_OSError, this::mp_raise_OSError);
    }


    // function: Function(address=134256816, size=16, name='mp_raise_NotImplementedError', path='build/py/runtime.o', joint_set={0}, stop_set={6})
    abstract protected void mp_raise_NotImplementedError(int offset) throws Exception;
    protected int mp_raise_NotImplementedError = 0x080098b0;
    public void mp_raise_NotImplementedError() throws Exception
    {
        call(this.mp_raise_NotImplementedError, this::mp_raise_NotImplementedError);
    }


    // function: Function(address=134256832, size=20, name='mp_raise_recursion_depth', path='build/py/runtime.o', joint_set={0, 12}, stop_set={12})
    abstract protected void mp_raise_recursion_depth(int offset) throws Exception;
    protected int mp_raise_recursion_depth = 0x080098c0;
    public void mp_raise_recursion_depth() throws Exception
    {
        call(this.mp_raise_recursion_depth, this::mp_raise_recursion_depth);
    }


    // function: Function(address=134256852, size=56, name='mp_call_function_1_protected', path='build/py/runtime_utils.o', joint_set={0, 32, 38, 14, 46, 18, 26}, stop_set={48, 36})
    abstract protected void mp_call_function_1_protected(int offset) throws Exception;
    protected int mp_call_function_1_protected = 0x080098d4;
    public void mp_call_function_1_protected() throws Exception
    {
        call(this.mp_call_function_1_protected, this::mp_call_function_1_protected);
    }


    // function: Function(address=134256908, size=36, name='mp_sched_lock', path='build/py/scheduler.o', joint_set={0, 24, 20, 14}, stop_set={28, 22})
    abstract protected void mp_sched_lock(int offset) throws Exception;
    protected int mp_sched_lock = 0x0800990c;
    public void mp_sched_lock() throws Exception
    {
        call(this.mp_sched_lock, this::mp_sched_lock);
    }


    // function: Function(address=134256944, size=56, name='mp_sched_unlock', path='build/py/scheduler.o', joint_set={0, 40, 44, 46, 20, 30}, stop_set={50, 44})
    abstract protected void mp_sched_unlock(int offset) throws Exception;
    protected int mp_sched_unlock = 0x08009930;
    public void mp_sched_unlock() throws Exception
    {
        call(this.mp_sched_unlock, this::mp_sched_unlock);
    }


    // function: Function(address=134257000, size=52, name='mp_handle_pending_tail', path='build/py/scheduler.o', joint_set={0, 42, 46, 22}, stop_set={46})
    abstract protected void mp_handle_pending_tail(int offset) throws Exception;
    protected int mp_handle_pending_tail = 0x08009968;
    public void mp_handle_pending_tail() throws Exception
    {
        call(this.mp_handle_pending_tail, this::mp_handle_pending_tail);
    }


    // function: Function(address=134257052, size=56, name='mp_handle_pending', path='build/py/scheduler.o', joint_set={0, 38, 42, 46, 16, 50, 26}, stop_set={50, 42})
    abstract protected void mp_handle_pending(int offset) throws Exception;
    protected int mp_handle_pending = 0x0800999c;
    public void mp_handle_pending() throws Exception
    {
        call(this.mp_handle_pending, this::mp_handle_pending);
    }


    // function: Function(address=134257108, size=60, name='mp_sched_schedule', path='build/py/scheduler.o', joint_set={0, 16, 52, 26, 28}, stop_set={54})
    abstract protected void mp_sched_schedule(int offset) throws Exception;
    protected int mp_sched_schedule = 0x080099d4;
    public void mp_sched_schedule() throws Exception
    {
        call(this.mp_sched_schedule, this::mp_sched_schedule);
    }


    // function: Function(address=134257168, size=12, name='mp_stack_set_top', path='build/py/stackctrl.o', joint_set={0}, stop_set={4})
    abstract protected void mp_stack_set_top(int offset) throws Exception;
    protected int mp_stack_set_top = 0x08009a10;
    public void mp_stack_set_top() throws Exception
    {
        call(this.mp_stack_set_top, this::mp_stack_set_top);
    }


    // function: Function(address=134257180, size=20, name='mp_stack_usage', path='build/py/stackctrl.o', joint_set={0}, stop_set={12})
    abstract protected void mp_stack_usage(int offset) throws Exception;
    protected int mp_stack_usage = 0x08009a1c;
    public void mp_stack_usage() throws Exception
    {
        call(this.mp_stack_usage, this::mp_stack_usage);
    }


    // function: Function(address=134257200, size=12, name='mp_stack_set_limit', path='build/py/stackctrl.o', joint_set={0}, stop_set={4})
    abstract protected void mp_stack_set_limit(int offset) throws Exception;
    protected int mp_stack_set_limit = 0x08009a30;
    public void mp_stack_set_limit() throws Exception
    {
        call(this.mp_stack_set_limit, this::mp_stack_set_limit);
    }


    // function: Function(address=134257212, size=28, name='mp_stack_check', path='build/py/stackctrl.o', joint_set={0, 16, 20}, stop_set={16, 20})
    abstract protected void mp_stack_check(int offset) throws Exception;
    protected int mp_stack_check = 0x08009a3c;
    public void mp_stack_check() throws Exception
    {
        call(this.mp_stack_check, this::mp_stack_check);
    }


    // function: Function(address=134257240, size=96, name='mp_arg_check_num', path='build/py/argcheck.o', joint_set={0, 64, 34, 72, 40, 42, 12, 46, 16, 22, 56, 26, 60, 30}, stop_set={70, 72, 40, 18, 56})
    abstract protected void mp_arg_check_num(int offset) throws Exception;
    protected int mp_arg_check_num = 0x08009a58;
    public void mp_arg_check_num() throws Exception
    {
        call(this.mp_arg_check_num, this::mp_arg_check_num);
    }


    // function: Function(address=134257336, size=200, name='mp_arg_parse_all', path='build/py/argcheck.o', joint_set={0, 134, 140, 20, 150, 26, 154, 158, 34, 164, 36, 40, 46, 174, 178, 52, 64, 76, 80, 86, 102, 106, 112, 122, 126}, stop_set={162, 36, 138, 176, 148, 84, 180, 122})
    abstract protected void mp_arg_parse_all(int offset) throws Exception;
    protected int mp_arg_parse_all = 0x08009ab8;
    public void mp_arg_parse_all() throws Exception
    {
        call(this.mp_arg_parse_all, this::mp_arg_parse_all);
    }


    // function: Function(address=134257536, size=44, name='mp_arg_parse_all_kw_array', path='build/py/argcheck.o', joint_set={0, 40, 20}, stop_set={42})
    abstract protected void mp_arg_parse_all_kw_array(int offset) throws Exception;
    protected int mp_arg_parse_all_kw_array = 0x08009b80;
    public void mp_arg_parse_all_kw_array() throws Exception
    {
        call(this.mp_arg_parse_all_kw_array, this::mp_arg_parse_all_kw_array);
    }


    // function: Function(address=134257580, size=12, name='mp_arg_error_unimpl_kw', path='build/py/argcheck.o', joint_set={0}, stop_set={4})
    abstract protected void mp_arg_error_unimpl_kw(int offset) throws Exception;
    protected int mp_arg_error_unimpl_kw = 0x08009bac;
    public void mp_arg_error_unimpl_kw() throws Exception
    {
        call(this.mp_arg_error_unimpl_kw, this::mp_arg_error_unimpl_kw);
    }


    // function: Function(address=134257592, size=60, name='mp_warning', path='build/py/warning.o', joint_set={0, 38, 20, 30}, stop_set={44})
    abstract protected void mp_warning(int offset) throws Exception;
    protected int mp_warning = 0x08009bb8;
    public void mp_warning() throws Exception
    {
        call(this.mp_warning, this::mp_warning);
    }


    // function: Function(address=134257652, size=28, name='mp_map_init', path='build/py/map.o', joint_set={0, 10, 12, 18, 24}, stop_set={16, 26})
    abstract protected void mp_map_init(int offset) throws Exception;
    protected int mp_map_init = 0x08009bf4;
    public void mp_map_init() throws Exception
    {
        call(this.mp_map_init, this::mp_map_init);
    }


    // function: Function(address=134257680, size=26, name='mp_map_init_fixed_table', path='build/py/map.o', joint_set={0}, stop_set={24})
    abstract protected void mp_map_init_fixed_table(int offset) throws Exception;
    protected int mp_map_init_fixed_table = 0x08009c10;
    public void mp_map_init_fixed_table() throws Exception
    {
        call(this.mp_map_init_fixed_table, this::mp_map_init_fixed_table);
    }


    // function: Function(address=134257706, size=34, name='mp_map_deinit', path='build/py/map.o', joint_set={0, 10, 20}, stop_set={32})
    abstract protected void mp_map_deinit(int offset) throws Exception;
    protected int mp_map_deinit = 0x08009c2a;
    public void mp_map_deinit() throws Exception
    {
        call(this.mp_map_deinit, this::mp_map_deinit);
    }


    // function: Function(address=134257740, size=46, name='mp_map_clear', path='build/py/map.o', joint_set={0, 10, 20}, stop_set={44})
    abstract protected void mp_map_clear(int offset) throws Exception;
    protected int mp_map_clear = 0x08009c4c;
    public void mp_map_clear() throws Exception
    {
        call(this.mp_map_clear, this::mp_map_clear);
    }


    // function: Function(address=134257788, size=512, name='mp_map_lookup', path='build/py/map.o', joint_set={0, 384, 258, 390, 264, 274, 18, 406, 152, 280, 282, 26, 156, 30, 416, 290, 162, 420, 166, 38, 298, 426, 172, 44, 46, 432, 178, 436, 52, 312, 446, 318, 62, 66, 454, 72, 74, 460, 204, 464, 338, 340, 84, 220, 120, 352, 354, 226, 484, 376, 486, 98, 232, 362, 492, 238, 368, 496, 242, 372, 252, 246, 502, 504, 380}, stop_set={224, 160, 418, 352, 484, 164, 72, 490, 44, 494, 378, 366, 244, 502, 506})
    abstract protected void mp_map_lookup(int offset) throws Exception;
    protected int mp_map_lookup = 0x08009c7c;
    public void mp_map_lookup() throws Exception
    {
        call(this.mp_map_lookup, this::mp_map_lookup);
    }


    // function: Function(address=134258300, size=116, name='mp_map_rehash', path='build/py/map.o', joint_set={0, 64, 36, 100, 72, 106, 44, 28, 14, 80, 82, 22, 88, 92}, stop_set={80, 108})
    abstract protected void mp_map_rehash(int offset) throws Exception;
    protected int mp_map_rehash = 0x08009e7c;
    public void mp_map_rehash() throws Exception
    {
        call(this.mp_map_rehash, this::mp_map_rehash);
    }


    // function: Function(address=134258416, size=20, name='mp_set_init', path='build/py/map.o', joint_set={0, 16}, stop_set={18})
    abstract protected void mp_set_init(int offset) throws Exception;
    protected int mp_set_init = 0x08009ef0;
    public void mp_set_init() throws Exception
    {
        call(this.mp_set_init, this::mp_set_init);
    }


    // function: Function(address=134258436, size=222, name='mp_set_lookup', path='build/py/map.o', joint_set={0, 132, 136, 16, 146, 22, 154, 26, 158, 34, 164, 42, 46, 54, 186, 194, 196, 72, 202, 206, 78, 82, 212, 84, 218, 92, 96, 100, 104, 106, 116, 124}, stop_set={200, 204, 144, 216, 220, 94})
    abstract protected void mp_set_lookup(int offset) throws Exception;
    protected int mp_set_lookup = 0x08009f04;
    public void mp_set_lookup() throws Exception
    {
        call(this.mp_set_lookup, this::mp_set_lookup);
    }


    // function: Function(address=134258660, size=100, name='mp_set_rehash', path='build/py/map.o', joint_set={0, 64, 36, 72, 74, 28, 14, 48, 80, 84, 22, 58, 92}, stop_set={72, 94})
    abstract protected void mp_set_rehash(int offset) throws Exception;
    protected int mp_set_rehash = 0x08009fe4;
    public void mp_set_rehash() throws Exception
    {
        call(this.mp_set_rehash, this::mp_set_rehash);
    }


    // function: Function(address=134258760, size=62, name='mp_set_remove_first', path='build/py/map.o', joint_set={0, 32, 6, 10, 44, 14, 52, 54, 58, 28}, stop_set={56, 60, 12})
    abstract protected void mp_set_remove_first(int offset) throws Exception;
    protected int mp_set_remove_first = 0x0800a048;
    public void mp_set_remove_first() throws Exception
    {
        call(this.mp_set_remove_first, this::mp_set_remove_first);
    }


    // function: Function(address=134258822, size=24, name='mp_set_clear', path='build/py/map.o', joint_set={0, 14}, stop_set={22})
    abstract protected void mp_set_clear(int offset) throws Exception;
    protected int mp_set_clear = 0x0800a086;
    public void mp_set_clear() throws Exception
    {
        call(this.mp_set_clear, this::mp_set_clear);
    }


    // function: Function(address=134258846, size=2, name='mp_identity', path='build/py/obj.o', joint_set={0}, stop_set={0})
    abstract protected void mp_identity(int offset) throws Exception;
    protected int mp_identity = 0x0800a09e;
    public void mp_identity() throws Exception
    {
        call(this.mp_identity, this::mp_identity);
    }


    // function: Function(address=134258848, size=32, name='mp_obj_get_type', path='build/py/obj.o', joint_set={0, 16, 18, 6}, stop_set={20})
    abstract protected void mp_obj_get_type(int offset) throws Exception;
    protected int mp_obj_get_type = 0x0800a0a0;
    public void mp_obj_get_type() throws Exception
    {
        call(this.mp_obj_get_type, this::mp_obj_get_type);
    }


    // function: Function(address=134258880, size=14, name='mp_obj_get_type_str', path='build/py/obj.o', joint_set={0, 12, 6}, stop_set={12})
    abstract protected void mp_obj_get_type_str(int offset) throws Exception;
    protected int mp_obj_get_type_str = 0x0800a0c0;
    public void mp_obj_get_type_str() throws Exception
    {
        call(this.mp_obj_get_type_str, this::mp_obj_get_type_str);
    }


    // function: Function(address=134258896, size=52, name='mp_obj_print_helper', path='build/py/obj.o', joint_set={0, 32, 34, 12, 44, 18, 24}, stop_set={32, 44})
    abstract protected void mp_obj_print_helper(int offset) throws Exception;
    protected int mp_obj_print_helper = 0x0800a0d0;
    public void mp_obj_print_helper() throws Exception
    {
        call(this.mp_obj_print_helper, this::mp_obj_print_helper);
    }


    // function: Function(address=134258948, size=20, name='mp_obj_print', path='build/py/obj.o', joint_set={0, 12}, stop_set={12})
    abstract protected void mp_obj_print(int offset) throws Exception;
    protected int mp_obj_print = 0x0800a104;
    public void mp_obj_print() throws Exception
    {
        call(this.mp_obj_print, this::mp_obj_print);
    }


    // function: Function(address=134258968, size=144, name='mp_obj_print_exception', path='build/py/obj.o', joint_set={0, 32, 68, 70, 40, 104, 12, 46, 92, 16, 112, 50, 118, 26, 60, 126}, stop_set={116, 68, 126})
    abstract protected void mp_obj_print_exception(int offset) throws Exception;
    protected int mp_obj_print_exception = 0x0800a118;
    public void mp_obj_print_exception() throws Exception
    {
        call(this.mp_obj_print_exception, this::mp_obj_print_exception);
    }


    // function: Function(address=134259112, size=36, name='mp_obj_is_callable', path='build/py/obj.o', joint_set={0, 8, 16, 22, 24, 30}, stop_set={22, 30})
    abstract protected void mp_obj_is_callable(int offset) throws Exception;
    protected int mp_obj_is_callable = 0x0800a1a8;
    public void mp_obj_is_callable() throws Exception
    {
        call(this.mp_obj_is_callable, this::mp_obj_is_callable);
    }


    // function: Function(address=134259148, size=232, name='mp_obj_equal', path='build/py/obj.o', joint_set={0, 130, 134, 136, 10, 142, 16, 148, 24, 30, 160, 36, 40, 44, 172, 176, 50, 54, 184, 188, 60, 196, 68, 72, 202, 80, 88, 92, 100, 108, 110, 118, 122}, stop_set={134, 38, 170, 202, 108})
    abstract protected void mp_obj_equal(int offset) throws Exception;
    protected int mp_obj_equal = 0x0800a1cc;
    public void mp_obj_equal() throws Exception
    {
        call(this.mp_obj_equal, this::mp_obj_equal);
    }


    // function: Function(address=134259380, size=88, name='mp_obj_get_int', path='build/py/obj.o', joint_set={0, 64, 36, 8, 40, 42, 28, 46, 16, 20, 22, 24, 56, 60}, stop_set={66, 40, 22, 56, 62})
    abstract protected void mp_obj_get_int(int offset) throws Exception;
    protected int mp_obj_get_int = 0x0800a2b4;
    public void mp_obj_get_int() throws Exception
    {
        call(this.mp_obj_get_int, this::mp_obj_get_int);
    }


    // function: Function(address=134259468, size=36, name='mp_obj_get_int_truncated', path='build/py/obj.o', joint_set={0, 6, 10, 18, 22, 24, 28}, stop_set={28, 22})
    abstract protected void mp_obj_get_int_truncated(int offset) throws Exception;
    protected int mp_obj_get_int_truncated = 0x0800a30c;
    public void mp_obj_get_int_truncated() throws Exception
    {
        call(this.mp_obj_get_int_truncated, this::mp_obj_get_int_truncated);
    }


    // function: Function(address=134259504, size=76, name='mp_obj_get_int_maybe', path='build/py/obj.o', joint_set={0, 32, 38, 40, 44, 28, 12, 48, 16, 18, 22, 56, 60}, stop_set={42, 20, 60, 30})
    abstract protected void mp_obj_get_int_maybe(int offset) throws Exception;
    protected int mp_obj_get_int_maybe = 0x0800a330;
    public void mp_obj_get_int_maybe() throws Exception
    {
        call(this.mp_obj_get_int_maybe, this::mp_obj_get_int_maybe);
    }


    // function: Function(address=134259580, size=96, name='mp_obj_get_float_maybe', path='build/py/obj.o', joint_set={0, 32, 64, 36, 68, 70, 10, 74, 42, 16, 50, 54, 22, 56, 28}, stop_set={34, 68, 72, 78, 54})
    abstract protected void mp_obj_get_float_maybe(int offset) throws Exception;
    protected int mp_obj_get_float_maybe = 0x0800a37c;
    public void mp_obj_get_float_maybe() throws Exception
    {
        call(this.mp_obj_get_float_maybe, this::mp_obj_get_float_maybe);
    }


    // function: Function(address=134259676, size=48, name='mp_obj_get_float', path='build/py/obj.o', joint_set={0, 34, 10, 14, 20, 30}, stop_set={36, 30})
    abstract protected void mp_obj_get_float(int offset) throws Exception;
    protected int mp_obj_get_float = 0x0800a3dc;
    public void mp_obj_get_float() throws Exception
    {
        call(this.mp_obj_get_float, this::mp_obj_get_float);
    }


    // function: Function(address=134259724, size=140, name='mp_obj_get_complex', path='build/py/obj.o', joint_set={0, 12, 16, 18, 20, 26, 32, 36, 40, 46, 50, 54, 62, 66, 68, 74, 78, 80, 86, 92, 94, 98, 108}, stop_set={34, 66, 108, 78, 48, 18, 92})
    abstract protected void mp_obj_get_complex(int offset) throws Exception;
    protected int mp_obj_get_complex = 0x0800a40c;
    public void mp_obj_get_complex() throws Exception
    {
        call(this.mp_obj_get_complex, this::mp_obj_get_complex);
    }


    // function: Function(address=134259864, size=68, name='mp_obj_get_array', path='build/py/obj.o', joint_set={0, 32, 36, 6, 46, 14, 18, 20, 26, 30}, stop_set={18, 46, 30})
    abstract protected void mp_obj_get_array(int offset) throws Exception;
    protected int mp_obj_get_array = 0x0800a498;
    public void mp_obj_get_array() throws Exception
    {
        call(this.mp_obj_get_array, this::mp_obj_get_array);
    }


    // function: Function(address=134259932, size=40, name='mp_obj_get_array_fixed_n', path='build/py/obj.o', joint_set={0, 10, 16, 26, 30}, stop_set={26, 30})
    abstract protected void mp_obj_get_array_fixed_n(int offset) throws Exception;
    protected int mp_obj_get_array_fixed_n = 0x0800a4dc;
    public void mp_obj_get_array_fixed_n() throws Exception
    {
        call(this.mp_obj_get_array_fixed_n, this::mp_obj_get_array_fixed_n);
    }


    // function: Function(address=134259972, size=132, name='mp_get_index', path='build/py/obj.o', joint_set={0, 32, 98, 64, 36, 102, 40, 44, 76, 14, 80, 112, 18, 52, 84, 88, 24, 56, 92}, stop_set={112, 42, 76, 86})
    abstract protected void mp_get_index(int offset) throws Exception;
    protected int mp_get_index = 0x0800a504;
    public void mp_get_index() throws Exception
    {
        call(this.mp_get_index, this::mp_get_index);
    }


    // function: Function(address=134260104, size=30, name='mp_obj_id', path='build/py/obj.o', joint_set={0, 6, 10, 12, 16, 24, 28}, stop_set={10, 28, 22})
    abstract protected void mp_obj_id(int offset) throws Exception;
    protected int mp_obj_id = 0x0800a588;
    public void mp_obj_id() throws Exception
    {
        call(this.mp_obj_id, this::mp_obj_id);
    }


    // function: Function(address=134260136, size=52, name='mp_obj_len_maybe', path='build/py/obj.o', joint_set={0, 32, 38, 8, 16, 24, 26}, stop_set={24, 44})
    abstract protected void mp_obj_len_maybe(int offset) throws Exception;
    protected int mp_obj_len_maybe = 0x0800a5a8;
    public void mp_obj_len_maybe() throws Exception
    {
        call(this.mp_obj_len_maybe, this::mp_obj_len_maybe);
    }


    // function: Function(address=134260188, size=100, name='mp_obj_is_true', path='build/py/obj.o', joint_set={0, 64, 36, 68, 42, 74, 12, 78, 80, 48, 18, 20, 22, 58, 30}, stop_set={66, 20, 84})
    abstract protected void mp_obj_is_true(int offset) throws Exception;
    protected int mp_obj_is_true = 0x0800a5dc;
    public void mp_obj_is_true() throws Exception
    {
        call(this.mp_obj_is_true, this::mp_obj_is_true);
    }


    // function: Function(address=134260288, size=44, name='mp_obj_len', path='build/py/obj.o', joint_set={0, 32, 8, 12, 18, 28}, stop_set={32, 28})
    abstract protected void mp_obj_len(int offset) throws Exception;
    protected int mp_obj_len = 0x0800a640;
    public void mp_obj_len() throws Exception
    {
        call(this.mp_obj_len, this::mp_obj_len);
    }


    // function: Function(address=134260332, size=100, name='mp_obj_subscr', path='build/py/obj.o', joint_set={0, 64, 70, 38, 74, 42, 12, 46, 80, 18, 52, 56, 60, 30}, stop_set={80, 52, 78, 68})
    abstract protected void mp_obj_subscr(int offset) throws Exception;
    protected int mp_obj_subscr = 0x0800a66c;
    public void mp_obj_subscr() throws Exception
    {
        call(this.mp_obj_subscr, this::mp_obj_subscr);
    }


    // function: Function(address=134260432, size=2, name='mp_identity_getiter', path='build/py/obj.o', joint_set={0}, stop_set={0})
    abstract protected void mp_identity_getiter(int offset) throws Exception;
    protected int mp_identity_getiter = 0x0800a6d0;
    public void mp_identity_getiter() throws Exception
    {
        call(this.mp_identity_getiter, this::mp_identity_getiter);
    }


    // function: Function(address=134260434, size=34, name='mp_get_buffer', path='build/py/obj.o', joint_set={0, 32, 18, 12}, stop_set={32})
    abstract protected void mp_get_buffer(int offset) throws Exception;
    protected int mp_get_buffer = 0x0800a6d2;
    public void mp_get_buffer() throws Exception
    {
        call(this.mp_get_buffer, this::mp_get_buffer);
    }


    // function: Function(address=134260468, size=24, name='mp_get_buffer_raise', path='build/py/obj.o', joint_set={0, 16, 10, 6}, stop_set={16, 12})
    abstract protected void mp_get_buffer_raise(int offset) throws Exception;
    protected int mp_get_buffer_raise = 0x0800a6f4;
    public void mp_get_buffer_raise() throws Exception
    {
        call(this.mp_get_buffer_raise, this::mp_get_buffer_raise);
    }


    // function: Function(address=134260492, size=16, name='mp_generic_unary_op', path='build/py/obj.o', joint_set={0, 10, 12, 4}, stop_set={10, 14})
    abstract protected void mp_generic_unary_op(int offset) throws Exception;
    protected int mp_generic_unary_op = 0x0800a70c;
    public void mp_generic_unary_op() throws Exception
    {
        call(this.mp_generic_unary_op, this::mp_generic_unary_op);
    }


    // function: Function(address=134260508, size=44, name='array_unary_op', path='build/py/objarray.o', joint_set={0, 4, 8, 12, 20, 22, 24}, stop_set={32, 10, 22})
    abstract protected void array_unary_op(int offset) throws Exception;
    protected int array_unary_op = 0x0800a71c;
    public void array_unary_op() throws Exception
    {
        call(this.array_unary_op, this::array_unary_op);
    }


    // function: Function(address=134260552, size=40, name='array_iterator_new', path='build/py/objarray.o', joint_set={0, 26, 20}, stop_set={28})
    abstract protected void array_iterator_new(int offset) throws Exception;
    protected int array_iterator_new = 0x0800a748;
    public void array_iterator_new() throws Exception
    {
        call(this.array_iterator_new, this::array_iterator_new);
    }


    // function: Function(address=134260592, size=84, name='array_get_buffer', path='build/py/objarray.o', joint_set={0, 64, 76, 52, 22, 58}, stop_set={76})
    abstract protected void array_get_buffer(int offset) throws Exception;
    protected int array_get_buffer = 0x0800a770;
    public void array_get_buffer() throws Exception
    {
        call(this.array_get_buffer, this::array_get_buffer);
    }


    // function: Function(address=134260676, size=68, name='array_new', path='build/py/objarray.o', joint_set={0, 32, 34, 16, 54, 24}, stop_set={58})
    abstract protected void array_new(int offset) throws Exception;
    protected int array_new = 0x0800a7c4;
    public void array_new() throws Exception
    {
        call(this.array_new, this::array_new);
    }


    // function: Function(address=134260744, size=116, name='array_extend', path='build/py/objarray.o', joint_set={0, 34, 98, 68, 44, 14, 86, 24, 60}, stop_set={96, 108})
    abstract protected void array_extend(int offset) throws Exception;
    protected int array_extend = 0x0800a808;
    public void array_extend() throws Exception
    {
        call(this.array_extend, this::array_extend);
    }


    // function: Function(address=134260860, size=112, name='array_append', path='build/py/objarray.o', joint_set={0, 76, 14, 52, 24, 88}, stop_set={104})
    abstract protected void array_append(int offset) throws Exception;
    protected int array_append = 0x0800a87c;
    public void array_append() throws Exception
    {
        call(this.array_append, this::array_append);
    }


    // function: Function(address=134260972, size=38, name='array_it_iternext', path='build/py/objarray.o', joint_set={0, 16, 36}, stop_set={36})
    abstract protected void array_it_iternext(int offset) throws Exception;
    protected int array_it_iternext = 0x0800a8ec;
    public void array_it_iternext() throws Exception
    {
        call(this.array_it_iternext, this::array_it_iternext);
    }


    // function: Function(address=134261012, size=592, name='array_subscr', path='build/py/objarray.o', joint_set={0, 512, 130, 386, 260, 390, 264, 394, 522, 140, 12, 142, 526, 528, 10, 18, 274, 402, 408, 282, 540, 28, 30, 286, 542, 546, 292, 164, 38, 40, 172, 556, 46, 302, 178, 50, 52, 56, 186, 446, 320, 70, 72, 200, 330, 76, 466, 84, 94, 230, 360, 488, 106, 490, 110, 116, 502, 376, 252, 254}, stop_set={388, 70, 38, 488, 28, 558, 526, 112, 16, 52, 252, 280, 444, 284, 540})
    abstract protected void array_subscr(int offset) throws Exception;
    protected int array_subscr = 0x0800a914;
    public void array_subscr() throws Exception
    {
        call(this.array_subscr, this::array_subscr);
    }


    // function: Function(address=134261604, size=312, name='array_binary_op', path='build/py/objarray.o', joint_set={0, 256, 134, 266, 14, 270, 144, 16, 20, 22, 26, 30, 286, 162, 34, 44, 178, 50, 54, 62, 194, 200, 72, 208, 216, 88, 218, 222, 94, 98, 226, 234, 108, 240, 118, 246}, stop_set={96, 198, 242, 20, 24, 286, 216})
    abstract protected void array_binary_op(int offset) throws Exception;
    protected int array_binary_op = 0x0800ab64;
    public void array_binary_op() throws Exception
    {
        call(this.array_binary_op, this::array_binary_op);
    }


    // function: Function(address=134261916, size=180, name='array_construct', path='build/py/objarray.o', joint_set={0, 128, 134, 138, 12, 142, 16, 150, 152, 24, 30, 166, 40, 44, 54, 64, 74, 88, 94, 100, 104, 106, 114, 124}, stop_set={168, 92, 150})
    abstract protected void array_construct(int offset) throws Exception;
    protected int array_construct = 0x0800ac9c;
    public void array_construct() throws Exception
    {
        call(this.array_construct, this::array_construct);
    }


    // function: Function(address=134262096, size=50, name='array_make_new', path='build/py/objarray.o', joint_set={0, 34, 40, 42, 48, 22, 28}, stop_set={40, 48})
    abstract protected void array_make_new(int offset) throws Exception;
    protected int array_make_new = 0x0800ad50;
    public void array_make_new() throws Exception
    {
        call(this.array_make_new, this::array_make_new);
    }


    // function: Function(address=134262148, size=140, name='array_print', path='build/py/objarray.o', joint_set={0, 64, 38, 102, 40, 70, 12, 78, 48, 80, 112, 18, 84, 54, 62, 92, 30}, stop_set={78, 114, 38})
    abstract protected void array_print(int offset) throws Exception;
    protected int array_print = 0x0800ad84;
    public void array_print() throws Exception
    {
        call(this.array_print, this::array_print);
    }


    // function: Function(address=134262288, size=100, name='bytearray_make_new', path='build/py/objarray.o', joint_set={0, 32, 36, 70, 42, 46, 92, 82, 20, 54, 86, 24, 60}, stop_set={34, 84, 92})
    abstract protected void bytearray_make_new(int offset) throws Exception;
    protected int bytearray_make_new = 0x0800ae10;
    public void bytearray_make_new() throws Exception
    {
        call(this.bytearray_make_new, this::bytearray_make_new);
    }


    // function: Function(address=134262388, size=36, name='mp_obj_new_memoryview', path='build/py/objarray.o', joint_set={0, 14}, stop_set={30})
    abstract protected void mp_obj_new_memoryview(int offset) throws Exception;
    protected int mp_obj_new_memoryview = 0x0800ae74;
    public void mp_obj_new_memoryview() throws Exception
    {
        call(this.mp_obj_new_memoryview, this::mp_obj_new_memoryview);
    }


    // function: Function(address=134262424, size=102, name='memoryview_make_new', path='build/py/objarray.o', joint_set={0, 32, 96, 70, 82, 52, 22, 86, 60}, stop_set={100})
    abstract protected void memoryview_make_new(int offset) throws Exception;
    protected int memoryview_make_new = 0x0800ae98;
    public void memoryview_make_new() throws Exception
    {
        call(this.memoryview_make_new, this::memoryview_make_new);
    }


    // function: Function(address=134262528, size=32, name='mp_obj_new_bytearray_by_ref', path='build/py/objarray.o', joint_set={0, 12}, stop_set={24})
    abstract protected void mp_obj_new_bytearray_by_ref(int offset) throws Exception;
    protected int mp_obj_new_bytearray_by_ref = 0x0800af00;
    public void mp_obj_new_bytearray_by_ref() throws Exception
    {
        call(this.mp_obj_new_bytearray_by_ref, this::mp_obj_new_bytearray_by_ref);
    }


    // function: Function(address=134262560, size=42, name='mp_obj_attrtuple_attr', path='build/py/objattrtuple.o', joint_set={0, 36, 38, 8, 16, 20, 28}, stop_set={40, 36})
    abstract protected void mp_obj_attrtuple_attr(int offset) throws Exception;
    protected int mp_obj_attrtuple_attr = 0x0800af20;
    public void mp_obj_attrtuple_attr() throws Exception
    {
        call(this.mp_obj_attrtuple_attr, this::mp_obj_attrtuple_attr);
    }


    // function: Function(address=134262604, size=92, name='mp_obj_attrtuple_print_helper', path='build/py/objattrtuple.o', joint_set={0, 32, 36, 70, 44, 16, 22, 60, 30}, stop_set={72, 30})
    abstract protected void mp_obj_attrtuple_print_helper(int offset) throws Exception;
    protected int mp_obj_attrtuple_print_helper = 0x0800af4c;
    public void mp_obj_attrtuple_print_helper() throws Exception
    {
        call(this.mp_obj_attrtuple_print_helper, this::mp_obj_attrtuple_print_helper);
    }


    // function: Function(address=134262696, size=18, name='mp_obj_attrtuple_print', path='build/py/objattrtuple.o', joint_set={0, 16}, stop_set={16})
    abstract protected void mp_obj_attrtuple_print(int offset) throws Exception;
    protected int mp_obj_attrtuple_print = 0x0800afa8;
    public void mp_obj_attrtuple_print() throws Exception
    {
        call(this.mp_obj_attrtuple_print, this::mp_obj_attrtuple_print);
    }


    // function: Function(address=134262714, size=16, name='bool_binary_op', path='build/py/objbool.o', joint_set={0, 14}, stop_set={14})
    abstract protected void bool_binary_op(int offset) throws Exception;
    protected int bool_binary_op = 0x0800afba;
    public void bool_binary_op() throws Exception
    {
        call(this.bool_binary_op, this::bool_binary_op);
    }


    // function: Function(address=134262730, size=26, name='bool_unary_op', path='build/py/objbool.o', joint_set={0, 8, 20, 22}, stop_set={24})
    abstract protected void bool_unary_op(int offset) throws Exception;
    protected int bool_unary_op = 0x0800afca;
    public void bool_unary_op() throws Exception
    {
        call(this.bool_unary_op, this::bool_unary_op);
    }


    // function: Function(address=134262756, size=52, name='bool_make_new', path='build/py/objbool.o', joint_set={0, 36, 38, 20, 24, 30}, stop_set={40})
    abstract protected void bool_make_new(int offset) throws Exception;
    protected int bool_make_new = 0x0800afe4;
    public void bool_make_new() throws Exception
    {
        call(this.bool_make_new, this::bool_make_new);
    }


    // function: Function(address=134262808, size=48, name='bool_print', path='build/py/objbool.o', joint_set={0, 8, 14, 16, 20, 22, 28}, stop_set={20, 30})
    abstract protected void bool_print(int offset) throws Exception;
    protected int bool_print = 0x0800b018;
    public void bool_print() throws Exception
    {
        call(this.bool_print, this::bool_print);
    }


    // function: Function(address=134262856, size=64, name='bound_meth_print', path='build/py/objboundmeth.o', joint_set={0, 32, 42, 14, 50, 24}, stop_set={50})
    abstract protected void bound_meth_print(int offset) throws Exception;
    protected int bound_meth_print = 0x0800b048;
    public void bound_meth_print() throws Exception
    {
        call(this.bound_meth_print, this::bound_meth_print);
    }


    // function: Function(address=134262920, size=30, name='bound_meth_attr', path='build/py/objboundmeth.o', joint_set={0, 10, 14, 20, 28}, stop_set={28})
    abstract protected void bound_meth_attr(int offset) throws Exception;
    protected int bound_meth_attr = 0x0800b088;
    public void bound_meth_attr() throws Exception
    {
        call(this.bound_meth_attr, this::bound_meth_attr);
    }


    // function: Function(address=134262952, size=60, name='mp_call_method_self_n_kw', path='build/py/objboundmeth.o', joint_set={0, 24, 50, 38}, stop_set={54})
    abstract protected void mp_call_method_self_n_kw(int offset) throws Exception;
    protected int mp_call_method_self_n_kw = 0x0800b0a8;
    public void mp_call_method_self_n_kw() throws Exception
    {
        call(this.mp_call_method_self_n_kw, this::mp_call_method_self_n_kw);
    }


    // function: Function(address=134263012, size=18, name='bound_meth_call', path='build/py/objboundmeth.o', joint_set={0, 16}, stop_set={16})
    abstract protected void bound_meth_call(int offset) throws Exception;
    protected int bound_meth_call = 0x0800b0e4;
    public void bound_meth_call() throws Exception
    {
        call(this.bound_meth_call, this::bound_meth_call);
    }


    // function: Function(address=134263032, size=28, name='mp_obj_new_bound_meth', path='build/py/objboundmeth.o', joint_set={0, 12}, stop_set={20})
    abstract protected void mp_obj_new_bound_meth(int offset) throws Exception;
    protected int mp_obj_new_bound_meth = 0x0800b0f8;
    public void mp_obj_new_bound_meth() throws Exception
    {
        call(this.mp_obj_new_bound_meth, this::mp_obj_new_bound_meth);
    }


    // function: Function(address=134263060, size=60, name='cell_print', path='build/py/objcell.o', joint_set={0, 36, 38, 14, 46, 20, 28}, stop_set={36, 46})
    abstract protected void cell_print(int offset) throws Exception;
    protected int cell_print = 0x0800b114;
    public void cell_print() throws Exception
    {
        call(this.cell_print, this::cell_print);
    }


    // function: Function(address=134263120, size=4, name='mp_obj_cell_get', path='build/py/objcell.o', joint_set={0}, stop_set={2})
    abstract protected void mp_obj_cell_get(int offset) throws Exception;
    protected int mp_obj_cell_get = 0x0800b150;
    public void mp_obj_cell_get() throws Exception
    {
        call(this.mp_obj_cell_get, this::mp_obj_cell_get);
    }


    // function: Function(address=134263124, size=4, name='mp_obj_cell_set', path='build/py/objcell.o', joint_set={0}, stop_set={2})
    abstract protected void mp_obj_cell_set(int offset) throws Exception;
    protected int mp_obj_cell_set = 0x0800b154;
    public void mp_obj_cell_set() throws Exception
    {
        call(this.mp_obj_cell_set, this::mp_obj_cell_set);
    }


    // function: Function(address=134263128, size=24, name='mp_obj_new_cell', path='build/py/objcell.o', joint_set={0, 10}, stop_set={16})
    abstract protected void mp_obj_new_cell(int offset) throws Exception;
    protected int mp_obj_new_cell = 0x0800b158;
    public void mp_obj_new_cell() throws Exception
    {
        call(this.mp_obj_new_cell, this::mp_obj_new_cell);
    }


    // function: Function(address=134263152, size=148, name='closure_call', path='build/py/objclosure.o', joint_set={0, 102, 38, 136, 74, 76, 82, 146, 116, 50, 90, 62}, stop_set={80, 146})
    abstract protected void closure_call(int offset) throws Exception;
    protected int closure_call = 0x0800b170;
    public void closure_call() throws Exception
    {
        call(this.closure_call, this::closure_call);
    }


    // function: Function(address=134263300, size=112, name='closure_print', path='build/py/objclosure.o', joint_set={0, 34, 36, 70, 42, 12, 78, 82, 50, 52, 22, 90, 62}, stop_set={80, 90, 50})
    abstract protected void closure_print(int offset) throws Exception;
    protected int closure_print = 0x0800b204;
    public void closure_print() throws Exception
    {
        call(this.closure_print, this::closure_print);
    }


    // function: Function(address=134263412, size=48, name='mp_obj_new_closure', path='build/py/objclosure.o', joint_set={0, 18, 40}, stop_set={42})
    abstract protected void mp_obj_new_closure(int offset) throws Exception;
    protected int mp_obj_new_closure = 0x0800b274;
    public void mp_obj_new_closure() throws Exception
    {
        call(this.mp_obj_new_closure, this::mp_obj_new_closure);
    }


    // function: Function(address=134263460, size=40, name='complex_attr', path='build/py/objcomplex.o', joint_set={0, 36, 10, 18, 20, 24, 26, 28}, stop_set={26, 38})
    abstract protected void complex_attr(int offset) throws Exception;
    protected int complex_attr = 0x0800b2a4;
    public void complex_attr() throws Exception
    {
        call(this.complex_attr, this::complex_attr);
    }


    // function: Function(address=134263500, size=160, name='complex_print', path='build/py/objcomplex.o', joint_set={0, 96, 72, 136, 104, 42, 108, 46, 18, 82, 116, 52, 56, 24, 92}, stop_set={140, 54})
    abstract protected void complex_print(int offset) throws Exception;
    protected int complex_print = 0x0800b2cc;
    public void complex_print() throws Exception
    {
        call(this.complex_print, this::complex_print);
    }


    // function: Function(address=134263660, size=28, name='mp_obj_new_complex', path='build/py/objcomplex.o', joint_set={0, 12}, stop_set={20})
    abstract protected void mp_obj_new_complex(int offset) throws Exception;
    protected int mp_obj_new_complex = 0x0800b36c;
    public void mp_obj_new_complex() throws Exception
    {
        call(this.mp_obj_new_complex, this::mp_obj_new_complex);
    }


    // function: Function(address=134263688, size=156, name='complex_unary_op', path='build/py/objcomplex.o', joint_set={0, 8, 10, 140, 14, 144, 18, 20, 24, 28, 32, 42, 52, 60, 64, 68, 70, 78, 82, 90, 96, 100, 106, 114, 124}, stop_set={98, 68, 142, 146, 22, 122})
    abstract protected void complex_unary_op(int offset) throws Exception;
    protected int complex_unary_op = 0x0800b388;
    public void complex_unary_op() throws Exception
    {
        call(this.complex_unary_op, this::complex_unary_op);
    }


    // function: Function(address=134263844, size=188, name='complex_make_new', path='build/py/objcomplex.o', joint_set={0, 138, 142, 20, 148, 24, 154, 158, 32, 164, 36, 170, 44, 48, 176, 54, 62, 70, 76, 80, 86, 90, 94, 96, 104, 108, 116, 124}, stop_set={168, 140, 178, 84, 156, 94})
    abstract protected void complex_make_new(int offset) throws Exception;
    protected int complex_make_new = 0x0800b424;
    public void complex_make_new() throws Exception
    {
        call(this.complex_make_new, this::complex_make_new);
    }


    // function: Function(address=134264032, size=10, name='mp_obj_complex_get', path='build/py/objcomplex.o', joint_set={0}, stop_set={8})
    abstract protected void mp_obj_complex_get(int offset) throws Exception;
    protected int mp_obj_complex_get = 0x0800b4e0;
    public void mp_obj_complex_get() throws Exception
    {
        call(this.mp_obj_complex_get, this::mp_obj_complex_get);
    }


    // function: Function(address=134264044, size=604, name='mp_obj_complex_binary_op', path='build/py/objcomplex.o', joint_set={0, 512, 516, 524, 530, 20, 24, 538, 26, 30, 544, 32, 546, 36, 38, 42, 554, 44, 558, 48, 52, 54, 566, 56, 58, 572, 62, 574, 74, 82, 88, 94, 96, 104, 110, 114, 116, 120, 122, 124, 128, 132, 140, 150, 152, 160, 164, 168, 170, 174, 182, 192, 200, 204, 212, 216, 224, 228, 238, 242, 250, 256, 262, 270, 276, 280, 282, 288, 294, 298, 306, 318, 326, 336, 344, 354, 368, 370, 384, 394, 402, 412, 422, 426, 428, 434, 440, 450, 464, 476, 484, 494, 504}, stop_set={544, 576, 162, 260, 36, 424, 42, 120, 430, 46, 114, 52, 284, 572, 280, 56, 316, 94})
    abstract protected void mp_obj_complex_binary_op(int offset) throws Exception;
    protected int mp_obj_complex_binary_op = 0x0800b4ec;
    public void mp_obj_complex_binary_op() throws Exception
    {
        call(this.mp_obj_complex_binary_op, this::mp_obj_complex_binary_op);
    }


    // function: Function(address=134264648, size=14, name='complex_binary_op', path='build/py/objcomplex.o', joint_set={0, 12}, stop_set={12})
    abstract protected void complex_binary_op(int offset) throws Exception;
    protected int complex_binary_op = 0x0800b748;
    public void complex_binary_op() throws Exception
    {
        call(this.complex_binary_op, this::complex_binary_op);
    }


    // function: Function(address=134264664, size=104, name='deque_make_new', path='build/py/objdeque.o', joint_set={0, 34, 90, 40, 76, 46, 50, 84, 56, 26, 92}, stop_set={96, 36})
    abstract protected void deque_make_new(int offset) throws Exception;
    protected int deque_make_new = 0x0800b758;
    public void deque_make_new() throws Exception
    {
        call(this.deque_make_new, this::deque_make_new);
    }


    // function: Function(address=134264768, size=68, name='deque_unary_op', path='build/py/objdeque.o', joint_set={0, 34, 4, 38, 40, 8, 12, 46, 54, 22, 24, 26}, stop_set={24, 56, 44, 52})
    abstract protected void deque_unary_op(int offset) throws Exception;
    protected int deque_unary_op = 0x0800b7c0;
    public void deque_unary_op() throws Exception
    {
        call(this.deque_unary_op, this::deque_unary_op);
    }


    // function: Function(address=134264836, size=56, name='deque_popleft', path='build/py/objdeque.o', joint_set={0, 42, 12, 44, 20}, stop_set={16, 44})
    abstract protected void deque_popleft(int offset) throws Exception;
    protected int deque_popleft = 0x0800b804;
    public void deque_popleft() throws Exception
    {
        call(this.deque_popleft, this::deque_popleft);
    }


    // function: Function(address=134264892, size=76, name='mp_obj_deque_append', path='build/py/objdeque.o', joint_set={0, 34, 26, 12, 14, 46, 52, 54, 22, 58}, stop_set={56, 60, 30})
    abstract protected void mp_obj_deque_append(int offset) throws Exception;
    protected int mp_obj_deque_append = 0x0800b83c;
    public void mp_obj_deque_append() throws Exception
    {
        call(this.mp_obj_deque_append, this::mp_obj_deque_append);
    }


    // function: Function(address=134264968, size=24, name='dict_view_getiter', path='build/py/objdict.o', joint_set={0}, stop_set={18})
    abstract protected void dict_view_getiter(int offset) throws Exception;
    protected int dict_view_getiter = 0x0800b888;
    public void dict_view_getiter() throws Exception
    {
        call(this.dict_view_getiter, this::dict_view_getiter);
    }


    // function: Function(address=134264992, size=24, name='dict_getiter', path='build/py/objdict.o', joint_set={0}, stop_set={16})
    abstract protected void dict_getiter(int offset) throws Exception;
    protected int dict_getiter = 0x0800b8a0;
    public void dict_getiter() throws Exception
    {
        call(this.dict_getiter, this::dict_getiter);
    }


    // function: Function(address=134265016, size=28, name='dict_values', path='build/py/objdict.o', joint_set={0, 10}, stop_set={20})
    abstract protected void dict_values(int offset) throws Exception;
    protected int dict_values = 0x0800b8b8;
    public void dict_values() throws Exception
    {
        call(this.dict_values, this::dict_values);
    }


    // function: Function(address=134265044, size=16, name='mp_ensure_not_fixed', path='build/py/objdict.o', joint_set={0, 8, 14}, stop_set={10, 14})
    abstract protected void mp_ensure_not_fixed(int offset) throws Exception;
    protected int mp_ensure_not_fixed = 0x0800b8d4;
    public void mp_ensure_not_fixed() throws Exception
    {
        call(this.mp_ensure_not_fixed, this::mp_ensure_not_fixed);
    }


    // function: Function(address=134265060, size=24, name='dict_clear', path='build/py/objdict.o', joint_set={0, 8, 14}, stop_set={16})
    abstract protected void dict_clear(int offset) throws Exception;
    protected int dict_clear = 0x0800b8e4;
    public void dict_clear() throws Exception
    {
        call(this.dict_clear, this::dict_clear);
    }


    // function: Function(address=134265084, size=60, name='dict_unary_op', path='build/py/objdict.o', joint_set={0, 32, 4, 38, 8, 12, 46, 22, 24, 26}, stop_set={24, 48, 36, 44})
    abstract protected void dict_unary_op(int offset) throws Exception;
    protected int dict_unary_op = 0x0800b8fc;
    public void dict_unary_op() throws Exception
    {
        call(this.dict_unary_op, this::dict_unary_op);
    }


    // function: Function(address=134265144, size=92, name='dict_get_helper', path='build/py/objdict.o', joint_set={0, 32, 66, 68, 38, 72, 42, 76, 12, 60, 48, 18, 56, 28, 62}, stop_set={56, 80, 70})
    abstract protected void dict_get_helper(int offset) throws Exception;
    protected int dict_get_helper = 0x0800b938;
    public void dict_get_helper() throws Exception
    {
        call(this.dict_get_helper, this::dict_get_helper);
    }


    // function: Function(address=134265236, size=10, name='dict_setdefault', path='build/py/objdict.o', joint_set={0, 8}, stop_set={8})
    abstract protected void dict_setdefault(int offset) throws Exception;
    protected int dict_setdefault = 0x0800b994;
    public void dict_setdefault() throws Exception
    {
        call(this.dict_setdefault, this::dict_setdefault);
    }


    // function: Function(address=134265246, size=10, name='dict_pop', path='build/py/objdict.o', joint_set={0, 8}, stop_set={8})
    abstract protected void dict_pop(int offset) throws Exception;
    protected int dict_pop = 0x0800b99e;
    public void dict_pop() throws Exception
    {
        call(this.dict_pop, this::dict_pop);
    }


    // function: Function(address=134265256, size=10, name='dict_get', path='build/py/objdict.o', joint_set={0, 8}, stop_set={8})
    abstract protected void dict_get(int offset) throws Exception;
    protected int dict_get = 0x0800b9a8;
    public void dict_get() throws Exception
    {
        call(this.dict_get, this::dict_get);
    }


    // function: Function(address=134265266, size=42, name='dict_iter_next', path='build/py/objdict.o', joint_set={0, 32, 34, 38, 8, 12, 16, 28}, stop_set={40, 36, 14})
    abstract protected void dict_iter_next(int offset) throws Exception;
    protected int dict_iter_next = 0x0800b9b2;
    public void dict_iter_next() throws Exception
    {
        call(this.dict_iter_next, this::dict_iter_next);
    }


    // function: Function(address=134265308, size=58, name='dict_view_it_iternext', path='build/py/objdict.o', joint_set={0, 46, 14, 18, 50, 54, 24, 28}, stop_set={48, 56, 52})
    abstract protected void dict_view_it_iternext(int offset) throws Exception;
    protected int dict_view_it_iternext = 0x0800b9dc;
    public void dict_view_it_iternext() throws Exception
    {
        call(this.dict_view_it_iternext, this::dict_view_it_iternext);
    }


    // function: Function(address=134265368, size=120, name='dict_view_print', path='build/py/objdict.o', joint_set={0, 68, 72, 76, 60, 50, 20, 84, 56, 28, 94}, stop_set={96, 70})
    abstract protected void dict_view_print(int offset) throws Exception;
    protected int dict_view_print = 0x0800ba18;
    public void dict_view_print() throws Exception
    {
        call(this.dict_view_print, this::dict_view_print);
    }


    // function: Function(address=134265488, size=232, name='dict_update', path='build/py/objdict.o', joint_set={0, 134, 142, 18, 146, 152, 156, 34, 162, 38, 172, 46, 178, 56, 190, 62, 64, 194, 72, 202, 76, 206, 208, 80, 214, 90, 96, 102, 104, 110, 114, 120, 126}, stop_set={78, 176, 218, 158, 94})
    abstract protected void dict_update(int offset) throws Exception;
    protected int dict_update = 0x0800ba90;
    public void dict_update() throws Exception
    {
        call(this.dict_update, this::dict_update);
    }


    // function: Function(address=134265720, size=72, name='dict_popitem', path='build/py/objdict.o', joint_set={0, 34, 12, 22, 26, 60}, stop_set={62, 30})
    abstract protected void dict_popitem(int offset) throws Exception;
    protected int dict_popitem = 0x0800bb78;
    public void dict_popitem() throws Exception
    {
        call(this.dict_popitem, this::dict_popitem);
    }


    // function: Function(address=134265792, size=220, name='dict_binary_op', path='build/py/objdict.o', joint_set={0, 128, 136, 10, 16, 148, 150, 26, 158, 32, 162, 34, 38, 166, 176, 48, 180, 56, 60, 188, 192, 66, 194, 70, 200, 78, 88, 94, 98, 106, 110, 118, 122, 124}, stop_set={192, 164, 36, 200, 122})
    abstract protected void dict_binary_op(int offset) throws Exception;
    protected int dict_binary_op = 0x0800bbc0;
    public void dict_binary_op() throws Exception
    {
        call(this.dict_binary_op, this::dict_binary_op);
    }


    // function: Function(address=134266012, size=26, name='dict_view_binary_op', path='build/py/objdict.o', joint_set={0, 10, 14, 20, 22}, stop_set={24})
    abstract protected void dict_view_binary_op(int offset) throws Exception;
    protected int dict_view_binary_op = 0x0800bc9c;
    public void dict_view_binary_op() throws Exception
    {
        call(this.dict_view_binary_op, this::dict_view_binary_op);
    }


    // function: Function(address=134266040, size=164, name='dict_print', path='build/py/objdict.o', joint_set={0, 96, 34, 132, 90, 122, 70, 104, 42, 78, 14, 16, 48, 114, 86, 24, 58, 62}, stop_set={88, 134})
    abstract protected void dict_print(int offset) throws Exception;
    protected int dict_print = 0x0800bcb8;
    public void dict_print() throws Exception
    {
        call(this.dict_print, this::dict_print);
    }


    // function: Function(address=134266204, size=28, name='dict_items', path='build/py/objdict.o', joint_set={0, 10}, stop_set={20})
    abstract protected void dict_items(int offset) throws Exception;
    protected int dict_items = 0x0800bd5c;
    public void dict_items() throws Exception
    {
        call(this.dict_items, this::dict_items);
    }


    // function: Function(address=134266232, size=28, name='dict_keys', path='build/py/objdict.o', joint_set={0, 10}, stop_set={20})
    abstract protected void dict_keys(int offset) throws Exception;
    protected int dict_keys = 0x0800bd78;
    public void dict_keys() throws Exception
    {
        call(this.dict_keys, this::dict_keys);
    }


    // function: Function(address=134266260, size=36, name='mp_obj_dict_get', path='build/py/objdict.o', joint_set={0, 12, 16, 24, 28}, stop_set={24, 30})
    abstract protected void mp_obj_dict_get(int offset) throws Exception;
    protected int mp_obj_dict_get = 0x0800bd94;
    public void mp_obj_dict_get() throws Exception
    {
        call(this.mp_obj_dict_get, this::mp_obj_dict_get);
    }


    // function: Function(address=134266296, size=16, name='mp_obj_dict_init', path='build/py/objdict.o', joint_set={0, 10}, stop_set={10})
    abstract protected void mp_obj_dict_init(int offset) throws Exception;
    protected int mp_obj_dict_init = 0x0800bdb8;
    public void mp_obj_dict_init() throws Exception
    {
        call(this.mp_obj_dict_init, this::mp_obj_dict_init);
    }


    // function: Function(address=134266312, size=22, name='mp_obj_new_dict', path='build/py/objdict.o', joint_set={0, 10, 18}, stop_set={20})
    abstract protected void mp_obj_new_dict(int offset) throws Exception;
    protected int mp_obj_new_dict = 0x0800bdc8;
    public void mp_obj_new_dict() throws Exception
    {
        call(this.mp_obj_new_dict, this::mp_obj_new_dict);
    }


    // function: Function(address=134266336, size=76, name='dict_fromkeys', path='build/py/objdict.o', joint_set={0, 34, 68, 38, 40, 14, 46, 50, 54, 22, 24, 58, 30}, stop_set={56, 52, 70})
    abstract protected void dict_fromkeys(int offset) throws Exception;
    protected int dict_fromkeys = 0x0800bde0;
    public void dict_fromkeys() throws Exception
    {
        call(this.dict_fromkeys, this::dict_fromkeys);
    }


    // function: Function(address=134266412, size=86, name='dict_copy', path='build/py/objdict.o', joint_set={0, 10, 82}, stop_set={84})
    abstract protected void dict_copy(int offset) throws Exception;
    protected int dict_copy = 0x0800be2c;
    public void dict_copy() throws Exception
    {
        call(this.dict_copy, this::dict_copy);
    }


    // function: Function(address=134266500, size=80, name='dict_make_new', path='build/py/objdict.o', joint_set={0, 36, 70, 42, 28, 18, 60}, stop_set={74})
    abstract protected void dict_make_new(int offset) throws Exception;
    protected int dict_make_new = 0x0800be84;
    public void dict_make_new() throws Exception
    {
        call(this.dict_make_new, this::dict_make_new);
    }


    // function: Function(address=134266580, size=6, name='mp_obj_dict_len', path='build/py/objdict.o', joint_set={0}, stop_set={4})
    abstract protected void mp_obj_dict_len(int offset) throws Exception;
    protected int mp_obj_dict_len = 0x0800bed4;
    public void mp_obj_dict_len() throws Exception
    {
        call(this.mp_obj_dict_len, this::mp_obj_dict_len);
    }


    // function: Function(address=134266586, size=28, name='mp_obj_dict_store', path='build/py/objdict.o', joint_set={0, 12, 22}, stop_set={26})
    abstract protected void mp_obj_dict_store(int offset) throws Exception;
    protected int mp_obj_dict_store = 0x0800beda;
    public void mp_obj_dict_store() throws Exception
    {
        call(this.mp_obj_dict_store, this::mp_obj_dict_store);
    }


    // function: Function(address=134266614, size=22, name='mp_obj_dict_delete', path='build/py/objdict.o', joint_set={0, 18}, stop_set={20})
    abstract protected void mp_obj_dict_delete(int offset) throws Exception;
    protected int mp_obj_dict_delete = 0x0800bef6;
    public void mp_obj_dict_delete() throws Exception
    {
        call(this.mp_obj_dict_delete, this::mp_obj_dict_delete);
    }


    // function: Function(address=134266636, size=64, name='dict_subscr', path='build/py/objdict.o', joint_set={0, 32, 40, 8, 12, 44, 46, 16, 48, 52, 20, 28}, stop_set={40, 52, 46, 14})
    abstract protected void dict_subscr(int offset) throws Exception;
    protected int dict_subscr = 0x0800bf0c;
    public void dict_subscr() throws Exception
    {
        call(this.dict_subscr, this::dict_subscr);
    }


    // function: Function(address=134266700, size=40, name='enumerate_iternext', path='build/py/objenumerate.o', joint_set={0, 10, 38, 14}, stop_set={38})
    abstract protected void enumerate_iternext(int offset) throws Exception;
    protected int enumerate_iternext = 0x0800bf4c;
    public void enumerate_iternext() throws Exception
    {
        call(this.enumerate_iternext, this::enumerate_iternext);
    }


    // function: Function(address=134266740, size=60, name='enumerate_make_new', path='build/py/objenumerate.o', joint_set={0, 24, 42, 30}, stop_set={52})
    abstract protected void enumerate_make_new(int offset) throws Exception;
    protected int enumerate_make_new = 0x0800bf74;
    public void enumerate_make_new() throws Exception
    {
        call(this.enumerate_make_new, this::enumerate_make_new);
    }


    // function: Function(address=134266800, size=164, name='mp_obj_exception_print', path='build/py/objexcept.o', joint_set={0, 128, 130, 134, 144, 18, 24, 32, 40, 44, 52, 58, 64, 72, 74, 78, 86, 92, 96, 100, 114, 116}, stop_set={72, 128, 144, 114})
    abstract protected void mp_obj_exception_print(int offset) throws Exception;
    protected int mp_obj_exception_print = 0x0800bfb0;
    public void mp_obj_exception_print() throws Exception
    {
        call(this.mp_obj_exception_print, this::mp_obj_exception_print);
    }


    // function: Function(address=134266964, size=128, name='mp_obj_exception_make_new', path='build/py/objexcept.o', joint_set={0, 32, 58, 68, 38, 40, 72, 106, 48, 50, 84, 86, 26}, stop_set={56, 106})
    abstract protected void mp_obj_exception_make_new(int offset) throws Exception;
    protected int mp_obj_exception_make_new = 0x0800c054;
    public void mp_obj_exception_make_new() throws Exception
    {
        call(this.mp_obj_exception_make_new, this::mp_obj_exception_make_new);
    }


    // function: Function(address=134267092, size=88, name='exc_add_strn', path='build/py/objexcept.o', joint_set={0, 68, 40, 76, 44, 18, 82, 54, 24}, stop_set={80, 74, 86})
    abstract protected void exc_add_strn(int offset) throws Exception;
    protected int exc_add_strn = 0x0800c0d4;
    public void exc_add_strn() throws Exception
    {
        call(this.exc_add_strn, this::exc_add_strn);
    }


    // function: Function(address=134267180, size=2, name='mp_init_emergency_exception_buf', path='build/py/objexcept.o', joint_set={0}, stop_set={0})
    abstract protected void mp_init_emergency_exception_buf(int offset) throws Exception;
    protected int mp_init_emergency_exception_buf = 0x0800c12c;
    public void mp_init_emergency_exception_buf() throws Exception
    {
        call(this.mp_init_emergency_exception_buf, this::mp_init_emergency_exception_buf);
    }


    // function: Function(address=134267184, size=20, name='mp_obj_exception_get_value', path='build/py/objexcept.o', joint_set={0, 10, 12}, stop_set={12})
    abstract protected void mp_obj_exception_get_value(int offset) throws Exception;
    protected int mp_obj_exception_get_value = 0x0800c130;
    public void mp_obj_exception_get_value() throws Exception
    {
        call(this.mp_obj_exception_get_value, this::mp_obj_exception_get_value);
    }


    // function: Function(address=134267204, size=72, name='mp_obj_exception_attr', path='build/py/objexcept.o', joint_set={0, 34, 38, 10, 46, 14, 52, 22, 56, 26, 28, 30}, stop_set={58, 28, 36})
    abstract protected void mp_obj_exception_attr(int offset) throws Exception;
    protected int mp_obj_exception_attr = 0x0800c144;
    public void mp_obj_exception_attr() throws Exception
    {
        call(this.mp_obj_exception_attr, this::mp_obj_exception_attr);
    }


    // function: Function(address=134267276, size=12, name='mp_obj_new_exception_args', path='build/py/objexcept.o', joint_set={0}, stop_set={10})
    abstract protected void mp_obj_new_exception_args(int offset) throws Exception;
    protected int mp_obj_new_exception_args = 0x0800c18c;
    public void mp_obj_new_exception_args() throws Exception
    {
        call(this.mp_obj_new_exception_args, this::mp_obj_new_exception_args);
    }


    // function: Function(address=134267288, size=12, name='mp_obj_new_exception', path='build/py/objexcept.o', joint_set={0, 10}, stop_set={10})
    abstract protected void mp_obj_new_exception(int offset) throws Exception;
    protected int mp_obj_new_exception = 0x0800c198;
    public void mp_obj_new_exception() throws Exception
    {
        call(this.mp_obj_new_exception, this::mp_obj_new_exception);
    }


    // function: Function(address=134267300, size=14, name='mp_obj_new_exception_arg1', path='build/py/objexcept.o', joint_set={0, 12}, stop_set={12})
    abstract protected void mp_obj_new_exception_arg1(int offset) throws Exception;
    protected int mp_obj_new_exception_arg1 = 0x0800c1a4;
    public void mp_obj_new_exception_arg1() throws Exception
    {
        call(this.mp_obj_new_exception_arg1, this::mp_obj_new_exception_arg1);
    }


    // function: Function(address=134267316, size=148, name='mp_obj_new_exception_msg_varg', path='build/py/objexcept.o', joint_set={0, 34, 40, 104, 14, 48, 82, 22, 120, 30}, stop_set={128})
    abstract protected void mp_obj_new_exception_msg_varg(int offset) throws Exception;
    protected int mp_obj_new_exception_msg_varg = 0x0800c1b4;
    public void mp_obj_new_exception_msg_varg() throws Exception
    {
        call(this.mp_obj_new_exception_msg_varg, this::mp_obj_new_exception_msg_varg);
    }


    // function: Function(address=134267464, size=8, name='mp_obj_new_exception_msg', path='build/py/objexcept.o', joint_set={0, 6}, stop_set={6})
    abstract protected void mp_obj_new_exception_msg(int offset) throws Exception;
    protected int mp_obj_new_exception_msg = 0x0800c248;
    public void mp_obj_new_exception_msg() throws Exception
    {
        call(this.mp_obj_new_exception_msg, this::mp_obj_new_exception_msg);
    }


    // function: Function(address=134267472, size=48, name='mp_obj_is_exception_type', path='build/py/objexcept.o', joint_set={0, 34, 8, 16, 26}, stop_set={34})
    abstract protected void mp_obj_is_exception_type(int offset) throws Exception;
    protected int mp_obj_is_exception_type = 0x0800c250;
    public void mp_obj_is_exception_type() throws Exception
    {
        call(this.mp_obj_is_exception_type, this::mp_obj_is_exception_type);
    }


    // function: Function(address=134267520, size=12, name='mp_obj_is_exception_instance', path='build/py/objexcept.o', joint_set={0, 10, 6}, stop_set={10})
    abstract protected void mp_obj_is_exception_instance(int offset) throws Exception;
    protected int mp_obj_is_exception_instance = 0x0800c280;
    public void mp_obj_is_exception_instance() throws Exception
    {
        call(this.mp_obj_is_exception_instance, this::mp_obj_is_exception_instance);
    }


    // function: Function(address=134267532, size=32, name='mp_obj_exception_match', path='build/py/objexcept.o', joint_set={0, 10, 14, 20, 22, 30}, stop_set={30})
    abstract protected void mp_obj_exception_match(int offset) throws Exception;
    protected int mp_obj_exception_match = 0x0800c28c;
    public void mp_obj_exception_match() throws Exception
    {
        call(this.mp_obj_exception_match, this::mp_obj_exception_match);
    }


    // function: Function(address=134267564, size=28, name='mp_obj_exception_clear_traceback', path='build/py/objexcept.o', joint_set={0, 8, 18, 16}, stop_set={22})
    abstract protected void mp_obj_exception_clear_traceback(int offset) throws Exception;
    protected int mp_obj_exception_clear_traceback = 0x0800c2ac;
    public void mp_obj_exception_clear_traceback() throws Exception
    {
        call(this.mp_obj_exception_clear_traceback, this::mp_obj_exception_clear_traceback);
    }


    // function: Function(address=134267592, size=128, name='mp_obj_exception_add_traceback', path='build/py/objexcept.o', joint_set={0, 36, 104, 74, 76, 108, 14, 44, 50, 86, 22, 24, 56, 92, 30}, stop_set={74, 116})
    abstract protected void mp_obj_exception_add_traceback(int offset) throws Exception;
    protected int mp_obj_exception_add_traceback = 0x0800c2c8;
    public void mp_obj_exception_add_traceback() throws Exception
    {
        call(this.mp_obj_exception_add_traceback, this::mp_obj_exception_add_traceback);
    }


    // function: Function(address=134267720, size=44, name='mp_obj_exception_get_traceback', path='build/py/objexcept.o', joint_set={0, 34, 12, 20, 22, 28, 30}, stop_set={32, 38})
    abstract protected void mp_obj_exception_get_traceback(int offset) throws Exception;
    protected int mp_obj_exception_get_traceback = 0x0800c348;
    public void mp_obj_exception_get_traceback() throws Exception
    {
        call(this.mp_obj_exception_get_traceback, this::mp_obj_exception_get_traceback);
    }


    // function: Function(address=134267764, size=52, name='filter_iternext', path='build/py/objfilter.o', joint_set={0, 36, 4, 40, 10, 44, 46, 16, 24}, stop_set={46})
    abstract protected void filter_iternext(int offset) throws Exception;
    protected int filter_iternext = 0x0800c374;
    public void filter_iternext() throws Exception
    {
        call(this.filter_iternext, this::filter_iternext);
    }


    // function: Function(address=134267816, size=50, name='filter_make_new', path='build/py/objfilter.o', joint_set={0, 28, 22, 44}, stop_set={48})
    abstract protected void filter_make_new(int offset) throws Exception;
    protected int filter_make_new = 0x0800c3a8;
    public void filter_make_new() throws Exception
    {
        call(this.filter_make_new, this::filter_make_new);
    }


    // function: Function(address=134267868, size=88, name='float_print', path='build/py/objfloat.o', joint_set={0, 36, 68, 72, 44, 60, 80, 48, 56, 28}, stop_set={82})
    abstract protected void float_print(int offset) throws Exception;
    protected int float_print = 0x0800c3dc;
    public void float_print() throws Exception
    {
        call(this.float_print, this::float_print);
    }


    // function: Function(address=134267956, size=220, name='mp_obj_float_divmod', path='build/py/objfloat.o', joint_set={0, 136, 140, 16, 144, 154, 32, 162, 38, 174, 48, 178, 52, 184, 58, 62, 194, 70, 202, 74, 206, 82, 216, 88, 92, 100, 114, 118, 122}, stop_set={176, 218, 98})
    abstract protected void mp_obj_float_divmod(int offset) throws Exception;
    protected int mp_obj_float_divmod = 0x0800c434;
    public void mp_obj_float_divmod() throws Exception
    {
        call(this.mp_obj_float_divmod, this::mp_obj_float_divmod);
    }


    // function: Function(address=134268176, size=70, name='mp_float_hash', path='build/py/objfloat.o', joint_set={0, 64, 16, 50, 54, 56, 58, 30}, stop_set={56, 68})
    abstract protected void mp_float_hash(int offset) throws Exception;
    protected int mp_float_hash = 0x0800c510;
    public void mp_float_hash() throws Exception
    {
        call(this.mp_float_hash, this::mp_float_hash);
    }


    // function: Function(address=134268248, size=24, name='mp_obj_new_float', path='build/py/objfloat.o', joint_set={0, 10}, stop_set={16})
    abstract protected void mp_obj_new_float(int offset) throws Exception;
    protected int mp_obj_new_float = 0x0800c558;
    public void mp_obj_new_float() throws Exception
    {
        call(this.mp_obj_new_float, this::mp_obj_new_float);
    }


    // function: Function(address=134268272, size=92, name='float_make_new', path='build/py/objfloat.o', joint_set={0, 68, 40, 76, 44, 80, 84, 24, 62, 58, 30}, stop_set={60, 84})
    abstract protected void float_make_new(int offset) throws Exception;
    protected int float_make_new = 0x0800c570;
    public void float_make_new() throws Exception
    {
        call(this.float_make_new, this::float_make_new);
    }


    // function: Function(address=134268364, size=100, name='float_unary_op', path='build/py/objfloat.o', joint_set={0, 34, 68, 74, 10, 42, 12, 78, 46, 16, 84, 20, 22, 56, 26, 60, 30}, stop_set={24, 90, 76, 58})
    abstract protected void float_unary_op(int offset) throws Exception;
    protected int float_unary_op = 0x0800c5cc;
    public void float_unary_op() throws Exception
    {
        call(this.float_unary_op, this::float_unary_op);
    }


    // function: Function(address=134268464, size=4, name='mp_obj_float_get', path='build/py/objfloat.o', joint_set={0}, stop_set={2})
    abstract protected void mp_obj_float_get(int offset) throws Exception;
    protected int mp_obj_float_get = 0x0800c630;
    public void mp_obj_float_get() throws Exception
    {
        call(this.mp_obj_float_get, this::mp_obj_float_get);
    }


    // function: Function(address=134268468, size=560, name='mp_obj_float_binary_op', path='build/py/objfloat.o', joint_set={0, 516, 518, 526, 528, 18, 22, 536, 26, 28, 32, 34, 36, 40, 42, 46, 48, 52, 54, 58, 60, 64, 68, 70, 74, 78, 82, 84, 88, 92, 100, 104, 112, 116, 118, 122, 124, 128, 132, 140, 142, 148, 150, 154, 156, 160, 164, 174, 178, 186, 188, 192, 196, 204, 208, 216, 222, 230, 240, 242, 250, 252, 260, 262, 272, 276, 284, 294, 298, 306, 310, 314, 326, 330, 332, 342, 346, 348, 356, 362, 374, 378, 386, 390, 402, 406, 408, 416, 420, 422, 430, 434, 440, 446, 450, 462, 464, 470, 478, 480, 488, 494, 498, 506, 508}, stop_set={260, 516, 526, 148, 406, 536, 32, 420, 40, 46, 52, 312, 58, 186, 62, 82, 468, 478, 360, 108, 240, 496, 506, 250})
    abstract protected void mp_obj_float_binary_op(int offset) throws Exception;
    protected int mp_obj_float_binary_op = 0x0800c634;
    public void mp_obj_float_binary_op() throws Exception
    {
        call(this.mp_obj_float_binary_op, this::mp_obj_float_binary_op);
    }


    // function: Function(address=134269028, size=36, name='float_binary_op', path='build/py/objfloat.o', joint_set={0, 8, 16, 24, 26, 30}, stop_set={24, 30})
    abstract protected void float_binary_op(int offset) throws Exception;
    protected int float_binary_op = 0x0800c864;
    public void float_binary_op() throws Exception
    {
        call(this.float_binary_op, this::float_binary_op);
    }


    // function: Function(address=134269064, size=24, name='fun_builtin_0_call', path='build/py/objfun.o', joint_set={0, 18}, stop_set={22})
    abstract protected void fun_builtin_0_call(int offset) throws Exception;
    protected int fun_builtin_0_call = 0x0800c888;
    public void fun_builtin_0_call() throws Exception
    {
        call(this.fun_builtin_0_call, this::fun_builtin_0_call);
    }


    // function: Function(address=134269088, size=30, name='fun_builtin_1_call', path='build/py/objfun.o', joint_set={0, 22}, stop_set={28})
    abstract protected void fun_builtin_1_call(int offset) throws Exception;
    protected int fun_builtin_1_call = 0x0800c8a0;
    public void fun_builtin_1_call() throws Exception
    {
        call(this.fun_builtin_1_call, this::fun_builtin_1_call);
    }


    // function: Function(address=134269118, size=30, name='fun_builtin_2_call', path='build/py/objfun.o', joint_set={0, 22}, stop_set={28})
    abstract protected void fun_builtin_2_call(int offset) throws Exception;
    protected int fun_builtin_2_call = 0x0800c8be;
    public void fun_builtin_2_call() throws Exception
    {
        call(this.fun_builtin_2_call, this::fun_builtin_2_call);
    }


    // function: Function(address=134269148, size=30, name='fun_builtin_3_call', path='build/py/objfun.o', joint_set={0, 22}, stop_set={28})
    abstract protected void fun_builtin_3_call(int offset) throws Exception;
    protected int fun_builtin_3_call = 0x0800c8dc;
    public void fun_builtin_3_call() throws Exception
    {
        call(this.fun_builtin_3_call, this::fun_builtin_3_call);
    }


    // function: Function(address=134269180, size=132, name='fun_bc_call', path='build/py/objfun.o', joint_set={0, 34, 98, 70, 102, 108, 16, 112, 22, 54, 88, 122, 30}, stop_set={108, 124, 120})
    abstract protected void fun_bc_call(int offset) throws Exception;
    protected int fun_bc_call = 0x0800c8fc;
    public void fun_bc_call() throws Exception
    {
        call(this.fun_bc_call, this::fun_bc_call);
    }


    // function: Function(address=134269312, size=76, name='fun_builtin_var_call', path='build/py/objfun.o', joint_set={0, 34, 66, 40, 52, 62}, stop_set={64, 74})
    abstract protected void fun_builtin_var_call(int offset) throws Exception;
    protected int fun_builtin_var_call = 0x0800c980;
    public void fun_builtin_var_call() throws Exception
    {
        call(this.fun_builtin_var_call, this::fun_builtin_var_call);
    }


    // function: Function(address=134269388, size=16, name='mp_obj_code_get_name', path='build/py/objfun.o', joint_set={0, 6}, stop_set={14})
    abstract protected void mp_obj_code_get_name(int offset) throws Exception;
    protected int mp_obj_code_get_name = 0x0800c9cc;
    public void mp_obj_code_get_name() throws Exception
    {
        call(this.mp_obj_code_get_name, this::mp_obj_code_get_name);
    }


    // function: Function(address=134269404, size=20, name='mp_obj_fun_get_name', path='build/py/objfun.o', joint_set={0, 8, 18, 12}, stop_set={18})
    abstract protected void mp_obj_fun_get_name(int offset) throws Exception;
    protected int mp_obj_fun_get_name = 0x0800c9dc;
    public void mp_obj_fun_get_name() throws Exception
    {
        call(this.mp_obj_fun_get_name, this::mp_obj_fun_get_name);
    }


    // function: Function(address=134269424, size=28, name='mp_obj_fun_bc_attr', path='build/py/objfun.o', joint_set={0, 10, 14, 18, 26}, stop_set={26})
    abstract protected void mp_obj_fun_bc_attr(int offset) throws Exception;
    protected int mp_obj_fun_bc_attr = 0x0800c9f0;
    public void mp_obj_fun_bc_attr() throws Exception
    {
        call(this.mp_obj_fun_bc_attr, this::mp_obj_fun_bc_attr);
    }


    // function: Function(address=134269452, size=32, name='fun_bc_print', path='build/py/objfun.o', joint_set={0, 24, 12}, stop_set={24})
    abstract protected void fun_bc_print(int offset) throws Exception;
    protected int fun_bc_print = 0x0800ca0c;
    public void fun_bc_print() throws Exception
    {
        call(this.fun_bc_print, this::fun_bc_print);
    }


    // function: Function(address=134269484, size=84, name='mp_obj_fun_bc_prepare_codestate', path='build/py/objfun.o', joint_set={0, 32, 66, 14, 48, 20, 28}, stop_set={78})
    abstract protected void mp_obj_fun_bc_prepare_codestate(int offset) throws Exception;
    protected int mp_obj_fun_bc_prepare_codestate = 0x0800ca2c;
    public void mp_obj_fun_bc_prepare_codestate() throws Exception
    {
        call(this.mp_obj_fun_bc_prepare_codestate, this::mp_obj_fun_bc_prepare_codestate);
    }


    // function: Function(address=134269568, size=92, name='mp_obj_new_fun_bc', path='build/py/objfun.o', joint_set={0, 32, 68, 72, 78, 14, 16, 56}, stop_set={80})
    abstract protected void mp_obj_new_fun_bc(int offset) throws Exception;
    protected int mp_obj_new_fun_bc = 0x0800ca80;
    public void mp_obj_new_fun_bc() throws Exception
    {
        call(this.mp_obj_new_fun_bc, this::mp_obj_new_fun_bc);
    }


    // function: Function(address=134269660, size=80, name='gen_wrap_call', path='build/py/objgenerator.o', joint_set={0, 72, 44, 16, 24, 28}, stop_set={74})
    abstract protected void gen_wrap_call(int offset) throws Exception;
    protected int gen_wrap_call = 0x0800cadc;
    public void gen_wrap_call() throws Exception
    {
        call(this.gen_wrap_call, this::gen_wrap_call);
    }


    // function: Function(address=134269740, size=28, name='gen_instance_pend_throw', path='build/py/objgenerator.o', joint_set={0, 16, 10}, stop_set={20, 12})
    abstract protected void gen_instance_pend_throw(int offset) throws Exception;
    protected int gen_instance_pend_throw = 0x0800cb2c;
    public void gen_instance_pend_throw() throws Exception
    {
        call(this.gen_instance_pend_throw, this::gen_instance_pend_throw);
    }


    // function: Function(address=134269768, size=32, name='gen_instance_print', path='build/py/objgenerator.o', joint_set={0, 24, 12}, stop_set={24})
    abstract protected void gen_instance_print(int offset) throws Exception;
    protected int gen_instance_print = 0x0800cb48;
    public void gen_instance_print() throws Exception
    {
        call(this.gen_instance_print, this::gen_instance_print);
    }


    // function: Function(address=134269800, size=16, name='unlikely_gen_instance_throw_part_0', path='build/py/objgenerator.o', joint_set={0, 8}, stop_set={8})
    abstract protected void unlikely_gen_instance_throw_part_0(int offset) throws Exception;
    protected int unlikely_gen_instance_throw_part_0 = 0x0800cb68;
    public void unlikely_gen_instance_throw_part_0() throws Exception
    {
        call(this.unlikely_gen_instance_throw_part_0, this::unlikely_gen_instance_throw_part_0);
    }


    // function: Function(address=134269816, size=184, name='mp_obj_gen_resume', path='build/py/objgenerator.o', joint_set={0, 64, 128, 132, 58, 102, 70, 38, 76, 120, 14, 44, 80, 50, 146, 116, 20, 24, 154, 28}, stop_set={130, 164, 72, 78, 46, 144, 26})
    abstract protected void mp_obj_gen_resume(int offset) throws Exception;
    protected int mp_obj_gen_resume = 0x0800cb78;
    public void mp_obj_gen_resume() throws Exception
    {
        call(this.mp_obj_gen_resume, this::mp_obj_gen_resume);
    }


    // function: Function(address=134270000, size=88, name='gen_resume_and_raise', path='build/py/objgenerator.o', joint_set={0, 66, 38, 8, 72, 42, 12, 76, 46, 44, 18, 52, 24, 58, 28, 62}, stop_set={64, 78, 44, 38})
    abstract protected void gen_resume_and_raise(int offset) throws Exception;
    protected int gen_resume_and_raise = 0x0800cc30;
    public void gen_resume_and_raise() throws Exception
    {
        call(this.gen_resume_and_raise, this::gen_resume_and_raise);
    }


    // function: Function(address=134270088, size=36, name='gen_instance_throw', path='build/py/objgenerator.o', joint_set={0, 8, 10, 18, 22, 26, 30}, stop_set={28, 30})
    abstract protected void gen_instance_throw(int offset) throws Exception;
    protected int gen_instance_throw = 0x0800cc88;
    public void gen_instance_throw() throws Exception
    {
        call(this.gen_instance_throw, this::gen_instance_throw);
    }


    // function: Function(address=134270124, size=18, name='gen_instance_send', path='build/py/objgenerator.o', joint_set={0, 8, 12, 16}, stop_set={16})
    abstract protected void gen_instance_send(int offset) throws Exception;
    protected int gen_instance_send = 0x0800ccac;
    public void gen_instance_send() throws Exception
    {
        call(this.gen_instance_send, this::gen_instance_send);
    }


    // function: Function(address=134270144, size=16, name='gen_instance_iternext', path='build/py/objgenerator.o', joint_set={0, 10}, stop_set={10})
    abstract protected void gen_instance_iternext(int offset) throws Exception;
    protected int gen_instance_iternext = 0x0800ccc0;
    public void gen_instance_iternext() throws Exception
    {
        call(this.gen_instance_iternext, this::gen_instance_iternext);
    }


    // function: Function(address=134270160, size=96, name='gen_instance_close', path='build/py/objgenerator.o', joint_set={0, 34, 66, 40, 14, 46, 18, 50, 22, 56, 26, 62}, stop_set={24, 68, 30})
    abstract protected void gen_instance_close(int offset) throws Exception;
    protected int gen_instance_close = 0x0800ccd0;
    public void gen_instance_close() throws Exception
    {
        call(this.gen_instance_close, this::gen_instance_close);
    }


    // function: Function(address=134270256, size=84, name='it_iternext', path='build/py/objgetitemiter.o', joint_set={0, 68, 72, 12, 44, 16, 50, 24, 60}, stop_set={48, 74, 68})
    abstract protected void it_iternext(int offset) throws Exception;
    protected int it_iternext = 0x0800cd30;
    public void it_iternext() throws Exception
    {
        call(this.it_iternext, this::it_iternext);
    }


    // function: Function(address=134270340, size=24, name='mp_obj_new_getitem_iter', path='build/py/objgetitemiter.o', joint_set={0}, stop_set={18})
    abstract protected void mp_obj_new_getitem_iter(int offset) throws Exception;
    protected int mp_obj_new_getitem_iter = 0x0800cd84;
    public void mp_obj_new_getitem_iter() throws Exception
    {
        call(this.mp_obj_new_getitem_iter, this::mp_obj_new_getitem_iter);
    }


    // function: Function(address=134270364, size=128, name='int_to_bytes', path='build/py/objint.o', joint_set={0, 72, 104, 42, 106, 12, 80, 16, 114, 84, 54, 22, 62, 92, 94}, stop_set={82, 18, 114})
    abstract protected void int_to_bytes(int offset) throws Exception;
    protected int int_to_bytes = 0x0800cd9c;
    public void int_to_bytes() throws Exception
    {
        call(this.int_to_bytes, this::int_to_bytes);
    }


    // function: Function(address=134270492, size=108, name='int_from_bytes', path='build/py/objint.o', joint_set={0, 68, 38, 44, 16, 48, 82, 52, 54, 86, 26, 60}, stop_set={58, 84, 94, 52})
    abstract protected void int_from_bytes(int offset) throws Exception;
    protected int int_from_bytes = 0x0800ce1c;
    public void int_from_bytes() throws Exception
    {
        call(this.int_from_bytes, this::int_from_bytes);
    }


    // function: Function(address=134270600, size=128, name='mp_obj_new_int_from_float', path='build/py/objint.o', joint_set={0, 64, 96, 32, 58, 102, 72, 40, 44, 76, 16, 50, 20, 86, 54, 90, 28}, stop_set={40, 108, 46, 88, 94})
    abstract protected void mp_obj_new_int_from_float(int offset) throws Exception;
    protected int mp_obj_new_int_from_float = 0x0800ce88;
    public void mp_obj_new_int_from_float() throws Exception
    {
        call(this.mp_obj_new_int_from_float, this::mp_obj_new_int_from_float);
    }


    // function: Function(address=134270728, size=156, name='mp_obj_int_make_new', path='build/py/objint.o', joint_set={0, 128, 132, 136, 24, 30, 34, 40, 48, 56, 64, 70, 76, 80, 82, 88, 92, 96, 100, 108, 118}, stop_set={80, 98, 142, 126})
    abstract protected void mp_obj_int_make_new(int offset) throws Exception;
    protected int mp_obj_int_make_new = 0x0800cf08;
    public void mp_obj_int_make_new() throws Exception
    {
        call(this.mp_obj_int_make_new, this::mp_obj_int_make_new);
    }


    // function: Function(address=134270884, size=56, name='mp_int_format_size', path='build/py/objint.o', joint_set={0, 34, 36, 40, 44, 18, 26}, stop_set={50})
    abstract protected void mp_int_format_size(int offset) throws Exception;
    protected int mp_int_format_size = 0x0800cfa4;
    public void mp_int_format_size() throws Exception
    {
        call(this.mp_int_format_size, this::mp_int_format_size);
    }


    // function: Function(address=134270940, size=278, name='mp_obj_int_formatted', path='build/py/objint.o', joint_set={0, 256, 128, 132, 264, 140, 272, 274, 150, 24, 152, 158, 32, 36, 178, 50, 180, 186, 58, 62, 192, 68, 198, 204, 210, 84, 216, 220, 92, 226, 100, 108, 112, 124, 242, 246, 250, 252}, stop_set={240, 272, 276, 184, 250, 156})
    abstract protected void mp_obj_int_formatted(int offset) throws Exception;
    protected int mp_obj_int_formatted = 0x0800cfdc;
    public void mp_obj_int_formatted() throws Exception
    {
        call(this.mp_obj_int_formatted, this::mp_obj_int_formatted);
    }


    // function: Function(address=134271218, size=62, name='mp_obj_int_print', path='build/py/objint.o', joint_set={0, 38, 46, 52, 58}, stop_set={60})
    abstract protected void mp_obj_int_print(int offset) throws Exception;
    protected int mp_obj_int_print = 0x0800d0f2;
    public void mp_obj_int_print() throws Exception
    {
        call(this.mp_obj_int_print, this::mp_obj_int_print);
    }


    // function: Function(address=134271280, size=100, name='mp_obj_int_binary_op_extra_cases', path='build/py/objint.o', joint_set={0, 32, 66, 38, 72, 12, 28, 46, 14, 16, 50, 20, 22, 60}, stop_set={20, 78, 30})
    abstract protected void mp_obj_int_binary_op_extra_cases(int offset) throws Exception;
    protected int mp_obj_int_binary_op_extra_cases = 0x0800d130;
    public void mp_obj_int_binary_op_extra_cases() throws Exception
    {
        call(this.mp_obj_int_binary_op_extra_cases, this::mp_obj_int_binary_op_extra_cases);
    }


    // function: Function(address=134271380, size=28, name='mp_obj_int_new_mpz', path='build/py/objint_mpz.o', joint_set={0, 8, 18}, stop_set={20})
    abstract protected void mp_obj_int_new_mpz(int offset) throws Exception;
    protected int mp_obj_int_new_mpz = 0x0800d194;
    public void mp_obj_int_new_mpz() throws Exception
    {
        call(this.mp_obj_int_new_mpz, this::mp_obj_int_new_mpz);
    }


    // function: Function(address=134271408, size=84, name='mp_obj_int_formatted_impl', path='build/py/objint_mpz.o', joint_set={0, 38, 74, 46, 50, 54}, stop_set={82})
    abstract protected void mp_obj_int_formatted_impl(int offset) throws Exception;
    protected int mp_obj_int_formatted_impl = 0x0800d1b0;
    public void mp_obj_int_formatted_impl() throws Exception
    {
        call(this.mp_obj_int_formatted_impl, this::mp_obj_int_formatted_impl);
    }


    // function: Function(address=134271492, size=30, name='mp_obj_int_from_bytes_impl', path='build/py/objint_mpz.o', joint_set={0, 26, 12}, stop_set={28})
    abstract protected void mp_obj_int_from_bytes_impl(int offset) throws Exception;
    protected int mp_obj_int_from_bytes_impl = 0x0800d204;
    public void mp_obj_int_from_bytes_impl() throws Exception
    {
        call(this.mp_obj_int_from_bytes_impl, this::mp_obj_int_from_bytes_impl);
    }


    // function: Function(address=134271522, size=32, name='mp_obj_int_to_bytes_impl', path='build/py/objint_mpz.o', joint_set={0, 18, 30}, stop_set={30})
    abstract protected void mp_obj_int_to_bytes_impl(int offset) throws Exception;
    protected int mp_obj_int_to_bytes_impl = 0x0800d222;
    public void mp_obj_int_to_bytes_impl() throws Exception
    {
        call(this.mp_obj_int_to_bytes_impl, this::mp_obj_int_to_bytes_impl);
    }


    // function: Function(address=134271554, size=40, name='mp_obj_int_sign', path='build/py/objint_mpz.o', joint_set={0, 34, 8, 12, 18, 20, 26}, stop_set={18, 38})
    abstract protected void mp_obj_int_sign(int offset) throws Exception;
    protected int mp_obj_int_sign = 0x0800d242;
    public void mp_obj_int_sign() throws Exception
    {
        call(this.mp_obj_int_sign, this::mp_obj_int_sign);
    }


    // function: Function(address=134271596, size=128, name='mp_obj_int_unary_op', path='build/py/objint_mpz.o', joint_set={0, 8, 10, 14, 18, 20, 24, 28, 32, 36, 44, 48, 54, 62, 66, 76, 80, 84, 94, 96, 102, 106, 116}, stop_set={78, 46, 116, 22, 60, 94})
    abstract protected void mp_obj_int_unary_op(int offset) throws Exception;
    protected int mp_obj_int_unary_op = 0x0800d26c;
    public void mp_obj_int_unary_op() throws Exception
    {
        call(this.mp_obj_int_unary_op, this::mp_obj_int_unary_op);
    }


    // function: Function(address=134271724, size=30, name='mp_obj_new_int_from_ll', path='build/py/objint_mpz.o', joint_set={0, 10, 26}, stop_set={28})
    abstract protected void mp_obj_new_int_from_ll(int offset) throws Exception;
    protected int mp_obj_new_int_from_ll = 0x0800d2ec;
    public void mp_obj_new_int_from_ll() throws Exception
    {
        call(this.mp_obj_new_int_from_ll, this::mp_obj_new_int_from_ll);
    }


    // function: Function(address=134271754, size=24, name='mp_obj_new_int', path='build/py/objint_mpz.o', joint_set={0, 10, 14, 16, 22}, stop_set={14, 22})
    abstract protected void mp_obj_new_int(int offset) throws Exception;
    protected int mp_obj_new_int = 0x0800d30a;
    public void mp_obj_new_int() throws Exception
    {
        call(this.mp_obj_new_int, this::mp_obj_new_int);
    }


    // function: Function(address=134271778, size=30, name='mp_obj_new_int_from_ull', path='build/py/objint_mpz.o', joint_set={0, 10, 26}, stop_set={28})
    abstract protected void mp_obj_new_int_from_ull(int offset) throws Exception;
    protected int mp_obj_new_int_from_ull = 0x0800d322;
    public void mp_obj_new_int_from_ull() throws Exception
    {
        call(this.mp_obj_new_int_from_ull, this::mp_obj_new_int_from_ull);
    }


    // function: Function(address=134271808, size=208, name='mp_obj_int_pow3', path='build/py/objint_mpz.o', joint_set={0, 132, 140, 142, 20, 24, 156, 32, 162, 168, 40, 44, 174, 52, 180, 186, 60, 192, 64, 72, 78, 86, 96, 104, 106, 114, 122, 124}, stop_set={74, 196})
    abstract protected void mp_obj_int_pow3(int offset) throws Exception;
    protected int mp_obj_int_pow3 = 0x0800d340;
    public void mp_obj_int_pow3() throws Exception
    {
        call(this.mp_obj_int_pow3, this::mp_obj_int_pow3);
    }


    // function: Function(address=134272016, size=22, name='mp_obj_new_int_from_uint', path='build/py/objint_mpz.o', joint_set={0, 6, 12, 14, 20}, stop_set={12, 20})
    abstract protected void mp_obj_new_int_from_uint(int offset) throws Exception;
    protected int mp_obj_new_int_from_uint = 0x0800d410;
    public void mp_obj_new_int_from_uint() throws Exception
    {
        call(this.mp_obj_new_int_from_uint, this::mp_obj_new_int_from_uint);
    }


    // function: Function(address=134272038, size=46, name='mp_obj_new_int_from_str_len', path='build/py/objint_mpz.o', joint_set={0, 16, 34}, stop_set={44})
    abstract protected void mp_obj_new_int_from_str_len(int offset) throws Exception;
    protected int mp_obj_new_int_from_str_len = 0x0800d426;
    public void mp_obj_new_int_from_str_len() throws Exception
    {
        call(this.mp_obj_new_int_from_str_len, this::mp_obj_new_int_from_str_len);
    }


    // function: Function(address=134272084, size=18, name='mp_obj_int_get_truncated', path='build/py/objint_mpz.o', joint_set={0, 6, 8, 10, 16}, stop_set={8, 16})
    abstract protected void mp_obj_int_get_truncated(int offset) throws Exception;
    protected int mp_obj_int_get_truncated = 0x0800d454;
    public void mp_obj_int_get_truncated() throws Exception
    {
        call(this.mp_obj_int_get_truncated, this::mp_obj_int_get_truncated);
    }


    // function: Function(address=134272104, size=44, name='mp_obj_int_get_checked', path='build/py/objint_mpz.o', joint_set={0, 6, 8, 10, 18, 22, 26}, stop_set={8, 24, 30})
    abstract protected void mp_obj_int_get_checked(int offset) throws Exception;
    protected int mp_obj_int_get_checked = 0x0800d468;
    public void mp_obj_int_get_checked() throws Exception
    {
        call(this.mp_obj_int_get_checked, this::mp_obj_int_get_checked);
    }


    // function: Function(address=134272148, size=648, name='mp_obj_int_binary_op', path='build/py/objint_mpz.o', joint_set={0, 516, 520, 524, 526, 16, 530, 532, 540, 28, 30, 544, 546, 36, 550, 554, 558, 562, 50, 52, 566, 56, 60, 572, 574, 66, 68, 580, 582, 74, 586, 592, 82, 594, 600, 90, 602, 604, 94, 96, 610, 612, 102, 112, 118, 124, 130, 140, 142, 148, 154, 166, 168, 174, 184, 186, 194, 196, 200, 206, 208, 212, 216, 218, 222, 224, 228, 230, 236, 240, 254, 266, 268, 272, 274, 278, 282, 292, 294, 298, 302, 308, 314, 324, 328, 330, 334, 336, 340, 344, 354, 356, 360, 362, 366, 370, 380, 382, 386, 390, 396, 402, 404, 414, 416, 426, 428, 434, 442, 448, 456, 460, 466, 468, 478, 480, 490, 492, 498, 502, 508}, stop_set={266, 140, 524, 402, 530, 414, 292, 426, 172, 556, 438, 184, 572, 66, 322, 580, 194, 584, 592, 466, 216, 600, 602, 478, 94, 354, 610, 228, 612, 490, 116, 504, 380})
    abstract protected void mp_obj_int_binary_op(int offset) throws Exception;
    protected int mp_obj_int_binary_op = 0x0800d494;
    public void mp_obj_int_binary_op() throws Exception
    {
        call(this.mp_obj_int_binary_op, this::mp_obj_int_binary_op);
    }


    // function: Function(address=134272796, size=10, name='mp_obj_int_as_float_impl', path='build/py/objint_mpz.o', joint_set={0, 8}, stop_set={8})
    abstract protected void mp_obj_int_as_float_impl(int offset) throws Exception;
    protected int mp_obj_int_as_float_impl = 0x0800d71c;
    public void mp_obj_int_as_float_impl() throws Exception
    {
        call(this.mp_obj_int_as_float_impl, this::mp_obj_int_as_float_impl);
    }


    // function: Function(address=134272808, size=28, name='list_getiter', path='build/py/objlist.o', joint_set={0}, stop_set={16})
    abstract protected void list_getiter(int offset) throws Exception;
    protected int list_getiter = 0x0800d728;
    public void list_getiter() throws Exception
    {
        call(this.list_getiter, this::list_getiter);
    }


    // function: Function(address=134272836, size=56, name='list_reverse', path='build/py/objlist.o', joint_set={0, 24, 20, 16}, stop_set={46, 22})
    abstract protected void list_reverse(int offset) throws Exception;
    protected int list_reverse = 0x0800d744;
    public void list_reverse() throws Exception
    {
        call(this.list_reverse, this::list_reverse);
    }


    // function: Function(address=134272892, size=28, name='list_it_iternext', path='build/py/objlist.o', joint_set={0, 16, 26}, stop_set={26})
    abstract protected void list_it_iternext(int offset) throws Exception;
    protected int list_it_iternext = 0x0800d77c;
    public void list_it_iternext() throws Exception
    {
        call(this.list_it_iternext, this::list_it_iternext);
    }


    // function: Function(address=134272920, size=80, name='mp_obj_list_append', path='build/py/objlist.o', joint_set={0, 24, 54, 14}, stop_set={68})
    abstract protected void mp_obj_list_append(int offset) throws Exception;
    protected int mp_obj_list_append = 0x0800d798;
    public void mp_obj_list_append() throws Exception
    {
        call(this.mp_obj_list_append, this::mp_obj_list_append);
    }


    // function: Function(address=134273000, size=76, name='list_insert', path='build/py/objlist.o', joint_set={0, 34, 42, 12, 16, 50, 18, 54, 58, 28}, stop_set={48, 56, 70})
    abstract protected void list_insert(int offset) throws Exception;
    protected int list_insert = 0x0800d7e8;
    public void list_insert() throws Exception
    {
        call(this.list_insert, this::list_insert);
    }


    // function: Function(address=134273076, size=44, name='list_clear', path='build/py/objlist.o', joint_set={0, 34, 20}, stop_set={36})
    abstract protected void list_clear(int offset) throws Exception;
    protected int list_clear = 0x0800d834;
    public void list_clear() throws Exception
    {
        call(this.list_clear, this::list_clear);
    }


    // function: Function(address=134273120, size=208, name='mp_quicksort', path='build/py/objlist.o', joint_set={0, 128, 132, 140, 16, 144, 22, 26, 40, 172, 48, 50, 52, 184, 186, 60, 192, 68, 204, 76, 82, 88, 94, 96, 104, 110, 118, 122}, stop_set={130, 142, 206, 120, 24, 190})
    abstract protected void mp_quicksort(int offset) throws Exception;
    protected int mp_quicksort = 0x0800d860;
    public void mp_quicksort() throws Exception
    {
        call(this.mp_quicksort, this::mp_quicksort);
    }


    // function: Function(address=134273328, size=92, name='mp_obj_list_sort', path='build/py/objlist.o', joint_set={0, 66, 34, 50, 52, 24, 60, 62}, stop_set={70})
    abstract protected void mp_obj_list_sort(int offset) throws Exception;
    protected int mp_obj_list_sort = 0x0800d930;
    public void mp_obj_list_sort() throws Exception
    {
        call(this.mp_obj_list_sort, this::mp_obj_list_sort);
    }


    // function: Function(address=134273420, size=18, name='list_index', path='build/py/objlist.o', joint_set={0, 16}, stop_set={16})
    abstract protected void list_index(int offset) throws Exception;
    protected int list_index = 0x0800d98c;
    public void list_index() throws Exception
    {
        call(this.list_index, this::list_index);
    }


    // function: Function(address=134273440, size=124, name='list_pop', path='build/py/objlist.o', joint_set={0, 64, 98, 36, 106, 110, 14, 80, 22, 86, 28, 30}, stop_set={114, 18, 108})
    abstract protected void list_pop(int offset) throws Exception;
    protected int list_pop = 0x0800d9a0;
    public void list_pop() throws Exception
    {
        call(this.list_pop, this::list_pop);
    }


    // function: Function(address=134273564, size=32, name='mp_obj_list_remove', path='build/py/objlist.o', joint_set={0, 24, 14}, stop_set={26})
    abstract protected void mp_obj_list_remove(int offset) throws Exception;
    protected int mp_obj_list_remove = 0x0800da1c;
    public void mp_obj_list_remove() throws Exception
    {
        call(this.mp_obj_list_remove, this::mp_obj_list_remove);
    }


    // function: Function(address=134273596, size=36, name='list_extend_from_iter', path='build/py/objlist.o', joint_set={0, 34, 12, 14, 20, 28, 30}, stop_set={34, 28})
    abstract protected void list_extend_from_iter(int offset) throws Exception;
    protected int list_extend_from_iter = 0x0800da3c;
    public void list_extend_from_iter() throws Exception
    {
        call(this.list_extend_from_iter, this::list_extend_from_iter);
    }


    // function: Function(address=134273632, size=14, name='list_count', path='build/py/objlist.o', joint_set={0, 12}, stop_set={12})
    abstract protected void list_count(int offset) throws Exception;
    protected int list_count = 0x0800da60;
    public void list_count() throws Exception
    {
        call(this.list_count, this::list_count);
    }


    // function: Function(address=134273648, size=84, name='list_print', path='build/py/objlist.o', joint_set={0, 66, 38, 40, 44, 12, 14, 52, 22, 24, 30}, stop_set={68, 38})
    abstract protected void list_print(int offset) throws Exception;
    protected int list_print = 0x0800da70;
    public void list_print() throws Exception
    {
        call(this.list_print, this::list_print);
    }


    // function: Function(address=134273732, size=56, name='list_unary_op', path='build/py/objlist.o', joint_set={0, 34, 4, 8, 42, 12, 20, 22, 24, 28}, stop_set={32, 40, 44, 22})
    abstract protected void list_unary_op(int offset) throws Exception;
    protected int list_unary_op = 0x0800dac4;
    public void list_unary_op() throws Exception
    {
        call(this.list_unary_op, this::list_unary_op);
    }


    // function: Function(address=134273788, size=116, name='list_extend', path='build/py/objlist.o', joint_set={0, 32, 98, 68, 106, 12, 44, 20, 86, 94}, stop_set={96, 106})
    abstract protected void list_extend(int offset) throws Exception;
    protected int list_extend = 0x0800dafc;
    public void list_extend() throws Exception
    {
        call(this.list_extend, this::list_extend);
    }


    // function: Function(address=134273904, size=52, name='mp_obj_list_init', path='build/py/objlist.o', joint_set={0, 46, 16, 18, 28}, stop_set={46})
    abstract protected void mp_obj_list_init(int offset) throws Exception;
    protected int mp_obj_list_init = 0x0800db70;
    public void mp_obj_list_init() throws Exception
    {
        call(this.mp_obj_list_init, this::mp_obj_list_init);
    }


    // function: Function(address=134273956, size=22, name='list_new', path='build/py/objlist.o', joint_set={0, 10, 18}, stop_set={20})
    abstract protected void list_new(int offset) throws Exception;
    protected int list_new = 0x0800dba4;
    public void list_new() throws Exception
    {
        call(this.list_new, this::list_new);
    }


    // function: Function(address=134273980, size=216, name='list_binary_op', path='build/py/objlist.o', joint_set={0, 10, 12, 142, 16, 148, 20, 24, 28, 156, 160, 36, 164, 42, 172, 48, 176, 50, 180, 60, 194, 200, 78, 80, 90, 100, 110, 124}, stop_set={200, 78, 178, 146, 18, 158})
    abstract protected void list_binary_op(int offset) throws Exception;
    protected int list_binary_op = 0x0800dbbc;
    public void list_binary_op() throws Exception
    {
        call(this.list_binary_op, this::list_binary_op);
    }


    // function: Function(address=134274196, size=48, name='list_make_new', path='build/py/objlist.o', joint_set={0, 32, 34, 40, 46, 22, 26}, stop_set={32, 46})
    abstract protected void list_make_new(int offset) throws Exception;
    protected int list_make_new = 0x0800dc94;
    public void list_make_new() throws Exception
    {
        call(this.list_make_new, this::list_make_new);
    }


    // function: Function(address=134274244, size=34, name='mp_obj_new_list', path='build/py/objlist.o', joint_set={0, 10, 14, 18, 22, 24}, stop_set={32, 22})
    abstract protected void mp_obj_new_list(int offset) throws Exception;
    protected int mp_obj_new_list = 0x0800dcc4;
    public void mp_obj_new_list() throws Exception
    {
        call(this.mp_obj_new_list, this::mp_obj_new_list);
    }


    // function: Function(address=134274278, size=12, name='list_copy', path='build/py/objlist.o', joint_set={0, 10}, stop_set={10})
    abstract protected void list_copy(int offset) throws Exception;
    protected int list_copy = 0x0800dce6;
    public void list_copy() throws Exception
    {
        call(this.list_copy, this::list_copy);
    }


    // function: Function(address=134274290, size=10, name='mp_obj_list_get', path='build/py/objlist.o', joint_set={0}, stop_set={8})
    abstract protected void mp_obj_list_get(int offset) throws Exception;
    protected int mp_obj_list_get = 0x0800dcf2;
    public void mp_obj_list_get() throws Exception
    {
        call(this.mp_obj_list_get, this::mp_obj_list_get);
    }


    // function: Function(address=134274300, size=4, name='mp_obj_list_set_len', path='build/py/objlist.o', joint_set={0}, stop_set={2})
    abstract protected void mp_obj_list_set_len(int offset) throws Exception;
    protected int mp_obj_list_set_len = 0x0800dcfc;
    public void mp_obj_list_set_len() throws Exception
    {
        call(this.mp_obj_list_set_len, this::mp_obj_list_set_len);
    }


    // function: Function(address=134274304, size=26, name='mp_obj_list_store', path='build/py/objlist.o', joint_set={0, 18}, stop_set={24})
    abstract protected void mp_obj_list_store(int offset) throws Exception;
    protected int mp_obj_list_store = 0x0800dd00;
    public void mp_obj_list_store() throws Exception
    {
        call(this.mp_obj_list_store, this::mp_obj_list_store);
    }


    // function: Function(address=134274332, size=440, name='list_subscr', path='build/py/objlist.o', joint_set={0, 132, 396, 140, 270, 146, 18, 150, 22, 280, 30, 416, 288, 418, 160, 164, 38, 296, 42, 428, 174, 48, 194, 196, 326, 74, 208, 344, 216, 120, 222, 94, 352, 100, 102, 230, 364, 108, 238, 248, 122, 252, 126}, stop_set={416, 194, 162, 106, 428, 44, 214, 120, 350})
    abstract protected void list_subscr(int offset) throws Exception;
    protected int list_subscr = 0x0800dd1c;
    public void list_subscr() throws Exception
    {
        call(this.list_subscr, this::list_subscr);
    }


    // function: Function(address=134274772, size=72, name='map_iternext', path='build/py/objmap.o', joint_set={0, 64, 34, 32, 12, 46, 16, 50, 22, 60, 62}, stop_set={62, 32, 70})
    abstract protected void map_iternext(int offset) throws Exception;
    protected int map_iternext = 0x0800ded4;
    public void map_iternext() throws Exception
    {
        call(this.map_iternext, this::map_iternext);
    }


    // function: Function(address=134274844, size=88, name='map_make_new', path='build/py/objmap.o', joint_set={0, 68, 38, 76, 56, 26, 62}, stop_set={80, 66})
    abstract protected void map_make_new(int offset) throws Exception;
    protected int map_make_new = 0x0800df1c;
    public void map_make_new() throws Exception
    {
        call(this.map_make_new, this::map_make_new);
    }


    // function: Function(address=134274932, size=92, name='module_print', path='build/py/objmodule.o', joint_set={0, 32, 66, 68, 44, 78, 48, 18, 54, 24, 30}, stop_set={66, 78})
    abstract protected void module_print(int offset) throws Exception;
    protected int module_print = 0x0800df74;
    public void module_print() throws Exception
    {
        call(this.module_print, this::module_print);
    }


    // function: Function(address=134275024, size=104, name='module_attr', path='build/py/objmodule.o', joint_set={0, 32, 34, 66, 36, 68, 70, 26, 42, 48, 16, 82, 86, 30, 90, 60, 94}, stop_set={88, 34, 94})
    abstract protected void module_attr(int offset) throws Exception;
    protected int module_attr = 0x0800dfd0;
    public void module_attr() throws Exception
    {
        call(this.module_attr, this::module_attr);
    }


    // function: Function(address=134275128, size=68, name='mp_obj_new_module', path='build/py/objmodule.o', joint_set={0, 32, 44, 18, 54, 56, 26}, stop_set={58})
    abstract protected void mp_obj_new_module(int offset) throws Exception;
    protected int mp_obj_new_module = 0x0800e038;
    public void mp_obj_new_module() throws Exception
    {
        call(this.mp_obj_new_module, this::mp_obj_new_module);
    }


    // function: Function(address=134275196, size=28, name='mp_module_register', path='build/py/objmodule.o', joint_set={0, 18}, stop_set={20})
    abstract protected void mp_module_register(int offset) throws Exception;
    protected int mp_module_register = 0x0800e07c;
    public void mp_module_register() throws Exception
    {
        call(this.mp_module_register, this::mp_module_register);
    }


    // function: Function(address=134275224, size=42, name='mp_module_call_init', path='build/py/objmodule.o', joint_set={0, 32, 40, 16, 22}, stop_set={40})
    abstract protected void mp_module_call_init(int offset) throws Exception;
    protected int mp_module_call_init = 0x0800e098;
    public void mp_module_call_init() throws Exception
    {
        call(this.mp_module_call_init, this::mp_module_call_init);
    }


    // function: Function(address=134275268, size=60, name='mp_module_get', path='build/py/objmodule.o', joint_set={0, 34, 38, 46, 48, 20, 24}, stop_set={48})
    abstract protected void mp_module_get(int offset) throws Exception;
    protected int mp_module_get = 0x0800e0c4;
    public void mp_module_get() throws Exception
    {
        call(this.mp_module_get, this::mp_module_get);
    }


    // function: Function(address=134275328, size=8, name='object___init__', path='build/py/objobject.o', joint_set={0}, stop_set={2})
    abstract protected void object___init__(int offset) throws Exception;
    protected int object___init__ = 0x0800e100;
    public void object___init__() throws Exception
    {
        call(this.object___init__, this::object___init__);
    }


    // function: Function(address=134275336, size=48, name='object___new__', path='build/py/objobject.o', joint_set={0, 34, 6, 14, 22, 28}, stop_set={24, 34})
    abstract protected void object___new__(int offset) throws Exception;
    protected int object___new__ = 0x0800e108;
    public void object___new__() throws Exception
    {
        call(this.object___new__, this::object___new__);
    }


    // function: Function(address=134275384, size=28, name='object_make_new', path='build/py/objobject.o', joint_set={0, 24, 18}, stop_set={26})
    abstract protected void object_make_new(int offset) throws Exception;
    protected int object_make_new = 0x0800e138;
    public void object_make_new() throws Exception
    {
        call(this.object_make_new, this::object_make_new);
    }


    // function: Function(address=134275412, size=8, name='polymorph_it_iternext', path='build/py/objpolyiter.o', joint_set={0}, stop_set={6})
    abstract protected void polymorph_it_iternext(int offset) throws Exception;
    protected int polymorph_it_iternext = 0x0800e154;
    public void polymorph_it_iternext() throws Exception
    {
        call(this.polymorph_it_iternext, this::polymorph_it_iternext);
    }


    // function: Function(address=134275420, size=22, name='property_deleter', path='build/py/objproperty.o', joint_set={0, 12}, stop_set={20})
    abstract protected void property_deleter(int offset) throws Exception;
    protected int property_deleter = 0x0800e15c;
    public void property_deleter() throws Exception
    {
        call(this.property_deleter, this::property_deleter);
    }


    // function: Function(address=134275442, size=26, name='property_setter', path='build/py/objproperty.o', joint_set={0, 12}, stop_set={24})
    abstract protected void property_setter(int offset) throws Exception;
    protected int property_setter = 0x0800e172;
    public void property_setter() throws Exception
    {
        call(this.property_setter, this::property_setter);
    }


    // function: Function(address=134275468, size=26, name='property_getter', path='build/py/objproperty.o', joint_set={0, 12}, stop_set={24})
    abstract protected void property_getter(int offset) throws Exception;
    protected int property_getter = 0x0800e18c;
    public void property_getter() throws Exception
    {
        call(this.property_getter, this::property_getter);
    }


    // function: Function(address=134275496, size=56, name='property_make_new', path='build/py/objproperty.o', joint_set={0, 26, 32}, stop_set={48})
    abstract protected void property_make_new(int offset) throws Exception;
    protected int property_make_new = 0x0800e1a8;
    public void property_make_new() throws Exception
    {
        call(this.property_make_new, this::property_make_new);
    }


    // function: Function(address=134275552, size=4, name='mp_obj_property_get', path='build/py/objproperty.o', joint_set={0}, stop_set={2})
    abstract protected void mp_obj_property_get(int offset) throws Exception;
    protected int mp_obj_property_get = 0x0800e1e0;
    public void mp_obj_property_get() throws Exception
    {
        call(this.mp_obj_property_get, this::mp_obj_property_get);
    }


    // function: Function(address=134275556, size=24, name='none_print', path='build/py/objnone.o', joint_set={0, 8, 10, 14}, stop_set={14})
    abstract protected void none_print(int offset) throws Exception;
    protected int none_print = 0x0800e1e4;
    public void none_print() throws Exception
    {
        call(this.none_print, this::none_print);
    }


    // function: Function(address=134275580, size=72, name='namedtuple_asdict', path='build/py/objnamedtuple.o', joint_set={0, 64, 34, 40, 44, 16}, stop_set={66, 42})
    abstract protected void namedtuple_asdict(int offset) throws Exception;
    protected int namedtuple_asdict = 0x0800e1fc;
    public void namedtuple_asdict() throws Exception
    {
        call(this.namedtuple_asdict, this::namedtuple_asdict);
    }


    // function: Function(address=134275652, size=36, name='namedtuple_print', path='build/py/objnamedtuple.o', joint_set={0, 16, 28}, stop_set={28})
    abstract protected void namedtuple_print(int offset) throws Exception;
    protected int namedtuple_print = 0x0800e244;
    public void namedtuple_print() throws Exception
    {
        call(this.namedtuple_print, this::namedtuple_print);
    }


    // function: Function(address=134275688, size=32, name='mp_obj_namedtuple_find_field', path='build/py/objnamedtuple.o', joint_set={0, 6, 10, 14, 18, 28}, stop_set={16, 30})
    abstract protected void mp_obj_namedtuple_find_field(int offset) throws Exception;
    protected int mp_obj_namedtuple_find_field = 0x0800e268;
    public void mp_obj_namedtuple_find_field() throws Exception
    {
        call(this.mp_obj_namedtuple_find_field, this::mp_obj_namedtuple_find_field);
    }


    // function: Function(address=134275720, size=64, name='namedtuple_attr', path='build/py/objnamedtuple.o', joint_set={0, 32, 42, 12, 16, 20, 22, 28}, stop_set={40, 20, 46})
    abstract protected void namedtuple_attr(int offset) throws Exception;
    protected int namedtuple_attr = 0x0800e288;
    public void namedtuple_attr() throws Exception
    {
        call(this.namedtuple_attr, this::namedtuple_attr);
    }


    // function: Function(address=134275784, size=176, name='namedtuple_make_new', path='build/py/objnamedtuple.o', joint_set={0, 64, 96, 128, 36, 32, 102, 138, 44, 78, 112, 144, 84, 116, 20, 120, 90, 126}, stop_set={32, 142, 126, 156, 94})
    abstract protected void namedtuple_make_new(int offset) throws Exception;
    protected int namedtuple_make_new = 0x0800e2c8;
    public void namedtuple_make_new() throws Exception
    {
        call(this.namedtuple_make_new, this::namedtuple_make_new);
    }


    // function: Function(address=134275960, size=56, name='mp_obj_new_namedtuple_base', path='build/py/objnamedtuple.o', joint_set={0, 38, 42, 46, 18, 52, 28}, stop_set={44, 54})
    abstract protected void mp_obj_new_namedtuple_base(int offset) throws Exception;
    protected int mp_obj_new_namedtuple_base = 0x0800e378;
    public void mp_obj_new_namedtuple_base() throws Exception
    {
        call(this.mp_obj_new_namedtuple_base, this::mp_obj_new_namedtuple_base);
    }


    // function: Function(address=134276016, size=144, name='new_namedtuple_type', path='build/py/objnamedtuple.o', joint_set={0, 32, 8, 40, 42, 52, 20, 24, 60}, stop_set={100})
    abstract protected void new_namedtuple_type(int offset) throws Exception;
    protected int new_namedtuple_type = 0x0800e3b0;
    public void new_namedtuple_type() throws Exception
    {
        call(this.new_namedtuple_type, this::new_namedtuple_type);
    }


    // function: Function(address=134276160, size=50, name='range_it_iternext', path='build/py/objrange.o', joint_set={0, 36, 10, 18, 20, 22, 28}, stop_set={48, 20})
    abstract protected void range_it_iternext(int offset) throws Exception;
    protected int range_it_iternext = 0x0800e440;
    public void range_it_iternext() throws Exception
    {
        call(this.range_it_iternext, this::range_it_iternext);
    }


    // function: Function(address=134276210, size=32, name='range_len', path='build/py/objrange.o', joint_set={0, 24, 18, 20}, stop_set={30})
    abstract protected void range_len(int offset) throws Exception;
    protected int range_len = 0x0800e472;
    public void range_len() throws Exception
    {
        call(this.range_len, this::range_len);
    }


    // function: Function(address=134276244, size=52, name='range_unary_op', path='build/py/objrange.o', joint_set={0, 32, 34, 10, 16, 20, 24, 30}, stop_set={32, 40, 22})
    abstract protected void range_unary_op(int offset) throws Exception;
    protected int range_unary_op = 0x0800e494;
    public void range_unary_op() throws Exception
    {
        call(this.range_unary_op, this::range_unary_op);
    }


    // function: Function(address=134276296, size=24, name='range_getiter', path='build/py/objrange.o', joint_set={0}, stop_set={18})
    abstract protected void range_getiter(int offset) throws Exception;
    protected int range_getiter = 0x0800e4c8;
    public void range_getiter() throws Exception
    {
        call(this.range_getiter, this::range_getiter);
    }


    // function: Function(address=134276320, size=132, name='range_subscr', path='build/py/objrange.o', joint_set={0, 32, 40, 106, 14, 46, 20, 84, 24, 90, 94}, stop_set={120, 92})
    abstract protected void range_subscr(int offset) throws Exception;
    protected int range_subscr = 0x0800e4e0;
    public void range_subscr() throws Exception
    {
        call(this.range_subscr, this::range_subscr);
    }


    // function: Function(address=134276452, size=104, name='range_make_new', path='build/py/objrange.o', joint_set={0, 32, 66, 74, 80, 50, 86, 54, 56, 26, 92, 62}, stop_set={60, 94})
    abstract protected void range_make_new(int offset) throws Exception;
    protected int range_make_new = 0x0800e564;
    public void range_make_new() throws Exception
    {
        call(this.range_make_new, this::range_make_new);
    }


    // function: Function(address=134276556, size=56, name='range_print', path='build/py/objrange.o', joint_set={0, 32, 40, 16, 22, 30}, stop_set={40, 30})
    abstract protected void range_print(int offset) throws Exception;
    protected int range_print = 0x0800e5cc;
    public void range_print() throws Exception
    {
        call(this.range_print, this::range_print);
    }


    // function: Function(address=134276612, size=96, name='range_binary_op', path='build/py/objrange.o', joint_set={0, 66, 36, 70, 44, 78, 16, 80, 50, 56, 26, 30}, stop_set={82})
    abstract protected void range_binary_op(int offset) throws Exception;
    protected int range_binary_op = 0x0800e604;
    public void range_binary_op() throws Exception
    {
        call(this.range_binary_op, this::range_binary_op);
    }


    // function: Function(address=134276708, size=52, name='range_attr', path='build/py/objrange.o', joint_set={0, 36, 40, 10, 48, 18, 20, 24, 26, 28}, stop_set={26, 50, 38})
    abstract protected void range_attr(int offset) throws Exception;
    protected int range_attr = 0x0800e664;
    public void range_attr() throws Exception
    {
        call(this.range_attr, this::range_attr);
    }


    // function: Function(address=134276760, size=30, name='reversed_iternext', path='build/py/objreversed.o', joint_set={0, 10, 28}, stop_set={28})
    abstract protected void reversed_iternext(int offset) throws Exception;
    protected int reversed_iternext = 0x0800e698;
    public void reversed_iternext() throws Exception
    {
        call(this.reversed_iternext, this::reversed_iternext);
    }


    // function: Function(address=134276790, size=84, name='reversed_make_new', path='build/py/objreversed.o', joint_set={0, 32, 38, 76, 80, 48, 50, 22, 56, 62}, stop_set={82, 54})
    abstract protected void reversed_make_new(int offset) throws Exception;
    protected int reversed_make_new = 0x0800e6b6;
    public void reversed_make_new() throws Exception
    {
        call(this.reversed_make_new, this::reversed_make_new);
    }


    // function: Function(address=134276876, size=36, name='is_set_or_frozenset', path='build/py/objset.o', joint_set={0, 24, 6, 16}, stop_set={26})
    abstract protected void is_set_or_frozenset(int offset) throws Exception;
    protected int is_set_or_frozenset = 0x0800e70c;
    public void is_set_or_frozenset() throws Exception
    {
        call(this.is_set_or_frozenset, this::is_set_or_frozenset);
    }


    // function: Function(address=134276912, size=28, name='set_getiter', path='build/py/objset.o', joint_set={0}, stop_set={16})
    abstract protected void set_getiter(int offset) throws Exception;
    protected int set_getiter = 0x0800e730;
    public void set_getiter() throws Exception
    {
        call(this.set_getiter, this::set_getiter);
    }


    // function: Function(address=134276940, size=20, name='text_set_add', path='build/py/objset.o', joint_set={0, 10}, stop_set={12})
    abstract protected void text_set_add(int offset) throws Exception;
    protected int text_set_add = 0x0800e74c;
    public void text_set_add() throws Exception
    {
        call(this.text_set_add, this::text_set_add);
    }


    // function: Function(address=134276960, size=20, name='set_discard', path='build/py/objset.o', joint_set={0, 10}, stop_set={12})
    abstract protected void set_discard(int offset) throws Exception;
    protected int set_discard = 0x0800e760;
    public void set_discard() throws Exception
    {
        call(this.set_discard, this::set_discard);
    }


    // function: Function(address=134276980, size=38, name='set_update_int', path='build/py/objset.o', joint_set={0, 36, 12, 14, 20, 24, 26}, stop_set={24, 36})
    abstract protected void set_update_int(int offset) throws Exception;
    protected int set_update_int = 0x0800e774;
    public void set_update_int() throws Exception
    {
        call(this.set_update_int, this::set_update_int);
    }


    // function: Function(address=134277020, size=36, name='set_update', path='build/py/objset.o', joint_set={0, 8, 12, 16, 26}, stop_set={28, 14})
    abstract protected void set_update(int offset) throws Exception;
    protected int set_update = 0x0800e79c;
    public void set_update() throws Exception
    {
        call(this.set_update, this::set_update);
    }


    // function: Function(address=134277056, size=44, name='set_symmetric_difference_update', path='build/py/objset.o', joint_set={0, 38, 12, 14, 20, 24, 28}, stop_set={26, 38})
    abstract protected void set_symmetric_difference_update(int offset) throws Exception;
    protected int set_symmetric_difference_update = 0x0800e7c0;
    public void set_symmetric_difference_update() throws Exception
    {
        call(this.set_symmetric_difference_update, this::set_symmetric_difference_update);
    }


    // function: Function(address=134277100, size=60, name='set_isdisjoint', path='build/py/objset.o', joint_set={0, 32, 42, 14, 46, 16, 22, 26, 28}, stop_set={48, 30})
    abstract protected void set_isdisjoint(int offset) throws Exception;
    protected int set_isdisjoint = 0x0800e7ec;
    public void set_isdisjoint() throws Exception
    {
        call(this.set_isdisjoint, this::set_isdisjoint);
    }


    // function: Function(address=134277160, size=42, name='set_copy', path='build/py/objset.o', joint_set={0, 38, 10, 22}, stop_set={40})
    abstract protected void set_copy(int offset) throws Exception;
    protected int set_copy = 0x0800e828;
    public void set_copy() throws Exception
    {
        call(this.set_copy, this::set_copy);
    }


    // function: Function(address=134277202, size=20, name='set_union', path='build/py/objset.o', joint_set={0, 8, 16}, stop_set={18})
    abstract protected void set_union(int offset) throws Exception;
    protected int set_union = 0x0800e852;
    public void set_union() throws Exception
    {
        call(this.set_union, this::set_union);
    }


    // function: Function(address=134277222, size=20, name='set_symmetric_difference', path='build/py/objset.o', joint_set={0, 8, 16}, stop_set={18})
    abstract protected void set_symmetric_difference(int offset) throws Exception;
    protected int set_symmetric_difference = 0x0800e866;
    public void set_symmetric_difference() throws Exception
    {
        call(this.set_symmetric_difference, this::set_symmetric_difference);
    }


    // function: Function(address=134277244, size=16, name='set_clear', path='build/py/objset.o', joint_set={0, 8}, stop_set={10})
    abstract protected void set_clear(int offset) throws Exception;
    protected int set_clear = 0x0800e87c;
    public void set_clear() throws Exception
    {
        call(this.set_clear, this::set_clear);
    }


    // function: Function(address=134277260, size=80, name='set_diff_int', path='build/py/objset.o', joint_set={0, 32, 66, 70, 42, 12, 28, 78, 48, 18, 20, 52, 22, 58, 60}, stop_set={50, 78, 30})
    abstract protected void set_diff_int(int offset) throws Exception;
    protected int set_diff_int = 0x0800e88c;
    public void set_diff_int() throws Exception
    {
        call(this.set_diff_int, this::set_diff_int);
    }


    // function: Function(address=134277340, size=16, name='set_diff_update', path='build/py/objset.o', joint_set={0, 8}, stop_set={10})
    abstract protected void set_diff_update(int offset) throws Exception;
    protected int set_diff_update = 0x0800e8dc;
    public void set_diff_update() throws Exception
    {
        call(this.set_diff_update, this::set_diff_update);
    }


    // function: Function(address=134277356, size=10, name='set_diff', path='build/py/objset.o', joint_set={0, 8}, stop_set={8})
    abstract protected void set_diff(int offset) throws Exception;
    protected int set_diff = 0x0800e8ec;
    public void set_diff() throws Exception
    {
        call(this.set_diff, this::set_diff);
    }


    // function: Function(address=134277368, size=180, name='set_print', path='build/py/objset.o', joint_set={0, 140, 12, 142, 22, 28, 32, 40, 42, 48, 50, 54, 62, 70, 74, 80, 88, 92, 96, 110, 114, 118, 126}, stop_set={144, 48, 94})
    abstract protected void set_print(int offset) throws Exception;
    protected int set_print = 0x0800e8f8;
    public void set_print() throws Exception
    {
        call(this.set_print, this::set_print);
    }


    // function: Function(address=134277548, size=40, name='set_remove', path='build/py/objset.o', joint_set={0, 12, 16, 24, 28}, stop_set={24, 30})
    abstract protected void set_remove(int offset) throws Exception;
    protected int set_remove = 0x0800e9ac;
    public void set_remove() throws Exception
    {
        call(this.set_remove, this::set_remove);
    }


    // function: Function(address=134277588, size=32, name='text_set_pop', path='build/py/objset.o', joint_set={0, 8, 20, 12}, stop_set={16, 20})
    abstract protected void text_set_pop(int offset) throws Exception;
    protected int text_set_pop = 0x0800e9d4;
    public void text_set_pop() throws Exception
    {
        call(this.text_set_pop, this::text_set_pop);
    }


    // function: Function(address=134277620, size=42, name='set_it_iternext', path='build/py/objset.o', joint_set={0, 32, 34, 38, 10, 14, 18, 28}, stop_set={40, 16, 36})
    abstract protected void set_it_iternext(int offset) throws Exception;
    protected int set_it_iternext = 0x0800e9f4;
    public void set_it_iternext() throws Exception
    {
        call(this.set_it_iternext, this::set_it_iternext);
    }


    // function: Function(address=134277664, size=116, name='set_unary_op', path='build/py/objset.o', joint_set={0, 96, 64, 58, 100, 38, 8, 72, 12, 60, 92, 48, 16, 82, 86, 24, 26, 28}, stop_set={98, 36, 70, 102, 26})
    abstract protected void set_unary_op(int offset) throws Exception;
    protected int set_unary_op = 0x0800ea20;
    public void set_unary_op() throws Exception
    {
        call(this.set_unary_op, this::set_unary_op);
    }


    // function: Function(address=134277780, size=56, name='mp_obj_new_set', path='build/py/objset.o', joint_set={0, 32, 36, 40, 12, 50, 28}, stop_set={50, 38})
    abstract protected void mp_obj_new_set(int offset) throws Exception;
    protected int mp_obj_new_set = 0x0800ea94;
    public void mp_obj_new_set() throws Exception
    {
        call(this.mp_obj_new_set, this::mp_obj_new_set);
    }


    // function: Function(address=134277836, size=100, name='set_intersect_int_part_4', path='build/py/objset.o', joint_set={0, 34, 68, 38, 72, 44, 16, 82, 86, 54, 26, 28, 94}, stop_set={70, 94})
    abstract protected void set_intersect_int_part_4(int offset) throws Exception;
    protected int set_intersect_int_part_4 = 0x0800eacc;
    public void set_intersect_int_part_4() throws Exception
    {
        call(this.set_intersect_int_part_4, this::set_intersect_int_part_4);
    }


    // function: Function(address=134277936, size=24, name='set_intersect_update', path='build/py/objset.o', joint_set={0, 16, 8, 14}, stop_set={18})
    abstract protected void set_intersect_update(int offset) throws Exception;
    protected int set_intersect_update = 0x0800eb30;
    public void set_intersect_update() throws Exception
    {
        call(this.set_intersect_update, this::set_intersect_update);
    }


    // function: Function(address=134277960, size=20, name='set_intersect', path='build/py/objset.o', joint_set={0, 6, 10, 12, 18}, stop_set={10, 18})
    abstract protected void set_intersect(int offset) throws Exception;
    protected int set_intersect = 0x0800eb48;
    public void set_intersect() throws Exception
    {
        call(this.set_intersect, this::set_intersect);
    }


    // function: Function(address=134277980, size=12, name='mp_obj_set_store', path='build/py/objset.o', joint_set={0, 10}, stop_set={10})
    abstract protected void mp_obj_set_store(int offset) throws Exception;
    protected int mp_obj_set_store = 0x0800eb5c;
    public void mp_obj_set_store() throws Exception
    {
        call(this.mp_obj_set_store, this::mp_obj_set_store);
    }


    // function: Function(address=134277992, size=82, name='set_make_new', path='build/py/objset.o', joint_set={0, 64, 36, 70, 38, 74, 44, 80, 52, 24, 28, 62}, stop_set={80, 42})
    abstract protected void set_make_new(int offset) throws Exception;
    protected int set_make_new = 0x0800eb68;
    public void set_make_new() throws Exception
    {
        call(this.set_make_new, this::set_make_new);
    }


    // function: Function(address=134278076, size=180, name='set_issubset_internal', path='build/py/objset.o', joint_set={0, 128, 134, 140, 18, 150, 22, 154, 34, 38, 48, 52, 64, 68, 74, 86, 100, 106, 110, 112, 114, 118, 124}, stop_set={138, 156})
    abstract protected void set_issubset_internal(int offset) throws Exception;
    protected int set_issubset_internal = 0x0800ebbc;
    public void set_issubset_internal() throws Exception
    {
        call(this.set_issubset_internal, this::set_issubset_internal);
    }


    // function: Function(address=134278256, size=16, name='set_issuperset', path='build/py/objset.o', joint_set={0, 14}, stop_set={14})
    abstract protected void set_issuperset(int offset) throws Exception;
    protected int set_issuperset = 0x0800ec70;
    public void set_issuperset() throws Exception
    {
        call(this.set_issuperset, this::set_issuperset);
    }


    // function: Function(address=134278272, size=10, name='set_issubset', path='build/py/objset.o', joint_set={0, 8}, stop_set={8})
    abstract protected void set_issubset(int offset) throws Exception;
    protected int set_issubset = 0x0800ec80;
    public void set_issubset() throws Exception
    {
        call(this.set_issubset, this::set_issubset);
    }


    // function: Function(address=134278284, size=300, name='set_binary_op', path='build/py/objset.o', joint_set={0, 128, 130, 256, 258, 134, 266, 268, 142, 144, 18, 148, 278, 152, 154, 28, 284, 32, 162, 34, 166, 40, 44, 174, 176, 54, 184, 56, 188, 60, 190, 62, 194, 66, 70, 198, 74, 204, 206, 78, 80, 84, 214, 88, 218, 220, 96, 226, 100, 230, 104, 232, 106, 110, 240, 114, 248, 122, 124}, stop_set={256, 32, 98, 164, 122, 230, 72, 266, 204, 174, 142, 238, 152, 218, 188, 286})
    abstract protected void set_binary_op(int offset) throws Exception;
    protected int set_binary_op = 0x0800ec8c;
    public void set_binary_op() throws Exception
    {
        call(this.set_binary_op, this::set_binary_op);
    }


    // function: Function(address=134278584, size=16, name='singleton_print', path='build/py/objsingleton.o', joint_set={0, 10}, stop_set={10})
    abstract protected void singleton_print(int offset) throws Exception;
    protected int singleton_print = 0x0800edb8;
    public void singleton_print() throws Exception
    {
        call(this.singleton_print, this::singleton_print);
    }


    // function: Function(address=134278600, size=84, name='slice_print', path='build/py/objslice.o', joint_set={0, 32, 68, 42, 12, 50, 22, 60}, stop_set={68})
    abstract protected void slice_print(int offset) throws Exception;
    protected int slice_print = 0x0800edc8;
    public void slice_print() throws Exception
    {
        call(this.slice_print, this::slice_print);
    }


    // function: Function(address=134278684, size=44, name='slice_attr', path='build/py/objslice.o', joint_set={0, 32, 6, 40, 14, 16, 18, 20, 28}, stop_set={18, 42, 30})
    abstract protected void slice_attr(int offset) throws Exception;
    protected int slice_attr = 0x0800ee1c;
    public void slice_attr() throws Exception
    {
        call(this.slice_attr, this::slice_attr);
    }


    // function: Function(address=134278728, size=32, name='mp_obj_new_slice', path='build/py/objslice.o', joint_set={0, 14}, stop_set={24})
    abstract protected void mp_obj_new_slice(int offset) throws Exception;
    protected int mp_obj_new_slice = 0x0800ee48;
    public void mp_obj_new_slice() throws Exception
    {
        call(this.mp_obj_new_slice, this::mp_obj_new_slice);
    }


    // function: Function(address=134278760, size=16, name='mp_obj_slice_get', path='build/py/objslice.o', joint_set={0}, stop_set={14})
    abstract protected void mp_obj_slice_get(int offset) throws Exception;
    protected int mp_obj_slice_get = 0x0800ee68;
    public void mp_obj_slice_get() throws Exception
    {
        call(this.mp_obj_slice_get, this::mp_obj_slice_get);
    }


    // function: Function(address=134278776, size=56, name='arg_looks_integer', path='build/py/objstr.o', joint_set={0, 32, 42, 12, 22, 28}, stop_set={44})
    abstract protected void arg_looks_integer(int offset) throws Exception;
    protected int arg_looks_integer = 0x0800ee78;
    public void arg_looks_integer() throws Exception
    {
        call(this.arg_looks_integer, this::arg_looks_integer);
    }


    // function: Function(address=134278832, size=40, name='arg_looks_numeric', path='build/py/objstr.o', joint_set={0, 8, 14, 20, 30}, stop_set={32})
    abstract protected void arg_looks_numeric(int offset) throws Exception;
    protected int arg_looks_numeric = 0x0800eeb0;
    public void arg_looks_numeric() throws Exception
    {
        call(this.arg_looks_numeric, this::arg_looks_numeric);
    }


    // function: Function(address=134278872, size=28, name='mp_obj_new_bytes_iterator', path='build/py/objstr.o', joint_set={0}, stop_set={16})
    abstract protected void mp_obj_new_bytes_iterator(int offset) throws Exception;
    protected int mp_obj_new_bytes_iterator = 0x0800eed8;
    public void mp_obj_new_bytes_iterator() throws Exception
    {
        call(this.mp_obj_new_bytes_iterator, this::mp_obj_new_bytes_iterator);
    }


    // function: Function(address=134278900, size=56, name='bytes_it_iternext', path='build/py/objstr.o', joint_set={0, 34, 46, 14, 48, 22, 24}, stop_set={54, 46})
    abstract protected void bytes_it_iternext(int offset) throws Exception;
    protected int bytes_it_iternext = 0x0800eef4;
    public void bytes_it_iternext() throws Exception
    {
        call(this.bytes_it_iternext, this::bytes_it_iternext);
    }


    // function: Function(address=134278956, size=40, name='unlikely_bad_implicit_conversion', path='build/py/objstr.o', joint_set={0, 6, 18, 20, 28}, stop_set={28})
    abstract protected void unlikely_bad_implicit_conversion(int offset) throws Exception;
    protected int unlikely_bad_implicit_conversion = 0x0800ef2c;
    public void unlikely_bad_implicit_conversion() throws Exception
    {
        call(this.unlikely_bad_implicit_conversion, this::unlikely_bad_implicit_conversion);
    }


    // function: Function(address=134278996, size=232, name='str_count', path='build/py/objstr.o', joint_set={0, 138, 140, 14, 148, 22, 28, 158, 34, 162, 170, 44, 178, 52, 54, 188, 64, 196, 200, 72, 74, 202, 204, 214, 88, 218, 224, 96, 108, 110, 116, 124}, stop_set={226, 168, 176, 216, 186})
    abstract protected void str_count(int offset) throws Exception;
    protected int str_count = 0x0800ef54;
    public void str_count() throws Exception
    {
        call(this.str_count, this::str_count);
    }


    // function: Function(address=134279228, size=132, name='str_uni_istype', path='build/py/objstr.o', joint_set={0, 12, 20, 22, 28, 30, 32, 40, 48, 50, 58, 62, 64, 70, 78, 82, 92, 94, 100, 104, 112}, stop_set={38, 80, 114, 30, 92, 62})
    abstract protected void str_uni_istype(int offset) throws Exception;
    protected int str_uni_istype = 0x0800f03c;
    public void str_uni_istype() throws Exception
    {
        call(this.str_uni_istype, this::str_uni_istype);
    }


    // function: Function(address=134279360, size=16, name='str_isspace', path='build/py/objstr.o', joint_set={0, 10}, stop_set={10})
    abstract protected void str_isspace(int offset) throws Exception;
    protected int str_isspace = 0x0800f0c0;
    public void str_isspace() throws Exception
    {
        call(this.str_isspace, this::str_isspace);
    }


    // function: Function(address=134279376, size=16, name='str_isalpha', path='build/py/objstr.o', joint_set={0, 10}, stop_set={10})
    abstract protected void str_isalpha(int offset) throws Exception;
    protected int str_isalpha = 0x0800f0d0;
    public void str_isalpha() throws Exception
    {
        call(this.str_isalpha, this::str_isalpha);
    }


    // function: Function(address=134279392, size=16, name='str_isdigit', path='build/py/objstr.o', joint_set={0, 10}, stop_set={10})
    abstract protected void str_isdigit(int offset) throws Exception;
    protected int str_isdigit = 0x0800f0e0;
    public void str_isdigit() throws Exception
    {
        call(this.str_isdigit, this::str_isdigit);
    }


    // function: Function(address=134279408, size=16, name='str_isupper', path='build/py/objstr.o', joint_set={0, 10}, stop_set={10})
    abstract protected void str_isupper(int offset) throws Exception;
    protected int str_isupper = 0x0800f0f0;
    public void str_isupper() throws Exception
    {
        call(this.str_isupper, this::str_isupper);
    }


    // function: Function(address=134279424, size=16, name='str_islower', path='build/py/objstr.o', joint_set={0, 10}, stop_set={10})
    abstract protected void str_islower(int offset) throws Exception;
    protected int str_islower = 0x0800f100;
    public void str_islower() throws Exception
    {
        call(this.str_islower, this::str_islower);
    }


    // function: Function(address=134279440, size=48, name='str_to_int', path='build/py/objstr.o', joint_set={0, 38, 6, 14, 46, 20}, stop_set={46})
    abstract protected void str_to_int(int offset) throws Exception;
    protected int str_to_int = 0x0800f110;
    public void str_to_int() throws Exception
    {
        call(this.str_to_int, this::str_to_int);
    }


    // function: Function(address=134279488, size=60, name='mp_obj_str_get_buffer', path='build/py/objstr.o', joint_set={0, 36, 38, 8, 46, 16, 24}, stop_set={58, 36, 44})
    abstract protected void mp_obj_str_get_buffer(int offset) throws Exception;
    protected int mp_obj_str_get_buffer = 0x0800f140;
    public void mp_obj_str_get_buffer() throws Exception
    {
        call(this.mp_obj_str_get_buffer, this::mp_obj_str_get_buffer);
    }


    // function: Function(address=134279548, size=200, name='mp_str_print_quoted', path='build/py/objstr.o', joint_set={0, 130, 136, 140, 18, 146, 152, 24, 156, 158, 30, 32, 164, 168, 44, 50, 60, 62, 68, 76, 82, 86, 92, 98, 102, 108, 110, 116, 120, 124}, stop_set={166, 170, 138, 108, 84, 90, 60})
    abstract protected void mp_str_print_quoted(int offset) throws Exception;
    protected int mp_str_print_quoted = 0x0800f17c;
    public void mp_str_print_quoted() throws Exception
    {
        call(this.mp_str_print_quoted, this::mp_str_print_quoted);
    }


    // function: Function(address=134279748, size=116, name='mp_str_print_json', path='build/py/objstr.o', joint_set={0, 32, 64, 38, 70, 42, 44, 76, 78, 16, 50, 18, 84, 52, 22, 58, 30}, stop_set={50, 86, 30})
    abstract protected void mp_str_print_json(int offset) throws Exception;
    protected int mp_str_print_json = 0x0800f244;
    public void mp_str_print_json() throws Exception
    {
        call(this.mp_str_print_json, this::mp_str_print_json);
    }


    // function: Function(address=134279864, size=96, name='str_print', path='build/py/objstr.o', joint_set={0, 64, 66, 38, 40, 74, 14, 48, 52, 86, 22, 24, 28}, stop_set={64, 86, 38, 46})
    abstract protected void str_print(int offset) throws Exception;
    protected int str_print = 0x0800f2b8;
    public void str_print() throws Exception
    {
        call(this.str_print, this::str_print);
    }


    // function: Function(address=134279960, size=62, name='find_subbytes', path='build/py/objstr.o', joint_set={0, 42, 14, 46, 50, 56, 24, 58, 28}, stop_set={60, 54})
    abstract protected void find_subbytes(int offset) throws Exception;
    protected int find_subbytes = 0x0800f318;
    public void find_subbytes() throws Exception
    {
        call(this.find_subbytes, this::find_subbytes);
    }


    // function: Function(address=134280024, size=248, name='str_finder', path='build/py/objstr.o', joint_set={0, 128, 142, 144, 18, 150, 26, 32, 38, 166, 170, 48, 180, 56, 58, 186, 194, 68, 204, 76, 78, 210, 218, 92, 220, 224, 228, 100, 112, 114, 120}, stop_set={192, 226, 232, 202, 182})
    abstract protected void str_finder(int offset) throws Exception;
    protected int str_finder = 0x0800f358;
    public void str_finder() throws Exception
    {
        call(this.str_finder, this::str_finder);
    }


    // function: Function(address=134280272, size=12, name='str_find', path='build/py/objstr.o', joint_set={0, 10}, stop_set={10})
    abstract protected void str_find(int offset) throws Exception;
    protected int str_find = 0x0800f450;
    public void str_find() throws Exception
    {
        call(this.str_find, this::str_find);
    }


    // function: Function(address=134280284, size=14, name='str_rfind', path='build/py/objstr.o', joint_set={0, 12}, stop_set={12})
    abstract protected void str_rfind(int offset) throws Exception;
    protected int str_rfind = 0x0800f45c;
    public void str_rfind() throws Exception
    {
        call(this.str_rfind, this::str_rfind);
    }


    // function: Function(address=134280298, size=12, name='str_index', path='build/py/objstr.o', joint_set={0, 10}, stop_set={10})
    abstract protected void str_index(int offset) throws Exception;
    protected int str_index = 0x0800f46a;
    public void str_index() throws Exception
    {
        call(this.str_index, this::str_index);
    }


    // function: Function(address=134280310, size=14, name='str_rindex', path='build/py/objstr.o', joint_set={0, 12}, stop_set={12})
    abstract protected void str_rindex(int offset) throws Exception;
    protected int str_rindex = 0x0800f476;
    public void str_rindex() throws Exception
    {
        call(this.str_rindex, this::str_rindex);
    }


    // function: Function(address=134280324, size=60, name='mp_obj_new_str_copy', path='build/py/objstr.o', joint_set={0, 32, 40, 14, 52, 24, 56}, stop_set={58})
    abstract protected void mp_obj_new_str_copy(int offset) throws Exception;
    protected int mp_obj_new_str_copy = 0x0800f484;
    public void mp_obj_new_str_copy() throws Exception
    {
        call(this.mp_obj_new_str_copy, this::mp_obj_new_str_copy);
    }


    // function: Function(address=134280384, size=14, name='mp_obj_new_str_via_qstr', path='build/py/objstr.o', joint_set={0, 6}, stop_set={12})
    abstract protected void mp_obj_new_str_via_qstr(int offset) throws Exception;
    protected int mp_obj_new_str_via_qstr = 0x0800f4c0;
    public void mp_obj_new_str_via_qstr() throws Exception
    {
        call(this.mp_obj_new_str_via_qstr, this::mp_obj_new_str_via_qstr);
    }


    // function: Function(address=134280400, size=108, name='mp_obj_new_str_from_vstr', path='build/py/objstr.o', joint_set={0, 64, 100, 40, 44, 76, 12, 80, 50, 20, 30, 24, 94}, stop_set={42, 92, 102})
    abstract protected void mp_obj_new_str_from_vstr(int offset) throws Exception;
    protected int mp_obj_new_str_from_vstr = 0x0800f4d0;
    public void mp_obj_new_str_from_vstr() throws Exception
    {
        call(this.mp_obj_new_str_from_vstr, this::mp_obj_new_str_from_vstr);
    }


    // function: Function(address=134280508, size=268, name='str_join', path='build/py/objstr.o', joint_set={0, 12, 140, 144, 150, 22, 154, 158, 30, 32, 40, 172, 46, 178, 52, 184, 188, 192, 68, 202, 206, 80, 82, 88, 220, 98, 100, 228, 230, 106, 238, 114, 118, 246, 126}, stop_set={124, 146, 244, 116, 182, 186, 252})
    abstract protected void str_join(int offset) throws Exception;
    protected int str_join = 0x0800f53c;
    public void str_join() throws Exception
    {
        call(this.str_join, this::str_join);
    }


    // function: Function(address=134280776, size=106, name='str_center', path='build/py/objstr.o', joint_set={0, 32, 98, 58, 90, 40, 78, 48, 16, 84, 24, 26, 92}, stop_set={96, 104})
    abstract protected void str_center(int offset) throws Exception;
    protected int str_center = 0x0800f648;
    public void str_center() throws Exception
    {
        call(this.str_center, this::str_center);
    }


    // function: Function(address=134280882, size=390, name='str_replace', path='build/py/objstr.o', joint_set={0, 130, 388, 262, 138, 10, 140, 16, 20, 150, 22, 26, 158, 32, 162, 292, 38, 44, 300, 172, 304, 52, 180, 184, 58, 60, 64, 194, 324, 70, 330, 204, 76, 334, 80, 214, 346, 90, 354, 98, 100, 360, 232, 362, 110, 368, 372, 244, 252, 118, 120, 380}, stop_set={192, 388, 360, 202, 78, 370, 212, 182, 24, 378})
    abstract protected void str_replace(int offset) throws Exception;
    protected int str_replace = 0x0800f6b2;
    public void str_replace() throws Exception
    {
        call(this.str_replace, this::str_replace);
    }


    // function: Function(address=134281272, size=82, name='str_caseconv', path='build/py/objstr.o', joint_set={0, 36, 58, 70, 40, 46, 16, 52, 24, 26, 62}, stop_set={80, 60, 68})
    abstract protected void str_caseconv(int offset) throws Exception;
    protected int str_caseconv = 0x0800f838;
    public void str_caseconv() throws Exception
    {
        call(this.str_caseconv, this::str_caseconv);
    }


    // function: Function(address=134281356, size=16, name='str_lower', path='build/py/objstr.o', joint_set={0, 10}, stop_set={10})
    abstract protected void str_lower(int offset) throws Exception;
    protected int str_lower = 0x0800f88c;
    public void str_lower() throws Exception
    {
        call(this.str_lower, this::str_lower);
    }


    // function: Function(address=134281372, size=16, name='str_upper', path='build/py/objstr.o', joint_set={0, 10}, stop_set={10})
    abstract protected void str_upper(int offset) throws Exception;
    protected int str_upper = 0x0800f89c;
    public void str_upper() throws Exception
    {
        call(this.str_upper, this::str_upper);
    }


    // function: Function(address=134281388, size=40, name='mp_obj_new_str', path='build/py/objstr.o', joint_set={0, 32, 10, 14, 20, 22}, stop_set={32, 20})
    abstract protected void mp_obj_new_str(int offset) throws Exception;
    protected int mp_obj_new_str = 0x0800f8ac;
    public void mp_obj_new_str() throws Exception
    {
        call(this.mp_obj_new_str, this::mp_obj_new_str);
    }


    // function: Function(address=134281428, size=204, name='mp_obj_str_make_new', path='build/py/objstr.o', joint_set={0, 134, 138, 16, 146, 20, 152, 32, 162, 36, 40, 170, 178, 50, 182, 60, 190, 192, 68, 72, 78, 86, 96, 104, 106, 114, 118, 126}, stop_set={160, 194, 70, 144, 122, 190})
    abstract protected void mp_obj_str_make_new(int offset) throws Exception;
    protected int mp_obj_str_make_new = 0x0800f8d4;
    public void mp_obj_str_make_new() throws Exception
    {
        call(this.mp_obj_str_make_new, this::mp_obj_str_make_new);
    }


    // function: Function(address=134281632, size=40, name='bytes_decode', path='build/py/objstr.o', joint_set={0, 8, 32, 22}, stop_set={32})
    abstract protected void bytes_decode(int offset) throws Exception;
    protected int bytes_decode = 0x0800f9a0;
    public void bytes_decode() throws Exception
    {
        call(this.bytes_decode, this::bytes_decode);
    }


    // function: Function(address=134281672, size=20, name='mp_obj_new_bytes', path='build/py/objstr.o', joint_set={0, 12}, stop_set={12})
    abstract protected void mp_obj_new_bytes(int offset) throws Exception;
    protected int mp_obj_new_bytes = 0x0800f9c8;
    public void mp_obj_new_bytes() throws Exception
    {
        call(this.mp_obj_new_bytes, this::mp_obj_new_bytes);
    }


    // function: Function(address=134281692, size=280, name='bytes_make_new_part_4', path='build/py/objstr.o', joint_set={0, 256, 128, 136, 144, 18, 22, 30, 158, 160, 36, 38, 166, 168, 42, 174, 50, 178, 52, 186, 188, 62, 194, 68, 70, 200, 74, 202, 208, 82, 84, 216, 218, 92, 224, 228, 102, 232, 106, 236, 240, 114, 242, 118, 246, 122, 254}, stop_set={258, 36, 166, 230, 104, 112, 242, 116, 186, 254})
    abstract protected void bytes_make_new_part_4(int offset) throws Exception;
    protected int bytes_make_new_part_4 = 0x0800f9dc;
    public void bytes_make_new_part_4() throws Exception
    {
        call(this.bytes_make_new_part_4, this::bytes_make_new_part_4);
    }


    // function: Function(address=134281972, size=32, name='bytes_make_new', path='build/py/objstr.o', joint_set={0, 8, 12, 18, 26}, stop_set={26})
    abstract protected void bytes_make_new(int offset) throws Exception;
    protected int bytes_make_new = 0x0800faf4;
    public void bytes_make_new() throws Exception
    {
        call(this.bytes_make_new, this::bytes_make_new);
    }


    // function: Function(address=134282004, size=44, name='str_encode', path='build/py/objstr.o', joint_set={0, 32, 38, 8, 24, 30}, stop_set={38, 30})
    abstract protected void str_encode(int offset) throws Exception;
    protected int str_encode = 0x0800fb14;
    public void str_encode() throws Exception
    {
        call(this.str_encode, this::str_encode);
    }


    // function: Function(address=134282048, size=32, name='mp_obj_new_str_of_type', path='build/py/objstr.o', joint_set={0, 14, 18, 20, 24}, stop_set={24, 18})
    abstract protected void mp_obj_new_str_of_type(int offset) throws Exception;
    protected int mp_obj_new_str_of_type = 0x0800fb40;
    public void mp_obj_new_str_of_type() throws Exception
    {
        call(this.mp_obj_new_str_of_type, this::mp_obj_new_str_of_type);
    }


    // function: Function(address=134282080, size=160, name='str_splitlines', path='build/py/objstr.o', joint_set={0, 134, 138, 146, 150, 24, 30, 40, 52, 60, 62, 68, 74, 80, 88, 90, 96, 100, 110, 118, 120, 126}, stop_set={136, 78, 148, 86, 152})
    abstract protected void str_splitlines(int offset) throws Exception;
    protected int str_splitlines = 0x0800fb60;
    public void str_splitlines() throws Exception
    {
        call(this.str_splitlines, this::str_splitlines);
    }


    // function: Function(address=134282240, size=292, name='str_uni_strip', path='build/py/objstr.o', joint_set={0, 258, 262, 136, 266, 138, 142, 16, 276, 22, 152, 28, 162, 34, 40, 172, 50, 180, 58, 60, 64, 196, 200, 74, 206, 82, 84, 212, 218, 94, 228, 104, 232, 240, 114, 246, 120, 126}, stop_set={256, 160, 260, 230, 264, 170, 140, 178, 276, 150})
    abstract protected void str_uni_strip(int offset) throws Exception;
    protected int str_uni_strip = 0x0800fc00;
    public void str_uni_strip() throws Exception
    {
        call(this.str_uni_strip, this::str_uni_strip);
    }


    // function: Function(address=134282532, size=14, name='str_strip', path='build/py/objstr.o', joint_set={0, 12}, stop_set={12})
    abstract protected void str_strip(int offset) throws Exception;
    protected int str_strip = 0x0800fd24;
    public void str_strip() throws Exception
    {
        call(this.str_strip, this::str_strip);
    }


    // function: Function(address=134282546, size=14, name='str_lstrip', path='build/py/objstr.o', joint_set={0, 12}, stop_set={12})
    abstract protected void str_lstrip(int offset) throws Exception;
    protected int str_lstrip = 0x0800fd32;
    public void str_lstrip() throws Exception
    {
        call(this.str_lstrip, this::str_lstrip);
    }


    // function: Function(address=134282560, size=14, name='str_rstrip', path='build/py/objstr.o', joint_set={0, 12}, stop_set={12})
    abstract protected void str_rstrip(int offset) throws Exception;
    protected int str_rstrip = 0x0800fd40;
    public void str_rstrip() throws Exception
    {
        call(this.str_rstrip, this::str_rstrip);
    }


    // function: Function(address=134282576, size=204, name='str_partitioner', path='build/py/objstr.o', joint_set={0, 132, 136, 14, 148, 22, 28, 34, 170, 42, 172, 50, 52, 180, 184, 188, 60, 68, 70, 76, 82, 90, 98, 104, 106, 118, 120}, stop_set={96, 78, 182, 88, 186, 190})
    abstract protected void str_partitioner(int offset) throws Exception;
    protected int str_partitioner = 0x0800fd50;
    public void str_partitioner() throws Exception
    {
        call(this.str_partitioner, this::str_partitioner);
    }


    // function: Function(address=134282780, size=10, name='str_partition', path='build/py/objstr.o', joint_set={0, 8}, stop_set={8})
    abstract protected void str_partition(int offset) throws Exception;
    protected int str_partition = 0x0800fe1c;
    public void str_partition() throws Exception
    {
        call(this.str_partition, this::str_partition);
    }


    // function: Function(address=134282790, size=12, name='str_rpartition', path='build/py/objstr.o', joint_set={0, 10}, stop_set={10})
    abstract protected void str_rpartition(int offset) throws Exception;
    protected int str_rpartition = 0x0800fe26;
    public void str_rpartition() throws Exception
    {
        call(this.str_rpartition, this::str_rpartition);
    }


    // function: Function(address=134282804, size=132, name='bytes_subscr', path='build/py/objstr.o', joint_set={0, 96, 34, 64, 32, 70, 38, 108, 44, 14, 60, 78, 52, 118, 24, 92}, stop_set={66, 76, 116, 120, 94})
    abstract protected void bytes_subscr(int offset) throws Exception;
    protected int bytes_subscr = 0x0800fe34;
    public void bytes_subscr() throws Exception
    {
        call(this.bytes_subscr, this::bytes_subscr);
    }


    // function: Function(address=134282936, size=144, name='mp_obj_str_equal', path='build/py/objstr.o', joint_set={0, 128, 136, 22, 26, 32, 36, 42, 44, 48, 54, 60, 64, 68, 72, 74, 78, 84, 92, 94, 98, 106, 108, 116, 122}, stop_set={34, 134, 76, 142, 46, 126})
    abstract protected void mp_obj_str_equal(int offset) throws Exception;
    protected int mp_obj_str_equal = 0x0800feb8;
    public void mp_obj_str_equal() throws Exception
    {
        call(this.mp_obj_str_equal, this::mp_obj_str_equal);
    }


    // function: Function(address=134283080, size=44, name='mp_obj_str_get_qstr', path='build/py/objstr.o', joint_set={0, 34, 36, 40, 10, 12, 14, 18, 26}, stop_set={34, 12})
    abstract protected void mp_obj_str_get_qstr(int offset) throws Exception;
    protected int mp_obj_str_get_qstr = 0x0800ff48;
    public void mp_obj_str_get_qstr() throws Exception
    {
        call(this.mp_obj_str_get_qstr, this::mp_obj_str_get_qstr);
    }


    // function: Function(address=134283124, size=48, name='mp_obj_str_get_str', path='build/py/objstr.o', joint_set={0, 36, 38, 10, 14, 24, 28}, stop_set={40, 36})
    abstract protected void mp_obj_str_get_str(int offset) throws Exception;
    protected int mp_obj_str_get_str = 0x0800ff74;
    public void mp_obj_str_get_str() throws Exception
    {
        call(this.mp_obj_str_get_str, this::mp_obj_str_get_str);
    }


    // function: Function(address=134283172, size=56, name='mp_obj_str_get_data', path='build/py/objstr.o', joint_set={0, 38, 12, 44, 16, 26, 30}, stop_set={42, 50})
    abstract protected void mp_obj_str_get_data(int offset) throws Exception;
    protected int mp_obj_str_get_data = 0x0800ffa4;
    public void mp_obj_str_get_data() throws Exception
    {
        call(this.mp_obj_str_get_data, this::mp_obj_str_get_data);
    }


    // function: Function(address=134283228, size=1348, name='mp_obj_str_binary_op', path='build/py/objstr.o', joint_set={0, 514, 1026, 516, 1032, 524, 1020, 526, 1040, 20, 22, 1046, 542, 1054, 1056, 546, 1060, 40, 556, 1070, 560, 48, 1080, 58, 572, 62, 576, 68, 580, 584, 1098, 588, 80, 1104, 596, 1108, 88, 602, 1116, 94, 606, 608, 1124, 104, 1132, 1134, 1136, 626, 1140, 118, 1142, 634, 1146, 636, 124, 1150, 640, 644, 132, 646, 1160, 650, 140, 654, 142, 1166, 144, 660, 148, 150, 1174, 666, 1178, 156, 1186, 1190, 1194, 172, 686, 1198, 690, 694, 186, 1214, 192, 1218, 198, 1222, 202, 1228, 720, 210, 1234, 212, 1238, 216, 728, 1240, 732, 1244, 222, 1248, 740, 228, 232, 1258, 748, 238, 756, 244, 246, 760, 1272, 250, 254, 770, 260, 776, 778, 266, 1292, 784, 274, 788, 1300, 280, 1304, 794, 1308, 298, 1322, 304, 314, 320, 326, 330, 336, 340, 344, 350, 864, 352, 354, 868, 358, 874, 362, 366, 370, 374, 378, 382, 898, 388, 900, 394, 910, 408, 414, 926, 932, 936, 426, 944, 432, 946, 440, 954, 446, 962, 964, 452, 970, 972, 466, 472, 990, 478, 480, 996, 484, 998, 490, 1004, 498, 1010, 504, 1018, 508, 510}, stop_set={898, 386, 644, 1158, 392, 776, 524, 1148, 148, 20, 1302, 154, 1306, 542, 1184, 1058, 810, 1322, 684, 1068, 558, 184, 60, 574, 1220, 200, 328, 718, 1102, 338, 212, 342, 1242, 478, 866, 356, 996, 230, 364, 372, 246, 758, 634, 508})
    abstract protected void mp_obj_str_binary_op(int offset) throws Exception;
    protected int mp_obj_str_binary_op = 0x0800ffdc;
    public void mp_obj_str_binary_op() throws Exception
    {
        call(this.mp_obj_str_binary_op, this::mp_obj_str_binary_op);
    }


    // function: Function(address=134284576, size=332, name='mp_obj_str_split', path='build/py/objstr.o', joint_set={0, 256, 128, 132, 134, 266, 140, 14, 144, 274, 20, 278, 150, 26, 286, 288, 160, 34, 32, 294, 168, 42, 298, 172, 306, 178, 54, 184, 316, 188, 62, 64, 320, 192, 198, 74, 202, 78, 206, 210, 84, 214, 88, 220, 92, 248, 226, 102, 232, 110, 112, 240, 114, 120, 254}, stop_set={322, 130, 126, 110, 176, 212, 118, 250, 190})
    abstract protected void mp_obj_str_split(int offset) throws Exception;
    protected int mp_obj_str_split = 0x08010520;
    public void mp_obj_str_split() throws Exception
    {
        call(this.mp_obj_str_split, this::mp_obj_str_split);
    }


    // function: Function(address=134284908, size=292, name='str_rsplit', path='build/py/objstr.o', joint_set={0, 262, 12, 140, 146, 20, 22, 150, 156, 28, 34, 166, 170, 174, 48, 56, 58, 64, 194, 68, 200, 80, 88, 218, 94, 104, 234, 238, 112, 120, 126}, stop_set={90, 122, 102, 172, 236, 276, 26})
    abstract protected void str_rsplit(int offset) throws Exception;
    protected int str_rsplit = 0x0801066c;
    public void str_rsplit() throws Exception
    {
        call(this.str_rsplit, this::str_rsplit);
    }


    // function: Function(address=134285200, size=116, name='str_startswith', path='build/py/objstr.o', joint_set={0, 34, 100, 36, 68, 44, 14, 82, 52, 88, 26, 92, 94}, stop_set={98, 106})
    abstract protected void str_startswith(int offset) throws Exception;
    protected int str_startswith = 0x08010790;
    public void str_startswith() throws Exception
    {
        call(this.str_startswith, this::str_startswith);
    }


    // function: Function(address=134285316, size=96, name='str_endswith', path='build/py/objstr.o', joint_set={0, 64, 34, 72, 40, 76, 46, 78, 16, 54, 24, 26}, stop_set={80, 42, 52})
    abstract protected void str_endswith(int offset) throws Exception;
    protected int str_endswith = 0x08010804;
    public void str_endswith() throws Exception
    {
        call(this.str_endswith, this::str_endswith);
    }


    // function: Function(address=134285412, size=1368, name='mp_obj_str_format_helper', path='build/py/objstr.o', joint_set={0, 1024, 516, 1032, 1034, 526, 1038, 1042, 22, 534, 1048, 1052, 30, 1056, 1060, 548, 550, 1064, 554, 1068, 48, 1072, 1080, 58, 1086, 64, 578, 72, 584, 78, 82, 84, 1108, 88, 1112, 602, 1116, 92, 1120, 98, 612, 616, 106, 618, 620, 112, 1138, 626, 120, 1144, 632, 636, 638, 126, 640, 130, 134, 1158, 646, 138, 652, 1164, 1166, 144, 1170, 658, 150, 1176, 664, 668, 158, 672, 674, 162, 168, 1194, 684, 172, 176, 180, 692, 188, 702, 1214, 198, 1222, 710, 204, 1228, 722, 724, 214, 1244, 732, 224, 1250, 1252, 740, 1256, 744, 234, 232, 1262, 752, 1266, 242, 756, 246, 1270, 1274, 250, 1276, 764, 768, 260, 1284, 264, 778, 1294, 270, 784, 1296, 274, 272, 788, 1302, 1304, 280, 794, 282, 286, 800, 292, 1316, 806, 1322, 298, 1324, 814, 304, 818, 308, 822, 1334, 824, 1340, 830, 1342, 318, 834, 322, 332, 336, 346, 358, 366, 382, 386, 392, 394, 908, 398, 914, 404, 918, 408, 922, 928, 416, 932, 936, 938, 940, 428, 432, 946, 950, 440, 954, 442, 956, 446, 960, 450, 964, 968, 458, 972, 462, 978, 470, 990, 992, 482, 996, 486, 488, 1000, 1004, 1008, 496, 506}, stop_set={260, 388, 1032, 776, 1164, 782, 912, 786, 148, 920, 280, 160, 1314, 548, 1192, 296, 1322, 302, 46, 178, 1332, 440, 1212, 1340, 444, 1344, 448, 836, 460, 334, 80, 1106, 84, 990, 1250, 994, 1254, 998, 104, 616, 362, 486, 1264, 1136, 754, 244, 248, 1274})
    abstract protected void mp_obj_str_format_helper(int offset) throws Exception;
    protected int mp_obj_str_format_helper = 0x08010864;
    public void mp_obj_str_format_helper() throws Exception
    {
        call(this.mp_obj_str_format_helper, this::mp_obj_str_format_helper);
    }


    // function: Function(address=134286780, size=76, name='mp_obj_str_format', path='build/py/objstr.o', joint_set={0, 64, 28, 52, 20, 60, 30}, stop_set={70, 62})
    abstract protected void mp_obj_str_format(int offset) throws Exception;
    protected int mp_obj_str_format = 0x08010dbc;
    public void mp_obj_str_format() throws Exception
    {
        call(this.mp_obj_str_format, this::mp_obj_str_format);
    }


    // function: Function(address=134286856, size=16, name='mp_obj_str_intern_checked', path='build/py/objstr.o', joint_set={0, 8, 14}, stop_set={14})
    abstract protected void mp_obj_str_intern_checked(int offset) throws Exception;
    protected int mp_obj_str_intern_checked = 0x08010e08;
    public void mp_obj_str_intern_checked() throws Exception
    {
        call(this.mp_obj_str_intern_checked, this::mp_obj_str_intern_checked);
    }


    // function: Function(address=134286872, size=28, name='mp_obj_new_str_iterator', path='build/py/objstrunicode.o', joint_set={0}, stop_set={16})
    abstract protected void mp_obj_new_str_iterator(int offset) throws Exception;
    protected int mp_obj_new_str_iterator = 0x08010e18;
    public void mp_obj_new_str_iterator() throws Exception
    {
        call(this.mp_obj_new_str_iterator, this::mp_obj_new_str_iterator);
    }


    // function: Function(address=134286900, size=68, name='str_it_iternext', path='build/py/objstrunicode.o', joint_set={0, 34, 42, 14, 52, 22, 24, 58, 60}, stop_set={58, 66})
    abstract protected void str_it_iternext(int offset) throws Exception;
    protected int str_it_iternext = 0x08010e34;
    public void str_it_iternext() throws Exception
    {
        call(this.str_it_iternext, this::str_it_iternext);
    }


    // function: Function(address=134286968, size=76, name='uni_unary_op', path='build/py/objstrunicode.o', joint_set={0, 32, 40, 12, 48, 50, 20, 52, 24, 58, 28}, stop_set={64, 38, 50, 30})
    abstract protected void uni_unary_op(int offset) throws Exception;
    protected int uni_unary_op = 0x08010e78;
    public void uni_unary_op() throws Exception
    {
        call(this.uni_unary_op, this::uni_unary_op);
    }


    // function: Function(address=134287044, size=288, name='uni_print', path='build/py/objstrunicode.o', joint_set={0, 128, 134, 142, 16, 148, 152, 24, 26, 158, 160, 32, 166, 40, 44, 174, 178, 52, 184, 56, 190, 194, 66, 68, 196, 202, 78, 208, 84, 218, 90, 92, 220, 94, 224, 98, 230, 104, 112, 240, 118, 122}, stop_set={96, 66, 126, 228, 42, 176, 242, 50, 120, 218, 158})
    abstract protected void uni_print(int offset) throws Exception;
    protected int uni_print = 0x08010ec4;
    public void uni_print() throws Exception
    {
        call(this.uni_print, this::uni_print);
    }


    // function: Function(address=134287332, size=196, name='str_index_to_ptr', path='build/py/objstrunicode.o', joint_set={0, 130, 134, 142, 146, 18, 150, 152, 156, 28, 30, 32, 160, 164, 36, 40, 172, 48, 56, 60, 64, 66, 68, 72, 80, 88, 92, 98, 108, 112, 120, 124}, stop_set={132, 76, 108, 174, 154, 30})
    abstract protected void str_index_to_ptr(int offset) throws Exception;
    protected int str_index_to_ptr = 0x08010fe4;
    public void str_index_to_ptr() throws Exception
    {
        call(this.str_index_to_ptr, this::str_index_to_ptr);
    }


    // function: Function(address=134287528, size=220, name='str_subscr', path='build/py/objstrunicode.o', joint_set={0, 134, 136, 14, 142, 152, 24, 156, 32, 34, 38, 42, 172, 50, 182, 188, 62, 192, 196, 70, 200, 202, 74, 80, 88, 96, 110, 112, 122}, stop_set={154, 200, 204, 76, 86, 186})
    abstract protected void str_subscr(int offset) throws Exception;
    protected int str_subscr = 0x080110a8;
    public void str_subscr() throws Exception
    {
        call(this.str_subscr, this::str_subscr);
    }


    // function: Function(address=134287748, size=10, name='stringio___exit__', path='build/py/objstringio.o', joint_set={0, 8}, stop_set={8})
    abstract protected void stringio___exit__(int offset) throws Exception;
    protected int stringio___exit__ = 0x08011184;
    public void stringio___exit__() throws Exception
    {
        call(this.stringio___exit__, this::stringio___exit__);
    }


    // function: Function(address=134287760, size=36, name='stringio_print', path='build/py/objstringio.o', joint_set={0, 16, 22, 14}, stop_set={22})
    abstract protected void stringio_print(int offset) throws Exception;
    protected int stringio_print = 0x08011190;
    public void stringio_print() throws Exception
    {
        call(this.stringio_print, this::stringio_print);
    }


    // function: Function(address=134287796, size=164, name='stringio_write', path='build/py/objstringio.o', joint_set={0, 32, 130, 68, 102, 42, 76, 110, 156, 146, 18, 116, 86, 24, 56, 92}, stop_set={90, 20, 158})
    abstract protected void stringio_write(int offset) throws Exception;
    protected int stringio_write = 0x080111b4;
    public void stringio_write() throws Exception
    {
        call(this.stringio_write, this::stringio_write);
    }


    // function: Function(address=134287960, size=164, name='stringio_make_new', path='build/py/objstringio.o', joint_set={0, 130, 140, 16, 146, 152, 30, 36, 40, 48, 52, 54, 58, 64, 76, 82, 90, 100, 104, 114, 120}, stop_set={144, 154, 80, 150})
    abstract protected void stringio_make_new(int offset) throws Exception;
    protected int stringio_make_new = 0x08011258;
    public void stringio_make_new() throws Exception
    {
        call(this.stringio_make_new, this::stringio_make_new);
    }


    // function: Function(address=134288124, size=94, name='stringio_ioctl', path='build/py/objstringio.o', joint_set={0, 34, 68, 36, 72, 8, 44, 12, 48, 18, 82, 20, 52, 54, 30, 88, 26, 62}, stop_set={32, 66, 92, 80, 18, 60})
    abstract protected void stringio_ioctl(int offset) throws Exception;
    protected int stringio_ioctl = 0x080112fc;
    public void stringio_ioctl() throws Exception
    {
        call(this.stringio_ioctl, this::stringio_ioctl);
    }


    // function: Function(address=134288220, size=52, name='stringio_getvalue', path='build/py/objstringio.o', joint_set={0, 34, 8, 14, 24, 26}, stop_set={34, 10})
    abstract protected void stringio_getvalue(int offset) throws Exception;
    protected int stringio_getvalue = 0x0801135c;
    public void stringio_getvalue() throws Exception
    {
        call(this.stringio_getvalue, this::stringio_getvalue);
    }


    // function: Function(address=134288272, size=60, name='stringio_read', path='build/py/objstringio.o', joint_set={0, 34, 36, 12, 46, 18, 52, 28}, stop_set={54, 14})
    abstract protected void stringio_read(int offset) throws Exception;
    protected int stringio_read = 0x08011390;
    public void stringio_read() throws Exception
    {
        call(this.stringio_read, this::stringio_read);
    }


    // function: Function(address=134288332, size=28, name='tuple_it_iternext', path='build/py/objtuple.o', joint_set={0, 16, 26}, stop_set={26})
    abstract protected void tuple_it_iternext(int offset) throws Exception;
    protected int tuple_it_iternext = 0x080113cc;
    public void tuple_it_iternext() throws Exception
    {
        call(this.tuple_it_iternext, this::tuple_it_iternext);
    }


    // function: Function(address=134288360, size=28, name='mp_obj_tuple_getiter', path='build/py/objtuple.o', joint_set={0}, stop_set={16})
    abstract protected void mp_obj_tuple_getiter(int offset) throws Exception;
    protected int mp_obj_tuple_getiter = 0x080113e8;
    public void mp_obj_tuple_getiter() throws Exception
    {
        call(this.mp_obj_tuple_getiter, this::mp_obj_tuple_getiter);
    }


    // function: Function(address=134288388, size=120, name='mp_obj_tuple_print', path='build/py/objtuple.o', joint_set={0, 64, 32, 26, 68, 36, 76, 44, 46, 12, 18, 20, 52, 54, 90, 60}, stop_set={62, 92, 52})
    abstract protected void mp_obj_tuple_print(int offset) throws Exception;
    protected int mp_obj_tuple_print = 0x08011404;
    public void mp_obj_tuple_print() throws Exception
    {
        call(this.mp_obj_tuple_print, this::mp_obj_tuple_print);
    }


    // function: Function(address=134288508, size=20, name='tuple_index', path='build/py/objtuple.o', joint_set={0, 18}, stop_set={18})
    abstract protected void tuple_index(int offset) throws Exception;
    protected int tuple_index = 0x0801147c;
    public void tuple_index() throws Exception
    {
        call(this.tuple_index, this::tuple_index);
    }


    // function: Function(address=134288528, size=16, name='tuple_count', path='build/py/objtuple.o', joint_set={0, 14}, stop_set={14})
    abstract protected void tuple_count(int offset) throws Exception;
    protected int tuple_count = 0x08011490;
    public void tuple_count() throws Exception
    {
        call(this.tuple_count, this::tuple_count);
    }


    // function: Function(address=134288544, size=92, name='mp_obj_tuple_unary_op', path='build/py/objtuple.o', joint_set={0, 32, 66, 58, 38, 8, 12, 76, 46, 16, 24, 26, 28}, stop_set={64, 74, 44, 78, 26})
    abstract protected void mp_obj_tuple_unary_op(int offset) throws Exception;
    protected int mp_obj_tuple_unary_op = 0x080114a0;
    public void mp_obj_tuple_unary_op() throws Exception
    {
        call(this.mp_obj_tuple_unary_op, this::mp_obj_tuple_unary_op);
    }


    // function: Function(address=134288636, size=60, name='mp_obj_new_tuple', path='build/py/objtuple.o', joint_set={0, 32, 36, 40, 42, 12, 22}, stop_set={40, 50})
    abstract protected void mp_obj_new_tuple(int offset) throws Exception;
    protected int mp_obj_new_tuple = 0x080114fc;
    public void mp_obj_new_tuple() throws Exception
    {
        call(this.mp_obj_new_tuple, this::mp_obj_new_tuple);
    }


    // function: Function(address=134288696, size=256, name='mp_obj_tuple_binary_op', path='build/py/objtuple.o', joint_set={0, 132, 14, 142, 24, 30, 34, 164, 38, 166, 44, 172, 50, 180, 54, 188, 192, 66, 196, 200, 86, 220, 226, 104, 110, 118, 124}, stop_set={226, 164, 36, 198, 108})
    abstract protected void mp_obj_tuple_binary_op(int offset) throws Exception;
    protected int mp_obj_tuple_binary_op = 0x08011538;
    public void mp_obj_tuple_binary_op() throws Exception
    {
        call(this.mp_obj_tuple_binary_op, this::mp_obj_tuple_binary_op);
    }


    // function: Function(address=134288952, size=116, name='mp_obj_tuple_subscr', path='build/py/objtuple.o', joint_set={0, 32, 36, 102, 10, 42, 76, 82, 18, 54, 26, 94}, stop_set={80, 100, 104, 38})
    abstract protected void mp_obj_tuple_subscr(int offset) throws Exception;
    protected int mp_obj_tuple_subscr = 0x08011638;
    public void mp_obj_tuple_subscr() throws Exception
    {
        call(this.mp_obj_tuple_subscr, this::mp_obj_tuple_subscr);
    }


    // function: Function(address=134289068, size=140, name='mp_obj_tuple_make_new', path='build/py/objtuple.o', joint_set={0, 96, 64, 34, 70, 102, 42, 106, 78, 48, 116, 22, 86, 120, 58, 28}, stop_set={128, 100})
    abstract protected void mp_obj_tuple_make_new(int offset) throws Exception;
    protected int mp_obj_tuple_make_new = 0x080116ac;
    public void mp_obj_tuple_make_new() throws Exception
    {
        call(this.mp_obj_tuple_make_new, this::mp_obj_tuple_make_new);
    }


    // function: Function(address=134289208, size=10, name='mp_obj_tuple_get', path='build/py/objtuple.o', joint_set={0}, stop_set={8})
    abstract protected void mp_obj_tuple_get(int offset) throws Exception;
    protected int mp_obj_tuple_get = 0x08011738;
    public void mp_obj_tuple_get() throws Exception
    {
        call(this.mp_obj_tuple_get, this::mp_obj_tuple_get);
    }


    // function: Function(address=134289218, size=14, name='mp_obj_tuple_del', path='build/py/objtuple.o', joint_set={0, 12}, stop_set={12})
    abstract protected void mp_obj_tuple_del(int offset) throws Exception;
    protected int mp_obj_tuple_del = 0x08011742;
    public void mp_obj_tuple_del() throws Exception
    {
        call(this.mp_obj_tuple_del, this::mp_obj_tuple_del);
    }


    // function: Function(address=134289232, size=88, name='instance_count_native_bases', path='build/py/objtype.o', joint_set={0, 64, 34, 68, 72, 40, 10, 14, 52, 20, 24, 56, 28}, stop_set={26, 66, 74, 70})
    abstract protected void instance_count_native_bases(int offset) throws Exception;
    protected int instance_count_native_bases = 0x08011750;
    public void instance_count_native_bases() throws Exception
    {
        call(this.instance_count_native_bases, this::instance_count_native_bases);
    }


    // function: Function(address=134289320, size=44, name='native_base_init_wrapper', path='build/py/objtype.o', joint_set={0, 20}, stop_set={36})
    abstract protected void native_base_init_wrapper(int offset) throws Exception;
    protected int native_base_init_wrapper = 0x080117a8;
    public void native_base_init_wrapper() throws Exception
    {
        call(this.native_base_init_wrapper, this::native_base_init_wrapper);
    }


    // function: Function(address=134289364, size=240, name='mp_obj_class_lookup', path='build/py/objtype.o', joint_set={0, 128, 6, 12, 144, 20, 152, 26, 156, 158, 32, 34, 164, 40, 172, 178, 56, 188, 60, 196, 198, 72, 202, 76, 206, 80, 82, 214, 86, 222, 94, 100, 102, 106, 112, 118}, stop_set={32, 196, 104, 204, 80, 156, 222})
    abstract protected void mp_obj_class_lookup(int offset) throws Exception;
    protected int mp_obj_class_lookup = 0x080117d4;
    public void mp_obj_class_lookup() throws Exception
    {
        call(this.mp_obj_class_lookup, this::mp_obj_class_lookup);
    }


    // function: Function(address=134289604, size=160, name='super_attr', path='build/py/objtype.o', joint_set={0, 128, 34, 132, 68, 38, 100, 104, 74, 138, 44, 14, 110, 144, 116, 52, 86, 120, 88, 62}, stop_set={144, 130, 102, 86})
    abstract protected void super_attr(int offset) throws Exception;
    protected int super_attr = 0x080118c4;
    public void super_attr() throws Exception
    {
        call(this.super_attr, this::super_attr);
    }


    // function: Function(address=134289764, size=36, name='static_class_method_make_new', path='build/py/objtype.o', joint_set={0, 28, 22}, stop_set={34})
    abstract protected void static_class_method_make_new(int offset) throws Exception;
    protected int static_class_method_make_new = 0x08011964;
    public void static_class_method_make_new() throws Exception
    {
        call(this.static_class_method_make_new, this::static_class_method_make_new);
    }


    // function: Function(address=134289800, size=64, name='super_make_new', path='build/py/objtype.o', joint_set={0, 36, 42, 48, 22, 28}, stop_set={58, 38})
    abstract protected void super_make_new(int offset) throws Exception;
    protected int super_make_new = 0x08011988;
    public void super_make_new() throws Exception
    {
        call(this.super_make_new, this::super_make_new);
    }


    // function: Function(address=134289864, size=16, name='type_print', path='build/py/objtype.o', joint_set={0, 10}, stop_set={10})
    abstract protected void type_print(int offset) throws Exception;
    protected int type_print = 0x080119c8;
    public void type_print() throws Exception
    {
        call(this.type_print, this::type_print);
    }


    // function: Function(address=134289880, size=128, name='instance_subscr', path='build/py/objtype.o', joint_set={0, 64, 98, 102, 70, 80, 48, 20, 116, 54, 84, 62, 94, 52, 120, 30}, stop_set={96, 82, 122})
    abstract protected void instance_subscr(int offset) throws Exception;
    protected int instance_subscr = 0x080119d8;
    public void instance_subscr() throws Exception
    {
        call(this.instance_subscr, this::instance_subscr);
    }


    // function: Function(address=134290008, size=116, name='instance_binary_op', path='build/py/objtype.o', joint_set={0, 64, 70, 102, 72, 10, 76, 48, 80, 54, 24, 92, 94}, stop_set={74, 92, 106})
    abstract protected void instance_binary_op(int offset) throws Exception;
    protected int instance_binary_op = 0x08011a58;
    public void instance_binary_op() throws Exception
    {
        call(this.instance_binary_op, this::instance_binary_op);
    }


    // function: Function(address=134290124, size=160, name='instance_unary_op', path='build/py/objtype.o', joint_set={0, 128, 98, 26, 132, 36, 102, 42, 106, 14, 124, 144, 112, 84, 116, 150, 20, 120, 90, 60}, stop_set={130, 100, 40, 152, 122})
    abstract protected void instance_unary_op(int offset) throws Exception;
    protected int instance_unary_op = 0x08011acc;
    public void instance_unary_op() throws Exception
    {
        call(this.instance_unary_op, this::instance_unary_op);
    }


    // function: Function(address=134290284, size=188, name='instance_print', path='build/py/objtype.o', joint_set={0, 128, 134, 138, 142, 16, 146, 20, 152, 158, 30, 164, 176, 58, 64, 68, 82, 88, 94, 102, 106, 114, 122, 126}, stop_set={136, 140, 156, 176})
    abstract protected void instance_print(int offset) throws Exception;
    protected int instance_print = 0x08011b6c;
    public void instance_print() throws Exception
    {
        call(this.instance_print, this::instance_print);
    }


    // function: Function(address=134290472, size=64, name='super_print', path='build/py/objtype.o', joint_set={0, 40, 12, 48, 22, 30}, stop_set={48})
    abstract protected void super_print(int offset) throws Exception;
    protected int super_print = 0x08011c28;
    public void super_print() throws Exception
    {
        call(this.super_print, this::super_print);
    }


    // function: Function(address=134290536, size=560, name='mp_obj_instance_attr', path='build/py/objtype.o', joint_set={0, 132, 516, 262, 388, 520, 138, 522, 524, 394, 16, 400, 18, 146, 276, 402, 152, 538, 410, 286, 160, 416, 34, 38, 422, 168, 40, 44, 48, 432, 178, 308, 436, 182, 438, 56, 58, 442, 314, 192, 64, 66, 322, 452, 198, 70, 458, 330, 334, 208, 82, 468, 86, 216, 344, 220, 222, 94, 478, 352, 98, 226, 484, 350, 230, 358, 234, 250, 362, 366, 116, 244, 500, 374, 504, 372, 122, 382}, stop_set={96, 164, 68, 260, 520, 42, 522, 364, 16, 498, 466, 180, 436, 372, 408, 380, 220, 540, 350})
    abstract protected void mp_obj_instance_attr(int offset) throws Exception;
    protected int mp_obj_instance_attr = 0x08011c68;
    public void mp_obj_instance_attr() throws Exception
    {
        call(this.mp_obj_instance_attr, this::mp_obj_instance_attr);
    }


    // function: Function(address=134291096, size=36, name='type_call', path='build/py/objtype.o', joint_set={0, 8, 18, 22}, stop_set={24, 18})
    abstract protected void type_call(int offset) throws Exception;
    protected int type_call = 0x08011e98;
    public void type_call() throws Exception
    {
        call(this.type_call, this::type_call);
    }


    // function: Function(address=134291132, size=74, name='instance_get_buffer', path='build/py/objtype.o', joint_set={0, 70, 46, 54, 22, 60}, stop_set={72})
    abstract protected void instance_get_buffer(int offset) throws Exception;
    protected int instance_get_buffer = 0x08011ebc;
    public void instance_get_buffer() throws Exception
    {
        call(this.instance_get_buffer, this::instance_get_buffer);
    }


    // function: Function(address=134291206, size=86, name='instance_getiter', path='build/py/objtype.o', joint_set={0, 70, 74, 44, 20, 52, 84, 56, 62}, stop_set={72, 84})
    abstract protected void instance_getiter(int offset) throws Exception;
    protected int instance_getiter = 0x08011f06;
    public void instance_getiter() throws Exception
    {
        call(this.instance_getiter, this::instance_getiter);
    }


    // function: Function(address=134291292, size=80, name='check_for_special_accessors', path='build/py/objtype.o', joint_set={0, 26, 68, 42, 28, 16, 48, 20, 52, 58, 60}, stop_set={58, 50, 68})
    abstract protected void check_for_special_accessors(int offset) throws Exception;
    protected int check_for_special_accessors = 0x08011f5c;
    public void check_for_special_accessors() throws Exception
    {
        call(this.check_for_special_accessors, this::check_for_special_accessors);
    }


    // function: Function(address=134291372, size=164, name='type_attr', path='build/py/objtype.o', joint_set={0, 68, 100, 102, 134, 138, 108, 14, 50, 18, 148, 116, 54, 86, 120, 94, 26, 30, 60, 126}, stop_set={130, 100, 52, 154, 28})
    abstract protected void type_attr(int offset) throws Exception;
    protected int type_attr = 0x08011fac;
    public void type_attr() throws Exception
    {
        call(this.type_attr, this::type_attr);
    }


    // function: Function(address=134291536, size=112, name='mp_obj_instance_call', path='build/py/objtype.o', joint_set={0, 64, 100, 68, 42, 74, 48, 84, 54, 88}, stop_set={64, 100, 86})
    abstract protected void mp_obj_instance_call(int offset) throws Exception;
    protected int mp_obj_instance_call = 0x08012050;
    public void mp_obj_instance_call() throws Exception
    {
        call(this.mp_obj_instance_call, this::mp_obj_instance_call);
    }


    // function: Function(address=134291648, size=44, name='mp_obj_new_instance', path='build/py/objtype.o', joint_set={0, 32, 36, 8, 18, 28}, stop_set={38})
    abstract protected void mp_obj_new_instance(int offset) throws Exception;
    protected int mp_obj_new_instance = 0x080120c0;
    public void mp_obj_new_instance() throws Exception
    {
        call(this.mp_obj_new_instance, this::mp_obj_new_instance);
    }


    // function: Function(address=134291692, size=348, name='mp_obj_instance_make_new', path='build/py/objtype.o', joint_set={0, 256, 128, 138, 142, 150, 280, 24, 160, 290, 162, 168, 172, 300, 302, 48, 178, 308, 56, 316, 60, 68, 198, 70, 212, 92, 98, 226, 106, 236, 238, 114, 116, 122}, stop_set={328, 138, 300, 236, 176})
    abstract protected void mp_obj_instance_make_new(int offset) throws Exception;
    protected int mp_obj_instance_make_new = 0x080120ec;
    public void mp_obj_instance_make_new() throws Exception
    {
        call(this.mp_obj_instance_make_new, this::mp_obj_instance_make_new);
    }


    // function: Function(address=134292040, size=48, name='mp_obj_instance_is_callable', path='build/py/objtype.o', joint_set={0, 36}, stop_set={46})
    abstract protected void mp_obj_instance_is_callable(int offset) throws Exception;
    protected int mp_obj_instance_is_callable = 0x08012248;
    public void mp_obj_instance_is_callable() throws Exception
    {
        call(this.mp_obj_instance_is_callable, this::mp_obj_instance_is_callable);
    }


    // function: Function(address=134292088, size=404, name='mp_obj_new_type', path='build/py/objtype.o', joint_set={0, 262, 134, 266, 16, 272, 18, 146, 148, 276, 22, 154, 30, 286, 162, 36, 166, 170, 298, 44, 302, 180, 54, 310, 190, 322, 68, 196, 74, 332, 206, 334, 80, 210, 216, 230, 234, 240, 242, 250}, stop_set={232, 168, 206, 238, 18, 338, 284})
    abstract protected void mp_obj_new_type(int offset) throws Exception;
    protected int mp_obj_new_type = 0x08012278;
    public void mp_obj_new_type() throws Exception
    {
        call(this.mp_obj_new_type, this::mp_obj_new_type);
    }


    // function: Function(address=134292492, size=64, name='type_make_new', path='build/py/objtype.o', joint_set={0, 36, 58, 42, 44, 50, 22, 26, 30}, stop_set={32, 42, 58})
    abstract protected void type_make_new(int offset) throws Exception;
    protected int type_make_new = 0x0801240c;
    public void type_make_new() throws Exception
    {
        call(this.type_make_new, this::type_make_new);
    }


    // function: Function(address=134292556, size=32, name='mp_load_super_method', path='build/py/objtype.o', joint_set={0, 24}, stop_set={26})
    abstract protected void mp_load_super_method(int offset) throws Exception;
    protected int mp_load_super_method = 0x0801244c;
    public void mp_load_super_method() throws Exception
    {
        call(this.mp_load_super_method, this::mp_load_super_method);
    }


    // function: Function(address=134292588, size=96, name='mp_obj_is_subclass_fast', path='build/py/objtype.o', joint_set={0, 32, 64, 58, 68, 38, 6, 72, 74, 10, 76, 14, 80, 20, 52, 26}, stop_set={70, 74, 82, 78})
    abstract protected void mp_obj_is_subclass_fast(int offset) throws Exception;
    protected int mp_obj_is_subclass_fast = 0x0801246c;
    public void mp_obj_is_subclass_fast() throws Exception
    {
        call(this.mp_obj_is_subclass_fast, this::mp_obj_is_subclass_fast);
    }


    // function: Function(address=134292684, size=120, name='mp_obj_is_subclass', path='build/py/objtype.o', joint_set={0, 68, 36, 40, 42, 46, 14, 92, 78, 52, 84, 22, 30, 88, 60, 62}, stop_set={64, 44, 90, 60, 94})
    abstract protected void mp_obj_is_subclass(int offset) throws Exception;
    protected int mp_obj_is_subclass = 0x080124cc;
    public void mp_obj_is_subclass() throws Exception
    {
        call(this.mp_obj_is_subclass, this::mp_obj_is_subclass);
    }


    // function: Function(address=134292804, size=36, name='mp_builtin_issubclass', path='build/py/objtype.o', joint_set={0, 6, 14, 20, 24}, stop_set={16, 24})
    abstract protected void mp_builtin_issubclass(int offset) throws Exception;
    protected int mp_builtin_issubclass = 0x08012544;
    public void mp_builtin_issubclass() throws Exception
    {
        call(this.mp_builtin_issubclass, this::mp_builtin_issubclass);
    }


    // function: Function(address=134292840, size=16, name='mp_builtin_isinstance', path='build/py/objtype.o', joint_set={0, 8, 14}, stop_set={14})
    abstract protected void mp_builtin_isinstance(int offset) throws Exception;
    protected int mp_builtin_isinstance = 0x08012568;
    public void mp_builtin_isinstance() throws Exception
    {
        call(this.mp_builtin_isinstance, this::mp_builtin_isinstance);
    }


    // function: Function(address=134292856, size=26, name='mp_instance_cast_to_native_base', path='build/py/objtype.o', joint_set={0, 10, 16, 20, 22}, stop_set={24})
    abstract protected void mp_instance_cast_to_native_base(int offset) throws Exception;
    protected int mp_instance_cast_to_native_base = 0x08012578;
    public void mp_instance_cast_to_native_base() throws Exception
    {
        call(this.mp_instance_cast_to_native_base, this::mp_instance_cast_to_native_base);
    }


    // function: Function(address=134292882, size=64, name='zip_iternext', path='build/py/objzip.o', joint_set={0, 38, 10, 42, 16, 48, 50, 20, 54, 26}, stop_set={52, 62})
    abstract protected void zip_iternext(int offset) throws Exception;
    protected int zip_iternext = 0x08012592;
    public void zip_iternext() throws Exception
    {
        call(this.zip_iternext, this::zip_iternext);
    }


    // function: Function(address=134292948, size=76, name='zip_make_new', path='build/py/objzip.o', joint_set={0, 34, 68, 60, 50, 54, 28}, stop_set={58, 70})
    abstract protected void zip_make_new(int offset) throws Exception;
    protected int zip_make_new = 0x080125d4;
    public void zip_make_new() throws Exception
    {
        call(this.zip_make_new, this::zip_make_new);
    }


    // function: Function(address=134293024, size=22, name='op_getitem', path='build/py/opmethods.o', joint_set={0, 10}, stop_set={20})
    abstract protected void op_getitem(int offset) throws Exception;
    protected int op_getitem = 0x08012620;
    public void op_getitem() throws Exception
    {
        call(this.op_getitem, this::op_getitem);
    }


    // function: Function(address=134293046, size=24, name='op_setitem', path='build/py/opmethods.o', joint_set={0, 12}, stop_set={22})
    abstract protected void op_setitem(int offset) throws Exception;
    protected int op_setitem = 0x08012636;
    public void op_setitem() throws Exception
    {
        call(this.op_setitem, this::op_setitem);
    }


    // function: Function(address=134293070, size=22, name='op_delitem', path='build/py/opmethods.o', joint_set={0, 10}, stop_set={20})
    abstract protected void op_delitem(int offset) throws Exception;
    protected int op_delitem = 0x0801264e;
    public void op_delitem() throws Exception
    {
        call(this.op_delitem, this::op_delitem);
    }


    // function: Function(address=134293092, size=22, name='op_contains', path='build/py/opmethods.o', joint_set={0, 10}, stop_set={20})
    abstract protected void op_contains(int offset) throws Exception;
    protected int op_contains = 0x08012664;
    public void op_contains() throws Exception
    {
        call(this.op_contains, this::op_contains);
    }


    // function: Function(address=134293114, size=38, name='mp_seq_multiply', path='build/py/sequence.o', joint_set={0, 12, 16, 18, 28}, stop_set={16, 36})
    abstract protected void mp_seq_multiply(int offset) throws Exception;
    protected int mp_seq_multiply = 0x0801267a;
    public void mp_seq_multiply() throws Exception
    {
        call(this.mp_seq_multiply, this::mp_seq_multiply);
    }


    // function: Function(address=134293152, size=248, name='mp_seq_get_fast_slice_indexes', path='build/py/sequence.o', joint_set={0, 142, 146, 20, 150, 154, 28, 160, 32, 164, 36, 168, 42, 172, 48, 176, 180, 52, 184, 58, 188, 190, 194, 66, 68, 198, 74, 204, 208, 80, 212, 86, 216, 90, 220, 94, 224, 98, 228, 102, 232, 106, 238, 112, 114, 120, 124, 126}, stop_set={230, 202, 140, 44, 238, 178, 210, 148, 222})
    abstract protected void mp_seq_get_fast_slice_indexes(int offset) throws Exception;
    protected int mp_seq_get_fast_slice_indexes = 0x080126a0;
    public void mp_seq_get_fast_slice_indexes() throws Exception
    {
        call(this.mp_seq_get_fast_slice_indexes, this::mp_seq_get_fast_slice_indexes);
    }


    // function: Function(address=134293400, size=70, name='mp_seq_extract_slice', path='build/py/sequence.o', joint_set={0, 32, 68, 36, 46, 50, 20, 26, 60, 62}, stop_set={48, 34, 68})
    abstract protected void mp_seq_extract_slice(int offset) throws Exception;
    protected int mp_seq_extract_slice = 0x08012798;
    public void mp_seq_extract_slice() throws Exception
    {
        call(this.mp_seq_extract_slice, this::mp_seq_extract_slice);
    }


    // function: Function(address=134293470, size=108, name='mp_seq_cmp_bytes', path='build/py/sequence.o', joint_set={0, 32, 98, 68, 38, 72, 42, 76, 12, 46, 60, 48, 82, 18, 52, 24, 56, 88, 92, 30}, stop_set={96, 66, 70, 74, 106, 50})
    abstract protected void mp_seq_cmp_bytes(int offset) throws Exception;
    protected int mp_seq_cmp_bytes = 0x080127de;
    public void mp_seq_cmp_bytes() throws Exception
    {
        call(this.mp_seq_cmp_bytes, this::mp_seq_cmp_bytes);
    }


    // function: Function(address=134293580, size=152, name='mp_seq_cmp_objs', path='build/py/sequence.o', joint_set={0, 130, 12, 142, 18, 146, 20, 24, 28, 32, 38, 44, 52, 54, 60, 70, 76, 78, 82, 86, 90, 102, 106, 112, 116}, stop_set={140, 110, 80, 146, 84, 22, 88})
    abstract protected void mp_seq_cmp_objs(int offset) throws Exception;
    protected int mp_seq_cmp_objs = 0x0801284c;
    public void mp_seq_cmp_objs() throws Exception
    {
        call(this.mp_seq_cmp_objs, this::mp_seq_cmp_objs);
    }


    // function: Function(address=134293732, size=104, name='mp_seq_index_obj', path='build/py/sequence.o', joint_set={0, 64, 58, 70, 40, 46, 18, 82, 86, 90, 60, 30}, stop_set={88, 98, 66})
    abstract protected void mp_seq_index_obj(int offset) throws Exception;
    protected int mp_seq_index_obj = 0x080128e4;
    public void mp_seq_index_obj() throws Exception
    {
        call(this.mp_seq_index_obj, this::mp_seq_index_obj);
    }


    // function: Function(address=134293836, size=40, name='mp_seq_count_obj', path='build/py/sequence.o', joint_set={0, 32, 12, 16, 24}, stop_set={38, 22})
    abstract protected void mp_seq_count_obj(int offset) throws Exception;
    protected int mp_seq_count_obj = 0x0801294c;
    public void mp_seq_count_obj() throws Exception
    {
        call(this.mp_seq_count_obj, this::mp_seq_count_obj);
    }


    // function: Function(address=134293876, size=36, name='mp_stream_close', path='build/py/stream.o', joint_set={0, 26, 20}, stop_set={28, 22})
    abstract protected void mp_stream_close(int offset) throws Exception;
    protected int mp_stream_close = 0x08012974;
    public void mp_stream_close() throws Exception
    {
        call(this.mp_stream_close, this::mp_stream_close);
    }


    // function: Function(address=134293912, size=36, name='stream_flush', path='build/py/stream.o', joint_set={0, 26, 20}, stop_set={28, 22})
    abstract protected void stream_flush(int offset) throws Exception;
    protected int stream_flush = 0x08012998;
    public void stream_flush() throws Exception
    {
        call(this.stream_flush, this::stream_flush);
    }


    // function: Function(address=134293948, size=140, name='stream_unbuffered_readline', path='build/py/stream.o', joint_set={0, 32, 130, 36, 122, 102, 70, 42, 76, 44, 110, 112, 16, 52, 86, 118, 24, 90, 94}, stop_set={120, 88, 130, 72})
    abstract protected void stream_unbuffered_readline(int offset) throws Exception;
    protected int stream_unbuffered_readline = 0x080129bc;
    public void stream_unbuffered_readline() throws Exception
    {
        call(this.stream_unbuffered_readline, this::stream_unbuffered_readline);
    }


    // function: Function(address=134294088, size=46, name='stream_unbuffered_readlines', path='build/py/stream.o', joint_set={0, 32, 40, 42, 12, 14, 22, 28}, stop_set={40, 44})
    abstract protected void stream_unbuffered_readlines(int offset) throws Exception;
    protected int stream_unbuffered_readlines = 0x08012a48;
    public void stream_unbuffered_readlines() throws Exception
    {
        call(this.stream_unbuffered_readlines, this::stream_unbuffered_readlines);
    }


    // function: Function(address=134294134, size=84, name='stream_seek', path='build/py/stream.o', joint_set={0, 32, 68, 70, 40, 74, 14, 48, 80, 24, 30}, stop_set={82, 70})
    abstract protected void stream_seek(int offset) throws Exception;
    protected int stream_seek = 0x08012a76;
    public void stream_seek() throws Exception
    {
        call(this.stream_seek, this::stream_seek);
    }


    // function: Function(address=134294218, size=22, name='stream_tell', path='build/py/stream.o', joint_set={0, 18}, stop_set={20})
    abstract protected void stream_tell(int offset) throws Exception;
    protected int stream_tell = 0x08012aca;
    public void stream_tell() throws Exception
    {
        call(this.stream_tell, this::stream_tell);
    }


    // function: Function(address=134294240, size=92, name='mp_stream_rw', path='build/py/stream.o', joint_set={0, 68, 36, 40, 76, 46, 50, 88, 28, 30}, stop_set={48, 90, 44, 86})
    abstract protected void mp_stream_rw(int offset) throws Exception;
    protected int mp_stream_rw = 0x08012ae0;
    public void mp_stream_rw() throws Exception
    {
        call(this.mp_stream_rw, this::mp_stream_rw);
    }


    // function: Function(address=134294332, size=384, name='stream_read_generic', path='build/py/stream.o', joint_set={0, 134, 266, 12, 142, 272, 150, 152, 284, 158, 32, 288, 166, 40, 296, 172, 300, 304, 308, 182, 56, 312, 190, 62, 68, 324, 200, 76, 204, 332, 208, 216, 92, 348, 94, 354, 228, 104, 360, 106, 362, 110, 240, 372, 118, 252}, stop_set={322, 360, 170, 202, 92, 374, 310, 150, 58, 188, 286})
    abstract protected void stream_read_generic(int offset) throws Exception;
    protected int stream_read_generic = 0x08012b3c;
    public void stream_read_generic() throws Exception
    {
        call(this.stream_read_generic, this::stream_read_generic);
    }


    // function: Function(address=134294716, size=10, name='stream_read', path='build/py/stream.o', joint_set={0, 8}, stop_set={8})
    abstract protected void stream_read(int offset) throws Exception;
    protected int stream_read = 0x08012cbc;
    public void stream_read() throws Exception
    {
        call(this.stream_read, this::stream_read);
    }


    // function: Function(address=134294726, size=74, name='stream_readinto', path='build/py/stream.o', joint_set={0, 64, 36, 38, 18, 52, 24, 58, 30}, stop_set={72, 60})
    abstract protected void stream_readinto(int offset) throws Exception;
    protected int stream_readinto = 0x08012cc6;
    public void stream_readinto() throws Exception
    {
        call(this.stream_readinto, this::stream_readinto);
    }


    // function: Function(address=134294800, size=64, name='mp_get_stream_raise', path='build/py/stream.o', joint_set={0, 34, 38, 8, 44, 14, 18, 52, 24, 28}, stop_set={48, 52})
    abstract protected void mp_get_stream_raise(int offset) throws Exception;
    protected int mp_get_stream_raise = 0x08012d10;
    public void mp_get_stream_raise() throws Exception
    {
        call(this.mp_get_stream_raise, this::mp_get_stream_raise);
    }


    // function: Function(address=134294864, size=32, name='mp_stream_write', path='build/py/stream.o', joint_set={0, 16, 10, 22}, stop_set={18, 30})
    abstract protected void mp_stream_write(int offset) throws Exception;
    protected int mp_stream_write = 0x08012d50;
    public void mp_stream_write() throws Exception
    {
        call(this.mp_stream_write, this::mp_stream_write);
    }


    // function: Function(address=134294896, size=96, name='stream_write_method', path='build/py/stream.o', joint_set={0, 64, 70, 42, 44, 28, 78, 18, 84, 22, 88, 56, 60, 30}, stop_set={86, 58, 94})
    abstract protected void stream_write_method(int offset) throws Exception;
    protected int stream_write_method = 0x08012d70;
    public void stream_write_method() throws Exception
    {
        call(this.stream_write_method, this::stream_write_method);
    }


    // function: Function(address=134294992, size=10, name='mp_stream_write_adaptor', path='build/py/stream.o', joint_set={0, 8}, stop_set={8})
    abstract protected void mp_stream_write_adaptor(int offset) throws Exception;
    protected int mp_stream_write_adaptor = 0x08012dd0;
    public void mp_stream_write_adaptor() throws Exception
    {
        call(this.mp_stream_write_adaptor, this::mp_stream_write_adaptor);
    }


    // function: Function(address=134295002, size=30, name='mp_stream_unbuffered_iter', path='build/py/stream.o', joint_set={0, 18, 12}, stop_set={28})
    abstract protected void mp_stream_unbuffered_iter(int offset) throws Exception;
    protected int mp_stream_unbuffered_iter = 0x08012dda;
    public void mp_stream_unbuffered_iter() throws Exception
    {
        call(this.mp_stream_unbuffered_iter, this::mp_stream_unbuffered_iter);
    }


    // function: Function(address=134295032, size=208, name='mp_binary_get_size', path='build/py/binary.o', joint_set={0, 128, 130, 6, 134, 136, 10, 140, 14, 144, 18, 20, 148, 150, 24, 26, 154, 30, 158, 34, 162, 164, 38, 168, 42, 170, 46, 174, 50, 178, 54, 182, 186, 60, 188, 192, 64, 66, 198, 70, 74, 78, 80, 84, 88, 92, 94, 96, 100, 102, 104, 108, 110, 114, 116, 120, 124}, stop_set={128, 162, 196, 102, 40, 202, 78, 142, 176, 56, 190})
    abstract protected void mp_binary_get_size(int offset) throws Exception;
    protected int mp_binary_get_size = 0x08012df8;
    public void mp_binary_get_size() throws Exception
    {
        call(this.mp_binary_get_size, this::mp_binary_get_size);
    }


    // function: Function(address=134295240, size=174, name='mp_binary_get_val_array', path='build/py/binary.o', joint_set={0, 128, 130, 6, 8, 12, 142, 14, 144, 18, 148, 22, 152, 154, 26, 30, 34, 36, 166, 40, 168, 44, 48, 50, 54, 58, 62, 64, 72, 76, 80, 84, 92, 94, 100, 106, 114, 116}, stop_set={128, 98, 70, 166, 104, 42, 172, 28, 142, 114, 152, 92})
    abstract protected void mp_binary_get_val_array(int offset) throws Exception;
    protected int mp_binary_get_val_array = 0x08012ec8;
    public void mp_binary_get_val_array() throws Exception
    {
        call(this.mp_binary_get_val_array, this::mp_binary_get_val_array);
    }


    // function: Function(address=134295414, size=82, name='mp_binary_get_int', path='build/py/binary.o', joint_set={0, 38, 70, 42, 74, 10, 16, 24}, stop_set={80, 40})
    abstract protected void mp_binary_get_int(int offset) throws Exception;
    protected int mp_binary_get_int = 0x08012f76;
    public void mp_binary_get_int() throws Exception
    {
        call(this.mp_binary_get_int, this::mp_binary_get_int);
    }


    // function: Function(address=134295496, size=168, name='mp_binary_get_val', path='build/py/binary.o', joint_set={0, 128, 130, 136, 138, 142, 16, 148, 20, 152, 154, 32, 160, 58, 66, 70, 74, 82, 84, 88, 92, 96, 100, 102, 106, 120, 124}, stop_set={160, 128, 100, 136, 82, 152})
    abstract protected void mp_binary_get_val(int offset) throws Exception;
    protected int mp_binary_get_val = 0x08012fc8;
    public void mp_binary_get_val() throws Exception
    {
        call(this.mp_binary_get_val, this::mp_binary_get_val);
    }


    // function: Function(address=134295664, size=38, name='mp_binary_set_int', path='build/py/binary.o', joint_set={0, 32, 36, 14, 24, 26}, stop_set={24, 36})
    abstract protected void mp_binary_set_int(int offset) throws Exception;
    protected int mp_binary_set_int = 0x08013070;
    public void mp_binary_set_int() throws Exception
    {
        call(this.mp_binary_set_int, this::mp_binary_set_int);
    }


    // function: Function(address=134295704, size=236, name='mp_binary_set_val', path='build/py/binary.o', joint_set={0, 140, 20, 28, 160, 164, 42, 172, 184, 188, 66, 194, 70, 200, 74, 206, 80, 82, 210, 212, 92, 220, 94, 226, 100, 104, 110, 114}, stop_set={102, 230, 186, 92, 158})
    abstract protected void mp_binary_set_val(int offset) throws Exception;
    protected int mp_binary_set_val = 0x08013098;
    public void mp_binary_set_val() throws Exception
    {
        call(this.mp_binary_set_val, this::mp_binary_set_val);
    }


    // function: Function(address=134295940, size=126, name='mp_binary_set_val_array_from_int', path='build/py/binary.o', joint_set={0, 8, 10, 14, 16, 20, 24, 26, 30, 34, 38, 44, 48, 50, 54, 58, 62, 66, 70, 74, 78, 80, 86, 98, 106, 110, 120}, stop_set={96, 64, 42, 108, 78, 84, 24, 124})
    abstract protected void mp_binary_set_val_array_from_int(int offset) throws Exception;
    protected int mp_binary_set_val_array_from_int = 0x08013184;
    public void mp_binary_set_val_array_from_int() throws Exception
    {
        call(this.mp_binary_set_val_array_from_int, this::mp_binary_set_val_array_from_int);
    }


    // function: Function(address=134296068, size=132, name='mp_binary_set_val_array', path='build/py/binary.o', joint_set={0, 38, 70, 40, 104, 42, 106, 14, 78, 48, 112, 18, 124, 52, 22, 88, 28, 62}, stop_set={40, 104, 60, 26, 124})
    abstract protected void mp_binary_set_val_array(int offset) throws Exception;
    protected int mp_binary_set_val_array = 0x08013204;
    public void mp_binary_set_val_array() throws Exception
    {
        call(this.mp_binary_set_val_array, this::mp_binary_set_val_array);
    }


    // function: Function(address=134296200, size=20, name='mp_import_stat_any', path='build/py/builtinimport.o', joint_set={0, 8, 18, 12}, stop_set={18})
    abstract protected void mp_import_stat_any(int offset) throws Exception;
    protected int mp_import_stat_any = 0x08013288;
    public void mp_import_stat_any() throws Exception
    {
        call(this.mp_import_stat_any, this::mp_import_stat_any);
    }


    // function: Function(address=134296220, size=80, name='do_execute_raw_code', path='build/py/builtinimport.o', joint_set={0, 32, 40, 44, 60, 48, 28}, stop_set={58, 70})
    abstract protected void do_execute_raw_code(int offset) throws Exception;
    protected int do_execute_raw_code = 0x0801329c;
    public void do_execute_raw_code() throws Exception
    {
        call(this.do_execute_raw_code, this::do_execute_raw_code);
    }


    // function: Function(address=134296300, size=34, name='do_load_from_lexer', path='build/py/builtinimport.o', joint_set={0, 32, 20}, stop_set={32})
    abstract protected void do_load_from_lexer(int offset) throws Exception;
    protected int do_load_from_lexer = 0x080132ec;
    public void do_load_from_lexer() throws Exception
    {
        call(this.do_load_from_lexer, this::do_load_from_lexer);
    }


    // function: Function(address=134296334, size=76, name='text_do_load', path='build/py/builtinimport.o', joint_set={0, 34, 66, 68, 74, 12, 28, 48, 52, 22, 54, 60, 62}, stop_set={74, 60})
    abstract protected void text_do_load(int offset) throws Exception;
    protected int text_do_load = 0x0801330e;
    public void text_do_load() throws Exception
    {
        call(this.text_do_load, this::text_do_load);
    }


    // function: Function(address=134296410, size=50, name='stat_file_py_or_mpy', path='build/py/builtinimport.o', joint_set={0, 34, 38, 8, 12, 44, 46, 16, 28}, stop_set={48})
    abstract protected void stat_file_py_or_mpy(int offset) throws Exception;
    protected int stat_file_py_or_mpy = 0x0801335a;
    public void stat_file_py_or_mpy() throws Exception
    {
        call(this.stat_file_py_or_mpy, this::stat_file_py_or_mpy);
    }


    // function: Function(address=134296460, size=36, name='stat_dir_or_file', path='build/py/builtinimport.o', joint_set={0, 8, 12, 16, 24, 30}, stop_set={30})
    abstract protected void stat_dir_or_file(int offset) throws Exception;
    protected int stat_dir_or_file = 0x0801338c;
    public void stat_dir_or_file() throws Exception
    {
        call(this.stat_dir_or_file, this::stat_dir_or_file);
    }


    // function: Function(address=134296496, size=772, name='mp_builtin___import__', path='build/py/builtinimport.o', joint_set={0, 514, 520, 12, 528, 20, 536, 28, 540, 36, 550, 42, 560, 52, 62, 576, 70, 584, 72, 586, 594, 84, 606, 94, 616, 104, 620, 108, 624, 116, 120, 632, 124, 126, 130, 642, 138, 652, 142, 660, 150, 666, 154, 156, 670, 678, 166, 680, 172, 686, 178, 188, 702, 194, 712, 716, 718, 210, 724, 218, 230, 236, 242, 246, 250, 258, 262, 270, 280, 284, 286, 296, 310, 314, 320, 328, 332, 336, 344, 346, 354, 362, 372, 378, 382, 388, 394, 398, 404, 408, 422, 430, 436, 444, 454, 460, 464, 466, 474, 480, 496, 500, 510}, stop_set={294, 616, 584, 330, 136, 140, 406, 726, 344, 154, 604, 126})
    abstract protected void mp_builtin___import__(int offset) throws Exception;
    protected int mp_builtin___import__ = 0x080133b0;
    public void mp_builtin___import__() throws Exception
    {
        call(this.mp_builtin___import__, this::mp_builtin___import__);
    }


    // function: Function(address=134297268, size=20, name='mp_obj_is_package', path='build/py/builtinimport.o', joint_set={0, 10}, stop_set={18})
    abstract protected void mp_obj_is_package(int offset) throws Exception;
    protected int mp_obj_is_package = 0x080136b4;
    public void mp_obj_is_package() throws Exception
    {
        call(this.mp_obj_is_package, this::mp_obj_is_package);
    }


    // function: Function(address=134297288, size=116, name='mp_builtin_compile', path='build/py/builtinevex.o', joint_set={0, 64, 66, 96, 38, 102, 72, 12, 46, 20, 52, 90, 60, 30}, stop_set={104, 62, 98, 94})
    abstract protected void mp_builtin_compile(int offset) throws Exception;
    protected int mp_builtin_compile = 0x080136c8;
    public void mp_builtin_compile() throws Exception
    {
        call(this.mp_builtin_compile, this::mp_builtin_compile);
    }


    // function: Function(address=134297404, size=240, name='eval_exec_helper', path='build/py/builtinevex.o', joint_set={0, 130, 136, 144, 20, 150, 156, 28, 32, 170, 42, 48, 178, 52, 184, 56, 188, 192, 64, 68, 202, 78, 206, 86, 218, 94, 104, 112, 114, 120, 124}, stop_set={166, 154, 204, 44, 148, 218})
    abstract protected void eval_exec_helper(int offset) throws Exception;
    protected int eval_exec_helper = 0x0801373c;
    public void eval_exec_helper() throws Exception
    {
        call(this.eval_exec_helper, this::eval_exec_helper);
    }


    // function: Function(address=134297644, size=10, name='mp_builtin_eval', path='build/py/builtinevex.o', joint_set={0, 8}, stop_set={8})
    abstract protected void mp_builtin_eval(int offset) throws Exception;
    protected int mp_builtin_eval = 0x0801382c;
    public void mp_builtin_eval() throws Exception
    {
        call(this.mp_builtin_eval, this::mp_builtin_eval);
    }


    // function: Function(address=134297654, size=10, name='mp_builtin_exec', path='build/py/builtinevex.o', joint_set={0, 8}, stop_set={8})
    abstract protected void mp_builtin_exec(int offset) throws Exception;
    protected int mp_builtin_exec = 0x08013836;
    public void mp_builtin_exec() throws Exception
    {
        call(this.mp_builtin_exec, this::mp_builtin_exec);
    }


    // function: Function(address=134297664, size=10, name='mp_builtin_execfile', path='build/py/builtinevex.o', joint_set={0, 8}, stop_set={8})
    abstract protected void mp_builtin_execfile(int offset) throws Exception;
    protected int mp_builtin_execfile = 0x08013840;
    public void mp_builtin_execfile() throws Exception
    {
        call(this.mp_builtin_execfile, this::mp_builtin_execfile);
    }


    // function: Function(address=134297674, size=44, name='mp_help_add_from_names', path='build/py/builtinhelp.o', joint_set={0, 6, 40, 12, 14, 20, 30}, stop_set={42, 12})
    abstract protected void mp_help_add_from_names(int offset) throws Exception;
    protected int mp_help_add_from_names = 0x0801384a;
    public void mp_help_add_from_names() throws Exception
    {
        call(this.mp_help_add_from_names, this::mp_help_add_from_names);
    }


    // function: Function(address=134297718, size=40, name='mp_help_add_from_map', path='build/py/builtinhelp.o', joint_set={0, 36, 8, 14, 16, 26, 30}, stop_set={38, 14})
    abstract protected void mp_help_add_from_map(int offset) throws Exception;
    protected int mp_help_add_from_map = 0x08013876;
    public void mp_help_add_from_map() throws Exception
    {
        call(this.mp_help_add_from_map, this::mp_help_add_from_map);
    }


    // function: Function(address=134297760, size=412, name='mp_builtin_help', path='build/py/builtinhelp.o', joint_set={0, 260, 132, 262, 10, 268, 140, 270, 12, 274, 18, 150, 24, 154, 286, 158, 32, 162, 40, 298, 174, 306, 50, 178, 314, 58, 188, 186, 322, 66, 196, 200, 330, 74, 332, 206, 338, 84, 216, 94, 224, 122, 234, 106, 240, 112, 116, 248, 250, 254}, stop_set={198, 268, 172, 272, 176, 338, 114, 22, 248, 186, 252})
    abstract protected void mp_builtin_help(int offset) throws Exception;
    protected int mp_builtin_help = 0x080138a0;
    public void mp_builtin_help() throws Exception
    {
        call(this.mp_builtin_help, this::mp_builtin_help);
    }


    // function: Function(address=134298172, size=12, name='mp_builtin_globals', path='build/py/modbuiltins.o', joint_set={0}, stop_set={4})
    abstract protected void mp_builtin_globals(int offset) throws Exception;
    protected int mp_builtin_globals = 0x08013a3c;
    public void mp_builtin_globals() throws Exception
    {
        call(this.mp_builtin_globals, this::mp_builtin_globals);
    }


    // function: Function(address=134298184, size=12, name='mp_builtin_locals', path='build/py/modbuiltins.o', joint_set={0}, stop_set={4})
    abstract protected void mp_builtin_locals(int offset) throws Exception;
    protected int mp_builtin_locals = 0x08013a48;
    public void mp_builtin_locals() throws Exception
    {
        call(this.mp_builtin_locals, this::mp_builtin_locals);
    }


    // function: Function(address=134298196, size=116, name='mp_builtin___build_class__', path='build/py/modbuiltins.o', joint_set={0, 64, 98, 42, 48, 50, 82, 20, 90, 30}, stop_set={102})
    abstract protected void mp_builtin___build_class__(int offset) throws Exception;
    protected int mp_builtin___build_class__ = 0x08013a54;
    public void mp_builtin___build_class__() throws Exception
    {
        call(this.mp_builtin___build_class__, this::mp_builtin___build_class__);
    }


    // function: Function(address=134298312, size=12, name='mp_builtin_abs', path='build/py/modbuiltins.o', joint_set={0, 10}, stop_set={10})
    abstract protected void mp_builtin_abs(int offset) throws Exception;
    protected int mp_builtin_abs = 0x08013ac8;
    public void mp_builtin_abs() throws Exception
    {
        call(this.mp_builtin_abs, this::mp_builtin_abs);
    }


    // function: Function(address=134298324, size=12, name='mp_builtin_hash', path='build/py/modbuiltins.o', joint_set={0, 10}, stop_set={10})
    abstract protected void mp_builtin_hash(int offset) throws Exception;
    protected int mp_builtin_hash = 0x08013ad4;
    public void mp_builtin_hash() throws Exception
    {
        call(this.mp_builtin_hash, this::mp_builtin_hash);
    }


    // function: Function(address=134298336, size=10, name='mp_builtin_iter', path='build/py/modbuiltins.o', joint_set={0, 8}, stop_set={8})
    abstract protected void mp_builtin_iter(int offset) throws Exception;
    protected int mp_builtin_iter = 0x08013ae0;
    public void mp_builtin_iter() throws Exception
    {
        call(this.mp_builtin_iter, this::mp_builtin_iter);
    }


    // function: Function(address=134298348, size=48, name='mp_builtin_all', path='build/py/modbuiltins.o', joint_set={0, 34, 8, 10, 16, 20, 22, 26, 30}, stop_set={24, 36})
    abstract protected void mp_builtin_all(int offset) throws Exception;
    protected int mp_builtin_all = 0x08013aec;
    public void mp_builtin_all() throws Exception
    {
        call(this.mp_builtin_all, this::mp_builtin_all);
    }


    // function: Function(address=134298396, size=48, name='mp_builtin_any', path='build/py/modbuiltins.o', joint_set={0, 34, 8, 10, 16, 20, 22, 26, 30}, stop_set={24, 36})
    abstract protected void mp_builtin_any(int offset) throws Exception;
    protected int mp_builtin_any = 0x08013b1c;
    public void mp_builtin_any() throws Exception
    {
        call(this.mp_builtin_any, this::mp_builtin_any);
    }


    // function: Function(address=134298444, size=22, name='mp_builtin_bin', path='build/py/modbuiltins.o', joint_set={0, 20}, stop_set={20})
    abstract protected void mp_builtin_bin(int offset) throws Exception;
    protected int mp_builtin_bin = 0x08013b4c;
    public void mp_builtin_bin() throws Exception
    {
        call(this.mp_builtin_bin, this::mp_builtin_bin);
    }


    // function: Function(address=134298468, size=28, name='mp_builtin_callable', path='build/py/modbuiltins.o', joint_set={0, 12, 6, 14}, stop_set={16})
    abstract protected void mp_builtin_callable(int offset) throws Exception;
    protected int mp_builtin_callable = 0x08013b64;
    public void mp_builtin_callable() throws Exception
    {
        call(this.mp_builtin_callable, this::mp_builtin_callable);
    }


    // function: Function(address=134298496, size=160, name='mp_builtin_chr', path='build/py/modbuiltins.o', joint_set={0, 64, 32, 100, 6, 138, 12, 16, 22, 24, 56, 94}, stop_set={136, 140, 54, 22, 92})
    abstract protected void mp_builtin_chr(int offset) throws Exception;
    protected int mp_builtin_chr = 0x08013b80;
    public void mp_builtin_chr() throws Exception
    {
        call(this.mp_builtin_chr, this::mp_builtin_chr);
    }


    // function: Function(address=134298656, size=14, name='mp_builtin_divmod', path='build/py/modbuiltins.o', joint_set={0, 12}, stop_set={12})
    abstract protected void mp_builtin_divmod(int offset) throws Exception;
    protected int mp_builtin_divmod = 0x08013c20;
    public void mp_builtin_divmod() throws Exception
    {
        call(this.mp_builtin_divmod, this::mp_builtin_divmod);
    }


    // function: Function(address=134298670, size=16, name='mp_builtin_hex', path='build/py/modbuiltins.o', joint_set={0, 14}, stop_set={14})
    abstract protected void mp_builtin_hex(int offset) throws Exception;
    protected int mp_builtin_hex = 0x08013c2e;
    public void mp_builtin_hex() throws Exception
    {
        call(this.mp_builtin_hex, this::mp_builtin_hex);
    }


    // function: Function(address=134298686, size=16, name='mp_builtin_oct', path='build/py/modbuiltins.o', joint_set={0, 14}, stop_set={14})
    abstract protected void mp_builtin_oct(int offset) throws Exception;
    protected int mp_builtin_oct = 0x08013c3e;
    public void mp_builtin_oct() throws Exception
    {
        call(this.mp_builtin_oct, this::mp_builtin_oct);
    }


    // function: Function(address=134298702, size=52, name='mp_builtin_sum', path='build/py/modbuiltins.o', joint_set={0, 34, 40, 12, 14, 48, 22, 24, 30}, stop_set={50, 38})
    abstract protected void mp_builtin_sum(int offset) throws Exception;
    protected int mp_builtin_sum = 0x08013c4e;
    public void mp_builtin_sum() throws Exception
    {
        call(this.mp_builtin_sum, this::mp_builtin_sum);
    }


    // function: Function(address=134298756, size=224, name='mp_builtin_min_max', path='build/py/modbuiltins.o', joint_set={0, 132, 140, 148, 22, 150, 154, 28, 32, 36, 166, 172, 46, 176, 52, 182, 188, 60, 68, 70, 200, 74, 78, 206, 82, 92, 96, 102, 106, 110, 120, 124, 126}, stop_set={130, 206, 80, 180, 184})
    abstract protected void mp_builtin_min_max(int offset) throws Exception;
    protected int mp_builtin_min_max = 0x08013c84;
    public void mp_builtin_min_max() throws Exception
    {
        call(this.mp_builtin_min_max, this::mp_builtin_min_max);
    }


    // function: Function(address=134298980, size=10, name='mp_builtin_max', path='build/py/modbuiltins.o', joint_set={0, 8}, stop_set={8})
    abstract protected void mp_builtin_max(int offset) throws Exception;
    protected int mp_builtin_max = 0x08013d64;
    public void mp_builtin_max() throws Exception
    {
        call(this.mp_builtin_max, this::mp_builtin_max);
    }


    // function: Function(address=134298990, size=10, name='mp_builtin_min', path='build/py/modbuiltins.o', joint_set={0, 8}, stop_set={8})
    abstract protected void mp_builtin_min(int offset) throws Exception;
    protected int mp_builtin_min = 0x08013d6e;
    public void mp_builtin_min() throws Exception
    {
        call(this.mp_builtin_min, this::mp_builtin_min);
    }


    // function: Function(address=134299000, size=100, name='mp_builtin_ord', path='build/py/modbuiltins.o', joint_set={0, 32, 64, 40, 72, 10, 46, 82, 52, 20, 56, 24, 58}, stop_set={56, 82, 70})
    abstract protected void mp_builtin_ord(int offset) throws Exception;
    protected int mp_builtin_ord = 0x08013d78;
    public void mp_builtin_ord() throws Exception
    {
        call(this.mp_builtin_ord, this::mp_builtin_ord);
    }


    // function: Function(address=134299100, size=132, name='mp_builtin_print', path='build/py/modbuiltins.o', joint_set={0, 34, 66, 102, 72, 114, 82, 52, 88, 26, 92, 62}, stop_set={116, 86})
    abstract protected void mp_builtin_print(int offset) throws Exception;
    protected int mp_builtin_print = 0x08013ddc;
    public void mp_builtin_print() throws Exception
    {
        call(this.mp_builtin_print, this::mp_builtin_print);
    }


    // function: Function(address=134299232, size=44, name='mp_builtin_repr', path='build/py/modbuiltins.o', joint_set={0, 16, 26, 34}, stop_set={36})
    abstract protected void mp_builtin_repr(int offset) throws Exception;
    protected int mp_builtin_repr = 0x08013e60;
    public void mp_builtin_repr() throws Exception
    {
        call(this.mp_builtin_repr, this::mp_builtin_repr);
    }


    // function: Function(address=134299276, size=108, name='mp_builtin_round', path='build/py/modbuiltins.o', joint_set={0, 96, 34, 38, 72, 12, 44, 76, 92, 16, 50, 82, 86, 54, 24, 88, 28, 62}, stop_set={96, 86, 30})
    abstract protected void mp_builtin_round(int offset) throws Exception;
    protected int mp_builtin_round = 0x08013e8c;
    public void mp_builtin_round() throws Exception
    {
        call(this.mp_builtin_round, this::mp_builtin_round);
    }


    // function: Function(address=134299384, size=60, name='mp_builtin_sorted', path='build/py/modbuiltins.o', joint_set={0, 18, 44, 12}, stop_set={48, 14})
    abstract protected void mp_builtin_sorted(int offset) throws Exception;
    protected int mp_builtin_sorted = 0x08013ef8;
    public void mp_builtin_sorted() throws Exception
    {
        call(this.mp_builtin_sorted, this::mp_builtin_sorted);
    }


    // function: Function(address=134299444, size=44, name='mp_builtin_hasattr', path='build/py/modbuiltins.o', joint_set={0, 32, 10, 22, 30}, stop_set={32})
    abstract protected void mp_builtin_hasattr(int offset) throws Exception;
    protected int mp_builtin_hasattr = 0x08013f34;
    public void mp_builtin_hasattr() throws Exception
    {
        call(this.mp_builtin_hasattr, this::mp_builtin_hasattr);
    }


    // function: Function(address=134299488, size=68, name='mp_builtin_getattr', path='build/py/modbuiltins.o', joint_set={0, 40, 8, 10, 48, 18, 54, 56, 26, 28}, stop_set={58})
    abstract protected void mp_builtin_getattr(int offset) throws Exception;
    protected int mp_builtin_getattr = 0x08013f60;
    public void mp_builtin_getattr() throws Exception
    {
        call(this.mp_builtin_getattr, this::mp_builtin_getattr);
    }


    // function: Function(address=134299556, size=32, name='mp_builtin_setattr', path='build/py/modbuiltins.o', joint_set={0, 12, 22}, stop_set={24})
    abstract protected void mp_builtin_setattr(int offset) throws Exception;
    protected int mp_builtin_setattr = 0x08013fa4;
    public void mp_builtin_setattr() throws Exception
    {
        call(this.mp_builtin_setattr, this::mp_builtin_setattr);
    }


    // function: Function(address=134299588, size=10, name='mp_builtin_delattr', path='build/py/modbuiltins.o', joint_set={0, 8}, stop_set={8})
    abstract protected void mp_builtin_delattr(int offset) throws Exception;
    protected int mp_builtin_delattr = 0x08013fc4;
    public void mp_builtin_delattr() throws Exception
    {
        call(this.mp_builtin_delattr, this::mp_builtin_delattr);
    }


    // function: Function(address=134299600, size=144, name='mp_builtin_dir', path='build/py/modbuiltins.o', joint_set={0, 32, 26, 100, 58, 122, 38, 136, 104, 76, 16, 112, 82, 48, 52, 24, 94, 126, 62}, stop_set={124, 138, 36, 60})
    abstract protected void mp_builtin_dir(int offset) throws Exception;
    protected int mp_builtin_dir = 0x08013fd0;
    public void mp_builtin_dir() throws Exception
    {
        call(this.mp_builtin_dir, this::mp_builtin_dir);
    }


    // function: Function(address=134299744, size=28, name='mp_builtin_next', path='build/py/modbuiltins.o', joint_set={0, 6, 10, 16, 20}, stop_set={16, 20})
    abstract protected void mp_builtin_next(int offset) throws Exception;
    protected int mp_builtin_next = 0x08014060;
    public void mp_builtin_next() throws Exception
    {
        call(this.mp_builtin_next, this::mp_builtin_next);
    }


    // function: Function(address=134299772, size=34, name='mp_builtin_pow', path='build/py/modbuiltins.o', joint_set={0, 32, 14, 24, 26}, stop_set={24, 32})
    abstract protected void mp_builtin_pow(int offset) throws Exception;
    protected int mp_builtin_pow = 0x0801407c;
    public void mp_builtin_pow() throws Exception
    {
        call(this.mp_builtin_pow, this::mp_builtin_pow);
    }


    // function: Function(address=134299808, size=76, name='mp_builtin___repl_print__', path='build/py/modbuiltins.o', joint_set={0, 10, 50, 22, 30}, stop_set={54})
    abstract protected void mp_builtin___repl_print__(int offset) throws Exception;
    protected int mp_builtin___repl_print__ = 0x080140a0;
    public void mp_builtin___repl_print__() throws Exception
    {
        call(this.mp_builtin___repl_print__, this::mp_builtin___repl_print__);
    }


    // function: Function(address=134299884, size=24, name='gc_disable', path='build/py/modgc.o', joint_set={0}, stop_set={10})
    abstract protected void gc_disable(int offset) throws Exception;
    protected int gc_disable = 0x080140ec;
    public void gc_disable() throws Exception
    {
        call(this.gc_disable, this::gc_disable);
    }


    // function: Function(address=134299908, size=24, name='gc_enable', path='build/py/modgc.o', joint_set={0}, stop_set={10})
    abstract protected void gc_enable(int offset) throws Exception;
    protected int gc_enable = 0x08014104;
    public void gc_enable() throws Exception
    {
        call(this.gc_enable, this::gc_enable);
    }


    // function: Function(address=134299932, size=32, name='gc_isenabled', path='build/py/modgc.o', joint_set={0, 12, 14}, stop_set={14})
    abstract protected void gc_isenabled(int offset) throws Exception;
    protected int gc_isenabled = 0x0801411c;
    public void gc_isenabled() throws Exception
    {
        call(this.gc_isenabled, this::gc_isenabled);
    }


    // function: Function(address=134299964, size=28, name='py_gc_collect', path='build/py/modgc.o', joint_set={0, 6}, stop_set={20})
    abstract protected void py_gc_collect(int offset) throws Exception;
    protected int py_gc_collect = 0x0801413c;
    public void py_gc_collect() throws Exception
    {
        call(this.py_gc_collect, this::py_gc_collect);
    }


    // function: Function(address=134299992, size=22, name='gc_mem_free', path='build/py/modgc.o', joint_set={0, 10}, stop_set={20})
    abstract protected void gc_mem_free(int offset) throws Exception;
    protected int gc_mem_free = 0x08014158;
    public void gc_mem_free() throws Exception
    {
        call(this.gc_mem_free, this::gc_mem_free);
    }


    // function: Function(address=134300014, size=22, name='gc_mem_alloc', path='build/py/modgc.o', joint_set={0, 10}, stop_set={20})
    abstract protected void gc_mem_alloc(int offset) throws Exception;
    protected int gc_mem_alloc = 0x0801416e;
    public void gc_mem_alloc() throws Exception
    {
        call(this.gc_mem_alloc, this::gc_mem_alloc);
    }


    // function: Function(address=134300036, size=60, name='gc_threshold', path='build/py/modgc.o', joint_set={0, 34, 40, 44, 12, 48, 20, 26, 28}, stop_set={26, 50, 46})
    abstract protected void gc_threshold(int offset) throws Exception;
    protected int gc_threshold = 0x08014184;
    public void gc_threshold() throws Exception
    {
        call(this.gc_threshold, this::gc_threshold);
    }


    // function: Function(address=134300096, size=224, name='resource_stream', path='build/py/modio.o', joint_set={0, 128, 134, 146, 22, 28, 158, 168, 178, 50, 58, 186, 64, 68, 198, 74, 84, 92, 100, 110, 124}, stop_set={176, 64, 200})
    abstract protected void resource_stream(int offset) throws Exception;
    protected int resource_stream = 0x080141c0;
    public void resource_stream() throws Exception
    {
        call(this.resource_stream, this::resource_stream);
    }


    // function: Function(address=134300320, size=6, name='fabs_funcf', path='build/py/modmath.o', joint_set={0}, stop_set={4})
    abstract protected void fabs_funcf(int offset) throws Exception;
    protected int fabs_funcf = 0x080142a0;
    public void fabs_funcf() throws Exception
    {
        call(this.fabs_funcf, this::fabs_funcf);
    }


    // function: Function(address=134300328, size=20, name='log2f', path='build/py/modmath.o', joint_set={0, 12, 6}, stop_set={12})
    abstract protected void log2f(int offset) throws Exception;
    protected int log2f = 0x080142a8;
    public void log2f() throws Exception
    {
        call(this.log2f, this::log2f);
    }


    // function: Function(address=134300348, size=32, name='mp_math_isnan', path='build/py/modmath.o', joint_set={0, 6, 12, 18, 20}, stop_set={22})
    abstract protected void mp_math_isnan(int offset) throws Exception;
    protected int mp_math_isnan = 0x080142bc;
    public void mp_math_isnan() throws Exception
    {
        call(this.mp_math_isnan, this::mp_math_isnan);
    }


    // function: Function(address=134300380, size=56, name='mp_math_isfinite', path='build/py/modmath.o', joint_set={0, 34, 36, 6, 38, 18, 22, 30}, stop_set={40, 36})
    abstract protected void mp_math_isfinite(int offset) throws Exception;
    protected int mp_math_isfinite = 0x080142dc;
    public void mp_math_isfinite() throws Exception
    {
        call(this.mp_math_isfinite, this::mp_math_isfinite);
    }


    // function: Function(address=134300436, size=56, name='mp_math_isinf', path='build/py/modmath.o', joint_set={0, 34, 36, 38, 6, 18, 22, 30}, stop_set={40, 36})
    abstract protected void mp_math_isinf(int offset) throws Exception;
    protected int mp_math_isinf = 0x08014314;
    public void mp_math_isinf() throws Exception
    {
        call(this.mp_math_isinf, this::mp_math_isinf);
    }


    // function: Function(address=134300492, size=24, name='mp_math_degrees', path='build/py/modmath.o', joint_set={0, 16, 12, 6}, stop_set={16})
    abstract protected void mp_math_degrees(int offset) throws Exception;
    protected int mp_math_degrees = 0x0801434c;
    public void mp_math_degrees() throws Exception
    {
        call(this.mp_math_degrees, this::mp_math_degrees);
    }


    // function: Function(address=134300516, size=24, name='mp_math_radians', path='build/py/modmath.o', joint_set={0, 16, 12, 6}, stop_set={16})
    abstract protected void mp_math_radians(int offset) throws Exception;
    protected int mp_math_radians = 0x08014364;
    public void mp_math_radians() throws Exception
    {
        call(this.mp_math_radians, this::mp_math_radians);
    }


    // function: Function(address=134300540, size=16, name='mp_math_trunc', path='build/py/modmath.o', joint_set={0, 10, 6, 14}, stop_set={14})
    abstract protected void mp_math_trunc(int offset) throws Exception;
    protected int mp_math_trunc = 0x0801437c;
    public void mp_math_trunc() throws Exception
    {
        call(this.mp_math_trunc, this::mp_math_trunc);
    }


    // function: Function(address=134300556, size=42, name='mp_math_modf', path='build/py/modmath.o', joint_set={0, 38, 10, 16, 20, 28}, stop_set={40})
    abstract protected void mp_math_modf(int offset) throws Exception;
    protected int mp_math_modf = 0x0801438c;
    public void mp_math_modf() throws Exception
    {
        call(this.mp_math_modf, this::mp_math_modf);
    }


    // function: Function(address=134300598, size=30, name='mp_math_ldexp', path='build/py/modmath.o', joint_set={0, 8, 16, 24, 28}, stop_set={28})
    abstract protected void mp_math_ldexp(int offset) throws Exception;
    protected int mp_math_ldexp = 0x080143b6;
    public void mp_math_ldexp() throws Exception
    {
        call(this.mp_math_ldexp, this::mp_math_ldexp);
    }


    // function: Function(address=134300628, size=42, name='mp_math_frexp', path='build/py/modmath.o', joint_set={0, 38, 10, 16, 20, 28}, stop_set={40})
    abstract protected void mp_math_frexp(int offset) throws Exception;
    protected int mp_math_frexp = 0x080143d4;
    public void mp_math_frexp() throws Exception
    {
        call(this.mp_math_frexp, this::mp_math_frexp);
    }


    // function: Function(address=134300670, size=16, name='mp_math_floor', path='build/py/modmath.o', joint_set={0, 10, 6, 14}, stop_set={14})
    abstract protected void mp_math_floor(int offset) throws Exception;
    protected int mp_math_floor = 0x080143fe;
    public void mp_math_floor() throws Exception
    {
        call(this.mp_math_floor, this::mp_math_floor);
    }


    // function: Function(address=134300686, size=12, name='copysign_funcf', path='build/py/modmath.o', joint_set={0}, stop_set={10})
    abstract protected void copysign_funcf(int offset) throws Exception;
    protected int copysign_funcf = 0x0801440e;
    public void copysign_funcf() throws Exception
    {
        call(this.copysign_funcf, this::copysign_funcf);
    }


    // function: Function(address=134300698, size=16, name='mp_math_ceil', path='build/py/modmath.o', joint_set={0, 10, 6, 14}, stop_set={14})
    abstract protected void mp_math_ceil(int offset) throws Exception;
    protected int mp_math_ceil = 0x0801441a;
    public void mp_math_ceil() throws Exception
    {
        call(this.mp_math_ceil, this::mp_math_ceil);
    }


    // function: Function(address=134300716, size=116, name='math_generic_1', path='build/py/modmath.o', joint_set={0, 64, 98, 32, 36, 8, 104, 76, 92, 48, 80, 20, 52, 88, 24, 60}, stop_set={104, 94})
    abstract protected void math_generic_1(int offset) throws Exception;
    protected int math_generic_1 = 0x0801442c;
    public void math_generic_1() throws Exception
    {
        call(this.math_generic_1, this::math_generic_1);
    }


    // function: Function(address=134300832, size=16, name='mp_math_lgamma', path='build/py/modmath.o', joint_set={0, 8}, stop_set={8})
    abstract protected void mp_math_lgamma(int offset) throws Exception;
    protected int mp_math_lgamma = 0x080144a0;
    public void mp_math_lgamma() throws Exception
    {
        call(this.mp_math_lgamma, this::mp_math_lgamma);
    }


    // function: Function(address=134300848, size=16, name='mp_math_gamma', path='build/py/modmath.o', joint_set={0, 8}, stop_set={8})
    abstract protected void mp_math_gamma(int offset) throws Exception;
    protected int mp_math_gamma = 0x080144b0;
    public void mp_math_gamma() throws Exception
    {
        call(this.mp_math_gamma, this::mp_math_gamma);
    }


    // function: Function(address=134300864, size=16, name='mp_math_erfc', path='build/py/modmath.o', joint_set={0, 8}, stop_set={8})
    abstract protected void mp_math_erfc(int offset) throws Exception;
    protected int mp_math_erfc = 0x080144c0;
    public void mp_math_erfc() throws Exception
    {
        call(this.mp_math_erfc, this::mp_math_erfc);
    }


    // function: Function(address=134300880, size=16, name='mp_math_erf', path='build/py/modmath.o', joint_set={0, 8}, stop_set={8})
    abstract protected void mp_math_erf(int offset) throws Exception;
    protected int mp_math_erf = 0x080144d0;
    public void mp_math_erf() throws Exception
    {
        call(this.mp_math_erf, this::mp_math_erf);
    }


    // function: Function(address=134300896, size=16, name='mp_math_fabs', path='build/py/modmath.o', joint_set={0, 8}, stop_set={8})
    abstract protected void mp_math_fabs(int offset) throws Exception;
    protected int mp_math_fabs = 0x080144e0;
    public void mp_math_fabs() throws Exception
    {
        call(this.mp_math_fabs, this::mp_math_fabs);
    }


    // function: Function(address=134300912, size=16, name='mp_math_atan', path='build/py/modmath.o', joint_set={0, 8}, stop_set={8})
    abstract protected void mp_math_atan(int offset) throws Exception;
    protected int mp_math_atan = 0x080144f0;
    public void mp_math_atan() throws Exception
    {
        call(this.mp_math_atan, this::mp_math_atan);
    }


    // function: Function(address=134300928, size=16, name='mp_math_asin', path='build/py/modmath.o', joint_set={0, 8}, stop_set={8})
    abstract protected void mp_math_asin(int offset) throws Exception;
    protected int mp_math_asin = 0x08014500;
    public void mp_math_asin() throws Exception
    {
        call(this.mp_math_asin, this::mp_math_asin);
    }


    // function: Function(address=134300944, size=16, name='mp_math_acos', path='build/py/modmath.o', joint_set={0, 8}, stop_set={8})
    abstract protected void mp_math_acos(int offset) throws Exception;
    protected int mp_math_acos = 0x08014510;
    public void mp_math_acos() throws Exception
    {
        call(this.mp_math_acos, this::mp_math_acos);
    }


    // function: Function(address=134300960, size=16, name='mp_math_tan', path='build/py/modmath.o', joint_set={0, 8}, stop_set={8})
    abstract protected void mp_math_tan(int offset) throws Exception;
    protected int mp_math_tan = 0x08014520;
    public void mp_math_tan() throws Exception
    {
        call(this.mp_math_tan, this::mp_math_tan);
    }


    // function: Function(address=134300976, size=16, name='mp_math_sin', path='build/py/modmath.o', joint_set={0, 8}, stop_set={8})
    abstract protected void mp_math_sin(int offset) throws Exception;
    protected int mp_math_sin = 0x08014530;
    public void mp_math_sin() throws Exception
    {
        call(this.mp_math_sin, this::mp_math_sin);
    }


    // function: Function(address=134300992, size=16, name='mp_math_cos', path='build/py/modmath.o', joint_set={0, 8}, stop_set={8})
    abstract protected void mp_math_cos(int offset) throws Exception;
    protected int mp_math_cos = 0x08014540;
    public void mp_math_cos() throws Exception
    {
        call(this.mp_math_cos, this::mp_math_cos);
    }


    // function: Function(address=134301008, size=16, name='mp_math_atanh', path='build/py/modmath.o', joint_set={0, 8}, stop_set={8})
    abstract protected void mp_math_atanh(int offset) throws Exception;
    protected int mp_math_atanh = 0x08014550;
    public void mp_math_atanh() throws Exception
    {
        call(this.mp_math_atanh, this::mp_math_atanh);
    }


    // function: Function(address=134301024, size=16, name='mp_math_asinh', path='build/py/modmath.o', joint_set={0, 8}, stop_set={8})
    abstract protected void mp_math_asinh(int offset) throws Exception;
    protected int mp_math_asinh = 0x08014560;
    public void mp_math_asinh() throws Exception
    {
        call(this.mp_math_asinh, this::mp_math_asinh);
    }


    // function: Function(address=134301040, size=16, name='mp_math_acosh', path='build/py/modmath.o', joint_set={0, 8}, stop_set={8})
    abstract protected void mp_math_acosh(int offset) throws Exception;
    protected int mp_math_acosh = 0x08014570;
    public void mp_math_acosh() throws Exception
    {
        call(this.mp_math_acosh, this::mp_math_acosh);
    }


    // function: Function(address=134301056, size=16, name='mp_math_tanh', path='build/py/modmath.o', joint_set={0, 8}, stop_set={8})
    abstract protected void mp_math_tanh(int offset) throws Exception;
    protected int mp_math_tanh = 0x08014580;
    public void mp_math_tanh() throws Exception
    {
        call(this.mp_math_tanh, this::mp_math_tanh);
    }


    // function: Function(address=134301072, size=16, name='mp_math_sinh', path='build/py/modmath.o', joint_set={0, 8}, stop_set={8})
    abstract protected void mp_math_sinh(int offset) throws Exception;
    protected int mp_math_sinh = 0x08014590;
    public void mp_math_sinh() throws Exception
    {
        call(this.mp_math_sinh, this::mp_math_sinh);
    }


    // function: Function(address=134301088, size=16, name='mp_math_cosh', path='build/py/modmath.o', joint_set={0, 8}, stop_set={8})
    abstract protected void mp_math_cosh(int offset) throws Exception;
    protected int mp_math_cosh = 0x080145a0;
    public void mp_math_cosh() throws Exception
    {
        call(this.mp_math_cosh, this::mp_math_cosh);
    }


    // function: Function(address=134301104, size=16, name='mp_math_log10', path='build/py/modmath.o', joint_set={0, 8}, stop_set={8})
    abstract protected void mp_math_log10(int offset) throws Exception;
    protected int mp_math_log10 = 0x080145b0;
    public void mp_math_log10() throws Exception
    {
        call(this.mp_math_log10, this::mp_math_log10);
    }


    // function: Function(address=134301120, size=16, name='mp_math_log2', path='build/py/modmath.o', joint_set={0, 8}, stop_set={8})
    abstract protected void mp_math_log2(int offset) throws Exception;
    protected int mp_math_log2 = 0x080145c0;
    public void mp_math_log2() throws Exception
    {
        call(this.mp_math_log2, this::mp_math_log2);
    }


    // function: Function(address=134301136, size=16, name='mp_math_expm1', path='build/py/modmath.o', joint_set={0, 8}, stop_set={8})
    abstract protected void mp_math_expm1(int offset) throws Exception;
    protected int mp_math_expm1 = 0x080145d0;
    public void mp_math_expm1() throws Exception
    {
        call(this.mp_math_expm1, this::mp_math_expm1);
    }


    // function: Function(address=134301152, size=16, name='mp_math_exp', path='build/py/modmath.o', joint_set={0, 8}, stop_set={8})
    abstract protected void mp_math_exp(int offset) throws Exception;
    protected int mp_math_exp = 0x080145e0;
    public void mp_math_exp() throws Exception
    {
        call(this.mp_math_exp, this::mp_math_exp);
    }


    // function: Function(address=134301168, size=16, name='mp_math_sqrt', path='build/py/modmath.o', joint_set={0, 8}, stop_set={8})
    abstract protected void mp_math_sqrt(int offset) throws Exception;
    protected int mp_math_sqrt = 0x080145f0;
    public void mp_math_sqrt() throws Exception
    {
        call(this.mp_math_sqrt, this::mp_math_sqrt);
    }


    // function: Function(address=134301184, size=140, name='math_generic_2', path='build/py/modmath.o', joint_set={0, 34, 130, 58, 102, 38, 10, 74, 106, 78, 46, 18, 114, 50, 86, 118, 90, 124, 62}, stop_set={120, 130})
    abstract protected void math_generic_2(int offset) throws Exception;
    protected int math_generic_2 = 0x08014600;
    public void math_generic_2() throws Exception
    {
        call(this.math_generic_2, this::math_generic_2);
    }


    // function: Function(address=134301324, size=16, name='mp_math_fmod', path='build/py/modmath.o', joint_set={0, 8}, stop_set={8})
    abstract protected void mp_math_fmod(int offset) throws Exception;
    protected int mp_math_fmod = 0x0801468c;
    public void mp_math_fmod() throws Exception
    {
        call(this.mp_math_fmod, this::mp_math_fmod);
    }


    // function: Function(address=134301340, size=16, name='mp_math_copysign', path='build/py/modmath.o', joint_set={0, 8}, stop_set={8})
    abstract protected void mp_math_copysign(int offset) throws Exception;
    protected int mp_math_copysign = 0x0801469c;
    public void mp_math_copysign() throws Exception
    {
        call(this.mp_math_copysign, this::mp_math_copysign);
    }


    // function: Function(address=134301356, size=16, name='mp_math_atan2', path='build/py/modmath.o', joint_set={0, 8}, stop_set={8})
    abstract protected void mp_math_atan2(int offset) throws Exception;
    protected int mp_math_atan2 = 0x080146ac;
    public void mp_math_atan2() throws Exception
    {
        call(this.mp_math_atan2, this::mp_math_atan2);
    }


    // function: Function(address=134301372, size=16, name='mp_math_pow', path='build/py/modmath.o', joint_set={0, 8}, stop_set={8})
    abstract protected void mp_math_pow(int offset) throws Exception;
    protected int mp_math_pow = 0x080146bc;
    public void mp_math_pow() throws Exception
    {
        call(this.mp_math_pow, this::mp_math_pow);
    }


    // function: Function(address=134301388, size=116, name='mp_math_log', path='build/py/modmath.o', joint_set={0, 96, 36, 100, 70, 42, 74, 12, 48, 82, 20, 56, 24, 88, 60, 30}, stop_set={26, 100, 78})
    abstract protected void mp_math_log(int offset) throws Exception;
    protected int mp_math_log = 0x080146cc;
    public void mp_math_log() throws Exception
    {
        call(this.mp_math_log, this::mp_math_log);
    }


    // function: Function(address=134301504, size=66, name='mp_cmath_sin', path='build/py/modcmath.o', joint_set={0, 32, 64, 40, 10, 16, 48, 24, 58}, stop_set={64})
    abstract protected void mp_cmath_sin(int offset) throws Exception;
    protected int mp_cmath_sin = 0x08014740;
    public void mp_cmath_sin() throws Exception
    {
        call(this.mp_cmath_sin, this::mp_cmath_sin);
    }


    // function: Function(address=134301570, size=70, name='mp_cmath_cos', path='build/py/modcmath.o', joint_set={0, 32, 68, 40, 10, 16, 52, 24, 62}, stop_set={68})
    abstract protected void mp_cmath_cos(int offset) throws Exception;
    protected int mp_cmath_cos = 0x08014782;
    public void mp_cmath_cos() throws Exception
    {
        call(this.mp_cmath_cos, this::mp_cmath_cos);
    }


    // function: Function(address=134301640, size=102, name='mp_cmath_sqrt', path='build/py/modcmath.o', joint_set={0, 64, 100, 38, 70, 10, 46, 78, 20, 84, 56, 94, 30}, stop_set={100})
    abstract protected void mp_cmath_sqrt(int offset) throws Exception;
    protected int mp_cmath_sqrt = 0x080147c8;
    public void mp_cmath_sqrt() throws Exception
    {
        call(this.mp_cmath_sqrt, this::mp_cmath_sqrt);
    }


    // function: Function(address=134301744, size=84, name='mp_cmath_log10', path='build/py/modcmath.o', joint_set={0, 38, 70, 10, 42, 76, 20, 52, 58, 30}, stop_set={76})
    abstract protected void mp_cmath_log10(int offset) throws Exception;
    protected int mp_cmath_log10 = 0x08014830;
    public void mp_cmath_log10() throws Exception
    {
        call(this.mp_cmath_log10, this::mp_cmath_log10);
    }


    // function: Function(address=134301828, size=72, name='mp_cmath_log', path='build/py/modcmath.o', joint_set={0, 64, 38, 70, 10, 42, 20, 52, 30}, stop_set={70})
    abstract protected void mp_cmath_log(int offset) throws Exception;
    protected int mp_cmath_log = 0x08014884;
    public void mp_cmath_log() throws Exception
    {
        call(this.mp_cmath_log, this::mp_cmath_log);
    }


    // function: Function(address=134301900, size=58, name='mp_cmath_exp', path='build/py/modcmath.o', joint_set={0, 34, 40, 10, 16, 50, 56, 26}, stop_set={56})
    abstract protected void mp_cmath_exp(int offset) throws Exception;
    protected int mp_cmath_exp = 0x080148cc;
    public void mp_cmath_exp() throws Exception
    {
        call(this.mp_cmath_exp, this::mp_cmath_exp);
    }


    // function: Function(address=134301958, size=54, name='mp_cmath_rect', path='build/py/modcmath.o', joint_set={0, 36, 8, 46, 16, 52, 22, 30}, stop_set={52})
    abstract protected void mp_cmath_rect(int offset) throws Exception;
    protected int mp_cmath_rect = 0x08014906;
    public void mp_cmath_rect() throws Exception
    {
        call(this.mp_cmath_rect, this::mp_cmath_rect);
    }


    // function: Function(address=134302012, size=24, name='mp_cmath_phase', path='build/py/modcmath.o', joint_set={0, 10, 18, 22}, stop_set={22})
    abstract protected void mp_cmath_phase(int offset) throws Exception;
    protected int mp_cmath_phase = 0x0801493c;
    public void mp_cmath_phase() throws Exception
    {
        call(this.mp_cmath_phase, this::mp_cmath_phase);
    }


    // function: Function(address=134302036, size=76, name='mp_cmath_polar', path='build/py/modcmath.o', joint_set={0, 32, 40, 72, 12, 44, 48, 22, 58, 62}, stop_set={74})
    abstract protected void mp_cmath_polar(int offset) throws Exception;
    protected int mp_cmath_polar = 0x08014954;
    public void mp_cmath_polar() throws Exception
    {
        call(this.mp_cmath_polar, this::mp_cmath_polar);
    }


    // function: Function(address=134302112, size=20, name='mp_micropython_pystack_use', path='build/py/modmicropython.o', joint_set={0}, stop_set={14})
    abstract protected void mp_micropython_pystack_use(int offset) throws Exception;
    protected int mp_micropython_pystack_use = 0x080149a0;
    public void mp_micropython_pystack_use() throws Exception
    {
        call(this.mp_micropython_pystack_use, this::mp_micropython_pystack_use);
    }


    // function: Function(address=134302132, size=14, name='mp_micropython_mem_total', path='build/py/modmicropython.o', joint_set={0, 6}, stop_set={12})
    abstract protected void mp_micropython_mem_total(int offset) throws Exception;
    protected int mp_micropython_mem_total = 0x080149b4;
    public void mp_micropython_mem_total() throws Exception
    {
        call(this.mp_micropython_mem_total, this::mp_micropython_mem_total);
    }


    // function: Function(address=134302146, size=14, name='mp_micropython_mem_current', path='build/py/modmicropython.o', joint_set={0, 6}, stop_set={12})
    abstract protected void mp_micropython_mem_current(int offset) throws Exception;
    protected int mp_micropython_mem_current = 0x080149c2;
    public void mp_micropython_mem_current() throws Exception
    {
        call(this.mp_micropython_mem_current, this::mp_micropython_mem_current);
    }


    // function: Function(address=134302160, size=14, name='mp_micropython_mem_peak', path='build/py/modmicropython.o', joint_set={0, 6}, stop_set={12})
    abstract protected void mp_micropython_mem_peak(int offset) throws Exception;
    protected int mp_micropython_mem_peak = 0x080149d0;
    public void mp_micropython_mem_peak() throws Exception
    {
        call(this.mp_micropython_mem_peak, this::mp_micropython_mem_peak);
    }


    // function: Function(address=134302174, size=14, name='mp_micropython_stack_use', path='build/py/modmicropython.o', joint_set={0, 6}, stop_set={12})
    abstract protected void mp_micropython_stack_use(int offset) throws Exception;
    protected int mp_micropython_stack_use = 0x080149de;
    public void mp_micropython_stack_use() throws Exception
    {
        call(this.mp_micropython_stack_use, this::mp_micropython_stack_use);
    }


    // function: Function(address=134302188, size=92, name='mp_micropython_mem_info', path='build/py/modmicropython.o', joint_set={0, 66, 36, 8, 40, 14, 20, 54, 58, 62}, stop_set={68})
    abstract protected void mp_micropython_mem_info(int offset) throws Exception;
    protected int mp_micropython_mem_info = 0x080149ec;
    public void mp_micropython_mem_info() throws Exception
    {
        call(this.mp_micropython_mem_info, this::mp_micropython_mem_info);
    }


    // function: Function(address=134302280, size=20, name='mp_micropython_kbd_intr', path='build/py/modmicropython.o', joint_set={0, 10, 6}, stop_set={12})
    abstract protected void mp_micropython_kbd_intr(int offset) throws Exception;
    protected int mp_micropython_kbd_intr = 0x08014a48;
    public void mp_micropython_kbd_intr() throws Exception
    {
        call(this.mp_micropython_kbd_intr, this::mp_micropython_kbd_intr);
    }


    // function: Function(address=134302300, size=16, name='mp_micropython_heap_unlock', path='build/py/modmicropython.o', joint_set={0, 6}, stop_set={8})
    abstract protected void mp_micropython_heap_unlock(int offset) throws Exception;
    protected int mp_micropython_heap_unlock = 0x08014a5c;
    public void mp_micropython_heap_unlock() throws Exception
    {
        call(this.mp_micropython_heap_unlock, this::mp_micropython_heap_unlock);
    }


    // function: Function(address=134302316, size=16, name='mp_micropython_heap_lock', path='build/py/modmicropython.o', joint_set={0, 6}, stop_set={8})
    abstract protected void mp_micropython_heap_lock(int offset) throws Exception;
    protected int mp_micropython_heap_lock = 0x08014a6c;
    public void mp_micropython_heap_lock() throws Exception
    {
        call(this.mp_micropython_heap_lock, this::mp_micropython_heap_lock);
    }


    // function: Function(address=134302332, size=64, name='mp_micropython_qstr_info', path='build/py/modmicropython.o', joint_set={0, 38, 42, 46, 18}, stop_set={50})
    abstract protected void mp_micropython_qstr_info(int offset) throws Exception;
    protected int mp_micropython_qstr_info = 0x08014a7c;
    public void mp_micropython_qstr_info() throws Exception
    {
        call(this.mp_micropython_qstr_info, this::mp_micropython_qstr_info);
    }


    // function: Function(address=134302396, size=36, name='mp_micropython_schedule', path='build/py/modmicropython.o', joint_set={0, 18, 10, 6}, stop_set={20, 14})
    abstract protected void mp_micropython_schedule(int offset) throws Exception;
    protected int mp_micropython_schedule = 0x08014abc;
    public void mp_micropython_schedule() throws Exception
    {
        call(this.mp_micropython_schedule, this::mp_micropython_schedule);
    }


    // function: Function(address=134302432, size=44, name='mp_micropython_opt_level', path='build/py/modmicropython.o', joint_set={0, 12, 20, 22, 28}, stop_set={32, 20})
    abstract protected void mp_micropython_opt_level(int offset) throws Exception;
    protected int mp_micropython_opt_level = 0x08014ae0;
    public void mp_micropython_opt_level() throws Exception
    {
        call(this.mp_micropython_opt_level, this::mp_micropython_opt_level);
    }


    // function: Function(address=134302476, size=36, name='get_fmt_type', path='build/py/modstruct.o', joint_set={0, 32, 8, 12, 16, 20, 24, 28}, stop_set={18, 34, 30})
    abstract protected void get_fmt_type(int offset) throws Exception;
    protected int get_fmt_type = 0x08014b0c;
    public void get_fmt_type() throws Exception
    {
        call(this.get_fmt_type, this::get_fmt_type);
    }


    // function: Function(address=134302512, size=44, name='get_fmt_num', path='build/py/modstruct.o', joint_set={0, 36, 8, 16, 26}, stop_set={42})
    abstract protected void get_fmt_num(int offset) throws Exception;
    protected int get_fmt_num = 0x08014b30;
    public void get_fmt_num() throws Exception
    {
        call(this.get_fmt_num, this::get_fmt_num);
    }


    // function: Function(address=134302556, size=102, name='calc_size_items', path='build/py/modstruct.o', joint_set={0, 66, 36, 40, 74, 46, 16, 82, 20, 52, 54, 62, 90, 28, 94}, stop_set={72, 34, 100})
    abstract protected void calc_size_items(int offset) throws Exception;
    protected int calc_size_items = 0x08014b5c;
    public void calc_size_items() throws Exception
    {
        call(this.calc_size_items, this::calc_size_items);
    }


    // function: Function(address=134302658, size=22, name='struct_calcsize', path='build/py/modstruct.o', joint_set={0, 12, 6}, stop_set={20})
    abstract protected void struct_calcsize(int offset) throws Exception;
    protected int struct_calcsize = 0x08014bc2;
    public void struct_calcsize() throws Exception
    {
        call(this.struct_calcsize, this::struct_calcsize);
    }


    // function: Function(address=134302680, size=216, name='struct_unpack_from', path='build/py/modstruct.o', joint_set={0, 128, 132, 138, 140, 14, 148, 22, 154, 30, 160, 40, 170, 52, 182, 190, 66, 72, 204, 76, 82, 88, 94, 108, 112, 118}, stop_set={116, 210, 180, 84})
    abstract protected void struct_unpack_from(int offset) throws Exception;
    protected int struct_unpack_from = 0x08014bd8;
    public void struct_unpack_from() throws Exception
    {
        call(this.struct_unpack_from, this::struct_unpack_from);
    }


    // function: Function(address=134302896, size=160, name='struct_pack_into_internal', path='build/py/modstruct.o', joint_set={0, 132, 14, 144, 22, 152, 26, 30, 34, 42, 46, 52, 58, 60, 68, 70, 76, 80, 94, 98, 114, 120, 122}, stop_set={32, 96, 158})
    abstract protected void struct_pack_into_internal(int offset) throws Exception;
    protected int struct_pack_into_internal = 0x08014cb0;
    public void struct_pack_into_internal() throws Exception
    {
        call(this.struct_pack_into_internal, this::struct_pack_into_internal);
    }


    // function: Function(address=134303056, size=68, name='struct_pack', path='build/py/modstruct.o', joint_set={0, 38, 16, 52, 26, 60}, stop_set={62})
    abstract protected void struct_pack(int offset) throws Exception;
    protected int struct_pack = 0x08014d50;
    public void struct_pack() throws Exception
    {
        call(this.struct_pack, this::struct_pack);
    }


    // function: Function(address=134303124, size=92, name='struct_pack_into', path='build/py/modstruct.o', joint_set={0, 64, 36, 42, 78, 18, 24, 56, 28}, stop_set={82, 38})
    abstract protected void struct_pack_into(int offset) throws Exception;
    protected int struct_pack_into = 0x08014d94;
    public void struct_pack_into() throws Exception
    {
        call(this.struct_pack_into, this::struct_pack_into);
    }


    // function: Function(address=134303216, size=32, name='mp_sys_exit', path='build/py/modsys.o', joint_set={0, 10, 14, 18, 24}, stop_set={24, 14})
    abstract protected void mp_sys_exit(int offset) throws Exception;
    protected int mp_sys_exit = 0x08014df0;
    public void mp_sys_exit() throws Exception
    {
        call(this.mp_sys_exit, this::mp_sys_exit);
    }


    // function: Function(address=134303248, size=52, name='mp_sys_print_exception', path='build/py/modsys.o', joint_set={0, 34, 10, 18, 20}, stop_set={36})
    abstract protected void mp_sys_print_exception(int offset) throws Exception;
    protected int mp_sys_print_exception = 0x08014e10;
    public void mp_sys_print_exception() throws Exception
    {
        call(this.mp_sys_print_exception, this::mp_sys_print_exception);
    }


    // function: Function(address=134303300, size=56, name='mp_sys_exc_info', path='build/py/modsys.o', joint_set={0, 34, 40, 16, 24, 28}, stop_set={32, 44})
    abstract protected void mp_sys_exc_info(int offset) throws Exception;
    protected int mp_sys_exc_info = 0x08014e44;
    public void mp_sys_exc_info() throws Exception
    {
        call(this.mp_sys_exc_info, this::mp_sys_exc_info);
    }


    // function: Function(address=134303356, size=12, name='mp_sys_getsizeof', path='build/py/modsys.o', joint_set={0, 10}, stop_set={10})
    abstract protected void mp_sys_getsizeof(int offset) throws Exception;
    protected int mp_sys_getsizeof = 0x08014e7c;
    public void mp_sys_getsizeof() throws Exception
    {
        call(this.mp_sys_getsizeof, this::mp_sys_getsizeof);
    }


    // function: Function(address=134303368, size=28, name='mp_errno_to_str', path='build/py/moduerrno.o', joint_set={0, 18, 14, 22}, stop_set={22})
    abstract protected void mp_errno_to_str(int offset) throws Exception;
    protected int mp_errno_to_str = 0x08014e88;
    public void mp_errno_to_str() throws Exception
    {
        call(this.mp_errno_to_str, this::mp_errno_to_str);
    }


    // function: Function(address=134303396, size=4440, name='mp_execute_bytecode', path='build/py/vm.o', joint_set={0, 4100, 520, 4106, 534, 26, 542, 36, 562, 66, 72, 76, 78, 3662, 1108, 1114, 90, 92, 1116, 1120, 98, 100, 1124, 3172, 3174, 3688, 1128, 3178, 1132, 110, 3182, 3694, 116, 3188, 1142, 3702, 1144, 3704, 124, 4220, 3710, 1152, 4224, 3712, 1156, 1158, 3718, 3720, 1162, 4234, 140, 3728, 4240, 146, 3218, 3732, 144, 1174, 3224, 154, 156, 3232, 162, 3746, 3234, 166, 3240, 680, 172, 174, 3248, 3250, 690, 3768, 186, 3262, 194, 3266, 3276, 3278, 216, 3802, 3806, 224, 738, 3302, 742, 232, 746, 3308, 238, 3310, 240, 750, 4340, 4346, 4350, 256, 3328, 1792, 3844, 4362, 778, 4366, 4370, 4378, 3866, 3358, 4384, 802, 1826, 292, 4388, 3370, 300, 3372, 304, 3892, 822, 3382, 3894, 320, 836, 328, 848, 852, 858, 360, 372, 890, 894, 384, 394, 400, 914, 3990, 4000, 420, 4004, 4006, 4012, 436, 4022, 438, 4026, 442, 4034, 452, 4038, 4042, 4046, 4052, 472, 4060, 4066, 4072, 508}, stop_set={1156, 4108, 780, 144, 532, 154, 1180, 3232, 1828, 4004, 678, 3238, 554, 4394, 172, 3370, 3248, 436, 948, 3384, 440, 4284, 450, 708, 3276, 3916, 76, 1114, 90, 98, 3306, 238, 370, 1142, 3702, 506, 4348, 3710})
    abstract protected void mp_execute_bytecode(int offset) throws Exception;
    protected int mp_execute_bytecode = 0x08014ea4;
    public void mp_execute_bytecode() throws Exception
    {
        call(this.mp_execute_bytecode, this::mp_execute_bytecode);
    }


    // function: Function(address=134307836, size=36, name='unlikely_fun_pos_args_mismatch', path='build/py/bc.o', joint_set={0, 24, 10}, stop_set={24})
    abstract protected void unlikely_fun_pos_args_mismatch(int offset) throws Exception;
    protected int unlikely_fun_pos_args_mismatch = 0x08015ffc;
    public void unlikely_fun_pos_args_mismatch() throws Exception
    {
        call(this.unlikely_fun_pos_args_mismatch, this::unlikely_fun_pos_args_mismatch);
    }


    // function: Function(address=134307872, size=32, name='mp_decode_uint', path='build/py/bc.o', joint_set={0, 10, 28}, stop_set={30})
    abstract protected void mp_decode_uint(int offset) throws Exception;
    protected int mp_decode_uint = 0x08016020;
    public void mp_decode_uint() throws Exception
    {
        call(this.mp_decode_uint, this::mp_decode_uint);
    }


    // function: Function(address=134307904, size=12, name='mp_decode_uint_value', path='build/py/bc.o', joint_set={0, 10}, stop_set={10})
    abstract protected void mp_decode_uint_value(int offset) throws Exception;
    protected int mp_decode_uint_value = 0x08016040;
    public void mp_decode_uint_value() throws Exception
    {
        call(this.mp_decode_uint_value, this::mp_decode_uint_value);
    }


    // function: Function(address=134307916, size=12, name='mp_decode_uint_skip', path='build/py/bc.o', joint_set={0, 10}, stop_set={10})
    abstract protected void mp_decode_uint_skip(int offset) throws Exception;
    protected int mp_decode_uint_skip = 0x0801604c;
    public void mp_decode_uint_skip() throws Exception
    {
        call(this.mp_decode_uint_skip, this::mp_decode_uint_skip);
    }


    // function: Function(address=134307928, size=720, name='mp_setup_code_state', path='build/py/bc.o', joint_set={0, 512, 642, 384, 516, 390, 648, 266, 524, 270, 526, 272, 656, 654, 532, 662, 150, 666, 538, 284, 412, 156, 288, 544, 290, 416, 160, 38, 166, 552, 682, 46, 304, 560, 434, 564, 310, 312, 184, 188, 446, 190, 450, 322, 196, 324, 578, 194, 456, 202, 332, 462, 334, 208, 210, 340, 472, 600, 346, 352, 224, 230, 358, 488, 616, 234, 250, 492, 620, 364, 624, 498, 116, 244, 502, 628, 374, 506, 636}, stop_set={514, 644, 524, 270, 654, 664, 410, 542, 414, 288, 686, 558, 432, 562, 310, 194, 460, 332, 208, 338, 498, 626, 634, 510})
    abstract protected void mp_setup_code_state(int offset) throws Exception;
    protected int mp_setup_code_state = 0x08016058;
    public void mp_setup_code_state() throws Exception
    {
        call(this.mp_setup_code_state, this::mp_setup_code_state);
    }


    // function: Function(address=134308648, size=84, name='mp_opcode_format', path='build/py/bc.o', joint_set={0, 64, 36, 72, 76, 46, 52, 28, 62}, stop_set={78, 70})
    abstract protected void mp_opcode_format(int offset) throws Exception;
    protected int mp_opcode_format = 0x08016328;
    public void mp_opcode_format() throws Exception
    {
        call(this.mp_opcode_format, this::mp_opcode_format);
    }


    // function: Function(address=134308732, size=54, name='str_startswith_word', path='build/py/repl.o', joint_set={0, 32, 36, 6, 40, 14, 50, 18, 22, 24, 28}, stop_set={48, 52, 22, 30})
    abstract protected void str_startswith_word(int offset) throws Exception;
    protected int str_startswith_word = 0x0801637c;
    public void str_startswith_word() throws Exception
    {
        call(this.str_startswith_word, this::str_startswith_word);
    }


    // function: Function(address=134308788, size=388, name='mp_repl_continue_with_input', path='build/py/repl.o', joint_set={0, 256, 260, 132, 264, 136, 10, 268, 14, 144, 18, 148, 278, 282, 156, 30, 286, 288, 160, 292, 36, 168, 44, 172, 302, 48, 306, 52, 180, 310, 184, 56, 190, 62, 320, 194, 324, 198, 328, 72, 202, 332, 204, 78, 336, 208, 84, 212, 340, 86, 216, 90, 346, 120, 350, 96, 352, 224, 228, 100, 234, 108, 240, 112, 124, 244, 248, 252}, stop_set={354, 322, 326, 330, 202, 300, 334, 238, 210, 276, 182, 88, 250, 318})
    abstract protected void mp_repl_continue_with_input(int offset) throws Exception;
    protected int mp_repl_continue_with_input = 0x080163b4;
    public void mp_repl_continue_with_input() throws Exception
    {
        call(this.mp_repl_continue_with_input, this::mp_repl_continue_with_input);
    }


    // function: Function(address=134309176, size=524, name='mp_repl_autocomplete', path='build/py/repl.o', joint_set={0, 384, 134, 264, 138, 14, 146, 276, 406, 22, 280, 408, 154, 26, 32, 288, 418, 36, 164, 292, 40, 296, 168, 428, 46, 432, 50, 180, 310, 56, 440, 186, 60, 318, 446, 194, 322, 196, 452, 200, 204, 460, 334, 76, 78, 466, 82, 212, 214, 342, 88, 472, 350, 94, 224, 480, 230, 102, 360, 488, 106, 108, 236, 494, 366, 112, 116, 248, 378, 252, 126}, stop_set={290, 294, 38, 262, 136, 332, 492, 110, 430, 496, 114, 308, 278, 24, 286})
    abstract protected void mp_repl_autocomplete(int offset) throws Exception;
    protected int mp_repl_autocomplete = 0x08016538;
    public void mp_repl_autocomplete() throws Exception
    {
        call(this.mp_repl_autocomplete, this::mp_repl_autocomplete);
    }


    // function: Function(address=134309700, size=104, name='mp_small_int_mul_overflow', path='build/py/smallint.o', joint_set={0, 64, 70, 72, 40, 10, 78, 46, 48, 14, 52, 20, 86, 30, 56, 26, 92, 94}, stop_set={96, 50, 28, 70})
    abstract protected void mp_small_int_mul_overflow(int offset) throws Exception;
    protected int mp_small_int_mul_overflow = 0x08016744;
    public void mp_small_int_mul_overflow() throws Exception
    {
        call(this.mp_small_int_mul_overflow, this::mp_small_int_mul_overflow);
    }


    // function: Function(address=134309804, size=32, name='mp_small_int_modulo', path='build/py/smallint.o', joint_set={0, 8, 12, 16, 20, 24, 28}, stop_set={18, 30})
    abstract protected void mp_small_int_modulo(int offset) throws Exception;
    protected int mp_small_int_modulo = 0x080167ac;
    public void mp_small_int_modulo() throws Exception
    {
        call(this.mp_small_int_modulo, this::mp_small_int_modulo);
    }


    // function: Function(address=134309836, size=30, name='mp_small_int_floor_divide', path='build/py/smallint.o', joint_set={0, 6, 10, 14, 18, 20, 24}, stop_set={18, 28})
    abstract protected void mp_small_int_floor_divide(int offset) throws Exception;
    protected int mp_small_int_floor_divide = 0x080167cc;
    public void mp_small_int_floor_divide() throws Exception
    {
        call(this.mp_small_int_floor_divide, this::mp_small_int_floor_divide);
    }


    // function: Function(address=134309866, size=72, name='mp_frozen_stat_helper', path='build/py/frozenmod.o', joint_set={0, 64, 34, 68, 12, 44, 14, 48, 20, 22, 54, 58, 28}, stop_set={70, 66, 20, 62})
    abstract protected void mp_frozen_stat_helper(int offset) throws Exception;
    protected int mp_frozen_stat_helper = 0x080167ea;
    public void mp_frozen_stat_helper() throws Exception
    {
        call(this.mp_frozen_stat_helper, this::mp_frozen_stat_helper);
    }


    // function: Function(address=134309940, size=104, name='mp_find_frozen_str', path='build/py/frozenmod.o', joint_set={0, 64, 68, 38, 14, 46, 50, 20, 26}, stop_set={88, 66})
    abstract protected void mp_find_frozen_str(int offset) throws Exception;
    protected int mp_find_frozen_str = 0x08016834;
    public void mp_find_frozen_str() throws Exception
    {
        call(this.mp_find_frozen_str, this::mp_find_frozen_str);
    }


    // function: Function(address=134310044, size=36, name='mp_frozen_stat', path='build/py/frozenmod.o', joint_set={0, 24, 12, 16}, stop_set={24})
    abstract protected void mp_frozen_stat(int offset) throws Exception;
    protected int mp_frozen_stat = 0x0801689c;
    public void mp_frozen_stat() throws Exception
    {
        call(this.mp_frozen_stat, this::mp_frozen_stat);
    }


    // function: Function(address=134310080, size=128, name='mp_find_frozen_module', path='build/py/frozenmod.o', joint_set={0, 96, 34, 100, 104, 40, 72, 108, 78, 46, 60, 18, 86, 22, 56, 28}, stop_set={106, 76, 118})
    abstract protected void mp_find_frozen_module(int offset) throws Exception;
    protected int mp_find_frozen_module = 0x080168c0;
    public void mp_find_frozen_module() throws Exception
    {
        call(this.mp_find_frozen_module, this::mp_find_frozen_module);
    }


    // function: Function(address=134310208, size=20, name='uctypes_struct_addressof', path='build/extmod/moductypes.o', joint_set={0, 16, 10}, stop_set={18})
    abstract protected void uctypes_struct_addressof(int offset) throws Exception;
    protected int uctypes_struct_addressof = 0x08016940;
    public void uctypes_struct_addressof() throws Exception
    {
        call(this.uctypes_struct_addressof, this::uctypes_struct_addressof);
    }


    // function: Function(address=134310228, size=28, name='uctypes_struct_bytearray_at', path='build/extmod/moductypes.o', joint_set={0, 26, 10, 18}, stop_set={26})
    abstract protected void uctypes_struct_bytearray_at(int offset) throws Exception;
    protected int uctypes_struct_bytearray_at = 0x08016954;
    public void uctypes_struct_bytearray_at() throws Exception
    {
        call(this.uctypes_struct_bytearray_at, this::uctypes_struct_bytearray_at);
    }


    // function: Function(address=134310256, size=26, name='uctypes_struct_bytes_at', path='build/extmod/moductypes.o', joint_set={0, 8, 16, 24}, stop_set={24})
    abstract protected void uctypes_struct_bytes_at(int offset) throws Exception;
    protected int uctypes_struct_bytes_at = 0x08016970;
    public void uctypes_struct_bytes_at() throws Exception
    {
        call(this.uctypes_struct_bytes_at, this::uctypes_struct_bytes_at);
    }


    // function: Function(address=134310282, size=150, name='get_aligned', path='build/extmod/moductypes.o', joint_set={0, 6, 8, 138, 140, 12, 144, 16, 148, 20, 24, 28, 32, 34, 38, 42, 54, 56, 60, 64, 76, 78, 80, 86, 90, 92, 94, 100, 106, 114, 116, 124, 126}, stop_set={98, 104, 138, 76, 124, 114, 148, 84, 54, 26, 92})
    abstract protected void get_aligned(int offset) throws Exception;
    protected int get_aligned = 0x0801698a;
    public void get_aligned() throws Exception
    {
        call(this.get_aligned, this::get_aligned);
    }


    // function: Function(address=134310432, size=66, name='uctypes_struct_make_new', path='build/extmod/moductypes.o', joint_set={0, 40, 54, 24, 62, 60, 30}, stop_set={64})
    abstract protected void uctypes_struct_make_new(int offset) throws Exception;
    protected int uctypes_struct_make_new = 0x08016a20;
    public void uctypes_struct_make_new() throws Exception
    {
        call(this.uctypes_struct_make_new, this::uctypes_struct_make_new);
    }


    // function: Function(address=134310500, size=88, name='uctypes_struct_print', path='build/extmod/moductypes.o', joint_set={0, 34, 40, 10, 44, 46, 18, 54, 24}, stop_set={42, 54})
    abstract protected void uctypes_struct_print(int offset) throws Exception;
    protected int uctypes_struct_print = 0x08016a64;
    public void uctypes_struct_print() throws Exception
    {
        call(this.uctypes_struct_print, this::uctypes_struct_print);
    }


    // function: Function(address=134310588, size=112, name='set_aligned', path='build/extmod/moductypes.o', joint_set={0, 32, 64, 96, 98, 34, 70, 102, 38, 74, 76, 48, 80, 52, 20, 56, 24, 58, 28, 62}, stop_set={32, 96, 100, 68, 106, 46})
    abstract protected void set_aligned(int offset) throws Exception;
    protected int set_aligned = 0x08016abc;
    public void set_aligned() throws Exception
    {
        call(this.set_aligned, this::set_aligned);
    }


    // function: Function(address=134310700, size=236, name='uctypes_struct_size', path='build/extmod/moductypes.o', joint_set={0, 128, 130, 134, 140, 18, 146, 26, 154, 156, 30, 160, 36, 42, 174, 52, 58, 186, 190, 196, 70, 74, 206, 210, 82, 214, 94, 98, 104, 114, 120, 122}, stop_set={132, 138, 208, 188, 216, 56, 156})
    abstract protected void uctypes_struct_size(int offset) throws Exception;
    protected int uctypes_struct_size = 0x08016b2c;
    public void uctypes_struct_size() throws Exception
    {
        call(this.uctypes_struct_size, this::uctypes_struct_size);
    }


    // function: Function(address=134310936, size=64, name='uctypes_struct_sizeof', path='build/extmod/moductypes.o', joint_set={0, 32, 36, 42, 10, 50, 18, 22, 24}, stop_set={48, 52, 22})
    abstract protected void uctypes_struct_sizeof(int offset) throws Exception;
    protected int uctypes_struct_sizeof = 0x08016c18;
    public void uctypes_struct_sizeof() throws Exception
    {
        call(this.uctypes_struct_sizeof, this::uctypes_struct_sizeof);
    }


    // function: Function(address=134311000, size=80, name='uctypes_struct_agg_size', path='build/extmod/moductypes.o', joint_set={0, 66, 68, 38, 72, 10, 42, 14, 78, 18, 22, 54, 28, 30}, stop_set={70, 40, 78, 20, 28})
    abstract protected void uctypes_struct_agg_size(int offset) throws Exception;
    protected int uctypes_struct_agg_size = 0x08016c58;
    public void uctypes_struct_agg_size() throws Exception
    {
        call(this.uctypes_struct_agg_size, this::uctypes_struct_agg_size);
    }


    // function: Function(address=134311080, size=34, name='uctypes_get_buffer', path='build/extmod/moductypes.o', joint_set={0, 20}, stop_set={32})
    abstract protected void uctypes_get_buffer(int offset) throws Exception;
    protected int uctypes_get_buffer = 0x08016ca8;
    public void uctypes_get_buffer() throws Exception
    {
        call(this.uctypes_get_buffer, this::uctypes_get_buffer);
    }


    // function: Function(address=134311116, size=312, name='uctypes_struct_subscr', path='build/extmod/moductypes.o', joint_set={0, 130, 260, 134, 10, 142, 144, 18, 280, 26, 158, 32, 160, 164, 42, 176, 52, 184, 60, 64, 70, 202, 80, 212, 86, 218, 92, 98, 230, 108, 236, 240, 242, 116, 118, 252}, stop_set={96, 132, 60, 240, 210, 278, 282, 28, 158})
    abstract protected void uctypes_struct_subscr(int offset) throws Exception;
    protected int uctypes_struct_subscr = 0x08016ccc;
    public void uctypes_struct_subscr() throws Exception
    {
        call(this.uctypes_struct_subscr, this::uctypes_struct_subscr);
    }


    // function: Function(address=134311428, size=532, name='uctypes_struct_attr_op', path='build/extmod/moductypes.o', joint_set={0, 256, 384, 132, 260, 134, 388, 264, 396, 400, 146, 148, 404, 22, 156, 158, 30, 288, 32, 416, 36, 292, 420, 424, 298, 426, 172, 46, 174, 432, 54, 438, 56, 448, 322, 72, 456, 202, 458, 78, 336, 464, 340, 212, 88, 344, 346, 216, 92, 474, 350, 222, 224, 354, 100, 358, 486, 104, 492, 238, 114, 254, 120, 124, 382}, stop_set={32, 352, 290, 258, 356, 484, 102, 262, 456, 424, 172, 398, 146, 500, 118, 254, 344, 54, 348, 382})
    abstract protected void uctypes_struct_attr_op(int offset) throws Exception;
    protected int uctypes_struct_attr_op = 0x08016e04;
    public void uctypes_struct_attr_op() throws Exception
    {
        call(this.uctypes_struct_attr_op, this::uctypes_struct_attr_op);
    }


    // function: Function(address=134311960, size=34, name='uctypes_struct_attr', path='build/extmod/moductypes.o', joint_set={0, 10, 14, 16, 18, 24, 28}, stop_set={16, 32})
    abstract protected void uctypes_struct_attr(int offset) throws Exception;
    protected int uctypes_struct_attr = 0x08017018;
    public void uctypes_struct_attr() throws Exception
    {
        call(this.uctypes_struct_attr, this::uctypes_struct_attr);
    }


    // function: Function(address=134311994, size=42, name='ujson_stream_next', path='build/extmod/modujson.o', joint_set={0, 32, 36, 38, 28}, stop_set={40, 28})
    abstract protected void ujson_stream_next(int offset) throws Exception;
    protected int ujson_stream_next = 0x0801703a;
    public void ujson_stream_next() throws Exception
    {
        call(this.ujson_stream_next, this::ujson_stream_next);
    }


    // function: Function(address=134312036, size=760, name='mod_ujson_load', path='build/extmod/modujson.o', joint_set={0, 512, 516, 520, 12, 528, 534, 544, 36, 548, 554, 46, 558, 50, 566, 56, 58, 574, 64, 578, 68, 580, 72, 74, 586, 588, 78, 80, 596, 84, 598, 88, 92, 606, 98, 614, 102, 616, 106, 108, 622, 112, 628, 116, 634, 122, 636, 126, 128, 642, 646, 134, 648, 652, 142, 144, 148, 662, 150, 154, 668, 156, 160, 676, 164, 678, 166, 170, 684, 172, 176, 690, 694, 182, 700, 188, 702, 192, 706, 708, 198, 714, 202, 716, 208, 210, 722, 214, 216, 728, 218, 734, 226, 228, 236, 240, 248, 250, 258, 264, 268, 270, 274, 278, 284, 286, 302, 306, 312, 318, 322, 328, 332, 338, 342, 348, 352, 358, 360, 366, 370, 372, 378, 382, 384, 390, 394, 398, 404, 410, 412, 416, 420, 426, 428, 432, 436, 440, 444, 448, 452, 456, 460, 466, 482, 486, 496, 504, 510}, stop_set={514, 262, 646, 392, 510, 650, 268, 142, 666, 154, 284, 676, 164, 426, 304, 56, 442, 700, 446, 576, 706, 450, 454, 72, 714, 586, 596, 726, 214, 350, 94, 736, 226, 126, 358, 614, 106, 626, 370, 248, 634, 382})
    abstract protected void mod_ujson_load(int offset) throws Exception;
    protected int mod_ujson_load = 0x08017064;
    public void mod_ujson_load() throws Exception
    {
        call(this.mod_ujson_load, this::mod_ujson_load);
    }


    // function: Function(address=134312796, size=56, name='mod_ujson_loads', path='build/extmod/modujson.o', joint_set={0, 10, 46}, stop_set={48})
    abstract protected void mod_ujson_loads(int offset) throws Exception;
    protected int mod_ujson_loads = 0x0801735c;
    public void mod_ujson_loads() throws Exception
    {
        call(this.mod_ujson_loads, this::mod_ujson_loads);
    }


    // function: Function(address=134312852, size=44, name='mod_ujson_dump', path='build/extmod/modujson.o', joint_set={0, 14, 30}, stop_set={32})
    abstract protected void mod_ujson_dump(int offset) throws Exception;
    protected int mod_ujson_dump = 0x08017394;
    public void mod_ujson_dump() throws Exception
    {
        call(this.mod_ujson_dump, this::mod_ujson_dump);
    }


    // function: Function(address=134312896, size=44, name='mod_ujson_dumps', path='build/extmod/modujson.o', joint_set={0, 16, 26, 34}, stop_set={36})
    abstract protected void mod_ujson_dumps(int offset) throws Exception;
    protected int mod_ujson_dumps = 0x080173c0;
    public void mod_ujson_dumps() throws Exception
    {
        call(this.mod_ujson_dumps, this::mod_ujson_dumps);
    }


    // function: Function(address=134312940, size=16, name='match_print', path='build/extmod/modure.o', joint_set={0, 10}, stop_set={10})
    abstract protected void match_print(int offset) throws Exception;
    protected int match_print = 0x080173ec;
    public void match_print() throws Exception
    {
        call(this.match_print, this::match_print);
    }


    // function: Function(address=134312956, size=16, name='re_print', path='build/extmod/modure.o', joint_set={0, 10}, stop_set={10})
    abstract protected void re_print(int offset) throws Exception;
    protected int re_print = 0x080173fc;
    public void re_print() throws Exception
    {
        call(this.re_print, this::re_print);
    }


    // function: Function(address=134312972, size=860, name='_compilecode', path='build/extmod/modure.o', joint_set={0, 526, 14, 18, 538, 30, 36, 40, 46, 558, 50, 570, 62, 576, 66, 68, 582, 70, 586, 588, 76, 78, 592, 80, 84, 86, 88, 604, 94, 96, 616, 620, 624, 114, 630, 118, 120, 636, 124, 640, 128, 644, 134, 136, 140, 144, 656, 660, 150, 662, 152, 666, 160, 164, 678, 168, 172, 174, 688, 178, 702, 192, 196, 200, 202, 714, 718, 722, 728, 218, 732, 224, 738, 228, 742, 234, 746, 238, 240, 754, 244, 758, 250, 762, 252, 764, 256, 768, 258, 264, 780, 784, 786, 282, 284, 800, 292, 804, 294, 300, 816, 310, 320, 322, 834, 328, 844, 848, 344, 856, 346, 354, 358, 364, 374, 378, 386, 390, 396, 400, 410, 414, 420, 426, 428, 438, 442, 448, 456, 462, 470, 480, 484, 490, 496, 502}, stop_set={256, 384, 134, 394, 778, 524, 654, 784, 660, 150, 282, 158, 298, 172, 568, 60, 446, 574, 320, 832, 66, 580, 586, 76, 846, 84, 858, 94, 736, 762, 356, 232, 362, 238, 112, 756, 634, 118, 250})
    abstract protected void _compilecode(int offset) throws Exception;
    protected int _compilecode = 0x0801740c;
    public void _compilecode() throws Exception
    {
        call(this._compilecode, this::_compilecode);
    }


    // function: Function(address=134313832, size=72, name='match_group', path='build/extmod/modure.o', joint_set={0, 34, 12, 46, 16, 52, 22, 62, 30}, stop_set={62, 30})
    abstract protected void match_group(int offset) throws Exception;
    protected int match_group = 0x08017768;
    public void match_group() throws Exception
    {
        call(this.match_group, this::match_group);
    }


    // function: Function(address=134313904, size=44, name='re1_5_sizecode', path='build/extmod/modure.o', joint_set={0, 32, 34, 38, 14, 28}, stop_set={42, 36})
    abstract protected void re1_5_sizecode(int offset) throws Exception;
    protected int re1_5_sizecode = 0x080177b0;
    public void re1_5_sizecode() throws Exception
    {
        call(this.re1_5_sizecode, this::re1_5_sizecode);
    }


    // function: Function(address=134313948, size=84, name='re1_5_compilecode', path='build/extmod/modure.o', joint_set={0, 34, 40, 72, 46}, stop_set={74})
    abstract protected void re1_5_compilecode(int offset) throws Exception;
    protected int re1_5_compilecode = 0x080177dc;
    public void re1_5_compilecode() throws Exception
    {
        call(this.re1_5_compilecode, this::re1_5_compilecode);
    }


    // function: Function(address=134314032, size=312, name='re1_5_dumpcode', path='build/extmod/modure.o', joint_set={0, 128, 134, 138, 12, 140, 18, 150, 26, 156, 30, 160, 164, 38, 50, 52, 180, 182, 56, 60, 190, 64, 70, 198, 204, 78, 82, 84, 88, 218, 92, 220, 100, 230, 104, 232, 106, 110, 240, 114, 244, 124}, stop_set={162, 98, 230, 218, 138, 238, 242, 148, 86, 246, 122, 28})
    abstract protected void re1_5_dumpcode(int offset) throws Exception;
    protected int re1_5_dumpcode = 0x08017830;
    public void re1_5_dumpcode() throws Exception
    {
        call(this.re1_5_dumpcode, this::re1_5_dumpcode);
    }


    // function: Function(address=134314344, size=92, name='mod_re_compile', path='build/extmod/modure.o', joint_set={0, 34, 66, 70, 74, 12, 80, 48, 18, 22, 54, 56, 28}, stop_set={24, 82})
    abstract protected void mod_re_compile(int offset) throws Exception;
    protected int mod_re_compile = 0x08017968;
    public void mod_re_compile() throws Exception
    {
        call(this.mod_re_compile, this::mod_re_compile);
    }


    // function: Function(address=134314436, size=52, name='_re1_5_classmatch', path='build/extmod/modure.o', joint_set={0, 32, 38, 10, 44, 46, 14, 24}, stop_set={50, 44, 22})
    abstract protected void _re1_5_classmatch(int offset) throws Exception;
    protected int _re1_5_classmatch = 0x080179c4;
    public void _re1_5_classmatch() throws Exception
    {
        call(this._re1_5_classmatch, this::_re1_5_classmatch);
    }


    // function: Function(address=134314488, size=74, name='_re1_5_namedclassmatch', path='build/extmod/modure.o', joint_set={0, 34, 68, 38, 72, 42, 28, 48, 50, 22, 60}, stop_set={48, 32, 72})
    abstract protected void _re1_5_namedclassmatch(int offset) throws Exception;
    protected int _re1_5_namedclassmatch = 0x080179f8;
    public void _re1_5_namedclassmatch() throws Exception
    {
        call(this._re1_5_namedclassmatch, this::_re1_5_namedclassmatch);
    }


    // function: Function(address=134314562, size=280, name='recursiveloop', path='build/extmod/modure.o', joint_set={0, 258, 264, 138, 266, 142, 270, 16, 272, 144, 276, 22, 152, 156, 28, 30, 164, 36, 38, 40, 168, 44, 176, 48, 180, 52, 56, 60, 64, 72, 202, 76, 206, 80, 210, 84, 86, 216, 90, 94, 226, 100, 104, 108, 112, 116, 254}, stop_set={36, 102, 262, 154, 78, 142, 208, 270, 274, 178, 214, 278, 58, 28})
    abstract protected void recursiveloop(int offset) throws Exception;
    protected int recursiveloop = 0x08017a42;
    public void recursiveloop() throws Exception
    {
        call(this.recursiveloop, this::recursiveloop);
    }


    // function: Function(address=134314842, size=26, name='re1_5_recursiveloopprog', path='build/extmod/modure.o', joint_set={0, 24, 10, 12}, stop_set={24})
    abstract protected void re1_5_recursiveloopprog(int offset) throws Exception;
    protected int re1_5_recursiveloopprog = 0x08017b5a;
    public void re1_5_recursiveloopprog() throws Exception
    {
        call(this.re1_5_recursiveloopprog, this::re1_5_recursiveloopprog);
    }


    // function: Function(address=134314868, size=120, name='ure_exec_isra_2', path='build/extmod/modure.o', joint_set={0, 98, 44, 78, 18, 82, 90, 92, 62}, stop_set={96, 108})
    abstract protected void ure_exec_isra_2(int offset) throws Exception;
    protected int ure_exec_isra_2 = 0x08017b74;
    public void ure_exec_isra_2() throws Exception
    {
        call(this.ure_exec_isra_2, this::ure_exec_isra_2);
    }


    // function: Function(address=134314988, size=10, name='re_match', path='build/extmod/modure.o', joint_set={0, 8}, stop_set={8})
    abstract protected void re_match(int offset) throws Exception;
    protected int re_match = 0x08017bec;
    public void re_match() throws Exception
    {
        call(this.re_match, this::re_match);
    }


    // function: Function(address=134314998, size=10, name='re_search', path='build/extmod/modure.o', joint_set={0, 8}, stop_set={8})
    abstract protected void re_search(int offset) throws Exception;
    protected int re_search = 0x08017bf6;
    public void re_search() throws Exception
    {
        call(this.re_search, this::re_search);
    }


    // function: Function(address=134315008, size=30, name='mod_re_match', path='build/extmod/modure.o', joint_set={0, 10, 26}, stop_set={28})
    abstract protected void mod_re_match(int offset) throws Exception;
    protected int mod_re_match = 0x08017c00;
    public void mod_re_match() throws Exception
    {
        call(this.mod_re_match, this::mod_re_match);
    }


    // function: Function(address=134315038, size=30, name='mod_re_search', path='build/extmod/modure.o', joint_set={0, 10, 26}, stop_set={28})
    abstract protected void mod_re_search(int offset) throws Exception;
    protected int mod_re_search = 0x08017c1e;
    public void mod_re_search() throws Exception
    {
        call(this.mod_re_search, this::mod_re_search);
    }


    // function: Function(address=134315068, size=204, name='re_split', path='build/extmod/modure.o', joint_set={0, 128, 136, 142, 16, 148, 26, 156, 162, 48, 180, 54, 56, 188, 64, 78, 80, 90, 106, 110, 120}, stop_set={192, 144})
    abstract protected void re_split(int offset) throws Exception;
    protected int re_split = 0x08017c3c;
    public void re_split() throws Exception
    {
        call(this.re_split, this::re_split);
    }


    // function: Function(address=134315272, size=102, name='tinf_build_tree', path='build/extmod/moduzlib.o', joint_set={0, 34, 98, 74, 12, 48, 80, 50, 20, 54, 24, 58, 28}, stop_set={72, 56, 100})
    abstract protected void tinf_build_tree(int offset) throws Exception;
    protected int tinf_build_tree = 0x08017d08;
    public void tinf_build_tree() throws Exception
    {
        call(this.tinf_build_tree, this::tinf_build_tree);
    }


    // function: Function(address=134315376, size=56, name='read_src_stream', path='build/extmod/moduzlib.o', joint_set={0, 34, 38, 44, 48, 28}, stop_set={50, 44, 30})
    abstract protected void read_src_stream(int offset) throws Exception;
    protected int read_src_stream = 0x08017d70;
    public void read_src_stream() throws Exception
    {
        call(this.read_src_stream, this::read_src_stream);
    }


    // function: Function(address=134315432, size=22, name='uzlib_get_byte', path='build/extmod/moduzlib.o', joint_set={0, 16, 14, 8}, stop_set={20, 14})
    abstract protected void uzlib_get_byte(int offset) throws Exception;
    protected int uzlib_get_byte = 0x08017da8;
    public void uzlib_get_byte() throws Exception
    {
        call(this.uzlib_get_byte, this::uzlib_get_byte);
    }


    // function: Function(address=134315454, size=36, name='tinf_getbit', path='build/extmod/moduzlib.o', joint_set={0, 24, 18, 14}, stop_set={34})
    abstract protected void tinf_getbit(int offset) throws Exception;
    protected int tinf_getbit = 0x08017dbe;
    public void tinf_getbit() throws Exception
    {
        call(this.tinf_getbit, this::tinf_getbit);
    }


    // function: Function(address=134315490, size=44, name='tinf_read_bits', path='build/extmod/moduzlib.o', joint_set={0, 34, 38, 40, 12, 18, 22, 28}, stop_set={26, 42})
    abstract protected void tinf_read_bits(int offset) throws Exception;
    protected int tinf_read_bits = 0x08017de2;
    public void tinf_read_bits() throws Exception
    {
        call(this.tinf_read_bits, this::tinf_read_bits);
    }


    // function: Function(address=134315534, size=42, name='tinf_decode_symbol', path='build/extmod/moduzlib.o', joint_set={0, 18, 32, 12}, stop_set={40})
    abstract protected void tinf_decode_symbol(int offset) throws Exception;
    protected int tinf_decode_symbol = 0x08017e0e;
    public void tinf_decode_symbol() throws Exception
    {
        call(this.tinf_decode_symbol, this::tinf_decode_symbol);
    }


    // function: Function(address=134315576, size=268, name='tinf_decode_trees', path='build/extmod/moduzlib.o', joint_set={0, 128, 140, 20, 148, 152, 156, 32, 160, 44, 50, 180, 182, 186, 60, 62, 190, 66, 198, 76, 78, 208, 216, 88, 220, 226, 98, 236, 114, 244, 118, 248, 254}, stop_set={224, 260, 196, 138, 252, 116, 188})
    abstract protected void tinf_decode_trees(int offset) throws Exception;
    protected int tinf_decode_trees = 0x08017e38;
    public void tinf_decode_trees() throws Exception
    {
        call(this.tinf_decode_trees, this::tinf_decode_trees);
    }


    // function: Function(address=134315844, size=30, name='tinf_get_le_uint32', path='build/extmod/moduzlib.o', joint_set={0, 8, 14, 16, 24}, stop_set={28, 14})
    abstract protected void tinf_get_le_uint32(int offset) throws Exception;
    protected int tinf_get_le_uint32 = 0x08017f44;
    public void tinf_get_le_uint32() throws Exception
    {
        call(this.tinf_get_le_uint32, this::tinf_get_le_uint32);
    }


    // function: Function(address=134315874, size=28, name='tinf_get_be_uint32', path='build/extmod/moduzlib.o', joint_set={0, 8, 14, 16, 24}, stop_set={26, 14})
    abstract protected void tinf_get_be_uint32(int offset) throws Exception;
    protected int tinf_get_be_uint32 = 0x08017f62;
    public void tinf_get_be_uint32() throws Exception
    {
        call(this.tinf_get_be_uint32, this::tinf_get_be_uint32);
    }


    // function: Function(address=134315904, size=640, name='uzlib_uncompress', path='build/extmod/moduzlib.o', joint_set={0, 386, 258, 262, 8, 392, 524, 14, 16, 272, 400, 276, 22, 416, 544, 34, 292, 420, 548, 40, 298, 300, 430, 432, 304, 434, 560, 564, 306, 310, 438, 572, 318, 574, 576, 190, 324, 458, 586, 332, 202, 340, 598, 472, 602, 350, 608, 96, 610, 612, 614, 230, 488, 362, 108, 494, 240, 124, 370, 114, 500, 246, 248, 506, 380, 510}, stop_set={608, 612, 616, 430, 270, 432, 14, 308, 596, 246, 600, 570})
    abstract protected void uzlib_uncompress(int offset) throws Exception;
    protected int uzlib_uncompress = 0x08017f80;
    public void uzlib_uncompress() throws Exception
    {
        call(this.uzlib_uncompress, this::uzlib_uncompress);
    }


    // function: Function(address=134316544, size=68, name='uzlib_zlib_parse_header', path='build/extmod/moduzlib.o', joint_set={0, 32, 8, 40, 60, 16, 48, 52, 28, 62}, stop_set={66, 60})
    abstract protected void uzlib_zlib_parse_header(int offset) throws Exception;
    protected int uzlib_zlib_parse_header = 0x08018200;
    public void uzlib_zlib_parse_header() throws Exception
    {
        call(this.uzlib_zlib_parse_header, this::uzlib_zlib_parse_header);
    }


    // function: Function(address=134316612, size=20, name='tinf_skip_bytes', path='build/extmod/moduzlib.o', joint_set={0, 6, 10, 12, 18}, stop_set={18, 10})
    abstract protected void tinf_skip_bytes(int offset) throws Exception;
    protected int tinf_skip_bytes = 0x08018244;
    public void tinf_skip_bytes() throws Exception
    {
        call(this.tinf_skip_bytes, this::tinf_skip_bytes);
    }


    // function: Function(address=134316632, size=24, name='tinf_get_uint16', path='build/extmod/moduzlib.o', joint_set={0, 8, 16}, stop_set={22})
    abstract protected void tinf_get_uint16(int offset) throws Exception;
    protected int tinf_get_uint16 = 0x08018258;
    public void tinf_get_uint16() throws Exception
    {
        call(this.tinf_get_uint16, this::tinf_get_uint16);
    }


    // function: Function(address=134316656, size=138, name='uzlib_gzip_parse_header', path='build/extmod/moduzlib.o', joint_set={0, 8, 14, 18, 20, 26, 30, 36, 40, 46, 58, 66, 70, 76, 84, 88, 94, 98, 102, 108, 112, 118, 124}, stop_set={136, 18})
    abstract protected void uzlib_gzip_parse_header(int offset) throws Exception;
    protected int uzlib_gzip_parse_header = 0x08018270;
    public void uzlib_gzip_parse_header() throws Exception
    {
        call(this.uzlib_gzip_parse_header, this::uzlib_gzip_parse_header);
    }


    // function: Function(address=134316796, size=184, name='decompio_make_new', path='build/extmod/moduzlib.o', joint_set={0, 128, 34, 100, 132, 136, 42, 106, 78, 142, 124, 112, 84, 118, 88, 26, 60, 94}, stop_set={90, 130, 166, 122})
    abstract protected void decompio_make_new(int offset) throws Exception;
    protected int decompio_make_new = 0x080182fc;
    public void decompio_make_new() throws Exception
    {
        call(this.decompio_make_new, this::decompio_make_new);
    }


    // function: Function(address=134316980, size=204, name='uzlib_adler32', path='build/extmod/moduzlib.o', joint_set={0, 66, 36, 40, 10, 76, 14, 82, 20, 52, 184, 56, 28, 30}, stop_set={192, 18, 80, 182})
    abstract protected void uzlib_adler32(int offset) throws Exception;
    protected int uzlib_adler32 = 0x080183b4;
    public void uzlib_adler32() throws Exception
    {
        call(this.uzlib_adler32, this::uzlib_adler32);
    }


    // function: Function(address=134317184, size=56, name='uzlib_crc32', path='build/extmod/moduzlib.o', joint_set={0, 16, 18, 12}, stop_set={48, 16})
    abstract protected void uzlib_crc32(int offset) throws Exception;
    protected int uzlib_crc32 = 0x08018480;
    public void uzlib_crc32() throws Exception
    {
        call(this.uzlib_crc32, this::uzlib_crc32);
    }


    // function: Function(address=134317240, size=106, name='uzlib_uncompress_chksum', path='build/extmod/moduzlib.o', joint_set={0, 66, 98, 90, 104, 10, 42, 14, 78, 48, 84, 54, 22, 26, 60, 30}, stop_set={64, 28, 104})
    abstract protected void uzlib_uncompress_chksum(int offset) throws Exception;
    protected int uzlib_uncompress_chksum = 0x080184b8;
    public void uzlib_uncompress_chksum() throws Exception
    {
        call(this.uzlib_uncompress_chksum, this::uzlib_uncompress_chksum);
    }


    // function: Function(address=134317348, size=60, name='decompio_read', path='build/extmod/moduzlib.o', joint_set={0, 34, 36, 42, 46, 18, 54, 30}, stop_set={40, 54})
    abstract protected void decompio_read(int offset) throws Exception;
    protected int decompio_read = 0x08018524;
    public void decompio_read() throws Exception
    {
        call(this.decompio_read, this::decompio_read);
    }


    // function: Function(address=134317408, size=196, name='mod_uzlib_decompress', path='build/extmod/moduzlib.o', joint_set={0, 96, 34, 162, 70, 136, 104, 170, 76, 120, 18, 82, 148, 180, 54, 86, 24, 92, 152}, stop_set={184, 148, 134})
    abstract protected void mod_uzlib_decompress(int offset) throws Exception;
    protected int mod_uzlib_decompress = 0x08018560;
    public void mod_uzlib_decompress() throws Exception
    {
        call(this.mod_uzlib_decompress, this::mod_uzlib_decompress);
    }


    // function: Function(address=134317604, size=32, name='get_heap', path='build/extmod/moduheapq.o', joint_set={0, 20, 14, 6}, stop_set={16, 20})
    abstract protected void get_heap(int offset) throws Exception;
    protected int get_heap = 0x08018624;
    public void get_heap() throws Exception
    {
        call(this.get_heap, this::get_heap);
    }


    // function: Function(address=134317636, size=72, name='heap_siftdown_isra_0', path='build/extmod/moduheapq.o', joint_set={0, 58, 44, 14, 50, 26}, stop_set={56, 64})
    abstract protected void heap_siftdown_isra_0(int offset) throws Exception;
    protected int heap_siftdown_isra_0 = 0x08018644;
    public void heap_siftdown_isra_0() throws Exception
    {
        call(this.heap_siftdown_isra_0, this::heap_siftdown_isra_0);
    }


    // function: Function(address=134317708, size=112, name='heap_siftup', path='build/extmod/moduheapq.o', joint_set={0, 66, 58, 38, 80, 86, 54, 88, 26}, stop_set={104, 56})
    abstract protected void heap_siftup(int offset) throws Exception;
    protected int heap_siftup = 0x0801868c;
    public void heap_siftup() throws Exception
    {
        call(this.heap_siftup, this::heap_siftup);
    }


    // function: Function(address=134317820, size=36, name='mod_uheapq_heapify', path='build/extmod/moduheapq.o', joint_set={0, 6, 12, 16, 20, 30}, stop_set={18, 30})
    abstract protected void mod_uheapq_heapify(int offset) throws Exception;
    protected int mod_uheapq_heapify = 0x080186fc;
    public void mod_uheapq_heapify() throws Exception
    {
        call(this.mod_uheapq_heapify, this::mod_uheapq_heapify);
    }


    // function: Function(address=134317856, size=44, name='mod_uheapq_heappush', path='build/extmod/moduheapq.o', joint_set={0, 10, 20, 34}, stop_set={36})
    abstract protected void mod_uheapq_heappush(int offset) throws Exception;
    protected int mod_uheapq_heappush = 0x08018720;
    public void mod_uheapq_heappush() throws Exception
    {
        call(this.mod_uheapq_heappush, this::mod_uheapq_heappush);
    }


    // function: Function(address=134317900, size=64, name='mod_uheapq_heappop', path='build/extmod/moduheapq.o', joint_set={0, 6, 12, 48, 52, 20, 24}, stop_set={20, 54})
    abstract protected void mod_uheapq_heappop(int offset) throws Exception;
    protected int mod_uheapq_heappop = 0x0801874c;
    public void mod_uheapq_heappop() throws Exception
    {
        call(this.mod_uheapq_heappop, this::mod_uheapq_heappop);
    }


    // function: Function(address=134317964, size=44, name='utimeq_unary_op', path='build/extmod/modutimeq.o', joint_set={0, 4, 8, 12, 20, 22, 24}, stop_set={32, 10, 22})
    abstract protected void utimeq_unary_op(int offset) throws Exception;
    protected int utimeq_unary_op = 0x0801878c;
    public void utimeq_unary_op() throws Exception
    {
        call(this.utimeq_unary_op, this::utimeq_unary_op);
    }


    // function: Function(address=134318008, size=68, name='utimeq_make_new', path='build/extmod/modutimeq.o', joint_set={0, 42, 24, 58, 30}, stop_set={66})
    abstract protected void utimeq_make_new(int offset) throws Exception;
    protected int utimeq_make_new = 0x080187b8;
    public void utimeq_make_new() throws Exception
    {
        call(this.utimeq_make_new, this::utimeq_make_new);
    }


    // function: Function(address=134318076, size=40, name='mod_utimeq_peektime', path='build/extmod/modutimeq.o', joint_set={0, 8, 20, 16}, stop_set={16, 28})
    abstract protected void mod_utimeq_peektime(int offset) throws Exception;
    protected int mod_utimeq_peektime = 0x080187fc;
    public void mod_utimeq_peektime() throws Exception
    {
        call(this.mod_utimeq_peektime, this::mod_utimeq_peektime);
    }


    // function: Function(address=134318116, size=144, name='heap_siftdown_constprop_3', path='build/extmod/modutimeq.o', joint_set={0, 36, 78, 92, 114, 118, 88, 58, 124, 30}, stop_set={56, 112, 136})
    abstract protected void heap_siftdown_constprop_3(int offset) throws Exception;
    protected int heap_siftdown_constprop_3 = 0x08018824;
    public void heap_siftdown_constprop_3() throws Exception
    {
        call(this.heap_siftdown_constprop_3, this::heap_siftdown_constprop_3);
    }


    // function: Function(address=134318260, size=276, name='mod_utimeq_heappop', path='build/extmod/modutimeq.o', joint_set={0, 132, 140, 12, 20, 24, 158, 30, 164, 38, 170, 44, 50, 186, 196, 200, 202, 230, 234, 240, 116}, stop_set={162, 228, 46, 20, 252})
    abstract protected void mod_utimeq_heappop(int offset) throws Exception;
    protected int mod_utimeq_heappop = 0x080188b4;
    public void mod_utimeq_heappop() throws Exception
    {
        call(this.mod_utimeq_heappop, this::mod_utimeq_heappop);
    }


    // function: Function(address=134318536, size=84, name='mod_utimeq_heappush', path='build/extmod/modutimeq.o', joint_set={0, 56, 22, 14}, stop_set={64, 18})
    abstract protected void mod_utimeq_heappush(int offset) throws Exception;
    protected int mod_utimeq_heappush = 0x080189c8;
    public void mod_utimeq_heappush() throws Exception
    {
        call(this.mod_utimeq_heappush, this::mod_utimeq_heappush);
    }


    // function: Function(address=134318620, size=364, name='sha256_transform', path='build/extmod/moduhashlib.o', joint_set={0, 38, 6, 166, 44, 108, 342, 282}, stop_set={356, 340})
    abstract protected void sha256_transform(int offset) throws Exception;
    protected int sha256_transform = 0x08018a1c;
    public void sha256_transform() throws Exception
    {
        call(this.sha256_transform, this::sha256_transform);
    }


    // function: Function(address=134318984, size=80, name='sha256_init', path='build/extmod/moduhashlib.o', joint_set={0}, stop_set={44})
    abstract protected void sha256_init(int offset) throws Exception;
    protected int sha256_init = 0x08018b88;
    public void sha256_init() throws Exception
    {
        call(this.sha256_init, this::sha256_init);
    }


    // function: Function(address=134319064, size=66, name='sha256_update', path='build/extmod/moduhashlib.o', joint_set={0, 38, 46, 16, 22, 24, 62}, stop_set={64, 22})
    abstract protected void sha256_update(int offset) throws Exception;
    protected int sha256_update = 0x08018bd8;
    public void sha256_update() throws Exception
    {
        call(this.sha256_update, this::sha256_update);
    }


    // function: Function(address=134319132, size=36, name='uhashlib_sha256_update', path='build/extmod/moduhashlib.o', joint_set={0, 24, 14}, stop_set={28})
    abstract protected void uhashlib_sha256_update(int offset) throws Exception;
    protected int uhashlib_sha256_update = 0x08018c1c;
    public void uhashlib_sha256_update() throws Exception
    {
        call(this.uhashlib_sha256_update, this::uhashlib_sha256_update);
    }


    // function: Function(address=134319168, size=52, name='uhashlib_sha256_make_new', path='build/extmod/moduhashlib.o', joint_set={0, 36, 40, 48, 22, 28}, stop_set={50})
    abstract protected void uhashlib_sha256_make_new(int offset) throws Exception;
    protected int uhashlib_sha256_make_new = 0x08018c40;
    public void uhashlib_sha256_make_new() throws Exception
    {
        call(this.uhashlib_sha256_make_new, this::uhashlib_sha256_make_new);
    }


    // function: Function(address=134319220, size=204, name='sha256_final', path='build/extmod/moduhashlib.o', joint_set={0, 196, 164, 198, 166, 104, 106, 172, 174, 178, 18, 20, 24, 186}, stop_set={170, 202, 196, 164})
    abstract protected void sha256_final(int offset) throws Exception;
    protected int sha256_final = 0x08018c74;
    public void sha256_final() throws Exception
    {
        call(this.sha256_final, this::sha256_final);
    }


    // function: Function(address=134319424, size=36, name='uhashlib_sha256_digest', path='build/extmod/moduhashlib.o', joint_set={0, 28, 12, 20}, stop_set={30})
    abstract protected void uhashlib_sha256_digest(int offset) throws Exception;
    protected int uhashlib_sha256_digest = 0x08018d40;
    public void uhashlib_sha256_digest() throws Exception
    {
        call(this.uhashlib_sha256_digest, this::uhashlib_sha256_digest);
    }


    // function: Function(address=134319460, size=136, name='mod_binascii_hexlify', path='build/extmod/modubinascii.o', joint_set={0, 66, 34, 100, 102, 122, 74, 44, 46, 78, 112, 18, 116, 86, 56, 26, 88, 62}, stop_set={76, 126})
    abstract protected void mod_binascii_hexlify(int offset) throws Exception;
    protected int mod_binascii_hexlify = 0x08018d64;
    public void mod_binascii_hexlify() throws Exception
    {
        call(this.mod_binascii_hexlify, this::mod_binascii_hexlify);
    }


    // function: Function(address=134319596, size=244, name='mod_binascii_b2a_base64', path='build/extmod/modubinascii.o', joint_set={0, 132, 136, 12, 20, 28, 32, 44, 50, 54, 184, 58, 190, 196, 198, 200, 204, 76, 208, 212, 216, 220, 92, 224, 98, 228, 232, 236, 116, 120}, stop_set={226, 134, 202, 234, 238, 210, 182, 218, 188})
    abstract protected void mod_binascii_b2a_base64(int offset) throws Exception;
    protected int mod_binascii_b2a_base64 = 0x08018dec;
    public void mod_binascii_b2a_base64() throws Exception
    {
        call(this.mod_binascii_b2a_base64, this::mod_binascii_b2a_base64);
    }


    // function: Function(address=134319840, size=132, name='mod_binascii_unhexlify', path='build/extmod/modubinascii.o', joint_set={0, 32, 96, 70, 102, 74, 12, 44, 112, 80, 114, 48, 24, 56, 60}, stop_set={114, 58, 110})
    abstract protected void mod_binascii_unhexlify(int offset) throws Exception;
    protected int mod_binascii_unhexlify = 0x08018ee0;
    public void mod_binascii_unhexlify() throws Exception
    {
        call(this.mod_binascii_unhexlify, this::mod_binascii_unhexlify);
    }


    // function: Function(address=134319972, size=196, name='mod_binascii_a2b_base64', path='build/extmod/modubinascii.o', joint_set={0, 128, 132, 12, 140, 144, 152, 156, 32, 160, 164, 168, 172, 44, 176, 54, 184, 58, 64, 70, 74, 78, 82, 84, 94, 96, 106, 122, 124}, stop_set={130, 166, 186, 170, 174, 142, 154, 60, 126})
    abstract protected void mod_binascii_a2b_base64(int offset) throws Exception;
    protected int mod_binascii_a2b_base64 = 0x08018f64;
    public void mod_binascii_a2b_base64() throws Exception
    {
        call(this.mod_binascii_a2b_base64, this::mod_binascii_a2b_base64);
    }


    // function: Function(address=134320168, size=50, name='mod_binascii_crc32', path='build/extmod/modubinascii.o', joint_set={0, 40, 46, 18, 24, 30}, stop_set={48})
    abstract protected void mod_binascii_crc32(int offset) throws Exception;
    protected int mod_binascii_crc32 = 0x08019028;
    public void mod_binascii_crc32() throws Exception
    {
        call(this.mod_binascii_crc32, this::mod_binascii_crc32);
    }


    // function: Function(address=134320220, size=40, name='machine_mem_get_addr', path='build/extmod/machine_mem.o', joint_set={0, 8, 14, 26, 30}, stop_set={26, 30})
    abstract protected void machine_mem_get_addr(int offset) throws Exception;
    protected int machine_mem_get_addr = 0x0801905c;
    public void machine_mem_get_addr() throws Exception
    {
        call(this.machine_mem_get_addr, this::machine_mem_get_addr);
    }


    // function: Function(address=134320260, size=20, name='machine_mem_print', path='build/extmod/machine_mem.o', joint_set={0, 12}, stop_set={12})
    abstract protected void machine_mem_print(int offset) throws Exception;
    protected int machine_mem_print = 0x08019084;
    public void machine_mem_print() throws Exception
    {
        call(this.machine_mem_print, this::machine_mem_print);
    }


    // function: Function(address=134320280, size=92, name='machine_mem_subscr', path='build/extmod/machine_mem.o', joint_set={0, 34, 38, 72, 40, 44, 12, 76, 46, 80, 50, 84, 20, 54, 30, 24, 62}, stop_set={36, 44, 78, 48, 82, 86})
    abstract protected void machine_mem_subscr(int offset) throws Exception;
    protected int machine_mem_subscr = 0x08019098;
    public void machine_mem_subscr() throws Exception
    {
        call(this.machine_mem_subscr, this::machine_mem_subscr);
    }


    // function: Function(address=134320372, size=96, name='yasmarang', path='build/extmod/modurandom.o', joint_set={0}, stop_set={78})
    abstract protected void yasmarang(int offset) throws Exception;
    protected int yasmarang = 0x080190f4;
    public void yasmarang() throws Exception
    {
        call(this.yasmarang, this::yasmarang);
    }


    // function: Function(address=134320468, size=34, name='yasmarang_randbelow', path='build/extmod/modurandom.o', joint_set={0, 8, 16, 20, 26, 28}, stop_set={32, 26})
    abstract protected void yasmarang_randbelow(int offset) throws Exception;
    protected int yasmarang_randbelow = 0x08019154;
    public void yasmarang_randbelow() throws Exception
    {
        call(this.yasmarang_randbelow, this::yasmarang_randbelow);
    }


    // function: Function(address=134320502, size=66, name='mod_urandom_uniform', path='build/extmod/modurandom.o', joint_set={0, 64, 8, 46, 60, 16, 22, 54, 28}, stop_set={64})
    abstract protected void mod_urandom_uniform(int offset) throws Exception;
    protected int mod_urandom_uniform = 0x08019176;
    public void mod_urandom_uniform() throws Exception
    {
        call(this.mod_urandom_uniform, this::mod_urandom_uniform);
    }


    // function: Function(address=134320568, size=42, name='mod_urandom_randint', path='build/extmod/modurandom.o', joint_set={0, 34, 8, 40, 16, 20, 26}, stop_set={40, 22})
    abstract protected void mod_urandom_randint(int offset) throws Exception;
    protected int mod_urandom_randint = 0x080191b8;
    public void mod_urandom_randint() throws Exception
    {
        call(this.mod_urandom_randint, this::mod_urandom_randint);
    }


    // function: Function(address=134320610, size=106, name='mod_urandom_randrange', path='build/extmod/modurandom.o', joint_set={0, 12, 18, 22, 26, 30, 32, 38, 44, 48, 54, 58, 64, 68, 72, 78, 82, 86, 90, 94, 100}, stop_set={98, 102, 56, 88, 30})
    abstract protected void mod_urandom_randrange(int offset) throws Exception;
    protected int mod_urandom_randrange = 0x080191e2;
    public void mod_urandom_randrange() throws Exception
    {
        call(this.mod_urandom_randrange, this::mod_urandom_randrange);
    }


    // function: Function(address=134320716, size=52, name='mod_urandom_seed', path='build/extmod/modurandom.o', joint_set={0, 6}, stop_set={30})
    abstract protected void mod_urandom_seed(int offset) throws Exception;
    protected int mod_urandom_seed = 0x0801924c;
    public void mod_urandom_seed() throws Exception
    {
        call(this.mod_urandom_seed, this::mod_urandom_seed);
    }


    // function: Function(address=134320768, size=44, name='mod_urandom_getrandbits', path='build/extmod/modurandom.o', joint_set={0, 6, 42, 12, 16, 22, 26}, stop_set={18, 42})
    abstract protected void mod_urandom_getrandbits(int offset) throws Exception;
    protected int mod_urandom_getrandbits = 0x08019280;
    public void mod_urandom_getrandbits() throws Exception
    {
        call(this.mod_urandom_getrandbits, this::mod_urandom_getrandbits);
    }


    // function: Function(address=134320812, size=52, name='mod_urandom_choice', path='build/extmod/modurandom.o', joint_set={0, 34, 8, 12, 44, 16, 22, 26, 30}, stop_set={44, 22})
    abstract protected void mod_urandom_choice(int offset) throws Exception;
    protected int mod_urandom_choice = 0x080192ac;
    public void mod_urandom_choice() throws Exception
    {
        call(this.mod_urandom_choice, this::mod_urandom_choice);
    }


    // function: Function(address=134320864, size=30, name='mod_urandom_random', path='build/extmod/modurandom.o', joint_set={0, 24, 28, 6}, stop_set={28})
    abstract protected void mod_urandom_random(int offset) throws Exception;
    protected int mod_urandom_random = 0x080192e0;
    public void mod_urandom_random() throws Exception
    {
        call(this.mod_urandom_random, this::mod_urandom_random);
    }


    // function: Function(address=134320894, size=62, name='mp_vfs_proxy_call', path='build/extmod/vfs.o', joint_set={0, 34, 58, 38, 12, 14, 48, 18, 22, 26}, stop_set={24, 60, 14})
    abstract protected void mp_vfs_proxy_call(int offset) throws Exception;
    protected int mp_vfs_proxy_call = 0x080192fe;
    public void mp_vfs_proxy_call() throws Exception
    {
        call(this.mp_vfs_proxy_call, this::mp_vfs_proxy_call);
    }


    // function: Function(address=134320956, size=160, name='mp_vfs_umount', path='build/extmod/vfs.o', joint_set={0, 66, 130, 36, 70, 38, 108, 60, 92, 112, 124, 80, 14, 84, 20, 56, 28}, stop_set={136, 128, 62})
    abstract protected void mp_vfs_umount(int offset) throws Exception;
    protected int mp_vfs_umount = 0x0801933c;
    public void mp_vfs_umount() throws Exception
    {
        call(this.mp_vfs_umount, this::mp_vfs_umount);
    }


    // function: Function(address=134321116, size=116, name='mp_vfs_getcwd', path='build/extmod/vfs.o', joint_set={0, 96, 34, 100, 58, 38, 68, 74, 44, 14, 80, 88, 26}, stop_set={104, 98})
    abstract protected void mp_vfs_getcwd(int offset) throws Exception;
    protected int mp_vfs_getcwd = 0x080193dc;
    public void mp_vfs_getcwd() throws Exception
    {
        call(this.mp_vfs_getcwd, this::mp_vfs_getcwd);
    }


    // function: Function(address=134321232, size=112, name='mp_vfs_ilistdir_it_iternext', path='build/extmod/vfs.o', joint_set={0, 64, 74, 76, 14, 46, 48, 18, 52, 54, 88, 58, 28}, stop_set={56, 98})
    abstract protected void mp_vfs_ilistdir_it_iternext(int offset) throws Exception;
    protected int mp_vfs_ilistdir_it_iternext = 0x08019450;
    public void mp_vfs_ilistdir_it_iternext() throws Exception
    {
        call(this.mp_vfs_ilistdir_it_iternext, this::mp_vfs_ilistdir_it_iternext);
    }


    // function: Function(address=134321344, size=140, name='mp_vfs_lookup_path', path='build/extmod/vfs.o', joint_set={0, 32, 64, 100, 70, 40, 104, 44, 12, 78, 112, 84, 116, 52, 24, 88, 120, 126}, stop_set={128, 68, 114, 86, 124, 62})
    abstract protected void mp_vfs_lookup_path(int offset) throws Exception;
    protected int mp_vfs_lookup_path = 0x080194c0;
    public void mp_vfs_lookup_path() throws Exception
    {
        call(this.mp_vfs_lookup_path, this::mp_vfs_lookup_path);
    }


    // function: Function(address=134321484, size=156, name='mp_vfs_mount', path='build/extmod/vfs.o', joint_set={0, 32, 128, 100, 134, 136, 106, 48, 112, 82, 54, 118, 24, 122, 88, 94}, stop_set={114, 142})
    abstract protected void mp_vfs_mount(int offset) throws Exception;
    protected int mp_vfs_mount = 0x0801954c;
    public void mp_vfs_mount() throws Exception
    {
        call(this.mp_vfs_mount, this::mp_vfs_mount);
    }


    // function: Function(address=134321640, size=54, name='lookup_path', path='build/extmod/vfs.o', joint_set={0, 38, 10, 16, 48, 50, 22, 28}, stop_set={52})
    abstract protected void lookup_path(int offset) throws Exception;
    protected int lookup_path = 0x080195e8;
    public void lookup_path() throws Exception
    {
        call(this.lookup_path, this::lookup_path);
    }


    // function: Function(address=134321696, size=48, name='mp_vfs_open', path='build/extmod/vfs.o', joint_set={0, 18, 26, 38}, stop_set={40})
    abstract protected void mp_vfs_open(int offset) throws Exception;
    protected int mp_vfs_open = 0x08019620;
    public void mp_vfs_open() throws Exception
    {
        call(this.mp_vfs_open, this::mp_vfs_open);
    }


    // function: Function(address=134321744, size=72, name='mp_vfs_chdir', path='build/extmod/vfs.o', joint_set={0, 32, 38, 8, 46, 52, 20, 54, 24, 58, 28}, stop_set={62, 56, 52, 30})
    abstract protected void mp_vfs_chdir(int offset) throws Exception;
    protected int mp_vfs_chdir = 0x08019650;
    public void mp_vfs_chdir() throws Exception
    {
        call(this.mp_vfs_chdir, this::mp_vfs_chdir);
    }


    // function: Function(address=134321816, size=104, name='mp_vfs_ilistdir', path='build/extmod/vfs.o', joint_set={0, 66, 70, 8, 10, 18, 82, 22, 54, 28}, stop_set={68, 84})
    abstract protected void mp_vfs_ilistdir(int offset) throws Exception;
    protected int mp_vfs_ilistdir = 0x08019698;
    public void mp_vfs_ilistdir() throws Exception
    {
        call(this.mp_vfs_ilistdir, this::mp_vfs_ilistdir);
    }


    // function: Function(address=134321920, size=50, name='mp_vfs_listdir', path='build/extmod/vfs.o', joint_set={0, 32, 6, 40, 16, 48, 18, 24, 28}, stop_set={48, 30})
    abstract protected void mp_vfs_listdir(int offset) throws Exception;
    protected int mp_vfs_listdir = 0x08019700;
    public void mp_vfs_listdir() throws Exception
    {
        call(this.mp_vfs_listdir, this::mp_vfs_listdir);
    }


    // function: Function(address=134321972, size=60, name='mp_vfs_mkdir', path='build/extmod/vfs.o', joint_set={0, 34, 38, 8, 12, 18, 52, 22, 28}, stop_set={52, 14})
    abstract protected void mp_vfs_mkdir(int offset) throws Exception;
    protected int mp_vfs_mkdir = 0x08019734;
    public void mp_vfs_mkdir() throws Exception
    {
        call(this.mp_vfs_mkdir, this::mp_vfs_mkdir);
    }


    // function: Function(address=134322032, size=22, name='mp_vfs_remove', path='build/extmod/vfs.o', joint_set={0, 8, 20}, stop_set={20})
    abstract protected void mp_vfs_remove(int offset) throws Exception;
    protected int mp_vfs_remove = 0x08019770;
    public void mp_vfs_remove() throws Exception
    {
        call(this.mp_vfs_remove, this::mp_vfs_remove);
    }


    // function: Function(address=134322054, size=46, name='mp_vfs_rename', path='build/extmod/vfs.o', joint_set={0, 10, 44, 20, 24, 30}, stop_set={26, 44})
    abstract protected void mp_vfs_rename(int offset) throws Exception;
    protected int mp_vfs_rename = 0x08019786;
    public void mp_vfs_rename() throws Exception
    {
        call(this.mp_vfs_rename, this::mp_vfs_rename);
    }


    // function: Function(address=134322100, size=22, name='mp_vfs_rmdir', path='build/extmod/vfs.o', joint_set={0, 8, 20}, stop_set={20})
    abstract protected void mp_vfs_rmdir(int offset) throws Exception;
    protected int mp_vfs_rmdir = 0x080197b4;
    public void mp_vfs_rmdir() throws Exception
    {
        call(this.mp_vfs_rmdir, this::mp_vfs_rmdir);
    }


    // function: Function(address=134322124, size=60, name='mp_vfs_stat', path='build/extmod/vfs.o', joint_set={0, 34, 8, 40, 42, 12, 20, 54}, stop_set={40, 54})
    abstract protected void mp_vfs_stat(int offset) throws Exception;
    protected int mp_vfs_stat = 0x080197cc;
    public void mp_vfs_stat() throws Exception
    {
        call(this.mp_vfs_stat, this::mp_vfs_stat);
    }


    // function: Function(address=134322184, size=92, name='mp_vfs_statvfs', path='build/extmod/vfs.o', joint_set={0, 64, 32, 70, 8, 42, 12, 48, 82, 52, 20, 54, 24, 60}, stop_set={82, 52, 62})
    abstract protected void mp_vfs_statvfs(int offset) throws Exception;
    protected int mp_vfs_statvfs = 0x08019808;
    public void mp_vfs_statvfs() throws Exception
    {
        call(this.mp_vfs_statvfs, this::mp_vfs_statvfs);
    }


    // function: Function(address=134322276, size=124, name='mp_vfs_import_stat', path='build/extmod/vfs.o', joint_set={0, 34, 68, 102, 72, 10, 44, 60, 92, 16, 110, 18, 52, 22, 86, 28}, stop_set={122, 20, 42})
    abstract protected void mp_vfs_import_stat(int offset) throws Exception;
    protected int mp_vfs_import_stat = 0x08019864;
    public void mp_vfs_import_stat() throws Exception
    {
        call(this.mp_vfs_import_stat, this::mp_vfs_import_stat);
    }


    // function: Function(address=134322400, size=20, name='mp_reader_vfs_close', path='build/extmod/vfs_reader.o', joint_set={0, 10, 18}, stop_set={18})
    abstract protected void mp_reader_vfs_close(int offset) throws Exception;
    protected int mp_reader_vfs_close = 0x080198e0;
    public void mp_reader_vfs_close() throws Exception
    {
        call(this.mp_reader_vfs_close, this::mp_reader_vfs_close);
    }


    // function: Function(address=134322420, size=70, name='mp_reader_vfs_readbyte', path='build/extmod/vfs_reader.o', joint_set={0, 64, 34, 12, 44, 16, 48, 50, 60}, stop_set={68, 62})
    abstract protected void mp_reader_vfs_readbyte(int offset) throws Exception;
    protected int mp_reader_vfs_readbyte = 0x080198f4;
    public void mp_reader_vfs_readbyte() throws Exception
    {
        call(this.mp_reader_vfs_readbyte, this::mp_reader_vfs_readbyte);
    }


    // function: Function(address=134322492, size=96, name='mp_reader_new_file', path='build/extmod/vfs_reader.o', joint_set={0, 66, 70, 40, 12, 20, 58, 28}, stop_set={82, 66})
    abstract protected void mp_reader_new_file(int offset) throws Exception;
    protected int mp_reader_new_file = 0x0801993c;
    public void mp_reader_new_file() throws Exception
    {
        call(this.mp_reader_new_file, this::mp_reader_new_file);
    }


    // function: Function(address=134322588, size=28, name='time_ticks_diff', path='build/extmod/utime_mphal.o', joint_set={0}, stop_set={26})
    abstract protected void time_ticks_diff(int offset) throws Exception;
    protected int time_ticks_diff = 0x0801999c;
    public void time_ticks_diff() throws Exception
    {
        call(this.time_ticks_diff, this::time_ticks_diff);
    }


    // function: Function(address=134322616, size=32, name='time_sleep', path='build/extmod/utime_mphal.o', joint_set={0, 6, 12, 16, 20}, stop_set={22})
    abstract protected void time_sleep(int offset) throws Exception;
    protected int time_sleep = 0x080199b8;
    public void time_sleep() throws Exception
    {
        call(this.time_sleep, this::time_sleep);
    }


    // function: Function(address=134322648, size=24, name='time_sleep_ms', path='build/extmod/utime_mphal.o', joint_set={0, 10, 6, 14}, stop_set={16})
    abstract protected void time_sleep_ms(int offset) throws Exception;
    protected int time_sleep_ms = 0x080199d8;
    public void time_sleep_ms() throws Exception
    {
        call(this.time_sleep_ms, this::time_sleep_ms);
    }


    // function: Function(address=134322672, size=32, name='time_ticks_add', path='build/extmod/utime_mphal.o', joint_set={0, 10}, stop_set={24})
    abstract protected void time_ticks_add(int offset) throws Exception;
    protected int time_ticks_add = 0x080199f0;
    public void time_ticks_add() throws Exception
    {
        call(this.time_ticks_add, this::time_ticks_add);
    }


    // function: Function(address=134322704, size=24, name='time_ticks_ms', path='build/extmod/utime_mphal.o', joint_set={0, 6}, stop_set={16})
    abstract protected void time_ticks_ms(int offset) throws Exception;
    protected int time_ticks_ms = 0x08019a10;
    public void time_ticks_ms() throws Exception
    {
        call(this.time_ticks_ms, this::time_ticks_ms);
    }


    // function: Function(address=134322728, size=24, name='time_ticks_cpu', path='build/extmod/utime_mphal.o', joint_set={0, 6}, stop_set={16})
    abstract protected void time_ticks_cpu(int offset) throws Exception;
    protected int time_ticks_cpu = 0x08019a28;
    public void time_ticks_cpu() throws Exception
    {
        call(this.time_ticks_cpu, this::time_ticks_cpu);
    }


    // function: Function(address=134322752, size=34, name='strn_print_strn', path='build/lib/utils/printf.o', joint_set={0, 10, 12, 20}, stop_set={32})
    abstract protected void strn_print_strn(int offset) throws Exception;
    protected int strn_print_strn = 0x08019a40;
    public void strn_print_strn() throws Exception
    {
        call(this.strn_print_strn, this::strn_print_strn);
    }


    // function: Function(address=134322788, size=28, name='printf', path='build/lib/utils/printf.o', joint_set={0, 16}, stop_set={22})
    abstract protected void printf(int offset) throws Exception;
    protected int printf = 0x08019a64;
    public void printf() throws Exception
    {
        call(this.printf, this::printf);
    }


    // function: Function(address=134322816, size=20, name='putchar', path='build/lib/utils/printf.o', joint_set={0, 16}, stop_set={18})
    abstract protected void putchar(int offset) throws Exception;
    protected int putchar = 0x08019a80;
    public void putchar() throws Exception
    {
        call(this.putchar, this::putchar);
    }


    // function: Function(address=134322836, size=34, name='puts', path='build/lib/utils/printf.o', joint_set={0, 8, 16, 30}, stop_set={32})
    abstract protected void puts(int offset) throws Exception;
    protected int puts = 0x08019a94;
    public void puts() throws Exception
    {
        call(this.puts, this::puts);
    }


    // function: Function(address=134322872, size=56, name='vsnprintf', path='build/lib/utils/printf.o', joint_set={0, 38, 40, 42, 46, 26, 30}, stop_set={48, 44})
    abstract protected void vsnprintf(int offset) throws Exception;
    protected int vsnprintf = 0x08019ab8;
    public void vsnprintf() throws Exception
    {
        call(this.vsnprintf, this::vsnprintf);
    }


    // function: Function(address=134322928, size=22, name='snprintf', path='build/lib/utils/printf.o', joint_set={0, 14}, stop_set={20})
    abstract protected void snprintf(int offset) throws Exception;
    protected int snprintf = 0x08019af0;
    public void snprintf() throws Exception
    {
        call(this.snprintf, this::snprintf);
    }


    // function: Function(address=134322952, size=200, name='main', path='build/main.o', joint_set={0, 128, 132, 134, 10, 142, 14, 146, 22, 36, 44, 52, 56, 66, 74, 82, 88, 92, 94, 98, 104, 108, 116, 120, 124}, stop_set={96, 146, 132, 126})
    abstract protected void main(int offset) throws Exception;
    protected int main = 0x08019b08;
    public void main() throws Exception
    {
        call(this.main, this::main);
    }


    // function: Function(address=134323152, size=44, name='Signal_Handler', path='build/machine.o', joint_set={0, 16, 10}, stop_set={28})
    abstract protected void Signal_Handler(int offset) throws Exception;
    protected int Signal_Handler = 0x08019bd0;
    public void Signal_Handler() throws Exception
    {
        call(this.Signal_Handler, this::Signal_Handler);
    }


    // function: Function(address=134323196, size=14, name='_exit', path='build/machine.o', joint_set={0}, stop_set={12})
    abstract protected void _exit(int offset) throws Exception;
    protected int _exit = 0x08019bfc;
    public void _exit() throws Exception
    {
        call(this._exit, this::_exit);
    }


    // function: Function(address=134323210, size=16, name='_start', path='build/machine.o', joint_set={0, 10, 14}, stop_set={14})
    abstract protected void _start(int offset) throws Exception;
    protected int _start = 0x08019c0a;
    public void _start() throws Exception
    {
        call(this._start, this::_start);
    }


    // function: Function(address=134323228, size=100, name='Reset_Handler', path='build/machine.o', joint_set={0, 14, 48, 20, 56, 26, 30}, stop_set={58, 54})
    abstract protected void Reset_Handler(int offset) throws Exception;
    protected int Reset_Handler = 0x08019c1c;
    public void Reset_Handler() throws Exception
    {
        call(this.Reset_Handler, this::Reset_Handler);
    }


    // function: Function(address=134323328, size=16, name='__fatal_error', path='build/machine.o', joint_set={0, 14}, stop_set={14})
    abstract protected void __fatal_error(int offset) throws Exception;
    protected int __fatal_error = 0x08019c80;
    public void __fatal_error() throws Exception
    {
        call(this.__fatal_error, this::__fatal_error);
    }


    // function: Function(address=134323344, size=12, name='nlr_jump_fail', path='build/machine.o', joint_set={0}, stop_set={4})
    abstract protected void nlr_jump_fail(int offset) throws Exception;
    protected int nlr_jump_fail = 0x08019c90;
    public void nlr_jump_fail() throws Exception
    {
        call(this.nlr_jump_fail, this::nlr_jump_fail);
    }


    // function: Function(address=134323356, size=16, name='mp_hal_stdin_rx_chr', path='build/mphalport.o', joint_set={0, 6}, stop_set={14})
    abstract protected void mp_hal_stdin_rx_chr(int offset) throws Exception;
    protected int mp_hal_stdin_rx_chr = 0x08019c9c;
    public void mp_hal_stdin_rx_chr() throws Exception
    {
        call(this.mp_hal_stdin_rx_chr, this::mp_hal_stdin_rx_chr);
    }


    // function: Function(address=134323372, size=32, name='mp_hal_stdout_tx_strn', path='build/mphalport.o', joint_set={0, 16, 6, 22}, stop_set={22})
    abstract protected void mp_hal_stdout_tx_strn(int offset) throws Exception;
    protected int mp_hal_stdout_tx_strn = 0x08019cac;
    public void mp_hal_stdout_tx_strn() throws Exception
    {
        call(this.mp_hal_stdout_tx_strn, this::mp_hal_stdout_tx_strn);
    }


    // function: Function(address=134323404, size=40, name='mp_hal_delay_ms', path='build/mphalport.o', joint_set={0, 10, 18, 20, 24}, stop_set={18, 28})
    abstract protected void mp_hal_delay_ms(int offset) throws Exception;
    protected int mp_hal_delay_ms = 0x08019ccc;
    public void mp_hal_delay_ms() throws Exception
    {
        call(this.mp_hal_delay_ms, this::mp_hal_delay_ms);
    }


    // function: Function(address=134323444, size=12, name='mp_hal_ticks_ms', path='build/mphalport.o', joint_set={0}, stop_set={4})
    abstract protected void mp_hal_ticks_ms(int offset) throws Exception;
    protected int mp_hal_ticks_ms = 0x08019cf4;
    public void mp_hal_ticks_ms() throws Exception
    {
        call(this.mp_hal_ticks_ms, this::mp_hal_ticks_ms);
    }


    // function: Function(address=134323456, size=12, name='mp_hal_ticks_cpu', path='build/mphalport.o', joint_set={0}, stop_set={4})
    abstract protected void mp_hal_ticks_cpu(int offset) throws Exception;
    protected int mp_hal_ticks_cpu = 0x08019d00;
    public void mp_hal_ticks_cpu() throws Exception
    {
        call(this.mp_hal_ticks_cpu, this::mp_hal_ticks_cpu);
    }


    // function: Function(address=134323468, size=16, name='usystem_print_hook', path='build/modusystem.o', joint_set={0}, stop_set={6})
    abstract protected void usystem_print_hook(int offset) throws Exception;
    protected int usystem_print_hook = 0x08019d0c;
    public void usystem_print_hook() throws Exception
    {
        call(this.usystem_print_hook, this::usystem_print_hook);
    }


    // function: Function(address=134323484, size=32, name='usystem_debug', path='build/modusystem.o', joint_set={0, 12}, stop_set={26})
    abstract protected void usystem_debug(int offset) throws Exception;
    protected int usystem_debug = 0x08019d1c;
    public void usystem_debug() throws Exception
    {
        call(this.usystem_debug, this::usystem_debug);
    }


    // function: Function(address=134323516, size=52, name='usystem_set_stdin_char', path='build/modusystem.o', joint_set={0, 34, 6, 12, 20, 24}, stop_set={36})
    abstract protected void usystem_set_stdin_char(int offset) throws Exception;
    protected int usystem_set_stdin_char = 0x08019d3c;
    public void usystem_set_stdin_char() throws Exception
    {
        call(this.usystem_set_stdin_char, this::usystem_set_stdin_char);
    }


    // function: Function(address=134323568, size=36, name='parse_2', path='build/modusystem.o', joint_set={0, 8, 22, 16}, stop_set={24})
    abstract protected void parse_2(int offset) throws Exception;
    protected int parse_2 = 0x08019d70;
    public void parse_2() throws Exception
    {
        call(this.parse_2, this::parse_2);
    }


    // function: Function(address=134323604, size=30, name='usystem_syscall', path='build/modusystem.o', joint_set={0, 12, 28}, stop_set={28})
    abstract protected void usystem_syscall(int offset) throws Exception;
    protected int usystem_syscall = 0x08019d94;
    public void usystem_syscall() throws Exception
    {
        call(this.usystem_syscall, this::usystem_syscall);
    }


    // function: Function(address=134323634, size=20, name='usystem_signal', path='build/modusystem.o', joint_set={0, 18}, stop_set={18})
    abstract protected void usystem_signal(int offset) throws Exception;
    protected int usystem_signal = 0x08019db2;
    public void usystem_signal() throws Exception
    {
        call(this.usystem_signal, this::usystem_signal);
    }


    // function: Function(address=134323654, size=20, name='usystem_components', path='build/modusystem.o', joint_set={0, 18}, stop_set={18})
    abstract protected void usystem_components(int offset) throws Exception;
    protected int usystem_components = 0x08019dc6;
    public void usystem_components() throws Exception
    {
        call(this.usystem_components, this::usystem_components);
    }


    // function: Function(address=134323674, size=34, name='usystem_methods', path='build/modusystem.o', joint_set={0, 32, 12}, stop_set={32})
    abstract protected void usystem_methods(int offset) throws Exception;
    protected int usystem_methods = 0x08019dda;
    public void usystem_methods() throws Exception
    {
        call(this.usystem_methods, this::usystem_methods);
    }


    // function: Function(address=134323708, size=32, name='usystem_annotations', path='build/modusystem.o', joint_set={0, 12, 30}, stop_set={30})
    abstract protected void usystem_annotations(int offset) throws Exception;
    protected int usystem_annotations = 0x08019dfc;
    public void usystem_annotations() throws Exception
    {
        call(this.usystem_annotations, this::usystem_annotations);
    }


    // function: Function(address=134323740, size=20, name='usystem_get_stdout_str', path='build/modusystem.o', joint_set={0, 18}, stop_set={18})
    abstract protected void usystem_get_stdout_str(int offset) throws Exception;
    protected int usystem_get_stdout_str = 0x08019e1c;
    public void usystem_get_stdout_str() throws Exception
    {
        call(this.usystem_get_stdout_str, this::usystem_get_stdout_str);
    }


    // function: Function(address=134323760, size=36, name='gc_collect', path='build/gccollect.o', joint_set={0, 8, 14, 24, 28}, stop_set={30})
    abstract protected void gc_collect(int offset) throws Exception;
    protected int gc_collect = 0x08019e30;
    public void gc_collect() throws Exception
    {
        call(this.gc_collect, this::gc_collect);
    }


    // function: Function(address=134323796, size=10, name='vfs_openpie_file___exit__', path='build/openpie_vfs.o', joint_set={0, 8}, stop_set={8})
    abstract protected void vfs_openpie_file___exit__(int offset) throws Exception;
    protected int vfs_openpie_file___exit__ = 0x08019e54;
    public void vfs_openpie_file___exit__() throws Exception
    {
        call(this.vfs_openpie_file___exit__, this::vfs_openpie_file___exit__);
    }


    // function: Function(address=134323808, size=32, name='vfs_openpie_file_print', path='build/openpie_vfs.o', joint_set={0, 24, 12}, stop_set={24})
    abstract protected void vfs_openpie_file_print(int offset) throws Exception;
    protected int vfs_openpie_file_print = 0x08019e60;
    public void vfs_openpie_file_print() throws Exception
    {
        call(this.vfs_openpie_file_print, this::vfs_openpie_file_print);
    }


    // function: Function(address=134323840, size=24, name='unlikely_check_fd_is_open_isra_0_part_1', path='build/openpie_vfs.o', joint_set={0, 10}, stop_set={10})
    abstract protected void unlikely_check_fd_is_open_isra_0_part_1(int offset) throws Exception;
    protected int unlikely_check_fd_is_open_isra_0_part_1 = 0x08019e80;
    public void unlikely_check_fd_is_open_isra_0_part_1() throws Exception
    {
        call(this.unlikely_check_fd_is_open_isra_0_part_1, this::unlikely_check_fd_is_open_isra_0_part_1);
    }


    // function: Function(address=134323864, size=18, name='vfs_openpie_file_fileno', path='build/openpie_vfs.o', joint_set={0, 16, 12, 8}, stop_set={16})
    abstract protected void vfs_openpie_file_fileno(int offset) throws Exception;
    protected int vfs_openpie_file_fileno = 0x08019e98;
    public void vfs_openpie_file_fileno() throws Exception
    {
        call(this.vfs_openpie_file_fileno, this::vfs_openpie_file_fileno);
    }


    // function: Function(address=134323882, size=14, name='SVC_CALL_VFS', path='build/openpie_vfs.o', joint_set={0}, stop_set={12})
    abstract protected void SVC_CALL_VFS(int offset) throws Exception;
    protected int SVC_CALL_VFS = 0x08019eaa;
    public void SVC_CALL_VFS() throws Exception
    {
        call(this.SVC_CALL_VFS, this::SVC_CALL_VFS);
    }


    // function: Function(address=134323896, size=16, name='SVC_CALL_VFS_OUT', path='build/openpie_vfs.o', joint_set={0}, stop_set={14})
    abstract protected void SVC_CALL_VFS_OUT(int offset) throws Exception;
    protected int SVC_CALL_VFS_OUT = 0x08019eb8;
    public void SVC_CALL_VFS_OUT() throws Exception
    {
        call(this.SVC_CALL_VFS_OUT, this::SVC_CALL_VFS_OUT);
    }


    // function: Function(address=134323912, size=126, name='vfs_openpie_file_ioctl', path='build/openpie_vfs.o', joint_set={0, 32, 102, 42, 76, 120, 110, 80, 16, 82, 50, 20, 116, 54, 88, 24, 58, 28, 94}, stop_set={124, 114, 118, 86, 56, 92})
    abstract protected void vfs_openpie_file_ioctl(int offset) throws Exception;
    protected int vfs_openpie_file_ioctl = 0x08019ec8;
    public void vfs_openpie_file_ioctl() throws Exception
    {
        call(this.vfs_openpie_file_ioctl, this::vfs_openpie_file_ioctl);
    }


    // function: Function(address=134324038, size=54, name='vfs_openpie_file_write', path='build/openpie_vfs.o', joint_set={0, 36, 42, 14, 48, 18}, stop_set={52})
    abstract protected void vfs_openpie_file_write(int offset) throws Exception;
    protected int vfs_openpie_file_write = 0x08019f46;
    public void vfs_openpie_file_write() throws Exception
    {
        call(this.vfs_openpie_file_write, this::vfs_openpie_file_write);
    }


    // function: Function(address=134324092, size=52, name='vfs_openpie_file_read', path='build/openpie_vfs.o', joint_set={0, 34, 40, 46, 14, 18}, stop_set={50})
    abstract protected void vfs_openpie_file_read(int offset) throws Exception;
    protected int vfs_openpie_file_read = 0x08019f7c;
    public void vfs_openpie_file_read() throws Exception
    {
        call(this.vfs_openpie_file_read, this::vfs_openpie_file_read);
    }


    // function: Function(address=134324144, size=92, name='mp_vfs_openpie_file_open', path='build/openpie_vfs.o', joint_set={0, 34, 68, 72, 42, 76, 18, 82, 86, 26}, stop_set={72, 90})
    abstract protected void mp_vfs_openpie_file_open(int offset) throws Exception;
    protected int mp_vfs_openpie_file_open = 0x08019fb0;
    public void mp_vfs_openpie_file_open() throws Exception
    {
        call(this.mp_vfs_openpie_file_open, this::mp_vfs_openpie_file_open);
    }


    // function: Function(address=134324236, size=48, name='vfs_openpie_file_make_new', path='build/openpie_vfs.o', joint_set={0, 26, 38}, stop_set={40})
    abstract protected void vfs_openpie_file_make_new(int offset) throws Exception;
    protected int vfs_openpie_file_make_new = 0x0801a00c;
    public void vfs_openpie_file_make_new() throws Exception
    {
        call(this.vfs_openpie_file_make_new, this::vfs_openpie_file_make_new);
    }


    // function: Function(address=134324284, size=36, name='gc_helper_get_regs_and_sp', path='build/gchelper_m0.o', joint_set={0}, stop_set={34})
    abstract protected void gc_helper_get_regs_and_sp(int offset) throws Exception;
    protected int gc_helper_get_regs_and_sp = 0x0801a03c;
    public void gc_helper_get_regs_and_sp() throws Exception
    {
        call(this.gc_helper_get_regs_and_sp, this::gc_helper_get_regs_and_sp);
    }


    // function: Function(address=134324320, size=8, name='stdio_obj___exit__', path='build/lib/utils/sys_stdio_mphal.o', joint_set={0}, stop_set={2})
    abstract protected void stdio_obj___exit__(int offset) throws Exception;
    protected int stdio_obj___exit__ = 0x0801a060;
    public void stdio_obj___exit__() throws Exception
    {
        call(this.stdio_obj___exit__, this::stdio_obj___exit__);
    }


    // function: Function(address=134324328, size=16, name='stdio_obj_print', path='build/lib/utils/sys_stdio_mphal.o', joint_set={0, 10}, stop_set={10})
    abstract protected void stdio_obj_print(int offset) throws Exception;
    protected int stdio_obj_print = 0x0801a068;
    public void stdio_obj_print() throws Exception
    {
        call(this.stdio_obj_print, this::stdio_obj_print);
    }


    // function: Function(address=134324344, size=16, name='stdio_buffer_write', path='build/lib/utils/sys_stdio_mphal.o', joint_set={0, 12}, stop_set={14})
    abstract protected void stdio_buffer_write(int offset) throws Exception;
    protected int stdio_buffer_write = 0x0801a078;
    public void stdio_buffer_write() throws Exception
    {
        call(this.stdio_buffer_write, this::stdio_buffer_write);
    }


    // function: Function(address=134324360, size=26, name='stdio_buffer_read', path='build/lib/utils/sys_stdio_mphal.o', joint_set={0, 8, 12, 16, 20}, stop_set={24, 14})
    abstract protected void stdio_buffer_read(int offset) throws Exception;
    protected int stdio_buffer_read = 0x0801a088;
    public void stdio_buffer_read() throws Exception
    {
        call(this.stdio_buffer_read, this::stdio_buffer_read);
    }


    // function: Function(address=134324386, size=36, name='stdio_write', path='build/lib/utils/sys_stdio_mphal.o', joint_set={0, 16, 26, 22}, stop_set={24, 34})
    abstract protected void stdio_write(int offset) throws Exception;
    protected int stdio_write = 0x0801a0a2;
    public void stdio_write() throws Exception
    {
        call(this.stdio_write, this::stdio_write);
    }


    // function: Function(address=134324422, size=50, name='stdio_read', path='build/lib/utils/sys_stdio_mphal.o', joint_set={0, 32, 34, 40, 10, 16, 20, 24, 28}, stop_set={48, 38, 22})
    abstract protected void stdio_read(int offset) throws Exception;
    protected int stdio_read = 0x0801a0c6;
    public void stdio_read() throws Exception
    {
        call(this.stdio_read, this::stdio_read);
    }


    // function: Function(address=134324472, size=44, name='mp_hal_stdout_tx_strn_cooked', path='build/lib/utils/stdout_helpers.o', joint_set={0, 36, 6, 10, 12, 18, 26}, stop_set={10, 38})
    abstract protected void mp_hal_stdout_tx_strn_cooked(int offset) throws Exception;
    protected int mp_hal_stdout_tx_strn_cooked = 0x0801a0f8;
    public void mp_hal_stdout_tx_strn_cooked() throws Exception
    {
        call(this.mp_hal_stdout_tx_strn_cooked, this::mp_hal_stdout_tx_strn_cooked);
    }


    // function: Function(address=134324516, size=18, name='mp_hal_stdout_tx_str', path='build/lib/utils/stdout_helpers.o', joint_set={0, 8, 16}, stop_set={16})
    abstract protected void mp_hal_stdout_tx_str(int offset) throws Exception;
    protected int mp_hal_stdout_tx_str = 0x0801a124;
    public void mp_hal_stdout_tx_str() throws Exception
    {
        call(this.mp_hal_stdout_tx_str, this::mp_hal_stdout_tx_str);
    }


    // function: Function(address=134324536, size=28, name='mp_hal_set_interrupt_char', path='build/lib/utils/interrupt_char.o', joint_set={0, 8, 14}, stop_set={18})
    abstract protected void mp_hal_set_interrupt_char(int offset) throws Exception;
    protected int mp_hal_set_interrupt_char = 0x0801a138;
    public void mp_hal_set_interrupt_char() throws Exception
    {
        call(this.mp_hal_set_interrupt_char, this::mp_hal_set_interrupt_char);
    }


    // function: Function(address=134324564, size=308, name='parse_compile_execute', path='build/lib/utils/pyexec.o', joint_set={0, 256, 128, 260, 266, 144, 274, 148, 24, 152, 156, 30, 164, 36, 170, 44, 174, 52, 56, 184, 186, 64, 198, 72, 78, 82, 212, 214, 90, 218, 92, 96, 224, 226, 104, 234, 108, 238, 116, 246}, stop_set={224, 168, 264, 212, 276})
    abstract protected void parse_compile_execute(int offset) throws Exception;
    protected int parse_compile_execute = 0x0801a154;
    public void parse_compile_execute() throws Exception
    {
        call(this.parse_compile_execute, this::parse_compile_execute);
    }


    // function: Function(address=134324872, size=160, name='pyexec_raw_repl', path='build/lib/utils/pyexec.o', joint_set={0, 134, 138, 14, 16, 22, 32, 36, 40, 44, 50, 56, 64, 68, 72, 78, 82, 90, 92, 98, 106, 112, 118, 124}, stop_set={66, 122, 138, 76, 90})
    abstract protected void pyexec_raw_repl(int offset) throws Exception;
    protected int pyexec_raw_repl = 0x0801a288;
    public void pyexec_raw_repl() throws Exception
    {
        call(this.pyexec_raw_repl, this::pyexec_raw_repl);
    }


    // function: Function(address=134325032, size=272, name='pyexec_friendly_repl', path='build/lib/utils/pyexec.o', joint_set={0, 136, 140, 14, 16, 146, 148, 22, 24, 156, 28, 160, 162, 40, 168, 44, 174, 50, 180, 182, 56, 62, 190, 192, 66, 198, 70, 204, 76, 78, 208, 82, 212, 86, 90, 220, 96, 228, 102, 232, 108, 236, 112, 118, 120, 124}, stop_set={64, 160, 106, 76, 238, 84, 180, 190})
    abstract protected void pyexec_friendly_repl(int offset) throws Exception;
    protected int pyexec_friendly_repl = 0x0801a328;
    public void pyexec_friendly_repl() throws Exception
    {
        call(this.pyexec_friendly_repl, this::pyexec_friendly_repl);
    }


    // function: Function(address=134325304, size=60, name='pyexec_frozen_module', path='build/lib/utils/pyexec.o', joint_set={0, 36, 8, 40, 42, 48, 18, 50, 24, 28}, stop_set={48, 38, 54})
    abstract protected void pyexec_frozen_module(int offset) throws Exception;
    protected int pyexec_frozen_module = 0x0801a438;
    public void pyexec_frozen_module() throws Exception
    {
        call(this.pyexec_frozen_module, this::pyexec_frozen_module);
    }


    // function: Function(address=134325364, size=70, name='memcpy', path='build/lib/libc/string0.o', joint_set={0, 32, 36, 44, 12, 14, 18, 52, 20, 56, 28, 62}, stop_set={18, 26, 68, 60})
    abstract protected void memcpy(int offset) throws Exception;
    protected int memcpy = 0x0801a474;
    public void memcpy() throws Exception
    {
        call(this.memcpy, this::memcpy);
    }


    // function: Function(address=134325434, size=36, name='memmove', path='build/lib/libc/string0.o', joint_set={0, 34, 6, 12, 16, 20, 22, 30}, stop_set={34, 20, 28})
    abstract protected void memmove(int offset) throws Exception;
    protected int memmove = 0x0801a4ba;
    public void memmove() throws Exception
    {
        call(this.memmove, this::memmove);
    }


    // function: Function(address=134325470, size=64, name='memset', path='build/lib/libc/string0.o', joint_set={0, 32, 36, 6, 10, 44, 14, 48, 20, 52, 56, 58, 28}, stop_set={56, 18, 62})
    abstract protected void memset(int offset) throws Exception;
    protected int memset = 0x0801a4de;
    public void memset() throws Exception
    {
        call(this.memset, this::memset);
    }


    // function: Function(address=134325534, size=36, name='memcmp', path='build/lib/libc/string0.o', joint_set={0, 4, 8, 10, 12, 20, 26, 30}, stop_set={10, 34, 28})
    abstract protected void memcmp(int offset) throws Exception;
    protected int memcmp = 0x0801a51e;
    public void memcmp() throws Exception
    {
        call(this.memcmp, this::memcmp);
    }


    // function: Function(address=134325570, size=18, name='strlen', path='build/lib/libc/string0.o', joint_set={0, 4, 12, 14}, stop_set={16, 12})
    abstract protected void strlen(int offset) throws Exception;
    protected int strlen = 0x0801a542;
    public void strlen() throws Exception
    {
        call(this.strlen, this::strlen);
    }


    // function: Function(address=134325588, size=46, name='strcmp', path='build/lib/libc/string0.o', joint_set={0, 32, 36, 38, 8, 12, 44, 18, 26, 28}, stop_set={16, 44, 30})
    abstract protected void strcmp(int offset) throws Exception;
    protected int strcmp = 0x0801a554;
    public void strcmp() throws Exception
    {
        call(this.strcmp, this::strcmp);
    }


    // function: Function(address=134325634, size=68, name='strncmp', path='build/lib/libc/string0.o', joint_set={0, 32, 66, 2, 34, 38, 8, 42, 14, 48, 18, 20, 22, 56, 62}, stop_set={66, 36, 20, 54, 60})
    abstract protected void strncmp(int offset) throws Exception;
    protected int strncmp = 0x0801a582;
    public void strncmp() throws Exception
    {
        call(this.strncmp, this::strncmp);
    }


    // function: Function(address=134325702, size=24, name='strchr', path='build/lib/libc/string0.o', joint_set={0, 2, 8, 12, 16, 18, 20}, stop_set={18, 22})
    abstract protected void strchr(int offset) throws Exception;
    protected int strchr = 0x0801a5c6;
    public void strchr() throws Exception
    {
        call(this.strchr, this::strchr);
    }


    // function: Function(address=134325728, size=48, name='mp_hal_move_cursor_back', path='build/lib/mp-readline/readline.o', joint_set={0, 8, 12, 16, 18, 28}, stop_set={16, 38})
    abstract protected void mp_hal_move_cursor_back(int offset) throws Exception;
    protected int mp_hal_move_cursor_back = 0x0801a5e0;
    public void mp_hal_move_cursor_back() throws Exception
    {
        call(this.mp_hal_move_cursor_back, this::mp_hal_move_cursor_back);
    }


    // function: Function(address=134325776, size=36, name='readline_init', path='build/lib/mp-readline/readline.o', joint_set={0, 30}, stop_set={30})
    abstract protected void readline_init(int offset) throws Exception;
    protected int readline_init = 0x0801a610;
    public void readline_init() throws Exception
    {
        call(this.readline_init, this::readline_init);
    }


    // function: Function(address=134325812, size=96, name='readline_push_history', path='build/lib/mp-readline/readline.o', joint_set={0, 32, 58, 38, 10, 28, 46, 50, 84, 22, 90, 60}, stop_set={90})
    abstract protected void readline_push_history(int offset) throws Exception;
    protected int readline_push_history = 0x0801a634;
    public void readline_push_history() throws Exception
    {
        call(this.readline_push_history, this::readline_push_history);
    }


    // function: Function(address=134325908, size=628, name='readline_process_char', path='build/lib/mp-readline/readline.o', joint_set={0, 514, 520, 524, 20, 22, 534, 28, 542, 546, 36, 548, 40, 42, 46, 558, 50, 562, 52, 56, 570, 62, 576, 68, 580, 584, 76, 78, 590, 594, 84, 598, 90, 602, 604, 94, 98, 106, 114, 116, 120, 124, 142, 146, 152, 158, 174, 184, 192, 208, 222, 230, 250, 254, 258, 266, 272, 276, 280, 286, 292, 294, 296, 302, 306, 314, 322, 330, 336, 350, 356, 360, 378, 384, 392, 396, 402, 416, 422, 434, 438, 448, 452, 466, 468, 472, 480, 484, 488, 492, 504, 510}, stop_set={256, 320, 546, 482, 228, 390, 582, 40, 300, 588, 432, 466, 82, 274, 50, 118, 502, 20, 602, 606})
    abstract protected void readline_process_char(int offset) throws Exception;
    protected int readline_process_char = 0x0801a694;
    public void readline_process_char() throws Exception
    {
        call(this.readline_process_char, this::readline_process_char);
    }


    // function: Function(address=134326536, size=20, name='readline', path='build/lib/mp-readline/readline.o', joint_set={0, 6, 10, 14, 18}, stop_set={18})
    abstract protected void readline(int offset) throws Exception;
    protected int readline = 0x0801a908;
    public void readline() throws Exception
    {
        call(this.readline, this::readline);
    }


    // function: Function(address=134326556, size=98, name='scalbnf', path='build/lib/libm/math.o', joint_set={0, 34, 70, 38, 40, 8, 76, 92, 50, 52, 20, 86, 24, 60}, stop_set={96, 50})
    abstract protected void scalbnf(int offset) throws Exception;
    protected int scalbnf = 0x0801a91c;
    public void scalbnf() throws Exception
    {
        call(this.scalbnf, this::scalbnf);
    }


    // function: Function(address=134326656, size=1696, name='powf', path='build/lib/libm/math.o', joint_set={0, 1536, 516, 1028, 1548, 1036, 528, 16, 18, 1530, 1554, 532, 1044, 536, 1560, 1050, 28, 30, 1566, 552, 1576, 1578, 44, 558, 48, 1584, 1586, 1076, 56, 568, 1592, 60, 1084, 1598, 576, 1602, 66, 1604, 1606, 1096, 72, 586, 1610, 78, 598, 1116, 96, 610, 612, 614, 1126, 616, 106, 624, 1136, 114, 120, 634, 1146, 126, 130, 642, 132, 134, 646, 648, 138, 146, 148, 662, 150, 156, 1184, 160, 164, 1192, 168, 1202, 182, 1210, 190, 1216, 194, 708, 198, 710, 200, 1224, 716, 718, 1230, 208, 212, 726, 1240, 218, 220, 1248, 738, 228, 1254, 748, 1260, 1266, 756, 246, 1272, 762, 250, 1278, 260, 772, 1284, 264, 1290, 780, 272, 1296, 274, 278, 790, 1302, 282, 286, 798, 288, 1312, 806, 296, 1320, 300, 816, 304, 1330, 310, 824, 1336, 314, 316, 830, 1342, 836, 326, 328, 1352, 842, 334, 848, 1360, 338, 854, 1366, 346, 860, 350, 866, 1378, 356, 872, 362, 1388, 366, 880, 1394, 374, 890, 1402, 1408, 902, 1418, 910, 1426, 920, 412, 1436, 926, 420, 934, 1448, 428, 940, 1458, 438, 950, 1466, 960, 1472, 450, 962, 968, 458, 1482, 464, 1490, 474, 1500, 484, 1508, 492, 498, 1524, 506}, stop_set={130, 646, 16, 146, 280, 1564, 28, 286, 158, 294, 1576, 1584, 308, 180, 58, 960, 1602, 1604, 198, 326, 1608, 970, 1614, 218, 348, 354, 610, 614, 376})
    abstract protected void powf(int offset) throws Exception;
    protected int powf = 0x0801a980;
    public void powf() throws Exception
    {
        call(this.powf, this::powf);
    }


    // function: Function(address=134328352, size=344, name='expf', path='build/lib/libm/math.o', joint_set={0, 258, 136, 264, 140, 142, 272, 18, 148, 276, 278, 24, 156, 284, 286, 28, 164, 36, 40, 44, 174, 50, 184, 186, 58, 194, 66, 202, 76, 80, 208, 214, 86, 222, 94, 102, 232, 244, 116, 118, 252, 126}, stop_set={292, 38, 78, 276, 116, 56, 284})
    abstract protected void expf(int offset) throws Exception;
    protected int expf = 0x0801b020;
    public void expf() throws Exception
    {
        call(this.expf, this::expf);
    }


    // function: Function(address=134328696, size=664, name='expm1f', path='build/lib/libm/math.o', joint_set={0, 514, 518, 522, 526, 530, 18, 26, 28, 544, 32, 34, 550, 40, 44, 50, 562, 566, 54, 56, 570, 574, 62, 64, 580, 70, 588, 76, 80, 594, 86, 94, 104, 110, 112, 122, 132, 140, 146, 152, 160, 170, 178, 188, 198, 206, 214, 220, 224, 232, 238, 242, 246, 248, 252, 262, 270, 274, 278, 282, 286, 292, 300, 308, 318, 322, 328, 334, 340, 346, 350, 356, 360, 366, 372, 378, 384, 390, 398, 406, 408, 412, 416, 424, 428, 438, 446, 452, 460, 466, 474, 478, 488, 496, 504, 510}, stop_set={320, 32, 354, 450, 260, 26, 326, 358, 524, 592, 528, 596, 54, 246, 62, 410, 476, 572})
    abstract protected void expm1f(int offset) throws Exception;
    protected int expm1f = 0x0801b178;
    public void expm1f() throws Exception
    {
        call(this.expm1f, this::expm1f);
    }


    // function: Function(address=134329360, size=36, name='__expo2f', path='build/lib/libm/math.o', joint_set={0, 8, 12, 20, 28}, stop_set={28})
    abstract protected void __expo2f(int offset) throws Exception;
    protected int __expo2f = 0x0801b410;
    public void __expo2f() throws Exception
    {
        call(this.__expo2f, this::__expo2f);
    }


    // function: Function(address=134329396, size=340, name='logf', path='build/lib/libm/math.o', joint_set={0, 264, 138, 144, 272, 18, 16, 274, 22, 278, 280, 28, 160, 32, 290, 36, 292, 40, 170, 44, 176, 50, 54, 182, 62, 192, 68, 198, 204, 212, 218, 92, 224, 102, 234, 110, 242, 118, 254, 248, 126}, stop_set={290, 294, 38, 272, 16, 52, 278})
    abstract protected void logf(int offset) throws Exception;
    protected int logf = 0x0801b434;
    public void logf() throws Exception
    {
        call(this.logf, this::logf);
    }


    // function: Function(address=134329736, size=20, name='log10f', path='build/lib/libm/math.o', joint_set={0, 12, 6}, stop_set={12})
    abstract protected void log10f(int offset) throws Exception;
    protected int log10f = 0x0801b588;
    public void log10f() throws Exception
    {
        call(this.log10f, this::log10f);
    }


    // function: Function(address=134329756, size=144, name='coshf', path='build/lib/libm/math.o', joint_set={0, 128, 96, 36, 68, 38, 42, 108, 76, 14, 92, 28, 114, 50, 84, 20, 86, 122, 124, 62}, stop_set={128, 122, 36, 84})
    abstract protected void coshf(int offset) throws Exception;
    protected int coshf = 0x0801b59c;
    public void coshf() throws Exception
    {
        call(this.coshf, this::coshf);
    }


    // function: Function(address=134329900, size=160, name='sinhf', path='build/lib/libm/math.o', joint_set={0, 128, 132, 8, 12, 142, 24, 28, 36, 42, 48, 58, 70, 78, 86, 88, 92, 94, 98, 104, 112, 120, 126}, stop_set={96, 102, 144, 126})
    abstract protected void sinhf(int offset) throws Exception;
    protected int sinhf = 0x0801b62c;
    public void sinhf() throws Exception
    {
        call(this.sinhf, this::sinhf);
    }


    // function: Function(address=134330060, size=76, name='tanhf', path='build/lib/libm/math.o', joint_set={0, 32, 66, 40, 42, 44, 16, 50, 20, 58, 28}, stop_set={42, 66})
    abstract protected void tanhf(int offset) throws Exception;
    protected int tanhf = 0x0801b6cc;
    public void tanhf() throws Exception
    {
        call(this.tanhf, this::tanhf);
    }


    // function: Function(address=134330136, size=88, name='ceilf', path='build/lib/libm/math.o', joint_set={0, 66, 26, 34, 70, 42, 76, 44, 46, 14, 50, 18, 58}, stop_set={48, 74, 80})
    abstract protected void ceilf(int offset) throws Exception;
    protected int ceilf = 0x0801b718;
    public void ceilf() throws Exception
    {
        call(this.ceilf, this::ceilf);
    }


    // function: Function(address=134330224, size=88, name='floorf', path='build/lib/libm/math.o', joint_set={0, 66, 26, 34, 70, 74, 42, 44, 46, 14, 50, 18, 58}, stop_set={48, 72, 76})
    abstract protected void floorf(int offset) throws Exception;
    protected int floorf = 0x0801b770;
    public void floorf() throws Exception
    {
        call(this.floorf, this::floorf);
    }


    // function: Function(address=134330312, size=48, name='truncf', path='build/lib/libm/math.o', joint_set={0, 38, 46, 14, 18, 20, 30}, stop_set={46})
    abstract protected void truncf(int offset) throws Exception;
    protected int truncf = 0x0801b7c8;
    public void truncf() throws Exception
    {
        call(this.truncf, this::truncf);
    }


    // function: Function(address=134330360, size=160, name='acoshf', path='build/lib/libm/acoshf.o', joint_set={0, 128, 132, 134, 138, 14, 144, 22, 30, 40, 48, 52, 60, 64, 66, 72, 78, 86, 90, 100, 110, 120}, stop_set={64, 132, 144})
    abstract protected void acoshf(int offset) throws Exception;
    protected int acoshf = 0x0801b7f8;
    public void acoshf() throws Exception
    {
        call(this.acoshf, this::acoshf);
    }


    // function: Function(address=134330520, size=80, name='text_R', path='build/lib/libm/asinfacosf.o', joint_set={0, 34, 10, 44, 60, 16, 52, 22, 28}, stop_set={60})
    abstract protected void text_R(int offset) throws Exception;
    protected int text_R = 0x0801b898;
    public void text_R() throws Exception
    {
        call(this.text_R, this::text_R);
    }


    // function: Function(address=134330600, size=196, name='asinf', path='build/lib/libm/asinfacosf.o', joint_set={0, 132, 138, 144, 16, 150, 22, 28, 158, 32, 164, 36, 38, 44, 52, 54, 58, 64, 74, 80, 84, 90, 96, 104, 112, 118, 126}, stop_set={56, 170, 36, 94})
    abstract protected void asinf(int offset) throws Exception;
    protected int asinf = 0x0801b8e8;
    public void asinf() throws Exception
    {
        call(this.asinf, this::asinf);
    }


    // function: Function(address=134330796, size=288, name='acosf', path='build/lib/libm/asinfacosf.o', joint_set={0, 128, 260, 262, 136, 142, 14, 148, 20, 154, 26, 30, 162, 36, 168, 170, 44, 46, 180, 52, 188, 60, 194, 66, 70, 76, 208, 84, 216, 92, 226, 100, 102, 234, 106, 242, 114, 248, 122, 254}, stop_set={260, 100, 168, 264, 44, 28})
    abstract protected void acosf(int offset) throws Exception;
    protected int acosf = 0x0801b9ac;
    public void acosf() throws Exception
    {
        call(this.acosf, this::acosf);
    }


    // function: Function(address=134331084, size=200, name='asinhf', path='build/lib/libm/asinhf.o', joint_set={0, 134, 138, 16, 146, 22, 154, 28, 30, 160, 34, 164, 166, 40, 44, 176, 50, 58, 66, 70, 76, 86, 96, 104, 108, 110, 116, 124}, stop_set={108, 42, 164, 180})
    abstract protected void asinhf(int offset) throws Exception;
    protected int asinhf = 0x0801bacc;
    public void asinhf() throws Exception
    {
        call(this.asinhf, this::asinhf);
    }


    // function: Function(address=134331284, size=304, name='atan2f', path='build/lib/libm/atan2f.o', joint_set={0, 128, 256, 260, 132, 264, 136, 12, 140, 16, 144, 150, 24, 28, 156, 36, 166, 40, 170, 174, 48, 54, 184, 56, 192, 200, 72, 202, 76, 206, 80, 210, 84, 214, 90, 94, 222, 98, 226, 230, 122, 106, 238, 110, 114, 246, 118, 250, 124, 254}, stop_set={96, 224, 130, 258, 228, 38, 262, 134, 266, 236, 82, 54, 254, 154, 126})
    abstract protected void atan2f(int offset) throws Exception;
    protected int atan2f = 0x0801bb94;
    public void atan2f() throws Exception
    {
        call(this.atan2f, this::atan2f);
    }


    // function: Function(address=134331588, size=456, name='atanf', path='build/lib/libm/atanf.o', joint_set={0, 128, 382, 132, 262, 268, 140, 274, 148, 20, 26, 156, 284, 30, 162, 36, 38, 168, 40, 296, 46, 174, 304, 180, 52, 312, 58, 60, 190, 318, 66, 196, 326, 72, 202, 332, 78, 210, 338, 86, 216, 348, 220, 92, 354, 228, 100, 232, 364, 108, 242, 372, 374, 120, 254}, stop_set={384, 36, 230, 330, 266, 44, 76, 336, 372, 316, 58, 380})
    abstract protected void atanf(int offset) throws Exception;
    protected int atanf = 0x0801bcc4;
    public void atanf() throws Exception
    {
        call(this.atanf, this::atanf);
    }


    // function: Function(address=134332044, size=144, name='atanhf', path='build/lib/libm/atanhf.o', joint_set={0, 96, 66, 34, 38, 104, 42, 108, 28, 78, 48, 16, 52, 118, 86, 88, 22, 58, 92, 126}, stop_set={128, 50, 106})
    abstract protected void atanhf(int offset) throws Exception;
    protected int atanhf = 0x0801be8c;
    public void atanhf() throws Exception
    {
        call(this.atanhf, this::atanhf);
    }


    // function: Function(address=134332188, size=692, name='__ieee754_rem_pio2f', path='build/lib/libm/ef_rem_pio2.o', joint_set={0, 386, 258, 514, 132, 510, 392, 524, 142, 400, 144, 402, 18, 276, 532, 148, 280, 152, 538, 24, 28, 156, 542, 416, 34, 162, 424, 298, 554, 170, 46, 306, 434, 562, 180, 50, 184, 56, 570, 316, 444, 190, 62, 192, 576, 450, 326, 200, 584, 74, 72, 332, 460, 590, 78, 208, 82, 466, 212, 342, 88, 218, 348, 476, 478, 120, 608, 94, 226, 484, 358, 102, 616, 234, 618, 490, 496, 112, 244, 372, 116, 376, 126, 254}, stop_set={26, 616, 190, 494, 400, 114, 86, 278, 634, 182, 154, 476, 414})
    abstract protected void __ieee754_rem_pio2f(int offset) throws Exception;
    protected int __ieee754_rem_pio2f = 0x0801bf1c;
    public void __ieee754_rem_pio2f() throws Exception
    {
        call(this.__ieee754_rem_pio2f, this::__ieee754_rem_pio2f);
    }


    // function: Function(address=134332880, size=176, name='sqrtf', path='build/lib/libm/ef_sqrt.o', joint_set={0, 130, 144, 16, 148, 22, 152, 158, 30, 32, 36, 40, 44, 50, 56, 58, 66, 82, 84, 98, 104, 110, 120, 124}, stop_set={34, 164, 142, 56, 156})
    abstract protected void sqrtf(int offset) throws Exception;
    protected int sqrtf = 0x0801c1d0;
    public void sqrtf() throws Exception
    {
        call(this.sqrtf, this::sqrtf);
    }


    // function: Function(address=134333056, size=1976, name='__ieee754_lgammaf_r', path='build/lib/libm/erf_lgamma.o', joint_set={0, 1024, 1538, 518, 1030, 1032, 1542, 524, 1038, 1550, 530, 1556, 1044, 22, 536, 1560, 28, 1052, 542, 1532, 32, 1568, 36, 1572, 548, 1060, 554, 1066, 1580, 46, 1582, 48, 560, 1072, 1588, 1590, 566, 1078, 54, 58, 1596, 1084, 1598, 576, 1090, 1604, 582, 1096, 588, 76, 78, 1102, 1616, 1618, 594, 1108, 82, 86, 600, 1114, 1628, 94, 606, 1630, 1120, 98, 100, 612, 1638, 1126, 106, 618, 1132, 1646, 112, 626, 1652, 1142, 118, 632, 1658, 1148, 126, 128, 1664, 640, 1154, 1670, 136, 648, 1160, 140, 1676, 652, 1166, 1682, 658, 148, 1172, 1688, 1178, 668, 158, 1694, 1184, 162, 674, 1700, 1190, 680, 1706, 172, 1196, 688, 176, 1202, 1716, 694, 184, 1722, 1210, 1728, 704, 1218, 708, 198, 1734, 200, 204, 1740, 716, 1230, 1746, 722, 1238, 216, 1752, 728, 1244, 1758, 734, 224, 1246, 1250, 1764, 740, 1254, 228, 1770, 746, 1260, 1262, 238, 1776, 752, 244, 1270, 758, 1784, 1272, 764, 1276, 252, 1280, 770, 258, 1796, 1800, 776, 1290, 1288, 1804, 268, 272, 1808, 274, 786, 1298, 278, 792, 1304, 1306, 282, 1818, 798, 286, 288, 804, 1316, 296, 810, 1322, 1324, 816, 306, 1332, 822, 1338, 316, 828, 1340, 322, 834, 1350, 326, 842, 1356, 1360, 336, 850, 1364, 342, 1368, 1370, 348, 862, 1376, 356, 870, 1382, 360, 364, 1388, 1394, 372, 374, 1402, 1406, 384, 390, 1418, 396, 1426, 404, 410, 1434, 414, 1440, 418, 1446, 424, 426, 1452, 434, 1458, 436, 1464, 444, 1470, 452, 1476, 1482, 460, 1488, 466, 1494, 472, 1500, 478, 484, 1512, 490, 496, 1524, 502, 508}, stop_set={1536, 1030, 650, 1806, 402, 1558, 1818, 30, 672, 416, 1570, 294, 424, 1580, 46, 692, 1588, 1596, 320, 198, 202, 80, 1616, 1368, 92, 1374, 354, 98, 1380, 870, 1386, 1260, 1392, 372, 1270})
    abstract protected void __ieee754_lgammaf_r(int offset) throws Exception;
    protected int __ieee754_lgammaf_r = 0x0801c280;
    public void __ieee754_lgammaf_r() throws Exception
    {
        call(this.__ieee754_lgammaf_r, this::__ieee754_lgammaf_r);
    }


    // function: Function(address=134335032, size=208, name='fmodf', path='build/lib/libm/fmodf.o', joint_set={0, 128, 136, 10, 16, 144, 20, 150, 30, 160, 38, 166, 44, 46, 176, 50, 180, 182, 184, 56, 58, 190, 66, 68, 196, 74, 78, 86, 96, 100, 106, 112, 116, 120, 124}, stop_set={194, 66, 164, 202, 142, 174, 48, 148, 188, 158})
    abstract protected void fmodf(int offset) throws Exception;
    protected int fmodf = 0x0801ca38;
    public void fmodf() throws Exception
    {
        call(this.fmodf, this::fmodf);
    }


    // function: Function(address=134335240, size=260, name='__kernel_cosf', path='build/lib/libm/kf_cos.o', joint_set={0, 128, 136, 144, 16, 20, 24, 152, 158, 32, 162, 164, 42, 170, 176, 52, 58, 186, 64, 196, 70, 202, 76, 208, 82, 212, 88, 94, 100, 106, 112, 118}, stop_set={216, 210, 162, 206})
    abstract protected void __kernel_cosf(int offset) throws Exception;
    protected int __kernel_cosf = 0x0801cb08;
    public void __kernel_cosf() throws Exception
    {
        call(this.__kernel_cosf, this::__kernel_cosf);
    }


    // function: Function(address=134335500, size=1428, name='__kernel_rem_pio2f', path='build/lib/libm/kf_rem_pio2.o', joint_set={0, 512, 1030, 520, 524, 526, 1038, 534, 1050, 538, 540, 546, 1058, 1062, 554, 1068, 558, 560, 1072, 568, 1090, 578, 580, 1098, 590, 1104, 82, 1106, 88, 1112, 600, 604, 606, 1120, 1122, 98, 1126, 614, 104, 106, 618, 620, 1132, 1138, 626, 628, 116, 632, 1144, 634, 636, 1150, 638, 1158, 134, 1160, 650, 138, 140, 1164, 656, 148, 1172, 1178, 666, 158, 670, 162, 1190, 678, 170, 1194, 684, 1198, 178, 1204, 184, 696, 1210, 190, 1216, 708, 198, 1224, 718, 206, 208, 1232, 1236, 732, 742, 744, 1264, 756, 1274, 250, 1280, 256, 258, 1292, 784, 1298, 276, 1302, 790, 792, 280, 282, 1312, 288, 1314, 292, 1318, 806, 294, 298, 300, 1328, 818, 306, 1336, 824, 1340, 316, 322, 844, 332, 1364, 852, 340, 344, 350, 1374, 1380, 358, 870, 1390, 878, 366, 882, 1398, 1402, 892, 382, 902, 390, 394, 912, 400, 916, 926, 416, 930, 934, 422, 944, 432, 436, 952, 440, 956, 456, 974, 464, 468, 984, 990, 998, 488, 492, 1006, 498, 1012}, stop_set={256, 648, 138, 1036, 1422, 654, 1148, 790, 280, 538, 414, 292, 420, 298, 682, 558, 694, 1338, 1214, 1088, 578, 1222, 1096, 842, 716, 846, 206, 1104, 1234, 1110, 982, 342, 730, 604, 740, 996, 104, 618, 490, 364, 1388, 632, 880, 626, 1142, 1400, 890, 636, 510})
    abstract protected void __kernel_rem_pio2f(int offset) throws Exception;
    protected int __kernel_rem_pio2f = 0x0801cc0c;
    public void __kernel_rem_pio2f() throws Exception
    {
        call(this.__kernel_rem_pio2f, this::__kernel_rem_pio2f);
    }


    // function: Function(address=134336928, size=236, name='__kernel_sinf', path='build/lib/libm/kf_sin.o', joint_set={0, 132, 134, 138, 18, 148, 22, 26, 158, 34, 166, 44, 172, 178, 54, 188, 60, 66, 196, 72, 204, 78, 84, 90, 96, 104, 112, 118, 124}, stop_set={136, 204})
    abstract protected void __kernel_sinf(int offset) throws Exception;
    protected int __kernel_sinf = 0x0801d1a0;
    public void __kernel_sinf() throws Exception
    {
        call(this.__kernel_sinf, this::__kernel_sinf);
    }


    // function: Function(address=134337164, size=604, name='__kernel_tanf', path='build/lib/libm/kf_tan.o', joint_set={0, 384, 130, 258, 514, 390, 264, 520, 138, 270, 526, 528, 398, 148, 276, 404, 282, 26, 412, 158, 30, 290, 34, 164, 296, 170, 44, 302, 430, 176, 50, 308, 182, 54, 440, 56, 314, 438, 188, 446, 62, 194, 324, 68, 200, 456, 74, 330, 206, 82, 212, 340, 86, 472, 218, 350, 94, 482, 228, 356, 102, 488, 234, 366, 240, 112, 498, 506, 246, 118, 376, 122, 252}, stop_set={72, 526, 530, 438, 60})
    abstract protected void __kernel_tanf(int offset) throws Exception;
    protected int __kernel_tanf = 0x0801d28c;
    public void __kernel_tanf() throws Exception
    {
        call(this.__kernel_tanf, this::__kernel_tanf);
    }


    // function: Function(address=134337768, size=448, name='log1pf', path='build/lib/libm/log1pf.o', joint_set={0, 260, 132, 266, 138, 142, 272, 16, 18, 148, 150, 280, 24, 286, 30, 34, 292, 166, 38, 168, 42, 302, 46, 178, 308, 54, 186, 58, 316, 194, 322, 66, 328, 202, 74, 80, 338, 84, 214, 90, 346, 220, 348, 96, 98, 354, 228, 356, 122, 358, 108, 238, 366, 378, 372, 244, 250, 126}, stop_set={384, 96, 354, 56, 376, 356, 44, 16, 370, 88, 346})
    abstract protected void log1pf(int offset) throws Exception;
    protected int log1pf = 0x0801d4e8;
    public void log1pf() throws Exception
    {
        call(this.log1pf, this::log1pf);
    }


    // function: Function(address=134338216, size=74, name='nearbyintf', path='build/lib/libm/nearbyintf.o', joint_set={0, 64, 34, 72, 42, 12, 46, 52, 22, 56, 26, 60}, stop_set={72, 58})
    abstract protected void nearbyintf(int offset) throws Exception;
    protected int nearbyintf = 0x0801d6a8;
    public void nearbyintf() throws Exception
    {
        call(this.nearbyintf, this::nearbyintf);
    }


    // function: Function(address=134338292, size=108, name='cosf', path='build/lib/libm/sf_cos.o', joint_set={0, 96, 34, 26, 68, 42, 76, 14, 60, 46, 50, 84, 20, 54, 86, 58, 28}, stop_set={96, 58, 74, 84, 26})
    abstract protected void cosf(int offset) throws Exception;
    protected int cosf = 0x0801d6f4;
    public void cosf() throws Exception
    {
        call(this.cosf, this::cosf);
    }


    // function: Function(address=134338400, size=1208, name='erff', path='build/lib/libm/sf_erf.o', joint_set={0, 1024, 516, 1030, 522, 1036, 528, 1042, 18, 534, 1048, 540, 1054, 30, 546, 1060, 552, 42, 558, 1070, 46, 50, 52, 564, 1076, 570, 1082, 58, 576, 1088, 64, 1094, 70, 586, 1100, 78, 592, 1106, 598, 1112, 88, 604, 1118, 96, 610, 1124, 616, 104, 1130, 108, 622, 1134, 110, 1138, 114, 628, 118, 1144, 634, 124, 640, 132, 646, 138, 652, 144, 658, 660, 150, 664, 156, 670, 162, 678, 168, 174, 184, 698, 190, 704, 708, 196, 202, 718, 208, 214, 728, 220, 736, 226, 232, 746, 240, 754, 758, 248, 252, 766, 258, 772, 774, 778, 268, 276, 282, 288, 294, 300, 306, 312, 318, 324, 330, 336, 342, 352, 358, 364, 370, 376, 382, 388, 394, 400, 406, 412, 420, 428, 432, 436, 440, 444, 446, 452, 456, 458, 464, 470, 988, 480, 994, 1000, 490, 492, 1006, 498, 1012, 504, 1018, 510}, stop_set={772, 456, 106, 490, 1132, 250, 462, 784, 50, 434, 116, 1142, 1146, 444})
    abstract protected void erff(int offset) throws Exception;
    protected int erff = 0x0801d760;
    public void erff() throws Exception
    {
        call(this.erff, this::erff);
    }


    // function: Function(address=134339608, size=1212, name='erfcf', path='build/lib/libm/sf_erf.o', joint_set={0, 514, 1028, 520, 1034, 526, 1040, 18, 532, 1046, 538, 26, 1052, 544, 550, 1062, 38, 42, 556, 1068, 46, 50, 562, 1074, 568, 1080, 56, 1086, 64, 578, 66, 68, 1092, 584, 72, 1098, 74, 590, 78, 1104, 596, 1110, 86, 602, 1116, 92, 608, 1122, 98, 614, 1126, 104, 1130, 620, 110, 626, 1138, 116, 632, 1144, 1146, 122, 638, 128, 644, 650, 138, 652, 656, 144, 662, 150, 156, 670, 162, 168, 174, 690, 180, 696, 186, 700, 194, 710, 202, 720, 208, 728, 216, 224, 738, 228, 746, 750, 238, 244, 758, 250, 764, 766, 256, 770, 266, 274, 280, 286, 292, 298, 304, 310, 316, 322, 328, 334, 340, 350, 356, 362, 368, 374, 380, 386, 392, 398, 404, 410, 418, 426, 430, 436, 442, 448, 454, 456, 968, 972, 462, 978, 472, 986, 992, 482, 484, 998, 490, 1004, 496, 1010, 502, 1016, 508, 1022}, stop_set={248, 770, 482, 1124, 446, 454, 226, 72, 48, 1136, 434, 1144, 764, 1150})
    abstract protected void erfcf(int offset) throws Exception;
    protected int erfcf = 0x0801dc18;
    public void erfcf() throws Exception
    {
        call(this.erfcf, this::erfcf);
    }


    // function: Function(address=134340820, size=84, name='frexpf', path='build/lib/libm/sf_frexp.o', joint_set={0, 70, 38, 50, 20, 24, 30}, stop_set={70})
    abstract protected void frexpf(int offset) throws Exception;
    protected int frexpf = 0x0801e0d4;
    public void frexpf() throws Exception
    {
        call(this.frexpf, this::frexpf);
    }


    // function: Function(address=134340904, size=64, name='ldexpf', path='build/lib/libm/sf_ldexp.o', joint_set={0, 34, 42, 46, 18, 22, 54, 56, 30}, stop_set={58})
    abstract protected void ldexpf(int offset) throws Exception;
    protected int ldexpf = 0x0801e128;
    public void ldexpf() throws Exception
    {
        call(this.ldexpf, this::ldexpf);
    }


    // function: Function(address=134340968, size=68, name='modff', path='build/lib/libm/sf_modf.o', joint_set={0, 34, 42, 14, 18, 52, 54, 24, 26}, stop_set={24, 40, 60, 52})
    abstract protected void modff(int offset) throws Exception;
    protected int modff = 0x0801e168;
    public void modff() throws Exception
    {
        call(this.modff, this::modff);
    }


    // function: Function(address=134341036, size=112, name='sinf', path='build/lib/libm/sf_sin.o', joint_set={0, 66, 34, 36, 102, 42, 74, 76, 12, 16, 50, 20, 22, 86, 54, 58, 28, 94}, stop_set={64, 34, 102, 74, 20, 92})
    abstract protected void sinf(int offset) throws Exception;
    protected int sinf = 0x0801e1ac;
    public void sinf() throws Exception
    {
        call(this.sinf, this::sinf);
    }


    // function: Function(address=134341148, size=68, name='tanf', path='build/lib/libm/sf_tan.o', joint_set={0, 34, 36, 42, 12, 16, 20, 22, 28}, stop_set={56, 34, 20})
    abstract protected void tanf(int offset) throws Exception;
    protected int tanf = 0x0801e21c;
    public void tanf() throws Exception
    {
        call(this.tanf, this::tanf);
    }


    // function: Function(address=134341216, size=10, name='lgammaf', path='build/lib/libm/wf_lgamma.o', joint_set={0, 8}, stop_set={8})
    abstract protected void lgammaf(int offset) throws Exception;
    protected int lgammaf = 0x0801e260;
    public void lgammaf() throws Exception
    {
        call(this.lgammaf, this::lgammaf);
    }


    // function: Function(address=134341226, size=26, name='tgammaf', path='build/lib/libm/wf_tgamma.o', joint_set={0, 8, 12, 18, 24}, stop_set={24})
    abstract protected void tgammaf(int offset) throws Exception;
    protected int tgammaf = 0x0801e26a;
    public void tgammaf() throws Exception
    {
        call(this.tgammaf, this::tgammaf);
    }


    // function: Function(address=134341252, size=276, name='__aeabi_uidiv', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(_udivsi3.o)', joint_set={0, 256, 130, 8, 264, 138, 14, 142, 20, 150, 154, 26, 158, 32, 164, 168, 44, 176, 50, 180, 56, 58, 188, 60, 192, 66, 70, 200, 204, 206, 78, 82, 212, 254, 216, 90, 94, 224, 228, 102, 106, 236, 108, 240, 242, 114, 246, 118, 248, 126}, stop_set={56, 264, 252, 254})
    abstract protected void __aeabi_uidiv(int offset) throws Exception;
    protected int __aeabi_uidiv = 0x0801e284;
    public void __aeabi_uidiv() throws Exception
    {
        call(this.__aeabi_uidiv, this::__aeabi_uidiv);
    }


    // function: Function(address=134341520, size=8, name='__aeabi_uidivmod', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(_udivsi3.o)', joint_set={0, 4}, stop_set={4})
    abstract protected void __aeabi_uidivmod(int offset) throws Exception;
    protected int __aeabi_uidivmod = 0x0801e390;
    public void __aeabi_uidivmod() throws Exception
    {
        call(this.__aeabi_uidivmod, this::__aeabi_uidivmod);
    }


    // function: Function(address=134341528, size=468, name='__divsi3', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(_divsi3.o)', joint_set={0, 6, 14, 20, 26, 32, 38, 50, 56, 62, 64, 66, 72, 76, 84, 88, 96, 100, 108, 112, 114, 120, 124, 132, 136, 144, 148, 156, 160, 164, 170, 174, 182, 186, 194, 198, 206, 210, 212, 218, 222, 230, 234, 242, 246, 248, 252, 254, 260, 262, 266, 268, 272, 274, 286, 292, 304, 312, 320, 324, 328, 330, 336, 340, 348, 352, 360, 364, 372, 376, 378, 384, 388, 396, 400, 404, 410, 414, 420, 422, 432, 436, 438, 440, 442, 448, 450, 458}, stop_set={258, 260, 326, 458, 440, 62})
    abstract protected void __divsi3(int offset) throws Exception;
    protected int __divsi3 = 0x0801e398;
    public void __divsi3() throws Exception
    {
        call(this.__divsi3, this::__divsi3);
    }


    // function: Function(address=134341988, size=8, name='__aeabi_idivmod', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(_divsi3.o)', joint_set={0, 4}, stop_set={4})
    abstract protected void __aeabi_idivmod(int offset) throws Exception;
    protected int __aeabi_idivmod = 0x0801e564;
    public void __aeabi_idivmod() throws Exception
    {
        call(this.__aeabi_idivmod, this::__aeabi_idivmod);
    }


    // function: Function(address=134341996, size=4, name='__aeabi_idiv0', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(_dvmd_tls.o)', joint_set={0}, stop_set={0})
    abstract protected void __aeabi_idiv0(int offset) throws Exception;
    protected int __aeabi_idiv0 = 0x0801e56c;
    public void __aeabi_idiv0() throws Exception
    {
        call(this.__aeabi_idiv0, this::__aeabi_idiv0);
    }


    // function: Function(address=134342000, size=116, name='__aeabi_cfrcmple', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(_arm_cmpsf2.o)', joint_set={0}, stop_set={6})
    abstract protected void __aeabi_cfrcmple(int offset) throws Exception;
    protected int __aeabi_cfrcmple = 0x0801e570;
    public void __aeabi_cfrcmple() throws Exception
    {
        call(this.__aeabi_cfrcmple, this::__aeabi_cfrcmple);
    }


    // function: Function(address=134342008, size=16, name='__aeabi_cfcmpeq', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(_arm_cmpsf2.o)', joint_set={0, 10, 6, 14}, stop_set={14})
    abstract protected void __aeabi_cfcmpeq(int offset) throws Exception;
    protected int __aeabi_cfcmpeq = 0x0801e578;
    public void __aeabi_cfcmpeq() throws Exception
    {
        call(this.__aeabi_cfcmpeq, this::__aeabi_cfcmpeq);
    }


    // function: Function(address=134342024, size=12, name='__aeabi_fcmpeq', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(_arm_cmpsf2.o)', joint_set={0, 6}, stop_set={10})
    abstract protected void __aeabi_fcmpeq(int offset) throws Exception;
    protected int __aeabi_fcmpeq = 0x0801e588;
    public void __aeabi_fcmpeq() throws Exception
    {
        call(this.__aeabi_fcmpeq, this::__aeabi_fcmpeq);
    }


    // function: Function(address=134342036, size=20, name='__aeabi_fcmplt', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(_arm_cmpsf2.o)', joint_set={0, 10, 6, 14}, stop_set={16, 12})
    abstract protected void __aeabi_fcmplt(int offset) throws Exception;
    protected int __aeabi_fcmplt = 0x0801e594;
    public void __aeabi_fcmplt() throws Exception
    {
        call(this.__aeabi_fcmplt, this::__aeabi_fcmplt);
    }


    // function: Function(address=134342056, size=20, name='__aeabi_fcmple', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(_arm_cmpsf2.o)', joint_set={0, 10, 6, 14}, stop_set={16, 12})
    abstract protected void __aeabi_fcmple(int offset) throws Exception;
    protected int __aeabi_fcmple = 0x0801e5a8;
    public void __aeabi_fcmple() throws Exception
    {
        call(this.__aeabi_fcmple, this::__aeabi_fcmple);
    }


    // function: Function(address=134342076, size=20, name='__aeabi_fcmpgt', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(_arm_cmpsf2.o)', joint_set={0, 10, 6, 14}, stop_set={16, 12})
    abstract protected void __aeabi_fcmpgt(int offset) throws Exception;
    protected int __aeabi_fcmpgt = 0x0801e5bc;
    public void __aeabi_fcmpgt() throws Exception
    {
        call(this.__aeabi_fcmpgt, this::__aeabi_fcmpgt);
    }


    // function: Function(address=134342096, size=20, name='__aeabi_fcmpge', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(_arm_cmpsf2.o)', joint_set={0, 10, 6, 14}, stop_set={16, 12})
    abstract protected void __aeabi_fcmpge(int offset) throws Exception;
    protected int __aeabi_fcmpge = 0x0801e5d0;
    public void __aeabi_fcmpge() throws Exception
    {
        call(this.__aeabi_fcmpge, this::__aeabi_fcmpge);
    }


    // function: Function(address=134342116, size=48, name='__fixunssfsi', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(_fixunssfsi.o)', joint_set={0, 34, 38, 12, 16, 22, 24}, stop_set={46, 22})
    abstract protected void __fixunssfsi(int offset) throws Exception;
    protected int __fixunssfsi = 0x0801e5e4;
    public void __fixunssfsi() throws Exception
    {
        call(this.__fixunssfsi, this::__fixunssfsi);
    }


    // function: Function(address=134342164, size=820, name='__aeabi_fadd', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(addsf3.o)', joint_set={0, 512, 514, 520, 524, 530, 536, 540, 544, 554, 46, 562, 50, 566, 54, 570, 58, 60, 574, 66, 578, 68, 582, 74, 586, 592, 594, 600, 604, 94, 608, 98, 612, 100, 618, 108, 110, 116, 630, 118, 122, 634, 638, 130, 134, 646, 136, 650, 140, 144, 150, 154, 666, 156, 672, 676, 680, 682, 172, 174, 178, 692, 184, 698, 186, 700, 706, 710, 712, 204, 718, 208, 214, 728, 218, 220, 734, 736, 746, 236, 238, 752, 242, 756, 246, 252, 766, 768, 260, 776, 780, 786, 790, 794, 798, 288, 800, 806, 298, 306, 308, 312, 314, 322, 328, 332, 336, 338, 342, 346, 360, 366, 370, 372, 376, 380, 388, 392, 394, 410, 418, 424, 426, 436, 438, 442, 450, 454, 464, 476, 480, 484, 488, 490, 498, 504, 506, 510}, stop_set={512, 128, 774, 134, 518, 392, 788, 534, 792, 154, 670, 798, 416, 804, 422, 808, 680, 552, 560, 436, 312, 184, 58, 576, 704, 66, 580, 326, 710, 202, 462, 336, 598, 726, 474, 218, 92, 734, 98, 358, 488, 632, 108, 496, 370, 628, 116, 504, 764, 510})
    abstract protected void __aeabi_fadd(int offset) throws Exception;
    protected int __aeabi_fadd = 0x0801e614;
    public void __aeabi_fadd() throws Exception
    {
        call(this.__aeabi_fadd, this::__aeabi_fadd);
    }


    // function: Function(address=134342984, size=548, name='__aeabi_fdiv', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(divsf3.o)', joint_set={0, 514, 390, 264, 396, 140, 398, 272, 148, 276, 280, 152, 408, 412, 28, 160, 416, 162, 32, 292, 422, 166, 298, 174, 48, 178, 186, 316, 190, 68, 328, 72, 334, 464, 86, 214, 472, 222, 96, 98, 228, 232, 250, 106, 492, 110, 500, 244, 502, 506, 252, 382}, stop_set={512, 96, 290, 226, 344, 518, 326, 430, 242, 212, 470, 278, 120, 314, 184})
    abstract protected void __aeabi_fdiv(int offset) throws Exception;
    protected int __aeabi_fdiv = 0x0801e948;
    public void __aeabi_fdiv() throws Exception
    {
        call(this.__aeabi_fdiv, this::__aeabi_fdiv);
    }


    // function: Function(address=134343532, size=80, name='__eqsf2', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(eqsf2.o)', joint_set={0, 64, 66, 58, 36, 38, 72, 42, 74, 46, 50, 26, 30}, stop_set={64, 36, 72, 76, 56})
    abstract protected void __eqsf2(int offset) throws Exception;
    protected int __eqsf2 = 0x0801eb6c;
    public void __eqsf2() throws Exception
    {
        call(this.__eqsf2, this::__eqsf2);
    }


    // function: Function(address=134343612, size=156, name='__gesf2', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(gesf2.o)', joint_set={0, 130, 132, 136, 140, 146, 26, 30, 34, 38, 42, 46, 50, 58, 60, 64, 70, 74, 78, 82, 86, 88, 100, 106, 108, 112, 116, 120}, stop_set={128, 98, 68, 154, 106, 86, 58})
    abstract protected void __gesf2(int offset) throws Exception;
    protected int __gesf2 = 0x0801ebbc;
    public void __gesf2() throws Exception
    {
        call(this.__gesf2, this::__gesf2);
    }


    // function: Function(address=134343768, size=160, name='__ltsf2', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(lesf2.o)', joint_set={0, 134, 136, 140, 144, 148, 26, 30, 34, 38, 42, 46, 56, 60, 64, 68, 72, 76, 80, 90, 94, 98, 100, 104, 108, 114, 124}, stop_set={134, 54, 88, 122, 156, 62})
    abstract protected void __ltsf2(int offset) throws Exception;
    protected int __ltsf2 = 0x0801ec58;
    public void __ltsf2() throws Exception
    {
        call(this.__ltsf2, this::__ltsf2);
    }


    // function: Function(address=134343928, size=612, name='__aeabi_fmul', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(mulsf3.o)', joint_set={0, 384, 396, 140, 144, 402, 146, 534, 542, 544, 32, 290, 548, 36, 424, 298, 436, 54, 182, 442, 574, 578, 68, 584, 72, 330, 208, 338, 212, 86, 346, 350, 224, 376, 358, 102, 360, 230, 364, 110, 242, 114, 372, 116, 502, 248, 510}, stop_set={576, 452, 582, 422, 554, 394, 588, 206, 240, 144, 434, 114, 246, 156, 222, 382})
    abstract protected void __aeabi_fmul(int offset) throws Exception;
    protected int __aeabi_fmul = 0x0801ecf8;
    public void __aeabi_fmul() throws Exception
    {
        call(this.__aeabi_fmul, this::__aeabi_fmul);
    }


    // function: Function(address=134344540, size=904, name='__aeabi_fsub', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(subsf3.o)', joint_set={0, 512, 520, 524, 526, 536, 548, 552, 556, 46, 48, 562, 564, 52, 570, 58, 62, 576, 66, 68, 580, 584, 74, 588, 76, 82, 596, 84, 86, 600, 90, 92, 606, 96, 612, 102, 616, 110, 622, 112, 628, 632, 634, 636, 644, 648, 138, 652, 656, 148, 660, 664, 156, 668, 158, 162, 674, 164, 680, 172, 174, 178, 692, 696, 704, 708, 198, 202, 210, 724, 212, 730, 220, 734, 222, 226, 740, 742, 234, 238, 750, 240, 752, 244, 758, 248, 760, 764, 258, 772, 774, 264, 782, 788, 792, 284, 286, 290, 802, 296, 808, 298, 814, 828, 316, 832, 320, 322, 324, 838, 328, 842, 844, 338, 852, 856, 344, 862, 872, 876, 364, 880, 370, 372, 884, 890, 382, 384, 386, 392, 396, 398, 402, 404, 418, 422, 428, 436, 440, 444, 452, 456, 458, 474, 484, 488, 494, 496, 498, 502, 508}, stop_set={384, 642, 772, 524, 402, 658, 534, 416, 800, 162, 546, 296, 172, 46, 434, 690, 562, 568, 314, 826, 320, 578, 66, 196, 322, 840, 456, 586, 74, 850, 594, 210, 82, 854, 728, 90, 220, 860, 610, 482, 740, 870, 232, 874, 878, 750, 238, 110, 506, 626, 500, 888, 634, 758, 632, 370, 762, 892, 382})
    abstract protected void __aeabi_fsub(int offset) throws Exception;
    protected int __aeabi_fsub = 0x0801ef5c;
    public void __aeabi_fsub() throws Exception
    {
        call(this.__aeabi_fsub, this::__aeabi_fsub);
    }


    // function: Function(address=134345444, size=44, name='__aeabi_fcmpun', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(unordsf2.o)', joint_set={0, 32, 34, 40, 20, 26}, stop_set={32, 40})
    abstract protected void __aeabi_fcmpun(int offset) throws Exception;
    protected int __aeabi_fcmpun = 0x0801f2e4;
    public void __aeabi_fcmpun() throws Exception
    {
        call(this.__aeabi_fcmpun, this::__aeabi_fcmpun);
    }


    // function: Function(address=134345488, size=64, name='__aeabi_f2iz', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(fixsfsi.o)', joint_set={0, 36, 42, 44, 46, 16, 20, 52, 30}, stop_set={56, 50, 44})
    abstract protected void __aeabi_f2iz(int offset) throws Exception;
    protected int __aeabi_f2iz = 0x0801f310;
    public void __aeabi_f2iz() throws Exception
    {
        call(this.__aeabi_f2iz, this::__aeabi_f2iz);
    }


    // function: Function(address=134345552, size=148, name='__aeabi_i2f', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(floatsisf.o)', joint_set={0, 130, 98, 34, 6, 72, 104, 138, 44, 76, 110, 80, 48, 116, 20, 90, 28}, stop_set={128, 42, 136, 142})
    abstract protected void __aeabi_i2f(int offset) throws Exception;
    protected int __aeabi_i2f = 0x0801f350;
    public void __aeabi_i2f() throws Exception
    {
        call(this.__aeabi_i2f, this::__aeabi_i2f);
    }


    // function: Function(address=134345700, size=128, name='__aeabi_ui2f', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(floatunsisf.o)', joint_set={0, 96, 34, 66, 90, 102, 6, 38, 10, 76, 112, 18, 84, 118, 24, 58, 62}, stop_set={32, 122, 116, 110})
    abstract protected void __aeabi_ui2f(int offset) throws Exception;
    protected int __aeabi_ui2f = 0x0801f3e4;
    public void __aeabi_ui2f() throws Exception
    {
        call(this.__aeabi_ui2f, this::__aeabi_ui2f);
    }


    // function: Function(address=134345828, size=116, name='__aeabi_i2d', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(floatsidf.o)', joint_set={0, 32, 98, 6, 42, 76, 20}, stop_set={96, 74, 106})
    abstract protected void __aeabi_i2d(int offset) throws Exception;
    protected int __aeabi_i2d = 0x0801f464;
    public void __aeabi_i2d() throws Exception
    {
        call(this.__aeabi_i2d, this::__aeabi_i2d);
    }


    // function: Function(address=134345944, size=164, name='__aeabi_f2d', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(extendsfdf2.o)', joint_set={0, 66, 132, 70, 138, 108, 76, 112, 80, 20, 30, 62, 94, 126}, stop_set={130, 136, 106, 60, 148, 124})
    abstract protected void __aeabi_f2d(int offset) throws Exception;
    protected int __aeabi_f2d = 0x0801f4d8;
    public void __aeabi_f2d() throws Exception
    {
        call(this.__aeabi_f2d, this::__aeabi_f2d);
    }


    // function: Function(address=134346108, size=264, name='__aeabi_d2f', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(truncdfsf2.o)', joint_set={0, 128, 132, 142, 144, 146, 154, 28, 160, 36, 166, 40, 180, 58, 62, 196, 70, 72, 206, 80, 88, 222, 94, 98, 112, 118, 122}, stop_set={248, 140, 110, 220, 152, 158, 92, 126})
    abstract protected void __aeabi_d2f(int offset) throws Exception;
    protected int __aeabi_d2f = 0x0801f57c;
    public void __aeabi_d2f() throws Exception
    {
        call(this.__aeabi_d2f, this::__aeabi_d2f);
    }


    // function: Function(address=134346372, size=60, name='__clzsi2', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(_clzsi2.o)', joint_set={0, 34, 10, 14, 20, 24, 30}, stop_set={40})
    abstract protected void __clzsi2(int offset) throws Exception;
    protected int __clzsi2 = 0x0801f684;
    public void __clzsi2() throws Exception
    {
        call(this.__clzsi2, this::__clzsi2);
    }

}
