package kr.pe.ecmaxp.micropython.example;

import kr.pe.ecmaxp.thumbsk.CPU;
import kr.pe.ecmaxp.thumbjk.KotlinCPU;
import org.jetbrains.annotations.NotNull;

import static kr.pe.ecmaxp.thumbsk.helper.RegisterIndex.*;
import static kr.pe.ecmaxp.micropython.example.MicroPython_vals.*;

abstract public class MicroPython_link extends KotlinCPU
{
    public MicroPython_link(@NotNull CPU cpu)
    {
        super(cpu);
    }

    // function: Function(address=134217740, size=20, name='nlr_push_tail', path='build/py/nlr.o', has_indirect=True)
    abstract protected void nlr_push_tail(int offset) throws Exception;

    // function: Function(address=134217760, size=16, name='nlr_pop', path='build/py/nlr.o', has_indirect=False)
    abstract protected void nlr_pop(int offset) throws Exception;

    // function: Function(address=134217776, size=40, name='nlr_push', path='build/py/nlrthumb.o', has_indirect=False)
    abstract protected void nlr_push(int offset) throws Exception;

    // function: Function(address=134217816, size=68, name='nlr_jump', path='build/py/nlrthumb.o', has_indirect=False)
    abstract protected void nlr_jump(int offset) throws Exception;

    // function: Function(address=134217884, size=64, name='m_malloc', path='build/py/malloc.o', has_indirect=False)
    abstract protected void m_malloc(int offset) throws Exception;

    // function: Function(address=134217948, size=48, name='m_malloc_maybe', path='build/py/malloc.o', has_indirect=False)
    abstract protected void m_malloc_maybe(int offset) throws Exception;

    // function: Function(address=134217996, size=8, name='m_malloc0', path='build/py/malloc.o', has_indirect=False)
    abstract protected void m_malloc0(int offset) throws Exception;

    // function: Function(address=134218004, size=68, name='m_realloc', path='build/py/malloc.o', has_indirect=False)
    abstract protected void m_realloc(int offset) throws Exception;

    // function: Function(address=134218072, size=64, name='m_realloc_maybe', path='build/py/malloc.o', has_indirect=False)
    abstract protected void m_realloc_maybe(int offset) throws Exception;

    // function: Function(address=134218136, size=28, name='m_free', path='build/py/malloc.o', has_indirect=False)
    abstract protected void m_free(int offset) throws Exception;

    // function: Function(address=134218164, size=16, name='m_get_total_bytes_allocated', path='build/py/malloc.o', has_indirect=False)
    abstract protected void m_get_total_bytes_allocated(int offset) throws Exception;

    // function: Function(address=134218180, size=16, name='m_get_current_bytes_allocated', path='build/py/malloc.o', has_indirect=False)
    abstract protected void m_get_current_bytes_allocated(int offset) throws Exception;

    // function: Function(address=134218196, size=16, name='m_get_peak_bytes_allocated', path='build/py/malloc.o', has_indirect=False)
    abstract protected void m_get_peak_bytes_allocated(int offset) throws Exception;

    // function: Function(address=134218212, size=240, name='gc_mark_subtree', path='build/py/gc.o', has_indirect=False)
    abstract protected void gc_mark_subtree(int offset) throws Exception;

    // function: Function(address=134218452, size=128, name='gc_init', path='build/py/gc.o', has_indirect=False)
    abstract protected void gc_init(int offset) throws Exception;

    // function: Function(address=134218580, size=20, name='gc_lock', path='build/py/gc.o', has_indirect=False)
    abstract protected void gc_lock(int offset) throws Exception;

    // function: Function(address=134218600, size=20, name='gc_unlock', path='build/py/gc.o', has_indirect=False)
    abstract protected void gc_unlock(int offset) throws Exception;

    // function: Function(address=134218620, size=20, name='gc_is_locked', path='build/py/gc.o', has_indirect=False)
    abstract protected void gc_is_locked(int offset) throws Exception;

    // function: Function(address=134218640, size=276, name='gc_collect_start', path='build/py/gc.o', has_indirect=False)
    abstract protected void gc_collect_start(int offset) throws Exception;

    // function: Function(address=134218916, size=136, name='gc_collect_root', path='build/py/gc.o', has_indirect=False)
    abstract protected void gc_collect_root(int offset) throws Exception;

    // function: Function(address=134219052, size=412, name='gc_collect_end', path='build/py/gc.o', has_indirect=False)
    abstract protected void gc_collect_end(int offset) throws Exception;

    // function: Function(address=134219464, size=280, name='gc_info', path='build/py/gc.o', has_indirect=False)
    abstract protected void gc_info(int offset) throws Exception;

    // function: Function(address=134219744, size=460, name='gc_alloc', path='build/py/gc.o', has_indirect=False)
    abstract protected void gc_alloc(int offset) throws Exception;

    // function: Function(address=134220204, size=132, name='gc_free', path='build/py/gc.o', has_indirect=False)
    abstract protected void gc_free(int offset) throws Exception;

    // function: Function(address=134220336, size=108, name='gc_nbytes', path='build/py/gc.o', has_indirect=False)
    abstract protected void gc_nbytes(int offset) throws Exception;

    // function: Function(address=134220444, size=680, name='gc_realloc', path='build/py/gc.o', has_indirect=False)
    abstract protected void gc_realloc(int offset) throws Exception;

    // function: Function(address=134221124, size=316, name='gc_dump_info', path='build/py/gc.o', has_indirect=False)
    abstract protected void gc_dump_info(int offset) throws Exception;

    // function: Function(address=134221440, size=452, name='gc_dump_alloc_table', path='build/py/gc.o', has_indirect=False)
    abstract protected void gc_dump_alloc_table(int offset) throws Exception;

    // function: Function(address=134221892, size=16, name='mp_pystack_init', path='build/py/pystack.o', has_indirect=False)
    abstract protected void mp_pystack_init(int offset) throws Exception;

    // function: Function(address=134221908, size=48, name='mp_pystack_alloc', path='build/py/pystack.o', has_indirect=False)
    abstract protected void mp_pystack_alloc(int offset) throws Exception;

    // function: Function(address=134221956, size=28, name='find_qstr', path='build/py/qstr.o', has_indirect=False)
    abstract protected void find_qstr(int offset) throws Exception;

    // function: Function(address=134221984, size=36, name='qstr_compute_hash', path='build/py/qstr.o', has_indirect=False)
    abstract protected void qstr_compute_hash(int offset) throws Exception;

    // function: Function(address=134222020, size=24, name='qstr_init', path='build/py/qstr.o', has_indirect=False)
    abstract protected void qstr_init(int offset) throws Exception;

    // function: Function(address=134222044, size=108, name='qstr_find_strn', path='build/py/qstr.o', has_indirect=False)
    abstract protected void qstr_find_strn(int offset) throws Exception;

    // function: Function(address=134222152, size=296, name='qstr_from_strn', path='build/py/qstr.o', has_indirect=False)
    abstract protected void qstr_from_strn(int offset) throws Exception;

    // function: Function(address=134222448, size=18, name='qstr_from_str', path='build/py/qstr.o', has_indirect=False)
    abstract protected void qstr_from_str(int offset) throws Exception;

    // function: Function(address=134222466, size=16, name='qstr_hash', path='build/py/qstr.o', has_indirect=False)
    abstract protected void qstr_hash(int offset) throws Exception;

    // function: Function(address=134222482, size=10, name='qstr_len', path='build/py/qstr.o', has_indirect=False)
    abstract protected void qstr_len(int offset) throws Exception;

    // function: Function(address=134222492, size=10, name='qstr_str', path='build/py/qstr.o', has_indirect=False)
    abstract protected void qstr_str(int offset) throws Exception;

    // function: Function(address=134222502, size=16, name='qstr_data', path='build/py/qstr.o', has_indirect=False)
    abstract protected void qstr_data(int offset) throws Exception;

    // function: Function(address=134222520, size=120, name='qstr_pool_info', path='build/py/qstr.o', has_indirect=False)
    abstract protected void qstr_pool_info(int offset) throws Exception;

    // function: Function(address=134222640, size=68, name='qstr_dump_data', path='build/py/qstr.o', has_indirect=False)
    abstract protected void qstr_dump_data(int offset) throws Exception;

    // function: Function(address=134222708, size=56, name='vstr_ensure_extra', path='build/py/vstr.o', has_indirect=False)
    abstract protected void vstr_ensure_extra(int offset) throws Exception;

    // function: Function(address=134222764, size=36, name='vstr_add_strn', path='build/py/vstr.o', has_indirect=True)
    abstract protected void vstr_add_strn(int offset) throws Exception;

    // function: Function(address=134222800, size=48, name='vstr_ins_blank_bytes_constprop_2', path='build/py/vstr.o', has_indirect=False)
    abstract protected void vstr_ins_blank_bytes_constprop_2(int offset) throws Exception;

    // function: Function(address=134222848, size=34, name='vstr_init', path='build/py/vstr.o', has_indirect=False)
    abstract protected void vstr_init(int offset) throws Exception;

    // function: Function(address=134222882, size=16, name='vstr_init_len', path='build/py/vstr.o', has_indirect=False)
    abstract protected void vstr_init_len(int offset) throws Exception;

    // function: Function(address=134222898, size=18, name='vstr_init_fixed_buf', path='build/py/vstr.o', has_indirect=False)
    abstract protected void vstr_init_fixed_buf(int offset) throws Exception;

    // function: Function(address=134222916, size=24, name='vstr_init_print', path='build/py/vstr.o', has_indirect=False)
    abstract protected void vstr_init_print(int offset) throws Exception;

    // function: Function(address=134222940, size=24, name='vstr_clear', path='build/py/vstr.o', has_indirect=False)
    abstract protected void vstr_clear(int offset) throws Exception;

    // function: Function(address=134222964, size=22, name='vstr_new', path='build/py/vstr.o', has_indirect=False)
    abstract protected void vstr_new(int offset) throws Exception;

    // function: Function(address=134222986, size=30, name='vstr_free', path='build/py/vstr.o', has_indirect=False)
    abstract protected void vstr_free(int offset) throws Exception;

    // function: Function(address=134223016, size=48, name='vstr_extend', path='build/py/vstr.o', has_indirect=False)
    abstract protected void vstr_extend(int offset) throws Exception;

    // function: Function(address=134223064, size=22, name='vstr_add_len', path='build/py/vstr.o', has_indirect=False)
    abstract protected void vstr_add_len(int offset) throws Exception;

    // function: Function(address=134223086, size=30, name='vstr_null_terminated_str', path='build/py/vstr.o', has_indirect=False)
    abstract protected void vstr_null_terminated_str(int offset) throws Exception;

    // function: Function(address=134223116, size=14, name='vstr_add_byte', path='build/py/vstr.o', has_indirect=False)
    abstract protected void vstr_add_byte(int offset) throws Exception;

    // function: Function(address=134223132, size=152, name='vstr_add_char', path='build/py/vstr.o', has_indirect=False)
    abstract protected void vstr_add_char(int offset) throws Exception;

    // function: Function(address=134223284, size=24, name='vstr_add_str', path='build/py/vstr.o', has_indirect=False)
    abstract protected void vstr_add_str(int offset) throws Exception;

    // function: Function(address=134223308, size=12, name='vstr_ins_byte', path='build/py/vstr.o', has_indirect=False)
    abstract protected void vstr_ins_byte(int offset) throws Exception;

    // function: Function(address=134223320, size=12, name='vstr_ins_char', path='build/py/vstr.o', has_indirect=False)
    abstract protected void vstr_ins_char(int offset) throws Exception;

    // function: Function(address=134223332, size=16, name='vstr_cut_tail_bytes', path='build/py/vstr.o', has_indirect=False)
    abstract protected void vstr_cut_tail_bytes(int offset) throws Exception;

    // function: Function(address=134223348, size=46, name='vstr_cut_out_bytes', path='build/py/vstr.o', has_indirect=False)
    abstract protected void vstr_cut_out_bytes(int offset) throws Exception;

    // function: Function(address=134223394, size=12, name='plat_print_strn', path='build/py/mpprint.o', has_indirect=False)
    abstract protected void plat_print_strn(int offset) throws Exception;

    // function: Function(address=134223406, size=30, name='mp_print_str', path='build/py/mpprint.o', has_indirect=False)
    abstract protected void mp_print_str(int offset) throws Exception;

    // function: Function(address=134223436, size=184, name='mp_print_strn', path='build/py/mpprint.o', has_indirect=False)
    abstract protected void mp_print_strn(int offset) throws Exception;

    // function: Function(address=134223620, size=218, name='mp_print_int', path='build/py/mpprint.o', has_indirect=False)
    abstract protected void mp_print_int(int offset) throws Exception;

    // function: Function(address=134223840, size=576, name='mp_print_mp_int', path='build/py/mpprint.o', has_indirect=False)
    abstract protected void mp_print_mp_int(int offset) throws Exception;

    // function: Function(address=134224416, size=138, name='mp_print_float', path='build/py/mpprint.o', has_indirect=False)
    abstract protected void mp_print_float(int offset) throws Exception;

    // function: Function(address=134224556, size=672, name='mp_vprintf', path='build/py/mpprint.o', has_indirect=False)
    abstract protected void mp_vprintf(int offset) throws Exception;

    // function: Function(address=134225228, size=22, name='mp_printf', path='build/py/mpprint.o', has_indirect=False)
    abstract protected void mp_printf(int offset) throws Exception;

    // function: Function(address=134225250, size=54, name='utf8_get_char', path='build/py/unicode.o', has_indirect=False)
    abstract protected void utf8_get_char(int offset) throws Exception;

    // function: Function(address=134225304, size=18, name='utf8_next_char', path='build/py/unicode.o', has_indirect=False)
    abstract protected void utf8_next_char(int offset) throws Exception;

    // function: Function(address=134225322, size=30, name='utf8_ptr_to_index', path='build/py/unicode.o', has_indirect=False)
    abstract protected void utf8_ptr_to_index(int offset) throws Exception;

    // function: Function(address=134225352, size=32, name='utf8_charlen', path='build/py/unicode.o', has_indirect=False)
    abstract protected void utf8_charlen(int offset) throws Exception;

    // function: Function(address=134225384, size=24, name='unichar_isspace', path='build/py/unicode.o', has_indirect=True)
    abstract protected void unichar_isspace(int offset) throws Exception;

    // function: Function(address=134225408, size=24, name='unichar_isalpha', path='build/py/unicode.o', has_indirect=True)
    abstract protected void unichar_isalpha(int offset) throws Exception;

    // function: Function(address=134225432, size=24, name='unichar_isdigit', path='build/py/unicode.o', has_indirect=True)
    abstract protected void unichar_isdigit(int offset) throws Exception;

    // function: Function(address=134225456, size=24, name='unichar_isxdigit', path='build/py/unicode.o', has_indirect=False)
    abstract protected void unichar_isxdigit(int offset) throws Exception;

    // function: Function(address=134225480, size=32, name='unichar_isident', path='build/py/unicode.o', has_indirect=False)
    abstract protected void unichar_isident(int offset) throws Exception;

    // function: Function(address=134225512, size=24, name='unichar_isupper', path='build/py/unicode.o', has_indirect=True)
    abstract protected void unichar_isupper(int offset) throws Exception;

    // function: Function(address=134225536, size=24, name='unichar_islower', path='build/py/unicode.o', has_indirect=True)
    abstract protected void unichar_islower(int offset) throws Exception;

    // function: Function(address=134225560, size=18, name='unichar_tolower', path='build/py/unicode.o', has_indirect=True)
    abstract protected void unichar_tolower(int offset) throws Exception;

    // function: Function(address=134225578, size=18, name='unichar_toupper', path='build/py/unicode.o', has_indirect=True)
    abstract protected void unichar_toupper(int offset) throws Exception;

    // function: Function(address=134225596, size=14, name='unichar_xdigit_value', path='build/py/unicode.o', has_indirect=False)
    abstract protected void unichar_xdigit_value(int offset) throws Exception;

    // function: Function(address=134225610, size=78, name='utf8_check', path='build/py/unicode.o', has_indirect=False)
    abstract protected void utf8_check(int offset) throws Exception;

    // function: Function(address=134225688, size=20, name='mpn_remove_trailing_zeros', path='build/py/mpz.o', has_indirect=False)
    abstract protected void mpn_remove_trailing_zeros(int offset) throws Exception;

    // function: Function(address=134225708, size=62, name='text_mpn_shr', path='build/py/mpz.o', has_indirect=False)
    abstract protected void text_mpn_shr(int offset) throws Exception;

    // function: Function(address=134225770, size=88, name='text_mpn_add', path='build/py/mpz.o', has_indirect=False)
    abstract protected void text_mpn_add(int offset) throws Exception;

    // function: Function(address=134225858, size=80, name='text_mpn_sub', path='build/py/mpz.o', has_indirect=False)
    abstract protected void text_mpn_sub(int offset) throws Exception;

    // function: Function(address=134225940, size=112, name='mpn_xor_neg', path='build/py/mpz.o', has_indirect=False)
    abstract protected void mpn_xor_neg(int offset) throws Exception;

    // function: Function(address=134226052, size=50, name='mpz_need_dig', path='build/py/mpz.o', has_indirect=False)
    abstract protected void mpz_need_dig(int offset) throws Exception;

    // function: Function(address=134226102, size=76, name='mpz_clone', path='build/py/mpz.o', has_indirect=False)
    abstract protected void mpz_clone(int offset) throws Exception;

    // function: Function(address=134226178, size=44, name='mpn_cmp_part_1', path='build/py/mpz.o', has_indirect=False)
    abstract protected void mpn_cmp_part_1(int offset) throws Exception;

    // function: Function(address=134226222, size=28, name='mpz_free', path='build/py/mpz.o', has_indirect=False)
    abstract protected void mpz_free(int offset) throws Exception;

    // function: Function(address=134226250, size=58, name='mpz_set_from_int_part_4', path='build/py/mpz.o', has_indirect=False)
    abstract protected void mpz_set_from_int_part_4(int offset) throws Exception;

    // function: Function(address=134226308, size=10, name='mpz_init_zero', path='build/py/mpz.o', has_indirect=False)
    abstract protected void mpz_init_zero(int offset) throws Exception;

    // function: Function(address=134226318, size=26, name='mpz_deinit', path='build/py/mpz.o', has_indirect=False)
    abstract protected void mpz_deinit(int offset) throws Exception;

    // function: Function(address=134226344, size=46, name='mpz_set', path='build/py/mpz.o', has_indirect=False)
    abstract protected void mpz_set(int offset) throws Exception;

    // function: Function(address=134226390, size=16, name='mpz_set_from_int', path='build/py/mpz.o', has_indirect=False)
    abstract protected void mpz_set_from_int(int offset) throws Exception;

    // function: Function(address=134226406, size=20, name='mpz_init_from_int', path='build/py/mpz.o', has_indirect=False)
    abstract protected void mpz_init_from_int(int offset) throws Exception;

    // function: Function(address=134226426, size=42, name='mpz_init_fixed_from_int', path='build/py/mpz.o', has_indirect=False)
    abstract protected void mpz_init_fixed_from_int(int offset) throws Exception;

    // function: Function(address=134226468, size=88, name='mpz_set_from_ll', path='build/py/mpz.o', has_indirect=False)
    abstract protected void mpz_set_from_ll(int offset) throws Exception;

    // function: Function(address=134226556, size=190, name='mpz_set_from_float', path='build/py/mpz.o', has_indirect=False)
    abstract protected void mpz_set_from_float(int offset) throws Exception;

    // function: Function(address=134226746, size=164, name='mpz_set_from_str', path='build/py/mpz.o', has_indirect=False)
    abstract protected void mpz_set_from_str(int offset) throws Exception;

    // function: Function(address=134226910, size=106, name='mpz_set_from_bytes', path='build/py/mpz.o', has_indirect=False)
    abstract protected void mpz_set_from_bytes(int offset) throws Exception;

    // function: Function(address=134227016, size=70, name='mpz_cmp', path='build/py/mpz.o', has_indirect=False)
    abstract protected void mpz_cmp(int offset) throws Exception;

    // function: Function(address=134227086, size=22, name='mpz_abs_inpl', path='build/py/mpz.o', has_indirect=False)
    abstract protected void mpz_abs_inpl(int offset) throws Exception;

    // function: Function(address=134227108, size=32, name='mpz_neg_inpl', path='build/py/mpz.o', has_indirect=False)
    abstract protected void mpz_neg_inpl(int offset) throws Exception;

    // function: Function(address=134227140, size=110, name='mpz_not_inpl', path='build/py/mpz.o', has_indirect=False)
    abstract protected void mpz_not_inpl(int offset) throws Exception;

    // function: Function(address=134227252, size=208, name='mpz_shl_inpl', path='build/py/mpz.o', has_indirect=False)
    abstract protected void mpz_shl_inpl(int offset) throws Exception;

    // function: Function(address=134227460, size=194, name='mpz_shr_inpl', path='build/py/mpz.o', has_indirect=False)
    abstract protected void mpz_shr_inpl(int offset) throws Exception;

    // function: Function(address=134227654, size=116, name='mpz_add_inpl', path='build/py/mpz.o', has_indirect=False)
    abstract protected void mpz_add_inpl(int offset) throws Exception;

    // function: Function(address=134227770, size=130, name='mpz_sub_inpl', path='build/py/mpz.o', has_indirect=False)
    abstract protected void mpz_sub_inpl(int offset) throws Exception;

    // function: Function(address=134227900, size=310, name='mpz_and_inpl', path='build/py/mpz.o', has_indirect=False)
    abstract protected void mpz_and_inpl(int offset) throws Exception;

    // function: Function(address=134228210, size=296, name='mpz_or_inpl', path='build/py/mpz.o', has_indirect=False)
    abstract protected void mpz_or_inpl(int offset) throws Exception;

    // function: Function(address=134228506, size=218, name='mpz_xor_inpl', path='build/py/mpz.o', has_indirect=False)
    abstract protected void mpz_xor_inpl(int offset) throws Exception;

    // function: Function(address=134228724, size=262, name='mpz_mul_inpl', path='build/py/mpz.o', has_indirect=False)
    abstract protected void mpz_mul_inpl(int offset) throws Exception;

    // function: Function(address=134228986, size=132, name='mpz_pow_inpl', path='build/py/mpz.o', has_indirect=False)
    abstract protected void mpz_pow_inpl(int offset) throws Exception;

    // function: Function(address=134229120, size=688, name='mpz_divmod_inpl', path='build/py/mpz.o', has_indirect=False)
    abstract protected void mpz_divmod_inpl(int offset) throws Exception;

    // function: Function(address=134229808, size=182, name='mpz_pow3_inpl', path='build/py/mpz.o', has_indirect=False)
    abstract protected void mpz_pow3_inpl(int offset) throws Exception;

    // function: Function(address=134229990, size=40, name='mpz_hash', path='build/py/mpz.o', has_indirect=False)
    abstract protected void mpz_hash(int offset) throws Exception;

    // function: Function(address=134230032, size=56, name='mpz_as_int_checked', path='build/py/mpz.o', has_indirect=False)
    abstract protected void mpz_as_int_checked(int offset) throws Exception;

    // function: Function(address=134230088, size=142, name='mpz_as_bytes', path='build/py/mpz.o', has_indirect=False)
    abstract protected void mpz_as_bytes(int offset) throws Exception;

    // function: Function(address=134230230, size=60, name='mpz_as_float', path='build/py/mpz.o', has_indirect=False)
    abstract protected void mpz_as_float(int offset) throws Exception;

    // function: Function(address=134230290, size=288, name='mpz_as_str_inpl', path='build/py/mpz.o', has_indirect=False)
    abstract protected void mpz_as_str_inpl(int offset) throws Exception;

    // function: Function(address=134230578, size=22, name='mp_reader_mem_readbyte', path='build/py/reader.o', has_indirect=True)
    abstract protected void mp_reader_mem_readbyte(int offset) throws Exception;

    // function: Function(address=134230600, size=26, name='mp_reader_mem_close', path='build/py/reader.o', has_indirect=True)
    abstract protected void mp_reader_mem_close(int offset) throws Exception;

    // function: Function(address=134230628, size=48, name='mp_reader_new_mem', path='build/py/reader.o', has_indirect=False)
    abstract protected void mp_reader_new_mem(int offset) throws Exception;

    // function: Function(address=134230676, size=80, name='is_string_or_bytes', path='build/py/lexer.o', has_indirect=False)
    abstract protected void is_string_or_bytes(int offset) throws Exception;

    // function: Function(address=134230756, size=96, name='next_char', path='build/py/lexer.o', has_indirect=False)
    abstract protected void next_char(int offset) throws Exception;

    // function: Function(address=134230852, size=102, name='skip_whitespace', path='build/py/lexer.o', has_indirect=False)
    abstract protected void skip_whitespace(int offset) throws Exception;

    // function: Function(address=134230956, size=1420, name='mp_lexer_to_next', path='build/py/lexer.o', has_indirect=False)
    abstract protected void mp_lexer_to_next(int offset) throws Exception;

    // function: Function(address=134232376, size=122, name='mp_lexer_new', path='build/py/lexer.o', has_indirect=False)
    abstract protected void mp_lexer_new(int offset) throws Exception;

    // function: Function(address=134232498, size=26, name='mp_lexer_new_from_str_len', path='build/py/lexer.o', has_indirect=False)
    abstract protected void mp_lexer_new_from_str_len(int offset) throws Exception;

    // function: Function(address=134232524, size=32, name='mp_lexer_new_from_file', path='build/py/lexer.o', has_indirect=False)
    abstract protected void mp_lexer_new_from_file(int offset) throws Exception;

    // function: Function(address=134232556, size=40, name='mp_lexer_free', path='build/py/lexer.o', has_indirect=False)
    abstract protected void mp_lexer_free(int offset) throws Exception;

    // function: Function(address=134232596, size=14, name='pop_result', path='build/py/parse.o', has_indirect=False)
    abstract protected void pop_result(int offset) throws Exception;

    // function: Function(address=134232612, size=20, name='peek_result', path='build/py/parse.o', has_indirect=False)
    abstract protected void peek_result(int offset) throws Exception;

    // function: Function(address=134232632, size=112, name='parser_alloc', path='build/py/parse.o', has_indirect=False)
    abstract protected void parser_alloc(int offset) throws Exception;

    // function: Function(address=134232744, size=48, name='push_result_node', path='build/py/parse.o', has_indirect=False)
    abstract protected void push_result_node(int offset) throws Exception;

    // function: Function(address=134232792, size=70, name='push_rule', path='build/py/parse.o', has_indirect=False)
    abstract protected void push_rule(int offset) throws Exception;

    // function: Function(address=134232862, size=16, name='push_rule_from_arg', path='build/py/parse.o', has_indirect=False)
    abstract protected void push_rule_from_arg(int offset) throws Exception;

    // function: Function(address=134232880, size=224, name='push_result_token', path='build/py/parse.o', has_indirect=False)
    abstract protected void push_result_token(int offset) throws Exception;

    // function: Function(address=134233104, size=24, name='mp_parse_node_is_const_false', path='build/py/parse.o', has_indirect=False)
    abstract protected void mp_parse_node_is_const_false(int offset) throws Exception;

    // function: Function(address=134233128, size=26, name='mp_parse_node_is_const_true', path='build/py/parse.o', has_indirect=False)
    abstract protected void mp_parse_node_is_const_true(int offset) throws Exception;

    // function: Function(address=134233156, size=80, name='mp_parse_node_get_int_maybe', path='build/py/parse.o', has_indirect=False)
    abstract protected void mp_parse_node_get_int_maybe(int offset) throws Exception;

    // function: Function(address=134233236, size=972, name='push_result_rule', path='build/py/parse.o', has_indirect=False)
    abstract protected void push_result_rule(int offset) throws Exception;

    // function: Function(address=134234208, size=40, name='mp_parse_node_extract_list', path='build/py/parse.o', has_indirect=False)
    abstract protected void mp_parse_node_extract_list(int offset) throws Exception;

