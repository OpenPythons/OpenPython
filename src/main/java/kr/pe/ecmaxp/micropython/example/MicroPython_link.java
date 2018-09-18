package kr.pe.ecmaxp.micropython.example;

import kotlin.Pair;
import kr.pe.ecmaxp.thumbjk.Callback;
import kr.pe.ecmaxp.thumbjk.KotlinCPU;
import kr.pe.ecmaxp.thumbjk.InterruptHandler;
import kr.pe.ecmaxp.thumbsk.Memory;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

import static kr.pe.ecmaxp.thumbsk.helper.RegisterIndex.*;

abstract public class MicroPython_link extends KotlinCPU
{
    public MicroPython_link(@NotNull Memory memory)
    {
        super(memory);
    }

    private void gen_hints_1() {
        hint(nlr_push_tail, this::nlr_push_tail, 0);
        hint(nlr_pop, this::nlr_pop, 0);
        hint(nlr_push, this::nlr_push, 0);
        hint(nlr_jump, this::nlr_jump, 0);
        hint(nlr_jump, this::nlr_jump, 14);
        hint(m_malloc, this::m_malloc, 0);
        hint(m_malloc, this::m_malloc, 10);
        hint(m_malloc, this::m_malloc, 24);
        hint(m_malloc_maybe, this::m_malloc_maybe, 0);
        hint(m_malloc_maybe, this::m_malloc_maybe, 10);
        hint(m_malloc0, this::m_malloc0, 0);
        hint(m_malloc0, this::m_malloc0, 6);
        hint(m_realloc, this::m_realloc, 0);
        hint(m_realloc, this::m_realloc, 14);
        hint(m_realloc, this::m_realloc, 28);
        hint(m_realloc_maybe, this::m_realloc_maybe, 0);
        hint(m_realloc_maybe, this::m_realloc_maybe, 14);
        hint(m_free, this::m_free, 0);
        hint(m_free, this::m_free, 8);
        hint(m_get_total_bytes_allocated, this::m_get_total_bytes_allocated, 0);
        hint(m_get_current_bytes_allocated, this::m_get_current_bytes_allocated, 0);
        hint(m_get_peak_bytes_allocated, this::m_get_peak_bytes_allocated, 0);
        hint(gc_mark_subtree, this::gc_mark_subtree, 0);
        hint(gc_init, this::gc_init, 0);
        hint(gc_init, this::gc_init, 26);
        hint(gc_init, this::gc_init, 74);
        hint(gc_init, this::gc_init, 90);
        hint(gc_lock, this::gc_lock, 0);
        hint(gc_unlock, this::gc_unlock, 0);
        hint(gc_is_locked, this::gc_is_locked, 0);
        hint(gc_collect_start, this::gc_collect_start, 0);
        hint(gc_collect_start, this::gc_collect_start, 252);
        hint(gc_collect_start, this::gc_collect_start, 270);
        hint(gc_collect_root, this::gc_collect_root, 0);
        hint(gc_collect_root, this::gc_collect_root, 128);
        hint(gc_collect_end, this::gc_collect_end, 0);
        hint(gc_collect_end, this::gc_collect_end, 94);
        hint(gc_collect_end, this::gc_collect_end, 310);
        hint(gc_collect_end, this::gc_collect_end, 320);
        hint(gc_collect_end, this::gc_collect_end, 328);
        hint(gc_collect_end, this::gc_collect_end, 332);
        hint(gc_info, this::gc_info, 0);
        hint(gc_alloc, this::gc_alloc, 0);
        hint(gc_alloc, this::gc_alloc, 190);
        hint(gc_alloc, this::gc_alloc, 380);
        hint(gc_free, this::gc_free, 0);
        hint(gc_nbytes, this::gc_nbytes, 0);
        hint(gc_realloc, this::gc_realloc, 0);
        hint(gc_realloc, this::gc_realloc, 236);
        hint(gc_realloc, this::gc_realloc, 478);
        hint(gc_realloc, this::gc_realloc, 522);
        hint(gc_realloc, this::gc_realloc, 538);
        hint(gc_dump_info, this::gc_dump_info, 0);
        hint(gc_dump_info, this::gc_dump_info, 222);
        hint(gc_dump_info, this::gc_dump_info, 238);
        hint(gc_dump_alloc_table, this::gc_dump_alloc_table, 0);
        hint(gc_dump_alloc_table, this::gc_dump_alloc_table, 34);
        hint(gc_dump_alloc_table, this::gc_dump_alloc_table, 96);
        hint(gc_dump_alloc_table, this::gc_dump_alloc_table, 194);
        hint(gc_dump_alloc_table, this::gc_dump_alloc_table, 232);
        hint(gc_dump_alloc_table, this::gc_dump_alloc_table, 336);
        hint(mp_pystack_init, this::mp_pystack_init, 0);
        hint(mp_pystack_alloc, this::mp_pystack_alloc, 0);
        hint(mp_pystack_alloc, this::mp_pystack_alloc, 30);
        hint(mp_pystack_alloc, this::mp_pystack_alloc, 34);
        hint(find_qstr, this::find_qstr, 0);
        hint(qstr_compute_hash, this::qstr_compute_hash, 0);
        hint(qstr_init, this::qstr_init, 0);
        hint(qstr_find_strn, this::qstr_find_strn, 0);
        hint(qstr_find_strn, this::qstr_find_strn, 12);
        hint(qstr_find_strn, this::qstr_find_strn, 82);
        hint(qstr_from_strn, this::qstr_from_strn, 0);
        hint(qstr_from_strn, this::qstr_from_strn, 12);
        hint(qstr_from_strn, this::qstr_from_strn, 58);
        hint(qstr_from_strn, this::qstr_from_strn, 84);
        hint(qstr_from_strn, this::qstr_from_strn, 112);
        hint(qstr_from_strn, this::qstr_from_strn, 126);
        hint(qstr_from_strn, this::qstr_from_strn, 142);
        hint(qstr_from_strn, this::qstr_from_strn, 188);
        hint(qstr_from_strn, this::qstr_from_strn, 210);
        hint(qstr_from_strn, this::qstr_from_strn, 234);
        hint(qstr_from_str, this::qstr_from_str, 0);
        hint(qstr_from_str, this::qstr_from_str, 8);
        hint(qstr_from_str, this::qstr_from_str, 16);
        hint(qstr_hash, this::qstr_hash, 0);
        hint(qstr_hash, this::qstr_hash, 6);
        hint(qstr_len, this::qstr_len, 0);
        hint(qstr_len, this::qstr_len, 6);
        hint(qstr_str, this::qstr_str, 0);
        hint(qstr_str, this::qstr_str, 6);
        hint(qstr_data, this::qstr_data, 0);
        hint(qstr_data, this::qstr_data, 8);
        hint(qstr_pool_info, this::qstr_pool_info, 0);
        hint(qstr_pool_info, this::qstr_pool_info, 86);
        hint(qstr_dump_data, this::qstr_dump_data, 0);
        hint(qstr_dump_data, this::qstr_dump_data, 48);
        hint(vstr_ensure_extra, this::vstr_ensure_extra, 0);
        hint(vstr_ensure_extra, this::vstr_ensure_extra, 28);
        hint(vstr_ensure_extra, this::vstr_ensure_extra, 44);
        hint(vstr_add_strn, this::vstr_add_strn, 0);
        hint(vstr_add_strn, this::vstr_add_strn, 14);
        hint(vstr_add_strn, this::vstr_add_strn, 28);
        hint(vstr_ins_blank_bytes_constprop_2, this::vstr_ins_blank_bytes_constprop_2, 0);
        hint(vstr_ins_blank_bytes_constprop_2, this::vstr_ins_blank_bytes_constprop_2, 22);
        hint(vstr_ins_blank_bytes_constprop_2, this::vstr_ins_blank_bytes_constprop_2, 36);
        hint(vstr_init, this::vstr_init, 0);
        hint(vstr_init, this::vstr_init, 22);
        hint(vstr_init_len, this::vstr_init_len, 0);
        hint(vstr_init_len, this::vstr_init_len, 12);
        hint(vstr_init_fixed_buf, this::vstr_init_fixed_buf, 0);
        hint(vstr_init_print, this::vstr_init_print, 0);
        hint(vstr_init_print, this::vstr_init_print, 10);
        hint(vstr_clear, this::vstr_clear, 0);
        hint(vstr_clear, this::vstr_clear, 18);
        hint(vstr_new, this::vstr_new, 0);
        hint(vstr_new, this::vstr_new, 10);
        hint(vstr_new, this::vstr_new, 18);
        hint(vstr_free, this::vstr_free, 0);
        hint(vstr_free, this::vstr_free, 20);
        hint(vstr_free, this::vstr_free, 28);
        hint(vstr_extend, this::vstr_extend, 0);
        hint(vstr_extend, this::vstr_extend, 20);
        hint(vstr_extend, this::vstr_extend, 32);
        hint(vstr_add_len, this::vstr_add_len, 0);
        hint(vstr_add_len, this::vstr_add_len, 10);
        hint(vstr_null_terminated_str, this::vstr_null_terminated_str, 0);
        hint(vstr_null_terminated_str, this::vstr_null_terminated_str, 18);
        hint(vstr_add_byte, this::vstr_add_byte, 0);
        hint(vstr_add_byte, this::vstr_add_byte, 10);
        hint(vstr_add_char, this::vstr_add_char, 0);
        hint(vstr_add_char, this::vstr_add_char, 16);
        hint(vstr_add_char, this::vstr_add_char, 50);
        hint(vstr_add_char, this::vstr_add_char, 94);
        hint(vstr_add_char, this::vstr_add_char, 116);
        hint(vstr_add_str, this::vstr_add_str, 0);
        hint(vstr_add_str, this::vstr_add_str, 12);
        hint(vstr_add_str, this::vstr_add_str, 22);
        hint(vstr_ins_byte, this::vstr_ins_byte, 0);
        hint(vstr_ins_byte, this::vstr_ins_byte, 8);
        hint(vstr_ins_char, this::vstr_ins_char, 0);
        hint(vstr_ins_char, this::vstr_ins_char, 8);
        hint(vstr_cut_tail_bytes, this::vstr_cut_tail_bytes, 0);
        hint(vstr_cut_out_bytes, this::vstr_cut_out_bytes, 0);
        hint(vstr_cut_out_bytes, this::vstr_cut_out_bytes, 38);
        hint(plat_print_strn, this::plat_print_strn, 0);
        hint(plat_print_strn, this::plat_print_strn, 10);
        hint(mp_print_str, this::mp_print_str, 0);
        hint(mp_print_str, this::mp_print_str, 12);
        hint(mp_print_str, this::mp_print_str, 26);
        hint(mp_print_strn, this::mp_print_strn, 0);
        hint(mp_print_strn, this::mp_print_strn, 80);
        hint(mp_print_strn, this::mp_print_strn, 104);
        hint(mp_print_strn, this::mp_print_strn, 132);
        hint(mp_print_int, this::mp_print_int, 0);
        hint(mp_print_int, this::mp_print_int, 56);
        hint(mp_print_int, this::mp_print_int, 158);
        hint(mp_print_int, this::mp_print_int, 188);
        hint(mp_print_mp_int, this::mp_print_mp_int, 0);
        hint(mp_print_mp_int, this::mp_print_mp_int, 42);
        hint(mp_print_mp_int, this::mp_print_mp_int, 80);
        hint(mp_print_mp_int, this::mp_print_mp_int, 220);
        hint(mp_print_mp_int, this::mp_print_mp_int, 294);
        hint(mp_print_mp_int, this::mp_print_mp_int, 362);
        hint(mp_print_mp_int, this::mp_print_mp_int, 394);
        hint(mp_print_mp_int, this::mp_print_mp_int, 426);
        hint(mp_print_mp_int, this::mp_print_mp_int, 466);
        hint(mp_print_mp_int, this::mp_print_mp_int, 490);
        hint(mp_print_mp_int, this::mp_print_mp_int, 506);
        hint(mp_print_float, this::mp_print_float, 0);
        hint(mp_print_float, this::mp_print_float, 46);
        hint(mp_print_float, this::mp_print_float, 98);
        hint(mp_print_float, this::mp_print_float, 132);
        hint(mp_vprintf, this::mp_vprintf, 0);
        hint(mp_vprintf, this::mp_vprintf, 90);
        hint(mp_vprintf, this::mp_vprintf, 314);
        hint(mp_vprintf, this::mp_vprintf, 424);
        hint(mp_vprintf, this::mp_vprintf, 472);
        hint(mp_vprintf, this::mp_vprintf, 534);
        hint(mp_vprintf, this::mp_vprintf, 610);
        hint(mp_vprintf, this::mp_vprintf, 632);
        hint(mp_vprintf, this::mp_vprintf, 654);
        hint(mp_printf, this::mp_printf, 0);
        hint(mp_printf, this::mp_printf, 14);
        hint(utf8_get_char, this::utf8_get_char, 0);
        hint(utf8_next_char, this::utf8_next_char, 0);
        hint(utf8_ptr_to_index, this::utf8_ptr_to_index, 0);
        hint(utf8_charlen, this::utf8_charlen, 0);
        hint(unichar_isspace, this::unichar_isspace, 0);
        hint(unichar_isalpha, this::unichar_isalpha, 0);
        hint(unichar_isdigit, this::unichar_isdigit, 0);
        hint(unichar_isxdigit, this::unichar_isxdigit, 0);
        hint(unichar_isident, this::unichar_isident, 0);
        hint(unichar_isupper, this::unichar_isupper, 0);
        hint(unichar_islower, this::unichar_islower, 0);
        hint(unichar_tolower, this::unichar_tolower, 0);
        hint(unichar_tolower, this::unichar_tolower, 8);
        hint(unichar_toupper, this::unichar_toupper, 0);
        hint(unichar_toupper, this::unichar_toupper, 8);
        hint(unichar_xdigit_value, this::unichar_xdigit_value, 0);
        hint(utf8_check, this::utf8_check, 0);
        hint(mpn_remove_trailing_zeros, this::mpn_remove_trailing_zeros, 0);
        hint(text_mpn_shr, this::text_mpn_shr, 0);
        hint(text_mpn_add, this::text_mpn_add, 0);
        hint(text_mpn_sub, this::text_mpn_sub, 0);
        hint(text_mpn_sub, this::text_mpn_sub, 40);
        hint(mpn_xor_neg, this::mpn_xor_neg, 0);
        hint(mpn_xor_neg, this::mpn_xor_neg, 40);
        hint(mpz_need_dig, this::mpz_need_dig, 0);
        hint(mpz_need_dig, this::mpz_need_dig, 34);
        hint(mpz_clone, this::mpz_clone, 0);
        hint(mpz_clone, this::mpz_clone, 10);
        hint(mpz_clone, this::mpz_clone, 58);
        hint(mpz_clone, this::mpz_clone, 72);
        hint(mpn_cmp_part_1, this::mpn_cmp_part_1, 0);
        hint(mpz_free, this::mpz_free, 0);
        hint(mpz_free, this::mpz_free, 18);
        hint(mpz_free, this::mpz_free, 26);
        hint(mpz_set_from_int_part_4, this::mpz_set_from_int_part_4, 0);
        hint(mpz_set_from_int_part_4, this::mpz_set_from_int_part_4, 12);
        hint(mpz_init_zero, this::mpz_init_zero, 0);
        hint(mpz_deinit, this::mpz_deinit, 0);
        hint(mpz_deinit, this::mpz_deinit, 24);
        hint(mpz_set, this::mpz_set, 0);
        hint(mpz_set, this::mpz_set, 12);
        hint(mpz_set, this::mpz_set, 44);
        hint(mpz_set_from_int, this::mpz_set_from_int, 0);
        hint(mpz_set_from_int, this::mpz_set_from_int, 14);
        hint(mpz_init_from_int, this::mpz_init_from_int, 0);
        hint(mpz_init_from_int, this::mpz_init_from_int, 10);
        hint(mpz_init_from_int, this::mpz_init_from_int, 18);
        hint(mpz_init_fixed_from_int, this::mpz_init_fixed_from_int, 0);
        hint(mpz_init_fixed_from_int, this::mpz_init_fixed_from_int, 40);
        hint(mpz_set_from_ll, this::mpz_set_from_ll, 0);
        hint(mpz_set_from_ll, this::mpz_set_from_ll, 18);
        hint(mpz_set_from_float, this::mpz_set_from_float, 0);
        hint(mpz_set_from_float, this::mpz_set_from_float, 58);
        hint(mpz_set_from_float, this::mpz_set_from_float, 108);
        hint(mpz_set_from_float, this::mpz_set_from_float, 130);
        hint(mpz_set_from_str, this::mpz_set_from_str, 0);
        hint(mpz_set_from_str, this::mpz_set_from_str, 24);
        hint(mpz_set_from_bytes, this::mpz_set_from_bytes, 0);
        hint(mpz_set_from_bytes, this::mpz_set_from_bytes, 32);
        hint(mpz_set_from_bytes, this::mpz_set_from_bytes, 62);
        hint(mpz_cmp, this::mpz_cmp, 0);
        hint(mpz_cmp, this::mpz_cmp, 56);
        hint(mpz_abs_inpl, this::mpz_abs_inpl, 0);
        hint(mpz_abs_inpl, this::mpz_abs_inpl, 12);
        hint(mpz_neg_inpl, this::mpz_neg_inpl, 0);
        hint(mpz_neg_inpl, this::mpz_neg_inpl, 12);
        hint(mpz_not_inpl, this::mpz_not_inpl, 0);
        hint(mpz_not_inpl, this::mpz_not_inpl, 12);
        hint(mpz_not_inpl, this::mpz_not_inpl, 26);
        hint(mpz_not_inpl, this::mpz_not_inpl, 72);
        hint(mpz_not_inpl, this::mpz_not_inpl, 84);
        hint(mpz_not_inpl, this::mpz_not_inpl, 100);
        hint(mpz_shl_inpl, this::mpz_shl_inpl, 0);
        hint(mpz_shl_inpl, this::mpz_shl_inpl, 28);
        hint(mpz_shl_inpl, this::mpz_shl_inpl, 44);
        hint(mpz_shl_inpl, this::mpz_shl_inpl, 130);
        hint(mpz_shr_inpl, this::mpz_shr_inpl, 0);
        hint(mpz_shr_inpl, this::mpz_shr_inpl, 28);
        hint(mpz_shr_inpl, this::mpz_shr_inpl, 36);
        hint(mpz_shr_inpl, this::mpz_shr_inpl, 48);
        hint(mpz_shr_inpl, this::mpz_shr_inpl, 180);
        hint(mpz_add_inpl, this::mpz_add_inpl, 0);
        hint(mpz_add_inpl, this::mpz_add_inpl, 26);
        hint(mpz_add_inpl, this::mpz_add_inpl, 56);
        hint(mpz_add_inpl, this::mpz_add_inpl, 72);
        hint(mpz_add_inpl, this::mpz_add_inpl, 98);
        hint(mpz_add_inpl, this::mpz_add_inpl, 114);
        hint(mpz_sub_inpl, this::mpz_sub_inpl, 0);
        hint(mpz_sub_inpl, this::mpz_sub_inpl, 30);
        hint(mpz_sub_inpl, this::mpz_sub_inpl, 62);
        hint(mpz_sub_inpl, this::mpz_sub_inpl, 78);
        hint(mpz_sub_inpl, this::mpz_sub_inpl, 112);
        hint(mpz_sub_inpl, this::mpz_sub_inpl, 128);
        hint(mpz_and_inpl, this::mpz_and_inpl, 0);
        hint(mpz_and_inpl, this::mpz_and_inpl, 46);
        hint(mpz_and_inpl, this::mpz_and_inpl, 70);
        hint(mpz_and_inpl, this::mpz_and_inpl, 112);
        hint(mpz_and_inpl, this::mpz_and_inpl, 212);
        hint(mpz_or_inpl, this::mpz_or_inpl, 0);
        hint(mpz_or_inpl, this::mpz_or_inpl, 48);
        hint(mpz_or_inpl, this::mpz_or_inpl, 148);
        hint(mpz_or_inpl, this::mpz_or_inpl, 218);
        hint(mpz_xor_inpl, this::mpz_xor_inpl, 0);
        hint(mpz_xor_inpl, this::mpz_xor_inpl, 46);
        hint(mpz_xor_inpl, this::mpz_xor_inpl, 98);
        hint(mpz_xor_inpl, this::mpz_xor_inpl, 164);
        hint(mpz_xor_inpl, this::mpz_xor_inpl, 174);
        hint(mpz_xor_inpl, this::mpz_xor_inpl, 208);
        hint(mpz_mul_inpl, this::mpz_mul_inpl, 0);
        hint(mpz_mul_inpl, this::mpz_mul_inpl, 40);
        hint(mpz_mul_inpl, this::mpz_mul_inpl, 62);
        hint(mpz_mul_inpl, this::mpz_mul_inpl, 76);
        hint(mpz_mul_inpl, this::mpz_mul_inpl, 144);
        hint(mpz_mul_inpl, this::mpz_mul_inpl, 160);
        hint(mpz_pow_inpl, this::mpz_pow_inpl, 0);
        hint(mpz_pow_inpl, this::mpz_pow_inpl, 38);
        hint(mpz_pow_inpl, this::mpz_pow_inpl, 46);
        hint(mpz_pow_inpl, this::mpz_pow_inpl, 54);
        hint(mpz_pow_inpl, this::mpz_pow_inpl, 64);
        hint(mpz_pow_inpl, this::mpz_pow_inpl, 88);
        hint(mpz_pow_inpl, this::mpz_pow_inpl, 100);
        hint(mpz_pow_inpl, this::mpz_pow_inpl, 112);
        hint(mpz_pow_inpl, this::mpz_pow_inpl, 118);
        hint(mpz_pow_inpl, this::mpz_pow_inpl, 130);
        hint(mpz_divmod_inpl, this::mpz_divmod_inpl, 0);
        hint(mpz_divmod_inpl, this::mpz_divmod_inpl, 20);
        hint(mpz_divmod_inpl, this::mpz_divmod_inpl, 36);
        hint(mpz_divmod_inpl, this::mpz_divmod_inpl, 52);
        hint(mpz_divmod_inpl, this::mpz_divmod_inpl, 60);
        hint(mpz_divmod_inpl, this::mpz_divmod_inpl, 100);
        hint(mpz_divmod_inpl, this::mpz_divmod_inpl, 152);
        hint(mpz_divmod_inpl, this::mpz_divmod_inpl, 162);
        hint(mpz_divmod_inpl, this::mpz_divmod_inpl, 172);
        hint(mpz_divmod_inpl, this::mpz_divmod_inpl, 472);
        hint(mpz_pow3_inpl, this::mpz_pow3_inpl, 0);
        hint(mpz_pow3_inpl, this::mpz_pow3_inpl, 54);
        hint(mpz_pow3_inpl, this::mpz_pow3_inpl, 66);
        hint(mpz_pow3_inpl, this::mpz_pow3_inpl, 74);
        hint(mpz_pow3_inpl, this::mpz_pow3_inpl, 82);
        hint(mpz_pow3_inpl, this::mpz_pow3_inpl, 108);
        hint(mpz_pow3_inpl, this::mpz_pow3_inpl, 120);
        hint(mpz_pow3_inpl, this::mpz_pow3_inpl, 132);
        hint(mpz_pow3_inpl, this::mpz_pow3_inpl, 144);
        hint(mpz_pow3_inpl, this::mpz_pow3_inpl, 150);
        hint(mpz_pow3_inpl, this::mpz_pow3_inpl, 156);
        hint(mpz_pow3_inpl, this::mpz_pow3_inpl, 168);
        hint(mpz_pow3_inpl, this::mpz_pow3_inpl, 180);
        hint(mpz_hash, this::mpz_hash, 0);
        hint(mpz_as_int_checked, this::mpz_as_int_checked, 0);
        hint(mpz_as_bytes, this::mpz_as_bytes, 0);
        hint(mpz_as_float, this::mpz_as_float, 0);
        hint(mpz_as_float, this::mpz_as_float, 44);
        hint(mpz_as_float, this::mpz_as_float, 52);
        hint(mpz_as_float, this::mpz_as_float, 58);
        hint(mpz_as_str_inpl, this::mpz_as_str_inpl, 0);
        hint(mpz_as_str_inpl, this::mpz_as_str_inpl, 76);
        hint(mpz_as_str_inpl, this::mpz_as_str_inpl, 86);
        hint(mpz_as_str_inpl, this::mpz_as_str_inpl, 174);
        hint(mpz_as_str_inpl, this::mpz_as_str_inpl, 184);
        hint(mpz_as_str_inpl, this::mpz_as_str_inpl, 240);
        hint(mp_reader_mem_readbyte, this::mp_reader_mem_readbyte, 0);
        hint(mp_reader_mem_close, this::mp_reader_mem_close, 0);
        hint(mp_reader_mem_close, this::mp_reader_mem_close, 16);
        hint(mp_reader_mem_close, this::mp_reader_mem_close, 24);
        hint(mp_reader_new_mem, this::mp_reader_new_mem, 0);
        hint(mp_reader_new_mem, this::mp_reader_new_mem, 16);
        hint(is_string_or_bytes, this::is_string_or_bytes, 0);
        hint(next_char, this::next_char, 0);
        hint(next_char, this::next_char, 34);
        hint(next_char, this::next_char, 56);
        hint(skip_whitespace, this::skip_whitespace, 0);
        hint(skip_whitespace, this::skip_whitespace, 40);
        hint(skip_whitespace, this::skip_whitespace, 48);
        hint(skip_whitespace, this::skip_whitespace, 58);
        hint(skip_whitespace, this::skip_whitespace, 72);
        hint(skip_whitespace, this::skip_whitespace, 100);
        hint(mp_lexer_to_next, this::mp_lexer_to_next, 0);
        hint(mp_lexer_to_next, this::mp_lexer_to_next, 14);
        hint(mp_lexer_to_next, this::mp_lexer_to_next, 114);
        hint(mp_lexer_to_next, this::mp_lexer_to_next, 190);
        hint(mp_lexer_to_next, this::mp_lexer_to_next, 276);
        hint(mp_lexer_to_next, this::mp_lexer_to_next, 286);
        hint(mp_lexer_to_next, this::mp_lexer_to_next, 304);
        hint(mp_lexer_to_next, this::mp_lexer_to_next, 330);
        hint(mp_lexer_to_next, this::mp_lexer_to_next, 336);
        hint(mp_lexer_to_next, this::mp_lexer_to_next, 378);
        hint(mp_lexer_to_next, this::mp_lexer_to_next, 386);
        hint(mp_lexer_to_next, this::mp_lexer_to_next, 392);
        hint(mp_lexer_to_next, this::mp_lexer_to_next, 446);
        hint(mp_lexer_to_next, this::mp_lexer_to_next, 452);
        hint(mp_lexer_to_next, this::mp_lexer_to_next, 466);
        hint(mp_lexer_to_next, this::mp_lexer_to_next, 484);
        hint(mp_lexer_to_next, this::mp_lexer_to_next, 544);
        hint(mp_lexer_to_next, this::mp_lexer_to_next, 588);
        hint(mp_lexer_to_next, this::mp_lexer_to_next, 666);
        hint(mp_lexer_to_next, this::mp_lexer_to_next, 698);
        hint(mp_lexer_to_next, this::mp_lexer_to_next, 706);
        hint(mp_lexer_to_next, this::mp_lexer_to_next, 718);
        hint(mp_lexer_to_next, this::mp_lexer_to_next, 740);
        hint(mp_lexer_to_next, this::mp_lexer_to_next, 762);
        hint(mp_lexer_to_next, this::mp_lexer_to_next, 786);
        hint(mp_lexer_to_next, this::mp_lexer_to_next, 828);
        hint(mp_lexer_to_next, this::mp_lexer_to_next, 862);
        hint(mp_lexer_to_next, this::mp_lexer_to_next, 868);
        hint(mp_lexer_to_next, this::mp_lexer_to_next, 880);
        hint(mp_lexer_to_next, this::mp_lexer_to_next, 896);
        hint(mp_lexer_to_next, this::mp_lexer_to_next, 938);
        hint(mp_lexer_to_next, this::mp_lexer_to_next, 956);
        hint(mp_lexer_to_next, this::mp_lexer_to_next, 984);
        hint(mp_lexer_to_next, this::mp_lexer_to_next, 1012);
        hint(mp_lexer_to_next, this::mp_lexer_to_next, 1018);
        hint(mp_lexer_to_next, this::mp_lexer_to_next, 1032);
        hint(mp_lexer_to_next, this::mp_lexer_to_next, 1102);
        hint(mp_lexer_to_next, this::mp_lexer_to_next, 1108);
        hint(mp_lexer_to_next, this::mp_lexer_to_next, 1132);
        hint(mp_lexer_to_next, this::mp_lexer_to_next, 1154);
        hint(mp_lexer_to_next, this::mp_lexer_to_next, 1216);
        hint(mp_lexer_to_next, this::mp_lexer_to_next, 1242);
        hint(mp_lexer_to_next, this::mp_lexer_to_next, 1280);
        hint(mp_lexer_to_next, this::mp_lexer_to_next, 1286);
        hint(mp_lexer_to_next, this::mp_lexer_to_next, 1326);
        hint(mp_lexer_new, this::mp_lexer_new, 0);
        hint(mp_lexer_new, this::mp_lexer_new, 16);
        hint(mp_lexer_new, this::mp_lexer_new, 56);
        hint(mp_lexer_new, this::mp_lexer_new, 68);
        hint(mp_lexer_new, this::mp_lexer_new, 84);
        hint(mp_lexer_new, this::mp_lexer_new, 90);
        hint(mp_lexer_new, this::mp_lexer_new, 96);
        hint(mp_lexer_new, this::mp_lexer_new, 102);
        hint(mp_lexer_new_from_str_len, this::mp_lexer_new_from_str_len, 0);
        hint(mp_lexer_new_from_str_len, this::mp_lexer_new_from_str_len, 10);
        hint(mp_lexer_new_from_str_len, this::mp_lexer_new_from_str_len, 22);
        hint(mp_lexer_new_from_file, this::mp_lexer_new_from_file, 0);
        hint(mp_lexer_new_from_file, this::mp_lexer_new_from_file, 12);
        hint(mp_lexer_new_from_file, this::mp_lexer_new_from_file, 18);
        hint(mp_lexer_new_from_file, this::mp_lexer_new_from_file, 28);
        hint(mp_lexer_free, this::mp_lexer_free, 0);
        hint(mp_lexer_free, this::mp_lexer_free, 12);
        hint(mp_lexer_free, this::mp_lexer_free, 20);
        hint(mp_lexer_free, this::mp_lexer_free, 30);
        hint(mp_lexer_free, this::mp_lexer_free, 38);
        hint(pop_result, this::pop_result, 0);
        hint(peek_result, this::peek_result, 0);
        hint(parser_alloc, this::parser_alloc, 0);
        hint(parser_alloc, this::parser_alloc, 38);
        hint(parser_alloc, this::parser_alloc, 56);
        hint(parser_alloc, this::parser_alloc, 82);
        hint(push_result_node, this::push_result_node, 0);
        hint(push_result_node, this::push_result_node, 26);
        hint(push_rule, this::push_rule, 0);
        hint(push_rule, this::push_rule, 30);
        hint(push_rule_from_arg, this::push_rule_from_arg, 0);
        hint(push_rule_from_arg, this::push_rule_from_arg, 14);
        hint(push_result_token, this::push_result_token, 0);
        hint(push_result_token, this::push_result_token, 26);
        hint(push_result_token, this::push_result_token, 48);
        hint(push_result_token, this::push_result_token, 80);
        hint(push_result_token, this::push_result_token, 98);
        hint(push_result_token, this::push_result_token, 120);
        hint(push_result_token, this::push_result_token, 132);
        hint(push_result_token, this::push_result_token, 166);
        hint(push_result_token, this::push_result_token, 188);
        hint(push_result_token, this::push_result_token, 206);
        hint(mp_parse_node_is_const_false, this::mp_parse_node_is_const_false, 0);
        hint(mp_parse_node_is_const_true, this::mp_parse_node_is_const_true, 0);
        hint(mp_parse_node_get_int_maybe, this::mp_parse_node_get_int_maybe, 0);
        hint(push_result_rule, this::push_result_rule, 0);
        hint(push_result_rule, this::push_result_rule, 22);
        hint(push_result_rule, this::push_result_rule, 68);
        hint(push_result_rule, this::push_result_rule, 78);
        hint(push_result_rule, this::push_result_rule, 104);
        hint(push_result_rule, this::push_result_rule, 152);
        hint(push_result_rule, this::push_result_rule, 158);
        hint(push_result_rule, this::push_result_rule, 214);
        hint(push_result_rule, this::push_result_rule, 220);
        hint(push_result_rule, this::push_result_rule, 230);
        hint(push_result_rule, this::push_result_rule, 238);
        hint(push_result_rule, this::push_result_rule, 256);
        hint(push_result_rule, this::push_result_rule, 262);
        hint(push_result_rule, this::push_result_rule, 272);
        hint(push_result_rule, this::push_result_rule, 284);
        hint(push_result_rule, this::push_result_rule, 300);
        hint(push_result_rule, this::push_result_rule, 306);
        hint(push_result_rule, this::push_result_rule, 320);
        hint(push_result_rule, this::push_result_rule, 342);
        hint(push_result_rule, this::push_result_rule, 348);
        hint(push_result_rule, this::push_result_rule, 364);
        hint(push_result_rule, this::push_result_rule, 388);
        hint(push_result_rule, this::push_result_rule, 406);
        hint(push_result_rule, this::push_result_rule, 412);
        hint(push_result_rule, this::push_result_rule, 424);
        hint(push_result_rule, this::push_result_rule, 448);
        hint(push_result_rule, this::push_result_rule, 466);
        hint(push_result_rule, this::push_result_rule, 500);
        hint(push_result_rule, this::push_result_rule, 506);
        hint(push_result_rule, this::push_result_rule, 518);
        hint(push_result_rule, this::push_result_rule, 544);
        hint(push_result_rule, this::push_result_rule, 564);
        hint(push_result_rule, this::push_result_rule, 594);
        hint(push_result_rule, this::push_result_rule, 682);
        hint(push_result_rule, this::push_result_rule, 694);
        hint(push_result_rule, this::push_result_rule, 708);
        hint(push_result_rule, this::push_result_rule, 714);
        hint(push_result_rule, this::push_result_rule, 732);
        hint(push_result_rule, this::push_result_rule, 742);
        hint(push_result_rule, this::push_result_rule, 754);
        hint(push_result_rule, this::push_result_rule, 760);
        hint(push_result_rule, this::push_result_rule, 772);
        hint(push_result_rule, this::push_result_rule, 780);
        hint(push_result_rule, this::push_result_rule, 788);
        hint(push_result_rule, this::push_result_rule, 806);
        hint(push_result_rule, this::push_result_rule, 816);
        hint(push_result_rule, this::push_result_rule, 864);
        hint(push_result_rule, this::push_result_rule, 880);
        hint(push_result_rule, this::push_result_rule, 926);
        hint(push_result_rule, this::push_result_rule, 938);
        hint(mp_parse_node_extract_list, this::mp_parse_node_extract_list, 0);
    }

    private void gen_hints_2() {
        hint(mp_parse, this::mp_parse, 0);
        hint(mp_parse, this::mp_parse, 26);
        hint(mp_parse, this::mp_parse, 40);
        hint(mp_parse, this::mp_parse, 56);
        hint(mp_parse, this::mp_parse, 82);
        hint(mp_parse, this::mp_parse, 234);
        hint(mp_parse, this::mp_parse, 240);
        hint(mp_parse, this::mp_parse, 304);
        hint(mp_parse, this::mp_parse, 310);
        hint(mp_parse, this::mp_parse, 328);
        hint(mp_parse, this::mp_parse, 336);
        hint(mp_parse, this::mp_parse, 370);
        hint(mp_parse, this::mp_parse, 426);
        hint(mp_parse, this::mp_parse, 438);
        hint(mp_parse, this::mp_parse, 444);
        hint(mp_parse, this::mp_parse, 482);
        hint(mp_parse, this::mp_parse, 488);
        hint(mp_parse, this::mp_parse, 544);
        hint(mp_parse, this::mp_parse, 560);
        hint(mp_parse, this::mp_parse, 580);
        hint(mp_parse, this::mp_parse, 600);
        hint(mp_parse, this::mp_parse, 614);
        hint(mp_parse, this::mp_parse, 694);
        hint(mp_parse, this::mp_parse, 702);
        hint(mp_parse, this::mp_parse, 714);
        hint(mp_parse, this::mp_parse, 734);
        hint(mp_parse, this::mp_parse, 788);
        hint(mp_parse, this::mp_parse, 800);
        hint(mp_parse, this::mp_parse, 806);
        hint(mp_parse_tree_clear, this::mp_parse_tree_clear, 0);
        hint(mp_parse_tree_clear, this::mp_parse_tree_clear, 20);
        hint(scope_new, this::scope_new, 0);
        hint(scope_new, this::scope_new, 16);
        hint(scope_new, this::scope_new, 42);
        hint(scope_new, this::scope_new, 58);
        hint(scope_free, this::scope_free, 0);
        hint(scope_free, this::scope_free, 14);
        hint(scope_free, this::scope_free, 22);
        hint(scope_find, this::scope_find, 0);
        hint(scope_find_or_add_id, this::scope_find_or_add_id, 0);
        hint(scope_find_or_add_id, this::scope_find_or_add_id, 12);
        hint(scope_find_or_add_id, this::scope_find_or_add_id, 38);
        hint(scope_find_global, this::scope_find_global, 0);
        hint(scope_find_global, this::scope_find_global, 12);
        hint(scope_find_local_and_close_over, this::scope_find_local_and_close_over, 0);
        hint(scope_find_local_and_close_over, this::scope_find_local_and_close_over, 44);
        hint(scope_find_local_and_close_over, this::scope_find_local_and_close_over, 76);
        hint(compile_increase_except_level, this::compile_increase_except_level, 0);
        hint(apply_to_single_or_list, this::apply_to_single_or_list, 0);
        hint(apply_to_single_or_list, this::apply_to_single_or_list, 48);
        hint(apply_to_single_or_list, this::apply_to_single_or_list, 58);
        hint(compile_del_stmt, this::compile_del_stmt, 0);
        hint(compile_del_stmt, this::compile_del_stmt, 12);
        hint(compile_import_name, this::compile_import_name, 0);
        hint(compile_import_name, this::compile_import_name, 12);
        hint(scope_new_and_link, this::scope_new_and_link, 0);
        hint(scope_new_and_link, this::scope_new_and_link, 14);
        hint(compile_trailer_period, this::compile_trailer_period, 0);
        hint(compile_trailer_period, this::compile_trailer_period, 14);
        hint(compile_const_object, this::compile_const_object, 0);
        hint(compile_const_object, this::compile_const_object, 10);
        hint(close_over_variables_etc, this::close_over_variables_etc, 0);
        hint(close_over_variables_etc, this::close_over_variables_etc, 48);
        hint(close_over_variables_etc, this::close_over_variables_etc, 106);
        hint(close_over_variables_etc, this::close_over_variables_etc, 152);
        hint(compile_funcdef_lambdef, this::compile_funcdef_lambdef, 0);
        hint(compile_funcdef_lambdef, this::compile_funcdef_lambdef, 30);
        hint(compile_funcdef_lambdef, this::compile_funcdef_lambdef, 54);
        hint(compile_funcdef_lambdef, this::compile_funcdef_lambdef, 60);
        hint(compile_funcdef_lambdef, this::compile_funcdef_lambdef, 72);
        hint(compile_lambdef, this::compile_lambdef, 0);
        hint(compile_lambdef, this::compile_lambdef, 24);
        hint(compile_lambdef, this::compile_lambdef, 38);
        hint(compile_funcdef_helper, this::compile_funcdef_helper, 0);
        hint(compile_funcdef_helper, this::compile_funcdef_helper, 22);
        hint(compile_funcdef_helper, this::compile_funcdef_helper, 38);
        hint(compile_error_set_line_isra_0, this::compile_error_set_line_isra_0, 0);
        hint(compile_syntax_error, this::compile_syntax_error, 0);
        hint(compile_syntax_error, this::compile_syntax_error, 20);
        hint(compile_syntax_error, this::compile_syntax_error, 32);
        hint(compile_star_expr, this::compile_star_expr, 0);
        hint(compile_star_expr, this::compile_star_expr, 8);
        hint(compile_break_cont_stmt, this::compile_break_cont_stmt, 0);
        hint(compile_break_cont_stmt, this::compile_break_cont_stmt, 28);
        hint(compile_break_cont_stmt, this::compile_break_cont_stmt, 42);
        hint(compile_scope_func_lambda_param_isra_5, this::compile_scope_func_lambda_param_isra_5, 0);
        hint(compile_scope_func_lambda_param_isra_5, this::compile_scope_func_lambda_param_isra_5, 28);
        hint(compile_scope_func_lambda_param_isra_5, this::compile_scope_func_lambda_param_isra_5, 76);
        hint(compile_scope_lambda_param, this::compile_scope_lambda_param, 0);
        hint(compile_scope_lambda_param, this::compile_scope_lambda_param, 10);
        hint(compile_scope_func_param, this::compile_scope_func_param, 0);
        hint(compile_scope_func_param, this::compile_scope_func_param, 10);
        hint(compile_yield_from_isra_6, this::compile_yield_from_isra_6, 0);
        hint(compile_yield_from_isra_6, this::compile_yield_from_isra_6, 12);
        hint(compile_yield_from_isra_6, this::compile_yield_from_isra_6, 20);
        hint(compile_yield_from_isra_6, this::compile_yield_from_isra_6, 28);
        hint(compile_await_object_method, this::compile_await_object_method, 0);
        hint(compile_await_object_method, this::compile_await_object_method, 12);
        hint(compile_await_object_method, this::compile_await_object_method, 24);
        hint(compile_await_object_method, this::compile_await_object_method, 32);
        hint(compile_load_id, this::compile_load_id, 0);
        hint(compile_load_id, this::compile_load_id, 16);
        hint(compile_load_id, this::compile_load_id, 28);
        hint(compile_store_id, this::compile_store_id, 0);
        hint(compile_store_id, this::compile_store_id, 16);
        hint(compile_store_id, this::compile_store_id, 28);
        hint(compile_funcdef, this::compile_funcdef, 0);
        hint(compile_funcdef, this::compile_funcdef, 12);
        hint(compile_funcdef, this::compile_funcdef, 20);
        hint(compile_delete_id, this::compile_delete_id, 0);
        hint(compile_delete_id, this::compile_delete_id, 16);
        hint(compile_delete_id, this::compile_delete_id, 28);
        hint(compile_node, this::compile_node, 0);
        hint(compile_node, this::compile_node, 46);
        hint(compile_node, this::compile_node, 62);
        hint(compile_node, this::compile_node, 70);
        hint(compile_node, this::compile_node, 102);
        hint(compile_node, this::compile_node, 112);
        hint(compile_node, this::compile_node, 132);
        hint(compile_node, this::compile_node, 140);
        hint(compile_node, this::compile_node, 158);
        hint(compile_node, this::compile_node, 168);
        hint(compile_node, this::compile_node, 184);
        hint(c_assign, this::c_assign, 0);
        hint(c_assign, this::c_assign, 38);
        hint(c_assign, this::c_assign, 44);
        hint(c_assign, this::c_assign, 78);
        hint(c_assign, this::c_assign, 114);
        hint(c_assign, this::c_assign, 178);
        hint(c_assign, this::c_assign, 196);
        hint(c_assign, this::c_assign, 216);
        hint(c_assign, this::c_assign, 226);
        hint(c_assign, this::c_assign, 234);
        hint(c_assign, this::c_assign, 250);
        hint(c_assign, this::c_assign, 262);
        hint(c_assign, this::c_assign, 272);
        hint(c_assign, this::c_assign, 338);
        hint(c_assign_tuple, this::c_assign_tuple, 0);
        hint(c_assign_tuple, this::c_assign_tuple, 48);
        hint(c_assign_tuple, this::c_assign_tuple, 72);
        hint(c_assign_tuple, this::c_assign_tuple, 102);
        hint(c_assign_tuple, this::c_assign_tuple, 166);
        hint(c_assign_tuple, this::c_assign_tuple, 178);
        hint(c_assign_tuple, this::c_assign_tuple, 200);
        hint(c_if_cond, this::c_if_cond, 0);
        hint(c_if_cond, this::c_if_cond, 20);
        hint(c_if_cond, this::c_if_cond, 36);
        hint(c_if_cond, this::c_if_cond, 52);
        hint(c_if_cond, this::c_if_cond, 106);
        hint(c_if_cond, this::c_if_cond, 126);
        hint(c_if_cond, this::c_if_cond, 174);
        hint(c_if_cond, this::c_if_cond, 182);
        hint(c_if_cond, this::c_if_cond, 216);
        hint(c_if_cond, this::c_if_cond, 226);
        hint(compile_scope_comp_iter, this::compile_scope_comp_iter, 0);
        hint(compile_scope_comp_iter, this::compile_scope_comp_iter, 28);
        hint(compile_scope_comp_iter, this::compile_scope_comp_iter, 36);
        hint(compile_scope_comp_iter, this::compile_scope_comp_iter, 46);
        hint(compile_scope_comp_iter, this::compile_scope_comp_iter, 60);
        hint(compile_scope_comp_iter, this::compile_scope_comp_iter, 76);
        hint(compile_scope_comp_iter, this::compile_scope_comp_iter, 82);
        hint(compile_scope_comp_iter, this::compile_scope_comp_iter, 90);
        hint(compile_scope_comp_iter, this::compile_scope_comp_iter, 98);
        hint(compile_scope_comp_iter, this::compile_scope_comp_iter, 104);
        hint(compile_scope_comp_iter, this::compile_scope_comp_iter, 118);
        hint(compile_scope_comp_iter, this::compile_scope_comp_iter, 142);
        hint(compile_scope_comp_iter, this::compile_scope_comp_iter, 154);
        hint(compile_scope_comp_iter, this::compile_scope_comp_iter, 162);
        hint(compile_scope_comp_iter, this::compile_scope_comp_iter, 176);
        hint(check_for_doc_string, this::check_for_doc_string, 0);
        hint(check_for_doc_string, this::check_for_doc_string, 74);
        hint(check_for_doc_string, this::check_for_doc_string, 82);
        hint(compile_scope, this::compile_scope, 0);
        hint(compile_scope, this::compile_scope, 26);
        hint(compile_scope, this::compile_scope, 62);
        hint(compile_scope, this::compile_scope, 68);
        hint(compile_scope, this::compile_scope, 90);
        hint(compile_scope, this::compile_scope, 98);
        hint(compile_scope, this::compile_scope, 106);
        hint(compile_scope, this::compile_scope, 132);
        hint(compile_scope, this::compile_scope, 140);
        hint(compile_scope, this::compile_scope, 146);
        hint(compile_scope, this::compile_scope, 156);
        hint(compile_scope, this::compile_scope, 184);
        hint(compile_scope, this::compile_scope, 192);
        hint(compile_scope, this::compile_scope, 204);
        hint(compile_scope, this::compile_scope, 232);
        hint(compile_scope, this::compile_scope, 266);
        hint(compile_scope, this::compile_scope, 278);
        hint(compile_scope, this::compile_scope, 286);
        hint(compile_scope, this::compile_scope, 292);
        hint(compile_scope, this::compile_scope, 298);
        hint(compile_scope, this::compile_scope, 310);
        hint(compile_scope, this::compile_scope, 328);
        hint(compile_scope, this::compile_scope, 336);
        hint(compile_scope, this::compile_scope, 354);
        hint(compile_scope, this::compile_scope, 366);
        hint(compile_scope, this::compile_scope, 374);
        hint(compile_scope, this::compile_scope, 384);
        hint(compile_scope, this::compile_scope, 392);
        hint(compile_scope, this::compile_scope, 400);
        hint(compile_scope, this::compile_scope, 408);
        hint(compile_scope, this::compile_scope, 416);
        hint(compile_scope, this::compile_scope, 436);
        hint(compile_dictorsetmaker_item, this::compile_dictorsetmaker_item, 0);
        hint(compile_dictorsetmaker_item, this::compile_dictorsetmaker_item, 12);
        hint(compile_dictorsetmaker_item, this::compile_dictorsetmaker_item, 20);
        hint(compile_subscript, this::compile_subscript, 0);
        hint(compile_subscript, this::compile_subscript, 20);
        hint(compile_subscript, this::compile_subscript, 36);
        hint(compile_subscript, this::compile_subscript, 50);
        hint(compile_subscript, this::compile_subscript, 74);
        hint(compile_subscript, this::compile_subscript, 90);
        hint(compile_subscript, this::compile_subscript, 104);
        hint(compile_subscript, this::compile_subscript, 116);
        hint(compile_subscript, this::compile_subscript, 130);
        hint(compile_trailer_bracket, this::compile_trailer_bracket, 0);
        hint(compile_trailer_bracket, this::compile_trailer_bracket, 10);
        hint(compile_trailer_bracket, this::compile_trailer_bracket, 18);
        hint(text_c_tuple, this::text_c_tuple, 0);
        hint(text_c_tuple, this::text_c_tuple, 16);
        hint(text_c_tuple, this::text_c_tuple, 48);
        hint(text_c_tuple, this::text_c_tuple, 62);
        hint(compile_generic_tuple, this::compile_generic_tuple, 0);
        hint(compile_generic_tuple, this::compile_generic_tuple, 10);
        hint(compile_while_stmt, this::compile_while_stmt, 0);
        hint(compile_while_stmt, this::compile_while_stmt, 42);
        hint(compile_while_stmt, this::compile_while_stmt, 60);
        hint(compile_while_stmt, this::compile_while_stmt, 72);
        hint(compile_while_stmt, this::compile_while_stmt, 80);
        hint(compile_while_stmt, this::compile_while_stmt, 88);
        hint(compile_while_stmt, this::compile_while_stmt, 96);
        hint(compile_while_stmt, this::compile_while_stmt, 108);
        hint(compile_while_stmt, this::compile_while_stmt, 128);
        hint(compile_while_stmt, this::compile_while_stmt, 136);
        hint(compile_yield_stmt, this::compile_yield_stmt, 0);
        hint(compile_yield_stmt, this::compile_yield_stmt, 10);
        hint(compile_yield_stmt, this::compile_yield_stmt, 16);
        hint(c_del_stmt, this::c_del_stmt, 0);
        hint(c_del_stmt, this::c_del_stmt, 22);
        hint(c_del_stmt, this::c_del_stmt, 52);
        hint(c_del_stmt, this::c_del_stmt, 112);
        hint(c_del_stmt, this::c_del_stmt, 120);
        hint(c_del_stmt, this::c_del_stmt, 134);
        hint(c_del_stmt, this::c_del_stmt, 154);
        hint(c_del_stmt, this::c_del_stmt, 206);
        hint(c_del_stmt, this::c_del_stmt, 222);
        hint(c_del_stmt, this::c_del_stmt, 238);
        hint(c_del_stmt, this::c_del_stmt, 252);
        hint(compile_generic_all_nodes, this::compile_generic_all_nodes, 0);
        hint(compile_generic_all_nodes, this::compile_generic_all_nodes, 28);
        hint(compile_generic_all_nodes, this::compile_generic_all_nodes, 48);
        hint(compile_power, this::compile_power, 0);
        hint(compile_power, this::compile_power, 8);
        hint(compile_power, this::compile_power, 16);
        hint(compile_if_stmt, this::compile_if_stmt, 0);
        hint(compile_if_stmt, this::compile_if_stmt, 20);
        hint(compile_if_stmt, this::compile_if_stmt, 40);
        hint(compile_if_stmt, this::compile_if_stmt, 48);
        hint(compile_if_stmt, this::compile_if_stmt, 54);
        hint(compile_if_stmt, this::compile_if_stmt, 76);
        hint(compile_if_stmt, this::compile_if_stmt, 88);
        hint(compile_if_stmt, this::compile_if_stmt, 96);
        hint(compile_if_stmt, this::compile_if_stmt, 108);
        hint(compile_if_stmt, this::compile_if_stmt, 130);
        hint(compile_if_stmt, this::compile_if_stmt, 138);
        hint(compile_if_stmt, this::compile_if_stmt, 156);
        hint(compile_if_stmt, this::compile_if_stmt, 178);
        hint(compile_if_stmt, this::compile_if_stmt, 186);
        hint(compile_if_stmt, this::compile_if_stmt, 192);
        hint(compile_if_stmt, this::compile_if_stmt, 202);
        hint(compile_if_stmt, this::compile_if_stmt, 214);
        hint(compile_if_stmt, this::compile_if_stmt, 222);
        hint(compile_comprehension, this::compile_comprehension, 0);
        hint(compile_comprehension, this::compile_comprehension, 26);
        hint(compile_comprehension, this::compile_comprehension, 40);
        hint(compile_comprehension, this::compile_comprehension, 48);
        hint(compile_comprehension, this::compile_comprehension, 60);
        hint(compile_comprehension, this::compile_comprehension, 72);
        hint(compile_atom_bracket, this::compile_atom_bracket, 0);
        hint(compile_atom_bracket, this::compile_atom_bracket, 20);
        hint(compile_atom_bracket, this::compile_atom_bracket, 64);
        hint(compile_atom_bracket, this::compile_atom_bracket, 80);
        hint(compile_atom_bracket, this::compile_atom_bracket, 88);
        hint(compile_atom_bracket, this::compile_atom_bracket, 108);
        hint(compile_atom_bracket, this::compile_atom_bracket, 118);
        hint(compile_atom_bracket, this::compile_atom_bracket, 126);
        hint(compile_trailer_paren_helper, this::compile_trailer_paren_helper, 0);
        hint(compile_trailer_paren_helper, this::compile_trailer_paren_helper, 24);
        hint(compile_trailer_paren_helper, this::compile_trailer_paren_helper, 58);
        hint(compile_trailer_paren_helper, this::compile_trailer_paren_helper, 72);
        hint(compile_trailer_paren_helper, this::compile_trailer_paren_helper, 92);
        hint(compile_trailer_paren_helper, this::compile_trailer_paren_helper, 136);
        hint(compile_trailer_paren_helper, this::compile_trailer_paren_helper, 216);
        hint(compile_trailer_paren_helper, this::compile_trailer_paren_helper, 224);
        hint(compile_trailer_paren_helper, this::compile_trailer_paren_helper, 242);
        hint(compile_trailer_paren_helper, this::compile_trailer_paren_helper, 276);
        hint(compile_trailer_paren_helper, this::compile_trailer_paren_helper, 296);
        hint(compile_trailer_paren_helper, this::compile_trailer_paren_helper, 308);
        hint(compile_trailer_paren_helper, this::compile_trailer_paren_helper, 320);
        hint(compile_classdef_helper, this::compile_classdef_helper, 0);
        hint(compile_classdef_helper, this::compile_classdef_helper, 20);
        hint(compile_classdef_helper, this::compile_classdef_helper, 28);
        hint(compile_classdef_helper, this::compile_classdef_helper, 42);
        hint(compile_classdef_helper, this::compile_classdef_helper, 50);
        hint(compile_classdef_helper, this::compile_classdef_helper, 82);
        hint(compile_classdef, this::compile_classdef, 0);
        hint(compile_classdef, this::compile_classdef, 12);
        hint(compile_classdef, this::compile_classdef, 20);
        hint(compile_trailer_paren, this::compile_trailer_paren, 0);
        hint(compile_trailer_paren, this::compile_trailer_paren, 12);
        hint(compile_decorated, this::compile_decorated, 0);
        hint(compile_decorated, this::compile_decorated, 20);
        hint(compile_decorated, this::compile_decorated, 56);
        hint(compile_decorated, this::compile_decorated, 80);
        hint(compile_decorated, this::compile_decorated, 102);
        hint(compile_decorated, this::compile_decorated, 124);
        hint(compile_decorated, this::compile_decorated, 140);
        hint(compile_decorated, this::compile_decorated, 178);
        hint(compile_decorated, this::compile_decorated, 198);
        hint(compile_decorated, this::compile_decorated, 230);
        hint(compile_decorated, this::compile_decorated, 242);
        hint(compile_decorated, this::compile_decorated, 256);
        hint(compile_atom_brace, this::compile_atom_brace, 0);
        hint(compile_atom_brace, this::compile_atom_brace, 22);
        hint(compile_atom_brace, this::compile_atom_brace, 52);
        hint(compile_atom_brace, this::compile_atom_brace, 60);
        hint(compile_atom_brace, this::compile_atom_brace, 66);
        hint(compile_atom_brace, this::compile_atom_brace, 94);
        hint(compile_atom_brace, this::compile_atom_brace, 124);
        hint(compile_atom_brace, this::compile_atom_brace, 132);
        hint(compile_atom_brace, this::compile_atom_brace, 138);
        hint(compile_atom_brace, this::compile_atom_brace, 170);
        hint(compile_atom_brace, this::compile_atom_brace, 210);
        hint(compile_atom_brace, this::compile_atom_brace, 230);
        hint(compile_atom_brace, this::compile_atom_brace, 238);
        hint(compile_atom_brace, this::compile_atom_brace, 280);
        hint(compile_atom_brace, this::compile_atom_brace, 290);
        hint(compile_funcdef_lambdef_param, this::compile_funcdef_lambdef_param, 0);
        hint(compile_funcdef_lambdef_param, this::compile_funcdef_lambdef_param, 64);
        hint(compile_funcdef_lambdef_param, this::compile_funcdef_lambdef_param, 104);
        hint(compile_funcdef_lambdef_param, this::compile_funcdef_lambdef_param, 114);
        hint(compile_funcdef_lambdef_param, this::compile_funcdef_lambdef_param, 122);
        hint(compile_funcdef_lambdef_param, this::compile_funcdef_lambdef_param, 130);
        hint(compile_funcdef_lambdef_param, this::compile_funcdef_lambdef_param, 136);
        hint(compile_funcdef_lambdef_param, this::compile_funcdef_lambdef_param, 142);
        hint(compile_funcdef_lambdef_param, this::compile_funcdef_lambdef_param, 158);
        hint(compile_atom_expr_normal, this::compile_atom_expr_normal, 0);
        hint(compile_atom_expr_normal, this::compile_atom_expr_normal, 12);
        hint(compile_atom_expr_normal, this::compile_atom_expr_normal, 88);
        hint(compile_atom_expr_normal, this::compile_atom_expr_normal, 110);
        hint(compile_atom_expr_normal, this::compile_atom_expr_normal, 134);
        hint(compile_atom_expr_normal, this::compile_atom_expr_normal, 152);
        hint(compile_atom_expr_normal, this::compile_atom_expr_normal, 196);
        hint(compile_atom_expr_normal, this::compile_atom_expr_normal, 208);
        hint(compile_atom_expr_normal, this::compile_atom_expr_normal, 266);
        hint(compile_atom_expr_normal, this::compile_atom_expr_normal, 278);
        hint(compile_atom_expr_normal, this::compile_atom_expr_normal, 290);
        hint(compile_term, this::compile_term, 0);
        hint(compile_term, this::compile_term, 20);
        hint(compile_term, this::compile_term, 40);
        hint(compile_term, this::compile_term, 66);
        hint(compile_binary_op, this::compile_binary_op, 0);
        hint(compile_binary_op, this::compile_binary_op, 22);
        hint(compile_binary_op, this::compile_binary_op, 46);
        hint(compile_binary_op, this::compile_binary_op, 54);
        hint(compile_expr_stmt, this::compile_expr_stmt, 0);
        hint(compile_expr_stmt, this::compile_expr_stmt, 32);
        hint(compile_expr_stmt, this::compile_expr_stmt, 40);
        hint(compile_expr_stmt, this::compile_expr_stmt, 52);
        hint(compile_expr_stmt, this::compile_expr_stmt, 58);
        hint(compile_expr_stmt, this::compile_expr_stmt, 84);
        hint(compile_expr_stmt, this::compile_expr_stmt, 116);
        hint(compile_expr_stmt, this::compile_expr_stmt, 124);
        hint(compile_expr_stmt, this::compile_expr_stmt, 146);
        hint(compile_expr_stmt, this::compile_expr_stmt, 172);
        hint(compile_expr_stmt, this::compile_expr_stmt, 182);
        hint(compile_expr_stmt, this::compile_expr_stmt, 192);
        hint(compile_expr_stmt, this::compile_expr_stmt, 210);
        hint(compile_expr_stmt, this::compile_expr_stmt, 224);
        hint(compile_expr_stmt, this::compile_expr_stmt, 332);
        hint(compile_expr_stmt, this::compile_expr_stmt, 340);
        hint(compile_expr_stmt, this::compile_expr_stmt, 354);
        hint(compile_expr_stmt, this::compile_expr_stmt, 360);
        hint(compile_expr_stmt, this::compile_expr_stmt, 366);
        hint(compile_expr_stmt, this::compile_expr_stmt, 376);
        hint(compile_expr_stmt, this::compile_expr_stmt, 386);
        hint(compile_expr_stmt, this::compile_expr_stmt, 402);
        hint(compile_expr_stmt, this::compile_expr_stmt, 412);
        hint(compile_factor_2, this::compile_factor_2, 0);
        hint(compile_factor_2, this::compile_factor_2, 12);
        hint(compile_factor_2, this::compile_factor_2, 40);
        hint(compile_not_test_2, this::compile_not_test_2, 0);
        hint(compile_not_test_2, this::compile_not_test_2, 10);
        hint(compile_not_test_2, this::compile_not_test_2, 18);
        hint(compile_or_and_test, this::compile_or_and_test, 0);
        hint(compile_or_and_test, this::compile_or_and_test, 46);
        hint(compile_or_and_test, this::compile_or_and_test, 60);
        hint(compile_or_and_test, this::compile_or_and_test, 78);
        hint(compile_comparison, this::compile_comparison, 0);
        hint(compile_comparison, this::compile_comparison, 16);
        hint(compile_comparison, this::compile_comparison, 60);
        hint(compile_comparison, this::compile_comparison, 68);
        hint(compile_comparison, this::compile_comparison, 76);
        hint(compile_comparison, this::compile_comparison, 82);
        hint(compile_comparison, this::compile_comparison, 88);
        hint(compile_comparison, this::compile_comparison, 96);
        hint(compile_comparison, this::compile_comparison, 108);
        hint(compile_comparison, this::compile_comparison, 118);
        hint(compile_comparison, this::compile_comparison, 124);
        hint(compile_comparison, this::compile_comparison, 154);
        hint(compile_comparison, this::compile_comparison, 168);
        hint(compile_test_if_expr, this::compile_test_if_expr, 0);
        hint(compile_test_if_expr, this::compile_test_if_expr, 28);
        hint(compile_test_if_expr, this::compile_test_if_expr, 36);
        hint(compile_test_if_expr, this::compile_test_if_expr, 44);
        hint(compile_test_if_expr, this::compile_test_if_expr, 52);
        hint(compile_test_if_expr, this::compile_test_if_expr, 62);
        hint(compile_test_if_expr, this::compile_test_if_expr, 70);
        hint(compile_test_if_expr, this::compile_test_if_expr, 78);
        hint(compile_for_stmt, this::compile_for_stmt, 0);
        hint(compile_for_stmt, this::compile_for_stmt, 98);
        hint(compile_for_stmt, this::compile_for_stmt, 268);
        hint(compile_for_stmt, this::compile_for_stmt, 276);
        hint(compile_for_stmt, this::compile_for_stmt, 284);
        hint(compile_for_stmt, this::compile_for_stmt, 292);
        hint(compile_for_stmt, this::compile_for_stmt, 298);
        hint(compile_for_stmt, this::compile_for_stmt, 308);
        hint(compile_for_stmt, this::compile_for_stmt, 316);
        hint(compile_for_stmt, this::compile_for_stmt, 324);
        hint(compile_for_stmt, this::compile_for_stmt, 332);
        hint(compile_for_stmt, this::compile_for_stmt, 340);
        hint(compile_for_stmt, this::compile_for_stmt, 348);
        hint(compile_for_stmt, this::compile_for_stmt, 360);
        hint(compile_for_stmt, this::compile_for_stmt, 366);
        hint(compile_for_stmt, this::compile_for_stmt, 382);
        hint(compile_for_stmt, this::compile_for_stmt, 392);
        hint(compile_for_stmt, this::compile_for_stmt, 416);
        hint(compile_for_stmt, this::compile_for_stmt, 428);
        hint(compile_for_stmt, this::compile_for_stmt, 436);
        hint(compile_for_stmt, this::compile_for_stmt, 450);
        hint(compile_for_stmt, this::compile_for_stmt, 462);
        hint(compile_for_stmt, this::compile_for_stmt, 470);
        hint(compile_for_stmt, this::compile_for_stmt, 476);
        hint(compile_for_stmt, this::compile_for_stmt, 488);
        hint(compile_for_stmt, this::compile_for_stmt, 504);
        hint(compile_for_stmt, this::compile_for_stmt, 512);
        hint(compile_for_stmt, this::compile_for_stmt, 558);
        hint(compile_for_stmt, this::compile_for_stmt, 566);
        hint(compile_for_stmt, this::compile_for_stmt, 574);
        hint(compile_for_stmt, this::compile_for_stmt, 582);
        hint(compile_for_stmt, this::compile_for_stmt, 592);
        hint(compile_for_stmt, this::compile_for_stmt, 600);
        hint(compile_for_stmt, this::compile_for_stmt, 606);
        hint(compile_for_stmt, this::compile_for_stmt, 618);
        hint(compile_for_stmt, this::compile_for_stmt, 626);
        hint(compile_for_stmt, this::compile_for_stmt, 632);
        hint(compile_for_stmt, this::compile_for_stmt, 652);
        hint(compile_for_stmt, this::compile_for_stmt, 660);
        hint(compile_with_stmt_helper, this::compile_with_stmt_helper, 0);
        hint(compile_with_stmt_helper, this::compile_with_stmt_helper, 22);
        hint(compile_with_stmt_helper, this::compile_with_stmt_helper, 60);
        hint(compile_with_stmt_helper, this::compile_with_stmt_helper, 70);
        hint(compile_with_stmt_helper, this::compile_with_stmt_helper, 80);
        hint(compile_with_stmt_helper, this::compile_with_stmt_helper, 86);
        hint(compile_with_stmt_helper, this::compile_with_stmt_helper, 102);
        hint(compile_with_stmt_helper, this::compile_with_stmt_helper, 110);
        hint(compile_with_stmt_helper, this::compile_with_stmt_helper, 122);
        hint(compile_with_stmt_helper, this::compile_with_stmt_helper, 132);
        hint(compile_with_stmt_helper, this::compile_with_stmt_helper, 142);
        hint(compile_with_stmt_helper, this::compile_with_stmt_helper, 148);
        hint(compile_with_stmt, this::compile_with_stmt, 0);
        hint(compile_with_stmt, this::compile_with_stmt, 18);
        hint(compile_with_stmt, this::compile_with_stmt, 30);
        hint(compile_try_except, this::compile_try_except, 0);
        hint(compile_try_except, this::compile_try_except, 32);
        hint(compile_try_except, this::compile_try_except, 38);
        hint(compile_try_except, this::compile_try_except, 46);
        hint(compile_try_except, this::compile_try_except, 52);
        hint(compile_try_except, this::compile_try_except, 60);
        hint(compile_try_except, this::compile_try_except, 68);
        hint(compile_try_except, this::compile_try_except, 74);
        hint(compile_try_except, this::compile_try_except, 108);
        hint(compile_try_except, this::compile_try_except, 114);
        hint(compile_try_except, this::compile_try_except, 122);
        hint(compile_try_except, this::compile_try_except, 130);
        hint(compile_try_except, this::compile_try_except, 138);
        hint(compile_try_except, this::compile_try_except, 180);
        hint(compile_try_except, this::compile_try_except, 192);
        hint(compile_try_except, this::compile_try_except, 202);
        hint(compile_try_except, this::compile_try_except, 208);
        hint(compile_try_except, this::compile_try_except, 220);
        hint(compile_try_except, this::compile_try_except, 228);
        hint(compile_try_except, this::compile_try_except, 236);
        hint(compile_try_except, this::compile_try_except, 244);
        hint(compile_try_except, this::compile_try_except, 252);
        hint(compile_try_except, this::compile_try_except, 264);
        hint(compile_try_except, this::compile_try_except, 272);
        hint(compile_try_except, this::compile_try_except, 280);
        hint(compile_try_except, this::compile_try_except, 288);
    }

    private void gen_hints_3() {
        hint(compile_try_except, this::compile_try_except, 302);
        hint(compile_try_except, this::compile_try_except, 344);
        hint(compile_try_except, this::compile_try_except, 352);
        hint(compile_try_except, this::compile_try_except, 360);
        hint(compile_try_except, this::compile_try_except, 370);
        hint(compile_try_except, this::compile_try_except, 382);
        hint(compile_try_except, this::compile_try_except, 398);
        hint(compile_try_except, this::compile_try_except, 404);
        hint(compile_try_finally, this::compile_try_finally, 0);
        hint(compile_try_finally, this::compile_try_finally, 28);
        hint(compile_try_finally, this::compile_try_finally, 34);
        hint(compile_try_finally, this::compile_try_finally, 46);
        hint(compile_try_finally, this::compile_try_finally, 54);
        hint(compile_try_finally, this::compile_try_finally, 64);
        hint(compile_try_finally, this::compile_try_finally, 70);
        hint(compile_try_finally, this::compile_try_finally, 78);
        hint(compile_try_finally, this::compile_try_finally, 86);
        hint(compile_try_finally, this::compile_try_finally, 94);
        hint(compile_try_finally, this::compile_try_finally, 106);
        hint(compile_try_finally, this::compile_try_finally, 126);
        hint(compile_try_stmt, this::compile_try_stmt, 0);
        hint(compile_try_stmt, this::compile_try_stmt, 34);
        hint(compile_try_stmt, this::compile_try_stmt, 52);
        hint(compile_try_stmt, this::compile_try_stmt, 74);
        hint(compile_try_stmt, this::compile_try_stmt, 100);
        hint(compile_async_with_stmt_helper, this::compile_async_with_stmt_helper, 0);
        hint(compile_async_with_stmt_helper, this::compile_async_with_stmt_helper, 22);
        hint(compile_async_with_stmt_helper, this::compile_async_with_stmt_helper, 78);
        hint(compile_async_with_stmt_helper, this::compile_async_with_stmt_helper, 84);
        hint(compile_async_with_stmt_helper, this::compile_async_with_stmt_helper, 92);
        hint(compile_async_with_stmt_helper, this::compile_async_with_stmt_helper, 102);
        hint(compile_async_with_stmt_helper, this::compile_async_with_stmt_helper, 112);
        hint(compile_async_with_stmt_helper, this::compile_async_with_stmt_helper, 118);
        hint(compile_async_with_stmt_helper, this::compile_async_with_stmt_helper, 126);
        hint(compile_async_with_stmt_helper, this::compile_async_with_stmt_helper, 142);
        hint(compile_async_with_stmt_helper, this::compile_async_with_stmt_helper, 152);
        hint(compile_async_with_stmt_helper, this::compile_async_with_stmt_helper, 158);
        hint(compile_async_with_stmt_helper, this::compile_async_with_stmt_helper, 166);
        hint(compile_async_with_stmt_helper, this::compile_async_with_stmt_helper, 172);
        hint(compile_async_with_stmt_helper, this::compile_async_with_stmt_helper, 180);
        hint(compile_async_with_stmt_helper, this::compile_async_with_stmt_helper, 188);
        hint(compile_async_with_stmt_helper, this::compile_async_with_stmt_helper, 194);
        hint(compile_async_with_stmt_helper, this::compile_async_with_stmt_helper, 204);
        hint(compile_async_with_stmt_helper, this::compile_async_with_stmt_helper, 212);
        hint(compile_async_with_stmt_helper, this::compile_async_with_stmt_helper, 222);
        hint(compile_async_with_stmt_helper, this::compile_async_with_stmt_helper, 228);
        hint(compile_async_with_stmt_helper, this::compile_async_with_stmt_helper, 234);
        hint(compile_async_with_stmt_helper, this::compile_async_with_stmt_helper, 240);
        hint(compile_async_with_stmt_helper, this::compile_async_with_stmt_helper, 250);
        hint(compile_async_with_stmt_helper, this::compile_async_with_stmt_helper, 256);
        hint(compile_async_with_stmt_helper, this::compile_async_with_stmt_helper, 262);
        hint(compile_async_with_stmt_helper, this::compile_async_with_stmt_helper, 268);
        hint(compile_async_with_stmt_helper, this::compile_async_with_stmt_helper, 278);
        hint(compile_async_with_stmt_helper, this::compile_async_with_stmt_helper, 284);
        hint(compile_async_with_stmt_helper, this::compile_async_with_stmt_helper, 292);
        hint(compile_async_with_stmt_helper, this::compile_async_with_stmt_helper, 308);
        hint(compile_async_with_stmt_helper, this::compile_async_with_stmt_helper, 314);
        hint(compile_async_with_stmt_helper, this::compile_async_with_stmt_helper, 324);
        hint(compile_async_with_stmt_helper, this::compile_async_with_stmt_helper, 330);
        hint(compile_async_with_stmt_helper, this::compile_async_with_stmt_helper, 338);
        hint(compile_async_with_stmt_helper, this::compile_async_with_stmt_helper, 346);
        hint(compile_async_with_stmt_helper, this::compile_async_with_stmt_helper, 354);
        hint(compile_async_with_stmt_helper, this::compile_async_with_stmt_helper, 362);
        hint(compile_async_with_stmt_helper, this::compile_async_with_stmt_helper, 368);
        hint(compile_async_with_stmt_helper, this::compile_async_with_stmt_helper, 374);
        hint(compile_async_with_stmt_helper, this::compile_async_with_stmt_helper, 382);
        hint(compile_async_with_stmt_helper, this::compile_async_with_stmt_helper, 392);
        hint(compile_async_with_stmt_helper, this::compile_async_with_stmt_helper, 400);
        hint(compile_async_with_stmt_helper, this::compile_async_with_stmt_helper, 406);
        hint(compile_async_with_stmt_helper, this::compile_async_with_stmt_helper, 412);
        hint(compile_async_with_stmt_helper, this::compile_async_with_stmt_helper, 424);
        hint(compile_async_with_stmt_helper, this::compile_async_with_stmt_helper, 430);
        hint(compile_async_with_stmt_helper, this::compile_async_with_stmt_helper, 436);
        hint(compile_async_with_stmt_helper, this::compile_async_with_stmt_helper, 446);
        hint(compile_async_with_stmt_helper, this::compile_async_with_stmt_helper, 454);
        hint(compile_async_with_stmt_helper, this::compile_async_with_stmt_helper, 466);
        hint(compile_async_with_stmt_helper, this::compile_async_with_stmt_helper, 476);
        hint(compile_async_with_stmt_helper, this::compile_async_with_stmt_helper, 482);
        hint(compile_async_with_stmt_helper, this::compile_async_with_stmt_helper, 490);
        hint(compile_async_with_stmt_helper, this::compile_async_with_stmt_helper, 496);
        hint(compile_async_stmt, this::compile_async_stmt, 0);
        hint(compile_async_stmt, this::compile_async_stmt, 22);
        hint(compile_async_stmt, this::compile_async_stmt, 60);
        hint(compile_async_stmt, this::compile_async_stmt, 68);
        hint(compile_async_stmt, this::compile_async_stmt, 76);
        hint(compile_async_stmt, this::compile_async_stmt, 112);
        hint(compile_async_stmt, this::compile_async_stmt, 122);
        hint(compile_async_stmt, this::compile_async_stmt, 128);
        hint(compile_async_stmt, this::compile_async_stmt, 136);
        hint(compile_async_stmt, this::compile_async_stmt, 144);
        hint(compile_async_stmt, this::compile_async_stmt, 154);
        hint(compile_async_stmt, this::compile_async_stmt, 160);
        hint(compile_async_stmt, this::compile_async_stmt, 168);
        hint(compile_async_stmt, this::compile_async_stmt, 176);
        hint(compile_async_stmt, this::compile_async_stmt, 182);
        hint(compile_async_stmt, this::compile_async_stmt, 188);
        hint(compile_async_stmt, this::compile_async_stmt, 198);
        hint(compile_async_stmt, this::compile_async_stmt, 206);
        hint(compile_async_stmt, this::compile_async_stmt, 216);
        hint(compile_async_stmt, this::compile_async_stmt, 222);
        hint(compile_async_stmt, this::compile_async_stmt, 228);
        hint(compile_async_stmt, this::compile_async_stmt, 236);
        hint(compile_async_stmt, this::compile_async_stmt, 244);
        hint(compile_async_stmt, this::compile_async_stmt, 252);
        hint(compile_async_stmt, this::compile_async_stmt, 264);
        hint(compile_async_stmt, this::compile_async_stmt, 270);
        hint(compile_async_stmt, this::compile_async_stmt, 278);
        hint(compile_async_stmt, this::compile_async_stmt, 286);
        hint(compile_async_stmt, this::compile_async_stmt, 294);
        hint(compile_async_stmt, this::compile_async_stmt, 314);
        hint(compile_async_stmt, this::compile_async_stmt, 322);
        hint(compile_async_stmt, this::compile_async_stmt, 330);
        hint(compile_async_stmt, this::compile_async_stmt, 344);
        hint(compile_async_stmt, this::compile_async_stmt, 356);
        hint(compile_yield_expr, this::compile_yield_expr, 0);
        hint(compile_yield_expr, this::compile_yield_expr, 22);
        hint(compile_yield_expr, this::compile_yield_expr, 38);
        hint(compile_yield_expr, this::compile_yield_expr, 46);
        hint(compile_yield_expr, this::compile_yield_expr, 68);
        hint(compile_yield_expr, this::compile_yield_expr, 76);
        hint(compile_yield_expr, this::compile_yield_expr, 86);
        hint(compile_return_stmt, this::compile_return_stmt, 0);
        hint(compile_return_stmt, this::compile_return_stmt, 18);
        hint(compile_return_stmt, this::compile_return_stmt, 34);
        hint(compile_return_stmt, this::compile_return_stmt, 40);
        hint(compile_return_stmt, this::compile_return_stmt, 72);
        hint(compile_return_stmt, this::compile_return_stmt, 80);
        hint(compile_return_stmt, this::compile_return_stmt, 86);
        hint(compile_return_stmt, this::compile_return_stmt, 94);
        hint(compile_return_stmt, this::compile_return_stmt, 102);
        hint(compile_atom_paren, this::compile_atom_paren, 0);
        hint(compile_atom_paren, this::compile_atom_paren, 34);
        hint(compile_atom_paren, this::compile_atom_paren, 54);
        hint(compile_atom_expr_await, this::compile_atom_expr_await, 0);
        hint(compile_atom_expr_await, this::compile_atom_expr_await, 22);
        hint(compile_atom_expr_await, this::compile_atom_expr_await, 30);
        hint(compile_atom_expr_await, this::compile_atom_expr_await, 38);
        hint(compile_assert_stmt, this::compile_assert_stmt, 0);
        hint(compile_assert_stmt, this::compile_assert_stmt, 34);
        hint(compile_assert_stmt, this::compile_assert_stmt, 44);
        hint(compile_assert_stmt, this::compile_assert_stmt, 56);
        hint(compile_assert_stmt, this::compile_assert_stmt, 68);
        hint(compile_assert_stmt, this::compile_assert_stmt, 76);
        hint(compile_assert_stmt, this::compile_assert_stmt, 84);
        hint(compile_raise_stmt, this::compile_raise_stmt, 0);
        hint(compile_raise_stmt, this::compile_raise_stmt, 28);
        hint(compile_raise_stmt, this::compile_raise_stmt, 36);
        hint(compile_raise_stmt, this::compile_raise_stmt, 44);
        hint(compile_raise_stmt, this::compile_raise_stmt, 54);
        hint(compile_global_nonlocal_stmt, this::compile_global_nonlocal_stmt, 0);
        hint(compile_global_nonlocal_stmt, this::compile_global_nonlocal_stmt, 38);
        hint(compile_global_nonlocal_stmt, this::compile_global_nonlocal_stmt, 54);
        hint(compile_global_nonlocal_stmt, this::compile_global_nonlocal_stmt, 86);
        hint(compile_global_nonlocal_stmt, this::compile_global_nonlocal_stmt, 122);
        hint(compile_global_nonlocal_stmt, this::compile_global_nonlocal_stmt, 148);
        hint(compile_global_nonlocal_stmt, this::compile_global_nonlocal_stmt, 164);
        hint(do_import_name_isra_19, this::do_import_name_isra_19, 0);
        hint(do_import_name_isra_19, this::do_import_name_isra_19, 72);
        hint(do_import_name_isra_19, this::do_import_name_isra_19, 116);
        hint(do_import_name_isra_19, this::do_import_name_isra_19, 136);
        hint(do_import_name_isra_19, this::do_import_name_isra_19, 152);
        hint(do_import_name_isra_19, this::do_import_name_isra_19, 182);
        hint(do_import_name_isra_19, this::do_import_name_isra_19, 200);
        hint(do_import_name_isra_19, this::do_import_name_isra_19, 232);
        hint(do_import_name_isra_19, this::do_import_name_isra_19, 242);
        hint(compile_import_from, this::compile_import_from, 0);
        hint(compile_import_from, this::compile_import_from, 48);
        hint(compile_import_from, this::compile_import_from, 76);
        hint(compile_import_from, this::compile_import_from, 84);
        hint(compile_import_from, this::compile_import_from, 94);
        hint(compile_import_from, this::compile_import_from, 104);
        hint(compile_import_from, this::compile_import_from, 114);
        hint(compile_import_from, this::compile_import_from, 160);
        hint(compile_import_from, this::compile_import_from, 172);
        hint(compile_import_from, this::compile_import_from, 192);
        hint(compile_import_from, this::compile_import_from, 202);
        hint(compile_import_from, this::compile_import_from, 216);
        hint(compile_import_from, this::compile_import_from, 234);
        hint(compile_import_from, this::compile_import_from, 254);
        hint(compile_import_from, this::compile_import_from, 268);
        hint(compile_dotted_as_name, this::compile_dotted_as_name, 0);
        hint(compile_dotted_as_name, this::compile_dotted_as_name, 14);
        hint(compile_dotted_as_name, this::compile_dotted_as_name, 22);
        hint(compile_dotted_as_name, this::compile_dotted_as_name, 34);
        hint(compile_dotted_as_name, this::compile_dotted_as_name, 42);
        hint(mp_compile, this::mp_compile, 0);
        hint(mp_compile, this::mp_compile, 22);
        hint(mp_compile, this::mp_compile, 48);
        hint(mp_compile, this::mp_compile, 54);
        hint(mp_compile, this::mp_compile, 94);
        hint(mp_compile, this::mp_compile, 118);
        hint(mp_compile, this::mp_compile, 134);
        hint(mp_compile, this::mp_compile, 140);
        hint(mp_compile, this::mp_compile, 146);
        hint(mp_compile, this::mp_compile, 160);
        hint(mp_compile, this::mp_compile, 178);
        hint(mp_compile, this::mp_compile, 188);
        hint(mp_compile, this::mp_compile, 548);
        hint(mp_compile, this::mp_compile, 566);
        hint(mp_compile, this::mp_compile, 584);
        hint(mp_compile, this::mp_compile, 598);
        hint(mp_emit_common_get_id_for_load, this::mp_emit_common_get_id_for_load, 0);
        hint(mp_emit_common_get_id_for_load, this::mp_emit_common_get_id_for_load, 16);
        hint(mp_emit_common_get_id_for_load, this::mp_emit_common_get_id_for_load, 32);
        hint(mp_emit_common_get_id_for_modification, this::mp_emit_common_get_id_for_modification, 0);
        hint(mp_emit_common_get_id_for_modification, this::mp_emit_common_get_id_for_modification, 14);
        hint(mp_emit_common_id_op, this::mp_emit_common_id_op, 0);
        hint(mp_emit_common_id_op, this::mp_emit_common_id_op, 16);
        hint(mp_emit_common_id_op, this::mp_emit_common_id_op, 32);
        hint(mp_emit_common_id_op, this::mp_emit_common_id_op, 54);
        hint(emit_write_uint, this::emit_write_uint, 0);
        hint(emit_write_uint, this::emit_write_uint, 32);
        hint(emit_get_cur_to_write_code_info, this::emit_get_cur_to_write_code_info, 0);
        hint(emit_write_code_info_byte, this::emit_write_code_info_byte, 0);
        hint(emit_write_code_info_byte, this::emit_write_code_info_byte, 10);
        hint(emit_get_cur_to_write_bytecode, this::emit_get_cur_to_write_bytecode, 0);
        hint(emit_write_bytecode_byte, this::emit_write_bytecode_byte, 0);
        hint(emit_write_bytecode_byte, this::emit_write_bytecode_byte, 10);
        hint(emit_write_bytecode_byte_uint, this::emit_write_bytecode_byte_uint, 0);
        hint(emit_write_bytecode_byte_uint, this::emit_write_bytecode_byte_uint, 10);
        hint(emit_write_bytecode_byte_uint, this::emit_write_bytecode_byte_uint, 20);
        hint(emit_write_bytecode_byte_raw_code, this::emit_write_bytecode_byte_raw_code, 0);
        hint(emit_write_bytecode_byte_raw_code, this::emit_write_bytecode_byte_raw_code, 40);
        hint(mp_emit_bc_delete_local, this::mp_emit_bc_delete_local, 0);
        hint(mp_emit_bc_delete_local, this::mp_emit_bc_delete_local, 10);
        hint(emit_write_bytecode_byte_qstr, this::emit_write_bytecode_byte_qstr, 0);
        hint(emit_write_bytecode_byte_qstr, this::emit_write_bytecode_byte_qstr, 12);
        hint(emit_write_bytecode_byte_unsigned_label, this::emit_write_bytecode_byte_unsigned_label, 0);
        hint(emit_write_bytecode_byte_unsigned_label, this::emit_write_bytecode_byte_unsigned_label, 32);
        hint(emit_write_bytecode_byte_signed_label, this::emit_write_bytecode_byte_signed_label, 0);
        hint(emit_write_bytecode_byte_signed_label, this::emit_write_bytecode_byte_signed_label, 32);
        hint(emit_write_bytecode_byte_obj_constprop_8, this::emit_write_bytecode_byte_obj_constprop_8, 0);
        hint(emit_write_bytecode_byte_obj_constprop_8, this::emit_write_bytecode_byte_obj_constprop_8, 36);
        hint(emit_bc_new, this::emit_bc_new, 0);
        hint(emit_bc_new, this::emit_bc_new, 8);
        hint(emit_bc_set_max_num_labels, this::emit_bc_set_max_num_labels, 0);
        hint(emit_bc_set_max_num_labels, this::emit_bc_set_max_num_labels, 12);
        hint(emit_bc_free, this::emit_bc_free, 0);
        hint(emit_bc_free, this::emit_bc_free, 14);
        hint(emit_bc_free, this::emit_bc_free, 22);
        hint(mp_emit_bc_start_pass, this::mp_emit_bc_start_pass, 0);
        hint(mp_emit_bc_start_pass, this::mp_emit_bc_start_pass, 50);
        hint(mp_emit_bc_start_pass, this::mp_emit_bc_start_pass, 60);
        hint(mp_emit_bc_start_pass, this::mp_emit_bc_start_pass, 70);
        hint(mp_emit_bc_start_pass, this::mp_emit_bc_start_pass, 80);
        hint(mp_emit_bc_start_pass, this::mp_emit_bc_start_pass, 90);
        hint(mp_emit_bc_start_pass, this::mp_emit_bc_start_pass, 100);
        hint(mp_emit_bc_start_pass, this::mp_emit_bc_start_pass, 118);
        hint(mp_emit_bc_start_pass, this::mp_emit_bc_start_pass, 128);
        hint(mp_emit_bc_start_pass, this::mp_emit_bc_start_pass, 144);
        hint(mp_emit_bc_start_pass, this::mp_emit_bc_start_pass, 166);
        hint(mp_emit_bc_start_pass, this::mp_emit_bc_start_pass, 208);
        hint(mp_emit_bc_start_pass, this::mp_emit_bc_start_pass, 230);
        hint(mp_emit_bc_end_pass, this::mp_emit_bc_end_pass, 0);
        hint(mp_emit_bc_end_pass, this::mp_emit_bc_end_pass, 16);
        hint(mp_emit_bc_end_pass, this::mp_emit_bc_end_pass, 40);
        hint(mp_emit_bc_end_pass, this::mp_emit_bc_end_pass, 64);
        hint(mp_emit_bc_end_pass, this::mp_emit_bc_end_pass, 86);
        hint(mp_emit_bc_last_emit_was_return_value, this::mp_emit_bc_last_emit_was_return_value, 0);
        hint(mp_emit_bc_adjust_stack_size, this::mp_emit_bc_adjust_stack_size, 0);
        hint(mp_emit_bc_load_local, this::mp_emit_bc_load_local, 0);
        hint(mp_emit_bc_load_local, this::mp_emit_bc_load_local, 14);
        hint(mp_emit_bc_load_local, this::mp_emit_bc_load_local, 34);
        hint(mp_emit_bc_load_local, this::mp_emit_bc_load_local, 48);
        hint(mp_emit_bc_load_global, this::mp_emit_bc_load_global, 0);
        hint(mp_emit_bc_load_global, this::mp_emit_bc_load_global, 16);
        hint(mp_emit_bc_load_global, this::mp_emit_bc_load_global, 26);
        hint(mp_emit_bc_load_global, this::mp_emit_bc_load_global, 42);
        hint(mp_emit_bc_store_local, this::mp_emit_bc_store_local, 0);
        hint(mp_emit_bc_store_local, this::mp_emit_bc_store_local, 16);
        hint(mp_emit_bc_store_local, this::mp_emit_bc_store_local, 36);
        hint(mp_emit_bc_store_local, this::mp_emit_bc_store_local, 50);
        hint(mp_emit_bc_store_global, this::mp_emit_bc_store_global, 0);
        hint(mp_emit_bc_store_global, this::mp_emit_bc_store_global, 16);
        hint(mp_emit_bc_store_global, this::mp_emit_bc_store_global, 30);
        hint(mp_emit_bc_delete_global, this::mp_emit_bc_delete_global, 0);
        hint(mp_emit_bc_delete_global, this::mp_emit_bc_delete_global, 16);
        hint(mp_emit_bc_delete_global, this::mp_emit_bc_delete_global, 26);
        hint(emit_bc_call_function_method_helper, this::emit_bc_call_function_method_helper, 0);
        hint(emit_bc_call_function_method_helper, this::emit_bc_call_function_method_helper, 34);
        hint(emit_bc_call_function_method_helper, this::emit_bc_call_function_method_helper, 46);
        hint(emit_bc_call_function_method_helper, this::emit_bc_call_function_method_helper, 54);
        hint(mp_emit_bc_set_source_line, this::mp_emit_bc_set_source_line, 0);
        hint(mp_emit_bc_set_source_line, this::mp_emit_bc_set_source_line, 90);
        hint(mp_emit_bc_set_source_line, this::mp_emit_bc_set_source_line, 124);
        hint(mp_emit_bc_label_assign, this::mp_emit_bc_label_assign, 0);
        hint(mp_emit_bc_label_assign, this::mp_emit_bc_label_assign, 12);
        hint(mp_emit_bc_import, this::mp_emit_bc_import, 0);
        hint(mp_emit_bc_import, this::mp_emit_bc_import, 18);
        hint(mp_emit_bc_import, this::mp_emit_bc_import, 32);
        hint(mp_emit_bc_import, this::mp_emit_bc_import, 42);
        hint(mp_emit_bc_import, this::mp_emit_bc_import, 54);
        hint(mp_emit_bc_load_const_tok, this::mp_emit_bc_load_const_tok, 0);
        hint(mp_emit_bc_load_const_tok, this::mp_emit_bc_load_const_tok, 12);
        hint(mp_emit_bc_load_const_tok, this::mp_emit_bc_load_const_tok, 34);
        hint(mp_emit_bc_load_const_tok, this::mp_emit_bc_load_const_tok, 44);
        hint(mp_emit_bc_load_const_small_int, this::mp_emit_bc_load_const_small_int, 0);
        hint(mp_emit_bc_load_const_small_int, this::mp_emit_bc_load_const_small_int, 12);
        hint(mp_emit_bc_load_const_small_int, this::mp_emit_bc_load_const_small_int, 32);
        hint(mp_emit_bc_load_const_small_int, this::mp_emit_bc_load_const_small_int, 42);
        hint(mp_emit_bc_load_const_small_int, this::mp_emit_bc_load_const_small_int, 96);
        hint(mp_emit_bc_load_const_str, this::mp_emit_bc_load_const_str, 0);
        hint(mp_emit_bc_load_const_str, this::mp_emit_bc_load_const_str, 12);
        hint(mp_emit_bc_load_const_str, this::mp_emit_bc_load_const_str, 22);
        hint(mp_emit_bc_load_const_obj, this::mp_emit_bc_load_const_obj, 0);
        hint(mp_emit_bc_load_const_obj, this::mp_emit_bc_load_const_obj, 12);
        hint(mp_emit_bc_load_const_obj, this::mp_emit_bc_load_const_obj, 20);
        hint(mp_emit_bc_load_null, this::mp_emit_bc_load_null, 0);
        hint(mp_emit_bc_load_null, this::mp_emit_bc_load_null, 10);
        hint(mp_emit_bc_load_null, this::mp_emit_bc_load_null, 18);
        hint(mp_emit_bc_load_method, this::mp_emit_bc_load_method, 0);
        hint(mp_emit_bc_load_method, this::mp_emit_bc_load_method, 18);
        hint(mp_emit_bc_load_method, this::mp_emit_bc_load_method, 34);
        hint(mp_emit_bc_load_build_class, this::mp_emit_bc_load_build_class, 0);
        hint(mp_emit_bc_load_build_class, this::mp_emit_bc_load_build_class, 10);
        hint(mp_emit_bc_load_build_class, this::mp_emit_bc_load_build_class, 18);
        hint(mp_emit_bc_dup_top, this::mp_emit_bc_dup_top, 0);
        hint(mp_emit_bc_dup_top, this::mp_emit_bc_dup_top, 10);
        hint(mp_emit_bc_dup_top, this::mp_emit_bc_dup_top, 18);
        hint(mp_emit_bc_dup_top_two, this::mp_emit_bc_dup_top_two, 0);
        hint(mp_emit_bc_dup_top_two, this::mp_emit_bc_dup_top_two, 10);
        hint(mp_emit_bc_dup_top_two, this::mp_emit_bc_dup_top_two, 18);
        hint(mp_emit_bc_pop_top, this::mp_emit_bc_pop_top, 0);
        hint(mp_emit_bc_pop_top, this::mp_emit_bc_pop_top, 12);
        hint(mp_emit_bc_pop_top, this::mp_emit_bc_pop_top, 20);
        hint(mp_emit_bc_rot_two, this::mp_emit_bc_rot_two, 0);
        hint(mp_emit_bc_rot_two, this::mp_emit_bc_rot_two, 10);
        hint(mp_emit_bc_rot_two, this::mp_emit_bc_rot_two, 18);
        hint(mp_emit_bc_attr, this::mp_emit_bc_attr, 0);
        hint(mp_emit_bc_attr, this::mp_emit_bc_attr, 16);
        hint(mp_emit_bc_attr, this::mp_emit_bc_attr, 26);
        hint(mp_emit_bc_attr, this::mp_emit_bc_attr, 42);
        hint(mp_emit_bc_attr, this::mp_emit_bc_attr, 52);
        hint(mp_emit_bc_attr, this::mp_emit_bc_attr, 58);
        hint(mp_emit_bc_attr, this::mp_emit_bc_attr, 68);
        hint(mp_emit_bc_rot_three, this::mp_emit_bc_rot_three, 0);
        hint(mp_emit_bc_rot_three, this::mp_emit_bc_rot_three, 10);
        hint(mp_emit_bc_rot_three, this::mp_emit_bc_rot_three, 18);
        hint(mp_emit_bc_subscr, this::mp_emit_bc_subscr, 0);
        hint(mp_emit_bc_subscr, this::mp_emit_bc_subscr, 14);
        hint(mp_emit_bc_subscr, this::mp_emit_bc_subscr, 22);
        hint(mp_emit_bc_subscr, this::mp_emit_bc_subscr, 32);
        hint(mp_emit_bc_subscr, this::mp_emit_bc_subscr, 38);
        hint(mp_emit_bc_subscr, this::mp_emit_bc_subscr, 48);
        hint(mp_emit_bc_jump, this::mp_emit_bc_jump, 0);
        hint(mp_emit_bc_jump, this::mp_emit_bc_jump, 12);
        hint(mp_emit_bc_jump, this::mp_emit_bc_jump, 22);
        hint(mp_emit_bc_pop_jump_if, this::mp_emit_bc_pop_jump_if, 0);
        hint(mp_emit_bc_pop_jump_if, this::mp_emit_bc_pop_jump_if, 16);
        hint(mp_emit_bc_pop_jump_if, this::mp_emit_bc_pop_jump_if, 32);
        hint(mp_emit_bc_jump_if_or_pop, this::mp_emit_bc_jump_if_or_pop, 0);
        hint(mp_emit_bc_jump_if_or_pop, this::mp_emit_bc_jump_if_or_pop, 16);
        hint(mp_emit_bc_jump_if_or_pop, this::mp_emit_bc_jump_if_or_pop, 32);
        hint(mp_emit_bc_unwind_jump, this::mp_emit_bc_unwind_jump, 0);
        hint(mp_emit_bc_unwind_jump, this::mp_emit_bc_unwind_jump, 22);
        hint(mp_emit_bc_unwind_jump, this::mp_emit_bc_unwind_jump, 34);
        hint(mp_emit_bc_unwind_jump, this::mp_emit_bc_unwind_jump, 42);
        hint(mp_emit_bc_unwind_jump, this::mp_emit_bc_unwind_jump, 50);
        hint(mp_emit_bc_unwind_jump, this::mp_emit_bc_unwind_jump, 58);
        hint(mp_emit_bc_unwind_jump, this::mp_emit_bc_unwind_jump, 68);
        hint(mp_emit_bc_unwind_jump, this::mp_emit_bc_unwind_jump, 78);
        hint(mp_emit_bc_unwind_jump, this::mp_emit_bc_unwind_jump, 94);
        hint(mp_emit_bc_setup_block, this::mp_emit_bc_setup_block, 0);
        hint(mp_emit_bc_setup_block, this::mp_emit_bc_setup_block, 24);
        hint(mp_emit_bc_setup_block, this::mp_emit_bc_setup_block, 34);
        hint(mp_emit_bc_end_finally, this::mp_emit_bc_end_finally, 0);
        hint(mp_emit_bc_end_finally, this::mp_emit_bc_end_finally, 12);
        hint(mp_emit_bc_end_finally, this::mp_emit_bc_end_finally, 20);
        hint(mp_emit_bc_get_iter, this::mp_emit_bc_get_iter, 0);
        hint(mp_emit_bc_get_iter, this::mp_emit_bc_get_iter, 22);
        hint(mp_emit_bc_get_iter, this::mp_emit_bc_get_iter, 36);
        hint(mp_emit_bc_for_iter, this::mp_emit_bc_for_iter, 0);
        hint(mp_emit_bc_for_iter, this::mp_emit_bc_for_iter, 12);
        hint(mp_emit_bc_for_iter, this::mp_emit_bc_for_iter, 22);
        hint(mp_emit_bc_for_iter_end, this::mp_emit_bc_for_iter_end, 0);
        hint(mp_emit_bc_for_iter_end, this::mp_emit_bc_for_iter_end, 10);
        hint(mp_emit_bc_pop_block, this::mp_emit_bc_pop_block, 0);
        hint(mp_emit_bc_pop_block, this::mp_emit_bc_pop_block, 10);
        hint(mp_emit_bc_pop_block, this::mp_emit_bc_pop_block, 18);
        hint(mp_emit_bc_with_cleanup, this::mp_emit_bc_with_cleanup, 0);
        hint(mp_emit_bc_with_cleanup, this::mp_emit_bc_with_cleanup, 10);
        hint(mp_emit_bc_with_cleanup, this::mp_emit_bc_with_cleanup, 18);
        hint(mp_emit_bc_with_cleanup, this::mp_emit_bc_with_cleanup, 26);
        hint(mp_emit_bc_with_cleanup, this::mp_emit_bc_with_cleanup, 34);
        hint(mp_emit_bc_with_cleanup, this::mp_emit_bc_with_cleanup, 42);
        hint(mp_emit_bc_with_cleanup, this::mp_emit_bc_with_cleanup, 52);
        hint(mp_emit_bc_pop_except, this::mp_emit_bc_pop_except, 0);
        hint(mp_emit_bc_pop_except, this::mp_emit_bc_pop_except, 10);
        hint(mp_emit_bc_pop_except, this::mp_emit_bc_pop_except, 18);
        hint(mp_emit_bc_unary_op, this::mp_emit_bc_unary_op, 0);
        hint(mp_emit_bc_unary_op, this::mp_emit_bc_unary_op, 12);
        hint(mp_emit_bc_unary_op, this::mp_emit_bc_unary_op, 24);
        hint(mp_emit_bc_binary_op, this::mp_emit_bc_binary_op, 0);
        hint(mp_emit_bc_binary_op, this::mp_emit_bc_binary_op, 32);
        hint(mp_emit_bc_binary_op, this::mp_emit_bc_binary_op, 40);
        hint(mp_emit_bc_binary_op, this::mp_emit_bc_binary_op, 52);
        hint(mp_emit_bc_binary_op, this::mp_emit_bc_binary_op, 60);
        hint(mp_emit_bc_build, this::mp_emit_bc_build, 0);
        hint(mp_emit_bc_build, this::mp_emit_bc_build, 20);
        hint(mp_emit_bc_build, this::mp_emit_bc_build, 34);
        hint(mp_emit_bc_store_map, this::mp_emit_bc_store_map, 0);
        hint(mp_emit_bc_store_map, this::mp_emit_bc_store_map, 12);
        hint(mp_emit_bc_store_map, this::mp_emit_bc_store_map, 20);
        hint(mp_emit_bc_store_comp, this::mp_emit_bc_store_comp, 0);
        hint(mp_emit_bc_store_comp, this::mp_emit_bc_store_comp, 26);
        hint(mp_emit_bc_store_comp, this::mp_emit_bc_store_comp, 40);
        hint(mp_emit_bc_unpack_sequence, this::mp_emit_bc_unpack_sequence, 0);
        hint(mp_emit_bc_unpack_sequence, this::mp_emit_bc_unpack_sequence, 12);
        hint(mp_emit_bc_unpack_sequence, this::mp_emit_bc_unpack_sequence, 22);
        hint(mp_emit_bc_unpack_ex, this::mp_emit_bc_unpack_ex, 0);
        hint(mp_emit_bc_unpack_ex, this::mp_emit_bc_unpack_ex, 14);
        hint(mp_emit_bc_unpack_ex, this::mp_emit_bc_unpack_ex, 26);
        hint(mp_emit_bc_make_function, this::mp_emit_bc_make_function, 0);
        hint(mp_emit_bc_make_function, this::mp_emit_bc_make_function, 18);
        hint(mp_emit_bc_make_function, this::mp_emit_bc_make_function, 28);
        hint(mp_emit_bc_make_function, this::mp_emit_bc_make_function, 36);
        hint(mp_emit_bc_make_closure, this::mp_emit_bc_make_closure, 0);
        hint(mp_emit_bc_make_closure, this::mp_emit_bc_make_closure, 22);
        hint(mp_emit_bc_make_closure, this::mp_emit_bc_make_closure, 32);
        hint(mp_emit_bc_make_closure, this::mp_emit_bc_make_closure, 40);
        hint(mp_emit_bc_make_closure, this::mp_emit_bc_make_closure, 48);
        hint(mp_emit_bc_call_function, this::mp_emit_bc_call_function, 0);
        hint(mp_emit_bc_call_function, this::mp_emit_bc_call_function, 16);
        hint(mp_emit_bc_call_method, this::mp_emit_bc_call_method, 0);
        hint(mp_emit_bc_call_method, this::mp_emit_bc_call_method, 18);
        hint(mp_emit_bc_return_value, this::mp_emit_bc_return_value, 0);
        hint(mp_emit_bc_return_value, this::mp_emit_bc_return_value, 12);
        hint(mp_emit_bc_return_value, this::mp_emit_bc_return_value, 24);
        hint(mp_emit_bc_raise_varargs, this::mp_emit_bc_raise_varargs, 0);
        hint(mp_emit_bc_raise_varargs, this::mp_emit_bc_raise_varargs, 12);
        hint(mp_emit_bc_raise_varargs, this::mp_emit_bc_raise_varargs, 20);
        hint(mp_emit_bc_yield, this::mp_emit_bc_yield, 0);
        hint(mp_emit_bc_yield, this::mp_emit_bc_yield, 12);
        hint(mp_emit_bc_yield, this::mp_emit_bc_yield, 32);
        hint(mp_emit_bc_start_except_handler, this::mp_emit_bc_start_except_handler, 0);
        hint(mp_emit_bc_start_except_handler, this::mp_emit_bc_start_except_handler, 8);
        hint(mp_emit_bc_end_except_handler, this::mp_emit_bc_end_except_handler, 0);
        hint(mp_emit_bc_end_except_handler, this::mp_emit_bc_end_except_handler, 10);
        hint(mp_format_float, this::mp_format_float, 0);
        hint(mp_format_float, this::mp_format_float, 74);
        hint(mp_format_float, this::mp_format_float, 126);
        hint(mp_format_float, this::mp_format_float, 138);
        hint(mp_format_float, this::mp_format_float, 194);
        hint(mp_format_float, this::mp_format_float, 316);
        hint(mp_format_float, this::mp_format_float, 356);
        hint(mp_format_float, this::mp_format_float, 364);
        hint(mp_format_float, this::mp_format_float, 370);
        hint(mp_format_float, this::mp_format_float, 426);
        hint(mp_format_float, this::mp_format_float, 456);
        hint(mp_format_float, this::mp_format_float, 476);
        hint(mp_format_float, this::mp_format_float, 514);
        hint(mp_format_float, this::mp_format_float, 538);
        hint(mp_format_float, this::mp_format_float, 638);
        hint(mp_format_float, this::mp_format_float, 644);
        hint(mp_format_float, this::mp_format_float, 656);
        hint(mp_format_float, this::mp_format_float, 770);
        hint(mp_format_float, this::mp_format_float, 790);
        hint(mp_format_float, this::mp_format_float, 814);
        hint(mp_format_float, this::mp_format_float, 826);
        hint(mp_format_float, this::mp_format_float, 1012);
        hint(mp_format_float, this::mp_format_float, 1196);
        hint(mp_parse_num_base, this::mp_parse_num_base, 0);
        hint(unlikely_raise_exc, this::unlikely_raise_exc, 0);
        hint(unlikely_raise_exc, this::unlikely_raise_exc, 22);
        hint(unlikely_raise_exc, this::unlikely_raise_exc, 28);
        hint(mp_parse_num_integer, this::mp_parse_num_integer, 0);
        hint(mp_parse_num_integer, this::mp_parse_num_integer, 28);
        hint(mp_parse_num_integer, this::mp_parse_num_integer, 40);
        hint(mp_parse_num_integer, this::mp_parse_num_integer, 64);
        hint(mp_parse_num_integer, this::mp_parse_num_integer, 102);
        hint(mp_parse_num_integer, this::mp_parse_num_integer, 112);
        hint(mp_parse_num_integer, this::mp_parse_num_integer, 124);
        hint(mp_parse_num_integer, this::mp_parse_num_integer, 132);
        hint(mp_parse_num_integer, this::mp_parse_num_integer, 140);
        hint(mp_parse_num_integer, this::mp_parse_num_integer, 146);
        hint(mp_parse_num_integer, this::mp_parse_num_integer, 208);
        hint(mp_parse_num_integer, this::mp_parse_num_integer, 242);
        hint(mp_parse_num_integer, this::mp_parse_num_integer, 272);
        hint(mp_parse_num_decimal, this::mp_parse_num_decimal, 0);
        hint(mp_parse_num_decimal, this::mp_parse_num_decimal, 24);
        hint(mp_parse_num_decimal, this::mp_parse_num_decimal, 222);
        hint(mp_parse_num_decimal, this::mp_parse_num_decimal, 228);
        hint(mp_parse_num_decimal, this::mp_parse_num_decimal, 302);
        hint(mp_parse_num_decimal, this::mp_parse_num_decimal, 312);
        hint(mp_parse_num_decimal, this::mp_parse_num_decimal, 320);
        hint(mp_parse_num_decimal, this::mp_parse_num_decimal, 328);
        hint(mp_parse_num_decimal, this::mp_parse_num_decimal, 362);
        hint(mp_parse_num_decimal, this::mp_parse_num_decimal, 374);
        hint(mp_parse_num_decimal, this::mp_parse_num_decimal, 382);
        hint(mp_parse_num_decimal, this::mp_parse_num_decimal, 388);
        hint(mp_parse_num_decimal, this::mp_parse_num_decimal, 514);
        hint(mp_parse_num_decimal, this::mp_parse_num_decimal, 540);
        hint(mp_parse_num_decimal, this::mp_parse_num_decimal, 562);
        hint(mp_emit_glue_new_raw_code, this::mp_emit_glue_new_raw_code, 0);
        hint(mp_emit_glue_new_raw_code, this::mp_emit_glue_new_raw_code, 8);
        hint(mp_emit_glue_assign_bytecode, this::mp_emit_glue_assign_bytecode, 0);
        hint(mp_make_function_from_raw_code, this::mp_make_function_from_raw_code, 0);
        hint(mp_make_function_from_raw_code, this::mp_make_function_from_raw_code, 16);
        hint(mp_make_closure_from_raw_code, this::mp_make_closure_from_raw_code, 0);
        hint(mp_make_closure_from_raw_code, this::mp_make_closure_from_raw_code, 24);
    }

    private void gen_hints_4() {
        hint(mp_make_closure_from_raw_code, this::mp_make_closure_from_raw_code, 40);
        hint(read_bytes, this::read_bytes, 0);
        hint(read_bytes, this::read_bytes, 20);
        hint(read_uint, this::read_uint, 0);
        hint(read_uint, this::read_uint, 14);
        hint(load_qstr, this::load_qstr, 0);
        hint(load_qstr, this::load_qstr, 8);
        hint(load_qstr, this::load_qstr, 14);
        hint(load_qstr, this::load_qstr, 26);
        hint(load_qstr, this::load_qstr, 34);
        hint(load_qstr, this::load_qstr, 44);
        hint(load_raw_code, this::load_raw_code, 0);
        hint(load_raw_code, this::load_raw_code, 10);
        hint(load_raw_code, this::load_raw_code, 16);
        hint(load_raw_code, this::load_raw_code, 28);
        hint(load_raw_code, this::load_raw_code, 38);
        hint(load_raw_code, this::load_raw_code, 44);
        hint(load_raw_code, this::load_raw_code, 80);
        hint(load_raw_code, this::load_raw_code, 104);
        hint(load_raw_code, this::load_raw_code, 112);
        hint(load_raw_code, this::load_raw_code, 148);
        hint(load_raw_code, this::load_raw_code, 156);
        hint(load_raw_code, this::load_raw_code, 176);
        hint(load_raw_code, this::load_raw_code, 224);
        hint(load_raw_code, this::load_raw_code, 236);
        hint(load_raw_code, this::load_raw_code, 250);
        hint(load_raw_code, this::load_raw_code, 260);
        hint(load_raw_code, this::load_raw_code, 278);
        hint(load_raw_code, this::load_raw_code, 292);
        hint(load_raw_code, this::load_raw_code, 306);
        hint(load_raw_code, this::load_raw_code, 316);
        hint(load_raw_code, this::load_raw_code, 326);
        hint(load_raw_code, this::load_raw_code, 352);
        hint(load_raw_code, this::load_raw_code, 362);
        hint(load_raw_code, this::load_raw_code, 388);
        hint(load_raw_code, this::load_raw_code, 396);
        hint(mp_raw_code_load, this::mp_raw_code_load, 0);
        hint(mp_raw_code_load, this::mp_raw_code_load, 14);
        hint(mp_raw_code_load, this::mp_raw_code_load, 44);
        hint(mp_raw_code_load, this::mp_raw_code_load, 50);
        hint(mp_raw_code_load, this::mp_raw_code_load, 58);
        hint(mp_raw_code_load_file, this::mp_raw_code_load_file, 0);
        hint(mp_raw_code_load_file, this::mp_raw_code_load_file, 10);
        hint(mp_raw_code_load_file, this::mp_raw_code_load_file, 16);
        hint(mp_init, this::mp_init, 0);
        hint(mp_init, this::mp_init, 6);
        hint(mp_init, this::mp_init, 32);
        hint(mp_init, this::mp_init, 58);
        hint(mp_init, this::mp_init, 68);
        hint(mp_init, this::mp_init, 78);
        hint(mp_deinit, this::mp_deinit, 0);
        hint(mp_load_global, this::mp_load_global, 0);
        hint(mp_load_global, this::mp_load_global, 24);
        hint(mp_load_global, this::mp_load_global, 46);
        hint(mp_load_global, this::mp_load_global, 64);
        hint(mp_load_global, this::mp_load_global, 78);
        hint(mp_load_global, this::mp_load_global, 82);
        hint(mp_load_name, this::mp_load_name, 0);
        hint(mp_load_name, this::mp_load_name, 28);
        hint(mp_load_name, this::mp_load_name, 42);
        hint(mp_load_build_class, this::mp_load_build_class, 0);
        hint(mp_load_build_class, this::mp_load_build_class, 28);
        hint(mp_store_name, this::mp_store_name, 0);
        hint(mp_store_name, this::mp_store_name, 18);
        hint(mp_delete_name, this::mp_delete_name, 0);
        hint(mp_delete_name, this::mp_delete_name, 16);
        hint(mp_store_global, this::mp_store_global, 0);
        hint(mp_store_global, this::mp_store_global, 18);
        hint(mp_delete_global, this::mp_delete_global, 0);
        hint(mp_delete_global, this::mp_delete_global, 16);
        hint(mp_unary_op, this::mp_unary_op, 0);
        hint(mp_unary_op, this::mp_unary_op, 16);
        hint(mp_unary_op, this::mp_unary_op, 110);
        hint(mp_unary_op, this::mp_unary_op, 170);
        hint(mp_unary_op, this::mp_unary_op, 182);
        hint(mp_unary_op, this::mp_unary_op, 188);
        hint(mp_unary_op, this::mp_unary_op, 196);
        hint(mp_unary_op, this::mp_unary_op, 212);
        hint(mp_unary_op, this::mp_unary_op, 224);
        hint(mp_unary_op, this::mp_unary_op, 228);
        hint(mp_unary_op, this::mp_unary_op, 234);
        hint(mp_call_function_n_kw, this::mp_call_function_n_kw, 0);
        hint(mp_call_function_n_kw, this::mp_call_function_n_kw, 14);
        hint(mp_call_function_n_kw, this::mp_call_function_n_kw, 26);
        hint(mp_call_function_n_kw, this::mp_call_function_n_kw, 36);
        hint(mp_call_function_n_kw, this::mp_call_function_n_kw, 40);
        hint(mp_call_function_n_kw, this::mp_call_function_n_kw, 50);
        hint(mp_call_function_0, this::mp_call_function_0, 0);
        hint(mp_call_function_0, this::mp_call_function_0, 12);
        hint(mp_call_function_1, this::mp_call_function_1, 0);
        hint(mp_call_function_1, this::mp_call_function_1, 14);
        hint(checked_fun_call, this::checked_fun_call, 0);
        hint(checked_fun_call, this::checked_fun_call, 20);
        hint(checked_fun_call, this::checked_fun_call, 38);
        hint(checked_fun_call, this::checked_fun_call, 42);
        hint(checked_fun_call, this::checked_fun_call, 54);
        hint(mp_call_method_n_kw, this::mp_call_method_n_kw, 0);
        hint(mp_call_method_n_kw, this::mp_call_method_n_kw, 28);
        hint(mp_convert_member_lookup, this::mp_convert_member_lookup, 0);
        hint(mp_convert_member_lookup, this::mp_convert_member_lookup, 40);
        hint(mp_convert_member_lookup, this::mp_convert_member_lookup, 118);
        hint(mp_load_method_maybe, this::mp_load_method_maybe, 0);
        hint(mp_load_method_maybe, this::mp_load_method_maybe, 18);
        hint(mp_load_method_maybe, this::mp_load_method_maybe, 58);
        hint(mp_load_method_maybe, this::mp_load_method_maybe, 80);
        hint(mp_load_method_maybe, this::mp_load_method_maybe, 96);
        hint(mp_load_method, this::mp_load_method, 0);
        hint(mp_load_method, this::mp_load_method, 12);
        hint(mp_load_method, this::mp_load_method, 44);
        hint(mp_load_method, this::mp_load_method, 48);
        hint(mp_load_method, this::mp_load_method, 54);
        hint(mp_load_attr, this::mp_load_attr, 0);
        hint(mp_load_attr, this::mp_load_attr, 8);
        hint(mp_load_attr, this::mp_load_attr, 22);
        hint(mp_load_method_protected, this::mp_load_method_protected, 0);
        hint(mp_load_method_protected, this::mp_load_method_protected, 18);
        hint(mp_load_method_protected, this::mp_load_method_protected, 32);
        hint(mp_load_method_protected, this::mp_load_method_protected, 36);
        hint(mp_load_method_protected, this::mp_load_method_protected, 54);
        hint(mp_load_method_protected, this::mp_load_method_protected, 64);
        hint(mp_store_attr, this::mp_store_attr, 0);
        hint(mp_store_attr, this::mp_store_attr, 12);
        hint(mp_store_attr, this::mp_store_attr, 32);
        hint(mp_store_attr, this::mp_store_attr, 44);
        hint(mp_store_attr, this::mp_store_attr, 56);
        hint(mp_store_attr, this::mp_store_attr, 60);
        hint(mp_getiter, this::mp_getiter, 0);
        hint(mp_getiter, this::mp_getiter, 10);
        hint(mp_getiter, this::mp_getiter, 30);
        hint(mp_getiter, this::mp_getiter, 48);
        hint(mp_getiter, this::mp_getiter, 60);
        hint(mp_getiter, this::mp_getiter, 70);
        hint(mp_getiter, this::mp_getiter, 74);
        hint(mp_getiter, this::mp_getiter, 80);
        hint(mp_getiter, this::mp_getiter, 94);
        hint(mp_iternext_allow_raise, this::mp_iternext_allow_raise, 0);
        hint(mp_iternext_allow_raise, this::mp_iternext_allow_raise, 8);
        hint(mp_iternext_allow_raise, this::mp_iternext_allow_raise, 18);
        hint(mp_iternext_allow_raise, this::mp_iternext_allow_raise, 30);
        hint(mp_iternext_allow_raise, this::mp_iternext_allow_raise, 46);
        hint(mp_iternext_allow_raise, this::mp_iternext_allow_raise, 54);
        hint(mp_iternext_allow_raise, this::mp_iternext_allow_raise, 64);
        hint(mp_iternext_allow_raise, this::mp_iternext_allow_raise, 68);
        hint(mp_iternext, this::mp_iternext, 0);
        hint(mp_iternext, this::mp_iternext, 10);
        hint(mp_iternext, this::mp_iternext, 16);
        hint(mp_iternext, this::mp_iternext, 26);
        hint(mp_iternext, this::mp_iternext, 44);
        hint(mp_iternext, this::mp_iternext, 56);
        hint(mp_iternext, this::mp_iternext, 68);
        hint(mp_iternext, this::mp_iternext, 74);
        hint(mp_iternext, this::mp_iternext, 86);
        hint(mp_iternext, this::mp_iternext, 96);
        hint(mp_iternext, this::mp_iternext, 102);
        hint(mp_iternext, this::mp_iternext, 112);
        hint(mp_call_prepare_args_n_kw_var, this::mp_call_prepare_args_n_kw_var, 0);
        hint(mp_call_prepare_args_n_kw_var, this::mp_call_prepare_args_n_kw_var, 76);
        hint(mp_call_prepare_args_n_kw_var, this::mp_call_prepare_args_n_kw_var, 100);
        hint(mp_call_prepare_args_n_kw_var, this::mp_call_prepare_args_n_kw_var, 124);
        hint(mp_call_prepare_args_n_kw_var, this::mp_call_prepare_args_n_kw_var, 146);
        hint(mp_call_prepare_args_n_kw_var, this::mp_call_prepare_args_n_kw_var, 224);
        hint(mp_call_prepare_args_n_kw_var, this::mp_call_prepare_args_n_kw_var, 240);
        hint(mp_call_prepare_args_n_kw_var, this::mp_call_prepare_args_n_kw_var, 264);
        hint(mp_call_prepare_args_n_kw_var, this::mp_call_prepare_args_n_kw_var, 282);
        hint(mp_call_prepare_args_n_kw_var, this::mp_call_prepare_args_n_kw_var, 302);
        hint(mp_call_prepare_args_n_kw_var, this::mp_call_prepare_args_n_kw_var, 326);
        hint(mp_call_prepare_args_n_kw_var, this::mp_call_prepare_args_n_kw_var, 334);
        hint(mp_call_prepare_args_n_kw_var, this::mp_call_prepare_args_n_kw_var, 344);
        hint(mp_call_prepare_args_n_kw_var, this::mp_call_prepare_args_n_kw_var, 368);
        hint(mp_call_prepare_args_n_kw_var, this::mp_call_prepare_args_n_kw_var, 410);
        hint(mp_call_prepare_args_n_kw_var, this::mp_call_prepare_args_n_kw_var, 486);
        hint(mp_call_prepare_args_n_kw_var, this::mp_call_prepare_args_n_kw_var, 496);
        hint(mp_call_prepare_args_n_kw_var, this::mp_call_prepare_args_n_kw_var, 502);
        hint(mp_call_prepare_args_n_kw_var, this::mp_call_prepare_args_n_kw_var, 518);
        hint(mp_call_prepare_args_n_kw_var, this::mp_call_prepare_args_n_kw_var, 558);
        hint(mp_call_prepare_args_n_kw_var, this::mp_call_prepare_args_n_kw_var, 572);
        hint(mp_call_prepare_args_n_kw_var, this::mp_call_prepare_args_n_kw_var, 584);
        hint(mp_call_prepare_args_n_kw_var, this::mp_call_prepare_args_n_kw_var, 596);
        hint(mp_call_method_n_kw_var, this::mp_call_method_n_kw_var, 0);
        hint(mp_call_method_n_kw_var, this::mp_call_method_n_kw_var, 8);
        hint(mp_call_method_n_kw_var, this::mp_call_method_n_kw_var, 20);
        hint(mp_unpack_sequence, this::mp_unpack_sequence, 0);
        hint(mp_unpack_sequence, this::mp_unpack_sequence, 34);
        hint(mp_unpack_sequence, this::mp_unpack_sequence, 76);
        hint(mp_unpack_sequence, this::mp_unpack_sequence, 94);
        hint(mp_unpack_sequence, this::mp_unpack_sequence, 108);
        hint(mp_unpack_sequence, this::mp_unpack_sequence, 140);
        hint(mp_unpack_sequence, this::mp_unpack_sequence, 144);
        hint(mp_unpack_ex, this::mp_unpack_ex, 0);
        hint(mp_unpack_ex, this::mp_unpack_ex, 40);
        hint(mp_unpack_ex, this::mp_unpack_ex, 76);
        hint(mp_unpack_ex, this::mp_unpack_ex, 124);
        hint(mp_unpack_ex, this::mp_unpack_ex, 144);
        hint(mp_unpack_ex, this::mp_unpack_ex, 152);
        hint(mp_unpack_ex, this::mp_unpack_ex, 184);
        hint(mp_unpack_ex, this::mp_unpack_ex, 192);
        hint(mp_unpack_ex, this::mp_unpack_ex, 218);
        hint(mp_unpack_ex, this::mp_unpack_ex, 242);
        hint(mp_unpack_ex, this::mp_unpack_ex, 246);
        hint(mp_make_raise_obj, this::mp_make_raise_obj, 0);
        hint(mp_make_raise_obj, this::mp_make_raise_obj, 8);
        hint(mp_make_raise_obj, this::mp_make_raise_obj, 24);
        hint(mp_make_raise_obj, this::mp_make_raise_obj, 36);
        hint(mp_make_raise_obj, this::mp_make_raise_obj, 48);
        hint(mp_resume, this::mp_resume, 0);
        hint(mp_resume, this::mp_resume, 16);
        hint(mp_resume, this::mp_resume, 34);
        hint(mp_resume, this::mp_resume, 54);
        hint(mp_resume, this::mp_resume, 78);
        hint(mp_resume, this::mp_resume, 96);
        hint(mp_resume, this::mp_resume, 108);
        hint(mp_resume, this::mp_resume, 120);
        hint(mp_resume, this::mp_resume, 132);
        hint(mp_resume, this::mp_resume, 138);
        hint(mp_resume, this::mp_resume, 158);
        hint(mp_resume, this::mp_resume, 164);
        hint(mp_resume, this::mp_resume, 178);
        hint(mp_resume, this::mp_resume, 194);
        hint(mp_resume, this::mp_resume, 208);
        hint(mp_resume, this::mp_resume, 224);
        hint(mp_import_name, this::mp_import_name, 0);
        hint(mp_import_name, this::mp_import_name, 28);
        hint(mp_import_from, this::mp_import_from, 0);
        hint(mp_import_from, this::mp_import_from, 14);
        hint(mp_import_from, this::mp_import_from, 32);
        hint(mp_import_from, this::mp_import_from, 36);
        hint(mp_import_from, this::mp_import_from, 48);
        hint(mp_import_from, this::mp_import_from, 62);
        hint(mp_import_from, this::mp_import_from, 70);
        hint(mp_import_from, this::mp_import_from, 78);
        hint(mp_import_from, this::mp_import_from, 90);
        hint(mp_import_from, this::mp_import_from, 100);
        hint(mp_import_from, this::mp_import_from, 120);
        hint(mp_import_from, this::mp_import_from, 128);
        hint(mp_import_from, this::mp_import_from, 138);
        hint(mp_import_from, this::mp_import_from, 146);
        hint(mp_import_from, this::mp_import_from, 180);
        hint(mp_import_all, this::mp_import_all, 0);
        hint(mp_import_all, this::mp_import_all, 36);
        hint(mp_import_all, this::mp_import_all, 54);
        hint(mp_parse_compile_execute, this::mp_parse_compile_execute, 0);
        hint(mp_parse_compile_execute, this::mp_parse_compile_execute, 30);
        hint(mp_parse_compile_execute, this::mp_parse_compile_execute, 48);
        hint(mp_parse_compile_execute, this::mp_parse_compile_execute, 60);
        hint(mp_parse_compile_execute, this::mp_parse_compile_execute, 70);
        hint(mp_parse_compile_execute, this::mp_parse_compile_execute, 76);
        hint(mp_parse_compile_execute, this::mp_parse_compile_execute, 104);
        hint(mp_raise_msg, this::mp_raise_msg, 0);
        hint(mp_raise_msg, this::mp_raise_msg, 10);
        hint(mp_raise_msg, this::mp_raise_msg, 14);
        hint(mp_raise_msg, this::mp_raise_msg, 18);
        hint(m_malloc_fail, this::m_malloc_fail, 0);
        hint(m_malloc_fail, this::m_malloc_fail, 8);
        hint(m_malloc_fail, this::m_malloc_fail, 20);
        hint(m_malloc_fail, this::m_malloc_fail, 28);
        hint(m_malloc_fail, this::m_malloc_fail, 32);
        hint(mp_raise_ValueError, this::mp_raise_ValueError, 0);
        hint(mp_raise_ValueError, this::mp_raise_ValueError, 10);
        hint(mp_binary_op, this::mp_binary_op, 0);
        hint(mp_binary_op, this::mp_binary_op, 38);
        hint(mp_binary_op, this::mp_binary_op, 66);
        hint(mp_binary_op, this::mp_binary_op, 78);
        hint(mp_binary_op, this::mp_binary_op, 108);
        hint(mp_binary_op, this::mp_binary_op, 116);
        hint(mp_binary_op, this::mp_binary_op, 130);
        hint(mp_binary_op, this::mp_binary_op, 134);
        hint(mp_binary_op, this::mp_binary_op, 146);
        hint(mp_binary_op, this::mp_binary_op, 160);
        hint(mp_binary_op, this::mp_binary_op, 276);
        hint(mp_binary_op, this::mp_binary_op, 294);
        hint(mp_binary_op, this::mp_binary_op, 308);
        hint(mp_binary_op, this::mp_binary_op, 408);
        hint(mp_binary_op, this::mp_binary_op, 418);
        hint(mp_binary_op, this::mp_binary_op, 434);
        hint(mp_binary_op, this::mp_binary_op, 532);
        hint(mp_binary_op, this::mp_binary_op, 548);
        hint(mp_binary_op, this::mp_binary_op, 556);
        hint(mp_binary_op, this::mp_binary_op, 564);
        hint(mp_binary_op, this::mp_binary_op, 568);
        hint(mp_binary_op, this::mp_binary_op, 586);
        hint(mp_binary_op, this::mp_binary_op, 602);
        hint(mp_binary_op, this::mp_binary_op, 606);
        hint(mp_binary_op, this::mp_binary_op, 614);
        hint(mp_binary_op, this::mp_binary_op, 646);
        hint(mp_binary_op, this::mp_binary_op, 654);
        hint(mp_binary_op, this::mp_binary_op, 666);
        hint(mp_binary_op, this::mp_binary_op, 718);
        hint(mp_binary_op, this::mp_binary_op, 744);
        hint(mp_binary_op, this::mp_binary_op, 790);
        hint(mp_binary_op, this::mp_binary_op, 810);
        hint(mp_binary_op, this::mp_binary_op, 820);
        hint(mp_binary_op, this::mp_binary_op, 840);
        hint(mp_binary_op, this::mp_binary_op, 852);
        hint(mp_binary_op, this::mp_binary_op, 878);
        hint(mp_binary_op, this::mp_binary_op, 926);
        hint(mp_raise_TypeError, this::mp_raise_TypeError, 0);
        hint(mp_raise_TypeError, this::mp_raise_TypeError, 10);
        hint(mp_raise_OSError, this::mp_raise_OSError, 0);
        hint(mp_raise_OSError, this::mp_raise_OSError, 14);
        hint(mp_raise_OSError, this::mp_raise_OSError, 18);
        hint(mp_raise_NotImplementedError, this::mp_raise_NotImplementedError, 0);
        hint(mp_raise_NotImplementedError, this::mp_raise_NotImplementedError, 10);
        hint(mp_raise_recursion_depth, this::mp_raise_recursion_depth, 0);
        hint(mp_raise_recursion_depth, this::mp_raise_recursion_depth, 12);
        hint(mp_raise_recursion_depth, this::mp_raise_recursion_depth, 16);
        hint(mp_call_function_1_protected, this::mp_call_function_1_protected, 0);
        hint(mp_call_function_1_protected, this::mp_call_function_1_protected, 14);
        hint(mp_call_function_1_protected, this::mp_call_function_1_protected, 26);
        hint(mp_call_function_1_protected, this::mp_call_function_1_protected, 32);
        hint(mp_call_function_1_protected, this::mp_call_function_1_protected, 46);
        hint(mp_sched_lock, this::mp_sched_lock, 0);
        hint(mp_sched_unlock, this::mp_sched_unlock, 0);
        hint(mp_handle_pending_tail, this::mp_handle_pending_tail, 0);
        hint(mp_handle_pending_tail, this::mp_handle_pending_tail, 42);
        hint(mp_handle_pending_tail, this::mp_handle_pending_tail, 46);
        hint(mp_handle_pending, this::mp_handle_pending, 0);
        hint(mp_handle_pending, this::mp_handle_pending, 46);
        hint(mp_handle_pending, this::mp_handle_pending, 50);
        hint(mp_sched_schedule, this::mp_sched_schedule, 0);
        hint(mp_stack_set_top, this::mp_stack_set_top, 0);
        hint(mp_stack_usage, this::mp_stack_usage, 0);
        hint(mp_stack_set_limit, this::mp_stack_set_limit, 0);
        hint(mp_stack_check, this::mp_stack_check, 0);
        hint(mp_stack_check, this::mp_stack_check, 20);
        hint(mp_arg_check_num, this::mp_arg_check_num, 0);
        hint(mp_arg_check_num, this::mp_arg_check_num, 22);
        hint(mp_arg_check_num, this::mp_arg_check_num, 40);
        hint(mp_arg_check_num, this::mp_arg_check_num, 56);
        hint(mp_arg_check_num, this::mp_arg_check_num, 60);
        hint(mp_arg_parse_all, this::mp_arg_parse_all, 0);
        hint(mp_arg_parse_all, this::mp_arg_parse_all, 40);
        hint(mp_arg_parse_all, this::mp_arg_parse_all, 80);
        hint(mp_arg_parse_all, this::mp_arg_parse_all, 102);
        hint(mp_arg_parse_all, this::mp_arg_parse_all, 122);
        hint(mp_arg_parse_all, this::mp_arg_parse_all, 126);
        hint(mp_arg_parse_all, this::mp_arg_parse_all, 158);
        hint(mp_arg_parse_all_kw_array, this::mp_arg_parse_all_kw_array, 0);
        hint(mp_arg_parse_all_kw_array, this::mp_arg_parse_all_kw_array, 20);
        hint(mp_arg_parse_all_kw_array, this::mp_arg_parse_all_kw_array, 40);
        hint(mp_arg_error_unimpl_kw, this::mp_arg_error_unimpl_kw, 0);
        hint(mp_arg_error_unimpl_kw, this::mp_arg_error_unimpl_kw, 8);
        hint(mp_warning, this::mp_warning, 0);
        hint(mp_warning, this::mp_warning, 20);
        hint(mp_warning, this::mp_warning, 30);
        hint(mp_warning, this::mp_warning, 38);
        hint(mp_map_init, this::mp_map_init, 0);
        hint(mp_map_init, this::mp_map_init, 24);
        hint(mp_map_init_fixed_table, this::mp_map_init_fixed_table, 0);
        hint(mp_map_deinit, this::mp_map_deinit, 0);
        hint(mp_map_deinit, this::mp_map_deinit, 20);
        hint(mp_map_clear, this::mp_map_clear, 0);
        hint(mp_map_clear, this::mp_map_clear, 20);
        hint(mp_map_lookup, this::mp_map_lookup, 0);
        hint(mp_map_lookup, this::mp_map_lookup, 98);
        hint(mp_map_lookup, this::mp_map_lookup, 120);
        hint(mp_map_lookup, this::mp_map_lookup, 204);
        hint(mp_map_lookup, this::mp_map_lookup, 238);
        hint(mp_map_lookup, this::mp_map_lookup, 264);
        hint(mp_map_lookup, this::mp_map_lookup, 280);
        hint(mp_map_lookup, this::mp_map_lookup, 290);
        hint(mp_map_lookup, this::mp_map_lookup, 362);
        hint(mp_map_lookup, this::mp_map_lookup, 406);
        hint(mp_map_lookup, this::mp_map_lookup, 432);
        hint(mp_map_lookup, this::mp_map_lookup, 446);
        hint(mp_map_lookup, this::mp_map_lookup, 502);
        hint(mp_map_rehash, this::mp_map_rehash, 0);
        hint(mp_map_rehash, this::mp_map_rehash, 44);
        hint(mp_map_rehash, this::mp_map_rehash, 80);
        hint(mp_map_rehash, this::mp_map_rehash, 100);
        hint(mp_set_init, this::mp_set_init, 0);
        hint(mp_set_init, this::mp_set_init, 16);
        hint(mp_set_lookup, this::mp_set_lookup, 0);
        hint(mp_set_lookup, this::mp_set_lookup, 26);
        hint(mp_set_lookup, this::mp_set_lookup, 34);
        hint(mp_set_lookup, this::mp_set_lookup, 46);
        hint(mp_set_lookup, this::mp_set_lookup, 116);
        hint(mp_set_lookup, this::mp_set_lookup, 154);
        hint(mp_set_lookup, this::mp_set_lookup, 186);
        hint(mp_set_lookup, this::mp_set_lookup, 212);
        hint(mp_set_rehash, this::mp_set_rehash, 0);
        hint(mp_set_rehash, this::mp_set_rehash, 48);
        hint(mp_set_rehash, this::mp_set_rehash, 72);
        hint(mp_set_rehash, this::mp_set_rehash, 92);
        hint(mp_set_remove_first, this::mp_set_remove_first, 0);
        hint(mp_set_remove_first, this::mp_set_remove_first, 44);
        hint(mp_set_clear, this::mp_set_clear, 0);
        hint(mp_set_clear, this::mp_set_clear, 14);
        hint(mp_identity, this::mp_identity, 0);
        hint(mp_obj_get_type, this::mp_obj_get_type, 0);
        hint(mp_obj_get_type_str, this::mp_obj_get_type_str, 0);
        hint(mp_obj_get_type_str, this::mp_obj_get_type_str, 6);
        hint(mp_obj_get_type_str, this::mp_obj_get_type_str, 12);
        hint(mp_obj_print_helper, this::mp_obj_print_helper, 0);
        hint(mp_obj_print_helper, this::mp_obj_print_helper, 12);
        hint(mp_obj_print_helper, this::mp_obj_print_helper, 18);
        hint(mp_obj_print_helper, this::mp_obj_print_helper, 32);
        hint(mp_obj_print_helper, this::mp_obj_print_helper, 44);
        hint(mp_obj_print, this::mp_obj_print, 0);
        hint(mp_obj_print, this::mp_obj_print, 12);
        hint(mp_obj_print_exception, this::mp_obj_print_exception, 0);
        hint(mp_obj_print_exception, this::mp_obj_print_exception, 12);
        hint(mp_obj_print_exception, this::mp_obj_print_exception, 26);
        hint(mp_obj_print_exception, this::mp_obj_print_exception, 40);
        hint(mp_obj_print_exception, this::mp_obj_print_exception, 60);
        hint(mp_obj_print_exception, this::mp_obj_print_exception, 68);
        hint(mp_obj_print_exception, this::mp_obj_print_exception, 92);
        hint(mp_obj_print_exception, this::mp_obj_print_exception, 112);
        hint(mp_obj_print_exception, this::mp_obj_print_exception, 126);
        hint(mp_obj_is_callable, this::mp_obj_is_callable, 0);
        hint(mp_obj_is_callable, this::mp_obj_is_callable, 8);
        hint(mp_obj_is_callable, this::mp_obj_is_callable, 30);
        hint(mp_obj_equal, this::mp_obj_equal, 0);
        hint(mp_obj_equal, this::mp_obj_equal, 108);
        hint(mp_obj_equal, this::mp_obj_equal, 142);
        hint(mp_obj_equal, this::mp_obj_equal, 156);
        hint(mp_obj_equal, this::mp_obj_equal, 202);
        hint(mp_obj_get_int, this::mp_obj_get_int, 0);
        hint(mp_obj_get_int, this::mp_obj_get_int, 40);
        hint(mp_obj_get_int, this::mp_obj_get_int, 46);
        hint(mp_obj_get_int, this::mp_obj_get_int, 56);
        hint(mp_obj_get_int, this::mp_obj_get_int, 60);
        hint(mp_obj_get_int_truncated, this::mp_obj_get_int_truncated, 0);
        hint(mp_obj_get_int_truncated, this::mp_obj_get_int_truncated, 22);
        hint(mp_obj_get_int_truncated, this::mp_obj_get_int_truncated, 28);
        hint(mp_obj_get_int_maybe, this::mp_obj_get_int_maybe, 0);
        hint(mp_obj_get_int_maybe, this::mp_obj_get_int_maybe, 60);
        hint(mp_obj_get_float_maybe, this::mp_obj_get_float_maybe, 0);
        hint(mp_obj_get_float_maybe, this::mp_obj_get_float_maybe, 28);
        hint(mp_obj_get_float_maybe, this::mp_obj_get_float_maybe, 54);
        hint(mp_obj_get_float_maybe, this::mp_obj_get_float_maybe, 68);
        hint(mp_obj_get_float, this::mp_obj_get_float, 0);
        hint(mp_obj_get_float, this::mp_obj_get_float, 10);
        hint(mp_obj_get_float, this::mp_obj_get_float, 20);
        hint(mp_obj_get_float, this::mp_obj_get_float, 30);
        hint(mp_obj_get_float, this::mp_obj_get_float, 34);
        hint(mp_obj_get_complex, this::mp_obj_get_complex, 0);
        hint(mp_obj_get_complex, this::mp_obj_get_complex, 46);
        hint(mp_obj_get_complex, this::mp_obj_get_complex, 66);
        hint(mp_obj_get_complex, this::mp_obj_get_complex, 78);
        hint(mp_obj_get_complex, this::mp_obj_get_complex, 92);
        hint(mp_obj_get_complex, this::mp_obj_get_complex, 98);
        hint(mp_obj_get_complex, this::mp_obj_get_complex, 108);
        hint(mp_obj_get_complex, this::mp_obj_get_complex, 112);
        hint(mp_obj_get_array, this::mp_obj_get_array, 0);
        hint(mp_obj_get_array, this::mp_obj_get_array, 18);
        hint(mp_obj_get_array, this::mp_obj_get_array, 30);
        hint(mp_obj_get_array, this::mp_obj_get_array, 36);
        hint(mp_obj_get_array, this::mp_obj_get_array, 46);
        hint(mp_obj_get_array, this::mp_obj_get_array, 50);
        hint(mp_obj_get_array_fixed_n, this::mp_obj_get_array_fixed_n, 0);
        hint(mp_obj_get_array_fixed_n, this::mp_obj_get_array_fixed_n, 10);
        hint(mp_obj_get_array_fixed_n, this::mp_obj_get_array_fixed_n, 26);
        hint(mp_obj_get_array_fixed_n, this::mp_obj_get_array_fixed_n, 30);
        hint(mp_get_index, this::mp_get_index, 0);
        hint(mp_get_index, this::mp_get_index, 52);
        hint(mp_get_index, this::mp_get_index, 64);
        hint(mp_get_index, this::mp_get_index, 76);
        hint(mp_get_index, this::mp_get_index, 80);
        hint(mp_get_index, this::mp_get_index, 112);
        hint(mp_obj_id, this::mp_obj_id, 0);
        hint(mp_obj_id, this::mp_obj_id, 10);
        hint(mp_obj_id, this::mp_obj_id, 28);
        hint(mp_obj_len_maybe, this::mp_obj_len_maybe, 0);
        hint(mp_obj_len_maybe, this::mp_obj_len_maybe, 32);
        hint(mp_obj_len_maybe, this::mp_obj_len_maybe, 44);
        hint(mp_obj_is_true, this::mp_obj_is_true, 0);
        hint(mp_obj_is_true, this::mp_obj_is_true, 42);
        hint(mp_obj_is_true, this::mp_obj_is_true, 54);
        hint(mp_obj_is_true, this::mp_obj_is_true, 74);
        hint(mp_obj_len, this::mp_obj_len, 0);
        hint(mp_obj_len, this::mp_obj_len, 8);
        hint(mp_obj_len, this::mp_obj_len, 18);
        hint(mp_obj_len, this::mp_obj_len, 28);
        hint(mp_obj_len, this::mp_obj_len, 32);
        hint(mp_obj_subscr, this::mp_obj_subscr, 0);
        hint(mp_obj_subscr, this::mp_obj_subscr, 12);
        hint(mp_obj_subscr, this::mp_obj_subscr, 26);
        hint(mp_obj_subscr, this::mp_obj_subscr, 42);
        hint(mp_obj_subscr, this::mp_obj_subscr, 52);
        hint(mp_obj_subscr, this::mp_obj_subscr, 56);
        hint(mp_obj_subscr, this::mp_obj_subscr, 64);
        hint(mp_obj_subscr, this::mp_obj_subscr, 74);
        hint(mp_identity_getiter, this::mp_identity_getiter, 0);
        hint(mp_get_buffer, this::mp_get_buffer, 0);
        hint(mp_get_buffer, this::mp_get_buffer, 12);
        hint(mp_get_buffer, this::mp_get_buffer, 26);
        hint(mp_get_buffer_raise, this::mp_get_buffer_raise, 0);
        hint(mp_get_buffer_raise, this::mp_get_buffer_raise, 6);
        hint(mp_get_buffer_raise, this::mp_get_buffer_raise, 16);
        hint(mp_generic_unary_op, this::mp_generic_unary_op, 0);
        hint(array_unary_op, this::array_unary_op, 0);
        hint(array_iterator_new, this::array_iterator_new, 0);
        hint(array_get_buffer, this::array_get_buffer, 0);
        hint(array_get_buffer, this::array_get_buffer, 22);
        hint(array_new, this::array_new, 0);
        hint(array_new, this::array_new, 16);
        hint(array_new, this::array_new, 24);
        hint(array_new, this::array_new, 54);
        hint(array_extend, this::array_extend, 0);
        hint(array_extend, this::array_extend, 14);
    }

    private void gen_hints_5() {
        hint(array_extend, this::array_extend, 24);
        hint(array_extend, this::array_extend, 34);
        hint(array_extend, this::array_extend, 60);
        hint(array_extend, this::array_extend, 86);
        hint(array_append, this::array_append, 0);
        hint(array_append, this::array_append, 24);
        hint(array_append, this::array_append, 52);
        hint(array_append, this::array_append, 76);
        hint(array_append, this::array_append, 88);
        hint(array_it_iternext, this::array_it_iternext, 0);
        hint(array_it_iternext, this::array_it_iternext, 36);
        hint(array_subscr, this::array_subscr, 0);
        hint(array_subscr, this::array_subscr, 46);
        hint(array_subscr, this::array_subscr, 56);
        hint(array_subscr, this::array_subscr, 76);
        hint(array_subscr, this::array_subscr, 106);
        hint(array_subscr, this::array_subscr, 116);
        hint(array_subscr, this::array_subscr, 200);
        hint(array_subscr, this::array_subscr, 230);
        hint(array_subscr, this::array_subscr, 252);
        hint(array_subscr, this::array_subscr, 274);
        hint(array_subscr, this::array_subscr, 320);
        hint(array_subscr, this::array_subscr, 360);
        hint(array_subscr, this::array_subscr, 376);
        hint(array_subscr, this::array_subscr, 394);
        hint(array_subscr, this::array_subscr, 408);
        hint(array_subscr, this::array_subscr, 466);
        hint(array_subscr, this::array_subscr, 488);
        hint(array_subscr, this::array_subscr, 502);
        hint(array_subscr, this::array_subscr, 540);
        hint(array_subscr, this::array_subscr, 556);
        hint(array_binary_op, this::array_binary_op, 0);
        hint(array_binary_op, this::array_binary_op, 44);
        hint(array_binary_op, this::array_binary_op, 72);
        hint(array_binary_op, this::array_binary_op, 88);
        hint(array_binary_op, this::array_binary_op, 108);
        hint(array_binary_op, this::array_binary_op, 118);
        hint(array_binary_op, this::array_binary_op, 134);
        hint(array_binary_op, this::array_binary_op, 144);
        hint(array_binary_op, this::array_binary_op, 162);
        hint(array_binary_op, this::array_binary_op, 178);
        hint(array_binary_op, this::array_binary_op, 194);
        hint(array_binary_op, this::array_binary_op, 216);
        hint(array_binary_op, this::array_binary_op, 246);
        hint(array_binary_op, this::array_binary_op, 256);
        hint(array_binary_op, this::array_binary_op, 266);
        hint(array_binary_op, this::array_binary_op, 286);
        hint(array_construct, this::array_construct, 0);
        hint(array_construct, this::array_construct, 40);
        hint(array_construct, this::array_construct, 54);
        hint(array_construct, this::array_construct, 64);
        hint(array_construct, this::array_construct, 74);
        hint(array_construct, this::array_construct, 88);
        hint(array_construct, this::array_construct, 100);
        hint(array_construct, this::array_construct, 114);
        hint(array_construct, this::array_construct, 124);
        hint(array_construct, this::array_construct, 134);
        hint(array_construct, this::array_construct, 150);
        hint(array_construct, this::array_construct, 166);
        hint(array_make_new, this::array_make_new, 0);
        hint(array_make_new, this::array_make_new, 22);
        hint(array_make_new, this::array_make_new, 28);
        hint(array_make_new, this::array_make_new, 40);
        hint(array_make_new, this::array_make_new, 48);
        hint(array_print, this::array_print, 0);
        hint(array_print, this::array_print, 18);
        hint(array_print, this::array_print, 30);
        hint(array_print, this::array_print, 38);
        hint(array_print, this::array_print, 48);
        hint(array_print, this::array_print, 62);
        hint(array_print, this::array_print, 78);
        hint(array_print, this::array_print, 92);
        hint(array_print, this::array_print, 102);
        hint(array_print, this::array_print, 112);
        hint(bytearray_make_new, this::bytearray_make_new, 0);
        hint(bytearray_make_new, this::bytearray_make_new, 20);
        hint(bytearray_make_new, this::bytearray_make_new, 32);
        hint(bytearray_make_new, this::bytearray_make_new, 60);
        hint(bytearray_make_new, this::bytearray_make_new, 70);
        hint(bytearray_make_new, this::bytearray_make_new, 82);
        hint(bytearray_make_new, this::bytearray_make_new, 92);
        hint(mp_obj_new_memoryview, this::mp_obj_new_memoryview, 0);
        hint(mp_obj_new_memoryview, this::mp_obj_new_memoryview, 14);
        hint(memoryview_make_new, this::memoryview_make_new, 0);
        hint(memoryview_make_new, this::memoryview_make_new, 22);
        hint(memoryview_make_new, this::memoryview_make_new, 32);
        hint(memoryview_make_new, this::memoryview_make_new, 52);
        hint(memoryview_make_new, this::memoryview_make_new, 60);
        hint(memoryview_make_new, this::memoryview_make_new, 70);
        hint(memoryview_make_new, this::memoryview_make_new, 82);
        hint(mp_obj_new_bytearray_by_ref, this::mp_obj_new_bytearray_by_ref, 0);
        hint(mp_obj_new_bytearray_by_ref, this::mp_obj_new_bytearray_by_ref, 12);
        hint(mp_obj_attrtuple_attr, this::mp_obj_attrtuple_attr, 0);
        hint(mp_obj_attrtuple_print_helper, this::mp_obj_attrtuple_print_helper, 0);
        hint(mp_obj_attrtuple_print_helper, this::mp_obj_attrtuple_print_helper, 16);
        hint(mp_obj_attrtuple_print_helper, this::mp_obj_attrtuple_print_helper, 30);
        hint(mp_obj_attrtuple_print_helper, this::mp_obj_attrtuple_print_helper, 44);
        hint(mp_obj_attrtuple_print_helper, this::mp_obj_attrtuple_print_helper, 60);
        hint(mp_obj_attrtuple_print_helper, this::mp_obj_attrtuple_print_helper, 70);
        hint(mp_obj_attrtuple_print, this::mp_obj_attrtuple_print, 0);
        hint(mp_obj_attrtuple_print, this::mp_obj_attrtuple_print, 16);
        hint(bool_binary_op, this::bool_binary_op, 0);
        hint(bool_binary_op, this::bool_binary_op, 14);
        hint(bool_unary_op, this::bool_unary_op, 0);
        hint(bool_unary_op, this::bool_unary_op, 20);
        hint(bool_make_new, this::bool_make_new, 0);
        hint(bool_make_new, this::bool_make_new, 20);
        hint(bool_make_new, this::bool_make_new, 30);
        hint(bool_print, this::bool_print, 0);
        hint(bool_print, this::bool_print, 20);
        hint(bound_meth_print, this::bound_meth_print, 0);
        hint(bound_meth_print, this::bound_meth_print, 14);
        hint(bound_meth_print, this::bound_meth_print, 24);
        hint(bound_meth_print, this::bound_meth_print, 32);
        hint(bound_meth_print, this::bound_meth_print, 42);
        hint(bound_meth_print, this::bound_meth_print, 50);
        hint(bound_meth_attr, this::bound_meth_attr, 0);
        hint(bound_meth_attr, this::bound_meth_attr, 20);
        hint(mp_call_method_self_n_kw, this::mp_call_method_self_n_kw, 0);
        hint(mp_call_method_self_n_kw, this::mp_call_method_self_n_kw, 24);
        hint(mp_call_method_self_n_kw, this::mp_call_method_self_n_kw, 38);
        hint(mp_call_method_self_n_kw, this::mp_call_method_self_n_kw, 50);
        hint(bound_meth_call, this::bound_meth_call, 0);
        hint(bound_meth_call, this::bound_meth_call, 16);
        hint(mp_obj_new_bound_meth, this::mp_obj_new_bound_meth, 0);
        hint(mp_obj_new_bound_meth, this::mp_obj_new_bound_meth, 12);
        hint(cell_print, this::cell_print, 0);
        hint(cell_print, this::cell_print, 14);
        hint(cell_print, this::cell_print, 28);
        hint(cell_print, this::cell_print, 36);
        hint(cell_print, this::cell_print, 46);
        hint(mp_obj_cell_get, this::mp_obj_cell_get, 0);
        hint(mp_obj_cell_set, this::mp_obj_cell_set, 0);
        hint(mp_obj_new_cell, this::mp_obj_new_cell, 0);
        hint(mp_obj_new_cell, this::mp_obj_new_cell, 10);
        hint(closure_call, this::closure_call, 0);
        hint(closure_call, this::closure_call, 50);
        hint(closure_call, this::closure_call, 62);
        hint(closure_call, this::closure_call, 74);
        hint(closure_call, this::closure_call, 90);
        hint(closure_call, this::closure_call, 102);
        hint(closure_call, this::closure_call, 116);
        hint(closure_call, this::closure_call, 136);
        hint(closure_call, this::closure_call, 146);
        hint(closure_print, this::closure_print, 0);
        hint(closure_print, this::closure_print, 12);
        hint(closure_print, this::closure_print, 22);
        hint(closure_print, this::closure_print, 34);
        hint(closure_print, this::closure_print, 50);
        hint(closure_print, this::closure_print, 70);
        hint(closure_print, this::closure_print, 78);
        hint(closure_print, this::closure_print, 90);
        hint(mp_obj_new_closure, this::mp_obj_new_closure, 0);
        hint(mp_obj_new_closure, this::mp_obj_new_closure, 18);
        hint(mp_obj_new_closure, this::mp_obj_new_closure, 40);
        hint(complex_attr, this::complex_attr, 0);
        hint(complex_attr, this::complex_attr, 24);
        hint(complex_print, this::complex_print, 0);
        hint(complex_print, this::complex_print, 18);
        hint(complex_print, this::complex_print, 42);
        hint(complex_print, this::complex_print, 52);
        hint(complex_print, this::complex_print, 72);
        hint(complex_print, this::complex_print, 82);
        hint(complex_print, this::complex_print, 92);
        hint(complex_print, this::complex_print, 104);
        hint(complex_print, this::complex_print, 116);
        hint(complex_print, this::complex_print, 136);
        hint(mp_obj_new_complex, this::mp_obj_new_complex, 0);
        hint(mp_obj_new_complex, this::mp_obj_new_complex, 12);
        hint(complex_unary_op, this::complex_unary_op, 0);
        hint(complex_unary_op, this::complex_unary_op, 42);
        hint(complex_unary_op, this::complex_unary_op, 52);
        hint(complex_unary_op, this::complex_unary_op, 60);
        hint(complex_unary_op, this::complex_unary_op, 64);
        hint(complex_unary_op, this::complex_unary_op, 68);
        hint(complex_unary_op, this::complex_unary_op, 78);
        hint(complex_unary_op, this::complex_unary_op, 90);
        hint(complex_unary_op, this::complex_unary_op, 106);
        hint(complex_unary_op, this::complex_unary_op, 114);
        hint(complex_unary_op, this::complex_unary_op, 140);
        hint(complex_make_new, this::complex_make_new, 0);
        hint(complex_make_new, this::complex_make_new, 20);
        hint(complex_make_new, this::complex_make_new, 70);
        hint(complex_make_new, this::complex_make_new, 80);
        hint(complex_make_new, this::complex_make_new, 94);
        hint(complex_make_new, this::complex_make_new, 124);
        hint(complex_make_new, this::complex_make_new, 138);
        hint(complex_make_new, this::complex_make_new, 154);
        hint(complex_make_new, this::complex_make_new, 164);
        hint(complex_make_new, this::complex_make_new, 176);
        hint(mp_obj_complex_get, this::mp_obj_complex_get, 0);
        hint(mp_obj_complex_binary_op, this::mp_obj_complex_binary_op, 0);
        hint(mp_obj_complex_binary_op, this::mp_obj_complex_binary_op, 20);
        hint(mp_obj_complex_binary_op, this::mp_obj_complex_binary_op, 74);
        hint(mp_obj_complex_binary_op, this::mp_obj_complex_binary_op, 88);
        hint(mp_obj_complex_binary_op, this::mp_obj_complex_binary_op, 104);
        hint(mp_obj_complex_binary_op, this::mp_obj_complex_binary_op, 114);
        hint(mp_obj_complex_binary_op, this::mp_obj_complex_binary_op, 140);
        hint(mp_obj_complex_binary_op, this::mp_obj_complex_binary_op, 150);
        hint(mp_obj_complex_binary_op, this::mp_obj_complex_binary_op, 160);
        hint(mp_obj_complex_binary_op, this::mp_obj_complex_binary_op, 182);
        hint(mp_obj_complex_binary_op, this::mp_obj_complex_binary_op, 192);
        hint(mp_obj_complex_binary_op, this::mp_obj_complex_binary_op, 200);
        hint(mp_obj_complex_binary_op, this::mp_obj_complex_binary_op, 204);
        hint(mp_obj_complex_binary_op, this::mp_obj_complex_binary_op, 212);
        hint(mp_obj_complex_binary_op, this::mp_obj_complex_binary_op, 224);
        hint(mp_obj_complex_binary_op, this::mp_obj_complex_binary_op, 238);
        hint(mp_obj_complex_binary_op, this::mp_obj_complex_binary_op, 250);
        hint(mp_obj_complex_binary_op, this::mp_obj_complex_binary_op, 270);
        hint(mp_obj_complex_binary_op, this::mp_obj_complex_binary_op, 280);
        hint(mp_obj_complex_binary_op, this::mp_obj_complex_binary_op, 288);
        hint(mp_obj_complex_binary_op, this::mp_obj_complex_binary_op, 294);
        hint(mp_obj_complex_binary_op, this::mp_obj_complex_binary_op, 306);
        hint(mp_obj_complex_binary_op, this::mp_obj_complex_binary_op, 326);
        hint(mp_obj_complex_binary_op, this::mp_obj_complex_binary_op, 336);
        hint(mp_obj_complex_binary_op, this::mp_obj_complex_binary_op, 344);
        hint(mp_obj_complex_binary_op, this::mp_obj_complex_binary_op, 354);
        hint(mp_obj_complex_binary_op, this::mp_obj_complex_binary_op, 368);
        hint(mp_obj_complex_binary_op, this::mp_obj_complex_binary_op, 384);
        hint(mp_obj_complex_binary_op, this::mp_obj_complex_binary_op, 394);
        hint(mp_obj_complex_binary_op, this::mp_obj_complex_binary_op, 402);
        hint(mp_obj_complex_binary_op, this::mp_obj_complex_binary_op, 412);
        hint(mp_obj_complex_binary_op, this::mp_obj_complex_binary_op, 422);
        hint(mp_obj_complex_binary_op, this::mp_obj_complex_binary_op, 434);
        hint(mp_obj_complex_binary_op, this::mp_obj_complex_binary_op, 440);
        hint(mp_obj_complex_binary_op, this::mp_obj_complex_binary_op, 450);
        hint(mp_obj_complex_binary_op, this::mp_obj_complex_binary_op, 464);
        hint(mp_obj_complex_binary_op, this::mp_obj_complex_binary_op, 476);
        hint(mp_obj_complex_binary_op, this::mp_obj_complex_binary_op, 484);
        hint(mp_obj_complex_binary_op, this::mp_obj_complex_binary_op, 494);
        hint(mp_obj_complex_binary_op, this::mp_obj_complex_binary_op, 504);
        hint(mp_obj_complex_binary_op, this::mp_obj_complex_binary_op, 512);
        hint(mp_obj_complex_binary_op, this::mp_obj_complex_binary_op, 516);
        hint(mp_obj_complex_binary_op, this::mp_obj_complex_binary_op, 524);
        hint(mp_obj_complex_binary_op, this::mp_obj_complex_binary_op, 530);
        hint(mp_obj_complex_binary_op, this::mp_obj_complex_binary_op, 538);
        hint(mp_obj_complex_binary_op, this::mp_obj_complex_binary_op, 544);
        hint(mp_obj_complex_binary_op, this::mp_obj_complex_binary_op, 554);
        hint(mp_obj_complex_binary_op, this::mp_obj_complex_binary_op, 566);
        hint(complex_binary_op, this::complex_binary_op, 0);
        hint(complex_binary_op, this::complex_binary_op, 12);
        hint(deque_make_new, this::deque_make_new, 0);
        hint(deque_make_new, this::deque_make_new, 26);
        hint(deque_make_new, this::deque_make_new, 40);
        hint(deque_make_new, this::deque_make_new, 46);
        hint(deque_make_new, this::deque_make_new, 56);
        hint(deque_make_new, this::deque_make_new, 76);
        hint(deque_make_new, this::deque_make_new, 90);
        hint(deque_unary_op, this::deque_unary_op, 0);
        hint(deque_popleft, this::deque_popleft, 0);
        hint(deque_popleft, this::deque_popleft, 20);
        hint(mp_obj_deque_append, this::mp_obj_deque_append, 0);
        hint(mp_obj_deque_append, this::mp_obj_deque_append, 34);
        hint(dict_view_getiter, this::dict_view_getiter, 0);
        hint(dict_getiter, this::dict_getiter, 0);
        hint(dict_values, this::dict_values, 0);
        hint(dict_values, this::dict_values, 10);
        hint(mp_ensure_not_fixed, this::mp_ensure_not_fixed, 0);
        hint(mp_ensure_not_fixed, this::mp_ensure_not_fixed, 14);
        hint(dict_clear, this::dict_clear, 0);
        hint(dict_clear, this::dict_clear, 8);
        hint(dict_clear, this::dict_clear, 14);
        hint(dict_unary_op, this::dict_unary_op, 0);
        hint(dict_get_helper, this::dict_get_helper, 0);
        hint(dict_get_helper, this::dict_get_helper, 18);
        hint(dict_get_helper, this::dict_get_helper, 28);
        hint(dict_get_helper, this::dict_get_helper, 56);
        hint(dict_get_helper, this::dict_get_helper, 60);
        hint(dict_setdefault, this::dict_setdefault, 0);
        hint(dict_setdefault, this::dict_setdefault, 8);
        hint(dict_pop, this::dict_pop, 0);
        hint(dict_pop, this::dict_pop, 8);
        hint(dict_get, this::dict_get, 0);
        hint(dict_get, this::dict_get, 8);
        hint(dict_iter_next, this::dict_iter_next, 0);
        hint(dict_view_it_iternext, this::dict_view_it_iternext, 0);
        hint(dict_view_it_iternext, this::dict_view_it_iternext, 14);
        hint(dict_view_it_iternext, this::dict_view_it_iternext, 46);
        hint(dict_view_print, this::dict_view_print, 0);
        hint(dict_view_print, this::dict_view_print, 20);
        hint(dict_view_print, this::dict_view_print, 28);
        hint(dict_view_print, this::dict_view_print, 56);
        hint(dict_view_print, this::dict_view_print, 68);
        hint(dict_view_print, this::dict_view_print, 84);
        hint(dict_view_print, this::dict_view_print, 94);
        hint(dict_update, this::dict_update, 0);
        hint(dict_update, this::dict_update, 18);
        hint(dict_update, this::dict_update, 34);
        hint(dict_update, this::dict_update, 72);
        hint(dict_update, this::dict_update, 90);
        hint(dict_update, this::dict_update, 102);
        hint(dict_update, this::dict_update, 110);
        hint(dict_update, this::dict_update, 120);
        hint(dict_update, this::dict_update, 126);
        hint(dict_update, this::dict_update, 134);
        hint(dict_update, this::dict_update, 142);
        hint(dict_update, this::dict_update, 162);
        hint(dict_update, this::dict_update, 172);
        hint(dict_update, this::dict_update, 202);
        hint(dict_popitem, this::dict_popitem, 0);
        hint(dict_popitem, this::dict_popitem, 12);
        hint(dict_popitem, this::dict_popitem, 22);
        hint(dict_popitem, this::dict_popitem, 34);
        hint(dict_popitem, this::dict_popitem, 60);
        hint(dict_binary_op, this::dict_binary_op, 0);
        hint(dict_binary_op, this::dict_binary_op, 26);
        hint(dict_binary_op, this::dict_binary_op, 78);
        hint(dict_binary_op, this::dict_binary_op, 88);
        hint(dict_binary_op, this::dict_binary_op, 106);
        hint(dict_binary_op, this::dict_binary_op, 118);
        hint(dict_binary_op, this::dict_binary_op, 158);
        hint(dict_binary_op, this::dict_binary_op, 176);
        hint(dict_binary_op, this::dict_binary_op, 188);
        hint(dict_view_binary_op, this::dict_view_binary_op, 0);
        hint(dict_view_binary_op, this::dict_view_binary_op, 20);
        hint(dict_print, this::dict_print, 0);
        hint(dict_print, this::dict_print, 34);
        hint(dict_print, this::dict_print, 42);
        hint(dict_print, this::dict_print, 58);
        hint(dict_print, this::dict_print, 70);
        hint(dict_print, this::dict_print, 86);
        hint(dict_print, this::dict_print, 104);
        hint(dict_print, this::dict_print, 114);
        hint(dict_print, this::dict_print, 122);
        hint(dict_print, this::dict_print, 132);
        hint(dict_items, this::dict_items, 0);
        hint(dict_items, this::dict_items, 10);
        hint(dict_keys, this::dict_keys, 0);
        hint(dict_keys, this::dict_keys, 10);
        hint(mp_obj_dict_get, this::mp_obj_dict_get, 0);
        hint(mp_obj_dict_get, this::mp_obj_dict_get, 12);
        hint(mp_obj_dict_get, this::mp_obj_dict_get, 24);
        hint(mp_obj_dict_get, this::mp_obj_dict_get, 28);
        hint(mp_obj_dict_init, this::mp_obj_dict_init, 0);
        hint(mp_obj_dict_init, this::mp_obj_dict_init, 10);
        hint(mp_obj_new_dict, this::mp_obj_new_dict, 0);
        hint(mp_obj_new_dict, this::mp_obj_new_dict, 10);
        hint(mp_obj_new_dict, this::mp_obj_new_dict, 18);
        hint(dict_fromkeys, this::dict_fromkeys, 0);
        hint(dict_fromkeys, this::dict_fromkeys, 14);
        hint(dict_fromkeys, this::dict_fromkeys, 30);
        hint(dict_fromkeys, this::dict_fromkeys, 38);
        hint(dict_fromkeys, this::dict_fromkeys, 46);
        hint(dict_fromkeys, this::dict_fromkeys, 68);
        hint(dict_copy, this::dict_copy, 0);
        hint(dict_copy, this::dict_copy, 10);
        hint(dict_copy, this::dict_copy, 82);
        hint(dict_make_new, this::dict_make_new, 0);
        hint(dict_make_new, this::dict_make_new, 18);
        hint(dict_make_new, this::dict_make_new, 60);
        hint(dict_make_new, this::dict_make_new, 70);
        hint(mp_obj_dict_len, this::mp_obj_dict_len, 0);
        hint(mp_obj_dict_store, this::mp_obj_dict_store, 0);
        hint(mp_obj_dict_store, this::mp_obj_dict_store, 12);
        hint(mp_obj_dict_store, this::mp_obj_dict_store, 22);
        hint(mp_obj_dict_delete, this::mp_obj_dict_delete, 0);
        hint(mp_obj_dict_delete, this::mp_obj_dict_delete, 18);
        hint(dict_subscr, this::dict_subscr, 0);
        hint(dict_subscr, this::dict_subscr, 12);
        hint(dict_subscr, this::dict_subscr, 28);
        hint(dict_subscr, this::dict_subscr, 40);
        hint(dict_subscr, this::dict_subscr, 44);
        hint(dict_subscr, this::dict_subscr, 52);
        hint(enumerate_iternext, this::enumerate_iternext, 0);
        hint(enumerate_iternext, this::enumerate_iternext, 10);
        hint(enumerate_iternext, this::enumerate_iternext, 38);
        hint(enumerate_make_new, this::enumerate_make_new, 0);
        hint(enumerate_make_new, this::enumerate_make_new, 24);
        hint(enumerate_make_new, this::enumerate_make_new, 30);
        hint(enumerate_make_new, this::enumerate_make_new, 42);
        hint(mp_obj_exception_print, this::mp_obj_exception_print, 0);
        hint(mp_obj_exception_print, this::mp_obj_exception_print, 32);
        hint(mp_obj_exception_print, this::mp_obj_exception_print, 40);
        hint(mp_obj_exception_print, this::mp_obj_exception_print, 52);
        hint(mp_obj_exception_print, this::mp_obj_exception_print, 72);
        hint(mp_obj_exception_print, this::mp_obj_exception_print, 96);
        hint(mp_obj_exception_print, this::mp_obj_exception_print, 114);
        hint(mp_obj_exception_print, this::mp_obj_exception_print, 128);
        hint(mp_obj_exception_print, this::mp_obj_exception_print, 144);
        hint(mp_obj_exception_make_new, this::mp_obj_exception_make_new, 0);
        hint(mp_obj_exception_make_new, this::mp_obj_exception_make_new, 26);
        hint(mp_obj_exception_make_new, this::mp_obj_exception_make_new, 32);
        hint(mp_obj_exception_make_new, this::mp_obj_exception_make_new, 68);
        hint(mp_obj_exception_make_new, this::mp_obj_exception_make_new, 106);
        hint(exc_add_strn, this::exc_add_strn, 0);
        hint(exc_add_strn, this::exc_add_strn, 40);
        hint(exc_add_strn, this::exc_add_strn, 68);
        hint(mp_init_emergency_exception_buf, this::mp_init_emergency_exception_buf, 0);
        hint(mp_obj_exception_get_value, this::mp_obj_exception_get_value, 0);
        hint(mp_obj_exception_attr, this::mp_obj_exception_attr, 0);
        hint(mp_obj_exception_attr, this::mp_obj_exception_attr, 56);
        hint(mp_obj_new_exception_args, this::mp_obj_new_exception_args, 0);
        hint(mp_obj_new_exception_args, this::mp_obj_new_exception_args, 10);
        hint(mp_obj_new_exception, this::mp_obj_new_exception, 0);
        hint(mp_obj_new_exception, this::mp_obj_new_exception, 10);
        hint(mp_obj_new_exception_arg1, this::mp_obj_new_exception_arg1, 0);
        hint(mp_obj_new_exception_arg1, this::mp_obj_new_exception_arg1, 12);
        hint(mp_obj_new_exception_msg_varg, this::mp_obj_new_exception_msg_varg, 0);
        hint(mp_obj_new_exception_msg_varg, this::mp_obj_new_exception_msg_varg, 14);
        hint(mp_obj_new_exception_msg_varg, this::mp_obj_new_exception_msg_varg, 22);
        hint(mp_obj_new_exception_msg_varg, this::mp_obj_new_exception_msg_varg, 30);
        hint(mp_obj_new_exception_msg_varg, this::mp_obj_new_exception_msg_varg, 82);
        hint(mp_obj_new_exception_msg_varg, this::mp_obj_new_exception_msg_varg, 104);
        hint(mp_obj_new_exception_msg_varg, this::mp_obj_new_exception_msg_varg, 120);
        hint(mp_obj_new_exception_msg, this::mp_obj_new_exception_msg, 0);
        hint(mp_obj_new_exception_msg, this::mp_obj_new_exception_msg, 6);
        hint(mp_obj_is_exception_type, this::mp_obj_is_exception_type, 0);
        hint(mp_obj_is_exception_type, this::mp_obj_is_exception_type, 34);
        hint(mp_obj_is_exception_instance, this::mp_obj_is_exception_instance, 0);
        hint(mp_obj_is_exception_instance, this::mp_obj_is_exception_instance, 6);
        hint(mp_obj_is_exception_instance, this::mp_obj_is_exception_instance, 10);
        hint(mp_obj_exception_match, this::mp_obj_exception_match, 0);
        hint(mp_obj_exception_match, this::mp_obj_exception_match, 10);
        hint(mp_obj_exception_match, this::mp_obj_exception_match, 20);
        hint(mp_obj_exception_match, this::mp_obj_exception_match, 30);
        hint(mp_obj_exception_clear_traceback, this::mp_obj_exception_clear_traceback, 0);
        hint(mp_obj_exception_clear_traceback, this::mp_obj_exception_clear_traceback, 8);
        hint(mp_obj_exception_add_traceback, this::mp_obj_exception_add_traceback, 0);
        hint(mp_obj_exception_add_traceback, this::mp_obj_exception_add_traceback, 14);
        hint(mp_obj_exception_add_traceback, this::mp_obj_exception_add_traceback, 36);
        hint(mp_obj_exception_add_traceback, this::mp_obj_exception_add_traceback, 104);
        hint(mp_obj_exception_get_traceback, this::mp_obj_exception_get_traceback, 0);
        hint(mp_obj_exception_get_traceback, this::mp_obj_exception_get_traceback, 12);
        hint(filter_iternext, this::filter_iternext, 0);
        hint(filter_iternext, this::filter_iternext, 10);
        hint(filter_iternext, this::filter_iternext, 36);
        hint(filter_iternext, this::filter_iternext, 40);
        hint(filter_make_new, this::filter_make_new, 0);
        hint(filter_make_new, this::filter_make_new, 22);
        hint(filter_make_new, this::filter_make_new, 28);
        hint(filter_make_new, this::filter_make_new, 44);
        hint(float_print, this::float_print, 0);
        hint(float_print, this::float_print, 28);
        hint(float_print, this::float_print, 36);
        hint(float_print, this::float_print, 44);
        hint(float_print, this::float_print, 56);
        hint(float_print, this::float_print, 68);
        hint(float_print, this::float_print, 80);
        hint(mp_obj_float_divmod, this::mp_obj_float_divmod, 0);
        hint(mp_obj_float_divmod, this::mp_obj_float_divmod, 16);
        hint(mp_obj_float_divmod, this::mp_obj_float_divmod, 32);
        hint(mp_obj_float_divmod, this::mp_obj_float_divmod, 38);
        hint(mp_obj_float_divmod, this::mp_obj_float_divmod, 48);
        hint(mp_obj_float_divmod, this::mp_obj_float_divmod, 70);
        hint(mp_obj_float_divmod, this::mp_obj_float_divmod, 82);
        hint(mp_obj_float_divmod, this::mp_obj_float_divmod, 114);
        hint(mp_obj_float_divmod, this::mp_obj_float_divmod, 136);
        hint(mp_obj_float_divmod, this::mp_obj_float_divmod, 162);
        hint(mp_obj_float_divmod, this::mp_obj_float_divmod, 174);
        hint(mp_obj_float_divmod, this::mp_obj_float_divmod, 184);
        hint(mp_obj_float_divmod, this::mp_obj_float_divmod, 194);
        hint(mp_obj_float_divmod, this::mp_obj_float_divmod, 202);
        hint(mp_obj_float_divmod, this::mp_obj_float_divmod, 216);
        hint(mp_float_hash, this::mp_float_hash, 0);
        hint(mp_obj_new_float, this::mp_obj_new_float, 0);
        hint(mp_obj_new_float, this::mp_obj_new_float, 10);
        hint(float_make_new, this::float_make_new, 0);
        hint(float_make_new, this::float_make_new, 24);
        hint(float_make_new, this::float_make_new, 40);
        hint(float_make_new, this::float_make_new, 58);
        hint(float_make_new, this::float_make_new, 80);
        hint(float_make_new, this::float_make_new, 84);
        hint(float_unary_op, this::float_unary_op, 0);
        hint(float_unary_op, this::float_unary_op, 42);
        hint(float_unary_op, this::float_unary_op, 56);
        hint(float_unary_op, this::float_unary_op, 68);
        hint(float_unary_op, this::float_unary_op, 84);
        hint(mp_obj_float_get, this::mp_obj_float_get, 0);
        hint(mp_obj_float_binary_op, this::mp_obj_float_binary_op, 0);
        hint(mp_obj_float_binary_op, this::mp_obj_float_binary_op, 18);
        hint(mp_obj_float_binary_op, this::mp_obj_float_binary_op, 82);
        hint(mp_obj_float_binary_op, this::mp_obj_float_binary_op, 100);
        hint(mp_obj_float_binary_op, this::mp_obj_float_binary_op, 112);
        hint(mp_obj_float_binary_op, this::mp_obj_float_binary_op, 140);
        hint(mp_obj_float_binary_op, this::mp_obj_float_binary_op, 148);
        hint(mp_obj_float_binary_op, this::mp_obj_float_binary_op, 174);
        hint(mp_obj_float_binary_op, this::mp_obj_float_binary_op, 186);
        hint(mp_obj_float_binary_op, this::mp_obj_float_binary_op, 204);
        hint(mp_obj_float_binary_op, this::mp_obj_float_binary_op, 216);
        hint(mp_obj_float_binary_op, this::mp_obj_float_binary_op, 222);
        hint(mp_obj_float_binary_op, this::mp_obj_float_binary_op, 230);
        hint(mp_obj_float_binary_op, this::mp_obj_float_binary_op, 240);
        hint(mp_obj_float_binary_op, this::mp_obj_float_binary_op, 250);
        hint(mp_obj_float_binary_op, this::mp_obj_float_binary_op, 260);
        hint(mp_obj_float_binary_op, this::mp_obj_float_binary_op, 272);
        hint(mp_obj_float_binary_op, this::mp_obj_float_binary_op, 284);
        hint(mp_obj_float_binary_op, this::mp_obj_float_binary_op, 294);
        hint(mp_obj_float_binary_op, this::mp_obj_float_binary_op, 326);
        hint(mp_obj_float_binary_op, this::mp_obj_float_binary_op, 342);
        hint(mp_obj_float_binary_op, this::mp_obj_float_binary_op, 374);
        hint(mp_obj_float_binary_op, this::mp_obj_float_binary_op, 386);
        hint(mp_obj_float_binary_op, this::mp_obj_float_binary_op, 402);
        hint(mp_obj_float_binary_op, this::mp_obj_float_binary_op, 416);
        hint(mp_obj_float_binary_op, this::mp_obj_float_binary_op, 430);
        hint(mp_obj_float_binary_op, this::mp_obj_float_binary_op, 440);
        hint(mp_obj_float_binary_op, this::mp_obj_float_binary_op, 446);
        hint(mp_obj_float_binary_op, this::mp_obj_float_binary_op, 462);
        hint(mp_obj_float_binary_op, this::mp_obj_float_binary_op, 478);
        hint(mp_obj_float_binary_op, this::mp_obj_float_binary_op, 488);
        hint(mp_obj_float_binary_op, this::mp_obj_float_binary_op, 506);
    }

    private void gen_hints_6() {
        hint(mp_obj_float_binary_op, this::mp_obj_float_binary_op, 516);
        hint(mp_obj_float_binary_op, this::mp_obj_float_binary_op, 526);
        hint(mp_obj_float_binary_op, this::mp_obj_float_binary_op, 536);
        hint(float_binary_op, this::float_binary_op, 0);
        hint(float_binary_op, this::float_binary_op, 24);
        hint(float_binary_op, this::float_binary_op, 30);
        hint(fun_builtin_0_call, this::fun_builtin_0_call, 0);
        hint(fun_builtin_0_call, this::fun_builtin_0_call, 18);
        hint(fun_builtin_0_call, this::fun_builtin_0_call, 22);
        hint(fun_builtin_1_call, this::fun_builtin_1_call, 0);
        hint(fun_builtin_1_call, this::fun_builtin_1_call, 22);
        hint(fun_builtin_1_call, this::fun_builtin_1_call, 28);
        hint(fun_builtin_2_call, this::fun_builtin_2_call, 0);
        hint(fun_builtin_2_call, this::fun_builtin_2_call, 22);
        hint(fun_builtin_2_call, this::fun_builtin_2_call, 28);
        hint(fun_builtin_3_call, this::fun_builtin_3_call, 0);
        hint(fun_builtin_3_call, this::fun_builtin_3_call, 22);
        hint(fun_builtin_3_call, this::fun_builtin_3_call, 28);
        hint(fun_bc_call, this::fun_bc_call, 0);
        hint(fun_bc_call, this::fun_bc_call, 16);
        hint(fun_bc_call, this::fun_bc_call, 22);
        hint(fun_bc_call, this::fun_bc_call, 30);
        hint(fun_bc_call, this::fun_bc_call, 34);
        hint(fun_bc_call, this::fun_bc_call, 54);
        hint(fun_bc_call, this::fun_bc_call, 70);
        hint(fun_bc_call, this::fun_bc_call, 88);
        hint(fun_bc_call, this::fun_bc_call, 112);
        hint(fun_builtin_var_call, this::fun_builtin_var_call, 0);
        hint(fun_builtin_var_call, this::fun_builtin_var_call, 34);
        hint(fun_builtin_var_call, this::fun_builtin_var_call, 52);
        hint(fun_builtin_var_call, this::fun_builtin_var_call, 62);
        hint(fun_builtin_var_call, this::fun_builtin_var_call, 74);
        hint(mp_obj_code_get_name, this::mp_obj_code_get_name, 0);
        hint(mp_obj_code_get_name, this::mp_obj_code_get_name, 6);
        hint(mp_obj_fun_get_name, this::mp_obj_fun_get_name, 0);
        hint(mp_obj_fun_get_name, this::mp_obj_fun_get_name, 8);
        hint(mp_obj_fun_get_name, this::mp_obj_fun_get_name, 12);
        hint(mp_obj_fun_get_name, this::mp_obj_fun_get_name, 18);
        hint(mp_obj_fun_bc_attr, this::mp_obj_fun_bc_attr, 0);
        hint(mp_obj_fun_bc_attr, this::mp_obj_fun_bc_attr, 18);
        hint(fun_bc_print, this::fun_bc_print, 0);
        hint(fun_bc_print, this::fun_bc_print, 12);
        hint(fun_bc_print, this::fun_bc_print, 24);
        hint(mp_obj_fun_bc_prepare_codestate, this::mp_obj_fun_bc_prepare_codestate, 0);
        hint(mp_obj_fun_bc_prepare_codestate, this::mp_obj_fun_bc_prepare_codestate, 14);
        hint(mp_obj_fun_bc_prepare_codestate, this::mp_obj_fun_bc_prepare_codestate, 20);
        hint(mp_obj_fun_bc_prepare_codestate, this::mp_obj_fun_bc_prepare_codestate, 28);
        hint(mp_obj_fun_bc_prepare_codestate, this::mp_obj_fun_bc_prepare_codestate, 32);
        hint(mp_obj_fun_bc_prepare_codestate, this::mp_obj_fun_bc_prepare_codestate, 48);
        hint(mp_obj_fun_bc_prepare_codestate, this::mp_obj_fun_bc_prepare_codestate, 66);
        hint(mp_obj_new_fun_bc, this::mp_obj_new_fun_bc, 0);
        hint(mp_obj_new_fun_bc, this::mp_obj_new_fun_bc, 32);
        hint(mp_obj_new_fun_bc, this::mp_obj_new_fun_bc, 68);
        hint(gen_wrap_call, this::gen_wrap_call, 0);
        hint(gen_wrap_call, this::gen_wrap_call, 16);
        hint(gen_wrap_call, this::gen_wrap_call, 24);
        hint(gen_wrap_call, this::gen_wrap_call, 28);
        hint(gen_wrap_call, this::gen_wrap_call, 44);
        hint(gen_wrap_call, this::gen_wrap_call, 72);
        hint(gen_instance_pend_throw, this::gen_instance_pend_throw, 0);
        hint(gen_instance_pend_throw, this::gen_instance_pend_throw, 16);
        hint(gen_instance_print, this::gen_instance_print, 0);
        hint(gen_instance_print, this::gen_instance_print, 12);
        hint(gen_instance_print, this::gen_instance_print, 24);
        hint(unlikely_gen_instance_throw_part_0, this::unlikely_gen_instance_throw_part_0, 0);
        hint(unlikely_gen_instance_throw_part_0, this::unlikely_gen_instance_throw_part_0, 8);
        hint(unlikely_gen_instance_throw_part_0, this::unlikely_gen_instance_throw_part_0, 12);
        hint(mp_obj_gen_resume, this::mp_obj_gen_resume, 0);
        hint(mp_obj_gen_resume, this::mp_obj_gen_resume, 14);
        hint(mp_obj_gen_resume, this::mp_obj_gen_resume, 50);
        hint(mp_obj_gen_resume, this::mp_obj_gen_resume, 76);
        hint(mp_obj_gen_resume, this::mp_obj_gen_resume, 102);
        hint(mp_obj_gen_resume, this::mp_obj_gen_resume, 154);
        hint(gen_resume_and_raise, this::gen_resume_and_raise, 0);
        hint(gen_resume_and_raise, this::gen_resume_and_raise, 8);
        hint(gen_resume_and_raise, this::gen_resume_and_raise, 38);
        hint(gen_resume_and_raise, this::gen_resume_and_raise, 42);
        hint(gen_resume_and_raise, this::gen_resume_and_raise, 52);
        hint(gen_resume_and_raise, this::gen_resume_and_raise, 58);
        hint(gen_resume_and_raise, this::gen_resume_and_raise, 72);
        hint(gen_instance_throw, this::gen_instance_throw, 0);
        hint(gen_instance_throw, this::gen_instance_throw, 18);
        hint(gen_instance_throw, this::gen_instance_throw, 26);
        hint(gen_instance_send, this::gen_instance_send, 0);
        hint(gen_instance_send, this::gen_instance_send, 8);
        hint(gen_instance_send, this::gen_instance_send, 16);
        hint(gen_instance_iternext, this::gen_instance_iternext, 0);
        hint(gen_instance_iternext, this::gen_instance_iternext, 10);
        hint(gen_instance_close, this::gen_instance_close, 0);
        hint(gen_instance_close, this::gen_instance_close, 14);
        hint(gen_instance_close, this::gen_instance_close, 34);
        hint(gen_instance_close, this::gen_instance_close, 40);
        hint(gen_instance_close, this::gen_instance_close, 46);
        hint(gen_instance_close, this::gen_instance_close, 56);
        hint(gen_instance_close, this::gen_instance_close, 62);
        hint(gen_instance_close, this::gen_instance_close, 72);
        hint(it_iternext, this::it_iternext, 0);
        hint(it_iternext, this::it_iternext, 12);
        hint(it_iternext, this::it_iternext, 24);
        hint(it_iternext, this::it_iternext, 44);
        hint(it_iternext, this::it_iternext, 72);
        hint(mp_obj_new_getitem_iter, this::mp_obj_new_getitem_iter, 0);
        hint(int_to_bytes, this::int_to_bytes, 0);
        hint(int_to_bytes, this::int_to_bytes, 12);
        hint(int_to_bytes, this::int_to_bytes, 22);
        hint(int_to_bytes, this::int_to_bytes, 42);
        hint(int_to_bytes, this::int_to_bytes, 54);
        hint(int_to_bytes, this::int_to_bytes, 72);
        hint(int_to_bytes, this::int_to_bytes, 80);
        hint(int_to_bytes, this::int_to_bytes, 114);
        hint(int_from_bytes, this::int_from_bytes, 0);
        hint(int_from_bytes, this::int_from_bytes, 16);
        hint(int_from_bytes, this::int_from_bytes, 52);
        hint(int_from_bytes, this::int_from_bytes, 82);
        hint(mp_obj_new_int_from_float, this::mp_obj_new_int_from_float, 0);
        hint(mp_obj_new_int_from_float, this::mp_obj_new_int_from_float, 16);
        hint(mp_obj_new_int_from_float, this::mp_obj_new_int_from_float, 28);
        hint(mp_obj_new_int_from_float, this::mp_obj_new_int_from_float, 40);
        hint(mp_obj_new_int_from_float, this::mp_obj_new_int_from_float, 44);
        hint(mp_obj_new_int_from_float, this::mp_obj_new_int_from_float, 50);
        hint(mp_obj_new_int_from_float, this::mp_obj_new_int_from_float, 76);
        hint(mp_obj_new_int_from_float, this::mp_obj_new_int_from_float, 86);
        hint(mp_obj_new_int_from_float, this::mp_obj_new_int_from_float, 102);
        hint(mp_obj_int_make_new, this::mp_obj_int_make_new, 0);
        hint(mp_obj_int_make_new, this::mp_obj_int_make_new, 24);
        hint(mp_obj_int_make_new, this::mp_obj_int_make_new, 70);
        hint(mp_obj_int_make_new, this::mp_obj_int_make_new, 80);
        hint(mp_obj_int_make_new, this::mp_obj_int_make_new, 92);
        hint(mp_obj_int_make_new, this::mp_obj_int_make_new, 96);
        hint(mp_obj_int_make_new, this::mp_obj_int_make_new, 108);
        hint(mp_obj_int_make_new, this::mp_obj_int_make_new, 118);
        hint(mp_obj_int_make_new, this::mp_obj_int_make_new, 136);
        hint(mp_int_format_size, this::mp_int_format_size, 0);
        hint(mp_int_format_size, this::mp_int_format_size, 18);
        hint(mp_int_format_size, this::mp_int_format_size, 34);
        hint(mp_int_format_size, this::mp_int_format_size, 44);
        hint(mp_obj_int_formatted, this::mp_obj_int_formatted, 0);
        hint(mp_obj_int_formatted, this::mp_obj_int_formatted, 50);
        hint(mp_obj_int_formatted, this::mp_obj_int_formatted, 62);
        hint(mp_obj_int_formatted, this::mp_obj_int_formatted, 100);
        hint(mp_obj_int_formatted, this::mp_obj_int_formatted, 178);
        hint(mp_obj_int_formatted, this::mp_obj_int_formatted, 204);
        hint(mp_obj_int_print, this::mp_obj_int_print, 0);
        hint(mp_obj_int_print, this::mp_obj_int_print, 38);
        hint(mp_obj_int_print, this::mp_obj_int_print, 46);
        hint(mp_obj_int_print, this::mp_obj_int_print, 58);
        hint(mp_obj_int_binary_op_extra_cases, this::mp_obj_int_binary_op_extra_cases, 0);
        hint(mp_obj_int_binary_op_extra_cases, this::mp_obj_int_binary_op_extra_cases, 20);
        hint(mp_obj_int_new_mpz, this::mp_obj_int_new_mpz, 0);
        hint(mp_obj_int_new_mpz, this::mp_obj_int_new_mpz, 8);
        hint(mp_obj_int_new_mpz, this::mp_obj_int_new_mpz, 18);
        hint(mp_obj_int_formatted_impl, this::mp_obj_int_formatted_impl, 0);
        hint(mp_obj_int_formatted_impl, this::mp_obj_int_formatted_impl, 38);
        hint(mp_obj_int_formatted_impl, this::mp_obj_int_formatted_impl, 50);
        hint(mp_obj_int_formatted_impl, this::mp_obj_int_formatted_impl, 74);
        hint(mp_obj_int_from_bytes_impl, this::mp_obj_int_from_bytes_impl, 0);
        hint(mp_obj_int_from_bytes_impl, this::mp_obj_int_from_bytes_impl, 12);
        hint(mp_obj_int_from_bytes_impl, this::mp_obj_int_from_bytes_impl, 26);
        hint(mp_obj_int_to_bytes_impl, this::mp_obj_int_to_bytes_impl, 0);
        hint(mp_obj_int_to_bytes_impl, this::mp_obj_int_to_bytes_impl, 18);
        hint(mp_obj_int_to_bytes_impl, this::mp_obj_int_to_bytes_impl, 30);
        hint(mp_obj_int_sign, this::mp_obj_int_sign, 0);
        hint(mp_obj_int_unary_op, this::mp_obj_int_unary_op, 0);
        hint(mp_obj_int_unary_op, this::mp_obj_int_unary_op, 54);
        hint(mp_obj_int_unary_op, this::mp_obj_int_unary_op, 66);
        hint(mp_obj_int_unary_op, this::mp_obj_int_unary_op, 76);
        hint(mp_obj_int_unary_op, this::mp_obj_int_unary_op, 84);
        hint(mp_obj_int_unary_op, this::mp_obj_int_unary_op, 94);
        hint(mp_obj_int_unary_op, this::mp_obj_int_unary_op, 106);
        hint(mp_obj_int_unary_op, this::mp_obj_int_unary_op, 116);
        hint(mp_obj_new_int_from_ll, this::mp_obj_new_int_from_ll, 0);
        hint(mp_obj_new_int_from_ll, this::mp_obj_new_int_from_ll, 10);
        hint(mp_obj_new_int_from_ll, this::mp_obj_new_int_from_ll, 26);
        hint(mp_obj_new_int, this::mp_obj_new_int, 0);
        hint(mp_obj_new_int, this::mp_obj_new_int, 22);
        hint(mp_obj_new_int_from_ull, this::mp_obj_new_int_from_ull, 0);
        hint(mp_obj_new_int_from_ull, this::mp_obj_new_int_from_ull, 10);
        hint(mp_obj_new_int_from_ull, this::mp_obj_new_int_from_ull, 26);
        hint(mp_obj_int_pow3, this::mp_obj_int_pow3, 0);
        hint(mp_obj_int_pow3, this::mp_obj_int_pow3, 78);
        hint(mp_obj_int_pow3, this::mp_obj_int_pow3, 86);
        hint(mp_obj_int_pow3, this::mp_obj_int_pow3, 104);
        hint(mp_obj_int_pow3, this::mp_obj_int_pow3, 122);
        hint(mp_obj_int_pow3, this::mp_obj_int_pow3, 140);
        hint(mp_obj_int_pow3, this::mp_obj_int_pow3, 156);
        hint(mp_obj_int_pow3, this::mp_obj_int_pow3, 168);
        hint(mp_obj_int_pow3, this::mp_obj_int_pow3, 180);
        hint(mp_obj_int_pow3, this::mp_obj_int_pow3, 192);
        hint(mp_obj_new_int_from_uint, this::mp_obj_new_int_from_uint, 0);
        hint(mp_obj_new_int_from_uint, this::mp_obj_new_int_from_uint, 20);
        hint(mp_obj_new_int_from_str_len, this::mp_obj_new_int_from_str_len, 0);
        hint(mp_obj_new_int_from_str_len, this::mp_obj_new_int_from_str_len, 16);
        hint(mp_obj_new_int_from_str_len, this::mp_obj_new_int_from_str_len, 34);
        hint(mp_obj_int_get_truncated, this::mp_obj_int_get_truncated, 0);
        hint(mp_obj_int_get_truncated, this::mp_obj_int_get_truncated, 16);
        hint(mp_obj_int_get_checked, this::mp_obj_int_get_checked, 0);
        hint(mp_obj_int_get_checked, this::mp_obj_int_get_checked, 18);
        hint(mp_obj_int_get_checked, this::mp_obj_int_get_checked, 34);
        hint(mp_obj_int_binary_op, this::mp_obj_int_binary_op, 0);
        hint(mp_obj_int_binary_op, this::mp_obj_int_binary_op, 28);
        hint(mp_obj_int_binary_op, this::mp_obj_int_binary_op, 50);
        hint(mp_obj_int_binary_op, this::mp_obj_int_binary_op, 74);
        hint(mp_obj_int_binary_op, this::mp_obj_int_binary_op, 82);
        hint(mp_obj_int_binary_op, this::mp_obj_int_binary_op, 90);
        hint(mp_obj_int_binary_op, this::mp_obj_int_binary_op, 94);
        hint(mp_obj_int_binary_op, this::mp_obj_int_binary_op, 130);
        hint(mp_obj_int_binary_op, this::mp_obj_int_binary_op, 140);
        hint(mp_obj_int_binary_op, this::mp_obj_int_binary_op, 154);
        hint(mp_obj_int_binary_op, this::mp_obj_int_binary_op, 166);
        hint(mp_obj_int_binary_op, this::mp_obj_int_binary_op, 184);
        hint(mp_obj_int_binary_op, this::mp_obj_int_binary_op, 200);
        hint(mp_obj_int_binary_op, this::mp_obj_int_binary_op, 240);
        hint(mp_obj_int_binary_op, this::mp_obj_int_binary_op, 254);
        hint(mp_obj_int_binary_op, this::mp_obj_int_binary_op, 266);
        hint(mp_obj_int_binary_op, this::mp_obj_int_binary_op, 292);
        hint(mp_obj_int_binary_op, this::mp_obj_int_binary_op, 314);
        hint(mp_obj_int_binary_op, this::mp_obj_int_binary_op, 354);
        hint(mp_obj_int_binary_op, this::mp_obj_int_binary_op, 380);
        hint(mp_obj_int_binary_op, this::mp_obj_int_binary_op, 414);
        hint(mp_obj_int_binary_op, this::mp_obj_int_binary_op, 426);
        hint(mp_obj_int_binary_op, this::mp_obj_int_binary_op, 442);
        hint(mp_obj_int_binary_op, this::mp_obj_int_binary_op, 448);
        hint(mp_obj_int_binary_op, this::mp_obj_int_binary_op, 460);
        hint(mp_obj_int_binary_op, this::mp_obj_int_binary_op, 466);
        hint(mp_obj_int_binary_op, this::mp_obj_int_binary_op, 478);
        hint(mp_obj_int_binary_op, this::mp_obj_int_binary_op, 490);
        hint(mp_obj_int_binary_op, this::mp_obj_int_binary_op, 498);
        hint(mp_obj_int_binary_op, this::mp_obj_int_binary_op, 508);
        hint(mp_obj_int_binary_op, this::mp_obj_int_binary_op, 524);
        hint(mp_obj_int_binary_op, this::mp_obj_int_binary_op, 530);
        hint(mp_obj_int_binary_op, this::mp_obj_int_binary_op, 540);
        hint(mp_obj_int_as_float_impl, this::mp_obj_int_as_float_impl, 0);
        hint(mp_obj_int_as_float_impl, this::mp_obj_int_as_float_impl, 8);
        hint(list_getiter, this::list_getiter, 0);
        hint(list_reverse, this::list_reverse, 0);
        hint(list_it_iternext, this::list_it_iternext, 0);
        hint(mp_obj_list_append, this::mp_obj_list_append, 0);
        hint(mp_obj_list_append, this::mp_obj_list_append, 24);
        hint(mp_obj_list_append, this::mp_obj_list_append, 54);
        hint(list_insert, this::list_insert, 0);
        hint(list_insert, this::list_insert, 28);
        hint(list_clear, this::list_clear, 0);
        hint(list_clear, this::list_clear, 20);
        hint(list_clear, this::list_clear, 34);
        hint(mp_quicksort, this::mp_quicksort, 0);
        hint(mp_quicksort, this::mp_quicksort, 16);
        hint(mp_quicksort, this::mp_quicksort, 48);
        hint(mp_quicksort, this::mp_quicksort, 76);
        hint(mp_quicksort, this::mp_quicksort, 104);
        hint(mp_quicksort, this::mp_quicksort, 128);
        hint(mp_quicksort, this::mp_quicksort, 140);
        hint(mp_quicksort, this::mp_quicksort, 184);
        hint(mp_quicksort, this::mp_quicksort, 204);
        hint(mp_obj_list_sort, this::mp_obj_list_sort, 0);
        hint(mp_obj_list_sort, this::mp_obj_list_sort, 24);
        hint(mp_obj_list_sort, this::mp_obj_list_sort, 66);
        hint(list_index, this::list_index, 0);
        hint(list_index, this::list_index, 16);
        hint(list_pop, this::list_pop, 0);
        hint(list_pop, this::list_pop, 22);
        hint(list_pop, this::list_pop, 36);
        hint(list_pop, this::list_pop, 64);
        hint(list_pop, this::list_pop, 98);
        hint(mp_obj_list_remove, this::mp_obj_list_remove, 0);
        hint(mp_obj_list_remove, this::mp_obj_list_remove, 14);
        hint(mp_obj_list_remove, this::mp_obj_list_remove, 24);
        hint(list_extend_from_iter, this::list_extend_from_iter, 0);
        hint(list_extend_from_iter, this::list_extend_from_iter, 12);
        hint(list_extend_from_iter, this::list_extend_from_iter, 20);
        hint(list_extend_from_iter, this::list_extend_from_iter, 34);
        hint(list_count, this::list_count, 0);
        hint(list_count, this::list_count, 12);
        hint(list_print, this::list_print, 0);
        hint(list_print, this::list_print, 22);
        hint(list_print, this::list_print, 38);
        hint(list_print, this::list_print, 52);
        hint(list_print, this::list_print, 66);
        hint(list_unary_op, this::list_unary_op, 0);
        hint(list_extend, this::list_extend, 0);
        hint(list_extend, this::list_extend, 44);
        hint(list_extend, this::list_extend, 68);
        hint(list_extend, this::list_extend, 86);
        hint(list_extend, this::list_extend, 106);
        hint(mp_obj_list_init, this::mp_obj_list_init, 0);
        hint(mp_obj_list_init, this::mp_obj_list_init, 28);
        hint(mp_obj_list_init, this::mp_obj_list_init, 46);
        hint(list_new, this::list_new, 0);
        hint(list_new, this::list_new, 10);
        hint(list_new, this::list_new, 18);
        hint(list_binary_op, this::list_binary_op, 0);
        hint(list_binary_op, this::list_binary_op, 36);
        hint(list_binary_op, this::list_binary_op, 60);
        hint(list_binary_op, this::list_binary_op, 78);
        hint(list_binary_op, this::list_binary_op, 110);
        hint(list_binary_op, this::list_binary_op, 124);
        hint(list_binary_op, this::list_binary_op, 142);
        hint(list_binary_op, this::list_binary_op, 156);
        hint(list_binary_op, this::list_binary_op, 194);
        hint(list_make_new, this::list_make_new, 0);
        hint(list_make_new, this::list_make_new, 22);
        hint(list_make_new, this::list_make_new, 32);
        hint(list_make_new, this::list_make_new, 40);
        hint(list_make_new, this::list_make_new, 46);
        hint(mp_obj_new_list, this::mp_obj_new_list, 0);
        hint(mp_obj_new_list, this::mp_obj_new_list, 10);
        hint(list_copy, this::list_copy, 0);
        hint(list_copy, this::list_copy, 10);
        hint(mp_obj_list_get, this::mp_obj_list_get, 0);
        hint(mp_obj_list_set_len, this::mp_obj_list_set_len, 0);
        hint(mp_obj_list_store, this::mp_obj_list_store, 0);
        hint(mp_obj_list_store, this::mp_obj_list_store, 18);
        hint(list_subscr, this::list_subscr, 0);
        hint(list_subscr, this::list_subscr, 38);
        hint(list_subscr, this::list_subscr, 48);
        hint(list_subscr, this::list_subscr, 74);
        hint(list_subscr, this::list_subscr, 94);
        hint(list_subscr, this::list_subscr, 120);
        hint(list_subscr, this::list_subscr, 146);
        hint(list_subscr, this::list_subscr, 160);
        hint(list_subscr, this::list_subscr, 174);
        hint(list_subscr, this::list_subscr, 194);
        hint(list_subscr, this::list_subscr, 208);
        hint(list_subscr, this::list_subscr, 238);
        hint(list_subscr, this::list_subscr, 248);
        hint(list_subscr, this::list_subscr, 288);
        hint(list_subscr, this::list_subscr, 326);
        hint(list_subscr, this::list_subscr, 344);
        hint(list_subscr, this::list_subscr, 364);
        hint(list_subscr, this::list_subscr, 396);
        hint(list_subscr, this::list_subscr, 416);
        hint(list_subscr, this::list_subscr, 428);
        hint(map_iternext, this::map_iternext, 0);
        hint(map_iternext, this::map_iternext, 12);
        hint(map_iternext, this::map_iternext, 32);
        hint(map_iternext, this::map_iternext, 46);
        hint(map_iternext, this::map_iternext, 60);
        hint(map_make_new, this::map_make_new, 0);
        hint(map_make_new, this::map_make_new, 26);
        hint(map_make_new, this::map_make_new, 38);
        hint(map_make_new, this::map_make_new, 76);
        hint(module_print, this::module_print, 0);
        hint(module_print, this::module_print, 18);
        hint(module_print, this::module_print, 30);
        hint(module_print, this::module_print, 44);
        hint(module_print, this::module_print, 54);
        hint(module_print, this::module_print, 66);
        hint(module_print, this::module_print, 78);
        hint(module_attr, this::module_attr, 0);
        hint(module_attr, this::module_attr, 26);
        hint(module_attr, this::module_attr, 66);
        hint(module_attr, this::module_attr, 86);
        hint(module_attr, this::module_attr, 94);
        hint(mp_obj_new_module, this::mp_obj_new_module, 0);
        hint(mp_obj_new_module, this::mp_obj_new_module, 18);
        hint(mp_obj_new_module, this::mp_obj_new_module, 32);
        hint(mp_obj_new_module, this::mp_obj_new_module, 44);
        hint(mp_obj_new_module, this::mp_obj_new_module, 54);
        hint(mp_module_register, this::mp_module_register, 0);
        hint(mp_module_register, this::mp_module_register, 18);
        hint(mp_module_call_init, this::mp_module_call_init, 0);
        hint(mp_module_call_init, this::mp_module_call_init, 16);
        hint(mp_module_call_init, this::mp_module_call_init, 32);
        hint(mp_module_call_init, this::mp_module_call_init, 40);
        hint(mp_module_get, this::mp_module_get, 0);
        hint(mp_module_get, this::mp_module_get, 20);
        hint(mp_module_get, this::mp_module_get, 34);
        hint(mp_module_get, this::mp_module_get, 46);
        hint(object___init__, this::object___init__, 0);
        hint(object___new__, this::object___new__, 0);
        hint(object___new__, this::object___new__, 28);
        hint(object___new__, this::object___new__, 34);
        hint(object_make_new, this::object_make_new, 0);
        hint(object_make_new, this::object_make_new, 18);
        hint(object_make_new, this::object_make_new, 24);
        hint(polymorph_it_iternext, this::polymorph_it_iternext, 0);
        hint(polymorph_it_iternext, this::polymorph_it_iternext, 6);
        hint(property_deleter, this::property_deleter, 0);
        hint(property_deleter, this::property_deleter, 12);
        hint(property_setter, this::property_setter, 0);
        hint(property_setter, this::property_setter, 12);
        hint(property_getter, this::property_getter, 0);
        hint(property_getter, this::property_getter, 12);
        hint(property_make_new, this::property_make_new, 0);
        hint(property_make_new, this::property_make_new, 26);
        hint(property_make_new, this::property_make_new, 32);
        hint(mp_obj_property_get, this::mp_obj_property_get, 0);
        hint(none_print, this::none_print, 0);
        hint(none_print, this::none_print, 14);
        hint(namedtuple_asdict, this::namedtuple_asdict, 0);
        hint(namedtuple_asdict, this::namedtuple_asdict, 16);
        hint(namedtuple_asdict, this::namedtuple_asdict, 64);
        hint(namedtuple_print, this::namedtuple_print, 0);
        hint(namedtuple_print, this::namedtuple_print, 16);
        hint(namedtuple_print, this::namedtuple_print, 28);
        hint(mp_obj_namedtuple_find_field, this::mp_obj_namedtuple_find_field, 0);
        hint(namedtuple_attr, this::namedtuple_attr, 0);
        hint(namedtuple_attr, this::namedtuple_attr, 28);
        hint(namedtuple_attr, this::namedtuple_attr, 50);
        hint(namedtuple_make_new, this::namedtuple_make_new, 0);
        hint(namedtuple_make_new, this::namedtuple_make_new, 32);
        hint(namedtuple_make_new, this::namedtuple_make_new, 36);
        hint(namedtuple_make_new, this::namedtuple_make_new, 44);
        hint(namedtuple_make_new, this::namedtuple_make_new, 64);
        hint(namedtuple_make_new, this::namedtuple_make_new, 78);
        hint(namedtuple_make_new, this::namedtuple_make_new, 102);
        hint(namedtuple_make_new, this::namedtuple_make_new, 112);
        hint(namedtuple_make_new, this::namedtuple_make_new, 126);
        hint(mp_obj_new_namedtuple_base, this::mp_obj_new_namedtuple_base, 0);
        hint(mp_obj_new_namedtuple_base, this::mp_obj_new_namedtuple_base, 18);
        hint(mp_obj_new_namedtuple_base, this::mp_obj_new_namedtuple_base, 28);
        hint(mp_obj_new_namedtuple_base, this::mp_obj_new_namedtuple_base, 52);
        hint(new_namedtuple_type, this::new_namedtuple_type, 0);
        hint(new_namedtuple_type, this::new_namedtuple_type, 8);
        hint(new_namedtuple_type, this::new_namedtuple_type, 40);
        hint(new_namedtuple_type, this::new_namedtuple_type, 52);
        hint(new_namedtuple_type, this::new_namedtuple_type, 60);
        hint(range_it_iternext, this::range_it_iternext, 0);
        hint(range_len, this::range_len, 0);
        hint(range_len, this::range_len, 24);
        hint(range_unary_op, this::range_unary_op, 0);
        hint(range_unary_op, this::range_unary_op, 10);
        hint(range_getiter, this::range_getiter, 0);
        hint(range_subscr, this::range_subscr, 0);
        hint(range_subscr, this::range_subscr, 20);
        hint(range_subscr, this::range_subscr, 40);
        hint(range_subscr, this::range_subscr, 46);
        hint(range_subscr, this::range_subscr, 106);
        hint(range_make_new, this::range_make_new, 0);
        hint(range_make_new, this::range_make_new, 26);
        hint(range_make_new, this::range_make_new, 32);
        hint(range_make_new, this::range_make_new, 54);
        hint(range_make_new, this::range_make_new, 66);
        hint(range_make_new, this::range_make_new, 74);
        hint(range_make_new, this::range_make_new, 86);
        hint(range_make_new, this::range_make_new, 98);
        hint(range_print, this::range_print, 0);
        hint(range_print, this::range_print, 16);
        hint(range_print, this::range_print, 30);
        hint(range_print, this::range_print, 40);
        hint(range_binary_op, this::range_binary_op, 0);
        hint(range_binary_op, this::range_binary_op, 36);
        hint(range_binary_op, this::range_binary_op, 44);
        hint(range_attr, this::range_attr, 0);
        hint(range_attr, this::range_attr, 24);
        hint(reversed_iternext, this::reversed_iternext, 0);
        hint(reversed_iternext, this::reversed_iternext, 28);
        hint(reversed_make_new, this::reversed_make_new, 0);
        hint(reversed_make_new, this::reversed_make_new, 22);
        hint(reversed_make_new, this::reversed_make_new, 32);
        hint(reversed_make_new, this::reversed_make_new, 48);
        hint(reversed_make_new, this::reversed_make_new, 62);
        hint(reversed_make_new, this::reversed_make_new, 76);
        hint(reversed_make_new, this::reversed_make_new, 80);
        hint(is_set_or_frozenset, this::is_set_or_frozenset, 0);
        hint(set_getiter, this::set_getiter, 0);
        hint(text_set_add, this::text_set_add, 0);
        hint(text_set_add, this::text_set_add, 10);
        hint(set_discard, this::set_discard, 0);
        hint(set_discard, this::set_discard, 10);
        hint(set_update_int, this::set_update_int, 0);
        hint(set_update_int, this::set_update_int, 12);
        hint(set_update_int, this::set_update_int, 20);
        hint(set_update_int, this::set_update_int, 36);
        hint(set_update, this::set_update, 0);
        hint(set_update, this::set_update, 26);
        hint(set_symmetric_difference_update, this::set_symmetric_difference_update, 0);
        hint(set_symmetric_difference_update, this::set_symmetric_difference_update, 12);
        hint(set_symmetric_difference_update, this::set_symmetric_difference_update, 20);
        hint(set_symmetric_difference_update, this::set_symmetric_difference_update, 38);
        hint(set_isdisjoint, this::set_isdisjoint, 0);
        hint(set_isdisjoint, this::set_isdisjoint, 14);
        hint(set_isdisjoint, this::set_isdisjoint, 22);
        hint(set_isdisjoint, this::set_isdisjoint, 42);
        hint(set_copy, this::set_copy, 0);
        hint(set_copy, this::set_copy, 10);
        hint(set_copy, this::set_copy, 22);
        hint(set_copy, this::set_copy, 38);
        hint(set_union, this::set_union, 0);
        hint(set_union, this::set_union, 8);
        hint(set_union, this::set_union, 16);
        hint(set_symmetric_difference, this::set_symmetric_difference, 0);
        hint(set_symmetric_difference, this::set_symmetric_difference, 8);
        hint(set_symmetric_difference, this::set_symmetric_difference, 16);
        hint(set_clear, this::set_clear, 0);
        hint(set_clear, this::set_clear, 8);
        hint(set_diff_int, this::set_diff_int, 0);
        hint(set_diff_int, this::set_diff_int, 18);
        hint(set_diff_int, this::set_diff_int, 48);
        hint(set_diff_int, this::set_diff_int, 58);
        hint(set_diff_int, this::set_diff_int, 66);
        hint(set_diff_int, this::set_diff_int, 78);
        hint(set_diff_update, this::set_diff_update, 0);
        hint(set_diff_update, this::set_diff_update, 8);
        hint(set_diff, this::set_diff, 0);
        hint(set_diff, this::set_diff, 8);
        hint(set_print, this::set_print, 0);
        hint(set_print, this::set_print, 40);
        hint(set_print, this::set_print, 48);
        hint(set_print, this::set_print, 62);
        hint(set_print, this::set_print, 70);
    }

    private void gen_hints_7() {
        hint(set_print, this::set_print, 88);
        hint(set_print, this::set_print, 126);
        hint(set_print, this::set_print, 140);
        hint(set_remove, this::set_remove, 0);
        hint(set_remove, this::set_remove, 12);
        hint(set_remove, this::set_remove, 24);
        hint(set_remove, this::set_remove, 28);
        hint(text_set_pop, this::text_set_pop, 0);
        hint(text_set_pop, this::text_set_pop, 8);
        hint(text_set_pop, this::text_set_pop, 20);
        hint(set_it_iternext, this::set_it_iternext, 0);
        hint(set_unary_op, this::set_unary_op, 0);
        hint(set_unary_op, this::set_unary_op, 92);
        hint(mp_obj_new_set, this::mp_obj_new_set, 0);
        hint(mp_obj_new_set, this::mp_obj_new_set, 12);
        hint(mp_obj_new_set, this::mp_obj_new_set, 28);
        hint(mp_obj_new_set, this::mp_obj_new_set, 50);
        hint(set_intersect_int_part_4, this::set_intersect_int_part_4, 0);
        hint(set_intersect_int_part_4, this::set_intersect_int_part_4, 16);
        hint(set_intersect_int_part_4, this::set_intersect_int_part_4, 26);
        hint(set_intersect_int_part_4, this::set_intersect_int_part_4, 34);
        hint(set_intersect_int_part_4, this::set_intersect_int_part_4, 54);
        hint(set_intersect_int_part_4, this::set_intersect_int_part_4, 82);
        hint(set_intersect_int_part_4, this::set_intersect_int_part_4, 94);
        hint(set_intersect_update, this::set_intersect_update, 0);
        hint(set_intersect_update, this::set_intersect_update, 14);
        hint(set_intersect, this::set_intersect, 0);
        hint(set_intersect, this::set_intersect, 10);
        hint(set_intersect, this::set_intersect, 18);
        hint(mp_obj_set_store, this::mp_obj_set_store, 0);
        hint(mp_obj_set_store, this::mp_obj_set_store, 10);
        hint(set_make_new, this::set_make_new, 0);
        hint(set_make_new, this::set_make_new, 24);
        hint(set_make_new, this::set_make_new, 36);
        hint(set_make_new, this::set_make_new, 52);
        hint(set_make_new, this::set_make_new, 62);
        hint(set_make_new, this::set_make_new, 70);
        hint(set_make_new, this::set_make_new, 80);
        hint(set_issubset_internal, this::set_issubset_internal, 0);
        hint(set_issubset_internal, this::set_issubset_internal, 18);
        hint(set_issubset_internal, this::set_issubset_internal, 34);
        hint(set_issubset_internal, this::set_issubset_internal, 48);
        hint(set_issubset_internal, this::set_issubset_internal, 64);
        hint(set_issubset_internal, this::set_issubset_internal, 106);
        hint(set_issubset_internal, this::set_issubset_internal, 124);
        hint(set_issubset_internal, this::set_issubset_internal, 134);
        hint(set_issubset_internal, this::set_issubset_internal, 150);
        hint(set_issuperset, this::set_issuperset, 0);
        hint(set_issuperset, this::set_issuperset, 14);
        hint(set_issubset, this::set_issubset, 0);
        hint(set_issubset, this::set_issubset, 8);
        hint(set_binary_op, this::set_binary_op, 0);
        hint(set_binary_op, this::set_binary_op, 40);
        hint(set_binary_op, this::set_binary_op, 96);
        hint(set_binary_op, this::set_binary_op, 122);
        hint(set_binary_op, this::set_binary_op, 142);
        hint(set_binary_op, this::set_binary_op, 152);
        hint(set_binary_op, this::set_binary_op, 162);
        hint(set_binary_op, this::set_binary_op, 174);
        hint(set_binary_op, this::set_binary_op, 188);
        hint(set_binary_op, this::set_binary_op, 204);
        hint(set_binary_op, this::set_binary_op, 214);
        hint(set_binary_op, this::set_binary_op, 230);
        hint(set_binary_op, this::set_binary_op, 256);
        hint(set_binary_op, this::set_binary_op, 266);
        hint(set_binary_op, this::set_binary_op, 278);
        hint(singleton_print, this::singleton_print, 0);
        hint(singleton_print, this::singleton_print, 10);
        hint(slice_print, this::slice_print, 0);
        hint(slice_print, this::slice_print, 12);
        hint(slice_print, this::slice_print, 22);
        hint(slice_print, this::slice_print, 32);
        hint(slice_print, this::slice_print, 42);
        hint(slice_print, this::slice_print, 50);
        hint(slice_print, this::slice_print, 60);
        hint(slice_print, this::slice_print, 68);
        hint(slice_attr, this::slice_attr, 0);
        hint(mp_obj_new_slice, this::mp_obj_new_slice, 0);
        hint(mp_obj_new_slice, this::mp_obj_new_slice, 14);
        hint(mp_obj_slice_get, this::mp_obj_slice_get, 0);
        hint(arg_looks_integer, this::arg_looks_integer, 0);
        hint(arg_looks_numeric, this::arg_looks_numeric, 0);
        hint(arg_looks_numeric, this::arg_looks_numeric, 8);
        hint(mp_obj_new_bytes_iterator, this::mp_obj_new_bytes_iterator, 0);
        hint(bytes_it_iternext, this::bytes_it_iternext, 0);
        hint(bytes_it_iternext, this::bytes_it_iternext, 22);
        hint(unlikely_bad_implicit_conversion, this::unlikely_bad_implicit_conversion, 0);
        hint(unlikely_bad_implicit_conversion, this::unlikely_bad_implicit_conversion, 6);
        hint(unlikely_bad_implicit_conversion, this::unlikely_bad_implicit_conversion, 28);
        hint(unlikely_bad_implicit_conversion, this::unlikely_bad_implicit_conversion, 32);
        hint(str_count, this::str_count, 0);
        hint(str_count, this::str_count, 14);
        hint(str_count, this::str_count, 22);
        hint(str_count, this::str_count, 34);
        hint(str_count, this::str_count, 52);
        hint(str_count, this::str_count, 72);
        hint(str_count, this::str_count, 108);
        hint(str_count, this::str_count, 138);
        hint(str_count, this::str_count, 158);
        hint(str_count, this::str_count, 196);
        hint(str_count, this::str_count, 224);
        hint(str_uni_istype, this::str_uni_istype, 0);
        hint(str_uni_istype, this::str_uni_istype, 20);
        hint(str_uni_istype, this::str_uni_istype, 86);
        hint(str_uni_istype, this::str_uni_istype, 100);
        hint(str_uni_istype, this::str_uni_istype, 108);
        hint(str_isspace, this::str_isspace, 0);
        hint(str_isspace, this::str_isspace, 10);
        hint(str_isalpha, this::str_isalpha, 0);
        hint(str_isalpha, this::str_isalpha, 10);
        hint(str_isdigit, this::str_isdigit, 0);
        hint(str_isdigit, this::str_isdigit, 10);
        hint(str_isupper, this::str_isupper, 0);
        hint(str_isupper, this::str_isupper, 10);
        hint(str_islower, this::str_islower, 0);
        hint(str_islower, this::str_islower, 10);
        hint(str_to_int, this::str_to_int, 0);
        hint(mp_obj_str_get_buffer, this::mp_obj_str_get_buffer, 0);
        hint(mp_obj_str_get_buffer, this::mp_obj_str_get_buffer, 24);
        hint(mp_str_print_quoted, this::mp_str_print_quoted, 0);
        hint(mp_str_print_quoted, this::mp_str_print_quoted, 44);
        hint(mp_str_print_quoted, this::mp_str_print_quoted, 60);
        hint(mp_str_print_quoted, this::mp_str_print_quoted, 108);
        hint(mp_str_print_quoted, this::mp_str_print_quoted, 164);
        hint(mp_str_print_json, this::mp_str_print_json, 0);
        hint(mp_str_print_json, this::mp_str_print_json, 16);
        hint(mp_str_print_json, this::mp_str_print_json, 30);
        hint(mp_str_print_json, this::mp_str_print_json, 50);
        hint(mp_str_print_json, this::mp_str_print_json, 84);
        hint(str_print, this::str_print, 0);
        hint(str_print, this::str_print, 22);
        hint(str_print, this::str_print, 38);
        hint(str_print, this::str_print, 64);
        hint(str_print, this::str_print, 74);
        hint(str_print, this::str_print, 86);
        hint(find_subbytes, this::find_subbytes, 0);
        hint(find_subbytes, this::find_subbytes, 42);
        hint(str_finder, this::str_finder, 0);
        hint(str_finder, this::str_finder, 18);
        hint(str_finder, this::str_finder, 26);
        hint(str_finder, this::str_finder, 38);
        hint(str_finder, this::str_finder, 56);
        hint(str_finder, this::str_finder, 76);
        hint(str_finder, this::str_finder, 112);
        hint(str_finder, this::str_finder, 142);
        hint(str_finder, this::str_finder, 166);
        hint(str_finder, this::str_finder, 186);
        hint(str_finder, this::str_finder, 218);
        hint(str_find, this::str_find, 0);
        hint(str_find, this::str_find, 10);
        hint(str_rfind, this::str_rfind, 0);
        hint(str_rfind, this::str_rfind, 12);
        hint(str_index, this::str_index, 0);
        hint(str_index, this::str_index, 10);
        hint(str_rindex, this::str_rindex, 0);
        hint(str_rindex, this::str_rindex, 12);
        hint(mp_obj_new_str_copy, this::mp_obj_new_str_copy, 0);
        hint(mp_obj_new_str_copy, this::mp_obj_new_str_copy, 14);
        hint(mp_obj_new_str_copy, this::mp_obj_new_str_copy, 32);
        hint(mp_obj_new_str_copy, this::mp_obj_new_str_copy, 40);
        hint(mp_obj_new_str_copy, this::mp_obj_new_str_copy, 52);
        hint(mp_obj_new_str_via_qstr, this::mp_obj_new_str_via_qstr, 0);
        hint(mp_obj_new_str_via_qstr, this::mp_obj_new_str_via_qstr, 6);
        hint(mp_obj_new_str_from_vstr, this::mp_obj_new_str_from_vstr, 0);
        hint(mp_obj_new_str_from_vstr, this::mp_obj_new_str_from_vstr, 20);
        hint(mp_obj_new_str_from_vstr, this::mp_obj_new_str_from_vstr, 30);
        hint(mp_obj_new_str_from_vstr, this::mp_obj_new_str_from_vstr, 50);
        hint(mp_obj_new_str_from_vstr, this::mp_obj_new_str_from_vstr, 64);
        hint(mp_obj_new_str_from_vstr, this::mp_obj_new_str_from_vstr, 100);
        hint(str_join, this::str_join, 0);
        hint(str_join, this::str_join, 12);
        hint(str_join, this::str_join, 30);
        hint(str_join, this::str_join, 66);
        hint(str_join, this::str_join, 80);
        hint(str_join, this::str_join, 98);
        hint(str_join, this::str_join, 114);
        hint(str_join, this::str_join, 140);
        hint(str_join, this::str_join, 150);
        hint(str_join, this::str_join, 178);
        hint(str_join, this::str_join, 202);
        hint(str_join, this::str_join, 228);
        hint(str_join, this::str_join, 238);
        hint(str_center, this::str_center, 0);
        hint(str_center, this::str_center, 24);
        hint(str_center, this::str_center, 32);
        hint(str_center, this::str_center, 48);
        hint(str_center, this::str_center, 58);
        hint(str_center, this::str_center, 78);
        hint(str_center, this::str_center, 84);
        hint(str_center, this::str_center, 90);
        hint(str_replace, this::str_replace, 0);
        hint(str_replace, this::str_replace, 16);
        hint(str_replace, this::str_replace, 44);
        hint(str_replace, this::str_replace, 52);
        hint(str_replace, this::str_replace, 64);
        hint(str_replace, this::str_replace, 70);
        hint(str_replace, this::str_replace, 98);
        hint(str_replace, this::str_replace, 118);
        hint(str_replace, this::str_replace, 138);
        hint(str_replace, this::str_replace, 172);
        hint(str_replace, this::str_replace, 244);
        hint(str_replace, this::str_replace, 262);
        hint(str_replace, this::str_replace, 324);
        hint(str_replace, this::str_replace, 346);
        hint(str_replace, this::str_replace, 368);
        hint(str_replace, this::str_replace, 388);
        hint(str_caseconv, this::str_caseconv, 0);
        hint(str_caseconv, this::str_caseconv, 24);
        hint(str_caseconv, this::str_caseconv, 36);
        hint(str_caseconv, this::str_caseconv, 52);
        hint(str_caseconv, this::str_caseconv, 58);
        hint(str_caseconv, this::str_caseconv, 74);
        hint(str_lower, this::str_lower, 0);
        hint(str_lower, this::str_lower, 10);
        hint(str_upper, this::str_upper, 0);
        hint(str_upper, this::str_upper, 10);
        hint(mp_obj_new_str, this::mp_obj_new_str, 0);
        hint(mp_obj_new_str, this::mp_obj_new_str, 10);
        hint(mp_obj_new_str, this::mp_obj_new_str, 32);
        hint(mp_obj_str_make_new, this::mp_obj_str_make_new, 0);
        hint(mp_obj_str_make_new, this::mp_obj_str_make_new, 20);
        hint(mp_obj_str_make_new, this::mp_obj_str_make_new, 32);
        hint(mp_obj_str_make_new, this::mp_obj_str_make_new, 50);
        hint(mp_obj_str_make_new, this::mp_obj_str_make_new, 60);
        hint(mp_obj_str_make_new, this::mp_obj_str_make_new, 68);
        hint(mp_obj_str_make_new, this::mp_obj_str_make_new, 104);
        hint(mp_obj_str_make_new, this::mp_obj_str_make_new, 114);
        hint(mp_obj_str_make_new, this::mp_obj_str_make_new, 126);
        hint(mp_obj_str_make_new, this::mp_obj_str_make_new, 134);
        hint(mp_obj_str_make_new, this::mp_obj_str_make_new, 152);
        hint(mp_obj_str_make_new, this::mp_obj_str_make_new, 170);
        hint(mp_obj_str_make_new, this::mp_obj_str_make_new, 178);
        hint(mp_obj_str_make_new, this::mp_obj_str_make_new, 190);
        hint(bytes_decode, this::bytes_decode, 0);
        hint(bytes_decode, this::bytes_decode, 32);
        hint(mp_obj_new_bytes, this::mp_obj_new_bytes, 0);
        hint(mp_obj_new_bytes, this::mp_obj_new_bytes, 12);
        hint(bytes_make_new_part_4, this::bytes_make_new_part_4, 0);
        hint(bytes_make_new_part_4, this::bytes_make_new_part_4, 50);
        hint(bytes_make_new_part_4, this::bytes_make_new_part_4, 68);
        hint(bytes_make_new_part_4, this::bytes_make_new_part_4, 82);
        hint(bytes_make_new_part_4, this::bytes_make_new_part_4, 92);
        hint(bytes_make_new_part_4, this::bytes_make_new_part_4, 144);
        hint(bytes_make_new_part_4, this::bytes_make_new_part_4, 158);
        hint(bytes_make_new_part_4, this::bytes_make_new_part_4, 166);
        hint(bytes_make_new_part_4, this::bytes_make_new_part_4, 174);
        hint(bytes_make_new_part_4, this::bytes_make_new_part_4, 186);
        hint(bytes_make_new_part_4, this::bytes_make_new_part_4, 194);
        hint(bytes_make_new_part_4, this::bytes_make_new_part_4, 208);
        hint(bytes_make_new_part_4, this::bytes_make_new_part_4, 216);
        hint(bytes_make_new_part_4, this::bytes_make_new_part_4, 224);
        hint(bytes_make_new_part_4, this::bytes_make_new_part_4, 236);
        hint(bytes_make_new_part_4, this::bytes_make_new_part_4, 246);
        hint(bytes_make_new_part_4, this::bytes_make_new_part_4, 254);
        hint(bytes_make_new_part_4, this::bytes_make_new_part_4, 262);
        hint(bytes_make_new, this::bytes_make_new, 0);
        hint(bytes_make_new, this::bytes_make_new, 12);
        hint(bytes_make_new, this::bytes_make_new, 26);
        hint(str_encode, this::str_encode, 0);
        hint(str_encode, this::str_encode, 30);
        hint(mp_obj_new_str_of_type, this::mp_obj_new_str_of_type, 0);
        hint(mp_obj_new_str_of_type, this::mp_obj_new_str_of_type, 18);
        hint(mp_obj_new_str_of_type, this::mp_obj_new_str_of_type, 24);
        hint(str_splitlines, this::str_splitlines, 0);
        hint(str_splitlines, this::str_splitlines, 24);
        hint(str_splitlines, this::str_splitlines, 30);
        hint(str_splitlines, this::str_splitlines, 40);
        hint(str_splitlines, this::str_splitlines, 60);
        hint(str_splitlines, this::str_splitlines, 126);
        hint(str_splitlines, this::str_splitlines, 134);
        hint(str_uni_strip, this::str_uni_strip, 0);
        hint(str_uni_strip, this::str_uni_strip, 16);
        hint(str_uni_strip, this::str_uni_strip, 28);
        hint(str_uni_strip, this::str_uni_strip, 40);
        hint(str_uni_strip, this::str_uni_strip, 58);
        hint(str_uni_strip, this::str_uni_strip, 82);
        hint(str_uni_strip, this::str_uni_strip, 196);
        hint(str_uni_strip, this::str_uni_strip, 276);
        hint(str_strip, this::str_strip, 0);
        hint(str_strip, this::str_strip, 12);
        hint(str_lstrip, this::str_lstrip, 0);
        hint(str_lstrip, this::str_lstrip, 12);
        hint(str_rstrip, this::str_rstrip, 0);
        hint(str_rstrip, this::str_rstrip, 12);
        hint(str_partitioner, this::str_partitioner, 0);
        hint(str_partitioner, this::str_partitioner, 14);
        hint(str_partitioner, this::str_partitioner, 22);
        hint(str_partitioner, this::str_partitioner, 34);
        hint(str_partitioner, this::str_partitioner, 50);
        hint(str_partitioner, this::str_partitioner, 68);
        hint(str_partitioner, this::str_partitioner, 82);
        hint(str_partitioner, this::str_partitioner, 132);
        hint(str_partitioner, this::str_partitioner, 148);
        hint(str_partitioner, this::str_partitioner, 170);
        hint(str_partitioner, this::str_partitioner, 180);
        hint(str_partition, this::str_partition, 0);
        hint(str_partition, this::str_partition, 8);
        hint(str_rpartition, this::str_rpartition, 0);
        hint(str_rpartition, this::str_rpartition, 10);
        hint(bytes_subscr, this::bytes_subscr, 0);
        hint(bytes_subscr, this::bytes_subscr, 14);
        hint(bytes_subscr, this::bytes_subscr, 32);
        hint(bytes_subscr, this::bytes_subscr, 60);
        hint(bytes_subscr, this::bytes_subscr, 70);
        hint(bytes_subscr, this::bytes_subscr, 92);
        hint(bytes_subscr, this::bytes_subscr, 108);
        hint(mp_obj_str_equal, this::mp_obj_str_equal, 0);
        hint(mp_obj_str_equal, this::mp_obj_str_equal, 42);
        hint(mp_obj_str_equal, this::mp_obj_str_equal, 60);
        hint(mp_obj_str_equal, this::mp_obj_str_equal, 92);
        hint(mp_obj_str_equal, this::mp_obj_str_equal, 106);
        hint(mp_obj_str_equal, this::mp_obj_str_equal, 122);
        hint(mp_obj_str_get_qstr, this::mp_obj_str_get_qstr, 0);
        hint(mp_obj_str_get_qstr, this::mp_obj_str_get_qstr, 34);
        hint(mp_obj_str_get_qstr, this::mp_obj_str_get_qstr, 40);
        hint(mp_obj_str_get_str, this::mp_obj_str_get_str, 0);
        hint(mp_obj_str_get_str, this::mp_obj_str_get_str, 28);
        hint(mp_obj_str_get_str, this::mp_obj_str_get_str, 36);
        hint(mp_obj_str_get_data, this::mp_obj_str_get_data, 0);
        hint(mp_obj_str_get_data, this::mp_obj_str_get_data, 30);
        hint(mp_obj_str_get_data, this::mp_obj_str_get_data, 38);
        hint(mp_obj_str_binary_op, this::mp_obj_str_binary_op, 0);
        hint(mp_obj_str_binary_op, this::mp_obj_str_binary_op, 58);
        hint(mp_obj_str_binary_op, this::mp_obj_str_binary_op, 88);
        hint(mp_obj_str_binary_op, this::mp_obj_str_binary_op, 104);
        hint(mp_obj_str_binary_op, this::mp_obj_str_binary_op, 148);
        hint(mp_obj_str_binary_op, this::mp_obj_str_binary_op, 198);
        hint(mp_obj_str_binary_op, this::mp_obj_str_binary_op, 216);
        hint(mp_obj_str_binary_op, this::mp_obj_str_binary_op, 228);
        hint(mp_obj_str_binary_op, this::mp_obj_str_binary_op, 250);
        hint(mp_obj_str_binary_op, this::mp_obj_str_binary_op, 266);
        hint(mp_obj_str_binary_op, this::mp_obj_str_binary_op, 274);
        hint(mp_obj_str_binary_op, this::mp_obj_str_binary_op, 408);
        hint(mp_obj_str_binary_op, this::mp_obj_str_binary_op, 466);
        hint(mp_obj_str_binary_op, this::mp_obj_str_binary_op, 542);
        hint(mp_obj_str_binary_op, this::mp_obj_str_binary_op, 546);
        hint(mp_obj_str_binary_op, this::mp_obj_str_binary_op, 556);
        hint(mp_obj_str_binary_op, this::mp_obj_str_binary_op, 572);
        hint(mp_obj_str_binary_op, this::mp_obj_str_binary_op, 602);
        hint(mp_obj_str_binary_op, this::mp_obj_str_binary_op, 606);
        hint(mp_obj_str_binary_op, this::mp_obj_str_binary_op, 634);
        hint(mp_obj_str_binary_op, this::mp_obj_str_binary_op, 748);
        hint(mp_obj_str_binary_op, this::mp_obj_str_binary_op, 776);
        hint(mp_obj_str_binary_op, this::mp_obj_str_binary_op, 784);
        hint(mp_obj_str_binary_op, this::mp_obj_str_binary_op, 794);
        hint(mp_obj_str_binary_op, this::mp_obj_str_binary_op, 874);
        hint(mp_obj_str_binary_op, this::mp_obj_str_binary_op, 898);
        hint(mp_obj_str_binary_op, this::mp_obj_str_binary_op, 910);
        hint(mp_obj_str_binary_op, this::mp_obj_str_binary_op, 954);
        hint(mp_obj_str_binary_op, this::mp_obj_str_binary_op, 990);
        hint(mp_obj_str_binary_op, this::mp_obj_str_binary_op, 996);
        hint(mp_obj_str_binary_op, this::mp_obj_str_binary_op, 1004);
        hint(mp_obj_str_binary_op, this::mp_obj_str_binary_op, 1018);
        hint(mp_obj_str_binary_op, this::mp_obj_str_binary_op, 1032);
        hint(mp_obj_str_binary_op, this::mp_obj_str_binary_op, 1080);
        hint(mp_obj_str_binary_op, this::mp_obj_str_binary_op, 1098);
        hint(mp_obj_str_binary_op, this::mp_obj_str_binary_op, 1108);
        hint(mp_obj_str_binary_op, this::mp_obj_str_binary_op, 1132);
        hint(mp_obj_str_binary_op, this::mp_obj_str_binary_op, 1174);
        hint(mp_obj_str_binary_op, this::mp_obj_str_binary_op, 1190);
        hint(mp_obj_str_binary_op, this::mp_obj_str_binary_op, 1214);
        hint(mp_obj_str_binary_op, this::mp_obj_str_binary_op, 1234);
        hint(mp_obj_str_binary_op, this::mp_obj_str_binary_op, 1258);
        hint(mp_obj_str_binary_op, this::mp_obj_str_binary_op, 1272);
        hint(mp_obj_str_binary_op, this::mp_obj_str_binary_op, 1292);
        hint(mp_obj_str_binary_op, this::mp_obj_str_binary_op, 1300);
        hint(mp_obj_str_binary_op, this::mp_obj_str_binary_op, 1322);
        hint(mp_obj_str_split, this::mp_obj_str_split, 0);
        hint(mp_obj_str_split, this::mp_obj_str_split, 14);
        hint(mp_obj_str_split, this::mp_obj_str_split, 32);
        hint(mp_obj_str_split, this::mp_obj_str_split, 42);
        hint(mp_obj_str_split, this::mp_obj_str_split, 62);
        hint(mp_obj_str_split, this::mp_obj_str_split, 84);
        hint(mp_obj_str_split, this::mp_obj_str_split, 102);
        hint(mp_obj_str_split, this::mp_obj_str_split, 110);
        hint(mp_obj_str_split, this::mp_obj_str_split, 140);
        hint(mp_obj_str_split, this::mp_obj_str_split, 160);
        hint(mp_obj_str_split, this::mp_obj_str_split, 168);
        hint(mp_obj_str_split, this::mp_obj_str_split, 198);
        hint(mp_obj_str_split, this::mp_obj_str_split, 220);
        hint(mp_obj_str_split, this::mp_obj_str_split, 232);
        hint(mp_obj_str_split, this::mp_obj_str_split, 240);
        hint(mp_obj_str_split, this::mp_obj_str_split, 254);
        hint(mp_obj_str_split, this::mp_obj_str_split, 266);
        hint(mp_obj_str_split, this::mp_obj_str_split, 274);
        hint(mp_obj_str_split, this::mp_obj_str_split, 316);
        hint(str_rsplit, this::str_rsplit, 0);
        hint(str_rsplit, this::str_rsplit, 20);
        hint(str_rsplit, this::str_rsplit, 34);
        hint(str_rsplit, this::str_rsplit, 56);
        hint(str_rsplit, this::str_rsplit, 64);
        hint(str_rsplit, this::str_rsplit, 80);
        hint(str_rsplit, this::str_rsplit, 94);
        hint(str_rsplit, this::str_rsplit, 112);
        hint(str_rsplit, this::str_rsplit, 126);
        hint(str_rsplit, this::str_rsplit, 166);
        hint(str_rsplit, this::str_rsplit, 194);
        hint(str_rsplit, this::str_rsplit, 218);
        hint(str_rsplit, this::str_rsplit, 234);
        hint(str_rsplit, this::str_rsplit, 262);
        hint(str_startswith, this::str_startswith, 0);
        hint(str_startswith, this::str_startswith, 14);
        hint(str_startswith, this::str_startswith, 34);
        hint(str_startswith, this::str_startswith, 44);
        hint(str_startswith, this::str_startswith, 68);
        hint(str_startswith, this::str_startswith, 88);
        hint(str_endswith, this::str_endswith, 0);
        hint(str_endswith, this::str_endswith, 24);
        hint(str_endswith, this::str_endswith, 34);
        hint(str_endswith, this::str_endswith, 46);
        hint(str_endswith, this::str_endswith, 72);
        hint(mp_obj_str_format_helper, this::mp_obj_str_format_helper, 0);
        hint(mp_obj_str_format_helper, this::mp_obj_str_format_helper, 22);
        hint(mp_obj_str_format_helper, this::mp_obj_str_format_helper, 78);
        hint(mp_obj_str_format_helper, this::mp_obj_str_format_helper, 88);
        hint(mp_obj_str_format_helper, this::mp_obj_str_format_helper, 98);
        hint(mp_obj_str_format_helper, this::mp_obj_str_format_helper, 260);
        hint(mp_obj_str_format_helper, this::mp_obj_str_format_helper, 264);
        hint(mp_obj_str_format_helper, this::mp_obj_str_format_helper, 318);
        hint(mp_obj_str_format_helper, this::mp_obj_str_format_helper, 346);
        hint(mp_obj_str_format_helper, this::mp_obj_str_format_helper, 366);
        hint(mp_obj_str_format_helper, this::mp_obj_str_format_helper, 392);
        hint(mp_obj_str_format_helper, this::mp_obj_str_format_helper, 416);
        hint(mp_obj_str_format_helper, this::mp_obj_str_format_helper, 428);
        hint(mp_obj_str_format_helper, this::mp_obj_str_format_helper, 440);
        hint(mp_obj_str_format_helper, this::mp_obj_str_format_helper, 516);
        hint(mp_obj_str_format_helper, this::mp_obj_str_format_helper, 526);
        hint(mp_obj_str_format_helper, this::mp_obj_str_format_helper, 534);
        hint(mp_obj_str_format_helper, this::mp_obj_str_format_helper, 554);
        hint(mp_obj_str_format_helper, this::mp_obj_str_format_helper, 578);
        hint(mp_obj_str_format_helper, this::mp_obj_str_format_helper, 584);
        hint(mp_obj_str_format_helper, this::mp_obj_str_format_helper, 612);
        hint(mp_obj_str_format_helper, this::mp_obj_str_format_helper, 684);
        hint(mp_obj_str_format_helper, this::mp_obj_str_format_helper, 722);
        hint(mp_obj_str_format_helper, this::mp_obj_str_format_helper, 740);
        hint(mp_obj_str_format_helper, this::mp_obj_str_format_helper, 764);
        hint(mp_obj_str_format_helper, this::mp_obj_str_format_helper, 794);
        hint(mp_obj_str_format_helper, this::mp_obj_str_format_helper, 806);
        hint(mp_obj_str_format_helper, this::mp_obj_str_format_helper, 946);
        hint(mp_obj_str_format_helper, this::mp_obj_str_format_helper, 978);
        hint(mp_obj_str_format_helper, this::mp_obj_str_format_helper, 990);
        hint(mp_obj_str_format_helper, this::mp_obj_str_format_helper, 1032);
        hint(mp_obj_str_format_helper, this::mp_obj_str_format_helper, 1048);
        hint(mp_obj_str_format_helper, this::mp_obj_str_format_helper, 1080);
        hint(mp_obj_str_format_helper, this::mp_obj_str_format_helper, 1086);
        hint(mp_obj_str_format_helper, this::mp_obj_str_format_helper, 1144);
        hint(mp_obj_str_format_helper, this::mp_obj_str_format_helper, 1164);
        hint(mp_obj_str_format_helper, this::mp_obj_str_format_helper, 1228);
        hint(mp_obj_str_format_helper, this::mp_obj_str_format_helper, 1250);
        hint(mp_obj_str_format_helper, this::mp_obj_str_format_helper, 1284);
        hint(mp_obj_str_format, this::mp_obj_str_format, 0);
        hint(mp_obj_str_format, this::mp_obj_str_format, 28);
        hint(mp_obj_str_format, this::mp_obj_str_format, 52);
        hint(mp_obj_str_format, this::mp_obj_str_format, 60);
        hint(mp_obj_str_intern_checked, this::mp_obj_str_intern_checked, 0);
        hint(mp_obj_str_intern_checked, this::mp_obj_str_intern_checked, 8);
        hint(mp_obj_str_intern_checked, this::mp_obj_str_intern_checked, 14);
        hint(mp_obj_new_str_iterator, this::mp_obj_new_str_iterator, 0);
        hint(str_it_iternext, this::str_it_iternext, 0);
        hint(str_it_iternext, this::str_it_iternext, 22);
        hint(str_it_iternext, this::str_it_iternext, 42);
        hint(str_it_iternext, this::str_it_iternext, 52);
        hint(uni_unary_op, this::uni_unary_op, 0);
        hint(uni_unary_op, this::uni_unary_op, 20);
        hint(uni_unary_op, this::uni_unary_op, 58);
        hint(uni_print, this::uni_print, 0);
        hint(uni_print, this::uni_print, 24);
        hint(uni_print, this::uni_print, 40);
        hint(uni_print, this::uni_print, 66);
        hint(uni_print, this::uni_print, 134);
        hint(uni_print, this::uni_print, 142);
        hint(uni_print, this::uni_print, 158);
        hint(uni_print, this::uni_print, 202);
        hint(uni_print, this::uni_print, 218);
        hint(str_index_to_ptr, this::str_index_to_ptr, 0);
        hint(str_index_to_ptr, this::str_index_to_ptr, 28);
        hint(str_index_to_ptr, this::str_index_to_ptr, 80);
        hint(str_index_to_ptr, this::str_index_to_ptr, 88);
        hint(str_index_to_ptr, this::str_index_to_ptr, 98);
        hint(str_index_to_ptr, this::str_index_to_ptr, 108);
        hint(str_index_to_ptr, this::str_index_to_ptr, 112);
        hint(str_subscr, this::str_subscr, 0);
        hint(str_subscr, this::str_subscr, 14);
        hint(str_subscr, this::str_subscr, 32);
        hint(str_subscr, this::str_subscr, 62);
        hint(str_subscr, this::str_subscr, 80);
        hint(str_subscr, this::str_subscr, 110);
        hint(str_subscr, this::str_subscr, 134);
        hint(str_subscr, this::str_subscr, 152);
        hint(str_subscr, this::str_subscr, 172);
        hint(str_subscr, this::str_subscr, 200);
        hint(stringio___exit__, this::stringio___exit__, 0);
        hint(stringio___exit__, this::stringio___exit__, 8);
        hint(stringio_print, this::stringio_print, 0);
        hint(stringio_print, this::stringio_print, 22);
        hint(stringio_write, this::stringio_write, 0);
        hint(stringio_write, this::stringio_write, 24);
        hint(stringio_write, this::stringio_write, 42);
        hint(stringio_write, this::stringio_write, 56);
        hint(stringio_write, this::stringio_write, 110);
    }

    private void gen_hints_8() {
        hint(stringio_write, this::stringio_write, 130);
        hint(stringio_write, this::stringio_write, 146);
        hint(stringio_make_new, this::stringio_make_new, 0);
        hint(stringio_make_new, this::stringio_make_new, 16);
        hint(stringio_make_new, this::stringio_make_new, 52);
        hint(stringio_make_new, this::stringio_make_new, 58);
        hint(stringio_make_new, this::stringio_make_new, 76);
        hint(stringio_make_new, this::stringio_make_new, 90);
        hint(stringio_make_new, this::stringio_make_new, 120);
        hint(stringio_make_new, this::stringio_make_new, 130);
        hint(stringio_ioctl, this::stringio_ioctl, 0);
        hint(stringio_ioctl, this::stringio_ioctl, 88);
        hint(stringio_getvalue, this::stringio_getvalue, 0);
        hint(stringio_getvalue, this::stringio_getvalue, 14);
        hint(stringio_getvalue, this::stringio_getvalue, 34);
        hint(stringio_read, this::stringio_read, 0);
        hint(stringio_read, this::stringio_read, 18);
        hint(stringio_read, this::stringio_read, 46);
        hint(tuple_it_iternext, this::tuple_it_iternext, 0);
        hint(mp_obj_tuple_getiter, this::mp_obj_tuple_getiter, 0);
        hint(mp_obj_tuple_print, this::mp_obj_tuple_print, 0);
        hint(mp_obj_tuple_print, this::mp_obj_tuple_print, 18);
        hint(mp_obj_tuple_print, this::mp_obj_tuple_print, 44);
        hint(mp_obj_tuple_print, this::mp_obj_tuple_print, 52);
        hint(mp_obj_tuple_print, this::mp_obj_tuple_print, 60);
        hint(mp_obj_tuple_print, this::mp_obj_tuple_print, 76);
        hint(mp_obj_tuple_print, this::mp_obj_tuple_print, 90);
        hint(tuple_index, this::tuple_index, 0);
        hint(tuple_index, this::tuple_index, 18);
        hint(tuple_count, this::tuple_count, 0);
        hint(tuple_count, this::tuple_count, 14);
        hint(mp_obj_tuple_unary_op, this::mp_obj_tuple_unary_op, 0);
        hint(mp_obj_tuple_unary_op, this::mp_obj_tuple_unary_op, 58);
        hint(mp_obj_new_tuple, this::mp_obj_new_tuple, 0);
        hint(mp_obj_new_tuple, this::mp_obj_new_tuple, 22);
        hint(mp_obj_tuple_binary_op, this::mp_obj_tuple_binary_op, 0);
        hint(mp_obj_tuple_binary_op, this::mp_obj_tuple_binary_op, 44);
        hint(mp_obj_tuple_binary_op, this::mp_obj_tuple_binary_op, 50);
        hint(mp_obj_tuple_binary_op, this::mp_obj_tuple_binary_op, 66);
        hint(mp_obj_tuple_binary_op, this::mp_obj_tuple_binary_op, 86);
        hint(mp_obj_tuple_binary_op, this::mp_obj_tuple_binary_op, 104);
        hint(mp_obj_tuple_binary_op, this::mp_obj_tuple_binary_op, 118);
        hint(mp_obj_tuple_binary_op, this::mp_obj_tuple_binary_op, 142);
        hint(mp_obj_tuple_binary_op, this::mp_obj_tuple_binary_op, 164);
        hint(mp_obj_tuple_binary_op, this::mp_obj_tuple_binary_op, 172);
        hint(mp_obj_tuple_binary_op, this::mp_obj_tuple_binary_op, 188);
        hint(mp_obj_tuple_binary_op, this::mp_obj_tuple_binary_op, 220);
        hint(mp_obj_tuple_subscr, this::mp_obj_tuple_subscr, 0);
        hint(mp_obj_tuple_subscr, this::mp_obj_tuple_subscr, 32);
        hint(mp_obj_tuple_subscr, this::mp_obj_tuple_subscr, 42);
        hint(mp_obj_tuple_subscr, this::mp_obj_tuple_subscr, 54);
        hint(mp_obj_tuple_subscr, this::mp_obj_tuple_subscr, 76);
        hint(mp_obj_tuple_subscr, this::mp_obj_tuple_subscr, 94);
        hint(mp_obj_tuple_make_new, this::mp_obj_tuple_make_new, 0);
        hint(mp_obj_tuple_make_new, this::mp_obj_tuple_make_new, 22);
        hint(mp_obj_tuple_make_new, this::mp_obj_tuple_make_new, 48);
        hint(mp_obj_tuple_make_new, this::mp_obj_tuple_make_new, 58);
        hint(mp_obj_tuple_make_new, this::mp_obj_tuple_make_new, 70);
        hint(mp_obj_tuple_make_new, this::mp_obj_tuple_make_new, 86);
        hint(mp_obj_tuple_make_new, this::mp_obj_tuple_make_new, 96);
        hint(mp_obj_tuple_make_new, this::mp_obj_tuple_make_new, 116);
        hint(mp_obj_tuple_get, this::mp_obj_tuple_get, 0);
        hint(mp_obj_tuple_del, this::mp_obj_tuple_del, 0);
        hint(mp_obj_tuple_del, this::mp_obj_tuple_del, 12);
        hint(instance_count_native_bases, this::instance_count_native_bases, 0);
        hint(instance_count_native_bases, this::instance_count_native_bases, 64);
        hint(native_base_init_wrapper, this::native_base_init_wrapper, 0);
        hint(native_base_init_wrapper, this::native_base_init_wrapper, 20);
        hint(native_base_init_wrapper, this::native_base_init_wrapper, 32);
        hint(mp_obj_class_lookup, this::mp_obj_class_lookup, 0);
        hint(mp_obj_class_lookup, this::mp_obj_class_lookup, 56);
        hint(mp_obj_class_lookup, this::mp_obj_class_lookup, 80);
        hint(mp_obj_class_lookup, this::mp_obj_class_lookup, 188);
        hint(mp_obj_class_lookup, this::mp_obj_class_lookup, 214);
        hint(super_attr, this::super_attr, 0);
        hint(super_attr, this::super_attr, 86);
        hint(super_attr, this::super_attr, 110);
        hint(super_attr, this::super_attr, 144);
        hint(static_class_method_make_new, this::static_class_method_make_new, 0);
        hint(static_class_method_make_new, this::static_class_method_make_new, 22);
        hint(static_class_method_make_new, this::static_class_method_make_new, 28);
        hint(super_make_new, this::super_make_new, 0);
        hint(super_make_new, this::super_make_new, 22);
        hint(super_make_new, this::super_make_new, 42);
        hint(super_make_new, this::super_make_new, 48);
        hint(type_print, this::type_print, 0);
        hint(type_print, this::type_print, 10);
        hint(instance_subscr, this::instance_subscr, 0);
        hint(instance_subscr, this::instance_subscr, 20);
        hint(instance_subscr, this::instance_subscr, 30);
        hint(instance_subscr, this::instance_subscr, 62);
        hint(instance_subscr, this::instance_subscr, 80);
        hint(instance_subscr, this::instance_subscr, 94);
        hint(instance_subscr, this::instance_subscr, 116);
        hint(instance_binary_op, this::instance_binary_op, 0);
        hint(instance_binary_op, this::instance_binary_op, 24);
        hint(instance_binary_op, this::instance_binary_op, 48);
        hint(instance_binary_op, this::instance_binary_op, 64);
        hint(instance_binary_op, this::instance_binary_op, 92);
        hint(instance_unary_op, this::instance_unary_op, 0);
        hint(instance_unary_op, this::instance_unary_op, 20);
        hint(instance_unary_op, this::instance_unary_op, 26);
        hint(instance_unary_op, this::instance_unary_op, 60);
        hint(instance_unary_op, this::instance_unary_op, 84);
        hint(instance_unary_op, this::instance_unary_op, 98);
        hint(instance_unary_op, this::instance_unary_op, 112);
        hint(instance_unary_op, this::instance_unary_op, 120);
        hint(instance_unary_op, this::instance_unary_op, 144);
        hint(instance_print, this::instance_print, 0);
        hint(instance_print, this::instance_print, 30);
        hint(instance_print, this::instance_print, 58);
        hint(instance_print, this::instance_print, 82);
        hint(instance_print, this::instance_print, 94);
        hint(instance_print, this::instance_print, 114);
        hint(instance_print, this::instance_print, 122);
        hint(instance_print, this::instance_print, 134);
        hint(instance_print, this::instance_print, 152);
        hint(instance_print, this::instance_print, 164);
        hint(instance_print, this::instance_print, 176);
        hint(super_print, this::super_print, 0);
        hint(super_print, this::super_print, 12);
        hint(super_print, this::super_print, 22);
        hint(super_print, this::super_print, 30);
        hint(super_print, this::super_print, 40);
        hint(super_print, this::super_print, 48);
        hint(mp_obj_instance_attr, this::mp_obj_instance_attr, 0);
        hint(mp_obj_instance_attr, this::mp_obj_instance_attr, 34);
        hint(mp_obj_instance_attr, this::mp_obj_instance_attr, 56);
        hint(mp_obj_instance_attr, this::mp_obj_instance_attr, 94);
        hint(mp_obj_instance_attr, this::mp_obj_instance_attr, 116);
        hint(mp_obj_instance_attr, this::mp_obj_instance_attr, 152);
        hint(mp_obj_instance_attr, this::mp_obj_instance_attr, 168);
        hint(mp_obj_instance_attr, this::mp_obj_instance_attr, 178);
        hint(mp_obj_instance_attr, this::mp_obj_instance_attr, 192);
        hint(mp_obj_instance_attr, this::mp_obj_instance_attr, 208);
        hint(mp_obj_instance_attr, this::mp_obj_instance_attr, 220);
        hint(mp_obj_instance_attr, this::mp_obj_instance_attr, 244);
        hint(mp_obj_instance_attr, this::mp_obj_instance_attr, 286);
        hint(mp_obj_instance_attr, this::mp_obj_instance_attr, 308);
        hint(mp_obj_instance_attr, this::mp_obj_instance_attr, 334);
        hint(mp_obj_instance_attr, this::mp_obj_instance_attr, 362);
        hint(mp_obj_instance_attr, this::mp_obj_instance_attr, 394);
        hint(mp_obj_instance_attr, this::mp_obj_instance_attr, 416);
        hint(mp_obj_instance_attr, this::mp_obj_instance_attr, 436);
        hint(mp_obj_instance_attr, this::mp_obj_instance_attr, 452);
        hint(mp_obj_instance_attr, this::mp_obj_instance_attr, 478);
        hint(mp_obj_instance_attr, this::mp_obj_instance_attr, 516);
        hint(mp_obj_instance_attr, this::mp_obj_instance_attr, 538);
        hint(type_call, this::type_call, 0);
        hint(type_call, this::type_call, 18);
        hint(type_call, this::type_call, 22);
        hint(type_call, this::type_call, 24);
        hint(instance_get_buffer, this::instance_get_buffer, 0);
        hint(instance_get_buffer, this::instance_get_buffer, 22);
        hint(instance_get_buffer, this::instance_get_buffer, 46);
        hint(instance_get_buffer, this::instance_get_buffer, 60);
        hint(instance_get_buffer, this::instance_get_buffer, 70);
        hint(instance_getiter, this::instance_getiter, 0);
        hint(instance_getiter, this::instance_getiter, 20);
        hint(instance_getiter, this::instance_getiter, 44);
        hint(instance_getiter, this::instance_getiter, 62);
        hint(instance_getiter, this::instance_getiter, 70);
        hint(instance_getiter, this::instance_getiter, 84);
        hint(check_for_special_accessors, this::check_for_special_accessors, 0);
        hint(check_for_special_accessors, this::check_for_special_accessors, 42);
        hint(type_attr, this::type_attr, 0);
        hint(type_attr, this::type_attr, 50);
        hint(type_attr, this::type_attr, 94);
        hint(type_attr, this::type_attr, 116);
        hint(type_attr, this::type_attr, 134);
        hint(type_attr, this::type_attr, 148);
        hint(mp_obj_instance_call, this::mp_obj_instance_call, 0);
        hint(mp_obj_instance_call, this::mp_obj_instance_call, 42);
        hint(mp_obj_instance_call, this::mp_obj_instance_call, 54);
        hint(mp_obj_instance_call, this::mp_obj_instance_call, 64);
        hint(mp_obj_instance_call, this::mp_obj_instance_call, 68);
        hint(mp_obj_instance_call, this::mp_obj_instance_call, 84);
        hint(mp_obj_instance_call, this::mp_obj_instance_call, 100);
        hint(mp_obj_new_instance, this::mp_obj_new_instance, 0);
        hint(mp_obj_new_instance, this::mp_obj_new_instance, 8);
        hint(mp_obj_new_instance, this::mp_obj_new_instance, 18);
        hint(mp_obj_new_instance, this::mp_obj_new_instance, 28);
        hint(mp_obj_instance_make_new, this::mp_obj_instance_make_new, 0);
        hint(mp_obj_instance_make_new, this::mp_obj_instance_make_new, 24);
        hint(mp_obj_instance_make_new, this::mp_obj_instance_make_new, 48);
        hint(mp_obj_instance_make_new, this::mp_obj_instance_make_new, 68);
        hint(mp_obj_instance_make_new, this::mp_obj_instance_make_new, 92);
        hint(mp_obj_instance_make_new, this::mp_obj_instance_make_new, 114);
        hint(mp_obj_instance_make_new, this::mp_obj_instance_make_new, 128);
        hint(mp_obj_instance_make_new, this::mp_obj_instance_make_new, 138);
        hint(mp_obj_instance_make_new, this::mp_obj_instance_make_new, 142);
        hint(mp_obj_instance_make_new, this::mp_obj_instance_make_new, 160);
        hint(mp_obj_instance_make_new, this::mp_obj_instance_make_new, 168);
        hint(mp_obj_instance_make_new, this::mp_obj_instance_make_new, 198);
        hint(mp_obj_instance_make_new, this::mp_obj_instance_make_new, 212);
        hint(mp_obj_instance_make_new, this::mp_obj_instance_make_new, 226);
        hint(mp_obj_instance_make_new, this::mp_obj_instance_make_new, 236);
        hint(mp_obj_instance_make_new, this::mp_obj_instance_make_new, 256);
        hint(mp_obj_instance_make_new, this::mp_obj_instance_make_new, 280);
        hint(mp_obj_instance_make_new, this::mp_obj_instance_make_new, 290);
        hint(mp_obj_instance_make_new, this::mp_obj_instance_make_new, 300);
        hint(mp_obj_instance_make_new, this::mp_obj_instance_make_new, 326);
        hint(mp_obj_instance_is_callable, this::mp_obj_instance_is_callable, 0);
        hint(mp_obj_instance_is_callable, this::mp_obj_instance_is_callable, 36);
        hint(mp_obj_new_type, this::mp_obj_new_type, 0);
        hint(mp_obj_new_type, this::mp_obj_new_type, 22);
        hint(mp_obj_new_type, this::mp_obj_new_type, 54);
        hint(mp_obj_new_type, this::mp_obj_new_type, 80);
        hint(mp_obj_new_type, this::mp_obj_new_type, 162);
        hint(mp_obj_new_type, this::mp_obj_new_type, 206);
        hint(mp_obj_new_type, this::mp_obj_new_type, 210);
        hint(mp_obj_new_type, this::mp_obj_new_type, 272);
        hint(mp_obj_new_type, this::mp_obj_new_type, 298);
        hint(mp_obj_new_type, this::mp_obj_new_type, 332);
        hint(type_make_new, this::type_make_new, 0);
        hint(type_make_new, this::type_make_new, 22);
        hint(type_make_new, this::type_make_new, 36);
        hint(type_make_new, this::type_make_new, 42);
        hint(type_make_new, this::type_make_new, 50);
        hint(type_make_new, this::type_make_new, 58);
        hint(mp_load_super_method, this::mp_load_super_method, 0);
        hint(mp_load_super_method, this::mp_load_super_method, 24);
        hint(mp_obj_is_subclass_fast, this::mp_obj_is_subclass_fast, 0);
        hint(mp_obj_is_subclass_fast, this::mp_obj_is_subclass_fast, 64);
        hint(mp_obj_is_subclass, this::mp_obj_is_subclass, 0);
        hint(mp_obj_is_subclass, this::mp_obj_is_subclass, 60);
        hint(mp_obj_is_subclass, this::mp_obj_is_subclass, 68);
        hint(mp_obj_is_subclass, this::mp_obj_is_subclass, 84);
        hint(mp_builtin_issubclass, this::mp_builtin_issubclass, 0);
        hint(mp_builtin_issubclass, this::mp_builtin_issubclass, 20);
        hint(mp_builtin_issubclass, this::mp_builtin_issubclass, 24);
        hint(mp_builtin_isinstance, this::mp_builtin_isinstance, 0);
        hint(mp_builtin_isinstance, this::mp_builtin_isinstance, 8);
        hint(mp_builtin_isinstance, this::mp_builtin_isinstance, 14);
        hint(mp_instance_cast_to_native_base, this::mp_instance_cast_to_native_base, 0);
        hint(mp_instance_cast_to_native_base, this::mp_instance_cast_to_native_base, 10);
        hint(mp_instance_cast_to_native_base, this::mp_instance_cast_to_native_base, 16);
        hint(zip_iternext, this::zip_iternext, 0);
        hint(zip_iternext, this::zip_iternext, 16);
        hint(zip_iternext, this::zip_iternext, 38);
        hint(zip_iternext, this::zip_iternext, 48);
        hint(zip_make_new, this::zip_make_new, 0);
        hint(zip_make_new, this::zip_make_new, 28);
        hint(zip_make_new, this::zip_make_new, 34);
        hint(zip_make_new, this::zip_make_new, 68);
        hint(op_getitem, this::op_getitem, 0);
        hint(op_getitem, this::op_getitem, 10);
        hint(op_getitem, this::op_getitem, 20);
        hint(op_setitem, this::op_setitem, 0);
        hint(op_setitem, this::op_setitem, 12);
        hint(op_setitem, this::op_setitem, 22);
        hint(op_delitem, this::op_delitem, 0);
        hint(op_delitem, this::op_delitem, 10);
        hint(op_delitem, this::op_delitem, 20);
        hint(op_contains, this::op_contains, 0);
        hint(op_contains, this::op_contains, 10);
        hint(op_contains, this::op_contains, 20);
        hint(mp_seq_multiply, this::mp_seq_multiply, 0);
        hint(mp_seq_multiply, this::mp_seq_multiply, 28);
        hint(mp_seq_get_fast_slice_indexes, this::mp_seq_get_fast_slice_indexes, 0);
        hint(mp_seq_get_fast_slice_indexes, this::mp_seq_get_fast_slice_indexes, 20);
        hint(mp_seq_get_fast_slice_indexes, this::mp_seq_get_fast_slice_indexes, 36);
        hint(mp_seq_get_fast_slice_indexes, this::mp_seq_get_fast_slice_indexes, 48);
        hint(mp_seq_get_fast_slice_indexes, this::mp_seq_get_fast_slice_indexes, 146);
        hint(mp_seq_get_fast_slice_indexes, this::mp_seq_get_fast_slice_indexes, 154);
        hint(mp_seq_extract_slice, this::mp_seq_extract_slice, 0);
        hint(mp_seq_extract_slice, this::mp_seq_extract_slice, 20);
        hint(mp_seq_extract_slice, this::mp_seq_extract_slice, 46);
        hint(mp_seq_extract_slice, this::mp_seq_extract_slice, 60);
        hint(mp_seq_cmp_bytes, this::mp_seq_cmp_bytes, 0);
        hint(mp_seq_cmp_bytes, this::mp_seq_cmp_bytes, 38);
        hint(mp_seq_cmp_objs, this::mp_seq_cmp_objs, 0);
        hint(mp_seq_cmp_objs, this::mp_seq_cmp_objs, 102);
        hint(mp_seq_cmp_objs, this::mp_seq_cmp_objs, 130);
        hint(mp_seq_index_obj, this::mp_seq_index_obj, 0);
        hint(mp_seq_index_obj, this::mp_seq_index_obj, 18);
        hint(mp_seq_index_obj, this::mp_seq_index_obj, 40);
        hint(mp_seq_index_obj, this::mp_seq_index_obj, 58);
        hint(mp_seq_index_obj, this::mp_seq_index_obj, 70);
        hint(mp_seq_index_obj, this::mp_seq_index_obj, 82);
        hint(mp_seq_count_obj, this::mp_seq_count_obj, 0);
        hint(mp_seq_count_obj, this::mp_seq_count_obj, 32);
        hint(mp_stream_close, this::mp_stream_close, 0);
        hint(mp_stream_close, this::mp_stream_close, 16);
        hint(mp_stream_close, this::mp_stream_close, 26);
        hint(stream_flush, this::stream_flush, 0);
        hint(stream_flush, this::stream_flush, 16);
        hint(stream_flush, this::stream_flush, 26);
        hint(stream_unbuffered_readline, this::stream_unbuffered_readline, 0);
        hint(stream_unbuffered_readline, this::stream_unbuffered_readline, 32);
        hint(stream_unbuffered_readline, this::stream_unbuffered_readline, 52);
        hint(stream_unbuffered_readline, this::stream_unbuffered_readline, 66);
        hint(stream_unbuffered_readline, this::stream_unbuffered_readline, 76);
        hint(stream_unbuffered_readline, this::stream_unbuffered_readline, 86);
        hint(stream_unbuffered_readline, this::stream_unbuffered_readline, 102);
        hint(stream_unbuffered_readline, this::stream_unbuffered_readline, 118);
        hint(stream_unbuffered_readlines, this::stream_unbuffered_readlines, 0);
        hint(stream_unbuffered_readlines, this::stream_unbuffered_readlines, 12);
        hint(stream_unbuffered_readlines, this::stream_unbuffered_readlines, 22);
        hint(stream_unbuffered_readlines, this::stream_unbuffered_readlines, 28);
        hint(stream_unbuffered_readlines, this::stream_unbuffered_readlines, 40);
        hint(stream_seek, this::stream_seek, 0);
        hint(stream_seek, this::stream_seek, 14);
        hint(stream_seek, this::stream_seek, 30);
        hint(stream_seek, this::stream_seek, 64);
        hint(stream_seek, this::stream_seek, 74);
        hint(stream_seek, this::stream_seek, 80);
        hint(stream_tell, this::stream_tell, 0);
        hint(stream_tell, this::stream_tell, 18);
        hint(mp_stream_rw, this::mp_stream_rw, 0);
        hint(mp_stream_rw, this::mp_stream_rw, 62);
        hint(stream_read_generic, this::stream_read_generic, 0);
        hint(stream_read_generic, this::stream_read_generic, 32);
        hint(stream_read_generic, this::stream_read_generic, 52);
        hint(stream_read_generic, this::stream_read_generic, 62);
        hint(stream_read_generic, this::stream_read_generic, 68);
        hint(stream_read_generic, this::stream_read_generic, 104);
        hint(stream_read_generic, this::stream_read_generic, 118);
        hint(stream_read_generic, this::stream_read_generic, 134);
        hint(stream_read_generic, this::stream_read_generic, 150);
        hint(stream_read_generic, this::stream_read_generic, 182);
        hint(stream_read_generic, this::stream_read_generic, 296);
        hint(stream_read_generic, this::stream_read_generic, 308);
        hint(stream_read_generic, this::stream_read_generic, 332);
        hint(stream_read_generic, this::stream_read_generic, 348);
        hint(stream_read_generic, this::stream_read_generic, 360);
        hint(stream_read, this::stream_read, 0);
        hint(stream_read, this::stream_read, 8);
        hint(stream_readinto, this::stream_readinto, 0);
        hint(stream_readinto, this::stream_readinto, 18);
        hint(stream_readinto, this::stream_readinto, 30);
        hint(stream_readinto, this::stream_readinto, 52);
        hint(stream_readinto, this::stream_readinto, 64);
        hint(mp_get_stream_raise, this::mp_get_stream_raise, 0);
        hint(mp_get_stream_raise, this::mp_get_stream_raise, 8);
        hint(mp_get_stream_raise, this::mp_get_stream_raise, 52);
        hint(mp_stream_write, this::mp_stream_write, 0);
        hint(mp_stream_write, this::mp_stream_write, 10);
        hint(mp_stream_write, this::mp_stream_write, 22);
        hint(stream_write_method, this::stream_write_method, 0);
        hint(stream_write_method, this::stream_write_method, 18);
        hint(stream_write_method, this::stream_write_method, 28);
        hint(stream_write_method, this::stream_write_method, 56);
        hint(stream_write_method, this::stream_write_method, 70);
        hint(stream_write_method, this::stream_write_method, 78);
        hint(mp_stream_write_adaptor, this::mp_stream_write_adaptor, 0);
        hint(mp_stream_write_adaptor, this::mp_stream_write_adaptor, 8);
        hint(mp_stream_unbuffered_iter, this::mp_stream_unbuffered_iter, 0);
        hint(mp_stream_unbuffered_iter, this::mp_stream_unbuffered_iter, 12);
        hint(mp_stream_unbuffered_iter, this::mp_stream_unbuffered_iter, 18);
        hint(mp_binary_get_size, this::mp_binary_get_size, 0);
        hint(mp_binary_get_size, this::mp_binary_get_size, 60);
        hint(mp_binary_get_val_array, this::mp_binary_get_val_array, 0);
        hint(mp_binary_get_val_array, this::mp_binary_get_val_array, 92);
        hint(mp_binary_get_val_array, this::mp_binary_get_val_array, 114);
        hint(mp_binary_get_val_array, this::mp_binary_get_val_array, 128);
        hint(mp_binary_get_val_array, this::mp_binary_get_val_array, 142);
        hint(mp_binary_get_val_array, this::mp_binary_get_val_array, 152);
        hint(mp_binary_get_val_array, this::mp_binary_get_val_array, 166);
        hint(mp_binary_get_int, this::mp_binary_get_int, 0);
        hint(mp_binary_get_val, this::mp_binary_get_val, 0);
        hint(mp_binary_get_val, this::mp_binary_get_val, 16);
        hint(mp_binary_get_val, this::mp_binary_get_val, 58);
        hint(mp_binary_get_val, this::mp_binary_get_val, 74);
        hint(mp_binary_get_val, this::mp_binary_get_val, 82);
        hint(mp_binary_get_val, this::mp_binary_get_val, 96);
        hint(mp_binary_get_val, this::mp_binary_get_val, 100);
        hint(mp_binary_get_val, this::mp_binary_get_val, 128);
        hint(mp_binary_get_val, this::mp_binary_get_val, 136);
        hint(mp_binary_get_val, this::mp_binary_get_val, 152);
        hint(mp_binary_get_val, this::mp_binary_get_val, 160);
        hint(mp_binary_set_int, this::mp_binary_set_int, 0);
        hint(mp_binary_set_int, this::mp_binary_set_int, 24);
        hint(mp_binary_set_val, this::mp_binary_set_val, 0);
        hint(mp_binary_set_val, this::mp_binary_set_val, 20);
        hint(mp_binary_set_val, this::mp_binary_set_val, 92);
        hint(mp_binary_set_val, this::mp_binary_set_val, 100);
        hint(mp_binary_set_val, this::mp_binary_set_val, 110);
        hint(mp_binary_set_val, this::mp_binary_set_val, 114);
        hint(mp_binary_set_val, this::mp_binary_set_val, 140);
        hint(mp_binary_set_val, this::mp_binary_set_val, 184);
        hint(mp_binary_set_val, this::mp_binary_set_val, 194);
        hint(mp_binary_set_val, this::mp_binary_set_val, 220);
        hint(mp_binary_set_val_array_from_int, this::mp_binary_set_val_array_from_int, 0);
        hint(mp_binary_set_val_array_from_int, this::mp_binary_set_val_array_from_int, 106);
        hint(mp_binary_set_val_array_from_int, this::mp_binary_set_val_array_from_int, 120);
        hint(mp_binary_set_val_array, this::mp_binary_set_val_array, 0);
        hint(mp_binary_set_val_array, this::mp_binary_set_val_array, 38);
        hint(mp_binary_set_val_array, this::mp_binary_set_val_array, 48);
        hint(mp_binary_set_val_array, this::mp_binary_set_val_array, 52);
        hint(mp_binary_set_val_array, this::mp_binary_set_val_array, 88);
        hint(mp_binary_set_val_array, this::mp_binary_set_val_array, 104);
        hint(mp_binary_set_val_array, this::mp_binary_set_val_array, 112);
        hint(mp_binary_set_val_array, this::mp_binary_set_val_array, 124);
        hint(mp_import_stat_any, this::mp_import_stat_any, 0);
        hint(mp_import_stat_any, this::mp_import_stat_any, 8);
        hint(mp_import_stat_any, this::mp_import_stat_any, 18);
        hint(do_execute_raw_code, this::do_execute_raw_code, 0);
        hint(do_execute_raw_code, this::do_execute_raw_code, 28);
        hint(do_execute_raw_code, this::do_execute_raw_code, 40);
        hint(do_execute_raw_code, this::do_execute_raw_code, 44);
        hint(do_execute_raw_code, this::do_execute_raw_code, 48);
        hint(do_execute_raw_code, this::do_execute_raw_code, 74);
        hint(do_load_from_lexer, this::do_load_from_lexer, 0);
        hint(do_load_from_lexer, this::do_load_from_lexer, 20);
        hint(do_load_from_lexer, this::do_load_from_lexer, 32);
        hint(text_do_load, this::text_do_load, 0);
        hint(text_do_load, this::text_do_load, 12);
        hint(text_do_load, this::text_do_load, 22);
        hint(text_do_load, this::text_do_load, 52);
        hint(text_do_load, this::text_do_load, 60);
        hint(text_do_load, this::text_do_load, 66);
        hint(text_do_load, this::text_do_load, 74);
        hint(stat_file_py_or_mpy, this::stat_file_py_or_mpy, 0);
        hint(stat_file_py_or_mpy, this::stat_file_py_or_mpy, 8);
        hint(stat_file_py_or_mpy, this::stat_file_py_or_mpy, 12);
        hint(stat_file_py_or_mpy, this::stat_file_py_or_mpy, 28);
        hint(stat_file_py_or_mpy, this::stat_file_py_or_mpy, 34);
        hint(stat_file_py_or_mpy, this::stat_file_py_or_mpy, 38);
        hint(stat_dir_or_file, this::stat_dir_or_file, 0);
        hint(stat_dir_or_file, this::stat_dir_or_file, 8);
        hint(stat_dir_or_file, this::stat_dir_or_file, 12);
        hint(stat_dir_or_file, this::stat_dir_or_file, 24);
        hint(stat_dir_or_file, this::stat_dir_or_file, 30);
        hint(mp_builtin___import__, this::mp_builtin___import__, 0);
        hint(mp_builtin___import__, this::mp_builtin___import__, 36);
        hint(mp_builtin___import__, this::mp_builtin___import__, 52);
        hint(mp_builtin___import__, this::mp_builtin___import__, 70);
        hint(mp_builtin___import__, this::mp_builtin___import__, 84);
        hint(mp_builtin___import__, this::mp_builtin___import__, 94);
        hint(mp_builtin___import__, this::mp_builtin___import__, 130);
        hint(mp_builtin___import__, this::mp_builtin___import__, 178);
        hint(mp_builtin___import__, this::mp_builtin___import__, 188);
        hint(mp_builtin___import__, this::mp_builtin___import__, 210);
        hint(mp_builtin___import__, this::mp_builtin___import__, 218);
        hint(mp_builtin___import__, this::mp_builtin___import__, 230);
        hint(mp_builtin___import__, this::mp_builtin___import__, 242);
        hint(mp_builtin___import__, this::mp_builtin___import__, 246);
        hint(mp_builtin___import__, this::mp_builtin___import__, 258);
        hint(mp_builtin___import__, this::mp_builtin___import__, 280);
        hint(mp_builtin___import__, this::mp_builtin___import__, 284);
        hint(mp_builtin___import__, this::mp_builtin___import__, 310);
        hint(mp_builtin___import__, this::mp_builtin___import__, 354);
        hint(mp_builtin___import__, this::mp_builtin___import__, 372);
        hint(mp_builtin___import__, this::mp_builtin___import__, 388);
        hint(mp_builtin___import__, this::mp_builtin___import__, 394);
        hint(mp_builtin___import__, this::mp_builtin___import__, 404);
        hint(mp_builtin___import__, this::mp_builtin___import__, 422);
        hint(mp_builtin___import__, this::mp_builtin___import__, 436);
        hint(mp_builtin___import__, this::mp_builtin___import__, 444);
        hint(mp_builtin___import__, this::mp_builtin___import__, 454);
        hint(mp_builtin___import__, this::mp_builtin___import__, 460);
        hint(mp_builtin___import__, this::mp_builtin___import__, 496);
        hint(mp_builtin___import__, this::mp_builtin___import__, 510);
        hint(mp_builtin___import__, this::mp_builtin___import__, 520);
        hint(mp_builtin___import__, this::mp_builtin___import__, 550);
        hint(mp_builtin___import__, this::mp_builtin___import__, 560);
        hint(mp_builtin___import__, this::mp_builtin___import__, 576);
        hint(mp_builtin___import__, this::mp_builtin___import__, 584);
        hint(mp_builtin___import__, this::mp_builtin___import__, 594);
        hint(mp_builtin___import__, this::mp_builtin___import__, 616);
        hint(mp_builtin___import__, this::mp_builtin___import__, 620);
        hint(mp_builtin___import__, this::mp_builtin___import__, 632);
        hint(mp_builtin___import__, this::mp_builtin___import__, 642);
        hint(mp_builtin___import__, this::mp_builtin___import__, 652);
        hint(mp_builtin___import__, this::mp_builtin___import__, 660);
        hint(mp_builtin___import__, this::mp_builtin___import__, 666);
        hint(mp_builtin___import__, this::mp_builtin___import__, 678);
        hint(mp_builtin___import__, this::mp_builtin___import__, 702);
        hint(mp_builtin___import__, this::mp_builtin___import__, 712);
        hint(mp_obj_is_package, this::mp_obj_is_package, 0);
        hint(mp_obj_is_package, this::mp_obj_is_package, 10);
        hint(mp_builtin_compile, this::mp_builtin_compile, 0);
        hint(mp_builtin_compile, this::mp_builtin_compile, 12);
        hint(mp_builtin_compile, this::mp_builtin_compile, 20);
        hint(mp_builtin_compile, this::mp_builtin_compile, 30);
        hint(mp_builtin_compile, this::mp_builtin_compile, 38);
        hint(mp_builtin_compile, this::mp_builtin_compile, 72);
        hint(mp_builtin_compile, this::mp_builtin_compile, 90);
        hint(mp_builtin_compile, this::mp_builtin_compile, 102);
        hint(eval_exec_helper, this::eval_exec_helper, 0);
        hint(eval_exec_helper, this::eval_exec_helper, 48);
        hint(eval_exec_helper, this::eval_exec_helper, 120);
        hint(eval_exec_helper, this::eval_exec_helper, 130);
        hint(eval_exec_helper, this::eval_exec_helper, 136);
        hint(eval_exec_helper, this::eval_exec_helper, 170);
        hint(eval_exec_helper, this::eval_exec_helper, 178);
        hint(eval_exec_helper, this::eval_exec_helper, 188);
        hint(eval_exec_helper, this::eval_exec_helper, 202);
        hint(eval_exec_helper, this::eval_exec_helper, 218);
        hint(mp_builtin_eval, this::mp_builtin_eval, 0);
        hint(mp_builtin_eval, this::mp_builtin_eval, 8);
        hint(mp_builtin_exec, this::mp_builtin_exec, 0);
        hint(mp_builtin_exec, this::mp_builtin_exec, 8);
        hint(mp_builtin_execfile, this::mp_builtin_execfile, 0);
        hint(mp_builtin_execfile, this::mp_builtin_execfile, 8);
        hint(mp_help_add_from_names, this::mp_help_add_from_names, 0);
        hint(mp_help_add_from_names, this::mp_help_add_from_names, 20);
        hint(mp_help_add_from_names, this::mp_help_add_from_names, 30);
        hint(mp_help_add_from_names, this::mp_help_add_from_names, 40);
    }

    private void gen_hints_9() {
        hint(mp_help_add_from_map, this::mp_help_add_from_map, 0);
        hint(mp_help_add_from_map, this::mp_help_add_from_map, 36);
        hint(mp_builtin_help, this::mp_builtin_help, 0);
        hint(mp_builtin_help, this::mp_builtin_help, 18);
        hint(mp_builtin_help, this::mp_builtin_help, 40);
        hint(mp_builtin_help, this::mp_builtin_help, 50);
        hint(mp_builtin_help, this::mp_builtin_help, 58);
        hint(mp_builtin_help, this::mp_builtin_help, 66);
        hint(mp_builtin_help, this::mp_builtin_help, 74);
        hint(mp_builtin_help, this::mp_builtin_help, 84);
        hint(mp_builtin_help, this::mp_builtin_help, 94);
        hint(mp_builtin_help, this::mp_builtin_help, 132);
        hint(mp_builtin_help, this::mp_builtin_help, 140);
        hint(mp_builtin_help, this::mp_builtin_help, 186);
        hint(mp_builtin_help, this::mp_builtin_help, 196);
        hint(mp_builtin_help, this::mp_builtin_help, 206);
        hint(mp_builtin_help, this::mp_builtin_help, 216);
        hint(mp_builtin_help, this::mp_builtin_help, 224);
        hint(mp_builtin_help, this::mp_builtin_help, 234);
        hint(mp_builtin_help, this::mp_builtin_help, 298);
        hint(mp_builtin_help, this::mp_builtin_help, 306);
        hint(mp_builtin_help, this::mp_builtin_help, 314);
        hint(mp_builtin_help, this::mp_builtin_help, 322);
        hint(mp_builtin_help, this::mp_builtin_help, 330);
        hint(mp_builtin_globals, this::mp_builtin_globals, 0);
        hint(mp_builtin_locals, this::mp_builtin_locals, 0);
        hint(mp_builtin___build_class__, this::mp_builtin___build_class__, 0);
        hint(mp_builtin___build_class__, this::mp_builtin___build_class__, 20);
        hint(mp_builtin___build_class__, this::mp_builtin___build_class__, 30);
        hint(mp_builtin___build_class__, this::mp_builtin___build_class__, 48);
        hint(mp_builtin___build_class__, this::mp_builtin___build_class__, 64);
        hint(mp_builtin___build_class__, this::mp_builtin___build_class__, 82);
        hint(mp_builtin___build_class__, this::mp_builtin___build_class__, 98);
        hint(mp_builtin_abs, this::mp_builtin_abs, 0);
        hint(mp_builtin_abs, this::mp_builtin_abs, 10);
        hint(mp_builtin_hash, this::mp_builtin_hash, 0);
        hint(mp_builtin_hash, this::mp_builtin_hash, 10);
        hint(mp_builtin_iter, this::mp_builtin_iter, 0);
        hint(mp_builtin_iter, this::mp_builtin_iter, 8);
        hint(mp_builtin_all, this::mp_builtin_all, 0);
        hint(mp_builtin_all, this::mp_builtin_all, 8);
        hint(mp_builtin_all, this::mp_builtin_all, 16);
        hint(mp_builtin_all, this::mp_builtin_all, 30);
        hint(mp_builtin_any, this::mp_builtin_any, 0);
        hint(mp_builtin_any, this::mp_builtin_any, 8);
        hint(mp_builtin_any, this::mp_builtin_any, 16);
        hint(mp_builtin_any, this::mp_builtin_any, 30);
        hint(mp_builtin_bin, this::mp_builtin_bin, 0);
        hint(mp_builtin_bin, this::mp_builtin_bin, 20);
        hint(mp_builtin_callable, this::mp_builtin_callable, 0);
        hint(mp_builtin_callable, this::mp_builtin_callable, 6);
        hint(mp_builtin_chr, this::mp_builtin_chr, 0);
        hint(mp_builtin_chr, this::mp_builtin_chr, 6);
        hint(mp_builtin_chr, this::mp_builtin_chr, 22);
        hint(mp_builtin_chr, this::mp_builtin_chr, 144);
        hint(mp_builtin_divmod, this::mp_builtin_divmod, 0);
        hint(mp_builtin_divmod, this::mp_builtin_divmod, 12);
        hint(mp_builtin_hex, this::mp_builtin_hex, 0);
        hint(mp_builtin_hex, this::mp_builtin_hex, 14);
        hint(mp_builtin_oct, this::mp_builtin_oct, 0);
        hint(mp_builtin_oct, this::mp_builtin_oct, 14);
        hint(mp_builtin_sum, this::mp_builtin_sum, 0);
        hint(mp_builtin_sum, this::mp_builtin_sum, 22);
        hint(mp_builtin_sum, this::mp_builtin_sum, 30);
        hint(mp_builtin_sum, this::mp_builtin_sum, 48);
        hint(mp_builtin_min_max, this::mp_builtin_min_max, 0);
        hint(mp_builtin_min_max, this::mp_builtin_min_max, 22);
        hint(mp_builtin_min_max, this::mp_builtin_min_max, 68);
        hint(mp_builtin_min_max, this::mp_builtin_min_max, 92);
        hint(mp_builtin_min_max, this::mp_builtin_min_max, 102);
        hint(mp_builtin_min_max, this::mp_builtin_min_max, 120);
        hint(mp_builtin_min_max, this::mp_builtin_min_max, 148);
        hint(mp_builtin_min_max, this::mp_builtin_min_max, 166);
        hint(mp_builtin_min_max, this::mp_builtin_min_max, 188);
        hint(mp_builtin_min_max, this::mp_builtin_min_max, 200);
        hint(mp_builtin_max, this::mp_builtin_max, 0);
        hint(mp_builtin_max, this::mp_builtin_max, 8);
        hint(mp_builtin_min, this::mp_builtin_min, 0);
        hint(mp_builtin_min, this::mp_builtin_min, 8);
        hint(mp_builtin_ord, this::mp_builtin_ord, 0);
        hint(mp_builtin_ord, this::mp_builtin_ord, 10);
        hint(mp_builtin_ord, this::mp_builtin_ord, 40);
        hint(mp_builtin_ord, this::mp_builtin_ord, 52);
        hint(mp_builtin_ord, this::mp_builtin_ord, 56);
        hint(mp_builtin_ord, this::mp_builtin_ord, 82);
        hint(mp_builtin_ord, this::mp_builtin_ord, 86);
        hint(mp_builtin_print, this::mp_builtin_print, 0);
        hint(mp_builtin_print, this::mp_builtin_print, 26);
        hint(mp_builtin_print, this::mp_builtin_print, 34);
        hint(mp_builtin_print, this::mp_builtin_print, 52);
        hint(mp_builtin_print, this::mp_builtin_print, 62);
        hint(mp_builtin_print, this::mp_builtin_print, 82);
        hint(mp_builtin_print, this::mp_builtin_print, 102);
        hint(mp_builtin_print, this::mp_builtin_print, 114);
        hint(mp_builtin_repr, this::mp_builtin_repr, 0);
        hint(mp_builtin_repr, this::mp_builtin_repr, 16);
        hint(mp_builtin_repr, this::mp_builtin_repr, 26);
        hint(mp_builtin_repr, this::mp_builtin_repr, 34);
        hint(mp_builtin_round, this::mp_builtin_round, 0);
        hint(mp_builtin_round, this::mp_builtin_round, 34);
        hint(mp_builtin_round, this::mp_builtin_round, 38);
        hint(mp_builtin_round, this::mp_builtin_round, 50);
        hint(mp_builtin_round, this::mp_builtin_round, 54);
        hint(mp_builtin_round, this::mp_builtin_round, 62);
        hint(mp_builtin_round, this::mp_builtin_round, 72);
        hint(mp_builtin_round, this::mp_builtin_round, 76);
        hint(mp_builtin_round, this::mp_builtin_round, 82);
        hint(mp_builtin_round, this::mp_builtin_round, 86);
        hint(mp_builtin_round, this::mp_builtin_round, 92);
        hint(mp_builtin_round, this::mp_builtin_round, 96);
        hint(mp_builtin_sorted, this::mp_builtin_sorted, 0);
        hint(mp_builtin_sorted, this::mp_builtin_sorted, 18);
        hint(mp_builtin_sorted, this::mp_builtin_sorted, 32);
        hint(mp_builtin_sorted, this::mp_builtin_sorted, 44);
        hint(mp_builtin_hasattr, this::mp_builtin_hasattr, 0);
        hint(mp_builtin_hasattr, this::mp_builtin_hasattr, 10);
        hint(mp_builtin_hasattr, this::mp_builtin_hasattr, 22);
        hint(mp_builtin_getattr, this::mp_builtin_getattr, 0);
        hint(mp_builtin_getattr, this::mp_builtin_getattr, 18);
        hint(mp_builtin_getattr, this::mp_builtin_getattr, 34);
        hint(mp_builtin_getattr, this::mp_builtin_getattr, 54);
        hint(mp_builtin_setattr, this::mp_builtin_setattr, 0);
        hint(mp_builtin_setattr, this::mp_builtin_setattr, 12);
        hint(mp_builtin_setattr, this::mp_builtin_setattr, 22);
        hint(mp_builtin_delattr, this::mp_builtin_delattr, 0);
        hint(mp_builtin_delattr, this::mp_builtin_delattr, 8);
        hint(mp_builtin_dir, this::mp_builtin_dir, 0);
        hint(mp_builtin_dir, this::mp_builtin_dir, 16);
        hint(mp_builtin_dir, this::mp_builtin_dir, 58);
        hint(mp_builtin_dir, this::mp_builtin_dir, 94);
        hint(mp_builtin_dir, this::mp_builtin_dir, 122);
        hint(mp_builtin_dir, this::mp_builtin_dir, 136);
        hint(mp_builtin_next, this::mp_builtin_next, 0);
        hint(mp_builtin_next, this::mp_builtin_next, 6);
        hint(mp_builtin_next, this::mp_builtin_next, 16);
        hint(mp_builtin_next, this::mp_builtin_next, 20);
        hint(mp_builtin_pow, this::mp_builtin_pow, 0);
        hint(mp_builtin_pow, this::mp_builtin_pow, 24);
        hint(mp_builtin_pow, this::mp_builtin_pow, 32);
        hint(mp_builtin___repl_print__, this::mp_builtin___repl_print__, 0);
        hint(mp_builtin___repl_print__, this::mp_builtin___repl_print__, 22);
        hint(mp_builtin___repl_print__, this::mp_builtin___repl_print__, 30);
        hint(mp_builtin___repl_print__, this::mp_builtin___repl_print__, 50);
        hint(gc_disable, this::gc_disable, 0);
        hint(gc_enable, this::gc_enable, 0);
        hint(gc_isenabled, this::gc_isenabled, 0);
        hint(py_gc_collect, this::py_gc_collect, 0);
        hint(py_gc_collect, this::py_gc_collect, 6);
        hint(gc_mem_free, this::gc_mem_free, 0);
        hint(gc_mem_free, this::gc_mem_free, 10);
        hint(gc_mem_alloc, this::gc_mem_alloc, 0);
        hint(gc_mem_alloc, this::gc_mem_alloc, 10);
        hint(gc_threshold, this::gc_threshold, 0);
        hint(gc_threshold, this::gc_threshold, 26);
        hint(gc_threshold, this::gc_threshold, 34);
        hint(resource_stream, this::resource_stream, 0);
        hint(resource_stream, this::resource_stream, 22);
        hint(resource_stream, this::resource_stream, 50);
        hint(resource_stream, this::resource_stream, 58);
        hint(resource_stream, this::resource_stream, 68);
        hint(resource_stream, this::resource_stream, 74);
        hint(resource_stream, this::resource_stream, 84);
        hint(resource_stream, this::resource_stream, 92);
        hint(resource_stream, this::resource_stream, 100);
        hint(resource_stream, this::resource_stream, 110);
        hint(resource_stream, this::resource_stream, 124);
        hint(resource_stream, this::resource_stream, 134);
        hint(resource_stream, this::resource_stream, 146);
        hint(resource_stream, this::resource_stream, 158);
        hint(resource_stream, this::resource_stream, 186);
        hint(resource_stream, this::resource_stream, 198);
        hint(fabs_funcf, this::fabs_funcf, 0);
        hint(log2f, this::log2f, 0);
        hint(log2f, this::log2f, 6);
        hint(log2f, this::log2f, 12);
        hint(mp_math_isnan, this::mp_math_isnan, 0);
        hint(mp_math_isnan, this::mp_math_isnan, 6);
        hint(mp_math_isnan, this::mp_math_isnan, 12);
        hint(mp_math_isfinite, this::mp_math_isfinite, 0);
        hint(mp_math_isfinite, this::mp_math_isfinite, 6);
        hint(mp_math_isfinite, this::mp_math_isfinite, 18);
        hint(mp_math_isfinite, this::mp_math_isfinite, 30);
        hint(mp_math_isinf, this::mp_math_isinf, 0);
        hint(mp_math_isinf, this::mp_math_isinf, 6);
        hint(mp_math_isinf, this::mp_math_isinf, 18);
        hint(mp_math_isinf, this::mp_math_isinf, 30);
        hint(mp_math_degrees, this::mp_math_degrees, 0);
        hint(mp_math_degrees, this::mp_math_degrees, 6);
        hint(mp_math_degrees, this::mp_math_degrees, 12);
        hint(mp_math_degrees, this::mp_math_degrees, 16);
        hint(mp_math_radians, this::mp_math_radians, 0);
        hint(mp_math_radians, this::mp_math_radians, 6);
        hint(mp_math_radians, this::mp_math_radians, 12);
        hint(mp_math_radians, this::mp_math_radians, 16);
        hint(mp_math_trunc, this::mp_math_trunc, 0);
        hint(mp_math_trunc, this::mp_math_trunc, 6);
        hint(mp_math_trunc, this::mp_math_trunc, 10);
        hint(mp_math_trunc, this::mp_math_trunc, 14);
        hint(mp_math_modf, this::mp_math_modf, 0);
        hint(mp_math_modf, this::mp_math_modf, 10);
        hint(mp_math_modf, this::mp_math_modf, 16);
        hint(mp_math_modf, this::mp_math_modf, 20);
        hint(mp_math_modf, this::mp_math_modf, 28);
        hint(mp_math_modf, this::mp_math_modf, 38);
        hint(mp_math_ldexp, this::mp_math_ldexp, 0);
        hint(mp_math_ldexp, this::mp_math_ldexp, 8);
        hint(mp_math_ldexp, this::mp_math_ldexp, 16);
        hint(mp_math_ldexp, this::mp_math_ldexp, 24);
        hint(mp_math_ldexp, this::mp_math_ldexp, 28);
        hint(mp_math_frexp, this::mp_math_frexp, 0);
        hint(mp_math_frexp, this::mp_math_frexp, 10);
        hint(mp_math_frexp, this::mp_math_frexp, 16);
        hint(mp_math_frexp, this::mp_math_frexp, 20);
        hint(mp_math_frexp, this::mp_math_frexp, 28);
        hint(mp_math_frexp, this::mp_math_frexp, 38);
        hint(mp_math_floor, this::mp_math_floor, 0);
        hint(mp_math_floor, this::mp_math_floor, 6);
        hint(mp_math_floor, this::mp_math_floor, 10);
        hint(mp_math_floor, this::mp_math_floor, 14);
        hint(copysign_funcf, this::copysign_funcf, 0);
        hint(mp_math_ceil, this::mp_math_ceil, 0);
        hint(mp_math_ceil, this::mp_math_ceil, 6);
        hint(mp_math_ceil, this::mp_math_ceil, 10);
        hint(mp_math_ceil, this::mp_math_ceil, 14);
        hint(math_generic_1, this::math_generic_1, 0);
        hint(math_generic_1, this::math_generic_1, 8);
        hint(math_generic_1, this::math_generic_1, 12);
        hint(math_generic_1, this::math_generic_1, 20);
        hint(math_generic_1, this::math_generic_1, 32);
        hint(math_generic_1, this::math_generic_1, 48);
        hint(math_generic_1, this::math_generic_1, 60);
        hint(math_generic_1, this::math_generic_1, 76);
        hint(math_generic_1, this::math_generic_1, 88);
        hint(math_generic_1, this::math_generic_1, 98);
        hint(math_generic_1, this::math_generic_1, 104);
        hint(mp_math_lgamma, this::mp_math_lgamma, 0);
        hint(mp_math_lgamma, this::mp_math_lgamma, 8);
        hint(mp_math_gamma, this::mp_math_gamma, 0);
        hint(mp_math_gamma, this::mp_math_gamma, 8);
        hint(mp_math_erfc, this::mp_math_erfc, 0);
        hint(mp_math_erfc, this::mp_math_erfc, 8);
        hint(mp_math_erf, this::mp_math_erf, 0);
        hint(mp_math_erf, this::mp_math_erf, 8);
        hint(mp_math_fabs, this::mp_math_fabs, 0);
        hint(mp_math_fabs, this::mp_math_fabs, 8);
        hint(mp_math_atan, this::mp_math_atan, 0);
        hint(mp_math_atan, this::mp_math_atan, 8);
        hint(mp_math_asin, this::mp_math_asin, 0);
        hint(mp_math_asin, this::mp_math_asin, 8);
        hint(mp_math_acos, this::mp_math_acos, 0);
        hint(mp_math_acos, this::mp_math_acos, 8);
        hint(mp_math_tan, this::mp_math_tan, 0);
        hint(mp_math_tan, this::mp_math_tan, 8);
        hint(mp_math_sin, this::mp_math_sin, 0);
        hint(mp_math_sin, this::mp_math_sin, 8);
        hint(mp_math_cos, this::mp_math_cos, 0);
        hint(mp_math_cos, this::mp_math_cos, 8);
        hint(mp_math_atanh, this::mp_math_atanh, 0);
        hint(mp_math_atanh, this::mp_math_atanh, 8);
        hint(mp_math_asinh, this::mp_math_asinh, 0);
        hint(mp_math_asinh, this::mp_math_asinh, 8);
        hint(mp_math_acosh, this::mp_math_acosh, 0);
        hint(mp_math_acosh, this::mp_math_acosh, 8);
        hint(mp_math_tanh, this::mp_math_tanh, 0);
        hint(mp_math_tanh, this::mp_math_tanh, 8);
        hint(mp_math_sinh, this::mp_math_sinh, 0);
        hint(mp_math_sinh, this::mp_math_sinh, 8);
        hint(mp_math_cosh, this::mp_math_cosh, 0);
        hint(mp_math_cosh, this::mp_math_cosh, 8);
        hint(mp_math_log10, this::mp_math_log10, 0);
        hint(mp_math_log10, this::mp_math_log10, 8);
        hint(mp_math_log2, this::mp_math_log2, 0);
        hint(mp_math_log2, this::mp_math_log2, 8);
        hint(mp_math_expm1, this::mp_math_expm1, 0);
        hint(mp_math_expm1, this::mp_math_expm1, 8);
        hint(mp_math_exp, this::mp_math_exp, 0);
        hint(mp_math_exp, this::mp_math_exp, 8);
        hint(mp_math_sqrt, this::mp_math_sqrt, 0);
        hint(mp_math_sqrt, this::mp_math_sqrt, 8);
        hint(math_generic_2, this::math_generic_2, 0);
        hint(math_generic_2, this::math_generic_2, 10);
        hint(math_generic_2, this::math_generic_2, 18);
        hint(math_generic_2, this::math_generic_2, 26);
        hint(math_generic_2, this::math_generic_2, 34);
        hint(math_generic_2, this::math_generic_2, 46);
        hint(math_generic_2, this::math_generic_2, 58);
        hint(math_generic_2, this::math_generic_2, 74);
        hint(math_generic_2, this::math_generic_2, 86);
        hint(math_generic_2, this::math_generic_2, 102);
        hint(math_generic_2, this::math_generic_2, 114);
        hint(math_generic_2, this::math_generic_2, 124);
        hint(math_generic_2, this::math_generic_2, 130);
        hint(mp_math_fmod, this::mp_math_fmod, 0);
        hint(mp_math_fmod, this::mp_math_fmod, 8);
        hint(mp_math_copysign, this::mp_math_copysign, 0);
        hint(mp_math_copysign, this::mp_math_copysign, 8);
        hint(mp_math_atan2, this::mp_math_atan2, 0);
        hint(mp_math_atan2, this::mp_math_atan2, 8);
        hint(mp_math_pow, this::mp_math_pow, 0);
        hint(mp_math_pow, this::mp_math_pow, 8);
        hint(mp_math_log, this::mp_math_log, 0);
        hint(mp_math_log, this::mp_math_log, 12);
        hint(mp_math_log, this::mp_math_log, 20);
        hint(mp_math_log, this::mp_math_log, 30);
        hint(mp_math_log, this::mp_math_log, 36);
        hint(mp_math_log, this::mp_math_log, 48);
        hint(mp_math_log, this::mp_math_log, 56);
        hint(mp_math_log, this::mp_math_log, 70);
        hint(mp_math_log, this::mp_math_log, 82);
        hint(mp_math_log, this::mp_math_log, 88);
        hint(mp_math_log, this::mp_math_log, 96);
        hint(mp_math_log, this::mp_math_log, 100);
        hint(mp_cmath_sin, this::mp_cmath_sin, 0);
        hint(mp_cmath_sin, this::mp_cmath_sin, 10);
        hint(mp_cmath_sin, this::mp_cmath_sin, 16);
        hint(mp_cmath_sin, this::mp_cmath_sin, 24);
        hint(mp_cmath_sin, this::mp_cmath_sin, 32);
        hint(mp_cmath_sin, this::mp_cmath_sin, 40);
        hint(mp_cmath_sin, this::mp_cmath_sin, 48);
        hint(mp_cmath_sin, this::mp_cmath_sin, 58);
        hint(mp_cmath_sin, this::mp_cmath_sin, 64);
        hint(mp_cmath_cos, this::mp_cmath_cos, 0);
        hint(mp_cmath_cos, this::mp_cmath_cos, 10);
        hint(mp_cmath_cos, this::mp_cmath_cos, 16);
        hint(mp_cmath_cos, this::mp_cmath_cos, 24);
        hint(mp_cmath_cos, this::mp_cmath_cos, 32);
        hint(mp_cmath_cos, this::mp_cmath_cos, 40);
        hint(mp_cmath_cos, this::mp_cmath_cos, 52);
        hint(mp_cmath_cos, this::mp_cmath_cos, 62);
        hint(mp_cmath_cos, this::mp_cmath_cos, 68);
        hint(mp_cmath_sqrt, this::mp_cmath_sqrt, 0);
        hint(mp_cmath_sqrt, this::mp_cmath_sqrt, 10);
        hint(mp_cmath_sqrt, this::mp_cmath_sqrt, 20);
        hint(mp_cmath_sqrt, this::mp_cmath_sqrt, 30);
        hint(mp_cmath_sqrt, this::mp_cmath_sqrt, 38);
        hint(mp_cmath_sqrt, this::mp_cmath_sqrt, 46);
        hint(mp_cmath_sqrt, this::mp_cmath_sqrt, 56);
        hint(mp_cmath_sqrt, this::mp_cmath_sqrt, 64);
        hint(mp_cmath_sqrt, this::mp_cmath_sqrt, 70);
        hint(mp_cmath_sqrt, this::mp_cmath_sqrt, 78);
        hint(mp_cmath_sqrt, this::mp_cmath_sqrt, 84);
        hint(mp_cmath_sqrt, this::mp_cmath_sqrt, 94);
        hint(mp_cmath_sqrt, this::mp_cmath_sqrt, 100);
        hint(mp_cmath_log10, this::mp_cmath_log10, 0);
        hint(mp_cmath_log10, this::mp_cmath_log10, 10);
        hint(mp_cmath_log10, this::mp_cmath_log10, 20);
        hint(mp_cmath_log10, this::mp_cmath_log10, 30);
        hint(mp_cmath_log10, this::mp_cmath_log10, 38);
        hint(mp_cmath_log10, this::mp_cmath_log10, 42);
        hint(mp_cmath_log10, this::mp_cmath_log10, 52);
        hint(mp_cmath_log10, this::mp_cmath_log10, 58);
        hint(mp_cmath_log10, this::mp_cmath_log10, 70);
        hint(mp_cmath_log10, this::mp_cmath_log10, 76);
        hint(mp_cmath_log, this::mp_cmath_log, 0);
        hint(mp_cmath_log, this::mp_cmath_log, 10);
        hint(mp_cmath_log, this::mp_cmath_log, 20);
        hint(mp_cmath_log, this::mp_cmath_log, 30);
        hint(mp_cmath_log, this::mp_cmath_log, 38);
        hint(mp_cmath_log, this::mp_cmath_log, 42);
        hint(mp_cmath_log, this::mp_cmath_log, 52);
        hint(mp_cmath_log, this::mp_cmath_log, 64);
        hint(mp_cmath_log, this::mp_cmath_log, 70);
        hint(mp_cmath_exp, this::mp_cmath_exp, 0);
        hint(mp_cmath_exp, this::mp_cmath_exp, 10);
        hint(mp_cmath_exp, this::mp_cmath_exp, 16);
        hint(mp_cmath_exp, this::mp_cmath_exp, 26);
        hint(mp_cmath_exp, this::mp_cmath_exp, 34);
        hint(mp_cmath_exp, this::mp_cmath_exp, 40);
        hint(mp_cmath_exp, this::mp_cmath_exp, 50);
        hint(mp_cmath_exp, this::mp_cmath_exp, 56);
        hint(mp_cmath_rect, this::mp_cmath_rect, 0);
        hint(mp_cmath_rect, this::mp_cmath_rect, 8);
        hint(mp_cmath_rect, this::mp_cmath_rect, 16);
        hint(mp_cmath_rect, this::mp_cmath_rect, 22);
        hint(mp_cmath_rect, this::mp_cmath_rect, 30);
        hint(mp_cmath_rect, this::mp_cmath_rect, 36);
        hint(mp_cmath_rect, this::mp_cmath_rect, 46);
        hint(mp_cmath_rect, this::mp_cmath_rect, 52);
        hint(mp_cmath_phase, this::mp_cmath_phase, 0);
        hint(mp_cmath_phase, this::mp_cmath_phase, 10);
        hint(mp_cmath_phase, this::mp_cmath_phase, 18);
        hint(mp_cmath_phase, this::mp_cmath_phase, 22);
        hint(mp_cmath_polar, this::mp_cmath_polar, 0);
        hint(mp_cmath_polar, this::mp_cmath_polar, 12);
        hint(mp_cmath_polar, this::mp_cmath_polar, 22);
        hint(mp_cmath_polar, this::mp_cmath_polar, 32);
        hint(mp_cmath_polar, this::mp_cmath_polar, 40);
        hint(mp_cmath_polar, this::mp_cmath_polar, 44);
        hint(mp_cmath_polar, this::mp_cmath_polar, 48);
        hint(mp_cmath_polar, this::mp_cmath_polar, 58);
        hint(mp_cmath_polar, this::mp_cmath_polar, 62);
        hint(mp_cmath_polar, this::mp_cmath_polar, 72);
        hint(mp_micropython_pystack_use, this::mp_micropython_pystack_use, 0);
        hint(mp_micropython_mem_total, this::mp_micropython_mem_total, 0);
        hint(mp_micropython_mem_total, this::mp_micropython_mem_total, 6);
        hint(mp_micropython_mem_current, this::mp_micropython_mem_current, 0);
        hint(mp_micropython_mem_current, this::mp_micropython_mem_current, 6);
        hint(mp_micropython_mem_peak, this::mp_micropython_mem_peak, 0);
        hint(mp_micropython_mem_peak, this::mp_micropython_mem_peak, 6);
        hint(mp_micropython_stack_use, this::mp_micropython_stack_use, 0);
        hint(mp_micropython_stack_use, this::mp_micropython_stack_use, 6);
        hint(mp_micropython_mem_info, this::mp_micropython_mem_info, 0);
        hint(mp_micropython_mem_info, this::mp_micropython_mem_info, 8);
        hint(mp_micropython_mem_info, this::mp_micropython_mem_info, 14);
        hint(mp_micropython_mem_info, this::mp_micropython_mem_info, 20);
        hint(mp_micropython_mem_info, this::mp_micropython_mem_info, 36);
        hint(mp_micropython_mem_info, this::mp_micropython_mem_info, 40);
        hint(mp_micropython_mem_info, this::mp_micropython_mem_info, 54);
        hint(mp_micropython_mem_info, this::mp_micropython_mem_info, 58);
        hint(mp_micropython_mem_info, this::mp_micropython_mem_info, 66);
        hint(mp_micropython_kbd_intr, this::mp_micropython_kbd_intr, 0);
        hint(mp_micropython_kbd_intr, this::mp_micropython_kbd_intr, 6);
        hint(mp_micropython_kbd_intr, this::mp_micropython_kbd_intr, 10);
        hint(mp_micropython_heap_unlock, this::mp_micropython_heap_unlock, 0);
        hint(mp_micropython_heap_unlock, this::mp_micropython_heap_unlock, 6);
        hint(mp_micropython_heap_lock, this::mp_micropython_heap_lock, 0);
        hint(mp_micropython_heap_lock, this::mp_micropython_heap_lock, 6);
        hint(mp_micropython_qstr_info, this::mp_micropython_qstr_info, 0);
        hint(mp_micropython_qstr_info, this::mp_micropython_qstr_info, 18);
        hint(mp_micropython_qstr_info, this::mp_micropython_qstr_info, 38);
        hint(mp_micropython_qstr_info, this::mp_micropython_qstr_info, 46);
        hint(mp_micropython_schedule, this::mp_micropython_schedule, 0);
        hint(mp_micropython_schedule, this::mp_micropython_schedule, 6);
        hint(mp_micropython_schedule, this::mp_micropython_schedule, 18);
        hint(mp_micropython_opt_level, this::mp_micropython_opt_level, 0);
        hint(mp_micropython_opt_level, this::mp_micropython_opt_level, 28);
        hint(get_fmt_type, this::get_fmt_type, 0);
        hint(get_fmt_num, this::get_fmt_num, 0);
        hint(get_fmt_num, this::get_fmt_num, 16);
        hint(get_fmt_num, this::get_fmt_num, 36);
        hint(calc_size_items, this::calc_size_items, 0);
        hint(calc_size_items, this::calc_size_items, 16);
        hint(calc_size_items, this::calc_size_items, 40);
        hint(calc_size_items, this::calc_size_items, 52);
        hint(calc_size_items, this::calc_size_items, 82);
        hint(struct_calcsize, this::struct_calcsize, 0);
        hint(struct_calcsize, this::struct_calcsize, 6);
        hint(struct_calcsize, this::struct_calcsize, 12);
        hint(struct_unpack_from, this::struct_unpack_from, 0);
        hint(struct_unpack_from, this::struct_unpack_from, 14);
        hint(struct_unpack_from, this::struct_unpack_from, 22);
        hint(struct_unpack_from, this::struct_unpack_from, 30);
        hint(struct_unpack_from, this::struct_unpack_from, 40);
        hint(struct_unpack_from, this::struct_unpack_from, 52);
        hint(struct_unpack_from, this::struct_unpack_from, 72);
        hint(struct_unpack_from, this::struct_unpack_from, 88);
        hint(struct_unpack_from, this::struct_unpack_from, 128);
        hint(struct_unpack_from, this::struct_unpack_from, 138);
        hint(struct_unpack_from, this::struct_unpack_from, 170);
        hint(struct_unpack_from, this::struct_unpack_from, 190);
        hint(struct_pack_into_internal, this::struct_pack_into_internal, 0);
        hint(struct_pack_into_internal, this::struct_pack_into_internal, 14);
        hint(struct_pack_into_internal, this::struct_pack_into_internal, 22);
        hint(struct_pack_into_internal, this::struct_pack_into_internal, 46);
        hint(struct_pack_into_internal, this::struct_pack_into_internal, 58);
        hint(struct_pack_into_internal, this::struct_pack_into_internal, 94);
        hint(struct_pack_into_internal, this::struct_pack_into_internal, 114);
        hint(struct_pack_into_internal, this::struct_pack_into_internal, 132);
        hint(struct_pack_into_internal, this::struct_pack_into_internal, 144);
        hint(struct_pack, this::struct_pack, 0);
        hint(struct_pack, this::struct_pack, 16);
        hint(struct_pack, this::struct_pack, 26);
        hint(struct_pack, this::struct_pack, 38);
        hint(struct_pack, this::struct_pack, 52);
        hint(struct_pack, this::struct_pack, 60);
        hint(struct_pack_into, this::struct_pack_into, 0);
        hint(struct_pack_into, this::struct_pack_into, 18);
        hint(struct_pack_into, this::struct_pack_into, 24);
        hint(struct_pack_into, this::struct_pack_into, 42);
        hint(struct_pack_into, this::struct_pack_into, 56);
        hint(struct_pack_into, this::struct_pack_into, 78);
        hint(mp_sys_exit, this::mp_sys_exit, 0);
        hint(mp_sys_exit, this::mp_sys_exit, 14);
        hint(mp_sys_exit, this::mp_sys_exit, 18);
        hint(mp_sys_exit, this::mp_sys_exit, 24);
        hint(mp_sys_print_exception, this::mp_sys_print_exception, 0);
        hint(mp_sys_print_exception, this::mp_sys_print_exception, 18);
        hint(mp_sys_print_exception, this::mp_sys_print_exception, 34);
        hint(mp_sys_exc_info, this::mp_sys_exc_info, 0);
        hint(mp_sys_exc_info, this::mp_sys_exc_info, 16);
        hint(mp_sys_exc_info, this::mp_sys_exc_info, 40);
        hint(mp_sys_getsizeof, this::mp_sys_getsizeof, 0);
        hint(mp_sys_getsizeof, this::mp_sys_getsizeof, 10);
        hint(mp_errno_to_str, this::mp_errno_to_str, 0);
        hint(mp_errno_to_str, this::mp_errno_to_str, 14);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 0);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 36);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 72);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 110);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 116);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 140);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 166);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 256);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 300);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 304);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 320);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 328);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 436);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 542);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 556);
    }

    private void gen_hints_10() {
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 578);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 648);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 686);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 690);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 710);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 738);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 742);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 750);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 770);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 778);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 782);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 798);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 852);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 858);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 874);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 890);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 930);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 950);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 962);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 966);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 1016);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 1034);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 1040);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 1058);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 1066);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 1088);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 1108);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 1124);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 1132);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 1152);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 1162);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 1174);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 1182);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 1240);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 1260);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 1264);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 1286);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 1298);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 1316);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 1334);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 1342);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 1346);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 1362);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 1380);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 1396);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 1398);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 1414);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 1416);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 1450);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 1460);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 1480);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 1514);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 1522);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 1578);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 1614);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 1636);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 1642);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 1656);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 1658);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 1672);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 1674);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 1716);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 1736);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 1776);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 1784);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 1792);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 1810);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 1826);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 1830);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 1850);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 1854);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 1872);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 1874);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 1892);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 1894);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 1934);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 1952);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 2006);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 2020);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 2024);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 2028);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 2034);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 2052);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 2076);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 2094);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 2098);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 2132);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 2210);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 2266);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 2278);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 2290);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 2308);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 2318);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 2380);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 2392);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 2394);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 2426);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 2444);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 2482);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 2484);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 2522);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 2524);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 2574);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 2594);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 2642);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 2644);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 2688);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 2726);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 2738);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 2776);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 2792);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 2850);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 2868);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 2916);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 2934);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 2972);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 2974);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 2982);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 2988);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 2998);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 3024);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 3038);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 3044);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 3066);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 3084);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 3104);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 3112);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 3116);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 3132);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 3134);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 3156);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 3158);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 3178);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 3182);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 3266);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 3302);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 3358);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 3382);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 3386);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 3440);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 3458);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 3462);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 3522);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 3546);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 3550);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 3604);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 3620);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 3688);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 3728);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 3732);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 3746);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 3768);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 3802);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 3806);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 3844);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 3926);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 3942);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 3946);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 3990);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 4000);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 4012);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 4026);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 4034);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 4042);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 4046);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 4060);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 4066);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 4072);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 4100);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 4106);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 4162);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 4170);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 4212);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 4224);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 4234);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 4240);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 4346);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 4370);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 4378);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 4384);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 4388);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 4404);
        hint(mp_execute_bytecode, this::mp_execute_bytecode, 4418);
        hint(unlikely_fun_pos_args_mismatch, this::unlikely_fun_pos_args_mismatch, 0);
        hint(unlikely_fun_pos_args_mismatch, this::unlikely_fun_pos_args_mismatch, 10);
        hint(unlikely_fun_pos_args_mismatch, this::unlikely_fun_pos_args_mismatch, 24);
        hint(unlikely_fun_pos_args_mismatch, this::unlikely_fun_pos_args_mismatch, 28);
        hint(mp_decode_uint, this::mp_decode_uint, 0);
        hint(mp_decode_uint_value, this::mp_decode_uint_value, 0);
        hint(mp_decode_uint_value, this::mp_decode_uint_value, 10);
        hint(mp_decode_uint_skip, this::mp_decode_uint_skip, 0);
        hint(mp_setup_code_state, this::mp_setup_code_state, 0);
        hint(mp_setup_code_state, this::mp_setup_code_state, 38);
        hint(mp_setup_code_state, this::mp_setup_code_state, 46);
        hint(mp_setup_code_state, this::mp_setup_code_state, 116);
        hint(mp_setup_code_state, this::mp_setup_code_state, 166);
        hint(mp_setup_code_state, this::mp_setup_code_state, 184);
        hint(mp_setup_code_state, this::mp_setup_code_state, 230);
        hint(mp_setup_code_state, this::mp_setup_code_state, 322);
        hint(mp_setup_code_state, this::mp_setup_code_state, 498);
        hint(mp_setup_code_state, this::mp_setup_code_state, 502);
        hint(mp_setup_code_state, this::mp_setup_code_state, 524);
        hint(mp_setup_code_state, this::mp_setup_code_state, 616);
        hint(mp_setup_code_state, this::mp_setup_code_state, 648);
        hint(mp_setup_code_state, this::mp_setup_code_state, 662);
        hint(mp_setup_code_state, this::mp_setup_code_state, 682);
        hint(mp_opcode_format, this::mp_opcode_format, 0);
        hint(str_startswith_word, this::str_startswith_word, 0);
        hint(str_startswith_word, this::str_startswith_word, 40);
        hint(mp_repl_continue_with_input, this::mp_repl_continue_with_input, 0);
        hint(mp_repl_continue_with_input, this::mp_repl_continue_with_input, 96);
        hint(mp_repl_continue_with_input, this::mp_repl_continue_with_input, 108);
        hint(mp_repl_continue_with_input, this::mp_repl_continue_with_input, 120);
        hint(mp_repl_continue_with_input, this::mp_repl_continue_with_input, 132);
        hint(mp_repl_continue_with_input, this::mp_repl_continue_with_input, 144);
        hint(mp_repl_continue_with_input, this::mp_repl_continue_with_input, 156);
        hint(mp_repl_continue_with_input, this::mp_repl_continue_with_input, 168);
        hint(mp_repl_continue_with_input, this::mp_repl_continue_with_input, 180);
        hint(mp_repl_autocomplete, this::mp_repl_autocomplete, 0);
        hint(mp_repl_autocomplete, this::mp_repl_autocomplete, 32);
        hint(mp_repl_autocomplete, this::mp_repl_autocomplete, 46);
        hint(mp_repl_autocomplete, this::mp_repl_autocomplete, 102);
        hint(mp_repl_autocomplete, this::mp_repl_autocomplete, 126);
        hint(mp_repl_autocomplete, this::mp_repl_autocomplete, 146);
        hint(mp_repl_autocomplete, this::mp_repl_autocomplete, 164);
        hint(mp_repl_autocomplete, this::mp_repl_autocomplete, 180);
        hint(mp_repl_autocomplete, this::mp_repl_autocomplete, 248);
        hint(mp_repl_autocomplete, this::mp_repl_autocomplete, 342);
        hint(mp_repl_autocomplete, this::mp_repl_autocomplete, 360);
        hint(mp_repl_autocomplete, this::mp_repl_autocomplete, 378);
        hint(mp_repl_autocomplete, this::mp_repl_autocomplete, 428);
        hint(mp_repl_autocomplete, this::mp_repl_autocomplete, 440);
        hint(mp_repl_autocomplete, this::mp_repl_autocomplete, 460);
        hint(mp_repl_autocomplete, this::mp_repl_autocomplete, 488);
        hint(mp_small_int_mul_overflow, this::mp_small_int_mul_overflow, 0);
        hint(mp_small_int_mul_overflow, this::mp_small_int_mul_overflow, 20);
        hint(mp_small_int_mul_overflow, this::mp_small_int_mul_overflow, 40);
        hint(mp_small_int_mul_overflow, this::mp_small_int_mul_overflow, 64);
        hint(mp_small_int_mul_overflow, this::mp_small_int_mul_overflow, 86);
        hint(mp_small_int_modulo, this::mp_small_int_modulo, 0);
        hint(mp_small_int_modulo, this::mp_small_int_modulo, 8);
        hint(mp_small_int_floor_divide, this::mp_small_int_floor_divide, 0);
        hint(mp_small_int_floor_divide, this::mp_small_int_floor_divide, 18);
        hint(mp_frozen_stat_helper, this::mp_frozen_stat_helper, 0);
        hint(mp_frozen_stat_helper, this::mp_frozen_stat_helper, 12);
        hint(mp_frozen_stat_helper, this::mp_frozen_stat_helper, 28);
        hint(mp_frozen_stat_helper, this::mp_frozen_stat_helper, 44);
        hint(mp_find_frozen_str, this::mp_find_frozen_str, 0);
        hint(mp_find_frozen_str, this::mp_find_frozen_str, 26);
        hint(mp_find_frozen_str, this::mp_find_frozen_str, 46);
        hint(mp_frozen_stat, this::mp_frozen_stat, 0);
        hint(mp_frozen_stat, this::mp_frozen_stat, 12);
        hint(mp_frozen_stat, this::mp_frozen_stat, 24);
        hint(mp_find_frozen_module, this::mp_find_frozen_module, 0);
        hint(mp_find_frozen_module, this::mp_find_frozen_module, 18);
        hint(mp_find_frozen_module, this::mp_find_frozen_module, 40);
        hint(mp_find_frozen_module, this::mp_find_frozen_module, 56);
        hint(mp_find_frozen_module, this::mp_find_frozen_module, 86);
        hint(mp_find_frozen_module, this::mp_find_frozen_module, 96);
        hint(uctypes_struct_addressof, this::uctypes_struct_addressof, 0);
        hint(uctypes_struct_addressof, this::uctypes_struct_addressof, 10);
        hint(uctypes_struct_addressof, this::uctypes_struct_addressof, 16);
        hint(uctypes_struct_bytearray_at, this::uctypes_struct_bytearray_at, 0);
        hint(uctypes_struct_bytearray_at, this::uctypes_struct_bytearray_at, 10);
        hint(uctypes_struct_bytearray_at, this::uctypes_struct_bytearray_at, 18);
        hint(uctypes_struct_bytearray_at, this::uctypes_struct_bytearray_at, 26);
        hint(uctypes_struct_bytes_at, this::uctypes_struct_bytes_at, 0);
        hint(uctypes_struct_bytes_at, this::uctypes_struct_bytes_at, 8);
        hint(uctypes_struct_bytes_at, this::uctypes_struct_bytes_at, 16);
        hint(uctypes_struct_bytes_at, this::uctypes_struct_bytes_at, 24);
        hint(get_aligned, this::get_aligned, 0);
        hint(get_aligned, this::get_aligned, 54);
        hint(get_aligned, this::get_aligned, 76);
        hint(get_aligned, this::get_aligned, 114);
        hint(get_aligned, this::get_aligned, 124);
        hint(get_aligned, this::get_aligned, 138);
        hint(get_aligned, this::get_aligned, 148);
        hint(uctypes_struct_make_new, this::uctypes_struct_make_new, 0);
        hint(uctypes_struct_make_new, this::uctypes_struct_make_new, 24);
        hint(uctypes_struct_make_new, this::uctypes_struct_make_new, 30);
        hint(uctypes_struct_make_new, this::uctypes_struct_make_new, 40);
        hint(uctypes_struct_make_new, this::uctypes_struct_make_new, 60);
        hint(uctypes_struct_print, this::uctypes_struct_print, 0);
        hint(uctypes_struct_print, this::uctypes_struct_print, 54);
        hint(set_aligned, this::set_aligned, 0);
        hint(set_aligned, this::set_aligned, 24);
        hint(set_aligned, this::set_aligned, 38);
        hint(set_aligned, this::set_aligned, 52);
        hint(set_aligned, this::set_aligned, 96);
        hint(uctypes_struct_size, this::uctypes_struct_size, 0);
        hint(uctypes_struct_size, this::uctypes_struct_size, 160);
        hint(uctypes_struct_size, this::uctypes_struct_size, 174);
        hint(uctypes_struct_size, this::uctypes_struct_size, 206);
        hint(uctypes_struct_sizeof, this::uctypes_struct_sizeof, 0);
        hint(uctypes_struct_sizeof, this::uctypes_struct_sizeof, 22);
        hint(uctypes_struct_sizeof, this::uctypes_struct_sizeof, 42);
        hint(uctypes_struct_agg_size, this::uctypes_struct_agg_size, 0);
        hint(uctypes_struct_agg_size, this::uctypes_struct_agg_size, 28);
        hint(uctypes_struct_agg_size, this::uctypes_struct_agg_size, 78);
        hint(uctypes_get_buffer, this::uctypes_get_buffer, 0);
        hint(uctypes_get_buffer, this::uctypes_get_buffer, 20);
        hint(uctypes_struct_subscr, this::uctypes_struct_subscr, 0);
        hint(uctypes_struct_subscr, this::uctypes_struct_subscr, 32);
        hint(uctypes_struct_subscr, this::uctypes_struct_subscr, 60);
        hint(uctypes_struct_subscr, this::uctypes_struct_subscr, 64);
        hint(uctypes_struct_subscr, this::uctypes_struct_subscr, 92);
        hint(uctypes_struct_subscr, this::uctypes_struct_subscr, 130);
        hint(uctypes_struct_subscr, this::uctypes_struct_subscr, 158);
        hint(uctypes_struct_subscr, this::uctypes_struct_subscr, 176);
        hint(uctypes_struct_subscr, this::uctypes_struct_subscr, 184);
        hint(uctypes_struct_subscr, this::uctypes_struct_subscr, 240);
        hint(uctypes_struct_subscr, this::uctypes_struct_subscr, 252);
        hint(uctypes_struct_subscr, this::uctypes_struct_subscr, 260);
        hint(uctypes_struct_attr_op, this::uctypes_struct_attr_op, 0);
        hint(uctypes_struct_attr_op, this::uctypes_struct_attr_op, 36);
        hint(uctypes_struct_attr_op, this::uctypes_struct_attr_op, 46);
        hint(uctypes_struct_attr_op, this::uctypes_struct_attr_op, 100);
        hint(uctypes_struct_attr_op, this::uctypes_struct_attr_op, 114);
        hint(uctypes_struct_attr_op, this::uctypes_struct_attr_op, 146);
        hint(uctypes_struct_attr_op, this::uctypes_struct_attr_op, 172);
        hint(uctypes_struct_attr_op, this::uctypes_struct_attr_op, 254);
        hint(uctypes_struct_attr_op, this::uctypes_struct_attr_op, 288);
        hint(uctypes_struct_attr_op, this::uctypes_struct_attr_op, 298);
        hint(uctypes_struct_attr_op, this::uctypes_struct_attr_op, 382);
        hint(uctypes_struct_attr_op, this::uctypes_struct_attr_op, 448);
        hint(uctypes_struct_attr_op, this::uctypes_struct_attr_op, 456);
        hint(uctypes_struct_attr_op, this::uctypes_struct_attr_op, 464);
        hint(uctypes_struct_attr_op, this::uctypes_struct_attr_op, 492);
        hint(uctypes_struct_attr, this::uctypes_struct_attr, 0);
        hint(uctypes_struct_attr, this::uctypes_struct_attr, 14);
        hint(uctypes_struct_attr, this::uctypes_struct_attr, 24);
        hint(ujson_stream_next, this::ujson_stream_next, 0);
        hint(ujson_stream_next, this::ujson_stream_next, 20);
        hint(ujson_stream_next, this::ujson_stream_next, 32);
        hint(mod_ujson_load, this::mod_ujson_load, 0);
        hint(mod_ujson_load, this::mod_ujson_load, 12);
        hint(mod_ujson_load, this::mod_ujson_load, 36);
        hint(mod_ujson_load, this::mod_ujson_load, 46);
        hint(mod_ujson_load, this::mod_ujson_load, 64);
        hint(mod_ujson_load, this::mod_ujson_load, 98);
        hint(mod_ujson_load, this::mod_ujson_load, 134);
        hint(mod_ujson_load, this::mod_ujson_load, 142);
        hint(mod_ujson_load, this::mod_ujson_load, 188);
        hint(mod_ujson_load, this::mod_ujson_load, 198);
        hint(mod_ujson_load, this::mod_ujson_load, 208);
        hint(mod_ujson_load, this::mod_ujson_load, 236);
        hint(mod_ujson_load, this::mod_ujson_load, 258);
        hint(mod_ujson_load, this::mod_ujson_load, 302);
        hint(mod_ujson_load, this::mod_ujson_load, 318);
        hint(mod_ujson_load, this::mod_ujson_load, 328);
        hint(mod_ujson_load, this::mod_ujson_load, 338);
        hint(mod_ujson_load, this::mod_ujson_load, 348);
        hint(mod_ujson_load, this::mod_ujson_load, 366);
        hint(mod_ujson_load, this::mod_ujson_load, 378);
        hint(mod_ujson_load, this::mod_ujson_load, 390);
        hint(mod_ujson_load, this::mod_ujson_load, 404);
        hint(mod_ujson_load, this::mod_ujson_load, 426);
        hint(mod_ujson_load, this::mod_ujson_load, 466);
        hint(mod_ujson_load, this::mod_ujson_load, 504);
        hint(mod_ujson_load, this::mod_ujson_load, 510);
        hint(mod_ujson_load, this::mod_ujson_load, 528);
        hint(mod_ujson_load, this::mod_ujson_load, 554);
        hint(mod_ujson_load, this::mod_ujson_load, 574);
        hint(mod_ujson_load, this::mod_ujson_load, 586);
        hint(mod_ujson_load, this::mod_ujson_load, 596);
        hint(mod_ujson_load, this::mod_ujson_load, 606);
        hint(mod_ujson_load, this::mod_ujson_load, 622);
        hint(mod_ujson_load, this::mod_ujson_load, 634);
        hint(mod_ujson_load, this::mod_ujson_load, 662);
        hint(mod_ujson_load, this::mod_ujson_load, 676);
        hint(mod_ujson_load, this::mod_ujson_load, 684);
        hint(mod_ujson_load, this::mod_ujson_load, 690);
        hint(mod_ujson_load, this::mod_ujson_load, 722);
        hint(mod_ujson_load, this::mod_ujson_load, 734);
        hint(mod_ujson_loads, this::mod_ujson_loads, 0);
        hint(mod_ujson_loads, this::mod_ujson_loads, 10);
        hint(mod_ujson_loads, this::mod_ujson_loads, 46);
        hint(mod_ujson_dump, this::mod_ujson_dump, 0);
        hint(mod_ujson_dump, this::mod_ujson_dump, 14);
        hint(mod_ujson_dump, this::mod_ujson_dump, 30);
        hint(mod_ujson_dumps, this::mod_ujson_dumps, 0);
        hint(mod_ujson_dumps, this::mod_ujson_dumps, 16);
        hint(mod_ujson_dumps, this::mod_ujson_dumps, 26);
        hint(mod_ujson_dumps, this::mod_ujson_dumps, 34);
        hint(match_print, this::match_print, 0);
        hint(match_print, this::match_print, 10);
        hint(re_print, this::re_print, 0);
        hint(re_print, this::re_print, 10);
        hint(_compilecode, this::_compilecode, 0);
        hint(_compilecode, this::_compilecode, 282);
        hint(_compilecode, this::_compilecode, 480);
        hint(_compilecode, this::_compilecode, 604);
        hint(_compilecode, this::_compilecode, 678);
        hint(match_group, this::match_group, 0);
        hint(match_group, this::match_group, 12);
        hint(match_group, this::match_group, 30);
        hint(match_group, this::match_group, 34);
        hint(match_group, this::match_group, 52);
        hint(match_group, this::match_group, 62);
        hint(re1_5_sizecode, this::re1_5_sizecode, 0);
        hint(re1_5_sizecode, this::re1_5_sizecode, 14);
        hint(re1_5_sizecode, this::re1_5_sizecode, 28);
        hint(re1_5_compilecode, this::re1_5_compilecode, 0);
        hint(re1_5_compilecode, this::re1_5_compilecode, 34);
        hint(re1_5_dumpcode, this::re1_5_dumpcode, 0);
        hint(re1_5_dumpcode, this::re1_5_dumpcode, 26);
        hint(re1_5_dumpcode, this::re1_5_dumpcode, 38);
        hint(re1_5_dumpcode, this::re1_5_dumpcode, 82);
        hint(re1_5_dumpcode, this::re1_5_dumpcode, 138);
        hint(re1_5_dumpcode, this::re1_5_dumpcode, 160);
        hint(re1_5_dumpcode, this::re1_5_dumpcode, 190);
        hint(re1_5_dumpcode, this::re1_5_dumpcode, 218);
        hint(re1_5_dumpcode, this::re1_5_dumpcode, 230);
        hint(mod_re_compile, this::mod_re_compile, 0);
        hint(mod_re_compile, this::mod_re_compile, 12);
        hint(mod_re_compile, this::mod_re_compile, 18);
        hint(mod_re_compile, this::mod_re_compile, 28);
        hint(mod_re_compile, this::mod_re_compile, 34);
        hint(mod_re_compile, this::mod_re_compile, 54);
        hint(mod_re_compile, this::mod_re_compile, 66);
        hint(mod_re_compile, this::mod_re_compile, 80);
        hint(_re1_5_classmatch, this::_re1_5_classmatch, 0);
        hint(_re1_5_namedclassmatch, this::_re1_5_namedclassmatch, 0);
        hint(recursiveloop, this::recursiveloop, 0);
        hint(recursiveloop, this::recursiveloop, 16);
        hint(recursiveloop, this::recursiveloop, 72);
        hint(recursiveloop, this::recursiveloop, 138);
        hint(recursiveloop, this::recursiveloop, 164);
        hint(recursiveloop, this::recursiveloop, 202);
        hint(recursiveloop, this::recursiveloop, 254);
        hint(re1_5_recursiveloopprog, this::re1_5_recursiveloopprog, 0);
        hint(re1_5_recursiveloopprog, this::re1_5_recursiveloopprog, 24);
        hint(ure_exec_isra_2, this::ure_exec_isra_2, 0);
        hint(ure_exec_isra_2, this::ure_exec_isra_2, 18);
        hint(ure_exec_isra_2, this::ure_exec_isra_2, 44);
        hint(ure_exec_isra_2, this::ure_exec_isra_2, 62);
        hint(ure_exec_isra_2, this::ure_exec_isra_2, 78);
        hint(ure_exec_isra_2, this::ure_exec_isra_2, 90);
        hint(re_match, this::re_match, 0);
        hint(re_match, this::re_match, 8);
        hint(re_search, this::re_search, 0);
        hint(re_search, this::re_search, 8);
        hint(mod_re_match, this::mod_re_match, 0);
        hint(mod_re_match, this::mod_re_match, 10);
        hint(mod_re_match, this::mod_re_match, 26);
        hint(mod_re_search, this::mod_re_search, 0);
        hint(mod_re_search, this::mod_re_search, 10);
        hint(mod_re_search, this::mod_re_search, 26);
        hint(re_split, this::re_split, 0);
        hint(re_split, this::re_split, 16);
        hint(re_split, this::re_split, 26);
        hint(re_split, this::re_split, 54);
        hint(re_split, this::re_split, 64);
        hint(re_split, this::re_split, 78);
        hint(re_split, this::re_split, 90);
        hint(re_split, this::re_split, 106);
        hint(re_split, this::re_split, 128);
        hint(re_split, this::re_split, 136);
        hint(re_split, this::re_split, 148);
        hint(re_split, this::re_split, 180);
        hint(re_split, this::re_split, 188);
        hint(tinf_build_tree, this::tinf_build_tree, 0);
        hint(read_src_stream, this::read_src_stream, 0);
        hint(read_src_stream, this::read_src_stream, 24);
        hint(read_src_stream, this::read_src_stream, 34);
        hint(read_src_stream, this::read_src_stream, 44);
        hint(read_src_stream, this::read_src_stream, 48);
        hint(uzlib_get_byte, this::uzlib_get_byte, 0);
        hint(uzlib_get_byte, this::uzlib_get_byte, 20);
        hint(tinf_getbit, this::tinf_getbit, 0);
        hint(tinf_getbit, this::tinf_getbit, 18);
        hint(tinf_read_bits, this::tinf_read_bits, 0);
        hint(tinf_read_bits, this::tinf_read_bits, 34);
        hint(tinf_decode_symbol, this::tinf_decode_symbol, 0);
        hint(tinf_decode_symbol, this::tinf_decode_symbol, 18);
        hint(tinf_decode_trees, this::tinf_decode_trees, 0);
        hint(tinf_decode_trees, this::tinf_decode_trees, 20);
        hint(tinf_decode_trees, this::tinf_decode_trees, 32);
        hint(tinf_decode_trees, this::tinf_decode_trees, 44);
        hint(tinf_decode_trees, this::tinf_decode_trees, 76);
        hint(tinf_decode_trees, this::tinf_decode_trees, 98);
        hint(tinf_decode_trees, this::tinf_decode_trees, 114);
        hint(tinf_decode_trees, this::tinf_decode_trees, 128);
        hint(tinf_decode_trees, this::tinf_decode_trees, 148);
        hint(tinf_decode_trees, this::tinf_decode_trees, 180);
        hint(tinf_decode_trees, this::tinf_decode_trees, 208);
        hint(tinf_decode_trees, this::tinf_decode_trees, 236);
        hint(tinf_get_le_uint32, this::tinf_get_le_uint32, 0);
        hint(tinf_get_le_uint32, this::tinf_get_le_uint32, 24);
        hint(tinf_get_be_uint32, this::tinf_get_be_uint32, 0);
        hint(tinf_get_be_uint32, this::tinf_get_be_uint32, 24);
        hint(uzlib_uncompress, this::uzlib_uncompress, 0);
        hint(uzlib_uncompress, this::uzlib_uncompress, 22);
        hint(uzlib_uncompress, this::uzlib_uncompress, 34);
        hint(uzlib_uncompress, this::uzlib_uncompress, 258);
        hint(uzlib_uncompress, this::uzlib_uncompress, 292);
        hint(uzlib_uncompress, this::uzlib_uncompress, 324);
        hint(uzlib_uncompress, this::uzlib_uncompress, 332);
        hint(uzlib_uncompress, this::uzlib_uncompress, 340);
        hint(uzlib_uncompress, this::uzlib_uncompress, 350);
    }

    private void gen_hints_11() {
        hint(uzlib_uncompress, this::uzlib_uncompress, 386);
        hint(uzlib_uncompress, this::uzlib_uncompress, 458);
        hint(uzlib_uncompress, this::uzlib_uncompress, 472);
        hint(uzlib_uncompress, this::uzlib_uncompress, 488);
        hint(uzlib_zlib_parse_header, this::uzlib_zlib_parse_header, 0);
        hint(uzlib_zlib_parse_header, this::uzlib_zlib_parse_header, 8);
        hint(uzlib_zlib_parse_header, this::uzlib_zlib_parse_header, 16);
        hint(uzlib_zlib_parse_header, this::uzlib_zlib_parse_header, 28);
        hint(tinf_skip_bytes, this::tinf_skip_bytes, 0);
        hint(tinf_skip_bytes, this::tinf_skip_bytes, 18);
        hint(tinf_get_uint16, this::tinf_get_uint16, 0);
        hint(tinf_get_uint16, this::tinf_get_uint16, 8);
        hint(tinf_get_uint16, this::tinf_get_uint16, 16);
        hint(uzlib_gzip_parse_header, this::uzlib_gzip_parse_header, 0);
        hint(uzlib_gzip_parse_header, this::uzlib_gzip_parse_header, 8);
        hint(uzlib_gzip_parse_header, this::uzlib_gzip_parse_header, 26);
        hint(uzlib_gzip_parse_header, this::uzlib_gzip_parse_header, 36);
        hint(uzlib_gzip_parse_header, this::uzlib_gzip_parse_header, 46);
        hint(uzlib_gzip_parse_header, this::uzlib_gzip_parse_header, 66);
        hint(uzlib_gzip_parse_header, this::uzlib_gzip_parse_header, 76);
        hint(uzlib_gzip_parse_header, this::uzlib_gzip_parse_header, 84);
        hint(uzlib_gzip_parse_header, this::uzlib_gzip_parse_header, 94);
        hint(uzlib_gzip_parse_header, this::uzlib_gzip_parse_header, 108);
        hint(uzlib_gzip_parse_header, this::uzlib_gzip_parse_header, 124);
        hint(decompio_make_new, this::decompio_make_new, 0);
        hint(decompio_make_new, this::decompio_make_new, 26);
        hint(decompio_make_new, this::decompio_make_new, 34);
        hint(decompio_make_new, this::decompio_make_new, 42);
        hint(decompio_make_new, this::decompio_make_new, 60);
        hint(decompio_make_new, this::decompio_make_new, 84);
        hint(decompio_make_new, this::decompio_make_new, 94);
        hint(decompio_make_new, this::decompio_make_new, 100);
        hint(decompio_make_new, this::decompio_make_new, 112);
        hint(decompio_make_new, this::decompio_make_new, 142);
        hint(uzlib_adler32, this::uzlib_adler32, 0);
        hint(uzlib_adler32, this::uzlib_adler32, 66);
        hint(uzlib_adler32, this::uzlib_adler32, 76);
        hint(uzlib_crc32, this::uzlib_crc32, 0);
        hint(uzlib_uncompress_chksum, this::uzlib_uncompress_chksum, 0);
        hint(uzlib_uncompress_chksum, this::uzlib_uncompress_chksum, 10);
        hint(uzlib_uncompress_chksum, this::uzlib_uncompress_chksum, 42);
        hint(uzlib_uncompress_chksum, this::uzlib_uncompress_chksum, 54);
        hint(uzlib_uncompress_chksum, this::uzlib_uncompress_chksum, 78);
        hint(uzlib_uncompress_chksum, this::uzlib_uncompress_chksum, 90);
        hint(uzlib_uncompress_chksum, this::uzlib_uncompress_chksum, 104);
        hint(decompio_read, this::decompio_read, 0);
        hint(decompio_read, this::decompio_read, 30);
        hint(mod_uzlib_decompress, this::mod_uzlib_decompress, 0);
        hint(mod_uzlib_decompress, this::mod_uzlib_decompress, 18);
        hint(mod_uzlib_decompress, this::mod_uzlib_decompress, 24);
        hint(mod_uzlib_decompress, this::mod_uzlib_decompress, 34);
        hint(mod_uzlib_decompress, this::mod_uzlib_decompress, 54);
        hint(mod_uzlib_decompress, this::mod_uzlib_decompress, 82);
        hint(mod_uzlib_decompress, this::mod_uzlib_decompress, 92);
        hint(mod_uzlib_decompress, this::mod_uzlib_decompress, 120);
        hint(mod_uzlib_decompress, this::mod_uzlib_decompress, 148);
        hint(mod_uzlib_decompress, this::mod_uzlib_decompress, 152);
        hint(mod_uzlib_decompress, this::mod_uzlib_decompress, 162);
        hint(mod_uzlib_decompress, this::mod_uzlib_decompress, 170);
        hint(mod_uzlib_decompress, this::mod_uzlib_decompress, 180);
        hint(get_heap, this::get_heap, 0);
        hint(get_heap, this::get_heap, 20);
        hint(heap_siftdown_isra_0, this::heap_siftdown_isra_0, 0);
        hint(heap_siftdown_isra_0, this::heap_siftdown_isra_0, 44);
        hint(heap_siftup, this::heap_siftup, 0);
        hint(heap_siftup, this::heap_siftup, 54);
        hint(heap_siftup, this::heap_siftup, 80);
        hint(mod_uheapq_heapify, this::mod_uheapq_heapify, 0);
        hint(mod_uheapq_heapify, this::mod_uheapq_heapify, 6);
        hint(mod_uheapq_heapify, this::mod_uheapq_heapify, 30);
        hint(mod_uheapq_heappush, this::mod_uheapq_heappush, 0);
        hint(mod_uheapq_heappush, this::mod_uheapq_heappush, 10);
        hint(mod_uheapq_heappush, this::mod_uheapq_heappush, 20);
        hint(mod_uheapq_heappush, this::mod_uheapq_heappush, 34);
        hint(mod_uheapq_heappop, this::mod_uheapq_heappop, 0);
        hint(mod_uheapq_heappop, this::mod_uheapq_heappop, 6);
        hint(mod_uheapq_heappop, this::mod_uheapq_heappop, 20);
        hint(mod_uheapq_heappop, this::mod_uheapq_heappop, 24);
        hint(mod_uheapq_heappop, this::mod_uheapq_heappop, 52);
        hint(utimeq_unary_op, this::utimeq_unary_op, 0);
        hint(utimeq_make_new, this::utimeq_make_new, 0);
        hint(utimeq_make_new, this::utimeq_make_new, 24);
        hint(utimeq_make_new, this::utimeq_make_new, 30);
        hint(utimeq_make_new, this::utimeq_make_new, 42);
        hint(utimeq_make_new, this::utimeq_make_new, 58);
        hint(mod_utimeq_peektime, this::mod_utimeq_peektime, 0);
        hint(mod_utimeq_peektime, this::mod_utimeq_peektime, 16);
        hint(mod_utimeq_peektime, this::mod_utimeq_peektime, 20);
        hint(heap_siftdown_constprop_3, this::heap_siftdown_constprop_3, 0);
        hint(mod_utimeq_heappop, this::mod_utimeq_heappop, 0);
        hint(mod_utimeq_heappop, this::mod_utimeq_heappop, 20);
        hint(mod_utimeq_heappop, this::mod_utimeq_heappop, 24);
        hint(mod_utimeq_heappop, this::mod_utimeq_heappop, 50);
        hint(mod_utimeq_heappop, this::mod_utimeq_heappop, 158);
        hint(mod_utimeq_heappush, this::mod_utimeq_heappush, 0);
        hint(mod_utimeq_heappush, this::mod_utimeq_heappush, 22);
        hint(mod_utimeq_heappush, this::mod_utimeq_heappush, 56);
        hint(sha256_transform, this::sha256_transform, 0);
        hint(sha256_init, this::sha256_init, 0);
        hint(sha256_update, this::sha256_update, 0);
        hint(sha256_update, this::sha256_update, 46);
        hint(uhashlib_sha256_update, this::uhashlib_sha256_update, 0);
        hint(uhashlib_sha256_update, this::uhashlib_sha256_update, 14);
        hint(uhashlib_sha256_update, this::uhashlib_sha256_update, 24);
        hint(uhashlib_sha256_make_new, this::uhashlib_sha256_make_new, 0);
        hint(uhashlib_sha256_make_new, this::uhashlib_sha256_make_new, 22);
        hint(uhashlib_sha256_make_new, this::uhashlib_sha256_make_new, 28);
        hint(uhashlib_sha256_make_new, this::uhashlib_sha256_make_new, 36);
        hint(uhashlib_sha256_make_new, this::uhashlib_sha256_make_new, 48);
        hint(sha256_final, this::sha256_final, 0);
        hint(sha256_final, this::sha256_final, 104);
        hint(sha256_final, this::sha256_final, 186);
        hint(sha256_final, this::sha256_final, 196);
        hint(uhashlib_sha256_digest, this::uhashlib_sha256_digest, 0);
        hint(uhashlib_sha256_digest, this::uhashlib_sha256_digest, 12);
        hint(uhashlib_sha256_digest, this::uhashlib_sha256_digest, 20);
        hint(uhashlib_sha256_digest, this::uhashlib_sha256_digest, 28);
        hint(mod_binascii_hexlify, this::mod_binascii_hexlify, 0);
        hint(mod_binascii_hexlify, this::mod_binascii_hexlify, 18);
        hint(mod_binascii_hexlify, this::mod_binascii_hexlify, 44);
        hint(mod_binascii_hexlify, this::mod_binascii_hexlify, 56);
        hint(mod_binascii_hexlify, this::mod_binascii_hexlify, 74);
        hint(mod_binascii_b2a_base64, this::mod_binascii_b2a_base64, 0);
        hint(mod_binascii_b2a_base64, this::mod_binascii_b2a_base64, 12);
        hint(mod_binascii_b2a_base64, this::mod_binascii_b2a_base64, 28);
        hint(mod_binascii_b2a_base64, this::mod_binascii_b2a_base64, 44);
        hint(mod_binascii_b2a_base64, this::mod_binascii_b2a_base64, 132);
        hint(mod_binascii_unhexlify, this::mod_binascii_unhexlify, 0);
        hint(mod_binascii_unhexlify, this::mod_binascii_unhexlify, 12);
        hint(mod_binascii_unhexlify, this::mod_binascii_unhexlify, 32);
        hint(mod_binascii_unhexlify, this::mod_binascii_unhexlify, 56);
        hint(mod_binascii_unhexlify, this::mod_binascii_unhexlify, 70);
        hint(mod_binascii_unhexlify, this::mod_binascii_unhexlify, 80);
        hint(mod_binascii_unhexlify, this::mod_binascii_unhexlify, 118);
        hint(mod_binascii_a2b_base64, this::mod_binascii_a2b_base64, 0);
        hint(mod_binascii_a2b_base64, this::mod_binascii_a2b_base64, 12);
        hint(mod_binascii_a2b_base64, this::mod_binascii_a2b_base64, 32);
        hint(mod_binascii_a2b_base64, this::mod_binascii_a2b_base64, 64);
        hint(mod_binascii_a2b_base64, this::mod_binascii_a2b_base64, 184);
        hint(mod_binascii_crc32, this::mod_binascii_crc32, 0);
        hint(mod_binascii_crc32, this::mod_binascii_crc32, 18);
        hint(mod_binascii_crc32, this::mod_binascii_crc32, 30);
        hint(mod_binascii_crc32, this::mod_binascii_crc32, 40);
        hint(mod_binascii_crc32, this::mod_binascii_crc32, 46);
        hint(machine_mem_get_addr, this::machine_mem_get_addr, 0);
        hint(machine_mem_get_addr, this::machine_mem_get_addr, 8);
        hint(machine_mem_get_addr, this::machine_mem_get_addr, 26);
        hint(machine_mem_get_addr, this::machine_mem_get_addr, 30);
        hint(machine_mem_print, this::machine_mem_print, 0);
        hint(machine_mem_print, this::machine_mem_print, 12);
        hint(machine_mem_subscr, this::machine_mem_subscr, 0);
        hint(machine_mem_subscr, this::machine_mem_subscr, 24);
        hint(machine_mem_subscr, this::machine_mem_subscr, 44);
        hint(machine_mem_subscr, this::machine_mem_subscr, 54);
        hint(machine_mem_subscr, this::machine_mem_subscr, 62);
        hint(yasmarang, this::yasmarang, 0);
        hint(yasmarang_randbelow, this::yasmarang_randbelow, 0);
        hint(yasmarang_randbelow, this::yasmarang_randbelow, 20);
        hint(mod_urandom_uniform, this::mod_urandom_uniform, 0);
        hint(mod_urandom_uniform, this::mod_urandom_uniform, 8);
        hint(mod_urandom_uniform, this::mod_urandom_uniform, 16);
        hint(mod_urandom_uniform, this::mod_urandom_uniform, 22);
        hint(mod_urandom_uniform, this::mod_urandom_uniform, 28);
        hint(mod_urandom_uniform, this::mod_urandom_uniform, 46);
        hint(mod_urandom_uniform, this::mod_urandom_uniform, 54);
        hint(mod_urandom_uniform, this::mod_urandom_uniform, 60);
        hint(mod_urandom_uniform, this::mod_urandom_uniform, 64);
        hint(mod_urandom_randint, this::mod_urandom_randint, 0);
        hint(mod_urandom_randint, this::mod_urandom_randint, 8);
        hint(mod_urandom_randint, this::mod_urandom_randint, 16);
        hint(mod_urandom_randint, this::mod_urandom_randint, 26);
        hint(mod_urandom_randint, this::mod_urandom_randint, 34);
        hint(mod_urandom_randint, this::mod_urandom_randint, 40);
        hint(mod_urandom_randrange, this::mod_urandom_randrange, 0);
        hint(mod_urandom_randrange, this::mod_urandom_randrange, 12);
        hint(mod_urandom_randrange, this::mod_urandom_randrange, 26);
        hint(mod_urandom_randrange, this::mod_urandom_randrange, 30);
        hint(mod_urandom_randrange, this::mod_urandom_randrange, 38);
        hint(mod_urandom_randrange, this::mod_urandom_randrange, 54);
        hint(mod_urandom_randrange, this::mod_urandom_randrange, 64);
        hint(mod_urandom_randrange, this::mod_urandom_randrange, 78);
        hint(mod_urandom_randrange, this::mod_urandom_randrange, 86);
        hint(mod_urandom_randrange, this::mod_urandom_randrange, 106);
        hint(mod_urandom_seed, this::mod_urandom_seed, 0);
        hint(mod_urandom_seed, this::mod_urandom_seed, 6);
        hint(mod_urandom_getrandbits, this::mod_urandom_getrandbits, 0);
        hint(mod_urandom_getrandbits, this::mod_urandom_getrandbits, 6);
        hint(mod_urandom_getrandbits, this::mod_urandom_getrandbits, 22);
        hint(mod_urandom_getrandbits, this::mod_urandom_getrandbits, 26);
        hint(mod_urandom_getrandbits, this::mod_urandom_getrandbits, 42);
        hint(mod_urandom_choice, this::mod_urandom_choice, 0);
        hint(mod_urandom_choice, this::mod_urandom_choice, 8);
        hint(mod_urandom_choice, this::mod_urandom_choice, 12);
        hint(mod_urandom_choice, this::mod_urandom_choice, 22);
        hint(mod_urandom_choice, this::mod_urandom_choice, 26);
        hint(mod_urandom_choice, this::mod_urandom_choice, 30);
        hint(mod_urandom_choice, this::mod_urandom_choice, 34);
        hint(mod_urandom_choice, this::mod_urandom_choice, 44);
        hint(mod_urandom_random, this::mod_urandom_random, 0);
        hint(mod_urandom_random, this::mod_urandom_random, 6);
        hint(mod_urandom_random, this::mod_urandom_random, 24);
        hint(mod_urandom_random, this::mod_urandom_random, 28);
        hint(mp_vfs_proxy_call, this::mp_vfs_proxy_call, 0);
        hint(mp_vfs_proxy_call, this::mp_vfs_proxy_call, 18);
        hint(mp_vfs_proxy_call, this::mp_vfs_proxy_call, 34);
        hint(mp_vfs_proxy_call, this::mp_vfs_proxy_call, 48);
        hint(mp_vfs_proxy_call, this::mp_vfs_proxy_call, 58);
        hint(mp_vfs_umount, this::mp_vfs_umount, 0);
        hint(mp_vfs_umount, this::mp_vfs_umount, 36);
        hint(mp_vfs_umount, this::mp_vfs_umount, 66);
        hint(mp_vfs_umount, this::mp_vfs_umount, 80);
        hint(mp_vfs_umount, this::mp_vfs_umount, 124);
        hint(mp_vfs_getcwd, this::mp_vfs_getcwd, 0);
        hint(mp_vfs_getcwd, this::mp_vfs_getcwd, 26);
        hint(mp_vfs_getcwd, this::mp_vfs_getcwd, 38);
        hint(mp_vfs_getcwd, this::mp_vfs_getcwd, 44);
        hint(mp_vfs_getcwd, this::mp_vfs_getcwd, 58);
        hint(mp_vfs_getcwd, this::mp_vfs_getcwd, 68);
        hint(mp_vfs_getcwd, this::mp_vfs_getcwd, 88);
        hint(mp_vfs_getcwd, this::mp_vfs_getcwd, 96);
        hint(mp_vfs_ilistdir_it_iternext, this::mp_vfs_ilistdir_it_iternext, 0);
        hint(mp_vfs_ilistdir_it_iternext, this::mp_vfs_ilistdir_it_iternext, 46);
        hint(mp_vfs_ilistdir_it_iternext, this::mp_vfs_ilistdir_it_iternext, 52);
        hint(mp_vfs_ilistdir_it_iternext, this::mp_vfs_ilistdir_it_iternext, 64);
        hint(mp_vfs_ilistdir_it_iternext, this::mp_vfs_ilistdir_it_iternext, 88);
        hint(mp_vfs_lookup_path, this::mp_vfs_lookup_path, 0);
        hint(mp_vfs_lookup_path, this::mp_vfs_lookup_path, 100);
        hint(mp_vfs_mount, this::mp_vfs_mount, 0);
        hint(mp_vfs_mount, this::mp_vfs_mount, 24);
        hint(mp_vfs_mount, this::mp_vfs_mount, 32);
        hint(mp_vfs_mount, this::mp_vfs_mount, 48);
        hint(mp_vfs_mount, this::mp_vfs_mount, 54);
        hint(mp_vfs_mount, this::mp_vfs_mount, 82);
        hint(mp_vfs_mount, this::mp_vfs_mount, 88);
        hint(mp_vfs_mount, this::mp_vfs_mount, 94);
        hint(mp_vfs_mount, this::mp_vfs_mount, 118);
        hint(lookup_path, this::lookup_path, 0);
        hint(lookup_path, this::lookup_path, 10);
        hint(lookup_path, this::lookup_path, 16);
        hint(lookup_path, this::lookup_path, 28);
        hint(lookup_path, this::lookup_path, 38);
        hint(lookup_path, this::lookup_path, 48);
        hint(mp_vfs_open, this::mp_vfs_open, 0);
        hint(mp_vfs_open, this::mp_vfs_open, 18);
        hint(mp_vfs_open, this::mp_vfs_open, 26);
        hint(mp_vfs_open, this::mp_vfs_open, 38);
        hint(mp_vfs_chdir, this::mp_vfs_chdir, 0);
        hint(mp_vfs_chdir, this::mp_vfs_chdir, 8);
        hint(mp_vfs_chdir, this::mp_vfs_chdir, 52);
        hint(mp_vfs_ilistdir, this::mp_vfs_ilistdir, 0);
        hint(mp_vfs_ilistdir, this::mp_vfs_ilistdir, 18);
        hint(mp_vfs_ilistdir, this::mp_vfs_ilistdir, 28);
        hint(mp_vfs_ilistdir, this::mp_vfs_ilistdir, 54);
        hint(mp_vfs_ilistdir, this::mp_vfs_ilistdir, 82);
        hint(mp_vfs_listdir, this::mp_vfs_listdir, 0);
        hint(mp_vfs_listdir, this::mp_vfs_listdir, 6);
        hint(mp_vfs_listdir, this::mp_vfs_listdir, 16);
        hint(mp_vfs_listdir, this::mp_vfs_listdir, 24);
        hint(mp_vfs_listdir, this::mp_vfs_listdir, 40);
        hint(mp_vfs_listdir, this::mp_vfs_listdir, 48);
        hint(mp_vfs_mkdir, this::mp_vfs_mkdir, 0);
        hint(mp_vfs_mkdir, this::mp_vfs_mkdir, 8);
        hint(mp_vfs_mkdir, this::mp_vfs_mkdir, 18);
        hint(mp_vfs_mkdir, this::mp_vfs_mkdir, 28);
        hint(mp_vfs_mkdir, this::mp_vfs_mkdir, 34);
        hint(mp_vfs_mkdir, this::mp_vfs_mkdir, 52);
        hint(mp_vfs_remove, this::mp_vfs_remove, 0);
        hint(mp_vfs_remove, this::mp_vfs_remove, 8);
        hint(mp_vfs_remove, this::mp_vfs_remove, 20);
        hint(mp_vfs_rename, this::mp_vfs_rename, 0);
        hint(mp_vfs_rename, this::mp_vfs_rename, 10);
        hint(mp_vfs_rename, this::mp_vfs_rename, 20);
        hint(mp_vfs_rename, this::mp_vfs_rename, 30);
        hint(mp_vfs_rename, this::mp_vfs_rename, 44);
        hint(mp_vfs_rmdir, this::mp_vfs_rmdir, 0);
        hint(mp_vfs_rmdir, this::mp_vfs_rmdir, 8);
        hint(mp_vfs_rmdir, this::mp_vfs_rmdir, 20);
        hint(mp_vfs_stat, this::mp_vfs_stat, 0);
        hint(mp_vfs_stat, this::mp_vfs_stat, 8);
        hint(mp_vfs_stat, this::mp_vfs_stat, 20);
        hint(mp_vfs_stat, this::mp_vfs_stat, 54);
        hint(mp_vfs_statvfs, this::mp_vfs_statvfs, 0);
        hint(mp_vfs_statvfs, this::mp_vfs_statvfs, 8);
        hint(mp_vfs_statvfs, this::mp_vfs_statvfs, 32);
        hint(mp_vfs_statvfs, this::mp_vfs_statvfs, 82);
        hint(mp_vfs_import_stat, this::mp_vfs_import_stat, 0);
        hint(mp_vfs_import_stat, this::mp_vfs_import_stat, 10);
        hint(mp_vfs_import_stat, this::mp_vfs_import_stat, 28);
        hint(mp_vfs_import_stat, this::mp_vfs_import_stat, 42);
        hint(mp_vfs_import_stat, this::mp_vfs_import_stat, 52);
        hint(mp_vfs_import_stat, this::mp_vfs_import_stat, 60);
        hint(mp_vfs_import_stat, this::mp_vfs_import_stat, 68);
        hint(mp_vfs_import_stat, this::mp_vfs_import_stat, 86);
        hint(mp_vfs_import_stat, this::mp_vfs_import_stat, 92);
        hint(mp_vfs_import_stat, this::mp_vfs_import_stat, 102);
        hint(mp_vfs_import_stat, this::mp_vfs_import_stat, 110);
        hint(mp_reader_vfs_close, this::mp_reader_vfs_close, 0);
        hint(mp_reader_vfs_close, this::mp_reader_vfs_close, 10);
        hint(mp_reader_vfs_close, this::mp_reader_vfs_close, 18);
        hint(mp_reader_vfs_readbyte, this::mp_reader_vfs_readbyte, 0);
        hint(mp_reader_vfs_readbyte, this::mp_reader_vfs_readbyte, 34);
        hint(mp_reader_new_file, this::mp_reader_new_file, 0);
        hint(mp_reader_new_file, this::mp_reader_new_file, 12);
        hint(mp_reader_new_file, this::mp_reader_new_file, 20);
        hint(mp_reader_new_file, this::mp_reader_new_file, 28);
        hint(mp_reader_new_file, this::mp_reader_new_file, 40);
        hint(mp_reader_new_file, this::mp_reader_new_file, 58);
        hint(mp_reader_new_file, this::mp_reader_new_file, 70);
        hint(time_ticks_diff, this::time_ticks_diff, 0);
        hint(time_sleep, this::time_sleep, 0);
        hint(time_sleep, this::time_sleep, 6);
        hint(time_sleep, this::time_sleep, 12);
        hint(time_sleep, this::time_sleep, 16);
        hint(time_sleep, this::time_sleep, 20);
        hint(time_sleep_ms, this::time_sleep_ms, 0);
        hint(time_sleep_ms, this::time_sleep_ms, 6);
        hint(time_sleep_ms, this::time_sleep_ms, 14);
        hint(time_ticks_add, this::time_ticks_add, 0);
        hint(time_ticks_add, this::time_ticks_add, 10);
        hint(time_ticks_ms, this::time_ticks_ms, 0);
        hint(time_ticks_ms, this::time_ticks_ms, 6);
        hint(time_ticks_cpu, this::time_ticks_cpu, 0);
        hint(time_ticks_cpu, this::time_ticks_cpu, 6);
        hint(strn_print_strn, this::strn_print_strn, 0);
        hint(strn_print_strn, this::strn_print_strn, 20);
        hint(printf, this::printf, 0);
        hint(printf, this::printf, 16);
        hint(putchar, this::putchar, 0);
        hint(putchar, this::putchar, 16);
        hint(puts, this::puts, 0);
        hint(puts, this::puts, 8);
        hint(puts, this::puts, 16);
        hint(puts, this::puts, 30);
        hint(vsnprintf, this::vsnprintf, 0);
        hint(vsnprintf, this::vsnprintf, 26);
        hint(snprintf, this::snprintf, 0);
        hint(snprintf, this::snprintf, 14);
        hint(main, this::main, 0);
        hint(main, this::main, 10);
        hint(main, this::main, 22);
        hint(main, this::main, 36);
        hint(main, this::main, 44);
        hint(main, this::main, 52);
        hint(main, this::main, 56);
        hint(main, this::main, 66);
        hint(main, this::main, 74);
        hint(main, this::main, 82);
        hint(main, this::main, 88);
        hint(main, this::main, 104);
        hint(main, this::main, 120);
        hint(main, this::main, 132);
        hint(main, this::main, 142);
        hint(main, this::main, 146);
        hint(Signal_Handler, this::Signal_Handler, 0);
        hint(Signal_Handler, this::Signal_Handler, 10);
        hint(Signal_Handler, this::Signal_Handler, 16);
        hint(Signal_Handler, this::Signal_Handler, 26);
        hint(_exit, this::_exit, 0);
        hint(_exit, this::_exit, 10);
        hint(_start, this::_start, 0);
        hint(_start, this::_start, 10);
        hint(_start, this::_start, 14);
        hint(Reset_Handler, this::Reset_Handler, 0);
        hint(Reset_Handler, this::Reset_Handler, 48);
        hint(__fatal_error, this::__fatal_error, 0);
        hint(__fatal_error, this::__fatal_error, 12);
        hint(nlr_jump_fail, this::nlr_jump_fail, 0);
        hint(nlr_jump_fail, this::nlr_jump_fail, 8);
        hint(mp_hal_stdin_rx_chr, this::mp_hal_stdin_rx_chr, 0);
        hint(mp_hal_stdin_rx_chr, this::mp_hal_stdin_rx_chr, 6);
        hint(mp_hal_stdout_tx_strn, this::mp_hal_stdout_tx_strn, 0);
        hint(mp_hal_stdout_tx_strn, this::mp_hal_stdout_tx_strn, 6);
        hint(mp_hal_stdout_tx_strn, this::mp_hal_stdout_tx_strn, 16);
        hint(mp_hal_stdout_tx_strn, this::mp_hal_stdout_tx_strn, 22);
        hint(mp_hal_delay_ms, this::mp_hal_delay_ms, 0);
        hint(mp_hal_delay_ms, this::mp_hal_delay_ms, 24);
        hint(mp_hal_ticks_ms, this::mp_hal_ticks_ms, 0);
        hint(mp_hal_ticks_cpu, this::mp_hal_ticks_cpu, 0);
        hint(usystem_print_hook, this::usystem_print_hook, 0);
        hint(usystem_debug, this::usystem_debug, 0);
        hint(usystem_debug, this::usystem_debug, 12);
        hint(usystem_debug, this::usystem_debug, 22);
        hint(usystem_set_stdin_char, this::usystem_set_stdin_char, 0);
        hint(usystem_set_stdin_char, this::usystem_set_stdin_char, 24);
        hint(parse_2, this::parse_2, 0);
        hint(parse_2, this::parse_2, 16);
        hint(parse_2, this::parse_2, 22);
        hint(usystem_syscall, this::usystem_syscall, 0);
        hint(usystem_syscall, this::usystem_syscall, 12);
        hint(usystem_syscall, this::usystem_syscall, 22);
        hint(usystem_syscall, this::usystem_syscall, 28);
        hint(usystem_signal, this::usystem_signal, 0);
        hint(usystem_signal, this::usystem_signal, 12);
        hint(usystem_signal, this::usystem_signal, 18);
        hint(usystem_components, this::usystem_components, 0);
        hint(usystem_components, this::usystem_components, 12);
        hint(usystem_components, this::usystem_components, 18);
        hint(usystem_methods, this::usystem_methods, 0);
        hint(usystem_methods, this::usystem_methods, 12);
        hint(usystem_methods, this::usystem_methods, 26);
        hint(usystem_methods, this::usystem_methods, 32);
        hint(usystem_annotations, this::usystem_annotations, 0);
        hint(usystem_annotations, this::usystem_annotations, 12);
        hint(usystem_annotations, this::usystem_annotations, 24);
        hint(usystem_annotations, this::usystem_annotations, 30);
        hint(usystem_get_stdout_str, this::usystem_get_stdout_str, 0);
        hint(usystem_get_stdout_str, this::usystem_get_stdout_str, 12);
        hint(usystem_get_stdout_str, this::usystem_get_stdout_str, 18);
        hint(gc_collect, this::gc_collect, 0);
        hint(gc_collect, this::gc_collect, 8);
        hint(gc_collect, this::gc_collect, 14);
        hint(gc_collect, this::gc_collect, 24);
        hint(gc_collect, this::gc_collect, 28);
        hint(vfs_openpie_file___exit__, this::vfs_openpie_file___exit__, 0);
        hint(vfs_openpie_file___exit__, this::vfs_openpie_file___exit__, 8);
        hint(vfs_openpie_file_print, this::vfs_openpie_file_print, 0);
        hint(vfs_openpie_file_print, this::vfs_openpie_file_print, 12);
        hint(vfs_openpie_file_print, this::vfs_openpie_file_print, 24);
        hint(unlikely_check_fd_is_open_isra_0_part_1, this::unlikely_check_fd_is_open_isra_0_part_1, 0);
        hint(unlikely_check_fd_is_open_isra_0_part_1, this::unlikely_check_fd_is_open_isra_0_part_1, 10);
        hint(unlikely_check_fd_is_open_isra_0_part_1, this::unlikely_check_fd_is_open_isra_0_part_1, 14);
        hint(vfs_openpie_file_fileno, this::vfs_openpie_file_fileno, 0);
        hint(vfs_openpie_file_fileno, this::vfs_openpie_file_fileno, 12);
        hint(vfs_openpie_file_fileno, this::vfs_openpie_file_fileno, 16);
        hint(SVC_CALL_VFS, this::SVC_CALL_VFS, 0);
        hint(SVC_CALL_VFS, this::SVC_CALL_VFS, 10);
        hint(SVC_CALL_VFS_OUT, this::SVC_CALL_VFS_OUT, 0);
        hint(SVC_CALL_VFS_OUT, this::SVC_CALL_VFS_OUT, 12);
        hint(vfs_openpie_file_ioctl, this::vfs_openpie_file_ioctl, 0);
        hint(vfs_openpie_file_ioctl, this::vfs_openpie_file_ioctl, 20);
        hint(vfs_openpie_file_ioctl, this::vfs_openpie_file_ioctl, 42);
        hint(vfs_openpie_file_ioctl, this::vfs_openpie_file_ioctl, 76);
        hint(vfs_openpie_file_ioctl, this::vfs_openpie_file_ioctl, 102);
        hint(vfs_openpie_file_write, this::vfs_openpie_file_write, 0);
        hint(vfs_openpie_file_write, this::vfs_openpie_file_write, 18);
        hint(vfs_openpie_file_write, this::vfs_openpie_file_write, 36);
        hint(vfs_openpie_file_read, this::vfs_openpie_file_read, 0);
        hint(vfs_openpie_file_read, this::vfs_openpie_file_read, 18);
        hint(vfs_openpie_file_read, this::vfs_openpie_file_read, 34);
        hint(mp_vfs_openpie_file_open, this::mp_vfs_openpie_file_open, 0);
        hint(mp_vfs_openpie_file_open, this::mp_vfs_openpie_file_open, 18);
        hint(mp_vfs_openpie_file_open, this::mp_vfs_openpie_file_open, 26);
        hint(mp_vfs_openpie_file_open, this::mp_vfs_openpie_file_open, 34);
        hint(mp_vfs_openpie_file_open, this::mp_vfs_openpie_file_open, 42);
        hint(mp_vfs_openpie_file_open, this::mp_vfs_openpie_file_open, 68);
        hint(mp_vfs_openpie_file_open, this::mp_vfs_openpie_file_open, 76);
        hint(mp_vfs_openpie_file_open, this::mp_vfs_openpie_file_open, 86);
        hint(vfs_openpie_file_make_new, this::vfs_openpie_file_make_new, 0);
        hint(vfs_openpie_file_make_new, this::vfs_openpie_file_make_new, 26);
        hint(vfs_openpie_file_make_new, this::vfs_openpie_file_make_new, 38);
        hint(gc_helper_get_regs_and_sp, this::gc_helper_get_regs_and_sp, 0);
        hint(stdio_obj___exit__, this::stdio_obj___exit__, 0);
        hint(stdio_obj_print, this::stdio_obj_print, 0);
        hint(stdio_obj_print, this::stdio_obj_print, 10);
        hint(stdio_buffer_write, this::stdio_buffer_write, 0);
        hint(stdio_buffer_write, this::stdio_buffer_write, 12);
        hint(stdio_buffer_read, this::stdio_buffer_read, 0);
        hint(stdio_buffer_read, this::stdio_buffer_read, 20);
        hint(stdio_write, this::stdio_write, 0);
        hint(stdio_write, this::stdio_write, 22);
        hint(stdio_read, this::stdio_read, 0);
        hint(stdio_read, this::stdio_read, 28);
        hint(mp_hal_stdout_tx_strn_cooked, this::mp_hal_stdout_tx_strn_cooked, 0);
        hint(mp_hal_stdout_tx_strn_cooked, this::mp_hal_stdout_tx_strn_cooked, 26);
        hint(mp_hal_stdout_tx_strn_cooked, this::mp_hal_stdout_tx_strn_cooked, 36);
        hint(mp_hal_stdout_tx_str, this::mp_hal_stdout_tx_str, 0);
        hint(mp_hal_stdout_tx_str, this::mp_hal_stdout_tx_str, 8);
        hint(mp_hal_stdout_tx_str, this::mp_hal_stdout_tx_str, 16);
        hint(mp_hal_set_interrupt_char, this::mp_hal_set_interrupt_char, 0);
        hint(mp_hal_set_interrupt_char, this::mp_hal_set_interrupt_char, 14);
        hint(parse_compile_execute, this::parse_compile_execute, 0);
        hint(parse_compile_execute, this::parse_compile_execute, 24);
        hint(parse_compile_execute, this::parse_compile_execute, 44);
        hint(parse_compile_execute, this::parse_compile_execute, 52);
        hint(parse_compile_execute, this::parse_compile_execute, 56);
        hint(parse_compile_execute, this::parse_compile_execute, 64);
        hint(parse_compile_execute, this::parse_compile_execute, 72);
        hint(parse_compile_execute, this::parse_compile_execute, 78);
        hint(parse_compile_execute, this::parse_compile_execute, 90);
        hint(parse_compile_execute, this::parse_compile_execute, 108);
        hint(parse_compile_execute, this::parse_compile_execute, 116);
        hint(parse_compile_execute, this::parse_compile_execute, 128);
        hint(parse_compile_execute, this::parse_compile_execute, 144);
        hint(parse_compile_execute, this::parse_compile_execute, 148);
        hint(parse_compile_execute, this::parse_compile_execute, 152);
        hint(parse_compile_execute, this::parse_compile_execute, 164);
        hint(parse_compile_execute, this::parse_compile_execute, 184);
        hint(parse_compile_execute, this::parse_compile_execute, 198);
        hint(parse_compile_execute, this::parse_compile_execute, 212);
        hint(parse_compile_execute, this::parse_compile_execute, 224);
        hint(parse_compile_execute, this::parse_compile_execute, 234);
        hint(parse_compile_execute, this::parse_compile_execute, 246);
        hint(parse_compile_execute, this::parse_compile_execute, 256);
        hint(parse_compile_execute, this::parse_compile_execute, 274);
        hint(pyexec_raw_repl, this::pyexec_raw_repl, 0);
        hint(pyexec_raw_repl, this::pyexec_raw_repl, 14);
        hint(pyexec_raw_repl, this::pyexec_raw_repl, 22);
        hint(pyexec_raw_repl, this::pyexec_raw_repl, 32);
        hint(pyexec_raw_repl, this::pyexec_raw_repl, 36);
        hint(pyexec_raw_repl, this::pyexec_raw_repl, 50);
    }

    private void gen_hints_12() {
        hint(pyexec_raw_repl, this::pyexec_raw_repl, 56);
        hint(pyexec_raw_repl, this::pyexec_raw_repl, 90);
        hint(pyexec_raw_repl, this::pyexec_raw_repl, 98);
        hint(pyexec_raw_repl, this::pyexec_raw_repl, 112);
        hint(pyexec_raw_repl, this::pyexec_raw_repl, 118);
        hint(pyexec_raw_repl, this::pyexec_raw_repl, 134);
        hint(pyexec_friendly_repl, this::pyexec_friendly_repl, 0);
        hint(pyexec_friendly_repl, this::pyexec_friendly_repl, 14);
        hint(pyexec_friendly_repl, this::pyexec_friendly_repl, 22);
        hint(pyexec_friendly_repl, this::pyexec_friendly_repl, 28);
        hint(pyexec_friendly_repl, this::pyexec_friendly_repl, 40);
        hint(pyexec_friendly_repl, this::pyexec_friendly_repl, 50);
        hint(pyexec_friendly_repl, this::pyexec_friendly_repl, 56);
        hint(pyexec_friendly_repl, this::pyexec_friendly_repl, 76);
        hint(pyexec_friendly_repl, this::pyexec_friendly_repl, 96);
        hint(pyexec_friendly_repl, this::pyexec_friendly_repl, 102);
        hint(pyexec_friendly_repl, this::pyexec_friendly_repl, 118);
        hint(pyexec_friendly_repl, this::pyexec_friendly_repl, 124);
        hint(pyexec_friendly_repl, this::pyexec_friendly_repl, 146);
        hint(pyexec_friendly_repl, this::pyexec_friendly_repl, 156);
        hint(pyexec_friendly_repl, this::pyexec_friendly_repl, 168);
        hint(pyexec_friendly_repl, this::pyexec_friendly_repl, 180);
        hint(pyexec_friendly_repl, this::pyexec_friendly_repl, 190);
        hint(pyexec_friendly_repl, this::pyexec_friendly_repl, 204);
        hint(pyexec_friendly_repl, this::pyexec_friendly_repl, 208);
        hint(pyexec_friendly_repl, this::pyexec_friendly_repl, 220);
        hint(pyexec_friendly_repl, this::pyexec_friendly_repl, 228);
        hint(pyexec_frozen_module, this::pyexec_frozen_module, 0);
        hint(pyexec_frozen_module, this::pyexec_frozen_module, 8);
        hint(pyexec_frozen_module, this::pyexec_frozen_module, 18);
        hint(pyexec_frozen_module, this::pyexec_frozen_module, 36);
        hint(pyexec_frozen_module, this::pyexec_frozen_module, 48);
        hint(memcpy, this::memcpy, 0);
        hint(memmove, this::memmove, 0);
        hint(memmove, this::memmove, 34);
        hint(memset, this::memset, 0);
        hint(memcmp, this::memcmp, 0);
        hint(strlen, this::strlen, 0);
        hint(strcmp, this::strcmp, 0);
        hint(strncmp, this::strncmp, 0);
        hint(strchr, this::strchr, 0);
        hint(mp_hal_move_cursor_back, this::mp_hal_move_cursor_back, 0);
        hint(mp_hal_move_cursor_back, this::mp_hal_move_cursor_back, 16);
        hint(mp_hal_move_cursor_back, this::mp_hal_move_cursor_back, 28);
        hint(readline_init, this::readline_init, 0);
        hint(readline_init, this::readline_init, 30);
        hint(readline_push_history, this::readline_push_history, 0);
        hint(readline_push_history, this::readline_push_history, 28);
        hint(readline_push_history, this::readline_push_history, 38);
        hint(readline_push_history, this::readline_push_history, 46);
        hint(readline_push_history, this::readline_push_history, 58);
        hint(readline_process_char, this::readline_process_char, 0);
        hint(readline_process_char, this::readline_process_char, 62);
        hint(readline_process_char, this::readline_process_char, 68);
        hint(readline_process_char, this::readline_process_char, 76);
        hint(readline_process_char, this::readline_process_char, 114);
        hint(readline_process_char, this::readline_process_char, 142);
        hint(readline_process_char, this::readline_process_char, 158);
        hint(readline_process_char, this::readline_process_char, 174);
        hint(readline_process_char, this::readline_process_char, 192);
        hint(readline_process_char, this::readline_process_char, 208);
        hint(readline_process_char, this::readline_process_char, 222);
        hint(readline_process_char, this::readline_process_char, 250);
        hint(readline_process_char, this::readline_process_char, 272);
        hint(readline_process_char, this::readline_process_char, 360);
        hint(readline_process_char, this::readline_process_char, 384);
        hint(readline_process_char, this::readline_process_char, 416);
        hint(readline_process_char, this::readline_process_char, 466);
        hint(readline_process_char, this::readline_process_char, 576);
        hint(readline, this::readline, 0);
        hint(readline, this::readline, 6);
        hint(readline, this::readline, 10);
        hint(readline, this::readline, 14);
        hint(scalbnf, this::scalbnf, 0);
        hint(scalbnf, this::scalbnf, 20);
        hint(scalbnf, this::scalbnf, 34);
        hint(scalbnf, this::scalbnf, 50);
        hint(scalbnf, this::scalbnf, 70);
        hint(scalbnf, this::scalbnf, 86);
        hint(powf, this::powf, 0);
        hint(powf, this::powf, 56);
        hint(powf, this::powf, 130);
        hint(powf, this::powf, 198);
        hint(powf, this::powf, 218);
        hint(powf, this::powf, 260);
        hint(powf, this::powf, 278);
        hint(powf, this::powf, 346);
        hint(powf, this::powf, 374);
        hint(powf, this::powf, 420);
        hint(powf, this::powf, 428);
        hint(powf, this::powf, 438);
        hint(powf, this::powf, 450);
        hint(powf, this::powf, 458);
        hint(powf, this::powf, 464);
        hint(powf, this::powf, 474);
        hint(powf, this::powf, 484);
        hint(powf, this::powf, 492);
        hint(powf, this::powf, 498);
        hint(powf, this::powf, 506);
        hint(powf, this::powf, 516);
        hint(powf, this::powf, 528);
        hint(powf, this::powf, 536);
        hint(powf, this::powf, 552);
        hint(powf, this::powf, 558);
        hint(powf, this::powf, 568);
        hint(powf, this::powf, 576);
        hint(powf, this::powf, 586);
        hint(powf, this::powf, 598);
        hint(powf, this::powf, 624);
        hint(powf, this::powf, 634);
        hint(powf, this::powf, 642);
        hint(powf, this::powf, 716);
        hint(powf, this::powf, 726);
        hint(powf, this::powf, 738);
        hint(powf, this::powf, 748);
        hint(powf, this::powf, 756);
        hint(powf, this::powf, 762);
        hint(powf, this::powf, 772);
        hint(powf, this::powf, 780);
        hint(powf, this::powf, 790);
        hint(powf, this::powf, 798);
        hint(powf, this::powf, 806);
        hint(powf, this::powf, 816);
        hint(powf, this::powf, 824);
        hint(powf, this::powf, 830);
        hint(powf, this::powf, 836);
        hint(powf, this::powf, 842);
        hint(powf, this::powf, 848);
        hint(powf, this::powf, 854);
        hint(powf, this::powf, 860);
        hint(powf, this::powf, 866);
        hint(powf, this::powf, 872);
        hint(powf, this::powf, 880);
        hint(powf, this::powf, 890);
        hint(powf, this::powf, 902);
        hint(powf, this::powf, 910);
        hint(powf, this::powf, 920);
        hint(powf, this::powf, 926);
        hint(powf, this::powf, 934);
        hint(powf, this::powf, 940);
        hint(powf, this::powf, 950);
        hint(powf, this::powf, 968);
        hint(powf, this::powf, 1044);
        hint(powf, this::powf, 1116);
        hint(powf, this::powf, 1126);
        hint(powf, this::powf, 1136);
        hint(powf, this::powf, 1146);
        hint(powf, this::powf, 1184);
        hint(powf, this::powf, 1192);
        hint(powf, this::powf, 1202);
        hint(powf, this::powf, 1210);
        hint(powf, this::powf, 1216);
        hint(powf, this::powf, 1224);
        hint(powf, this::powf, 1230);
        hint(powf, this::powf, 1240);
        hint(powf, this::powf, 1248);
        hint(powf, this::powf, 1254);
        hint(powf, this::powf, 1260);
        hint(powf, this::powf, 1266);
        hint(powf, this::powf, 1272);
        hint(powf, this::powf, 1278);
        hint(powf, this::powf, 1284);
        hint(powf, this::powf, 1290);
        hint(powf, this::powf, 1296);
        hint(powf, this::powf, 1302);
        hint(powf, this::powf, 1312);
        hint(powf, this::powf, 1320);
        hint(powf, this::powf, 1330);
        hint(powf, this::powf, 1336);
        hint(powf, this::powf, 1342);
        hint(powf, this::powf, 1352);
        hint(powf, this::powf, 1360);
        hint(powf, this::powf, 1366);
        hint(powf, this::powf, 1378);
        hint(powf, this::powf, 1388);
        hint(powf, this::powf, 1394);
        hint(powf, this::powf, 1402);
        hint(powf, this::powf, 1408);
        hint(powf, this::powf, 1418);
        hint(powf, this::powf, 1426);
        hint(powf, this::powf, 1436);
        hint(powf, this::powf, 1448);
        hint(powf, this::powf, 1458);
        hint(powf, this::powf, 1466);
        hint(powf, this::powf, 1472);
        hint(powf, this::powf, 1482);
        hint(powf, this::powf, 1490);
        hint(powf, this::powf, 1500);
        hint(powf, this::powf, 1508);
        hint(powf, this::powf, 1524);
        hint(powf, this::powf, 1530);
        hint(powf, this::powf, 1536);
        hint(powf, this::powf, 1548);
        hint(powf, this::powf, 1554);
        hint(powf, this::powf, 1560);
        hint(powf, this::powf, 1592);
        hint(powf, this::powf, 1598);
        hint(expf, this::expf, 0);
        hint(expf, this::expf, 36);
        hint(expf, this::expf, 66);
        hint(expf, this::expf, 102);
        hint(expf, this::expf, 116);
        hint(expf, this::expf, 126);
        hint(expf, this::expf, 136);
        hint(expf, this::expf, 140);
        hint(expf, this::expf, 148);
        hint(expf, this::expf, 156);
        hint(expf, this::expf, 164);
        hint(expf, this::expf, 174);
        hint(expf, this::expf, 184);
        hint(expf, this::expf, 194);
        hint(expf, this::expf, 202);
        hint(expf, this::expf, 208);
        hint(expf, this::expf, 214);
        hint(expf, this::expf, 222);
        hint(expf, this::expf, 232);
        hint(expf, this::expf, 244);
        hint(expf, this::expf, 252);
        hint(expf, this::expf, 258);
        hint(expf, this::expf, 264);
        hint(expf, this::expf, 272);
        hint(expf, this::expf, 284);
        hint(expm1f, this::expm1f, 0);
        hint(expm1f, this::expm1f, 40);
        hint(expm1f, this::expm1f, 54);
        hint(expm1f, this::expm1f, 80);
        hint(expm1f, this::expm1f, 94);
        hint(expm1f, this::expm1f, 104);
        hint(expm1f, this::expm1f, 110);
        hint(expm1f, this::expm1f, 122);
        hint(expm1f, this::expm1f, 132);
        hint(expm1f, this::expm1f, 140);
        hint(expm1f, this::expm1f, 146);
        hint(expm1f, this::expm1f, 152);
        hint(expm1f, this::expm1f, 160);
        hint(expm1f, this::expm1f, 170);
        hint(expm1f, this::expm1f, 178);
        hint(expm1f, this::expm1f, 188);
        hint(expm1f, this::expm1f, 198);
        hint(expm1f, this::expm1f, 206);
        hint(expm1f, this::expm1f, 214);
        hint(expm1f, this::expm1f, 220);
        hint(expm1f, this::expm1f, 232);
        hint(expm1f, this::expm1f, 238);
        hint(expm1f, this::expm1f, 246);
        hint(expm1f, this::expm1f, 252);
        hint(expm1f, this::expm1f, 270);
        hint(expm1f, this::expm1f, 282);
        hint(expm1f, this::expm1f, 286);
        hint(expm1f, this::expm1f, 292);
        hint(expm1f, this::expm1f, 300);
        hint(expm1f, this::expm1f, 308);
        hint(expm1f, this::expm1f, 318);
        hint(expm1f, this::expm1f, 346);
        hint(expm1f, this::expm1f, 366);
        hint(expm1f, this::expm1f, 372);
        hint(expm1f, this::expm1f, 378);
        hint(expm1f, this::expm1f, 384);
        hint(expm1f, this::expm1f, 398);
        hint(expm1f, this::expm1f, 406);
        hint(expm1f, this::expm1f, 424);
        hint(expm1f, this::expm1f, 438);
        hint(expm1f, this::expm1f, 446);
        hint(expm1f, this::expm1f, 460);
        hint(expm1f, this::expm1f, 466);
        hint(expm1f, this::expm1f, 474);
        hint(expm1f, this::expm1f, 496);
        hint(expm1f, this::expm1f, 504);
        hint(expm1f, this::expm1f, 514);
        hint(expm1f, this::expm1f, 522);
        hint(expm1f, this::expm1f, 550);
        hint(expm1f, this::expm1f, 562);
        hint(expm1f, this::expm1f, 570);
        hint(expm1f, this::expm1f, 580);
        hint(expm1f, this::expm1f, 588);
        hint(__expo2f, this::__expo2f, 0);
        hint(__expo2f, this::__expo2f, 8);
        hint(__expo2f, this::__expo2f, 12);
        hint(__expo2f, this::__expo2f, 20);
        hint(__expo2f, this::__expo2f, 28);
        hint(logf, this::logf, 0);
        hint(logf, this::logf, 28);
        hint(logf, this::logf, 36);
        hint(logf, this::logf, 50);
        hint(logf, this::logf, 62);
        hint(logf, this::logf, 92);
        hint(logf, this::logf, 102);
        hint(logf, this::logf, 110);
        hint(logf, this::logf, 118);
        hint(logf, this::logf, 126);
        hint(logf, this::logf, 138);
        hint(logf, this::logf, 144);
        hint(logf, this::logf, 160);
        hint(logf, this::logf, 170);
        hint(logf, this::logf, 176);
        hint(logf, this::logf, 182);
        hint(logf, this::logf, 192);
        hint(logf, this::logf, 198);
        hint(logf, this::logf, 204);
        hint(logf, this::logf, 212);
        hint(logf, this::logf, 218);
        hint(logf, this::logf, 224);
        hint(logf, this::logf, 234);
        hint(logf, this::logf, 242);
        hint(logf, this::logf, 248);
        hint(logf, this::logf, 254);
        hint(logf, this::logf, 264);
        hint(logf, this::logf, 272);
        hint(log10f, this::log10f, 0);
        hint(log10f, this::log10f, 6);
        hint(log10f, this::log10f, 12);
        hint(coshf, this::coshf, 0);
        hint(coshf, this::coshf, 28);
        hint(coshf, this::coshf, 42);
        hint(coshf, this::coshf, 50);
        hint(coshf, this::coshf, 62);
        hint(coshf, this::coshf, 68);
        hint(coshf, this::coshf, 76);
        hint(coshf, this::coshf, 84);
        hint(coshf, this::coshf, 96);
        hint(coshf, this::coshf, 108);
        hint(coshf, this::coshf, 114);
        hint(coshf, this::coshf, 122);
        hint(coshf, this::coshf, 128);
        hint(sinhf, this::sinhf, 0);
        hint(sinhf, this::sinhf, 28);
        hint(sinhf, this::sinhf, 48);
        hint(sinhf, this::sinhf, 58);
        hint(sinhf, this::sinhf, 70);
        hint(sinhf, this::sinhf, 78);
        hint(sinhf, this::sinhf, 86);
        hint(sinhf, this::sinhf, 92);
        hint(sinhf, this::sinhf, 112);
        hint(sinhf, this::sinhf, 120);
        hint(sinhf, this::sinhf, 126);
        hint(sinhf, this::sinhf, 132);
        hint(sinhf, this::sinhf, 142);
        hint(tanhf, this::tanhf, 0);
        hint(tanhf, this::tanhf, 16);
        hint(tanhf, this::tanhf, 28);
        hint(tanhf, this::tanhf, 50);
        hint(tanhf, this::tanhf, 58);
        hint(tanhf, this::tanhf, 66);
        hint(ceilf, this::ceilf, 0);
        hint(ceilf, this::ceilf, 34);
        hint(ceilf, this::ceilf, 58);
        hint(floorf, this::floorf, 0);
        hint(floorf, this::floorf, 34);
        hint(floorf, this::floorf, 58);
        hint(truncf, this::truncf, 0);
        hint(truncf, this::truncf, 38);
        hint(acoshf, this::acoshf, 0);
        hint(acoshf, this::acoshf, 22);
        hint(acoshf, this::acoshf, 30);
        hint(acoshf, this::acoshf, 40);
        hint(acoshf, this::acoshf, 48);
        hint(acoshf, this::acoshf, 52);
        hint(acoshf, this::acoshf, 60);
        hint(acoshf, this::acoshf, 64);
        hint(acoshf, this::acoshf, 78);
        hint(acoshf, this::acoshf, 86);
        hint(acoshf, this::acoshf, 90);
        hint(acoshf, this::acoshf, 100);
        hint(acoshf, this::acoshf, 110);
        hint(acoshf, this::acoshf, 120);
        hint(acoshf, this::acoshf, 128);
        hint(acoshf, this::acoshf, 132);
        hint(acoshf, this::acoshf, 138);
        hint(acoshf, this::acoshf, 144);
        hint(text_R, this::text_R, 0);
        hint(text_R, this::text_R, 10);
        hint(text_R, this::text_R, 16);
        hint(text_R, this::text_R, 22);
        hint(text_R, this::text_R, 28);
        hint(text_R, this::text_R, 34);
        hint(text_R, this::text_R, 44);
        hint(text_R, this::text_R, 52);
        hint(text_R, this::text_R, 60);
        hint(asinf, this::asinf, 0);
        hint(asinf, this::asinf, 28);
        hint(asinf, this::asinf, 36);
        hint(asinf, this::asinf, 44);
        hint(asinf, this::asinf, 52);
        hint(asinf, this::asinf, 80);
        hint(asinf, this::asinf, 84);
        hint(asinf, this::asinf, 90);
        hint(asinf, this::asinf, 104);
        hint(asinf, this::asinf, 112);
        hint(asinf, this::asinf, 118);
        hint(asinf, this::asinf, 126);
        hint(asinf, this::asinf, 132);
        hint(asinf, this::asinf, 138);
        hint(asinf, this::asinf, 144);
        hint(asinf, this::asinf, 150);
        hint(asinf, this::asinf, 158);
        hint(acosf, this::acosf, 0);
        hint(acosf, this::acosf, 36);
        hint(acosf, this::acosf, 44);
        hint(acosf, this::acosf, 66);
        hint(acosf, this::acosf, 70);
        hint(acosf, this::acosf, 76);
        hint(acosf, this::acosf, 84);
        hint(acosf, this::acosf, 92);
        hint(acosf, this::acosf, 100);
        hint(acosf, this::acosf, 114);
        hint(acosf, this::acosf, 122);
        hint(acosf, this::acosf, 128);
        hint(acosf, this::acosf, 136);
        hint(acosf, this::acosf, 142);
        hint(acosf, this::acosf, 148);
        hint(acosf, this::acosf, 154);
        hint(acosf, this::acosf, 162);
        hint(acosf, this::acosf, 168);
        hint(acosf, this::acosf, 180);
        hint(acosf, this::acosf, 188);
        hint(acosf, this::acosf, 194);
        hint(acosf, this::acosf, 208);
        hint(acosf, this::acosf, 216);
        hint(acosf, this::acosf, 226);
        hint(acosf, this::acosf, 234);
        hint(acosf, this::acosf, 242);
        hint(acosf, this::acosf, 248);
        hint(acosf, this::acosf, 254);
        hint(acosf, this::acosf, 260);
        hint(asinhf, this::asinhf, 0);
        hint(asinhf, this::asinhf, 22);
        hint(asinhf, this::asinhf, 28);
        hint(asinhf, this::asinhf, 58);
        hint(asinhf, this::asinhf, 66);
        hint(asinhf, this::asinhf, 70);
        hint(asinhf, this::asinhf, 76);
        hint(asinhf, this::asinhf, 86);
        hint(asinhf, this::asinhf, 96);
        hint(asinhf, this::asinhf, 104);
        hint(asinhf, this::asinhf, 108);
        hint(asinhf, this::asinhf, 124);
        hint(asinhf, this::asinhf, 134);
        hint(asinhf, this::asinhf, 138);
        hint(asinhf, this::asinhf, 146);
        hint(asinhf, this::asinhf, 154);
        hint(asinhf, this::asinhf, 160);
        hint(asinhf, this::asinhf, 164);
        hint(asinhf, this::asinhf, 176);
        hint(atan2f, this::atan2f, 0);
        hint(atan2f, this::atan2f, 12);
        hint(atan2f, this::atan2f, 24);
        hint(atan2f, this::atan2f, 36);
        hint(atan2f, this::atan2f, 54);
        hint(atan2f, this::atan2f, 192);
        hint(atan2f, this::atan2f, 200);
        hint(atan2f, this::atan2f, 222);
        hint(atan2f, this::atan2f, 246);
        hint(atan2f, this::atan2f, 254);
        hint(atanf, this::atanf, 0);
        hint(atanf, this::atanf, 26);
        hint(atanf, this::atanf, 72);
        hint(atanf, this::atanf, 100);
        hint(atanf, this::atanf, 108);
        hint(atanf, this::atanf, 120);
        hint(atanf, this::atanf, 128);
        hint(atanf, this::atanf, 140);
        hint(atanf, this::atanf, 148);
        hint(atanf, this::atanf, 156);
        hint(atanf, this::atanf, 162);
        hint(atanf, this::atanf, 168);
        hint(atanf, this::atanf, 174);
        hint(atanf, this::atanf, 180);
        hint(atanf, this::atanf, 190);
        hint(atanf, this::atanf, 196);
        hint(atanf, this::atanf, 202);
        hint(atanf, this::atanf, 210);
        hint(atanf, this::atanf, 216);
        hint(atanf, this::atanf, 228);
        hint(atanf, this::atanf, 242);
        hint(atanf, this::atanf, 254);
        hint(atanf, this::atanf, 262);
        hint(atanf, this::atanf, 284);
        hint(atanf, this::atanf, 296);
        hint(atanf, this::atanf, 304);
        hint(atanf, this::atanf, 312);
        hint(atanf, this::atanf, 326);
        hint(atanf, this::atanf, 348);
        hint(atanf, this::atanf, 354);
        hint(atanf, this::atanf, 364);
        hint(atanhf, this::atanhf, 0);
        hint(atanhf, this::atanhf, 34);
        hint(atanhf, this::atanhf, 58);
        hint(atanhf, this::atanhf, 66);
        hint(atanhf, this::atanhf, 78);
        hint(atanhf, this::atanhf, 86);
        hint(atanhf, this::atanhf, 92);
        hint(atanhf, this::atanhf, 96);
        hint(atanhf, this::atanhf, 104);
        hint(atanhf, this::atanhf, 118);
        hint(atanhf, this::atanhf, 126);
        hint(__ieee754_rem_pio2f, this::__ieee754_rem_pio2f, 0);
        hint(__ieee754_rem_pio2f, this::__ieee754_rem_pio2f, 50);
        hint(__ieee754_rem_pio2f, this::__ieee754_rem_pio2f, 62);
        hint(__ieee754_rem_pio2f, this::__ieee754_rem_pio2f, 72);
        hint(__ieee754_rem_pio2f, this::__ieee754_rem_pio2f, 78);
    }

    private void gen_hints_13() {
        hint(__ieee754_rem_pio2f, this::__ieee754_rem_pio2f, 94);
        hint(__ieee754_rem_pio2f, this::__ieee754_rem_pio2f, 102);
        hint(__ieee754_rem_pio2f, this::__ieee754_rem_pio2f, 112);
        hint(__ieee754_rem_pio2f, this::__ieee754_rem_pio2f, 120);
        hint(__ieee754_rem_pio2f, this::__ieee754_rem_pio2f, 132);
        hint(__ieee754_rem_pio2f, this::__ieee754_rem_pio2f, 142);
        hint(__ieee754_rem_pio2f, this::__ieee754_rem_pio2f, 148);
        hint(__ieee754_rem_pio2f, this::__ieee754_rem_pio2f, 162);
        hint(__ieee754_rem_pio2f, this::__ieee754_rem_pio2f, 170);
        hint(__ieee754_rem_pio2f, this::__ieee754_rem_pio2f, 180);
        hint(__ieee754_rem_pio2f, this::__ieee754_rem_pio2f, 200);
        hint(__ieee754_rem_pio2f, this::__ieee754_rem_pio2f, 208);
        hint(__ieee754_rem_pio2f, this::__ieee754_rem_pio2f, 212);
        hint(__ieee754_rem_pio2f, this::__ieee754_rem_pio2f, 218);
        hint(__ieee754_rem_pio2f, this::__ieee754_rem_pio2f, 226);
        hint(__ieee754_rem_pio2f, this::__ieee754_rem_pio2f, 234);
        hint(__ieee754_rem_pio2f, this::__ieee754_rem_pio2f, 244);
        hint(__ieee754_rem_pio2f, this::__ieee754_rem_pio2f, 254);
        hint(__ieee754_rem_pio2f, this::__ieee754_rem_pio2f, 306);
        hint(__ieee754_rem_pio2f, this::__ieee754_rem_pio2f, 316);
        hint(__ieee754_rem_pio2f, this::__ieee754_rem_pio2f, 326);
        hint(__ieee754_rem_pio2f, this::__ieee754_rem_pio2f, 332);
        hint(__ieee754_rem_pio2f, this::__ieee754_rem_pio2f, 342);
        hint(__ieee754_rem_pio2f, this::__ieee754_rem_pio2f, 348);
        hint(__ieee754_rem_pio2f, this::__ieee754_rem_pio2f, 358);
        hint(__ieee754_rem_pio2f, this::__ieee754_rem_pio2f, 386);
        hint(__ieee754_rem_pio2f, this::__ieee754_rem_pio2f, 392);
        hint(__ieee754_rem_pio2f, this::__ieee754_rem_pio2f, 424);
        hint(__ieee754_rem_pio2f, this::__ieee754_rem_pio2f, 434);
        hint(__ieee754_rem_pio2f, this::__ieee754_rem_pio2f, 444);
        hint(__ieee754_rem_pio2f, this::__ieee754_rem_pio2f, 450);
        hint(__ieee754_rem_pio2f, this::__ieee754_rem_pio2f, 460);
        hint(__ieee754_rem_pio2f, this::__ieee754_rem_pio2f, 466);
        hint(__ieee754_rem_pio2f, this::__ieee754_rem_pio2f, 476);
        hint(__ieee754_rem_pio2f, this::__ieee754_rem_pio2f, 490);
        hint(__ieee754_rem_pio2f, this::__ieee754_rem_pio2f, 510);
        hint(__ieee754_rem_pio2f, this::__ieee754_rem_pio2f, 514);
        hint(__ieee754_rem_pio2f, this::__ieee754_rem_pio2f, 524);
        hint(__ieee754_rem_pio2f, this::__ieee754_rem_pio2f, 532);
        hint(__ieee754_rem_pio2f, this::__ieee754_rem_pio2f, 538);
        hint(__ieee754_rem_pio2f, this::__ieee754_rem_pio2f, 542);
        hint(__ieee754_rem_pio2f, this::__ieee754_rem_pio2f, 554);
        hint(__ieee754_rem_pio2f, this::__ieee754_rem_pio2f, 562);
        hint(__ieee754_rem_pio2f, this::__ieee754_rem_pio2f, 570);
        hint(__ieee754_rem_pio2f, this::__ieee754_rem_pio2f, 584);
        hint(__ieee754_rem_pio2f, this::__ieee754_rem_pio2f, 608);
        hint(sqrtf, this::sqrtf, 0);
        hint(sqrtf, this::sqrtf, 22);
        hint(sqrtf, this::sqrtf, 30);
        hint(sqrtf, this::sqrtf, 50);
        hint(sqrtf, this::sqrtf, 56);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 0);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 28);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 46);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 76);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 86);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 118);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 126);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 136);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 148);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 158);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 162);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 172);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 216);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 224);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 238);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 244);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 252);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 258);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 268);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 272);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 306);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 316);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 336);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 342);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 348);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 364);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 372);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 384);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 390);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 396);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 414);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 434);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 444);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 452);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 460);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 466);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 472);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 478);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 484);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 490);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 496);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 502);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 508);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 518);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 524);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 530);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 536);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 542);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 548);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 554);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 560);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 566);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 576);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 582);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 588);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 594);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 600);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 606);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 612);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 618);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 626);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 632);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 640);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 648);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 668);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 688);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 704);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 716);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 722);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 728);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 734);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 740);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 746);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 752);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 758);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 764);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 770);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 776);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 786);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 792);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 798);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 804);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 810);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 816);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 822);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 828);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 834);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 842);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 850);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 862);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 870);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1038);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1044);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1052);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1060);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1066);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1072);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1078);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1084);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1090);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1096);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1102);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1108);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1114);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1120);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1126);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1132);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1142);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1148);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1154);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1160);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1166);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1172);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1178);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1184);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1190);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1196);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1202);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1210);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1218);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1230);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1238);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1270);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1288);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1298);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1304);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1316);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1322);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1332);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1338);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1350);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1356);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1360);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1368);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1406);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1418);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1426);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1434);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1440);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1446);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1452);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1458);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1464);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1470);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1476);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1482);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1488);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1494);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1500);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1512);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1524);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1532);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1542);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1550);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1556);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1604);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1628);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1638);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1646);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1652);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1658);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1664);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1670);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1676);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1682);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1688);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1694);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1700);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1706);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1716);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1722);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1728);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1734);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1740);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1746);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1752);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1758);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1764);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1770);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1776);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1784);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1796);
        hint(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r, 1804);
        hint(fmodf, this::fmodf, 0);
        hint(fmodf, this::fmodf, 16);
        hint(fmodf, this::fmodf, 38);
        hint(fmodf, this::fmodf, 44);
        hint(fmodf, this::fmodf, 66);
        hint(__kernel_cosf, this::__kernel_cosf, 0);
        hint(__kernel_cosf, this::__kernel_cosf, 20);
        hint(__kernel_cosf, this::__kernel_cosf, 32);
        hint(__kernel_cosf, this::__kernel_cosf, 42);
        hint(__kernel_cosf, this::__kernel_cosf, 52);
        hint(__kernel_cosf, this::__kernel_cosf, 58);
        hint(__kernel_cosf, this::__kernel_cosf, 64);
        hint(__kernel_cosf, this::__kernel_cosf, 70);
        hint(__kernel_cosf, this::__kernel_cosf, 76);
        hint(__kernel_cosf, this::__kernel_cosf, 82);
        hint(__kernel_cosf, this::__kernel_cosf, 88);
        hint(__kernel_cosf, this::__kernel_cosf, 94);
        hint(__kernel_cosf, this::__kernel_cosf, 100);
        hint(__kernel_cosf, this::__kernel_cosf, 106);
        hint(__kernel_cosf, this::__kernel_cosf, 112);
        hint(__kernel_cosf, this::__kernel_cosf, 118);
        hint(__kernel_cosf, this::__kernel_cosf, 128);
        hint(__kernel_cosf, this::__kernel_cosf, 136);
        hint(__kernel_cosf, this::__kernel_cosf, 152);
        hint(__kernel_cosf, this::__kernel_cosf, 162);
        hint(__kernel_cosf, this::__kernel_cosf, 186);
        hint(__kernel_cosf, this::__kernel_cosf, 196);
        hint(__kernel_cosf, this::__kernel_cosf, 202);
        hint(__kernel_rem_pio2f, this::__kernel_rem_pio2f, 0);
        hint(__kernel_rem_pio2f, this::__kernel_rem_pio2f, 148);
        hint(__kernel_rem_pio2f, this::__kernel_rem_pio2f, 158);
        hint(__kernel_rem_pio2f, this::__kernel_rem_pio2f, 162);
        hint(__kernel_rem_pio2f, this::__kernel_rem_pio2f, 170);
        hint(__kernel_rem_pio2f, this::__kernel_rem_pio2f, 178);
        hint(__kernel_rem_pio2f, this::__kernel_rem_pio2f, 184);
        hint(__kernel_rem_pio2f, this::__kernel_rem_pio2f, 190);
        hint(__kernel_rem_pio2f, this::__kernel_rem_pio2f, 198);
        hint(__kernel_rem_pio2f, this::__kernel_rem_pio2f, 316);
        hint(__kernel_rem_pio2f, this::__kernel_rem_pio2f, 332);
        hint(__kernel_rem_pio2f, this::__kernel_rem_pio2f, 340);
        hint(__kernel_rem_pio2f, this::__kernel_rem_pio2f, 358);
        hint(__kernel_rem_pio2f, this::__kernel_rem_pio2f, 382);
        hint(__kernel_rem_pio2f, this::__kernel_rem_pio2f, 390);
        hint(__kernel_rem_pio2f, this::__kernel_rem_pio2f, 432);
        hint(__kernel_rem_pio2f, this::__kernel_rem_pio2f, 436);
        hint(__kernel_rem_pio2f, this::__kernel_rem_pio2f, 440);
        hint(__kernel_rem_pio2f, this::__kernel_rem_pio2f, 456);
        hint(__kernel_rem_pio2f, this::__kernel_rem_pio2f, 464);
        hint(__kernel_rem_pio2f, this::__kernel_rem_pio2f, 468);
        hint(__kernel_rem_pio2f, this::__kernel_rem_pio2f, 488);
        hint(__kernel_rem_pio2f, this::__kernel_rem_pio2f, 520);
        hint(__kernel_rem_pio2f, this::__kernel_rem_pio2f, 534);
        hint(__kernel_rem_pio2f, this::__kernel_rem_pio2f, 590);
        hint(__kernel_rem_pio2f, this::__kernel_rem_pio2f, 806);
        hint(__kernel_rem_pio2f, this::__kernel_rem_pio2f, 870);
        hint(__kernel_rem_pio2f, this::__kernel_rem_pio2f, 878);
        hint(__kernel_rem_pio2f, this::__kernel_rem_pio2f, 902);
        hint(__kernel_rem_pio2f, this::__kernel_rem_pio2f, 912);
        hint(__kernel_rem_pio2f, this::__kernel_rem_pio2f, 926);
        hint(__kernel_rem_pio2f, this::__kernel_rem_pio2f, 930);
        hint(__kernel_rem_pio2f, this::__kernel_rem_pio2f, 934);
        hint(__kernel_rem_pio2f, this::__kernel_rem_pio2f, 944);
        hint(__kernel_rem_pio2f, this::__kernel_rem_pio2f, 952);
        hint(__kernel_rem_pio2f, this::__kernel_rem_pio2f, 956);
        hint(__kernel_rem_pio2f, this::__kernel_rem_pio2f, 974);
        hint(__kernel_rem_pio2f, this::__kernel_rem_pio2f, 990);
        hint(__kernel_rem_pio2f, this::__kernel_rem_pio2f, 1006);
        hint(__kernel_rem_pio2f, this::__kernel_rem_pio2f, 1012);
        hint(__kernel_rem_pio2f, this::__kernel_rem_pio2f, 1030);
        hint(__kernel_rem_pio2f, this::__kernel_rem_pio2f, 1050);
        hint(__kernel_rem_pio2f, this::__kernel_rem_pio2f, 1058);
        hint(__kernel_rem_pio2f, this::__kernel_rem_pio2f, 1120);
        hint(__kernel_rem_pio2f, this::__kernel_rem_pio2f, 1158);
        hint(__kernel_rem_pio2f, this::__kernel_rem_pio2f, 1190);
        hint(__kernel_rem_pio2f, this::__kernel_rem_pio2f, 1232);
        hint(__kernel_rem_pio2f, this::__kernel_rem_pio2f, 1264);
        hint(__kernel_rem_pio2f, this::__kernel_rem_pio2f, 1274);
        hint(__kernel_rem_pio2f, this::__kernel_rem_pio2f, 1280);
        hint(__kernel_rem_pio2f, this::__kernel_rem_pio2f, 1364);
        hint(__kernel_rem_pio2f, this::__kernel_rem_pio2f, 1374);
        hint(__kernel_rem_pio2f, this::__kernel_rem_pio2f, 1380);
        hint(__kernel_rem_pio2f, this::__kernel_rem_pio2f, 1398);
        hint(__kernel_sinf, this::__kernel_sinf, 0);
        hint(__kernel_sinf, this::__kernel_sinf, 22);
        hint(__kernel_sinf, this::__kernel_sinf, 34);
        hint(__kernel_sinf, this::__kernel_sinf, 44);
        hint(__kernel_sinf, this::__kernel_sinf, 54);
        hint(__kernel_sinf, this::__kernel_sinf, 60);
        hint(__kernel_sinf, this::__kernel_sinf, 66);
        hint(__kernel_sinf, this::__kernel_sinf, 72);
        hint(__kernel_sinf, this::__kernel_sinf, 78);
        hint(__kernel_sinf, this::__kernel_sinf, 84);
        hint(__kernel_sinf, this::__kernel_sinf, 90);
        hint(__kernel_sinf, this::__kernel_sinf, 96);
        hint(__kernel_sinf, this::__kernel_sinf, 112);
        hint(__kernel_sinf, this::__kernel_sinf, 118);
        hint(__kernel_sinf, this::__kernel_sinf, 124);
        hint(__kernel_sinf, this::__kernel_sinf, 132);
        hint(__kernel_sinf, this::__kernel_sinf, 148);
        hint(__kernel_sinf, this::__kernel_sinf, 158);
        hint(__kernel_sinf, this::__kernel_sinf, 166);
        hint(__kernel_sinf, this::__kernel_sinf, 172);
        hint(__kernel_sinf, this::__kernel_sinf, 178);
        hint(__kernel_sinf, this::__kernel_sinf, 188);
        hint(__kernel_sinf, this::__kernel_sinf, 196);
        hint(__kernel_sinf, this::__kernel_sinf, 204);
        hint(__kernel_tanf, this::__kernel_tanf, 0);
        hint(__kernel_tanf, this::__kernel_tanf, 30);
        hint(__kernel_tanf, this::__kernel_tanf, 54);
        hint(__kernel_tanf, this::__kernel_tanf, 102);
        hint(__kernel_tanf, this::__kernel_tanf, 112);
        hint(__kernel_tanf, this::__kernel_tanf, 118);
        hint(__kernel_tanf, this::__kernel_tanf, 130);
        hint(__kernel_tanf, this::__kernel_tanf, 138);
        hint(__kernel_tanf, this::__kernel_tanf, 148);
        hint(__kernel_tanf, this::__kernel_tanf, 158);
        hint(__kernel_tanf, this::__kernel_tanf, 164);
        hint(__kernel_tanf, this::__kernel_tanf, 170);
        hint(__kernel_tanf, this::__kernel_tanf, 176);
        hint(__kernel_tanf, this::__kernel_tanf, 182);
        hint(__kernel_tanf, this::__kernel_tanf, 188);
        hint(__kernel_tanf, this::__kernel_tanf, 194);
        hint(__kernel_tanf, this::__kernel_tanf, 200);
        hint(__kernel_tanf, this::__kernel_tanf, 206);
        hint(__kernel_tanf, this::__kernel_tanf, 212);
        hint(__kernel_tanf, this::__kernel_tanf, 218);
        hint(__kernel_tanf, this::__kernel_tanf, 228);
        hint(__kernel_tanf, this::__kernel_tanf, 234);
        hint(__kernel_tanf, this::__kernel_tanf, 240);
        hint(__kernel_tanf, this::__kernel_tanf, 246);
        hint(__kernel_tanf, this::__kernel_tanf, 252);
        hint(__kernel_tanf, this::__kernel_tanf, 258);
        hint(__kernel_tanf, this::__kernel_tanf, 264);
        hint(__kernel_tanf, this::__kernel_tanf, 270);
        hint(__kernel_tanf, this::__kernel_tanf, 276);
        hint(__kernel_tanf, this::__kernel_tanf, 282);
        hint(__kernel_tanf, this::__kernel_tanf, 290);
        hint(__kernel_tanf, this::__kernel_tanf, 296);
        hint(__kernel_tanf, this::__kernel_tanf, 302);
        hint(__kernel_tanf, this::__kernel_tanf, 308);
        hint(__kernel_tanf, this::__kernel_tanf, 314);
        hint(__kernel_tanf, this::__kernel_tanf, 324);
        hint(__kernel_tanf, this::__kernel_tanf, 330);
        hint(__kernel_tanf, this::__kernel_tanf, 340);
        hint(__kernel_tanf, this::__kernel_tanf, 356);
        hint(__kernel_tanf, this::__kernel_tanf, 366);
        hint(__kernel_tanf, this::__kernel_tanf, 376);
        hint(__kernel_tanf, this::__kernel_tanf, 384);
        hint(__kernel_tanf, this::__kernel_tanf, 390);
        hint(__kernel_tanf, this::__kernel_tanf, 398);
        hint(__kernel_tanf, this::__kernel_tanf, 404);
        hint(__kernel_tanf, this::__kernel_tanf, 412);
        hint(__kernel_tanf, this::__kernel_tanf, 430);
        hint(__kernel_tanf, this::__kernel_tanf, 438);
        hint(__kernel_tanf, this::__kernel_tanf, 456);
        hint(__kernel_tanf, this::__kernel_tanf, 472);
        hint(__kernel_tanf, this::__kernel_tanf, 482);
        hint(__kernel_tanf, this::__kernel_tanf, 488);
        hint(__kernel_tanf, this::__kernel_tanf, 498);
        hint(__kernel_tanf, this::__kernel_tanf, 506);
        hint(__kernel_tanf, this::__kernel_tanf, 514);
        hint(__kernel_tanf, this::__kernel_tanf, 520);
        hint(__kernel_tanf, this::__kernel_tanf, 526);
        hint(log1pf, this::log1pf, 0);
        hint(log1pf, this::log1pf, 30);
        hint(log1pf, this::log1pf, 42);
        hint(log1pf, this::log1pf, 54);
        hint(log1pf, this::log1pf, 80);
        hint(log1pf, this::log1pf, 108);
        hint(log1pf, this::log1pf, 132);
        hint(log1pf, this::log1pf, 142);
        hint(log1pf, this::log1pf, 148);
        hint(log1pf, this::log1pf, 166);
        hint(log1pf, this::log1pf, 178);
        hint(log1pf, this::log1pf, 186);
        hint(log1pf, this::log1pf, 194);
        hint(log1pf, this::log1pf, 202);
        hint(log1pf, this::log1pf, 214);
        hint(log1pf, this::log1pf, 220);
        hint(log1pf, this::log1pf, 228);
        hint(log1pf, this::log1pf, 238);
        hint(log1pf, this::log1pf, 244);
        hint(log1pf, this::log1pf, 250);
        hint(log1pf, this::log1pf, 260);
        hint(log1pf, this::log1pf, 266);
        hint(log1pf, this::log1pf, 272);
        hint(log1pf, this::log1pf, 280);
        hint(log1pf, this::log1pf, 286);
        hint(log1pf, this::log1pf, 292);
        hint(log1pf, this::log1pf, 302);
        hint(log1pf, this::log1pf, 308);
        hint(log1pf, this::log1pf, 316);
        hint(log1pf, this::log1pf, 322);
        hint(log1pf, this::log1pf, 328);
        hint(log1pf, this::log1pf, 338);
        hint(log1pf, this::log1pf, 346);
        hint(log1pf, this::log1pf, 366);
        hint(nearbyintf, this::nearbyintf, 0);
        hint(nearbyintf, this::nearbyintf, 26);
        hint(nearbyintf, this::nearbyintf, 34);
        hint(nearbyintf, this::nearbyintf, 42);
        hint(nearbyintf, this::nearbyintf, 64);
        hint(nearbyintf, this::nearbyintf, 72);
        hint(cosf, this::cosf, 0);
        hint(cosf, this::cosf, 26);
        hint(cosf, this::cosf, 34);
        hint(cosf, this::cosf, 58);
        hint(cosf, this::cosf, 68);
        hint(cosf, this::cosf, 84);
        hint(cosf, this::cosf, 96);
        hint(erff, this::erff, 0);
        hint(erff, this::erff, 30);
        hint(erff, this::erff, 42);
        hint(erff, this::erff, 50);
        hint(erff, this::erff, 78);
        hint(erff, this::erff, 88);
        hint(erff, this::erff, 96);
        hint(erff, this::erff, 104);
        hint(erff, this::erff, 114);
        hint(erff, this::erff, 124);
        hint(erff, this::erff, 132);
        hint(erff, this::erff, 138);
        hint(erff, this::erff, 144);
        hint(erff, this::erff, 150);
        hint(erff, this::erff, 156);
        hint(erff, this::erff, 162);
        hint(erff, this::erff, 168);
        hint(erff, this::erff, 174);
        hint(erff, this::erff, 184);
        hint(erff, this::erff, 190);
        hint(erff, this::erff, 196);
        hint(erff, this::erff, 202);
        hint(erff, this::erff, 208);
        hint(erff, this::erff, 214);
        hint(erff, this::erff, 220);
        hint(erff, this::erff, 226);
        hint(erff, this::erff, 232);
        hint(erff, this::erff, 240);
        hint(erff, this::erff, 248);
        hint(erff, this::erff, 268);
        hint(erff, this::erff, 276);
        hint(erff, this::erff, 282);
        hint(erff, this::erff, 288);
        hint(erff, this::erff, 294);
        hint(erff, this::erff, 300);
        hint(erff, this::erff, 306);
        hint(erff, this::erff, 312);
        hint(erff, this::erff, 318);
        hint(erff, this::erff, 324);
        hint(erff, this::erff, 330);
        hint(erff, this::erff, 336);
        hint(erff, this::erff, 342);
        hint(erff, this::erff, 352);
        hint(erff, this::erff, 358);
        hint(erff, this::erff, 364);
        hint(erff, this::erff, 370);
        hint(erff, this::erff, 376);
        hint(erff, this::erff, 382);
        hint(erff, this::erff, 388);
        hint(erff, this::erff, 394);
        hint(erff, this::erff, 400);
        hint(erff, this::erff, 406);
        hint(erff, this::erff, 412);
        hint(erff, this::erff, 420);
        hint(erff, this::erff, 428);
        hint(erff, this::erff, 444);
    }

    private void gen_hints_14() {
        hint(erff, this::erff, 470);
        hint(erff, this::erff, 480);
        hint(erff, this::erff, 498);
        hint(erff, this::erff, 504);
        hint(erff, this::erff, 510);
        hint(erff, this::erff, 516);
        hint(erff, this::erff, 522);
        hint(erff, this::erff, 528);
        hint(erff, this::erff, 534);
        hint(erff, this::erff, 540);
        hint(erff, this::erff, 546);
        hint(erff, this::erff, 552);
        hint(erff, this::erff, 558);
        hint(erff, this::erff, 564);
        hint(erff, this::erff, 570);
        hint(erff, this::erff, 576);
        hint(erff, this::erff, 586);
        hint(erff, this::erff, 592);
        hint(erff, this::erff, 598);
        hint(erff, this::erff, 604);
        hint(erff, this::erff, 610);
        hint(erff, this::erff, 616);
        hint(erff, this::erff, 622);
        hint(erff, this::erff, 628);
        hint(erff, this::erff, 634);
        hint(erff, this::erff, 640);
        hint(erff, this::erff, 646);
        hint(erff, this::erff, 652);
        hint(erff, this::erff, 658);
        hint(erff, this::erff, 664);
        hint(erff, this::erff, 670);
        hint(erff, this::erff, 678);
        hint(erff, this::erff, 698);
        hint(erff, this::erff, 704);
        hint(erff, this::erff, 708);
        hint(erff, this::erff, 718);
        hint(erff, this::erff, 728);
        hint(erff, this::erff, 736);
        hint(erff, this::erff, 746);
        hint(erff, this::erff, 754);
        hint(erff, this::erff, 758);
        hint(erff, this::erff, 766);
        hint(erff, this::erff, 778);
        hint(erff, this::erff, 994);
        hint(erff, this::erff, 1000);
        hint(erff, this::erff, 1006);
        hint(erff, this::erff, 1012);
        hint(erff, this::erff, 1018);
        hint(erff, this::erff, 1024);
        hint(erff, this::erff, 1030);
        hint(erff, this::erff, 1036);
        hint(erff, this::erff, 1042);
        hint(erff, this::erff, 1048);
        hint(erff, this::erff, 1054);
        hint(erff, this::erff, 1060);
        hint(erff, this::erff, 1070);
        hint(erff, this::erff, 1076);
        hint(erff, this::erff, 1082);
        hint(erff, this::erff, 1088);
        hint(erff, this::erff, 1094);
        hint(erff, this::erff, 1100);
        hint(erff, this::erff, 1106);
        hint(erff, this::erff, 1112);
        hint(erff, this::erff, 1118);
        hint(erff, this::erff, 1124);
        hint(erff, this::erff, 1130);
        hint(erff, this::erff, 1138);
        hint(erfcf, this::erfcf, 0);
        hint(erfcf, this::erfcf, 26);
        hint(erfcf, this::erfcf, 38);
        hint(erfcf, this::erfcf, 46);
        hint(erfcf, this::erfcf, 72);
        hint(erfcf, this::erfcf, 78);
        hint(erfcf, this::erfcf, 86);
        hint(erfcf, this::erfcf, 92);
        hint(erfcf, this::erfcf, 98);
        hint(erfcf, this::erfcf, 104);
        hint(erfcf, this::erfcf, 110);
        hint(erfcf, this::erfcf, 116);
        hint(erfcf, this::erfcf, 122);
        hint(erfcf, this::erfcf, 128);
        hint(erfcf, this::erfcf, 138);
        hint(erfcf, this::erfcf, 144);
        hint(erfcf, this::erfcf, 150);
        hint(erfcf, this::erfcf, 156);
        hint(erfcf, this::erfcf, 162);
        hint(erfcf, this::erfcf, 168);
        hint(erfcf, this::erfcf, 174);
        hint(erfcf, this::erfcf, 180);
        hint(erfcf, this::erfcf, 186);
        hint(erfcf, this::erfcf, 194);
        hint(erfcf, this::erfcf, 202);
        hint(erfcf, this::erfcf, 208);
        hint(erfcf, this::erfcf, 224);
        hint(erfcf, this::erfcf, 238);
        hint(erfcf, this::erfcf, 244);
        hint(erfcf, this::erfcf, 266);
        hint(erfcf, this::erfcf, 274);
        hint(erfcf, this::erfcf, 280);
        hint(erfcf, this::erfcf, 286);
        hint(erfcf, this::erfcf, 292);
        hint(erfcf, this::erfcf, 298);
        hint(erfcf, this::erfcf, 304);
        hint(erfcf, this::erfcf, 310);
        hint(erfcf, this::erfcf, 316);
        hint(erfcf, this::erfcf, 322);
        hint(erfcf, this::erfcf, 328);
        hint(erfcf, this::erfcf, 334);
        hint(erfcf, this::erfcf, 340);
        hint(erfcf, this::erfcf, 350);
        hint(erfcf, this::erfcf, 356);
        hint(erfcf, this::erfcf, 362);
        hint(erfcf, this::erfcf, 368);
        hint(erfcf, this::erfcf, 374);
        hint(erfcf, this::erfcf, 380);
        hint(erfcf, this::erfcf, 386);
        hint(erfcf, this::erfcf, 392);
        hint(erfcf, this::erfcf, 398);
        hint(erfcf, this::erfcf, 404);
        hint(erfcf, this::erfcf, 410);
        hint(erfcf, this::erfcf, 418);
        hint(erfcf, this::erfcf, 426);
        hint(erfcf, this::erfcf, 442);
        hint(erfcf, this::erfcf, 462);
        hint(erfcf, this::erfcf, 472);
        hint(erfcf, this::erfcf, 490);
        hint(erfcf, this::erfcf, 496);
        hint(erfcf, this::erfcf, 502);
        hint(erfcf, this::erfcf, 508);
        hint(erfcf, this::erfcf, 514);
        hint(erfcf, this::erfcf, 520);
        hint(erfcf, this::erfcf, 526);
        hint(erfcf, this::erfcf, 532);
        hint(erfcf, this::erfcf, 538);
        hint(erfcf, this::erfcf, 544);
        hint(erfcf, this::erfcf, 550);
        hint(erfcf, this::erfcf, 556);
        hint(erfcf, this::erfcf, 562);
        hint(erfcf, this::erfcf, 568);
        hint(erfcf, this::erfcf, 578);
        hint(erfcf, this::erfcf, 584);
        hint(erfcf, this::erfcf, 590);
        hint(erfcf, this::erfcf, 596);
        hint(erfcf, this::erfcf, 602);
        hint(erfcf, this::erfcf, 608);
        hint(erfcf, this::erfcf, 614);
        hint(erfcf, this::erfcf, 620);
        hint(erfcf, this::erfcf, 626);
        hint(erfcf, this::erfcf, 632);
        hint(erfcf, this::erfcf, 638);
        hint(erfcf, this::erfcf, 644);
        hint(erfcf, this::erfcf, 650);
        hint(erfcf, this::erfcf, 656);
        hint(erfcf, this::erfcf, 662);
        hint(erfcf, this::erfcf, 670);
        hint(erfcf, this::erfcf, 690);
        hint(erfcf, this::erfcf, 696);
        hint(erfcf, this::erfcf, 700);
        hint(erfcf, this::erfcf, 710);
        hint(erfcf, this::erfcf, 720);
        hint(erfcf, this::erfcf, 728);
        hint(erfcf, this::erfcf, 738);
        hint(erfcf, this::erfcf, 746);
        hint(erfcf, this::erfcf, 750);
        hint(erfcf, this::erfcf, 758);
        hint(erfcf, this::erfcf, 770);
        hint(erfcf, this::erfcf, 986);
        hint(erfcf, this::erfcf, 992);
        hint(erfcf, this::erfcf, 998);
        hint(erfcf, this::erfcf, 1004);
        hint(erfcf, this::erfcf, 1010);
        hint(erfcf, this::erfcf, 1016);
        hint(erfcf, this::erfcf, 1022);
        hint(erfcf, this::erfcf, 1028);
        hint(erfcf, this::erfcf, 1034);
        hint(erfcf, this::erfcf, 1040);
        hint(erfcf, this::erfcf, 1046);
        hint(erfcf, this::erfcf, 1052);
        hint(erfcf, this::erfcf, 1062);
        hint(erfcf, this::erfcf, 1068);
        hint(erfcf, this::erfcf, 1074);
        hint(erfcf, this::erfcf, 1080);
        hint(erfcf, this::erfcf, 1086);
        hint(erfcf, this::erfcf, 1092);
        hint(erfcf, this::erfcf, 1098);
        hint(erfcf, this::erfcf, 1104);
        hint(erfcf, this::erfcf, 1110);
        hint(erfcf, this::erfcf, 1116);
        hint(erfcf, this::erfcf, 1122);
        hint(erfcf, this::erfcf, 1130);
        hint(frexpf, this::frexpf, 0);
        hint(frexpf, this::frexpf, 38);
        hint(ldexpf, this::ldexpf, 0);
        hint(ldexpf, this::ldexpf, 18);
        hint(ldexpf, this::ldexpf, 30);
        hint(ldexpf, this::ldexpf, 42);
        hint(ldexpf, this::ldexpf, 54);
        hint(modff, this::modff, 0);
        hint(modff, this::modff, 52);
        hint(sinf, this::sinf, 0);
        hint(sinf, this::sinf, 20);
        hint(sinf, this::sinf, 34);
        hint(sinf, this::sinf, 42);
        hint(sinf, this::sinf, 74);
        hint(sinf, this::sinf, 86);
        hint(sinf, this::sinf, 102);
        hint(tanf, this::tanf, 0);
        hint(tanf, this::tanf, 20);
        hint(tanf, this::tanf, 34);
        hint(tanf, this::tanf, 42);
        hint(lgammaf, this::lgammaf, 0);
        hint(lgammaf, this::lgammaf, 8);
        hint(tgammaf, this::tgammaf, 0);
        hint(tgammaf, this::tgammaf, 8);
        hint(tgammaf, this::tgammaf, 12);
        hint(__aeabi_uidiv, this::__aeabi_uidiv, 0);
        hint(__aeabi_uidiv, this::__aeabi_uidiv, 8);
        hint(__aeabi_uidiv, this::__aeabi_uidiv, 14);
        hint(__aeabi_uidiv, this::__aeabi_uidiv, 20);
        hint(__aeabi_uidiv, this::__aeabi_uidiv, 26);
        hint(__aeabi_uidiv, this::__aeabi_uidiv, 32);
        hint(__aeabi_uidiv, this::__aeabi_uidiv, 44);
        hint(__aeabi_uidiv, this::__aeabi_uidiv, 50);
        hint(__aeabi_uidiv, this::__aeabi_uidiv, 56);
        hint(__aeabi_uidiv, this::__aeabi_uidiv, 58);
        hint(__aeabi_uidiv, this::__aeabi_uidiv, 60);
        hint(__aeabi_uidiv, this::__aeabi_uidiv, 66);
        hint(__aeabi_uidiv, this::__aeabi_uidiv, 70);
        hint(__aeabi_uidiv, this::__aeabi_uidiv, 78);
        hint(__aeabi_uidiv, this::__aeabi_uidiv, 82);
        hint(__aeabi_uidiv, this::__aeabi_uidiv, 90);
        hint(__aeabi_uidiv, this::__aeabi_uidiv, 94);
        hint(__aeabi_uidiv, this::__aeabi_uidiv, 102);
        hint(__aeabi_uidiv, this::__aeabi_uidiv, 106);
        hint(__aeabi_uidiv, this::__aeabi_uidiv, 108);
        hint(__aeabi_uidiv, this::__aeabi_uidiv, 114);
        hint(__aeabi_uidiv, this::__aeabi_uidiv, 118);
        hint(__aeabi_uidiv, this::__aeabi_uidiv, 126);
        hint(__aeabi_uidiv, this::__aeabi_uidiv, 130);
        hint(__aeabi_uidiv, this::__aeabi_uidiv, 138);
        hint(__aeabi_uidiv, this::__aeabi_uidiv, 142);
        hint(__aeabi_uidiv, this::__aeabi_uidiv, 150);
        hint(__aeabi_uidiv, this::__aeabi_uidiv, 154);
        hint(__aeabi_uidiv, this::__aeabi_uidiv, 158);
        hint(__aeabi_uidiv, this::__aeabi_uidiv, 164);
        hint(__aeabi_uidiv, this::__aeabi_uidiv, 168);
        hint(__aeabi_uidiv, this::__aeabi_uidiv, 176);
        hint(__aeabi_uidiv, this::__aeabi_uidiv, 180);
        hint(__aeabi_uidiv, this::__aeabi_uidiv, 188);
        hint(__aeabi_uidiv, this::__aeabi_uidiv, 192);
        hint(__aeabi_uidiv, this::__aeabi_uidiv, 200);
        hint(__aeabi_uidiv, this::__aeabi_uidiv, 204);
        hint(__aeabi_uidiv, this::__aeabi_uidiv, 206);
        hint(__aeabi_uidiv, this::__aeabi_uidiv, 212);
        hint(__aeabi_uidiv, this::__aeabi_uidiv, 216);
        hint(__aeabi_uidiv, this::__aeabi_uidiv, 224);
        hint(__aeabi_uidiv, this::__aeabi_uidiv, 228);
        hint(__aeabi_uidiv, this::__aeabi_uidiv, 236);
        hint(__aeabi_uidiv, this::__aeabi_uidiv, 240);
        hint(__aeabi_uidiv, this::__aeabi_uidiv, 242);
        hint(__aeabi_uidiv, this::__aeabi_uidiv, 246);
        hint(__aeabi_uidiv, this::__aeabi_uidiv, 248);
        hint(__aeabi_uidiv, this::__aeabi_uidiv, 254);
        hint(__aeabi_uidiv, this::__aeabi_uidiv, 256);
        hint(__aeabi_uidiv, this::__aeabi_uidiv, 264);
        hint(__aeabi_uidivmod, this::__aeabi_uidivmod, 0);
        hint(__aeabi_uidivmod, this::__aeabi_uidivmod, 4);
        hint(__divsi3, this::__divsi3, 0);
        hint(__divsi3, this::__divsi3, 458);
        hint(__aeabi_idivmod, this::__aeabi_idivmod, 0);
        hint(__aeabi_idivmod, this::__aeabi_idivmod, 4);
        hint(__aeabi_idiv0, this::__aeabi_idiv0, 0);
        hint(__aeabi_cfrcmple, this::__aeabi_cfrcmple, 0);
        hint(__aeabi_cfcmpeq, this::__aeabi_cfcmpeq, 0);
        hint(__aeabi_cfcmpeq, this::__aeabi_cfcmpeq, 6);
        hint(__aeabi_cfcmpeq, this::__aeabi_cfcmpeq, 10);
        hint(__aeabi_cfcmpeq, this::__aeabi_cfcmpeq, 14);
        hint(__aeabi_fcmpeq, this::__aeabi_fcmpeq, 0);
        hint(__aeabi_fcmpeq, this::__aeabi_fcmpeq, 6);
        hint(__aeabi_fcmplt, this::__aeabi_fcmplt, 0);
        hint(__aeabi_fcmplt, this::__aeabi_fcmplt, 6);
        hint(__aeabi_fcmplt, this::__aeabi_fcmplt, 10);
        hint(__aeabi_fcmplt, this::__aeabi_fcmplt, 14);
        hint(__aeabi_fcmple, this::__aeabi_fcmple, 0);
        hint(__aeabi_fcmple, this::__aeabi_fcmple, 6);
        hint(__aeabi_fcmple, this::__aeabi_fcmple, 10);
        hint(__aeabi_fcmple, this::__aeabi_fcmple, 14);
        hint(__aeabi_fcmpgt, this::__aeabi_fcmpgt, 0);
        hint(__aeabi_fcmpgt, this::__aeabi_fcmpgt, 6);
        hint(__aeabi_fcmpgt, this::__aeabi_fcmpgt, 10);
        hint(__aeabi_fcmpgt, this::__aeabi_fcmpgt, 14);
        hint(__aeabi_fcmpge, this::__aeabi_fcmpge, 0);
        hint(__aeabi_fcmpge, this::__aeabi_fcmpge, 6);
        hint(__aeabi_fcmpge, this::__aeabi_fcmpge, 10);
        hint(__aeabi_fcmpge, this::__aeabi_fcmpge, 14);
        hint(__fixunssfsi, this::__fixunssfsi, 0);
        hint(__fixunssfsi, this::__fixunssfsi, 12);
        hint(__fixunssfsi, this::__fixunssfsi, 22);
        hint(__fixunssfsi, this::__fixunssfsi, 34);
        hint(__fixunssfsi, this::__fixunssfsi, 38);
        hint(__aeabi_fadd, this::__aeabi_fadd, 0);
        hint(__aeabi_fadd, this::__aeabi_fadd, 46);
        hint(__aeabi_fadd, this::__aeabi_fadd, 50);
        hint(__aeabi_fadd, this::__aeabi_fadd, 54);
        hint(__aeabi_fadd, this::__aeabi_fadd, 58);
        hint(__aeabi_fadd, this::__aeabi_fadd, 60);
        hint(__aeabi_fadd, this::__aeabi_fadd, 66);
        hint(__aeabi_fadd, this::__aeabi_fadd, 68);
        hint(__aeabi_fadd, this::__aeabi_fadd, 74);
        hint(__aeabi_fadd, this::__aeabi_fadd, 94);
        hint(__aeabi_fadd, this::__aeabi_fadd, 98);
        hint(__aeabi_fadd, this::__aeabi_fadd, 100);
        hint(__aeabi_fadd, this::__aeabi_fadd, 108);
        hint(__aeabi_fadd, this::__aeabi_fadd, 110);
        hint(__aeabi_fadd, this::__aeabi_fadd, 116);
        hint(__aeabi_fadd, this::__aeabi_fadd, 118);
        hint(__aeabi_fadd, this::__aeabi_fadd, 122);
        hint(__aeabi_fadd, this::__aeabi_fadd, 130);
        hint(__aeabi_fadd, this::__aeabi_fadd, 134);
        hint(__aeabi_fadd, this::__aeabi_fadd, 136);
        hint(__aeabi_fadd, this::__aeabi_fadd, 140);
        hint(__aeabi_fadd, this::__aeabi_fadd, 144);
        hint(__aeabi_fadd, this::__aeabi_fadd, 150);
        hint(__aeabi_fadd, this::__aeabi_fadd, 154);
        hint(__aeabi_fadd, this::__aeabi_fadd, 156);
        hint(__aeabi_fadd, this::__aeabi_fadd, 172);
        hint(__aeabi_fadd, this::__aeabi_fadd, 174);
        hint(__aeabi_fadd, this::__aeabi_fadd, 178);
        hint(__aeabi_fadd, this::__aeabi_fadd, 184);
        hint(__aeabi_fadd, this::__aeabi_fadd, 186);
        hint(__aeabi_fadd, this::__aeabi_fadd, 204);
        hint(__aeabi_fadd, this::__aeabi_fadd, 208);
        hint(__aeabi_fadd, this::__aeabi_fadd, 214);
        hint(__aeabi_fadd, this::__aeabi_fadd, 218);
        hint(__aeabi_fadd, this::__aeabi_fadd, 220);
        hint(__aeabi_fadd, this::__aeabi_fadd, 236);
        hint(__aeabi_fadd, this::__aeabi_fadd, 238);
        hint(__aeabi_fadd, this::__aeabi_fadd, 242);
        hint(__aeabi_fadd, this::__aeabi_fadd, 246);
        hint(__aeabi_fadd, this::__aeabi_fadd, 252);
        hint(__aeabi_fadd, this::__aeabi_fadd, 260);
        hint(__aeabi_fadd, this::__aeabi_fadd, 288);
        hint(__aeabi_fadd, this::__aeabi_fadd, 298);
        hint(__aeabi_fadd, this::__aeabi_fadd, 306);
        hint(__aeabi_fadd, this::__aeabi_fadd, 308);
        hint(__aeabi_fadd, this::__aeabi_fadd, 312);
        hint(__aeabi_fadd, this::__aeabi_fadd, 314);
        hint(__aeabi_fadd, this::__aeabi_fadd, 322);
        hint(__aeabi_fadd, this::__aeabi_fadd, 328);
        hint(__aeabi_fadd, this::__aeabi_fadd, 332);
        hint(__aeabi_fadd, this::__aeabi_fadd, 336);
        hint(__aeabi_fadd, this::__aeabi_fadd, 338);
        hint(__aeabi_fadd, this::__aeabi_fadd, 342);
        hint(__aeabi_fadd, this::__aeabi_fadd, 346);
        hint(__aeabi_fadd, this::__aeabi_fadd, 360);
        hint(__aeabi_fadd, this::__aeabi_fadd, 366);
        hint(__aeabi_fadd, this::__aeabi_fadd, 370);
        hint(__aeabi_fadd, this::__aeabi_fadd, 372);
        hint(__aeabi_fadd, this::__aeabi_fadd, 376);
        hint(__aeabi_fadd, this::__aeabi_fadd, 380);
        hint(__aeabi_fadd, this::__aeabi_fadd, 388);
        hint(__aeabi_fadd, this::__aeabi_fadd, 392);
        hint(__aeabi_fadd, this::__aeabi_fadd, 394);
        hint(__aeabi_fadd, this::__aeabi_fadd, 410);
        hint(__aeabi_fadd, this::__aeabi_fadd, 418);
        hint(__aeabi_fadd, this::__aeabi_fadd, 424);
        hint(__aeabi_fadd, this::__aeabi_fadd, 426);
        hint(__aeabi_fadd, this::__aeabi_fadd, 436);
        hint(__aeabi_fadd, this::__aeabi_fadd, 438);
        hint(__aeabi_fadd, this::__aeabi_fadd, 442);
        hint(__aeabi_fadd, this::__aeabi_fadd, 450);
        hint(__aeabi_fadd, this::__aeabi_fadd, 454);
        hint(__aeabi_fadd, this::__aeabi_fadd, 464);
        hint(__aeabi_fadd, this::__aeabi_fadd, 476);
        hint(__aeabi_fadd, this::__aeabi_fadd, 480);
        hint(__aeabi_fadd, this::__aeabi_fadd, 484);
        hint(__aeabi_fadd, this::__aeabi_fadd, 488);
        hint(__aeabi_fadd, this::__aeabi_fadd, 490);
        hint(__aeabi_fadd, this::__aeabi_fadd, 498);
        hint(__aeabi_fadd, this::__aeabi_fadd, 504);
        hint(__aeabi_fadd, this::__aeabi_fadd, 506);
        hint(__aeabi_fadd, this::__aeabi_fadd, 510);
        hint(__aeabi_fadd, this::__aeabi_fadd, 512);
        hint(__aeabi_fadd, this::__aeabi_fadd, 514);
        hint(__aeabi_fadd, this::__aeabi_fadd, 520);
        hint(__aeabi_fadd, this::__aeabi_fadd, 524);
        hint(__aeabi_fadd, this::__aeabi_fadd, 530);
        hint(__aeabi_fadd, this::__aeabi_fadd, 536);
        hint(__aeabi_fadd, this::__aeabi_fadd, 540);
        hint(__aeabi_fadd, this::__aeabi_fadd, 544);
        hint(__aeabi_fadd, this::__aeabi_fadd, 554);
        hint(__aeabi_fadd, this::__aeabi_fadd, 562);
        hint(__aeabi_fadd, this::__aeabi_fadd, 566);
        hint(__aeabi_fadd, this::__aeabi_fadd, 570);
        hint(__aeabi_fadd, this::__aeabi_fadd, 574);
        hint(__aeabi_fadd, this::__aeabi_fadd, 578);
        hint(__aeabi_fadd, this::__aeabi_fadd, 582);
        hint(__aeabi_fadd, this::__aeabi_fadd, 586);
        hint(__aeabi_fadd, this::__aeabi_fadd, 592);
        hint(__aeabi_fadd, this::__aeabi_fadd, 594);
        hint(__aeabi_fadd, this::__aeabi_fadd, 600);
        hint(__aeabi_fadd, this::__aeabi_fadd, 604);
        hint(__aeabi_fadd, this::__aeabi_fadd, 608);
        hint(__aeabi_fadd, this::__aeabi_fadd, 612);
        hint(__aeabi_fadd, this::__aeabi_fadd, 618);
        hint(__aeabi_fadd, this::__aeabi_fadd, 630);
        hint(__aeabi_fadd, this::__aeabi_fadd, 634);
        hint(__aeabi_fadd, this::__aeabi_fadd, 638);
        hint(__aeabi_fadd, this::__aeabi_fadd, 646);
        hint(__aeabi_fadd, this::__aeabi_fadd, 650);
        hint(__aeabi_fadd, this::__aeabi_fadd, 666);
        hint(__aeabi_fadd, this::__aeabi_fadd, 672);
        hint(__aeabi_fadd, this::__aeabi_fadd, 676);
        hint(__aeabi_fadd, this::__aeabi_fadd, 680);
        hint(__aeabi_fadd, this::__aeabi_fadd, 682);
        hint(__aeabi_fadd, this::__aeabi_fadd, 692);
        hint(__aeabi_fadd, this::__aeabi_fadd, 698);
        hint(__aeabi_fadd, this::__aeabi_fadd, 700);
        hint(__aeabi_fadd, this::__aeabi_fadd, 706);
        hint(__aeabi_fadd, this::__aeabi_fadd, 710);
        hint(__aeabi_fadd, this::__aeabi_fadd, 712);
        hint(__aeabi_fadd, this::__aeabi_fadd, 718);
        hint(__aeabi_fadd, this::__aeabi_fadd, 728);
        hint(__aeabi_fadd, this::__aeabi_fadd, 734);
        hint(__aeabi_fadd, this::__aeabi_fadd, 736);
        hint(__aeabi_fadd, this::__aeabi_fadd, 746);
        hint(__aeabi_fadd, this::__aeabi_fadd, 752);
        hint(__aeabi_fadd, this::__aeabi_fadd, 756);
        hint(__aeabi_fadd, this::__aeabi_fadd, 766);
        hint(__aeabi_fadd, this::__aeabi_fadd, 768);
        hint(__aeabi_fadd, this::__aeabi_fadd, 776);
        hint(__aeabi_fadd, this::__aeabi_fadd, 780);
        hint(__aeabi_fadd, this::__aeabi_fadd, 786);
        hint(__aeabi_fadd, this::__aeabi_fadd, 790);
        hint(__aeabi_fadd, this::__aeabi_fadd, 794);
        hint(__aeabi_fadd, this::__aeabi_fadd, 798);
        hint(__aeabi_fadd, this::__aeabi_fadd, 800);
        hint(__aeabi_fadd, this::__aeabi_fadd, 806);
        hint(__aeabi_fdiv, this::__aeabi_fdiv, 0);
        hint(__aeabi_fdiv, this::__aeabi_fdiv, 28);
        hint(__aeabi_fdiv, this::__aeabi_fdiv, 32);
        hint(__aeabi_fdiv, this::__aeabi_fdiv, 48);
        hint(__aeabi_fdiv, this::__aeabi_fdiv, 68);
        hint(__aeabi_fdiv, this::__aeabi_fdiv, 72);
        hint(__aeabi_fdiv, this::__aeabi_fdiv, 86);
        hint(__aeabi_fdiv, this::__aeabi_fdiv, 96);
        hint(__aeabi_fdiv, this::__aeabi_fdiv, 98);
        hint(__aeabi_fdiv, this::__aeabi_fdiv, 106);
        hint(__aeabi_fdiv, this::__aeabi_fdiv, 110);
        hint(__aeabi_fdiv, this::__aeabi_fdiv, 140);
        hint(__aeabi_fdiv, this::__aeabi_fdiv, 148);
        hint(__aeabi_fdiv, this::__aeabi_fdiv, 152);
        hint(__aeabi_fdiv, this::__aeabi_fdiv, 160);
        hint(__aeabi_fdiv, this::__aeabi_fdiv, 162);
        hint(__aeabi_fdiv, this::__aeabi_fdiv, 166);
        hint(__aeabi_fdiv, this::__aeabi_fdiv, 174);
        hint(__aeabi_fdiv, this::__aeabi_fdiv, 178);
        hint(__aeabi_fdiv, this::__aeabi_fdiv, 186);
        hint(__aeabi_fdiv, this::__aeabi_fdiv, 190);
        hint(__aeabi_fdiv, this::__aeabi_fdiv, 214);
        hint(__aeabi_fdiv, this::__aeabi_fdiv, 222);
        hint(__aeabi_fdiv, this::__aeabi_fdiv, 228);
        hint(__aeabi_fdiv, this::__aeabi_fdiv, 232);
        hint(__aeabi_fdiv, this::__aeabi_fdiv, 244);
        hint(__aeabi_fdiv, this::__aeabi_fdiv, 250);
        hint(__aeabi_fdiv, this::__aeabi_fdiv, 252);
        hint(__aeabi_fdiv, this::__aeabi_fdiv, 264);
        hint(__aeabi_fdiv, this::__aeabi_fdiv, 272);
        hint(__aeabi_fdiv, this::__aeabi_fdiv, 276);
        hint(__aeabi_fdiv, this::__aeabi_fdiv, 280);
        hint(__aeabi_fdiv, this::__aeabi_fdiv, 292);
        hint(__aeabi_fdiv, this::__aeabi_fdiv, 298);
        hint(__aeabi_fdiv, this::__aeabi_fdiv, 316);
        hint(__aeabi_fdiv, this::__aeabi_fdiv, 328);
        hint(__aeabi_fdiv, this::__aeabi_fdiv, 334);
        hint(__aeabi_fdiv, this::__aeabi_fdiv, 382);
        hint(__aeabi_fdiv, this::__aeabi_fdiv, 390);
        hint(__aeabi_fdiv, this::__aeabi_fdiv, 396);
        hint(__aeabi_fdiv, this::__aeabi_fdiv, 398);
        hint(__aeabi_fdiv, this::__aeabi_fdiv, 408);
        hint(__aeabi_fdiv, this::__aeabi_fdiv, 412);
        hint(__aeabi_fdiv, this::__aeabi_fdiv, 416);
        hint(__aeabi_fdiv, this::__aeabi_fdiv, 422);
        hint(__aeabi_fdiv, this::__aeabi_fdiv, 464);
        hint(__aeabi_fdiv, this::__aeabi_fdiv, 472);
        hint(__aeabi_fdiv, this::__aeabi_fdiv, 492);
        hint(__aeabi_fdiv, this::__aeabi_fdiv, 500);
        hint(__aeabi_fdiv, this::__aeabi_fdiv, 502);
        hint(__aeabi_fdiv, this::__aeabi_fdiv, 506);
        hint(__aeabi_fdiv, this::__aeabi_fdiv, 514);
        hint(__eqsf2, this::__eqsf2, 0);
        hint(__gesf2, this::__gesf2, 0);
        hint(__ltsf2, this::__ltsf2, 0);
        hint(__aeabi_fmul, this::__aeabi_fmul, 0);
        hint(__aeabi_fmul, this::__aeabi_fmul, 2);
        hint(__aeabi_fmul, this::__aeabi_fmul, 4);
        hint(__aeabi_fmul, this::__aeabi_fmul, 6);
        hint(__aeabi_fmul, this::__aeabi_fmul, 8);
        hint(__aeabi_fmul, this::__aeabi_fmul, 10);
        hint(__aeabi_fmul, this::__aeabi_fmul, 12);
    }

    private void gen_hints_15() {
        hint(__aeabi_fmul, this::__aeabi_fmul, 14);
        hint(__aeabi_fmul, this::__aeabi_fmul, 16);
        hint(__aeabi_fmul, this::__aeabi_fmul, 18);
        hint(__aeabi_fmul, this::__aeabi_fmul, 20);
        hint(__aeabi_fmul, this::__aeabi_fmul, 22);
        hint(__aeabi_fmul, this::__aeabi_fmul, 24);
        hint(__aeabi_fmul, this::__aeabi_fmul, 26);
        hint(__aeabi_fmul, this::__aeabi_fmul, 28);
        hint(__aeabi_fmul, this::__aeabi_fmul, 30);
        hint(__aeabi_fmul, this::__aeabi_fmul, 32);
        hint(__aeabi_fmul, this::__aeabi_fmul, 34);
        hint(__aeabi_fmul, this::__aeabi_fmul, 36);
        hint(__aeabi_fmul, this::__aeabi_fmul, 38);
        hint(__aeabi_fmul, this::__aeabi_fmul, 40);
        hint(__aeabi_fmul, this::__aeabi_fmul, 42);
        hint(__aeabi_fmul, this::__aeabi_fmul, 44);
        hint(__aeabi_fmul, this::__aeabi_fmul, 46);
        hint(__aeabi_fmul, this::__aeabi_fmul, 48);
        hint(__aeabi_fmul, this::__aeabi_fmul, 50);
        hint(__aeabi_fmul, this::__aeabi_fmul, 52);
        hint(__aeabi_fmul, this::__aeabi_fmul, 54);
        hint(__aeabi_fmul, this::__aeabi_fmul, 56);
        hint(__aeabi_fmul, this::__aeabi_fmul, 58);
        hint(__aeabi_fmul, this::__aeabi_fmul, 60);
        hint(__aeabi_fmul, this::__aeabi_fmul, 62);
        hint(__aeabi_fmul, this::__aeabi_fmul, 64);
        hint(__aeabi_fmul, this::__aeabi_fmul, 66);
        hint(__aeabi_fmul, this::__aeabi_fmul, 68);
        hint(__aeabi_fmul, this::__aeabi_fmul, 70);
        hint(__aeabi_fmul, this::__aeabi_fmul, 72);
        hint(__aeabi_fmul, this::__aeabi_fmul, 74);
        hint(__aeabi_fmul, this::__aeabi_fmul, 76);
        hint(__aeabi_fmul, this::__aeabi_fmul, 78);
        hint(__aeabi_fmul, this::__aeabi_fmul, 80);
        hint(__aeabi_fmul, this::__aeabi_fmul, 82);
        hint(__aeabi_fmul, this::__aeabi_fmul, 84);
        hint(__aeabi_fmul, this::__aeabi_fmul, 86);
        hint(__aeabi_fmul, this::__aeabi_fmul, 88);
        hint(__aeabi_fmul, this::__aeabi_fmul, 90);
        hint(__aeabi_fmul, this::__aeabi_fmul, 92);
        hint(__aeabi_fmul, this::__aeabi_fmul, 94);
        hint(__aeabi_fmul, this::__aeabi_fmul, 96);
        hint(__aeabi_fmul, this::__aeabi_fmul, 98);
        hint(__aeabi_fmul, this::__aeabi_fmul, 100);
        hint(__aeabi_fmul, this::__aeabi_fmul, 102);
        hint(__aeabi_fmul, this::__aeabi_fmul, 104);
        hint(__aeabi_fmul, this::__aeabi_fmul, 106);
        hint(__aeabi_fmul, this::__aeabi_fmul, 108);
        hint(__aeabi_fmul, this::__aeabi_fmul, 110);
        hint(__aeabi_fmul, this::__aeabi_fmul, 112);
        hint(__aeabi_fmul, this::__aeabi_fmul, 114);
        hint(__aeabi_fmul, this::__aeabi_fmul, 116);
        hint(__aeabi_fmul, this::__aeabi_fmul, 118);
        hint(__aeabi_fmul, this::__aeabi_fmul, 120);
        hint(__aeabi_fmul, this::__aeabi_fmul, 122);
        hint(__aeabi_fmul, this::__aeabi_fmul, 124);
        hint(__aeabi_fmul, this::__aeabi_fmul, 126);
        hint(__aeabi_fmul, this::__aeabi_fmul, 128);
        hint(__aeabi_fmul, this::__aeabi_fmul, 130);
        hint(__aeabi_fmul, this::__aeabi_fmul, 132);
        hint(__aeabi_fmul, this::__aeabi_fmul, 134);
        hint(__aeabi_fmul, this::__aeabi_fmul, 136);
        hint(__aeabi_fmul, this::__aeabi_fmul, 138);
        hint(__aeabi_fmul, this::__aeabi_fmul, 140);
        hint(__aeabi_fmul, this::__aeabi_fmul, 142);
        hint(__aeabi_fmul, this::__aeabi_fmul, 144);
        hint(__aeabi_fmul, this::__aeabi_fmul, 146);
        hint(__aeabi_fmul, this::__aeabi_fmul, 148);
        hint(__aeabi_fmul, this::__aeabi_fmul, 150);
        hint(__aeabi_fmul, this::__aeabi_fmul, 152);
        hint(__aeabi_fmul, this::__aeabi_fmul, 154);
        hint(__aeabi_fmul, this::__aeabi_fmul, 156);
        hint(__aeabi_fmul, this::__aeabi_fmul, 158);
        hint(__aeabi_fmul, this::__aeabi_fmul, 160);
        hint(__aeabi_fmul, this::__aeabi_fmul, 162);
        hint(__aeabi_fmul, this::__aeabi_fmul, 164);
        hint(__aeabi_fmul, this::__aeabi_fmul, 166);
        hint(__aeabi_fmul, this::__aeabi_fmul, 168);
        hint(__aeabi_fmul, this::__aeabi_fmul, 170);
        hint(__aeabi_fmul, this::__aeabi_fmul, 172);
        hint(__aeabi_fmul, this::__aeabi_fmul, 174);
        hint(__aeabi_fmul, this::__aeabi_fmul, 176);
        hint(__aeabi_fmul, this::__aeabi_fmul, 178);
        hint(__aeabi_fmul, this::__aeabi_fmul, 180);
        hint(__aeabi_fmul, this::__aeabi_fmul, 182);
        hint(__aeabi_fmul, this::__aeabi_fmul, 184);
        hint(__aeabi_fmul, this::__aeabi_fmul, 186);
        hint(__aeabi_fmul, this::__aeabi_fmul, 188);
        hint(__aeabi_fmul, this::__aeabi_fmul, 190);
        hint(__aeabi_fmul, this::__aeabi_fmul, 192);
        hint(__aeabi_fmul, this::__aeabi_fmul, 194);
        hint(__aeabi_fmul, this::__aeabi_fmul, 196);
        hint(__aeabi_fmul, this::__aeabi_fmul, 198);
        hint(__aeabi_fmul, this::__aeabi_fmul, 200);
        hint(__aeabi_fmul, this::__aeabi_fmul, 202);
        hint(__aeabi_fmul, this::__aeabi_fmul, 204);
        hint(__aeabi_fmul, this::__aeabi_fmul, 206);
        hint(__aeabi_fmul, this::__aeabi_fmul, 208);
        hint(__aeabi_fmul, this::__aeabi_fmul, 210);
        hint(__aeabi_fmul, this::__aeabi_fmul, 212);
        hint(__aeabi_fmul, this::__aeabi_fmul, 214);
        hint(__aeabi_fmul, this::__aeabi_fmul, 216);
        hint(__aeabi_fmul, this::__aeabi_fmul, 218);
        hint(__aeabi_fmul, this::__aeabi_fmul, 220);
        hint(__aeabi_fmul, this::__aeabi_fmul, 222);
        hint(__aeabi_fmul, this::__aeabi_fmul, 224);
        hint(__aeabi_fmul, this::__aeabi_fmul, 226);
        hint(__aeabi_fmul, this::__aeabi_fmul, 228);
        hint(__aeabi_fmul, this::__aeabi_fmul, 230);
        hint(__aeabi_fmul, this::__aeabi_fmul, 232);
        hint(__aeabi_fmul, this::__aeabi_fmul, 234);
        hint(__aeabi_fmul, this::__aeabi_fmul, 236);
        hint(__aeabi_fmul, this::__aeabi_fmul, 238);
        hint(__aeabi_fmul, this::__aeabi_fmul, 240);
        hint(__aeabi_fmul, this::__aeabi_fmul, 242);
        hint(__aeabi_fmul, this::__aeabi_fmul, 244);
        hint(__aeabi_fmul, this::__aeabi_fmul, 246);
        hint(__aeabi_fmul, this::__aeabi_fmul, 248);
        hint(__aeabi_fmul, this::__aeabi_fmul, 250);
        hint(__aeabi_fmul, this::__aeabi_fmul, 252);
        hint(__aeabi_fmul, this::__aeabi_fmul, 254);
        hint(__aeabi_fmul, this::__aeabi_fmul, 256);
        hint(__aeabi_fmul, this::__aeabi_fmul, 258);
        hint(__aeabi_fmul, this::__aeabi_fmul, 260);
        hint(__aeabi_fmul, this::__aeabi_fmul, 262);
        hint(__aeabi_fmul, this::__aeabi_fmul, 264);
        hint(__aeabi_fmul, this::__aeabi_fmul, 266);
        hint(__aeabi_fmul, this::__aeabi_fmul, 268);
        hint(__aeabi_fmul, this::__aeabi_fmul, 270);
        hint(__aeabi_fmul, this::__aeabi_fmul, 272);
        hint(__aeabi_fmul, this::__aeabi_fmul, 274);
        hint(__aeabi_fmul, this::__aeabi_fmul, 276);
        hint(__aeabi_fmul, this::__aeabi_fmul, 278);
        hint(__aeabi_fmul, this::__aeabi_fmul, 280);
        hint(__aeabi_fmul, this::__aeabi_fmul, 282);
        hint(__aeabi_fmul, this::__aeabi_fmul, 284);
        hint(__aeabi_fmul, this::__aeabi_fmul, 286);
        hint(__aeabi_fmul, this::__aeabi_fmul, 288);
        hint(__aeabi_fmul, this::__aeabi_fmul, 290);
        hint(__aeabi_fmul, this::__aeabi_fmul, 292);
        hint(__aeabi_fmul, this::__aeabi_fmul, 294);
        hint(__aeabi_fmul, this::__aeabi_fmul, 296);
        hint(__aeabi_fmul, this::__aeabi_fmul, 298);
        hint(__aeabi_fmul, this::__aeabi_fmul, 300);
        hint(__aeabi_fmul, this::__aeabi_fmul, 302);
        hint(__aeabi_fmul, this::__aeabi_fmul, 304);
        hint(__aeabi_fmul, this::__aeabi_fmul, 306);
        hint(__aeabi_fmul, this::__aeabi_fmul, 308);
        hint(__aeabi_fmul, this::__aeabi_fmul, 310);
        hint(__aeabi_fmul, this::__aeabi_fmul, 312);
        hint(__aeabi_fmul, this::__aeabi_fmul, 314);
        hint(__aeabi_fmul, this::__aeabi_fmul, 316);
        hint(__aeabi_fmul, this::__aeabi_fmul, 318);
        hint(__aeabi_fmul, this::__aeabi_fmul, 320);
        hint(__aeabi_fmul, this::__aeabi_fmul, 322);
        hint(__aeabi_fmul, this::__aeabi_fmul, 324);
        hint(__aeabi_fmul, this::__aeabi_fmul, 326);
        hint(__aeabi_fmul, this::__aeabi_fmul, 328);
        hint(__aeabi_fmul, this::__aeabi_fmul, 330);
        hint(__aeabi_fmul, this::__aeabi_fmul, 332);
        hint(__aeabi_fmul, this::__aeabi_fmul, 334);
        hint(__aeabi_fmul, this::__aeabi_fmul, 336);
        hint(__aeabi_fmul, this::__aeabi_fmul, 338);
        hint(__aeabi_fmul, this::__aeabi_fmul, 340);
        hint(__aeabi_fmul, this::__aeabi_fmul, 342);
        hint(__aeabi_fmul, this::__aeabi_fmul, 344);
        hint(__aeabi_fmul, this::__aeabi_fmul, 346);
        hint(__aeabi_fmul, this::__aeabi_fmul, 348);
        hint(__aeabi_fmul, this::__aeabi_fmul, 350);
        hint(__aeabi_fmul, this::__aeabi_fmul, 352);
        hint(__aeabi_fmul, this::__aeabi_fmul, 354);
        hint(__aeabi_fmul, this::__aeabi_fmul, 356);
        hint(__aeabi_fmul, this::__aeabi_fmul, 358);
        hint(__aeabi_fmul, this::__aeabi_fmul, 360);
        hint(__aeabi_fmul, this::__aeabi_fmul, 362);
        hint(__aeabi_fmul, this::__aeabi_fmul, 364);
        hint(__aeabi_fmul, this::__aeabi_fmul, 366);
        hint(__aeabi_fmul, this::__aeabi_fmul, 368);
        hint(__aeabi_fmul, this::__aeabi_fmul, 370);
        hint(__aeabi_fmul, this::__aeabi_fmul, 372);
        hint(__aeabi_fmul, this::__aeabi_fmul, 374);
        hint(__aeabi_fmul, this::__aeabi_fmul, 376);
        hint(__aeabi_fmul, this::__aeabi_fmul, 378);
        hint(__aeabi_fmul, this::__aeabi_fmul, 380);
        hint(__aeabi_fmul, this::__aeabi_fmul, 382);
        hint(__aeabi_fmul, this::__aeabi_fmul, 384);
        hint(__aeabi_fmul, this::__aeabi_fmul, 386);
        hint(__aeabi_fmul, this::__aeabi_fmul, 388);
        hint(__aeabi_fmul, this::__aeabi_fmul, 390);
        hint(__aeabi_fmul, this::__aeabi_fmul, 392);
        hint(__aeabi_fmul, this::__aeabi_fmul, 394);
        hint(__aeabi_fmul, this::__aeabi_fmul, 396);
        hint(__aeabi_fmul, this::__aeabi_fmul, 398);
        hint(__aeabi_fmul, this::__aeabi_fmul, 400);
        hint(__aeabi_fmul, this::__aeabi_fmul, 402);
        hint(__aeabi_fmul, this::__aeabi_fmul, 404);
        hint(__aeabi_fmul, this::__aeabi_fmul, 406);
        hint(__aeabi_fmul, this::__aeabi_fmul, 408);
        hint(__aeabi_fmul, this::__aeabi_fmul, 410);
        hint(__aeabi_fmul, this::__aeabi_fmul, 412);
        hint(__aeabi_fmul, this::__aeabi_fmul, 414);
        hint(__aeabi_fmul, this::__aeabi_fmul, 416);
        hint(__aeabi_fmul, this::__aeabi_fmul, 418);
        hint(__aeabi_fmul, this::__aeabi_fmul, 420);
        hint(__aeabi_fmul, this::__aeabi_fmul, 422);
        hint(__aeabi_fmul, this::__aeabi_fmul, 424);
        hint(__aeabi_fmul, this::__aeabi_fmul, 426);
        hint(__aeabi_fmul, this::__aeabi_fmul, 428);
        hint(__aeabi_fmul, this::__aeabi_fmul, 430);
        hint(__aeabi_fmul, this::__aeabi_fmul, 432);
        hint(__aeabi_fmul, this::__aeabi_fmul, 434);
        hint(__aeabi_fmul, this::__aeabi_fmul, 436);
        hint(__aeabi_fmul, this::__aeabi_fmul, 438);
        hint(__aeabi_fmul, this::__aeabi_fmul, 440);
        hint(__aeabi_fmul, this::__aeabi_fmul, 442);
        hint(__aeabi_fmul, this::__aeabi_fmul, 444);
        hint(__aeabi_fmul, this::__aeabi_fmul, 446);
        hint(__aeabi_fmul, this::__aeabi_fmul, 448);
        hint(__aeabi_fmul, this::__aeabi_fmul, 450);
        hint(__aeabi_fmul, this::__aeabi_fmul, 452);
        hint(__aeabi_fmul, this::__aeabi_fmul, 454);
        hint(__aeabi_fmul, this::__aeabi_fmul, 456);
        hint(__aeabi_fmul, this::__aeabi_fmul, 458);
        hint(__aeabi_fmul, this::__aeabi_fmul, 460);
        hint(__aeabi_fmul, this::__aeabi_fmul, 462);
        hint(__aeabi_fmul, this::__aeabi_fmul, 464);
        hint(__aeabi_fmul, this::__aeabi_fmul, 466);
        hint(__aeabi_fmul, this::__aeabi_fmul, 468);
        hint(__aeabi_fmul, this::__aeabi_fmul, 470);
        hint(__aeabi_fmul, this::__aeabi_fmul, 472);
        hint(__aeabi_fmul, this::__aeabi_fmul, 474);
        hint(__aeabi_fmul, this::__aeabi_fmul, 476);
        hint(__aeabi_fmul, this::__aeabi_fmul, 478);
        hint(__aeabi_fmul, this::__aeabi_fmul, 480);
        hint(__aeabi_fmul, this::__aeabi_fmul, 482);
        hint(__aeabi_fmul, this::__aeabi_fmul, 484);
        hint(__aeabi_fmul, this::__aeabi_fmul, 486);
        hint(__aeabi_fmul, this::__aeabi_fmul, 488);
        hint(__aeabi_fmul, this::__aeabi_fmul, 490);
        hint(__aeabi_fmul, this::__aeabi_fmul, 492);
        hint(__aeabi_fmul, this::__aeabi_fmul, 494);
        hint(__aeabi_fmul, this::__aeabi_fmul, 496);
        hint(__aeabi_fmul, this::__aeabi_fmul, 498);
        hint(__aeabi_fmul, this::__aeabi_fmul, 500);
        hint(__aeabi_fmul, this::__aeabi_fmul, 502);
        hint(__aeabi_fmul, this::__aeabi_fmul, 504);
        hint(__aeabi_fmul, this::__aeabi_fmul, 506);
        hint(__aeabi_fmul, this::__aeabi_fmul, 508);
        hint(__aeabi_fmul, this::__aeabi_fmul, 510);
        hint(__aeabi_fmul, this::__aeabi_fmul, 512);
        hint(__aeabi_fmul, this::__aeabi_fmul, 514);
        hint(__aeabi_fmul, this::__aeabi_fmul, 516);
        hint(__aeabi_fmul, this::__aeabi_fmul, 518);
        hint(__aeabi_fmul, this::__aeabi_fmul, 520);
        hint(__aeabi_fmul, this::__aeabi_fmul, 522);
        hint(__aeabi_fmul, this::__aeabi_fmul, 524);
        hint(__aeabi_fmul, this::__aeabi_fmul, 526);
        hint(__aeabi_fmul, this::__aeabi_fmul, 528);
        hint(__aeabi_fmul, this::__aeabi_fmul, 530);
        hint(__aeabi_fmul, this::__aeabi_fmul, 532);
        hint(__aeabi_fmul, this::__aeabi_fmul, 534);
        hint(__aeabi_fmul, this::__aeabi_fmul, 536);
        hint(__aeabi_fmul, this::__aeabi_fmul, 538);
        hint(__aeabi_fmul, this::__aeabi_fmul, 540);
        hint(__aeabi_fmul, this::__aeabi_fmul, 542);
        hint(__aeabi_fmul, this::__aeabi_fmul, 544);
        hint(__aeabi_fmul, this::__aeabi_fmul, 546);
        hint(__aeabi_fmul, this::__aeabi_fmul, 548);
        hint(__aeabi_fmul, this::__aeabi_fmul, 550);
        hint(__aeabi_fmul, this::__aeabi_fmul, 552);
        hint(__aeabi_fmul, this::__aeabi_fmul, 554);
        hint(__aeabi_fmul, this::__aeabi_fmul, 556);
        hint(__aeabi_fmul, this::__aeabi_fmul, 558);
        hint(__aeabi_fmul, this::__aeabi_fmul, 560);
        hint(__aeabi_fmul, this::__aeabi_fmul, 562);
        hint(__aeabi_fmul, this::__aeabi_fmul, 564);
        hint(__aeabi_fmul, this::__aeabi_fmul, 566);
        hint(__aeabi_fmul, this::__aeabi_fmul, 568);
        hint(__aeabi_fmul, this::__aeabi_fmul, 570);
        hint(__aeabi_fmul, this::__aeabi_fmul, 572);
        hint(__aeabi_fmul, this::__aeabi_fmul, 574);
        hint(__aeabi_fmul, this::__aeabi_fmul, 576);
        hint(__aeabi_fmul, this::__aeabi_fmul, 578);
        hint(__aeabi_fmul, this::__aeabi_fmul, 580);
        hint(__aeabi_fmul, this::__aeabi_fmul, 582);
        hint(__aeabi_fmul, this::__aeabi_fmul, 584);
        hint(__aeabi_fsub, this::__aeabi_fsub, 0);
        hint(__aeabi_fsub, this::__aeabi_fsub, 46);
        hint(__aeabi_fsub, this::__aeabi_fsub, 48);
        hint(__aeabi_fsub, this::__aeabi_fsub, 52);
        hint(__aeabi_fsub, this::__aeabi_fsub, 58);
        hint(__aeabi_fsub, this::__aeabi_fsub, 62);
        hint(__aeabi_fsub, this::__aeabi_fsub, 66);
        hint(__aeabi_fsub, this::__aeabi_fsub, 68);
        hint(__aeabi_fsub, this::__aeabi_fsub, 74);
        hint(__aeabi_fsub, this::__aeabi_fsub, 76);
        hint(__aeabi_fsub, this::__aeabi_fsub, 82);
        hint(__aeabi_fsub, this::__aeabi_fsub, 84);
        hint(__aeabi_fsub, this::__aeabi_fsub, 86);
        hint(__aeabi_fsub, this::__aeabi_fsub, 90);
        hint(__aeabi_fsub, this::__aeabi_fsub, 92);
        hint(__aeabi_fsub, this::__aeabi_fsub, 96);
        hint(__aeabi_fsub, this::__aeabi_fsub, 102);
        hint(__aeabi_fsub, this::__aeabi_fsub, 110);
        hint(__aeabi_fsub, this::__aeabi_fsub, 112);
        hint(__aeabi_fsub, this::__aeabi_fsub, 138);
        hint(__aeabi_fsub, this::__aeabi_fsub, 148);
        hint(__aeabi_fsub, this::__aeabi_fsub, 156);
        hint(__aeabi_fsub, this::__aeabi_fsub, 158);
        hint(__aeabi_fsub, this::__aeabi_fsub, 162);
        hint(__aeabi_fsub, this::__aeabi_fsub, 164);
        hint(__aeabi_fsub, this::__aeabi_fsub, 172);
        hint(__aeabi_fsub, this::__aeabi_fsub, 174);
        hint(__aeabi_fsub, this::__aeabi_fsub, 178);
        hint(__aeabi_fsub, this::__aeabi_fsub, 198);
        hint(__aeabi_fsub, this::__aeabi_fsub, 202);
        hint(__aeabi_fsub, this::__aeabi_fsub, 210);
        hint(__aeabi_fsub, this::__aeabi_fsub, 212);
        hint(__aeabi_fsub, this::__aeabi_fsub, 220);
        hint(__aeabi_fsub, this::__aeabi_fsub, 222);
        hint(__aeabi_fsub, this::__aeabi_fsub, 226);
        hint(__aeabi_fsub, this::__aeabi_fsub, 234);
        hint(__aeabi_fsub, this::__aeabi_fsub, 238);
        hint(__aeabi_fsub, this::__aeabi_fsub, 240);
        hint(__aeabi_fsub, this::__aeabi_fsub, 244);
        hint(__aeabi_fsub, this::__aeabi_fsub, 248);
        hint(__aeabi_fsub, this::__aeabi_fsub, 258);
        hint(__aeabi_fsub, this::__aeabi_fsub, 264);
        hint(__aeabi_fsub, this::__aeabi_fsub, 284);
        hint(__aeabi_fsub, this::__aeabi_fsub, 286);
        hint(__aeabi_fsub, this::__aeabi_fsub, 290);
        hint(__aeabi_fsub, this::__aeabi_fsub, 296);
        hint(__aeabi_fsub, this::__aeabi_fsub, 298);
        hint(__aeabi_fsub, this::__aeabi_fsub, 316);
        hint(__aeabi_fsub, this::__aeabi_fsub, 320);
        hint(__aeabi_fsub, this::__aeabi_fsub, 322);
        hint(__aeabi_fsub, this::__aeabi_fsub, 324);
        hint(__aeabi_fsub, this::__aeabi_fsub, 328);
        hint(__aeabi_fsub, this::__aeabi_fsub, 338);
        hint(__aeabi_fsub, this::__aeabi_fsub, 344);
        hint(__aeabi_fsub, this::__aeabi_fsub, 364);
        hint(__aeabi_fsub, this::__aeabi_fsub, 370);
        hint(__aeabi_fsub, this::__aeabi_fsub, 372);
        hint(__aeabi_fsub, this::__aeabi_fsub, 382);
        hint(__aeabi_fsub, this::__aeabi_fsub, 384);
        hint(__aeabi_fsub, this::__aeabi_fsub, 386);
        hint(__aeabi_fsub, this::__aeabi_fsub, 392);
        hint(__aeabi_fsub, this::__aeabi_fsub, 396);
        hint(__aeabi_fsub, this::__aeabi_fsub, 398);
        hint(__aeabi_fsub, this::__aeabi_fsub, 402);
        hint(__aeabi_fsub, this::__aeabi_fsub, 404);
        hint(__aeabi_fsub, this::__aeabi_fsub, 418);
        hint(__aeabi_fsub, this::__aeabi_fsub, 422);
        hint(__aeabi_fsub, this::__aeabi_fsub, 428);
        hint(__aeabi_fsub, this::__aeabi_fsub, 436);
        hint(__aeabi_fsub, this::__aeabi_fsub, 440);
        hint(__aeabi_fsub, this::__aeabi_fsub, 444);
        hint(__aeabi_fsub, this::__aeabi_fsub, 452);
        hint(__aeabi_fsub, this::__aeabi_fsub, 456);
        hint(__aeabi_fsub, this::__aeabi_fsub, 458);
        hint(__aeabi_fsub, this::__aeabi_fsub, 474);
        hint(__aeabi_fsub, this::__aeabi_fsub, 484);
        hint(__aeabi_fsub, this::__aeabi_fsub, 488);
        hint(__aeabi_fsub, this::__aeabi_fsub, 494);
        hint(__aeabi_fsub, this::__aeabi_fsub, 496);
        hint(__aeabi_fsub, this::__aeabi_fsub, 498);
        hint(__aeabi_fsub, this::__aeabi_fsub, 502);
        hint(__aeabi_fsub, this::__aeabi_fsub, 508);
        hint(__aeabi_fsub, this::__aeabi_fsub, 512);
        hint(__aeabi_fsub, this::__aeabi_fsub, 520);
        hint(__aeabi_fsub, this::__aeabi_fsub, 524);
        hint(__aeabi_fsub, this::__aeabi_fsub, 526);
        hint(__aeabi_fsub, this::__aeabi_fsub, 536);
        hint(__aeabi_fsub, this::__aeabi_fsub, 548);
        hint(__aeabi_fsub, this::__aeabi_fsub, 552);
        hint(__aeabi_fsub, this::__aeabi_fsub, 556);
        hint(__aeabi_fsub, this::__aeabi_fsub, 562);
        hint(__aeabi_fsub, this::__aeabi_fsub, 564);
        hint(__aeabi_fsub, this::__aeabi_fsub, 570);
        hint(__aeabi_fsub, this::__aeabi_fsub, 576);
        hint(__aeabi_fsub, this::__aeabi_fsub, 580);
        hint(__aeabi_fsub, this::__aeabi_fsub, 584);
        hint(__aeabi_fsub, this::__aeabi_fsub, 588);
        hint(__aeabi_fsub, this::__aeabi_fsub, 596);
        hint(__aeabi_fsub, this::__aeabi_fsub, 600);
        hint(__aeabi_fsub, this::__aeabi_fsub, 606);
        hint(__aeabi_fsub, this::__aeabi_fsub, 612);
        hint(__aeabi_fsub, this::__aeabi_fsub, 616);
        hint(__aeabi_fsub, this::__aeabi_fsub, 622);
        hint(__aeabi_fsub, this::__aeabi_fsub, 628);
        hint(__aeabi_fsub, this::__aeabi_fsub, 632);
        hint(__aeabi_fsub, this::__aeabi_fsub, 634);
        hint(__aeabi_fsub, this::__aeabi_fsub, 636);
        hint(__aeabi_fsub, this::__aeabi_fsub, 644);
        hint(__aeabi_fsub, this::__aeabi_fsub, 648);
        hint(__aeabi_fsub, this::__aeabi_fsub, 652);
        hint(__aeabi_fsub, this::__aeabi_fsub, 656);
        hint(__aeabi_fsub, this::__aeabi_fsub, 660);
        hint(__aeabi_fsub, this::__aeabi_fsub, 664);
        hint(__aeabi_fsub, this::__aeabi_fsub, 668);
        hint(__aeabi_fsub, this::__aeabi_fsub, 674);
        hint(__aeabi_fsub, this::__aeabi_fsub, 680);
        hint(__aeabi_fsub, this::__aeabi_fsub, 692);
        hint(__aeabi_fsub, this::__aeabi_fsub, 696);
        hint(__aeabi_fsub, this::__aeabi_fsub, 704);
        hint(__aeabi_fsub, this::__aeabi_fsub, 708);
        hint(__aeabi_fsub, this::__aeabi_fsub, 724);
        hint(__aeabi_fsub, this::__aeabi_fsub, 730);
        hint(__aeabi_fsub, this::__aeabi_fsub, 734);
        hint(__aeabi_fsub, this::__aeabi_fsub, 740);
        hint(__aeabi_fsub, this::__aeabi_fsub, 742);
        hint(__aeabi_fsub, this::__aeabi_fsub, 750);
        hint(__aeabi_fsub, this::__aeabi_fsub, 752);
        hint(__aeabi_fsub, this::__aeabi_fsub, 758);
        hint(__aeabi_fsub, this::__aeabi_fsub, 760);
        hint(__aeabi_fsub, this::__aeabi_fsub, 764);
        hint(__aeabi_fsub, this::__aeabi_fsub, 772);
        hint(__aeabi_fsub, this::__aeabi_fsub, 774);
        hint(__aeabi_fsub, this::__aeabi_fsub, 782);
        hint(__aeabi_fsub, this::__aeabi_fsub, 788);
        hint(__aeabi_fsub, this::__aeabi_fsub, 792);
        hint(__aeabi_fsub, this::__aeabi_fsub, 802);
        hint(__aeabi_fsub, this::__aeabi_fsub, 808);
        hint(__aeabi_fsub, this::__aeabi_fsub, 814);
        hint(__aeabi_fsub, this::__aeabi_fsub, 828);
        hint(__aeabi_fsub, this::__aeabi_fsub, 832);
        hint(__aeabi_fsub, this::__aeabi_fsub, 838);
        hint(__aeabi_fsub, this::__aeabi_fsub, 842);
        hint(__aeabi_fsub, this::__aeabi_fsub, 844);
        hint(__aeabi_fsub, this::__aeabi_fsub, 852);
        hint(__aeabi_fsub, this::__aeabi_fsub, 856);
        hint(__aeabi_fsub, this::__aeabi_fsub, 862);
        hint(__aeabi_fsub, this::__aeabi_fsub, 872);
        hint(__aeabi_fsub, this::__aeabi_fsub, 876);
        hint(__aeabi_fsub, this::__aeabi_fsub, 880);
        hint(__aeabi_fsub, this::__aeabi_fsub, 884);
        hint(__aeabi_fsub, this::__aeabi_fsub, 890);
        hint(__aeabi_fcmpun, this::__aeabi_fcmpun, 0);
        hint(__aeabi_fcmpun, this::__aeabi_fcmpun, 20);
        hint(__aeabi_fcmpun, this::__aeabi_fcmpun, 26);
        hint(__aeabi_fcmpun, this::__aeabi_fcmpun, 32);
        hint(__aeabi_fcmpun, this::__aeabi_fcmpun, 34);
        hint(__aeabi_fcmpun, this::__aeabi_fcmpun, 40);
        hint(__aeabi_f2iz, this::__aeabi_f2iz, 0);
        hint(__aeabi_f2iz, this::__aeabi_f2iz, 16);
        hint(__aeabi_f2iz, this::__aeabi_f2iz, 20);
        hint(__aeabi_f2iz, this::__aeabi_f2iz, 30);
        hint(__aeabi_f2iz, this::__aeabi_f2iz, 36);
        hint(__aeabi_f2iz, this::__aeabi_f2iz, 42);
        hint(__aeabi_f2iz, this::__aeabi_f2iz, 44);
        hint(__aeabi_f2iz, this::__aeabi_f2iz, 46);
        hint(__aeabi_f2iz, this::__aeabi_f2iz, 52);
        hint(__aeabi_i2f, this::__aeabi_i2f, 0);
        hint(__aeabi_i2f, this::__aeabi_i2f, 6);
        hint(__aeabi_i2f, this::__aeabi_i2f, 20);
        hint(__aeabi_i2f, this::__aeabi_i2f, 28);
        hint(__aeabi_i2f, this::__aeabi_i2f, 34);
        hint(__aeabi_i2f, this::__aeabi_i2f, 44);
        hint(__aeabi_i2f, this::__aeabi_i2f, 48);
        hint(__aeabi_i2f, this::__aeabi_i2f, 72);
        hint(__aeabi_i2f, this::__aeabi_i2f, 76);
        hint(__aeabi_i2f, this::__aeabi_i2f, 80);
        hint(__aeabi_i2f, this::__aeabi_i2f, 90);
        hint(__aeabi_i2f, this::__aeabi_i2f, 98);
        hint(__aeabi_i2f, this::__aeabi_i2f, 104);
        hint(__aeabi_i2f, this::__aeabi_i2f, 110);
        hint(__aeabi_i2f, this::__aeabi_i2f, 116);
        hint(__aeabi_i2f, this::__aeabi_i2f, 130);
        hint(__aeabi_i2f, this::__aeabi_i2f, 138);
        hint(__aeabi_ui2f, this::__aeabi_ui2f, 0);
        hint(__aeabi_ui2f, this::__aeabi_ui2f, 6);
        hint(__aeabi_ui2f, this::__aeabi_ui2f, 10);
        hint(__aeabi_ui2f, this::__aeabi_ui2f, 18);
        hint(__aeabi_ui2f, this::__aeabi_ui2f, 24);
        hint(__aeabi_ui2f, this::__aeabi_ui2f, 34);
        hint(__aeabi_ui2f, this::__aeabi_ui2f, 38);
        hint(__aeabi_ui2f, this::__aeabi_ui2f, 58);
        hint(__aeabi_ui2f, this::__aeabi_ui2f, 62);
        hint(__aeabi_ui2f, this::__aeabi_ui2f, 66);
        hint(__aeabi_ui2f, this::__aeabi_ui2f, 76);
        hint(__aeabi_ui2f, this::__aeabi_ui2f, 84);
        hint(__aeabi_ui2f, this::__aeabi_ui2f, 90);
        hint(__aeabi_ui2f, this::__aeabi_ui2f, 96);
        hint(__aeabi_ui2f, this::__aeabi_ui2f, 102);
        hint(__aeabi_ui2f, this::__aeabi_ui2f, 112);
        hint(__aeabi_ui2f, this::__aeabi_ui2f, 118);
        hint(__aeabi_i2d, this::__aeabi_i2d, 0);
        hint(__aeabi_i2d, this::__aeabi_i2d, 6);
        hint(__aeabi_i2d, this::__aeabi_i2d, 20);
        hint(__aeabi_i2d, this::__aeabi_i2d, 32);
        hint(__aeabi_i2d, this::__aeabi_i2d, 42);
        hint(__aeabi_i2d, this::__aeabi_i2d, 76);
        hint(__aeabi_i2d, this::__aeabi_i2d, 98);
        hint(__aeabi_f2d, this::__aeabi_f2d, 0);
        hint(__aeabi_f2d, this::__aeabi_f2d, 20);
        hint(__aeabi_f2d, this::__aeabi_f2d, 30);
        hint(__aeabi_f2d, this::__aeabi_f2d, 62);
        hint(__aeabi_f2d, this::__aeabi_f2d, 66);
        hint(__aeabi_f2d, this::__aeabi_f2d, 70);
        hint(__aeabi_f2d, this::__aeabi_f2d, 76);
    }

    private void gen_hints_16() {
        hint(__aeabi_f2d, this::__aeabi_f2d, 80);
        hint(__aeabi_f2d, this::__aeabi_f2d, 94);
        hint(__aeabi_f2d, this::__aeabi_f2d, 108);
        hint(__aeabi_f2d, this::__aeabi_f2d, 112);
        hint(__aeabi_f2d, this::__aeabi_f2d, 126);
        hint(__aeabi_f2d, this::__aeabi_f2d, 132);
        hint(__aeabi_f2d, this::__aeabi_f2d, 138);
        hint(__aeabi_d2f, this::__aeabi_d2f, 0);
        hint(__aeabi_d2f, this::__aeabi_d2f, 28);
        hint(__aeabi_d2f, this::__aeabi_d2f, 36);
        hint(__aeabi_d2f, this::__aeabi_d2f, 40);
        hint(__aeabi_d2f, this::__aeabi_d2f, 58);
        hint(__aeabi_d2f, this::__aeabi_d2f, 62);
        hint(__aeabi_d2f, this::__aeabi_d2f, 70);
        hint(__aeabi_d2f, this::__aeabi_d2f, 72);
        hint(__aeabi_d2f, this::__aeabi_d2f, 80);
        hint(__aeabi_d2f, this::__aeabi_d2f, 88);
        hint(__aeabi_d2f, this::__aeabi_d2f, 94);
        hint(__aeabi_d2f, this::__aeabi_d2f, 98);
        hint(__aeabi_d2f, this::__aeabi_d2f, 112);
        hint(__aeabi_d2f, this::__aeabi_d2f, 118);
        hint(__aeabi_d2f, this::__aeabi_d2f, 122);
        hint(__aeabi_d2f, this::__aeabi_d2f, 128);
        hint(__aeabi_d2f, this::__aeabi_d2f, 132);
        hint(__aeabi_d2f, this::__aeabi_d2f, 142);
        hint(__aeabi_d2f, this::__aeabi_d2f, 144);
        hint(__aeabi_d2f, this::__aeabi_d2f, 146);
        hint(__aeabi_d2f, this::__aeabi_d2f, 154);
        hint(__aeabi_d2f, this::__aeabi_d2f, 160);
        hint(__aeabi_d2f, this::__aeabi_d2f, 166);
        hint(__aeabi_d2f, this::__aeabi_d2f, 180);
        hint(__aeabi_d2f, this::__aeabi_d2f, 196);
        hint(__aeabi_d2f, this::__aeabi_d2f, 206);
        hint(__aeabi_d2f, this::__aeabi_d2f, 222);
        hint(__clzsi2, this::__clzsi2, 0);
    }

    @Override
    protected void gen_hints() {
        gen_hints_1();
        gen_hints_2();
        gen_hints_3();
        gen_hints_4();
        gen_hints_5();
        gen_hints_6();
        gen_hints_7();
        gen_hints_8();
        gen_hints_9();
        gen_hints_10();
        gen_hints_11();
        gen_hints_12();
        gen_hints_13();
        gen_hints_14();
        gen_hints_15();
        gen_hints_16();
    }

    // function: Function(address=134217740, size=20, name='nlr_push_tail', path='build/py/nlr.o', has_indirect=True)
    abstract protected void nlr_push_tail(int offset) throws Exception;
    public static final int nlr_push_tail = 0x0800000c;
    public void nlr_push_tail(InterruptHandler handler) throws Exception
    {
        call(this::nlr_push_tail, handler);
    }

    // function: Function(address=134217760, size=16, name='nlr_pop', path='build/py/nlr.o', has_indirect=False)
    abstract protected void nlr_pop(int offset) throws Exception;
    public static final int nlr_pop = 0x08000020;
    public void nlr_pop(InterruptHandler handler) throws Exception
    {
        call(this::nlr_pop, handler);
    }

    // function: Function(address=134217776, size=40, name='nlr_push', path='build/py/nlrthumb.o', has_indirect=False)
    abstract protected void nlr_push(int offset) throws Exception;
    public static final int nlr_push = 0x08000030;
    public void nlr_push(InterruptHandler handler) throws Exception
    {
        call(this::nlr_push, handler);
    }

    // function: Function(address=134217816, size=68, name='nlr_jump', path='build/py/nlrthumb.o', has_indirect=False)
    abstract protected void nlr_jump(int offset) throws Exception;
    public static final int nlr_jump = 0x08000058;
    public void nlr_jump(InterruptHandler handler) throws Exception
    {
        call(this::nlr_jump, handler);
    }

    // function: Function(address=134217884, size=64, name='m_malloc', path='build/py/malloc.o', has_indirect=False)
    abstract protected void m_malloc(int offset) throws Exception;
    public static final int m_malloc = 0x0800009c;
    public void m_malloc(InterruptHandler handler) throws Exception
    {
        call(this::m_malloc, handler);
    }

    // function: Function(address=134217948, size=48, name='m_malloc_maybe', path='build/py/malloc.o', has_indirect=False)
    abstract protected void m_malloc_maybe(int offset) throws Exception;
    public static final int m_malloc_maybe = 0x080000dc;
    public void m_malloc_maybe(InterruptHandler handler) throws Exception
    {
        call(this::m_malloc_maybe, handler);
    }

    // function: Function(address=134217996, size=8, name='m_malloc0', path='build/py/malloc.o', has_indirect=False)
    abstract protected void m_malloc0(int offset) throws Exception;
    public static final int m_malloc0 = 0x0800010c;
    public void m_malloc0(InterruptHandler handler) throws Exception
    {
        call(this::m_malloc0, handler);
    }

    // function: Function(address=134218004, size=68, name='m_realloc', path='build/py/malloc.o', has_indirect=False)
    abstract protected void m_realloc(int offset) throws Exception;
    public static final int m_realloc = 0x08000114;
    public void m_realloc(InterruptHandler handler) throws Exception
    {
        call(this::m_realloc, handler);
    }

    // function: Function(address=134218072, size=64, name='m_realloc_maybe', path='build/py/malloc.o', has_indirect=False)
    abstract protected void m_realloc_maybe(int offset) throws Exception;
    public static final int m_realloc_maybe = 0x08000158;
    public void m_realloc_maybe(InterruptHandler handler) throws Exception
    {
        call(this::m_realloc_maybe, handler);
    }

    // function: Function(address=134218136, size=28, name='m_free', path='build/py/malloc.o', has_indirect=False)
    abstract protected void m_free(int offset) throws Exception;
    public static final int m_free = 0x08000198;
    public void m_free(InterruptHandler handler) throws Exception
    {
        call(this::m_free, handler);
    }

    // function: Function(address=134218164, size=16, name='m_get_total_bytes_allocated', path='build/py/malloc.o', has_indirect=False)
    abstract protected void m_get_total_bytes_allocated(int offset) throws Exception;
    public static final int m_get_total_bytes_allocated = 0x080001b4;
    public void m_get_total_bytes_allocated(InterruptHandler handler) throws Exception
    {
        call(this::m_get_total_bytes_allocated, handler);
    }

    // function: Function(address=134218180, size=16, name='m_get_current_bytes_allocated', path='build/py/malloc.o', has_indirect=False)
    abstract protected void m_get_current_bytes_allocated(int offset) throws Exception;
    public static final int m_get_current_bytes_allocated = 0x080001c4;
    public void m_get_current_bytes_allocated(InterruptHandler handler) throws Exception
    {
        call(this::m_get_current_bytes_allocated, handler);
    }

    // function: Function(address=134218196, size=16, name='m_get_peak_bytes_allocated', path='build/py/malloc.o', has_indirect=False)
    abstract protected void m_get_peak_bytes_allocated(int offset) throws Exception;
    public static final int m_get_peak_bytes_allocated = 0x080001d4;
    public void m_get_peak_bytes_allocated(InterruptHandler handler) throws Exception
    {
        call(this::m_get_peak_bytes_allocated, handler);
    }

    // function: Function(address=134218212, size=240, name='gc_mark_subtree', path='build/py/gc.o', has_indirect=False)
    abstract protected void gc_mark_subtree(int offset) throws Exception;
    public static final int gc_mark_subtree = 0x080001e4;
    public void gc_mark_subtree(InterruptHandler handler) throws Exception
    {
        call(this::gc_mark_subtree, handler);
    }

    // function: Function(address=134218452, size=128, name='gc_init', path='build/py/gc.o', has_indirect=False)
    abstract protected void gc_init(int offset) throws Exception;
    public static final int gc_init = 0x080002d4;
    public void gc_init(InterruptHandler handler) throws Exception
    {
        call(this::gc_init, handler);
    }

    // function: Function(address=134218580, size=20, name='gc_lock', path='build/py/gc.o', has_indirect=False)
    abstract protected void gc_lock(int offset) throws Exception;
    public static final int gc_lock = 0x08000354;
    public void gc_lock(InterruptHandler handler) throws Exception
    {
        call(this::gc_lock, handler);
    }

    // function: Function(address=134218600, size=20, name='gc_unlock', path='build/py/gc.o', has_indirect=False)
    abstract protected void gc_unlock(int offset) throws Exception;
    public static final int gc_unlock = 0x08000368;
    public void gc_unlock(InterruptHandler handler) throws Exception
    {
        call(this::gc_unlock, handler);
    }

    // function: Function(address=134218620, size=20, name='gc_is_locked', path='build/py/gc.o', has_indirect=False)
    abstract protected void gc_is_locked(int offset) throws Exception;
    public static final int gc_is_locked = 0x0800037c;
    public void gc_is_locked(InterruptHandler handler) throws Exception
    {
        call(this::gc_is_locked, handler);
    }

    // function: Function(address=134218640, size=276, name='gc_collect_start', path='build/py/gc.o', has_indirect=False)
    abstract protected void gc_collect_start(int offset) throws Exception;
    public static final int gc_collect_start = 0x08000390;
    public void gc_collect_start(InterruptHandler handler) throws Exception
    {
        call(this::gc_collect_start, handler);
    }

    // function: Function(address=134218916, size=136, name='gc_collect_root', path='build/py/gc.o', has_indirect=False)
    abstract protected void gc_collect_root(int offset) throws Exception;
    public static final int gc_collect_root = 0x080004a4;
    public void gc_collect_root(InterruptHandler handler) throws Exception
    {
        call(this::gc_collect_root, handler);
    }

    // function: Function(address=134219052, size=412, name='gc_collect_end', path='build/py/gc.o', has_indirect=False)
    abstract protected void gc_collect_end(int offset) throws Exception;
    public static final int gc_collect_end = 0x0800052c;
    public void gc_collect_end(InterruptHandler handler) throws Exception
    {
        call(this::gc_collect_end, handler);
    }

    // function: Function(address=134219464, size=280, name='gc_info', path='build/py/gc.o', has_indirect=False)
    abstract protected void gc_info(int offset) throws Exception;
    public static final int gc_info = 0x080006c8;
    public void gc_info(InterruptHandler handler) throws Exception
    {
        call(this::gc_info, handler);
    }

    // function: Function(address=134219744, size=460, name='gc_alloc', path='build/py/gc.o', has_indirect=False)
    abstract protected void gc_alloc(int offset) throws Exception;
    public static final int gc_alloc = 0x080007e0;
    public void gc_alloc(InterruptHandler handler) throws Exception
    {
        call(this::gc_alloc, handler);
    }

    // function: Function(address=134220204, size=132, name='gc_free', path='build/py/gc.o', has_indirect=False)
    abstract protected void gc_free(int offset) throws Exception;
    public static final int gc_free = 0x080009ac;
    public void gc_free(InterruptHandler handler) throws Exception
    {
        call(this::gc_free, handler);
    }

    // function: Function(address=134220336, size=108, name='gc_nbytes', path='build/py/gc.o', has_indirect=False)
    abstract protected void gc_nbytes(int offset) throws Exception;
    public static final int gc_nbytes = 0x08000a30;
    public void gc_nbytes(InterruptHandler handler) throws Exception
    {
        call(this::gc_nbytes, handler);
    }

    // function: Function(address=134220444, size=680, name='gc_realloc', path='build/py/gc.o', has_indirect=False)
    abstract protected void gc_realloc(int offset) throws Exception;
    public static final int gc_realloc = 0x08000a9c;
    public void gc_realloc(InterruptHandler handler) throws Exception
    {
        call(this::gc_realloc, handler);
    }

    // function: Function(address=134221124, size=316, name='gc_dump_info', path='build/py/gc.o', has_indirect=False)
    abstract protected void gc_dump_info(int offset) throws Exception;
    public static final int gc_dump_info = 0x08000d44;
    public void gc_dump_info(InterruptHandler handler) throws Exception
    {
        call(this::gc_dump_info, handler);
    }

    // function: Function(address=134221440, size=452, name='gc_dump_alloc_table', path='build/py/gc.o', has_indirect=False)
    abstract protected void gc_dump_alloc_table(int offset) throws Exception;
    public static final int gc_dump_alloc_table = 0x08000e80;
    public void gc_dump_alloc_table(InterruptHandler handler) throws Exception
    {
        call(this::gc_dump_alloc_table, handler);
    }

    // function: Function(address=134221892, size=16, name='mp_pystack_init', path='build/py/pystack.o', has_indirect=False)
    abstract protected void mp_pystack_init(int offset) throws Exception;
    public static final int mp_pystack_init = 0x08001044;
    public void mp_pystack_init(InterruptHandler handler) throws Exception
    {
        call(this::mp_pystack_init, handler);
    }

    // function: Function(address=134221908, size=48, name='mp_pystack_alloc', path='build/py/pystack.o', has_indirect=False)
    abstract protected void mp_pystack_alloc(int offset) throws Exception;
    public static final int mp_pystack_alloc = 0x08001054;
    public void mp_pystack_alloc(InterruptHandler handler) throws Exception
    {
        call(this::mp_pystack_alloc, handler);
    }

    // function: Function(address=134221956, size=28, name='find_qstr', path='build/py/qstr.o', has_indirect=False)
    abstract protected void find_qstr(int offset) throws Exception;
    public static final int find_qstr = 0x08001084;
    public void find_qstr(InterruptHandler handler) throws Exception
    {
        call(this::find_qstr, handler);
    }

    // function: Function(address=134221984, size=36, name='qstr_compute_hash', path='build/py/qstr.o', has_indirect=False)
    abstract protected void qstr_compute_hash(int offset) throws Exception;
    public static final int qstr_compute_hash = 0x080010a0;
    public void qstr_compute_hash(InterruptHandler handler) throws Exception
    {
        call(this::qstr_compute_hash, handler);
    }

    // function: Function(address=134222020, size=24, name='qstr_init', path='build/py/qstr.o', has_indirect=False)
    abstract protected void qstr_init(int offset) throws Exception;
    public static final int qstr_init = 0x080010c4;
    public void qstr_init(InterruptHandler handler) throws Exception
    {
        call(this::qstr_init, handler);
    }

    // function: Function(address=134222044, size=108, name='qstr_find_strn', path='build/py/qstr.o', has_indirect=False)
    abstract protected void qstr_find_strn(int offset) throws Exception;
    public static final int qstr_find_strn = 0x080010dc;
    public void qstr_find_strn(InterruptHandler handler) throws Exception
    {
        call(this::qstr_find_strn, handler);
    }

    // function: Function(address=134222152, size=296, name='qstr_from_strn', path='build/py/qstr.o', has_indirect=False)
    abstract protected void qstr_from_strn(int offset) throws Exception;
    public static final int qstr_from_strn = 0x08001148;
    public void qstr_from_strn(InterruptHandler handler) throws Exception
    {
        call(this::qstr_from_strn, handler);
    }

    // function: Function(address=134222448, size=18, name='qstr_from_str', path='build/py/qstr.o', has_indirect=False)
    abstract protected void qstr_from_str(int offset) throws Exception;
    public static final int qstr_from_str = 0x08001270;
    public void qstr_from_str(InterruptHandler handler) throws Exception
    {
        call(this::qstr_from_str, handler);
    }

    // function: Function(address=134222466, size=16, name='qstr_hash', path='build/py/qstr.o', has_indirect=False)
    abstract protected void qstr_hash(int offset) throws Exception;
    public static final int qstr_hash = 0x08001282;
    public void qstr_hash(InterruptHandler handler) throws Exception
    {
        call(this::qstr_hash, handler);
    }

    // function: Function(address=134222482, size=10, name='qstr_len', path='build/py/qstr.o', has_indirect=False)
    abstract protected void qstr_len(int offset) throws Exception;
    public static final int qstr_len = 0x08001292;
    public void qstr_len(InterruptHandler handler) throws Exception
    {
        call(this::qstr_len, handler);
    }

    // function: Function(address=134222492, size=10, name='qstr_str', path='build/py/qstr.o', has_indirect=False)
    abstract protected void qstr_str(int offset) throws Exception;
    public static final int qstr_str = 0x0800129c;
    public void qstr_str(InterruptHandler handler) throws Exception
    {
        call(this::qstr_str, handler);
    }

    // function: Function(address=134222502, size=16, name='qstr_data', path='build/py/qstr.o', has_indirect=False)
    abstract protected void qstr_data(int offset) throws Exception;
    public static final int qstr_data = 0x080012a6;
    public void qstr_data(InterruptHandler handler) throws Exception
    {
        call(this::qstr_data, handler);
    }

    // function: Function(address=134222520, size=120, name='qstr_pool_info', path='build/py/qstr.o', has_indirect=False)
    abstract protected void qstr_pool_info(int offset) throws Exception;
    public static final int qstr_pool_info = 0x080012b8;
    public void qstr_pool_info(InterruptHandler handler) throws Exception
    {
        call(this::qstr_pool_info, handler);
    }

    // function: Function(address=134222640, size=68, name='qstr_dump_data', path='build/py/qstr.o', has_indirect=False)
    abstract protected void qstr_dump_data(int offset) throws Exception;
    public static final int qstr_dump_data = 0x08001330;
    public void qstr_dump_data(InterruptHandler handler) throws Exception
    {
        call(this::qstr_dump_data, handler);
    }

    // function: Function(address=134222708, size=56, name='vstr_ensure_extra', path='build/py/vstr.o', has_indirect=False)
    abstract protected void vstr_ensure_extra(int offset) throws Exception;
    public static final int vstr_ensure_extra = 0x08001374;
    public void vstr_ensure_extra(InterruptHandler handler) throws Exception
    {
        call(this::vstr_ensure_extra, handler);
    }

    // function: Function(address=134222764, size=36, name='vstr_add_strn', path='build/py/vstr.o', has_indirect=True)
    abstract protected void vstr_add_strn(int offset) throws Exception;
    public static final int vstr_add_strn = 0x080013ac;
    public void vstr_add_strn(InterruptHandler handler) throws Exception
    {
        call(this::vstr_add_strn, handler);
    }

    // function: Function(address=134222800, size=48, name='vstr_ins_blank_bytes_constprop_2', path='build/py/vstr.o', has_indirect=False)
    abstract protected void vstr_ins_blank_bytes_constprop_2(int offset) throws Exception;
    public static final int vstr_ins_blank_bytes_constprop_2 = 0x080013d0;
    public void vstr_ins_blank_bytes_constprop_2(InterruptHandler handler) throws Exception
    {
        call(this::vstr_ins_blank_bytes_constprop_2, handler);
    }

    // function: Function(address=134222848, size=34, name='vstr_init', path='build/py/vstr.o', has_indirect=False)
    abstract protected void vstr_init(int offset) throws Exception;
    public static final int vstr_init = 0x08001400;
    public void vstr_init(InterruptHandler handler) throws Exception
    {
        call(this::vstr_init, handler);
    }

    // function: Function(address=134222882, size=16, name='vstr_init_len', path='build/py/vstr.o', has_indirect=False)
    abstract protected void vstr_init_len(int offset) throws Exception;
    public static final int vstr_init_len = 0x08001422;
    public void vstr_init_len(InterruptHandler handler) throws Exception
    {
        call(this::vstr_init_len, handler);
    }

    // function: Function(address=134222898, size=18, name='vstr_init_fixed_buf', path='build/py/vstr.o', has_indirect=False)
    abstract protected void vstr_init_fixed_buf(int offset) throws Exception;
    public static final int vstr_init_fixed_buf = 0x08001432;
    public void vstr_init_fixed_buf(InterruptHandler handler) throws Exception
    {
        call(this::vstr_init_fixed_buf, handler);
    }

    // function: Function(address=134222916, size=24, name='vstr_init_print', path='build/py/vstr.o', has_indirect=False)
    abstract protected void vstr_init_print(int offset) throws Exception;
    public static final int vstr_init_print = 0x08001444;
    public void vstr_init_print(InterruptHandler handler) throws Exception
    {
        call(this::vstr_init_print, handler);
    }

    // function: Function(address=134222940, size=24, name='vstr_clear', path='build/py/vstr.o', has_indirect=False)
    abstract protected void vstr_clear(int offset) throws Exception;
    public static final int vstr_clear = 0x0800145c;
    public void vstr_clear(InterruptHandler handler) throws Exception
    {
        call(this::vstr_clear, handler);
    }

    // function: Function(address=134222964, size=22, name='vstr_new', path='build/py/vstr.o', has_indirect=False)
    abstract protected void vstr_new(int offset) throws Exception;
    public static final int vstr_new = 0x08001474;
    public void vstr_new(InterruptHandler handler) throws Exception
    {
        call(this::vstr_new, handler);
    }

    // function: Function(address=134222986, size=30, name='vstr_free', path='build/py/vstr.o', has_indirect=False)
    abstract protected void vstr_free(int offset) throws Exception;
    public static final int vstr_free = 0x0800148a;
    public void vstr_free(InterruptHandler handler) throws Exception
    {
        call(this::vstr_free, handler);
    }

    // function: Function(address=134223016, size=48, name='vstr_extend', path='build/py/vstr.o', has_indirect=False)
    abstract protected void vstr_extend(int offset) throws Exception;
    public static final int vstr_extend = 0x080014a8;
    public void vstr_extend(InterruptHandler handler) throws Exception
    {
        call(this::vstr_extend, handler);
    }

    // function: Function(address=134223064, size=22, name='vstr_add_len', path='build/py/vstr.o', has_indirect=False)
    abstract protected void vstr_add_len(int offset) throws Exception;
    public static final int vstr_add_len = 0x080014d8;
    public void vstr_add_len(InterruptHandler handler) throws Exception
    {
        call(this::vstr_add_len, handler);
    }

    // function: Function(address=134223086, size=30, name='vstr_null_terminated_str', path='build/py/vstr.o', has_indirect=False)
    abstract protected void vstr_null_terminated_str(int offset) throws Exception;
    public static final int vstr_null_terminated_str = 0x080014ee;
    public void vstr_null_terminated_str(InterruptHandler handler) throws Exception
    {
        call(this::vstr_null_terminated_str, handler);
    }

    // function: Function(address=134223116, size=14, name='vstr_add_byte', path='build/py/vstr.o', has_indirect=False)
    abstract protected void vstr_add_byte(int offset) throws Exception;
    public static final int vstr_add_byte = 0x0800150c;
    public void vstr_add_byte(InterruptHandler handler) throws Exception
    {
        call(this::vstr_add_byte, handler);
    }

    // function: Function(address=134223132, size=152, name='vstr_add_char', path='build/py/vstr.o', has_indirect=False)
    abstract protected void vstr_add_char(int offset) throws Exception;
    public static final int vstr_add_char = 0x0800151c;
    public void vstr_add_char(InterruptHandler handler) throws Exception
    {
        call(this::vstr_add_char, handler);
    }

    // function: Function(address=134223284, size=24, name='vstr_add_str', path='build/py/vstr.o', has_indirect=False)
    abstract protected void vstr_add_str(int offset) throws Exception;
    public static final int vstr_add_str = 0x080015b4;
    public void vstr_add_str(InterruptHandler handler) throws Exception
    {
        call(this::vstr_add_str, handler);
    }

    // function: Function(address=134223308, size=12, name='vstr_ins_byte', path='build/py/vstr.o', has_indirect=False)
    abstract protected void vstr_ins_byte(int offset) throws Exception;
    public static final int vstr_ins_byte = 0x080015cc;
    public void vstr_ins_byte(InterruptHandler handler) throws Exception
    {
        call(this::vstr_ins_byte, handler);
    }

    // function: Function(address=134223320, size=12, name='vstr_ins_char', path='build/py/vstr.o', has_indirect=False)
    abstract protected void vstr_ins_char(int offset) throws Exception;
    public static final int vstr_ins_char = 0x080015d8;
    public void vstr_ins_char(InterruptHandler handler) throws Exception
    {
        call(this::vstr_ins_char, handler);
    }

    // function: Function(address=134223332, size=16, name='vstr_cut_tail_bytes', path='build/py/vstr.o', has_indirect=False)
    abstract protected void vstr_cut_tail_bytes(int offset) throws Exception;
    public static final int vstr_cut_tail_bytes = 0x080015e4;
    public void vstr_cut_tail_bytes(InterruptHandler handler) throws Exception
    {
        call(this::vstr_cut_tail_bytes, handler);
    }

    // function: Function(address=134223348, size=46, name='vstr_cut_out_bytes', path='build/py/vstr.o', has_indirect=False)
    abstract protected void vstr_cut_out_bytes(int offset) throws Exception;
    public static final int vstr_cut_out_bytes = 0x080015f4;
    public void vstr_cut_out_bytes(InterruptHandler handler) throws Exception
    {
        call(this::vstr_cut_out_bytes, handler);
    }

    // function: Function(address=134223394, size=12, name='plat_print_strn', path='build/py/mpprint.o', has_indirect=False)
    abstract protected void plat_print_strn(int offset) throws Exception;
    public static final int plat_print_strn = 0x08001622;
    public void plat_print_strn(InterruptHandler handler) throws Exception
    {
        call(this::plat_print_strn, handler);
    }

    // function: Function(address=134223406, size=30, name='mp_print_str', path='build/py/mpprint.o', has_indirect=False)
    abstract protected void mp_print_str(int offset) throws Exception;
    public static final int mp_print_str = 0x0800162e;
    public void mp_print_str(InterruptHandler handler) throws Exception
    {
        call(this::mp_print_str, handler);
    }

    // function: Function(address=134223436, size=184, name='mp_print_strn', path='build/py/mpprint.o', has_indirect=False)
    abstract protected void mp_print_strn(int offset) throws Exception;
    public static final int mp_print_strn = 0x0800164c;
    public void mp_print_strn(InterruptHandler handler) throws Exception
    {
        call(this::mp_print_strn, handler);
    }

    // function: Function(address=134223620, size=218, name='mp_print_int', path='build/py/mpprint.o', has_indirect=False)
    abstract protected void mp_print_int(int offset) throws Exception;
    public static final int mp_print_int = 0x08001704;
    public void mp_print_int(InterruptHandler handler) throws Exception
    {
        call(this::mp_print_int, handler);
    }

    // function: Function(address=134223840, size=576, name='mp_print_mp_int', path='build/py/mpprint.o', has_indirect=False)
    abstract protected void mp_print_mp_int(int offset) throws Exception;
    public static final int mp_print_mp_int = 0x080017e0;
    public void mp_print_mp_int(InterruptHandler handler) throws Exception
    {
        call(this::mp_print_mp_int, handler);
    }

    // function: Function(address=134224416, size=138, name='mp_print_float', path='build/py/mpprint.o', has_indirect=False)
    abstract protected void mp_print_float(int offset) throws Exception;
    public static final int mp_print_float = 0x08001a20;
    public void mp_print_float(InterruptHandler handler) throws Exception
    {
        call(this::mp_print_float, handler);
    }

    // function: Function(address=134224556, size=672, name='mp_vprintf', path='build/py/mpprint.o', has_indirect=False)
    abstract protected void mp_vprintf(int offset) throws Exception;
    public static final int mp_vprintf = 0x08001aac;
    public void mp_vprintf(InterruptHandler handler) throws Exception
    {
        call(this::mp_vprintf, handler);
    }

    // function: Function(address=134225228, size=22, name='mp_printf', path='build/py/mpprint.o', has_indirect=False)
    abstract protected void mp_printf(int offset) throws Exception;
    public static final int mp_printf = 0x08001d4c;
    public void mp_printf(InterruptHandler handler) throws Exception
    {
        call(this::mp_printf, handler);
    }

    // function: Function(address=134225250, size=54, name='utf8_get_char', path='build/py/unicode.o', has_indirect=False)
    abstract protected void utf8_get_char(int offset) throws Exception;
    public static final int utf8_get_char = 0x08001d62;
    public void utf8_get_char(InterruptHandler handler) throws Exception
    {
        call(this::utf8_get_char, handler);
    }

    // function: Function(address=134225304, size=18, name='utf8_next_char', path='build/py/unicode.o', has_indirect=False)
    abstract protected void utf8_next_char(int offset) throws Exception;
    public static final int utf8_next_char = 0x08001d98;
    public void utf8_next_char(InterruptHandler handler) throws Exception
    {
        call(this::utf8_next_char, handler);
    }

    // function: Function(address=134225322, size=30, name='utf8_ptr_to_index', path='build/py/unicode.o', has_indirect=False)
    abstract protected void utf8_ptr_to_index(int offset) throws Exception;
    public static final int utf8_ptr_to_index = 0x08001daa;
    public void utf8_ptr_to_index(InterruptHandler handler) throws Exception
    {
        call(this::utf8_ptr_to_index, handler);
    }

    // function: Function(address=134225352, size=32, name='utf8_charlen', path='build/py/unicode.o', has_indirect=False)
    abstract protected void utf8_charlen(int offset) throws Exception;
    public static final int utf8_charlen = 0x08001dc8;
    public void utf8_charlen(InterruptHandler handler) throws Exception
    {
        call(this::utf8_charlen, handler);
    }

    // function: Function(address=134225384, size=24, name='unichar_isspace', path='build/py/unicode.o', has_indirect=True)
    abstract protected void unichar_isspace(int offset) throws Exception;
    public static final int unichar_isspace = 0x08001de8;
    public void unichar_isspace(InterruptHandler handler) throws Exception
    {
        call(this::unichar_isspace, handler);
    }

    // function: Function(address=134225408, size=24, name='unichar_isalpha', path='build/py/unicode.o', has_indirect=True)
    abstract protected void unichar_isalpha(int offset) throws Exception;
    public static final int unichar_isalpha = 0x08001e00;
    public void unichar_isalpha(InterruptHandler handler) throws Exception
    {
        call(this::unichar_isalpha, handler);
    }

    // function: Function(address=134225432, size=24, name='unichar_isdigit', path='build/py/unicode.o', has_indirect=True)
    abstract protected void unichar_isdigit(int offset) throws Exception;
    public static final int unichar_isdigit = 0x08001e18;
    public void unichar_isdigit(InterruptHandler handler) throws Exception
    {
        call(this::unichar_isdigit, handler);
    }

    // function: Function(address=134225456, size=24, name='unichar_isxdigit', path='build/py/unicode.o', has_indirect=False)
    abstract protected void unichar_isxdigit(int offset) throws Exception;
    public static final int unichar_isxdigit = 0x08001e30;
    public void unichar_isxdigit(InterruptHandler handler) throws Exception
    {
        call(this::unichar_isxdigit, handler);
    }

    // function: Function(address=134225480, size=32, name='unichar_isident', path='build/py/unicode.o', has_indirect=False)
    abstract protected void unichar_isident(int offset) throws Exception;
    public static final int unichar_isident = 0x08001e48;
    public void unichar_isident(InterruptHandler handler) throws Exception
    {
        call(this::unichar_isident, handler);
    }

    // function: Function(address=134225512, size=24, name='unichar_isupper', path='build/py/unicode.o', has_indirect=True)
    abstract protected void unichar_isupper(int offset) throws Exception;
    public static final int unichar_isupper = 0x08001e68;
    public void unichar_isupper(InterruptHandler handler) throws Exception
    {
        call(this::unichar_isupper, handler);
    }

    // function: Function(address=134225536, size=24, name='unichar_islower', path='build/py/unicode.o', has_indirect=True)
    abstract protected void unichar_islower(int offset) throws Exception;
    public static final int unichar_islower = 0x08001e80;
    public void unichar_islower(InterruptHandler handler) throws Exception
    {
        call(this::unichar_islower, handler);
    }

    // function: Function(address=134225560, size=18, name='unichar_tolower', path='build/py/unicode.o', has_indirect=True)
    abstract protected void unichar_tolower(int offset) throws Exception;
    public static final int unichar_tolower = 0x08001e98;
    public void unichar_tolower(InterruptHandler handler) throws Exception
    {
        call(this::unichar_tolower, handler);
    }

    // function: Function(address=134225578, size=18, name='unichar_toupper', path='build/py/unicode.o', has_indirect=True)
    abstract protected void unichar_toupper(int offset) throws Exception;
    public static final int unichar_toupper = 0x08001eaa;
    public void unichar_toupper(InterruptHandler handler) throws Exception
    {
        call(this::unichar_toupper, handler);
    }

    // function: Function(address=134225596, size=14, name='unichar_xdigit_value', path='build/py/unicode.o', has_indirect=False)
    abstract protected void unichar_xdigit_value(int offset) throws Exception;
    public static final int unichar_xdigit_value = 0x08001ebc;
    public void unichar_xdigit_value(InterruptHandler handler) throws Exception
    {
        call(this::unichar_xdigit_value, handler);
    }

    // function: Function(address=134225610, size=78, name='utf8_check', path='build/py/unicode.o', has_indirect=False)
    abstract protected void utf8_check(int offset) throws Exception;
    public static final int utf8_check = 0x08001eca;
    public void utf8_check(InterruptHandler handler) throws Exception
    {
        call(this::utf8_check, handler);
    }

    // function: Function(address=134225688, size=20, name='mpn_remove_trailing_zeros', path='build/py/mpz.o', has_indirect=False)
    abstract protected void mpn_remove_trailing_zeros(int offset) throws Exception;
    public static final int mpn_remove_trailing_zeros = 0x08001f18;
    public void mpn_remove_trailing_zeros(InterruptHandler handler) throws Exception
    {
        call(this::mpn_remove_trailing_zeros, handler);
    }

    // function: Function(address=134225708, size=62, name='text_mpn_shr', path='build/py/mpz.o', has_indirect=False)
    abstract protected void text_mpn_shr(int offset) throws Exception;
    public static final int text_mpn_shr = 0x08001f2c;
    public void text_mpn_shr(InterruptHandler handler) throws Exception
    {
        call(this::text_mpn_shr, handler);
    }

    // function: Function(address=134225770, size=88, name='text_mpn_add', path='build/py/mpz.o', has_indirect=False)
    abstract protected void text_mpn_add(int offset) throws Exception;
    public static final int text_mpn_add = 0x08001f6a;
    public void text_mpn_add(InterruptHandler handler) throws Exception
    {
        call(this::text_mpn_add, handler);
    }

    // function: Function(address=134225858, size=80, name='text_mpn_sub', path='build/py/mpz.o', has_indirect=False)
    abstract protected void text_mpn_sub(int offset) throws Exception;
    public static final int text_mpn_sub = 0x08001fc2;
    public void text_mpn_sub(InterruptHandler handler) throws Exception
    {
        call(this::text_mpn_sub, handler);
    }

    // function: Function(address=134225940, size=112, name='mpn_xor_neg', path='build/py/mpz.o', has_indirect=False)
    abstract protected void mpn_xor_neg(int offset) throws Exception;
    public static final int mpn_xor_neg = 0x08002014;
    public void mpn_xor_neg(InterruptHandler handler) throws Exception
    {
        call(this::mpn_xor_neg, handler);
    }

    // function: Function(address=134226052, size=50, name='mpz_need_dig', path='build/py/mpz.o', has_indirect=False)
    abstract protected void mpz_need_dig(int offset) throws Exception;
    public static final int mpz_need_dig = 0x08002084;
    public void mpz_need_dig(InterruptHandler handler) throws Exception
    {
        call(this::mpz_need_dig, handler);
    }

    // function: Function(address=134226102, size=76, name='mpz_clone', path='build/py/mpz.o', has_indirect=False)
    abstract protected void mpz_clone(int offset) throws Exception;
    public static final int mpz_clone = 0x080020b6;
    public void mpz_clone(InterruptHandler handler) throws Exception
    {
        call(this::mpz_clone, handler);
    }

    // function: Function(address=134226178, size=44, name='mpn_cmp_part_1', path='build/py/mpz.o', has_indirect=False)
    abstract protected void mpn_cmp_part_1(int offset) throws Exception;
    public static final int mpn_cmp_part_1 = 0x08002102;
    public void mpn_cmp_part_1(InterruptHandler handler) throws Exception
    {
        call(this::mpn_cmp_part_1, handler);
    }

    // function: Function(address=134226222, size=28, name='mpz_free', path='build/py/mpz.o', has_indirect=False)
    abstract protected void mpz_free(int offset) throws Exception;
    public static final int mpz_free = 0x0800212e;
    public void mpz_free(InterruptHandler handler) throws Exception
    {
        call(this::mpz_free, handler);
    }

    // function: Function(address=134226250, size=58, name='mpz_set_from_int_part_4', path='build/py/mpz.o', has_indirect=False)
    abstract protected void mpz_set_from_int_part_4(int offset) throws Exception;
    public static final int mpz_set_from_int_part_4 = 0x0800214a;
    public void mpz_set_from_int_part_4(InterruptHandler handler) throws Exception
    {
        call(this::mpz_set_from_int_part_4, handler);
    }

    // function: Function(address=134226308, size=10, name='mpz_init_zero', path='build/py/mpz.o', has_indirect=False)
    abstract protected void mpz_init_zero(int offset) throws Exception;
    public static final int mpz_init_zero = 0x08002184;
    public void mpz_init_zero(InterruptHandler handler) throws Exception
    {
        call(this::mpz_init_zero, handler);
    }

    // function: Function(address=134226318, size=26, name='mpz_deinit', path='build/py/mpz.o', has_indirect=False)
    abstract protected void mpz_deinit(int offset) throws Exception;
    public static final int mpz_deinit = 0x0800218e;
    public void mpz_deinit(InterruptHandler handler) throws Exception
    {
        call(this::mpz_deinit, handler);
    }

    // function: Function(address=134226344, size=46, name='mpz_set', path='build/py/mpz.o', has_indirect=False)
    abstract protected void mpz_set(int offset) throws Exception;
    public static final int mpz_set = 0x080021a8;
    public void mpz_set(InterruptHandler handler) throws Exception
    {
        call(this::mpz_set, handler);
    }

    // function: Function(address=134226390, size=16, name='mpz_set_from_int', path='build/py/mpz.o', has_indirect=False)
    abstract protected void mpz_set_from_int(int offset) throws Exception;
    public static final int mpz_set_from_int = 0x080021d6;
    public void mpz_set_from_int(InterruptHandler handler) throws Exception
    {
        call(this::mpz_set_from_int, handler);
    }

    // function: Function(address=134226406, size=20, name='mpz_init_from_int', path='build/py/mpz.o', has_indirect=False)
    abstract protected void mpz_init_from_int(int offset) throws Exception;
    public static final int mpz_init_from_int = 0x080021e6;
    public void mpz_init_from_int(InterruptHandler handler) throws Exception
    {
        call(this::mpz_init_from_int, handler);
    }

    // function: Function(address=134226426, size=42, name='mpz_init_fixed_from_int', path='build/py/mpz.o', has_indirect=False)
    abstract protected void mpz_init_fixed_from_int(int offset) throws Exception;
    public static final int mpz_init_fixed_from_int = 0x080021fa;
    public void mpz_init_fixed_from_int(InterruptHandler handler) throws Exception
    {
        call(this::mpz_init_fixed_from_int, handler);
    }

    // function: Function(address=134226468, size=88, name='mpz_set_from_ll', path='build/py/mpz.o', has_indirect=False)
    abstract protected void mpz_set_from_ll(int offset) throws Exception;
    public static final int mpz_set_from_ll = 0x08002224;
    public void mpz_set_from_ll(InterruptHandler handler) throws Exception
    {
        call(this::mpz_set_from_ll, handler);
    }

    // function: Function(address=134226556, size=190, name='mpz_set_from_float', path='build/py/mpz.o', has_indirect=False)
    abstract protected void mpz_set_from_float(int offset) throws Exception;
    public static final int mpz_set_from_float = 0x0800227c;
    public void mpz_set_from_float(InterruptHandler handler) throws Exception
    {
        call(this::mpz_set_from_float, handler);
    }

    // function: Function(address=134226746, size=164, name='mpz_set_from_str', path='build/py/mpz.o', has_indirect=False)
    abstract protected void mpz_set_from_str(int offset) throws Exception;
    public static final int mpz_set_from_str = 0x0800233a;
    public void mpz_set_from_str(InterruptHandler handler) throws Exception
    {
        call(this::mpz_set_from_str, handler);
    }

    // function: Function(address=134226910, size=106, name='mpz_set_from_bytes', path='build/py/mpz.o', has_indirect=False)
    abstract protected void mpz_set_from_bytes(int offset) throws Exception;
    public static final int mpz_set_from_bytes = 0x080023de;
    public void mpz_set_from_bytes(InterruptHandler handler) throws Exception
    {
        call(this::mpz_set_from_bytes, handler);
    }

    // function: Function(address=134227016, size=70, name='mpz_cmp', path='build/py/mpz.o', has_indirect=False)
    abstract protected void mpz_cmp(int offset) throws Exception;
    public static final int mpz_cmp = 0x08002448;
    public void mpz_cmp(InterruptHandler handler) throws Exception
    {
        call(this::mpz_cmp, handler);
    }

    // function: Function(address=134227086, size=22, name='mpz_abs_inpl', path='build/py/mpz.o', has_indirect=False)
    abstract protected void mpz_abs_inpl(int offset) throws Exception;
    public static final int mpz_abs_inpl = 0x0800248e;
    public void mpz_abs_inpl(InterruptHandler handler) throws Exception
    {
        call(this::mpz_abs_inpl, handler);
    }

    // function: Function(address=134227108, size=32, name='mpz_neg_inpl', path='build/py/mpz.o', has_indirect=False)
    abstract protected void mpz_neg_inpl(int offset) throws Exception;
    public static final int mpz_neg_inpl = 0x080024a4;
    public void mpz_neg_inpl(InterruptHandler handler) throws Exception
    {
        call(this::mpz_neg_inpl, handler);
    }

    // function: Function(address=134227140, size=110, name='mpz_not_inpl', path='build/py/mpz.o', has_indirect=False)
    abstract protected void mpz_not_inpl(int offset) throws Exception;
    public static final int mpz_not_inpl = 0x080024c4;
    public void mpz_not_inpl(InterruptHandler handler) throws Exception
    {
        call(this::mpz_not_inpl, handler);
    }

    // function: Function(address=134227252, size=208, name='mpz_shl_inpl', path='build/py/mpz.o', has_indirect=False)
    abstract protected void mpz_shl_inpl(int offset) throws Exception;
    public static final int mpz_shl_inpl = 0x08002534;
    public void mpz_shl_inpl(InterruptHandler handler) throws Exception
    {
        call(this::mpz_shl_inpl, handler);
    }

    // function: Function(address=134227460, size=194, name='mpz_shr_inpl', path='build/py/mpz.o', has_indirect=False)
    abstract protected void mpz_shr_inpl(int offset) throws Exception;
    public static final int mpz_shr_inpl = 0x08002604;
    public void mpz_shr_inpl(InterruptHandler handler) throws Exception
    {
        call(this::mpz_shr_inpl, handler);
    }

    // function: Function(address=134227654, size=116, name='mpz_add_inpl', path='build/py/mpz.o', has_indirect=False)
    abstract protected void mpz_add_inpl(int offset) throws Exception;
    public static final int mpz_add_inpl = 0x080026c6;
    public void mpz_add_inpl(InterruptHandler handler) throws Exception
    {
        call(this::mpz_add_inpl, handler);
    }

    // function: Function(address=134227770, size=130, name='mpz_sub_inpl', path='build/py/mpz.o', has_indirect=False)
    abstract protected void mpz_sub_inpl(int offset) throws Exception;
    public static final int mpz_sub_inpl = 0x0800273a;
    public void mpz_sub_inpl(InterruptHandler handler) throws Exception
    {
        call(this::mpz_sub_inpl, handler);
    }

    // function: Function(address=134227900, size=310, name='mpz_and_inpl', path='build/py/mpz.o', has_indirect=False)
    abstract protected void mpz_and_inpl(int offset) throws Exception;
    public static final int mpz_and_inpl = 0x080027bc;
    public void mpz_and_inpl(InterruptHandler handler) throws Exception
    {
        call(this::mpz_and_inpl, handler);
    }

    // function: Function(address=134228210, size=296, name='mpz_or_inpl', path='build/py/mpz.o', has_indirect=False)
    abstract protected void mpz_or_inpl(int offset) throws Exception;
    public static final int mpz_or_inpl = 0x080028f2;
    public void mpz_or_inpl(InterruptHandler handler) throws Exception
    {
        call(this::mpz_or_inpl, handler);
    }

    // function: Function(address=134228506, size=218, name='mpz_xor_inpl', path='build/py/mpz.o', has_indirect=False)
    abstract protected void mpz_xor_inpl(int offset) throws Exception;
    public static final int mpz_xor_inpl = 0x08002a1a;
    public void mpz_xor_inpl(InterruptHandler handler) throws Exception
    {
        call(this::mpz_xor_inpl, handler);
    }

    // function: Function(address=134228724, size=262, name='mpz_mul_inpl', path='build/py/mpz.o', has_indirect=False)
    abstract protected void mpz_mul_inpl(int offset) throws Exception;
    public static final int mpz_mul_inpl = 0x08002af4;
    public void mpz_mul_inpl(InterruptHandler handler) throws Exception
    {
        call(this::mpz_mul_inpl, handler);
    }

    // function: Function(address=134228986, size=132, name='mpz_pow_inpl', path='build/py/mpz.o', has_indirect=False)
    abstract protected void mpz_pow_inpl(int offset) throws Exception;
    public static final int mpz_pow_inpl = 0x08002bfa;
    public void mpz_pow_inpl(InterruptHandler handler) throws Exception
    {
        call(this::mpz_pow_inpl, handler);
    }

    // function: Function(address=134229120, size=688, name='mpz_divmod_inpl', path='build/py/mpz.o', has_indirect=False)
    abstract protected void mpz_divmod_inpl(int offset) throws Exception;
    public static final int mpz_divmod_inpl = 0x08002c80;
    public void mpz_divmod_inpl(InterruptHandler handler) throws Exception
    {
        call(this::mpz_divmod_inpl, handler);
    }

    // function: Function(address=134229808, size=182, name='mpz_pow3_inpl', path='build/py/mpz.o', has_indirect=False)
    abstract protected void mpz_pow3_inpl(int offset) throws Exception;
    public static final int mpz_pow3_inpl = 0x08002f30;
    public void mpz_pow3_inpl(InterruptHandler handler) throws Exception
    {
        call(this::mpz_pow3_inpl, handler);
    }

    // function: Function(address=134229990, size=40, name='mpz_hash', path='build/py/mpz.o', has_indirect=False)
    abstract protected void mpz_hash(int offset) throws Exception;
    public static final int mpz_hash = 0x08002fe6;
    public void mpz_hash(InterruptHandler handler) throws Exception
    {
        call(this::mpz_hash, handler);
    }

    // function: Function(address=134230032, size=56, name='mpz_as_int_checked', path='build/py/mpz.o', has_indirect=False)
    abstract protected void mpz_as_int_checked(int offset) throws Exception;
    public static final int mpz_as_int_checked = 0x08003010;
    public void mpz_as_int_checked(InterruptHandler handler) throws Exception
    {
        call(this::mpz_as_int_checked, handler);
    }

    // function: Function(address=134230088, size=142, name='mpz_as_bytes', path='build/py/mpz.o', has_indirect=False)
    abstract protected void mpz_as_bytes(int offset) throws Exception;
    public static final int mpz_as_bytes = 0x08003048;
    public void mpz_as_bytes(InterruptHandler handler) throws Exception
    {
        call(this::mpz_as_bytes, handler);
    }

    // function: Function(address=134230230, size=60, name='mpz_as_float', path='build/py/mpz.o', has_indirect=False)
    abstract protected void mpz_as_float(int offset) throws Exception;
    public static final int mpz_as_float = 0x080030d6;
    public void mpz_as_float(InterruptHandler handler) throws Exception
    {
        call(this::mpz_as_float, handler);
    }

    // function: Function(address=134230290, size=288, name='mpz_as_str_inpl', path='build/py/mpz.o', has_indirect=False)
    abstract protected void mpz_as_str_inpl(int offset) throws Exception;
    public static final int mpz_as_str_inpl = 0x08003112;
    public void mpz_as_str_inpl(InterruptHandler handler) throws Exception
    {
        call(this::mpz_as_str_inpl, handler);
    }

    // function: Function(address=134230578, size=22, name='mp_reader_mem_readbyte', path='build/py/reader.o', has_indirect=True)
    abstract protected void mp_reader_mem_readbyte(int offset) throws Exception;
    public static final int mp_reader_mem_readbyte = 0x08003232;
    public void mp_reader_mem_readbyte(InterruptHandler handler) throws Exception
    {
        call(this::mp_reader_mem_readbyte, handler);
    }

    // function: Function(address=134230600, size=26, name='mp_reader_mem_close', path='build/py/reader.o', has_indirect=True)
    abstract protected void mp_reader_mem_close(int offset) throws Exception;
    public static final int mp_reader_mem_close = 0x08003248;
    public void mp_reader_mem_close(InterruptHandler handler) throws Exception
    {
        call(this::mp_reader_mem_close, handler);
    }

    // function: Function(address=134230628, size=48, name='mp_reader_new_mem', path='build/py/reader.o', has_indirect=False)
    abstract protected void mp_reader_new_mem(int offset) throws Exception;
    public static final int mp_reader_new_mem = 0x08003264;
    public void mp_reader_new_mem(InterruptHandler handler) throws Exception
    {
        call(this::mp_reader_new_mem, handler);
    }

    // function: Function(address=134230676, size=80, name='is_string_or_bytes', path='build/py/lexer.o', has_indirect=False)
    abstract protected void is_string_or_bytes(int offset) throws Exception;
    public static final int is_string_or_bytes = 0x08003294;
    public void is_string_or_bytes(InterruptHandler handler) throws Exception
    {
        call(this::is_string_or_bytes, handler);
    }

    // function: Function(address=134230756, size=96, name='next_char', path='build/py/lexer.o', has_indirect=False)
    abstract protected void next_char(int offset) throws Exception;
    public static final int next_char = 0x080032e4;
    public void next_char(InterruptHandler handler) throws Exception
    {
        call(this::next_char, handler);
    }

    // function: Function(address=134230852, size=102, name='skip_whitespace', path='build/py/lexer.o', has_indirect=False)
    abstract protected void skip_whitespace(int offset) throws Exception;
    public static final int skip_whitespace = 0x08003344;
    public void skip_whitespace(InterruptHandler handler) throws Exception
    {
        call(this::skip_whitespace, handler);
    }

    // function: Function(address=134230956, size=1420, name='mp_lexer_to_next', path='build/py/lexer.o', has_indirect=False)
    abstract protected void mp_lexer_to_next(int offset) throws Exception;
    public static final int mp_lexer_to_next = 0x080033ac;
    public void mp_lexer_to_next(InterruptHandler handler) throws Exception
    {
        call(this::mp_lexer_to_next, handler);
    }

    // function: Function(address=134232376, size=122, name='mp_lexer_new', path='build/py/lexer.o', has_indirect=False)
    abstract protected void mp_lexer_new(int offset) throws Exception;
    public static final int mp_lexer_new = 0x08003938;
    public void mp_lexer_new(InterruptHandler handler) throws Exception
    {
        call(this::mp_lexer_new, handler);
    }

    // function: Function(address=134232498, size=26, name='mp_lexer_new_from_str_len', path='build/py/lexer.o', has_indirect=False)
    abstract protected void mp_lexer_new_from_str_len(int offset) throws Exception;
    public static final int mp_lexer_new_from_str_len = 0x080039b2;
    public void mp_lexer_new_from_str_len(InterruptHandler handler) throws Exception
    {
        call(this::mp_lexer_new_from_str_len, handler);
    }

    // function: Function(address=134232524, size=32, name='mp_lexer_new_from_file', path='build/py/lexer.o', has_indirect=False)
    abstract protected void mp_lexer_new_from_file(int offset) throws Exception;
    public static final int mp_lexer_new_from_file = 0x080039cc;
    public void mp_lexer_new_from_file(InterruptHandler handler) throws Exception
    {
        call(this::mp_lexer_new_from_file, handler);
    }

    // function: Function(address=134232556, size=40, name='mp_lexer_free', path='build/py/lexer.o', has_indirect=False)
    abstract protected void mp_lexer_free(int offset) throws Exception;
    public static final int mp_lexer_free = 0x080039ec;
    public void mp_lexer_free(InterruptHandler handler) throws Exception
    {
        call(this::mp_lexer_free, handler);
    }

    // function: Function(address=134232596, size=14, name='pop_result', path='build/py/parse.o', has_indirect=False)
    abstract protected void pop_result(int offset) throws Exception;
    public static final int pop_result = 0x08003a14;
    public void pop_result(InterruptHandler handler) throws Exception
    {
        call(this::pop_result, handler);
    }

    // function: Function(address=134232612, size=20, name='peek_result', path='build/py/parse.o', has_indirect=False)
    abstract protected void peek_result(int offset) throws Exception;
    public static final int peek_result = 0x08003a24;
    public void peek_result(InterruptHandler handler) throws Exception
    {
        call(this::peek_result, handler);
    }

    // function: Function(address=134232632, size=112, name='parser_alloc', path='build/py/parse.o', has_indirect=False)
    abstract protected void parser_alloc(int offset) throws Exception;
    public static final int parser_alloc = 0x08003a38;
    public void parser_alloc(InterruptHandler handler) throws Exception
    {
        call(this::parser_alloc, handler);
    }

    // function: Function(address=134232744, size=48, name='push_result_node', path='build/py/parse.o', has_indirect=False)
    abstract protected void push_result_node(int offset) throws Exception;
    public static final int push_result_node = 0x08003aa8;
    public void push_result_node(InterruptHandler handler) throws Exception
    {
        call(this::push_result_node, handler);
    }

    // function: Function(address=134232792, size=70, name='push_rule', path='build/py/parse.o', has_indirect=False)
    abstract protected void push_rule(int offset) throws Exception;
    public static final int push_rule = 0x08003ad8;
    public void push_rule(InterruptHandler handler) throws Exception
    {
        call(this::push_rule, handler);
    }

    // function: Function(address=134232862, size=16, name='push_rule_from_arg', path='build/py/parse.o', has_indirect=False)
    abstract protected void push_rule_from_arg(int offset) throws Exception;
    public static final int push_rule_from_arg = 0x08003b1e;
    public void push_rule_from_arg(InterruptHandler handler) throws Exception
    {
        call(this::push_rule_from_arg, handler);
    }

    // function: Function(address=134232880, size=224, name='push_result_token', path='build/py/parse.o', has_indirect=False)
    abstract protected void push_result_token(int offset) throws Exception;
    public static final int push_result_token = 0x08003b30;
    public void push_result_token(InterruptHandler handler) throws Exception
    {
        call(this::push_result_token, handler);
    }

    // function: Function(address=134233104, size=24, name='mp_parse_node_is_const_false', path='build/py/parse.o', has_indirect=False)
    abstract protected void mp_parse_node_is_const_false(int offset) throws Exception;
    public static final int mp_parse_node_is_const_false = 0x08003c10;
    public void mp_parse_node_is_const_false(InterruptHandler handler) throws Exception
    {
        call(this::mp_parse_node_is_const_false, handler);
    }

    // function: Function(address=134233128, size=26, name='mp_parse_node_is_const_true', path='build/py/parse.o', has_indirect=False)
    abstract protected void mp_parse_node_is_const_true(int offset) throws Exception;
    public static final int mp_parse_node_is_const_true = 0x08003c28;
    public void mp_parse_node_is_const_true(InterruptHandler handler) throws Exception
    {
        call(this::mp_parse_node_is_const_true, handler);
    }

    // function: Function(address=134233156, size=80, name='mp_parse_node_get_int_maybe', path='build/py/parse.o', has_indirect=False)
    abstract protected void mp_parse_node_get_int_maybe(int offset) throws Exception;
    public static final int mp_parse_node_get_int_maybe = 0x08003c44;
    public void mp_parse_node_get_int_maybe(InterruptHandler handler) throws Exception
    {
        call(this::mp_parse_node_get_int_maybe, handler);
    }

    // function: Function(address=134233236, size=972, name='push_result_rule', path='build/py/parse.o', has_indirect=False)
    abstract protected void push_result_rule(int offset) throws Exception;
    public static final int push_result_rule = 0x08003c94;
    public void push_result_rule(InterruptHandler handler) throws Exception
    {
        call(this::push_result_rule, handler);
    }

    // function: Function(address=134234208, size=40, name='mp_parse_node_extract_list', path='build/py/parse.o', has_indirect=False)
    abstract protected void mp_parse_node_extract_list(int offset) throws Exception;
    public static final int mp_parse_node_extract_list = 0x08004060;
    public void mp_parse_node_extract_list(InterruptHandler handler) throws Exception
    {
        call(this::mp_parse_node_extract_list, handler);
    }

    // function: Function(address=134234248, size=872, name='mp_parse', path='build/py/parse.o', has_indirect=False)
    abstract protected void mp_parse(int offset) throws Exception;
    public static final int mp_parse = 0x08004088;
    public void mp_parse(InterruptHandler handler) throws Exception
    {
        call(this::mp_parse, handler);
    }

    // function: Function(address=134235120, size=24, name='mp_parse_tree_clear', path='build/py/parse.o', has_indirect=False)
    abstract protected void mp_parse_tree_clear(int offset) throws Exception;
    public static final int mp_parse_tree_clear = 0x080043f0;
    public void mp_parse_tree_clear(InterruptHandler handler) throws Exception
    {
        call(this::mp_parse_tree_clear, handler);
    }

    // function: Function(address=134235144, size=76, name='scope_new', path='build/py/scope.o', has_indirect=False)
    abstract protected void scope_new(int offset) throws Exception;
    public static final int scope_new = 0x08004408;
    public void scope_new(InterruptHandler handler) throws Exception
    {
        call(this::scope_new, handler);
    }

    // function: Function(address=134235220, size=24, name='scope_free', path='build/py/scope.o', has_indirect=False)
    abstract protected void scope_free(int offset) throws Exception;
    public static final int scope_free = 0x08004454;
    public void scope_free(InterruptHandler handler) throws Exception
    {
        call(this::scope_free, handler);
    }

    // function: Function(address=134235244, size=32, name='scope_find', path='build/py/scope.o', has_indirect=False)
    abstract protected void scope_find(int offset) throws Exception;
    public static final int scope_find = 0x0800446c;
    public void scope_find(InterruptHandler handler) throws Exception
    {
        call(this::scope_find, handler);
    }

    // function: Function(address=134235276, size=70, name='scope_find_or_add_id', path='build/py/scope.o', has_indirect=False)
    abstract protected void scope_find_or_add_id(int offset) throws Exception;
    public static final int scope_find_or_add_id = 0x0800448c;
    public void scope_find_or_add_id(InterruptHandler handler) throws Exception
    {
        call(this::scope_find_or_add_id, handler);
    }

    // function: Function(address=134235346, size=18, name='scope_find_global', path='build/py/scope.o', has_indirect=False)
    abstract protected void scope_find_global(int offset) throws Exception;
    public static final int scope_find_global = 0x080044d2;
    public void scope_find_global(InterruptHandler handler) throws Exception
    {
        call(this::scope_find_global, handler);
    }

    // function: Function(address=134235364, size=88, name='scope_find_local_and_close_over', path='build/py/scope.o', has_indirect=False)
    abstract protected void scope_find_local_and_close_over(int offset) throws Exception;
    public static final int scope_find_local_and_close_over = 0x080044e4;
    public void scope_find_local_and_close_over(InterruptHandler handler) throws Exception
    {
        call(this::scope_find_local_and_close_over, handler);
    }

    // function: Function(address=134235452, size=20, name='compile_increase_except_level', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_increase_except_level(int offset) throws Exception;
    public static final int compile_increase_except_level = 0x0800453c;
    public void compile_increase_except_level(InterruptHandler handler) throws Exception
    {
        call(this::compile_increase_except_level, handler);
    }

    // function: Function(address=134235472, size=60, name='apply_to_single_or_list', path='build/py/compile.o', has_indirect=False)
    abstract protected void apply_to_single_or_list(int offset) throws Exception;
    public static final int apply_to_single_or_list = 0x08004550;
    public void apply_to_single_or_list(InterruptHandler handler) throws Exception
    {
        call(this::apply_to_single_or_list, handler);
    }

    // function: Function(address=134235532, size=20, name='compile_del_stmt', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_del_stmt(int offset) throws Exception;
    public static final int compile_del_stmt = 0x0800458c;
    public void compile_del_stmt(InterruptHandler handler) throws Exception
    {
        call(this::compile_del_stmt, handler);
    }

    // function: Function(address=134235552, size=20, name='compile_import_name', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_import_name(int offset) throws Exception;
    public static final int compile_import_name = 0x080045a0;
    public void compile_import_name(InterruptHandler handler) throws Exception
    {
        call(this::compile_import_name, handler);
    }

    // function: Function(address=134235572, size=44, name='scope_new_and_link', path='build/py/compile.o', has_indirect=False)
    abstract protected void scope_new_and_link(int offset) throws Exception;
    public static final int scope_new_and_link = 0x080045b4;
    public void scope_new_and_link(InterruptHandler handler) throws Exception
    {
        call(this::scope_new_and_link, handler);
    }

    // function: Function(address=134235616, size=16, name='compile_trailer_period', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_trailer_period(int offset) throws Exception;
    public static final int compile_trailer_period = 0x080045e0;
    public void compile_trailer_period(InterruptHandler handler) throws Exception
    {
        call(this::compile_trailer_period, handler);
    }

    // function: Function(address=134235632, size=12, name='compile_const_object', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_const_object(int offset) throws Exception;
    public static final int compile_const_object = 0x080045f0;
    public void compile_const_object(InterruptHandler handler) throws Exception
    {
        call(this::compile_const_object, handler);
    }

    // function: Function(address=134235644, size=160, name='close_over_variables_etc', path='build/py/compile.o', has_indirect=False)
    abstract protected void close_over_variables_etc(int offset) throws Exception;
    public static final int close_over_variables_etc = 0x080045fc;
    public void close_over_variables_etc(InterruptHandler handler) throws Exception
    {
        call(this::close_over_variables_etc, handler);
    }

    // function: Function(address=134235804, size=92, name='compile_funcdef_lambdef', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_funcdef_lambdef(int offset) throws Exception;
    public static final int compile_funcdef_lambdef = 0x0800469c;
    public void compile_funcdef_lambdef(InterruptHandler handler) throws Exception
    {
        call(this::compile_funcdef_lambdef, handler);
    }

    // function: Function(address=134235896, size=40, name='compile_lambdef', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_lambdef(int offset) throws Exception;
    public static final int compile_lambdef = 0x080046f8;
    public void compile_lambdef(InterruptHandler handler) throws Exception
    {
        call(this::compile_lambdef, handler);
    }

    // function: Function(address=134235936, size=42, name='compile_funcdef_helper', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_funcdef_helper(int offset) throws Exception;
    public static final int compile_funcdef_helper = 0x08004720;
    public void compile_funcdef_helper(InterruptHandler handler) throws Exception
    {
        call(this::compile_funcdef_helper, handler);
    }

    // function: Function(address=134235978, size=20, name='compile_error_set_line_isra_0', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_error_set_line_isra_0(int offset) throws Exception;
    public static final int compile_error_set_line_isra_0 = 0x0800474a;
    public void compile_error_set_line_isra_0(InterruptHandler handler) throws Exception
    {
        call(this::compile_error_set_line_isra_0, handler);
    }

    // function: Function(address=134236000, size=40, name='compile_syntax_error', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_syntax_error(int offset) throws Exception;
    public static final int compile_syntax_error = 0x08004760;
    public void compile_syntax_error(InterruptHandler handler) throws Exception
    {
        call(this::compile_syntax_error, handler);
    }

    // function: Function(address=134236040, size=16, name='compile_star_expr', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_star_expr(int offset) throws Exception;
    public static final int compile_star_expr = 0x08004788;
    public void compile_star_expr(InterruptHandler handler) throws Exception
    {
        call(this::compile_star_expr, handler);
    }

    // function: Function(address=134236056, size=64, name='compile_break_cont_stmt', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_break_cont_stmt(int offset) throws Exception;
    public static final int compile_break_cont_stmt = 0x08004798;
    public void compile_break_cont_stmt(InterruptHandler handler) throws Exception
    {
        call(this::compile_break_cont_stmt, handler);
    }

    // function: Function(address=134236120, size=168, name='compile_scope_func_lambda_param_isra_5', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_scope_func_lambda_param_isra_5(int offset) throws Exception;
    public static final int compile_scope_func_lambda_param_isra_5 = 0x080047d8;
    public void compile_scope_func_lambda_param_isra_5(InterruptHandler handler) throws Exception
    {
        call(this::compile_scope_func_lambda_param_isra_5, handler);
    }

    // function: Function(address=134236288, size=12, name='compile_scope_lambda_param', path='build/py/compile.o', has_indirect=True)
    abstract protected void compile_scope_lambda_param(int offset) throws Exception;
    public static final int compile_scope_lambda_param = 0x08004880;
    public void compile_scope_lambda_param(InterruptHandler handler) throws Exception
    {
        call(this::compile_scope_lambda_param, handler);
    }

    // function: Function(address=134236300, size=12, name='compile_scope_func_param', path='build/py/compile.o', has_indirect=True)
    abstract protected void compile_scope_func_param(int offset) throws Exception;
    public static final int compile_scope_func_param = 0x0800488c;
    public void compile_scope_func_param(InterruptHandler handler) throws Exception
    {
        call(this::compile_scope_func_param, handler);
    }

    // function: Function(address=134236312, size=30, name='compile_yield_from_isra_6', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_yield_from_isra_6(int offset) throws Exception;
    public static final int compile_yield_from_isra_6 = 0x08004898;
    public void compile_yield_from_isra_6(InterruptHandler handler) throws Exception
    {
        call(this::compile_yield_from_isra_6, handler);
    }

    // function: Function(address=134236342, size=34, name='compile_await_object_method', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_await_object_method(int offset) throws Exception;
    public static final int compile_await_object_method = 0x080048b6;
    public void compile_await_object_method(InterruptHandler handler) throws Exception
    {
        call(this::compile_await_object_method, handler);
    }

    // function: Function(address=134236376, size=36, name='compile_load_id', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_load_id(int offset) throws Exception;
    public static final int compile_load_id = 0x080048d8;
    public void compile_load_id(InterruptHandler handler) throws Exception
    {
        call(this::compile_load_id, handler);
    }

    // function: Function(address=134236412, size=36, name='compile_store_id', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_store_id(int offset) throws Exception;
    public static final int compile_store_id = 0x080048fc;
    public void compile_store_id(InterruptHandler handler) throws Exception
    {
        call(this::compile_store_id, handler);
    }

    // function: Function(address=134236448, size=22, name='compile_funcdef', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_funcdef(int offset) throws Exception;
    public static final int compile_funcdef = 0x08004920;
    public void compile_funcdef(InterruptHandler handler) throws Exception
    {
        call(this::compile_funcdef, handler);
    }

    // function: Function(address=134236472, size=36, name='compile_delete_id', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_delete_id(int offset) throws Exception;
    public static final int compile_delete_id = 0x08004938;
    public void compile_delete_id(InterruptHandler handler) throws Exception
    {
        call(this::compile_delete_id, handler);
    }

    // function: Function(address=134236508, size=200, name='compile_node', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_node(int offset) throws Exception;
    public static final int compile_node = 0x0800495c;
    public void compile_node(InterruptHandler handler) throws Exception
    {
        call(this::compile_node, handler);
    }

    // function: Function(address=134236708, size=388, name='c_assign', path='build/py/compile.o', has_indirect=False)
    abstract protected void c_assign(int offset) throws Exception;
    public static final int c_assign = 0x08004a24;
    public void c_assign(InterruptHandler handler) throws Exception
    {
        call(this::c_assign, handler);
    }

    // function: Function(address=134237096, size=212, name='c_assign_tuple', path='build/py/compile.o', has_indirect=False)
    abstract protected void c_assign_tuple(int offset) throws Exception;
    public static final int c_assign_tuple = 0x08004ba8;
    public void c_assign_tuple(InterruptHandler handler) throws Exception
    {
        call(this::c_assign_tuple, handler);
    }

    // function: Function(address=134237308, size=228, name='c_if_cond', path='build/py/compile.o', has_indirect=False)
    abstract protected void c_if_cond(int offset) throws Exception;
    public static final int c_if_cond = 0x08004c7c;
    public void c_if_cond(InterruptHandler handler) throws Exception
    {
        call(this::c_if_cond, handler);
    }

    // function: Function(address=134237536, size=178, name='compile_scope_comp_iter', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_scope_comp_iter(int offset) throws Exception;
    public static final int compile_scope_comp_iter = 0x08004d60;
    public void compile_scope_comp_iter(InterruptHandler handler) throws Exception
    {
        call(this::compile_scope_comp_iter, handler);
    }

    // function: Function(address=134237716, size=168, name='check_for_doc_string', path='build/py/compile.o', has_indirect=False)
    abstract protected void check_for_doc_string(int offset) throws Exception;
    public static final int check_for_doc_string = 0x08004e14;
    public void check_for_doc_string(InterruptHandler handler) throws Exception
    {
        call(this::check_for_doc_string, handler);
    }

    // function: Function(address=134237884, size=448, name='compile_scope', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_scope(int offset) throws Exception;
    public static final int compile_scope = 0x08004ebc;
    public void compile_scope(InterruptHandler handler) throws Exception
    {
        call(this::compile_scope, handler);
    }

    // function: Function(address=134238332, size=22, name='compile_dictorsetmaker_item', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_dictorsetmaker_item(int offset) throws Exception;
    public static final int compile_dictorsetmaker_item = 0x0800507c;
    public void compile_dictorsetmaker_item(InterruptHandler handler) throws Exception
    {
        call(this::compile_dictorsetmaker_item, handler);
    }

    // function: Function(address=134238354, size=132, name='compile_subscript', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_subscript(int offset) throws Exception;
    public static final int compile_subscript = 0x08005092;
    public void compile_subscript(InterruptHandler handler) throws Exception
    {
        call(this::compile_subscript, handler);
    }

    // function: Function(address=134238486, size=20, name='compile_trailer_bracket', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_trailer_bracket(int offset) throws Exception;
    public static final int compile_trailer_bracket = 0x08005116;
    public void compile_trailer_bracket(InterruptHandler handler) throws Exception
    {
        call(this::compile_trailer_bracket, handler);
    }

    // function: Function(address=134238506, size=66, name='text_c_tuple', path='build/py/compile.o', has_indirect=False)
    abstract protected void text_c_tuple(int offset) throws Exception;
    public static final int text_c_tuple = 0x0800512a;
    public void text_c_tuple(InterruptHandler handler) throws Exception
    {
        call(this::text_c_tuple, handler);
    }

    // function: Function(address=134238572, size=12, name='compile_generic_tuple', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_generic_tuple(int offset) throws Exception;
    public static final int compile_generic_tuple = 0x0800516c;
    public void compile_generic_tuple(InterruptHandler handler) throws Exception
    {
        call(this::compile_generic_tuple, handler);
    }

    // function: Function(address=134238584, size=140, name='compile_while_stmt', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_while_stmt(int offset) throws Exception;
    public static final int compile_while_stmt = 0x08005178;
    public void compile_while_stmt(InterruptHandler handler) throws Exception
    {
        call(this::compile_while_stmt, handler);
    }

    // function: Function(address=134238724, size=18, name='compile_yield_stmt', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_yield_stmt(int offset) throws Exception;
    public static final int compile_yield_stmt = 0x08005204;
    public void compile_yield_stmt(InterruptHandler handler) throws Exception
    {
        call(this::compile_yield_stmt, handler);
    }

    // function: Function(address=134238744, size=260, name='c_del_stmt', path='build/py/compile.o', has_indirect=True)
    abstract protected void c_del_stmt(int offset) throws Exception;
    public static final int c_del_stmt = 0x08005218;
    public void c_del_stmt(InterruptHandler handler) throws Exception
    {
        call(this::c_del_stmt, handler);
    }

    // function: Function(address=134239004, size=54, name='compile_generic_all_nodes', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_generic_all_nodes(int offset) throws Exception;
    public static final int compile_generic_all_nodes = 0x0800531c;
    public void compile_generic_all_nodes(InterruptHandler handler) throws Exception
    {
        call(this::compile_generic_all_nodes, handler);
    }

    // function: Function(address=134239058, size=18, name='compile_power', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_power(int offset) throws Exception;
    public static final int compile_power = 0x08005352;
    public void compile_power(InterruptHandler handler) throws Exception
    {
        call(this::compile_power, handler);
    }

    // function: Function(address=134239076, size=228, name='compile_if_stmt', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_if_stmt(int offset) throws Exception;
    public static final int compile_if_stmt = 0x08005364;
    public void compile_if_stmt(InterruptHandler handler) throws Exception
    {
        call(this::compile_if_stmt, handler);
    }

    // function: Function(address=134239304, size=74, name='compile_comprehension', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_comprehension(int offset) throws Exception;
    public static final int compile_comprehension = 0x08005448;
    public void compile_comprehension(InterruptHandler handler) throws Exception
    {
        call(this::compile_comprehension, handler);
    }

    // function: Function(address=134239378, size=136, name='compile_atom_bracket', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_atom_bracket(int offset) throws Exception;
    public static final int compile_atom_bracket = 0x08005492;
    public void compile_atom_bracket(InterruptHandler handler) throws Exception
    {
        call(this::compile_atom_bracket, handler);
    }

    // function: Function(address=134239516, size=344, name='compile_trailer_paren_helper', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_trailer_paren_helper(int offset) throws Exception;
    public static final int compile_trailer_paren_helper = 0x0800551c;
    public void compile_trailer_paren_helper(InterruptHandler handler) throws Exception
    {
        call(this::compile_trailer_paren_helper, handler);
    }

    // function: Function(address=134239860, size=86, name='compile_classdef_helper', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_classdef_helper(int offset) throws Exception;
    public static final int compile_classdef_helper = 0x08005674;
    public void compile_classdef_helper(InterruptHandler handler) throws Exception
    {
        call(this::compile_classdef_helper, handler);
    }

    // function: Function(address=134239946, size=22, name='compile_classdef', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_classdef(int offset) throws Exception;
    public static final int compile_classdef = 0x080056ca;
    public void compile_classdef(InterruptHandler handler) throws Exception
    {
        call(this::compile_classdef, handler);
    }

    // function: Function(address=134239968, size=14, name='compile_trailer_paren', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_trailer_paren(int offset) throws Exception;
    public static final int compile_trailer_paren = 0x080056e0;
    public void compile_trailer_paren(InterruptHandler handler) throws Exception
    {
        call(this::compile_trailer_paren, handler);
    }

    // function: Function(address=134239984, size=264, name='compile_decorated', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_decorated(int offset) throws Exception;
    public static final int compile_decorated = 0x080056f0;
    public void compile_decorated(InterruptHandler handler) throws Exception
    {
        call(this::compile_decorated, handler);
    }

    // function: Function(address=134240248, size=304, name='compile_atom_brace', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_atom_brace(int offset) throws Exception;
    public static final int compile_atom_brace = 0x080057f8;
    public void compile_atom_brace(InterruptHandler handler) throws Exception
    {
        call(this::compile_atom_brace, handler);
    }

    // function: Function(address=134240552, size=164, name='compile_funcdef_lambdef_param', path='build/py/compile.o', has_indirect=True)
    abstract protected void compile_funcdef_lambdef_param(int offset) throws Exception;
    public static final int compile_funcdef_lambdef_param = 0x08005928;
    public void compile_funcdef_lambdef_param(InterruptHandler handler) throws Exception
    {
        call(this::compile_funcdef_lambdef_param, handler);
    }

    // function: Function(address=134240716, size=300, name='compile_atom_expr_normal', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_atom_expr_normal(int offset) throws Exception;
    public static final int compile_atom_expr_normal = 0x080059cc;
    public void compile_atom_expr_normal(InterruptHandler handler) throws Exception
    {
        call(this::compile_atom_expr_normal, handler);
    }

    // function: Function(address=134241016, size=76, name='compile_term', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_term(int offset) throws Exception;
    public static final int compile_term = 0x08005af8;
    public void compile_term(InterruptHandler handler) throws Exception
    {
        call(this::compile_term, handler);
    }

    // function: Function(address=134241092, size=58, name='compile_binary_op', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_binary_op(int offset) throws Exception;
    public static final int compile_binary_op = 0x08005b44;
    public void compile_binary_op(InterruptHandler handler) throws Exception
    {
        call(this::compile_binary_op, handler);
    }

    // function: Function(address=134241152, size=440, name='compile_expr_stmt', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_expr_stmt(int offset) throws Exception;
    public static final int compile_expr_stmt = 0x08005b80;
    public void compile_expr_stmt(InterruptHandler handler) throws Exception
    {
        call(this::compile_expr_stmt, handler);
    }

    // function: Function(address=134241592, size=42, name='compile_factor_2', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_factor_2(int offset) throws Exception;
    public static final int compile_factor_2 = 0x08005d38;
    public void compile_factor_2(InterruptHandler handler) throws Exception
    {
        call(this::compile_factor_2, handler);
    }

    // function: Function(address=134241634, size=20, name='compile_not_test_2', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_not_test_2(int offset) throws Exception;
    public static final int compile_not_test_2 = 0x08005d62;
    public void compile_not_test_2(InterruptHandler handler) throws Exception
    {
        call(this::compile_not_test_2, handler);
    }

    // function: Function(address=134241654, size=80, name='compile_or_and_test', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_or_and_test(int offset) throws Exception;
    public static final int compile_or_and_test = 0x08005d76;
    public void compile_or_and_test(InterruptHandler handler) throws Exception
    {
        call(this::compile_or_and_test, handler);
    }

    // function: Function(address=134241736, size=200, name='compile_comparison', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_comparison(int offset) throws Exception;
    public static final int compile_comparison = 0x08005dc8;
    public void compile_comparison(InterruptHandler handler) throws Exception
    {
        call(this::compile_comparison, handler);
    }

    // function: Function(address=134241936, size=80, name='compile_test_if_expr', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_test_if_expr(int offset) throws Exception;
    public static final int compile_test_if_expr = 0x08005e90;
    public void compile_test_if_expr(InterruptHandler handler) throws Exception
    {
        call(this::compile_test_if_expr, handler);
    }

    // function: Function(address=134242016, size=672, name='compile_for_stmt', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_for_stmt(int offset) throws Exception;
    public static final int compile_for_stmt = 0x08005ee0;
    public void compile_for_stmt(InterruptHandler handler) throws Exception
    {
        call(this::compile_for_stmt, handler);
    }

    // function: Function(address=134242688, size=150, name='compile_with_stmt_helper', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_with_stmt_helper(int offset) throws Exception;
    public static final int compile_with_stmt_helper = 0x08006180;
    public void compile_with_stmt_helper(InterruptHandler handler) throws Exception
    {
        call(this::compile_with_stmt_helper, handler);
    }

    // function: Function(address=134242838, size=32, name='compile_with_stmt', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_with_stmt(int offset) throws Exception;
    public static final int compile_with_stmt = 0x08006216;
    public void compile_with_stmt(InterruptHandler handler) throws Exception
    {
        call(this::compile_with_stmt, handler);
    }

    // function: Function(address=134242872, size=412, name='compile_try_except', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_try_except(int offset) throws Exception;
    public static final int compile_try_except = 0x08006238;
    public void compile_try_except(InterruptHandler handler) throws Exception
    {
        call(this::compile_try_except, handler);
    }

    // function: Function(address=134243284, size=128, name='compile_try_finally', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_try_finally(int offset) throws Exception;
    public static final int compile_try_finally = 0x080063d4;
    public void compile_try_finally(InterruptHandler handler) throws Exception
    {
        call(this::compile_try_finally, handler);
    }

    // function: Function(address=134243412, size=106, name='compile_try_stmt', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_try_stmt(int offset) throws Exception;
    public static final int compile_try_stmt = 0x08006454;
    public void compile_try_stmt(InterruptHandler handler) throws Exception
    {
        call(this::compile_try_stmt, handler);
    }

    // function: Function(address=134243518, size=498, name='compile_async_with_stmt_helper', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_async_with_stmt_helper(int offset) throws Exception;
    public static final int compile_async_with_stmt_helper = 0x080064be;
    public void compile_async_with_stmt_helper(InterruptHandler handler) throws Exception
    {
        call(this::compile_async_with_stmt_helper, handler);
    }

    // function: Function(address=134244016, size=358, name='compile_async_stmt', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_async_stmt(int offset) throws Exception;
    public static final int compile_async_stmt = 0x080066b0;
    public void compile_async_stmt(InterruptHandler handler) throws Exception
    {
        call(this::compile_async_stmt, handler);
    }

    // function: Function(address=134244376, size=92, name='compile_yield_expr', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_yield_expr(int offset) throws Exception;
    public static final int compile_yield_expr = 0x08006818;
    public void compile_yield_expr(InterruptHandler handler) throws Exception
    {
        call(this::compile_yield_expr, handler);
    }

    // function: Function(address=134244468, size=112, name='compile_return_stmt', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_return_stmt(int offset) throws Exception;
    public static final int compile_return_stmt = 0x08006874;
    public void compile_return_stmt(InterruptHandler handler) throws Exception
    {
        call(this::compile_return_stmt, handler);
    }

    // function: Function(address=134244580, size=62, name='compile_atom_paren', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_atom_paren(int offset) throws Exception;
    public static final int compile_atom_paren = 0x080068e4;
    public void compile_atom_paren(InterruptHandler handler) throws Exception
    {
        call(this::compile_atom_paren, handler);
    }

    // function: Function(address=134244644, size=44, name='compile_atom_expr_await', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_atom_expr_await(int offset) throws Exception;
    public static final int compile_atom_expr_await = 0x08006924;
    public void compile_atom_expr_await(InterruptHandler handler) throws Exception
    {
        call(this::compile_atom_expr_await, handler);
    }

    // function: Function(address=134244688, size=92, name='compile_assert_stmt', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_assert_stmt(int offset) throws Exception;
    public static final int compile_assert_stmt = 0x08006950;
    public void compile_assert_stmt(InterruptHandler handler) throws Exception
    {
        call(this::compile_assert_stmt, handler);
    }

    // function: Function(address=134244780, size=58, name='compile_raise_stmt', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_raise_stmt(int offset) throws Exception;
    public static final int compile_raise_stmt = 0x080069ac;
    public void compile_raise_stmt(InterruptHandler handler) throws Exception
    {
        call(this::compile_raise_stmt, handler);
    }

    // function: Function(address=134244840, size=192, name='compile_global_nonlocal_stmt', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_global_nonlocal_stmt(int offset) throws Exception;
    public static final int compile_global_nonlocal_stmt = 0x080069e8;
    public void compile_global_nonlocal_stmt(InterruptHandler handler) throws Exception
    {
        call(this::compile_global_nonlocal_stmt, handler);
    }

    // function: Function(address=134245032, size=256, name='do_import_name_isra_19', path='build/py/compile.o', has_indirect=False)
    abstract protected void do_import_name_isra_19(int offset) throws Exception;
    public static final int do_import_name_isra_19 = 0x08006aa8;
    public void do_import_name_isra_19(InterruptHandler handler) throws Exception
    {
        call(this::do_import_name_isra_19, handler);
    }

    // function: Function(address=134245288, size=284, name='compile_import_from', path='build/py/compile.o', has_indirect=False)
    abstract protected void compile_import_from(int offset) throws Exception;
    public static final int compile_import_from = 0x08006ba8;
    public void compile_import_from(InterruptHandler handler) throws Exception
    {
        call(this::compile_import_from, handler);
    }

    // function: Function(address=134245572, size=44, name='compile_dotted_as_name', path='build/py/compile.o', has_indirect=True)
    abstract protected void compile_dotted_as_name(int offset) throws Exception;
    public static final int compile_dotted_as_name = 0x08006cc4;
    public void compile_dotted_as_name(InterruptHandler handler) throws Exception
    {
        call(this::compile_dotted_as_name, handler);
    }

    // function: Function(address=134245616, size=602, name='mp_compile', path='build/py/compile.o', has_indirect=False)
    abstract protected void mp_compile(int offset) throws Exception;
    public static final int mp_compile = 0x08006cf0;
    public void mp_compile(InterruptHandler handler) throws Exception
    {
        call(this::mp_compile, handler);
    }

    // function: Function(address=134246218, size=34, name='mp_emit_common_get_id_for_load', path='build/py/emitcommon.o', has_indirect=False)
    abstract protected void mp_emit_common_get_id_for_load(int offset) throws Exception;
    public static final int mp_emit_common_get_id_for_load = 0x08006f4a;
    public void mp_emit_common_get_id_for_load(InterruptHandler handler) throws Exception
    {
        call(this::mp_emit_common_get_id_for_load, handler);
    }

    // function: Function(address=134246252, size=50, name='mp_emit_common_get_id_for_modification', path='build/py/emitcommon.o', has_indirect=False)
    abstract protected void mp_emit_common_get_id_for_modification(int offset) throws Exception;
    public static final int mp_emit_common_get_id_for_modification = 0x08006f6c;
    public void mp_emit_common_get_id_for_modification(InterruptHandler handler) throws Exception
    {
        call(this::mp_emit_common_get_id_for_modification, handler);
    }

    // function: Function(address=134246302, size=60, name='mp_emit_common_id_op', path='build/py/emitcommon.o', has_indirect=False)
    abstract protected void mp_emit_common_id_op(int offset) throws Exception;
    public static final int mp_emit_common_id_op = 0x08006f9e;
    public void mp_emit_common_id_op(InterruptHandler handler) throws Exception
    {
        call(this::mp_emit_common_id_op, handler);
    }

    // function: Function(address=134246362, size=62, name='emit_write_uint', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void emit_write_uint(int offset) throws Exception;
    public static final int emit_write_uint = 0x08006fda;
    public void emit_write_uint(InterruptHandler handler) throws Exception
    {
        call(this::emit_write_uint, handler);
    }

    // function: Function(address=134246424, size=26, name='emit_get_cur_to_write_code_info', path='build/py/emitbc.o', has_indirect=True)
    abstract protected void emit_get_cur_to_write_code_info(int offset) throws Exception;
    public static final int emit_get_cur_to_write_code_info = 0x08007018;
    public void emit_get_cur_to_write_code_info(InterruptHandler handler) throws Exception
    {
        call(this::emit_get_cur_to_write_code_info, handler);
    }

    // function: Function(address=134246450, size=14, name='emit_write_code_info_byte', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void emit_write_code_info_byte(int offset) throws Exception;
    public static final int emit_write_code_info_byte = 0x08007032;
    public void emit_write_code_info_byte(InterruptHandler handler) throws Exception
    {
        call(this::emit_write_code_info_byte, handler);
    }

    // function: Function(address=134246464, size=30, name='emit_get_cur_to_write_bytecode', path='build/py/emitbc.o', has_indirect=True)
    abstract protected void emit_get_cur_to_write_bytecode(int offset) throws Exception;
    public static final int emit_get_cur_to_write_bytecode = 0x08007040;
    public void emit_get_cur_to_write_bytecode(InterruptHandler handler) throws Exception
    {
        call(this::emit_get_cur_to_write_bytecode, handler);
    }

    // function: Function(address=134246494, size=14, name='emit_write_bytecode_byte', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void emit_write_bytecode_byte(int offset) throws Exception;
    public static final int emit_write_bytecode_byte = 0x0800705e;
    public void emit_write_bytecode_byte(InterruptHandler handler) throws Exception
    {
        call(this::emit_write_bytecode_byte, handler);
    }

    // function: Function(address=134246508, size=28, name='emit_write_bytecode_byte_uint', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void emit_write_bytecode_byte_uint(int offset) throws Exception;
    public static final int emit_write_bytecode_byte_uint = 0x0800706c;
    public void emit_write_bytecode_byte_uint(InterruptHandler handler) throws Exception
    {
        call(this::emit_write_bytecode_byte_uint, handler);
    }

    // function: Function(address=134246536, size=42, name='emit_write_bytecode_byte_raw_code', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void emit_write_bytecode_byte_raw_code(int offset) throws Exception;
    public static final int emit_write_bytecode_byte_raw_code = 0x08007088;
    public void emit_write_bytecode_byte_raw_code(InterruptHandler handler) throws Exception
    {
        call(this::emit_write_bytecode_byte_raw_code, handler);
    }

    // function: Function(address=134246578, size=12, name='mp_emit_bc_delete_local', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_delete_local(int offset) throws Exception;
    public static final int mp_emit_bc_delete_local = 0x080070b2;
    public void mp_emit_bc_delete_local(InterruptHandler handler) throws Exception
    {
        call(this::mp_emit_bc_delete_local, handler);
    }

    // function: Function(address=134246590, size=22, name='emit_write_bytecode_byte_qstr', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void emit_write_bytecode_byte_qstr(int offset) throws Exception;
    public static final int emit_write_bytecode_byte_qstr = 0x080070be;
    public void emit_write_bytecode_byte_qstr(InterruptHandler handler) throws Exception
    {
        call(this::emit_write_bytecode_byte_qstr, handler);
    }

    // function: Function(address=134246612, size=42, name='emit_write_bytecode_byte_unsigned_label', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void emit_write_bytecode_byte_unsigned_label(int offset) throws Exception;
    public static final int emit_write_bytecode_byte_unsigned_label = 0x080070d4;
    public void emit_write_bytecode_byte_unsigned_label(InterruptHandler handler) throws Exception
    {
        call(this::emit_write_bytecode_byte_unsigned_label, handler);
    }

    // function: Function(address=134246656, size=48, name='emit_write_bytecode_byte_signed_label', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void emit_write_bytecode_byte_signed_label(int offset) throws Exception;
    public static final int emit_write_bytecode_byte_signed_label = 0x08007100;
    public void emit_write_bytecode_byte_signed_label(InterruptHandler handler) throws Exception
    {
        call(this::emit_write_bytecode_byte_signed_label, handler);
    }

    // function: Function(address=134246704, size=38, name='emit_write_bytecode_byte_obj_constprop_8', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void emit_write_bytecode_byte_obj_constprop_8(int offset) throws Exception;
    public static final int emit_write_bytecode_byte_obj_constprop_8 = 0x08007130;
    public void emit_write_bytecode_byte_obj_constprop_8(InterruptHandler handler) throws Exception
    {
        call(this::emit_write_bytecode_byte_obj_constprop_8, handler);
    }

    // function: Function(address=134246742, size=10, name='emit_bc_new', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void emit_bc_new(int offset) throws Exception;
    public static final int emit_bc_new = 0x08007156;
    public void emit_bc_new(InterruptHandler handler) throws Exception
    {
        call(this::emit_bc_new, handler);
    }

    // function: Function(address=134246752, size=16, name='emit_bc_set_max_num_labels', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void emit_bc_set_max_num_labels(int offset) throws Exception;
    public static final int emit_bc_set_max_num_labels = 0x08007160;
    public void emit_bc_set_max_num_labels(InterruptHandler handler) throws Exception
    {
        call(this::emit_bc_set_max_num_labels, handler);
    }

    // function: Function(address=134246768, size=24, name='emit_bc_free', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void emit_bc_free(int offset) throws Exception;
    public static final int emit_bc_free = 0x08007170;
    public void emit_bc_free(InterruptHandler handler) throws Exception
    {
        call(this::emit_bc_free, handler);
    }

    // function: Function(address=134246792, size=288, name='mp_emit_bc_start_pass', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_start_pass(int offset) throws Exception;
    public static final int mp_emit_bc_start_pass = 0x08007188;
    public void mp_emit_bc_start_pass(InterruptHandler handler) throws Exception
    {
        call(this::mp_emit_bc_start_pass, handler);
    }

    // function: Function(address=134247080, size=88, name='mp_emit_bc_end_pass', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_end_pass(int offset) throws Exception;
    public static final int mp_emit_bc_end_pass = 0x080072a8;
    public void mp_emit_bc_end_pass(InterruptHandler handler) throws Exception
    {
        call(this::mp_emit_bc_end_pass, handler);
    }

    // function: Function(address=134247168, size=10, name='mp_emit_bc_last_emit_was_return_value', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_last_emit_was_return_value(int offset) throws Exception;
    public static final int mp_emit_bc_last_emit_was_return_value = 0x08007300;
    public void mp_emit_bc_last_emit_was_return_value(InterruptHandler handler) throws Exception
    {
        call(this::mp_emit_bc_last_emit_was_return_value, handler);
    }

    // function: Function(address=134247178, size=28, name='mp_emit_bc_adjust_stack_size', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_adjust_stack_size(int offset) throws Exception;
    public static final int mp_emit_bc_adjust_stack_size = 0x0800730a;
    public void mp_emit_bc_adjust_stack_size(InterruptHandler handler) throws Exception
    {
        call(this::mp_emit_bc_adjust_stack_size, handler);
    }

    // function: Function(address=134247206, size=50, name='mp_emit_bc_load_local', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_load_local(int offset) throws Exception;
    public static final int mp_emit_bc_load_local = 0x08007326;
    public void mp_emit_bc_load_local(InterruptHandler handler) throws Exception
    {
        call(this::mp_emit_bc_load_local, handler);
    }

    // function: Function(address=134247256, size=48, name='mp_emit_bc_load_global', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_load_global(int offset) throws Exception;
    public static final int mp_emit_bc_load_global = 0x08007358;
    public void mp_emit_bc_load_global(InterruptHandler handler) throws Exception
    {
        call(this::mp_emit_bc_load_global, handler);
    }

    // function: Function(address=134247304, size=52, name='mp_emit_bc_store_local', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_store_local(int offset) throws Exception;
    public static final int mp_emit_bc_store_local = 0x08007388;
    public void mp_emit_bc_store_local(InterruptHandler handler) throws Exception
    {
        call(this::mp_emit_bc_store_local, handler);
    }

    // function: Function(address=134247356, size=32, name='mp_emit_bc_store_global', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_store_global(int offset) throws Exception;
    public static final int mp_emit_bc_store_global = 0x080073bc;
    public void mp_emit_bc_store_global(InterruptHandler handler) throws Exception
    {
        call(this::mp_emit_bc_store_global, handler);
    }

    // function: Function(address=134247388, size=28, name='mp_emit_bc_delete_global', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_delete_global(int offset) throws Exception;
    public static final int mp_emit_bc_delete_global = 0x080073dc;
    public void mp_emit_bc_delete_global(InterruptHandler handler) throws Exception
    {
        call(this::mp_emit_bc_delete_global, handler);
    }

    // function: Function(address=134247416, size=60, name='emit_bc_call_function_method_helper', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void emit_bc_call_function_method_helper(int offset) throws Exception;
    public static final int emit_bc_call_function_method_helper = 0x080073f8;
    public void emit_bc_call_function_method_helper(InterruptHandler handler) throws Exception
    {
        call(this::emit_bc_call_function_method_helper, handler);
    }

    // function: Function(address=134247476, size=152, name='mp_emit_bc_set_source_line', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_set_source_line(int offset) throws Exception;
    public static final int mp_emit_bc_set_source_line = 0x08007434;
    public void mp_emit_bc_set_source_line(InterruptHandler handler) throws Exception
    {
        call(this::mp_emit_bc_set_source_line, handler);
    }

    // function: Function(address=134247628, size=32, name='mp_emit_bc_label_assign', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_label_assign(int offset) throws Exception;
    public static final int mp_emit_bc_label_assign = 0x080074cc;
    public void mp_emit_bc_label_assign(InterruptHandler handler) throws Exception
    {
        call(this::mp_emit_bc_label_assign, handler);
    }

    // function: Function(address=134247660, size=56, name='mp_emit_bc_import', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_import(int offset) throws Exception;
    public static final int mp_emit_bc_import = 0x080074ec;
    public void mp_emit_bc_import(InterruptHandler handler) throws Exception
    {
        call(this::mp_emit_bc_import, handler);
    }

    // function: Function(address=134247716, size=56, name='mp_emit_bc_load_const_tok', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_load_const_tok(int offset) throws Exception;
    public static final int mp_emit_bc_load_const_tok = 0x08007524;
    public void mp_emit_bc_load_const_tok(InterruptHandler handler) throws Exception
    {
        call(this::mp_emit_bc_load_const_tok, handler);
    }

    // function: Function(address=134247772, size=144, name='mp_emit_bc_load_const_small_int', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_load_const_small_int(int offset) throws Exception;
    public static final int mp_emit_bc_load_const_small_int = 0x0800755c;
    public void mp_emit_bc_load_const_small_int(InterruptHandler handler) throws Exception
    {
        call(this::mp_emit_bc_load_const_small_int, handler);
    }

    // function: Function(address=134247916, size=24, name='mp_emit_bc_load_const_str', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_load_const_str(int offset) throws Exception;
    public static final int mp_emit_bc_load_const_str = 0x080075ec;
    public void mp_emit_bc_load_const_str(InterruptHandler handler) throws Exception
    {
        call(this::mp_emit_bc_load_const_str, handler);
    }

    // function: Function(address=134247940, size=22, name='mp_emit_bc_load_const_obj', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_load_const_obj(int offset) throws Exception;
    public static final int mp_emit_bc_load_const_obj = 0x08007604;
    public void mp_emit_bc_load_const_obj(InterruptHandler handler) throws Exception
    {
        call(this::mp_emit_bc_load_const_obj, handler);
    }

    // function: Function(address=134247962, size=20, name='mp_emit_bc_load_null', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_load_null(int offset) throws Exception;
    public static final int mp_emit_bc_load_null = 0x0800761a;
    public void mp_emit_bc_load_null(InterruptHandler handler) throws Exception
    {
        call(this::mp_emit_bc_load_null, handler);
    }

    // function: Function(address=134247982, size=36, name='mp_emit_bc_load_method', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_load_method(int offset) throws Exception;
    public static final int mp_emit_bc_load_method = 0x0800762e;
    public void mp_emit_bc_load_method(InterruptHandler handler) throws Exception
    {
        call(this::mp_emit_bc_load_method, handler);
    }

    // function: Function(address=134248018, size=20, name='mp_emit_bc_load_build_class', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_load_build_class(int offset) throws Exception;
    public static final int mp_emit_bc_load_build_class = 0x08007652;
    public void mp_emit_bc_load_build_class(InterruptHandler handler) throws Exception
    {
        call(this::mp_emit_bc_load_build_class, handler);
    }

    // function: Function(address=134248038, size=20, name='mp_emit_bc_dup_top', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_dup_top(int offset) throws Exception;
    public static final int mp_emit_bc_dup_top = 0x08007666;
    public void mp_emit_bc_dup_top(InterruptHandler handler) throws Exception
    {
        call(this::mp_emit_bc_dup_top, handler);
    }

    // function: Function(address=134248058, size=20, name='mp_emit_bc_dup_top_two', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_dup_top_two(int offset) throws Exception;
    public static final int mp_emit_bc_dup_top_two = 0x0800767a;
    public void mp_emit_bc_dup_top_two(InterruptHandler handler) throws Exception
    {
        call(this::mp_emit_bc_dup_top_two, handler);
    }

    // function: Function(address=134248078, size=22, name='mp_emit_bc_pop_top', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_pop_top(int offset) throws Exception;
    public static final int mp_emit_bc_pop_top = 0x0800768e;
    public void mp_emit_bc_pop_top(InterruptHandler handler) throws Exception
    {
        call(this::mp_emit_bc_pop_top, handler);
    }

    // function: Function(address=134248100, size=20, name='mp_emit_bc_rot_two', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_rot_two(int offset) throws Exception;
    public static final int mp_emit_bc_rot_two = 0x080076a4;
    public void mp_emit_bc_rot_two(InterruptHandler handler) throws Exception
    {
        call(this::mp_emit_bc_rot_two, handler);
    }

    // function: Function(address=134248120, size=80, name='mp_emit_bc_attr', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_attr(int offset) throws Exception;
    public static final int mp_emit_bc_attr = 0x080076b8;
    public void mp_emit_bc_attr(InterruptHandler handler) throws Exception
    {
        call(this::mp_emit_bc_attr, handler);
    }

    // function: Function(address=134248200, size=20, name='mp_emit_bc_rot_three', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_rot_three(int offset) throws Exception;
    public static final int mp_emit_bc_rot_three = 0x08007708;
    public void mp_emit_bc_rot_three(InterruptHandler handler) throws Exception
    {
        call(this::mp_emit_bc_rot_three, handler);
    }

    // function: Function(address=134248220, size=52, name='mp_emit_bc_subscr', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_subscr(int offset) throws Exception;
    public static final int mp_emit_bc_subscr = 0x0800771c;
    public void mp_emit_bc_subscr(InterruptHandler handler) throws Exception
    {
        call(this::mp_emit_bc_subscr, handler);
    }

    // function: Function(address=134248272, size=24, name='mp_emit_bc_jump', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_jump(int offset) throws Exception;
    public static final int mp_emit_bc_jump = 0x08007750;
    public void mp_emit_bc_jump(InterruptHandler handler) throws Exception
    {
        call(this::mp_emit_bc_jump, handler);
    }

    // function: Function(address=134248296, size=34, name='mp_emit_bc_pop_jump_if', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_pop_jump_if(int offset) throws Exception;
    public static final int mp_emit_bc_pop_jump_if = 0x08007768;
    public void mp_emit_bc_pop_jump_if(InterruptHandler handler) throws Exception
    {
        call(this::mp_emit_bc_pop_jump_if, handler);
    }

    // function: Function(address=134248330, size=34, name='mp_emit_bc_jump_if_or_pop', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_jump_if_or_pop(int offset) throws Exception;
    public static final int mp_emit_bc_jump_if_or_pop = 0x0800778a;
    public void mp_emit_bc_jump_if_or_pop(InterruptHandler handler) throws Exception
    {
        call(this::mp_emit_bc_jump_if_or_pop, handler);
    }

    // function: Function(address=134248364, size=100, name='mp_emit_bc_unwind_jump', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_unwind_jump(int offset) throws Exception;
    public static final int mp_emit_bc_unwind_jump = 0x080077ac;
    public void mp_emit_bc_unwind_jump(InterruptHandler handler) throws Exception
    {
        call(this::mp_emit_bc_unwind_jump, handler);
    }

    // function: Function(address=134248464, size=36, name='mp_emit_bc_setup_block', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_setup_block(int offset) throws Exception;
    public static final int mp_emit_bc_setup_block = 0x08007810;
    public void mp_emit_bc_setup_block(InterruptHandler handler) throws Exception
    {
        call(this::mp_emit_bc_setup_block, handler);
    }

    // function: Function(address=134248500, size=22, name='mp_emit_bc_end_finally', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_end_finally(int offset) throws Exception;
    public static final int mp_emit_bc_end_finally = 0x08007834;
    public void mp_emit_bc_end_finally(InterruptHandler handler) throws Exception
    {
        call(this::mp_emit_bc_end_finally, handler);
    }

    // function: Function(address=134248522, size=38, name='mp_emit_bc_get_iter', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_get_iter(int offset) throws Exception;
    public static final int mp_emit_bc_get_iter = 0x0800784a;
    public void mp_emit_bc_get_iter(InterruptHandler handler) throws Exception
    {
        call(this::mp_emit_bc_get_iter, handler);
    }

    // function: Function(address=134248560, size=24, name='mp_emit_bc_for_iter', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_for_iter(int offset) throws Exception;
    public static final int mp_emit_bc_for_iter = 0x08007870;
    public void mp_emit_bc_for_iter(InterruptHandler handler) throws Exception
    {
        call(this::mp_emit_bc_for_iter, handler);
    }

    // function: Function(address=134248584, size=12, name='mp_emit_bc_for_iter_end', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_for_iter_end(int offset) throws Exception;
    public static final int mp_emit_bc_for_iter_end = 0x08007888;
    public void mp_emit_bc_for_iter_end(InterruptHandler handler) throws Exception
    {
        call(this::mp_emit_bc_for_iter_end, handler);
    }

    // function: Function(address=134248596, size=20, name='mp_emit_bc_pop_block', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_pop_block(int offset) throws Exception;
    public static final int mp_emit_bc_pop_block = 0x08007894;
    public void mp_emit_bc_pop_block(InterruptHandler handler) throws Exception
    {
        call(this::mp_emit_bc_pop_block, handler);
    }

    // function: Function(address=134248616, size=54, name='mp_emit_bc_with_cleanup', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_with_cleanup(int offset) throws Exception;
    public static final int mp_emit_bc_with_cleanup = 0x080078a8;
    public void mp_emit_bc_with_cleanup(InterruptHandler handler) throws Exception
    {
        call(this::mp_emit_bc_with_cleanup, handler);
    }

    // function: Function(address=134248670, size=20, name='mp_emit_bc_pop_except', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_pop_except(int offset) throws Exception;
    public static final int mp_emit_bc_pop_except = 0x080078de;
    public void mp_emit_bc_pop_except(InterruptHandler handler) throws Exception
    {
        call(this::mp_emit_bc_pop_except, handler);
    }

    // function: Function(address=134248690, size=26, name='mp_emit_bc_unary_op', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_unary_op(int offset) throws Exception;
    public static final int mp_emit_bc_unary_op = 0x080078f2;
    public void mp_emit_bc_unary_op(InterruptHandler handler) throws Exception
    {
        call(this::mp_emit_bc_unary_op, handler);
    }

    // function: Function(address=134248716, size=68, name='mp_emit_bc_binary_op', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_binary_op(int offset) throws Exception;
    public static final int mp_emit_bc_binary_op = 0x0800790c;
    public void mp_emit_bc_binary_op(InterruptHandler handler) throws Exception
    {
        call(this::mp_emit_bc_binary_op, handler);
    }

    // function: Function(address=134248784, size=40, name='mp_emit_bc_build', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_build(int offset) throws Exception;
    public static final int mp_emit_bc_build = 0x08007950;
    public void mp_emit_bc_build(InterruptHandler handler) throws Exception
    {
        call(this::mp_emit_bc_build, handler);
    }

    // function: Function(address=134248824, size=22, name='mp_emit_bc_store_map', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_store_map(int offset) throws Exception;
    public static final int mp_emit_bc_store_map = 0x08007978;
    public void mp_emit_bc_store_map(InterruptHandler handler) throws Exception
    {
        call(this::mp_emit_bc_store_map, handler);
    }

    // function: Function(address=134248846, size=52, name='mp_emit_bc_store_comp', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_store_comp(int offset) throws Exception;
    public static final int mp_emit_bc_store_comp = 0x0800798e;
    public void mp_emit_bc_store_comp(InterruptHandler handler) throws Exception
    {
        call(this::mp_emit_bc_store_comp, handler);
    }

    // function: Function(address=134248898, size=24, name='mp_emit_bc_unpack_sequence', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_unpack_sequence(int offset) throws Exception;
    public static final int mp_emit_bc_unpack_sequence = 0x080079c2;
    public void mp_emit_bc_unpack_sequence(InterruptHandler handler) throws Exception
    {
        call(this::mp_emit_bc_unpack_sequence, handler);
    }

    // function: Function(address=134248922, size=28, name='mp_emit_bc_unpack_ex', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_unpack_ex(int offset) throws Exception;
    public static final int mp_emit_bc_unpack_ex = 0x080079da;
    public void mp_emit_bc_unpack_ex(InterruptHandler handler) throws Exception
    {
        call(this::mp_emit_bc_unpack_ex, handler);
    }

    // function: Function(address=134248950, size=42, name='mp_emit_bc_make_function', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_make_function(int offset) throws Exception;
    public static final int mp_emit_bc_make_function = 0x080079f6;
    public void mp_emit_bc_make_function(InterruptHandler handler) throws Exception
    {
        call(this::mp_emit_bc_make_function, handler);
    }

    // function: Function(address=134248992, size=54, name='mp_emit_bc_make_closure', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_make_closure(int offset) throws Exception;
    public static final int mp_emit_bc_make_closure = 0x08007a20;
    public void mp_emit_bc_make_closure(InterruptHandler handler) throws Exception
    {
        call(this::mp_emit_bc_make_closure, handler);
    }

    // function: Function(address=134249046, size=18, name='mp_emit_bc_call_function', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_call_function(int offset) throws Exception;
    public static final int mp_emit_bc_call_function = 0x08007a56;
    public void mp_emit_bc_call_function(InterruptHandler handler) throws Exception
    {
        call(this::mp_emit_bc_call_function, handler);
    }

    // function: Function(address=134249064, size=20, name='mp_emit_bc_call_method', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_call_method(int offset) throws Exception;
    public static final int mp_emit_bc_call_method = 0x08007a68;
    public void mp_emit_bc_call_method(InterruptHandler handler) throws Exception
    {
        call(this::mp_emit_bc_call_method, handler);
    }

    // function: Function(address=134249084, size=26, name='mp_emit_bc_return_value', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_return_value(int offset) throws Exception;
    public static final int mp_emit_bc_return_value = 0x08007a7c;
    public void mp_emit_bc_return_value(InterruptHandler handler) throws Exception
    {
        call(this::mp_emit_bc_return_value, handler);
    }

    // function: Function(address=134249110, size=28, name='mp_emit_bc_raise_varargs', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_raise_varargs(int offset) throws Exception;
    public static final int mp_emit_bc_raise_varargs = 0x08007a96;
    public void mp_emit_bc_raise_varargs(InterruptHandler handler) throws Exception
    {
        call(this::mp_emit_bc_raise_varargs, handler);
    }

    // function: Function(address=134249138, size=34, name='mp_emit_bc_yield', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_yield(int offset) throws Exception;
    public static final int mp_emit_bc_yield = 0x08007ab2;
    public void mp_emit_bc_yield(InterruptHandler handler) throws Exception
    {
        call(this::mp_emit_bc_yield, handler);
    }

    // function: Function(address=134249172, size=10, name='mp_emit_bc_start_except_handler', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_start_except_handler(int offset) throws Exception;
    public static final int mp_emit_bc_start_except_handler = 0x08007ad4;
    public void mp_emit_bc_start_except_handler(InterruptHandler handler) throws Exception
    {
        call(this::mp_emit_bc_start_except_handler, handler);
    }

    // function: Function(address=134249182, size=12, name='mp_emit_bc_end_except_handler', path='build/py/emitbc.o', has_indirect=False)
    abstract protected void mp_emit_bc_end_except_handler(int offset) throws Exception;
    public static final int mp_emit_bc_end_except_handler = 0x08007ade;
    public void mp_emit_bc_end_except_handler(InterruptHandler handler) throws Exception
    {
        call(this::mp_emit_bc_end_except_handler, handler);
    }

    // function: Function(address=134249196, size=1208, name='mp_format_float', path='build/py/formatfloat.o', has_indirect=False)
    abstract protected void mp_format_float(int offset) throws Exception;
    public static final int mp_format_float = 0x08007aec;
    public void mp_format_float(InterruptHandler handler) throws Exception
    {
        call(this::mp_format_float, handler);
    }

    // function: Function(address=134250404, size=122, name='mp_parse_num_base', path='build/py/parsenumbase.o', has_indirect=False)
    abstract protected void mp_parse_num_base(int offset) throws Exception;
    public static final int mp_parse_num_base = 0x08007fa4;
    public void mp_parse_num_base(InterruptHandler handler) throws Exception
    {
        call(this::mp_parse_num_base, handler);
    }

    // function: Function(address=134250528, size=32, name='unlikely_raise_exc', path='build/py/parsenum.o', has_indirect=False)
    abstract protected void unlikely_raise_exc(int offset) throws Exception;
    public static final int unlikely_raise_exc = 0x08008020;
    public void unlikely_raise_exc(InterruptHandler handler) throws Exception
    {
        call(this::unlikely_raise_exc, handler);
    }

    // function: Function(address=134250560, size=296, name='mp_parse_num_integer', path='build/py/parsenum.o', has_indirect=False)
    abstract protected void mp_parse_num_integer(int offset) throws Exception;
    public static final int mp_parse_num_integer = 0x08008040;
    public void mp_parse_num_integer(InterruptHandler handler) throws Exception
    {
        call(this::mp_parse_num_integer, handler);
    }

    // function: Function(address=134250856, size=632, name='mp_parse_num_decimal', path='build/py/parsenum.o', has_indirect=False)
    abstract protected void mp_parse_num_decimal(int offset) throws Exception;
    public static final int mp_parse_num_decimal = 0x08008168;
    public void mp_parse_num_decimal(InterruptHandler handler) throws Exception
    {
        call(this::mp_parse_num_decimal, handler);
    }

    // function: Function(address=134251488, size=24, name='mp_emit_glue_new_raw_code', path='build/py/emitglue.o', has_indirect=False)
    abstract protected void mp_emit_glue_new_raw_code(int offset) throws Exception;
    public static final int mp_emit_glue_new_raw_code = 0x080083e0;
    public void mp_emit_glue_new_raw_code(InterruptHandler handler) throws Exception
    {
        call(this::mp_emit_glue_new_raw_code, handler);
    }

    // function: Function(address=134251512, size=44, name='mp_emit_glue_assign_bytecode', path='build/py/emitglue.o', has_indirect=False)
    abstract protected void mp_emit_glue_assign_bytecode(int offset) throws Exception;
    public static final int mp_emit_glue_assign_bytecode = 0x080083f8;
    public void mp_emit_glue_assign_bytecode(InterruptHandler handler) throws Exception
    {
        call(this::mp_emit_glue_assign_bytecode, handler);
    }

    // function: Function(address=134251556, size=32, name='mp_make_function_from_raw_code', path='build/py/emitglue.o', has_indirect=False)
    abstract protected void mp_make_function_from_raw_code(int offset) throws Exception;
    public static final int mp_make_function_from_raw_code = 0x08008424;
    public void mp_make_function_from_raw_code(InterruptHandler handler) throws Exception
    {
        call(this::mp_make_function_from_raw_code, handler);
    }

    // function: Function(address=134251588, size=42, name='mp_make_closure_from_raw_code', path='build/py/emitglue.o', has_indirect=False)
    abstract protected void mp_make_closure_from_raw_code(int offset) throws Exception;
    public static final int mp_make_closure_from_raw_code = 0x08008444;
    public void mp_make_closure_from_raw_code(InterruptHandler handler) throws Exception
    {
        call(this::mp_make_closure_from_raw_code, handler);
    }

    // function: Function(address=134251630, size=26, name='read_bytes', path='build/py/persistentcode.o', has_indirect=False)
    abstract protected void read_bytes(int offset) throws Exception;
    public static final int read_bytes = 0x0800846e;
    public void read_bytes(InterruptHandler handler) throws Exception
    {
        call(this::read_bytes, handler);
    }

    // function: Function(address=134251656, size=30, name='read_uint', path='build/py/persistentcode.o', has_indirect=False)
    abstract protected void read_uint(int offset) throws Exception;
    public static final int read_uint = 0x08008488;
    public void read_uint(InterruptHandler handler) throws Exception
    {
        call(this::read_uint, handler);
    }

    // function: Function(address=134251686, size=48, name='load_qstr', path='build/py/persistentcode.o', has_indirect=False)
    abstract protected void load_qstr(int offset) throws Exception;
    public static final int load_qstr = 0x080084a6;
    public void load_qstr(InterruptHandler handler) throws Exception
    {
        call(this::load_qstr, handler);
    }

    // function: Function(address=134251736, size=416, name='load_raw_code', path='build/py/persistentcode.o', has_indirect=False)
    abstract protected void load_raw_code(int offset) throws Exception;
    public static final int load_raw_code = 0x080084d8;
    public void load_raw_code(InterruptHandler handler) throws Exception
    {
        call(this::load_raw_code, handler);
    }

    // function: Function(address=134252152, size=68, name='mp_raw_code_load', path='build/py/persistentcode.o', has_indirect=False)
    abstract protected void mp_raw_code_load(int offset) throws Exception;
    public static final int mp_raw_code_load = 0x08008678;
    public void mp_raw_code_load(InterruptHandler handler) throws Exception
    {
        call(this::mp_raw_code_load, handler);
    }

    // function: Function(address=134252220, size=20, name='mp_raw_code_load_file', path='build/py/persistentcode.o', has_indirect=False)
    abstract protected void mp_raw_code_load_file(int offset) throws Exception;
    public static final int mp_raw_code_load_file = 0x080086bc;
    public void mp_raw_code_load_file(InterruptHandler handler) throws Exception
    {
        call(this::mp_raw_code_load_file, handler);
    }

    // function: Function(address=134252240, size=120, name='mp_init', path='build/py/runtime.o', has_indirect=False)
    abstract protected void mp_init(int offset) throws Exception;
    public static final int mp_init = 0x080086d0;
    public void mp_init(InterruptHandler handler) throws Exception
    {
        call(this::mp_init, handler);
    }

    // function: Function(address=134252360, size=2, name='mp_deinit', path='build/py/runtime.o', has_indirect=False)
    abstract protected void mp_deinit(int offset) throws Exception;
    public static final int mp_deinit = 0x08008748;
    public void mp_deinit(InterruptHandler handler) throws Exception
    {
        call(this::mp_deinit, handler);
    }

    // function: Function(address=134252364, size=104, name='mp_load_global', path='build/py/runtime.o', has_indirect=False)
    abstract protected void mp_load_global(int offset) throws Exception;
    public static final int mp_load_global = 0x0800874c;
    public void mp_load_global(InterruptHandler handler) throws Exception
    {
        call(this::mp_load_global, handler);
    }

    // function: Function(address=134252468, size=48, name='mp_load_name', path='build/py/runtime.o', has_indirect=False)
    abstract protected void mp_load_name(int offset) throws Exception;
    public static final int mp_load_name = 0x080087b4;
    public void mp_load_name(InterruptHandler handler) throws Exception
    {
        call(this::mp_load_name, handler);
    }

    // function: Function(address=134252516, size=44, name='mp_load_build_class', path='build/py/runtime.o', has_indirect=False)
    abstract protected void mp_load_build_class(int offset) throws Exception;
    public static final int mp_load_build_class = 0x080087e4;
    public void mp_load_build_class(InterruptHandler handler) throws Exception
    {
        call(this::mp_load_build_class, handler);
    }

    // function: Function(address=134252560, size=24, name='mp_store_name', path='build/py/runtime.o', has_indirect=False)
    abstract protected void mp_store_name(int offset) throws Exception;
    public static final int mp_store_name = 0x08008810;
    public void mp_store_name(InterruptHandler handler) throws Exception
    {
        call(this::mp_store_name, handler);
    }

    // function: Function(address=134252584, size=24, name='mp_delete_name', path='build/py/runtime.o', has_indirect=False)
    abstract protected void mp_delete_name(int offset) throws Exception;
    public static final int mp_delete_name = 0x08008828;
    public void mp_delete_name(InterruptHandler handler) throws Exception
    {
        call(this::mp_delete_name, handler);
    }

    // function: Function(address=134252608, size=24, name='mp_store_global', path='build/py/runtime.o', has_indirect=False)
    abstract protected void mp_store_global(int offset) throws Exception;
    public static final int mp_store_global = 0x08008840;
    public void mp_store_global(InterruptHandler handler) throws Exception
    {
        call(this::mp_store_global, handler);
    }

    // function: Function(address=134252632, size=24, name='mp_delete_global', path='build/py/runtime.o', has_indirect=False)
    abstract protected void mp_delete_global(int offset) throws Exception;
    public static final int mp_delete_global = 0x08008858;
    public void mp_delete_global(InterruptHandler handler) throws Exception
    {
        call(this::mp_delete_global, handler);
    }

    // function: Function(address=134252656, size=264, name='mp_unary_op', path='build/py/runtime.o', has_indirect=False)
    abstract protected void mp_unary_op(int offset) throws Exception;
    public static final int mp_unary_op = 0x08008870;
    public void mp_unary_op(InterruptHandler handler) throws Exception
    {
        call(this::mp_unary_op, handler);
    }

    // function: Function(address=134252920, size=60, name='mp_call_function_n_kw', path='build/py/runtime.o', has_indirect=False)
    abstract protected void mp_call_function_n_kw(int offset) throws Exception;
    public static final int mp_call_function_n_kw = 0x08008978;
    public void mp_call_function_n_kw(InterruptHandler handler) throws Exception
    {
        call(this::mp_call_function_n_kw, handler);
    }

    // function: Function(address=134252980, size=14, name='mp_call_function_0', path='build/py/runtime.o', has_indirect=False)
    abstract protected void mp_call_function_0(int offset) throws Exception;
    public static final int mp_call_function_0 = 0x080089b4;
    public void mp_call_function_0(InterruptHandler handler) throws Exception
    {
        call(this::mp_call_function_0, handler);
    }

    // function: Function(address=134252994, size=16, name='mp_call_function_1', path='build/py/runtime.o', has_indirect=False)
    abstract protected void mp_call_function_1(int offset) throws Exception;
    public static final int mp_call_function_1 = 0x080089c2;
    public void mp_call_function_1(InterruptHandler handler) throws Exception
    {
        call(this::mp_call_function_1, handler);
    }

    // function: Function(address=134253012, size=64, name='checked_fun_call', path='build/py/runtime.o', has_indirect=False)
    abstract protected void checked_fun_call(int offset) throws Exception;
    public static final int checked_fun_call = 0x080089d4;
    public void checked_fun_call(InterruptHandler handler) throws Exception
    {
        call(this::checked_fun_call, handler);
    }

    // function: Function(address=134253076, size=30, name='mp_call_method_n_kw', path='build/py/runtime.o', has_indirect=False)
    abstract protected void mp_call_method_n_kw(int offset) throws Exception;
    public static final int mp_call_method_n_kw = 0x08008a14;
    public void mp_call_method_n_kw(InterruptHandler handler) throws Exception
    {
        call(this::mp_call_method_n_kw, handler);
    }

    // function: Function(address=134253108, size=172, name='mp_convert_member_lookup', path='build/py/runtime.o', has_indirect=False)
    abstract protected void mp_convert_member_lookup(int offset) throws Exception;
    public static final int mp_convert_member_lookup = 0x08008a34;
    public void mp_convert_member_lookup(InterruptHandler handler) throws Exception
    {
        call(this::mp_convert_member_lookup, handler);
    }

    // function: Function(address=134253280, size=104, name='mp_load_method_maybe', path='build/py/runtime.o', has_indirect=True)
    abstract protected void mp_load_method_maybe(int offset) throws Exception;
    public static final int mp_load_method_maybe = 0x08008ae0;
    public void mp_load_method_maybe(InterruptHandler handler) throws Exception
    {
        call(this::mp_load_method_maybe, handler);
    }

    // function: Function(address=134253384, size=80, name='mp_load_method', path='build/py/runtime.o', has_indirect=True)
    abstract protected void mp_load_method(int offset) throws Exception;
    public static final int mp_load_method = 0x08008b48;
    public void mp_load_method(InterruptHandler handler) throws Exception
    {
        call(this::mp_load_method, handler);
    }

    // function: Function(address=134253464, size=24, name='mp_load_attr', path='build/py/runtime.o', has_indirect=False)
    abstract protected void mp_load_attr(int offset) throws Exception;
    public static final int mp_load_attr = 0x08008b98;
    public void mp_load_attr(InterruptHandler handler) throws Exception
    {
        call(this::mp_load_attr, handler);
    }

    // function: Function(address=134253488, size=68, name='mp_load_method_protected', path='build/py/runtime.o', has_indirect=False)
    abstract protected void mp_load_method_protected(int offset) throws Exception;
    public static final int mp_load_method_protected = 0x08008bb0;
    public void mp_load_method_protected(InterruptHandler handler) throws Exception
    {
        call(this::mp_load_method_protected, handler);
    }

    // function: Function(address=134253556, size=72, name='mp_store_attr', path='build/py/runtime.o', has_indirect=False)
    abstract protected void mp_store_attr(int offset) throws Exception;
    public static final int mp_store_attr = 0x08008bf4;
    public void mp_store_attr(InterruptHandler handler) throws Exception
    {
        call(this::mp_store_attr, handler);
    }

    // function: Function(address=134253628, size=112, name='mp_getiter', path='build/py/runtime.o', has_indirect=False)
    abstract protected void mp_getiter(int offset) throws Exception;
    public static final int mp_getiter = 0x08008c3c;
    public void mp_getiter(InterruptHandler handler) throws Exception
    {
        call(this::mp_getiter, handler);
    }

    // function: Function(address=134253740, size=76, name='mp_iternext_allow_raise', path='build/py/runtime.o', has_indirect=False)
    abstract protected void mp_iternext_allow_raise(int offset) throws Exception;
    public static final int mp_iternext_allow_raise = 0x08008cac;
    public void mp_iternext_allow_raise(InterruptHandler handler) throws Exception
    {
        call(this::mp_iternext_allow_raise, handler);
    }

    // function: Function(address=134253816, size=128, name='mp_iternext', path='build/py/runtime.o', has_indirect=False)
    abstract protected void mp_iternext(int offset) throws Exception;
    public static final int mp_iternext = 0x08008cf8;
    public void mp_iternext(InterruptHandler handler) throws Exception
    {
        call(this::mp_iternext, handler);
    }

    // function: Function(address=134253944, size=628, name='mp_call_prepare_args_n_kw_var', path='build/py/runtime.o', has_indirect=False)
    abstract protected void mp_call_prepare_args_n_kw_var(int offset) throws Exception;
    public static final int mp_call_prepare_args_n_kw_var = 0x08008d78;
    public void mp_call_prepare_args_n_kw_var(InterruptHandler handler) throws Exception
    {
        call(this::mp_call_prepare_args_n_kw_var, handler);
    }

    // function: Function(address=134254572, size=36, name='mp_call_method_n_kw_var', path='build/py/runtime.o', has_indirect=False)
    abstract protected void mp_call_method_n_kw_var(int offset) throws Exception;
    public static final int mp_call_method_n_kw_var = 0x08008fec;
    public void mp_call_method_n_kw_var(InterruptHandler handler) throws Exception
    {
        call(this::mp_call_method_n_kw_var, handler);
    }

    // function: Function(address=134254608, size=168, name='mp_unpack_sequence', path='build/py/runtime.o', has_indirect=False)
    abstract protected void mp_unpack_sequence(int offset) throws Exception;
    public static final int mp_unpack_sequence = 0x08009010;
    public void mp_unpack_sequence(InterruptHandler handler) throws Exception
    {
        call(this::mp_unpack_sequence, handler);
    }

    // function: Function(address=134254776, size=264, name='mp_unpack_ex', path='build/py/runtime.o', has_indirect=False)
    abstract protected void mp_unpack_ex(int offset) throws Exception;
    public static final int mp_unpack_ex = 0x080090b8;
    public void mp_unpack_ex(InterruptHandler handler) throws Exception
    {
        call(this::mp_unpack_ex, handler);
    }

    // function: Function(address=134255040, size=60, name='mp_make_raise_obj', path='build/py/runtime.o', has_indirect=False)
    abstract protected void mp_make_raise_obj(int offset) throws Exception;
    public static final int mp_make_raise_obj = 0x080091c0;
    public void mp_make_raise_obj(InterruptHandler handler) throws Exception
    {
        call(this::mp_make_raise_obj, handler);
    }

    // function: Function(address=134255100, size=244, name='mp_resume', path='build/py/runtime.o', has_indirect=False)
    abstract protected void mp_resume(int offset) throws Exception;
    public static final int mp_resume = 0x080091fc;
    public void mp_resume(InterruptHandler handler) throws Exception
    {
        call(this::mp_resume, handler);
    }

    // function: Function(address=134255344, size=36, name='mp_import_name', path='build/py/runtime.o', has_indirect=False)
    abstract protected void mp_import_name(int offset) throws Exception;
    public static final int mp_import_name = 0x080092f0;
    public void mp_import_name(InterruptHandler handler) throws Exception
    {
        call(this::mp_import_name, handler);
    }

    // function: Function(address=134255380, size=204, name='mp_import_from', path='build/py/runtime.o', has_indirect=False)
    abstract protected void mp_import_from(int offset) throws Exception;
    public static final int mp_import_from = 0x08009314;
    public void mp_import_from(InterruptHandler handler) throws Exception
    {
        call(this::mp_import_from, handler);
    }

    // function: Function(address=134255584, size=58, name='mp_import_all', path='build/py/runtime.o', has_indirect=False)
    abstract protected void mp_import_all(int offset) throws Exception;
    public static final int mp_import_all = 0x080093e0;
    public void mp_import_all(InterruptHandler handler) throws Exception
    {
        call(this::mp_import_all, handler);
    }

    // function: Function(address=134255644, size=108, name='mp_parse_compile_execute', path='build/py/runtime.o', has_indirect=False)
    abstract protected void mp_parse_compile_execute(int offset) throws Exception;
    public static final int mp_parse_compile_execute = 0x0800941c;
    public void mp_parse_compile_execute(InterruptHandler handler) throws Exception
    {
        call(this::mp_parse_compile_execute, handler);
    }

    // function: Function(address=134255752, size=20, name='mp_raise_msg', path='build/py/runtime.o', has_indirect=False)
    abstract protected void mp_raise_msg(int offset) throws Exception;
    public static final int mp_raise_msg = 0x08009488;
    public void mp_raise_msg(InterruptHandler handler) throws Exception
    {
        call(this::mp_raise_msg, handler);
    }

    // function: Function(address=134255772, size=44, name='m_malloc_fail', path='build/py/runtime.o', has_indirect=False)
    abstract protected void m_malloc_fail(int offset) throws Exception;
    public static final int m_malloc_fail = 0x0800949c;
    public void m_malloc_fail(InterruptHandler handler) throws Exception
    {
        call(this::m_malloc_fail, handler);
    }

    // function: Function(address=134255816, size=16, name='mp_raise_ValueError', path='build/py/runtime.o', has_indirect=False)
    abstract protected void mp_raise_ValueError(int offset) throws Exception;
    public static final int mp_raise_ValueError = 0x080094c8;
    public void mp_raise_ValueError(InterruptHandler handler) throws Exception
    {
        call(this::mp_raise_ValueError, handler);
    }

    // function: Function(address=134255832, size=944, name='mp_binary_op', path='build/py/runtime.o', has_indirect=False)
    abstract protected void mp_binary_op(int offset) throws Exception;
    public static final int mp_binary_op = 0x080094d8;
    public void mp_binary_op(InterruptHandler handler) throws Exception
    {
        call(this::mp_binary_op, handler);
    }

    // function: Function(address=134256776, size=16, name='mp_raise_TypeError', path='build/py/runtime.o', has_indirect=False)
    abstract protected void mp_raise_TypeError(int offset) throws Exception;
    public static final int mp_raise_TypeError = 0x08009888;
    public void mp_raise_TypeError(InterruptHandler handler) throws Exception
    {
        call(this::mp_raise_TypeError, handler);
    }

    // function: Function(address=134256792, size=24, name='mp_raise_OSError', path='build/py/runtime.o', has_indirect=False)
    abstract protected void mp_raise_OSError(int offset) throws Exception;
    public static final int mp_raise_OSError = 0x08009898;
    public void mp_raise_OSError(InterruptHandler handler) throws Exception
    {
        call(this::mp_raise_OSError, handler);
    }

    // function: Function(address=134256816, size=16, name='mp_raise_NotImplementedError', path='build/py/runtime.o', has_indirect=False)
    abstract protected void mp_raise_NotImplementedError(int offset) throws Exception;
    public static final int mp_raise_NotImplementedError = 0x080098b0;
    public void mp_raise_NotImplementedError(InterruptHandler handler) throws Exception
    {
        call(this::mp_raise_NotImplementedError, handler);
    }

    // function: Function(address=134256832, size=20, name='mp_raise_recursion_depth', path='build/py/runtime.o', has_indirect=False)
    abstract protected void mp_raise_recursion_depth(int offset) throws Exception;
    public static final int mp_raise_recursion_depth = 0x080098c0;
    public void mp_raise_recursion_depth(InterruptHandler handler) throws Exception
    {
        call(this::mp_raise_recursion_depth, handler);
    }

    // function: Function(address=134256852, size=56, name='mp_call_function_1_protected', path='build/py/runtime_utils.o', has_indirect=False)
    abstract protected void mp_call_function_1_protected(int offset) throws Exception;
    public static final int mp_call_function_1_protected = 0x080098d4;
    public void mp_call_function_1_protected(InterruptHandler handler) throws Exception
    {
        call(this::mp_call_function_1_protected, handler);
    }

    // function: Function(address=134256908, size=36, name='mp_sched_lock', path='build/py/scheduler.o', has_indirect=False)
    abstract protected void mp_sched_lock(int offset) throws Exception;
    public static final int mp_sched_lock = 0x0800990c;
    public void mp_sched_lock(InterruptHandler handler) throws Exception
    {
        call(this::mp_sched_lock, handler);
    }

    // function: Function(address=134256944, size=56, name='mp_sched_unlock', path='build/py/scheduler.o', has_indirect=False)
    abstract protected void mp_sched_unlock(int offset) throws Exception;
    public static final int mp_sched_unlock = 0x08009930;
    public void mp_sched_unlock(InterruptHandler handler) throws Exception
    {
        call(this::mp_sched_unlock, handler);
    }

    // function: Function(address=134257000, size=52, name='mp_handle_pending_tail', path='build/py/scheduler.o', has_indirect=False)
    abstract protected void mp_handle_pending_tail(int offset) throws Exception;
    public static final int mp_handle_pending_tail = 0x08009968;
    public void mp_handle_pending_tail(InterruptHandler handler) throws Exception
    {
        call(this::mp_handle_pending_tail, handler);
    }

    // function: Function(address=134257052, size=56, name='mp_handle_pending', path='build/py/scheduler.o', has_indirect=False)
    abstract protected void mp_handle_pending(int offset) throws Exception;
    public static final int mp_handle_pending = 0x0800999c;
    public void mp_handle_pending(InterruptHandler handler) throws Exception
    {
        call(this::mp_handle_pending, handler);
    }

    // function: Function(address=134257108, size=60, name='mp_sched_schedule', path='build/py/scheduler.o', has_indirect=False)
    abstract protected void mp_sched_schedule(int offset) throws Exception;
    public static final int mp_sched_schedule = 0x080099d4;
    public void mp_sched_schedule(InterruptHandler handler) throws Exception
    {
        call(this::mp_sched_schedule, handler);
    }

    // function: Function(address=134257168, size=12, name='mp_stack_set_top', path='build/py/stackctrl.o', has_indirect=False)
    abstract protected void mp_stack_set_top(int offset) throws Exception;
    public static final int mp_stack_set_top = 0x08009a10;
    public void mp_stack_set_top(InterruptHandler handler) throws Exception
    {
        call(this::mp_stack_set_top, handler);
    }

    // function: Function(address=134257180, size=20, name='mp_stack_usage', path='build/py/stackctrl.o', has_indirect=False)
    abstract protected void mp_stack_usage(int offset) throws Exception;
    public static final int mp_stack_usage = 0x08009a1c;
    public void mp_stack_usage(InterruptHandler handler) throws Exception
    {
        call(this::mp_stack_usage, handler);
    }

    // function: Function(address=134257200, size=12, name='mp_stack_set_limit', path='build/py/stackctrl.o', has_indirect=False)
    abstract protected void mp_stack_set_limit(int offset) throws Exception;
    public static final int mp_stack_set_limit = 0x08009a30;
    public void mp_stack_set_limit(InterruptHandler handler) throws Exception
    {
        call(this::mp_stack_set_limit, handler);
    }

    // function: Function(address=134257212, size=28, name='mp_stack_check', path='build/py/stackctrl.o', has_indirect=False)
    abstract protected void mp_stack_check(int offset) throws Exception;
    public static final int mp_stack_check = 0x08009a3c;
    public void mp_stack_check(InterruptHandler handler) throws Exception
    {
        call(this::mp_stack_check, handler);
    }

    // function: Function(address=134257240, size=96, name='mp_arg_check_num', path='build/py/argcheck.o', has_indirect=False)
    abstract protected void mp_arg_check_num(int offset) throws Exception;
    public static final int mp_arg_check_num = 0x08009a58;
    public void mp_arg_check_num(InterruptHandler handler) throws Exception
    {
        call(this::mp_arg_check_num, handler);
    }

    // function: Function(address=134257336, size=200, name='mp_arg_parse_all', path='build/py/argcheck.o', has_indirect=False)
    abstract protected void mp_arg_parse_all(int offset) throws Exception;
    public static final int mp_arg_parse_all = 0x08009ab8;
    public void mp_arg_parse_all(InterruptHandler handler) throws Exception
    {
        call(this::mp_arg_parse_all, handler);
    }

    // function: Function(address=134257536, size=44, name='mp_arg_parse_all_kw_array', path='build/py/argcheck.o', has_indirect=False)
    abstract protected void mp_arg_parse_all_kw_array(int offset) throws Exception;
    public static final int mp_arg_parse_all_kw_array = 0x08009b80;
    public void mp_arg_parse_all_kw_array(InterruptHandler handler) throws Exception
    {
        call(this::mp_arg_parse_all_kw_array, handler);
    }

    // function: Function(address=134257580, size=12, name='mp_arg_error_unimpl_kw', path='build/py/argcheck.o', has_indirect=False)
    abstract protected void mp_arg_error_unimpl_kw(int offset) throws Exception;
    public static final int mp_arg_error_unimpl_kw = 0x08009bac;
    public void mp_arg_error_unimpl_kw(InterruptHandler handler) throws Exception
    {
        call(this::mp_arg_error_unimpl_kw, handler);
    }

    // function: Function(address=134257592, size=60, name='mp_warning', path='build/py/warning.o', has_indirect=False)
    abstract protected void mp_warning(int offset) throws Exception;
    public static final int mp_warning = 0x08009bb8;
    public void mp_warning(InterruptHandler handler) throws Exception
    {
        call(this::mp_warning, handler);
    }

    // function: Function(address=134257652, size=28, name='mp_map_init', path='build/py/map.o', has_indirect=False)
    abstract protected void mp_map_init(int offset) throws Exception;
    public static final int mp_map_init = 0x08009bf4;
    public void mp_map_init(InterruptHandler handler) throws Exception
    {
        call(this::mp_map_init, handler);
    }

    // function: Function(address=134257680, size=26, name='mp_map_init_fixed_table', path='build/py/map.o', has_indirect=False)
    abstract protected void mp_map_init_fixed_table(int offset) throws Exception;
    public static final int mp_map_init_fixed_table = 0x08009c10;
    public void mp_map_init_fixed_table(InterruptHandler handler) throws Exception
    {
        call(this::mp_map_init_fixed_table, handler);
    }

    // function: Function(address=134257706, size=34, name='mp_map_deinit', path='build/py/map.o', has_indirect=False)
    abstract protected void mp_map_deinit(int offset) throws Exception;
    public static final int mp_map_deinit = 0x08009c2a;
    public void mp_map_deinit(InterruptHandler handler) throws Exception
    {
        call(this::mp_map_deinit, handler);
    }

    // function: Function(address=134257740, size=46, name='mp_map_clear', path='build/py/map.o', has_indirect=False)
    abstract protected void mp_map_clear(int offset) throws Exception;
    public static final int mp_map_clear = 0x08009c4c;
    public void mp_map_clear(InterruptHandler handler) throws Exception
    {
        call(this::mp_map_clear, handler);
    }

    // function: Function(address=134257788, size=512, name='mp_map_lookup', path='build/py/map.o', has_indirect=False)
    abstract protected void mp_map_lookup(int offset) throws Exception;
    public static final int mp_map_lookup = 0x08009c7c;
    public void mp_map_lookup(InterruptHandler handler) throws Exception
    {
        call(this::mp_map_lookup, handler);
    }

    // function: Function(address=134258300, size=116, name='mp_map_rehash', path='build/py/map.o', has_indirect=False)
    abstract protected void mp_map_rehash(int offset) throws Exception;
    public static final int mp_map_rehash = 0x08009e7c;
    public void mp_map_rehash(InterruptHandler handler) throws Exception
    {
        call(this::mp_map_rehash, handler);
    }

    // function: Function(address=134258416, size=20, name='mp_set_init', path='build/py/map.o', has_indirect=False)
    abstract protected void mp_set_init(int offset) throws Exception;
    public static final int mp_set_init = 0x08009ef0;
    public void mp_set_init(InterruptHandler handler) throws Exception
    {
        call(this::mp_set_init, handler);
    }

    // function: Function(address=134258436, size=222, name='mp_set_lookup', path='build/py/map.o', has_indirect=False)
    abstract protected void mp_set_lookup(int offset) throws Exception;
    public static final int mp_set_lookup = 0x08009f04;
    public void mp_set_lookup(InterruptHandler handler) throws Exception
    {
        call(this::mp_set_lookup, handler);
    }

    // function: Function(address=134258660, size=100, name='mp_set_rehash', path='build/py/map.o', has_indirect=False)
    abstract protected void mp_set_rehash(int offset) throws Exception;
    public static final int mp_set_rehash = 0x08009fe4;
    public void mp_set_rehash(InterruptHandler handler) throws Exception
    {
        call(this::mp_set_rehash, handler);
    }

    // function: Function(address=134258760, size=62, name='mp_set_remove_first', path='build/py/map.o', has_indirect=False)
    abstract protected void mp_set_remove_first(int offset) throws Exception;
    public static final int mp_set_remove_first = 0x0800a048;
    public void mp_set_remove_first(InterruptHandler handler) throws Exception
    {
        call(this::mp_set_remove_first, handler);
    }

    // function: Function(address=134258822, size=24, name='mp_set_clear', path='build/py/map.o', has_indirect=False)
    abstract protected void mp_set_clear(int offset) throws Exception;
    public static final int mp_set_clear = 0x0800a086;
    public void mp_set_clear(InterruptHandler handler) throws Exception
    {
        call(this::mp_set_clear, handler);
    }

    // function: Function(address=134258846, size=2, name='mp_identity', path='build/py/obj.o', has_indirect=False)
    abstract protected void mp_identity(int offset) throws Exception;
    public static final int mp_identity = 0x0800a09e;
    public void mp_identity(InterruptHandler handler) throws Exception
    {
        call(this::mp_identity, handler);
    }

    // function: Function(address=134258848, size=32, name='mp_obj_get_type', path='build/py/obj.o', has_indirect=False)
    abstract protected void mp_obj_get_type(int offset) throws Exception;
    public static final int mp_obj_get_type = 0x0800a0a0;
    public void mp_obj_get_type(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_get_type, handler);
    }

    // function: Function(address=134258880, size=14, name='mp_obj_get_type_str', path='build/py/obj.o', has_indirect=False)
    abstract protected void mp_obj_get_type_str(int offset) throws Exception;
    public static final int mp_obj_get_type_str = 0x0800a0c0;
    public void mp_obj_get_type_str(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_get_type_str, handler);
    }

    // function: Function(address=134258896, size=52, name='mp_obj_print_helper', path='build/py/obj.o', has_indirect=False)
    abstract protected void mp_obj_print_helper(int offset) throws Exception;
    public static final int mp_obj_print_helper = 0x0800a0d0;
    public void mp_obj_print_helper(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_print_helper, handler);
    }

    // function: Function(address=134258948, size=20, name='mp_obj_print', path='build/py/obj.o', has_indirect=False)
    abstract protected void mp_obj_print(int offset) throws Exception;
    public static final int mp_obj_print = 0x0800a104;
    public void mp_obj_print(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_print, handler);
    }

    // function: Function(address=134258968, size=144, name='mp_obj_print_exception', path='build/py/obj.o', has_indirect=False)
    abstract protected void mp_obj_print_exception(int offset) throws Exception;
    public static final int mp_obj_print_exception = 0x0800a118;
    public void mp_obj_print_exception(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_print_exception, handler);
    }

    // function: Function(address=134259112, size=36, name='mp_obj_is_callable', path='build/py/obj.o', has_indirect=False)
    abstract protected void mp_obj_is_callable(int offset) throws Exception;
    public static final int mp_obj_is_callable = 0x0800a1a8;
    public void mp_obj_is_callable(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_is_callable, handler);
    }

    // function: Function(address=134259148, size=232, name='mp_obj_equal', path='build/py/obj.o', has_indirect=False)
    abstract protected void mp_obj_equal(int offset) throws Exception;
    public static final int mp_obj_equal = 0x0800a1cc;
    public void mp_obj_equal(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_equal, handler);
    }

    // function: Function(address=134259380, size=88, name='mp_obj_get_int', path='build/py/obj.o', has_indirect=False)
    abstract protected void mp_obj_get_int(int offset) throws Exception;
    public static final int mp_obj_get_int = 0x0800a2b4;
    public void mp_obj_get_int(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_get_int, handler);
    }

    // function: Function(address=134259468, size=36, name='mp_obj_get_int_truncated', path='build/py/obj.o', has_indirect=False)
    abstract protected void mp_obj_get_int_truncated(int offset) throws Exception;
    public static final int mp_obj_get_int_truncated = 0x0800a30c;
    public void mp_obj_get_int_truncated(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_get_int_truncated, handler);
    }

    // function: Function(address=134259504, size=76, name='mp_obj_get_int_maybe', path='build/py/obj.o', has_indirect=False)
    abstract protected void mp_obj_get_int_maybe(int offset) throws Exception;
    public static final int mp_obj_get_int_maybe = 0x0800a330;
    public void mp_obj_get_int_maybe(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_get_int_maybe, handler);
    }

    // function: Function(address=134259580, size=96, name='mp_obj_get_float_maybe', path='build/py/obj.o', has_indirect=False)
    abstract protected void mp_obj_get_float_maybe(int offset) throws Exception;
    public static final int mp_obj_get_float_maybe = 0x0800a37c;
    public void mp_obj_get_float_maybe(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_get_float_maybe, handler);
    }

    // function: Function(address=134259676, size=48, name='mp_obj_get_float', path='build/py/obj.o', has_indirect=False)
    abstract protected void mp_obj_get_float(int offset) throws Exception;
    public static final int mp_obj_get_float = 0x0800a3dc;
    public void mp_obj_get_float(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_get_float, handler);
    }

    // function: Function(address=134259724, size=140, name='mp_obj_get_complex', path='build/py/obj.o', has_indirect=False)
    abstract protected void mp_obj_get_complex(int offset) throws Exception;
    public static final int mp_obj_get_complex = 0x0800a40c;
    public void mp_obj_get_complex(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_get_complex, handler);
    }

    // function: Function(address=134259864, size=68, name='mp_obj_get_array', path='build/py/obj.o', has_indirect=False)
    abstract protected void mp_obj_get_array(int offset) throws Exception;
    public static final int mp_obj_get_array = 0x0800a498;
    public void mp_obj_get_array(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_get_array, handler);
    }

    // function: Function(address=134259932, size=40, name='mp_obj_get_array_fixed_n', path='build/py/obj.o', has_indirect=False)
    abstract protected void mp_obj_get_array_fixed_n(int offset) throws Exception;
    public static final int mp_obj_get_array_fixed_n = 0x0800a4dc;
    public void mp_obj_get_array_fixed_n(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_get_array_fixed_n, handler);
    }

    // function: Function(address=134259972, size=132, name='mp_get_index', path='build/py/obj.o', has_indirect=False)
    abstract protected void mp_get_index(int offset) throws Exception;
    public static final int mp_get_index = 0x0800a504;
    public void mp_get_index(InterruptHandler handler) throws Exception
    {
        call(this::mp_get_index, handler);
    }

    // function: Function(address=134260104, size=30, name='mp_obj_id', path='build/py/obj.o', has_indirect=False)
    abstract protected void mp_obj_id(int offset) throws Exception;
    public static final int mp_obj_id = 0x0800a588;
    public void mp_obj_id(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_id, handler);
    }

    // function: Function(address=134260136, size=52, name='mp_obj_len_maybe', path='build/py/obj.o', has_indirect=False)
    abstract protected void mp_obj_len_maybe(int offset) throws Exception;
    public static final int mp_obj_len_maybe = 0x0800a5a8;
    public void mp_obj_len_maybe(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_len_maybe, handler);
    }

    // function: Function(address=134260188, size=100, name='mp_obj_is_true', path='build/py/obj.o', has_indirect=False)
    abstract protected void mp_obj_is_true(int offset) throws Exception;
    public static final int mp_obj_is_true = 0x0800a5dc;
    public void mp_obj_is_true(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_is_true, handler);
    }

    // function: Function(address=134260288, size=44, name='mp_obj_len', path='build/py/obj.o', has_indirect=False)
    abstract protected void mp_obj_len(int offset) throws Exception;
    public static final int mp_obj_len = 0x0800a640;
    public void mp_obj_len(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_len, handler);
    }

    // function: Function(address=134260332, size=100, name='mp_obj_subscr', path='build/py/obj.o', has_indirect=False)
    abstract protected void mp_obj_subscr(int offset) throws Exception;
    public static final int mp_obj_subscr = 0x0800a66c;
    public void mp_obj_subscr(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_subscr, handler);
    }

    // function: Function(address=134260432, size=2, name='mp_identity_getiter', path='build/py/obj.o', has_indirect=True)
    abstract protected void mp_identity_getiter(int offset) throws Exception;
    public static final int mp_identity_getiter = 0x0800a6d0;
    public void mp_identity_getiter(InterruptHandler handler) throws Exception
    {
        call(this::mp_identity_getiter, handler);
    }

    // function: Function(address=134260434, size=34, name='mp_get_buffer', path='build/py/obj.o', has_indirect=False)
    abstract protected void mp_get_buffer(int offset) throws Exception;
    public static final int mp_get_buffer = 0x0800a6d2;
    public void mp_get_buffer(InterruptHandler handler) throws Exception
    {
        call(this::mp_get_buffer, handler);
    }

    // function: Function(address=134260468, size=24, name='mp_get_buffer_raise', path='build/py/obj.o', has_indirect=False)
    abstract protected void mp_get_buffer_raise(int offset) throws Exception;
    public static final int mp_get_buffer_raise = 0x0800a6f4;
    public void mp_get_buffer_raise(InterruptHandler handler) throws Exception
    {
        call(this::mp_get_buffer_raise, handler);
    }

    // function: Function(address=134260492, size=16, name='mp_generic_unary_op', path='build/py/obj.o', has_indirect=False)
    abstract protected void mp_generic_unary_op(int offset) throws Exception;
    public static final int mp_generic_unary_op = 0x0800a70c;
    public void mp_generic_unary_op(InterruptHandler handler) throws Exception
    {
        call(this::mp_generic_unary_op, handler);
    }

    // function: Function(address=134260508, size=44, name='array_unary_op', path='build/py/objarray.o', has_indirect=False)
    abstract protected void array_unary_op(int offset) throws Exception;
    public static final int array_unary_op = 0x0800a71c;
    public void array_unary_op(InterruptHandler handler) throws Exception
    {
        call(this::array_unary_op, handler);
    }

    // function: Function(address=134260552, size=40, name='array_iterator_new', path='build/py/objarray.o', has_indirect=False)
    abstract protected void array_iterator_new(int offset) throws Exception;
    public static final int array_iterator_new = 0x0800a748;
    public void array_iterator_new(InterruptHandler handler) throws Exception
    {
        call(this::array_iterator_new, handler);
    }

    // function: Function(address=134260592, size=84, name='array_get_buffer', path='build/py/objarray.o', has_indirect=False)
    abstract protected void array_get_buffer(int offset) throws Exception;
    public static final int array_get_buffer = 0x0800a770;
    public void array_get_buffer(InterruptHandler handler) throws Exception
    {
        call(this::array_get_buffer, handler);
    }

    // function: Function(address=134260676, size=68, name='array_new', path='build/py/objarray.o', has_indirect=False)
    abstract protected void array_new(int offset) throws Exception;
    public static final int array_new = 0x0800a7c4;
    public void array_new(InterruptHandler handler) throws Exception
    {
        call(this::array_new, handler);
    }

    // function: Function(address=134260744, size=116, name='array_extend', path='build/py/objarray.o', has_indirect=False)
    abstract protected void array_extend(int offset) throws Exception;
    public static final int array_extend = 0x0800a808;
    public void array_extend(InterruptHandler handler) throws Exception
    {
        call(this::array_extend, handler);
    }

    // function: Function(address=134260860, size=112, name='array_append', path='build/py/objarray.o', has_indirect=False)
    abstract protected void array_append(int offset) throws Exception;
    public static final int array_append = 0x0800a87c;
    public void array_append(InterruptHandler handler) throws Exception
    {
        call(this::array_append, handler);
    }

    // function: Function(address=134260972, size=38, name='array_it_iternext', path='build/py/objarray.o', has_indirect=False)
    abstract protected void array_it_iternext(int offset) throws Exception;
    public static final int array_it_iternext = 0x0800a8ec;
    public void array_it_iternext(InterruptHandler handler) throws Exception
    {
        call(this::array_it_iternext, handler);
    }

    // function: Function(address=134261012, size=592, name='array_subscr', path='build/py/objarray.o', has_indirect=True)
    abstract protected void array_subscr(int offset) throws Exception;
    public static final int array_subscr = 0x0800a914;
    public void array_subscr(InterruptHandler handler) throws Exception
    {
        call(this::array_subscr, handler);
    }

    // function: Function(address=134261604, size=312, name='array_binary_op', path='build/py/objarray.o', has_indirect=False)
    abstract protected void array_binary_op(int offset) throws Exception;
    public static final int array_binary_op = 0x0800ab64;
    public void array_binary_op(InterruptHandler handler) throws Exception
    {
        call(this::array_binary_op, handler);
    }

    // function: Function(address=134261916, size=180, name='array_construct', path='build/py/objarray.o', has_indirect=False)
    abstract protected void array_construct(int offset) throws Exception;
    public static final int array_construct = 0x0800ac9c;
    public void array_construct(InterruptHandler handler) throws Exception
    {
        call(this::array_construct, handler);
    }

    // function: Function(address=134262096, size=50, name='array_make_new', path='build/py/objarray.o', has_indirect=False)
    abstract protected void array_make_new(int offset) throws Exception;
    public static final int array_make_new = 0x0800ad50;
    public void array_make_new(InterruptHandler handler) throws Exception
    {
        call(this::array_make_new, handler);
    }

    // function: Function(address=134262148, size=140, name='array_print', path='build/py/objarray.o', has_indirect=False)
    abstract protected void array_print(int offset) throws Exception;
    public static final int array_print = 0x0800ad84;
    public void array_print(InterruptHandler handler) throws Exception
    {
        call(this::array_print, handler);
    }

    // function: Function(address=134262288, size=100, name='bytearray_make_new', path='build/py/objarray.o', has_indirect=False)
    abstract protected void bytearray_make_new(int offset) throws Exception;
    public static final int bytearray_make_new = 0x0800ae10;
    public void bytearray_make_new(InterruptHandler handler) throws Exception
    {
        call(this::bytearray_make_new, handler);
    }

    // function: Function(address=134262388, size=36, name='mp_obj_new_memoryview', path='build/py/objarray.o', has_indirect=False)
    abstract protected void mp_obj_new_memoryview(int offset) throws Exception;
    public static final int mp_obj_new_memoryview = 0x0800ae74;
    public void mp_obj_new_memoryview(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_new_memoryview, handler);
    }

    // function: Function(address=134262424, size=102, name='memoryview_make_new', path='build/py/objarray.o', has_indirect=False)
    abstract protected void memoryview_make_new(int offset) throws Exception;
    public static final int memoryview_make_new = 0x0800ae98;
    public void memoryview_make_new(InterruptHandler handler) throws Exception
    {
        call(this::memoryview_make_new, handler);
    }

    // function: Function(address=134262528, size=32, name='mp_obj_new_bytearray_by_ref', path='build/py/objarray.o', has_indirect=False)
    abstract protected void mp_obj_new_bytearray_by_ref(int offset) throws Exception;
    public static final int mp_obj_new_bytearray_by_ref = 0x0800af00;
    public void mp_obj_new_bytearray_by_ref(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_new_bytearray_by_ref, handler);
    }

    // function: Function(address=134262560, size=42, name='mp_obj_attrtuple_attr', path='build/py/objattrtuple.o', has_indirect=False)
    abstract protected void mp_obj_attrtuple_attr(int offset) throws Exception;
    public static final int mp_obj_attrtuple_attr = 0x0800af20;
    public void mp_obj_attrtuple_attr(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_attrtuple_attr, handler);
    }

    // function: Function(address=134262604, size=92, name='mp_obj_attrtuple_print_helper', path='build/py/objattrtuple.o', has_indirect=False)
    abstract protected void mp_obj_attrtuple_print_helper(int offset) throws Exception;
    public static final int mp_obj_attrtuple_print_helper = 0x0800af4c;
    public void mp_obj_attrtuple_print_helper(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_attrtuple_print_helper, handler);
    }

    // function: Function(address=134262696, size=18, name='mp_obj_attrtuple_print', path='build/py/objattrtuple.o', has_indirect=False)
    abstract protected void mp_obj_attrtuple_print(int offset) throws Exception;
    public static final int mp_obj_attrtuple_print = 0x0800afa8;
    public void mp_obj_attrtuple_print(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_attrtuple_print, handler);
    }

    // function: Function(address=134262714, size=16, name='bool_binary_op', path='build/py/objbool.o', has_indirect=False)
    abstract protected void bool_binary_op(int offset) throws Exception;
    public static final int bool_binary_op = 0x0800afba;
    public void bool_binary_op(InterruptHandler handler) throws Exception
    {
        call(this::bool_binary_op, handler);
    }

    // function: Function(address=134262730, size=26, name='bool_unary_op', path='build/py/objbool.o', has_indirect=False)
    abstract protected void bool_unary_op(int offset) throws Exception;
    public static final int bool_unary_op = 0x0800afca;
    public void bool_unary_op(InterruptHandler handler) throws Exception
    {
        call(this::bool_unary_op, handler);
    }

    // function: Function(address=134262756, size=52, name='bool_make_new', path='build/py/objbool.o', has_indirect=False)
    abstract protected void bool_make_new(int offset) throws Exception;
    public static final int bool_make_new = 0x0800afe4;
    public void bool_make_new(InterruptHandler handler) throws Exception
    {
        call(this::bool_make_new, handler);
    }

    // function: Function(address=134262808, size=48, name='bool_print', path='build/py/objbool.o', has_indirect=False)
    abstract protected void bool_print(int offset) throws Exception;
    public static final int bool_print = 0x0800b018;
    public void bool_print(InterruptHandler handler) throws Exception
    {
        call(this::bool_print, handler);
    }

    // function: Function(address=134262856, size=64, name='bound_meth_print', path='build/py/objboundmeth.o', has_indirect=False)
    abstract protected void bound_meth_print(int offset) throws Exception;
    public static final int bound_meth_print = 0x0800b048;
    public void bound_meth_print(InterruptHandler handler) throws Exception
    {
        call(this::bound_meth_print, handler);
    }

    // function: Function(address=134262920, size=30, name='bound_meth_attr', path='build/py/objboundmeth.o', has_indirect=False)
    abstract protected void bound_meth_attr(int offset) throws Exception;
    public static final int bound_meth_attr = 0x0800b088;
    public void bound_meth_attr(InterruptHandler handler) throws Exception
    {
        call(this::bound_meth_attr, handler);
    }

    // function: Function(address=134262952, size=60, name='mp_call_method_self_n_kw', path='build/py/objboundmeth.o', has_indirect=False)
    abstract protected void mp_call_method_self_n_kw(int offset) throws Exception;
    public static final int mp_call_method_self_n_kw = 0x0800b0a8;
    public void mp_call_method_self_n_kw(InterruptHandler handler) throws Exception
    {
        call(this::mp_call_method_self_n_kw, handler);
    }

    // function: Function(address=134263012, size=18, name='bound_meth_call', path='build/py/objboundmeth.o', has_indirect=False)
    abstract protected void bound_meth_call(int offset) throws Exception;
    public static final int bound_meth_call = 0x0800b0e4;
    public void bound_meth_call(InterruptHandler handler) throws Exception
    {
        call(this::bound_meth_call, handler);
    }

    // function: Function(address=134263032, size=28, name='mp_obj_new_bound_meth', path='build/py/objboundmeth.o', has_indirect=False)
    abstract protected void mp_obj_new_bound_meth(int offset) throws Exception;
    public static final int mp_obj_new_bound_meth = 0x0800b0f8;
    public void mp_obj_new_bound_meth(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_new_bound_meth, handler);
    }

    // function: Function(address=134263060, size=60, name='cell_print', path='build/py/objcell.o', has_indirect=False)
    abstract protected void cell_print(int offset) throws Exception;
    public static final int cell_print = 0x0800b114;
    public void cell_print(InterruptHandler handler) throws Exception
    {
        call(this::cell_print, handler);
    }

    // function: Function(address=134263120, size=4, name='mp_obj_cell_get', path='build/py/objcell.o', has_indirect=False)
    abstract protected void mp_obj_cell_get(int offset) throws Exception;
    public static final int mp_obj_cell_get = 0x0800b150;
    public void mp_obj_cell_get(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_cell_get, handler);
    }

    // function: Function(address=134263124, size=4, name='mp_obj_cell_set', path='build/py/objcell.o', has_indirect=False)
    abstract protected void mp_obj_cell_set(int offset) throws Exception;
    public static final int mp_obj_cell_set = 0x0800b154;
    public void mp_obj_cell_set(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_cell_set, handler);
    }

    // function: Function(address=134263128, size=24, name='mp_obj_new_cell', path='build/py/objcell.o', has_indirect=False)
    abstract protected void mp_obj_new_cell(int offset) throws Exception;
    public static final int mp_obj_new_cell = 0x0800b158;
    public void mp_obj_new_cell(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_new_cell, handler);
    }

    // function: Function(address=134263152, size=148, name='closure_call', path='build/py/objclosure.o', has_indirect=False)
    abstract protected void closure_call(int offset) throws Exception;
    public static final int closure_call = 0x0800b170;
    public void closure_call(InterruptHandler handler) throws Exception
    {
        call(this::closure_call, handler);
    }

    // function: Function(address=134263300, size=112, name='closure_print', path='build/py/objclosure.o', has_indirect=False)
    abstract protected void closure_print(int offset) throws Exception;
    public static final int closure_print = 0x0800b204;
    public void closure_print(InterruptHandler handler) throws Exception
    {
        call(this::closure_print, handler);
    }

    // function: Function(address=134263412, size=48, name='mp_obj_new_closure', path='build/py/objclosure.o', has_indirect=False)
    abstract protected void mp_obj_new_closure(int offset) throws Exception;
    public static final int mp_obj_new_closure = 0x0800b274;
    public void mp_obj_new_closure(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_new_closure, handler);
    }

    // function: Function(address=134263460, size=40, name='complex_attr', path='build/py/objcomplex.o', has_indirect=False)
    abstract protected void complex_attr(int offset) throws Exception;
    public static final int complex_attr = 0x0800b2a4;
    public void complex_attr(InterruptHandler handler) throws Exception
    {
        call(this::complex_attr, handler);
    }

    // function: Function(address=134263500, size=160, name='complex_print', path='build/py/objcomplex.o', has_indirect=False)
    abstract protected void complex_print(int offset) throws Exception;
    public static final int complex_print = 0x0800b2cc;
    public void complex_print(InterruptHandler handler) throws Exception
    {
        call(this::complex_print, handler);
    }

    // function: Function(address=134263660, size=28, name='mp_obj_new_complex', path='build/py/objcomplex.o', has_indirect=False)
    abstract protected void mp_obj_new_complex(int offset) throws Exception;
    public static final int mp_obj_new_complex = 0x0800b36c;
    public void mp_obj_new_complex(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_new_complex, handler);
    }

    // function: Function(address=134263688, size=156, name='complex_unary_op', path='build/py/objcomplex.o', has_indirect=False)
    abstract protected void complex_unary_op(int offset) throws Exception;
    public static final int complex_unary_op = 0x0800b388;
    public void complex_unary_op(InterruptHandler handler) throws Exception
    {
        call(this::complex_unary_op, handler);
    }

    // function: Function(address=134263844, size=188, name='complex_make_new', path='build/py/objcomplex.o', has_indirect=False)
    abstract protected void complex_make_new(int offset) throws Exception;
    public static final int complex_make_new = 0x0800b424;
    public void complex_make_new(InterruptHandler handler) throws Exception
    {
        call(this::complex_make_new, handler);
    }

    // function: Function(address=134264032, size=10, name='mp_obj_complex_get', path='build/py/objcomplex.o', has_indirect=False)
    abstract protected void mp_obj_complex_get(int offset) throws Exception;
    public static final int mp_obj_complex_get = 0x0800b4e0;
    public void mp_obj_complex_get(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_complex_get, handler);
    }

    // function: Function(address=134264044, size=604, name='mp_obj_complex_binary_op', path='build/py/objcomplex.o', has_indirect=False)
    abstract protected void mp_obj_complex_binary_op(int offset) throws Exception;
    public static final int mp_obj_complex_binary_op = 0x0800b4ec;
    public void mp_obj_complex_binary_op(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_complex_binary_op, handler);
    }

    // function: Function(address=134264648, size=14, name='complex_binary_op', path='build/py/objcomplex.o', has_indirect=False)
    abstract protected void complex_binary_op(int offset) throws Exception;
    public static final int complex_binary_op = 0x0800b748;
    public void complex_binary_op(InterruptHandler handler) throws Exception
    {
        call(this::complex_binary_op, handler);
    }

    // function: Function(address=134264664, size=104, name='deque_make_new', path='build/py/objdeque.o', has_indirect=False)
    abstract protected void deque_make_new(int offset) throws Exception;
    public static final int deque_make_new = 0x0800b758;
    public void deque_make_new(InterruptHandler handler) throws Exception
    {
        call(this::deque_make_new, handler);
    }

    // function: Function(address=134264768, size=68, name='deque_unary_op', path='build/py/objdeque.o', has_indirect=False)
    abstract protected void deque_unary_op(int offset) throws Exception;
    public static final int deque_unary_op = 0x0800b7c0;
    public void deque_unary_op(InterruptHandler handler) throws Exception
    {
        call(this::deque_unary_op, handler);
    }

    // function: Function(address=134264836, size=56, name='deque_popleft', path='build/py/objdeque.o', has_indirect=False)
    abstract protected void deque_popleft(int offset) throws Exception;
    public static final int deque_popleft = 0x0800b804;
    public void deque_popleft(InterruptHandler handler) throws Exception
    {
        call(this::deque_popleft, handler);
    }

    // function: Function(address=134264892, size=76, name='mp_obj_deque_append', path='build/py/objdeque.o', has_indirect=False)
    abstract protected void mp_obj_deque_append(int offset) throws Exception;
    public static final int mp_obj_deque_append = 0x0800b83c;
    public void mp_obj_deque_append(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_deque_append, handler);
    }

    // function: Function(address=134264968, size=24, name='dict_view_getiter', path='build/py/objdict.o', has_indirect=False)
    abstract protected void dict_view_getiter(int offset) throws Exception;
    public static final int dict_view_getiter = 0x0800b888;
    public void dict_view_getiter(InterruptHandler handler) throws Exception
    {
        call(this::dict_view_getiter, handler);
    }

    // function: Function(address=134264992, size=24, name='dict_getiter', path='build/py/objdict.o', has_indirect=False)
    abstract protected void dict_getiter(int offset) throws Exception;
    public static final int dict_getiter = 0x0800b8a0;
    public void dict_getiter(InterruptHandler handler) throws Exception
    {
        call(this::dict_getiter, handler);
    }

    // function: Function(address=134265016, size=28, name='dict_values', path='build/py/objdict.o', has_indirect=False)
    abstract protected void dict_values(int offset) throws Exception;
    public static final int dict_values = 0x0800b8b8;
    public void dict_values(InterruptHandler handler) throws Exception
    {
        call(this::dict_values, handler);
    }

    // function: Function(address=134265044, size=16, name='mp_ensure_not_fixed', path='build/py/objdict.o', has_indirect=False)
    abstract protected void mp_ensure_not_fixed(int offset) throws Exception;
    public static final int mp_ensure_not_fixed = 0x0800b8d4;
    public void mp_ensure_not_fixed(InterruptHandler handler) throws Exception
    {
        call(this::mp_ensure_not_fixed, handler);
    }

    // function: Function(address=134265060, size=24, name='dict_clear', path='build/py/objdict.o', has_indirect=False)
    abstract protected void dict_clear(int offset) throws Exception;
    public static final int dict_clear = 0x0800b8e4;
    public void dict_clear(InterruptHandler handler) throws Exception
    {
        call(this::dict_clear, handler);
    }

    // function: Function(address=134265084, size=60, name='dict_unary_op', path='build/py/objdict.o', has_indirect=False)
    abstract protected void dict_unary_op(int offset) throws Exception;
    public static final int dict_unary_op = 0x0800b8fc;
    public void dict_unary_op(InterruptHandler handler) throws Exception
    {
        call(this::dict_unary_op, handler);
    }

    // function: Function(address=134265144, size=92, name='dict_get_helper', path='build/py/objdict.o', has_indirect=False)
    abstract protected void dict_get_helper(int offset) throws Exception;
    public static final int dict_get_helper = 0x0800b938;
    public void dict_get_helper(InterruptHandler handler) throws Exception
    {
        call(this::dict_get_helper, handler);
    }

    // function: Function(address=134265236, size=10, name='dict_setdefault', path='build/py/objdict.o', has_indirect=False)
    abstract protected void dict_setdefault(int offset) throws Exception;
    public static final int dict_setdefault = 0x0800b994;
    public void dict_setdefault(InterruptHandler handler) throws Exception
    {
        call(this::dict_setdefault, handler);
    }

    // function: Function(address=134265246, size=10, name='dict_pop', path='build/py/objdict.o', has_indirect=False)
    abstract protected void dict_pop(int offset) throws Exception;
    public static final int dict_pop = 0x0800b99e;
    public void dict_pop(InterruptHandler handler) throws Exception
    {
        call(this::dict_pop, handler);
    }

    // function: Function(address=134265256, size=10, name='dict_get', path='build/py/objdict.o', has_indirect=False)
    abstract protected void dict_get(int offset) throws Exception;
    public static final int dict_get = 0x0800b9a8;
    public void dict_get(InterruptHandler handler) throws Exception
    {
        call(this::dict_get, handler);
    }

    // function: Function(address=134265266, size=42, name='dict_iter_next', path='build/py/objdict.o', has_indirect=False)
    abstract protected void dict_iter_next(int offset) throws Exception;
    public static final int dict_iter_next = 0x0800b9b2;
    public void dict_iter_next(InterruptHandler handler) throws Exception
    {
        call(this::dict_iter_next, handler);
    }

    // function: Function(address=134265308, size=58, name='dict_view_it_iternext', path='build/py/objdict.o', has_indirect=False)
    abstract protected void dict_view_it_iternext(int offset) throws Exception;
    public static final int dict_view_it_iternext = 0x0800b9dc;
    public void dict_view_it_iternext(InterruptHandler handler) throws Exception
    {
        call(this::dict_view_it_iternext, handler);
    }

    // function: Function(address=134265368, size=120, name='dict_view_print', path='build/py/objdict.o', has_indirect=False)
    abstract protected void dict_view_print(int offset) throws Exception;
    public static final int dict_view_print = 0x0800ba18;
    public void dict_view_print(InterruptHandler handler) throws Exception
    {
        call(this::dict_view_print, handler);
    }

    // function: Function(address=134265488, size=232, name='dict_update', path='build/py/objdict.o', has_indirect=False)
    abstract protected void dict_update(int offset) throws Exception;
    public static final int dict_update = 0x0800ba90;
    public void dict_update(InterruptHandler handler) throws Exception
    {
        call(this::dict_update, handler);
    }

    // function: Function(address=134265720, size=72, name='dict_popitem', path='build/py/objdict.o', has_indirect=False)
    abstract protected void dict_popitem(int offset) throws Exception;
    public static final int dict_popitem = 0x0800bb78;
    public void dict_popitem(InterruptHandler handler) throws Exception
    {
        call(this::dict_popitem, handler);
    }

    // function: Function(address=134265792, size=220, name='dict_binary_op', path='build/py/objdict.o', has_indirect=False)
    abstract protected void dict_binary_op(int offset) throws Exception;
    public static final int dict_binary_op = 0x0800bbc0;
    public void dict_binary_op(InterruptHandler handler) throws Exception
    {
        call(this::dict_binary_op, handler);
    }

    // function: Function(address=134266012, size=26, name='dict_view_binary_op', path='build/py/objdict.o', has_indirect=False)
    abstract protected void dict_view_binary_op(int offset) throws Exception;
    public static final int dict_view_binary_op = 0x0800bc9c;
    public void dict_view_binary_op(InterruptHandler handler) throws Exception
    {
        call(this::dict_view_binary_op, handler);
    }

    // function: Function(address=134266040, size=164, name='dict_print', path='build/py/objdict.o', has_indirect=False)
    abstract protected void dict_print(int offset) throws Exception;
    public static final int dict_print = 0x0800bcb8;
    public void dict_print(InterruptHandler handler) throws Exception
    {
        call(this::dict_print, handler);
    }

    // function: Function(address=134266204, size=28, name='dict_items', path='build/py/objdict.o', has_indirect=False)
    abstract protected void dict_items(int offset) throws Exception;
    public static final int dict_items = 0x0800bd5c;
    public void dict_items(InterruptHandler handler) throws Exception
    {
        call(this::dict_items, handler);
    }

    // function: Function(address=134266232, size=28, name='dict_keys', path='build/py/objdict.o', has_indirect=False)
    abstract protected void dict_keys(int offset) throws Exception;
    public static final int dict_keys = 0x0800bd78;
    public void dict_keys(InterruptHandler handler) throws Exception
    {
        call(this::dict_keys, handler);
    }

    // function: Function(address=134266260, size=36, name='mp_obj_dict_get', path='build/py/objdict.o', has_indirect=False)
    abstract protected void mp_obj_dict_get(int offset) throws Exception;
    public static final int mp_obj_dict_get = 0x0800bd94;
    public void mp_obj_dict_get(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_dict_get, handler);
    }

    // function: Function(address=134266296, size=16, name='mp_obj_dict_init', path='build/py/objdict.o', has_indirect=False)
    abstract protected void mp_obj_dict_init(int offset) throws Exception;
    public static final int mp_obj_dict_init = 0x0800bdb8;
    public void mp_obj_dict_init(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_dict_init, handler);
    }

    // function: Function(address=134266312, size=22, name='mp_obj_new_dict', path='build/py/objdict.o', has_indirect=False)
    abstract protected void mp_obj_new_dict(int offset) throws Exception;
    public static final int mp_obj_new_dict = 0x0800bdc8;
    public void mp_obj_new_dict(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_new_dict, handler);
    }

    // function: Function(address=134266336, size=76, name='dict_fromkeys', path='build/py/objdict.o', has_indirect=False)
    abstract protected void dict_fromkeys(int offset) throws Exception;
    public static final int dict_fromkeys = 0x0800bde0;
    public void dict_fromkeys(InterruptHandler handler) throws Exception
    {
        call(this::dict_fromkeys, handler);
    }

    // function: Function(address=134266412, size=86, name='dict_copy', path='build/py/objdict.o', has_indirect=False)
    abstract protected void dict_copy(int offset) throws Exception;
    public static final int dict_copy = 0x0800be2c;
    public void dict_copy(InterruptHandler handler) throws Exception
    {
        call(this::dict_copy, handler);
    }

    // function: Function(address=134266500, size=80, name='dict_make_new', path='build/py/objdict.o', has_indirect=True)
    abstract protected void dict_make_new(int offset) throws Exception;
    public static final int dict_make_new = 0x0800be84;
    public void dict_make_new(InterruptHandler handler) throws Exception
    {
        call(this::dict_make_new, handler);
    }

    // function: Function(address=134266580, size=6, name='mp_obj_dict_len', path='build/py/objdict.o', has_indirect=False)
    abstract protected void mp_obj_dict_len(int offset) throws Exception;
    public static final int mp_obj_dict_len = 0x0800bed4;
    public void mp_obj_dict_len(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_dict_len, handler);
    }

    // function: Function(address=134266586, size=28, name='mp_obj_dict_store', path='build/py/objdict.o', has_indirect=False)
    abstract protected void mp_obj_dict_store(int offset) throws Exception;
    public static final int mp_obj_dict_store = 0x0800beda;
    public void mp_obj_dict_store(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_dict_store, handler);
    }

    // function: Function(address=134266614, size=22, name='mp_obj_dict_delete', path='build/py/objdict.o', has_indirect=False)
    abstract protected void mp_obj_dict_delete(int offset) throws Exception;
    public static final int mp_obj_dict_delete = 0x0800bef6;
    public void mp_obj_dict_delete(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_dict_delete, handler);
    }

    // function: Function(address=134266636, size=64, name='dict_subscr', path='build/py/objdict.o', has_indirect=False)
    abstract protected void dict_subscr(int offset) throws Exception;
    public static final int dict_subscr = 0x0800bf0c;
    public void dict_subscr(InterruptHandler handler) throws Exception
    {
        call(this::dict_subscr, handler);
    }

    // function: Function(address=134266700, size=40, name='enumerate_iternext', path='build/py/objenumerate.o', has_indirect=False)
    abstract protected void enumerate_iternext(int offset) throws Exception;
    public static final int enumerate_iternext = 0x0800bf4c;
    public void enumerate_iternext(InterruptHandler handler) throws Exception
    {
        call(this::enumerate_iternext, handler);
    }

    // function: Function(address=134266740, size=60, name='enumerate_make_new', path='build/py/objenumerate.o', has_indirect=False)
    abstract protected void enumerate_make_new(int offset) throws Exception;
    public static final int enumerate_make_new = 0x0800bf74;
    public void enumerate_make_new(InterruptHandler handler) throws Exception
    {
        call(this::enumerate_make_new, handler);
    }

    // function: Function(address=134266800, size=164, name='mp_obj_exception_print', path='build/py/objexcept.o', has_indirect=False)
    abstract protected void mp_obj_exception_print(int offset) throws Exception;
    public static final int mp_obj_exception_print = 0x0800bfb0;
    public void mp_obj_exception_print(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_exception_print, handler);
    }

    // function: Function(address=134266964, size=128, name='mp_obj_exception_make_new', path='build/py/objexcept.o', has_indirect=True)
    abstract protected void mp_obj_exception_make_new(int offset) throws Exception;
    public static final int mp_obj_exception_make_new = 0x0800c054;
    public void mp_obj_exception_make_new(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_exception_make_new, handler);
    }

    // function: Function(address=134267092, size=88, name='exc_add_strn', path='build/py/objexcept.o', has_indirect=True)
    abstract protected void exc_add_strn(int offset) throws Exception;
    public static final int exc_add_strn = 0x0800c0d4;
    public void exc_add_strn(InterruptHandler handler) throws Exception
    {
        call(this::exc_add_strn, handler);
    }

    // function: Function(address=134267180, size=2, name='mp_init_emergency_exception_buf', path='build/py/objexcept.o', has_indirect=False)
    abstract protected void mp_init_emergency_exception_buf(int offset) throws Exception;
    public static final int mp_init_emergency_exception_buf = 0x0800c12c;
    public void mp_init_emergency_exception_buf(InterruptHandler handler) throws Exception
    {
        call(this::mp_init_emergency_exception_buf, handler);
    }

    // function: Function(address=134267184, size=20, name='mp_obj_exception_get_value', path='build/py/objexcept.o', has_indirect=False)
    abstract protected void mp_obj_exception_get_value(int offset) throws Exception;
    public static final int mp_obj_exception_get_value = 0x0800c130;
    public void mp_obj_exception_get_value(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_exception_get_value, handler);
    }

    // function: Function(address=134267204, size=72, name='mp_obj_exception_attr', path='build/py/objexcept.o', has_indirect=False)
    abstract protected void mp_obj_exception_attr(int offset) throws Exception;
    public static final int mp_obj_exception_attr = 0x0800c144;
    public void mp_obj_exception_attr(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_exception_attr, handler);
    }

    // function: Function(address=134267276, size=12, name='mp_obj_new_exception_args', path='build/py/objexcept.o', has_indirect=False)
    abstract protected void mp_obj_new_exception_args(int offset) throws Exception;
    public static final int mp_obj_new_exception_args = 0x0800c18c;
    public void mp_obj_new_exception_args(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_new_exception_args, handler);
    }

    // function: Function(address=134267288, size=12, name='mp_obj_new_exception', path='build/py/objexcept.o', has_indirect=False)
    abstract protected void mp_obj_new_exception(int offset) throws Exception;
    public static final int mp_obj_new_exception = 0x0800c198;
    public void mp_obj_new_exception(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_new_exception, handler);
    }

    // function: Function(address=134267300, size=14, name='mp_obj_new_exception_arg1', path='build/py/objexcept.o', has_indirect=False)
    abstract protected void mp_obj_new_exception_arg1(int offset) throws Exception;
    public static final int mp_obj_new_exception_arg1 = 0x0800c1a4;
    public void mp_obj_new_exception_arg1(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_new_exception_arg1, handler);
    }

    // function: Function(address=134267316, size=148, name='mp_obj_new_exception_msg_varg', path='build/py/objexcept.o', has_indirect=False)
    abstract protected void mp_obj_new_exception_msg_varg(int offset) throws Exception;
    public static final int mp_obj_new_exception_msg_varg = 0x0800c1b4;
    public void mp_obj_new_exception_msg_varg(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_new_exception_msg_varg, handler);
    }

    // function: Function(address=134267464, size=8, name='mp_obj_new_exception_msg', path='build/py/objexcept.o', has_indirect=False)
    abstract protected void mp_obj_new_exception_msg(int offset) throws Exception;
    public static final int mp_obj_new_exception_msg = 0x0800c248;
    public void mp_obj_new_exception_msg(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_new_exception_msg, handler);
    }

    // function: Function(address=134267472, size=48, name='mp_obj_is_exception_type', path='build/py/objexcept.o', has_indirect=False)
    abstract protected void mp_obj_is_exception_type(int offset) throws Exception;
    public static final int mp_obj_is_exception_type = 0x0800c250;
    public void mp_obj_is_exception_type(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_is_exception_type, handler);
    }

    // function: Function(address=134267520, size=12, name='mp_obj_is_exception_instance', path='build/py/objexcept.o', has_indirect=False)
    abstract protected void mp_obj_is_exception_instance(int offset) throws Exception;
    public static final int mp_obj_is_exception_instance = 0x0800c280;
    public void mp_obj_is_exception_instance(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_is_exception_instance, handler);
    }

    // function: Function(address=134267532, size=32, name='mp_obj_exception_match', path='build/py/objexcept.o', has_indirect=False)
    abstract protected void mp_obj_exception_match(int offset) throws Exception;
    public static final int mp_obj_exception_match = 0x0800c28c;
    public void mp_obj_exception_match(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_exception_match, handler);
    }

    // function: Function(address=134267564, size=28, name='mp_obj_exception_clear_traceback', path='build/py/objexcept.o', has_indirect=False)
    abstract protected void mp_obj_exception_clear_traceback(int offset) throws Exception;
    public static final int mp_obj_exception_clear_traceback = 0x0800c2ac;
    public void mp_obj_exception_clear_traceback(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_exception_clear_traceback, handler);
    }

    // function: Function(address=134267592, size=128, name='mp_obj_exception_add_traceback', path='build/py/objexcept.o', has_indirect=False)
    abstract protected void mp_obj_exception_add_traceback(int offset) throws Exception;
    public static final int mp_obj_exception_add_traceback = 0x0800c2c8;
    public void mp_obj_exception_add_traceback(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_exception_add_traceback, handler);
    }

    // function: Function(address=134267720, size=44, name='mp_obj_exception_get_traceback', path='build/py/objexcept.o', has_indirect=False)
    abstract protected void mp_obj_exception_get_traceback(int offset) throws Exception;
    public static final int mp_obj_exception_get_traceback = 0x0800c348;
    public void mp_obj_exception_get_traceback(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_exception_get_traceback, handler);
    }

    // function: Function(address=134267764, size=52, name='filter_iternext', path='build/py/objfilter.o', has_indirect=False)
    abstract protected void filter_iternext(int offset) throws Exception;
    public static final int filter_iternext = 0x0800c374;
    public void filter_iternext(InterruptHandler handler) throws Exception
    {
        call(this::filter_iternext, handler);
    }

    // function: Function(address=134267816, size=50, name='filter_make_new', path='build/py/objfilter.o', has_indirect=False)
    abstract protected void filter_make_new(int offset) throws Exception;
    public static final int filter_make_new = 0x0800c3a8;
    public void filter_make_new(InterruptHandler handler) throws Exception
    {
        call(this::filter_make_new, handler);
    }

    // function: Function(address=134267868, size=88, name='float_print', path='build/py/objfloat.o', has_indirect=False)
    abstract protected void float_print(int offset) throws Exception;
    public static final int float_print = 0x0800c3dc;
    public void float_print(InterruptHandler handler) throws Exception
    {
        call(this::float_print, handler);
    }

    // function: Function(address=134267956, size=220, name='mp_obj_float_divmod', path='build/py/objfloat.o', has_indirect=False)
    abstract protected void mp_obj_float_divmod(int offset) throws Exception;
    public static final int mp_obj_float_divmod = 0x0800c434;
    public void mp_obj_float_divmod(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_float_divmod, handler);
    }

    // function: Function(address=134268176, size=70, name='mp_float_hash', path='build/py/objfloat.o', has_indirect=False)
    abstract protected void mp_float_hash(int offset) throws Exception;
    public static final int mp_float_hash = 0x0800c510;
    public void mp_float_hash(InterruptHandler handler) throws Exception
    {
        call(this::mp_float_hash, handler);
    }

    // function: Function(address=134268248, size=24, name='mp_obj_new_float', path='build/py/objfloat.o', has_indirect=False)
    abstract protected void mp_obj_new_float(int offset) throws Exception;
    public static final int mp_obj_new_float = 0x0800c558;
    public void mp_obj_new_float(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_new_float, handler);
    }

    // function: Function(address=134268272, size=92, name='float_make_new', path='build/py/objfloat.o', has_indirect=False)
    abstract protected void float_make_new(int offset) throws Exception;
    public static final int float_make_new = 0x0800c570;
    public void float_make_new(InterruptHandler handler) throws Exception
    {
        call(this::float_make_new, handler);
    }

    // function: Function(address=134268364, size=100, name='float_unary_op', path='build/py/objfloat.o', has_indirect=False)
    abstract protected void float_unary_op(int offset) throws Exception;
    public static final int float_unary_op = 0x0800c5cc;
    public void float_unary_op(InterruptHandler handler) throws Exception
    {
        call(this::float_unary_op, handler);
    }

    // function: Function(address=134268464, size=4, name='mp_obj_float_get', path='build/py/objfloat.o', has_indirect=False)
    abstract protected void mp_obj_float_get(int offset) throws Exception;
    public static final int mp_obj_float_get = 0x0800c630;
    public void mp_obj_float_get(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_float_get, handler);
    }

    // function: Function(address=134268468, size=560, name='mp_obj_float_binary_op', path='build/py/objfloat.o', has_indirect=False)
    abstract protected void mp_obj_float_binary_op(int offset) throws Exception;
    public static final int mp_obj_float_binary_op = 0x0800c634;
    public void mp_obj_float_binary_op(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_float_binary_op, handler);
    }

    // function: Function(address=134269028, size=36, name='float_binary_op', path='build/py/objfloat.o', has_indirect=False)
    abstract protected void float_binary_op(int offset) throws Exception;
    public static final int float_binary_op = 0x0800c864;
    public void float_binary_op(InterruptHandler handler) throws Exception
    {
        call(this::float_binary_op, handler);
    }

    // function: Function(address=134269064, size=24, name='fun_builtin_0_call', path='build/py/objfun.o', has_indirect=False)
    abstract protected void fun_builtin_0_call(int offset) throws Exception;
    public static final int fun_builtin_0_call = 0x0800c888;
    public void fun_builtin_0_call(InterruptHandler handler) throws Exception
    {
        call(this::fun_builtin_0_call, handler);
    }

    // function: Function(address=134269088, size=30, name='fun_builtin_1_call', path='build/py/objfun.o', has_indirect=False)
    abstract protected void fun_builtin_1_call(int offset) throws Exception;
    public static final int fun_builtin_1_call = 0x0800c8a0;
    public void fun_builtin_1_call(InterruptHandler handler) throws Exception
    {
        call(this::fun_builtin_1_call, handler);
    }

    // function: Function(address=134269118, size=30, name='fun_builtin_2_call', path='build/py/objfun.o', has_indirect=False)
    abstract protected void fun_builtin_2_call(int offset) throws Exception;
    public static final int fun_builtin_2_call = 0x0800c8be;
    public void fun_builtin_2_call(InterruptHandler handler) throws Exception
    {
        call(this::fun_builtin_2_call, handler);
    }

    // function: Function(address=134269148, size=30, name='fun_builtin_3_call', path='build/py/objfun.o', has_indirect=False)
    abstract protected void fun_builtin_3_call(int offset) throws Exception;
    public static final int fun_builtin_3_call = 0x0800c8dc;
    public void fun_builtin_3_call(InterruptHandler handler) throws Exception
    {
        call(this::fun_builtin_3_call, handler);
    }

    // function: Function(address=134269180, size=132, name='fun_bc_call', path='build/py/objfun.o', has_indirect=False)
    abstract protected void fun_bc_call(int offset) throws Exception;
    public static final int fun_bc_call = 0x0800c8fc;
    public void fun_bc_call(InterruptHandler handler) throws Exception
    {
        call(this::fun_bc_call, handler);
    }

    // function: Function(address=134269312, size=76, name='fun_builtin_var_call', path='build/py/objfun.o', has_indirect=False)
    abstract protected void fun_builtin_var_call(int offset) throws Exception;
    public static final int fun_builtin_var_call = 0x0800c980;
    public void fun_builtin_var_call(InterruptHandler handler) throws Exception
    {
        call(this::fun_builtin_var_call, handler);
    }

    // function: Function(address=134269388, size=16, name='mp_obj_code_get_name', path='build/py/objfun.o', has_indirect=False)
    abstract protected void mp_obj_code_get_name(int offset) throws Exception;
    public static final int mp_obj_code_get_name = 0x0800c9cc;
    public void mp_obj_code_get_name(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_code_get_name, handler);
    }

    // function: Function(address=134269404, size=20, name='mp_obj_fun_get_name', path='build/py/objfun.o', has_indirect=False)
    abstract protected void mp_obj_fun_get_name(int offset) throws Exception;
    public static final int mp_obj_fun_get_name = 0x0800c9dc;
    public void mp_obj_fun_get_name(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_fun_get_name, handler);
    }

    // function: Function(address=134269424, size=28, name='mp_obj_fun_bc_attr', path='build/py/objfun.o', has_indirect=False)
    abstract protected void mp_obj_fun_bc_attr(int offset) throws Exception;
    public static final int mp_obj_fun_bc_attr = 0x0800c9f0;
    public void mp_obj_fun_bc_attr(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_fun_bc_attr, handler);
    }

    // function: Function(address=134269452, size=32, name='fun_bc_print', path='build/py/objfun.o', has_indirect=False)
    abstract protected void fun_bc_print(int offset) throws Exception;
    public static final int fun_bc_print = 0x0800ca0c;
    public void fun_bc_print(InterruptHandler handler) throws Exception
    {
        call(this::fun_bc_print, handler);
    }

    // function: Function(address=134269484, size=84, name='mp_obj_fun_bc_prepare_codestate', path='build/py/objfun.o', has_indirect=False)
    abstract protected void mp_obj_fun_bc_prepare_codestate(int offset) throws Exception;
    public static final int mp_obj_fun_bc_prepare_codestate = 0x0800ca2c;
    public void mp_obj_fun_bc_prepare_codestate(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_fun_bc_prepare_codestate, handler);
    }

    // function: Function(address=134269568, size=92, name='mp_obj_new_fun_bc', path='build/py/objfun.o', has_indirect=False)
    abstract protected void mp_obj_new_fun_bc(int offset) throws Exception;
    public static final int mp_obj_new_fun_bc = 0x0800ca80;
    public void mp_obj_new_fun_bc(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_new_fun_bc, handler);
    }

    // function: Function(address=134269660, size=80, name='gen_wrap_call', path='build/py/objgenerator.o', has_indirect=False)
    abstract protected void gen_wrap_call(int offset) throws Exception;
    public static final int gen_wrap_call = 0x0800cadc;
    public void gen_wrap_call(InterruptHandler handler) throws Exception
    {
        call(this::gen_wrap_call, handler);
    }

    // function: Function(address=134269740, size=28, name='gen_instance_pend_throw', path='build/py/objgenerator.o', has_indirect=False)
    abstract protected void gen_instance_pend_throw(int offset) throws Exception;
    public static final int gen_instance_pend_throw = 0x0800cb2c;
    public void gen_instance_pend_throw(InterruptHandler handler) throws Exception
    {
        call(this::gen_instance_pend_throw, handler);
    }

    // function: Function(address=134269768, size=32, name='gen_instance_print', path='build/py/objgenerator.o', has_indirect=False)
    abstract protected void gen_instance_print(int offset) throws Exception;
    public static final int gen_instance_print = 0x0800cb48;
    public void gen_instance_print(InterruptHandler handler) throws Exception
    {
        call(this::gen_instance_print, handler);
    }

    // function: Function(address=134269800, size=16, name='unlikely_gen_instance_throw_part_0', path='build/py/objgenerator.o', has_indirect=False)
    abstract protected void unlikely_gen_instance_throw_part_0(int offset) throws Exception;
    public static final int unlikely_gen_instance_throw_part_0 = 0x0800cb68;
    public void unlikely_gen_instance_throw_part_0(InterruptHandler handler) throws Exception
    {
        call(this::unlikely_gen_instance_throw_part_0, handler);
    }

    // function: Function(address=134269816, size=184, name='mp_obj_gen_resume', path='build/py/objgenerator.o', has_indirect=False)
    abstract protected void mp_obj_gen_resume(int offset) throws Exception;
    public static final int mp_obj_gen_resume = 0x0800cb78;
    public void mp_obj_gen_resume(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_gen_resume, handler);
    }

    // function: Function(address=134270000, size=88, name='gen_resume_and_raise', path='build/py/objgenerator.o', has_indirect=False)
    abstract protected void gen_resume_and_raise(int offset) throws Exception;
    public static final int gen_resume_and_raise = 0x0800cc30;
    public void gen_resume_and_raise(InterruptHandler handler) throws Exception
    {
        call(this::gen_resume_and_raise, handler);
    }

    // function: Function(address=134270088, size=36, name='gen_instance_throw', path='build/py/objgenerator.o', has_indirect=False)
    abstract protected void gen_instance_throw(int offset) throws Exception;
    public static final int gen_instance_throw = 0x0800cc88;
    public void gen_instance_throw(InterruptHandler handler) throws Exception
    {
        call(this::gen_instance_throw, handler);
    }

    // function: Function(address=134270124, size=18, name='gen_instance_send', path='build/py/objgenerator.o', has_indirect=False)
    abstract protected void gen_instance_send(int offset) throws Exception;
    public static final int gen_instance_send = 0x0800ccac;
    public void gen_instance_send(InterruptHandler handler) throws Exception
    {
        call(this::gen_instance_send, handler);
    }

    // function: Function(address=134270144, size=16, name='gen_instance_iternext', path='build/py/objgenerator.o', has_indirect=False)
    abstract protected void gen_instance_iternext(int offset) throws Exception;
    public static final int gen_instance_iternext = 0x0800ccc0;
    public void gen_instance_iternext(InterruptHandler handler) throws Exception
    {
        call(this::gen_instance_iternext, handler);
    }

    // function: Function(address=134270160, size=96, name='gen_instance_close', path='build/py/objgenerator.o', has_indirect=False)
    abstract protected void gen_instance_close(int offset) throws Exception;
    public static final int gen_instance_close = 0x0800ccd0;
    public void gen_instance_close(InterruptHandler handler) throws Exception
    {
        call(this::gen_instance_close, handler);
    }

    // function: Function(address=134270256, size=84, name='it_iternext', path='build/py/objgetitemiter.o', has_indirect=False)
    abstract protected void it_iternext(int offset) throws Exception;
    public static final int it_iternext = 0x0800cd30;
    public void it_iternext(InterruptHandler handler) throws Exception
    {
        call(this::it_iternext, handler);
    }

    // function: Function(address=134270340, size=24, name='mp_obj_new_getitem_iter', path='build/py/objgetitemiter.o', has_indirect=False)
    abstract protected void mp_obj_new_getitem_iter(int offset) throws Exception;
    public static final int mp_obj_new_getitem_iter = 0x0800cd84;
    public void mp_obj_new_getitem_iter(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_new_getitem_iter, handler);
    }

    // function: Function(address=134270364, size=128, name='int_to_bytes', path='build/py/objint.o', has_indirect=False)
    abstract protected void int_to_bytes(int offset) throws Exception;
    public static final int int_to_bytes = 0x0800cd9c;
    public void int_to_bytes(InterruptHandler handler) throws Exception
    {
        call(this::int_to_bytes, handler);
    }

    // function: Function(address=134270492, size=108, name='int_from_bytes', path='build/py/objint.o', has_indirect=False)
    abstract protected void int_from_bytes(int offset) throws Exception;
    public static final int int_from_bytes = 0x0800ce1c;
    public void int_from_bytes(InterruptHandler handler) throws Exception
    {
        call(this::int_from_bytes, handler);
    }

    // function: Function(address=134270600, size=128, name='mp_obj_new_int_from_float', path='build/py/objint.o', has_indirect=False)
    abstract protected void mp_obj_new_int_from_float(int offset) throws Exception;
    public static final int mp_obj_new_int_from_float = 0x0800ce88;
    public void mp_obj_new_int_from_float(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_new_int_from_float, handler);
    }

    // function: Function(address=134270728, size=156, name='mp_obj_int_make_new', path='build/py/objint.o', has_indirect=False)
    abstract protected void mp_obj_int_make_new(int offset) throws Exception;
    public static final int mp_obj_int_make_new = 0x0800cf08;
    public void mp_obj_int_make_new(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_int_make_new, handler);
    }

    // function: Function(address=134270884, size=56, name='mp_int_format_size', path='build/py/objint.o', has_indirect=False)
    abstract protected void mp_int_format_size(int offset) throws Exception;
    public static final int mp_int_format_size = 0x0800cfa4;
    public void mp_int_format_size(InterruptHandler handler) throws Exception
    {
        call(this::mp_int_format_size, handler);
    }

    // function: Function(address=134270940, size=278, name='mp_obj_int_formatted', path='build/py/objint.o', has_indirect=False)
    abstract protected void mp_obj_int_formatted(int offset) throws Exception;
    public static final int mp_obj_int_formatted = 0x0800cfdc;
    public void mp_obj_int_formatted(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_int_formatted, handler);
    }

    // function: Function(address=134271218, size=62, name='mp_obj_int_print', path='build/py/objint.o', has_indirect=False)
    abstract protected void mp_obj_int_print(int offset) throws Exception;
    public static final int mp_obj_int_print = 0x0800d0f2;
    public void mp_obj_int_print(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_int_print, handler);
    }

    // function: Function(address=134271280, size=100, name='mp_obj_int_binary_op_extra_cases', path='build/py/objint.o', has_indirect=False)
    abstract protected void mp_obj_int_binary_op_extra_cases(int offset) throws Exception;
    public static final int mp_obj_int_binary_op_extra_cases = 0x0800d130;
    public void mp_obj_int_binary_op_extra_cases(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_int_binary_op_extra_cases, handler);
    }

    // function: Function(address=134271380, size=28, name='mp_obj_int_new_mpz', path='build/py/objint_mpz.o', has_indirect=False)
    abstract protected void mp_obj_int_new_mpz(int offset) throws Exception;
    public static final int mp_obj_int_new_mpz = 0x0800d194;
    public void mp_obj_int_new_mpz(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_int_new_mpz, handler);
    }

    // function: Function(address=134271408, size=84, name='mp_obj_int_formatted_impl', path='build/py/objint_mpz.o', has_indirect=False)
    abstract protected void mp_obj_int_formatted_impl(int offset) throws Exception;
    public static final int mp_obj_int_formatted_impl = 0x0800d1b0;
    public void mp_obj_int_formatted_impl(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_int_formatted_impl, handler);
    }

    // function: Function(address=134271492, size=30, name='mp_obj_int_from_bytes_impl', path='build/py/objint_mpz.o', has_indirect=False)
    abstract protected void mp_obj_int_from_bytes_impl(int offset) throws Exception;
    public static final int mp_obj_int_from_bytes_impl = 0x0800d204;
    public void mp_obj_int_from_bytes_impl(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_int_from_bytes_impl, handler);
    }

    // function: Function(address=134271522, size=32, name='mp_obj_int_to_bytes_impl', path='build/py/objint_mpz.o', has_indirect=False)
    abstract protected void mp_obj_int_to_bytes_impl(int offset) throws Exception;
    public static final int mp_obj_int_to_bytes_impl = 0x0800d222;
    public void mp_obj_int_to_bytes_impl(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_int_to_bytes_impl, handler);
    }

    // function: Function(address=134271554, size=40, name='mp_obj_int_sign', path='build/py/objint_mpz.o', has_indirect=False)
    abstract protected void mp_obj_int_sign(int offset) throws Exception;
    public static final int mp_obj_int_sign = 0x0800d242;
    public void mp_obj_int_sign(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_int_sign, handler);
    }

    // function: Function(address=134271596, size=128, name='mp_obj_int_unary_op', path='build/py/objint_mpz.o', has_indirect=False)
    abstract protected void mp_obj_int_unary_op(int offset) throws Exception;
    public static final int mp_obj_int_unary_op = 0x0800d26c;
    public void mp_obj_int_unary_op(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_int_unary_op, handler);
    }

    // function: Function(address=134271724, size=30, name='mp_obj_new_int_from_ll', path='build/py/objint_mpz.o', has_indirect=False)
    abstract protected void mp_obj_new_int_from_ll(int offset) throws Exception;
    public static final int mp_obj_new_int_from_ll = 0x0800d2ec;
    public void mp_obj_new_int_from_ll(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_new_int_from_ll, handler);
    }

    // function: Function(address=134271754, size=24, name='mp_obj_new_int', path='build/py/objint_mpz.o', has_indirect=False)
    abstract protected void mp_obj_new_int(int offset) throws Exception;
    public static final int mp_obj_new_int = 0x0800d30a;
    public void mp_obj_new_int(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_new_int, handler);
    }

    // function: Function(address=134271778, size=30, name='mp_obj_new_int_from_ull', path='build/py/objint_mpz.o', has_indirect=False)
    abstract protected void mp_obj_new_int_from_ull(int offset) throws Exception;
    public static final int mp_obj_new_int_from_ull = 0x0800d322;
    public void mp_obj_new_int_from_ull(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_new_int_from_ull, handler);
    }

    // function: Function(address=134271808, size=208, name='mp_obj_int_pow3', path='build/py/objint_mpz.o', has_indirect=False)
    abstract protected void mp_obj_int_pow3(int offset) throws Exception;
    public static final int mp_obj_int_pow3 = 0x0800d340;
    public void mp_obj_int_pow3(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_int_pow3, handler);
    }

    // function: Function(address=134272016, size=22, name='mp_obj_new_int_from_uint', path='build/py/objint_mpz.o', has_indirect=False)
    abstract protected void mp_obj_new_int_from_uint(int offset) throws Exception;
    public static final int mp_obj_new_int_from_uint = 0x0800d410;
    public void mp_obj_new_int_from_uint(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_new_int_from_uint, handler);
    }

    // function: Function(address=134272038, size=46, name='mp_obj_new_int_from_str_len', path='build/py/objint_mpz.o', has_indirect=False)
    abstract protected void mp_obj_new_int_from_str_len(int offset) throws Exception;
    public static final int mp_obj_new_int_from_str_len = 0x0800d426;
    public void mp_obj_new_int_from_str_len(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_new_int_from_str_len, handler);
    }

    // function: Function(address=134272084, size=18, name='mp_obj_int_get_truncated', path='build/py/objint_mpz.o', has_indirect=False)
    abstract protected void mp_obj_int_get_truncated(int offset) throws Exception;
    public static final int mp_obj_int_get_truncated = 0x0800d454;
    public void mp_obj_int_get_truncated(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_int_get_truncated, handler);
    }

    // function: Function(address=134272104, size=44, name='mp_obj_int_get_checked', path='build/py/objint_mpz.o', has_indirect=False)
    abstract protected void mp_obj_int_get_checked(int offset) throws Exception;
    public static final int mp_obj_int_get_checked = 0x0800d468;
    public void mp_obj_int_get_checked(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_int_get_checked, handler);
    }

    // function: Function(address=134272148, size=648, name='mp_obj_int_binary_op', path='build/py/objint_mpz.o', has_indirect=False)
    abstract protected void mp_obj_int_binary_op(int offset) throws Exception;
    public static final int mp_obj_int_binary_op = 0x0800d494;
    public void mp_obj_int_binary_op(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_int_binary_op, handler);
    }

    // function: Function(address=134272796, size=10, name='mp_obj_int_as_float_impl', path='build/py/objint_mpz.o', has_indirect=False)
    abstract protected void mp_obj_int_as_float_impl(int offset) throws Exception;
    public static final int mp_obj_int_as_float_impl = 0x0800d71c;
    public void mp_obj_int_as_float_impl(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_int_as_float_impl, handler);
    }

    // function: Function(address=134272808, size=28, name='list_getiter', path='build/py/objlist.o', has_indirect=False)
    abstract protected void list_getiter(int offset) throws Exception;
    public static final int list_getiter = 0x0800d728;
    public void list_getiter(InterruptHandler handler) throws Exception
    {
        call(this::list_getiter, handler);
    }

    // function: Function(address=134272836, size=56, name='list_reverse', path='build/py/objlist.o', has_indirect=False)
    abstract protected void list_reverse(int offset) throws Exception;
    public static final int list_reverse = 0x0800d744;
    public void list_reverse(InterruptHandler handler) throws Exception
    {
        call(this::list_reverse, handler);
    }

    // function: Function(address=134272892, size=28, name='list_it_iternext', path='build/py/objlist.o', has_indirect=True)
    abstract protected void list_it_iternext(int offset) throws Exception;
    public static final int list_it_iternext = 0x0800d77c;
    public void list_it_iternext(InterruptHandler handler) throws Exception
    {
        call(this::list_it_iternext, handler);
    }

    // function: Function(address=134272920, size=80, name='mp_obj_list_append', path='build/py/objlist.o', has_indirect=False)
    abstract protected void mp_obj_list_append(int offset) throws Exception;
    public static final int mp_obj_list_append = 0x0800d798;
    public void mp_obj_list_append(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_list_append, handler);
    }

    // function: Function(address=134273000, size=76, name='list_insert', path='build/py/objlist.o', has_indirect=False)
    abstract protected void list_insert(int offset) throws Exception;
    public static final int list_insert = 0x0800d7e8;
    public void list_insert(InterruptHandler handler) throws Exception
    {
        call(this::list_insert, handler);
    }

    // function: Function(address=134273076, size=44, name='list_clear', path='build/py/objlist.o', has_indirect=False)
    abstract protected void list_clear(int offset) throws Exception;
    public static final int list_clear = 0x0800d834;
    public void list_clear(InterruptHandler handler) throws Exception
    {
        call(this::list_clear, handler);
    }

    // function: Function(address=134273120, size=208, name='mp_quicksort', path='build/py/objlist.o', has_indirect=False)
    abstract protected void mp_quicksort(int offset) throws Exception;
    public static final int mp_quicksort = 0x0800d860;
    public void mp_quicksort(InterruptHandler handler) throws Exception
    {
        call(this::mp_quicksort, handler);
    }

    // function: Function(address=134273328, size=92, name='mp_obj_list_sort', path='build/py/objlist.o', has_indirect=False)
    abstract protected void mp_obj_list_sort(int offset) throws Exception;
    public static final int mp_obj_list_sort = 0x0800d930;
    public void mp_obj_list_sort(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_list_sort, handler);
    }

    // function: Function(address=134273420, size=18, name='list_index', path='build/py/objlist.o', has_indirect=False)
    abstract protected void list_index(int offset) throws Exception;
    public static final int list_index = 0x0800d98c;
    public void list_index(InterruptHandler handler) throws Exception
    {
        call(this::list_index, handler);
    }

    // function: Function(address=134273440, size=124, name='list_pop', path='build/py/objlist.o', has_indirect=False)
    abstract protected void list_pop(int offset) throws Exception;
    public static final int list_pop = 0x0800d9a0;
    public void list_pop(InterruptHandler handler) throws Exception
    {
        call(this::list_pop, handler);
    }

    // function: Function(address=134273564, size=32, name='mp_obj_list_remove', path='build/py/objlist.o', has_indirect=False)
    abstract protected void mp_obj_list_remove(int offset) throws Exception;
    public static final int mp_obj_list_remove = 0x0800da1c;
    public void mp_obj_list_remove(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_list_remove, handler);
    }

    // function: Function(address=134273596, size=36, name='list_extend_from_iter', path='build/py/objlist.o', has_indirect=False)
    abstract protected void list_extend_from_iter(int offset) throws Exception;
    public static final int list_extend_from_iter = 0x0800da3c;
    public void list_extend_from_iter(InterruptHandler handler) throws Exception
    {
        call(this::list_extend_from_iter, handler);
    }

    // function: Function(address=134273632, size=14, name='list_count', path='build/py/objlist.o', has_indirect=False)
    abstract protected void list_count(int offset) throws Exception;
    public static final int list_count = 0x0800da60;
    public void list_count(InterruptHandler handler) throws Exception
    {
        call(this::list_count, handler);
    }

    // function: Function(address=134273648, size=84, name='list_print', path='build/py/objlist.o', has_indirect=False)
    abstract protected void list_print(int offset) throws Exception;
    public static final int list_print = 0x0800da70;
    public void list_print(InterruptHandler handler) throws Exception
    {
        call(this::list_print, handler);
    }

    // function: Function(address=134273732, size=56, name='list_unary_op', path='build/py/objlist.o', has_indirect=False)
    abstract protected void list_unary_op(int offset) throws Exception;
    public static final int list_unary_op = 0x0800dac4;
    public void list_unary_op(InterruptHandler handler) throws Exception
    {
        call(this::list_unary_op, handler);
    }

    // function: Function(address=134273788, size=116, name='list_extend', path='build/py/objlist.o', has_indirect=False)
    abstract protected void list_extend(int offset) throws Exception;
    public static final int list_extend = 0x0800dafc;
    public void list_extend(InterruptHandler handler) throws Exception
    {
        call(this::list_extend, handler);
    }

    // function: Function(address=134273904, size=52, name='mp_obj_list_init', path='build/py/objlist.o', has_indirect=False)
    abstract protected void mp_obj_list_init(int offset) throws Exception;
    public static final int mp_obj_list_init = 0x0800db70;
    public void mp_obj_list_init(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_list_init, handler);
    }

    // function: Function(address=134273956, size=22, name='list_new', path='build/py/objlist.o', has_indirect=False)
    abstract protected void list_new(int offset) throws Exception;
    public static final int list_new = 0x0800dba4;
    public void list_new(InterruptHandler handler) throws Exception
    {
        call(this::list_new, handler);
    }

    // function: Function(address=134273980, size=216, name='list_binary_op', path='build/py/objlist.o', has_indirect=False)
    abstract protected void list_binary_op(int offset) throws Exception;
    public static final int list_binary_op = 0x0800dbbc;
    public void list_binary_op(InterruptHandler handler) throws Exception
    {
        call(this::list_binary_op, handler);
    }

    // function: Function(address=134274196, size=48, name='list_make_new', path='build/py/objlist.o', has_indirect=False)
    abstract protected void list_make_new(int offset) throws Exception;
    public static final int list_make_new = 0x0800dc94;
    public void list_make_new(InterruptHandler handler) throws Exception
    {
        call(this::list_make_new, handler);
    }

    // function: Function(address=134274244, size=34, name='mp_obj_new_list', path='build/py/objlist.o', has_indirect=False)
    abstract protected void mp_obj_new_list(int offset) throws Exception;
    public static final int mp_obj_new_list = 0x0800dcc4;
    public void mp_obj_new_list(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_new_list, handler);
    }

    // function: Function(address=134274278, size=12, name='list_copy', path='build/py/objlist.o', has_indirect=False)
    abstract protected void list_copy(int offset) throws Exception;
    public static final int list_copy = 0x0800dce6;
    public void list_copy(InterruptHandler handler) throws Exception
    {
        call(this::list_copy, handler);
    }

    // function: Function(address=134274290, size=10, name='mp_obj_list_get', path='build/py/objlist.o', has_indirect=False)
    abstract protected void mp_obj_list_get(int offset) throws Exception;
    public static final int mp_obj_list_get = 0x0800dcf2;
    public void mp_obj_list_get(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_list_get, handler);
    }

    // function: Function(address=134274300, size=4, name='mp_obj_list_set_len', path='build/py/objlist.o', has_indirect=False)
    abstract protected void mp_obj_list_set_len(int offset) throws Exception;
    public static final int mp_obj_list_set_len = 0x0800dcfc;
    public void mp_obj_list_set_len(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_list_set_len, handler);
    }

    // function: Function(address=134274304, size=26, name='mp_obj_list_store', path='build/py/objlist.o', has_indirect=False)
    abstract protected void mp_obj_list_store(int offset) throws Exception;
    public static final int mp_obj_list_store = 0x0800dd00;
    public void mp_obj_list_store(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_list_store, handler);
    }

    // function: Function(address=134274332, size=440, name='list_subscr', path='build/py/objlist.o', has_indirect=False)
    abstract protected void list_subscr(int offset) throws Exception;
    public static final int list_subscr = 0x0800dd1c;
    public void list_subscr(InterruptHandler handler) throws Exception
    {
        call(this::list_subscr, handler);
    }

    // function: Function(address=134274772, size=72, name='map_iternext', path='build/py/objmap.o', has_indirect=False)
    abstract protected void map_iternext(int offset) throws Exception;
    public static final int map_iternext = 0x0800ded4;
    public void map_iternext(InterruptHandler handler) throws Exception
    {
        call(this::map_iternext, handler);
    }

    // function: Function(address=134274844, size=88, name='map_make_new', path='build/py/objmap.o', has_indirect=False)
    abstract protected void map_make_new(int offset) throws Exception;
    public static final int map_make_new = 0x0800df1c;
    public void map_make_new(InterruptHandler handler) throws Exception
    {
        call(this::map_make_new, handler);
    }

    // function: Function(address=134274932, size=92, name='module_print', path='build/py/objmodule.o', has_indirect=False)
    abstract protected void module_print(int offset) throws Exception;
    public static final int module_print = 0x0800df74;
    public void module_print(InterruptHandler handler) throws Exception
    {
        call(this::module_print, handler);
    }

    // function: Function(address=134275024, size=104, name='module_attr', path='build/py/objmodule.o', has_indirect=False)
    abstract protected void module_attr(int offset) throws Exception;
    public static final int module_attr = 0x0800dfd0;
    public void module_attr(InterruptHandler handler) throws Exception
    {
        call(this::module_attr, handler);
    }

    // function: Function(address=134275128, size=68, name='mp_obj_new_module', path='build/py/objmodule.o', has_indirect=False)
    abstract protected void mp_obj_new_module(int offset) throws Exception;
    public static final int mp_obj_new_module = 0x0800e038;
    public void mp_obj_new_module(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_new_module, handler);
    }

    // function: Function(address=134275196, size=28, name='mp_module_register', path='build/py/objmodule.o', has_indirect=False)
    abstract protected void mp_module_register(int offset) throws Exception;
    public static final int mp_module_register = 0x0800e07c;
    public void mp_module_register(InterruptHandler handler) throws Exception
    {
        call(this::mp_module_register, handler);
    }

    // function: Function(address=134275224, size=42, name='mp_module_call_init', path='build/py/objmodule.o', has_indirect=False)
    abstract protected void mp_module_call_init(int offset) throws Exception;
    public static final int mp_module_call_init = 0x0800e098;
    public void mp_module_call_init(InterruptHandler handler) throws Exception
    {
        call(this::mp_module_call_init, handler);
    }

    // function: Function(address=134275268, size=60, name='mp_module_get', path='build/py/objmodule.o', has_indirect=False)
    abstract protected void mp_module_get(int offset) throws Exception;
    public static final int mp_module_get = 0x0800e0c4;
    public void mp_module_get(InterruptHandler handler) throws Exception
    {
        call(this::mp_module_get, handler);
    }

    // function: Function(address=134275328, size=8, name='object___init__', path='build/py/objobject.o', has_indirect=False)
    abstract protected void object___init__(int offset) throws Exception;
    public static final int object___init__ = 0x0800e100;
    public void object___init__(InterruptHandler handler) throws Exception
    {
        call(this::object___init__, handler);
    }

    // function: Function(address=134275336, size=48, name='object___new__', path='build/py/objobject.o', has_indirect=False)
    abstract protected void object___new__(int offset) throws Exception;
    public static final int object___new__ = 0x0800e108;
    public void object___new__(InterruptHandler handler) throws Exception
    {
        call(this::object___new__, handler);
    }

    // function: Function(address=134275384, size=28, name='object_make_new', path='build/py/objobject.o', has_indirect=False)
    abstract protected void object_make_new(int offset) throws Exception;
    public static final int object_make_new = 0x0800e138;
    public void object_make_new(InterruptHandler handler) throws Exception
    {
        call(this::object_make_new, handler);
    }

    // function: Function(address=134275412, size=8, name='polymorph_it_iternext', path='build/py/objpolyiter.o', has_indirect=False)
    abstract protected void polymorph_it_iternext(int offset) throws Exception;
    public static final int polymorph_it_iternext = 0x0800e154;
    public void polymorph_it_iternext(InterruptHandler handler) throws Exception
    {
        call(this::polymorph_it_iternext, handler);
    }

    // function: Function(address=134275420, size=22, name='property_deleter', path='build/py/objproperty.o', has_indirect=False)
    abstract protected void property_deleter(int offset) throws Exception;
    public static final int property_deleter = 0x0800e15c;
    public void property_deleter(InterruptHandler handler) throws Exception
    {
        call(this::property_deleter, handler);
    }

    // function: Function(address=134275442, size=26, name='property_setter', path='build/py/objproperty.o', has_indirect=False)
    abstract protected void property_setter(int offset) throws Exception;
    public static final int property_setter = 0x0800e172;
    public void property_setter(InterruptHandler handler) throws Exception
    {
        call(this::property_setter, handler);
    }

    // function: Function(address=134275468, size=26, name='property_getter', path='build/py/objproperty.o', has_indirect=False)
    abstract protected void property_getter(int offset) throws Exception;
    public static final int property_getter = 0x0800e18c;
    public void property_getter(InterruptHandler handler) throws Exception
    {
        call(this::property_getter, handler);
    }

    // function: Function(address=134275496, size=56, name='property_make_new', path='build/py/objproperty.o', has_indirect=False)
    abstract protected void property_make_new(int offset) throws Exception;
    public static final int property_make_new = 0x0800e1a8;
    public void property_make_new(InterruptHandler handler) throws Exception
    {
        call(this::property_make_new, handler);
    }

    // function: Function(address=134275552, size=4, name='mp_obj_property_get', path='build/py/objproperty.o', has_indirect=False)
    abstract protected void mp_obj_property_get(int offset) throws Exception;
    public static final int mp_obj_property_get = 0x0800e1e0;
    public void mp_obj_property_get(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_property_get, handler);
    }

    // function: Function(address=134275556, size=24, name='none_print', path='build/py/objnone.o', has_indirect=False)
    abstract protected void none_print(int offset) throws Exception;
    public static final int none_print = 0x0800e1e4;
    public void none_print(InterruptHandler handler) throws Exception
    {
        call(this::none_print, handler);
    }

    // function: Function(address=134275580, size=72, name='namedtuple_asdict', path='build/py/objnamedtuple.o', has_indirect=False)
    abstract protected void namedtuple_asdict(int offset) throws Exception;
    public static final int namedtuple_asdict = 0x0800e1fc;
    public void namedtuple_asdict(InterruptHandler handler) throws Exception
    {
        call(this::namedtuple_asdict, handler);
    }

    // function: Function(address=134275652, size=36, name='namedtuple_print', path='build/py/objnamedtuple.o', has_indirect=True)
    abstract protected void namedtuple_print(int offset) throws Exception;
    public static final int namedtuple_print = 0x0800e244;
    public void namedtuple_print(InterruptHandler handler) throws Exception
    {
        call(this::namedtuple_print, handler);
    }

    // function: Function(address=134275688, size=32, name='mp_obj_namedtuple_find_field', path='build/py/objnamedtuple.o', has_indirect=False)
    abstract protected void mp_obj_namedtuple_find_field(int offset) throws Exception;
    public static final int mp_obj_namedtuple_find_field = 0x0800e268;
    public void mp_obj_namedtuple_find_field(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_namedtuple_find_field, handler);
    }

    // function: Function(address=134275720, size=64, name='namedtuple_attr', path='build/py/objnamedtuple.o', has_indirect=True)
    abstract protected void namedtuple_attr(int offset) throws Exception;
    public static final int namedtuple_attr = 0x0800e288;
    public void namedtuple_attr(InterruptHandler handler) throws Exception
    {
        call(this::namedtuple_attr, handler);
    }

    // function: Function(address=134275784, size=176, name='namedtuple_make_new', path='build/py/objnamedtuple.o', has_indirect=True)
    abstract protected void namedtuple_make_new(int offset) throws Exception;
    public static final int namedtuple_make_new = 0x0800e2c8;
    public void namedtuple_make_new(InterruptHandler handler) throws Exception
    {
        call(this::namedtuple_make_new, handler);
    }

    // function: Function(address=134275960, size=56, name='mp_obj_new_namedtuple_base', path='build/py/objnamedtuple.o', has_indirect=False)
    abstract protected void mp_obj_new_namedtuple_base(int offset) throws Exception;
    public static final int mp_obj_new_namedtuple_base = 0x0800e378;
    public void mp_obj_new_namedtuple_base(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_new_namedtuple_base, handler);
    }

    // function: Function(address=134276016, size=144, name='new_namedtuple_type', path='build/py/objnamedtuple.o', has_indirect=False)
    abstract protected void new_namedtuple_type(int offset) throws Exception;
    public static final int new_namedtuple_type = 0x0800e3b0;
    public void new_namedtuple_type(InterruptHandler handler) throws Exception
    {
        call(this::new_namedtuple_type, handler);
    }

    // function: Function(address=134276160, size=50, name='range_it_iternext', path='build/py/objrange.o', has_indirect=False)
    abstract protected void range_it_iternext(int offset) throws Exception;
    public static final int range_it_iternext = 0x0800e440;
    public void range_it_iternext(InterruptHandler handler) throws Exception
    {
        call(this::range_it_iternext, handler);
    }

    // function: Function(address=134276210, size=32, name='range_len', path='build/py/objrange.o', has_indirect=False)
    abstract protected void range_len(int offset) throws Exception;
    public static final int range_len = 0x0800e472;
    public void range_len(InterruptHandler handler) throws Exception
    {
        call(this::range_len, handler);
    }

    // function: Function(address=134276244, size=52, name='range_unary_op', path='build/py/objrange.o', has_indirect=False)
    abstract protected void range_unary_op(int offset) throws Exception;
    public static final int range_unary_op = 0x0800e494;
    public void range_unary_op(InterruptHandler handler) throws Exception
    {
        call(this::range_unary_op, handler);
    }

    // function: Function(address=134276296, size=24, name='range_getiter', path='build/py/objrange.o', has_indirect=False)
    abstract protected void range_getiter(int offset) throws Exception;
    public static final int range_getiter = 0x0800e4c8;
    public void range_getiter(InterruptHandler handler) throws Exception
    {
        call(this::range_getiter, handler);
    }

    // function: Function(address=134276320, size=132, name='range_subscr', path='build/py/objrange.o', has_indirect=False)
    abstract protected void range_subscr(int offset) throws Exception;
    public static final int range_subscr = 0x0800e4e0;
    public void range_subscr(InterruptHandler handler) throws Exception
    {
        call(this::range_subscr, handler);
    }

    // function: Function(address=134276452, size=104, name='range_make_new', path='build/py/objrange.o', has_indirect=False)
    abstract protected void range_make_new(int offset) throws Exception;
    public static final int range_make_new = 0x0800e564;
    public void range_make_new(InterruptHandler handler) throws Exception
    {
        call(this::range_make_new, handler);
    }

    // function: Function(address=134276556, size=56, name='range_print', path='build/py/objrange.o', has_indirect=False)
    abstract protected void range_print(int offset) throws Exception;
    public static final int range_print = 0x0800e5cc;
    public void range_print(InterruptHandler handler) throws Exception
    {
        call(this::range_print, handler);
    }

    // function: Function(address=134276612, size=96, name='range_binary_op', path='build/py/objrange.o', has_indirect=False)
    abstract protected void range_binary_op(int offset) throws Exception;
    public static final int range_binary_op = 0x0800e604;
    public void range_binary_op(InterruptHandler handler) throws Exception
    {
        call(this::range_binary_op, handler);
    }

    // function: Function(address=134276708, size=52, name='range_attr', path='build/py/objrange.o', has_indirect=False)
    abstract protected void range_attr(int offset) throws Exception;
    public static final int range_attr = 0x0800e664;
    public void range_attr(InterruptHandler handler) throws Exception
    {
        call(this::range_attr, handler);
    }

    // function: Function(address=134276760, size=30, name='reversed_iternext', path='build/py/objreversed.o', has_indirect=False)
    abstract protected void reversed_iternext(int offset) throws Exception;
    public static final int reversed_iternext = 0x0800e698;
    public void reversed_iternext(InterruptHandler handler) throws Exception
    {
        call(this::reversed_iternext, handler);
    }

    // function: Function(address=134276790, size=84, name='reversed_make_new', path='build/py/objreversed.o', has_indirect=False)
    abstract protected void reversed_make_new(int offset) throws Exception;
    public static final int reversed_make_new = 0x0800e6b6;
    public void reversed_make_new(InterruptHandler handler) throws Exception
    {
        call(this::reversed_make_new, handler);
    }

    // function: Function(address=134276876, size=36, name='is_set_or_frozenset', path='build/py/objset.o', has_indirect=False)
    abstract protected void is_set_or_frozenset(int offset) throws Exception;
    public static final int is_set_or_frozenset = 0x0800e70c;
    public void is_set_or_frozenset(InterruptHandler handler) throws Exception
    {
        call(this::is_set_or_frozenset, handler);
    }

    // function: Function(address=134276912, size=28, name='set_getiter', path='build/py/objset.o', has_indirect=False)
    abstract protected void set_getiter(int offset) throws Exception;
    public static final int set_getiter = 0x0800e730;
    public void set_getiter(InterruptHandler handler) throws Exception
    {
        call(this::set_getiter, handler);
    }

    // function: Function(address=134276940, size=20, name='text_set_add', path='build/py/objset.o', has_indirect=False)
    abstract protected void text_set_add(int offset) throws Exception;
    public static final int text_set_add = 0x0800e74c;
    public void text_set_add(InterruptHandler handler) throws Exception
    {
        call(this::text_set_add, handler);
    }

    // function: Function(address=134276960, size=20, name='set_discard', path='build/py/objset.o', has_indirect=False)
    abstract protected void set_discard(int offset) throws Exception;
    public static final int set_discard = 0x0800e760;
    public void set_discard(InterruptHandler handler) throws Exception
    {
        call(this::set_discard, handler);
    }

    // function: Function(address=134276980, size=38, name='set_update_int', path='build/py/objset.o', has_indirect=False)
    abstract protected void set_update_int(int offset) throws Exception;
    public static final int set_update_int = 0x0800e774;
    public void set_update_int(InterruptHandler handler) throws Exception
    {
        call(this::set_update_int, handler);
    }

    // function: Function(address=134277020, size=36, name='set_update', path='build/py/objset.o', has_indirect=False)
    abstract protected void set_update(int offset) throws Exception;
    public static final int set_update = 0x0800e79c;
    public void set_update(InterruptHandler handler) throws Exception
    {
        call(this::set_update, handler);
    }

    // function: Function(address=134277056, size=44, name='set_symmetric_difference_update', path='build/py/objset.o', has_indirect=False)
    abstract protected void set_symmetric_difference_update(int offset) throws Exception;
    public static final int set_symmetric_difference_update = 0x0800e7c0;
    public void set_symmetric_difference_update(InterruptHandler handler) throws Exception
    {
        call(this::set_symmetric_difference_update, handler);
    }

    // function: Function(address=134277100, size=60, name='set_isdisjoint', path='build/py/objset.o', has_indirect=False)
    abstract protected void set_isdisjoint(int offset) throws Exception;
    public static final int set_isdisjoint = 0x0800e7ec;
    public void set_isdisjoint(InterruptHandler handler) throws Exception
    {
        call(this::set_isdisjoint, handler);
    }

    // function: Function(address=134277160, size=42, name='set_copy', path='build/py/objset.o', has_indirect=False)
    abstract protected void set_copy(int offset) throws Exception;
    public static final int set_copy = 0x0800e828;
    public void set_copy(InterruptHandler handler) throws Exception
    {
        call(this::set_copy, handler);
    }

    // function: Function(address=134277202, size=20, name='set_union', path='build/py/objset.o', has_indirect=False)
    abstract protected void set_union(int offset) throws Exception;
    public static final int set_union = 0x0800e852;
    public void set_union(InterruptHandler handler) throws Exception
    {
        call(this::set_union, handler);
    }

    // function: Function(address=134277222, size=20, name='set_symmetric_difference', path='build/py/objset.o', has_indirect=False)
    abstract protected void set_symmetric_difference(int offset) throws Exception;
    public static final int set_symmetric_difference = 0x0800e866;
    public void set_symmetric_difference(InterruptHandler handler) throws Exception
    {
        call(this::set_symmetric_difference, handler);
    }

    // function: Function(address=134277244, size=16, name='set_clear', path='build/py/objset.o', has_indirect=False)
    abstract protected void set_clear(int offset) throws Exception;
    public static final int set_clear = 0x0800e87c;
    public void set_clear(InterruptHandler handler) throws Exception
    {
        call(this::set_clear, handler);
    }

    // function: Function(address=134277260, size=80, name='set_diff_int', path='build/py/objset.o', has_indirect=False)
    abstract protected void set_diff_int(int offset) throws Exception;
    public static final int set_diff_int = 0x0800e88c;
    public void set_diff_int(InterruptHandler handler) throws Exception
    {
        call(this::set_diff_int, handler);
    }

    // function: Function(address=134277340, size=16, name='set_diff_update', path='build/py/objset.o', has_indirect=False)
    abstract protected void set_diff_update(int offset) throws Exception;
    public static final int set_diff_update = 0x0800e8dc;
    public void set_diff_update(InterruptHandler handler) throws Exception
    {
        call(this::set_diff_update, handler);
    }

    // function: Function(address=134277356, size=10, name='set_diff', path='build/py/objset.o', has_indirect=False)
    abstract protected void set_diff(int offset) throws Exception;
    public static final int set_diff = 0x0800e8ec;
    public void set_diff(InterruptHandler handler) throws Exception
    {
        call(this::set_diff, handler);
    }

    // function: Function(address=134277368, size=180, name='set_print', path='build/py/objset.o', has_indirect=False)
    abstract protected void set_print(int offset) throws Exception;
    public static final int set_print = 0x0800e8f8;
    public void set_print(InterruptHandler handler) throws Exception
    {
        call(this::set_print, handler);
    }

    // function: Function(address=134277548, size=40, name='set_remove', path='build/py/objset.o', has_indirect=False)
    abstract protected void set_remove(int offset) throws Exception;
    public static final int set_remove = 0x0800e9ac;
    public void set_remove(InterruptHandler handler) throws Exception
    {
        call(this::set_remove, handler);
    }

    // function: Function(address=134277588, size=32, name='text_set_pop', path='build/py/objset.o', has_indirect=False)
    abstract protected void text_set_pop(int offset) throws Exception;
    public static final int text_set_pop = 0x0800e9d4;
    public void text_set_pop(InterruptHandler handler) throws Exception
    {
        call(this::text_set_pop, handler);
    }

    // function: Function(address=134277620, size=42, name='set_it_iternext', path='build/py/objset.o', has_indirect=True)
    abstract protected void set_it_iternext(int offset) throws Exception;
    public static final int set_it_iternext = 0x0800e9f4;
    public void set_it_iternext(InterruptHandler handler) throws Exception
    {
        call(this::set_it_iternext, handler);
    }

    // function: Function(address=134277664, size=116, name='set_unary_op', path='build/py/objset.o', has_indirect=False)
    abstract protected void set_unary_op(int offset) throws Exception;
    public static final int set_unary_op = 0x0800ea20;
    public void set_unary_op(InterruptHandler handler) throws Exception
    {
        call(this::set_unary_op, handler);
    }

    // function: Function(address=134277780, size=56, name='mp_obj_new_set', path='build/py/objset.o', has_indirect=False)
    abstract protected void mp_obj_new_set(int offset) throws Exception;
    public static final int mp_obj_new_set = 0x0800ea94;
    public void mp_obj_new_set(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_new_set, handler);
    }

    // function: Function(address=134277836, size=100, name='set_intersect_int_part_4', path='build/py/objset.o', has_indirect=False)
    abstract protected void set_intersect_int_part_4(int offset) throws Exception;
    public static final int set_intersect_int_part_4 = 0x0800eacc;
    public void set_intersect_int_part_4(InterruptHandler handler) throws Exception
    {
        call(this::set_intersect_int_part_4, handler);
    }

    // function: Function(address=134277936, size=24, name='set_intersect_update', path='build/py/objset.o', has_indirect=False)
    abstract protected void set_intersect_update(int offset) throws Exception;
    public static final int set_intersect_update = 0x0800eb30;
    public void set_intersect_update(InterruptHandler handler) throws Exception
    {
        call(this::set_intersect_update, handler);
    }

    // function: Function(address=134277960, size=20, name='set_intersect', path='build/py/objset.o', has_indirect=False)
    abstract protected void set_intersect(int offset) throws Exception;
    public static final int set_intersect = 0x0800eb48;
    public void set_intersect(InterruptHandler handler) throws Exception
    {
        call(this::set_intersect, handler);
    }

    // function: Function(address=134277980, size=12, name='mp_obj_set_store', path='build/py/objset.o', has_indirect=False)
    abstract protected void mp_obj_set_store(int offset) throws Exception;
    public static final int mp_obj_set_store = 0x0800eb5c;
    public void mp_obj_set_store(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_set_store, handler);
    }

    // function: Function(address=134277992, size=82, name='set_make_new', path='build/py/objset.o', has_indirect=False)
    abstract protected void set_make_new(int offset) throws Exception;
    public static final int set_make_new = 0x0800eb68;
    public void set_make_new(InterruptHandler handler) throws Exception
    {
        call(this::set_make_new, handler);
    }

    // function: Function(address=134278076, size=180, name='set_issubset_internal', path='build/py/objset.o', has_indirect=False)
    abstract protected void set_issubset_internal(int offset) throws Exception;
    public static final int set_issubset_internal = 0x0800ebbc;
    public void set_issubset_internal(InterruptHandler handler) throws Exception
    {
        call(this::set_issubset_internal, handler);
    }

    // function: Function(address=134278256, size=16, name='set_issuperset', path='build/py/objset.o', has_indirect=False)
    abstract protected void set_issuperset(int offset) throws Exception;
    public static final int set_issuperset = 0x0800ec70;
    public void set_issuperset(InterruptHandler handler) throws Exception
    {
        call(this::set_issuperset, handler);
    }

    // function: Function(address=134278272, size=10, name='set_issubset', path='build/py/objset.o', has_indirect=False)
    abstract protected void set_issubset(int offset) throws Exception;
    public static final int set_issubset = 0x0800ec80;
    public void set_issubset(InterruptHandler handler) throws Exception
    {
        call(this::set_issubset, handler);
    }

    // function: Function(address=134278284, size=300, name='set_binary_op', path='build/py/objset.o', has_indirect=False)
    abstract protected void set_binary_op(int offset) throws Exception;
    public static final int set_binary_op = 0x0800ec8c;
    public void set_binary_op(InterruptHandler handler) throws Exception
    {
        call(this::set_binary_op, handler);
    }

    // function: Function(address=134278584, size=16, name='singleton_print', path='build/py/objsingleton.o', has_indirect=False)
    abstract protected void singleton_print(int offset) throws Exception;
    public static final int singleton_print = 0x0800edb8;
    public void singleton_print(InterruptHandler handler) throws Exception
    {
        call(this::singleton_print, handler);
    }

    // function: Function(address=134278600, size=84, name='slice_print', path='build/py/objslice.o', has_indirect=False)
    abstract protected void slice_print(int offset) throws Exception;
    public static final int slice_print = 0x0800edc8;
    public void slice_print(InterruptHandler handler) throws Exception
    {
        call(this::slice_print, handler);
    }

    // function: Function(address=134278684, size=44, name='slice_attr', path='build/py/objslice.o', has_indirect=False)
    abstract protected void slice_attr(int offset) throws Exception;
    public static final int slice_attr = 0x0800ee1c;
    public void slice_attr(InterruptHandler handler) throws Exception
    {
        call(this::slice_attr, handler);
    }

    // function: Function(address=134278728, size=32, name='mp_obj_new_slice', path='build/py/objslice.o', has_indirect=False)
    abstract protected void mp_obj_new_slice(int offset) throws Exception;
    public static final int mp_obj_new_slice = 0x0800ee48;
    public void mp_obj_new_slice(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_new_slice, handler);
    }

    // function: Function(address=134278760, size=16, name='mp_obj_slice_get', path='build/py/objslice.o', has_indirect=False)
    abstract protected void mp_obj_slice_get(int offset) throws Exception;
    public static final int mp_obj_slice_get = 0x0800ee68;
    public void mp_obj_slice_get(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_slice_get, handler);
    }

    // function: Function(address=134278776, size=56, name='arg_looks_integer', path='build/py/objstr.o', has_indirect=False)
    abstract protected void arg_looks_integer(int offset) throws Exception;
    public static final int arg_looks_integer = 0x0800ee78;
    public void arg_looks_integer(InterruptHandler handler) throws Exception
    {
        call(this::arg_looks_integer, handler);
    }

    // function: Function(address=134278832, size=40, name='arg_looks_numeric', path='build/py/objstr.o', has_indirect=False)
    abstract protected void arg_looks_numeric(int offset) throws Exception;
    public static final int arg_looks_numeric = 0x0800eeb0;
    public void arg_looks_numeric(InterruptHandler handler) throws Exception
    {
        call(this::arg_looks_numeric, handler);
    }

    // function: Function(address=134278872, size=28, name='mp_obj_new_bytes_iterator', path='build/py/objstr.o', has_indirect=False)
    abstract protected void mp_obj_new_bytes_iterator(int offset) throws Exception;
    public static final int mp_obj_new_bytes_iterator = 0x0800eed8;
    public void mp_obj_new_bytes_iterator(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_new_bytes_iterator, handler);
    }

    // function: Function(address=134278900, size=56, name='bytes_it_iternext', path='build/py/objstr.o', has_indirect=True)
    abstract protected void bytes_it_iternext(int offset) throws Exception;
    public static final int bytes_it_iternext = 0x0800eef4;
    public void bytes_it_iternext(InterruptHandler handler) throws Exception
    {
        call(this::bytes_it_iternext, handler);
    }

    // function: Function(address=134278956, size=40, name='unlikely_bad_implicit_conversion', path='build/py/objstr.o', has_indirect=False)
    abstract protected void unlikely_bad_implicit_conversion(int offset) throws Exception;
    public static final int unlikely_bad_implicit_conversion = 0x0800ef2c;
    public void unlikely_bad_implicit_conversion(InterruptHandler handler) throws Exception
    {
        call(this::unlikely_bad_implicit_conversion, handler);
    }

    // function: Function(address=134278996, size=232, name='str_count', path='build/py/objstr.o', has_indirect=False)
    abstract protected void str_count(int offset) throws Exception;
    public static final int str_count = 0x0800ef54;
    public void str_count(InterruptHandler handler) throws Exception
    {
        call(this::str_count, handler);
    }

    // function: Function(address=134279228, size=132, name='str_uni_istype', path='build/py/objstr.o', has_indirect=False)
    abstract protected void str_uni_istype(int offset) throws Exception;
    public static final int str_uni_istype = 0x0800f03c;
    public void str_uni_istype(InterruptHandler handler) throws Exception
    {
        call(this::str_uni_istype, handler);
    }

    // function: Function(address=134279360, size=16, name='str_isspace', path='build/py/objstr.o', has_indirect=False)
    abstract protected void str_isspace(int offset) throws Exception;
    public static final int str_isspace = 0x0800f0c0;
    public void str_isspace(InterruptHandler handler) throws Exception
    {
        call(this::str_isspace, handler);
    }

    // function: Function(address=134279376, size=16, name='str_isalpha', path='build/py/objstr.o', has_indirect=False)
    abstract protected void str_isalpha(int offset) throws Exception;
    public static final int str_isalpha = 0x0800f0d0;
    public void str_isalpha(InterruptHandler handler) throws Exception
    {
        call(this::str_isalpha, handler);
    }

    // function: Function(address=134279392, size=16, name='str_isdigit', path='build/py/objstr.o', has_indirect=False)
    abstract protected void str_isdigit(int offset) throws Exception;
    public static final int str_isdigit = 0x0800f0e0;
    public void str_isdigit(InterruptHandler handler) throws Exception
    {
        call(this::str_isdigit, handler);
    }

    // function: Function(address=134279408, size=16, name='str_isupper', path='build/py/objstr.o', has_indirect=False)
    abstract protected void str_isupper(int offset) throws Exception;
    public static final int str_isupper = 0x0800f0f0;
    public void str_isupper(InterruptHandler handler) throws Exception
    {
        call(this::str_isupper, handler);
    }

    // function: Function(address=134279424, size=16, name='str_islower', path='build/py/objstr.o', has_indirect=False)
    abstract protected void str_islower(int offset) throws Exception;
    public static final int str_islower = 0x0800f100;
    public void str_islower(InterruptHandler handler) throws Exception
    {
        call(this::str_islower, handler);
    }

    // function: Function(address=134279440, size=48, name='str_to_int', path='build/py/objstr.o', has_indirect=False)
    abstract protected void str_to_int(int offset) throws Exception;
    public static final int str_to_int = 0x0800f110;
    public void str_to_int(InterruptHandler handler) throws Exception
    {
        call(this::str_to_int, handler);
    }

    // function: Function(address=134279488, size=60, name='mp_obj_str_get_buffer', path='build/py/objstr.o', has_indirect=False)
    abstract protected void mp_obj_str_get_buffer(int offset) throws Exception;
    public static final int mp_obj_str_get_buffer = 0x0800f140;
    public void mp_obj_str_get_buffer(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_str_get_buffer, handler);
    }

    // function: Function(address=134279548, size=200, name='mp_str_print_quoted', path='build/py/objstr.o', has_indirect=False)
    abstract protected void mp_str_print_quoted(int offset) throws Exception;
    public static final int mp_str_print_quoted = 0x0800f17c;
    public void mp_str_print_quoted(InterruptHandler handler) throws Exception
    {
        call(this::mp_str_print_quoted, handler);
    }

    // function: Function(address=134279748, size=116, name='mp_str_print_json', path='build/py/objstr.o', has_indirect=False)
    abstract protected void mp_str_print_json(int offset) throws Exception;
    public static final int mp_str_print_json = 0x0800f244;
    public void mp_str_print_json(InterruptHandler handler) throws Exception
    {
        call(this::mp_str_print_json, handler);
    }

    // function: Function(address=134279864, size=96, name='str_print', path='build/py/objstr.o', has_indirect=False)
    abstract protected void str_print(int offset) throws Exception;
    public static final int str_print = 0x0800f2b8;
    public void str_print(InterruptHandler handler) throws Exception
    {
        call(this::str_print, handler);
    }

    // function: Function(address=134279960, size=62, name='find_subbytes', path='build/py/objstr.o', has_indirect=False)
    abstract protected void find_subbytes(int offset) throws Exception;
    public static final int find_subbytes = 0x0800f318;
    public void find_subbytes(InterruptHandler handler) throws Exception
    {
        call(this::find_subbytes, handler);
    }

    // function: Function(address=134280024, size=248, name='str_finder', path='build/py/objstr.o', has_indirect=False)
    abstract protected void str_finder(int offset) throws Exception;
    public static final int str_finder = 0x0800f358;
    public void str_finder(InterruptHandler handler) throws Exception
    {
        call(this::str_finder, handler);
    }

    // function: Function(address=134280272, size=12, name='str_find', path='build/py/objstr.o', has_indirect=False)
    abstract protected void str_find(int offset) throws Exception;
    public static final int str_find = 0x0800f450;
    public void str_find(InterruptHandler handler) throws Exception
    {
        call(this::str_find, handler);
    }

    // function: Function(address=134280284, size=14, name='str_rfind', path='build/py/objstr.o', has_indirect=False)
    abstract protected void str_rfind(int offset) throws Exception;
    public static final int str_rfind = 0x0800f45c;
    public void str_rfind(InterruptHandler handler) throws Exception
    {
        call(this::str_rfind, handler);
    }

    // function: Function(address=134280298, size=12, name='str_index', path='build/py/objstr.o', has_indirect=False)
    abstract protected void str_index(int offset) throws Exception;
    public static final int str_index = 0x0800f46a;
    public void str_index(InterruptHandler handler) throws Exception
    {
        call(this::str_index, handler);
    }

    // function: Function(address=134280310, size=14, name='str_rindex', path='build/py/objstr.o', has_indirect=False)
    abstract protected void str_rindex(int offset) throws Exception;
    public static final int str_rindex = 0x0800f476;
    public void str_rindex(InterruptHandler handler) throws Exception
    {
        call(this::str_rindex, handler);
    }

    // function: Function(address=134280324, size=60, name='mp_obj_new_str_copy', path='build/py/objstr.o', has_indirect=False)
    abstract protected void mp_obj_new_str_copy(int offset) throws Exception;
    public static final int mp_obj_new_str_copy = 0x0800f484;
    public void mp_obj_new_str_copy(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_new_str_copy, handler);
    }

    // function: Function(address=134280384, size=14, name='mp_obj_new_str_via_qstr', path='build/py/objstr.o', has_indirect=False)
    abstract protected void mp_obj_new_str_via_qstr(int offset) throws Exception;
    public static final int mp_obj_new_str_via_qstr = 0x0800f4c0;
    public void mp_obj_new_str_via_qstr(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_new_str_via_qstr, handler);
    }

    // function: Function(address=134280400, size=108, name='mp_obj_new_str_from_vstr', path='build/py/objstr.o', has_indirect=False)
    abstract protected void mp_obj_new_str_from_vstr(int offset) throws Exception;
    public static final int mp_obj_new_str_from_vstr = 0x0800f4d0;
    public void mp_obj_new_str_from_vstr(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_new_str_from_vstr, handler);
    }

    // function: Function(address=134280508, size=268, name='str_join', path='build/py/objstr.o', has_indirect=False)
    abstract protected void str_join(int offset) throws Exception;
    public static final int str_join = 0x0800f53c;
    public void str_join(InterruptHandler handler) throws Exception
    {
        call(this::str_join, handler);
    }

    // function: Function(address=134280776, size=106, name='str_center', path='build/py/objstr.o', has_indirect=False)
    abstract protected void str_center(int offset) throws Exception;
    public static final int str_center = 0x0800f648;
    public void str_center(InterruptHandler handler) throws Exception
    {
        call(this::str_center, handler);
    }

    // function: Function(address=134280882, size=390, name='str_replace', path='build/py/objstr.o', has_indirect=False)
    abstract protected void str_replace(int offset) throws Exception;
    public static final int str_replace = 0x0800f6b2;
    public void str_replace(InterruptHandler handler) throws Exception
    {
        call(this::str_replace, handler);
    }

    // function: Function(address=134281272, size=82, name='str_caseconv', path='build/py/objstr.o', has_indirect=False)
    abstract protected void str_caseconv(int offset) throws Exception;
    public static final int str_caseconv = 0x0800f838;
    public void str_caseconv(InterruptHandler handler) throws Exception
    {
        call(this::str_caseconv, handler);
    }

    // function: Function(address=134281356, size=16, name='str_lower', path='build/py/objstr.o', has_indirect=False)
    abstract protected void str_lower(int offset) throws Exception;
    public static final int str_lower = 0x0800f88c;
    public void str_lower(InterruptHandler handler) throws Exception
    {
        call(this::str_lower, handler);
    }

    // function: Function(address=134281372, size=16, name='str_upper', path='build/py/objstr.o', has_indirect=False)
    abstract protected void str_upper(int offset) throws Exception;
    public static final int str_upper = 0x0800f89c;
    public void str_upper(InterruptHandler handler) throws Exception
    {
        call(this::str_upper, handler);
    }

    // function: Function(address=134281388, size=40, name='mp_obj_new_str', path='build/py/objstr.o', has_indirect=False)
    abstract protected void mp_obj_new_str(int offset) throws Exception;
    public static final int mp_obj_new_str = 0x0800f8ac;
    public void mp_obj_new_str(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_new_str, handler);
    }

    // function: Function(address=134281428, size=204, name='mp_obj_str_make_new', path='build/py/objstr.o', has_indirect=False)
    abstract protected void mp_obj_str_make_new(int offset) throws Exception;
    public static final int mp_obj_str_make_new = 0x0800f8d4;
    public void mp_obj_str_make_new(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_str_make_new, handler);
    }

    // function: Function(address=134281632, size=40, name='bytes_decode', path='build/py/objstr.o', has_indirect=False)
    abstract protected void bytes_decode(int offset) throws Exception;
    public static final int bytes_decode = 0x0800f9a0;
    public void bytes_decode(InterruptHandler handler) throws Exception
    {
        call(this::bytes_decode, handler);
    }

    // function: Function(address=134281672, size=20, name='mp_obj_new_bytes', path='build/py/objstr.o', has_indirect=False)
    abstract protected void mp_obj_new_bytes(int offset) throws Exception;
    public static final int mp_obj_new_bytes = 0x0800f9c8;
    public void mp_obj_new_bytes(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_new_bytes, handler);
    }

    // function: Function(address=134281692, size=280, name='bytes_make_new_part_4', path='build/py/objstr.o', has_indirect=False)
    abstract protected void bytes_make_new_part_4(int offset) throws Exception;
    public static final int bytes_make_new_part_4 = 0x0800f9dc;
    public void bytes_make_new_part_4(InterruptHandler handler) throws Exception
    {
        call(this::bytes_make_new_part_4, handler);
    }

    // function: Function(address=134281972, size=32, name='bytes_make_new', path='build/py/objstr.o', has_indirect=False)
    abstract protected void bytes_make_new(int offset) throws Exception;
    public static final int bytes_make_new = 0x0800faf4;
    public void bytes_make_new(InterruptHandler handler) throws Exception
    {
        call(this::bytes_make_new, handler);
    }

    // function: Function(address=134282004, size=44, name='str_encode', path='build/py/objstr.o', has_indirect=False)
    abstract protected void str_encode(int offset) throws Exception;
    public static final int str_encode = 0x0800fb14;
    public void str_encode(InterruptHandler handler) throws Exception
    {
        call(this::str_encode, handler);
    }

    // function: Function(address=134282048, size=32, name='mp_obj_new_str_of_type', path='build/py/objstr.o', has_indirect=False)
    abstract protected void mp_obj_new_str_of_type(int offset) throws Exception;
    public static final int mp_obj_new_str_of_type = 0x0800fb40;
    public void mp_obj_new_str_of_type(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_new_str_of_type, handler);
    }

    // function: Function(address=134282080, size=160, name='str_splitlines', path='build/py/objstr.o', has_indirect=False)
    abstract protected void str_splitlines(int offset) throws Exception;
    public static final int str_splitlines = 0x0800fb60;
    public void str_splitlines(InterruptHandler handler) throws Exception
    {
        call(this::str_splitlines, handler);
    }

    // function: Function(address=134282240, size=292, name='str_uni_strip', path='build/py/objstr.o', has_indirect=False)
    abstract protected void str_uni_strip(int offset) throws Exception;
    public static final int str_uni_strip = 0x0800fc00;
    public void str_uni_strip(InterruptHandler handler) throws Exception
    {
        call(this::str_uni_strip, handler);
    }

    // function: Function(address=134282532, size=14, name='str_strip', path='build/py/objstr.o', has_indirect=False)
    abstract protected void str_strip(int offset) throws Exception;
    public static final int str_strip = 0x0800fd24;
    public void str_strip(InterruptHandler handler) throws Exception
    {
        call(this::str_strip, handler);
    }

    // function: Function(address=134282546, size=14, name='str_lstrip', path='build/py/objstr.o', has_indirect=False)
    abstract protected void str_lstrip(int offset) throws Exception;
    public static final int str_lstrip = 0x0800fd32;
    public void str_lstrip(InterruptHandler handler) throws Exception
    {
        call(this::str_lstrip, handler);
    }

    // function: Function(address=134282560, size=14, name='str_rstrip', path='build/py/objstr.o', has_indirect=False)
    abstract protected void str_rstrip(int offset) throws Exception;
    public static final int str_rstrip = 0x0800fd40;
    public void str_rstrip(InterruptHandler handler) throws Exception
    {
        call(this::str_rstrip, handler);
    }

    // function: Function(address=134282576, size=204, name='str_partitioner', path='build/py/objstr.o', has_indirect=False)
    abstract protected void str_partitioner(int offset) throws Exception;
    public static final int str_partitioner = 0x0800fd50;
    public void str_partitioner(InterruptHandler handler) throws Exception
    {
        call(this::str_partitioner, handler);
    }

    // function: Function(address=134282780, size=10, name='str_partition', path='build/py/objstr.o', has_indirect=False)
    abstract protected void str_partition(int offset) throws Exception;
    public static final int str_partition = 0x0800fe1c;
    public void str_partition(InterruptHandler handler) throws Exception
    {
        call(this::str_partition, handler);
    }

    // function: Function(address=134282790, size=12, name='str_rpartition', path='build/py/objstr.o', has_indirect=False)
    abstract protected void str_rpartition(int offset) throws Exception;
    public static final int str_rpartition = 0x0800fe26;
    public void str_rpartition(InterruptHandler handler) throws Exception
    {
        call(this::str_rpartition, handler);
    }

    // function: Function(address=134282804, size=132, name='bytes_subscr', path='build/py/objstr.o', has_indirect=False)
    abstract protected void bytes_subscr(int offset) throws Exception;
    public static final int bytes_subscr = 0x0800fe34;
    public void bytes_subscr(InterruptHandler handler) throws Exception
    {
        call(this::bytes_subscr, handler);
    }

    // function: Function(address=134282936, size=144, name='mp_obj_str_equal', path='build/py/objstr.o', has_indirect=False)
    abstract protected void mp_obj_str_equal(int offset) throws Exception;
    public static final int mp_obj_str_equal = 0x0800feb8;
    public void mp_obj_str_equal(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_str_equal, handler);
    }

    // function: Function(address=134283080, size=44, name='mp_obj_str_get_qstr', path='build/py/objstr.o', has_indirect=False)
    abstract protected void mp_obj_str_get_qstr(int offset) throws Exception;
    public static final int mp_obj_str_get_qstr = 0x0800ff48;
    public void mp_obj_str_get_qstr(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_str_get_qstr, handler);
    }

    // function: Function(address=134283124, size=48, name='mp_obj_str_get_str', path='build/py/objstr.o', has_indirect=False)
    abstract protected void mp_obj_str_get_str(int offset) throws Exception;
    public static final int mp_obj_str_get_str = 0x0800ff74;
    public void mp_obj_str_get_str(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_str_get_str, handler);
    }

    // function: Function(address=134283172, size=56, name='mp_obj_str_get_data', path='build/py/objstr.o', has_indirect=False)
    abstract protected void mp_obj_str_get_data(int offset) throws Exception;
    public static final int mp_obj_str_get_data = 0x0800ffa4;
    public void mp_obj_str_get_data(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_str_get_data, handler);
    }

    // function: Function(address=134283228, size=1348, name='mp_obj_str_binary_op', path='build/py/objstr.o', has_indirect=True)
    abstract protected void mp_obj_str_binary_op(int offset) throws Exception;
    public static final int mp_obj_str_binary_op = 0x0800ffdc;
    public void mp_obj_str_binary_op(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_str_binary_op, handler);
    }

    // function: Function(address=134284576, size=332, name='mp_obj_str_split', path='build/py/objstr.o', has_indirect=False)
    abstract protected void mp_obj_str_split(int offset) throws Exception;
    public static final int mp_obj_str_split = 0x08010520;
    public void mp_obj_str_split(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_str_split, handler);
    }

    // function: Function(address=134284908, size=292, name='str_rsplit', path='build/py/objstr.o', has_indirect=False)
    abstract protected void str_rsplit(int offset) throws Exception;
    public static final int str_rsplit = 0x0801066c;
    public void str_rsplit(InterruptHandler handler) throws Exception
    {
        call(this::str_rsplit, handler);
    }

    // function: Function(address=134285200, size=116, name='str_startswith', path='build/py/objstr.o', has_indirect=False)
    abstract protected void str_startswith(int offset) throws Exception;
    public static final int str_startswith = 0x08010790;
    public void str_startswith(InterruptHandler handler) throws Exception
    {
        call(this::str_startswith, handler);
    }

    // function: Function(address=134285316, size=96, name='str_endswith', path='build/py/objstr.o', has_indirect=False)
    abstract protected void str_endswith(int offset) throws Exception;
    public static final int str_endswith = 0x08010804;
    public void str_endswith(InterruptHandler handler) throws Exception
    {
        call(this::str_endswith, handler);
    }

    // function: Function(address=134285412, size=1368, name='mp_obj_str_format_helper', path='build/py/objstr.o', has_indirect=False)
    abstract protected void mp_obj_str_format_helper(int offset) throws Exception;
    public static final int mp_obj_str_format_helper = 0x08010864;
    public void mp_obj_str_format_helper(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_str_format_helper, handler);
    }

    // function: Function(address=134286780, size=76, name='mp_obj_str_format', path='build/py/objstr.o', has_indirect=False)
    abstract protected void mp_obj_str_format(int offset) throws Exception;
    public static final int mp_obj_str_format = 0x08010dbc;
    public void mp_obj_str_format(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_str_format, handler);
    }

    // function: Function(address=134286856, size=16, name='mp_obj_str_intern_checked', path='build/py/objstr.o', has_indirect=False)
    abstract protected void mp_obj_str_intern_checked(int offset) throws Exception;
    public static final int mp_obj_str_intern_checked = 0x08010e08;
    public void mp_obj_str_intern_checked(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_str_intern_checked, handler);
    }

    // function: Function(address=134286872, size=28, name='mp_obj_new_str_iterator', path='build/py/objstrunicode.o', has_indirect=False)
    abstract protected void mp_obj_new_str_iterator(int offset) throws Exception;
    public static final int mp_obj_new_str_iterator = 0x08010e18;
    public void mp_obj_new_str_iterator(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_new_str_iterator, handler);
    }

    // function: Function(address=134286900, size=68, name='str_it_iternext', path='build/py/objstrunicode.o', has_indirect=True)
    abstract protected void str_it_iternext(int offset) throws Exception;
    public static final int str_it_iternext = 0x08010e34;
    public void str_it_iternext(InterruptHandler handler) throws Exception
    {
        call(this::str_it_iternext, handler);
    }

    // function: Function(address=134286968, size=76, name='uni_unary_op', path='build/py/objstrunicode.o', has_indirect=False)
    abstract protected void uni_unary_op(int offset) throws Exception;
    public static final int uni_unary_op = 0x08010e78;
    public void uni_unary_op(InterruptHandler handler) throws Exception
    {
        call(this::uni_unary_op, handler);
    }

    // function: Function(address=134287044, size=288, name='uni_print', path='build/py/objstrunicode.o', has_indirect=False)
    abstract protected void uni_print(int offset) throws Exception;
    public static final int uni_print = 0x08010ec4;
    public void uni_print(InterruptHandler handler) throws Exception
    {
        call(this::uni_print, handler);
    }

    // function: Function(address=134287332, size=196, name='str_index_to_ptr', path='build/py/objstrunicode.o', has_indirect=False)
    abstract protected void str_index_to_ptr(int offset) throws Exception;
    public static final int str_index_to_ptr = 0x08010fe4;
    public void str_index_to_ptr(InterruptHandler handler) throws Exception
    {
        call(this::str_index_to_ptr, handler);
    }

    // function: Function(address=134287528, size=220, name='str_subscr', path='build/py/objstrunicode.o', has_indirect=False)
    abstract protected void str_subscr(int offset) throws Exception;
    public static final int str_subscr = 0x080110a8;
    public void str_subscr(InterruptHandler handler) throws Exception
    {
        call(this::str_subscr, handler);
    }

    // function: Function(address=134287748, size=10, name='stringio___exit__', path='build/py/objstringio.o', has_indirect=False)
    abstract protected void stringio___exit__(int offset) throws Exception;
    public static final int stringio___exit__ = 0x08011184;
    public void stringio___exit__(InterruptHandler handler) throws Exception
    {
        call(this::stringio___exit__, handler);
    }

    // function: Function(address=134287760, size=36, name='stringio_print', path='build/py/objstringio.o', has_indirect=False)
    abstract protected void stringio_print(int offset) throws Exception;
    public static final int stringio_print = 0x08011190;
    public void stringio_print(InterruptHandler handler) throws Exception
    {
        call(this::stringio_print, handler);
    }

    // function: Function(address=134287796, size=164, name='stringio_write', path='build/py/objstringio.o', has_indirect=False)
    abstract protected void stringio_write(int offset) throws Exception;
    public static final int stringio_write = 0x080111b4;
    public void stringio_write(InterruptHandler handler) throws Exception
    {
        call(this::stringio_write, handler);
    }

    // function: Function(address=134287960, size=164, name='stringio_make_new', path='build/py/objstringio.o', has_indirect=False)
    abstract protected void stringio_make_new(int offset) throws Exception;
    public static final int stringio_make_new = 0x08011258;
    public void stringio_make_new(InterruptHandler handler) throws Exception
    {
        call(this::stringio_make_new, handler);
    }

    // function: Function(address=134288124, size=94, name='stringio_ioctl', path='build/py/objstringio.o', has_indirect=False)
    abstract protected void stringio_ioctl(int offset) throws Exception;
    public static final int stringio_ioctl = 0x080112fc;
    public void stringio_ioctl(InterruptHandler handler) throws Exception
    {
        call(this::stringio_ioctl, handler);
    }

    // function: Function(address=134288220, size=52, name='stringio_getvalue', path='build/py/objstringio.o', has_indirect=False)
    abstract protected void stringio_getvalue(int offset) throws Exception;
    public static final int stringio_getvalue = 0x0801135c;
    public void stringio_getvalue(InterruptHandler handler) throws Exception
    {
        call(this::stringio_getvalue, handler);
    }

    // function: Function(address=134288272, size=60, name='stringio_read', path='build/py/objstringio.o', has_indirect=False)
    abstract protected void stringio_read(int offset) throws Exception;
    public static final int stringio_read = 0x08011390;
    public void stringio_read(InterruptHandler handler) throws Exception
    {
        call(this::stringio_read, handler);
    }

    // function: Function(address=134288332, size=28, name='tuple_it_iternext', path='build/py/objtuple.o', has_indirect=True)
    abstract protected void tuple_it_iternext(int offset) throws Exception;
    public static final int tuple_it_iternext = 0x080113cc;
    public void tuple_it_iternext(InterruptHandler handler) throws Exception
    {
        call(this::tuple_it_iternext, handler);
    }

    // function: Function(address=134288360, size=28, name='mp_obj_tuple_getiter', path='build/py/objtuple.o', has_indirect=True)
    abstract protected void mp_obj_tuple_getiter(int offset) throws Exception;
    public static final int mp_obj_tuple_getiter = 0x080113e8;
    public void mp_obj_tuple_getiter(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_tuple_getiter, handler);
    }

    // function: Function(address=134288388, size=120, name='mp_obj_tuple_print', path='build/py/objtuple.o', has_indirect=False)
    abstract protected void mp_obj_tuple_print(int offset) throws Exception;
    public static final int mp_obj_tuple_print = 0x08011404;
    public void mp_obj_tuple_print(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_tuple_print, handler);
    }

    // function: Function(address=134288508, size=20, name='tuple_index', path='build/py/objtuple.o', has_indirect=False)
    abstract protected void tuple_index(int offset) throws Exception;
    public static final int tuple_index = 0x0801147c;
    public void tuple_index(InterruptHandler handler) throws Exception
    {
        call(this::tuple_index, handler);
    }

    // function: Function(address=134288528, size=16, name='tuple_count', path='build/py/objtuple.o', has_indirect=False)
    abstract protected void tuple_count(int offset) throws Exception;
    public static final int tuple_count = 0x08011490;
    public void tuple_count(InterruptHandler handler) throws Exception
    {
        call(this::tuple_count, handler);
    }

    // function: Function(address=134288544, size=92, name='mp_obj_tuple_unary_op', path='build/py/objtuple.o', has_indirect=True)
    abstract protected void mp_obj_tuple_unary_op(int offset) throws Exception;
    public static final int mp_obj_tuple_unary_op = 0x080114a0;
    public void mp_obj_tuple_unary_op(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_tuple_unary_op, handler);
    }

    // function: Function(address=134288636, size=60, name='mp_obj_new_tuple', path='build/py/objtuple.o', has_indirect=False)
    abstract protected void mp_obj_new_tuple(int offset) throws Exception;
    public static final int mp_obj_new_tuple = 0x080114fc;
    public void mp_obj_new_tuple(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_new_tuple, handler);
    }

    // function: Function(address=134288696, size=256, name='mp_obj_tuple_binary_op', path='build/py/objtuple.o', has_indirect=True)
    abstract protected void mp_obj_tuple_binary_op(int offset) throws Exception;
    public static final int mp_obj_tuple_binary_op = 0x08011538;
    public void mp_obj_tuple_binary_op(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_tuple_binary_op, handler);
    }

    // function: Function(address=134288952, size=116, name='mp_obj_tuple_subscr', path='build/py/objtuple.o', has_indirect=True)
    abstract protected void mp_obj_tuple_subscr(int offset) throws Exception;
    public static final int mp_obj_tuple_subscr = 0x08011638;
    public void mp_obj_tuple_subscr(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_tuple_subscr, handler);
    }

    // function: Function(address=134289068, size=140, name='mp_obj_tuple_make_new', path='build/py/objtuple.o', has_indirect=False)
    abstract protected void mp_obj_tuple_make_new(int offset) throws Exception;
    public static final int mp_obj_tuple_make_new = 0x080116ac;
    public void mp_obj_tuple_make_new(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_tuple_make_new, handler);
    }

    // function: Function(address=134289208, size=10, name='mp_obj_tuple_get', path='build/py/objtuple.o', has_indirect=False)
    abstract protected void mp_obj_tuple_get(int offset) throws Exception;
    public static final int mp_obj_tuple_get = 0x08011738;
    public void mp_obj_tuple_get(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_tuple_get, handler);
    }

    // function: Function(address=134289218, size=14, name='mp_obj_tuple_del', path='build/py/objtuple.o', has_indirect=False)
    abstract protected void mp_obj_tuple_del(int offset) throws Exception;
    public static final int mp_obj_tuple_del = 0x08011742;
    public void mp_obj_tuple_del(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_tuple_del, handler);
    }

    // function: Function(address=134289232, size=88, name='instance_count_native_bases', path='build/py/objtype.o', has_indirect=False)
    abstract protected void instance_count_native_bases(int offset) throws Exception;
    public static final int instance_count_native_bases = 0x08011750;
    public void instance_count_native_bases(InterruptHandler handler) throws Exception
    {
        call(this::instance_count_native_bases, handler);
    }

    // function: Function(address=134289320, size=44, name='native_base_init_wrapper', path='build/py/objtype.o', has_indirect=False)
    abstract protected void native_base_init_wrapper(int offset) throws Exception;
    public static final int native_base_init_wrapper = 0x080117a8;
    public void native_base_init_wrapper(InterruptHandler handler) throws Exception
    {
        call(this::native_base_init_wrapper, handler);
    }

    // function: Function(address=134289364, size=240, name='mp_obj_class_lookup', path='build/py/objtype.o', has_indirect=False)
    abstract protected void mp_obj_class_lookup(int offset) throws Exception;
    public static final int mp_obj_class_lookup = 0x080117d4;
    public void mp_obj_class_lookup(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_class_lookup, handler);
    }

    // function: Function(address=134289604, size=160, name='super_attr', path='build/py/objtype.o', has_indirect=False)
    abstract protected void super_attr(int offset) throws Exception;
    public static final int super_attr = 0x080118c4;
    public void super_attr(InterruptHandler handler) throws Exception
    {
        call(this::super_attr, handler);
    }

    // function: Function(address=134289764, size=36, name='static_class_method_make_new', path='build/py/objtype.o', has_indirect=False)
    abstract protected void static_class_method_make_new(int offset) throws Exception;
    public static final int static_class_method_make_new = 0x08011964;
    public void static_class_method_make_new(InterruptHandler handler) throws Exception
    {
        call(this::static_class_method_make_new, handler);
    }

    // function: Function(address=134289800, size=64, name='super_make_new', path='build/py/objtype.o', has_indirect=False)
    abstract protected void super_make_new(int offset) throws Exception;
    public static final int super_make_new = 0x08011988;
    public void super_make_new(InterruptHandler handler) throws Exception
    {
        call(this::super_make_new, handler);
    }

    // function: Function(address=134289864, size=16, name='type_print', path='build/py/objtype.o', has_indirect=False)
    abstract protected void type_print(int offset) throws Exception;
    public static final int type_print = 0x080119c8;
    public void type_print(InterruptHandler handler) throws Exception
    {
        call(this::type_print, handler);
    }

    // function: Function(address=134289880, size=128, name='instance_subscr', path='build/py/objtype.o', has_indirect=True)
    abstract protected void instance_subscr(int offset) throws Exception;
    public static final int instance_subscr = 0x080119d8;
    public void instance_subscr(InterruptHandler handler) throws Exception
    {
        call(this::instance_subscr, handler);
    }

    // function: Function(address=134290008, size=116, name='instance_binary_op', path='build/py/objtype.o', has_indirect=True)
    abstract protected void instance_binary_op(int offset) throws Exception;
    public static final int instance_binary_op = 0x08011a58;
    public void instance_binary_op(InterruptHandler handler) throws Exception
    {
        call(this::instance_binary_op, handler);
    }

    // function: Function(address=134290124, size=160, name='instance_unary_op', path='build/py/objtype.o', has_indirect=True)
    abstract protected void instance_unary_op(int offset) throws Exception;
    public static final int instance_unary_op = 0x08011acc;
    public void instance_unary_op(InterruptHandler handler) throws Exception
    {
        call(this::instance_unary_op, handler);
    }

    // function: Function(address=134290284, size=188, name='instance_print', path='build/py/objtype.o', has_indirect=True)
    abstract protected void instance_print(int offset) throws Exception;
    public static final int instance_print = 0x08011b6c;
    public void instance_print(InterruptHandler handler) throws Exception
    {
        call(this::instance_print, handler);
    }

    // function: Function(address=134290472, size=64, name='super_print', path='build/py/objtype.o', has_indirect=False)
    abstract protected void super_print(int offset) throws Exception;
    public static final int super_print = 0x08011c28;
    public void super_print(InterruptHandler handler) throws Exception
    {
        call(this::super_print, handler);
    }

    // function: Function(address=134290536, size=560, name='mp_obj_instance_attr', path='build/py/objtype.o', has_indirect=True)
    abstract protected void mp_obj_instance_attr(int offset) throws Exception;
    public static final int mp_obj_instance_attr = 0x08011c68;
    public void mp_obj_instance_attr(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_instance_attr, handler);
    }

    // function: Function(address=134291096, size=36, name='type_call', path='build/py/objtype.o', has_indirect=False)
    abstract protected void type_call(int offset) throws Exception;
    public static final int type_call = 0x08011e98;
    public void type_call(InterruptHandler handler) throws Exception
    {
        call(this::type_call, handler);
    }

    // function: Function(address=134291132, size=74, name='instance_get_buffer', path='build/py/objtype.o', has_indirect=True)
    abstract protected void instance_get_buffer(int offset) throws Exception;
    public static final int instance_get_buffer = 0x08011ebc;
    public void instance_get_buffer(InterruptHandler handler) throws Exception
    {
        call(this::instance_get_buffer, handler);
    }

    // function: Function(address=134291206, size=86, name='instance_getiter', path='build/py/objtype.o', has_indirect=True)
    abstract protected void instance_getiter(int offset) throws Exception;
    public static final int instance_getiter = 0x08011f06;
    public void instance_getiter(InterruptHandler handler) throws Exception
    {
        call(this::instance_getiter, handler);
    }

    // function: Function(address=134291292, size=80, name='check_for_special_accessors', path='build/py/objtype.o', has_indirect=False)
    abstract protected void check_for_special_accessors(int offset) throws Exception;
    public static final int check_for_special_accessors = 0x08011f5c;
    public void check_for_special_accessors(InterruptHandler handler) throws Exception
    {
        call(this::check_for_special_accessors, handler);
    }

    // function: Function(address=134291372, size=164, name='type_attr', path='build/py/objtype.o', has_indirect=False)
    abstract protected void type_attr(int offset) throws Exception;
    public static final int type_attr = 0x08011fac;
    public void type_attr(InterruptHandler handler) throws Exception
    {
        call(this::type_attr, handler);
    }

    // function: Function(address=134291536, size=112, name='mp_obj_instance_call', path='build/py/objtype.o', has_indirect=True)
    abstract protected void mp_obj_instance_call(int offset) throws Exception;
    public static final int mp_obj_instance_call = 0x08012050;
    public void mp_obj_instance_call(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_instance_call, handler);
    }

    // function: Function(address=134291648, size=44, name='mp_obj_new_instance', path='build/py/objtype.o', has_indirect=False)
    abstract protected void mp_obj_new_instance(int offset) throws Exception;
    public static final int mp_obj_new_instance = 0x080120c0;
    public void mp_obj_new_instance(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_new_instance, handler);
    }

    // function: Function(address=134291692, size=348, name='mp_obj_instance_make_new', path='build/py/objtype.o', has_indirect=True)
    abstract protected void mp_obj_instance_make_new(int offset) throws Exception;
    public static final int mp_obj_instance_make_new = 0x080120ec;
    public void mp_obj_instance_make_new(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_instance_make_new, handler);
    }

    // function: Function(address=134292040, size=48, name='mp_obj_instance_is_callable', path='build/py/objtype.o', has_indirect=False)
    abstract protected void mp_obj_instance_is_callable(int offset) throws Exception;
    public static final int mp_obj_instance_is_callable = 0x08012248;
    public void mp_obj_instance_is_callable(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_instance_is_callable, handler);
    }

    // function: Function(address=134292088, size=404, name='mp_obj_new_type', path='build/py/objtype.o', has_indirect=False)
    abstract protected void mp_obj_new_type(int offset) throws Exception;
    public static final int mp_obj_new_type = 0x08012278;
    public void mp_obj_new_type(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_new_type, handler);
    }

    // function: Function(address=134292492, size=64, name='type_make_new', path='build/py/objtype.o', has_indirect=False)
    abstract protected void type_make_new(int offset) throws Exception;
    public static final int type_make_new = 0x0801240c;
    public void type_make_new(InterruptHandler handler) throws Exception
    {
        call(this::type_make_new, handler);
    }

    // function: Function(address=134292556, size=32, name='mp_load_super_method', path='build/py/objtype.o', has_indirect=False)
    abstract protected void mp_load_super_method(int offset) throws Exception;
    public static final int mp_load_super_method = 0x0801244c;
    public void mp_load_super_method(InterruptHandler handler) throws Exception
    {
        call(this::mp_load_super_method, handler);
    }

    // function: Function(address=134292588, size=96, name='mp_obj_is_subclass_fast', path='build/py/objtype.o', has_indirect=False)
    abstract protected void mp_obj_is_subclass_fast(int offset) throws Exception;
    public static final int mp_obj_is_subclass_fast = 0x0801246c;
    public void mp_obj_is_subclass_fast(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_is_subclass_fast, handler);
    }

    // function: Function(address=134292684, size=120, name='mp_obj_is_subclass', path='build/py/objtype.o', has_indirect=False)
    abstract protected void mp_obj_is_subclass(int offset) throws Exception;
    public static final int mp_obj_is_subclass = 0x080124cc;
    public void mp_obj_is_subclass(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_is_subclass, handler);
    }

    // function: Function(address=134292804, size=36, name='mp_builtin_issubclass', path='build/py/objtype.o', has_indirect=False)
    abstract protected void mp_builtin_issubclass(int offset) throws Exception;
    public static final int mp_builtin_issubclass = 0x08012544;
    public void mp_builtin_issubclass(InterruptHandler handler) throws Exception
    {
        call(this::mp_builtin_issubclass, handler);
    }

    // function: Function(address=134292840, size=16, name='mp_builtin_isinstance', path='build/py/objtype.o', has_indirect=False)
    abstract protected void mp_builtin_isinstance(int offset) throws Exception;
    public static final int mp_builtin_isinstance = 0x08012568;
    public void mp_builtin_isinstance(InterruptHandler handler) throws Exception
    {
        call(this::mp_builtin_isinstance, handler);
    }

    // function: Function(address=134292856, size=26, name='mp_instance_cast_to_native_base', path='build/py/objtype.o', has_indirect=False)
    abstract protected void mp_instance_cast_to_native_base(int offset) throws Exception;
    public static final int mp_instance_cast_to_native_base = 0x08012578;
    public void mp_instance_cast_to_native_base(InterruptHandler handler) throws Exception
    {
        call(this::mp_instance_cast_to_native_base, handler);
    }

    // function: Function(address=134292882, size=64, name='zip_iternext', path='build/py/objzip.o', has_indirect=False)
    abstract protected void zip_iternext(int offset) throws Exception;
    public static final int zip_iternext = 0x08012592;
    public void zip_iternext(InterruptHandler handler) throws Exception
    {
        call(this::zip_iternext, handler);
    }

    // function: Function(address=134292948, size=76, name='zip_make_new', path='build/py/objzip.o', has_indirect=False)
    abstract protected void zip_make_new(int offset) throws Exception;
    public static final int zip_make_new = 0x080125d4;
    public void zip_make_new(InterruptHandler handler) throws Exception
    {
        call(this::zip_make_new, handler);
    }

    // function: Function(address=134293024, size=22, name='op_getitem', path='build/py/opmethods.o', has_indirect=False)
    abstract protected void op_getitem(int offset) throws Exception;
    public static final int op_getitem = 0x08012620;
    public void op_getitem(InterruptHandler handler) throws Exception
    {
        call(this::op_getitem, handler);
    }

    // function: Function(address=134293046, size=24, name='op_setitem', path='build/py/opmethods.o', has_indirect=False)
    abstract protected void op_setitem(int offset) throws Exception;
    public static final int op_setitem = 0x08012636;
    public void op_setitem(InterruptHandler handler) throws Exception
    {
        call(this::op_setitem, handler);
    }

    // function: Function(address=134293070, size=22, name='op_delitem', path='build/py/opmethods.o', has_indirect=False)
    abstract protected void op_delitem(int offset) throws Exception;
    public static final int op_delitem = 0x0801264e;
    public void op_delitem(InterruptHandler handler) throws Exception
    {
        call(this::op_delitem, handler);
    }

    // function: Function(address=134293092, size=22, name='op_contains', path='build/py/opmethods.o', has_indirect=False)
    abstract protected void op_contains(int offset) throws Exception;
    public static final int op_contains = 0x08012664;
    public void op_contains(InterruptHandler handler) throws Exception
    {
        call(this::op_contains, handler);
    }

    // function: Function(address=134293114, size=38, name='mp_seq_multiply', path='build/py/sequence.o', has_indirect=False)
    abstract protected void mp_seq_multiply(int offset) throws Exception;
    public static final int mp_seq_multiply = 0x0801267a;
    public void mp_seq_multiply(InterruptHandler handler) throws Exception
    {
        call(this::mp_seq_multiply, handler);
    }

    // function: Function(address=134293152, size=248, name='mp_seq_get_fast_slice_indexes', path='build/py/sequence.o', has_indirect=False)
    abstract protected void mp_seq_get_fast_slice_indexes(int offset) throws Exception;
    public static final int mp_seq_get_fast_slice_indexes = 0x080126a0;
    public void mp_seq_get_fast_slice_indexes(InterruptHandler handler) throws Exception
    {
        call(this::mp_seq_get_fast_slice_indexes, handler);
    }

    // function: Function(address=134293400, size=70, name='mp_seq_extract_slice', path='build/py/sequence.o', has_indirect=False)
    abstract protected void mp_seq_extract_slice(int offset) throws Exception;
    public static final int mp_seq_extract_slice = 0x08012798;
    public void mp_seq_extract_slice(InterruptHandler handler) throws Exception
    {
        call(this::mp_seq_extract_slice, handler);
    }

    // function: Function(address=134293470, size=108, name='mp_seq_cmp_bytes', path='build/py/sequence.o', has_indirect=False)
    abstract protected void mp_seq_cmp_bytes(int offset) throws Exception;
    public static final int mp_seq_cmp_bytes = 0x080127de;
    public void mp_seq_cmp_bytes(InterruptHandler handler) throws Exception
    {
        call(this::mp_seq_cmp_bytes, handler);
    }

    // function: Function(address=134293580, size=152, name='mp_seq_cmp_objs', path='build/py/sequence.o', has_indirect=False)
    abstract protected void mp_seq_cmp_objs(int offset) throws Exception;
    public static final int mp_seq_cmp_objs = 0x0801284c;
    public void mp_seq_cmp_objs(InterruptHandler handler) throws Exception
    {
        call(this::mp_seq_cmp_objs, handler);
    }

    // function: Function(address=134293732, size=104, name='mp_seq_index_obj', path='build/py/sequence.o', has_indirect=False)
    abstract protected void mp_seq_index_obj(int offset) throws Exception;
    public static final int mp_seq_index_obj = 0x080128e4;
    public void mp_seq_index_obj(InterruptHandler handler) throws Exception
    {
        call(this::mp_seq_index_obj, handler);
    }

    // function: Function(address=134293836, size=40, name='mp_seq_count_obj', path='build/py/sequence.o', has_indirect=False)
    abstract protected void mp_seq_count_obj(int offset) throws Exception;
    public static final int mp_seq_count_obj = 0x0801294c;
    public void mp_seq_count_obj(InterruptHandler handler) throws Exception
    {
        call(this::mp_seq_count_obj, handler);
    }

    // function: Function(address=134293876, size=36, name='mp_stream_close', path='build/py/stream.o', has_indirect=False)
    abstract protected void mp_stream_close(int offset) throws Exception;
    public static final int mp_stream_close = 0x08012974;
    public void mp_stream_close(InterruptHandler handler) throws Exception
    {
        call(this::mp_stream_close, handler);
    }

    // function: Function(address=134293912, size=36, name='stream_flush', path='build/py/stream.o', has_indirect=False)
    abstract protected void stream_flush(int offset) throws Exception;
    public static final int stream_flush = 0x08012998;
    public void stream_flush(InterruptHandler handler) throws Exception
    {
        call(this::stream_flush, handler);
    }

    // function: Function(address=134293948, size=140, name='stream_unbuffered_readline', path='build/py/stream.o', has_indirect=False)
    abstract protected void stream_unbuffered_readline(int offset) throws Exception;
    public static final int stream_unbuffered_readline = 0x080129bc;
    public void stream_unbuffered_readline(InterruptHandler handler) throws Exception
    {
        call(this::stream_unbuffered_readline, handler);
    }

    // function: Function(address=134294088, size=46, name='stream_unbuffered_readlines', path='build/py/stream.o', has_indirect=False)
    abstract protected void stream_unbuffered_readlines(int offset) throws Exception;
    public static final int stream_unbuffered_readlines = 0x08012a48;
    public void stream_unbuffered_readlines(InterruptHandler handler) throws Exception
    {
        call(this::stream_unbuffered_readlines, handler);
    }

    // function: Function(address=134294134, size=84, name='stream_seek', path='build/py/stream.o', has_indirect=False)
    abstract protected void stream_seek(int offset) throws Exception;
    public static final int stream_seek = 0x08012a76;
    public void stream_seek(InterruptHandler handler) throws Exception
    {
        call(this::stream_seek, handler);
    }

    // function: Function(address=134294218, size=22, name='stream_tell', path='build/py/stream.o', has_indirect=False)
    abstract protected void stream_tell(int offset) throws Exception;
    public static final int stream_tell = 0x08012aca;
    public void stream_tell(InterruptHandler handler) throws Exception
    {
        call(this::stream_tell, handler);
    }

    // function: Function(address=134294240, size=92, name='mp_stream_rw', path='build/py/stream.o', has_indirect=False)
    abstract protected void mp_stream_rw(int offset) throws Exception;
    public static final int mp_stream_rw = 0x08012ae0;
    public void mp_stream_rw(InterruptHandler handler) throws Exception
    {
        call(this::mp_stream_rw, handler);
    }

    // function: Function(address=134294332, size=384, name='stream_read_generic', path='build/py/stream.o', has_indirect=False)
    abstract protected void stream_read_generic(int offset) throws Exception;
    public static final int stream_read_generic = 0x08012b3c;
    public void stream_read_generic(InterruptHandler handler) throws Exception
    {
        call(this::stream_read_generic, handler);
    }

    // function: Function(address=134294716, size=10, name='stream_read', path='build/py/stream.o', has_indirect=False)
    abstract protected void stream_read(int offset) throws Exception;
    public static final int stream_read = 0x08012cbc;
    public void stream_read(InterruptHandler handler) throws Exception
    {
        call(this::stream_read, handler);
    }

    // function: Function(address=134294726, size=74, name='stream_readinto', path='build/py/stream.o', has_indirect=False)
    abstract protected void stream_readinto(int offset) throws Exception;
    public static final int stream_readinto = 0x08012cc6;
    public void stream_readinto(InterruptHandler handler) throws Exception
    {
        call(this::stream_readinto, handler);
    }

    // function: Function(address=134294800, size=64, name='mp_get_stream_raise', path='build/py/stream.o', has_indirect=False)
    abstract protected void mp_get_stream_raise(int offset) throws Exception;
    public static final int mp_get_stream_raise = 0x08012d10;
    public void mp_get_stream_raise(InterruptHandler handler) throws Exception
    {
        call(this::mp_get_stream_raise, handler);
    }

    // function: Function(address=134294864, size=32, name='mp_stream_write', path='build/py/stream.o', has_indirect=False)
    abstract protected void mp_stream_write(int offset) throws Exception;
    public static final int mp_stream_write = 0x08012d50;
    public void mp_stream_write(InterruptHandler handler) throws Exception
    {
        call(this::mp_stream_write, handler);
    }

    // function: Function(address=134294896, size=96, name='stream_write_method', path='build/py/stream.o', has_indirect=False)
    abstract protected void stream_write_method(int offset) throws Exception;
    public static final int stream_write_method = 0x08012d70;
    public void stream_write_method(InterruptHandler handler) throws Exception
    {
        call(this::stream_write_method, handler);
    }

    // function: Function(address=134294992, size=10, name='mp_stream_write_adaptor', path='build/py/stream.o', has_indirect=True)
    abstract protected void mp_stream_write_adaptor(int offset) throws Exception;
    public static final int mp_stream_write_adaptor = 0x08012dd0;
    public void mp_stream_write_adaptor(InterruptHandler handler) throws Exception
    {
        call(this::mp_stream_write_adaptor, handler);
    }

    // function: Function(address=134295002, size=30, name='mp_stream_unbuffered_iter', path='build/py/stream.o', has_indirect=False)
    abstract protected void mp_stream_unbuffered_iter(int offset) throws Exception;
    public static final int mp_stream_unbuffered_iter = 0x08012dda;
    public void mp_stream_unbuffered_iter(InterruptHandler handler) throws Exception
    {
        call(this::mp_stream_unbuffered_iter, handler);
    }

    // function: Function(address=134295032, size=208, name='mp_binary_get_size', path='build/py/binary.o', has_indirect=False)
    abstract protected void mp_binary_get_size(int offset) throws Exception;
    public static final int mp_binary_get_size = 0x08012df8;
    public void mp_binary_get_size(InterruptHandler handler) throws Exception
    {
        call(this::mp_binary_get_size, handler);
    }

    // function: Function(address=134295240, size=174, name='mp_binary_get_val_array', path='build/py/binary.o', has_indirect=False)
    abstract protected void mp_binary_get_val_array(int offset) throws Exception;
    public static final int mp_binary_get_val_array = 0x08012ec8;
    public void mp_binary_get_val_array(InterruptHandler handler) throws Exception
    {
        call(this::mp_binary_get_val_array, handler);
    }

    // function: Function(address=134295414, size=82, name='mp_binary_get_int', path='build/py/binary.o', has_indirect=False)
    abstract protected void mp_binary_get_int(int offset) throws Exception;
    public static final int mp_binary_get_int = 0x08012f76;
    public void mp_binary_get_int(InterruptHandler handler) throws Exception
    {
        call(this::mp_binary_get_int, handler);
    }

    // function: Function(address=134295496, size=168, name='mp_binary_get_val', path='build/py/binary.o', has_indirect=False)
    abstract protected void mp_binary_get_val(int offset) throws Exception;
    public static final int mp_binary_get_val = 0x08012fc8;
    public void mp_binary_get_val(InterruptHandler handler) throws Exception
    {
        call(this::mp_binary_get_val, handler);
    }

    // function: Function(address=134295664, size=38, name='mp_binary_set_int', path='build/py/binary.o', has_indirect=False)
    abstract protected void mp_binary_set_int(int offset) throws Exception;
    public static final int mp_binary_set_int = 0x08013070;
    public void mp_binary_set_int(InterruptHandler handler) throws Exception
    {
        call(this::mp_binary_set_int, handler);
    }

    // function: Function(address=134295704, size=236, name='mp_binary_set_val', path='build/py/binary.o', has_indirect=False)
    abstract protected void mp_binary_set_val(int offset) throws Exception;
    public static final int mp_binary_set_val = 0x08013098;
    public void mp_binary_set_val(InterruptHandler handler) throws Exception
    {
        call(this::mp_binary_set_val, handler);
    }

    // function: Function(address=134295940, size=126, name='mp_binary_set_val_array_from_int', path='build/py/binary.o', has_indirect=False)
    abstract protected void mp_binary_set_val_array_from_int(int offset) throws Exception;
    public static final int mp_binary_set_val_array_from_int = 0x08013184;
    public void mp_binary_set_val_array_from_int(InterruptHandler handler) throws Exception
    {
        call(this::mp_binary_set_val_array_from_int, handler);
    }

    // function: Function(address=134296068, size=132, name='mp_binary_set_val_array', path='build/py/binary.o', has_indirect=False)
    abstract protected void mp_binary_set_val_array(int offset) throws Exception;
    public static final int mp_binary_set_val_array = 0x08013204;
    public void mp_binary_set_val_array(InterruptHandler handler) throws Exception
    {
        call(this::mp_binary_set_val_array, handler);
    }

    // function: Function(address=134296200, size=20, name='mp_import_stat_any', path='build/py/builtinimport.o', has_indirect=False)
    abstract protected void mp_import_stat_any(int offset) throws Exception;
    public static final int mp_import_stat_any = 0x08013288;
    public void mp_import_stat_any(InterruptHandler handler) throws Exception
    {
        call(this::mp_import_stat_any, handler);
    }

    // function: Function(address=134296220, size=80, name='do_execute_raw_code', path='build/py/builtinimport.o', has_indirect=False)
    abstract protected void do_execute_raw_code(int offset) throws Exception;
    public static final int do_execute_raw_code = 0x0801329c;
    public void do_execute_raw_code(InterruptHandler handler) throws Exception
    {
        call(this::do_execute_raw_code, handler);
    }

    // function: Function(address=134296300, size=34, name='do_load_from_lexer', path='build/py/builtinimport.o', has_indirect=False)
    abstract protected void do_load_from_lexer(int offset) throws Exception;
    public static final int do_load_from_lexer = 0x080132ec;
    public void do_load_from_lexer(InterruptHandler handler) throws Exception
    {
        call(this::do_load_from_lexer, handler);
    }

    // function: Function(address=134296334, size=76, name='text_do_load', path='build/py/builtinimport.o', has_indirect=False)
    abstract protected void text_do_load(int offset) throws Exception;
    public static final int text_do_load = 0x0801330e;
    public void text_do_load(InterruptHandler handler) throws Exception
    {
        call(this::text_do_load, handler);
    }

    // function: Function(address=134296410, size=50, name='stat_file_py_or_mpy', path='build/py/builtinimport.o', has_indirect=False)
    abstract protected void stat_file_py_or_mpy(int offset) throws Exception;
    public static final int stat_file_py_or_mpy = 0x0801335a;
    public void stat_file_py_or_mpy(InterruptHandler handler) throws Exception
    {
        call(this::stat_file_py_or_mpy, handler);
    }

    // function: Function(address=134296460, size=36, name='stat_dir_or_file', path='build/py/builtinimport.o', has_indirect=False)
    abstract protected void stat_dir_or_file(int offset) throws Exception;
    public static final int stat_dir_or_file = 0x0801338c;
    public void stat_dir_or_file(InterruptHandler handler) throws Exception
    {
        call(this::stat_dir_or_file, handler);
    }

    // function: Function(address=134296496, size=772, name='mp_builtin___import__', path='build/py/builtinimport.o', has_indirect=False)
    abstract protected void mp_builtin___import__(int offset) throws Exception;
    public static final int mp_builtin___import__ = 0x080133b0;
    public void mp_builtin___import__(InterruptHandler handler) throws Exception
    {
        call(this::mp_builtin___import__, handler);
    }

    // function: Function(address=134297268, size=20, name='mp_obj_is_package', path='build/py/builtinimport.o', has_indirect=False)
    abstract protected void mp_obj_is_package(int offset) throws Exception;
    public static final int mp_obj_is_package = 0x080136b4;
    public void mp_obj_is_package(InterruptHandler handler) throws Exception
    {
        call(this::mp_obj_is_package, handler);
    }

    // function: Function(address=134297288, size=116, name='mp_builtin_compile', path='build/py/builtinevex.o', has_indirect=False)
    abstract protected void mp_builtin_compile(int offset) throws Exception;
    public static final int mp_builtin_compile = 0x080136c8;
    public void mp_builtin_compile(InterruptHandler handler) throws Exception
    {
        call(this::mp_builtin_compile, handler);
    }

    // function: Function(address=134297404, size=240, name='eval_exec_helper', path='build/py/builtinevex.o', has_indirect=False)
    abstract protected void eval_exec_helper(int offset) throws Exception;
    public static final int eval_exec_helper = 0x0801373c;
    public void eval_exec_helper(InterruptHandler handler) throws Exception
    {
        call(this::eval_exec_helper, handler);
    }

    // function: Function(address=134297644, size=10, name='mp_builtin_eval', path='build/py/builtinevex.o', has_indirect=False)
    abstract protected void mp_builtin_eval(int offset) throws Exception;
    public static final int mp_builtin_eval = 0x0801382c;
    public void mp_builtin_eval(InterruptHandler handler) throws Exception
    {
        call(this::mp_builtin_eval, handler);
    }

    // function: Function(address=134297654, size=10, name='mp_builtin_exec', path='build/py/builtinevex.o', has_indirect=False)
    abstract protected void mp_builtin_exec(int offset) throws Exception;
    public static final int mp_builtin_exec = 0x08013836;
    public void mp_builtin_exec(InterruptHandler handler) throws Exception
    {
        call(this::mp_builtin_exec, handler);
    }

    // function: Function(address=134297664, size=10, name='mp_builtin_execfile', path='build/py/builtinevex.o', has_indirect=False)
    abstract protected void mp_builtin_execfile(int offset) throws Exception;
    public static final int mp_builtin_execfile = 0x08013840;
    public void mp_builtin_execfile(InterruptHandler handler) throws Exception
    {
        call(this::mp_builtin_execfile, handler);
    }

    // function: Function(address=134297674, size=44, name='mp_help_add_from_names', path='build/py/builtinhelp.o', has_indirect=False)
    abstract protected void mp_help_add_from_names(int offset) throws Exception;
    public static final int mp_help_add_from_names = 0x0801384a;
    public void mp_help_add_from_names(InterruptHandler handler) throws Exception
    {
        call(this::mp_help_add_from_names, handler);
    }

    // function: Function(address=134297718, size=40, name='mp_help_add_from_map', path='build/py/builtinhelp.o', has_indirect=False)
    abstract protected void mp_help_add_from_map(int offset) throws Exception;
    public static final int mp_help_add_from_map = 0x08013876;
    public void mp_help_add_from_map(InterruptHandler handler) throws Exception
    {
        call(this::mp_help_add_from_map, handler);
    }

    // function: Function(address=134297760, size=412, name='mp_builtin_help', path='build/py/builtinhelp.o', has_indirect=False)
    abstract protected void mp_builtin_help(int offset) throws Exception;
    public static final int mp_builtin_help = 0x080138a0;
    public void mp_builtin_help(InterruptHandler handler) throws Exception
    {
        call(this::mp_builtin_help, handler);
    }

    // function: Function(address=134298172, size=12, name='mp_builtin_globals', path='build/py/modbuiltins.o', has_indirect=False)
    abstract protected void mp_builtin_globals(int offset) throws Exception;
    public static final int mp_builtin_globals = 0x08013a3c;
    public void mp_builtin_globals(InterruptHandler handler) throws Exception
    {
        call(this::mp_builtin_globals, handler);
    }

    // function: Function(address=134298184, size=12, name='mp_builtin_locals', path='build/py/modbuiltins.o', has_indirect=False)
    abstract protected void mp_builtin_locals(int offset) throws Exception;
    public static final int mp_builtin_locals = 0x08013a48;
    public void mp_builtin_locals(InterruptHandler handler) throws Exception
    {
        call(this::mp_builtin_locals, handler);
    }

    // function: Function(address=134298196, size=116, name='mp_builtin___build_class__', path='build/py/modbuiltins.o', has_indirect=False)
    abstract protected void mp_builtin___build_class__(int offset) throws Exception;
    public static final int mp_builtin___build_class__ = 0x08013a54;
    public void mp_builtin___build_class__(InterruptHandler handler) throws Exception
    {
        call(this::mp_builtin___build_class__, handler);
    }

    // function: Function(address=134298312, size=12, name='mp_builtin_abs', path='build/py/modbuiltins.o', has_indirect=False)
    abstract protected void mp_builtin_abs(int offset) throws Exception;
    public static final int mp_builtin_abs = 0x08013ac8;
    public void mp_builtin_abs(InterruptHandler handler) throws Exception
    {
        call(this::mp_builtin_abs, handler);
    }

    // function: Function(address=134298324, size=12, name='mp_builtin_hash', path='build/py/modbuiltins.o', has_indirect=False)
    abstract protected void mp_builtin_hash(int offset) throws Exception;
    public static final int mp_builtin_hash = 0x08013ad4;
    public void mp_builtin_hash(InterruptHandler handler) throws Exception
    {
        call(this::mp_builtin_hash, handler);
    }

    // function: Function(address=134298336, size=10, name='mp_builtin_iter', path='build/py/modbuiltins.o', has_indirect=False)
    abstract protected void mp_builtin_iter(int offset) throws Exception;
    public static final int mp_builtin_iter = 0x08013ae0;
    public void mp_builtin_iter(InterruptHandler handler) throws Exception
    {
        call(this::mp_builtin_iter, handler);
    }

    // function: Function(address=134298348, size=48, name='mp_builtin_all', path='build/py/modbuiltins.o', has_indirect=False)
    abstract protected void mp_builtin_all(int offset) throws Exception;
    public static final int mp_builtin_all = 0x08013aec;
    public void mp_builtin_all(InterruptHandler handler) throws Exception
    {
        call(this::mp_builtin_all, handler);
    }

    // function: Function(address=134298396, size=48, name='mp_builtin_any', path='build/py/modbuiltins.o', has_indirect=False)
    abstract protected void mp_builtin_any(int offset) throws Exception;
    public static final int mp_builtin_any = 0x08013b1c;
    public void mp_builtin_any(InterruptHandler handler) throws Exception
    {
        call(this::mp_builtin_any, handler);
    }

    // function: Function(address=134298444, size=22, name='mp_builtin_bin', path='build/py/modbuiltins.o', has_indirect=False)
    abstract protected void mp_builtin_bin(int offset) throws Exception;
    public static final int mp_builtin_bin = 0x08013b4c;
    public void mp_builtin_bin(InterruptHandler handler) throws Exception
    {
        call(this::mp_builtin_bin, handler);
    }

    // function: Function(address=134298468, size=28, name='mp_builtin_callable', path='build/py/modbuiltins.o', has_indirect=False)
    abstract protected void mp_builtin_callable(int offset) throws Exception;
    public static final int mp_builtin_callable = 0x08013b64;
    public void mp_builtin_callable(InterruptHandler handler) throws Exception
    {
        call(this::mp_builtin_callable, handler);
    }

    // function: Function(address=134298496, size=160, name='mp_builtin_chr', path='build/py/modbuiltins.o', has_indirect=False)
    abstract protected void mp_builtin_chr(int offset) throws Exception;
    public static final int mp_builtin_chr = 0x08013b80;
    public void mp_builtin_chr(InterruptHandler handler) throws Exception
    {
        call(this::mp_builtin_chr, handler);
    }

    // function: Function(address=134298656, size=14, name='mp_builtin_divmod', path='build/py/modbuiltins.o', has_indirect=False)
    abstract protected void mp_builtin_divmod(int offset) throws Exception;
    public static final int mp_builtin_divmod = 0x08013c20;
    public void mp_builtin_divmod(InterruptHandler handler) throws Exception
    {
        call(this::mp_builtin_divmod, handler);
    }

    // function: Function(address=134298670, size=16, name='mp_builtin_hex', path='build/py/modbuiltins.o', has_indirect=False)
    abstract protected void mp_builtin_hex(int offset) throws Exception;
    public static final int mp_builtin_hex = 0x08013c2e;
    public void mp_builtin_hex(InterruptHandler handler) throws Exception
    {
        call(this::mp_builtin_hex, handler);
    }

    // function: Function(address=134298686, size=16, name='mp_builtin_oct', path='build/py/modbuiltins.o', has_indirect=False)
    abstract protected void mp_builtin_oct(int offset) throws Exception;
    public static final int mp_builtin_oct = 0x08013c3e;
    public void mp_builtin_oct(InterruptHandler handler) throws Exception
    {
        call(this::mp_builtin_oct, handler);
    }

    // function: Function(address=134298702, size=52, name='mp_builtin_sum', path='build/py/modbuiltins.o', has_indirect=False)
    abstract protected void mp_builtin_sum(int offset) throws Exception;
    public static final int mp_builtin_sum = 0x08013c4e;
    public void mp_builtin_sum(InterruptHandler handler) throws Exception
    {
        call(this::mp_builtin_sum, handler);
    }

    // function: Function(address=134298756, size=224, name='mp_builtin_min_max', path='build/py/modbuiltins.o', has_indirect=False)
    abstract protected void mp_builtin_min_max(int offset) throws Exception;
    public static final int mp_builtin_min_max = 0x08013c84;
    public void mp_builtin_min_max(InterruptHandler handler) throws Exception
    {
        call(this::mp_builtin_min_max, handler);
    }

    // function: Function(address=134298980, size=10, name='mp_builtin_max', path='build/py/modbuiltins.o', has_indirect=False)
    abstract protected void mp_builtin_max(int offset) throws Exception;
    public static final int mp_builtin_max = 0x08013d64;
    public void mp_builtin_max(InterruptHandler handler) throws Exception
    {
        call(this::mp_builtin_max, handler);
    }

    // function: Function(address=134298990, size=10, name='mp_builtin_min', path='build/py/modbuiltins.o', has_indirect=False)
    abstract protected void mp_builtin_min(int offset) throws Exception;
    public static final int mp_builtin_min = 0x08013d6e;
    public void mp_builtin_min(InterruptHandler handler) throws Exception
    {
        call(this::mp_builtin_min, handler);
    }

    // function: Function(address=134299000, size=100, name='mp_builtin_ord', path='build/py/modbuiltins.o', has_indirect=False)
    abstract protected void mp_builtin_ord(int offset) throws Exception;
    public static final int mp_builtin_ord = 0x08013d78;
    public void mp_builtin_ord(InterruptHandler handler) throws Exception
    {
        call(this::mp_builtin_ord, handler);
    }

    // function: Function(address=134299100, size=132, name='mp_builtin_print', path='build/py/modbuiltins.o', has_indirect=False)
    abstract protected void mp_builtin_print(int offset) throws Exception;
    public static final int mp_builtin_print = 0x08013ddc;
    public void mp_builtin_print(InterruptHandler handler) throws Exception
    {
        call(this::mp_builtin_print, handler);
    }

    // function: Function(address=134299232, size=44, name='mp_builtin_repr', path='build/py/modbuiltins.o', has_indirect=False)
    abstract protected void mp_builtin_repr(int offset) throws Exception;
    public static final int mp_builtin_repr = 0x08013e60;
    public void mp_builtin_repr(InterruptHandler handler) throws Exception
    {
        call(this::mp_builtin_repr, handler);
    }

    // function: Function(address=134299276, size=108, name='mp_builtin_round', path='build/py/modbuiltins.o', has_indirect=False)
    abstract protected void mp_builtin_round(int offset) throws Exception;
    public static final int mp_builtin_round = 0x08013e8c;
    public void mp_builtin_round(InterruptHandler handler) throws Exception
    {
        call(this::mp_builtin_round, handler);
    }

    // function: Function(address=134299384, size=60, name='mp_builtin_sorted', path='build/py/modbuiltins.o', has_indirect=False)
    abstract protected void mp_builtin_sorted(int offset) throws Exception;
    public static final int mp_builtin_sorted = 0x08013ef8;
    public void mp_builtin_sorted(InterruptHandler handler) throws Exception
    {
        call(this::mp_builtin_sorted, handler);
    }

    // function: Function(address=134299444, size=44, name='mp_builtin_hasattr', path='build/py/modbuiltins.o', has_indirect=False)
    abstract protected void mp_builtin_hasattr(int offset) throws Exception;
    public static final int mp_builtin_hasattr = 0x08013f34;
    public void mp_builtin_hasattr(InterruptHandler handler) throws Exception
    {
        call(this::mp_builtin_hasattr, handler);
    }

    // function: Function(address=134299488, size=68, name='mp_builtin_getattr', path='build/py/modbuiltins.o', has_indirect=False)
    abstract protected void mp_builtin_getattr(int offset) throws Exception;
    public static final int mp_builtin_getattr = 0x08013f60;
    public void mp_builtin_getattr(InterruptHandler handler) throws Exception
    {
        call(this::mp_builtin_getattr, handler);
    }

    // function: Function(address=134299556, size=32, name='mp_builtin_setattr', path='build/py/modbuiltins.o', has_indirect=False)
    abstract protected void mp_builtin_setattr(int offset) throws Exception;
    public static final int mp_builtin_setattr = 0x08013fa4;
    public void mp_builtin_setattr(InterruptHandler handler) throws Exception
    {
        call(this::mp_builtin_setattr, handler);
    }

    // function: Function(address=134299588, size=10, name='mp_builtin_delattr', path='build/py/modbuiltins.o', has_indirect=False)
    abstract protected void mp_builtin_delattr(int offset) throws Exception;
    public static final int mp_builtin_delattr = 0x08013fc4;
    public void mp_builtin_delattr(InterruptHandler handler) throws Exception
    {
        call(this::mp_builtin_delattr, handler);
    }

    // function: Function(address=134299600, size=144, name='mp_builtin_dir', path='build/py/modbuiltins.o', has_indirect=False)
    abstract protected void mp_builtin_dir(int offset) throws Exception;
    public static final int mp_builtin_dir = 0x08013fd0;
    public void mp_builtin_dir(InterruptHandler handler) throws Exception
    {
        call(this::mp_builtin_dir, handler);
    }

    // function: Function(address=134299744, size=28, name='mp_builtin_next', path='build/py/modbuiltins.o', has_indirect=False)
    abstract protected void mp_builtin_next(int offset) throws Exception;
    public static final int mp_builtin_next = 0x08014060;
    public void mp_builtin_next(InterruptHandler handler) throws Exception
    {
        call(this::mp_builtin_next, handler);
    }

    // function: Function(address=134299772, size=34, name='mp_builtin_pow', path='build/py/modbuiltins.o', has_indirect=False)
    abstract protected void mp_builtin_pow(int offset) throws Exception;
    public static final int mp_builtin_pow = 0x0801407c;
    public void mp_builtin_pow(InterruptHandler handler) throws Exception
    {
        call(this::mp_builtin_pow, handler);
    }

    // function: Function(address=134299808, size=76, name='mp_builtin___repl_print__', path='build/py/modbuiltins.o', has_indirect=False)
    abstract protected void mp_builtin___repl_print__(int offset) throws Exception;
    public static final int mp_builtin___repl_print__ = 0x080140a0;
    public void mp_builtin___repl_print__(InterruptHandler handler) throws Exception
    {
        call(this::mp_builtin___repl_print__, handler);
    }

    // function: Function(address=134299884, size=24, name='gc_disable', path='build/py/modgc.o', has_indirect=False)
    abstract protected void gc_disable(int offset) throws Exception;
    public static final int gc_disable = 0x080140ec;
    public void gc_disable(InterruptHandler handler) throws Exception
    {
        call(this::gc_disable, handler);
    }

    // function: Function(address=134299908, size=24, name='gc_enable', path='build/py/modgc.o', has_indirect=False)
    abstract protected void gc_enable(int offset) throws Exception;
    public static final int gc_enable = 0x08014104;
    public void gc_enable(InterruptHandler handler) throws Exception
    {
        call(this::gc_enable, handler);
    }

    // function: Function(address=134299932, size=32, name='gc_isenabled', path='build/py/modgc.o', has_indirect=False)
    abstract protected void gc_isenabled(int offset) throws Exception;
    public static final int gc_isenabled = 0x0801411c;
    public void gc_isenabled(InterruptHandler handler) throws Exception
    {
        call(this::gc_isenabled, handler);
    }

    // function: Function(address=134299964, size=28, name='py_gc_collect', path='build/py/modgc.o', has_indirect=False)
    abstract protected void py_gc_collect(int offset) throws Exception;
    public static final int py_gc_collect = 0x0801413c;
    public void py_gc_collect(InterruptHandler handler) throws Exception
    {
        call(this::py_gc_collect, handler);
    }

    // function: Function(address=134299992, size=22, name='gc_mem_free', path='build/py/modgc.o', has_indirect=False)
    abstract protected void gc_mem_free(int offset) throws Exception;
    public static final int gc_mem_free = 0x08014158;
    public void gc_mem_free(InterruptHandler handler) throws Exception
    {
        call(this::gc_mem_free, handler);
    }

    // function: Function(address=134300014, size=22, name='gc_mem_alloc', path='build/py/modgc.o', has_indirect=False)
    abstract protected void gc_mem_alloc(int offset) throws Exception;
    public static final int gc_mem_alloc = 0x0801416e;
    public void gc_mem_alloc(InterruptHandler handler) throws Exception
    {
        call(this::gc_mem_alloc, handler);
    }

    // function: Function(address=134300036, size=60, name='gc_threshold', path='build/py/modgc.o', has_indirect=False)
    abstract protected void gc_threshold(int offset) throws Exception;
    public static final int gc_threshold = 0x08014184;
    public void gc_threshold(InterruptHandler handler) throws Exception
    {
        call(this::gc_threshold, handler);
    }

    // function: Function(address=134300096, size=224, name='resource_stream', path='build/py/modio.o', has_indirect=False)
    abstract protected void resource_stream(int offset) throws Exception;
    public static final int resource_stream = 0x080141c0;
    public void resource_stream(InterruptHandler handler) throws Exception
    {
        call(this::resource_stream, handler);
    }

    // function: Function(address=134300320, size=6, name='fabs_funcf', path='build/py/modmath.o', has_indirect=True)
    abstract protected void fabs_funcf(int offset) throws Exception;
    public static final int fabs_funcf = 0x080142a0;
    public void fabs_funcf(InterruptHandler handler) throws Exception
    {
        call(this::fabs_funcf, handler);
    }

    // function: Function(address=134300328, size=20, name='log2f', path='build/py/modmath.o', has_indirect=True)
    abstract protected void log2f(int offset) throws Exception;
    public static final int log2f = 0x080142a8;
    public void log2f(InterruptHandler handler) throws Exception
    {
        call(this::log2f, handler);
    }

    // function: Function(address=134300348, size=32, name='mp_math_isnan', path='build/py/modmath.o', has_indirect=False)
    abstract protected void mp_math_isnan(int offset) throws Exception;
    public static final int mp_math_isnan = 0x080142bc;
    public void mp_math_isnan(InterruptHandler handler) throws Exception
    {
        call(this::mp_math_isnan, handler);
    }

    // function: Function(address=134300380, size=56, name='mp_math_isfinite', path='build/py/modmath.o', has_indirect=False)
    abstract protected void mp_math_isfinite(int offset) throws Exception;
    public static final int mp_math_isfinite = 0x080142dc;
    public void mp_math_isfinite(InterruptHandler handler) throws Exception
    {
        call(this::mp_math_isfinite, handler);
    }

    // function: Function(address=134300436, size=56, name='mp_math_isinf', path='build/py/modmath.o', has_indirect=False)
    abstract protected void mp_math_isinf(int offset) throws Exception;
    public static final int mp_math_isinf = 0x08014314;
    public void mp_math_isinf(InterruptHandler handler) throws Exception
    {
        call(this::mp_math_isinf, handler);
    }

    // function: Function(address=134300492, size=24, name='mp_math_degrees', path='build/py/modmath.o', has_indirect=False)
    abstract protected void mp_math_degrees(int offset) throws Exception;
    public static final int mp_math_degrees = 0x0801434c;
    public void mp_math_degrees(InterruptHandler handler) throws Exception
    {
        call(this::mp_math_degrees, handler);
    }

    // function: Function(address=134300516, size=24, name='mp_math_radians', path='build/py/modmath.o', has_indirect=False)
    abstract protected void mp_math_radians(int offset) throws Exception;
    public static final int mp_math_radians = 0x08014364;
    public void mp_math_radians(InterruptHandler handler) throws Exception
    {
        call(this::mp_math_radians, handler);
    }

    // function: Function(address=134300540, size=16, name='mp_math_trunc', path='build/py/modmath.o', has_indirect=False)
    abstract protected void mp_math_trunc(int offset) throws Exception;
    public static final int mp_math_trunc = 0x0801437c;
    public void mp_math_trunc(InterruptHandler handler) throws Exception
    {
        call(this::mp_math_trunc, handler);
    }

    // function: Function(address=134300556, size=42, name='mp_math_modf', path='build/py/modmath.o', has_indirect=False)
    abstract protected void mp_math_modf(int offset) throws Exception;
    public static final int mp_math_modf = 0x0801438c;
    public void mp_math_modf(InterruptHandler handler) throws Exception
    {
        call(this::mp_math_modf, handler);
    }

    // function: Function(address=134300598, size=30, name='mp_math_ldexp', path='build/py/modmath.o', has_indirect=False)
    abstract protected void mp_math_ldexp(int offset) throws Exception;
    public static final int mp_math_ldexp = 0x080143b6;
    public void mp_math_ldexp(InterruptHandler handler) throws Exception
    {
        call(this::mp_math_ldexp, handler);
    }

    // function: Function(address=134300628, size=42, name='mp_math_frexp', path='build/py/modmath.o', has_indirect=False)
    abstract protected void mp_math_frexp(int offset) throws Exception;
    public static final int mp_math_frexp = 0x080143d4;
    public void mp_math_frexp(InterruptHandler handler) throws Exception
    {
        call(this::mp_math_frexp, handler);
    }

    // function: Function(address=134300670, size=16, name='mp_math_floor', path='build/py/modmath.o', has_indirect=False)
    abstract protected void mp_math_floor(int offset) throws Exception;
    public static final int mp_math_floor = 0x080143fe;
    public void mp_math_floor(InterruptHandler handler) throws Exception
    {
        call(this::mp_math_floor, handler);
    }

    // function: Function(address=134300686, size=12, name='copysign_funcf', path='build/py/modmath.o', has_indirect=True)
    abstract protected void copysign_funcf(int offset) throws Exception;
    public static final int copysign_funcf = 0x0801440e;
    public void copysign_funcf(InterruptHandler handler) throws Exception
    {
        call(this::copysign_funcf, handler);
    }

    // function: Function(address=134300698, size=16, name='mp_math_ceil', path='build/py/modmath.o', has_indirect=False)
    abstract protected void mp_math_ceil(int offset) throws Exception;
    public static final int mp_math_ceil = 0x0801441a;
    public void mp_math_ceil(InterruptHandler handler) throws Exception
    {
        call(this::mp_math_ceil, handler);
    }

    // function: Function(address=134300716, size=116, name='math_generic_1', path='build/py/modmath.o', has_indirect=False)
    abstract protected void math_generic_1(int offset) throws Exception;
    public static final int math_generic_1 = 0x0801442c;
    public void math_generic_1(InterruptHandler handler) throws Exception
    {
        call(this::math_generic_1, handler);
    }

    // function: Function(address=134300832, size=16, name='mp_math_lgamma', path='build/py/modmath.o', has_indirect=False)
    abstract protected void mp_math_lgamma(int offset) throws Exception;
    public static final int mp_math_lgamma = 0x080144a0;
    public void mp_math_lgamma(InterruptHandler handler) throws Exception
    {
        call(this::mp_math_lgamma, handler);
    }

    // function: Function(address=134300848, size=16, name='mp_math_gamma', path='build/py/modmath.o', has_indirect=False)
    abstract protected void mp_math_gamma(int offset) throws Exception;
    public static final int mp_math_gamma = 0x080144b0;
    public void mp_math_gamma(InterruptHandler handler) throws Exception
    {
        call(this::mp_math_gamma, handler);
    }

    // function: Function(address=134300864, size=16, name='mp_math_erfc', path='build/py/modmath.o', has_indirect=False)
    abstract protected void mp_math_erfc(int offset) throws Exception;
    public static final int mp_math_erfc = 0x080144c0;
    public void mp_math_erfc(InterruptHandler handler) throws Exception
    {
        call(this::mp_math_erfc, handler);
    }

    // function: Function(address=134300880, size=16, name='mp_math_erf', path='build/py/modmath.o', has_indirect=False)
    abstract protected void mp_math_erf(int offset) throws Exception;
    public static final int mp_math_erf = 0x080144d0;
    public void mp_math_erf(InterruptHandler handler) throws Exception
    {
        call(this::mp_math_erf, handler);
    }

    // function: Function(address=134300896, size=16, name='mp_math_fabs', path='build/py/modmath.o', has_indirect=False)
    abstract protected void mp_math_fabs(int offset) throws Exception;
    public static final int mp_math_fabs = 0x080144e0;
    public void mp_math_fabs(InterruptHandler handler) throws Exception
    {
        call(this::mp_math_fabs, handler);
    }

    // function: Function(address=134300912, size=16, name='mp_math_atan', path='build/py/modmath.o', has_indirect=False)
    abstract protected void mp_math_atan(int offset) throws Exception;
    public static final int mp_math_atan = 0x080144f0;
    public void mp_math_atan(InterruptHandler handler) throws Exception
    {
        call(this::mp_math_atan, handler);
    }

    // function: Function(address=134300928, size=16, name='mp_math_asin', path='build/py/modmath.o', has_indirect=False)
    abstract protected void mp_math_asin(int offset) throws Exception;
    public static final int mp_math_asin = 0x08014500;
    public void mp_math_asin(InterruptHandler handler) throws Exception
    {
        call(this::mp_math_asin, handler);
    }

    // function: Function(address=134300944, size=16, name='mp_math_acos', path='build/py/modmath.o', has_indirect=False)
    abstract protected void mp_math_acos(int offset) throws Exception;
    public static final int mp_math_acos = 0x08014510;
    public void mp_math_acos(InterruptHandler handler) throws Exception
    {
        call(this::mp_math_acos, handler);
    }

    // function: Function(address=134300960, size=16, name='mp_math_tan', path='build/py/modmath.o', has_indirect=False)
    abstract protected void mp_math_tan(int offset) throws Exception;
    public static final int mp_math_tan = 0x08014520;
    public void mp_math_tan(InterruptHandler handler) throws Exception
    {
        call(this::mp_math_tan, handler);
    }

    // function: Function(address=134300976, size=16, name='mp_math_sin', path='build/py/modmath.o', has_indirect=False)
    abstract protected void mp_math_sin(int offset) throws Exception;
    public static final int mp_math_sin = 0x08014530;
    public void mp_math_sin(InterruptHandler handler) throws Exception
    {
        call(this::mp_math_sin, handler);
    }

    // function: Function(address=134300992, size=16, name='mp_math_cos', path='build/py/modmath.o', has_indirect=False)
    abstract protected void mp_math_cos(int offset) throws Exception;
    public static final int mp_math_cos = 0x08014540;
    public void mp_math_cos(InterruptHandler handler) throws Exception
    {
        call(this::mp_math_cos, handler);
    }

    // function: Function(address=134301008, size=16, name='mp_math_atanh', path='build/py/modmath.o', has_indirect=False)
    abstract protected void mp_math_atanh(int offset) throws Exception;
    public static final int mp_math_atanh = 0x08014550;
    public void mp_math_atanh(InterruptHandler handler) throws Exception
    {
        call(this::mp_math_atanh, handler);
    }

    // function: Function(address=134301024, size=16, name='mp_math_asinh', path='build/py/modmath.o', has_indirect=False)
    abstract protected void mp_math_asinh(int offset) throws Exception;
    public static final int mp_math_asinh = 0x08014560;
    public void mp_math_asinh(InterruptHandler handler) throws Exception
    {
        call(this::mp_math_asinh, handler);
    }

    // function: Function(address=134301040, size=16, name='mp_math_acosh', path='build/py/modmath.o', has_indirect=False)
    abstract protected void mp_math_acosh(int offset) throws Exception;
    public static final int mp_math_acosh = 0x08014570;
    public void mp_math_acosh(InterruptHandler handler) throws Exception
    {
        call(this::mp_math_acosh, handler);
    }

    // function: Function(address=134301056, size=16, name='mp_math_tanh', path='build/py/modmath.o', has_indirect=False)
    abstract protected void mp_math_tanh(int offset) throws Exception;
    public static final int mp_math_tanh = 0x08014580;
    public void mp_math_tanh(InterruptHandler handler) throws Exception
    {
        call(this::mp_math_tanh, handler);
    }

    // function: Function(address=134301072, size=16, name='mp_math_sinh', path='build/py/modmath.o', has_indirect=False)
    abstract protected void mp_math_sinh(int offset) throws Exception;
    public static final int mp_math_sinh = 0x08014590;
    public void mp_math_sinh(InterruptHandler handler) throws Exception
    {
        call(this::mp_math_sinh, handler);
    }

    // function: Function(address=134301088, size=16, name='mp_math_cosh', path='build/py/modmath.o', has_indirect=False)
    abstract protected void mp_math_cosh(int offset) throws Exception;
    public static final int mp_math_cosh = 0x080145a0;
    public void mp_math_cosh(InterruptHandler handler) throws Exception
    {
        call(this::mp_math_cosh, handler);
    }

    // function: Function(address=134301104, size=16, name='mp_math_log10', path='build/py/modmath.o', has_indirect=False)
    abstract protected void mp_math_log10(int offset) throws Exception;
    public static final int mp_math_log10 = 0x080145b0;
    public void mp_math_log10(InterruptHandler handler) throws Exception
    {
        call(this::mp_math_log10, handler);
    }

    // function: Function(address=134301120, size=16, name='mp_math_log2', path='build/py/modmath.o', has_indirect=False)
    abstract protected void mp_math_log2(int offset) throws Exception;
    public static final int mp_math_log2 = 0x080145c0;
    public void mp_math_log2(InterruptHandler handler) throws Exception
    {
        call(this::mp_math_log2, handler);
    }

    // function: Function(address=134301136, size=16, name='mp_math_expm1', path='build/py/modmath.o', has_indirect=False)
    abstract protected void mp_math_expm1(int offset) throws Exception;
    public static final int mp_math_expm1 = 0x080145d0;
    public void mp_math_expm1(InterruptHandler handler) throws Exception
    {
        call(this::mp_math_expm1, handler);
    }

    // function: Function(address=134301152, size=16, name='mp_math_exp', path='build/py/modmath.o', has_indirect=False)
    abstract protected void mp_math_exp(int offset) throws Exception;
    public static final int mp_math_exp = 0x080145e0;
    public void mp_math_exp(InterruptHandler handler) throws Exception
    {
        call(this::mp_math_exp, handler);
    }

    // function: Function(address=134301168, size=16, name='mp_math_sqrt', path='build/py/modmath.o', has_indirect=False)
    abstract protected void mp_math_sqrt(int offset) throws Exception;
    public static final int mp_math_sqrt = 0x080145f0;
    public void mp_math_sqrt(InterruptHandler handler) throws Exception
    {
        call(this::mp_math_sqrt, handler);
    }

    // function: Function(address=134301184, size=140, name='math_generic_2', path='build/py/modmath.o', has_indirect=False)
    abstract protected void math_generic_2(int offset) throws Exception;
    public static final int math_generic_2 = 0x08014600;
    public void math_generic_2(InterruptHandler handler) throws Exception
    {
        call(this::math_generic_2, handler);
    }

    // function: Function(address=134301324, size=16, name='mp_math_fmod', path='build/py/modmath.o', has_indirect=False)
    abstract protected void mp_math_fmod(int offset) throws Exception;
    public static final int mp_math_fmod = 0x0801468c;
    public void mp_math_fmod(InterruptHandler handler) throws Exception
    {
        call(this::mp_math_fmod, handler);
    }

    // function: Function(address=134301340, size=16, name='mp_math_copysign', path='build/py/modmath.o', has_indirect=False)
    abstract protected void mp_math_copysign(int offset) throws Exception;
    public static final int mp_math_copysign = 0x0801469c;
    public void mp_math_copysign(InterruptHandler handler) throws Exception
    {
        call(this::mp_math_copysign, handler);
    }

    // function: Function(address=134301356, size=16, name='mp_math_atan2', path='build/py/modmath.o', has_indirect=False)
    abstract protected void mp_math_atan2(int offset) throws Exception;
    public static final int mp_math_atan2 = 0x080146ac;
    public void mp_math_atan2(InterruptHandler handler) throws Exception
    {
        call(this::mp_math_atan2, handler);
    }

    // function: Function(address=134301372, size=16, name='mp_math_pow', path='build/py/modmath.o', has_indirect=False)
    abstract protected void mp_math_pow(int offset) throws Exception;
    public static final int mp_math_pow = 0x080146bc;
    public void mp_math_pow(InterruptHandler handler) throws Exception
    {
        call(this::mp_math_pow, handler);
    }

    // function: Function(address=134301388, size=116, name='mp_math_log', path='build/py/modmath.o', has_indirect=False)
    abstract protected void mp_math_log(int offset) throws Exception;
    public static final int mp_math_log = 0x080146cc;
    public void mp_math_log(InterruptHandler handler) throws Exception
    {
        call(this::mp_math_log, handler);
    }

    // function: Function(address=134301504, size=66, name='mp_cmath_sin', path='build/py/modcmath.o', has_indirect=False)
    abstract protected void mp_cmath_sin(int offset) throws Exception;
    public static final int mp_cmath_sin = 0x08014740;
    public void mp_cmath_sin(InterruptHandler handler) throws Exception
    {
        call(this::mp_cmath_sin, handler);
    }

    // function: Function(address=134301570, size=70, name='mp_cmath_cos', path='build/py/modcmath.o', has_indirect=False)
    abstract protected void mp_cmath_cos(int offset) throws Exception;
    public static final int mp_cmath_cos = 0x08014782;
    public void mp_cmath_cos(InterruptHandler handler) throws Exception
    {
        call(this::mp_cmath_cos, handler);
    }

    // function: Function(address=134301640, size=102, name='mp_cmath_sqrt', path='build/py/modcmath.o', has_indirect=False)
    abstract protected void mp_cmath_sqrt(int offset) throws Exception;
    public static final int mp_cmath_sqrt = 0x080147c8;
    public void mp_cmath_sqrt(InterruptHandler handler) throws Exception
    {
        call(this::mp_cmath_sqrt, handler);
    }

    // function: Function(address=134301744, size=84, name='mp_cmath_log10', path='build/py/modcmath.o', has_indirect=False)
    abstract protected void mp_cmath_log10(int offset) throws Exception;
    public static final int mp_cmath_log10 = 0x08014830;
    public void mp_cmath_log10(InterruptHandler handler) throws Exception
    {
        call(this::mp_cmath_log10, handler);
    }

    // function: Function(address=134301828, size=72, name='mp_cmath_log', path='build/py/modcmath.o', has_indirect=False)
    abstract protected void mp_cmath_log(int offset) throws Exception;
    public static final int mp_cmath_log = 0x08014884;
    public void mp_cmath_log(InterruptHandler handler) throws Exception
    {
        call(this::mp_cmath_log, handler);
    }

    // function: Function(address=134301900, size=58, name='mp_cmath_exp', path='build/py/modcmath.o', has_indirect=False)
    abstract protected void mp_cmath_exp(int offset) throws Exception;
    public static final int mp_cmath_exp = 0x080148cc;
    public void mp_cmath_exp(InterruptHandler handler) throws Exception
    {
        call(this::mp_cmath_exp, handler);
    }

    // function: Function(address=134301958, size=54, name='mp_cmath_rect', path='build/py/modcmath.o', has_indirect=False)
    abstract protected void mp_cmath_rect(int offset) throws Exception;
    public static final int mp_cmath_rect = 0x08014906;
    public void mp_cmath_rect(InterruptHandler handler) throws Exception
    {
        call(this::mp_cmath_rect, handler);
    }

    // function: Function(address=134302012, size=24, name='mp_cmath_phase', path='build/py/modcmath.o', has_indirect=False)
    abstract protected void mp_cmath_phase(int offset) throws Exception;
    public static final int mp_cmath_phase = 0x0801493c;
    public void mp_cmath_phase(InterruptHandler handler) throws Exception
    {
        call(this::mp_cmath_phase, handler);
    }

    // function: Function(address=134302036, size=76, name='mp_cmath_polar', path='build/py/modcmath.o', has_indirect=False)
    abstract protected void mp_cmath_polar(int offset) throws Exception;
    public static final int mp_cmath_polar = 0x08014954;
    public void mp_cmath_polar(InterruptHandler handler) throws Exception
    {
        call(this::mp_cmath_polar, handler);
    }

    // function: Function(address=134302112, size=20, name='mp_micropython_pystack_use', path='build/py/modmicropython.o', has_indirect=False)
    abstract protected void mp_micropython_pystack_use(int offset) throws Exception;
    public static final int mp_micropython_pystack_use = 0x080149a0;
    public void mp_micropython_pystack_use(InterruptHandler handler) throws Exception
    {
        call(this::mp_micropython_pystack_use, handler);
    }

    // function: Function(address=134302132, size=14, name='mp_micropython_mem_total', path='build/py/modmicropython.o', has_indirect=False)
    abstract protected void mp_micropython_mem_total(int offset) throws Exception;
    public static final int mp_micropython_mem_total = 0x080149b4;
    public void mp_micropython_mem_total(InterruptHandler handler) throws Exception
    {
        call(this::mp_micropython_mem_total, handler);
    }

    // function: Function(address=134302146, size=14, name='mp_micropython_mem_current', path='build/py/modmicropython.o', has_indirect=False)
    abstract protected void mp_micropython_mem_current(int offset) throws Exception;
    public static final int mp_micropython_mem_current = 0x080149c2;
    public void mp_micropython_mem_current(InterruptHandler handler) throws Exception
    {
        call(this::mp_micropython_mem_current, handler);
    }

    // function: Function(address=134302160, size=14, name='mp_micropython_mem_peak', path='build/py/modmicropython.o', has_indirect=False)
    abstract protected void mp_micropython_mem_peak(int offset) throws Exception;
    public static final int mp_micropython_mem_peak = 0x080149d0;
    public void mp_micropython_mem_peak(InterruptHandler handler) throws Exception
    {
        call(this::mp_micropython_mem_peak, handler);
    }

    // function: Function(address=134302174, size=14, name='mp_micropython_stack_use', path='build/py/modmicropython.o', has_indirect=False)
    abstract protected void mp_micropython_stack_use(int offset) throws Exception;
    public static final int mp_micropython_stack_use = 0x080149de;
    public void mp_micropython_stack_use(InterruptHandler handler) throws Exception
    {
        call(this::mp_micropython_stack_use, handler);
    }

    // function: Function(address=134302188, size=92, name='mp_micropython_mem_info', path='build/py/modmicropython.o', has_indirect=False)
    abstract protected void mp_micropython_mem_info(int offset) throws Exception;
    public static final int mp_micropython_mem_info = 0x080149ec;
    public void mp_micropython_mem_info(InterruptHandler handler) throws Exception
    {
        call(this::mp_micropython_mem_info, handler);
    }

    // function: Function(address=134302280, size=20, name='mp_micropython_kbd_intr', path='build/py/modmicropython.o', has_indirect=False)
    abstract protected void mp_micropython_kbd_intr(int offset) throws Exception;
    public static final int mp_micropython_kbd_intr = 0x08014a48;
    public void mp_micropython_kbd_intr(InterruptHandler handler) throws Exception
    {
        call(this::mp_micropython_kbd_intr, handler);
    }

    // function: Function(address=134302300, size=16, name='mp_micropython_heap_unlock', path='build/py/modmicropython.o', has_indirect=False)
    abstract protected void mp_micropython_heap_unlock(int offset) throws Exception;
    public static final int mp_micropython_heap_unlock = 0x08014a5c;
    public void mp_micropython_heap_unlock(InterruptHandler handler) throws Exception
    {
        call(this::mp_micropython_heap_unlock, handler);
    }

    // function: Function(address=134302316, size=16, name='mp_micropython_heap_lock', path='build/py/modmicropython.o', has_indirect=False)
    abstract protected void mp_micropython_heap_lock(int offset) throws Exception;
    public static final int mp_micropython_heap_lock = 0x08014a6c;
    public void mp_micropython_heap_lock(InterruptHandler handler) throws Exception
    {
        call(this::mp_micropython_heap_lock, handler);
    }

    // function: Function(address=134302332, size=64, name='mp_micropython_qstr_info', path='build/py/modmicropython.o', has_indirect=False)
    abstract protected void mp_micropython_qstr_info(int offset) throws Exception;
    public static final int mp_micropython_qstr_info = 0x08014a7c;
    public void mp_micropython_qstr_info(InterruptHandler handler) throws Exception
    {
        call(this::mp_micropython_qstr_info, handler);
    }

    // function: Function(address=134302396, size=36, name='mp_micropython_schedule', path='build/py/modmicropython.o', has_indirect=False)
    abstract protected void mp_micropython_schedule(int offset) throws Exception;
    public static final int mp_micropython_schedule = 0x08014abc;
    public void mp_micropython_schedule(InterruptHandler handler) throws Exception
    {
        call(this::mp_micropython_schedule, handler);
    }

    // function: Function(address=134302432, size=44, name='mp_micropython_opt_level', path='build/py/modmicropython.o', has_indirect=False)
    abstract protected void mp_micropython_opt_level(int offset) throws Exception;
    public static final int mp_micropython_opt_level = 0x08014ae0;
    public void mp_micropython_opt_level(InterruptHandler handler) throws Exception
    {
        call(this::mp_micropython_opt_level, handler);
    }

    // function: Function(address=134302476, size=36, name='get_fmt_type', path='build/py/modstruct.o', has_indirect=False)
    abstract protected void get_fmt_type(int offset) throws Exception;
    public static final int get_fmt_type = 0x08014b0c;
    public void get_fmt_type(InterruptHandler handler) throws Exception
    {
        call(this::get_fmt_type, handler);
    }

    // function: Function(address=134302512, size=44, name='get_fmt_num', path='build/py/modstruct.o', has_indirect=False)
    abstract protected void get_fmt_num(int offset) throws Exception;
    public static final int get_fmt_num = 0x08014b30;
    public void get_fmt_num(InterruptHandler handler) throws Exception
    {
        call(this::get_fmt_num, handler);
    }

    // function: Function(address=134302556, size=102, name='calc_size_items', path='build/py/modstruct.o', has_indirect=False)
    abstract protected void calc_size_items(int offset) throws Exception;
    public static final int calc_size_items = 0x08014b5c;
    public void calc_size_items(InterruptHandler handler) throws Exception
    {
        call(this::calc_size_items, handler);
    }

    // function: Function(address=134302658, size=22, name='struct_calcsize', path='build/py/modstruct.o', has_indirect=False)
    abstract protected void struct_calcsize(int offset) throws Exception;
    public static final int struct_calcsize = 0x08014bc2;
    public void struct_calcsize(InterruptHandler handler) throws Exception
    {
        call(this::struct_calcsize, handler);
    }

    // function: Function(address=134302680, size=216, name='struct_unpack_from', path='build/py/modstruct.o', has_indirect=False)
    abstract protected void struct_unpack_from(int offset) throws Exception;
    public static final int struct_unpack_from = 0x08014bd8;
    public void struct_unpack_from(InterruptHandler handler) throws Exception
    {
        call(this::struct_unpack_from, handler);
    }

    // function: Function(address=134302896, size=160, name='struct_pack_into_internal', path='build/py/modstruct.o', has_indirect=False)
    abstract protected void struct_pack_into_internal(int offset) throws Exception;
    public static final int struct_pack_into_internal = 0x08014cb0;
    public void struct_pack_into_internal(InterruptHandler handler) throws Exception
    {
        call(this::struct_pack_into_internal, handler);
    }

    // function: Function(address=134303056, size=68, name='struct_pack', path='build/py/modstruct.o', has_indirect=False)
    abstract protected void struct_pack(int offset) throws Exception;
    public static final int struct_pack = 0x08014d50;
    public void struct_pack(InterruptHandler handler) throws Exception
    {
        call(this::struct_pack, handler);
    }

    // function: Function(address=134303124, size=92, name='struct_pack_into', path='build/py/modstruct.o', has_indirect=False)
    abstract protected void struct_pack_into(int offset) throws Exception;
    public static final int struct_pack_into = 0x08014d94;
    public void struct_pack_into(InterruptHandler handler) throws Exception
    {
        call(this::struct_pack_into, handler);
    }

    // function: Function(address=134303216, size=32, name='mp_sys_exit', path='build/py/modsys.o', has_indirect=False)
    abstract protected void mp_sys_exit(int offset) throws Exception;
    public static final int mp_sys_exit = 0x08014df0;
    public void mp_sys_exit(InterruptHandler handler) throws Exception
    {
        call(this::mp_sys_exit, handler);
    }

    // function: Function(address=134303248, size=52, name='mp_sys_print_exception', path='build/py/modsys.o', has_indirect=False)
    abstract protected void mp_sys_print_exception(int offset) throws Exception;
    public static final int mp_sys_print_exception = 0x08014e10;
    public void mp_sys_print_exception(InterruptHandler handler) throws Exception
    {
        call(this::mp_sys_print_exception, handler);
    }

    // function: Function(address=134303300, size=56, name='mp_sys_exc_info', path='build/py/modsys.o', has_indirect=False)
    abstract protected void mp_sys_exc_info(int offset) throws Exception;
    public static final int mp_sys_exc_info = 0x08014e44;
    public void mp_sys_exc_info(InterruptHandler handler) throws Exception
    {
        call(this::mp_sys_exc_info, handler);
    }

    // function: Function(address=134303356, size=12, name='mp_sys_getsizeof', path='build/py/modsys.o', has_indirect=False)
    abstract protected void mp_sys_getsizeof(int offset) throws Exception;
    public static final int mp_sys_getsizeof = 0x08014e7c;
    public void mp_sys_getsizeof(InterruptHandler handler) throws Exception
    {
        call(this::mp_sys_getsizeof, handler);
    }

    // function: Function(address=134303368, size=28, name='mp_errno_to_str', path='build/py/moduerrno.o', has_indirect=False)
    abstract protected void mp_errno_to_str(int offset) throws Exception;
    public static final int mp_errno_to_str = 0x08014e88;
    public void mp_errno_to_str(InterruptHandler handler) throws Exception
    {
        call(this::mp_errno_to_str, handler);
    }

    // function: Function(address=134303396, size=4440, name='mp_execute_bytecode', path='build/py/vm.o', has_indirect=False)
    abstract protected void mp_execute_bytecode(int offset) throws Exception;
    public static final int mp_execute_bytecode = 0x08014ea4;
    public void mp_execute_bytecode(InterruptHandler handler) throws Exception
    {
        call(this::mp_execute_bytecode, handler);
    }

    // function: Function(address=134307836, size=36, name='unlikely_fun_pos_args_mismatch', path='build/py/bc.o', has_indirect=False)
    abstract protected void unlikely_fun_pos_args_mismatch(int offset) throws Exception;
    public static final int unlikely_fun_pos_args_mismatch = 0x08015ffc;
    public void unlikely_fun_pos_args_mismatch(InterruptHandler handler) throws Exception
    {
        call(this::unlikely_fun_pos_args_mismatch, handler);
    }

    // function: Function(address=134307872, size=32, name='mp_decode_uint', path='build/py/bc.o', has_indirect=False)
    abstract protected void mp_decode_uint(int offset) throws Exception;
    public static final int mp_decode_uint = 0x08016020;
    public void mp_decode_uint(InterruptHandler handler) throws Exception
    {
        call(this::mp_decode_uint, handler);
    }

    // function: Function(address=134307904, size=12, name='mp_decode_uint_value', path='build/py/bc.o', has_indirect=False)
    abstract protected void mp_decode_uint_value(int offset) throws Exception;
    public static final int mp_decode_uint_value = 0x08016040;
    public void mp_decode_uint_value(InterruptHandler handler) throws Exception
    {
        call(this::mp_decode_uint_value, handler);
    }

    // function: Function(address=134307916, size=12, name='mp_decode_uint_skip', path='build/py/bc.o', has_indirect=False)
    abstract protected void mp_decode_uint_skip(int offset) throws Exception;
    public static final int mp_decode_uint_skip = 0x0801604c;
    public void mp_decode_uint_skip(InterruptHandler handler) throws Exception
    {
        call(this::mp_decode_uint_skip, handler);
    }

    // function: Function(address=134307928, size=720, name='mp_setup_code_state', path='build/py/bc.o', has_indirect=False)
    abstract protected void mp_setup_code_state(int offset) throws Exception;
    public static final int mp_setup_code_state = 0x08016058;
    public void mp_setup_code_state(InterruptHandler handler) throws Exception
    {
        call(this::mp_setup_code_state, handler);
    }

    // function: Function(address=134308648, size=84, name='mp_opcode_format', path='build/py/bc.o', has_indirect=False)
    abstract protected void mp_opcode_format(int offset) throws Exception;
    public static final int mp_opcode_format = 0x08016328;
    public void mp_opcode_format(InterruptHandler handler) throws Exception
    {
        call(this::mp_opcode_format, handler);
    }

    // function: Function(address=134308732, size=54, name='str_startswith_word', path='build/py/repl.o', has_indirect=False)
    abstract protected void str_startswith_word(int offset) throws Exception;
    public static final int str_startswith_word = 0x0801637c;
    public void str_startswith_word(InterruptHandler handler) throws Exception
    {
        call(this::str_startswith_word, handler);
    }

    // function: Function(address=134308788, size=388, name='mp_repl_continue_with_input', path='build/py/repl.o', has_indirect=False)
    abstract protected void mp_repl_continue_with_input(int offset) throws Exception;
    public static final int mp_repl_continue_with_input = 0x080163b4;
    public void mp_repl_continue_with_input(InterruptHandler handler) throws Exception
    {
        call(this::mp_repl_continue_with_input, handler);
    }

    // function: Function(address=134309176, size=524, name='mp_repl_autocomplete', path='build/py/repl.o', has_indirect=False)
    abstract protected void mp_repl_autocomplete(int offset) throws Exception;
    public static final int mp_repl_autocomplete = 0x08016538;
    public void mp_repl_autocomplete(InterruptHandler handler) throws Exception
    {
        call(this::mp_repl_autocomplete, handler);
    }

    // function: Function(address=134309700, size=104, name='mp_small_int_mul_overflow', path='build/py/smallint.o', has_indirect=False)
    abstract protected void mp_small_int_mul_overflow(int offset) throws Exception;
    public static final int mp_small_int_mul_overflow = 0x08016744;
    public void mp_small_int_mul_overflow(InterruptHandler handler) throws Exception
    {
        call(this::mp_small_int_mul_overflow, handler);
    }

    // function: Function(address=134309804, size=32, name='mp_small_int_modulo', path='build/py/smallint.o', has_indirect=False)
    abstract protected void mp_small_int_modulo(int offset) throws Exception;
    public static final int mp_small_int_modulo = 0x080167ac;
    public void mp_small_int_modulo(InterruptHandler handler) throws Exception
    {
        call(this::mp_small_int_modulo, handler);
    }

    // function: Function(address=134309836, size=30, name='mp_small_int_floor_divide', path='build/py/smallint.o', has_indirect=False)
    abstract protected void mp_small_int_floor_divide(int offset) throws Exception;
    public static final int mp_small_int_floor_divide = 0x080167cc;
    public void mp_small_int_floor_divide(InterruptHandler handler) throws Exception
    {
        call(this::mp_small_int_floor_divide, handler);
    }

    // function: Function(address=134309866, size=72, name='mp_frozen_stat_helper', path='build/py/frozenmod.o', has_indirect=False)
    abstract protected void mp_frozen_stat_helper(int offset) throws Exception;
    public static final int mp_frozen_stat_helper = 0x080167ea;
    public void mp_frozen_stat_helper(InterruptHandler handler) throws Exception
    {
        call(this::mp_frozen_stat_helper, handler);
    }

    // function: Function(address=134309940, size=104, name='mp_find_frozen_str', path='build/py/frozenmod.o', has_indirect=False)
    abstract protected void mp_find_frozen_str(int offset) throws Exception;
    public static final int mp_find_frozen_str = 0x08016834;
    public void mp_find_frozen_str(InterruptHandler handler) throws Exception
    {
        call(this::mp_find_frozen_str, handler);
    }

    // function: Function(address=134310044, size=36, name='mp_frozen_stat', path='build/py/frozenmod.o', has_indirect=False)
    abstract protected void mp_frozen_stat(int offset) throws Exception;
    public static final int mp_frozen_stat = 0x0801689c;
    public void mp_frozen_stat(InterruptHandler handler) throws Exception
    {
        call(this::mp_frozen_stat, handler);
    }

    // function: Function(address=134310080, size=128, name='mp_find_frozen_module', path='build/py/frozenmod.o', has_indirect=False)
    abstract protected void mp_find_frozen_module(int offset) throws Exception;
    public static final int mp_find_frozen_module = 0x080168c0;
    public void mp_find_frozen_module(InterruptHandler handler) throws Exception
    {
        call(this::mp_find_frozen_module, handler);
    }

    // function: Function(address=134310208, size=20, name='uctypes_struct_addressof', path='build/extmod/moductypes.o', has_indirect=False)
    abstract protected void uctypes_struct_addressof(int offset) throws Exception;
    public static final int uctypes_struct_addressof = 0x08016940;
    public void uctypes_struct_addressof(InterruptHandler handler) throws Exception
    {
        call(this::uctypes_struct_addressof, handler);
    }

    // function: Function(address=134310228, size=28, name='uctypes_struct_bytearray_at', path='build/extmod/moductypes.o', has_indirect=False)
    abstract protected void uctypes_struct_bytearray_at(int offset) throws Exception;
    public static final int uctypes_struct_bytearray_at = 0x08016954;
    public void uctypes_struct_bytearray_at(InterruptHandler handler) throws Exception
    {
        call(this::uctypes_struct_bytearray_at, handler);
    }

    // function: Function(address=134310256, size=26, name='uctypes_struct_bytes_at', path='build/extmod/moductypes.o', has_indirect=False)
    abstract protected void uctypes_struct_bytes_at(int offset) throws Exception;
    public static final int uctypes_struct_bytes_at = 0x08016970;
    public void uctypes_struct_bytes_at(InterruptHandler handler) throws Exception
    {
        call(this::uctypes_struct_bytes_at, handler);
    }

    // function: Function(address=134310282, size=150, name='get_aligned', path='build/extmod/moductypes.o', has_indirect=False)
    abstract protected void get_aligned(int offset) throws Exception;
    public static final int get_aligned = 0x0801698a;
    public void get_aligned(InterruptHandler handler) throws Exception
    {
        call(this::get_aligned, handler);
    }

    // function: Function(address=134310432, size=66, name='uctypes_struct_make_new', path='build/extmod/moductypes.o', has_indirect=False)
    abstract protected void uctypes_struct_make_new(int offset) throws Exception;
    public static final int uctypes_struct_make_new = 0x08016a20;
    public void uctypes_struct_make_new(InterruptHandler handler) throws Exception
    {
        call(this::uctypes_struct_make_new, handler);
    }

    // function: Function(address=134310500, size=88, name='uctypes_struct_print', path='build/extmod/moductypes.o', has_indirect=False)
    abstract protected void uctypes_struct_print(int offset) throws Exception;
    public static final int uctypes_struct_print = 0x08016a64;
    public void uctypes_struct_print(InterruptHandler handler) throws Exception
    {
        call(this::uctypes_struct_print, handler);
    }

    // function: Function(address=134310588, size=112, name='set_aligned', path='build/extmod/moductypes.o', has_indirect=False)
    abstract protected void set_aligned(int offset) throws Exception;
    public static final int set_aligned = 0x08016abc;
    public void set_aligned(InterruptHandler handler) throws Exception
    {
        call(this::set_aligned, handler);
    }

    // function: Function(address=134310700, size=236, name='uctypes_struct_size', path='build/extmod/moductypes.o', has_indirect=False)
    abstract protected void uctypes_struct_size(int offset) throws Exception;
    public static final int uctypes_struct_size = 0x08016b2c;
    public void uctypes_struct_size(InterruptHandler handler) throws Exception
    {
        call(this::uctypes_struct_size, handler);
    }

    // function: Function(address=134310936, size=64, name='uctypes_struct_sizeof', path='build/extmod/moductypes.o', has_indirect=False)
    abstract protected void uctypes_struct_sizeof(int offset) throws Exception;
    public static final int uctypes_struct_sizeof = 0x08016c18;
    public void uctypes_struct_sizeof(InterruptHandler handler) throws Exception
    {
        call(this::uctypes_struct_sizeof, handler);
    }

    // function: Function(address=134311000, size=80, name='uctypes_struct_agg_size', path='build/extmod/moductypes.o', has_indirect=False)
    abstract protected void uctypes_struct_agg_size(int offset) throws Exception;
    public static final int uctypes_struct_agg_size = 0x08016c58;
    public void uctypes_struct_agg_size(InterruptHandler handler) throws Exception
    {
        call(this::uctypes_struct_agg_size, handler);
    }

    // function: Function(address=134311080, size=34, name='uctypes_get_buffer', path='build/extmod/moductypes.o', has_indirect=False)
    abstract protected void uctypes_get_buffer(int offset) throws Exception;
    public static final int uctypes_get_buffer = 0x08016ca8;
    public void uctypes_get_buffer(InterruptHandler handler) throws Exception
    {
        call(this::uctypes_get_buffer, handler);
    }

    // function: Function(address=134311116, size=312, name='uctypes_struct_subscr', path='build/extmod/moductypes.o', has_indirect=False)
    abstract protected void uctypes_struct_subscr(int offset) throws Exception;
    public static final int uctypes_struct_subscr = 0x08016ccc;
    public void uctypes_struct_subscr(InterruptHandler handler) throws Exception
    {
        call(this::uctypes_struct_subscr, handler);
    }

    // function: Function(address=134311428, size=532, name='uctypes_struct_attr_op', path='build/extmod/moductypes.o', has_indirect=False)
    abstract protected void uctypes_struct_attr_op(int offset) throws Exception;
    public static final int uctypes_struct_attr_op = 0x08016e04;
    public void uctypes_struct_attr_op(InterruptHandler handler) throws Exception
    {
        call(this::uctypes_struct_attr_op, handler);
    }

    // function: Function(address=134311960, size=34, name='uctypes_struct_attr', path='build/extmod/moductypes.o', has_indirect=False)
    abstract protected void uctypes_struct_attr(int offset) throws Exception;
    public static final int uctypes_struct_attr = 0x08017018;
    public void uctypes_struct_attr(InterruptHandler handler) throws Exception
    {
        call(this::uctypes_struct_attr, handler);
    }

    // function: Function(address=134311994, size=42, name='ujson_stream_next', path='build/extmod/modujson.o', has_indirect=False)
    abstract protected void ujson_stream_next(int offset) throws Exception;
    public static final int ujson_stream_next = 0x0801703a;
    public void ujson_stream_next(InterruptHandler handler) throws Exception
    {
        call(this::ujson_stream_next, handler);
    }

    // function: Function(address=134312036, size=760, name='mod_ujson_load', path='build/extmod/modujson.o', has_indirect=False)
    abstract protected void mod_ujson_load(int offset) throws Exception;
    public static final int mod_ujson_load = 0x08017064;
    public void mod_ujson_load(InterruptHandler handler) throws Exception
    {
        call(this::mod_ujson_load, handler);
    }

    // function: Function(address=134312796, size=56, name='mod_ujson_loads', path='build/extmod/modujson.o', has_indirect=False)
    abstract protected void mod_ujson_loads(int offset) throws Exception;
    public static final int mod_ujson_loads = 0x0801735c;
    public void mod_ujson_loads(InterruptHandler handler) throws Exception
    {
        call(this::mod_ujson_loads, handler);
    }

    // function: Function(address=134312852, size=44, name='mod_ujson_dump', path='build/extmod/modujson.o', has_indirect=False)
    abstract protected void mod_ujson_dump(int offset) throws Exception;
    public static final int mod_ujson_dump = 0x08017394;
    public void mod_ujson_dump(InterruptHandler handler) throws Exception
    {
        call(this::mod_ujson_dump, handler);
    }

    // function: Function(address=134312896, size=44, name='mod_ujson_dumps', path='build/extmod/modujson.o', has_indirect=False)
    abstract protected void mod_ujson_dumps(int offset) throws Exception;
    public static final int mod_ujson_dumps = 0x080173c0;
    public void mod_ujson_dumps(InterruptHandler handler) throws Exception
    {
        call(this::mod_ujson_dumps, handler);
    }

    // function: Function(address=134312940, size=16, name='match_print', path='build/extmod/modure.o', has_indirect=False)
    abstract protected void match_print(int offset) throws Exception;
    public static final int match_print = 0x080173ec;
    public void match_print(InterruptHandler handler) throws Exception
    {
        call(this::match_print, handler);
    }

    // function: Function(address=134312956, size=16, name='re_print', path='build/extmod/modure.o', has_indirect=False)
    abstract protected void re_print(int offset) throws Exception;
    public static final int re_print = 0x080173fc;
    public void re_print(InterruptHandler handler) throws Exception
    {
        call(this::re_print, handler);
    }

    // function: Function(address=134312972, size=860, name='_compilecode', path='build/extmod/modure.o', has_indirect=False)
    abstract protected void _compilecode(int offset) throws Exception;
    public static final int _compilecode = 0x0801740c;
    public void _compilecode(InterruptHandler handler) throws Exception
    {
        call(this::_compilecode, handler);
    }

    // function: Function(address=134313832, size=72, name='match_group', path='build/extmod/modure.o', has_indirect=False)
    abstract protected void match_group(int offset) throws Exception;
    public static final int match_group = 0x08017768;
    public void match_group(InterruptHandler handler) throws Exception
    {
        call(this::match_group, handler);
    }

    // function: Function(address=134313904, size=44, name='re1_5_sizecode', path='build/extmod/modure.o', has_indirect=False)
    abstract protected void re1_5_sizecode(int offset) throws Exception;
    public static final int re1_5_sizecode = 0x080177b0;
    public void re1_5_sizecode(InterruptHandler handler) throws Exception
    {
        call(this::re1_5_sizecode, handler);
    }

    // function: Function(address=134313948, size=84, name='re1_5_compilecode', path='build/extmod/modure.o', has_indirect=False)
    abstract protected void re1_5_compilecode(int offset) throws Exception;
    public static final int re1_5_compilecode = 0x080177dc;
    public void re1_5_compilecode(InterruptHandler handler) throws Exception
    {
        call(this::re1_5_compilecode, handler);
    }

    // function: Function(address=134314032, size=312, name='re1_5_dumpcode', path='build/extmod/modure.o', has_indirect=False)
    abstract protected void re1_5_dumpcode(int offset) throws Exception;
    public static final int re1_5_dumpcode = 0x08017830;
    public void re1_5_dumpcode(InterruptHandler handler) throws Exception
    {
        call(this::re1_5_dumpcode, handler);
    }

    // function: Function(address=134314344, size=92, name='mod_re_compile', path='build/extmod/modure.o', has_indirect=False)
    abstract protected void mod_re_compile(int offset) throws Exception;
    public static final int mod_re_compile = 0x08017968;
    public void mod_re_compile(InterruptHandler handler) throws Exception
    {
        call(this::mod_re_compile, handler);
    }

    // function: Function(address=134314436, size=52, name='_re1_5_classmatch', path='build/extmod/modure.o', has_indirect=False)
    abstract protected void _re1_5_classmatch(int offset) throws Exception;
    public static final int _re1_5_classmatch = 0x080179c4;
    public void _re1_5_classmatch(InterruptHandler handler) throws Exception
    {
        call(this::_re1_5_classmatch, handler);
    }

    // function: Function(address=134314488, size=74, name='_re1_5_namedclassmatch', path='build/extmod/modure.o', has_indirect=False)
    abstract protected void _re1_5_namedclassmatch(int offset) throws Exception;
    public static final int _re1_5_namedclassmatch = 0x080179f8;
    public void _re1_5_namedclassmatch(InterruptHandler handler) throws Exception
    {
        call(this::_re1_5_namedclassmatch, handler);
    }

    // function: Function(address=134314562, size=280, name='recursiveloop', path='build/extmod/modure.o', has_indirect=False)
    abstract protected void recursiveloop(int offset) throws Exception;
    public static final int recursiveloop = 0x08017a42;
    public void recursiveloop(InterruptHandler handler) throws Exception
    {
        call(this::recursiveloop, handler);
    }

    // function: Function(address=134314842, size=26, name='re1_5_recursiveloopprog', path='build/extmod/modure.o', has_indirect=False)
    abstract protected void re1_5_recursiveloopprog(int offset) throws Exception;
    public static final int re1_5_recursiveloopprog = 0x08017b5a;
    public void re1_5_recursiveloopprog(InterruptHandler handler) throws Exception
    {
        call(this::re1_5_recursiveloopprog, handler);
    }

    // function: Function(address=134314868, size=120, name='ure_exec_isra_2', path='build/extmod/modure.o', has_indirect=False)
    abstract protected void ure_exec_isra_2(int offset) throws Exception;
    public static final int ure_exec_isra_2 = 0x08017b74;
    public void ure_exec_isra_2(InterruptHandler handler) throws Exception
    {
        call(this::ure_exec_isra_2, handler);
    }

    // function: Function(address=134314988, size=10, name='re_match', path='build/extmod/modure.o', has_indirect=False)
    abstract protected void re_match(int offset) throws Exception;
    public static final int re_match = 0x08017bec;
    public void re_match(InterruptHandler handler) throws Exception
    {
        call(this::re_match, handler);
    }

    // function: Function(address=134314998, size=10, name='re_search', path='build/extmod/modure.o', has_indirect=False)
    abstract protected void re_search(int offset) throws Exception;
    public static final int re_search = 0x08017bf6;
    public void re_search(InterruptHandler handler) throws Exception
    {
        call(this::re_search, handler);
    }

    // function: Function(address=134315008, size=30, name='mod_re_match', path='build/extmod/modure.o', has_indirect=False)
    abstract protected void mod_re_match(int offset) throws Exception;
    public static final int mod_re_match = 0x08017c00;
    public void mod_re_match(InterruptHandler handler) throws Exception
    {
        call(this::mod_re_match, handler);
    }

    // function: Function(address=134315038, size=30, name='mod_re_search', path='build/extmod/modure.o', has_indirect=False)
    abstract protected void mod_re_search(int offset) throws Exception;
    public static final int mod_re_search = 0x08017c1e;
    public void mod_re_search(InterruptHandler handler) throws Exception
    {
        call(this::mod_re_search, handler);
    }

    // function: Function(address=134315068, size=204, name='re_split', path='build/extmod/modure.o', has_indirect=False)
    abstract protected void re_split(int offset) throws Exception;
    public static final int re_split = 0x08017c3c;
    public void re_split(InterruptHandler handler) throws Exception
    {
        call(this::re_split, handler);
    }

    // function: Function(address=134315272, size=102, name='tinf_build_tree', path='build/extmod/moduzlib.o', has_indirect=False)
    abstract protected void tinf_build_tree(int offset) throws Exception;
    public static final int tinf_build_tree = 0x08017d08;
    public void tinf_build_tree(InterruptHandler handler) throws Exception
    {
        call(this::tinf_build_tree, handler);
    }

    // function: Function(address=134315376, size=56, name='read_src_stream', path='build/extmod/moduzlib.o', has_indirect=True)
    abstract protected void read_src_stream(int offset) throws Exception;
    public static final int read_src_stream = 0x08017d70;
    public void read_src_stream(InterruptHandler handler) throws Exception
    {
        call(this::read_src_stream, handler);
    }

    // function: Function(address=134315432, size=22, name='uzlib_get_byte', path='build/extmod/moduzlib.o', has_indirect=False)
    abstract protected void uzlib_get_byte(int offset) throws Exception;
    public static final int uzlib_get_byte = 0x08017da8;
    public void uzlib_get_byte(InterruptHandler handler) throws Exception
    {
        call(this::uzlib_get_byte, handler);
    }

    // function: Function(address=134315454, size=36, name='tinf_getbit', path='build/extmod/moduzlib.o', has_indirect=False)
    abstract protected void tinf_getbit(int offset) throws Exception;
    public static final int tinf_getbit = 0x08017dbe;
    public void tinf_getbit(InterruptHandler handler) throws Exception
    {
        call(this::tinf_getbit, handler);
    }

    // function: Function(address=134315490, size=44, name='tinf_read_bits', path='build/extmod/moduzlib.o', has_indirect=False)
    abstract protected void tinf_read_bits(int offset) throws Exception;
    public static final int tinf_read_bits = 0x08017de2;
    public void tinf_read_bits(InterruptHandler handler) throws Exception
    {
        call(this::tinf_read_bits, handler);
    }

    // function: Function(address=134315534, size=42, name='tinf_decode_symbol', path='build/extmod/moduzlib.o', has_indirect=False)
    abstract protected void tinf_decode_symbol(int offset) throws Exception;
    public static final int tinf_decode_symbol = 0x08017e0e;
    public void tinf_decode_symbol(InterruptHandler handler) throws Exception
    {
        call(this::tinf_decode_symbol, handler);
    }

    // function: Function(address=134315576, size=268, name='tinf_decode_trees', path='build/extmod/moduzlib.o', has_indirect=False)
    abstract protected void tinf_decode_trees(int offset) throws Exception;
    public static final int tinf_decode_trees = 0x08017e38;
    public void tinf_decode_trees(InterruptHandler handler) throws Exception
    {
        call(this::tinf_decode_trees, handler);
    }

    // function: Function(address=134315844, size=30, name='tinf_get_le_uint32', path='build/extmod/moduzlib.o', has_indirect=False)
    abstract protected void tinf_get_le_uint32(int offset) throws Exception;
    public static final int tinf_get_le_uint32 = 0x08017f44;
    public void tinf_get_le_uint32(InterruptHandler handler) throws Exception
    {
        call(this::tinf_get_le_uint32, handler);
    }

    // function: Function(address=134315874, size=28, name='tinf_get_be_uint32', path='build/extmod/moduzlib.o', has_indirect=False)
    abstract protected void tinf_get_be_uint32(int offset) throws Exception;
    public static final int tinf_get_be_uint32 = 0x08017f62;
    public void tinf_get_be_uint32(InterruptHandler handler) throws Exception
    {
        call(this::tinf_get_be_uint32, handler);
    }

    // function: Function(address=134315904, size=640, name='uzlib_uncompress', path='build/extmod/moduzlib.o', has_indirect=False)
    abstract protected void uzlib_uncompress(int offset) throws Exception;
    public static final int uzlib_uncompress = 0x08017f80;
    public void uzlib_uncompress(InterruptHandler handler) throws Exception
    {
        call(this::uzlib_uncompress, handler);
    }

    // function: Function(address=134316544, size=68, name='uzlib_zlib_parse_header', path='build/extmod/moduzlib.o', has_indirect=False)
    abstract protected void uzlib_zlib_parse_header(int offset) throws Exception;
    public static final int uzlib_zlib_parse_header = 0x08018200;
    public void uzlib_zlib_parse_header(InterruptHandler handler) throws Exception
    {
        call(this::uzlib_zlib_parse_header, handler);
    }

    // function: Function(address=134316612, size=20, name='tinf_skip_bytes', path='build/extmod/moduzlib.o', has_indirect=False)
    abstract protected void tinf_skip_bytes(int offset) throws Exception;
    public static final int tinf_skip_bytes = 0x08018244;
    public void tinf_skip_bytes(InterruptHandler handler) throws Exception
    {
        call(this::tinf_skip_bytes, handler);
    }

    // function: Function(address=134316632, size=24, name='tinf_get_uint16', path='build/extmod/moduzlib.o', has_indirect=False)
    abstract protected void tinf_get_uint16(int offset) throws Exception;
    public static final int tinf_get_uint16 = 0x08018258;
    public void tinf_get_uint16(InterruptHandler handler) throws Exception
    {
        call(this::tinf_get_uint16, handler);
    }

    // function: Function(address=134316656, size=138, name='uzlib_gzip_parse_header', path='build/extmod/moduzlib.o', has_indirect=False)
    abstract protected void uzlib_gzip_parse_header(int offset) throws Exception;
    public static final int uzlib_gzip_parse_header = 0x08018270;
    public void uzlib_gzip_parse_header(InterruptHandler handler) throws Exception
    {
        call(this::uzlib_gzip_parse_header, handler);
    }

    // function: Function(address=134316796, size=184, name='decompio_make_new', path='build/extmod/moduzlib.o', has_indirect=False)
    abstract protected void decompio_make_new(int offset) throws Exception;
    public static final int decompio_make_new = 0x080182fc;
    public void decompio_make_new(InterruptHandler handler) throws Exception
    {
        call(this::decompio_make_new, handler);
    }

    // function: Function(address=134316980, size=204, name='uzlib_adler32', path='build/extmod/moduzlib.o', has_indirect=False)
    abstract protected void uzlib_adler32(int offset) throws Exception;
    public static final int uzlib_adler32 = 0x080183b4;
    public void uzlib_adler32(InterruptHandler handler) throws Exception
    {
        call(this::uzlib_adler32, handler);
    }

    // function: Function(address=134317184, size=56, name='uzlib_crc32', path='build/extmod/moduzlib.o', has_indirect=False)
    abstract protected void uzlib_crc32(int offset) throws Exception;
    public static final int uzlib_crc32 = 0x08018480;
    public void uzlib_crc32(InterruptHandler handler) throws Exception
    {
        call(this::uzlib_crc32, handler);
    }

    // function: Function(address=134317240, size=106, name='uzlib_uncompress_chksum', path='build/extmod/moduzlib.o', has_indirect=False)
    abstract protected void uzlib_uncompress_chksum(int offset) throws Exception;
    public static final int uzlib_uncompress_chksum = 0x080184b8;
    public void uzlib_uncompress_chksum(InterruptHandler handler) throws Exception
    {
        call(this::uzlib_uncompress_chksum, handler);
    }

    // function: Function(address=134317348, size=60, name='decompio_read', path='build/extmod/moduzlib.o', has_indirect=False)
    abstract protected void decompio_read(int offset) throws Exception;
    public static final int decompio_read = 0x08018524;
    public void decompio_read(InterruptHandler handler) throws Exception
    {
        call(this::decompio_read, handler);
    }

    // function: Function(address=134317408, size=196, name='mod_uzlib_decompress', path='build/extmod/moduzlib.o', has_indirect=False)
    abstract protected void mod_uzlib_decompress(int offset) throws Exception;
    public static final int mod_uzlib_decompress = 0x08018560;
    public void mod_uzlib_decompress(InterruptHandler handler) throws Exception
    {
        call(this::mod_uzlib_decompress, handler);
    }

    // function: Function(address=134317604, size=32, name='get_heap', path='build/extmod/moduheapq.o', has_indirect=False)
    abstract protected void get_heap(int offset) throws Exception;
    public static final int get_heap = 0x08018624;
    public void get_heap(InterruptHandler handler) throws Exception
    {
        call(this::get_heap, handler);
    }

    // function: Function(address=134317636, size=72, name='heap_siftdown_isra_0', path='build/extmod/moduheapq.o', has_indirect=False)
    abstract protected void heap_siftdown_isra_0(int offset) throws Exception;
    public static final int heap_siftdown_isra_0 = 0x08018644;
    public void heap_siftdown_isra_0(InterruptHandler handler) throws Exception
    {
        call(this::heap_siftdown_isra_0, handler);
    }

    // function: Function(address=134317708, size=112, name='heap_siftup', path='build/extmod/moduheapq.o', has_indirect=False)
    abstract protected void heap_siftup(int offset) throws Exception;
    public static final int heap_siftup = 0x0801868c;
    public void heap_siftup(InterruptHandler handler) throws Exception
    {
        call(this::heap_siftup, handler);
    }

    // function: Function(address=134317820, size=36, name='mod_uheapq_heapify', path='build/extmod/moduheapq.o', has_indirect=False)
    abstract protected void mod_uheapq_heapify(int offset) throws Exception;
    public static final int mod_uheapq_heapify = 0x080186fc;
    public void mod_uheapq_heapify(InterruptHandler handler) throws Exception
    {
        call(this::mod_uheapq_heapify, handler);
    }

    // function: Function(address=134317856, size=44, name='mod_uheapq_heappush', path='build/extmod/moduheapq.o', has_indirect=False)
    abstract protected void mod_uheapq_heappush(int offset) throws Exception;
    public static final int mod_uheapq_heappush = 0x08018720;
    public void mod_uheapq_heappush(InterruptHandler handler) throws Exception
    {
        call(this::mod_uheapq_heappush, handler);
    }

    // function: Function(address=134317900, size=64, name='mod_uheapq_heappop', path='build/extmod/moduheapq.o', has_indirect=False)
    abstract protected void mod_uheapq_heappop(int offset) throws Exception;
    public static final int mod_uheapq_heappop = 0x0801874c;
    public void mod_uheapq_heappop(InterruptHandler handler) throws Exception
    {
        call(this::mod_uheapq_heappop, handler);
    }

    // function: Function(address=134317964, size=44, name='utimeq_unary_op', path='build/extmod/modutimeq.o', has_indirect=False)
    abstract protected void utimeq_unary_op(int offset) throws Exception;
    public static final int utimeq_unary_op = 0x0801878c;
    public void utimeq_unary_op(InterruptHandler handler) throws Exception
    {
        call(this::utimeq_unary_op, handler);
    }

    // function: Function(address=134318008, size=68, name='utimeq_make_new', path='build/extmod/modutimeq.o', has_indirect=False)
    abstract protected void utimeq_make_new(int offset) throws Exception;
    public static final int utimeq_make_new = 0x080187b8;
    public void utimeq_make_new(InterruptHandler handler) throws Exception
    {
        call(this::utimeq_make_new, handler);
    }

    // function: Function(address=134318076, size=40, name='mod_utimeq_peektime', path='build/extmod/modutimeq.o', has_indirect=False)
    abstract protected void mod_utimeq_peektime(int offset) throws Exception;
    public static final int mod_utimeq_peektime = 0x080187fc;
    public void mod_utimeq_peektime(InterruptHandler handler) throws Exception
    {
        call(this::mod_utimeq_peektime, handler);
    }

    // function: Function(address=134318116, size=144, name='heap_siftdown_constprop_3', path='build/extmod/modutimeq.o', has_indirect=False)
    abstract protected void heap_siftdown_constprop_3(int offset) throws Exception;
    public static final int heap_siftdown_constprop_3 = 0x08018824;
    public void heap_siftdown_constprop_3(InterruptHandler handler) throws Exception
    {
        call(this::heap_siftdown_constprop_3, handler);
    }

    // function: Function(address=134318260, size=276, name='mod_utimeq_heappop', path='build/extmod/modutimeq.o', has_indirect=False)
    abstract protected void mod_utimeq_heappop(int offset) throws Exception;
    public static final int mod_utimeq_heappop = 0x080188b4;
    public void mod_utimeq_heappop(InterruptHandler handler) throws Exception
    {
        call(this::mod_utimeq_heappop, handler);
    }

    // function: Function(address=134318536, size=84, name='mod_utimeq_heappush', path='build/extmod/modutimeq.o', has_indirect=False)
    abstract protected void mod_utimeq_heappush(int offset) throws Exception;
    public static final int mod_utimeq_heappush = 0x080189c8;
    public void mod_utimeq_heappush(InterruptHandler handler) throws Exception
    {
        call(this::mod_utimeq_heappush, handler);
    }

    // function: Function(address=134318620, size=364, name='sha256_transform', path='build/extmod/moduhashlib.o', has_indirect=False)
    abstract protected void sha256_transform(int offset) throws Exception;
    public static final int sha256_transform = 0x08018a1c;
    public void sha256_transform(InterruptHandler handler) throws Exception
    {
        call(this::sha256_transform, handler);
    }

    // function: Function(address=134318984, size=80, name='sha256_init', path='build/extmod/moduhashlib.o', has_indirect=False)
    abstract protected void sha256_init(int offset) throws Exception;
    public static final int sha256_init = 0x08018b88;
    public void sha256_init(InterruptHandler handler) throws Exception
    {
        call(this::sha256_init, handler);
    }

    // function: Function(address=134319064, size=66, name='sha256_update', path='build/extmod/moduhashlib.o', has_indirect=False)
    abstract protected void sha256_update(int offset) throws Exception;
    public static final int sha256_update = 0x08018bd8;
    public void sha256_update(InterruptHandler handler) throws Exception
    {
        call(this::sha256_update, handler);
    }

    // function: Function(address=134319132, size=36, name='uhashlib_sha256_update', path='build/extmod/moduhashlib.o', has_indirect=False)
    abstract protected void uhashlib_sha256_update(int offset) throws Exception;
    public static final int uhashlib_sha256_update = 0x08018c1c;
    public void uhashlib_sha256_update(InterruptHandler handler) throws Exception
    {
        call(this::uhashlib_sha256_update, handler);
    }

    // function: Function(address=134319168, size=52, name='uhashlib_sha256_make_new', path='build/extmod/moduhashlib.o', has_indirect=False)
    abstract protected void uhashlib_sha256_make_new(int offset) throws Exception;
    public static final int uhashlib_sha256_make_new = 0x08018c40;
    public void uhashlib_sha256_make_new(InterruptHandler handler) throws Exception
    {
        call(this::uhashlib_sha256_make_new, handler);
    }

    // function: Function(address=134319220, size=204, name='sha256_final', path='build/extmod/moduhashlib.o', has_indirect=False)
    abstract protected void sha256_final(int offset) throws Exception;
    public static final int sha256_final = 0x08018c74;
    public void sha256_final(InterruptHandler handler) throws Exception
    {
        call(this::sha256_final, handler);
    }

    // function: Function(address=134319424, size=36, name='uhashlib_sha256_digest', path='build/extmod/moduhashlib.o', has_indirect=False)
    abstract protected void uhashlib_sha256_digest(int offset) throws Exception;
    public static final int uhashlib_sha256_digest = 0x08018d40;
    public void uhashlib_sha256_digest(InterruptHandler handler) throws Exception
    {
        call(this::uhashlib_sha256_digest, handler);
    }

    // function: Function(address=134319460, size=136, name='mod_binascii_hexlify', path='build/extmod/modubinascii.o', has_indirect=False)
    abstract protected void mod_binascii_hexlify(int offset) throws Exception;
    public static final int mod_binascii_hexlify = 0x08018d64;
    public void mod_binascii_hexlify(InterruptHandler handler) throws Exception
    {
        call(this::mod_binascii_hexlify, handler);
    }

    // function: Function(address=134319596, size=244, name='mod_binascii_b2a_base64', path='build/extmod/modubinascii.o', has_indirect=False)
    abstract protected void mod_binascii_b2a_base64(int offset) throws Exception;
    public static final int mod_binascii_b2a_base64 = 0x08018dec;
    public void mod_binascii_b2a_base64(InterruptHandler handler) throws Exception
    {
        call(this::mod_binascii_b2a_base64, handler);
    }

    // function: Function(address=134319840, size=132, name='mod_binascii_unhexlify', path='build/extmod/modubinascii.o', has_indirect=False)
    abstract protected void mod_binascii_unhexlify(int offset) throws Exception;
    public static final int mod_binascii_unhexlify = 0x08018ee0;
    public void mod_binascii_unhexlify(InterruptHandler handler) throws Exception
    {
        call(this::mod_binascii_unhexlify, handler);
    }

    // function: Function(address=134319972, size=196, name='mod_binascii_a2b_base64', path='build/extmod/modubinascii.o', has_indirect=False)
    abstract protected void mod_binascii_a2b_base64(int offset) throws Exception;
    public static final int mod_binascii_a2b_base64 = 0x08018f64;
    public void mod_binascii_a2b_base64(InterruptHandler handler) throws Exception
    {
        call(this::mod_binascii_a2b_base64, handler);
    }

    // function: Function(address=134320168, size=50, name='mod_binascii_crc32', path='build/extmod/modubinascii.o', has_indirect=False)
    abstract protected void mod_binascii_crc32(int offset) throws Exception;
    public static final int mod_binascii_crc32 = 0x08019028;
    public void mod_binascii_crc32(InterruptHandler handler) throws Exception
    {
        call(this::mod_binascii_crc32, handler);
    }

    // function: Function(address=134320220, size=40, name='machine_mem_get_addr', path='build/extmod/machine_mem.o', has_indirect=False)
    abstract protected void machine_mem_get_addr(int offset) throws Exception;
    public static final int machine_mem_get_addr = 0x0801905c;
    public void machine_mem_get_addr(InterruptHandler handler) throws Exception
    {
        call(this::machine_mem_get_addr, handler);
    }

    // function: Function(address=134320260, size=20, name='machine_mem_print', path='build/extmod/machine_mem.o', has_indirect=False)
    abstract protected void machine_mem_print(int offset) throws Exception;
    public static final int machine_mem_print = 0x08019084;
    public void machine_mem_print(InterruptHandler handler) throws Exception
    {
        call(this::machine_mem_print, handler);
    }

    // function: Function(address=134320280, size=92, name='machine_mem_subscr', path='build/extmod/machine_mem.o', has_indirect=False)
    abstract protected void machine_mem_subscr(int offset) throws Exception;
    public static final int machine_mem_subscr = 0x08019098;
    public void machine_mem_subscr(InterruptHandler handler) throws Exception
    {
        call(this::machine_mem_subscr, handler);
    }

    // function: Function(address=134320372, size=96, name='yasmarang', path='build/extmod/modurandom.o', has_indirect=False)
    abstract protected void yasmarang(int offset) throws Exception;
    public static final int yasmarang = 0x080190f4;
    public void yasmarang(InterruptHandler handler) throws Exception
    {
        call(this::yasmarang, handler);
    }

    // function: Function(address=134320468, size=34, name='yasmarang_randbelow', path='build/extmod/modurandom.o', has_indirect=False)
    abstract protected void yasmarang_randbelow(int offset) throws Exception;
    public static final int yasmarang_randbelow = 0x08019154;
    public void yasmarang_randbelow(InterruptHandler handler) throws Exception
    {
        call(this::yasmarang_randbelow, handler);
    }

    // function: Function(address=134320502, size=66, name='mod_urandom_uniform', path='build/extmod/modurandom.o', has_indirect=False)
    abstract protected void mod_urandom_uniform(int offset) throws Exception;
    public static final int mod_urandom_uniform = 0x08019176;
    public void mod_urandom_uniform(InterruptHandler handler) throws Exception
    {
        call(this::mod_urandom_uniform, handler);
    }

    // function: Function(address=134320568, size=42, name='mod_urandom_randint', path='build/extmod/modurandom.o', has_indirect=False)
    abstract protected void mod_urandom_randint(int offset) throws Exception;
    public static final int mod_urandom_randint = 0x080191b8;
    public void mod_urandom_randint(InterruptHandler handler) throws Exception
    {
        call(this::mod_urandom_randint, handler);
    }

    // function: Function(address=134320610, size=106, name='mod_urandom_randrange', path='build/extmod/modurandom.o', has_indirect=False)
    abstract protected void mod_urandom_randrange(int offset) throws Exception;
    public static final int mod_urandom_randrange = 0x080191e2;
    public void mod_urandom_randrange(InterruptHandler handler) throws Exception
    {
        call(this::mod_urandom_randrange, handler);
    }

    // function: Function(address=134320716, size=52, name='mod_urandom_seed', path='build/extmod/modurandom.o', has_indirect=False)
    abstract protected void mod_urandom_seed(int offset) throws Exception;
    public static final int mod_urandom_seed = 0x0801924c;
    public void mod_urandom_seed(InterruptHandler handler) throws Exception
    {
        call(this::mod_urandom_seed, handler);
    }

    // function: Function(address=134320768, size=44, name='mod_urandom_getrandbits', path='build/extmod/modurandom.o', has_indirect=False)
    abstract protected void mod_urandom_getrandbits(int offset) throws Exception;
    public static final int mod_urandom_getrandbits = 0x08019280;
    public void mod_urandom_getrandbits(InterruptHandler handler) throws Exception
    {
        call(this::mod_urandom_getrandbits, handler);
    }

    // function: Function(address=134320812, size=52, name='mod_urandom_choice', path='build/extmod/modurandom.o', has_indirect=False)
    abstract protected void mod_urandom_choice(int offset) throws Exception;
    public static final int mod_urandom_choice = 0x080192ac;
    public void mod_urandom_choice(InterruptHandler handler) throws Exception
    {
        call(this::mod_urandom_choice, handler);
    }

    // function: Function(address=134320864, size=30, name='mod_urandom_random', path='build/extmod/modurandom.o', has_indirect=False)
    abstract protected void mod_urandom_random(int offset) throws Exception;
    public static final int mod_urandom_random = 0x080192e0;
    public void mod_urandom_random(InterruptHandler handler) throws Exception
    {
        call(this::mod_urandom_random, handler);
    }

    // function: Function(address=134320894, size=62, name='mp_vfs_proxy_call', path='build/extmod/vfs.o', has_indirect=False)
    abstract protected void mp_vfs_proxy_call(int offset) throws Exception;
    public static final int mp_vfs_proxy_call = 0x080192fe;
    public void mp_vfs_proxy_call(InterruptHandler handler) throws Exception
    {
        call(this::mp_vfs_proxy_call, handler);
    }

    // function: Function(address=134320956, size=160, name='mp_vfs_umount', path='build/extmod/vfs.o', has_indirect=False)
    abstract protected void mp_vfs_umount(int offset) throws Exception;
    public static final int mp_vfs_umount = 0x0801933c;
    public void mp_vfs_umount(InterruptHandler handler) throws Exception
    {
        call(this::mp_vfs_umount, handler);
    }

    // function: Function(address=134321116, size=116, name='mp_vfs_getcwd', path='build/extmod/vfs.o', has_indirect=False)
    abstract protected void mp_vfs_getcwd(int offset) throws Exception;
    public static final int mp_vfs_getcwd = 0x080193dc;
    public void mp_vfs_getcwd(InterruptHandler handler) throws Exception
    {
        call(this::mp_vfs_getcwd, handler);
    }

    // function: Function(address=134321232, size=112, name='mp_vfs_ilistdir_it_iternext', path='build/extmod/vfs.o', has_indirect=True)
    abstract protected void mp_vfs_ilistdir_it_iternext(int offset) throws Exception;
    public static final int mp_vfs_ilistdir_it_iternext = 0x08019450;
    public void mp_vfs_ilistdir_it_iternext(InterruptHandler handler) throws Exception
    {
        call(this::mp_vfs_ilistdir_it_iternext, handler);
    }

    // function: Function(address=134321344, size=140, name='mp_vfs_lookup_path', path='build/extmod/vfs.o', has_indirect=False)
    abstract protected void mp_vfs_lookup_path(int offset) throws Exception;
    public static final int mp_vfs_lookup_path = 0x080194c0;
    public void mp_vfs_lookup_path(InterruptHandler handler) throws Exception
    {
        call(this::mp_vfs_lookup_path, handler);
    }

    // function: Function(address=134321484, size=156, name='mp_vfs_mount', path='build/extmod/vfs.o', has_indirect=False)
    abstract protected void mp_vfs_mount(int offset) throws Exception;
    public static final int mp_vfs_mount = 0x0801954c;
    public void mp_vfs_mount(InterruptHandler handler) throws Exception
    {
        call(this::mp_vfs_mount, handler);
    }

    // function: Function(address=134321640, size=54, name='lookup_path', path='build/extmod/vfs.o', has_indirect=False)
    abstract protected void lookup_path(int offset) throws Exception;
    public static final int lookup_path = 0x080195e8;
    public void lookup_path(InterruptHandler handler) throws Exception
    {
        call(this::lookup_path, handler);
    }

    // function: Function(address=134321696, size=48, name='mp_vfs_open', path='build/extmod/vfs.o', has_indirect=False)
    abstract protected void mp_vfs_open(int offset) throws Exception;
    public static final int mp_vfs_open = 0x08019620;
    public void mp_vfs_open(InterruptHandler handler) throws Exception
    {
        call(this::mp_vfs_open, handler);
    }

    // function: Function(address=134321744, size=72, name='mp_vfs_chdir', path='build/extmod/vfs.o', has_indirect=False)
    abstract protected void mp_vfs_chdir(int offset) throws Exception;
    public static final int mp_vfs_chdir = 0x08019650;
    public void mp_vfs_chdir(InterruptHandler handler) throws Exception
    {
        call(this::mp_vfs_chdir, handler);
    }

    // function: Function(address=134321816, size=104, name='mp_vfs_ilistdir', path='build/extmod/vfs.o', has_indirect=False)
    abstract protected void mp_vfs_ilistdir(int offset) throws Exception;
    public static final int mp_vfs_ilistdir = 0x08019698;
    public void mp_vfs_ilistdir(InterruptHandler handler) throws Exception
    {
        call(this::mp_vfs_ilistdir, handler);
    }

    // function: Function(address=134321920, size=50, name='mp_vfs_listdir', path='build/extmod/vfs.o', has_indirect=False)
    abstract protected void mp_vfs_listdir(int offset) throws Exception;
    public static final int mp_vfs_listdir = 0x08019700;
    public void mp_vfs_listdir(InterruptHandler handler) throws Exception
    {
        call(this::mp_vfs_listdir, handler);
    }

    // function: Function(address=134321972, size=60, name='mp_vfs_mkdir', path='build/extmod/vfs.o', has_indirect=False)
    abstract protected void mp_vfs_mkdir(int offset) throws Exception;
    public static final int mp_vfs_mkdir = 0x08019734;
    public void mp_vfs_mkdir(InterruptHandler handler) throws Exception
    {
        call(this::mp_vfs_mkdir, handler);
    }

    // function: Function(address=134322032, size=22, name='mp_vfs_remove', path='build/extmod/vfs.o', has_indirect=False)
    abstract protected void mp_vfs_remove(int offset) throws Exception;
    public static final int mp_vfs_remove = 0x08019770;
    public void mp_vfs_remove(InterruptHandler handler) throws Exception
    {
        call(this::mp_vfs_remove, handler);
    }

    // function: Function(address=134322054, size=46, name='mp_vfs_rename', path='build/extmod/vfs.o', has_indirect=False)
    abstract protected void mp_vfs_rename(int offset) throws Exception;
    public static final int mp_vfs_rename = 0x08019786;
    public void mp_vfs_rename(InterruptHandler handler) throws Exception
    {
        call(this::mp_vfs_rename, handler);
    }

    // function: Function(address=134322100, size=22, name='mp_vfs_rmdir', path='build/extmod/vfs.o', has_indirect=False)
    abstract protected void mp_vfs_rmdir(int offset) throws Exception;
    public static final int mp_vfs_rmdir = 0x080197b4;
    public void mp_vfs_rmdir(InterruptHandler handler) throws Exception
    {
        call(this::mp_vfs_rmdir, handler);
    }

    // function: Function(address=134322124, size=60, name='mp_vfs_stat', path='build/extmod/vfs.o', has_indirect=False)
    abstract protected void mp_vfs_stat(int offset) throws Exception;
    public static final int mp_vfs_stat = 0x080197cc;
    public void mp_vfs_stat(InterruptHandler handler) throws Exception
    {
        call(this::mp_vfs_stat, handler);
    }

    // function: Function(address=134322184, size=92, name='mp_vfs_statvfs', path='build/extmod/vfs.o', has_indirect=False)
    abstract protected void mp_vfs_statvfs(int offset) throws Exception;
    public static final int mp_vfs_statvfs = 0x08019808;
    public void mp_vfs_statvfs(InterruptHandler handler) throws Exception
    {
        call(this::mp_vfs_statvfs, handler);
    }

    // function: Function(address=134322276, size=124, name='mp_vfs_import_stat', path='build/extmod/vfs.o', has_indirect=False)
    abstract protected void mp_vfs_import_stat(int offset) throws Exception;
    public static final int mp_vfs_import_stat = 0x08019864;
    public void mp_vfs_import_stat(InterruptHandler handler) throws Exception
    {
        call(this::mp_vfs_import_stat, handler);
    }

    // function: Function(address=134322400, size=20, name='mp_reader_vfs_close', path='build/extmod/vfs_reader.o', has_indirect=True)
    abstract protected void mp_reader_vfs_close(int offset) throws Exception;
    public static final int mp_reader_vfs_close = 0x080198e0;
    public void mp_reader_vfs_close(InterruptHandler handler) throws Exception
    {
        call(this::mp_reader_vfs_close, handler);
    }

    // function: Function(address=134322420, size=70, name='mp_reader_vfs_readbyte', path='build/extmod/vfs_reader.o', has_indirect=True)
    abstract protected void mp_reader_vfs_readbyte(int offset) throws Exception;
    public static final int mp_reader_vfs_readbyte = 0x080198f4;
    public void mp_reader_vfs_readbyte(InterruptHandler handler) throws Exception
    {
        call(this::mp_reader_vfs_readbyte, handler);
    }

    // function: Function(address=134322492, size=96, name='mp_reader_new_file', path='build/extmod/vfs_reader.o', has_indirect=False)
    abstract protected void mp_reader_new_file(int offset) throws Exception;
    public static final int mp_reader_new_file = 0x0801993c;
    public void mp_reader_new_file(InterruptHandler handler) throws Exception
    {
        call(this::mp_reader_new_file, handler);
    }

    // function: Function(address=134322588, size=28, name='time_ticks_diff', path='build/extmod/utime_mphal.o', has_indirect=False)
    abstract protected void time_ticks_diff(int offset) throws Exception;
    public static final int time_ticks_diff = 0x0801999c;
    public void time_ticks_diff(InterruptHandler handler) throws Exception
    {
        call(this::time_ticks_diff, handler);
    }

    // function: Function(address=134322616, size=32, name='time_sleep', path='build/extmod/utime_mphal.o', has_indirect=False)
    abstract protected void time_sleep(int offset) throws Exception;
    public static final int time_sleep = 0x080199b8;
    public void time_sleep(InterruptHandler handler) throws Exception
    {
        call(this::time_sleep, handler);
    }

    // function: Function(address=134322648, size=24, name='time_sleep_ms', path='build/extmod/utime_mphal.o', has_indirect=False)
    abstract protected void time_sleep_ms(int offset) throws Exception;
    public static final int time_sleep_ms = 0x080199d8;
    public void time_sleep_ms(InterruptHandler handler) throws Exception
    {
        call(this::time_sleep_ms, handler);
    }

    // function: Function(address=134322672, size=32, name='time_ticks_add', path='build/extmod/utime_mphal.o', has_indirect=False)
    abstract protected void time_ticks_add(int offset) throws Exception;
    public static final int time_ticks_add = 0x080199f0;
    public void time_ticks_add(InterruptHandler handler) throws Exception
    {
        call(this::time_ticks_add, handler);
    }

    // function: Function(address=134322704, size=24, name='time_ticks_ms', path='build/extmod/utime_mphal.o', has_indirect=False)
    abstract protected void time_ticks_ms(int offset) throws Exception;
    public static final int time_ticks_ms = 0x08019a10;
    public void time_ticks_ms(InterruptHandler handler) throws Exception
    {
        call(this::time_ticks_ms, handler);
    }

    // function: Function(address=134322728, size=24, name='time_ticks_cpu', path='build/extmod/utime_mphal.o', has_indirect=False)
    abstract protected void time_ticks_cpu(int offset) throws Exception;
    public static final int time_ticks_cpu = 0x08019a28;
    public void time_ticks_cpu(InterruptHandler handler) throws Exception
    {
        call(this::time_ticks_cpu, handler);
    }

    // function: Function(address=134322752, size=34, name='strn_print_strn', path='build/lib/utils/printf.o', has_indirect=True)
    abstract protected void strn_print_strn(int offset) throws Exception;
    public static final int strn_print_strn = 0x08019a40;
    public void strn_print_strn(InterruptHandler handler) throws Exception
    {
        call(this::strn_print_strn, handler);
    }

    // function: Function(address=134322788, size=28, name='printf', path='build/lib/utils/printf.o', has_indirect=False)
    abstract protected void printf(int offset) throws Exception;
    public static final int printf = 0x08019a64;
    public void printf(InterruptHandler handler) throws Exception
    {
        call(this::printf, handler);
    }

    // function: Function(address=134322816, size=20, name='putchar', path='build/lib/utils/printf.o', has_indirect=False)
    abstract protected void putchar(int offset) throws Exception;
    public static final int putchar = 0x08019a80;
    public void putchar(InterruptHandler handler) throws Exception
    {
        call(this::putchar, handler);
    }

    // function: Function(address=134322836, size=34, name='puts', path='build/lib/utils/printf.o', has_indirect=False)
    abstract protected void puts(int offset) throws Exception;
    public static final int puts = 0x08019a94;
    public void puts(InterruptHandler handler) throws Exception
    {
        call(this::puts, handler);
    }

    // function: Function(address=134322872, size=56, name='vsnprintf', path='build/lib/utils/printf.o', has_indirect=False)
    abstract protected void vsnprintf(int offset) throws Exception;
    public static final int vsnprintf = 0x08019ab8;
    public void vsnprintf(InterruptHandler handler) throws Exception
    {
        call(this::vsnprintf, handler);
    }

    // function: Function(address=134322928, size=22, name='snprintf', path='build/lib/utils/printf.o', has_indirect=False)
    abstract protected void snprintf(int offset) throws Exception;
    public static final int snprintf = 0x08019af0;
    public void snprintf(InterruptHandler handler) throws Exception
    {
        call(this::snprintf, handler);
    }

    // function: Function(address=134322952, size=200, name='main', path='build/main.o', has_indirect=False)
    abstract protected void main(int offset) throws Exception;
    public static final int main = 0x08019b08;
    public void main(InterruptHandler handler) throws Exception
    {
        call(this::main, handler);
    }

    // function: Function(address=134323152, size=44, name='Signal_Handler', path='build/machine.o', has_indirect=False)
    abstract protected void Signal_Handler(int offset) throws Exception;
    public static final int Signal_Handler = 0x08019bd0;
    public void Signal_Handler(InterruptHandler handler) throws Exception
    {
        call(this::Signal_Handler, handler);
    }

    // function: Function(address=134323196, size=14, name='_exit', path='build/machine.o', has_indirect=False)
    abstract protected void _exit(int offset) throws Exception;
    public static final int _exit = 0x08019bfc;
    public void _exit(InterruptHandler handler) throws Exception
    {
        call(this::_exit, handler);
    }

    // function: Function(address=134323210, size=16, name='_start', path='build/machine.o', has_indirect=False)
    abstract protected void _start(int offset) throws Exception;
    public static final int _start = 0x08019c0a;
    public void _start(InterruptHandler handler) throws Exception
    {
        call(this::_start, handler);
    }

    // function: Function(address=134323228, size=100, name='Reset_Handler', path='build/machine.o', has_indirect=False)
    abstract protected void Reset_Handler(int offset) throws Exception;
    public static final int Reset_Handler = 0x08019c1c;
    public void Reset_Handler(InterruptHandler handler) throws Exception
    {
        call(this::Reset_Handler, handler);
    }

    // function: Function(address=134323328, size=16, name='__fatal_error', path='build/machine.o', has_indirect=False)
    abstract protected void __fatal_error(int offset) throws Exception;
    public static final int __fatal_error = 0x08019c80;
    public void __fatal_error(InterruptHandler handler) throws Exception
    {
        call(this::__fatal_error, handler);
    }

    // function: Function(address=134323344, size=12, name='nlr_jump_fail', path='build/machine.o', has_indirect=False)
    abstract protected void nlr_jump_fail(int offset) throws Exception;
    public static final int nlr_jump_fail = 0x08019c90;
    public void nlr_jump_fail(InterruptHandler handler) throws Exception
    {
        call(this::nlr_jump_fail, handler);
    }

    // function: Function(address=134323356, size=16, name='mp_hal_stdin_rx_chr', path='build/mphalport.o', has_indirect=False)
    abstract protected void mp_hal_stdin_rx_chr(int offset) throws Exception;
    public static final int mp_hal_stdin_rx_chr = 0x08019c9c;
    public void mp_hal_stdin_rx_chr(InterruptHandler handler) throws Exception
    {
        call(this::mp_hal_stdin_rx_chr, handler);
    }

    // function: Function(address=134323372, size=32, name='mp_hal_stdout_tx_strn', path='build/mphalport.o', has_indirect=False)
    abstract protected void mp_hal_stdout_tx_strn(int offset) throws Exception;
    public static final int mp_hal_stdout_tx_strn = 0x08019cac;
    public void mp_hal_stdout_tx_strn(InterruptHandler handler) throws Exception
    {
        call(this::mp_hal_stdout_tx_strn, handler);
    }

    // function: Function(address=134323404, size=40, name='mp_hal_delay_ms', path='build/mphalport.o', has_indirect=False)
    abstract protected void mp_hal_delay_ms(int offset) throws Exception;
    public static final int mp_hal_delay_ms = 0x08019ccc;
    public void mp_hal_delay_ms(InterruptHandler handler) throws Exception
    {
        call(this::mp_hal_delay_ms, handler);
    }

    // function: Function(address=134323444, size=12, name='mp_hal_ticks_ms', path='build/mphalport.o', has_indirect=False)
    abstract protected void mp_hal_ticks_ms(int offset) throws Exception;
    public static final int mp_hal_ticks_ms = 0x08019cf4;
    public void mp_hal_ticks_ms(InterruptHandler handler) throws Exception
    {
        call(this::mp_hal_ticks_ms, handler);
    }

    // function: Function(address=134323456, size=12, name='mp_hal_ticks_cpu', path='build/mphalport.o', has_indirect=False)
    abstract protected void mp_hal_ticks_cpu(int offset) throws Exception;
    public static final int mp_hal_ticks_cpu = 0x08019d00;
    public void mp_hal_ticks_cpu(InterruptHandler handler) throws Exception
    {
        call(this::mp_hal_ticks_cpu, handler);
    }

    // function: Function(address=134323468, size=16, name='usystem_print_hook', path='build/modusystem.o', has_indirect=False)
    abstract protected void usystem_print_hook(int offset) throws Exception;
    public static final int usystem_print_hook = 0x08019d0c;
    public void usystem_print_hook(InterruptHandler handler) throws Exception
    {
        call(this::usystem_print_hook, handler);
    }

    // function: Function(address=134323484, size=32, name='usystem_debug', path='build/modusystem.o', has_indirect=False)
    abstract protected void usystem_debug(int offset) throws Exception;
    public static final int usystem_debug = 0x08019d1c;
    public void usystem_debug(InterruptHandler handler) throws Exception
    {
        call(this::usystem_debug, handler);
    }

    // function: Function(address=134323516, size=52, name='usystem_set_stdin_char', path='build/modusystem.o', has_indirect=False)
    abstract protected void usystem_set_stdin_char(int offset) throws Exception;
    public static final int usystem_set_stdin_char = 0x08019d3c;
    public void usystem_set_stdin_char(InterruptHandler handler) throws Exception
    {
        call(this::usystem_set_stdin_char, handler);
    }

    // function: Function(address=134323568, size=36, name='parse_2', path='build/modusystem.o', has_indirect=False)
    abstract protected void parse_2(int offset) throws Exception;
    public static final int parse_2 = 0x08019d70;
    public void parse_2(InterruptHandler handler) throws Exception
    {
        call(this::parse_2, handler);
    }

    // function: Function(address=134323604, size=30, name='usystem_syscall', path='build/modusystem.o', has_indirect=False)
    abstract protected void usystem_syscall(int offset) throws Exception;
    public static final int usystem_syscall = 0x08019d94;
    public void usystem_syscall(InterruptHandler handler) throws Exception
    {
        call(this::usystem_syscall, handler);
    }

    // function: Function(address=134323634, size=20, name='usystem_signal', path='build/modusystem.o', has_indirect=False)
    abstract protected void usystem_signal(int offset) throws Exception;
    public static final int usystem_signal = 0x08019db2;
    public void usystem_signal(InterruptHandler handler) throws Exception
    {
        call(this::usystem_signal, handler);
    }

    // function: Function(address=134323654, size=20, name='usystem_components', path='build/modusystem.o', has_indirect=False)
    abstract protected void usystem_components(int offset) throws Exception;
    public static final int usystem_components = 0x08019dc6;
    public void usystem_components(InterruptHandler handler) throws Exception
    {
        call(this::usystem_components, handler);
    }

    // function: Function(address=134323674, size=34, name='usystem_methods', path='build/modusystem.o', has_indirect=False)
    abstract protected void usystem_methods(int offset) throws Exception;
    public static final int usystem_methods = 0x08019dda;
    public void usystem_methods(InterruptHandler handler) throws Exception
    {
        call(this::usystem_methods, handler);
    }

    // function: Function(address=134323708, size=32, name='usystem_annotations', path='build/modusystem.o', has_indirect=False)
    abstract protected void usystem_annotations(int offset) throws Exception;
    public static final int usystem_annotations = 0x08019dfc;
    public void usystem_annotations(InterruptHandler handler) throws Exception
    {
        call(this::usystem_annotations, handler);
    }

    // function: Function(address=134323740, size=20, name='usystem_get_stdout_str', path='build/modusystem.o', has_indirect=False)
    abstract protected void usystem_get_stdout_str(int offset) throws Exception;
    public static final int usystem_get_stdout_str = 0x08019e1c;
    public void usystem_get_stdout_str(InterruptHandler handler) throws Exception
    {
        call(this::usystem_get_stdout_str, handler);
    }

    // function: Function(address=134323760, size=36, name='gc_collect', path='build/gccollect.o', has_indirect=False)
    abstract protected void gc_collect(int offset) throws Exception;
    public static final int gc_collect = 0x08019e30;
    public void gc_collect(InterruptHandler handler) throws Exception
    {
        call(this::gc_collect, handler);
    }

    // function: Function(address=134323796, size=10, name='vfs_openpie_file___exit__', path='build/openpie_vfs.o', has_indirect=False)
    abstract protected void vfs_openpie_file___exit__(int offset) throws Exception;
    public static final int vfs_openpie_file___exit__ = 0x08019e54;
    public void vfs_openpie_file___exit__(InterruptHandler handler) throws Exception
    {
        call(this::vfs_openpie_file___exit__, handler);
    }

    // function: Function(address=134323808, size=32, name='vfs_openpie_file_print', path='build/openpie_vfs.o', has_indirect=False)
    abstract protected void vfs_openpie_file_print(int offset) throws Exception;
    public static final int vfs_openpie_file_print = 0x08019e60;
    public void vfs_openpie_file_print(InterruptHandler handler) throws Exception
    {
        call(this::vfs_openpie_file_print, handler);
    }

    // function: Function(address=134323840, size=24, name='unlikely_check_fd_is_open_isra_0_part_1', path='build/openpie_vfs.o', has_indirect=False)
    abstract protected void unlikely_check_fd_is_open_isra_0_part_1(int offset) throws Exception;
    public static final int unlikely_check_fd_is_open_isra_0_part_1 = 0x08019e80;
    public void unlikely_check_fd_is_open_isra_0_part_1(InterruptHandler handler) throws Exception
    {
        call(this::unlikely_check_fd_is_open_isra_0_part_1, handler);
    }

    // function: Function(address=134323864, size=18, name='vfs_openpie_file_fileno', path='build/openpie_vfs.o', has_indirect=False)
    abstract protected void vfs_openpie_file_fileno(int offset) throws Exception;
    public static final int vfs_openpie_file_fileno = 0x08019e98;
    public void vfs_openpie_file_fileno(InterruptHandler handler) throws Exception
    {
        call(this::vfs_openpie_file_fileno, handler);
    }

    // function: Function(address=134323882, size=14, name='SVC_CALL_VFS', path='build/openpie_vfs.o', has_indirect=False)
    abstract protected void SVC_CALL_VFS(int offset) throws Exception;
    public static final int SVC_CALL_VFS = 0x08019eaa;
    public void SVC_CALL_VFS(InterruptHandler handler) throws Exception
    {
        call(this::SVC_CALL_VFS, handler);
    }

    // function: Function(address=134323896, size=16, name='SVC_CALL_VFS_OUT', path='build/openpie_vfs.o', has_indirect=False)
    abstract protected void SVC_CALL_VFS_OUT(int offset) throws Exception;
    public static final int SVC_CALL_VFS_OUT = 0x08019eb8;
    public void SVC_CALL_VFS_OUT(InterruptHandler handler) throws Exception
    {
        call(this::SVC_CALL_VFS_OUT, handler);
    }

    // function: Function(address=134323912, size=126, name='vfs_openpie_file_ioctl', path='build/openpie_vfs.o', has_indirect=False)
    abstract protected void vfs_openpie_file_ioctl(int offset) throws Exception;
    public static final int vfs_openpie_file_ioctl = 0x08019ec8;
    public void vfs_openpie_file_ioctl(InterruptHandler handler) throws Exception
    {
        call(this::vfs_openpie_file_ioctl, handler);
    }

    // function: Function(address=134324038, size=54, name='vfs_openpie_file_write', path='build/openpie_vfs.o', has_indirect=False)
    abstract protected void vfs_openpie_file_write(int offset) throws Exception;
    public static final int vfs_openpie_file_write = 0x08019f46;
    public void vfs_openpie_file_write(InterruptHandler handler) throws Exception
    {
        call(this::vfs_openpie_file_write, handler);
    }

    // function: Function(address=134324092, size=52, name='vfs_openpie_file_read', path='build/openpie_vfs.o', has_indirect=False)
    abstract protected void vfs_openpie_file_read(int offset) throws Exception;
    public static final int vfs_openpie_file_read = 0x08019f7c;
    public void vfs_openpie_file_read(InterruptHandler handler) throws Exception
    {
        call(this::vfs_openpie_file_read, handler);
    }

    // function: Function(address=134324144, size=92, name='mp_vfs_openpie_file_open', path='build/openpie_vfs.o', has_indirect=False)
    abstract protected void mp_vfs_openpie_file_open(int offset) throws Exception;
    public static final int mp_vfs_openpie_file_open = 0x08019fb0;
    public void mp_vfs_openpie_file_open(InterruptHandler handler) throws Exception
    {
        call(this::mp_vfs_openpie_file_open, handler);
    }

    // function: Function(address=134324236, size=48, name='vfs_openpie_file_make_new', path='build/openpie_vfs.o', has_indirect=False)
    abstract protected void vfs_openpie_file_make_new(int offset) throws Exception;
    public static final int vfs_openpie_file_make_new = 0x0801a00c;
    public void vfs_openpie_file_make_new(InterruptHandler handler) throws Exception
    {
        call(this::vfs_openpie_file_make_new, handler);
    }

    // function: Function(address=134324284, size=36, name='gc_helper_get_regs_and_sp', path='build/gchelper_m0.o', has_indirect=False)
    abstract protected void gc_helper_get_regs_and_sp(int offset) throws Exception;
    public static final int gc_helper_get_regs_and_sp = 0x0801a03c;
    public void gc_helper_get_regs_and_sp(InterruptHandler handler) throws Exception
    {
        call(this::gc_helper_get_regs_and_sp, handler);
    }

    // function: Function(address=134324320, size=8, name='stdio_obj___exit__', path='build/lib/utils/sys_stdio_mphal.o', has_indirect=False)
    abstract protected void stdio_obj___exit__(int offset) throws Exception;
    public static final int stdio_obj___exit__ = 0x0801a060;
    public void stdio_obj___exit__(InterruptHandler handler) throws Exception
    {
        call(this::stdio_obj___exit__, handler);
    }

    // function: Function(address=134324328, size=16, name='stdio_obj_print', path='build/lib/utils/sys_stdio_mphal.o', has_indirect=False)
    abstract protected void stdio_obj_print(int offset) throws Exception;
    public static final int stdio_obj_print = 0x0801a068;
    public void stdio_obj_print(InterruptHandler handler) throws Exception
    {
        call(this::stdio_obj_print, handler);
    }

    // function: Function(address=134324344, size=16, name='stdio_buffer_write', path='build/lib/utils/sys_stdio_mphal.o', has_indirect=False)
    abstract protected void stdio_buffer_write(int offset) throws Exception;
    public static final int stdio_buffer_write = 0x0801a078;
    public void stdio_buffer_write(InterruptHandler handler) throws Exception
    {
        call(this::stdio_buffer_write, handler);
    }

    // function: Function(address=134324360, size=26, name='stdio_buffer_read', path='build/lib/utils/sys_stdio_mphal.o', has_indirect=False)
    abstract protected void stdio_buffer_read(int offset) throws Exception;
    public static final int stdio_buffer_read = 0x0801a088;
    public void stdio_buffer_read(InterruptHandler handler) throws Exception
    {
        call(this::stdio_buffer_read, handler);
    }

    // function: Function(address=134324386, size=36, name='stdio_write', path='build/lib/utils/sys_stdio_mphal.o', has_indirect=False)
    abstract protected void stdio_write(int offset) throws Exception;
    public static final int stdio_write = 0x0801a0a2;
    public void stdio_write(InterruptHandler handler) throws Exception
    {
        call(this::stdio_write, handler);
    }

    // function: Function(address=134324422, size=50, name='stdio_read', path='build/lib/utils/sys_stdio_mphal.o', has_indirect=False)
    abstract protected void stdio_read(int offset) throws Exception;
    public static final int stdio_read = 0x0801a0c6;
    public void stdio_read(InterruptHandler handler) throws Exception
    {
        call(this::stdio_read, handler);
    }

    // function: Function(address=134324472, size=44, name='mp_hal_stdout_tx_strn_cooked', path='build/lib/utils/stdout_helpers.o', has_indirect=False)
    abstract protected void mp_hal_stdout_tx_strn_cooked(int offset) throws Exception;
    public static final int mp_hal_stdout_tx_strn_cooked = 0x0801a0f8;
    public void mp_hal_stdout_tx_strn_cooked(InterruptHandler handler) throws Exception
    {
        call(this::mp_hal_stdout_tx_strn_cooked, handler);
    }

    // function: Function(address=134324516, size=18, name='mp_hal_stdout_tx_str', path='build/lib/utils/stdout_helpers.o', has_indirect=False)
    abstract protected void mp_hal_stdout_tx_str(int offset) throws Exception;
    public static final int mp_hal_stdout_tx_str = 0x0801a124;
    public void mp_hal_stdout_tx_str(InterruptHandler handler) throws Exception
    {
        call(this::mp_hal_stdout_tx_str, handler);
    }

    // function: Function(address=134324536, size=28, name='mp_hal_set_interrupt_char', path='build/lib/utils/interrupt_char.o', has_indirect=False)
    abstract protected void mp_hal_set_interrupt_char(int offset) throws Exception;
    public static final int mp_hal_set_interrupt_char = 0x0801a138;
    public void mp_hal_set_interrupt_char(InterruptHandler handler) throws Exception
    {
        call(this::mp_hal_set_interrupt_char, handler);
    }

    // function: Function(address=134324564, size=308, name='parse_compile_execute', path='build/lib/utils/pyexec.o', has_indirect=False)
    abstract protected void parse_compile_execute(int offset) throws Exception;
    public static final int parse_compile_execute = 0x0801a154;
    public void parse_compile_execute(InterruptHandler handler) throws Exception
    {
        call(this::parse_compile_execute, handler);
    }

    // function: Function(address=134324872, size=160, name='pyexec_raw_repl', path='build/lib/utils/pyexec.o', has_indirect=False)
    abstract protected void pyexec_raw_repl(int offset) throws Exception;
    public static final int pyexec_raw_repl = 0x0801a288;
    public void pyexec_raw_repl(InterruptHandler handler) throws Exception
    {
        call(this::pyexec_raw_repl, handler);
    }

    // function: Function(address=134325032, size=272, name='pyexec_friendly_repl', path='build/lib/utils/pyexec.o', has_indirect=False)
    abstract protected void pyexec_friendly_repl(int offset) throws Exception;
    public static final int pyexec_friendly_repl = 0x0801a328;
    public void pyexec_friendly_repl(InterruptHandler handler) throws Exception
    {
        call(this::pyexec_friendly_repl, handler);
    }

    // function: Function(address=134325304, size=60, name='pyexec_frozen_module', path='build/lib/utils/pyexec.o', has_indirect=False)
    abstract protected void pyexec_frozen_module(int offset) throws Exception;
    public static final int pyexec_frozen_module = 0x0801a438;
    public void pyexec_frozen_module(InterruptHandler handler) throws Exception
    {
        call(this::pyexec_frozen_module, handler);
    }

    // function: Function(address=134325364, size=70, name='memcpy', path='build/lib/libc/string0.o', has_indirect=False)
    abstract protected void memcpy(int offset) throws Exception;
    public static final int memcpy = 0x0801a474;
    public void memcpy(InterruptHandler handler) throws Exception
    {
        call(this::memcpy, handler);
    }

    // function: Function(address=134325434, size=36, name='memmove', path='build/lib/libc/string0.o', has_indirect=False)
    abstract protected void memmove(int offset) throws Exception;
    public static final int memmove = 0x0801a4ba;
    public void memmove(InterruptHandler handler) throws Exception
    {
        call(this::memmove, handler);
    }

    // function: Function(address=134325470, size=64, name='memset', path='build/lib/libc/string0.o', has_indirect=False)
    abstract protected void memset(int offset) throws Exception;
    public static final int memset = 0x0801a4de;
    public void memset(InterruptHandler handler) throws Exception
    {
        call(this::memset, handler);
    }

    // function: Function(address=134325534, size=36, name='memcmp', path='build/lib/libc/string0.o', has_indirect=False)
    abstract protected void memcmp(int offset) throws Exception;
    public static final int memcmp = 0x0801a51e;
    public void memcmp(InterruptHandler handler) throws Exception
    {
        call(this::memcmp, handler);
    }

    // function: Function(address=134325570, size=18, name='strlen', path='build/lib/libc/string0.o', has_indirect=False)
    abstract protected void strlen(int offset) throws Exception;
    public static final int strlen = 0x0801a542;
    public void strlen(InterruptHandler handler) throws Exception
    {
        call(this::strlen, handler);
    }

    // function: Function(address=134325588, size=46, name='strcmp', path='build/lib/libc/string0.o', has_indirect=False)
    abstract protected void strcmp(int offset) throws Exception;
    public static final int strcmp = 0x0801a554;
    public void strcmp(InterruptHandler handler) throws Exception
    {
        call(this::strcmp, handler);
    }

    // function: Function(address=134325634, size=68, name='strncmp', path='build/lib/libc/string0.o', has_indirect=False)
    abstract protected void strncmp(int offset) throws Exception;
    public static final int strncmp = 0x0801a582;
    public void strncmp(InterruptHandler handler) throws Exception
    {
        call(this::strncmp, handler);
    }

    // function: Function(address=134325702, size=24, name='strchr', path='build/lib/libc/string0.o', has_indirect=False)
    abstract protected void strchr(int offset) throws Exception;
    public static final int strchr = 0x0801a5c6;
    public void strchr(InterruptHandler handler) throws Exception
    {
        call(this::strchr, handler);
    }

    // function: Function(address=134325728, size=48, name='mp_hal_move_cursor_back', path='build/lib/mp-readline/readline.o', has_indirect=False)
    abstract protected void mp_hal_move_cursor_back(int offset) throws Exception;
    public static final int mp_hal_move_cursor_back = 0x0801a5e0;
    public void mp_hal_move_cursor_back(InterruptHandler handler) throws Exception
    {
        call(this::mp_hal_move_cursor_back, handler);
    }

    // function: Function(address=134325776, size=36, name='readline_init', path='build/lib/mp-readline/readline.o', has_indirect=False)
    abstract protected void readline_init(int offset) throws Exception;
    public static final int readline_init = 0x0801a610;
    public void readline_init(InterruptHandler handler) throws Exception
    {
        call(this::readline_init, handler);
    }

    // function: Function(address=134325812, size=96, name='readline_push_history', path='build/lib/mp-readline/readline.o', has_indirect=False)
    abstract protected void readline_push_history(int offset) throws Exception;
    public static final int readline_push_history = 0x0801a634;
    public void readline_push_history(InterruptHandler handler) throws Exception
    {
        call(this::readline_push_history, handler);
    }

    // function: Function(address=134325908, size=628, name='readline_process_char', path='build/lib/mp-readline/readline.o', has_indirect=False)
    abstract protected void readline_process_char(int offset) throws Exception;
    public static final int readline_process_char = 0x0801a694;
    public void readline_process_char(InterruptHandler handler) throws Exception
    {
        call(this::readline_process_char, handler);
    }

    // function: Function(address=134326536, size=20, name='readline', path='build/lib/mp-readline/readline.o', has_indirect=False)
    abstract protected void readline(int offset) throws Exception;
    public static final int readline = 0x0801a908;
    public void readline(InterruptHandler handler) throws Exception
    {
        call(this::readline, handler);
    }

    // function: Function(address=134326556, size=98, name='scalbnf', path='build/lib/libm/math.o', has_indirect=False)
    abstract protected void scalbnf(int offset) throws Exception;
    public static final int scalbnf = 0x0801a91c;
    public void scalbnf(InterruptHandler handler) throws Exception
    {
        call(this::scalbnf, handler);
    }

    // function: Function(address=134326656, size=1696, name='powf', path='build/lib/libm/math.o', has_indirect=True)
    abstract protected void powf(int offset) throws Exception;
    public static final int powf = 0x0801a980;
    public void powf(InterruptHandler handler) throws Exception
    {
        call(this::powf, handler);
    }

    // function: Function(address=134328352, size=344, name='expf', path='build/lib/libm/math.o', has_indirect=True)
    abstract protected void expf(int offset) throws Exception;
    public static final int expf = 0x0801b020;
    public void expf(InterruptHandler handler) throws Exception
    {
        call(this::expf, handler);
    }

    // function: Function(address=134328696, size=664, name='expm1f', path='build/lib/libm/math.o', has_indirect=True)
    abstract protected void expm1f(int offset) throws Exception;
    public static final int expm1f = 0x0801b178;
    public void expm1f(InterruptHandler handler) throws Exception
    {
        call(this::expm1f, handler);
    }

    // function: Function(address=134329360, size=36, name='__expo2f', path='build/lib/libm/math.o', has_indirect=False)
    abstract protected void __expo2f(int offset) throws Exception;
    public static final int __expo2f = 0x0801b410;
    public void __expo2f(InterruptHandler handler) throws Exception
    {
        call(this::__expo2f, handler);
    }

    // function: Function(address=134329396, size=340, name='logf', path='build/lib/libm/math.o', has_indirect=False)
    abstract protected void logf(int offset) throws Exception;
    public static final int logf = 0x0801b434;
    public void logf(InterruptHandler handler) throws Exception
    {
        call(this::logf, handler);
    }

    // function: Function(address=134329736, size=20, name='log10f', path='build/lib/libm/math.o', has_indirect=True)
    abstract protected void log10f(int offset) throws Exception;
    public static final int log10f = 0x0801b588;
    public void log10f(InterruptHandler handler) throws Exception
    {
        call(this::log10f, handler);
    }

    // function: Function(address=134329756, size=144, name='coshf', path='build/lib/libm/math.o', has_indirect=True)
    abstract protected void coshf(int offset) throws Exception;
    public static final int coshf = 0x0801b59c;
    public void coshf(InterruptHandler handler) throws Exception
    {
        call(this::coshf, handler);
    }

    // function: Function(address=134329900, size=160, name='sinhf', path='build/lib/libm/math.o', has_indirect=True)
    abstract protected void sinhf(int offset) throws Exception;
    public static final int sinhf = 0x0801b62c;
    public void sinhf(InterruptHandler handler) throws Exception
    {
        call(this::sinhf, handler);
    }

    // function: Function(address=134330060, size=76, name='tanhf', path='build/lib/libm/math.o', has_indirect=True)
    abstract protected void tanhf(int offset) throws Exception;
    public static final int tanhf = 0x0801b6cc;
    public void tanhf(InterruptHandler handler) throws Exception
    {
        call(this::tanhf, handler);
    }

    // function: Function(address=134330136, size=88, name='ceilf', path='build/lib/libm/math.o', has_indirect=False)
    abstract protected void ceilf(int offset) throws Exception;
    public static final int ceilf = 0x0801b718;
    public void ceilf(InterruptHandler handler) throws Exception
    {
        call(this::ceilf, handler);
    }

    // function: Function(address=134330224, size=88, name='floorf', path='build/lib/libm/math.o', has_indirect=False)
    abstract protected void floorf(int offset) throws Exception;
    public static final int floorf = 0x0801b770;
    public void floorf(InterruptHandler handler) throws Exception
    {
        call(this::floorf, handler);
    }

    // function: Function(address=134330312, size=48, name='truncf', path='build/lib/libm/math.o', has_indirect=False)
    abstract protected void truncf(int offset) throws Exception;
    public static final int truncf = 0x0801b7c8;
    public void truncf(InterruptHandler handler) throws Exception
    {
        call(this::truncf, handler);
    }

    // function: Function(address=134330360, size=160, name='acoshf', path='build/lib/libm/acoshf.o', has_indirect=True)
    abstract protected void acoshf(int offset) throws Exception;
    public static final int acoshf = 0x0801b7f8;
    public void acoshf(InterruptHandler handler) throws Exception
    {
        call(this::acoshf, handler);
    }

    // function: Function(address=134330520, size=80, name='text_R', path='build/lib/libm/asinfacosf.o', has_indirect=False)
    abstract protected void text_R(int offset) throws Exception;
    public static final int text_R = 0x0801b898;
    public void text_R(InterruptHandler handler) throws Exception
    {
        call(this::text_R, handler);
    }

    // function: Function(address=134330600, size=196, name='asinf', path='build/lib/libm/asinfacosf.o', has_indirect=True)
    abstract protected void asinf(int offset) throws Exception;
    public static final int asinf = 0x0801b8e8;
    public void asinf(InterruptHandler handler) throws Exception
    {
        call(this::asinf, handler);
    }

    // function: Function(address=134330796, size=288, name='acosf', path='build/lib/libm/asinfacosf.o', has_indirect=True)
    abstract protected void acosf(int offset) throws Exception;
    public static final int acosf = 0x0801b9ac;
    public void acosf(InterruptHandler handler) throws Exception
    {
        call(this::acosf, handler);
    }

    // function: Function(address=134331084, size=200, name='asinhf', path='build/lib/libm/asinhf.o', has_indirect=True)
    abstract protected void asinhf(int offset) throws Exception;
    public static final int asinhf = 0x0801bacc;
    public void asinhf(InterruptHandler handler) throws Exception
    {
        call(this::asinhf, handler);
    }

    // function: Function(address=134331284, size=304, name='atan2f', path='build/lib/libm/atan2f.o', has_indirect=True)
    abstract protected void atan2f(int offset) throws Exception;
    public static final int atan2f = 0x0801bb94;
    public void atan2f(InterruptHandler handler) throws Exception
    {
        call(this::atan2f, handler);
    }

    // function: Function(address=134331588, size=456, name='atanf', path='build/lib/libm/atanf.o', has_indirect=True)
    abstract protected void atanf(int offset) throws Exception;
    public static final int atanf = 0x0801bcc4;
    public void atanf(InterruptHandler handler) throws Exception
    {
        call(this::atanf, handler);
    }

    // function: Function(address=134332044, size=144, name='atanhf', path='build/lib/libm/atanhf.o', has_indirect=True)
    abstract protected void atanhf(int offset) throws Exception;
    public static final int atanhf = 0x0801be8c;
    public void atanhf(InterruptHandler handler) throws Exception
    {
        call(this::atanhf, handler);
    }

    // function: Function(address=134332188, size=692, name='__ieee754_rem_pio2f', path='build/lib/libm/ef_rem_pio2.o', has_indirect=False)
    abstract protected void __ieee754_rem_pio2f(int offset) throws Exception;
    public static final int __ieee754_rem_pio2f = 0x0801bf1c;
    public void __ieee754_rem_pio2f(InterruptHandler handler) throws Exception
    {
        call(this::__ieee754_rem_pio2f, handler);
    }

    // function: Function(address=134332880, size=176, name='sqrtf', path='build/lib/libm/ef_sqrt.o', has_indirect=True)
    abstract protected void sqrtf(int offset) throws Exception;
    public static final int sqrtf = 0x0801c1d0;
    public void sqrtf(InterruptHandler handler) throws Exception
    {
        call(this::sqrtf, handler);
    }

    // function: Function(address=134333056, size=1976, name='__ieee754_lgammaf_r', path='build/lib/libm/erf_lgamma.o', has_indirect=False)
    abstract protected void __ieee754_lgammaf_r(int offset) throws Exception;
    public static final int __ieee754_lgammaf_r = 0x0801c280;
    public void __ieee754_lgammaf_r(InterruptHandler handler) throws Exception
    {
        call(this::__ieee754_lgammaf_r, handler);
    }

    // function: Function(address=134335032, size=208, name='fmodf', path='build/lib/libm/fmodf.o', has_indirect=True)
    abstract protected void fmodf(int offset) throws Exception;
    public static final int fmodf = 0x0801ca38;
    public void fmodf(InterruptHandler handler) throws Exception
    {
        call(this::fmodf, handler);
    }

    // function: Function(address=134335240, size=260, name='__kernel_cosf', path='build/lib/libm/kf_cos.o', has_indirect=False)
    abstract protected void __kernel_cosf(int offset) throws Exception;
    public static final int __kernel_cosf = 0x0801cb08;
    public void __kernel_cosf(InterruptHandler handler) throws Exception
    {
        call(this::__kernel_cosf, handler);
    }

    // function: Function(address=134335500, size=1428, name='__kernel_rem_pio2f', path='build/lib/libm/kf_rem_pio2.o', has_indirect=False)
    abstract protected void __kernel_rem_pio2f(int offset) throws Exception;
    public static final int __kernel_rem_pio2f = 0x0801cc0c;
    public void __kernel_rem_pio2f(InterruptHandler handler) throws Exception
    {
        call(this::__kernel_rem_pio2f, handler);
    }

    // function: Function(address=134336928, size=236, name='__kernel_sinf', path='build/lib/libm/kf_sin.o', has_indirect=False)
    abstract protected void __kernel_sinf(int offset) throws Exception;
    public static final int __kernel_sinf = 0x0801d1a0;
    public void __kernel_sinf(InterruptHandler handler) throws Exception
    {
        call(this::__kernel_sinf, handler);
    }

    // function: Function(address=134337164, size=604, name='__kernel_tanf', path='build/lib/libm/kf_tan.o', has_indirect=False)
    abstract protected void __kernel_tanf(int offset) throws Exception;
    public static final int __kernel_tanf = 0x0801d28c;
    public void __kernel_tanf(InterruptHandler handler) throws Exception
    {
        call(this::__kernel_tanf, handler);
    }

    // function: Function(address=134337768, size=448, name='log1pf', path='build/lib/libm/log1pf.o', has_indirect=False)
    abstract protected void log1pf(int offset) throws Exception;
    public static final int log1pf = 0x0801d4e8;
    public void log1pf(InterruptHandler handler) throws Exception
    {
        call(this::log1pf, handler);
    }

    // function: Function(address=134338216, size=74, name='nearbyintf', path='build/lib/libm/nearbyintf.o', has_indirect=False)
    abstract protected void nearbyintf(int offset) throws Exception;
    public static final int nearbyintf = 0x0801d6a8;
    public void nearbyintf(InterruptHandler handler) throws Exception
    {
        call(this::nearbyintf, handler);
    }

    // function: Function(address=134338292, size=108, name='cosf', path='build/lib/libm/sf_cos.o', has_indirect=True)
    abstract protected void cosf(int offset) throws Exception;
    public static final int cosf = 0x0801d6f4;
    public void cosf(InterruptHandler handler) throws Exception
    {
        call(this::cosf, handler);
    }

    // function: Function(address=134338400, size=1208, name='erff', path='build/lib/libm/sf_erf.o', has_indirect=True)
    abstract protected void erff(int offset) throws Exception;
    public static final int erff = 0x0801d760;
    public void erff(InterruptHandler handler) throws Exception
    {
        call(this::erff, handler);
    }

    // function: Function(address=134339608, size=1212, name='erfcf', path='build/lib/libm/sf_erf.o', has_indirect=True)
    abstract protected void erfcf(int offset) throws Exception;
    public static final int erfcf = 0x0801dc18;
    public void erfcf(InterruptHandler handler) throws Exception
    {
        call(this::erfcf, handler);
    }

    // function: Function(address=134340820, size=84, name='frexpf', path='build/lib/libm/sf_frexp.o', has_indirect=False)
    abstract protected void frexpf(int offset) throws Exception;
    public static final int frexpf = 0x0801e0d4;
    public void frexpf(InterruptHandler handler) throws Exception
    {
        call(this::frexpf, handler);
    }

    // function: Function(address=134340904, size=64, name='ldexpf', path='build/lib/libm/sf_ldexp.o', has_indirect=False)
    abstract protected void ldexpf(int offset) throws Exception;
    public static final int ldexpf = 0x0801e128;
    public void ldexpf(InterruptHandler handler) throws Exception
    {
        call(this::ldexpf, handler);
    }

    // function: Function(address=134340968, size=68, name='modff', path='build/lib/libm/sf_modf.o', has_indirect=False)
    abstract protected void modff(int offset) throws Exception;
    public static final int modff = 0x0801e168;
    public void modff(InterruptHandler handler) throws Exception
    {
        call(this::modff, handler);
    }

    // function: Function(address=134341036, size=112, name='sinf', path='build/lib/libm/sf_sin.o', has_indirect=True)
    abstract protected void sinf(int offset) throws Exception;
    public static final int sinf = 0x0801e1ac;
    public void sinf(InterruptHandler handler) throws Exception
    {
        call(this::sinf, handler);
    }

    // function: Function(address=134341148, size=68, name='tanf', path='build/lib/libm/sf_tan.o', has_indirect=True)
    abstract protected void tanf(int offset) throws Exception;
    public static final int tanf = 0x0801e21c;
    public void tanf(InterruptHandler handler) throws Exception
    {
        call(this::tanf, handler);
    }

    // function: Function(address=134341216, size=10, name='lgammaf', path='build/lib/libm/wf_lgamma.o', has_indirect=True)
    abstract protected void lgammaf(int offset) throws Exception;
    public static final int lgammaf = 0x0801e260;
    public void lgammaf(InterruptHandler handler) throws Exception
    {
        call(this::lgammaf, handler);
    }

    // function: Function(address=134341226, size=26, name='tgammaf', path='build/lib/libm/wf_tgamma.o', has_indirect=True)
    abstract protected void tgammaf(int offset) throws Exception;
    public static final int tgammaf = 0x0801e26a;
    public void tgammaf(InterruptHandler handler) throws Exception
    {
        call(this::tgammaf, handler);
    }

    // function: Function(address=134341252, size=276, name='__aeabi_uidiv', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(_udivsi3.o)', has_indirect=False)
    abstract protected void __aeabi_uidiv(int offset) throws Exception;
    public static final int __aeabi_uidiv = 0x0801e284;
    public void __aeabi_uidiv(InterruptHandler handler) throws Exception
    {
        call(this::__aeabi_uidiv, handler);
    }

    // function: Function(address=134341520, size=8, name='__aeabi_uidivmod', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(_udivsi3.o)', has_indirect=False)
    abstract protected void __aeabi_uidivmod(int offset) throws Exception;
    public static final int __aeabi_uidivmod = 0x0801e390;
    public void __aeabi_uidivmod(InterruptHandler handler) throws Exception
    {
        call(this::__aeabi_uidivmod, handler);
    }

    // function: Function(address=134341528, size=468, name='__divsi3', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(_divsi3.o)', has_indirect=False)
    abstract protected void __divsi3(int offset) throws Exception;
    public static final int __divsi3 = 0x0801e398;
    public void __divsi3(InterruptHandler handler) throws Exception
    {
        call(this::__divsi3, handler);
    }

    // function: Function(address=134341988, size=8, name='__aeabi_idivmod', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(_divsi3.o)', has_indirect=False)
    abstract protected void __aeabi_idivmod(int offset) throws Exception;
    public static final int __aeabi_idivmod = 0x0801e564;
    public void __aeabi_idivmod(InterruptHandler handler) throws Exception
    {
        call(this::__aeabi_idivmod, handler);
    }

    // function: Function(address=134341996, size=4, name='__aeabi_idiv0', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(_dvmd_tls.o)', has_indirect=False)
    abstract protected void __aeabi_idiv0(int offset) throws Exception;
    public static final int __aeabi_idiv0 = 0x0801e56c;
    public void __aeabi_idiv0(InterruptHandler handler) throws Exception
    {
        call(this::__aeabi_idiv0, handler);
    }

    // function: Function(address=134342000, size=116, name='__aeabi_cfrcmple', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(_arm_cmpsf2.o)', has_indirect=False)
    abstract protected void __aeabi_cfrcmple(int offset) throws Exception;
    public static final int __aeabi_cfrcmple = 0x0801e570;
    public void __aeabi_cfrcmple(InterruptHandler handler) throws Exception
    {
        call(this::__aeabi_cfrcmple, handler);
    }

    // function: Function(address=134342008, size=16, name='__aeabi_cfcmpeq', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(_arm_cmpsf2.o)', has_indirect=False)
    abstract protected void __aeabi_cfcmpeq(int offset) throws Exception;
    public static final int __aeabi_cfcmpeq = 0x0801e578;
    public void __aeabi_cfcmpeq(InterruptHandler handler) throws Exception
    {
        call(this::__aeabi_cfcmpeq, handler);
    }

    // function: Function(address=134342024, size=12, name='__aeabi_fcmpeq', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(_arm_cmpsf2.o)', has_indirect=False)
    abstract protected void __aeabi_fcmpeq(int offset) throws Exception;
    public static final int __aeabi_fcmpeq = 0x0801e588;
    public void __aeabi_fcmpeq(InterruptHandler handler) throws Exception
    {
        call(this::__aeabi_fcmpeq, handler);
    }

    // function: Function(address=134342036, size=20, name='__aeabi_fcmplt', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(_arm_cmpsf2.o)', has_indirect=False)
    abstract protected void __aeabi_fcmplt(int offset) throws Exception;
    public static final int __aeabi_fcmplt = 0x0801e594;
    public void __aeabi_fcmplt(InterruptHandler handler) throws Exception
    {
        call(this::__aeabi_fcmplt, handler);
    }

    // function: Function(address=134342056, size=20, name='__aeabi_fcmple', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(_arm_cmpsf2.o)', has_indirect=False)
    abstract protected void __aeabi_fcmple(int offset) throws Exception;
    public static final int __aeabi_fcmple = 0x0801e5a8;
    public void __aeabi_fcmple(InterruptHandler handler) throws Exception
    {
        call(this::__aeabi_fcmple, handler);
    }

    // function: Function(address=134342076, size=20, name='__aeabi_fcmpgt', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(_arm_cmpsf2.o)', has_indirect=False)
    abstract protected void __aeabi_fcmpgt(int offset) throws Exception;
    public static final int __aeabi_fcmpgt = 0x0801e5bc;
    public void __aeabi_fcmpgt(InterruptHandler handler) throws Exception
    {
        call(this::__aeabi_fcmpgt, handler);
    }

    // function: Function(address=134342096, size=20, name='__aeabi_fcmpge', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(_arm_cmpsf2.o)', has_indirect=False)
    abstract protected void __aeabi_fcmpge(int offset) throws Exception;
    public static final int __aeabi_fcmpge = 0x0801e5d0;
    public void __aeabi_fcmpge(InterruptHandler handler) throws Exception
    {
        call(this::__aeabi_fcmpge, handler);
    }

    // function: Function(address=134342116, size=48, name='__fixunssfsi', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(_fixunssfsi.o)', has_indirect=False)
    abstract protected void __fixunssfsi(int offset) throws Exception;
    public static final int __fixunssfsi = 0x0801e5e4;
    public void __fixunssfsi(InterruptHandler handler) throws Exception
    {
        call(this::__fixunssfsi, handler);
    }

    // function: Function(address=134342164, size=820, name='__aeabi_fadd', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(addsf3.o)', has_indirect=False)
    abstract protected void __aeabi_fadd(int offset) throws Exception;
    public static final int __aeabi_fadd = 0x0801e614;
    public void __aeabi_fadd(InterruptHandler handler) throws Exception
    {
        call(this::__aeabi_fadd, handler);
    }

    // function: Function(address=134342984, size=548, name='__aeabi_fdiv', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(divsf3.o)', has_indirect=False)
    abstract protected void __aeabi_fdiv(int offset) throws Exception;
    public static final int __aeabi_fdiv = 0x0801e948;
    public void __aeabi_fdiv(InterruptHandler handler) throws Exception
    {
        call(this::__aeabi_fdiv, handler);
    }

    // function: Function(address=134343532, size=80, name='__eqsf2', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(eqsf2.o)', has_indirect=False)
    abstract protected void __eqsf2(int offset) throws Exception;
    public static final int __eqsf2 = 0x0801eb6c;
    public void __eqsf2(InterruptHandler handler) throws Exception
    {
        call(this::__eqsf2, handler);
    }

    // function: Function(address=134343612, size=156, name='__gesf2', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(gesf2.o)', has_indirect=False)
    abstract protected void __gesf2(int offset) throws Exception;
    public static final int __gesf2 = 0x0801ebbc;
    public void __gesf2(InterruptHandler handler) throws Exception
    {
        call(this::__gesf2, handler);
    }

    // function: Function(address=134343768, size=160, name='__ltsf2', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(lesf2.o)', has_indirect=False)
    abstract protected void __ltsf2(int offset) throws Exception;
    public static final int __ltsf2 = 0x0801ec58;
    public void __ltsf2(InterruptHandler handler) throws Exception
    {
        call(this::__ltsf2, handler);
    }

    // function: Function(address=134343928, size=612, name='__aeabi_fmul', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(mulsf3.o)', has_indirect=False)
    abstract protected void __aeabi_fmul(int offset) throws Exception;
    public static final int __aeabi_fmul = 0x0801ecf8;
    public void __aeabi_fmul(InterruptHandler handler) throws Exception
    {
        call(this::__aeabi_fmul, handler);
    }

    // function: Function(address=134344540, size=904, name='__aeabi_fsub', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(subsf3.o)', has_indirect=False)
    abstract protected void __aeabi_fsub(int offset) throws Exception;
    public static final int __aeabi_fsub = 0x0801ef5c;
    public void __aeabi_fsub(InterruptHandler handler) throws Exception
    {
        call(this::__aeabi_fsub, handler);
    }

    // function: Function(address=134345444, size=44, name='__aeabi_fcmpun', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(unordsf2.o)', has_indirect=False)
    abstract protected void __aeabi_fcmpun(int offset) throws Exception;
    public static final int __aeabi_fcmpun = 0x0801f2e4;
    public void __aeabi_fcmpun(InterruptHandler handler) throws Exception
    {
        call(this::__aeabi_fcmpun, handler);
    }

    // function: Function(address=134345488, size=64, name='__aeabi_f2iz', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(fixsfsi.o)', has_indirect=False)
    abstract protected void __aeabi_f2iz(int offset) throws Exception;
    public static final int __aeabi_f2iz = 0x0801f310;
    public void __aeabi_f2iz(InterruptHandler handler) throws Exception
    {
        call(this::__aeabi_f2iz, handler);
    }

    // function: Function(address=134345552, size=148, name='__aeabi_i2f', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(floatsisf.o)', has_indirect=False)
    abstract protected void __aeabi_i2f(int offset) throws Exception;
    public static final int __aeabi_i2f = 0x0801f350;
    public void __aeabi_i2f(InterruptHandler handler) throws Exception
    {
        call(this::__aeabi_i2f, handler);
    }

    // function: Function(address=134345700, size=128, name='__aeabi_ui2f', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(floatunsisf.o)', has_indirect=False)
    abstract protected void __aeabi_ui2f(int offset) throws Exception;
    public static final int __aeabi_ui2f = 0x0801f3e4;
    public void __aeabi_ui2f(InterruptHandler handler) throws Exception
    {
        call(this::__aeabi_ui2f, handler);
    }

    // function: Function(address=134345828, size=116, name='__aeabi_i2d', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(floatsidf.o)', has_indirect=False)
    abstract protected void __aeabi_i2d(int offset) throws Exception;
    public static final int __aeabi_i2d = 0x0801f464;
    public void __aeabi_i2d(InterruptHandler handler) throws Exception
    {
        call(this::__aeabi_i2d, handler);
    }

    // function: Function(address=134345944, size=164, name='__aeabi_f2d', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(extendsfdf2.o)', has_indirect=False)
    abstract protected void __aeabi_f2d(int offset) throws Exception;
    public static final int __aeabi_f2d = 0x0801f4d8;
    public void __aeabi_f2d(InterruptHandler handler) throws Exception
    {
        call(this::__aeabi_f2d, handler);
    }

    // function: Function(address=134346108, size=264, name='__aeabi_d2f', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(truncdfsf2.o)', has_indirect=False)
    abstract protected void __aeabi_d2f(int offset) throws Exception;
    public static final int __aeabi_d2f = 0x0801f57c;
    public void __aeabi_d2f(InterruptHandler handler) throws Exception
    {
        call(this::__aeabi_d2f, handler);
    }

    // function: Function(address=134346372, size=60, name='__clzsi2', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(_clzsi2.o)', has_indirect=False)
    abstract protected void __clzsi2(int offset) throws Exception;
    public static final int __clzsi2 = 0x0801f684;
    public void __clzsi2(InterruptHandler handler) throws Exception
    {
        call(this::__clzsi2, handler);
    }

} // MicroPython_link