    // function: Function(address=134234248, size=872, name='mp_parse', path='build/py/parse.o', has_indirect=False)
    abstract protected void mp_parse(int offset) throws Exception;

    // function: Function(address=134235120, size=24, name='mp_parse_tree_clear', path='build/py/parse.o', has_indirect=False)
    abstract protected void mp_parse_tree_clear(int offset) throws Exception;

    // function: Function(address=134235144, size=76, name='scope_new', path='build/py/scope.o', has_indirect=False)
    abstract protected void scope_new(int offset) throws Exception;

    // function: Function(address=134235220, size=24, name='scope_free', path='build/py/scope.o', has_indirect=False)
    abstract protected void scope_free(int offset) throws Exception;

    // function: Function(address=134235244, size=32, name='scope_find', path='build/py/scope.o', has_indirect=False)
    abstract protected void scope_find(int offset) throws Exception;

    // function: Function(address=134235276, size=70, name='scope_find_or_add_id', path='build/py/scope.o', has_indirect=False)
    abstract protected void scope_find_or_add_id(int offset) throws Exception;

    // function: Function(address=134235346, size=18, name='scope_find_global', path='build/py/scope.o', has_indirect=False)
    abstract protected void scope_find_global(int offset) throws Exception;

    // function: Function(address=134235364, size=88, name='scope_find_local_and_close_over', path='build/py/scope.o', has_indirect=False)
    abstract protected void scope_find_local_and_close_over(int offset) throws Exception;

    // function: Function(address=134235452, size=20, name='compile_increase_except_level', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_increase_except_level(int offset) throws Exception;

    // function: Function(address=134235472, size=60, name='apply_to_single_or_list', path='build/py/compile.o', has_indirect=False)
    abstract protected void apply_to_single_or_list(int offset) throws Exception;

    // function: Function(address=134235532, size=20, name='compile_del_stmt', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_del_stmt(int offset) throws Exception;

    // function: Function(address=134235552, size=20, name='compile_import_name', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_import_name(int offset) throws Exception;

    // function: Function(address=134235572, size=44, name='scope_new_and_link', path='build/py/compile.o', has_indirect=False)
    abstract protected void scope_new_and_link(int offset) throws Exception;

    // function: Function(address=134235616, size=16, name='compile_trailer_period', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_trailer_period(int offset) throws Exception;

    // function: Function(address=134235632, size=12, name='compile_const_object', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_const_object(int offset) throws Exception;

    // function: Function(address=134235644, size=160, name='close_over_variables_etc', path='build/py/compile.o', has_indirect=False)
    abstract protected void close_over_variables_etc(int offset) throws Exception;

    // function: Function(address=134235804, size=92, name='compile_funcdef_lambdef', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_funcdef_lambdef(int offset) throws Exception;

    // function: Function(address=134235896, size=40, name='compile_lambdef', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_lambdef(int offset) throws Exception;

    // function: Function(address=134235936, size=42, name='compile_funcdef_helper', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_funcdef_helper(int offset) throws Exception;

    // function: Function(address=134235978, size=20, name='compile_error_set_line_isra_0', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_error_set_line_isra_0(int offset) throws Exception;

    // function: Function(address=134236000, size=40, name='compile_syntax_error', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_syntax_error(int offset) throws Exception;

    // function: Function(address=134236040, size=16, name='compile_star_expr', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_star_expr(int offset) throws Exception;

    // function: Function(address=134236056, size=64, name='compile_break_cont_stmt', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_break_cont_stmt(int offset) throws Exception;

    // function: Function(address=134236120, size=168, name='compile_scope_func_lambda_param_isra_5', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_scope_func_lambda_param_isra_5(int offset) throws Exception;

    // function: Function(address=134236288, size=12, name='compile_scope_lambda_param', path='build/py/compile.o', has_indirect=True)
    abstract protected void compile_scope_lambda_param(int offset) throws Exception;

    // function: Function(address=134236300, size=12, name='compile_scope_func_param', path='build/py/compile.o', has_indirect=True)
    abstract protected void compile_scope_func_param(int offset) throws Exception;

    // function: Function(address=134236312, size=30, name='compile_yield_from_isra_6', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_yield_from_isra_6(int offset) throws Exception;

    // function: Function(address=134236342, size=34, name='compile_await_object_method', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_await_object_method(int offset) throws Exception;

    // function: Function(address=134236376, size=36, name='compile_load_id', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_load_id(int offset) throws Exception;

    // function: Function(address=134236412, size=36, name='compile_store_id', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_store_id(int offset) throws Exception;

    // function: Function(address=134236448, size=22, name='compile_funcdef', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_funcdef(int offset) throws Exception;

    // function: Function(address=134236472, size=36, name='compile_delete_id', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_delete_id(int offset) throws Exception;

    // function: Function(address=134236508, size=200, name='compile_node', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_node(int offset) throws Exception;

    // function: Function(address=134236708, size=388, name='c_assign', path='build/py/compile.o', has_indirect=False)
    abstract protected void c_assign(int offset) throws Exception;

    // function: Function(address=134237096, size=212, name='c_assign_tuple', path='build/py/compile.o', has_indirect=False)
    abstract protected void c_assign_tuple(int offset) throws Exception;

    // function: Function(address=134237308, size=228, name='c_if_cond', path='build/py/compile.o', has_indirect=False)
    abstract protected void c_if_cond(int offset) throws Exception;

    // function: Function(address=134237536, size=178, name='compile_scope_comp_iter', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_scope_comp_iter(int offset) throws Exception;

    // function: Function(address=134237716, size=168, name='check_for_doc_string', path='build/py/compile.o', has_indirect=False)
    abstract protected void check_for_doc_string(int offset) throws Exception;

    // function: Function(address=134237884, size=448, name='compile_scope', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_scope(int offset) throws Exception;

    // function: Function(address=134238332, size=22, name='compile_dictorsetmaker_item', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_dictorsetmaker_item(int offset) throws Exception;

    // function: Function(address=134238354, size=132, name='compile_subscript', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_subscript(int offset) throws Exception;

    // function: Function(address=134238486, size=20, name='compile_trailer_bracket', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_trailer_bracket(int offset) throws Exception;

    // function: Function(address=134238506, size=66, name='text_c_tuple', path='build/py/compile.o', has_indirect=False)
    abstract protected void text_c_tuple(int offset) throws Exception;

    // function: Function(address=134238572, size=12, name='compile_generic_tuple', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_generic_tuple(int offset) throws Exception;

    // function: Function(address=134238584, size=140, name='compile_while_stmt', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_while_stmt(int offset) throws Exception;

    // function: Function(address=134238724, size=18, name='compile_yield_stmt', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_yield_stmt(int offset) throws Exception;

    // function: Function(address=134238744, size=260, name='c_del_stmt', path='build/py/compile.o', has_indirect=True)
    abstract protected void c_del_stmt(int offset) throws Exception;

    // function: Function(address=134239004, size=54, name='compile_generic_all_nodes', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_generic_all_nodes(int offset) throws Exception;

    // function: Function(address=134239058, size=18, name='compile_power', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_power(int offset) throws Exception;

    // function: Function(address=134239076, size=228, name='compile_if_stmt', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_if_stmt(int offset) throws Exception;

    // function: Function(address=134239304, size=74, name='compile_comprehension', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_comprehension(int offset) throws Exception;

    // function: Function(address=134239378, size=136, name='compile_atom_bracket', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_atom_bracket(int offset) throws Exception;

    // function: Function(address=134239516, size=344, name='compile_trailer_paren_helper', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_trailer_paren_helper(int offset) throws Exception;

    // function: Function(address=134239860, size=86, name='compile_classdef_helper', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_classdef_helper(int offset) throws Exception;

    // function: Function(address=134239946, size=22, name='compile_classdef', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_classdef(int offset) throws Exception;

    // function: Function(address=134239968, size=14, name='compile_trailer_paren', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_trailer_paren(int offset) throws Exception;

    // function: Function(address=134239984, size=264, name='compile_decorated', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_decorated(int offset) throws Exception;

    // function: Function(address=134240248, size=304, name='compile_atom_brace', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_atom_brace(int offset) throws Exception;

    // function: Function(address=134240552, size=164, name='compile_funcdef_lambdef_param', path='build/py/compile.o', has_indirect=True)
    abstract protected void compile_funcdef_lambdef_param(int offset) throws Exception;

    // function: Function(address=134240716, size=300, name='compile_atom_expr_normal', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_atom_expr_normal(int offset) throws Exception;

    // function: Function(address=134241016, size=76, name='compile_term', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_term(int offset) throws Exception;

    // function: Function(address=134241092, size=58, name='compile_binary_op', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_binary_op(int offset) throws Exception;

    // function: Function(address=134241152, size=440, name='compile_expr_stmt', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_expr_stmt(int offset) throws Exception;

    // function: Function(address=134241592, size=42, name='compile_factor_2', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_factor_2(int offset) throws Exception;

    // function: Function(address=134241634, size=20, name='compile_not_test_2', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_not_test_2(int offset) throws Exception;

    // function: Function(address=134241654, size=80, name='compile_or_and_test', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_or_and_test(int offset) throws Exception;

    // function: Function(address=134241736, size=200, name='compile_comparison', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_comparison(int offset) throws Exception;

    // function: Function(address=134241936, size=80, name='compile_test_if_expr', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_test_if_expr(int offset) throws Exception;

    // function: Function(address=134242016, size=672, name='compile_for_stmt', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_for_stmt(int offset) throws Exception;

    // function: Function(address=134242688, size=150, name='compile_with_stmt_helper', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_with_stmt_helper(int offset) throws Exception;

    // function: Function(address=134242838, size=32, name='compile_with_stmt', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_with_stmt(int offset) throws Exception;

    // function: Function(address=134242872, size=412, name='compile_try_except', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_try_except(int offset) throws Exception;

    // function: Function(address=134243284, size=128, name='compile_try_finally', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_try_finally(int offset) throws Exception;

    // function: Function(address=134243412, size=106, name='compile_try_stmt', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_try_stmt(int offset) throws Exception;

    // function: Function(address=134243518, size=498, name='compile_async_with_stmt_helper', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_async_with_stmt_helper(int offset) throws Exception;

    // function: Function(address=134244016, size=358, name='compile_async_stmt', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_async_stmt(int offset) throws Exception;

    // function: Function(address=134244376, size=92, name='compile_yield_expr', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_yield_expr(int offset) throws Exception;

    // function: Function(address=134244468, size=112, name='compile_return_stmt', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_return_stmt(int offset) throws Exception;

    // function: Function(address=134244580, size=62, name='compile_atom_paren', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_atom_paren(int offset) throws Exception;

    // function: Function(address=134244644, size=44, name='compile_atom_expr_await', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_atom_expr_await(int offset) throws Exception;

    // function: Function(address=134244688, size=92, name='compile_assert_stmt', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_assert_stmt(int offset) throws Exception;

    // function: Function(address=134244780, size=58, name='compile_raise_stmt', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_raise_stmt(int offset) throws Exception;

    // function: Function(address=134244840, size=192, name='compile_global_nonlocal_stmt', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_global_nonlocal_stmt(int offset) throws Exception;

    // function: Function(address=134245032, size=256, name='do_import_name_isra_19', path='build/py/compile.o', has_indirect=False)
    abstract protected void do_import_name_isra_19(int offset) throws Exception;

    // function: Function(address=134245288, size=284, name='compile_import_from', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_import_from(int offset) throws Exception;

    // function: Function(address=134245572, size=44, name='compile_dotted_as_name', path='build/py/compile.o', has_indirect=True)
    abstract protected void compile_dotted_as_name(int offset) throws Exception;

    // function: Function(address=134245616, size=602, name='mp_compile', path='build/py/compile.o', has_indirect=False)
    abstract protected void mp_compile(int offset) throws Exception;

    // function: Function(address=134246218, size=34, name='mp_emit_common_get_id_for_load', path='build/py/emitcommon.o', has_indirect=False)
    abstract protected void mp_emit_common_get_id_for_load(int offset) throws Exception;

    // function: Function(address=134246252, size=50, name='mp_emit_common_get_id_for_modification', path='build/py/emitcommon.o', has_indirect=False)
    abstract protected void mp_emit_common_get_id_for_modification(int offset) throws Exception;

    // function: Function(address=134246302, size=60, name='mp_emit_common_id_op', path='build/py/emitcommon.o', has_indirect=False)
    abstract protected void mp_emit_common_id_op(int offset) throws Exception;

    // function: Function(address=134246362, size=62, name='emit_write_uint', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void emit_write_uint(int offset) throws Exception;

    // function: Function(address=134246424, size=26, name='emit_get_cur_to_write_code_info', path='build/py/emitbc.o', has_indirect=True)
    abstract protected void emit_get_cur_to_write_code_info(int offset) throws Exception;

    // function: Function(address=134246450, size=14, name='emit_write_code_info_byte', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void emit_write_code_info_byte(int offset) throws Exception;

    // function: Function(address=134246464, size=30, name='emit_get_cur_to_write_bytecode', path='build/py/emitbc.o', has_indirect=True)
    abstract protected void emit_get_cur_to_write_bytecode(int offset) throws Exception;

    // function: Function(address=134246494, size=14, name='emit_write_bytecode_byte', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void emit_write_bytecode_byte(int offset) throws Exception;

    // function: Function(address=134246508, size=28, name='emit_write_bytecode_byte_uint', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void emit_write_bytecode_byte_uint(int offset) throws Exception;

    // function: Function(address=134246536, size=42, name='emit_write_bytecode_byte_raw_code', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void emit_write_bytecode_byte_raw_code(int offset) throws Exception;

    // function: Function(address=134246578, size=12, name='mp_emit_bc_delete_local', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_delete_local(int offset) throws Exception;

    // function: Function(address=134246590, size=22, name='emit_write_bytecode_byte_qstr', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void emit_write_bytecode_byte_qstr(int offset) throws Exception;

    // function: Function(address=134246612, size=42, name='emit_write_bytecode_byte_unsigned_label', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void emit_write_bytecode_byte_unsigned_label(int offset) throws Exception;

    // function: Function(address=134246656, size=48, name='emit_write_bytecode_byte_signed_label', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void emit_write_bytecode_byte_signed_label(int offset) throws Exception;

    // function: Function(address=134246704, size=38, name='emit_write_bytecode_byte_obj_constprop_8', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void emit_write_bytecode_byte_obj_constprop_8(int offset) throws Exception;

    // function: Function(address=134246742, size=10, name='emit_bc_new', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void emit_bc_new(int offset) throws Exception;

    // function: Function(address=134246752, size=16, name='emit_bc_set_max_num_labels', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void emit_bc_set_max_num_labels(int offset) throws Exception;

    // function: Function(address=134246768, size=24, name='emit_bc_free', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void emit_bc_free(int offset) throws Exception;

    // function: Function(address=134246792, size=288, name='mp_emit_bc_start_pass', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_start_pass(int offset) throws Exception;

    // function: Function(address=134247080, size=88, name='mp_emit_bc_end_pass', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_end_pass(int offset) throws Exception;

    // function: Function(address=134247168, size=10, name='mp_emit_bc_last_emit_was_return_value', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_last_emit_was_return_value(int offset) throws Exception;

    // function: Function(address=134247178, size=28, name='mp_emit_bc_adjust_stack_size', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_adjust_stack_size(int offset) throws Exception;

    // function: Function(address=134247206, size=50, name='mp_emit_bc_load_local', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_load_local(int offset) throws Exception;

    // function: Function(address=134247256, size=48, name='mp_emit_bc_load_global', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_load_global(int offset) throws Exception;

    // function: Function(address=134247304, size=52, name='mp_emit_bc_store_local', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_store_local(int offset) throws Exception;

    // function: Function(address=134247356, size=32, name='mp_emit_bc_store_global', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_store_global(int offset) throws Exception;

    // function: Function(address=134247388, size=28, name='mp_emit_bc_delete_global', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_delete_global(int offset) throws Exception;

    // function: Function(address=134247416, size=60, name='emit_bc_call_function_method_helper', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void emit_bc_call_function_method_helper(int offset) throws Exception;

    // function: Function(address=134247476, size=152, name='mp_emit_bc_set_source_line', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_set_source_line(int offset) throws Exception;

    // function: Function(address=134247628, size=32, name='mp_emit_bc_label_assign', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_label_assign(int offset) throws Exception;

    // function: Function(address=134247660, size=56, name='mp_emit_bc_import', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_import(int offset) throws Exception;

    // function: Function(address=134247716, size=56, name='mp_emit_bc_load_const_tok', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_load_const_tok(int offset) throws Exception;

    // function: Function(address=134247772, size=144, name='mp_emit_bc_load_const_small_int', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_load_const_small_int(int offset) throws Exception;

    // function: Function(address=134247916, size=24, name='mp_emit_bc_load_const_str', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_load_const_str(int offset) throws Exception;

    // function: Function(address=134247940, size=22, name='mp_emit_bc_load_const_obj', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_load_const_obj(int offset) throws Exception;

    // function: Function(address=134247962, size=20, name='mp_emit_bc_load_null', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_load_null(int offset) throws Exception;

    // function: Function(address=134247982, size=36, name='mp_emit_bc_load_method', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_load_method(int offset) throws Exception;

    // function: Function(address=134248018, size=20, name='mp_emit_bc_load_build_class', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_load_build_class(int offset) throws Exception;

    // function: Function(address=134248038, size=20, name='mp_emit_bc_dup_top', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_dup_top(int offset) throws Exception;

    // function: Function(address=134248058, size=20, name='mp_emit_bc_dup_top_two', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_dup_top_two(int offset) throws Exception;

    // function: Function(address=134248078, size=22, name='mp_emit_bc_pop_top', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_pop_top(int offset) throws Exception;

    // function: Function(address=134248100, size=20, name='mp_emit_bc_rot_two', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_rot_two(int offset) throws Exception;

    // function: Function(address=134248120, size=80, name='mp_emit_bc_attr', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_attr(int offset) throws Exception;

    // function: Function(address=134248200, size=20, name='mp_emit_bc_rot_three', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_rot_three(int offset) throws Exception;

    // function: Function(address=134248220, size=52, name='mp_emit_bc_subscr', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_subscr(int offset) throws Exception;

    // function: Function(address=134248272, size=24, name='mp_emit_bc_jump', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_jump(int offset) throws Exception;

    // function: Function(address=134248296, size=34, name='mp_emit_bc_pop_jump_if', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_pop_jump_if(int offset) throws Exception;

    // function: Function(address=134248330, size=34, name='mp_emit_bc_jump_if_or_pop', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_jump_if_or_pop(int offset) throws Exception;

    // function: Function(address=134248364, size=100, name='mp_emit_bc_unwind_jump', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_unwind_jump(int offset) throws Exception;

    // function: Function(address=134248464, size=36, name='mp_emit_bc_setup_block', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_setup_block(int offset) throws Exception;

    // function: Function(address=134248500, size=22, name='mp_emit_bc_end_finally', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_end_finally(int offset) throws Exception;

    // function: Function(address=134248522, size=38, name='mp_emit_bc_get_iter', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_get_iter(int offset) throws Exception;

    // function: Function(address=134248560, size=24, name='mp_emit_bc_for_iter', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_for_iter(int offset) throws Exception;

    // function: Function(address=134248584, size=12, name='mp_emit_bc_for_iter_end', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_for_iter_end(int offset) throws Exception;

    // function: Function(address=134248596, size=20, name='mp_emit_bc_pop_block', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_pop_block(int offset) throws Exception;

    // function: Function(address=134248616, size=54, name='mp_emit_bc_with_cleanup', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_with_cleanup(int offset) throws Exception;

    // function: Function(address=134248670, size=20, name='mp_emit_bc_pop_except', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_pop_except(int offset) throws Exception;

    // function: Function(address=134248690, size=26, name='mp_emit_bc_unary_op', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_unary_op(int offset) throws Exception;

    // function: Function(address=134248716, size=68, name='mp_emit_bc_binary_op', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_binary_op(int offset) throws Exception;

    // function: Function(address=134248784, size=40, name='mp_emit_bc_build', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_build(int offset) throws Exception;

    // function: Function(address=134248824, size=22, name='mp_emit_bc_store_map', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_store_map(int offset) throws Exception;

    // function: Function(address=134248846, size=52, name='mp_emit_bc_store_comp', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_store_comp(int offset) throws Exception;

    // function: Function(address=134248898, size=24, name='mp_emit_bc_unpack_sequence', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_unpack_sequence(int offset) throws Exception;

    // function: Function(address=134248922, size=28, name='mp_emit_bc_unpack_ex', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_unpack_ex(int offset) throws Exception;

    // function: Function(address=134248950, size=42, name='mp_emit_bc_make_function', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_make_function(int offset) throws Exception;

    // function: Function(address=134248992, size=54, name='mp_emit_bc_make_closure', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_make_closure(int offset) throws Exception;

    // function: Function(address=134249046, size=18, name='mp_emit_bc_call_function', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_call_function(int offset) throws Exception;

    // function: Function(address=134249064, size=20, name='mp_emit_bc_call_method', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_call_method(int offset) throws Exception;

    // function: Function(address=134249084, size=26, name='mp_emit_bc_return_value', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_return_value(int offset) throws Exception;

    // function: Function(address=134249110, size=28, name='mp_emit_bc_raise_varargs', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_raise_varargs(int offset) throws Exception;

    // function: Function(address=134249138, size=34, name='mp_emit_bc_yield', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_yield(int offset) throws Exception;

    // function: Function(address=134249172, size=10, name='mp_emit_bc_start_except_handler', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_start_except_handler(int offset) throws Exception;

    // function: Function(address=134249182, size=12, name='mp_emit_bc_end_except_handler', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_end_except_handler(int offset) throws Exception;

    // function: Function(address=134249196, size=1208, name='mp_format_float', path='build/py/formatfloat.o', has_indirect=False)
    abstract protected void mp_format_float(int offset) throws Exception;

    // function: Function(address=134250404, size=122, name='mp_parse_num_base', path='build/py/parsenumbase.o', has_indirect=False)
    abstract protected void mp_parse_num_base(int offset) throws Exception;

    // function: Function(address=134250528, size=32, name='unlikely_raise_exc', path='build/py/parsenum.o', has_indirect=False)
    abstract protected void unlikely_raise_exc(int offset) throws Exception;

    // function: Function(address=134250560, size=296, name='mp_parse_num_integer', path='build/py/parsenum.o', has_indirect=False)
    abstract protected void mp_parse_num_integer(int offset) throws Exception;

    // function: Function(address=134250856, size=632, name='mp_parse_num_decimal', path='build/py/parsenum.o', has_indirect=False)
    abstract protected void mp_parse_num_decimal(int offset) throws Exception;

    // function: Function(address=134251488, size=24, name='mp_emit_glue_new_raw_code', path='build/py/emitglue.o', has_indirect=False)
    abstract protected void mp_emit_glue_new_raw_code(int offset) throws Exception;

    // function: Function(address=134251512, size=44, name='mp_emit_glue_assign_bytecode', path='build/py/emitglue.o', has_indirect=False)
    abstract protected void mp_emit_glue_assign_bytecode(int offset) throws Exception;

    // function: Function(address=134251556, size=32, name='mp_make_function_from_raw_code', path='build/py/emitglue.o', has_indirect=False)
    abstract protected void mp_make_function_from_raw_code(int offset) throws Exception;

    // function: Function(address=134251588, size=42, name='mp_make_closure_from_raw_code', path='build/py/emitglue.o', has_indirect=False)
    abstract protected void mp_make_closure_from_raw_code(int offset) throws Exception;

    // function: Function(address=134251630, size=26, name='read_bytes', path='build/py/persistentcode.o', has_indirect=False)
    abstract protected void read_bytes(int offset) throws Exception;

    // function: Function(address=134251656, size=30, name='read_uint', path='build/py/persistentcode.o', has_indirect=False)
    abstract protected void read_uint(int offset) throws Exception;

    // function: Function(address=134251686, size=48, name='load_qstr', path='build/py/persistentcode.o', has_indirect=False)
    abstract protected void load_qstr(int offset) throws Exception;

    // function: Function(address=134251736, size=416, name='load_raw_code', path='build/py/persistentcode.o', has_indirect=False)
    abstract protected void load_raw_code(int offset) throws Exception;

    // function: Function(address=134252152, size=68, name='mp_raw_code_load', path='build/py/persistentcode.o', has_indirect=False)
    abstract protected void mp_raw_code_load(int offset) throws Exception;

    // function: Function(address=134252220, size=20, name='mp_raw_code_load_file', path='build/py/persistentcode.o', has_indirect=False)
    abstract protected void mp_raw_code_load_file(int offset) throws Exception;

    // function: Function(address=134252240, size=120, name='mp_init', path='build/py/runtime.o', has_indirect=False)
    abstract protected void mp_init(int offset) throws Exception;

    // function: Function(address=134252360, size=2, name='mp_deinit', path='build/py/runtime.o', has_indirect=False)
    abstract protected void mp_deinit(int offset) throws Exception;

    // function: Function(address=134252364, size=104, name='mp_load_global', path='build/py/runtime.o', has_indirect=False)
    abstract protected void mp_load_global(int offset) throws Exception;

    // function: Function(address=134252468, size=48, name='mp_load_name', path='build/py/runtime.o', has_indirect=False)
    abstract protected void mp_load_name(int offset) throws Exception;

    // function: Function(address=134252516, size=44, name='mp_load_build_class', path='build/py/runtime.o', has_indirect=False)
    abstract protected void mp_load_build_class(int offset) throws Exception;

    // function: Function(address=134252560, size=24, name='mp_store_name', path='build/py/runtime.o', has_indirect=False)
    abstract protected void mp_store_name(int offset) throws Exception;

    // function: Function(address=134252584, size=24, name='mp_delete_name', path='build/py/runtime.o', has_indirect=False)
    abstract protected void mp_delete_name(int offset) throws Exception;

    // function: Function(address=134252608, size=24, name='mp_store_global', path='build/py/runtime.o', has_indirect=False)
    abstract protected void mp_store_global(int offset) throws Exception;

    // function: Function(address=134252632, size=24, name='mp_delete_global', path='build/py/runtime.o', has_indirect=False)
    abstract protected void mp_delete_global(int offset) throws Exception;

    // function: Function(address=134252656, size=264, name='mp_unary_op', path='build/py/runtime.o', has_indirect=False)
    abstract protected void mp_unary_op(int offset) throws Exception;

    // function: Function(address=134252920, size=60, name='mp_call_function_n_kw', path='build/py/runtime.o', has_indirect=False)
    abstract protected void mp_call_function_n_kw(int offset) throws Exception;

    // function: Function(address=134252980, size=14, name='mp_call_function_0', path='build/py/runtime.o', has_indirect=False)
    abstract protected void mp_call_function_0(int offset) throws Exception;

    // function: Function(address=134252994, size=16, name='mp_call_function_1', path='build/py/runtime.o', has_indirect=False)
    abstract protected void mp_call_function_1(int offset) throws Exception;

    // function: Function(address=134253012, size=64, name='checked_fun_call', path='build/py/runtime.o', has_indirect=False)
    abstract protected void checked_fun_call(int offset) throws Exception;

    // function: Function(address=134253076, size=30, name='mp_call_method_n_kw', path='build/py/runtime.o', has_indirect=False)
    abstract protected void mp_call_method_n_kw(int offset) throws Exception;

    // function: Function(address=134253108, size=172, name='mp_convert_member_lookup', path='build/py/runtime.o', has_indirect=False)
    abstract protected void mp_convert_member_lookup(int offset) throws Exception;

    // function: Function(address=134253280, size=104, name='mp_load_method_maybe', path='build/py/runtime.o', has_indirect=True)
    abstract protected void mp_load_method_maybe(int offset) throws Exception;

    // function: Function(address=134253384, size=80, name='mp_load_method', path='build/py/runtime.o', has_indirect=True)
    abstract protected void mp_load_method(int offset) throws Exception;

    // function: Function(address=134253464, size=24, name='mp_load_attr', path='build/py/runtime.o', has_indirect=False)
    abstract protected void mp_load_attr(int offset) throws Exception;

    // function: Function(address=134253488, size=68, name='mp_load_method_protected', path='build/py/runtime.o', has_indirect=False)
    abstract protected void mp_load_method_protected(int offset) throws Exception;

    // function: Function(address=134253556, size=72, name='mp_store_attr', path='build/py/runtime.o', has_indirect=False)
    abstract protected void mp_store_attr(int offset) throws Exception;

    // function: Function(address=134253628, size=112, name='mp_getiter', path='build/py/runtime.o', has_indirect=False)
    abstract protected void mp_getiter(int offset) throws Exception;

    // function: Function(address=134253740, size=76, name='mp_iternext_allow_raise', path='build/py/runtime.o', has_indirect=False)
    abstract protected void mp_iternext_allow_raise(int offset) throws Exception;

    // function: Function(address=134253816, size=128, name='mp_iternext', path='build/py/runtime.o', has_indirect=False)
    abstract protected void mp_iternext(int offset) throws Exception;

    // function: Function(address=134253944, size=628, name='mp_call_prepare_args_n_kw_var', path='build/py/runtime.o', has_indirect=False)
    abstract protected void mp_call_prepare_args_n_kw_var(int offset) throws Exception;

    // function: Function(address=134254572, size=36, name='mp_call_method_n_kw_var', path='build/py/runtime.o', has_indirect=False)
    abstract protected void mp_call_method_n_kw_var(int offset) throws Exception;

    // function: Function(address=134254608, size=168, name='mp_unpack_sequence', path='build/py/runtime.o', has_indirect=False)
    abstract protected void mp_unpack_sequence(int offset) throws Exception;

    // function: Function(address=134254776, size=264, name='mp_unpack_ex', path='build/py/runtime.o', has_indirect=False)
    abstract protected void mp_unpack_ex(int offset) throws Exception;

    // function: Function(address=134255040, size=60, name='mp_make_raise_obj', path='build/py/runtime.o', has_indirect=False)
    abstract protected void mp_make_raise_obj(int offset) throws Exception;

    // function: Function(address=134255100, size=244, name='mp_resume', path='build/py/runtime.o', has_indirect=False)
    abstract protected void mp_resume(int offset) throws Exception;

    // function: Function(address=134255344, size=36, name='mp_import_name', path='build/py/runtime.o', has_indirect=False)
    abstract protected void mp_import_name(int offset) throws Exception;

    // function: Function(address=134255380, size=204, name='mp_import_from', path='build/py/runtime.o', has_indirect=False)
    abstract protected void mp_import_from(int offset) throws Exception;

    // function: Function(address=134255584, size=58, name='mp_import_all', path='build/py/runtime.o', has_indirect=False)
    abstract protected void mp_import_all(int offset) throws Exception;

    // function: Function(address=134255644, size=108, name='mp_parse_compile_execute', path='build/py/runtime.o', has_indirect=False)
    abstract protected void mp_parse_compile_execute(int offset) throws Exception;

    // function: Function(address=134255752, size=20, name='mp_raise_msg', path='build/py/runtime.o', has_indirect=False)
    abstract protected void mp_raise_msg(int offset) throws Exception;

    // function: Function(address=134255772, size=44, name='m_malloc_fail', path='build/py/runtime.o', has_indirect=False)
    abstract protected void m_malloc_fail(int offset) throws Exception;

    // function: Function(address=134255816, size=16, name='mp_raise_ValueError', path='build/py/runtime.o', has_indirect=False)
    abstract protected void mp_raise_ValueError(int offset) throws Exception;

    // function: Function(address=134255832, size=944, name='mp_binary_op', path='build/py/runtime.o', has_indirect=False)
    abstract protected void mp_binary_op(int offset) throws Exception;

    // function: Function(address=134256776, size=16, name='mp_raise_TypeError', path='build/py/runtime.o', has_indirect=False)
    abstract protected void mp_raise_TypeError(int offset) throws Exception;

    // function: Function(address=134256792, size=24, name='mp_raise_OSError', path='build/py/runtime.o', has_indirect=False)
    abstract protected void mp_raise_OSError(int offset) throws Exception;

    // function: Function(address=134256816, size=16, name='mp_raise_NotImplementedError', path='build/py/runtime.o', has_indirect=False)
    abstract protected void mp_raise_NotImplementedError(int offset) throws Exception;

    // function: Function(address=134256832, size=20, name='mp_raise_recursion_depth', path='build/py/runtime.o', has_indirect=False)
    abstract protected void mp_raise_recursion_depth(int offset) throws Exception;

    // function: Function(address=134256852, size=56, name='mp_call_function_1_protected', path='build/py/runtime_utils.o', has_indirect=False)
    abstract protected void mp_call_function_1_protected(int offset) throws Exception;

    // function: Function(address=134256908, size=36, name='mp_sched_lock', path='build/py/scheduler.o', has_indirect=False)
    abstract protected void mp_sched_lock(int offset) throws Exception;

    // function: Function(address=134256944, size=56, name='mp_sched_unlock', path='build/py/scheduler.o', has_indirect=False)
    abstract protected void mp_sched_unlock(int offset) throws Exception;

    // function: Function(address=134257000, size=52, name='mp_handle_pending_tail', path='build/py/scheduler.o', has_indirect=False)
    abstract protected void mp_handle_pending_tail(int offset) throws Exception;

    // function: Function(address=134257052, size=56, name='mp_handle_pending', path='build/py/scheduler.o', has_indirect=False)
    abstract protected void mp_handle_pending(int offset) throws Exception;

    // function: Function(address=134257108, size=60, name='mp_sched_schedule', path='build/py/scheduler.o', has_indirect=False)
    abstract protected void mp_sched_schedule(int offset) throws Exception;

    // function: Function(address=134257168, size=12, name='mp_stack_set_top', path='build/py/stackctrl.o', has_indirect=False)
    abstract protected void mp_stack_set_top(int offset) throws Exception;

    // function: Function(address=134257180, size=20, name='mp_stack_usage', path='build/py/stackctrl.o', has_indirect=False)
    abstract protected void mp_stack_usage(int offset) throws Exception;

    // function: Function(address=134257200, size=12, name='mp_stack_set_limit', path='build/py/stackctrl.o', has_indirect=False)
    abstract protected void mp_stack_set_limit(int offset) throws Exception;

    // function: Function(address=134257212, size=28, name='mp_stack_check', path='build/py/stackctrl.o', has_indirect=False)
    abstract protected void mp_stack_check(int offset) throws Exception;

    // function: Function(address=134257240, size=96, name='mp_arg_check_num', path='build/py/argcheck.o', has_indirect=False)
    abstract protected void mp_arg_check_num(int offset) throws Exception;

    // function: Function(address=134257336, size=200, name='mp_arg_parse_all', path='build/py/argcheck.o', has_indirect=False)
    abstract protected void mp_arg_parse_all(int offset) throws Exception;

    // function: Function(address=134257536, size=44, name='mp_arg_parse_all_kw_array', path='build/py/argcheck.o', has_indirect=False)
    abstract protected void mp_arg_parse_all_kw_array(int offset) throws Exception;

    // function: Function(address=134257580, size=12, name='mp_arg_error_unimpl_kw', path='build/py/argcheck.o', has_indirect=False)
    abstract protected void mp_arg_error_unimpl_kw(int offset) throws Exception;

    // function: Function(address=134257592, size=60, name='mp_warning', path='build/py/warning.o', has_indirect=False)
    abstract protected void mp_warning(int offset) throws Exception;

    // function: Function(address=134257652, size=28, name='mp_map_init', path='build/py/map.o', has_indirect=False)
    abstract protected void mp_map_init(int offset) throws Exception;

    // function: Function(address=134257680, size=26, name='mp_map_init_fixed_table', path='build/py/map.o', has_indirect=False)
    abstract protected void mp_map_init_fixed_table(int offset) throws Exception;

    // function: Function(address=134257706, size=34, name='mp_map_deinit', path='build/py/map.o', has_indirect=False)
    abstract protected void mp_map_deinit(int offset) throws Exception;

    // function: Function(address=134257740, size=46, name='mp_map_clear', path='build/py/map.o', has_indirect=False)
    abstract protected void mp_map_clear(int offset) throws Exception;

    // function: Function(address=134257788, size=512, name='mp_map_lookup', path='build/py/map.o', has_indirect=False)
    abstract protected void mp_map_lookup(int offset) throws Exception;

    // function: Function(address=134258300, size=116, name='mp_map_rehash', path='build/py/map.o', has_indirect=False)
    abstract protected void mp_map_rehash(int offset) throws Exception;

    // function: Function(address=134258416, size=20, name='mp_set_init', path='build/py/map.o', has_indirect=False)
    abstract protected void mp_set_init(int offset) throws Exception;

    // function: Function(address=134258436, size=222, name='mp_set_lookup', path='build/py/map.o', has_indirect=False)
    abstract protected void mp_set_lookup(int offset) throws Exception;

    // function: Function(address=134258660, size=100, name='mp_set_rehash', path='build/py/map.o', has_indirect=False)
    abstract protected void mp_set_rehash(int offset) throws Exception;

    // function: Function(address=134258760, size=62, name='mp_set_remove_first', path='build/py/map.o', has_indirect=False)
    abstract protected void mp_set_remove_first(int offset) throws Exception;

    // function: Function(address=134258822, size=24, name='mp_set_clear', path='build/py/map.o', has_indirect=False)
    abstract protected void mp_set_clear(int offset) throws Exception;

    // function: Function(address=134258846, size=2, name='mp_identity', path='build/py/obj.o', has_indirect=False)
    abstract protected void mp_identity(int offset) throws Exception;

    // function: Function(address=134258848, size=32, name='mp_obj_get_type', path='build/py/obj.o', has_indirect=False)
    abstract protected void mp_obj_get_type(int offset) throws Exception;

    // function: Function(address=134258880, size=14, name='mp_obj_get_type_str', path='build/py/obj.o', has_indirect=False)
    abstract protected void mp_obj_get_type_str(int offset) throws Exception;

    // function: Function(address=134258896, size=52, name='mp_obj_print_helper', path='build/py/obj.o', has_indirect=False)
    abstract protected void mp_obj_print_helper(int offset) throws Exception;

    // function: Function(address=134258948, size=20, name='mp_obj_print', path='build/py/obj.o', has_indirect=False)
    abstract protected void mp_obj_print(int offset) throws Exception;

    // function: Function(address=134258968, size=144, name='mp_obj_print_exception', path='build/py/obj.o', has_indirect=False)
    abstract protected void mp_obj_print_exception(int offset) throws Exception;

    // function: Function(address=134259112, size=36, name='mp_obj_is_callable', path='build/py/obj.o', has_indirect=False)
    abstract protected void mp_obj_is_callable(int offset) throws Exception;

    // function: Function(address=134259148, size=232, name='mp_obj_equal', path='build/py/obj.o', has_indirect=False)
    abstract protected void mp_obj_equal(int offset) throws Exception;

    // function: Function(address=134259380, size=88, name='mp_obj_get_int', path='build/py/obj.o', has_indirect=False)
    abstract protected void mp_obj_get_int(int offset) throws Exception;

    // function: Function(address=134259468, size=36, name='mp_obj_get_int_truncated', path='build/py/obj.o', has_indirect=False)
    abstract protected void mp_obj_get_int_truncated(int offset) throws Exception;

    // function: Function(address=134259504, size=76, name='mp_obj_get_int_maybe', path='build/py/obj.o', has_indirect=False)
    abstract protected void mp_obj_get_int_maybe(int offset) throws Exception;

    // function: Function(address=134259580, size=96, name='mp_obj_get_float_maybe', path='build/py/obj.o', has_indirect=False)
    abstract protected void mp_obj_get_float_maybe(int offset) throws Exception;

    // function: Function(address=134259676, size=48, name='mp_obj_get_float', path='build/py/obj.o', has_indirect=False)
    abstract protected void mp_obj_get_float(int offset) throws Exception;

    // function: Function(address=134259724, size=140, name='mp_obj_get_complex', path='build/py/obj.o', has_indirect=False)
    abstract protected void mp_obj_get_complex(int offset) throws Exception;

    // function: Function(address=134259864, size=68, name='mp_obj_get_array', path='build/py/obj.o', has_indirect=False)
    abstract protected void mp_obj_get_array(int offset) throws Exception;

    // function: Function(address=134259932, size=40, name='mp_obj_get_array_fixed_n', path='build/py/obj.o', has_indirect=False)
    abstract protected void mp_obj_get_array_fixed_n(int offset) throws Exception;

    // function: Function(address=134259972, size=132, name='mp_get_index', path='build/py/obj.o', has_indirect=False)
    abstract protected void mp_get_index(int offset) throws Exception;

    // function: Function(address=134260104, size=30, name='mp_obj_id', path='build/py/obj.o', has_indirect=False)
    abstract protected void mp_obj_id(int offset) throws Exception;

    // function: Function(address=134260136, size=52, name='mp_obj_len_maybe', path='build/py/obj.o', has_indirect=False)
    abstract protected void mp_obj_len_maybe(int offset) throws Exception;

    // function: Function(address=134260188, size=100, name='mp_obj_is_true', path='build/py/obj.o', has_indirect=False)
    abstract protected void mp_obj_is_true(int offset) throws Exception;

    // function: Function(address=134260288, size=44, name='mp_obj_len', path='build/py/obj.o', has_indirect=False)
    abstract protected void mp_obj_len(int offset) throws Exception;

    // function: Function(address=134260332, size=100, name='mp_obj_subscr', path='build/py/obj.o', has_indirect=False)
    abstract protected void mp_obj_subscr(int offset) throws Exception;

    // function: Function(address=134260432, size=2, name='mp_identity_getiter', path='build/py/obj.o', has_indirect=True)
    abstract protected void mp_identity_getiter(int offset) throws Exception;

    // function: Function(address=134260434, size=34, name='mp_get_buffer', path='build/py/obj.o', has_indirect=False)
    abstract protected void mp_get_buffer(int offset) throws Exception;

    // function: Function(address=134260468, size=24, name='mp_get_buffer_raise', path='build/py/obj.o', has_indirect=False)
    abstract protected void mp_get_buffer_raise(int offset) throws Exception;

    // function: Function(address=134260492, size=16, name='mp_generic_unary_op', path='build/py/obj.o', has_indirect=False)
    abstract protected void mp_generic_unary_op(int offset) throws Exception;

    // function: Function(address=134260508, size=44, name='array_unary_op', path='build/py/objarray.o', has_indirect=False)
    abstract protected void array_unary_op(int offset) throws Exception;

    // function: Function(address=134260552, size=40, name='array_iterator_new', path='build/py/objarray.o', has_indirect=False)
    abstract protected void array_iterator_new(int offset) throws Exception;

    // function: Function(address=134260592, size=84, name='array_get_buffer', path='build/py/objarray.o', has_indirect=False)
    abstract protected void array_get_buffer(int offset) throws Exception;

    // function: Function(address=134260676, size=68, name='array_new', path='build/py/objarray.o', has_indirect=False)
    abstract protected void array_new(int offset) throws Exception;

    // function: Function(address=134260744, size=116, name='array_extend', path='build/py/objarray.o', has_indirect=False)
    abstract protected void array_extend(int offset) throws Exception;

    // function: Function(address=134260860, size=112, name='array_append', path='build/py/objarray.o', has_indirect=False)
    abstract protected void array_append(int offset) throws Exception;

    // function: Function(address=134260972, size=38, name='array_it_iternext', path='build/py/objarray.o', has_indirect=False)
    abstract protected void array_it_iternext(int offset) throws Exception;

    // function: Function(address=134261012, size=592, name='array_subscr', path='build/py/objarray.o', has_indirect=True)
    abstract protected void array_subscr(int offset) throws Exception;

    // function: Function(address=134261604, size=312, name='array_binary_op', path='build/py/objarray.o', has_indirect=False)
    abstract protected void array_binary_op(int offset) throws Exception;

    // function: Function(address=134261916, size=180, name='array_construct', path='build/py/objarray.o', has_indirect=False)
    abstract protected void array_construct(int offset) throws Exception;

    // function: Function(address=134262096, size=50, name='array_make_new', path='build/py/objarray.o', has_indirect=False)
    abstract protected void array_make_new(int offset) throws Exception;

    // function: Function(address=134262148, size=140, name='array_print', path='build/py/objarray.o', has_indirect=False)
    abstract protected void array_print(int offset) throws Exception;

    // function: Function(address=134262288, size=100, name='bytearray_make_new', path='build/py/objarray.o', has_indirect=False)
    abstract protected void bytearray_make_new(int offset) throws Exception;

    // function: Function(address=134262388, size=36, name='mp_obj_new_memoryview', path='build/py/objarray.o', has_indirect=False)
    abstract protected void mp_obj_new_memoryview(int offset) throws Exception;

    // function: Function(address=134262424, size=102, name='memoryview_make_new', path='build/py/objarray.o', has_indirect=False)
    abstract protected void memoryview_make_new(int offset) throws Exception;

    // function: Function(address=134262528, size=32, name='mp_obj_new_bytearray_by_ref', path='build/py/objarray.o', has_indirect=False)
    abstract protected void mp_obj_new_bytearray_by_ref(int offset) throws Exception;

    // function: Function(address=134262560, size=42, name='mp_obj_attrtuple_attr', path='build/py/objattrtuple.o', has_indirect=False)
    abstract protected void mp_obj_attrtuple_attr(int offset) throws Exception;

    // function: Function(address=134262604, size=92, name='mp_obj_attrtuple_print_helper', path='build/py/objattrtuple.o', has_indirect=False)
    abstract protected void mp_obj_attrtuple_print_helper(int offset) throws Exception;

    // function: Function(address=134262696, size=18, name='mp_obj_attrtuple_print', path='build/py/objattrtuple.o', has_indirect=False)
    abstract protected void mp_obj_attrtuple_print(int offset) throws Exception;

    // function: Function(address=134262714, size=16, name='bool_binary_op', path='build/py/objbool.o', has_indirect=False)
    abstract protected void bool_binary_op(int offset) throws Exception;

    // function: Function(address=134262730, size=26, name='bool_unary_op', path='build/py/objbool.o', has_indirect=False)
    abstract protected void bool_unary_op(int offset) throws Exception;

    // function: Function(address=134262756, size=52, name='bool_make_new', path='build/py/objbool.o', has_indirect=False)
    abstract protected void bool_make_new(int offset) throws Exception;

    // function: Function(address=134262808, size=48, name='bool_print', path='build/py/objbool.o', has_indirect=False)
    abstract protected void bool_print(int offset) throws Exception;

    // function: Function(address=134262856, size=64, name='bound_meth_print', path='build/py/objboundmeth.o', has_indirect=False)
    abstract protected void bound_meth_print(int offset) throws Exception;

    // function: Function(address=134262920, size=30, name='bound_meth_attr', path='build/py/objboundmeth.o', has_indirect=False)
    abstract protected void bound_meth_attr(int offset) throws Exception;

    // function: Function(address=134262952, size=60, name='mp_call_method_self_n_kw', path='build/py/objboundmeth.o', has_indirect=False)
    abstract protected void mp_call_method_self_n_kw(int offset) throws Exception;

    // function: Function(address=134263012, size=18, name='bound_meth_call', path='build/py/objboundmeth.o', has_indirect=False)
    abstract protected void bound_meth_call(int offset) throws Exception;

    // function: Function(address=134263032, size=28, name='mp_obj_new_bound_meth', path='build/py/objboundmeth.o', has_indirect=False)
    abstract protected void mp_obj_new_bound_meth(int offset) throws Exception;

    // function: Function(address=134263060, size=60, name='cell_print', path='build/py/objcell.o', has_indirect=False)
    abstract protected void cell_print(int offset) throws Exception;

    // function: Function(address=134263120, size=4, name='mp_obj_cell_get', path='build/py/objcell.o', has_indirect=False)
    abstract protected void mp_obj_cell_get(int offset) throws Exception;

    // function: Function(address=134263124, size=4, name='mp_obj_cell_set', path='build/py/objcell.o', has_indirect=False)
    abstract protected void mp_obj_cell_set(int offset) throws Exception;

    // function: Function(address=134263128, size=24, name='mp_obj_new_cell', path='build/py/objcell.o', has_indirect=False)
    abstract protected void mp_obj_new_cell(int offset) throws Exception;

    // function: Function(address=134263152, size=148, name='closure_call', path='build/py/objclosure.o', has_indirect=False)
    abstract protected void closure_call(int offset) throws Exception;

    // function: Function(address=134263300, size=112, name='closure_print', path='build/py/objclosure.o', has_indirect=False)
    abstract protected void closure_print(int offset) throws Exception;

    // function: Function(address=134263412, size=48, name='mp_obj_new_closure', path='build/py/objclosure.o', has_indirect=False)
    abstract protected void mp_obj_new_closure(int offset) throws Exception;

    // function: Function(address=134263460, size=40, name='complex_attr', path='build/py/objcomplex.o', has_indirect=False)
    abstract protected void complex_attr(int offset) throws Exception;

    // function: Function(address=134263500, size=160, name='complex_print', path='build/py/objcomplex.o', has_indirect=False)
    abstract protected void complex_print(int offset) throws Exception;

    // function: Function(address=134263660, size=28, name='mp_obj_new_complex', path='build/py/objcomplex.o', has_indirect=False)
    abstract protected void mp_obj_new_complex(int offset) throws Exception;

    // function: Function(address=134263688, size=156, name='complex_unary_op', path='build/py/objcomplex.o', has_indirect=False)
    abstract protected void complex_unary_op(int offset) throws Exception;

    // function: Function(address=134263844, size=188, name='complex_make_new', path='build/py/objcomplex.o', has_indirect=False)
    abstract protected void complex_make_new(int offset) throws Exception;

    // function: Function(address=134264032, size=10, name='mp_obj_complex_get', path='build/py/objcomplex.o', has_indirect=False)
    abstract protected void mp_obj_complex_get(int offset) throws Exception;

    // function: Function(address=134264044, size=604, name='mp_obj_complex_binary_op', path='build/py/objcomplex.o', has_indirect=False)
    abstract protected void mp_obj_complex_binary_op(int offset) throws Exception;

    // function: Function(address=134264648, size=14, name='complex_binary_op', path='build/py/objcomplex.o', has_indirect=False)
    abstract protected void complex_binary_op(int offset) throws Exception;

    // function: Function(address=134264664, size=104, name='deque_make_new', path='build/py/objdeque.o', has_indirect=False)
    abstract protected void deque_make_new(int offset) throws Exception;

    // function: Function(address=134264768, size=68, name='deque_unary_op', path='build/py/objdeque.o', has_indirect=False)
    abstract protected void deque_unary_op(int offset) throws Exception;

    // function: Function(address=134264836, size=56, name='deque_popleft', path='build/py/objdeque.o', has_indirect=False)
    abstract protected void deque_popleft(int offset) throws Exception;

    // function: Function(address=134264892, size=76, name='mp_obj_deque_append', path='build/py/objdeque.o', has_indirect=False)
    abstract protected void mp_obj_deque_append(int offset) throws Exception;

    // function: Function(address=134264968, size=24, name='dict_view_getiter', path='build/py/objdict.o', has_indirect=False)
    abstract protected void dict_view_getiter(int offset) throws Exception;

    // function: Function(address=134264992, size=24, name='dict_getiter', path='build/py/objdict.o', has_indirect=False)
    abstract protected void dict_getiter(int offset) throws Exception;

    // function: Function(address=134265016, size=28, name='dict_values', path='build/py/objdict.o', has_indirect=False)
    abstract protected void dict_values(int offset) throws Exception;

    // function: Function(address=134265044, size=16, name='mp_ensure_not_fixed', path='build/py/objdict.o', has_indirect=False)
    abstract protected void mp_ensure_not_fixed(int offset) throws Exception;

    // function: Function(address=134265060, size=24, name='dict_clear', path='build/py/objdict.o', has_indirect=False)
    abstract protected void dict_clear(int offset) throws Exception;

    // function: Function(address=134265084, size=60, name='dict_unary_op', path='build/py/objdict.o', has_indirect=False)
    abstract protected void dict_unary_op(int offset) throws Exception;

    // function: Function(address=134265144, size=92, name='dict_get_helper', path='build/py/objdict.o', has_indirect=False)
    abstract protected void dict_get_helper(int offset) throws Exception;

    // function: Function(address=134265236, size=10, name='dict_setdefault', path='build/py/objdict.o', has_indirect=False)
    abstract protected void dict_setdefault(int offset) throws Exception;

    // function: Function(address=134265246, size=10, name='dict_pop', path='build/py/objdict.o', has_indirect=False)
    abstract protected void dict_pop(int offset) throws Exception;

    // function: Function(address=134265256, size=10, name='dict_get', path='build/py/objdict.o', has_indirect=False)
    abstract protected void dict_get(int offset) throws Exception;

    // function: Function(address=134265266, size=42, name='dict_iter_next', path='build/py/objdict.o', has_indirect=False)
    abstract protected void dict_iter_next(int offset) throws Exception;

    // function: Function(address=134265308, size=58, name='dict_view_it_iternext', path='build/py/objdict.o', has_indirect=False)
    abstract protected void dict_view_it_iternext(int offset) throws Exception;

    // function: Function(address=134265368, size=120, name='dict_view_print', path='build/py/objdict.o', has_indirect=False)
    abstract protected void dict_view_print(int offset) throws Exception;

    // function: Function(address=134265488, size=232, name='dict_update', path='build/py/objdict.o', has_indirect=False)
    abstract protected void dict_update(int offset) throws Exception;

    // function: Function(address=134265720, size=72, name='dict_popitem', path='build/py/objdict.o', has_indirect=False)
    abstract protected void dict_popitem(int offset) throws Exception;

    // function: Function(address=134265792, size=220, name='dict_binary_op', path='build/py/objdict.o', has_indirect=False)
    abstract protected void dict_binary_op(int offset) throws Exception;

    // function: Function(address=134266012, size=26, name='dict_view_binary_op', path='build/py/objdict.o', has_indirect=False)
    abstract protected void dict_view_binary_op(int offset) throws Exception;

    // function: Function(address=134266040, size=164, name='dict_print', path='build/py/objdict.o', has_indirect=False)
    abstract protected void dict_print(int offset) throws Exception;

    // function: Function(address=134266204, size=28, name='dict_items', path='build/py/objdict.o', has_indirect=False)
    abstract protected void dict_items(int offset) throws Exception;

    // function: Function(address=134266232, size=28, name='dict_keys', path='build/py/objdict.o', has_indirect=False)
    abstract protected void dict_keys(int offset) throws Exception;

    // function: Function(address=134266260, size=36, name='mp_obj_dict_get', path='build/py/objdict.o', has_indirect=False)
    abstract protected void mp_obj_dict_get(int offset) throws Exception;

    // function: Function(address=134266296, size=16, name='mp_obj_dict_init', path='build/py/objdict.o', has_indirect=False)
    abstract protected void mp_obj_dict_init(int offset) throws Exception;

    // function: Function(address=134266312, size=22, name='mp_obj_new_dict', path='build/py/objdict.o', has_indirect=False)
    abstract protected void mp_obj_new_dict(int offset) throws Exception;

    // function: Function(address=134266336, size=76, name='dict_fromkeys', path='build/py/objdict.o', has_indirect=False)
    abstract protected void dict_fromkeys(int offset) throws Exception;

    // function: Function(address=134266412, size=86, name='dict_copy', path='build/py/objdict.o', has_indirect=False)
    abstract protected void dict_copy(int offset) throws Exception;

    // function: Function(address=134266500, size=80, name='dict_make_new', path='build/py/objdict.o', has_indirect=True)
    abstract protected void dict_make_new(int offset) throws Exception;

    // function: Function(address=134266580, size=6, name='mp_obj_dict_len', path='build/py/objdict.o', has_indirect=False)
    abstract protected void mp_obj_dict_len(int offset) throws Exception;

    // function: Function(address=134266586, size=28, name='mp_obj_dict_store', path='build/py/objdict.o', has_indirect=False)
    abstract protected void mp_obj_dict_store(int offset) throws Exception;

    // function: Function(address=134266614, size=22, name='mp_obj_dict_delete', path='build/py/objdict.o', has_indirect=False)
    abstract protected void mp_obj_dict_delete(int offset) throws Exception;

    // function: Function(address=134266636, size=64, name='dict_subscr', path='build/py/objdict.o', has_indirect=False)
    abstract protected void dict_subscr(int offset) throws Exception;

    // function: Function(address=134266700, size=40, name='enumerate_iternext', path='build/py/objenumerate.o', has_indirect=False)
    abstract protected void enumerate_iternext(int offset) throws Exception;

    // function: Function(address=134266740, size=60, name='enumerate_make_new', path='build/py/objenumerate.o', has_indirect=False)
    abstract protected void enumerate_make_new(int offset) throws Exception;

    // function: Function(address=134266800, size=164, name='mp_obj_exception_print', path='build/py/objexcept.o', has_indirect=False)
    abstract protected void mp_obj_exception_print(int offset) throws Exception;

    // function: Function(address=134266964, size=128, name='mp_obj_exception_make_new', path='build/py/objexcept.o', has_indirect=True)
    abstract protected void mp_obj_exception_make_new(int offset) throws Exception;

    // function: Function(address=134267092, size=88, name='exc_add_strn', path='build/py/objexcept.o', has_indirect=True)
    abstract protected void exc_add_strn(int offset) throws Exception;

    // function: Function(address=134267180, size=2, name='mp_init_emergency_exception_buf', path='build/py/objexcept.o', has_indirect=False)
    abstract protected void mp_init_emergency_exception_buf(int offset) throws Exception;

    // function: Function(address=134267184, size=20, name='mp_obj_exception_get_value', path='build/py/objexcept.o', has_indirect=False)
    abstract protected void mp_obj_exception_get_value(int offset) throws Exception;

    // function: Function(address=134267204, size=72, name='mp_obj_exception_attr', path='build/py/objexcept.o', has_indirect=False)
    abstract protected void mp_obj_exception_attr(int offset) throws Exception;

    // function: Function(address=134267276, size=12, name='mp_obj_new_exception_args', path='build/py/objexcept.o', has_indirect=False)
    abstract protected void mp_obj_new_exception_args(int offset) throws Exception;

    // function: Function(address=134267288, size=12, name='mp_obj_new_exception', path='build/py/objexcept.o', has_indirect=False)
    abstract protected void mp_obj_new_exception(int offset) throws Exception;

    // function: Function(address=134267300, size=14, name='mp_obj_new_exception_arg1', path='build/py/objexcept.o', has_indirect=False)
    abstract protected void mp_obj_new_exception_arg1(int offset) throws Exception;

    // function: Function(address=134267316, size=148, name='mp_obj_new_exception_msg_varg', path='build/py/objexcept.o', has_indirect=False)
    abstract protected void mp_obj_new_exception_msg_varg(int offset) throws Exception;

    // function: Function(address=134267464, size=8, name='mp_obj_new_exception_msg', path='build/py/objexcept.o', has_indirect=False)
    abstract protected void mp_obj_new_exception_msg(int offset) throws Exception;

    // function: Function(address=134267472, size=48, name='mp_obj_is_exception_type', path='build/py/objexcept.o', has_indirect=False)
    abstract protected void mp_obj_is_exception_type(int offset) throws Exception;

    // function: Function(address=134267520, size=12, name='mp_obj_is_exception_instance', path='build/py/objexcept.o', has_indirect=False)
    abstract protected void mp_obj_is_exception_instance(int offset) throws Exception;

    // function: Function(address=134267532, size=32, name='mp_obj_exception_match', path='build/py/objexcept.o', has_indirect=False)
    abstract protected void mp_obj_exception_match(int offset) throws Exception;

    // function: Function(address=134267564, size=28, name='mp_obj_exception_clear_traceback', path='build/py/objexcept.o', has_indirect=False)
    abstract protected void mp_obj_exception_clear_traceback(int offset) throws Exception;

    // function: Function(address=134267592, size=128, name='mp_obj_exception_add_traceback', path='build/py/objexcept.o', has_indirect=False)
    abstract protected void mp_obj_exception_add_traceback(int offset) throws Exception;

    // function: Function(address=134267720, size=44, name='mp_obj_exception_get_traceback', path='build/py/objexcept.o', has_indirect=False)
    abstract protected void mp_obj_exception_get_traceback(int offset) throws Exception;

    // function: Function(address=134267764, size=52, name='filter_iternext', path='build/py/objfilter.o', has_indirect=False)
    abstract protected void filter_iternext(int offset) throws Exception;

    // function: Function(address=134267816, size=50, name='filter_make_new', path='build/py/objfilter.o', has_indirect=False)
    abstract protected void filter_make_new(int offset) throws Exception;

    // function: Function(address=134267868, size=88, name='float_print', path='build/py/objfloat.o', has_indirect=False)
    abstract protected void float_print(int offset) throws Exception;

    // function: Function(address=134267956, size=220, name='mp_obj_float_divmod', path='build/py/objfloat.o', has_indirect=False)
    abstract protected void mp_obj_float_divmod(int offset) throws Exception;

    // function: Function(address=134268176, size=70, name='mp_float_hash', path='build/py/objfloat.o', has_indirect=False)
    abstract protected void mp_float_hash(int offset) throws Exception;

    // function: Function(address=134268248, size=24, name='mp_obj_new_float', path='build/py/objfloat.o', has_indirect=False)
    abstract protected void mp_obj_new_float(int offset) throws Exception;

    // function: Function(address=134268272, size=92, name='float_make_new', path='build/py/objfloat.o', has_indirect=False)
    abstract protected void float_make_new(int offset) throws Exception;

    // function: Function(address=134268364, size=100, name='float_unary_op', path='build/py/objfloat.o', has_indirect=False)
    abstract protected void float_unary_op(int offset) throws Exception;

    // function: Function(address=134268464, size=4, name='mp_obj_float_get', path='build/py/objfloat.o', has_indirect=False)
    abstract protected void mp_obj_float_get(int offset) throws Exception;

    // function: Function(address=134268468, size=560, name='mp_obj_float_binary_op', path='build/py/objfloat.o', has_indirect=False)
    abstract protected void mp_obj_float_binary_op(int offset) throws Exception;

    // function: Function(address=134269028, size=36, name='float_binary_op', path='build/py/objfloat.o', has_indirect=False)
    abstract protected void float_binary_op(int offset) throws Exception;

    // function: Function(address=134269064, size=24, name='fun_builtin_0_call', path='build/py/objfun.o', has_indirect=False)
    abstract protected void fun_builtin_0_call(int offset) throws Exception;

    // function: Function(address=134269088, size=30, name='fun_builtin_1_call', path='build/py/objfun.o', has_indirect=False)
    abstract protected void fun_builtin_1_call(int offset) throws Exception;

    // function: Function(address=134269118, size=30, name='fun_builtin_2_call', path='build/py/objfun.o', has_indirect=False)
    abstract protected void fun_builtin_2_call(int offset) throws Exception;

    // function: Function(address=134269148, size=30, name='fun_builtin_3_call', path='build/py/objfun.o', has_indirect=False)
    abstract protected void fun_builtin_3_call(int offset) throws Exception;

    // function: Function(address=134269180, size=132, name='fun_bc_call', path='build/py/objfun.o', has_indirect=False)
    abstract protected void fun_bc_call(int offset) throws Exception;

    // function: Function(address=134269312, size=76, name='fun_builtin_var_call', path='build/py/objfun.o', has_indirect=False)
    abstract protected void fun_builtin_var_call(int offset) throws Exception;

    // function: Function(address=134269388, size=16, name='mp_obj_code_get_name', path='build/py/objfun.o', has_indirect=False)
    abstract protected void mp_obj_code_get_name(int offset) throws Exception;

    // function: Function(address=134269404, size=20, name='mp_obj_fun_get_name', path='build/py/objfun.o', has_indirect=False)
    abstract protected void mp_obj_fun_get_name(int offset) throws Exception;

    // function: Function(address=134269424, size=28, name='mp_obj_fun_bc_attr', path='build/py/objfun.o', has_indirect=False)
    abstract protected void mp_obj_fun_bc_attr(int offset) throws Exception;

    // function: Function(address=134269452, size=32, name='fun_bc_print', path='build/py/objfun.o', has_indirect=False)
    abstract protected void fun_bc_print(int offset) throws Exception;

    // function: Function(address=134269484, size=84, name='mp_obj_fun_bc_prepare_codestate', path='build/py/objfun.o', has_indirect=False)
    abstract protected void mp_obj_fun_bc_prepare_codestate(int offset) throws Exception;

    // function: Function(address=134269568, size=92, name='mp_obj_new_fun_bc', path='build/py/objfun.o', has_indirect=False)
    abstract protected void mp_obj_new_fun_bc(int offset) throws Exception;

    // function: Function(address=134269660, size=80, name='gen_wrap_call', path='build/py/objgenerator.o', has_indirect=False)
    abstract protected void gen_wrap_call(int offset) throws Exception;

    // function: Function(address=134269740, size=28, name='gen_instance_pend_throw', path='build/py/objgenerator.o', has_indirect=False)
    abstract protected void gen_instance_pend_throw(int offset) throws Exception;

    // function: Function(address=134269768, size=32, name='gen_instance_print', path='build/py/objgenerator.o', has_indirect=False)
    abstract protected void gen_instance_print(int offset) throws Exception;

    // function: Function(address=134269800, size=16, name='unlikely_gen_instance_throw_part_0', path='build/py/objgenerator.o', has_indirect=False)
    abstract protected void unlikely_gen_instance_throw_part_0(int offset) throws Exception;

    // function: Function(address=134269816, size=184, name='mp_obj_gen_resume', path='build/py/objgenerator.o', has_indirect=False)
    abstract protected void mp_obj_gen_resume(int offset) throws Exception;

    // function: Function(address=134270000, size=88, name='gen_resume_and_raise', path='build/py/objgenerator.o', has_indirect=False)
    abstract protected void gen_resume_and_raise(int offset) throws Exception;

    // function: Function(address=134270088, size=36, name='gen_instance_throw', path='build/py/objgenerator.o', has_indirect=False)
    abstract protected void gen_instance_throw(int offset) throws Exception;

    // function: Function(address=134270124, size=18, name='gen_instance_send', path='build/py/objgenerator.o', has_indirect=False)
    abstract protected void gen_instance_send(int offset) throws Exception;

    // function: Function(address=134270144, size=16, name='gen_instance_iternext', path='build/py/objgenerator.o', has_indirect=False)
    abstract protected void gen_instance_iternext(int offset) throws Exception;

    // function: Function(address=134270160, size=96, name='gen_instance_close', path='build/py/objgenerator.o', has_indirect=False)
    abstract protected void gen_instance_close(int offset) throws Exception;

    // function: Function(address=134270256, size=84, name='it_iternext', path='build/py/objgetitemiter.o', has_indirect=False)
    abstract protected void it_iternext(int offset) throws Exception;

    // function: Function(address=134270340, size=24, name='mp_obj_new_getitem_iter', path='build/py/objgetitemiter.o', has_indirect=False)
    abstract protected void mp_obj_new_getitem_iter(int offset) throws Exception;

    // function: Function(address=134270364, size=128, name='int_to_bytes', path='build/py/objint.o', has_indirect=False)
    abstract protected void int_to_bytes(int offset) throws Exception;

    // function: Function(address=134270492, size=108, name='int_from_bytes', path='build/py/objint.o', has_indirect=False)
    abstract protected void int_from_bytes(int offset) throws Exception;

    // function: Function(address=134270600, size=128, name='mp_obj_new_int_from_float', path='build/py/objint.o', has_indirect=False)
    abstract protected void mp_obj_new_int_from_float(int offset) throws Exception;

    // function: Function(address=134270728, size=156, name='mp_obj_int_make_new', path='build/py/objint.o', has_indirect=False)
    abstract protected void mp_obj_int_make_new(int offset) throws Exception;

    // function: Function(address=134270884, size=56, name='mp_int_format_size', path='build/py/objint.o', has_indirect=False)
    abstract protected void mp_int_format_size(int offset) throws Exception;

    // function: Function(address=134270940, size=278, name='mp_obj_int_formatted', path='build/py/objint.o', has_indirect=False)
    abstract protected void mp_obj_int_formatted(int offset) throws Exception;

    // function: Function(address=134271218, size=62, name='mp_obj_int_print', path='build/py/objint.o', has_indirect=False)
    abstract protected void mp_obj_int_print(int offset) throws Exception;

    // function: Function(address=134271280, size=100, name='mp_obj_int_binary_op_extra_cases', path='build/py/objint.o', has_indirect=False)
    abstract protected void mp_obj_int_binary_op_extra_cases(int offset) throws Exception;

    // function: Function(address=134271380, size=28, name='mp_obj_int_new_mpz', path='build/py/objint_mpz.o', has_indirect=False)
    abstract protected void mp_obj_int_new_mpz(int offset) throws Exception;

    // function: Function(address=134271408, size=84, name='mp_obj_int_formatted_impl', path='build/py/objint_mpz.o', has_indirect=False)
    abstract protected void mp_obj_int_formatted_impl(int offset) throws Exception;

    // function: Function(address=134271492, size=30, name='mp_obj_int_from_bytes_impl', path='build/py/objint_mpz.o', has_indirect=False)
    abstract protected void mp_obj_int_from_bytes_impl(int offset) throws Exception;

    // function: Function(address=134271522, size=32, name='mp_obj_int_to_bytes_impl', path='build/py/objint_mpz.o', has_indirect=False)
    abstract protected void mp_obj_int_to_bytes_impl(int offset) throws Exception;

    // function: Function(address=134271554, size=40, name='mp_obj_int_sign', path='build/py/objint_mpz.o', has_indirect=False)
    abstract protected void mp_obj_int_sign(int offset) throws Exception;

    // function: Function(address=134271596, size=128, name='mp_obj_int_unary_op', path='build/py/objint_mpz.o', has_indirect=False)
    abstract protected void mp_obj_int_unary_op(int offset) throws Exception;

    // function: Function(address=134271724, size=30, name='mp_obj_new_int_from_ll', path='build/py/objint_mpz.o', has_indirect=False)
    abstract protected void mp_obj_new_int_from_ll(int offset) throws Exception;

    // function: Function(address=134271754, size=24, name='mp_obj_new_int', path='build/py/objint_mpz.o', has_indirect=False)
    abstract protected void mp_obj_new_int(int offset) throws Exception;

    // function: Function(address=134271778, size=30, name='mp_obj_new_int_from_ull', path='build/py/objint_mpz.o', has_indirect=False)
    abstract protected void mp_obj_new_int_from_ull(int offset) throws Exception;

    // function: Function(address=134271808, size=208, name='mp_obj_int_pow3', path='build/py/objint_mpz.o', has_indirect=False)
    abstract protected void mp_obj_int_pow3(int offset) throws Exception;

    // function: Function(address=134272016, size=22, name='mp_obj_new_int_from_uint', path='build/py/objint_mpz.o', has_indirect=False)
    abstract protected void mp_obj_new_int_from_uint(int offset) throws Exception;

    // function: Function(address=134272038, size=46, name='mp_obj_new_int_from_str_len', path='build/py/objint_mpz.o', has_indirect=False)
    abstract protected void mp_obj_new_int_from_str_len(int offset) throws Exception;

    // function: Function(address=134272084, size=18, name='mp_obj_int_get_truncated', path='build/py/objint_mpz.o', has_indirect=False)
    abstract protected void mp_obj_int_get_truncated(int offset) throws Exception;

    // function: Function(address=134272104, size=44, name='mp_obj_int_get_checked', path='build/py/objint_mpz.o', has_indirect=False)
    abstract protected void mp_obj_int_get_checked(int offset) throws Exception;

    // function: Function(address=134272148, size=648, name='mp_obj_int_binary_op', path='build/py/objint_mpz.o', has_indirect=False)
    abstract protected void mp_obj_int_binary_op(int offset) throws Exception;

    // function: Function(address=134272796, size=10, name='mp_obj_int_as_float_impl', path='build/py/objint_mpz.o', has_indirect=False)
    abstract protected void mp_obj_int_as_float_impl(int offset) throws Exception;

    // function: Function(address=134272808, size=28, name='list_getiter', path='build/py/objlist.o', has_indirect=False)
    abstract protected void list_getiter(int offset) throws Exception;

    // function: Function(address=134272836, size=56, name='list_reverse', path='build/py/objlist.o', has_indirect=False)
    abstract protected void list_reverse(int offset) throws Exception;

    // function: Function(address=134272892, size=28, name='list_it_iternext', path='build/py/objlist.o', has_indirect=True)
    abstract protected void list_it_iternext(int offset) throws Exception;

    // function: Function(address=134272920, size=80, name='mp_obj_list_append', path='build/py/objlist.o', has_indirect=False)
    abstract protected void mp_obj_list_append(int offset) throws Exception;

    // function: Function(address=134273000, size=76, name='list_insert', path='build/py/objlist.o', has_indirect=False)
    abstract protected void list_insert(int offset) throws Exception;

    // function: Function(address=134273076, size=44, name='list_clear', path='build/py/objlist.o', has_indirect=False)
    abstract protected void list_clear(int offset) throws Exception;

    // function: Function(address=134273120, size=208, name='mp_quicksort', path='build/py/objlist.o', has_indirect=False)
    abstract protected void mp_quicksort(int offset) throws Exception;

    // function: Function(address=134273328, size=92, name='mp_obj_list_sort', path='build/py/objlist.o', has_indirect=False)
    abstract protected void mp_obj_list_sort(int offset) throws Exception;

    // function: Function(address=134273420, size=18, name='list_index', path='build/py/objlist.o', has_indirect=False)
    abstract protected void list_index(int offset) throws Exception;

    // function: Function(address=134273440, size=124, name='list_pop', path='build/py/objlist.o', has_indirect=False)
    abstract protected void list_pop(int offset) throws Exception;

    // function: Function(address=134273564, size=32, name='mp_obj_list_remove', path='build/py/objlist.o', has_indirect=False)
    abstract protected void mp_obj_list_remove(int offset) throws Exception;

    // function: Function(address=134273596, size=36, name='list_extend_from_iter', path='build/py/objlist.o', has_indirect=False)
    abstract protected void list_extend_from_iter(int offset) throws Exception;

    // function: Function(address=134273632, size=14, name='list_count', path='build/py/objlist.o', has_indirect=False)
    abstract protected void list_count(int offset) throws Exception;

    // function: Function(address=134273648, size=84, name='list_print', path='build/py/objlist.o', has_indirect=False)
    abstract protected void list_print(int offset) throws Exception;

    // function: Function(address=134273732, size=56, name='list_unary_op', path='build/py/objlist.o', has_indirect=False)
    abstract protected void list_unary_op(int offset) throws Exception;

    // function: Function(address=134273788, size=116, name='list_extend', path='build/py/objlist.o', has_indirect=False)
    abstract protected void list_extend(int offset) throws Exception;

    // function: Function(address=134273904, size=52, name='mp_obj_list_init', path='build/py/objlist.o', has_indirect=False)
    abstract protected void mp_obj_list_init(int offset) throws Exception;

    // function: Function(address=134273956, size=22, name='list_new', path='build/py/objlist.o', has_indirect=False)
    abstract protected void list_new(int offset) throws Exception;

    // function: Function(address=134273980, size=216, name='list_binary_op', path='build/py/objlist.o', has_indirect=False)
    abstract protected void list_binary_op(int offset) throws Exception;

    // function: Function(address=134274196, size=48, name='list_make_new', path='build/py/objlist.o', has_indirect=False)
    abstract protected void list_make_new(int offset) throws Exception;

    // function: Function(address=134274244, size=34, name='mp_obj_new_list', path='build/py/objlist.o', has_indirect=False)
    abstract protected void mp_obj_new_list(int offset) throws Exception;

    // function: Function(address=134274278, size=12, name='list_copy', path='build/py/objlist.o', has_indirect=False)
    abstract protected void list_copy(int offset) throws Exception;

    // function: Function(address=134274290, size=10, name='mp_obj_list_get', path='build/py/objlist.o', has_indirect=False)
    abstract protected void mp_obj_list_get(int offset) throws Exception;

    // function: Function(address=134274300, size=4, name='mp_obj_list_set_len', path='build/py/objlist.o', has_indirect=False)
    abstract protected void mp_obj_list_set_len(int offset) throws Exception;

    // function: Function(address=134274304, size=26, name='mp_obj_list_store', path='build/py/objlist.o', has_indirect=False)
    abstract protected void mp_obj_list_store(int offset) throws Exception;

    // function: Function(address=134274332, size=440, name='list_subscr', path='build/py/objlist.o', has_indirect=False)
    abstract protected void list_subscr(int offset) throws Exception;

    // function: Function(address=134274772, size=72, name='map_iternext', path='build/py/objmap.o', has_indirect=False)
    abstract protected void map_iternext(int offset) throws Exception;

    // function: Function(address=134274844, size=88, name='map_make_new', path='build/py/objmap.o', has_indirect=False)
    abstract protected void map_make_new(int offset) throws Exception;

    // function: Function(address=134274932, size=92, name='module_print', path='build/py/objmodule.o', has_indirect=False)
    abstract protected void module_print(int offset) throws Exception;

    // function: Function(address=134275024, size=104, name='module_attr', path='build/py/objmodule.o', has_indirect=False)
    abstract protected void module_attr(int offset) throws Exception;

    // function: Function(address=134275128, size=68, name='mp_obj_new_module', path='build/py/objmodule.o', has_indirect=False)
    abstract protected void mp_obj_new_module(int offset) throws Exception;

    // function: Function(address=134275196, size=28, name='mp_module_register', path='build/py/objmodule.o', has_indirect=False)
    abstract protected void mp_module_register(int offset) throws Exception;

    // function: Function(address=134275224, size=42, name='mp_module_call_init', path='build/py/objmodule.o', has_indirect=False)
    abstract protected void mp_module_call_init(int offset) throws Exception;

    // function: Function(address=134275268, size=60, name='mp_module_get', path='build/py/objmodule.o', has_indirect=False)
    abstract protected void mp_module_get(int offset) throws Exception;

    // function: Function(address=134275328, size=8, name='object___init__', path='build/py/objobject.o', has_indirect=False)
    abstract protected void object___init__(int offset) throws Exception;

    // function: Function(address=134275336, size=48, name='object___new__', path='build/py/objobject.o', has_indirect=False)
    abstract protected void object___new__(int offset) throws Exception;

    // function: Function(address=134275384, size=28, name='object_make_new', path='build/py/objobject.o', has_indirect=False)
    abstract protected void object_make_new(int offset) throws Exception;

    // function: Function(address=134275412, size=8, name='polymorph_it_iternext', path='build/py/objpolyiter.o', has_indirect=False)
    abstract protected void polymorph_it_iternext(int offset) throws Exception;

    // function: Function(address=134275420, size=22, name='property_deleter', path='build/py/objproperty.o', has_indirect=False)
    abstract protected void property_deleter(int offset) throws Exception;

    // function: Function(address=134275442, size=26, name='property_setter', path='build/py/objproperty.o', has_indirect=False)
    abstract protected void property_setter(int offset) throws Exception;

    // function: Function(address=134275468, size=26, name='property_getter', path='build/py/objproperty.o', has_indirect=False)
    abstract protected void property_getter(int offset) throws Exception;

    // function: Function(address=134275496, size=56, name='property_make_new', path='build/py/objproperty.o', has_indirect=False)
    abstract protected void property_make_new(int offset) throws Exception;

    // function: Function(address=134275552, size=4, name='mp_obj_property_get', path='build/py/objproperty.o', has_indirect=False)
    abstract protected void mp_obj_property_get(int offset) throws Exception;

    // function: Function(address=134275556, size=24, name='none_print', path='build/py/objnone.o', has_indirect=False)
    abstract protected void none_print(int offset) throws Exception;

    // function: Function(address=134275580, size=72, name='namedtuple_asdict', path='build/py/objnamedtuple.o', has_indirect=False)
    abstract protected void namedtuple_asdict(int offset) throws Exception;

    // function: Function(address=134275652, size=36, name='namedtuple_print', path='build/py/objnamedtuple.o', has_indirect=True)
    abstract protected void namedtuple_print(int offset) throws Exception;

    // function: Function(address=134275688, size=32, name='mp_obj_namedtuple_find_field', path='build/py/objnamedtuple.o', has_indirect=False)
    abstract protected void mp_obj_namedtuple_find_field(int offset) throws Exception;

    // function: Function(address=134275720, size=64, name='namedtuple_attr', path='build/py/objnamedtuple.o', has_indirect=True)
    abstract protected void namedtuple_attr(int offset) throws Exception;

    // function: Function(address=134275784, size=176, name='namedtuple_make_new', path='build/py/objnamedtuple.o', has_indirect=True)
    abstract protected void namedtuple_make_new(int offset) throws Exception;

    // function: Function(address=134275960, size=56, name='mp_obj_new_namedtuple_base', path='build/py/objnamedtuple.o', has_indirect=False)
    abstract protected void mp_obj_new_namedtuple_base(int offset) throws Exception;

    // function: Function(address=134276016, size=144, name='new_namedtuple_type', path='build/py/objnamedtuple.o', has_indirect=False)
    abstract protected void new_namedtuple_type(int offset) throws Exception;

    // function: Function(address=134276160, size=50, name='range_it_iternext', path='build/py/objrange.o', has_indirect=False)
    abstract protected void range_it_iternext(int offset) throws Exception;

    // function: Function(address=134276210, size=32, name='range_len', path='build/py/objrange.o', has_indirect=False)
    abstract protected void range_len(int offset) throws Exception;

    // function: Function(address=134276244, size=52, name='range_unary_op', path='build/py/objrange.o', has_indirect=False)
    abstract protected void range_unary_op(int offset) throws Exception;

    // function: Function(address=134276296, size=24, name='range_getiter', path='build/py/objrange.o', has_indirect=False)
    abstract protected void range_getiter(int offset) throws Exception;

    // function: Function(address=134276320, size=132, name='range_subscr', path='build/py/objrange.o', has_indirect=False)
    abstract protected void range_subscr(int offset) throws Exception;

    // function: Function(address=134276452, size=104, name='range_make_new', path='build/py/objrange.o', has_indirect=False)
    abstract protected void range_make_new(int offset) throws Exception;

    // function: Function(address=134276556, size=56, name='range_print', path='build/py/objrange.o', has_indirect=False)
    abstract protected void range_print(int offset) throws Exception;

    // function: Function(address=134276612, size=96, name='range_binary_op', path='build/py/objrange.o', has_indirect=False)
    abstract protected void range_binary_op(int offset) throws Exception;

    // function: Function(address=134276708, size=52, name='range_attr', path='build/py/objrange.o', has_indirect=False)
    abstract protected void range_attr(int offset) throws Exception;

    // function: Function(address=134276760, size=30, name='reversed_iternext', path='build/py/objreversed.o', has_indirect=False)
    abstract protected void reversed_iternext(int offset) throws Exception;

    // function: Function(address=134276790, size=84, name='reversed_make_new', path='build/py/objreversed.o', has_indirect=False)
    abstract protected void reversed_make_new(int offset) throws Exception;

    // function: Function(address=134276876, size=36, name='is_set_or_frozenset', path='build/py/objset.o', has_indirect=False)
    abstract protected void is_set_or_frozenset(int offset) throws Exception;

    // function: Function(address=134276912, size=28, name='set_getiter', path='build/py/objset.o', has_indirect=False)
    abstract protected void set_getiter(int offset) throws Exception;

    // function: Function(address=134276940, size=20, name='text_set_add', path='build/py/objset.o', has_indirect=False)
    abstract protected void text_set_add(int offset) throws Exception;

    // function: Function(address=134276960, size=20, name='set_discard', path='build/py/objset.o', has_indirect=False)
    abstract protected void set_discard(int offset) throws Exception;

    // function: Function(address=134276980, size=38, name='set_update_int', path='build/py/objset.o', has_indirect=False)
    abstract protected void set_update_int(int offset) throws Exception;

    // function: Function(address=134277020, size=36, name='set_update', path='build/py/objset.o', has_indirect=False)
    abstract protected void set_update(int offset) throws Exception;

    // function: Function(address=134277056, size=44, name='set_symmetric_difference_update', path='build/py/objset.o', has_indirect=False)
    abstract protected void set_symmetric_difference_update(int offset) throws Exception;

    // function: Function(address=134277100, size=60, name='set_isdisjoint', path='build/py/objset.o', has_indirect=False)
    abstract protected void set_isdisjoint(int offset) throws Exception;

    // function: Function(address=134277160, size=42, name='set_copy', path='build/py/objset.o', has_indirect=False)
    abstract protected void set_copy(int offset) throws Exception;

    // function: Function(address=134277202, size=20, name='set_union', path='build/py/objset.o', has_indirect=False)
    abstract protected void set_union(int offset) throws Exception;

    // function: Function(address=134277222, size=20, name='set_symmetric_difference', path='build/py/objset.o', has_indirect=False)
    abstract protected void set_symmetric_difference(int offset) throws Exception;

    // function: Function(address=134277244, size=16, name='set_clear', path='build/py/objset.o', has_indirect=False)
    abstract protected void set_clear(int offset) throws Exception;

    // function: Function(address=134277260, size=80, name='set_diff_int', path='build/py/objset.o', has_indirect=False)
    abstract protected void set_diff_int(int offset) throws Exception;

    // function: Function(address=134277340, size=16, name='set_diff_update', path='build/py/objset.o', has_indirect=False)
    abstract protected void set_diff_update(int offset) throws Exception;

    // function: Function(address=134277356, size=10, name='set_diff', path='build/py/objset.o', has_indirect=False)
    abstract protected void set_diff(int offset) throws Exception;

    // function: Function(address=134277368, size=180, name='set_print', path='build/py/objset.o', has_indirect=False)
    abstract protected void set_print(int offset) throws Exception;

    // function: Function(address=134277548, size=40, name='set_remove', path='build/py/objset.o', has_indirect=False)
    abstract protected void set_remove(int offset) throws Exception;

    // function: Function(address=134277588, size=32, name='text_set_pop', path='build/py/objset.o', has_indirect=False)
    abstract protected void text_set_pop(int offset) throws Exception;

    // function: Function(address=134277620, size=42, name='set_it_iternext', path='build/py/objset.o', has_indirect=True)
    abstract protected void set_it_iternext(int offset) throws Exception;

    // function: Function(address=134277664, size=116, name='set_unary_op', path='build/py/objset.o', has_indirect=False)
    abstract protected void set_unary_op(int offset) throws Exception;

    // function: Function(address=134277780, size=56, name='mp_obj_new_set', path='build/py/objset.o', has_indirect=False)
    abstract protected void mp_obj_new_set(int offset) throws Exception;

    // function: Function(address=134277836, size=100, name='set_intersect_int_part_4', path='build/py/objset.o', has_indirect=False)
    abstract protected void set_intersect_int_part_4(int offset) throws Exception;

    // function: Function(address=134277936, size=24, name='set_intersect_update', path='build/py/objset.o', has_indirect=False)
    abstract protected void set_intersect_update(int offset) throws Exception;

    // function: Function(address=134277960, size=20, name='set_intersect', path='build/py/objset.o', has_indirect=False)
    abstract protected void set_intersect(int offset) throws Exception;

    // function: Function(address=134277980, size=12, name='mp_obj_set_store', path='build/py/objset.o', has_indirect=False)
    abstract protected void mp_obj_set_store(int offset) throws Exception;

    // function: Function(address=134277992, size=82, name='set_make_new', path='build/py/objset.o', has_indirect=False)
    abstract protected void set_make_new(int offset) throws Exception;

    // function: Function(address=134278076, size=180, name='set_issubset_internal', path='build/py/objset.o', has_indirect=False)
    abstract protected void set_issubset_internal(int offset) throws Exception;

    // function: Function(address=134278256, size=16, name='set_issuperset', path='build/py/objset.o', has_indirect=False)
    abstract protected void set_issuperset(int offset) throws Exception;

    // function: Function(address=134278272, size=10, name='set_issubset', path='build/py/objset.o', has_indirect=False)
    abstract protected void set_issubset(int offset) throws Exception;

    // function: Function(address=134278284, size=300, name='set_binary_op', path='build/py/objset.o', has_indirect=False)
    abstract protected void set_binary_op(int offset) throws Exception;

    // function: Function(address=134278584, size=16, name='singleton_print', path='build/py/objsingleton.o', has_indirect=False)
    abstract protected void singleton_print(int offset) throws Exception;

    // function: Function(address=134278600, size=84, name='slice_print', path='build/py/objslice.o', has_indirect=False)
    abstract protected void slice_print(int offset) throws Exception;

    // function: Function(address=134278684, size=44, name='slice_attr', path='build/py/objslice.o', has_indirect=False)
    abstract protected void slice_attr(int offset) throws Exception;

    // function: Function(address=134278728, size=32, name='mp_obj_new_slice', path='build/py/objslice.o', has_indirect=False)
    abstract protected void mp_obj_new_slice(int offset) throws Exception;

    // function: Function(address=134278760, size=16, name='mp_obj_slice_get', path='build/py/objslice.o', has_indirect=False)
    abstract protected void mp_obj_slice_get(int offset) throws Exception;

    // function: Function(address=134278776, size=56, name='arg_looks_integer', path='build/py/objstr.o', has_indirect=False)
    abstract protected void arg_looks_integer(int offset) throws Exception;

    // function: Function(address=134278832, size=40, name='arg_looks_numeric', path='build/py/objstr.o', has_indirect=False)
    abstract protected void arg_looks_numeric(int offset) throws Exception;

    // function: Function(address=134278872, size=28, name='mp_obj_new_bytes_iterator', path='build/py/objstr.o', has_indirect=False)
    abstract protected void mp_obj_new_bytes_iterator(int offset) throws Exception;

    // function: Function(address=134278900, size=56, name='bytes_it_iternext', path='build/py/objstr.o', has_indirect=True)
    abstract protected void bytes_it_iternext(int offset) throws Exception;

    // function: Function(address=134278956, size=40, name='unlikely_bad_implicit_conversion', path='build/py/objstr.o', has_indirect=False)
    abstract protected void unlikely_bad_implicit_conversion(int offset) throws Exception;

    // function: Function(address=134278996, size=232, name='str_count', path='build/py/objstr.o', has_indirect=False)
    abstract protected void str_count(int offset) throws Exception;

    // function: Function(address=134279228, size=132, name='str_uni_istype', path='build/py/objstr.o', has_indirect=False)
    abstract protected void str_uni_istype(int offset) throws Exception;

    // function: Function(address=134279360, size=16, name='str_isspace', path='build/py/objstr.o', has_indirect=False)
    abstract protected void str_isspace(int offset) throws Exception;

    // function: Function(address=134279376, size=16, name='str_isalpha', path='build/py/objstr.o', has_indirect=False)
    abstract protected void str_isalpha(int offset) throws Exception;

    // function: Function(address=134279392, size=16, name='str_isdigit', path='build/py/objstr.o', has_indirect=False)
    abstract protected void str_isdigit(int offset) throws Exception;

    // function: Function(address=134279408, size=16, name='str_isupper', path='build/py/objstr.o', has_indirect=False)
    abstract protected void str_isupper(int offset) throws Exception;

    // function: Function(address=134279424, size=16, name='str_islower', path='build/py/objstr.o', has_indirect=False)
    abstract protected void str_islower(int offset) throws Exception;

    // function: Function(address=134279440, size=48, name='str_to_int', path='build/py/objstr.o', has_indirect=False)
    abstract protected void str_to_int(int offset) throws Exception;

    // function: Function(address=134279488, size=60, name='mp_obj_str_get_buffer', path='build/py/objstr.o', has_indirect=False)
    abstract protected void mp_obj_str_get_buffer(int offset) throws Exception;

    // function: Function(address=134279548, size=200, name='mp_str_print_quoted', path='build/py/objstr.o', has_indirect=False)
    abstract protected void mp_str_print_quoted(int offset) throws Exception;

    // function: Function(address=134279748, size=116, name='mp_str_print_json', path='build/py/objstr.o', has_indirect=False)
    abstract protected void mp_str_print_json(int offset) throws Exception;

    // function: Function(address=134279864, size=96, name='str_print', path='build/py/objstr.o', has_indirect=False)
    abstract protected void str_print(int offset) throws Exception;

    // function: Function(address=134279960, size=62, name='find_subbytes', path='build/py/objstr.o', has_indirect=False)
    abstract protected void find_subbytes(int offset) throws Exception;

    // function: Function(address=134280024, size=248, name='str_finder', path='build/py/objstr.o', has_indirect=False)
    abstract protected void str_finder(int offset) throws Exception;

    // function: Function(address=134280272, size=12, name='str_find', path='build/py/objstr.o', has_indirect=False)
    abstract protected void str_find(int offset) throws Exception;

    // function: Function(address=134280284, size=14, name='str_rfind', path='build/py/objstr.o', has_indirect=False)
    abstract protected void str_rfind(int offset) throws Exception;

    // function: Function(address=134280298, size=12, name='str_index', path='build/py/objstr.o', has_indirect=False)
    abstract protected void str_index(int offset) throws Exception;

    // function: Function(address=134280310, size=14, name='str_rindex', path='build/py/objstr.o', has_indirect=False)
    abstract protected void str_rindex(int offset) throws Exception;

    // function: Function(address=134280324, size=60, name='mp_obj_new_str_copy', path='build/py/objstr.o', has_indirect=False)
    abstract protected void mp_obj_new_str_copy(int offset) throws Exception;

    // function: Function(address=134280384, size=14, name='mp_obj_new_str_via_qstr', path='build/py/objstr.o', has_indirect=False)
    abstract protected void mp_obj_new_str_via_qstr(int offset) throws Exception;

    // function: Function(address=134280400, size=108, name='mp_obj_new_str_from_vstr', path='build/py/objstr.o', has_indirect=False)
    abstract protected void mp_obj_new_str_from_vstr(int offset) throws Exception;

    // function: Function(address=134280508, size=268, name='str_join', path='build/py/objstr.o', has_indirect=False)
    abstract protected void str_join(int offset) throws Exception;

    // function: Function(address=134280776, size=106, name='str_center', path='build/py/objstr.o', has_indirect=False)
    abstract protected void str_center(int offset) throws Exception;

    // function: Function(address=134280882, size=390, name='str_replace', path='build/py/objstr.o', has_indirect=False)
    abstract protected void str_replace(int offset) throws Exception;

    // function: Function(address=134281272, size=82, name='str_caseconv', path='build/py/objstr.o', has_indirect=False)
    abstract protected void str_caseconv(int offset) throws Exception;

    // function: Function(address=134281356, size=16, name='str_lower', path='build/py/objstr.o', has_indirect=False)
    abstract protected void str_lower(int offset) throws Exception;

    // function: Function(address=134281372, size=16, name='str_upper', path='build/py/objstr.o', has_indirect=False)
    abstract protected void str_upper(int offset) throws Exception;

    // function: Function(address=134281388, size=40, name='mp_obj_new_str', path='build/py/objstr.o', has_indirect=False)
    abstract protected void mp_obj_new_str(int offset) throws Exception;

    // function: Function(address=134281428, size=204, name='mp_obj_str_make_new', path='build/py/objstr.o', has_indirect=False)
    abstract protected void mp_obj_str_make_new(int offset) throws Exception;

    // function: Function(address=134281632, size=40, name='bytes_decode', path='build/py/objstr.o', has_indirect=False)
    abstract protected void bytes_decode(int offset) throws Exception;

    // function: Function(address=134281672, size=20, name='mp_obj_new_bytes', path='build/py/objstr.o', has_indirect=False)
    abstract protected void mp_obj_new_bytes(int offset) throws Exception;

    // function: Function(address=134281692, size=280, name='bytes_make_new_part_4', path='build/py/objstr.o', has_indirect=False)
    abstract protected void bytes_make_new_part_4(int offset) throws Exception;

    // function: Function(address=134281972, size=32, name='bytes_make_new', path='build/py/objstr.o', has_indirect=False)
    abstract protected void bytes_make_new(int offset) throws Exception;

    // function: Function(address=134282004, size=44, name='str_encode', path='build/py/objstr.o', has_indirect=False)
    abstract protected void str_encode(int offset) throws Exception;

    // function: Function(address=134282048, size=32, name='mp_obj_new_str_of_type', path='build/py/objstr.o', has_indirect=False)
    abstract protected void mp_obj_new_str_of_type(int offset) throws Exception;

    // function: Function(address=134282080, size=160, name='str_splitlines', path='build/py/objstr.o', has_indirect=False)
    abstract protected void str_splitlines(int offset) throws Exception;

    // function: Function(address=134282240, size=292, name='str_uni_strip', path='build/py/objstr.o', has_indirect=False)
    abstract protected void str_uni_strip(int offset) throws Exception;

    // function: Function(address=134282532, size=14, name='str_strip', path='build/py/objstr.o', has_indirect=False)
    abstract protected void str_strip(int offset) throws Exception;

    // function: Function(address=134282546, size=14, name='str_lstrip', path='build/py/objstr.o', has_indirect=False)
    abstract protected void str_lstrip(int offset) throws Exception;

    // function: Function(address=134282560, size=14, name='str_rstrip', path='build/py/objstr.o', has_indirect=False)
    abstract protected void str_rstrip(int offset) throws Exception;

    // function: Function(address=134282576, size=204, name='str_partitioner', path='build/py/objstr.o', has_indirect=False)
    abstract protected void str_partitioner(int offset) throws Exception;

    // function: Function(address=134282780, size=10, name='str_partition', path='build/py/objstr.o', has_indirect=False)
    abstract protected void str_partition(int offset) throws Exception;

    // function: Function(address=134282790, size=12, name='str_rpartition', path='build/py/objstr.o', has_indirect=False)
    abstract protected void str_rpartition(int offset) throws Exception;

    // function: Function(address=134282804, size=132, name='bytes_subscr', path='build/py/objstr.o', has_indirect=False)
    abstract protected void bytes_subscr(int offset) throws Exception;

    // function: Function(address=134282936, size=144, name='mp_obj_str_equal', path='build/py/objstr.o', has_indirect=False)
    abstract protected void mp_obj_str_equal(int offset) throws Exception;

    // function: Function(address=134283080, size=44, name='mp_obj_str_get_qstr', path='build/py/objstr.o', has_indirect=False)
    abstract protected void mp_obj_str_get_qstr(int offset) throws Exception;

    // function: Function(address=134283124, size=48, name='mp_obj_str_get_str', path='build/py/objstr.o', has_indirect=False)
    abstract protected void mp_obj_str_get_str(int offset) throws Exception;

    // function: Function(address=134283172, size=56, name='mp_obj_str_get_data', path='build/py/objstr.o', has_indirect=False)
    abstract protected void mp_obj_str_get_data(int offset) throws Exception;

    // function: Function(address=134283228, size=1348, name='mp_obj_str_binary_op', path='build/py/objstr.o', has_indirect=True)
    abstract protected void mp_obj_str_binary_op(int offset) throws Exception;

    // function: Function(address=134284576, size=332, name='mp_obj_str_split', path='build/py/objstr.o', has_indirect=False)
    abstract protected void mp_obj_str_split(int offset) throws Exception;

    // function: Function(address=134284908, size=292, name='str_rsplit', path='build/py/objstr.o', has_indirect=False)
    abstract protected void str_rsplit(int offset) throws Exception;

    // function: Function(address=134285200, size=116, name='str_startswith', path='build/py/objstr.o', has_indirect=False)
    abstract protected void str_startswith(int offset) throws Exception;

    // function: Function(address=134285316, size=96, name='str_endswith', path='build/py/objstr.o', has_indirect=False)
    abstract protected void str_endswith(int offset) throws Exception;

    // function: Function(address=134285412, size=1368, name='mp_obj_str_format_helper', path='build/py/objstr.o', has_indirect=False)
    abstract protected void mp_obj_str_format_helper(int offset) throws Exception;

    // function: Function(address=134286780, size=76, name='mp_obj_str_format', path='build/py/objstr.o', has_indirect=False)
    abstract protected void mp_obj_str_format(int offset) throws Exception;

    // function: Function(address=134286856, size=16, name='mp_obj_str_intern_checked', path='build/py/objstr.o', has_indirect=False)
    abstract protected void mp_obj_str_intern_checked(int offset) throws Exception;

    // function: Function(address=134286872, size=28, name='mp_obj_new_str_iterator', path='build/py/objstrunicode.o', has_indirect=False)
    abstract protected void mp_obj_new_str_iterator(int offset) throws Exception;

    // function: Function(address=134286900, size=68, name='str_it_iternext', path='build/py/objstrunicode.o', has_indirect=True)
    abstract protected void str_it_iternext(int offset) throws Exception;

    // function: Function(address=134286968, size=76, name='uni_unary_op', path='build/py/objstrunicode.o', has_indirect=False)
    abstract protected void uni_unary_op(int offset) throws Exception;

    // function: Function(address=134287044, size=288, name='uni_print', path='build/py/objstrunicode.o', has_indirect=False)
    abstract protected void uni_print(int offset) throws Exception;

    // function: Function(address=134287332, size=196, name='str_index_to_ptr', path='build/py/objstrunicode.o', has_indirect=False)
    abstract protected void str_index_to_ptr(int offset) throws Exception;

    // function: Function(address=134287528, size=220, name='str_subscr', path='build/py/objstrunicode.o', has_indirect=False)
    abstract protected void str_subscr(int offset) throws Exception;

    // function: Function(address=134287748, size=10, name='stringio___exit__', path='build/py/objstringio.o', has_indirect=False)
    abstract protected void stringio___exit__(int offset) throws Exception;

    // function: Function(address=134287760, size=36, name='stringio_print', path='build/py/objstringio.o', has_indirect=False)
    abstract protected void stringio_print(int offset) throws Exception;

    // function: Function(address=134287796, size=164, name='stringio_write', path='build/py/objstringio.o', has_indirect=False)
    abstract protected void stringio_write(int offset) throws Exception;

    // function: Function(address=134287960, size=164, name='stringio_make_new', path='build/py/objstringio.o', has_indirect=False)
    abstract protected void stringio_make_new(int offset) throws Exception;

    // function: Function(address=134288124, size=94, name='stringio_ioctl', path='build/py/objstringio.o', has_indirect=False)
    abstract protected void stringio_ioctl(int offset) throws Exception;

    // function: Function(address=134288220, size=52, name='stringio_getvalue', path='build/py/objstringio.o', has_indirect=False)
    abstract protected void stringio_getvalue(int offset) throws Exception;

    // function: Function(address=134288272, size=60, name='stringio_read', path='build/py/objstringio.o', has_indirect=False)
    abstract protected void stringio_read(int offset) throws Exception;

    // function: Function(address=134288332, size=28, name='tuple_it_iternext', path='build/py/objtuple.o', has_indirect=True)
    abstract protected void tuple_it_iternext(int offset) throws Exception;

    // function: Function(address=134288360, size=28, name='mp_obj_tuple_getiter', path='build/py/objtuple.o', has_indirect=True)
    abstract protected void mp_obj_tuple_getiter(int offset) throws Exception;

    // function: Function(address=134288388, size=120, name='mp_obj_tuple_print', path='build/py/objtuple.o', has_indirect=False)
    abstract protected void mp_obj_tuple_print(int offset) throws Exception;

    // function: Function(address=134288508, size=20, name='tuple_index', path='build/py/objtuple.o', has_indirect=False)
    abstract protected void tuple_index(int offset) throws Exception;

    // function: Function(address=134288528, size=16, name='tuple_count', path='build/py/objtuple.o', has_indirect=False)
    abstract protected void tuple_count(int offset) throws Exception;

    // function: Function(address=134288544, size=92, name='mp_obj_tuple_unary_op', path='build/py/objtuple.o', has_indirect=True)
    abstract protected void mp_obj_tuple_unary_op(int offset) throws Exception;

    // function: Function(address=134288636, size=60, name='mp_obj_new_tuple', path='build/py/objtuple.o', has_indirect=False)
    abstract protected void mp_obj_new_tuple(int offset) throws Exception;

    // function: Function(address=134288696, size=256, name='mp_obj_tuple_binary_op', path='build/py/objtuple.o', has_indirect=True)
    abstract protected void mp_obj_tuple_binary_op(int offset) throws Exception;

    // function: Function(address=134288952, size=116, name='mp_obj_tuple_subscr', path='build/py/objtuple.o', has_indirect=True)
    abstract protected void mp_obj_tuple_subscr(int offset) throws Exception;

    // function: Function(address=134289068, size=140, name='mp_obj_tuple_make_new', path='build/py/objtuple.o', has_indirect=False)
    abstract protected void mp_obj_tuple_make_new(int offset) throws Exception;

    // function: Function(address=134289208, size=10, name='mp_obj_tuple_get', path='build/py/objtuple.o', has_indirect=False)
    abstract protected void mp_obj_tuple_get(int offset) throws Exception;

    // function: Function(address=134289218, size=14, name='mp_obj_tuple_del', path='build/py/objtuple.o', has_indirect=False)
    abstract protected void mp_obj_tuple_del(int offset) throws Exception;

    // function: Function(address=134289232, size=88, name='instance_count_native_bases', path='build/py/objtype.o', has_indirect=False)
    abstract protected void instance_count_native_bases(int offset) throws Exception;

    // function: Function(address=134289320, size=44, name='native_base_init_wrapper', path='build/py/objtype.o', has_indirect=False)
    abstract protected void native_base_init_wrapper(int offset) throws Exception;

    // function: Function(address=134289364, size=240, name='mp_obj_class_lookup', path='build/py/objtype.o', has_indirect=False)
    abstract protected void mp_obj_class_lookup(int offset) throws Exception;

    // function: Function(address=134289604, size=160, name='super_attr', path='build/py/objtype.o', has_indirect=False)
    abstract protected void super_attr(int offset) throws Exception;

    // function: Function(address=134289764, size=36, name='static_class_method_make_new', path='build/py/objtype.o', has_indirect=False)
    abstract protected void static_class_method_make_new(int offset) throws Exception;

    // function: Function(address=134289800, size=64, name='super_make_new', path='build/py/objtype.o', has_indirect=False)
    abstract protected void super_make_new(int offset) throws Exception;

    // function: Function(address=134289864, size=16, name='type_print', path='build/py/objtype.o', has_indirect=False)
    abstract protected void type_print(int offset) throws Exception;

    // function: Function(address=134289880, size=128, name='instance_subscr', path='build/py/objtype.o', has_indirect=True)
    abstract protected void instance_subscr(int offset) throws Exception;

    // function: Function(address=134290008, size=116, name='instance_binary_op', path='build/py/objtype.o', has_indirect=True)
    abstract protected void instance_binary_op(int offset) throws Exception;

    // function: Function(address=134290124, size=160, name='instance_unary_op', path='build/py/objtype.o', has_indirect=True)
    abstract protected void instance_unary_op(int offset) throws Exception;

    // function: Function(address=134290284, size=188, name='instance_print', path='build/py/objtype.o', has_indirect=True)
    abstract protected void instance_print(int offset) throws Exception;

    // function: Function(address=134290472, size=64, name='super_print', path='build/py/objtype.o', has_indirect=False)
    abstract protected void super_print(int offset) throws Exception;

    // function: Function(address=134290536, size=560, name='mp_obj_instance_attr', path='build/py/objtype.o', has_indirect=True)
    abstract protected void mp_obj_instance_attr(int offset) throws Exception;

    // function: Function(address=134291096, size=36, name='type_call', path='build/py/objtype.o', has_indirect=False)
    abstract protected void type_call(int offset) throws Exception;

    // function: Function(address=134291132, size=74, name='instance_get_buffer', path='build/py/objtype.o', has_indirect=True)
    abstract protected void instance_get_buffer(int offset) throws Exception;

    // function: Function(address=134291206, size=86, name='instance_getiter', path='build/py/objtype.o', has_indirect=True)
    abstract protected void instance_getiter(int offset) throws Exception;

    // function: Function(address=134291292, size=80, name='check_for_special_accessors', path='build/py/objtype.o', has_indirect=False)
    abstract protected void check_for_special_accessors(int offset) throws Exception;

    // function: Function(address=134291372, size=164, name='type_attr', path='build/py/objtype.o', has_indirect=False)
    abstract protected void type_attr(int offset) throws Exception;

    // function: Function(address=134291536, size=112, name='mp_obj_instance_call', path='build/py/objtype.o', has_indirect=True)
    abstract protected void mp_obj_instance_call(int offset) throws Exception;

    // function: Function(address=134291648, size=44, name='mp_obj_new_instance', path='build/py/objtype.o', has_indirect=False)
    abstract protected void mp_obj_new_instance(int offset) throws Exception;

    // function: Function(address=134291692, size=348, name='mp_obj_instance_make_new', path='build/py/objtype.o', has_indirect=True)
    abstract protected void mp_obj_instance_make_new(int offset) throws Exception;

    // function: Function(address=134292040, size=48, name='mp_obj_instance_is_callable', path='build/py/objtype.o', has_indirect=False)
    abstract protected void mp_obj_instance_is_callable(int offset) throws Exception;

    // function: Function(address=134292088, size=404, name='mp_obj_new_type', path='build/py/objtype.o', has_indirect=False)
    abstract protected void mp_obj_new_type(int offset) throws Exception;

    // function: Function(address=134292492, size=64, name='type_make_new', path='build/py/objtype.o', has_indirect=False)
    abstract protected void type_make_new(int offset) throws Exception;

    // function: Function(address=134292556, size=32, name='mp_load_super_method', path='build/py/objtype.o', has_indirect=False)
    abstract protected void mp_load_super_method(int offset) throws Exception;

    // function: Function(address=134292588, size=96, name='mp_obj_is_subclass_fast', path='build/py/objtype.o', has_indirect=False)
    abstract protected void mp_obj_is_subclass_fast(int offset) throws Exception;

    // function: Function(address=134292684, size=120, name='mp_obj_is_subclass', path='build/py/objtype.o', has_indirect=False)
    abstract protected void mp_obj_is_subclass(int offset) throws Exception;

    // function: Function(address=134292804, size=36, name='mp_builtin_issubclass', path='build/py/objtype.o', has_indirect=False)
    abstract protected void mp_builtin_issubclass(int offset) throws Exception;

    // function: Function(address=134292840, size=16, name='mp_builtin_isinstance', path='build/py/objtype.o', has_indirect=False)
    abstract protected void mp_builtin_isinstance(int offset) throws Exception;

    // function: Function(address=134292856, size=26, name='mp_instance_cast_to_native_base', path='build/py/objtype.o', has_indirect=False)
    abstract protected void mp_instance_cast_to_native_base(int offset) throws Exception;

    // function: Function(address=134292882, size=64, name='zip_iternext', path='build/py/objzip.o', has_indirect=False)
    abstract protected void zip_iternext(int offset) throws Exception;

    // function: Function(address=134292948, size=76, name='zip_make_new', path='build/py/objzip.o', has_indirect=False)
    abstract protected void zip_make_new(int offset) throws Exception;

    // function: Function(address=134293024, size=22, name='op_getitem', path='build/py/opmethods.o', has_indirect=False)
    abstract protected void op_getitem(int offset) throws Exception;

    // function: Function(address=134293046, size=24, name='op_setitem', path='build/py/opmethods.o', has_indirect=False)
    abstract protected void op_setitem(int offset) throws Exception;

    // function: Function(address=134293070, size=22, name='op_delitem', path='build/py/opmethods.o', has_indirect=False)
    abstract protected void op_delitem(int offset) throws Exception;

    // function: Function(address=134293092, size=22, name='op_contains', path='build/py/opmethods.o', has_indirect=False)
    abstract protected void op_contains(int offset) throws Exception;

    // function: Function(address=134293114, size=38, name='mp_seq_multiply', path='build/py/sequence.o', has_indirect=False)
    abstract protected void mp_seq_multiply(int offset) throws Exception;

    // function: Function(address=134293152, size=248, name='mp_seq_get_fast_slice_indexes', path='build/py/sequence.o', has_indirect=False)
    abstract protected void mp_seq_get_fast_slice_indexes(int offset) throws Exception;

    // function: Function(address=134293400, size=70, name='mp_seq_extract_slice', path='build/py/sequence.o', has_indirect=False)
    abstract protected void mp_seq_extract_slice(int offset) throws Exception;

    // function: Function(address=134293470, size=108, name='mp_seq_cmp_bytes', path='build/py/sequence.o', has_indirect=False)
    abstract protected void mp_seq_cmp_bytes(int offset) throws Exception;

    // function: Function(address=134293580, size=152, name='mp_seq_cmp_objs', path='build/py/sequence.o', has_indirect=False)
    abstract protected void mp_seq_cmp_objs(int offset) throws Exception;

    // function: Function(address=134293732, size=104, name='mp_seq_index_obj', path='build/py/sequence.o', has_indirect=False)
    abstract protected void mp_seq_index_obj(int offset) throws Exception;

    // function: Function(address=134293836, size=40, name='mp_seq_count_obj', path='build/py/sequence.o', has_indirect=False)
    abstract protected void mp_seq_count_obj(int offset) throws Exception;

    // function: Function(address=134293876, size=36, name='mp_stream_close', path='build/py/stream.o', has_indirect=False)
    abstract protected void mp_stream_close(int offset) throws Exception;

    // function: Function(address=134293912, size=36, name='stream_flush', path='build/py/stream.o', has_indirect=False)
    abstract protected void stream_flush(int offset) throws Exception;

    // function: Function(address=134293948, size=140, name='stream_unbuffered_readline', path='build/py/stream.o', has_indirect=False)
    abstract protected void stream_unbuffered_readline(int offset) throws Exception;

    // function: Function(address=134294088, size=46, name='stream_unbuffered_readlines', path='build/py/stream.o', has_indirect=False)
    abstract protected void stream_unbuffered_readlines(int offset) throws Exception;

    // function: Function(address=134294134, size=84, name='stream_seek', path='build/py/stream.o', has_indirect=False)
    abstract protected void stream_seek(int offset) throws Exception;

    // function: Function(address=134294218, size=22, name='stream_tell', path='build/py/stream.o', has_indirect=False)
    abstract protected void stream_tell(int offset) throws Exception;

    // function: Function(address=134294240, size=92, name='mp_stream_rw', path='build/py/stream.o', has_indirect=False)
    abstract protected void mp_stream_rw(int offset) throws Exception;

    // function: Function(address=134294332, size=384, name='stream_read_generic', path='build/py/stream.o', has_indirect=False)
    abstract protected void stream_read_generic(int offset) throws Exception;

    // function: Function(address=134294716, size=10, name='stream_read', path='build/py/stream.o', has_indirect=False)
    abstract protected void stream_read(int offset) throws Exception;

    // function: Function(address=134294726, size=74, name='stream_readinto', path='build/py/stream.o', has_indirect=False)
    abstract protected void stream_readinto(int offset) throws Exception;

    // function: Function(address=134294800, size=64, name='mp_get_stream_raise', path='build/py/stream.o', has_indirect=False)
    abstract protected void mp_get_stream_raise(int offset) throws Exception;

    // function: Function(address=134294864, size=32, name='mp_stream_write', path='build/py/stream.o', has_indirect=False)
    abstract protected void mp_stream_write(int offset) throws Exception;

    // function: Function(address=134294896, size=96, name='stream_write_method', path='build/py/stream.o', has_indirect=False)
    abstract protected void stream_write_method(int offset) throws Exception;

    // function: Function(address=134294992, size=10, name='mp_stream_write_adaptor', path='build/py/stream.o', has_indirect=True)
    abstract protected void mp_stream_write_adaptor(int offset) throws Exception;

    // function: Function(address=134295002, size=30, name='mp_stream_unbuffered_iter', path='build/py/stream.o', has_indirect=False)
    abstract protected void mp_stream_unbuffered_iter(int offset) throws Exception;

    // function: Function(address=134295032, size=208, name='mp_binary_get_size', path='build/py/binary.o', has_indirect=False)
    abstract protected void mp_binary_get_size(int offset) throws Exception;

    // function: Function(address=134295240, size=174, name='mp_binary_get_val_array', path='build/py/binary.o', has_indirect=False)
    abstract protected void mp_binary_get_val_array(int offset) throws Exception;

    // function: Function(address=134295414, size=82, name='mp_binary_get_int', path='build/py/binary.o', has_indirect=False)
    abstract protected void mp_binary_get_int(int offset) throws Exception;

    // function: Function(address=134295496, size=168, name='mp_binary_get_val', path='build/py/binary.o', has_indirect=False)
    abstract protected void mp_binary_get_val(int offset) throws Exception;

    // function: Function(address=134295664, size=38, name='mp_binary_set_int', path='build/py/binary.o', has_indirect=False)
    abstract protected void mp_binary_set_int(int offset) throws Exception;

    // function: Function(address=134295704, size=236, name='mp_binary_set_val', path='build/py/binary.o', has_indirect=False)
    abstract protected void mp_binary_set_val(int offset) throws Exception;

    // function: Function(address=134295940, size=126, name='mp_binary_set_val_array_from_int', path='build/py/binary.o', has_indirect=False)
    abstract protected void mp_binary_set_val_array_from_int(int offset) throws Exception;

    // function: Function(address=134296068, size=132, name='mp_binary_set_val_array', path='build/py/binary.o', has_indirect=False)
    abstract protected void mp_binary_set_val_array(int offset) throws Exception;

    // function: Function(address=134296200, size=20, name='mp_import_stat_any', path='build/py/builtinimport.o', has_indirect=False)
    abstract protected void mp_import_stat_any(int offset) throws Exception;

    // function: Function(address=134296220, size=80, name='do_execute_raw_code', path='build/py/builtinimport.o', has_indirect=False)
    abstract protected void do_execute_raw_code(int offset) throws Exception;

    // function: Function(address=134296300, size=34, name='do_load_from_lexer', path='build/py/builtinimport.o', has_indirect=False)
    abstract protected void do_load_from_lexer(int offset) throws Exception;

    // function: Function(address=134296334, size=76, name='text_do_load', path='build/py/builtinimport.o', has_indirect=False)
    abstract protected void text_do_load(int offset) throws Exception;

    // function: Function(address=134296410, size=50, name='stat_file_py_or_mpy', path='build/py/builtinimport.o', has_indirect=False)
    abstract protected void stat_file_py_or_mpy(int offset) throws Exception;

    // function: Function(address=134296460, size=36, name='stat_dir_or_file', path='build/py/builtinimport.o', has_indirect=False)
    abstract protected void stat_dir_or_file(int offset) throws Exception;

    // function: Function(address=134296496, size=772, name='mp_builtin___import__', path='build/py/builtinimport.o', has_indirect=False)
    abstract protected void mp_builtin___import__(int offset) throws Exception;

    // function: Function(address=134297268, size=20, name='mp_obj_is_package', path='build/py/builtinimport.o', has_indirect=False)
    abstract protected void mp_obj_is_package(int offset) throws Exception;

    // function: Function(address=134297288, size=116, name='mp_builtin_compile', path='build/py/builtinevex.o', has_indirect=False)
    abstract protected void mp_builtin_compile(int offset) throws Exception;

    // function: Function(address=134297404, size=240, name='eval_exec_helper', path='build/py/builtinevex.o', has_indirect=False)
    abstract protected void eval_exec_helper(int offset) throws Exception;

    // function: Function(address=134297644, size=10, name='mp_builtin_eval', path='build/py/builtinevex.o', has_indirect=False)
    abstract protected void mp_builtin_eval(int offset) throws Exception;

    // function: Function(address=134297654, size=10, name='mp_builtin_exec', path='build/py/builtinevex.o', has_indirect=False)
    abstract protected void mp_builtin_exec(int offset) throws Exception;

    // function: Function(address=134297664, size=10, name='mp_builtin_execfile', path='build/py/builtinevex.o', has_indirect=False)
    abstract protected void mp_builtin_execfile(int offset) throws Exception;

    // function: Function(address=134297674, size=44, name='mp_help_add_from_names', path='build/py/builtinhelp.o', has_indirect=False)
    abstract protected void mp_help_add_from_names(int offset) throws Exception;

    // function: Function(address=134297718, size=40, name='mp_help_add_from_map', path='build/py/builtinhelp.o', has_indirect=False)
    abstract protected void mp_help_add_from_map(int offset) throws Exception;

    // function: Function(address=134297760, size=412, name='mp_builtin_help', path='build/py/builtinhelp.o', has_indirect=False)
    abstract protected void mp_builtin_help(int offset) throws Exception;

    // function: Function(address=134298172, size=12, name='mp_builtin_globals', path='build/py/modbuiltins.o', has_indirect=False)
    abstract protected void mp_builtin_globals(int offset) throws Exception;

    // function: Function(address=134298184, size=12, name='mp_builtin_locals', path='build/py/modbuiltins.o', has_indirect=False)
    abstract protected void mp_builtin_locals(int offset) throws Exception;

    // function: Function(address=134298196, size=116, name='mp_builtin___build_class__', path='build/py/modbuiltins.o', has_indirect=False)
    abstract protected void mp_builtin___build_class__(int offset) throws Exception;

    // function: Function(address=134298312, size=12, name='mp_builtin_abs', path='build/py/modbuiltins.o', has_indirect=False)
    abstract protected void mp_builtin_abs(int offset) throws Exception;

    // function: Function(address=134298324, size=12, name='mp_builtin_hash', path='build/py/modbuiltins.o', has_indirect=False)
    abstract protected void mp_builtin_hash(int offset) throws Exception;

    // function: Function(address=134298336, size=10, name='mp_builtin_iter', path='build/py/modbuiltins.o', has_indirect=False)
    abstract protected void mp_builtin_iter(int offset) throws Exception;

    // function: Function(address=134298348, size=48, name='mp_builtin_all', path='build/py/modbuiltins.o', has_indirect=False)
    abstract protected void mp_builtin_all(int offset) throws Exception;

    // function: Function(address=134298396, size=48, name='mp_builtin_any', path='build/py/modbuiltins.o', has_indirect=False)
    abstract protected void mp_builtin_any(int offset) throws Exception;

    // function: Function(address=134298444, size=22, name='mp_builtin_bin', path='build/py/modbuiltins.o', has_indirect=False)
    abstract protected void mp_builtin_bin(int offset) throws Exception;

    // function: Function(address=134298468, size=28, name='mp_builtin_callable', path='build/py/modbuiltins.o', has_indirect=False)
    abstract protected void mp_builtin_callable(int offset) throws Exception;

    // function: Function(address=134298496, size=160, name='mp_builtin_chr', path='build/py/modbuiltins.o', has_indirect=False)
    abstract protected void mp_builtin_chr(int offset) throws Exception;

    // function: Function(address=134298656, size=14, name='mp_builtin_divmod', path='build/py/modbuiltins.o', has_indirect=False)
    abstract protected void mp_builtin_divmod(int offset) throws Exception;

    // function: Function(address=134298670, size=16, name='mp_builtin_hex', path='build/py/modbuiltins.o', has_indirect=False)
    abstract protected void mp_builtin_hex(int offset) throws Exception;

    // function: Function(address=134298686, size=16, name='mp_builtin_oct', path='build/py/modbuiltins.o', has_indirect=False)
    abstract protected void mp_builtin_oct(int offset) throws Exception;

    // function: Function(address=134298702, size=52, name='mp_builtin_sum', path='build/py/modbuiltins.o', has_indirect=False)
    abstract protected void mp_builtin_sum(int offset) throws Exception;

    // function: Function(address=134298756, size=224, name='mp_builtin_min_max', path='build/py/modbuiltins.o', has_indirect=False)
    abstract protected void mp_builtin_min_max(int offset) throws Exception;

    // function: Function(address=134298980, size=10, name='mp_builtin_max', path='build/py/modbuiltins.o', has_indirect=False)
    abstract protected void mp_builtin_max(int offset) throws Exception;

    // function: Function(address=134298990, size=10, name='mp_builtin_min', path='build/py/modbuiltins.o', has_indirect=False)
    abstract protected void mp_builtin_min(int offset) throws Exception;

    // function: Function(address=134299000, size=100, name='mp_builtin_ord', path='build/py/modbuiltins.o', has_indirect=False)
    abstract protected void mp_builtin_ord(int offset) throws Exception;

    // function: Function(address=134299100, size=132, name='mp_builtin_print', path='build/py/modbuiltins.o', has_indirect=False)
    abstract protected void mp_builtin_print(int offset) throws Exception;

    // function: Function(address=134299232, size=44, name='mp_builtin_repr', path='build/py/modbuiltins.o', has_indirect=False)
    abstract protected void mp_builtin_repr(int offset) throws Exception;

    // function: Function(address=134299276, size=108, name='mp_builtin_round', path='build/py/modbuiltins.o', has_indirect=False)
    abstract protected void mp_builtin_round(int offset) throws Exception;

    // function: Function(address=134299384, size=60, name='mp_builtin_sorted', path='build/py/modbuiltins.o', has_indirect=False)
    abstract protected void mp_builtin_sorted(int offset) throws Exception;

    // function: Function(address=134299444, size=44, name='mp_builtin_hasattr', path='build/py/modbuiltins.o', has_indirect=False)
    abstract protected void mp_builtin_hasattr(int offset) throws Exception;

    // function: Function(address=134299488, size=68, name='mp_builtin_getattr', path='build/py/modbuiltins.o', has_indirect=False)
    abstract protected void mp_builtin_getattr(int offset) throws Exception;

    // function: Function(address=134299556, size=32, name='mp_builtin_setattr', path='build/py/modbuiltins.o', has_indirect=False)
    abstract protected void mp_builtin_setattr(int offset) throws Exception;

    // function: Function(address=134299588, size=10, name='mp_builtin_delattr', path='build/py/modbuiltins.o', has_indirect=False)
    abstract protected void mp_builtin_delattr(int offset) throws Exception;

    // function: Function(address=134299600, size=144, name='mp_builtin_dir', path='build/py/modbuiltins.o', has_indirect=False)
    abstract protected void mp_builtin_dir(int offset) throws Exception;

    // function: Function(address=134299744, size=28, name='mp_builtin_next', path='build/py/modbuiltins.o', has_indirect=False)
    abstract protected void mp_builtin_next(int offset) throws Exception;

    // function: Function(address=134299772, size=34, name='mp_builtin_pow', path='build/py/modbuiltins.o', has_indirect=False)
    abstract protected void mp_builtin_pow(int offset) throws Exception;

    // function: Function(address=134299808, size=76, name='mp_builtin___repl_print__', path='build/py/modbuiltins.o', has_indirect=False)
    abstract protected void mp_builtin___repl_print__(int offset) throws Exception;

    // function: Function(address=134299884, size=24, name='gc_disable', path='build/py/modgc.o', has_indirect=False)
    abstract protected void gc_disable(int offset) throws Exception;

    // function: Function(address=134299908, size=24, name='gc_enable', path='build/py/modgc.o', has_indirect=False)
    abstract protected void gc_enable(int offset) throws Exception;

    // function: Function(address=134299932, size=32, name='gc_isenabled', path='build/py/modgc.o', has_indirect=False)
    abstract protected void gc_isenabled(int offset) throws Exception;

    // function: Function(address=134299964, size=28, name='py_gc_collect', path='build/py/modgc.o', has_indirect=False)
    abstract protected void py_gc_collect(int offset) throws Exception;

    // function: Function(address=134299992, size=22, name='gc_mem_free', path='build/py/modgc.o', has_indirect=False)
    abstract protected void gc_mem_free(int offset) throws Exception;

    // function: Function(address=134300014, size=22, name='gc_mem_alloc', path='build/py/modgc.o', has_indirect=False)
    abstract protected void gc_mem_alloc(int offset) throws Exception;

    // function: Function(address=134300036, size=60, name='gc_threshold', path='build/py/modgc.o', has_indirect=False)
    abstract protected void gc_threshold(int offset) throws Exception;

    // function: Function(address=134300096, size=224, name='resource_stream', path='build/py/modio.o', has_indirect=False)
    abstract protected void resource_stream(int offset) throws Exception;

    // function: Function(address=134300320, size=6, name='fabs_funcf', path='build/py/modmath.o', has_indirect=True)
    abstract protected void fabs_funcf(int offset) throws Exception;

    // function: Function(address=134300328, size=20, name='log2f', path='build/py/modmath.o', has_indirect=True)
    abstract protected void log2f(int offset) throws Exception;

    // function: Function(address=134300348, size=32, name='mp_math_isnan', path='build/py/modmath.o', has_indirect=False)
    abstract protected void mp_math_isnan(int offset) throws Exception;

    // function: Function(address=134300380, size=56, name='mp_math_isfinite', path='build/py/modmath.o', has_indirect=False)
    abstract protected void mp_math_isfinite(int offset) throws Exception;

    // function: Function(address=134300436, size=56, name='mp_math_isinf', path='build/py/modmath.o', has_indirect=False)
    abstract protected void mp_math_isinf(int offset) throws Exception;

    // function: Function(address=134300492, size=24, name='mp_math_degrees', path='build/py/modmath.o', has_indirect=False)
    abstract protected void mp_math_degrees(int offset) throws Exception;

    // function: Function(address=134300516, size=24, name='mp_math_radians', path='build/py/modmath.o', has_indirect=False)
    abstract protected void mp_math_radians(int offset) throws Exception;

    // function: Function(address=134300540, size=16, name='mp_math_trunc', path='build/py/modmath.o', has_indirect=False)
    abstract protected void mp_math_trunc(int offset) throws Exception;

    // function: Function(address=134300556, size=42, name='mp_math_modf', path='build/py/modmath.o', has_indirect=False)
    abstract protected void mp_math_modf(int offset) throws Exception;

    // function: Function(address=134300598, size=30, name='mp_math_ldexp', path='build/py/modmath.o', has_indirect=False)
    abstract protected void mp_math_ldexp(int offset) throws Exception;

    // function: Function(address=134300628, size=42, name='mp_math_frexp', path='build/py/modmath.o', has_indirect=False)
    abstract protected void mp_math_frexp(int offset) throws Exception;

    // function: Function(address=134300670, size=16, name='mp_math_floor', path='build/py/modmath.o', has_indirect=False)
    abstract protected void mp_math_floor(int offset) throws Exception;

    // function: Function(address=134300686, size=12, name='copysign_funcf', path='build/py/modmath.o', has_indirect=True)
    abstract protected void copysign_funcf(int offset) throws Exception;

    // function: Function(address=134300698, size=16, name='mp_math_ceil', path='build/py/modmath.o', has_indirect=False)
    abstract protected void mp_math_ceil(int offset) throws Exception;

    // function: Function(address=134300716, size=116, name='math_generic_1', path='build/py/modmath.o', has_indirect=False)
    abstract protected void math_generic_1(int offset) throws Exception;

    // function: Function(address=134300832, size=16, name='mp_math_lgamma', path='build/py/modmath.o', has_indirect=False)
    abstract protected void mp_math_lgamma(int offset) throws Exception;

    // function: Function(address=134300848, size=16, name='mp_math_gamma', path='build/py/modmath.o', has_indirect=False)
    abstract protected void mp_math_gamma(int offset) throws Exception;

    // function: Function(address=134300864, size=16, name='mp_math_erfc', path='build/py/modmath.o', has_indirect=False)
    abstract protected void mp_math_erfc(int offset) throws Exception;

    // function: Function(address=134300880, size=16, name='mp_math_erf', path='build/py/modmath.o', has_indirect=False)
    abstract protected void mp_math_erf(int offset) throws Exception;

    // function: Function(address=134300896, size=16, name='mp_math_fabs', path='build/py/modmath.o', has_indirect=False)
    abstract protected void mp_math_fabs(int offset) throws Exception;

    // function: Function(address=134300912, size=16, name='mp_math_atan', path='build/py/modmath.o', has_indirect=False)
    abstract protected void mp_math_atan(int offset) throws Exception;

    // function: Function(address=134300928, size=16, name='mp_math_asin', path='build/py/modmath.o', has_indirect=False)
    abstract protected void mp_math_asin(int offset) throws Exception;

    // function: Function(address=134300944, size=16, name='mp_math_acos', path='build/py/modmath.o', has_indirect=False)
    abstract protected void mp_math_acos(int offset) throws Exception;

    // function: Function(address=134300960, size=16, name='mp_math_tan', path='build/py/modmath.o', has_indirect=False)
    abstract protected void mp_math_tan(int offset) throws Exception;

    // function: Function(address=134300976, size=16, name='mp_math_sin', path='build/py/modmath.o', has_indirect=False)
    abstract protected void mp_math_sin(int offset) throws Exception;

    // function: Function(address=134300992, size=16, name='mp_math_cos', path='build/py/modmath.o', has_indirect=False)
    abstract protected void mp_math_cos(int offset) throws Exception;

    // function: Function(address=134301008, size=16, name='mp_math_atanh', path='build/py/modmath.o', has_indirect=False)
    abstract protected void mp_math_atanh(int offset) throws Exception;

    // function: Function(address=134301024, size=16, name='mp_math_asinh', path='build/py/modmath.o', has_indirect=False)
    abstract protected void mp_math_asinh(int offset) throws Exception;

    // function: Function(address=134301040, size=16, name='mp_math_acosh', path='build/py/modmath.o', has_indirect=False)
    abstract protected void mp_math_acosh(int offset) throws Exception;

    // function: Function(address=134301056, size=16, name='mp_math_tanh', path='build/py/modmath.o', has_indirect=False)
    abstract protected void mp_math_tanh(int offset) throws Exception;

    // function: Function(address=134301072, size=16, name='mp_math_sinh', path='build/py/modmath.o', has_indirect=False)
    abstract protected void mp_math_sinh(int offset) throws Exception;

    // function: Function(address=134301088, size=16, name='mp_math_cosh', path='build/py/modmath.o', has_indirect=False)
    abstract protected void mp_math_cosh(int offset) throws Exception;

    // function: Function(address=134301104, size=16, name='mp_math_log10', path='build/py/modmath.o', has_indirect=False)
    abstract protected void mp_math_log10(int offset) throws Exception;

    // function: Function(address=134301120, size=16, name='mp_math_log2', path='build/py/modmath.o', has_indirect=False)
    abstract protected void mp_math_log2(int offset) throws Exception;

    // function: Function(address=134301136, size=16, name='mp_math_expm1', path='build/py/modmath.o', has_indirect=False)
    abstract protected void mp_math_expm1(int offset) throws Exception;

    // function: Function(address=134301152, size=16, name='mp_math_exp', path='build/py/modmath.o', has_indirect=False)
    abstract protected void mp_math_exp(int offset) throws Exception;

    // function: Function(address=134301168, size=16, name='mp_math_sqrt', path='build/py/modmath.o', has_indirect=False)
    abstract protected void mp_math_sqrt(int offset) throws Exception;

    // function: Function(address=134301184, size=140, name='math_generic_2', path='build/py/modmath.o', has_indirect=False)
    abstract protected void math_generic_2(int offset) throws Exception;

    // function: Function(address=134301324, size=16, name='mp_math_fmod', path='build/py/modmath.o', has_indirect=False)
    abstract protected void mp_math_fmod(int offset) throws Exception;

    // function: Function(address=134301340, size=16, name='mp_math_copysign', path='build/py/modmath.o', has_indirect=False)
    abstract protected void mp_math_copysign(int offset) throws Exception;

    // function: Function(address=134301356, size=16, name='mp_math_atan2', path='build/py/modmath.o', has_indirect=False)
    abstract protected void mp_math_atan2(int offset) throws Exception;

    // function: Function(address=134301372, size=16, name='mp_math_pow', path='build/py/modmath.o', has_indirect=False)
    abstract protected void mp_math_pow(int offset) throws Exception;

    // function: Function(address=134301388, size=116, name='mp_math_log', path='build/py/modmath.o', has_indirect=False)
    abstract protected void mp_math_log(int offset) throws Exception;

    // function: Function(address=134301504, size=66, name='mp_cmath_sin', path='build/py/modcmath.o', has_indirect=False)
    abstract protected void mp_cmath_sin(int offset) throws Exception;

    // function: Function(address=134301570, size=70, name='mp_cmath_cos', path='build/py/modcmath.o', has_indirect=False)
    abstract protected void mp_cmath_cos(int offset) throws Exception;

    // function: Function(address=134301640, size=102, name='mp_cmath_sqrt', path='build/py/modcmath.o', has_indirect=False)
    abstract protected void mp_cmath_sqrt(int offset) throws Exception;

    // function: Function(address=134301744, size=84, name='mp_cmath_log10', path='build/py/modcmath.o', has_indirect=False)
    abstract protected void mp_cmath_log10(int offset) throws Exception;

    // function: Function(address=134301828, size=72, name='mp_cmath_log', path='build/py/modcmath.o', has_indirect=False)
    abstract protected void mp_cmath_log(int offset) throws Exception;

    // function: Function(address=134301900, size=58, name='mp_cmath_exp', path='build/py/modcmath.o', has_indirect=False)
    abstract protected void mp_cmath_exp(int offset) throws Exception;

    // function: Function(address=134301958, size=54, name='mp_cmath_rect', path='build/py/modcmath.o', has_indirect=False)
    abstract protected void mp_cmath_rect(int offset) throws Exception;

    // function: Function(address=134302012, size=24, name='mp_cmath_phase', path='build/py/modcmath.o', has_indirect=False)
    abstract protected void mp_cmath_phase(int offset) throws Exception;

    // function: Function(address=134302036, size=76, name='mp_cmath_polar', path='build/py/modcmath.o', has_indirect=False)
    abstract protected void mp_cmath_polar(int offset) throws Exception;

    // function: Function(address=134302112, size=20, name='mp_micropython_pystack_use', path='build/py/modmicropython.o', has_indirect=False)
    abstract protected void mp_micropython_pystack_use(int offset) throws Exception;

    // function: Function(address=134302132, size=14, name='mp_micropython_mem_total', path='build/py/modmicropython.o', has_indirect=False)
    abstract protected void mp_micropython_mem_total(int offset) throws Exception;

    // function: Function(address=134302146, size=14, name='mp_micropython_mem_current', path='build/py/modmicropython.o', has_indirect=False)
    abstract protected void mp_micropython_mem_current(int offset) throws Exception;

    // function: Function(address=134302160, size=14, name='mp_micropython_mem_peak', path='build/py/modmicropython.o', has_indirect=False)
    abstract protected void mp_micropython_mem_peak(int offset) throws Exception;

    // function: Function(address=134302174, size=14, name='mp_micropython_stack_use', path='build/py/modmicropython.o', has_indirect=False)
    abstract protected void mp_micropython_stack_use(int offset) throws Exception;

    // function: Function(address=134302188, size=92, name='mp_micropython_mem_info', path='build/py/modmicropython.o', has_indirect=False)
    abstract protected void mp_micropython_mem_info(int offset) throws Exception;

    // function: Function(address=134302280, size=20, name='mp_micropython_kbd_intr', path='build/py/modmicropython.o', has_indirect=False)
    abstract protected void mp_micropython_kbd_intr(int offset) throws Exception;

    // function: Function(address=134302300, size=16, name='mp_micropython_heap_unlock', path='build/py/modmicropython.o', has_indirect=False)
    abstract protected void mp_micropython_heap_unlock(int offset) throws Exception;

    // function: Function(address=134302316, size=16, name='mp_micropython_heap_lock', path='build/py/modmicropython.o', has_indirect=False)
    abstract protected void mp_micropython_heap_lock(int offset) throws Exception;

    // function: Function(address=134302332, size=64, name='mp_micropython_qstr_info', path='build/py/modmicropython.o', has_indirect=False)
    abstract protected void mp_micropython_qstr_info(int offset) throws Exception;

    // function: Function(address=134302396, size=36, name='mp_micropython_schedule', path='build/py/modmicropython.o', has_indirect=False)
    abstract protected void mp_micropython_schedule(int offset) throws Exception;

    // function: Function(address=134302432, size=44, name='mp_micropython_opt_level', path='build/py/modmicropython.o', has_indirect=False)
    abstract protected void mp_micropython_opt_level(int offset) throws Exception;

    // function: Function(address=134302476, size=36, name='get_fmt_type', path='build/py/modstruct.o', has_indirect=False)
    abstract protected void get_fmt_type(int offset) throws Exception;

    // function: Function(address=134302512, size=44, name='get_fmt_num', path='build/py/modstruct.o', has_indirect=False)
    abstract protected void get_fmt_num(int offset) throws Exception;

    // function: Function(address=134302556, size=102, name='calc_size_items', path='build/py/modstruct.o', has_indirect=False)
    abstract protected void calc_size_items(int offset) throws Exception;

    // function: Function(address=134302658, size=22, name='struct_calcsize', path='build/py/modstruct.o', has_indirect=False)
    abstract protected void struct_calcsize(int offset) throws Exception;

    // function: Function(address=134302680, size=216, name='struct_unpack_from', path='build/py/modstruct.o', has_indirect=False)
    abstract protected void struct_unpack_from(int offset) throws Exception;

    // function: Function(address=134302896, size=160, name='struct_pack_into_internal', path='build/py/modstruct.o', has_indirect=False)
    abstract protected void struct_pack_into_internal(int offset) throws Exception;

    // function: Function(address=134303056, size=68, name='struct_pack', path='build/py/modstruct.o', has_indirect=False)
    abstract protected void struct_pack(int offset) throws Exception;

    // function: Function(address=134303124, size=92, name='struct_pack_into', path='build/py/modstruct.o', has_indirect=False)
    abstract protected void struct_pack_into(int offset) throws Exception;

    // function: Function(address=134303216, size=32, name='mp_sys_exit', path='build/py/modsys.o', has_indirect=False)
    abstract protected void mp_sys_exit(int offset) throws Exception;

    // function: Function(address=134303248, size=52, name='mp_sys_print_exception', path='build/py/modsys.o', has_indirect=False)
    abstract protected void mp_sys_print_exception(int offset) throws Exception;

    // function: Function(address=134303300, size=56, name='mp_sys_exc_info', path='build/py/modsys.o', has_indirect=False)
    abstract protected void mp_sys_exc_info(int offset) throws Exception;

    // function: Function(address=134303356, size=12, name='mp_sys_getsizeof', path='build/py/modsys.o', has_indirect=False)
    abstract protected void mp_sys_getsizeof(int offset) throws Exception;

    // function: Function(address=134303368, size=28, name='mp_errno_to_str', path='build/py/moduerrno.o', has_indirect=False)
    abstract protected void mp_errno_to_str(int offset) throws Exception;

    // function: Function(address=134303396, size=4844, name='mp_execute_bytecode', path='build/py/vm.o', has_indirect=False)
    abstract protected void mp_execute_bytecode(int offset) throws Exception;

    // function: Function(address=134308240, size=36, name='unlikely_fun_pos_args_mismatch', path='build/py/bc.o', has_indirect=False)
    abstract protected void unlikely_fun_pos_args_mismatch(int offset) throws Exception;

    // function: Function(address=134308276, size=32, name='mp_decode_uint', path='build/py/bc.o', has_indirect=False)
    abstract protected void mp_decode_uint(int offset) throws Exception;

    // function: Function(address=134308308, size=12, name='mp_decode_uint_value', path='build/py/bc.o', has_indirect=False)
    abstract protected void mp_decode_uint_value(int offset) throws Exception;

    // function: Function(address=134308320, size=12, name='mp_decode_uint_skip', path='build/py/bc.o', has_indirect=False)
    abstract protected void mp_decode_uint_skip(int offset) throws Exception;

    // function: Function(address=134308332, size=720, name='mp_setup_code_state', path='build/py/bc.o', has_indirect=False)
    abstract protected void mp_setup_code_state(int offset) throws Exception;

    // function: Function(address=134309052, size=84, name='mp_opcode_format', path='build/py/bc.o', has_indirect=False)
    abstract protected void mp_opcode_format(int offset) throws Exception;

    // function: Function(address=134309136, size=54, name='str_startswith_word', path='build/py/repl.o', has_indirect=False)
    abstract protected void str_startswith_word(int offset) throws Exception;

    // function: Function(address=134309192, size=388, name='mp_repl_continue_with_input', path='build/py/repl.o', has_indirect=False)
    abstract protected void mp_repl_continue_with_input(int offset) throws Exception;

    // function: Function(address=134309580, size=524, name='mp_repl_autocomplete', path='build/py/repl.o', has_indirect=False)
    abstract protected void mp_repl_autocomplete(int offset) throws Exception;

    // function: Function(address=134310104, size=104, name='mp_small_int_mul_overflow', path='build/py/smallint.o', has_indirect=False)
    abstract protected void mp_small_int_mul_overflow(int offset) throws Exception;

    // function: Function(address=134310208, size=32, name='mp_small_int_modulo', path='build/py/smallint.o', has_indirect=False)
    abstract protected void mp_small_int_modulo(int offset) throws Exception;

    // function: Function(address=134310240, size=30, name='mp_small_int_floor_divide', path='build/py/smallint.o', has_indirect=False)
    abstract protected void mp_small_int_floor_divide(int offset) throws Exception;

    // function: Function(address=134310270, size=72, name='mp_frozen_stat_helper', path='build/py/frozenmod.o', has_indirect=False)
    abstract protected void mp_frozen_stat_helper(int offset) throws Exception;

    // function: Function(address=134310344, size=104, name='mp_find_frozen_str', path='build/py/frozenmod.o', has_indirect=False)
    abstract protected void mp_find_frozen_str(int offset) throws Exception;

    // function: Function(address=134310448, size=36, name='mp_frozen_stat', path='build/py/frozenmod.o', has_indirect=False)
    abstract protected void mp_frozen_stat(int offset) throws Exception;

    // function: Function(address=134310484, size=128, name='mp_find_frozen_module', path='build/py/frozenmod.o', has_indirect=False)
    abstract protected void mp_find_frozen_module(int offset) throws Exception;

    // function: Function(address=134310612, size=20, name='uctypes_struct_addressof', path='build/extmod/moductypes.o', has_indirect=False)
    abstract protected void uctypes_struct_addressof(int offset) throws Exception;

    // function: Function(address=134310632, size=28, name='uctypes_struct_bytearray_at', path='build/extmod/moductypes.o', has_indirect=False)
    abstract protected void uctypes_struct_bytearray_at(int offset) throws Exception;

    // function: Function(address=134310660, size=26, name='uctypes_struct_bytes_at', path='build/extmod/moductypes.o', has_indirect=False)
    abstract protected void uctypes_struct_bytes_at(int offset) throws Exception;

    // function: Function(address=134310686, size=150, name='get_aligned', path='build/extmod/moductypes.o', has_indirect=False)
    abstract protected void get_aligned(int offset) throws Exception;

    // function: Function(address=134310836, size=66, name='uctypes_struct_make_new', path='build/extmod/moductypes.o', has_indirect=False)
    abstract protected void uctypes_struct_make_new(int offset) throws Exception;

    // function: Function(address=134310904, size=88, name='uctypes_struct_print', path='build/extmod/moductypes.o', has_indirect=False)
    abstract protected void uctypes_struct_print(int offset) throws Exception;

    // function: Function(address=134310992, size=112, name='set_aligned', path='build/extmod/moductypes.o', has_indirect=False)
    abstract protected void set_aligned(int offset) throws Exception;

    // function: Function(address=134311104, size=236, name='uctypes_struct_size', path='build/extmod/moductypes.o', has_indirect=False)
    abstract protected void uctypes_struct_size(int offset) throws Exception;

    // function: Function(address=134311340, size=64, name='uctypes_struct_sizeof', path='build/extmod/moductypes.o', has_indirect=False)
    abstract protected void uctypes_struct_sizeof(int offset) throws Exception;

    // function: Function(address=134311404, size=80, name='uctypes_struct_agg_size', path='build/extmod/moductypes.o', has_indirect=False)
    abstract protected void uctypes_struct_agg_size(int offset) throws Exception;

    // function: Function(address=134311484, size=34, name='uctypes_get_buffer', path='build/extmod/moductypes.o', has_indirect=False)
    abstract protected void uctypes_get_buffer(int offset) throws Exception;

    // function: Function(address=134311520, size=312, name='uctypes_struct_subscr', path='build/extmod/moductypes.o', has_indirect=False)
    abstract protected void uctypes_struct_subscr(int offset) throws Exception;

    // function: Function(address=134311832, size=532, name='uctypes_struct_attr_op', path='build/extmod/moductypes.o', has_indirect=False)
    abstract protected void uctypes_struct_attr_op(int offset) throws Exception;

    // function: Function(address=134312364, size=34, name='uctypes_struct_attr', path='build/extmod/moductypes.o', has_indirect=False)
    abstract protected void uctypes_struct_attr(int offset) throws Exception;

    // function: Function(address=134312398, size=42, name='ujson_stream_next', path='build/extmod/modujson.o', has_indirect=False)
    abstract protected void ujson_stream_next(int offset) throws Exception;

    // function: Function(address=134312440, size=760, name='mod_ujson_load', path='build/extmod/modujson.o', has_indirect=False)
    abstract protected void mod_ujson_load(int offset) throws Exception;

    // function: Function(address=134313200, size=56, name='mod_ujson_loads', path='build/extmod/modujson.o', has_indirect=False)
    abstract protected void mod_ujson_loads(int offset) throws Exception;

    // function: Function(address=134313256, size=44, name='mod_ujson_dump', path='build/extmod/modujson.o', has_indirect=False)
    abstract protected void mod_ujson_dump(int offset) throws Exception;

    // function: Function(address=134313300, size=44, name='mod_ujson_dumps', path='build/extmod/modujson.o', has_indirect=False)
    abstract protected void mod_ujson_dumps(int offset) throws Exception;

    // function: Function(address=134313344, size=16, name='match_print', path='build/extmod/modure.o', has_indirect=False)
    abstract protected void match_print(int offset) throws Exception;

    // function: Function(address=134313360, size=16, name='re_print', path='build/extmod/modure.o', has_indirect=False)
    abstract protected void re_print(int offset) throws Exception;

    // function: Function(address=134313376, size=860, name='_compilecode', path='build/extmod/modure.o', has_indirect=False)
    abstract protected void _compilecode(int offset) throws Exception;

    // function: Function(address=134314236, size=72, name='match_group', path='build/extmod/modure.o', has_indirect=False)
    abstract protected void match_group(int offset) throws Exception;

    // function: Function(address=134314308, size=44, name='re1_5_sizecode', path='build/extmod/modure.o', has_indirect=False)
    abstract protected void re1_5_sizecode(int offset) throws Exception;

    // function: Function(address=134314352, size=84, name='re1_5_compilecode', path='build/extmod/modure.o', has_indirect=False)
    abstract protected void re1_5_compilecode(int offset) throws Exception;

    // function: Function(address=134314436, size=312, name='re1_5_dumpcode', path='build/extmod/modure.o', has_indirect=False)
    abstract protected void re1_5_dumpcode(int offset) throws Exception;

    // function: Function(address=134314748, size=92, name='mod_re_compile', path='build/extmod/modure.o', has_indirect=False)
    abstract protected void mod_re_compile(int offset) throws Exception;

    // function: Function(address=134314840, size=52, name='_re1_5_classmatch', path='build/extmod/modure.o', has_indirect=False)
    abstract protected void _re1_5_classmatch(int offset) throws Exception;

    // function: Function(address=134314892, size=74, name='_re1_5_namedclassmatch', path='build/extmod/modure.o', has_indirect=False)
    abstract protected void _re1_5_namedclassmatch(int offset) throws Exception;

    // function: Function(address=134314966, size=280, name='recursiveloop', path='build/extmod/modure.o', has_indirect=False)
    abstract protected void recursiveloop(int offset) throws Exception;

    // function: Function(address=134315246, size=26, name='re1_5_recursiveloopprog', path='build/extmod/modure.o', has_indirect=False)
    abstract protected void re1_5_recursiveloopprog(int offset) throws Exception;

    // function: Function(address=134315272, size=120, name='ure_exec_isra_2', path='build/extmod/modure.o', has_indirect=False)
    abstract protected void ure_exec_isra_2(int offset) throws Exception;

    // function: Function(address=134315392, size=10, name='re_match', path='build/extmod/modure.o', has_indirect=False)
    abstract protected void re_match(int offset) throws Exception;

    // function: Function(address=134315402, size=10, name='re_search', path='build/extmod/modure.o', has_indirect=False)
    abstract protected void re_search(int offset) throws Exception;

    // function: Function(address=134315412, size=30, name='mod_re_match', path='build/extmod/modure.o', has_indirect=False)
    abstract protected void mod_re_match(int offset) throws Exception;

    // function: Function(address=134315442, size=30, name='mod_re_search', path='build/extmod/modure.o', has_indirect=False)
    abstract protected void mod_re_search(int offset) throws Exception;

    // function: Function(address=134315472, size=204, name='re_split', path='build/extmod/modure.o', has_indirect=False)
    abstract protected void re_split(int offset) throws Exception;

    // function: Function(address=134315676, size=102, name='tinf_build_tree', path='build/extmod/moduzlib.o', has_indirect=False)
    abstract protected void tinf_build_tree(int offset) throws Exception;

    // function: Function(address=134315780, size=56, name='read_src_stream', path='build/extmod/moduzlib.o', has_indirect=True)
    abstract protected void read_src_stream(int offset) throws Exception;

    // function: Function(address=134315836, size=22, name='uzlib_get_byte', path='build/extmod/moduzlib.o', has_indirect=False)
    abstract protected void uzlib_get_byte(int offset) throws Exception;

    // function: Function(address=134315858, size=36, name='tinf_getbit', path='build/extmod/moduzlib.o', has_indirect=False)
    abstract protected void tinf_getbit(int offset) throws Exception;

    // function: Function(address=134315894, size=44, name='tinf_read_bits', path='build/extmod/moduzlib.o', has_indirect=False)
    abstract protected void tinf_read_bits(int offset) throws Exception;

    // function: Function(address=134315938, size=42, name='tinf_decode_symbol', path='build/extmod/moduzlib.o', has_indirect=False)
    abstract protected void tinf_decode_symbol(int offset) throws Exception;

    // function: Function(address=134315980, size=268, name='tinf_decode_trees', path='build/extmod/moduzlib.o', has_indirect=False)
    abstract protected void tinf_decode_trees(int offset) throws Exception;

    // function: Function(address=134316248, size=30, name='tinf_get_le_uint32', path='build/extmod/moduzlib.o', has_indirect=False)
    abstract protected void tinf_get_le_uint32(int offset) throws Exception;

    // function: Function(address=134316278, size=28, name='tinf_get_be_uint32', path='build/extmod/moduzlib.o', has_indirect=False)
    abstract protected void tinf_get_be_uint32(int offset) throws Exception;

    // function: Function(address=134316308, size=640, name='uzlib_uncompress', path='build/extmod/moduzlib.o', has_indirect=False)
    abstract protected void uzlib_uncompress(int offset) throws Exception;

    // function: Function(address=134316948, size=68, name='uzlib_zlib_parse_header', path='build/extmod/moduzlib.o', has_indirect=False)
    abstract protected void uzlib_zlib_parse_header(int offset) throws Exception;

    // function: Function(address=134317016, size=20, name='tinf_skip_bytes', path='build/extmod/moduzlib.o', has_indirect=False)
    abstract protected void tinf_skip_bytes(int offset) throws Exception;

    // function: Function(address=134317036, size=24, name='tinf_get_uint16', path='build/extmod/moduzlib.o', has_indirect=False)
    abstract protected void tinf_get_uint16(int offset) throws Exception;

    // function: Function(address=134317060, size=138, name='uzlib_gzip_parse_header', path='build/extmod/moduzlib.o', has_indirect=False)
    abstract protected void uzlib_gzip_parse_header(int offset) throws Exception;

    // function: Function(address=134317200, size=184, name='decompio_make_new', path='build/extmod/moduzlib.o', has_indirect=False)
    abstract protected void decompio_make_new(int offset) throws Exception;

    // function: Function(address=134317384, size=204, name='uzlib_adler32', path='build/extmod/moduzlib.o', has_indirect=False)
    abstract protected void uzlib_adler32(int offset) throws Exception;

    // function: Function(address=134317588, size=56, name='uzlib_crc32', path='build/extmod/moduzlib.o', has_indirect=False)
    abstract protected void uzlib_crc32(int offset) throws Exception;

    // function: Function(address=134317644, size=106, name='uzlib_uncompress_chksum', path='build/extmod/moduzlib.o', has_indirect=False)
    abstract protected void uzlib_uncompress_chksum(int offset) throws Exception;

    // function: Function(address=134317752, size=60, name='decompio_read', path='build/extmod/moduzlib.o', has_indirect=False)
    abstract protected void decompio_read(int offset) throws Exception;

    // function: Function(address=134317812, size=196, name='mod_uzlib_decompress', path='build/extmod/moduzlib.o', has_indirect=False)
    abstract protected void mod_uzlib_decompress(int offset) throws Exception;

    // function: Function(address=134318008, size=32, name='get_heap', path='build/extmod/moduheapq.o', has_indirect=False)
    abstract protected void get_heap(int offset) throws Exception;

    // function: Function(address=134318040, size=72, name='heap_siftdown_isra_0', path='build/extmod/moduheapq.o', has_indirect=False)
    abstract protected void heap_siftdown_isra_0(int offset) throws Exception;

    // function: Function(address=134318112, size=112, name='heap_siftup', path='build/extmod/moduheapq.o', has_indirect=False)
    abstract protected void heap_siftup(int offset) throws Exception;

    // function: Function(address=134318224, size=36, name='mod_uheapq_heapify', path='build/extmod/moduheapq.o', has_indirect=False)
    abstract protected void mod_uheapq_heapify(int offset) throws Exception;

    // function: Function(address=134318260, size=44, name='mod_uheapq_heappush', path='build/extmod/moduheapq.o', has_indirect=False)
    abstract protected void mod_uheapq_heappush(int offset) throws Exception;

    // function: Function(address=134318304, size=64, name='mod_uheapq_heappop', path='build/extmod/moduheapq.o', has_indirect=False)
    abstract protected void mod_uheapq_heappop(int offset) throws Exception;

    // function: Function(address=134318368, size=44, name='utimeq_unary_op', path='build/extmod/modutimeq.o', has_indirect=False)
    abstract protected void utimeq_unary_op(int offset) throws Exception;

    // function: Function(address=134318412, size=68, name='utimeq_make_new', path='build/extmod/modutimeq.o', has_indirect=False)
    abstract protected void utimeq_make_new(int offset) throws Exception;

    // function: Function(address=134318480, size=40, name='mod_utimeq_peektime', path='build/extmod/modutimeq.o', has_indirect=False)
    abstract protected void mod_utimeq_peektime(int offset) throws Exception;

    // function: Function(address=134318520, size=144, name='heap_siftdown_constprop_3', path='build/extmod/modutimeq.o', has_indirect=False)
    abstract protected void heap_siftdown_constprop_3(int offset) throws Exception;

    // function: Function(address=134318664, size=276, name='mod_utimeq_heappop', path='build/extmod/modutimeq.o', has_indirect=False)
    abstract protected void mod_utimeq_heappop(int offset) throws Exception;

    // function: Function(address=134318940, size=84, name='mod_utimeq_heappush', path='build/extmod/modutimeq.o', has_indirect=False)
    abstract protected void mod_utimeq_heappush(int offset) throws Exception;

    // function: Function(address=134319024, size=364, name='sha256_transform', path='build/extmod/moduhashlib.o', has_indirect=False)
    abstract protected void sha256_transform(int offset) throws Exception;

    // function: Function(address=134319388, size=80, name='sha256_init', path='build/extmod/moduhashlib.o', has_indirect=False)
    abstract protected void sha256_init(int offset) throws Exception;

    // function: Function(address=134319468, size=66, name='sha256_update', path='build/extmod/moduhashlib.o', has_indirect=False)
    abstract protected void sha256_update(int offset) throws Exception;

    // function: Function(address=134319536, size=36, name='uhashlib_sha256_update', path='build/extmod/moduhashlib.o', has_indirect=False)
    abstract protected void uhashlib_sha256_update(int offset) throws Exception;

    // function: Function(address=134319572, size=52, name='uhashlib_sha256_make_new', path='build/extmod/moduhashlib.o', has_indirect=False)
    abstract protected void uhashlib_sha256_make_new(int offset) throws Exception;

    // function: Function(address=134319624, size=204, name='sha256_final', path='build/extmod/moduhashlib.o', has_indirect=False)
    abstract protected void sha256_final(int offset) throws Exception;

    // function: Function(address=134319828, size=36, name='uhashlib_sha256_digest', path='build/extmod/moduhashlib.o', has_indirect=False)
    abstract protected void uhashlib_sha256_digest(int offset) throws Exception;

    // function: Function(address=134319864, size=136, name='mod_binascii_hexlify', path='build/extmod/modubinascii.o', has_indirect=False)
    abstract protected void mod_binascii_hexlify(int offset) throws Exception;

    // function: Function(address=134320000, size=244, name='mod_binascii_b2a_base64', path='build/extmod/modubinascii.o', has_indirect=False)
    abstract protected void mod_binascii_b2a_base64(int offset) throws Exception;

    // function: Function(address=134320244, size=132, name='mod_binascii_unhexlify', path='build/extmod/modubinascii.o', has_indirect=False)
    abstract protected void mod_binascii_unhexlify(int offset) throws Exception;

    // function: Function(address=134320376, size=196, name='mod_binascii_a2b_base64', path='build/extmod/modubinascii.o', has_indirect=False)
    abstract protected void mod_binascii_a2b_base64(int offset) throws Exception;

    // function: Function(address=134320572, size=50, name='mod_binascii_crc32', path='build/extmod/modubinascii.o', has_indirect=False)
    abstract protected void mod_binascii_crc32(int offset) throws Exception;

    // function: Function(address=134320624, size=40, name='machine_mem_get_addr', path='build/extmod/machine_mem.o', has_indirect=False)
    abstract protected void machine_mem_get_addr(int offset) throws Exception;

    // function: Function(address=134320664, size=20, name='machine_mem_print', path='build/extmod/machine_mem.o', has_indirect=False)
    abstract protected void machine_mem_print(int offset) throws Exception;

    // function: Function(address=134320684, size=92, name='machine_mem_subscr', path='build/extmod/machine_mem.o', has_indirect=False)
    abstract protected void machine_mem_subscr(int offset) throws Exception;

    // function: Function(address=134320776, size=96, name='yasmarang', path='build/extmod/modurandom.o', has_indirect=False)
    abstract protected void yasmarang(int offset) throws Exception;

    // function: Function(address=134320872, size=34, name='yasmarang_randbelow', path='build/extmod/modurandom.o', has_indirect=False)
    abstract protected void yasmarang_randbelow(int offset) throws Exception;

    // function: Function(address=134320906, size=66, name='mod_urandom_uniform', path='build/extmod/modurandom.o', has_indirect=False)
    abstract protected void mod_urandom_uniform(int offset) throws Exception;

    // function: Function(address=134320972, size=42, name='mod_urandom_randint', path='build/extmod/modurandom.o', has_indirect=False)
    abstract protected void mod_urandom_randint(int offset) throws Exception;

    // function: Function(address=134321014, size=106, name='mod_urandom_randrange', path='build/extmod/modurandom.o', has_indirect=False)
    abstract protected void mod_urandom_randrange(int offset) throws Exception;

    // function: Function(address=134321120, size=52, name='mod_urandom_seed', path='build/extmod/modurandom.o', has_indirect=False)
    abstract protected void mod_urandom_seed(int offset) throws Exception;

    // function: Function(address=134321172, size=44, name='mod_urandom_getrandbits', path='build/extmod/modurandom.o', has_indirect=False)
    abstract protected void mod_urandom_getrandbits(int offset) throws Exception;

    // function: Function(address=134321216, size=52, name='mod_urandom_choice', path='build/extmod/modurandom.o', has_indirect=False)
    abstract protected void mod_urandom_choice(int offset) throws Exception;

    // function: Function(address=134321268, size=30, name='mod_urandom_random', path='build/extmod/modurandom.o', has_indirect=False)
    abstract protected void mod_urandom_random(int offset) throws Exception;

    // function: Function(address=134321298, size=62, name='mp_vfs_proxy_call', path='build/extmod/vfs.o', has_indirect=False)
    abstract protected void mp_vfs_proxy_call(int offset) throws Exception;

    // function: Function(address=134321360, size=160, name='mp_vfs_umount', path='build/extmod/vfs.o', has_indirect=False)
    abstract protected void mp_vfs_umount(int offset) throws Exception;

    // function: Function(address=134321520, size=116, name='mp_vfs_getcwd', path='build/extmod/vfs.o', has_indirect=False)
    abstract protected void mp_vfs_getcwd(int offset) throws Exception;

    // function: Function(address=134321636, size=112, name='mp_vfs_ilistdir_it_iternext', path='build/extmod/vfs.o', has_indirect=True)
    abstract protected void mp_vfs_ilistdir_it_iternext(int offset) throws Exception;

    // function: Function(address=134321748, size=140, name='mp_vfs_lookup_path', path='build/extmod/vfs.o', has_indirect=False)
    abstract protected void mp_vfs_lookup_path(int offset) throws Exception;

    // function: Function(address=134321888, size=156, name='mp_vfs_mount', path='build/extmod/vfs.o', has_indirect=False)
    abstract protected void mp_vfs_mount(int offset) throws Exception;

    // function: Function(address=134322044, size=54, name='lookup_path', path='build/extmod/vfs.o', has_indirect=False)
    abstract protected void lookup_path(int offset) throws Exception;

    // function: Function(address=134322100, size=48, name='mp_vfs_open', path='build/extmod/vfs.o', has_indirect=False)
    abstract protected void mp_vfs_open(int offset) throws Exception;

    // function: Function(address=134322148, size=72, name='mp_vfs_chdir', path='build/extmod/vfs.o', has_indirect=False)
    abstract protected void mp_vfs_chdir(int offset) throws Exception;

    // function: Function(address=134322220, size=104, name='mp_vfs_ilistdir', path='build/extmod/vfs.o', has_indirect=False)
    abstract protected void mp_vfs_ilistdir(int offset) throws Exception;

    // function: Function(address=134322324, size=50, name='mp_vfs_listdir', path='build/extmod/vfs.o', has_indirect=False)
    abstract protected void mp_vfs_listdir(int offset) throws Exception;

    // function: Function(address=134322376, size=60, name='mp_vfs_mkdir', path='build/extmod/vfs.o', has_indirect=False)
    abstract protected void mp_vfs_mkdir(int offset) throws Exception;

    // function: Function(address=134322436, size=22, name='mp_vfs_remove', path='build/extmod/vfs.o', has_indirect=False)
    abstract protected void mp_vfs_remove(int offset) throws Exception;

    // function: Function(address=134322458, size=46, name='mp_vfs_rename', path='build/extmod/vfs.o', has_indirect=False)
    abstract protected void mp_vfs_rename(int offset) throws Exception;

    // function: Function(address=134322504, size=22, name='mp_vfs_rmdir', path='build/extmod/vfs.o', has_indirect=False)
    abstract protected void mp_vfs_rmdir(int offset) throws Exception;

    // function: Function(address=134322528, size=60, name='mp_vfs_stat', path='build/extmod/vfs.o', has_indirect=False)
    abstract protected void mp_vfs_stat(int offset) throws Exception;

    // function: Function(address=134322588, size=92, name='mp_vfs_statvfs', path='build/extmod/vfs.o', has_indirect=False)
    abstract protected void mp_vfs_statvfs(int offset) throws Exception;

    // function: Function(address=134322680, size=124, name='mp_vfs_import_stat', path='build/extmod/vfs.o', has_indirect=False)
    abstract protected void mp_vfs_import_stat(int offset) throws Exception;

    // function: Function(address=134322804, size=20, name='mp_reader_vfs_close', path='build/extmod/vfs_reader.o', has_indirect=True)
    abstract protected void mp_reader_vfs_close(int offset) throws Exception;

    // function: Function(address=134322824, size=70, name='mp_reader_vfs_readbyte', path='build/extmod/vfs_reader.o', has_indirect=True)
    abstract protected void mp_reader_vfs_readbyte(int offset) throws Exception;

    // function: Function(address=134322896, size=96, name='mp_reader_new_file', path='build/extmod/vfs_reader.o', has_indirect=False)
    abstract protected void mp_reader_new_file(int offset) throws Exception;

    // function: Function(address=134322992, size=28, name='time_ticks_diff', path='build/extmod/utime_mphal.o', has_indirect=False)
    abstract protected void time_ticks_diff(int offset) throws Exception;

    // function: Function(address=134323020, size=32, name='time_sleep', path='build/extmod/utime_mphal.o', has_indirect=False)
    abstract protected void time_sleep(int offset) throws Exception;

    // function: Function(address=134323052, size=24, name='time_sleep_ms', path='build/extmod/utime_mphal.o', has_indirect=False)
    abstract protected void time_sleep_ms(int offset) throws Exception;

    // function: Function(address=134323076, size=32, name='time_ticks_add', path='build/extmod/utime_mphal.o', has_indirect=False)
    abstract protected void time_ticks_add(int offset) throws Exception;

    // function: Function(address=134323108, size=24, name='time_ticks_ms', path='build/extmod/utime_mphal.o', has_indirect=False)
    abstract protected void time_ticks_ms(int offset) throws Exception;

    // function: Function(address=134323132, size=24, name='time_ticks_cpu', path='build/extmod/utime_mphal.o', has_indirect=False)
    abstract protected void time_ticks_cpu(int offset) throws Exception;

    // function: Function(address=134323156, size=34, name='strn_print_strn', path='build/lib/utils/printf.o', has_indirect=True)
    abstract protected void strn_print_strn(int offset) throws Exception;

    // function: Function(address=134323192, size=28, name='printf', path='build/lib/utils/printf.o', has_indirect=False)
    abstract protected void printf(int offset) throws Exception;

    // function: Function(address=134323220, size=20, name='putchar', path='build/lib/utils/printf.o', has_indirect=False)
    abstract protected void putchar(int offset) throws Exception;

    // function: Function(address=134323240, size=34, name='puts', path='build/lib/utils/printf.o', has_indirect=False)
    abstract protected void puts(int offset) throws Exception;

    // function: Function(address=134323276, size=56, name='vsnprintf', path='build/lib/utils/printf.o', has_indirect=False)
    abstract protected void vsnprintf(int offset) throws Exception;

    // function: Function(address=134323332, size=22, name='snprintf', path='build/lib/utils/printf.o', has_indirect=False)
    abstract protected void snprintf(int offset) throws Exception;

    // function: Function(address=134323356, size=200, name='main', path='build/main.o', has_indirect=False)
    abstract protected void main(int offset) throws Exception;

    // function: Function(address=134323556, size=44, name='Signal_Handler', path='build/machine.o', has_indirect=False)
    abstract protected void Signal_Handler(int offset) throws Exception;

    // function: Function(address=134323600, size=14, name='_exit', path='build/machine.o', has_indirect=False)
    abstract protected void _exit(int offset) throws Exception;

    // function: Function(address=134323614, size=16, name='_start', path='build/machine.o', has_indirect=False)
    abstract protected void _start(int offset) throws Exception;

    // function: Function(address=134323632, size=100, name='Reset_Handler', path='build/machine.o', has_indirect=False)
    abstract protected void Reset_Handler(int offset) throws Exception;

    // function: Function(address=134323732, size=16, name='__fatal_error', path='build/machine.o', has_indirect=False)
    abstract protected void __fatal_error(int offset) throws Exception;

    // function: Function(address=134323748, size=12, name='nlr_jump_fail', path='build/machine.o', has_indirect=False)
    abstract protected void nlr_jump_fail(int offset) throws Exception;

    // function: Function(address=134323760, size=16, name='mp_hal_stdin_rx_chr', path='build/mphalport.o', has_indirect=False)
    abstract protected void mp_hal_stdin_rx_chr(int offset) throws Exception;

    // function: Function(address=134323776, size=32, name='mp_hal_stdout_tx_strn', path='build/mphalport.o', has_indirect=False)
    abstract protected void mp_hal_stdout_tx_strn(int offset) throws Exception;

    // function: Function(address=134323808, size=40, name='mp_hal_delay_ms', path='build/mphalport.o', has_indirect=False)
    abstract protected void mp_hal_delay_ms(int offset) throws Exception;

    // function: Function(address=134323848, size=12, name='mp_hal_ticks_ms', path='build/mphalport.o', has_indirect=False)
    abstract protected void mp_hal_ticks_ms(int offset) throws Exception;

    // function: Function(address=134323860, size=12, name='mp_hal_ticks_cpu', path='build/mphalport.o', has_indirect=False)
    abstract protected void mp_hal_ticks_cpu(int offset) throws Exception;

    // function: Function(address=134323872, size=16, name='usystem_print_hook', path='build/modusystem.o', has_indirect=False)
    abstract protected void usystem_print_hook(int offset) throws Exception;

    // function: Function(address=134323888, size=32, name='usystem_debug', path='build/modusystem.o', has_indirect=False)
    abstract protected void usystem_debug(int offset) throws Exception;

    // function: Function(address=134323920, size=52, name='usystem_set_stdin_char', path='build/modusystem.o', has_indirect=False)
    abstract protected void usystem_set_stdin_char(int offset) throws Exception;

    // function: Function(address=134323972, size=36, name='parse_2', path='build/modusystem.o', has_indirect=False)
    abstract protected void parse_2(int offset) throws Exception;

    // function: Function(address=134324008, size=30, name='usystem_syscall', path='build/modusystem.o', has_indirect=False)
    abstract protected void usystem_syscall(int offset) throws Exception;

    // function: Function(address=134324038, size=20, name='usystem_signal', path='build/modusystem.o', has_indirect=False)
    abstract protected void usystem_signal(int offset) throws Exception;

    // function: Function(address=134324058, size=20, name='usystem_components', path='build/modusystem.o', has_indirect=False)
    abstract protected void usystem_components(int offset) throws Exception;

    // function: Function(address=134324078, size=34, name='usystem_methods', path='build/modusystem.o', has_indirect=False)
    abstract protected void usystem_methods(int offset) throws Exception;

    // function: Function(address=134324112, size=32, name='usystem_annotations', path='build/modusystem.o', has_indirect=False)
    abstract protected void usystem_annotations(int offset) throws Exception;

    // function: Function(address=134324144, size=20, name='usystem_get_stdout_str', path='build/modusystem.o', has_indirect=False)
    abstract protected void usystem_get_stdout_str(int offset) throws Exception;

    // function: Function(address=134324164, size=36, name='gc_collect', path='build/gccollect.o', has_indirect=False)
    abstract protected void gc_collect(int offset) throws Exception;

    // function: Function(address=134324200, size=10, name='vfs_openpie_file___exit__', path='build/openpie_vfs.o', has_indirect=False)
    abstract protected void vfs_openpie_file___exit__(int offset) throws Exception;

    // function: Function(address=134324212, size=32, name='vfs_openpie_file_print', path='build/openpie_vfs.o', has_indirect=False)
    abstract protected void vfs_openpie_file_print(int offset) throws Exception;

    // function: Function(address=134324244, size=24, name='unlikely_check_fd_is_open_isra_0_part_1', path='build/openpie_vfs.o', has_indirect=False)
    abstract protected void unlikely_check_fd_is_open_isra_0_part_1(int offset) throws Exception;

    // function: Function(address=134324268, size=18, name='vfs_openpie_file_fileno', path='build/openpie_vfs.o', has_indirect=False)
    abstract protected void vfs_openpie_file_fileno(int offset) throws Exception;

    // function: Function(address=134324286, size=14, name='SVC_CALL_VFS', path='build/openpie_vfs.o', has_indirect=False)
    abstract protected void SVC_CALL_VFS(int offset) throws Exception;

    // function: Function(address=134324300, size=16, name='SVC_CALL_VFS_OUT', path='build/openpie_vfs.o', has_indirect=False)
    abstract protected void SVC_CALL_VFS_OUT(int offset) throws Exception;

    // function: Function(address=134324316, size=126, name='vfs_openpie_file_ioctl', path='build/openpie_vfs.o', has_indirect=False)
    abstract protected void vfs_openpie_file_ioctl(int offset) throws Exception;

    // function: Function(address=134324442, size=54, name='vfs_openpie_file_write', path='build/openpie_vfs.o', has_indirect=False)
    abstract protected void vfs_openpie_file_write(int offset) throws Exception;

    // function: Function(address=134324496, size=52, name='vfs_openpie_file_read', path='build/openpie_vfs.o', has_indirect=False)
    abstract protected void vfs_openpie_file_read(int offset) throws Exception;

    // function: Function(address=134324548, size=92, name='mp_vfs_openpie_file_open', path='build/openpie_vfs.o', has_indirect=False)
    abstract protected void mp_vfs_openpie_file_open(int offset) throws Exception;

    // function: Function(address=134324640, size=48, name='vfs_openpie_file_make_new', path='build/openpie_vfs.o', has_indirect=False)
    abstract protected void vfs_openpie_file_make_new(int offset) throws Exception;

    // function: Function(address=134324688, size=36, name='gc_helper_get_regs_and_sp', path='build/gchelper_m0.o', has_indirect=False)
    abstract protected void gc_helper_get_regs_and_sp(int offset) throws Exception;

    // function: Function(address=134324724, size=8, name='stdio_obj___exit__', path='build/lib/utils/sys_stdio_mphal.o', has_indirect=False)
    abstract protected void stdio_obj___exit__(int offset) throws Exception;

    // function: Function(address=134324732, size=16, name='stdio_obj_print', path='build/lib/utils/sys_stdio_mphal.o', has_indirect=False)
    abstract protected void stdio_obj_print(int offset) throws Exception;

    // function: Function(address=134324748, size=16, name='stdio_buffer_write', path='build/lib/utils/sys_stdio_mphal.o', has_indirect=False)
    abstract protected void stdio_buffer_write(int offset) throws Exception;

    // function: Function(address=134324764, size=26, name='stdio_buffer_read', path='build/lib/utils/sys_stdio_mphal.o', has_indirect=False)
    abstract protected void stdio_buffer_read(int offset) throws Exception;

    // function: Function(address=134324790, size=36, name='stdio_write', path='build/lib/utils/sys_stdio_mphal.o', has_indirect=False)
    abstract protected void stdio_write(int offset) throws Exception;

    // function: Function(address=134324826, size=50, name='stdio_read', path='build/lib/utils/sys_stdio_mphal.o', has_indirect=False)
    abstract protected void stdio_read(int offset) throws Exception;

    // function: Function(address=134324876, size=44, name='mp_hal_stdout_tx_strn_cooked', path='build/lib/utils/stdout_helpers.o', has_indirect=False)
    abstract protected void mp_hal_stdout_tx_strn_cooked(int offset) throws Exception;

    // function: Function(address=134324920, size=18, name='mp_hal_stdout_tx_str', path='build/lib/utils/stdout_helpers.o', has_indirect=False)
    abstract protected void mp_hal_stdout_tx_str(int offset) throws Exception;

    // function: Function(address=134324940, size=28, name='mp_hal_set_interrupt_char', path='build/lib/utils/interrupt_char.o', has_indirect=False)
    abstract protected void mp_hal_set_interrupt_char(int offset) throws Exception;

    // function: Function(address=134324968, size=308, name='parse_compile_execute', path='build/lib/utils/pyexec.o', has_indirect=False)
    abstract protected void parse_compile_execute(int offset) throws Exception;

    // function: Function(address=134325276, size=160, name='pyexec_raw_repl', path='build/lib/utils/pyexec.o', has_indirect=False)
    abstract protected void pyexec_raw_repl(int offset) throws Exception;

    // function: Function(address=134325436, size=272, name='pyexec_friendly_repl', path='build/lib/utils/pyexec.o', has_indirect=False)
    abstract protected void pyexec_friendly_repl(int offset) throws Exception;

    // function: Function(address=134325708, size=60, name='pyexec_frozen_module', path='build/lib/utils/pyexec.o', has_indirect=False)
    abstract protected void pyexec_frozen_module(int offset) throws Exception;

    // function: Function(address=134325768, size=70, name='memcpy', path='build/lib/libc/string0.o', has_indirect=False)
    abstract protected void memcpy(int offset) throws Exception;

    // function: Function(address=134325838, size=36, name='memmove', path='build/lib/libc/string0.o', has_indirect=False)
    abstract protected void memmove(int offset) throws Exception;

    // function: Function(address=134325874, size=64, name='memset', path='build/lib/libc/string0.o', has_indirect=False)
    abstract protected void memset(int offset) throws Exception;

    // function: Function(address=134325938, size=36, name='memcmp', path='build/lib/libc/string0.o', has_indirect=False)
    abstract protected void memcmp(int offset) throws Exception;

    // function: Function(address=134325974, size=18, name='strlen', path='build/lib/libc/string0.o', has_indirect=False)
    abstract protected void strlen(int offset) throws Exception;

    // function: Function(address=134325992, size=46, name='strcmp', path='build/lib/libc/string0.o', has_indirect=False)
    abstract protected void strcmp(int offset) throws Exception;

    // function: Function(address=134326038, size=68, name='strncmp', path='build/lib/libc/string0.o', has_indirect=False)
    abstract protected void strncmp(int offset) throws Exception;

    // function: Function(address=134326106, size=24, name='strchr', path='build/lib/libc/string0.o', has_indirect=False)
    abstract protected void strchr(int offset) throws Exception;

    // function: Function(address=134326132, size=48, name='mp_hal_move_cursor_back', path='build/lib/mp-readline/readline.o', has_indirect=False)
    abstract protected void mp_hal_move_cursor_back(int offset) throws Exception;

    // function: Function(address=134326180, size=36, name='readline_init', path='build/lib/mp-readline/readline.o', has_indirect=False)
    abstract protected void readline_init(int offset) throws Exception;

    // function: Function(address=134326216, size=96, name='readline_push_history', path='build/lib/mp-readline/readline.o', has_indirect=False)
    abstract protected void readline_push_history(int offset) throws Exception;

    // function: Function(address=134326312, size=628, name='readline_process_char', path='build/lib/mp-readline/readline.o', has_indirect=False)
    abstract protected void readline_process_char(int offset) throws Exception;

    // function: Function(address=134326940, size=20, name='readline', path='build/lib/mp-readline/readline.o', has_indirect=False)
    abstract protected void readline(int offset) throws Exception;

    // function: Function(address=134326960, size=98, name='scalbnf', path='build/lib/libm/math.o', has_indirect=False)
    abstract protected void scalbnf(int offset) throws Exception;

    // function: Function(address=134327060, size=1696, name='powf', path='build/lib/libm/math.o', has_indirect=True)
    abstract protected void powf(int offset) throws Exception;

    // function: Function(address=134328756, size=344, name='expf', path='build/lib/libm/math.o', has_indirect=True)
    abstract protected void expf(int offset) throws Exception;

    // function: Function(address=134329100, size=664, name='expm1f', path='build/lib/libm/math.o', has_indirect=True)
    abstract protected void expm1f(int offset) throws Exception;

    // function: Function(address=134329764, size=36, name='__expo2f', path='build/lib/libm/math.o', has_indirect=False)
    abstract protected void __expo2f(int offset) throws Exception;

    // function: Function(address=134329800, size=340, name='logf', path='build/lib/libm/math.o', has_indirect=False)
    abstract protected void logf(int offset) throws Exception;

    // function: Function(address=134330140, size=20, name='log10f', path='build/lib/libm/math.o', has_indirect=True)
    abstract protected void log10f(int offset) throws Exception;

    // function: Function(address=134330160, size=144, name='coshf', path='build/lib/libm/math.o', has_indirect=True)
    abstract protected void coshf(int offset) throws Exception;

    // function: Function(address=134330304, size=160, name='sinhf', path='build/lib/libm/math.o', has_indirect=True)
    abstract protected void sinhf(int offset) throws Exception;

    // function: Function(address=134330464, size=76, name='tanhf', path='build/lib/libm/math.o', has_indirect=True)
    abstract protected void tanhf(int offset) throws Exception;

    // function: Function(address=134330540, size=88, name='ceilf', path='build/lib/libm/math.o', has_indirect=False)
    abstract protected void ceilf(int offset) throws Exception;

    // function: Function(address=134330628, size=88, name='floorf', path='build/lib/libm/math.o', has_indirect=False)
    abstract protected void floorf(int offset) throws Exception;

    // function: Function(address=134330716, size=48, name='truncf', path='build/lib/libm/math.o', has_indirect=False)
    abstract protected void truncf(int offset) throws Exception;

    // function: Function(address=134330764, size=160, name='acoshf', path='build/lib/libm/acoshf.o', has_indirect=True)
    abstract protected void acoshf(int offset) throws Exception;

    // function: Function(address=134330924, size=80, name='text_R', path='build/lib/libm/asinfacosf.o', has_indirect=False)
    abstract protected void text_R(int offset) throws Exception;

    // function: Function(address=134331004, size=196, name='asinf', path='build/lib/libm/asinfacosf.o', has_indirect=True)
    abstract protected void asinf(int offset) throws Exception;

    // function: Function(address=134331200, size=288, name='acosf', path='build/lib/libm/asinfacosf.o', has_indirect=True)
    abstract protected void acosf(int offset) throws Exception;

    // function: Function(address=134331488, size=200, name='asinhf', path='build/lib/libm/asinhf.o', has_indirect=True)
    abstract protected void asinhf(int offset) throws Exception;

    // function: Function(address=134331688, size=304, name='atan2f', path='build/lib/libm/atan2f.o', has_indirect=True)
    abstract protected void atan2f(int offset) throws Exception;

    // function: Function(address=134331992, size=456, name='atanf', path='build/lib/libm/atanf.o', has_indirect=True)
    abstract protected void atanf(int offset) throws Exception;

    // function: Function(address=134332448, size=144, name='atanhf', path='build/lib/libm/atanhf.o', has_indirect=True)
    abstract protected void atanhf(int offset) throws Exception;

    // function: Function(address=134332592, size=692, name='__ieee754_rem_pio2f', path='build/lib/libm/ef_rem_pio2.o', has_indirect=False)
    abstract protected void __ieee754_rem_pio2f(int offset) throws Exception;

    // function: Function(address=134333284, size=176, name='sqrtf', path='build/lib/libm/ef_sqrt.o', has_indirect=True)
    abstract protected void sqrtf(int offset) throws Exception;

    // function: Function(address=134333460, size=1976, name='__ieee754_lgammaf_r', path='build/lib/libm/erf_lgamma.o', has_indirect=False)
    abstract protected void __ieee754_lgammaf_r(int offset) throws Exception;

    // function: Function(address=134335436, size=208, name='fmodf', path='build/lib/libm/fmodf.o', has_indirect=True)
    abstract protected void fmodf(int offset) throws Exception;

    // function: Function(address=134335644, size=260, name='__kernel_cosf', path='build/lib/libm/kf_cos.o', has_indirect=False)
    abstract protected void __kernel_cosf(int offset) throws Exception;

    // function: Function(address=134335904, size=1428, name='__kernel_rem_pio2f', path='build/lib/libm/kf_rem_pio2.o', has_indirect=False)
    abstract protected void __kernel_rem_pio2f(int offset) throws Exception;

    // function: Function(address=134337332, size=236, name='__kernel_sinf', path='build/lib/libm/kf_sin.o', has_indirect=False)
    abstract protected void __kernel_sinf(int offset) throws Exception;

    // function: Function(address=134337568, size=604, name='__kernel_tanf', path='build/lib/libm/kf_tan.o', has_indirect=False)
    abstract protected void __kernel_tanf(int offset) throws Exception;

    // function: Function(address=134338172, size=448, name='log1pf', path='build/lib/libm/log1pf.o', has_indirect=False)
    abstract protected void log1pf(int offset) throws Exception;

    // function: Function(address=134338620, size=74, name='nearbyintf', path='build/lib/libm/nearbyintf.o', has_indirect=False)
    abstract protected void nearbyintf(int offset) throws Exception;

    // function: Function(address=134338696, size=108, name='cosf', path='build/lib/libm/sf_cos.o', has_indirect=True)
    abstract protected void cosf(int offset) throws Exception;

    // function: Function(address=134338804, size=1208, name='erff', path='build/lib/libm/sf_erf.o', has_indirect=True)
    abstract protected void erff(int offset) throws Exception;

    // function: Function(address=134340012, size=1212, name='erfcf', path='build/lib/libm/sf_erf.o', has_indirect=True)
    abstract protected void erfcf(int offset) throws Exception;

    // function: Function(address=134341224, size=84, name='frexpf', path='build/lib/libm/sf_frexp.o', has_indirect=False)
    abstract protected void frexpf(int offset) throws Exception;

    // function: Function(address=134341308, size=64, name='ldexpf', path='build/lib/libm/sf_ldexp.o', has_indirect=False)
    abstract protected void ldexpf(int offset) throws Exception;

    // function: Function(address=134341372, size=68, name='modff', path='build/lib/libm/sf_modf.o', has_indirect=False)
    abstract protected void modff(int offset) throws Exception;

    // function: Function(address=134341440, size=112, name='sinf', path='build/lib/libm/sf_sin.o', has_indirect=True)
    abstract protected void sinf(int offset) throws Exception;

    // function: Function(address=134341552, size=68, name='tanf', path='build/lib/libm/sf_tan.o', has_indirect=True)
    abstract protected void tanf(int offset) throws Exception;

    // function: Function(address=134341620, size=10, name='lgammaf', path='build/lib/libm/wf_lgamma.o', has_indirect=True)
    abstract protected void lgammaf(int offset) throws Exception;

    // function: Function(address=134341630, size=26, name='tgammaf', path='build/lib/libm/wf_tgamma.o', has_indirect=True)
    abstract protected void tgammaf(int offset) throws Exception;

    // function: Function(address=134341656, size=276, name='__aeabi_uidiv', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(_udivsi3.o)', has_indirect=False)
    abstract protected void __aeabi_uidiv(int offset) throws Exception;

    // function: Function(address=134341924, size=8, name='__aeabi_uidivmod', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(_udivsi3.o)', has_indirect=False)
    abstract protected void __aeabi_uidivmod(int offset) throws Exception;

    // function: Function(address=134341932, size=468, name='__divsi3', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(_divsi3.o)', has_indirect=False)
    abstract protected void __divsi3(int offset) throws Exception;

    // function: Function(address=134342392, size=8, name='__aeabi_idivmod', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(_divsi3.o)', has_indirect=False)
    abstract protected void __aeabi_idivmod(int offset) throws Exception;

    // function: Function(address=134342400, size=4, name='__aeabi_idiv0', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(_dvmd_tls.o)', has_indirect=False)
    abstract protected void __aeabi_idiv0(int offset) throws Exception;

    // function: Function(address=134342404, size=116, name='__aeabi_cfrcmple', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(_arm_cmpsf2.o)', has_indirect=False)
    abstract protected void __aeabi_cfrcmple(int offset) throws Exception;

    // function: Function(address=134342412, size=16, name='__aeabi_cfcmpeq', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(_arm_cmpsf2.o)', has_indirect=False)
    abstract protected void __aeabi_cfcmpeq(int offset) throws Exception;

    // function: Function(address=134342428, size=12, name='__aeabi_fcmpeq', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(_arm_cmpsf2.o)', has_indirect=False)
    abstract protected void __aeabi_fcmpeq(int offset) throws Exception;

    // function: Function(address=134342440, size=20, name='__aeabi_fcmplt', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(_arm_cmpsf2.o)', has_indirect=False)
    abstract protected void __aeabi_fcmplt(int offset) throws Exception;

    // function: Function(address=134342460, size=20, name='__aeabi_fcmple', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(_arm_cmpsf2.o)', has_indirect=False)
    abstract protected void __aeabi_fcmple(int offset) throws Exception;

    // function: Function(address=134342480, size=20, name='__aeabi_fcmpgt', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(_arm_cmpsf2.o)', has_indirect=False)
    abstract protected void __aeabi_fcmpgt(int offset) throws Exception;

    // function: Function(address=134342500, size=20, name='__aeabi_fcmpge', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(_arm_cmpsf2.o)', has_indirect=False)
    abstract protected void __aeabi_fcmpge(int offset) throws Exception;

    // function: Function(address=134342520, size=48, name='__fixunssfsi', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(_fixunssfsi.o)', has_indirect=False)
    abstract protected void __fixunssfsi(int offset) throws Exception;

    // function: Function(address=134342568, size=820, name='__aeabi_fadd', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(addsf3.o)', has_indirect=False)
    abstract protected void __aeabi_fadd(int offset) throws Exception;

    // function: Function(address=134343388, size=548, name='__aeabi_fdiv', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(divsf3.o)', has_indirect=False)
    abstract protected void __aeabi_fdiv(int offset) throws Exception;

    // function: Function(address=134343936, size=80, name='__eqsf2', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(eqsf2.o)', has_indirect=False)
    abstract protected void __eqsf2(int offset) throws Exception;

    // function: Function(address=134344016, size=156, name='__gesf2', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(gesf2.o)', has_indirect=False)
    abstract protected void __gesf2(int offset) throws Exception;

    // function: Function(address=134344172, size=160, name='__ltsf2', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(lesf2.o)', has_indirect=False)
    abstract protected void __ltsf2(int offset) throws Exception;

    // function: Function(address=134344332, size=612, name='__aeabi_fmul', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(mulsf3.o)', has_indirect=False)
    abstract protected void __aeabi_fmul(int offset) throws Exception;

    // function: Function(address=134344944, size=904, name='__aeabi_fsub', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(subsf3.o)', has_indirect=False)
    abstract protected void __aeabi_fsub(int offset) throws Exception;

    // function: Function(address=134345848, size=44, name='__aeabi_fcmpun', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(unordsf2.o)', has_indirect=False)
    abstract protected void __aeabi_fcmpun(int offset) throws Exception;

    // function: Function(address=134345892, size=64, name='__aeabi_f2iz', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(fixsfsi.o)', has_indirect=False)
    abstract protected void __aeabi_f2iz(int offset) throws Exception;

    // function: Function(address=134345956, size=148, name='__aeabi_i2f', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(floatsisf.o)', has_indirect=False)
    abstract protected void __aeabi_i2f(int offset) throws Exception;

    // function: Function(address=134346104, size=128, name='__aeabi_ui2f', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(floatunsisf.o)', has_indirect=False)
    abstract protected void __aeabi_ui2f(int offset) throws Exception;

    // function: Function(address=134346232, size=116, name='__aeabi_i2d', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(floatsidf.o)', has_indirect=False)
    abstract protected void __aeabi_i2d(int offset) throws Exception;

    // function: Function(address=134346348, size=164, name='__aeabi_f2d', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(extendsfdf2.o)', has_indirect=False)
    abstract protected void __aeabi_f2d(int offset) throws Exception;

    // function: Function(address=134346512, size=264, name='__aeabi_d2f', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(truncdfsf2.o)', has_indirect=False)
    abstract protected void __aeabi_d2f(int offset) throws Exception;

    // function: Function(address=134346776, size=60, name='__clzsi2', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(_clzsi2.o)', has_indirect=False)
    abstract protected void __clzsi2(int offset) throws Exception;

} // MicroPython_link
