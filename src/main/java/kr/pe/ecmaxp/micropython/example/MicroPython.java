package kr.pe.ecmaxp.micropython.example;

import kr.pe.ecmaxp.thumbjk.Callback;
import kr.pe.ecmaxp.thumbsk.CPU;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

import static kr.pe.ecmaxp.micropython.example.MicroPython_vals.*;

public class MicroPython extends MicroPython_main
{
    public MicroPython(@NotNull CPU cpu)
    {
        super(cpu);
    }

    @Override
    @NotNull
    protected HashMap<Integer, Callback> gen_hints() {
        HashMap<Integer, Callback> map = new HashMap<>();
        map.put(nlr_push_tail, this::nlr_push_tail);
        map.put(nlr_pop, this::nlr_pop);
        map.put(nlr_push, this::nlr_push);
        map.put(nlr_jump, this::nlr_jump);
        map.put(m_malloc, this::m_malloc);
        map.put(m_malloc_maybe, this::m_malloc_maybe);
        map.put(m_malloc0, this::m_malloc0);
        map.put(m_realloc, this::m_realloc);
        map.put(m_realloc_maybe, this::m_realloc_maybe);
        map.put(m_free, this::m_free);
        map.put(m_get_total_bytes_allocated, this::m_get_total_bytes_allocated);
        map.put(m_get_current_bytes_allocated, this::m_get_current_bytes_allocated);
        map.put(m_get_peak_bytes_allocated, this::m_get_peak_bytes_allocated);
        map.put(gc_mark_subtree, this::gc_mark_subtree);
        map.put(gc_init, this::gc_init);
        map.put(gc_lock, this::gc_lock);
        map.put(gc_unlock, this::gc_unlock);
        map.put(gc_is_locked, this::gc_is_locked);
        map.put(gc_collect_start, this::gc_collect_start);
        map.put(gc_collect_root, this::gc_collect_root);
        map.put(gc_collect_end, this::gc_collect_end);
        map.put(gc_info, this::gc_info);
        map.put(gc_alloc, this::gc_alloc);
        map.put(gc_free, this::gc_free);
        map.put(gc_nbytes, this::gc_nbytes);
        map.put(gc_realloc, this::gc_realloc);
        map.put(gc_dump_info, this::gc_dump_info);
        map.put(gc_dump_alloc_table, this::gc_dump_alloc_table);
        map.put(mp_pystack_init, this::mp_pystack_init);
        map.put(mp_pystack_alloc, this::mp_pystack_alloc);
        map.put(find_qstr, this::find_qstr);
        map.put(qstr_compute_hash, this::qstr_compute_hash);
        map.put(qstr_init, this::qstr_init);
        map.put(qstr_find_strn, this::qstr_find_strn);
        map.put(qstr_from_strn, this::qstr_from_strn);
        map.put(qstr_from_str, this::qstr_from_str);
        map.put(qstr_hash, this::qstr_hash);
        map.put(qstr_len, this::qstr_len);
        map.put(qstr_str, this::qstr_str);
        map.put(qstr_data, this::qstr_data);
        map.put(qstr_pool_info, this::qstr_pool_info);
        map.put(qstr_dump_data, this::qstr_dump_data);
        map.put(vstr_ensure_extra, this::vstr_ensure_extra);
        map.put(vstr_add_strn, this::vstr_add_strn);
        map.put(vstr_ins_blank_bytes_constprop_2, this::vstr_ins_blank_bytes_constprop_2);
        map.put(vstr_init, this::vstr_init);
        map.put(vstr_init_len, this::vstr_init_len);
        map.put(vstr_init_fixed_buf, this::vstr_init_fixed_buf);
        map.put(vstr_init_print, this::vstr_init_print);
        map.put(vstr_clear, this::vstr_clear);
        map.put(vstr_new, this::vstr_new);
        map.put(vstr_free, this::vstr_free);
        map.put(vstr_extend, this::vstr_extend);
        map.put(vstr_add_len, this::vstr_add_len);
        map.put(vstr_null_terminated_str, this::vstr_null_terminated_str);
        map.put(vstr_add_byte, this::vstr_add_byte);
        map.put(vstr_add_char, this::vstr_add_char);
        map.put(vstr_add_str, this::vstr_add_str);
        map.put(vstr_ins_byte, this::vstr_ins_byte);
        map.put(vstr_ins_char, this::vstr_ins_char);
        map.put(vstr_cut_tail_bytes, this::vstr_cut_tail_bytes);
        map.put(vstr_cut_out_bytes, this::vstr_cut_out_bytes);
        map.put(plat_print_strn, this::plat_print_strn);
        map.put(mp_print_str, this::mp_print_str);
        map.put(mp_print_strn, this::mp_print_strn);
        map.put(mp_print_int, this::mp_print_int);
        map.put(mp_print_mp_int, this::mp_print_mp_int);
        map.put(mp_print_float, this::mp_print_float);
        map.put(mp_vprintf, this::mp_vprintf);
        map.put(mp_printf, this::mp_printf);
        map.put(utf8_get_char, this::utf8_get_char);
        map.put(utf8_next_char, this::utf8_next_char);
        map.put(utf8_ptr_to_index, this::utf8_ptr_to_index);
        map.put(utf8_charlen, this::utf8_charlen);
        map.put(unichar_isspace, this::unichar_isspace);
        map.put(unichar_isalpha, this::unichar_isalpha);
        map.put(unichar_isdigit, this::unichar_isdigit);
        map.put(unichar_isxdigit, this::unichar_isxdigit);
        map.put(unichar_isident, this::unichar_isident);
        map.put(unichar_isupper, this::unichar_isupper);
        map.put(unichar_islower, this::unichar_islower);
        map.put(unichar_tolower, this::unichar_tolower);
        map.put(unichar_toupper, this::unichar_toupper);
        map.put(unichar_xdigit_value, this::unichar_xdigit_value);
        map.put(utf8_check, this::utf8_check);
        map.put(mpn_remove_trailing_zeros, this::mpn_remove_trailing_zeros);
        map.put(text_mpn_shr, this::text_mpn_shr);
        map.put(text_mpn_add, this::text_mpn_add);
        map.put(text_mpn_sub, this::text_mpn_sub);
        map.put(mpn_xor_neg, this::mpn_xor_neg);
        map.put(mpz_need_dig, this::mpz_need_dig);
        map.put(mpz_clone, this::mpz_clone);
        map.put(mpn_cmp_part_1, this::mpn_cmp_part_1);
        map.put(mpz_free, this::mpz_free);
        map.put(mpz_set_from_int_part_4, this::mpz_set_from_int_part_4);
        map.put(mpz_init_zero, this::mpz_init_zero);
        map.put(mpz_deinit, this::mpz_deinit);
        map.put(mpz_set, this::mpz_set);
        map.put(mpz_set_from_int, this::mpz_set_from_int);
        map.put(mpz_init_from_int, this::mpz_init_from_int);
        map.put(mpz_init_fixed_from_int, this::mpz_init_fixed_from_int);
        map.put(mpz_set_from_ll, this::mpz_set_from_ll);
        map.put(mpz_set_from_float, this::mpz_set_from_float);
        map.put(mpz_set_from_str, this::mpz_set_from_str);
        map.put(mpz_set_from_bytes, this::mpz_set_from_bytes);
        map.put(mpz_cmp, this::mpz_cmp);
        map.put(mpz_abs_inpl, this::mpz_abs_inpl);
        map.put(mpz_neg_inpl, this::mpz_neg_inpl);
        map.put(mpz_not_inpl, this::mpz_not_inpl);
        map.put(mpz_shl_inpl, this::mpz_shl_inpl);
        map.put(mpz_shr_inpl, this::mpz_shr_inpl);
        map.put(mpz_add_inpl, this::mpz_add_inpl);
        map.put(mpz_sub_inpl, this::mpz_sub_inpl);
        map.put(mpz_and_inpl, this::mpz_and_inpl);
        map.put(mpz_or_inpl, this::mpz_or_inpl);
        map.put(mpz_xor_inpl, this::mpz_xor_inpl);
        map.put(mpz_mul_inpl, this::mpz_mul_inpl);
        map.put(mpz_pow_inpl, this::mpz_pow_inpl);
        map.put(mpz_divmod_inpl, this::mpz_divmod_inpl);
        map.put(mpz_pow3_inpl, this::mpz_pow3_inpl);
        map.put(mpz_hash, this::mpz_hash);
        map.put(mpz_as_int_checked, this::mpz_as_int_checked);
        map.put(mpz_as_bytes, this::mpz_as_bytes);
        map.put(mpz_as_float, this::mpz_as_float);
        map.put(mpz_as_str_inpl, this::mpz_as_str_inpl);
        map.put(mp_reader_mem_readbyte, this::mp_reader_mem_readbyte);
        map.put(mp_reader_mem_close, this::mp_reader_mem_close);
        map.put(mp_reader_new_mem, this::mp_reader_new_mem);
        map.put(is_string_or_bytes, this::is_string_or_bytes);
        map.put(next_char, this::next_char);
        map.put(skip_whitespace, this::skip_whitespace);
        map.put(mp_lexer_to_next, this::mp_lexer_to_next);
        map.put(mp_lexer_new, this::mp_lexer_new);
        map.put(mp_lexer_new_from_str_len, this::mp_lexer_new_from_str_len);
        map.put(mp_lexer_new_from_file, this::mp_lexer_new_from_file);
        map.put(mp_lexer_free, this::mp_lexer_free);
        map.put(pop_result, this::pop_result);
        map.put(peek_result, this::peek_result);
        map.put(parser_alloc, this::parser_alloc);
        map.put(push_result_node, this::push_result_node);
        map.put(push_rule, this::push_rule);
        map.put(push_rule_from_arg, this::push_rule_from_arg);
        map.put(push_result_token, this::push_result_token);
        map.put(mp_parse_node_is_const_false, this::mp_parse_node_is_const_false);
        map.put(mp_parse_node_is_const_true, this::mp_parse_node_is_const_true);
        map.put(mp_parse_node_get_int_maybe, this::mp_parse_node_get_int_maybe);
        map.put(push_result_rule, this::push_result_rule);
        map.put(mp_parse_node_extract_list, this::mp_parse_node_extract_list);
        map.put(mp_parse, this::mp_parse);
        map.put(mp_parse_tree_clear, this::mp_parse_tree_clear);
        map.put(scope_new, this::scope_new);
        map.put(scope_free, this::scope_free);
        map.put(scope_find, this::scope_find);
        map.put(scope_find_or_add_id, this::scope_find_or_add_id);
        map.put(scope_find_global, this::scope_find_global);
        map.put(scope_find_local_and_close_over, this::scope_find_local_and_close_over);
        map.put(compile_increase_except_level, this::compile_increase_except_level);
        map.put(apply_to_single_or_list, this::apply_to_single_or_list);
        map.put(compile_del_stmt, this::compile_del_stmt);
        map.put(compile_import_name, this::compile_import_name);
        map.put(scope_new_and_link, this::scope_new_and_link);
        map.put(compile_trailer_period, this::compile_trailer_period);
        map.put(compile_const_object, this::compile_const_object);
        map.put(close_over_variables_etc, this::close_over_variables_etc);
        map.put(compile_funcdef_lambdef, this::compile_funcdef_lambdef);
        map.put(compile_lambdef, this::compile_lambdef);
        map.put(compile_funcdef_helper, this::compile_funcdef_helper);
        map.put(compile_error_set_line_isra_0, this::compile_error_set_line_isra_0);
        map.put(compile_syntax_error, this::compile_syntax_error);
        map.put(compile_star_expr, this::compile_star_expr);
        map.put(compile_break_cont_stmt, this::compile_break_cont_stmt);
        map.put(compile_scope_func_lambda_param_isra_5, this::compile_scope_func_lambda_param_isra_5);
        map.put(compile_scope_lambda_param, this::compile_scope_lambda_param);
        map.put(compile_scope_func_param, this::compile_scope_func_param);
        map.put(compile_yield_from_isra_6, this::compile_yield_from_isra_6);
        map.put(compile_await_object_method, this::compile_await_object_method);
        map.put(compile_load_id, this::compile_load_id);
        map.put(compile_store_id, this::compile_store_id);
        map.put(compile_funcdef, this::compile_funcdef);
        map.put(compile_delete_id, this::compile_delete_id);
        map.put(compile_node, this::compile_node);
        map.put(c_assign, this::c_assign);
        map.put(c_assign_tuple, this::c_assign_tuple);
        map.put(c_if_cond, this::c_if_cond);
        map.put(compile_scope_comp_iter, this::compile_scope_comp_iter);
        map.put(check_for_doc_string, this::check_for_doc_string);
        map.put(compile_scope, this::compile_scope);
        map.put(compile_dictorsetmaker_item, this::compile_dictorsetmaker_item);
        map.put(compile_subscript, this::compile_subscript);
        map.put(compile_trailer_bracket, this::compile_trailer_bracket);
        map.put(text_c_tuple, this::text_c_tuple);
        map.put(compile_generic_tuple, this::compile_generic_tuple);
        map.put(compile_while_stmt, this::compile_while_stmt);
        map.put(compile_yield_stmt, this::compile_yield_stmt);
        map.put(c_del_stmt, this::c_del_stmt);
        map.put(compile_generic_all_nodes, this::compile_generic_all_nodes);
        map.put(compile_power, this::compile_power);
        map.put(compile_if_stmt, this::compile_if_stmt);
        map.put(compile_comprehension, this::compile_comprehension);
        map.put(compile_atom_bracket, this::compile_atom_bracket);
        map.put(compile_trailer_paren_helper, this::compile_trailer_paren_helper);
        map.put(compile_classdef_helper, this::compile_classdef_helper);
        map.put(compile_classdef, this::compile_classdef);
        map.put(compile_trailer_paren, this::compile_trailer_paren);
        map.put(compile_decorated, this::compile_decorated);
        map.put(compile_atom_brace, this::compile_atom_brace);
        map.put(compile_funcdef_lambdef_param, this::compile_funcdef_lambdef_param);
        map.put(compile_atom_expr_normal, this::compile_atom_expr_normal);
        map.put(compile_term, this::compile_term);
        map.put(compile_binary_op, this::compile_binary_op);
        map.put(compile_expr_stmt, this::compile_expr_stmt);
        map.put(compile_factor_2, this::compile_factor_2);
        map.put(compile_not_test_2, this::compile_not_test_2);
        map.put(compile_or_and_test, this::compile_or_and_test);
        map.put(compile_comparison, this::compile_comparison);
        map.put(compile_test_if_expr, this::compile_test_if_expr);
        map.put(compile_for_stmt, this::compile_for_stmt);
        map.put(compile_with_stmt_helper, this::compile_with_stmt_helper);
        map.put(compile_with_stmt, this::compile_with_stmt);
        map.put(compile_try_except, this::compile_try_except);
        map.put(compile_try_finally, this::compile_try_finally);
        map.put(compile_try_stmt, this::compile_try_stmt);
        map.put(compile_async_with_stmt_helper, this::compile_async_with_stmt_helper);
        map.put(compile_async_stmt, this::compile_async_stmt);
        map.put(compile_yield_expr, this::compile_yield_expr);
        map.put(compile_return_stmt, this::compile_return_stmt);
        map.put(compile_atom_paren, this::compile_atom_paren);
        map.put(compile_atom_expr_await, this::compile_atom_expr_await);
        map.put(compile_assert_stmt, this::compile_assert_stmt);
        map.put(compile_raise_stmt, this::compile_raise_stmt);
        map.put(compile_global_nonlocal_stmt, this::compile_global_nonlocal_stmt);
        map.put(do_import_name_isra_19, this::do_import_name_isra_19);
        map.put(compile_import_from, this::compile_import_from);
        map.put(compile_dotted_as_name, this::compile_dotted_as_name);
        map.put(mp_compile, this::mp_compile);
        map.put(mp_emit_common_get_id_for_load, this::mp_emit_common_get_id_for_load);
        map.put(mp_emit_common_get_id_for_modification, this::mp_emit_common_get_id_for_modification);
        map.put(mp_emit_common_id_op, this::mp_emit_common_id_op);
        map.put(emit_write_uint, this::emit_write_uint);
        map.put(emit_get_cur_to_write_code_info, this::emit_get_cur_to_write_code_info);
        map.put(emit_write_code_info_byte, this::emit_write_code_info_byte);
        map.put(emit_get_cur_to_write_bytecode, this::emit_get_cur_to_write_bytecode);
        map.put(emit_write_bytecode_byte, this::emit_write_bytecode_byte);
        map.put(emit_write_bytecode_byte_uint, this::emit_write_bytecode_byte_uint);
        map.put(emit_write_bytecode_byte_raw_code, this::emit_write_bytecode_byte_raw_code);
        map.put(mp_emit_bc_delete_local, this::mp_emit_bc_delete_local);
        map.put(emit_write_bytecode_byte_qstr, this::emit_write_bytecode_byte_qstr);
        map.put(emit_write_bytecode_byte_unsigned_label, this::emit_write_bytecode_byte_unsigned_label);
        map.put(emit_write_bytecode_byte_signed_label, this::emit_write_bytecode_byte_signed_label);
        map.put(emit_write_bytecode_byte_obj_constprop_8, this::emit_write_bytecode_byte_obj_constprop_8);
        map.put(emit_bc_new, this::emit_bc_new);
        map.put(emit_bc_set_max_num_labels, this::emit_bc_set_max_num_labels);
        map.put(emit_bc_free, this::emit_bc_free);
        map.put(mp_emit_bc_start_pass, this::mp_emit_bc_start_pass);
        map.put(mp_emit_bc_end_pass, this::mp_emit_bc_end_pass);
        map.put(mp_emit_bc_last_emit_was_return_value, this::mp_emit_bc_last_emit_was_return_value);
        map.put(mp_emit_bc_adjust_stack_size, this::mp_emit_bc_adjust_stack_size);
        map.put(mp_emit_bc_load_local, this::mp_emit_bc_load_local);
        map.put(mp_emit_bc_load_global, this::mp_emit_bc_load_global);
        map.put(mp_emit_bc_store_local, this::mp_emit_bc_store_local);
        map.put(mp_emit_bc_store_global, this::mp_emit_bc_store_global);
        map.put(mp_emit_bc_delete_global, this::mp_emit_bc_delete_global);
        map.put(emit_bc_call_function_method_helper, this::emit_bc_call_function_method_helper);
        map.put(mp_emit_bc_set_source_line, this::mp_emit_bc_set_source_line);
        map.put(mp_emit_bc_label_assign, this::mp_emit_bc_label_assign);
        map.put(mp_emit_bc_import, this::mp_emit_bc_import);
        map.put(mp_emit_bc_load_const_tok, this::mp_emit_bc_load_const_tok);
        map.put(mp_emit_bc_load_const_small_int, this::mp_emit_bc_load_const_small_int);
        map.put(mp_emit_bc_load_const_str, this::mp_emit_bc_load_const_str);
        map.put(mp_emit_bc_load_const_obj, this::mp_emit_bc_load_const_obj);
        map.put(mp_emit_bc_load_null, this::mp_emit_bc_load_null);
        map.put(mp_emit_bc_load_method, this::mp_emit_bc_load_method);
        map.put(mp_emit_bc_load_build_class, this::mp_emit_bc_load_build_class);
        map.put(mp_emit_bc_dup_top, this::mp_emit_bc_dup_top);
        map.put(mp_emit_bc_dup_top_two, this::mp_emit_bc_dup_top_two);
        map.put(mp_emit_bc_pop_top, this::mp_emit_bc_pop_top);
        map.put(mp_emit_bc_rot_two, this::mp_emit_bc_rot_two);
        map.put(mp_emit_bc_attr, this::mp_emit_bc_attr);
        map.put(mp_emit_bc_rot_three, this::mp_emit_bc_rot_three);
        map.put(mp_emit_bc_subscr, this::mp_emit_bc_subscr);
        map.put(mp_emit_bc_jump, this::mp_emit_bc_jump);
        map.put(mp_emit_bc_pop_jump_if, this::mp_emit_bc_pop_jump_if);
        map.put(mp_emit_bc_jump_if_or_pop, this::mp_emit_bc_jump_if_or_pop);
        map.put(mp_emit_bc_unwind_jump, this::mp_emit_bc_unwind_jump);
        map.put(mp_emit_bc_setup_block, this::mp_emit_bc_setup_block);
        map.put(mp_emit_bc_end_finally, this::mp_emit_bc_end_finally);
        map.put(mp_emit_bc_get_iter, this::mp_emit_bc_get_iter);
        map.put(mp_emit_bc_for_iter, this::mp_emit_bc_for_iter);
        map.put(mp_emit_bc_for_iter_end, this::mp_emit_bc_for_iter_end);
        map.put(mp_emit_bc_pop_block, this::mp_emit_bc_pop_block);
        map.put(mp_emit_bc_with_cleanup, this::mp_emit_bc_with_cleanup);
        map.put(mp_emit_bc_pop_except, this::mp_emit_bc_pop_except);
        map.put(mp_emit_bc_unary_op, this::mp_emit_bc_unary_op);
        map.put(mp_emit_bc_binary_op, this::mp_emit_bc_binary_op);
        map.put(mp_emit_bc_build, this::mp_emit_bc_build);
        map.put(mp_emit_bc_store_map, this::mp_emit_bc_store_map);
        map.put(mp_emit_bc_store_comp, this::mp_emit_bc_store_comp);
        map.put(mp_emit_bc_unpack_sequence, this::mp_emit_bc_unpack_sequence);
        map.put(mp_emit_bc_unpack_ex, this::mp_emit_bc_unpack_ex);
        map.put(mp_emit_bc_make_function, this::mp_emit_bc_make_function);
        map.put(mp_emit_bc_make_closure, this::mp_emit_bc_make_closure);
        map.put(mp_emit_bc_call_function, this::mp_emit_bc_call_function);
        map.put(mp_emit_bc_call_method, this::mp_emit_bc_call_method);
        map.put(mp_emit_bc_return_value, this::mp_emit_bc_return_value);
        map.put(mp_emit_bc_raise_varargs, this::mp_emit_bc_raise_varargs);
        map.put(mp_emit_bc_yield, this::mp_emit_bc_yield);
        map.put(mp_emit_bc_start_except_handler, this::mp_emit_bc_start_except_handler);
        map.put(mp_emit_bc_end_except_handler, this::mp_emit_bc_end_except_handler);
        map.put(mp_format_float, this::mp_format_float);
        map.put(mp_parse_num_base, this::mp_parse_num_base);
        map.put(unlikely_raise_exc, this::unlikely_raise_exc);
        map.put(mp_parse_num_integer, this::mp_parse_num_integer);
        map.put(mp_parse_num_decimal, this::mp_parse_num_decimal);
        map.put(mp_emit_glue_new_raw_code, this::mp_emit_glue_new_raw_code);
        map.put(mp_emit_glue_assign_bytecode, this::mp_emit_glue_assign_bytecode);
        map.put(mp_make_function_from_raw_code, this::mp_make_function_from_raw_code);
        map.put(mp_make_closure_from_raw_code, this::mp_make_closure_from_raw_code);
        map.put(read_bytes, this::read_bytes);
        map.put(read_uint, this::read_uint);
        map.put(load_qstr, this::load_qstr);
        map.put(load_raw_code, this::load_raw_code);
        map.put(mp_raw_code_load, this::mp_raw_code_load);
        map.put(mp_raw_code_load_file, this::mp_raw_code_load_file);
        map.put(mp_init, this::mp_init);
        map.put(mp_deinit, this::mp_deinit);
        map.put(mp_load_global, this::mp_load_global);
        map.put(mp_load_name, this::mp_load_name);
        map.put(mp_load_build_class, this::mp_load_build_class);
        map.put(mp_store_name, this::mp_store_name);
        map.put(mp_delete_name, this::mp_delete_name);
        map.put(mp_store_global, this::mp_store_global);
        map.put(mp_delete_global, this::mp_delete_global);
        map.put(mp_unary_op, this::mp_unary_op);
        map.put(mp_call_function_n_kw, this::mp_call_function_n_kw);
        map.put(mp_call_function_0, this::mp_call_function_0);
        map.put(mp_call_function_1, this::mp_call_function_1);
        map.put(checked_fun_call, this::checked_fun_call);
        map.put(mp_call_method_n_kw, this::mp_call_method_n_kw);
        map.put(mp_convert_member_lookup, this::mp_convert_member_lookup);
        map.put(mp_load_method_maybe, this::mp_load_method_maybe);
        map.put(mp_load_method, this::mp_load_method);
        map.put(mp_load_attr, this::mp_load_attr);
        map.put(mp_load_method_protected, this::mp_load_method_protected);
        map.put(mp_store_attr, this::mp_store_attr);
        map.put(mp_getiter, this::mp_getiter);
        map.put(mp_iternext_allow_raise, this::mp_iternext_allow_raise);
        map.put(mp_iternext, this::mp_iternext);
        map.put(mp_call_prepare_args_n_kw_var, this::mp_call_prepare_args_n_kw_var);
        map.put(mp_call_method_n_kw_var, this::mp_call_method_n_kw_var);
        map.put(mp_unpack_sequence, this::mp_unpack_sequence);
        map.put(mp_unpack_ex, this::mp_unpack_ex);
        map.put(mp_make_raise_obj, this::mp_make_raise_obj);
        map.put(mp_resume, this::mp_resume);
        map.put(mp_import_name, this::mp_import_name);
        map.put(mp_import_from, this::mp_import_from);
        map.put(mp_import_all, this::mp_import_all);
        map.put(mp_parse_compile_execute, this::mp_parse_compile_execute);
        map.put(mp_raise_msg, this::mp_raise_msg);
        map.put(m_malloc_fail, this::m_malloc_fail);
        map.put(mp_raise_ValueError, this::mp_raise_ValueError);
        map.put(mp_binary_op, this::mp_binary_op);
        map.put(mp_raise_TypeError, this::mp_raise_TypeError);
        map.put(mp_raise_OSError, this::mp_raise_OSError);
        map.put(mp_raise_NotImplementedError, this::mp_raise_NotImplementedError);
        map.put(mp_raise_recursion_depth, this::mp_raise_recursion_depth);
        map.put(mp_call_function_1_protected, this::mp_call_function_1_protected);
        map.put(mp_sched_lock, this::mp_sched_lock);
        map.put(mp_sched_unlock, this::mp_sched_unlock);
        map.put(mp_handle_pending_tail, this::mp_handle_pending_tail);
        map.put(mp_handle_pending, this::mp_handle_pending);
        map.put(mp_sched_schedule, this::mp_sched_schedule);
        map.put(mp_stack_set_top, this::mp_stack_set_top);
        map.put(mp_stack_usage, this::mp_stack_usage);
        map.put(mp_stack_set_limit, this::mp_stack_set_limit);
        map.put(mp_stack_check, this::mp_stack_check);
        map.put(mp_arg_check_num, this::mp_arg_check_num);
        map.put(mp_arg_parse_all, this::mp_arg_parse_all);
        map.put(mp_arg_parse_all_kw_array, this::mp_arg_parse_all_kw_array);
        map.put(mp_arg_error_unimpl_kw, this::mp_arg_error_unimpl_kw);
        map.put(mp_warning, this::mp_warning);
        map.put(mp_map_init, this::mp_map_init);
        map.put(mp_map_init_fixed_table, this::mp_map_init_fixed_table);
        map.put(mp_map_deinit, this::mp_map_deinit);
        map.put(mp_map_clear, this::mp_map_clear);
        map.put(mp_map_lookup, this::mp_map_lookup);
        map.put(mp_map_rehash, this::mp_map_rehash);
        map.put(mp_set_init, this::mp_set_init);
        map.put(mp_set_lookup, this::mp_set_lookup);
        map.put(mp_set_rehash, this::mp_set_rehash);
        map.put(mp_set_remove_first, this::mp_set_remove_first);
        map.put(mp_set_clear, this::mp_set_clear);
        map.put(mp_identity, this::mp_identity);
        map.put(mp_obj_get_type, this::mp_obj_get_type);
        map.put(mp_obj_get_type_str, this::mp_obj_get_type_str);
        map.put(mp_obj_print_helper, this::mp_obj_print_helper);
        map.put(mp_obj_print, this::mp_obj_print);
        map.put(mp_obj_print_exception, this::mp_obj_print_exception);
        map.put(mp_obj_is_callable, this::mp_obj_is_callable);
        map.put(mp_obj_equal, this::mp_obj_equal);
        map.put(mp_obj_get_int, this::mp_obj_get_int);
        map.put(mp_obj_get_int_truncated, this::mp_obj_get_int_truncated);
        map.put(mp_obj_get_int_maybe, this::mp_obj_get_int_maybe);
        map.put(mp_obj_get_float_maybe, this::mp_obj_get_float_maybe);
        map.put(mp_obj_get_float, this::mp_obj_get_float);
        map.put(mp_obj_get_complex, this::mp_obj_get_complex);
        map.put(mp_obj_get_array, this::mp_obj_get_array);
        map.put(mp_obj_get_array_fixed_n, this::mp_obj_get_array_fixed_n);
        map.put(mp_get_index, this::mp_get_index);
        map.put(mp_obj_id, this::mp_obj_id);
        map.put(mp_obj_len_maybe, this::mp_obj_len_maybe);
        map.put(mp_obj_is_true, this::mp_obj_is_true);
        map.put(mp_obj_len, this::mp_obj_len);
        map.put(mp_obj_subscr, this::mp_obj_subscr);
        map.put(mp_identity_getiter, this::mp_identity_getiter);
        map.put(mp_get_buffer, this::mp_get_buffer);
        map.put(mp_get_buffer_raise, this::mp_get_buffer_raise);
        map.put(mp_generic_unary_op, this::mp_generic_unary_op);
        map.put(array_unary_op, this::array_unary_op);
        map.put(array_iterator_new, this::array_iterator_new);
        map.put(array_get_buffer, this::array_get_buffer);
        map.put(array_new, this::array_new);
        map.put(array_extend, this::array_extend);
        map.put(array_append, this::array_append);
        map.put(array_it_iternext, this::array_it_iternext);
        map.put(array_subscr, this::array_subscr);
        map.put(array_binary_op, this::array_binary_op);
        map.put(array_construct, this::array_construct);
        map.put(array_make_new, this::array_make_new);
        map.put(array_print, this::array_print);
        map.put(bytearray_make_new, this::bytearray_make_new);
        map.put(mp_obj_new_memoryview, this::mp_obj_new_memoryview);
        map.put(memoryview_make_new, this::memoryview_make_new);
        map.put(mp_obj_new_bytearray_by_ref, this::mp_obj_new_bytearray_by_ref);
        map.put(mp_obj_attrtuple_attr, this::mp_obj_attrtuple_attr);
        map.put(mp_obj_attrtuple_print_helper, this::mp_obj_attrtuple_print_helper);
        map.put(mp_obj_attrtuple_print, this::mp_obj_attrtuple_print);
        map.put(bool_binary_op, this::bool_binary_op);
        map.put(bool_unary_op, this::bool_unary_op);
        map.put(bool_make_new, this::bool_make_new);
        map.put(bool_print, this::bool_print);
        map.put(bound_meth_print, this::bound_meth_print);
        map.put(bound_meth_attr, this::bound_meth_attr);
        map.put(mp_call_method_self_n_kw, this::mp_call_method_self_n_kw);
        map.put(bound_meth_call, this::bound_meth_call);
        map.put(mp_obj_new_bound_meth, this::mp_obj_new_bound_meth);
        map.put(cell_print, this::cell_print);
        map.put(mp_obj_cell_get, this::mp_obj_cell_get);
        map.put(mp_obj_cell_set, this::mp_obj_cell_set);
        map.put(mp_obj_new_cell, this::mp_obj_new_cell);
        map.put(closure_call, this::closure_call);
        map.put(closure_print, this::closure_print);
        map.put(mp_obj_new_closure, this::mp_obj_new_closure);
        map.put(complex_attr, this::complex_attr);
        map.put(complex_print, this::complex_print);
        map.put(mp_obj_new_complex, this::mp_obj_new_complex);
        map.put(complex_unary_op, this::complex_unary_op);
        map.put(complex_make_new, this::complex_make_new);
        map.put(mp_obj_complex_get, this::mp_obj_complex_get);
        map.put(mp_obj_complex_binary_op, this::mp_obj_complex_binary_op);
        map.put(complex_binary_op, this::complex_binary_op);
        map.put(deque_make_new, this::deque_make_new);
        map.put(deque_unary_op, this::deque_unary_op);
        map.put(deque_popleft, this::deque_popleft);
        map.put(mp_obj_deque_append, this::mp_obj_deque_append);
        map.put(dict_view_getiter, this::dict_view_getiter);
        map.put(dict_getiter, this::dict_getiter);
        map.put(dict_values, this::dict_values);
        map.put(mp_ensure_not_fixed, this::mp_ensure_not_fixed);
        map.put(dict_clear, this::dict_clear);
        map.put(dict_unary_op, this::dict_unary_op);
        map.put(dict_get_helper, this::dict_get_helper);
        map.put(dict_setdefault, this::dict_setdefault);
        map.put(dict_pop, this::dict_pop);
        map.put(dict_get, this::dict_get);
        map.put(dict_iter_next, this::dict_iter_next);
        map.put(dict_view_it_iternext, this::dict_view_it_iternext);
        map.put(dict_view_print, this::dict_view_print);
        map.put(dict_update, this::dict_update);
        map.put(dict_popitem, this::dict_popitem);
        map.put(dict_binary_op, this::dict_binary_op);
        map.put(dict_view_binary_op, this::dict_view_binary_op);
        map.put(dict_print, this::dict_print);
        map.put(dict_items, this::dict_items);
        map.put(dict_keys, this::dict_keys);
        map.put(mp_obj_dict_get, this::mp_obj_dict_get);
        map.put(mp_obj_dict_init, this::mp_obj_dict_init);
        map.put(mp_obj_new_dict, this::mp_obj_new_dict);
        map.put(dict_fromkeys, this::dict_fromkeys);
        map.put(dict_copy, this::dict_copy);
        map.put(dict_make_new, this::dict_make_new);
        map.put(mp_obj_dict_len, this::mp_obj_dict_len);
        map.put(mp_obj_dict_store, this::mp_obj_dict_store);
        map.put(mp_obj_dict_delete, this::mp_obj_dict_delete);
        map.put(dict_subscr, this::dict_subscr);
        map.put(enumerate_iternext, this::enumerate_iternext);
        map.put(enumerate_make_new, this::enumerate_make_new);
        map.put(mp_obj_exception_print, this::mp_obj_exception_print);
        map.put(mp_obj_exception_make_new, this::mp_obj_exception_make_new);
        map.put(exc_add_strn, this::exc_add_strn);
        map.put(mp_init_emergency_exception_buf, this::mp_init_emergency_exception_buf);
        map.put(mp_obj_exception_get_value, this::mp_obj_exception_get_value);
        map.put(mp_obj_exception_attr, this::mp_obj_exception_attr);
        map.put(mp_obj_new_exception_args, this::mp_obj_new_exception_args);
        map.put(mp_obj_new_exception, this::mp_obj_new_exception);
        map.put(mp_obj_new_exception_arg1, this::mp_obj_new_exception_arg1);
        map.put(mp_obj_new_exception_msg_varg, this::mp_obj_new_exception_msg_varg);
        map.put(mp_obj_new_exception_msg, this::mp_obj_new_exception_msg);
        map.put(mp_obj_is_exception_type, this::mp_obj_is_exception_type);
        map.put(mp_obj_is_exception_instance, this::mp_obj_is_exception_instance);
        map.put(mp_obj_exception_match, this::mp_obj_exception_match);
        map.put(mp_obj_exception_clear_traceback, this::mp_obj_exception_clear_traceback);
        map.put(mp_obj_exception_add_traceback, this::mp_obj_exception_add_traceback);
        map.put(mp_obj_exception_get_traceback, this::mp_obj_exception_get_traceback);
        map.put(filter_iternext, this::filter_iternext);
        map.put(filter_make_new, this::filter_make_new);
        map.put(float_print, this::float_print);
        map.put(mp_obj_float_divmod, this::mp_obj_float_divmod);
        map.put(mp_float_hash, this::mp_float_hash);
        map.put(mp_obj_new_float, this::mp_obj_new_float);
        map.put(float_make_new, this::float_make_new);
        map.put(float_unary_op, this::float_unary_op);
        map.put(mp_obj_float_get, this::mp_obj_float_get);
        map.put(mp_obj_float_binary_op, this::mp_obj_float_binary_op);
        map.put(float_binary_op, this::float_binary_op);
        map.put(fun_builtin_0_call, this::fun_builtin_0_call);
        map.put(fun_builtin_1_call, this::fun_builtin_1_call);
        map.put(fun_builtin_2_call, this::fun_builtin_2_call);
        map.put(fun_builtin_3_call, this::fun_builtin_3_call);
        map.put(fun_bc_call, this::fun_bc_call);
        map.put(fun_builtin_var_call, this::fun_builtin_var_call);
        map.put(mp_obj_code_get_name, this::mp_obj_code_get_name);
        map.put(mp_obj_fun_get_name, this::mp_obj_fun_get_name);
        map.put(mp_obj_fun_bc_attr, this::mp_obj_fun_bc_attr);
        map.put(fun_bc_print, this::fun_bc_print);
        map.put(mp_obj_fun_bc_prepare_codestate, this::mp_obj_fun_bc_prepare_codestate);
        map.put(mp_obj_new_fun_bc, this::mp_obj_new_fun_bc);
        map.put(gen_wrap_call, this::gen_wrap_call);
        map.put(gen_instance_pend_throw, this::gen_instance_pend_throw);
        map.put(gen_instance_print, this::gen_instance_print);
        map.put(unlikely_gen_instance_throw_part_0, this::unlikely_gen_instance_throw_part_0);
        map.put(mp_obj_gen_resume, this::mp_obj_gen_resume);
        map.put(gen_resume_and_raise, this::gen_resume_and_raise);
        map.put(gen_instance_throw, this::gen_instance_throw);
        map.put(gen_instance_send, this::gen_instance_send);
        map.put(gen_instance_iternext, this::gen_instance_iternext);
        map.put(gen_instance_close, this::gen_instance_close);
        map.put(it_iternext, this::it_iternext);
        map.put(mp_obj_new_getitem_iter, this::mp_obj_new_getitem_iter);
        map.put(int_to_bytes, this::int_to_bytes);
        map.put(int_from_bytes, this::int_from_bytes);
        map.put(mp_obj_new_int_from_float, this::mp_obj_new_int_from_float);
        map.put(mp_obj_int_make_new, this::mp_obj_int_make_new);
        map.put(mp_int_format_size, this::mp_int_format_size);
        map.put(mp_obj_int_formatted, this::mp_obj_int_formatted);
        map.put(mp_obj_int_print, this::mp_obj_int_print);
        map.put(mp_obj_int_binary_op_extra_cases, this::mp_obj_int_binary_op_extra_cases);
        map.put(mp_obj_int_new_mpz, this::mp_obj_int_new_mpz);
        map.put(mp_obj_int_formatted_impl, this::mp_obj_int_formatted_impl);
        map.put(mp_obj_int_from_bytes_impl, this::mp_obj_int_from_bytes_impl);
        map.put(mp_obj_int_to_bytes_impl, this::mp_obj_int_to_bytes_impl);
        map.put(mp_obj_int_sign, this::mp_obj_int_sign);
        map.put(mp_obj_int_unary_op, this::mp_obj_int_unary_op);
        map.put(mp_obj_new_int_from_ll, this::mp_obj_new_int_from_ll);
        map.put(mp_obj_new_int, this::mp_obj_new_int);
        map.put(mp_obj_new_int_from_ull, this::mp_obj_new_int_from_ull);
        map.put(mp_obj_int_pow3, this::mp_obj_int_pow3);
        map.put(mp_obj_new_int_from_uint, this::mp_obj_new_int_from_uint);
        map.put(mp_obj_new_int_from_str_len, this::mp_obj_new_int_from_str_len);
        map.put(mp_obj_int_get_truncated, this::mp_obj_int_get_truncated);
        map.put(mp_obj_int_get_checked, this::mp_obj_int_get_checked);
        map.put(mp_obj_int_binary_op, this::mp_obj_int_binary_op);
        map.put(mp_obj_int_as_float_impl, this::mp_obj_int_as_float_impl);
        map.put(list_getiter, this::list_getiter);
        map.put(list_reverse, this::list_reverse);
        map.put(list_it_iternext, this::list_it_iternext);
        map.put(mp_obj_list_append, this::mp_obj_list_append);
        map.put(list_insert, this::list_insert);
        map.put(list_clear, this::list_clear);
        map.put(mp_quicksort, this::mp_quicksort);
        map.put(mp_obj_list_sort, this::mp_obj_list_sort);
        map.put(list_index, this::list_index);
        map.put(list_pop, this::list_pop);
        map.put(mp_obj_list_remove, this::mp_obj_list_remove);
        map.put(list_extend_from_iter, this::list_extend_from_iter);
        map.put(list_count, this::list_count);
        map.put(list_print, this::list_print);
        map.put(list_unary_op, this::list_unary_op);
        map.put(list_extend, this::list_extend);
        map.put(mp_obj_list_init, this::mp_obj_list_init);
        map.put(list_new, this::list_new);
        map.put(list_binary_op, this::list_binary_op);
        map.put(list_make_new, this::list_make_new);
        map.put(mp_obj_new_list, this::mp_obj_new_list);
        map.put(list_copy, this::list_copy);
        map.put(mp_obj_list_get, this::mp_obj_list_get);
        map.put(mp_obj_list_set_len, this::mp_obj_list_set_len);
        map.put(mp_obj_list_store, this::mp_obj_list_store);
        map.put(list_subscr, this::list_subscr);
        map.put(map_iternext, this::map_iternext);
        map.put(map_make_new, this::map_make_new);
        map.put(module_print, this::module_print);
        map.put(module_attr, this::module_attr);
        map.put(mp_obj_new_module, this::mp_obj_new_module);
        map.put(mp_module_register, this::mp_module_register);
        map.put(mp_module_call_init, this::mp_module_call_init);
        map.put(mp_module_get, this::mp_module_get);
        map.put(object___init__, this::object___init__);
        map.put(object___new__, this::object___new__);
        map.put(object_make_new, this::object_make_new);
        map.put(polymorph_it_iternext, this::polymorph_it_iternext);
        map.put(property_deleter, this::property_deleter);
        map.put(property_setter, this::property_setter);
        map.put(property_getter, this::property_getter);
        map.put(property_make_new, this::property_make_new);
        map.put(mp_obj_property_get, this::mp_obj_property_get);
        map.put(none_print, this::none_print);
        map.put(namedtuple_asdict, this::namedtuple_asdict);
        map.put(namedtuple_print, this::namedtuple_print);
        map.put(mp_obj_namedtuple_find_field, this::mp_obj_namedtuple_find_field);
        map.put(namedtuple_attr, this::namedtuple_attr);
        map.put(namedtuple_make_new, this::namedtuple_make_new);
        map.put(mp_obj_new_namedtuple_base, this::mp_obj_new_namedtuple_base);
        map.put(new_namedtuple_type, this::new_namedtuple_type);
        map.put(range_it_iternext, this::range_it_iternext);
        map.put(range_len, this::range_len);
        map.put(range_unary_op, this::range_unary_op);
        map.put(range_getiter, this::range_getiter);
        map.put(range_subscr, this::range_subscr);
        map.put(range_make_new, this::range_make_new);
        map.put(range_print, this::range_print);
        map.put(range_binary_op, this::range_binary_op);
        map.put(range_attr, this::range_attr);
        map.put(reversed_iternext, this::reversed_iternext);
        map.put(reversed_make_new, this::reversed_make_new);
        map.put(is_set_or_frozenset, this::is_set_or_frozenset);
        map.put(set_getiter, this::set_getiter);
        map.put(text_set_add, this::text_set_add);
        map.put(set_discard, this::set_discard);
        map.put(set_update_int, this::set_update_int);
        map.put(set_update, this::set_update);
        map.put(set_symmetric_difference_update, this::set_symmetric_difference_update);
        map.put(set_isdisjoint, this::set_isdisjoint);
        map.put(set_copy, this::set_copy);
        map.put(set_union, this::set_union);
        map.put(set_symmetric_difference, this::set_symmetric_difference);
        map.put(set_clear, this::set_clear);
        map.put(set_diff_int, this::set_diff_int);
        map.put(set_diff_update, this::set_diff_update);
        map.put(set_diff, this::set_diff);
        map.put(set_print, this::set_print);
        map.put(set_remove, this::set_remove);
        map.put(text_set_pop, this::text_set_pop);
        map.put(set_it_iternext, this::set_it_iternext);
        map.put(set_unary_op, this::set_unary_op);
        map.put(mp_obj_new_set, this::mp_obj_new_set);
        map.put(set_intersect_int_part_4, this::set_intersect_int_part_4);
        map.put(set_intersect_update, this::set_intersect_update);
        map.put(set_intersect, this::set_intersect);
        map.put(mp_obj_set_store, this::mp_obj_set_store);
        map.put(set_make_new, this::set_make_new);
        map.put(set_issubset_internal, this::set_issubset_internal);
        map.put(set_issuperset, this::set_issuperset);
        map.put(set_issubset, this::set_issubset);
        map.put(set_binary_op, this::set_binary_op);
        map.put(singleton_print, this::singleton_print);
        map.put(slice_print, this::slice_print);
        map.put(slice_attr, this::slice_attr);
        map.put(mp_obj_new_slice, this::mp_obj_new_slice);
        map.put(mp_obj_slice_get, this::mp_obj_slice_get);
        map.put(arg_looks_integer, this::arg_looks_integer);
        map.put(arg_looks_numeric, this::arg_looks_numeric);
        map.put(mp_obj_new_bytes_iterator, this::mp_obj_new_bytes_iterator);
        map.put(bytes_it_iternext, this::bytes_it_iternext);
        map.put(unlikely_bad_implicit_conversion, this::unlikely_bad_implicit_conversion);
        map.put(str_count, this::str_count);
        map.put(str_uni_istype, this::str_uni_istype);
        map.put(str_isspace, this::str_isspace);
        map.put(str_isalpha, this::str_isalpha);
        map.put(str_isdigit, this::str_isdigit);
        map.put(str_isupper, this::str_isupper);
        map.put(str_islower, this::str_islower);
        map.put(str_to_int, this::str_to_int);
        map.put(mp_obj_str_get_buffer, this::mp_obj_str_get_buffer);
        map.put(mp_str_print_quoted, this::mp_str_print_quoted);
        map.put(mp_str_print_json, this::mp_str_print_json);
        map.put(str_print, this::str_print);
        map.put(find_subbytes, this::find_subbytes);
        map.put(str_finder, this::str_finder);
        map.put(str_find, this::str_find);
        map.put(str_rfind, this::str_rfind);
        map.put(str_index, this::str_index);
        map.put(str_rindex, this::str_rindex);
        map.put(mp_obj_new_str_copy, this::mp_obj_new_str_copy);
        map.put(mp_obj_new_str_via_qstr, this::mp_obj_new_str_via_qstr);
        map.put(mp_obj_new_str_from_vstr, this::mp_obj_new_str_from_vstr);
        map.put(str_join, this::str_join);
        map.put(str_center, this::str_center);
        map.put(str_replace, this::str_replace);
        map.put(str_caseconv, this::str_caseconv);
        map.put(str_lower, this::str_lower);
        map.put(str_upper, this::str_upper);
        map.put(mp_obj_new_str, this::mp_obj_new_str);
        map.put(mp_obj_str_make_new, this::mp_obj_str_make_new);
        map.put(bytes_decode, this::bytes_decode);
        map.put(mp_obj_new_bytes, this::mp_obj_new_bytes);
        map.put(bytes_make_new_part_4, this::bytes_make_new_part_4);
        map.put(bytes_make_new, this::bytes_make_new);
        map.put(str_encode, this::str_encode);
        map.put(mp_obj_new_str_of_type, this::mp_obj_new_str_of_type);
        map.put(str_splitlines, this::str_splitlines);
        map.put(str_uni_strip, this::str_uni_strip);
        map.put(str_strip, this::str_strip);
        map.put(str_lstrip, this::str_lstrip);
        map.put(str_rstrip, this::str_rstrip);
        map.put(str_partitioner, this::str_partitioner);
        map.put(str_partition, this::str_partition);
        map.put(str_rpartition, this::str_rpartition);
        map.put(bytes_subscr, this::bytes_subscr);
        map.put(mp_obj_str_equal, this::mp_obj_str_equal);
        map.put(mp_obj_str_get_qstr, this::mp_obj_str_get_qstr);
        map.put(mp_obj_str_get_str, this::mp_obj_str_get_str);
        map.put(mp_obj_str_get_data, this::mp_obj_str_get_data);
        map.put(mp_obj_str_binary_op, this::mp_obj_str_binary_op);
        map.put(mp_obj_str_split, this::mp_obj_str_split);
        map.put(str_rsplit, this::str_rsplit);
        map.put(str_startswith, this::str_startswith);
        map.put(str_endswith, this::str_endswith);
        map.put(mp_obj_str_format_helper, this::mp_obj_str_format_helper);
        map.put(mp_obj_str_format, this::mp_obj_str_format);
        map.put(mp_obj_str_intern_checked, this::mp_obj_str_intern_checked);
        map.put(mp_obj_new_str_iterator, this::mp_obj_new_str_iterator);
        map.put(str_it_iternext, this::str_it_iternext);
        map.put(uni_unary_op, this::uni_unary_op);
        map.put(uni_print, this::uni_print);
        map.put(str_index_to_ptr, this::str_index_to_ptr);
        map.put(str_subscr, this::str_subscr);
        map.put(stringio___exit__, this::stringio___exit__);
        map.put(stringio_print, this::stringio_print);
        map.put(stringio_write, this::stringio_write);
        map.put(stringio_make_new, this::stringio_make_new);
        map.put(stringio_ioctl, this::stringio_ioctl);
        map.put(stringio_getvalue, this::stringio_getvalue);
        map.put(stringio_read, this::stringio_read);
        map.put(tuple_it_iternext, this::tuple_it_iternext);
        map.put(mp_obj_tuple_getiter, this::mp_obj_tuple_getiter);
        map.put(mp_obj_tuple_print, this::mp_obj_tuple_print);
        map.put(tuple_index, this::tuple_index);
        map.put(tuple_count, this::tuple_count);
        map.put(mp_obj_tuple_unary_op, this::mp_obj_tuple_unary_op);
        map.put(mp_obj_new_tuple, this::mp_obj_new_tuple);
        map.put(mp_obj_tuple_binary_op, this::mp_obj_tuple_binary_op);
        map.put(mp_obj_tuple_subscr, this::mp_obj_tuple_subscr);
        map.put(mp_obj_tuple_make_new, this::mp_obj_tuple_make_new);
        map.put(mp_obj_tuple_get, this::mp_obj_tuple_get);
        map.put(mp_obj_tuple_del, this::mp_obj_tuple_del);
        map.put(instance_count_native_bases, this::instance_count_native_bases);
        map.put(native_base_init_wrapper, this::native_base_init_wrapper);
        map.put(mp_obj_class_lookup, this::mp_obj_class_lookup);
        map.put(super_attr, this::super_attr);
        map.put(static_class_method_make_new, this::static_class_method_make_new);
        map.put(super_make_new, this::super_make_new);
        map.put(type_print, this::type_print);
        map.put(instance_subscr, this::instance_subscr);
        map.put(instance_binary_op, this::instance_binary_op);
        map.put(instance_unary_op, this::instance_unary_op);
        map.put(instance_print, this::instance_print);
        map.put(super_print, this::super_print);
        map.put(mp_obj_instance_attr, this::mp_obj_instance_attr);
        map.put(type_call, this::type_call);
        map.put(instance_get_buffer, this::instance_get_buffer);
        map.put(instance_getiter, this::instance_getiter);
        map.put(check_for_special_accessors, this::check_for_special_accessors);
        map.put(type_attr, this::type_attr);
        map.put(mp_obj_instance_call, this::mp_obj_instance_call);
        map.put(mp_obj_new_instance, this::mp_obj_new_instance);
        map.put(mp_obj_instance_make_new, this::mp_obj_instance_make_new);
        map.put(mp_obj_instance_is_callable, this::mp_obj_instance_is_callable);
        map.put(mp_obj_new_type, this::mp_obj_new_type);
        map.put(type_make_new, this::type_make_new);
        map.put(mp_load_super_method, this::mp_load_super_method);
        map.put(mp_obj_is_subclass_fast, this::mp_obj_is_subclass_fast);
        map.put(mp_obj_is_subclass, this::mp_obj_is_subclass);
        map.put(mp_builtin_issubclass, this::mp_builtin_issubclass);
        map.put(mp_builtin_isinstance, this::mp_builtin_isinstance);
        map.put(mp_instance_cast_to_native_base, this::mp_instance_cast_to_native_base);
        map.put(zip_iternext, this::zip_iternext);
        map.put(zip_make_new, this::zip_make_new);
        map.put(op_getitem, this::op_getitem);
        map.put(op_setitem, this::op_setitem);
        map.put(op_delitem, this::op_delitem);
        map.put(op_contains, this::op_contains);
        map.put(mp_seq_multiply, this::mp_seq_multiply);
        map.put(mp_seq_get_fast_slice_indexes, this::mp_seq_get_fast_slice_indexes);
        map.put(mp_seq_extract_slice, this::mp_seq_extract_slice);
        map.put(mp_seq_cmp_bytes, this::mp_seq_cmp_bytes);
        map.put(mp_seq_cmp_objs, this::mp_seq_cmp_objs);
        map.put(mp_seq_index_obj, this::mp_seq_index_obj);
        map.put(mp_seq_count_obj, this::mp_seq_count_obj);
        map.put(mp_stream_close, this::mp_stream_close);
        map.put(stream_flush, this::stream_flush);
        map.put(stream_unbuffered_readline, this::stream_unbuffered_readline);
        map.put(stream_unbuffered_readlines, this::stream_unbuffered_readlines);
        map.put(stream_seek, this::stream_seek);
        map.put(stream_tell, this::stream_tell);
        map.put(mp_stream_rw, this::mp_stream_rw);
        map.put(stream_read_generic, this::stream_read_generic);
        map.put(stream_read, this::stream_read);
        map.put(stream_readinto, this::stream_readinto);
        map.put(mp_get_stream_raise, this::mp_get_stream_raise);
        map.put(mp_stream_write, this::mp_stream_write);
        map.put(stream_write_method, this::stream_write_method);
        map.put(mp_stream_write_adaptor, this::mp_stream_write_adaptor);
        map.put(mp_stream_unbuffered_iter, this::mp_stream_unbuffered_iter);
        map.put(mp_binary_get_size, this::mp_binary_get_size);
        map.put(mp_binary_get_val_array, this::mp_binary_get_val_array);
        map.put(mp_binary_get_int, this::mp_binary_get_int);
        map.put(mp_binary_get_val, this::mp_binary_get_val);
        map.put(mp_binary_set_int, this::mp_binary_set_int);
        map.put(mp_binary_set_val, this::mp_binary_set_val);
        map.put(mp_binary_set_val_array_from_int, this::mp_binary_set_val_array_from_int);
        map.put(mp_binary_set_val_array, this::mp_binary_set_val_array);
        map.put(mp_import_stat_any, this::mp_import_stat_any);
        map.put(do_execute_raw_code, this::do_execute_raw_code);
        map.put(do_load_from_lexer, this::do_load_from_lexer);
        map.put(text_do_load, this::text_do_load);
        map.put(stat_file_py_or_mpy, this::stat_file_py_or_mpy);
        map.put(stat_dir_or_file, this::stat_dir_or_file);
        map.put(mp_builtin___import__, this::mp_builtin___import__);
        map.put(mp_obj_is_package, this::mp_obj_is_package);
        map.put(mp_builtin_compile, this::mp_builtin_compile);
        map.put(eval_exec_helper, this::eval_exec_helper);
        map.put(mp_builtin_eval, this::mp_builtin_eval);
        map.put(mp_builtin_exec, this::mp_builtin_exec);
        map.put(mp_builtin_execfile, this::mp_builtin_execfile);
        map.put(mp_help_add_from_names, this::mp_help_add_from_names);
        map.put(mp_help_add_from_map, this::mp_help_add_from_map);
        map.put(mp_builtin_help, this::mp_builtin_help);
        map.put(mp_builtin_globals, this::mp_builtin_globals);
        map.put(mp_builtin_locals, this::mp_builtin_locals);
        map.put(mp_builtin___build_class__, this::mp_builtin___build_class__);
        map.put(mp_builtin_abs, this::mp_builtin_abs);
        map.put(mp_builtin_hash, this::mp_builtin_hash);
        map.put(mp_builtin_iter, this::mp_builtin_iter);
        map.put(mp_builtin_all, this::mp_builtin_all);
        map.put(mp_builtin_any, this::mp_builtin_any);
        map.put(mp_builtin_bin, this::mp_builtin_bin);
        map.put(mp_builtin_callable, this::mp_builtin_callable);
        map.put(mp_builtin_chr, this::mp_builtin_chr);
        map.put(mp_builtin_divmod, this::mp_builtin_divmod);
        map.put(mp_builtin_hex, this::mp_builtin_hex);
        map.put(mp_builtin_oct, this::mp_builtin_oct);
        map.put(mp_builtin_sum, this::mp_builtin_sum);
        map.put(mp_builtin_min_max, this::mp_builtin_min_max);
        map.put(mp_builtin_max, this::mp_builtin_max);
        map.put(mp_builtin_min, this::mp_builtin_min);
        map.put(mp_builtin_ord, this::mp_builtin_ord);
        map.put(mp_builtin_print, this::mp_builtin_print);
        map.put(mp_builtin_repr, this::mp_builtin_repr);
        map.put(mp_builtin_round, this::mp_builtin_round);
        map.put(mp_builtin_sorted, this::mp_builtin_sorted);
        map.put(mp_builtin_hasattr, this::mp_builtin_hasattr);
        map.put(mp_builtin_getattr, this::mp_builtin_getattr);
        map.put(mp_builtin_setattr, this::mp_builtin_setattr);
        map.put(mp_builtin_delattr, this::mp_builtin_delattr);
        map.put(mp_builtin_dir, this::mp_builtin_dir);
        map.put(mp_builtin_next, this::mp_builtin_next);
        map.put(mp_builtin_pow, this::mp_builtin_pow);
        map.put(mp_builtin___repl_print__, this::mp_builtin___repl_print__);
        map.put(gc_disable, this::gc_disable);
        map.put(gc_enable, this::gc_enable);
        map.put(gc_isenabled, this::gc_isenabled);
        map.put(py_gc_collect, this::py_gc_collect);
        map.put(gc_mem_free, this::gc_mem_free);
        map.put(gc_mem_alloc, this::gc_mem_alloc);
        map.put(gc_threshold, this::gc_threshold);
        map.put(resource_stream, this::resource_stream);
        map.put(fabs_funcf, this::fabs_funcf);
        map.put(log2f, this::log2f);
        map.put(mp_math_isnan, this::mp_math_isnan);
        map.put(mp_math_isfinite, this::mp_math_isfinite);
        map.put(mp_math_isinf, this::mp_math_isinf);
        map.put(mp_math_degrees, this::mp_math_degrees);
        map.put(mp_math_radians, this::mp_math_radians);
        map.put(mp_math_trunc, this::mp_math_trunc);
        map.put(mp_math_modf, this::mp_math_modf);
        map.put(mp_math_ldexp, this::mp_math_ldexp);
        map.put(mp_math_frexp, this::mp_math_frexp);
        map.put(mp_math_floor, this::mp_math_floor);
        map.put(copysign_funcf, this::copysign_funcf);
        map.put(mp_math_ceil, this::mp_math_ceil);
        map.put(math_generic_1, this::math_generic_1);
        map.put(mp_math_lgamma, this::mp_math_lgamma);
        map.put(mp_math_gamma, this::mp_math_gamma);
        map.put(mp_math_erfc, this::mp_math_erfc);
        map.put(mp_math_erf, this::mp_math_erf);
        map.put(mp_math_fabs, this::mp_math_fabs);
        map.put(mp_math_atan, this::mp_math_atan);
        map.put(mp_math_asin, this::mp_math_asin);
        map.put(mp_math_acos, this::mp_math_acos);
        map.put(mp_math_tan, this::mp_math_tan);
        map.put(mp_math_sin, this::mp_math_sin);
        map.put(mp_math_cos, this::mp_math_cos);
        map.put(mp_math_atanh, this::mp_math_atanh);
        map.put(mp_math_asinh, this::mp_math_asinh);
        map.put(mp_math_acosh, this::mp_math_acosh);
        map.put(mp_math_tanh, this::mp_math_tanh);
        map.put(mp_math_sinh, this::mp_math_sinh);
        map.put(mp_math_cosh, this::mp_math_cosh);
        map.put(mp_math_log10, this::mp_math_log10);
        map.put(mp_math_log2, this::mp_math_log2);
        map.put(mp_math_expm1, this::mp_math_expm1);
        map.put(mp_math_exp, this::mp_math_exp);
        map.put(mp_math_sqrt, this::mp_math_sqrt);
        map.put(math_generic_2, this::math_generic_2);
        map.put(mp_math_fmod, this::mp_math_fmod);
        map.put(mp_math_copysign, this::mp_math_copysign);
        map.put(mp_math_atan2, this::mp_math_atan2);
        map.put(mp_math_pow, this::mp_math_pow);
        map.put(mp_math_log, this::mp_math_log);
        map.put(mp_cmath_sin, this::mp_cmath_sin);
        map.put(mp_cmath_cos, this::mp_cmath_cos);
        map.put(mp_cmath_sqrt, this::mp_cmath_sqrt);
        map.put(mp_cmath_log10, this::mp_cmath_log10);
        map.put(mp_cmath_log, this::mp_cmath_log);
        map.put(mp_cmath_exp, this::mp_cmath_exp);
        map.put(mp_cmath_rect, this::mp_cmath_rect);
        map.put(mp_cmath_phase, this::mp_cmath_phase);
        map.put(mp_cmath_polar, this::mp_cmath_polar);
        map.put(mp_micropython_pystack_use, this::mp_micropython_pystack_use);
        map.put(mp_micropython_mem_total, this::mp_micropython_mem_total);
        map.put(mp_micropython_mem_current, this::mp_micropython_mem_current);
        map.put(mp_micropython_mem_peak, this::mp_micropython_mem_peak);
        map.put(mp_micropython_stack_use, this::mp_micropython_stack_use);
        map.put(mp_micropython_mem_info, this::mp_micropython_mem_info);
        map.put(mp_micropython_kbd_intr, this::mp_micropython_kbd_intr);
        map.put(mp_micropython_heap_unlock, this::mp_micropython_heap_unlock);
        map.put(mp_micropython_heap_lock, this::mp_micropython_heap_lock);
        map.put(mp_micropython_qstr_info, this::mp_micropython_qstr_info);
        map.put(mp_micropython_schedule, this::mp_micropython_schedule);
        map.put(mp_micropython_opt_level, this::mp_micropython_opt_level);
        map.put(get_fmt_type, this::get_fmt_type);
        map.put(get_fmt_num, this::get_fmt_num);
        map.put(calc_size_items, this::calc_size_items);
        map.put(struct_calcsize, this::struct_calcsize);
        map.put(struct_unpack_from, this::struct_unpack_from);
        map.put(struct_pack_into_internal, this::struct_pack_into_internal);
        map.put(struct_pack, this::struct_pack);
        map.put(struct_pack_into, this::struct_pack_into);
        map.put(mp_sys_exit, this::mp_sys_exit);
        map.put(mp_sys_print_exception, this::mp_sys_print_exception);
        map.put(mp_sys_exc_info, this::mp_sys_exc_info);
        map.put(mp_sys_getsizeof, this::mp_sys_getsizeof);
        map.put(mp_errno_to_str, this::mp_errno_to_str);
        map.put(mp_execute_bytecode, this::mp_execute_bytecode);
        map.put(unlikely_fun_pos_args_mismatch, this::unlikely_fun_pos_args_mismatch);
        map.put(mp_decode_uint, this::mp_decode_uint);
        map.put(mp_decode_uint_value, this::mp_decode_uint_value);
        map.put(mp_decode_uint_skip, this::mp_decode_uint_skip);
        map.put(mp_setup_code_state, this::mp_setup_code_state);
        map.put(mp_opcode_format, this::mp_opcode_format);
        map.put(str_startswith_word, this::str_startswith_word);
        map.put(mp_repl_continue_with_input, this::mp_repl_continue_with_input);
        map.put(mp_repl_autocomplete, this::mp_repl_autocomplete);
        map.put(mp_small_int_mul_overflow, this::mp_small_int_mul_overflow);
        map.put(mp_small_int_modulo, this::mp_small_int_modulo);
        map.put(mp_small_int_floor_divide, this::mp_small_int_floor_divide);
        map.put(mp_frozen_stat_helper, this::mp_frozen_stat_helper);
        map.put(mp_find_frozen_str, this::mp_find_frozen_str);
        map.put(mp_frozen_stat, this::mp_frozen_stat);
        map.put(mp_find_frozen_module, this::mp_find_frozen_module);
        map.put(uctypes_struct_addressof, this::uctypes_struct_addressof);
        map.put(uctypes_struct_bytearray_at, this::uctypes_struct_bytearray_at);
        map.put(uctypes_struct_bytes_at, this::uctypes_struct_bytes_at);
        map.put(get_aligned, this::get_aligned);
        map.put(uctypes_struct_make_new, this::uctypes_struct_make_new);
        map.put(uctypes_struct_print, this::uctypes_struct_print);
        map.put(set_aligned, this::set_aligned);
        map.put(uctypes_struct_size, this::uctypes_struct_size);
        map.put(uctypes_struct_sizeof, this::uctypes_struct_sizeof);
        map.put(uctypes_struct_agg_size, this::uctypes_struct_agg_size);
        map.put(uctypes_get_buffer, this::uctypes_get_buffer);
        map.put(uctypes_struct_subscr, this::uctypes_struct_subscr);
        map.put(uctypes_struct_attr_op, this::uctypes_struct_attr_op);
        map.put(uctypes_struct_attr, this::uctypes_struct_attr);
        map.put(ujson_stream_next, this::ujson_stream_next);
        map.put(mod_ujson_load, this::mod_ujson_load);
        map.put(mod_ujson_loads, this::mod_ujson_loads);
        map.put(mod_ujson_dump, this::mod_ujson_dump);
        map.put(mod_ujson_dumps, this::mod_ujson_dumps);
        map.put(match_print, this::match_print);
        map.put(re_print, this::re_print);
        map.put(_compilecode, this::_compilecode);
        map.put(match_group, this::match_group);
        map.put(re1_5_sizecode, this::re1_5_sizecode);
        map.put(re1_5_compilecode, this::re1_5_compilecode);
        map.put(re1_5_dumpcode, this::re1_5_dumpcode);
        map.put(mod_re_compile, this::mod_re_compile);
        map.put(_re1_5_classmatch, this::_re1_5_classmatch);
        map.put(_re1_5_namedclassmatch, this::_re1_5_namedclassmatch);
        map.put(recursiveloop, this::recursiveloop);
        map.put(re1_5_recursiveloopprog, this::re1_5_recursiveloopprog);
        map.put(ure_exec_isra_2, this::ure_exec_isra_2);
        map.put(re_match, this::re_match);
        map.put(re_search, this::re_search);
        map.put(mod_re_match, this::mod_re_match);
        map.put(mod_re_search, this::mod_re_search);
        map.put(re_split, this::re_split);
        map.put(tinf_build_tree, this::tinf_build_tree);
        map.put(read_src_stream, this::read_src_stream);
        map.put(uzlib_get_byte, this::uzlib_get_byte);
        map.put(tinf_getbit, this::tinf_getbit);
        map.put(tinf_read_bits, this::tinf_read_bits);
        map.put(tinf_decode_symbol, this::tinf_decode_symbol);
        map.put(tinf_decode_trees, this::tinf_decode_trees);
        map.put(tinf_get_le_uint32, this::tinf_get_le_uint32);
        map.put(tinf_get_be_uint32, this::tinf_get_be_uint32);
        map.put(uzlib_uncompress, this::uzlib_uncompress);
        map.put(uzlib_zlib_parse_header, this::uzlib_zlib_parse_header);
        map.put(tinf_skip_bytes, this::tinf_skip_bytes);
        map.put(tinf_get_uint16, this::tinf_get_uint16);
        map.put(uzlib_gzip_parse_header, this::uzlib_gzip_parse_header);
        map.put(decompio_make_new, this::decompio_make_new);
        map.put(uzlib_adler32, this::uzlib_adler32);
        map.put(uzlib_crc32, this::uzlib_crc32);
        map.put(uzlib_uncompress_chksum, this::uzlib_uncompress_chksum);
        map.put(decompio_read, this::decompio_read);
        map.put(mod_uzlib_decompress, this::mod_uzlib_decompress);
        map.put(get_heap, this::get_heap);
        map.put(heap_siftdown_isra_0, this::heap_siftdown_isra_0);
        map.put(heap_siftup, this::heap_siftup);
        map.put(mod_uheapq_heapify, this::mod_uheapq_heapify);
        map.put(mod_uheapq_heappush, this::mod_uheapq_heappush);
        map.put(mod_uheapq_heappop, this::mod_uheapq_heappop);
        map.put(utimeq_unary_op, this::utimeq_unary_op);
        map.put(utimeq_make_new, this::utimeq_make_new);
        map.put(mod_utimeq_peektime, this::mod_utimeq_peektime);
        map.put(heap_siftdown_constprop_3, this::heap_siftdown_constprop_3);
        map.put(mod_utimeq_heappop, this::mod_utimeq_heappop);
        map.put(mod_utimeq_heappush, this::mod_utimeq_heappush);
        map.put(sha256_transform, this::sha256_transform);
        map.put(sha256_init, this::sha256_init);
        map.put(sha256_update, this::sha256_update);
        map.put(uhashlib_sha256_update, this::uhashlib_sha256_update);
        map.put(uhashlib_sha256_make_new, this::uhashlib_sha256_make_new);
        map.put(sha256_final, this::sha256_final);
        map.put(uhashlib_sha256_digest, this::uhashlib_sha256_digest);
        map.put(mod_binascii_hexlify, this::mod_binascii_hexlify);
        map.put(mod_binascii_b2a_base64, this::mod_binascii_b2a_base64);
        map.put(mod_binascii_unhexlify, this::mod_binascii_unhexlify);
        map.put(mod_binascii_a2b_base64, this::mod_binascii_a2b_base64);
        map.put(mod_binascii_crc32, this::mod_binascii_crc32);
        map.put(machine_mem_get_addr, this::machine_mem_get_addr);
        map.put(machine_mem_print, this::machine_mem_print);
        map.put(machine_mem_subscr, this::machine_mem_subscr);
        map.put(yasmarang, this::yasmarang);
        map.put(yasmarang_randbelow, this::yasmarang_randbelow);
        map.put(mod_urandom_uniform, this::mod_urandom_uniform);
        map.put(mod_urandom_randint, this::mod_urandom_randint);
        map.put(mod_urandom_randrange, this::mod_urandom_randrange);
        map.put(mod_urandom_seed, this::mod_urandom_seed);
        map.put(mod_urandom_getrandbits, this::mod_urandom_getrandbits);
        map.put(mod_urandom_choice, this::mod_urandom_choice);
        map.put(mod_urandom_random, this::mod_urandom_random);
        map.put(mp_vfs_proxy_call, this::mp_vfs_proxy_call);
        map.put(mp_vfs_umount, this::mp_vfs_umount);
        map.put(mp_vfs_getcwd, this::mp_vfs_getcwd);
        map.put(mp_vfs_ilistdir_it_iternext, this::mp_vfs_ilistdir_it_iternext);
        map.put(mp_vfs_lookup_path, this::mp_vfs_lookup_path);
        map.put(mp_vfs_mount, this::mp_vfs_mount);
        map.put(lookup_path, this::lookup_path);
        map.put(mp_vfs_open, this::mp_vfs_open);
        map.put(mp_vfs_chdir, this::mp_vfs_chdir);
        map.put(mp_vfs_ilistdir, this::mp_vfs_ilistdir);
        map.put(mp_vfs_listdir, this::mp_vfs_listdir);
        map.put(mp_vfs_mkdir, this::mp_vfs_mkdir);
        map.put(mp_vfs_remove, this::mp_vfs_remove);
        map.put(mp_vfs_rename, this::mp_vfs_rename);
        map.put(mp_vfs_rmdir, this::mp_vfs_rmdir);
        map.put(mp_vfs_stat, this::mp_vfs_stat);
        map.put(mp_vfs_statvfs, this::mp_vfs_statvfs);
        map.put(mp_vfs_import_stat, this::mp_vfs_import_stat);
        map.put(mp_reader_vfs_close, this::mp_reader_vfs_close);
        map.put(mp_reader_vfs_readbyte, this::mp_reader_vfs_readbyte);
        map.put(mp_reader_new_file, this::mp_reader_new_file);
        map.put(time_ticks_diff, this::time_ticks_diff);
        map.put(time_sleep, this::time_sleep);
        map.put(time_sleep_ms, this::time_sleep_ms);
        map.put(time_ticks_add, this::time_ticks_add);
        map.put(time_ticks_ms, this::time_ticks_ms);
        map.put(time_ticks_cpu, this::time_ticks_cpu);
        map.put(strn_print_strn, this::strn_print_strn);
        map.put(printf, this::printf);
        map.put(putchar, this::putchar);
        map.put(puts, this::puts);
        map.put(vsnprintf, this::vsnprintf);
        map.put(snprintf, this::snprintf);
        map.put(main, this::main);
        map.put(Signal_Handler, this::Signal_Handler);
        map.put(_exit, this::_exit);
        map.put(_start, this::_start);
        map.put(Reset_Handler, this::Reset_Handler);
        map.put(__fatal_error, this::__fatal_error);
        map.put(nlr_jump_fail, this::nlr_jump_fail);
        map.put(mp_hal_stdin_rx_chr, this::mp_hal_stdin_rx_chr);
        map.put(mp_hal_stdout_tx_strn, this::mp_hal_stdout_tx_strn);
        map.put(mp_hal_delay_ms, this::mp_hal_delay_ms);
        map.put(mp_hal_ticks_ms, this::mp_hal_ticks_ms);
        map.put(mp_hal_ticks_cpu, this::mp_hal_ticks_cpu);
        map.put(usystem_print_hook, this::usystem_print_hook);
        map.put(usystem_debug, this::usystem_debug);
        map.put(usystem_set_stdin_char, this::usystem_set_stdin_char);
        map.put(parse_2, this::parse_2);
        map.put(usystem_syscall, this::usystem_syscall);
        map.put(usystem_signal, this::usystem_signal);
        map.put(usystem_components, this::usystem_components);
        map.put(usystem_methods, this::usystem_methods);
        map.put(usystem_annotations, this::usystem_annotations);
        map.put(usystem_get_stdout_str, this::usystem_get_stdout_str);
        map.put(gc_collect, this::gc_collect);
        map.put(vfs_openpie_file___exit__, this::vfs_openpie_file___exit__);
        map.put(vfs_openpie_file_print, this::vfs_openpie_file_print);
        map.put(unlikely_check_fd_is_open_isra_0_part_1, this::unlikely_check_fd_is_open_isra_0_part_1);
        map.put(vfs_openpie_file_fileno, this::vfs_openpie_file_fileno);
        map.put(SVC_CALL_VFS, this::SVC_CALL_VFS);
        map.put(SVC_CALL_VFS_OUT, this::SVC_CALL_VFS_OUT);
        map.put(vfs_openpie_file_ioctl, this::vfs_openpie_file_ioctl);
        map.put(vfs_openpie_file_write, this::vfs_openpie_file_write);
        map.put(vfs_openpie_file_read, this::vfs_openpie_file_read);
        map.put(mp_vfs_openpie_file_open, this::mp_vfs_openpie_file_open);
        map.put(vfs_openpie_file_make_new, this::vfs_openpie_file_make_new);
        map.put(gc_helper_get_regs_and_sp, this::gc_helper_get_regs_and_sp);
        map.put(stdio_obj___exit__, this::stdio_obj___exit__);
        map.put(stdio_obj_print, this::stdio_obj_print);
        map.put(stdio_buffer_write, this::stdio_buffer_write);
        map.put(stdio_buffer_read, this::stdio_buffer_read);
        map.put(stdio_write, this::stdio_write);
        map.put(stdio_read, this::stdio_read);
        map.put(mp_hal_stdout_tx_strn_cooked, this::mp_hal_stdout_tx_strn_cooked);
        map.put(mp_hal_stdout_tx_str, this::mp_hal_stdout_tx_str);
        map.put(mp_hal_set_interrupt_char, this::mp_hal_set_interrupt_char);
        map.put(parse_compile_execute, this::parse_compile_execute);
        map.put(pyexec_raw_repl, this::pyexec_raw_repl);
        map.put(pyexec_friendly_repl, this::pyexec_friendly_repl);
        map.put(pyexec_frozen_module, this::pyexec_frozen_module);
        map.put(memcpy, this::memcpy);
        map.put(memmove, this::memmove);
        map.put(memset, this::memset);
        map.put(memcmp, this::memcmp);
        map.put(strlen, this::strlen);
        map.put(strcmp, this::strcmp);
        map.put(strncmp, this::strncmp);
        map.put(strchr, this::strchr);
        map.put(mp_hal_move_cursor_back, this::mp_hal_move_cursor_back);
        map.put(readline_init, this::readline_init);
        map.put(readline_push_history, this::readline_push_history);
        map.put(readline_process_char, this::readline_process_char);
        map.put(readline, this::readline);
        map.put(scalbnf, this::scalbnf);
        map.put(powf, this::powf);
        map.put(expf, this::expf);
        map.put(expm1f, this::expm1f);
        map.put(__expo2f, this::__expo2f);
        map.put(logf, this::logf);
        map.put(log10f, this::log10f);
        map.put(coshf, this::coshf);
        map.put(sinhf, this::sinhf);
        map.put(tanhf, this::tanhf);
        map.put(ceilf, this::ceilf);
        map.put(floorf, this::floorf);
        map.put(truncf, this::truncf);
        map.put(acoshf, this::acoshf);
        map.put(text_R, this::text_R);
        map.put(asinf, this::asinf);
        map.put(acosf, this::acosf);
        map.put(asinhf, this::asinhf);
        map.put(atan2f, this::atan2f);
        map.put(atanf, this::atanf);
        map.put(atanhf, this::atanhf);
        map.put(__ieee754_rem_pio2f, this::__ieee754_rem_pio2f);
        map.put(sqrtf, this::sqrtf);
        map.put(__ieee754_lgammaf_r, this::__ieee754_lgammaf_r);
        map.put(fmodf, this::fmodf);
        map.put(__kernel_cosf, this::__kernel_cosf);
        map.put(__kernel_rem_pio2f, this::__kernel_rem_pio2f);
        map.put(__kernel_sinf, this::__kernel_sinf);
        map.put(__kernel_tanf, this::__kernel_tanf);
        map.put(log1pf, this::log1pf);
        map.put(nearbyintf, this::nearbyintf);
        map.put(cosf, this::cosf);
        map.put(erff, this::erff);
        map.put(erfcf, this::erfcf);
        map.put(frexpf, this::frexpf);
        map.put(ldexpf, this::ldexpf);
        map.put(modff, this::modff);
        map.put(sinf, this::sinf);
        map.put(tanf, this::tanf);
        map.put(lgammaf, this::lgammaf);
        map.put(tgammaf, this::tgammaf);
        map.put(__aeabi_uidiv, this::__aeabi_uidiv);
        map.put(__aeabi_uidivmod, this::__aeabi_uidivmod);
        map.put(__divsi3, this::__divsi3);
        map.put(__aeabi_idivmod, this::__aeabi_idivmod);
        map.put(__aeabi_idiv0, this::__aeabi_idiv0);
        map.put(__aeabi_cfrcmple, this::__aeabi_cfrcmple);
        map.put(__aeabi_cfcmpeq, this::__aeabi_cfcmpeq);
        map.put(__aeabi_fcmpeq, this::__aeabi_fcmpeq);
        map.put(__aeabi_fcmplt, this::__aeabi_fcmplt);
        map.put(__aeabi_fcmple, this::__aeabi_fcmple);
        map.put(__aeabi_fcmpgt, this::__aeabi_fcmpgt);
        map.put(__aeabi_fcmpge, this::__aeabi_fcmpge);
        map.put(__fixunssfsi, this::__fixunssfsi);
        map.put(__aeabi_fadd, this::__aeabi_fadd);
        map.put(__aeabi_fdiv, this::__aeabi_fdiv);
        map.put(__eqsf2, this::__eqsf2);
        map.put(__gesf2, this::__gesf2);
        map.put(__ltsf2, this::__ltsf2);
        map.put(__aeabi_fmul, this::__aeabi_fmul);
        map.put(__aeabi_fsub, this::__aeabi_fsub);
        map.put(__aeabi_fcmpun, this::__aeabi_fcmpun);
        map.put(__aeabi_f2iz, this::__aeabi_f2iz);
        map.put(__aeabi_i2f, this::__aeabi_i2f);
        map.put(__aeabi_ui2f, this::__aeabi_ui2f);
        map.put(__aeabi_i2d, this::__aeabi_i2d);
        map.put(__aeabi_f2d, this::__aeabi_f2d);
        map.put(__aeabi_d2f, this::__aeabi_d2f);
        map.put(__clzsi2, this::__clzsi2);
        return map;
    }

    // function: Function(address=134217740, size=20, name='nlr_push_tail', path='build/py/nlr.o', has_indirect=True)
    public void nlr_push_tail() throws Exception
    {
        call(this::nlr_push_tail);
    }

    // function: Function(address=134217760, size=16, name='nlr_pop', path='build/py/nlr.o', has_indirect=False)
    public void nlr_pop() throws Exception
    {
        call(this::nlr_pop);
    }

    // function: Function(address=134217776, size=40, name='nlr_push', path='build/py/nlrthumb.o', has_indirect=False)
    public void nlr_push() throws Exception
    {
        call(this::nlr_push);
    }

    // function: Function(address=134217816, size=68, name='nlr_jump', path='build/py/nlrthumb.o', has_indirect=False)
    public void nlr_jump() throws Exception
    {
        call(this::nlr_jump);
    }

    // function: Function(address=134217884, size=64, name='m_malloc', path='build/py/malloc.o', has_indirect=False)
    public void m_malloc() throws Exception
    {
        call(this::m_malloc);
    }

    // function: Function(address=134217948, size=48, name='m_malloc_maybe', path='build/py/malloc.o', has_indirect=False)
    public void m_malloc_maybe() throws Exception
    {
        call(this::m_malloc_maybe);
    }

    // function: Function(address=134217996, size=8, name='m_malloc0', path='build/py/malloc.o', has_indirect=False)
    public void m_malloc0() throws Exception
    {
        call(this::m_malloc0);
    }

    // function: Function(address=134218004, size=68, name='m_realloc', path='build/py/malloc.o', has_indirect=False)
    public void m_realloc() throws Exception
    {
        call(this::m_realloc);
    }

    // function: Function(address=134218072, size=64, name='m_realloc_maybe', path='build/py/malloc.o', has_indirect=False)
    public void m_realloc_maybe() throws Exception
    {
        call(this::m_realloc_maybe);
    }

    // function: Function(address=134218136, size=28, name='m_free', path='build/py/malloc.o', has_indirect=False)
    public void m_free() throws Exception
    {
        call(this::m_free);
    }

    // function: Function(address=134218164, size=16, name='m_get_total_bytes_allocated', path='build/py/malloc.o', has_indirect=False)
    public void m_get_total_bytes_allocated() throws Exception
    {
        call(this::m_get_total_bytes_allocated);
    }

    // function: Function(address=134218180, size=16, name='m_get_current_bytes_allocated', path='build/py/malloc.o', has_indirect=False)
    public void m_get_current_bytes_allocated() throws Exception
    {
        call(this::m_get_current_bytes_allocated);
    }

    // function: Function(address=134218196, size=16, name='m_get_peak_bytes_allocated', path='build/py/malloc.o', has_indirect=False)
    public void m_get_peak_bytes_allocated() throws Exception
    {
        call(this::m_get_peak_bytes_allocated);
    }

    // function: Function(address=134218212, size=240, name='gc_mark_subtree', path='build/py/gc.o', has_indirect=False)
    public void gc_mark_subtree() throws Exception
    {
        call(this::gc_mark_subtree);
    }

    // function: Function(address=134218452, size=128, name='gc_init', path='build/py/gc.o', has_indirect=False)
    public void gc_init() throws Exception
    {
        call(this::gc_init);
    }

    // function: Function(address=134218580, size=20, name='gc_lock', path='build/py/gc.o', has_indirect=False)
    public void gc_lock() throws Exception
    {
        call(this::gc_lock);
    }

    // function: Function(address=134218600, size=20, name='gc_unlock', path='build/py/gc.o', has_indirect=False)
    public void gc_unlock() throws Exception
    {
        call(this::gc_unlock);
    }

    // function: Function(address=134218620, size=20, name='gc_is_locked', path='build/py/gc.o', has_indirect=False)
    public void gc_is_locked() throws Exception
    {
        call(this::gc_is_locked);
    }

    // function: Function(address=134218640, size=276, name='gc_collect_start', path='build/py/gc.o', has_indirect=False)
    public void gc_collect_start() throws Exception
    {
        call(this::gc_collect_start);
    }

    // function: Function(address=134218916, size=136, name='gc_collect_root', path='build/py/gc.o', has_indirect=False)
    public void gc_collect_root() throws Exception
    {
        call(this::gc_collect_root);
    }

    // function: Function(address=134219052, size=412, name='gc_collect_end', path='build/py/gc.o', has_indirect=False)
    public void gc_collect_end() throws Exception
    {
        call(this::gc_collect_end);
    }

    // function: Function(address=134219464, size=280, name='gc_info', path='build/py/gc.o', has_indirect=False)
    public void gc_info() throws Exception
    {
        call(this::gc_info);
    }

    // function: Function(address=134219744, size=460, name='gc_alloc', path='build/py/gc.o', has_indirect=False)
    public void gc_alloc() throws Exception
    {
        call(this::gc_alloc);
    }

    // function: Function(address=134220204, size=132, name='gc_free', path='build/py/gc.o', has_indirect=False)
    public void gc_free() throws Exception
    {
        call(this::gc_free);
    }

    // function: Function(address=134220336, size=108, name='gc_nbytes', path='build/py/gc.o', has_indirect=False)
    public void gc_nbytes() throws Exception
    {
        call(this::gc_nbytes);
    }

    // function: Function(address=134220444, size=680, name='gc_realloc', path='build/py/gc.o', has_indirect=False)
    public void gc_realloc() throws Exception
    {
        call(this::gc_realloc);
    }

    // function: Function(address=134221124, size=316, name='gc_dump_info', path='build/py/gc.o', has_indirect=False)
    public void gc_dump_info() throws Exception
    {
        call(this::gc_dump_info);
    }

    // function: Function(address=134221440, size=452, name='gc_dump_alloc_table', path='build/py/gc.o', has_indirect=False)
    public void gc_dump_alloc_table() throws Exception
    {
        call(this::gc_dump_alloc_table);
    }

    // function: Function(address=134221892, size=16, name='mp_pystack_init', path='build/py/pystack.o', has_indirect=False)
    public void mp_pystack_init() throws Exception
    {
        call(this::mp_pystack_init);
    }

    // function: Function(address=134221908, size=48, name='mp_pystack_alloc', path='build/py/pystack.o', has_indirect=False)
    public void mp_pystack_alloc() throws Exception
    {
        call(this::mp_pystack_alloc);
    }

    // function: Function(address=134221956, size=28, name='find_qstr', path='build/py/qstr.o', has_indirect=False)
    public void find_qstr() throws Exception
    {
        call(this::find_qstr);
    }

    // function: Function(address=134221984, size=36, name='qstr_compute_hash', path='build/py/qstr.o', has_indirect=False)
    public void qstr_compute_hash() throws Exception
    {
        call(this::qstr_compute_hash);
    }

    // function: Function(address=134222020, size=24, name='qstr_init', path='build/py/qstr.o', has_indirect=False)
    public void qstr_init() throws Exception
    {
        call(this::qstr_init);
    }

    // function: Function(address=134222044, size=108, name='qstr_find_strn', path='build/py/qstr.o', has_indirect=False)
    public void qstr_find_strn() throws Exception
    {
        call(this::qstr_find_strn);
    }

    // function: Function(address=134222152, size=296, name='qstr_from_strn', path='build/py/qstr.o', has_indirect=False)
    public void qstr_from_strn() throws Exception
    {
        call(this::qstr_from_strn);
    }

    // function: Function(address=134222448, size=18, name='qstr_from_str', path='build/py/qstr.o', has_indirect=False)
    public void qstr_from_str() throws Exception
    {
        call(this::qstr_from_str);
    }

    // function: Function(address=134222466, size=16, name='qstr_hash', path='build/py/qstr.o', has_indirect=False)
    public void qstr_hash() throws Exception
    {
        call(this::qstr_hash);
    }

    // function: Function(address=134222482, size=10, name='qstr_len', path='build/py/qstr.o', has_indirect=False)
    public void qstr_len() throws Exception
    {
        call(this::qstr_len);
    }

    // function: Function(address=134222492, size=10, name='qstr_str', path='build/py/qstr.o', has_indirect=False)
    public void qstr_str() throws Exception
    {
        call(this::qstr_str);
    }

    // function: Function(address=134222502, size=16, name='qstr_data', path='build/py/qstr.o', has_indirect=False)
    public void qstr_data() throws Exception
    {
        call(this::qstr_data);
    }

    // function: Function(address=134222520, size=120, name='qstr_pool_info', path='build/py/qstr.o', has_indirect=False)
    public void qstr_pool_info() throws Exception
    {
        call(this::qstr_pool_info);
    }

    // function: Function(address=134222640, size=68, name='qstr_dump_data', path='build/py/qstr.o', has_indirect=False)
    public void qstr_dump_data() throws Exception
    {
        call(this::qstr_dump_data);
    }

    // function: Function(address=134222708, size=56, name='vstr_ensure_extra', path='build/py/vstr.o', has_indirect=False)
    public void vstr_ensure_extra() throws Exception
    {
        call(this::vstr_ensure_extra);
    }

    // function: Function(address=134222764, size=36, name='vstr_add_strn', path='build/py/vstr.o', has_indirect=True)
    public void vstr_add_strn() throws Exception
    {
        call(this::vstr_add_strn);
    }

    // function: Function(address=134222800, size=48, name='vstr_ins_blank_bytes_constprop_2', path='build/py/vstr.o', has_indirect=False)
    public void vstr_ins_blank_bytes_constprop_2() throws Exception
    {
        call(this::vstr_ins_blank_bytes_constprop_2);
    }

    // function: Function(address=134222848, size=34, name='vstr_init', path='build/py/vstr.o', has_indirect=False)
    public void vstr_init() throws Exception
    {
        call(this::vstr_init);
    }

    // function: Function(address=134222882, size=16, name='vstr_init_len', path='build/py/vstr.o', has_indirect=False)
    public void vstr_init_len() throws Exception
    {
        call(this::vstr_init_len);
    }

    // function: Function(address=134222898, size=18, name='vstr_init_fixed_buf', path='build/py/vstr.o', has_indirect=False)
    public void vstr_init_fixed_buf() throws Exception
    {
        call(this::vstr_init_fixed_buf);
    }

    // function: Function(address=134222916, size=24, name='vstr_init_print', path='build/py/vstr.o', has_indirect=False)
    public void vstr_init_print() throws Exception
    {
        call(this::vstr_init_print);
    }

    // function: Function(address=134222940, size=24, name='vstr_clear', path='build/py/vstr.o', has_indirect=False)
    public void vstr_clear() throws Exception
    {
        call(this::vstr_clear);
    }

    // function: Function(address=134222964, size=22, name='vstr_new', path='build/py/vstr.o', has_indirect=False)
    public void vstr_new() throws Exception
    {
        call(this::vstr_new);
    }

    // function: Function(address=134222986, size=30, name='vstr_free', path='build/py/vstr.o', has_indirect=False)
    public void vstr_free() throws Exception
    {
        call(this::vstr_free);
    }

    // function: Function(address=134223016, size=48, name='vstr_extend', path='build/py/vstr.o', has_indirect=False)
    public void vstr_extend() throws Exception
    {
        call(this::vstr_extend);
    }

    // function: Function(address=134223064, size=22, name='vstr_add_len', path='build/py/vstr.o', has_indirect=False)
    public void vstr_add_len() throws Exception
    {
        call(this::vstr_add_len);
    }

    // function: Function(address=134223086, size=30, name='vstr_null_terminated_str', path='build/py/vstr.o', has_indirect=False)
    public void vstr_null_terminated_str() throws Exception
    {
        call(this::vstr_null_terminated_str);
    }

    // function: Function(address=134223116, size=14, name='vstr_add_byte', path='build/py/vstr.o', has_indirect=False)
    public void vstr_add_byte() throws Exception
    {
        call(this::vstr_add_byte);
    }

    // function: Function(address=134223132, size=152, name='vstr_add_char', path='build/py/vstr.o', has_indirect=False)
    public void vstr_add_char() throws Exception
    {
        call(this::vstr_add_char);
    }

    // function: Function(address=134223284, size=24, name='vstr_add_str', path='build/py/vstr.o', has_indirect=False)
    public void vstr_add_str() throws Exception
    {
        call(this::vstr_add_str);
    }

    // function: Function(address=134223308, size=12, name='vstr_ins_byte', path='build/py/vstr.o', has_indirect=False)
    public void vstr_ins_byte() throws Exception
    {
        call(this::vstr_ins_byte);
    }

    // function: Function(address=134223320, size=12, name='vstr_ins_char', path='build/py/vstr.o', has_indirect=False)
    public void vstr_ins_char() throws Exception
    {
        call(this::vstr_ins_char);
    }

    // function: Function(address=134223332, size=16, name='vstr_cut_tail_bytes', path='build/py/vstr.o', has_indirect=False)
    public void vstr_cut_tail_bytes() throws Exception
    {
        call(this::vstr_cut_tail_bytes);
    }

    // function: Function(address=134223348, size=46, name='vstr_cut_out_bytes', path='build/py/vstr.o', has_indirect=False)
    public void vstr_cut_out_bytes() throws Exception
    {
        call(this::vstr_cut_out_bytes);
    }

    // function: Function(address=134223394, size=12, name='plat_print_strn', path='build/py/mpprint.o', has_indirect=False)
    public void plat_print_strn() throws Exception
    {
        call(this::plat_print_strn);
    }

    // function: Function(address=134223406, size=30, name='mp_print_str', path='build/py/mpprint.o', has_indirect=False)
    public void mp_print_str() throws Exception
    {
        call(this::mp_print_str);
    }

    // function: Function(address=134223436, size=184, name='mp_print_strn', path='build/py/mpprint.o', has_indirect=False)
    public void mp_print_strn() throws Exception
    {
        call(this::mp_print_strn);
    }

    // function: Function(address=134223620, size=218, name='mp_print_int', path='build/py/mpprint.o', has_indirect=False)
    public void mp_print_int() throws Exception
    {
        call(this::mp_print_int);
    }

    // function: Function(address=134223840, size=576, name='mp_print_mp_int', path='build/py/mpprint.o', has_indirect=False)
    public void mp_print_mp_int() throws Exception
    {
        call(this::mp_print_mp_int);
    }

    // function: Function(address=134224416, size=138, name='mp_print_float', path='build/py/mpprint.o', has_indirect=False)
    public void mp_print_float() throws Exception
    {
        call(this::mp_print_float);
    }

    // function: Function(address=134224556, size=672, name='mp_vprintf', path='build/py/mpprint.o', has_indirect=False)
    public void mp_vprintf() throws Exception
    {
        call(this::mp_vprintf);
    }

    // function: Function(address=134225228, size=22, name='mp_printf', path='build/py/mpprint.o', has_indirect=False)
    public void mp_printf() throws Exception
    {
        call(this::mp_printf);
    }

    // function: Function(address=134225250, size=54, name='utf8_get_char', path='build/py/unicode.o', has_indirect=False)
    public void utf8_get_char() throws Exception
    {
        call(this::utf8_get_char);
    }

    // function: Function(address=134225304, size=18, name='utf8_next_char', path='build/py/unicode.o', has_indirect=False)
    public void utf8_next_char() throws Exception
    {
        call(this::utf8_next_char);
    }

    // function: Function(address=134225322, size=30, name='utf8_ptr_to_index', path='build/py/unicode.o', has_indirect=False)
    public void utf8_ptr_to_index() throws Exception
    {
        call(this::utf8_ptr_to_index);
    }

    // function: Function(address=134225352, size=32, name='utf8_charlen', path='build/py/unicode.o', has_indirect=False)
    public void utf8_charlen() throws Exception
    {
        call(this::utf8_charlen);
    }

    // function: Function(address=134225384, size=24, name='unichar_isspace', path='build/py/unicode.o', has_indirect=True)
    public void unichar_isspace() throws Exception
    {
        call(this::unichar_isspace);
    }

    // function: Function(address=134225408, size=24, name='unichar_isalpha', path='build/py/unicode.o', has_indirect=True)
    public void unichar_isalpha() throws Exception
    {
        call(this::unichar_isalpha);
    }

    // function: Function(address=134225432, size=24, name='unichar_isdigit', path='build/py/unicode.o', has_indirect=True)
    public void unichar_isdigit() throws Exception
    {
        call(this::unichar_isdigit);
    }

    // function: Function(address=134225456, size=24, name='unichar_isxdigit', path='build/py/unicode.o', has_indirect=False)
    public void unichar_isxdigit() throws Exception
    {
        call(this::unichar_isxdigit);
    }

    // function: Function(address=134225480, size=32, name='unichar_isident', path='build/py/unicode.o', has_indirect=False)
    public void unichar_isident() throws Exception
    {
        call(this::unichar_isident);
    }

    // function: Function(address=134225512, size=24, name='unichar_isupper', path='build/py/unicode.o', has_indirect=True)
    public void unichar_isupper() throws Exception
    {
        call(this::unichar_isupper);
    }

    // function: Function(address=134225536, size=24, name='unichar_islower', path='build/py/unicode.o', has_indirect=True)
    public void unichar_islower() throws Exception
    {
        call(this::unichar_islower);
    }

    // function: Function(address=134225560, size=18, name='unichar_tolower', path='build/py/unicode.o', has_indirect=True)
    public void unichar_tolower() throws Exception
    {
        call(this::unichar_tolower);
    }

    // function: Function(address=134225578, size=18, name='unichar_toupper', path='build/py/unicode.o', has_indirect=True)
    public void unichar_toupper() throws Exception
    {
        call(this::unichar_toupper);
    }

    // function: Function(address=134225596, size=14, name='unichar_xdigit_value', path='build/py/unicode.o', has_indirect=False)
    public void unichar_xdigit_value() throws Exception
    {
        call(this::unichar_xdigit_value);
    }

    // function: Function(address=134225610, size=78, name='utf8_check', path='build/py/unicode.o', has_indirect=False)
    public void utf8_check() throws Exception
    {
        call(this::utf8_check);
    }

    // function: Function(address=134225688, size=20, name='mpn_remove_trailing_zeros', path='build/py/mpz.o', has_indirect=False)
    public void mpn_remove_trailing_zeros() throws Exception
    {
        call(this::mpn_remove_trailing_zeros);
    }

    // function: Function(address=134225708, size=62, name='text_mpn_shr', path='build/py/mpz.o', has_indirect=False)
    public void text_mpn_shr() throws Exception
    {
        call(this::text_mpn_shr);
    }

    // function: Function(address=134225770, size=88, name='text_mpn_add', path='build/py/mpz.o', has_indirect=False)
    public void text_mpn_add() throws Exception
    {
        call(this::text_mpn_add);
    }

    // function: Function(address=134225858, size=80, name='text_mpn_sub', path='build/py/mpz.o', has_indirect=False)
    public void text_mpn_sub() throws Exception
    {
        call(this::text_mpn_sub);
    }

    // function: Function(address=134225940, size=112, name='mpn_xor_neg', path='build/py/mpz.o', has_indirect=False)
    public void mpn_xor_neg() throws Exception
    {
        call(this::mpn_xor_neg);
    }

    // function: Function(address=134226052, size=50, name='mpz_need_dig', path='build/py/mpz.o', has_indirect=False)
    public void mpz_need_dig() throws Exception
    {
        call(this::mpz_need_dig);
    }

    // function: Function(address=134226102, size=76, name='mpz_clone', path='build/py/mpz.o', has_indirect=False)
    public void mpz_clone() throws Exception
    {
        call(this::mpz_clone);
    }

    // function: Function(address=134226178, size=44, name='mpn_cmp_part_1', path='build/py/mpz.o', has_indirect=False)
    public void mpn_cmp_part_1() throws Exception
    {
        call(this::mpn_cmp_part_1);
    }

    // function: Function(address=134226222, size=28, name='mpz_free', path='build/py/mpz.o', has_indirect=False)
    public void mpz_free() throws Exception
    {
        call(this::mpz_free);
    }

    // function: Function(address=134226250, size=58, name='mpz_set_from_int_part_4', path='build/py/mpz.o', has_indirect=False)
    public void mpz_set_from_int_part_4() throws Exception
    {
        call(this::mpz_set_from_int_part_4);
    }

    // function: Function(address=134226308, size=10, name='mpz_init_zero', path='build/py/mpz.o', has_indirect=False)
    public void mpz_init_zero() throws Exception
    {
        call(this::mpz_init_zero);
    }

    // function: Function(address=134226318, size=26, name='mpz_deinit', path='build/py/mpz.o', has_indirect=False)
    public void mpz_deinit() throws Exception
    {
        call(this::mpz_deinit);
    }

    // function: Function(address=134226344, size=46, name='mpz_set', path='build/py/mpz.o', has_indirect=False)
    public void mpz_set() throws Exception
    {
        call(this::mpz_set);
    }

    // function: Function(address=134226390, size=16, name='mpz_set_from_int', path='build/py/mpz.o', has_indirect=False)
    public void mpz_set_from_int() throws Exception
    {
        call(this::mpz_set_from_int);
    }

    // function: Function(address=134226406, size=20, name='mpz_init_from_int', path='build/py/mpz.o', has_indirect=False)
    public void mpz_init_from_int() throws Exception
    {
        call(this::mpz_init_from_int);
    }

    // function: Function(address=134226426, size=42, name='mpz_init_fixed_from_int', path='build/py/mpz.o', has_indirect=False)
    public void mpz_init_fixed_from_int() throws Exception
    {
        call(this::mpz_init_fixed_from_int);
    }

    // function: Function(address=134226468, size=88, name='mpz_set_from_ll', path='build/py/mpz.o', has_indirect=False)
    public void mpz_set_from_ll() throws Exception
    {
        call(this::mpz_set_from_ll);
    }

    // function: Function(address=134226556, size=190, name='mpz_set_from_float', path='build/py/mpz.o', has_indirect=False)
    public void mpz_set_from_float() throws Exception
    {
        call(this::mpz_set_from_float);
    }

    // function: Function(address=134226746, size=164, name='mpz_set_from_str', path='build/py/mpz.o', has_indirect=False)
    public void mpz_set_from_str() throws Exception
    {
        call(this::mpz_set_from_str);
    }

    // function: Function(address=134226910, size=106, name='mpz_set_from_bytes', path='build/py/mpz.o', has_indirect=False)
    public void mpz_set_from_bytes() throws Exception
    {
        call(this::mpz_set_from_bytes);
    }

    // function: Function(address=134227016, size=70, name='mpz_cmp', path='build/py/mpz.o', has_indirect=False)
    public void mpz_cmp() throws Exception
    {
        call(this::mpz_cmp);
    }

    // function: Function(address=134227086, size=22, name='mpz_abs_inpl', path='build/py/mpz.o', has_indirect=False)
    public void mpz_abs_inpl() throws Exception
    {
        call(this::mpz_abs_inpl);
    }

    // function: Function(address=134227108, size=32, name='mpz_neg_inpl', path='build/py/mpz.o', has_indirect=False)
    public void mpz_neg_inpl() throws Exception
    {
        call(this::mpz_neg_inpl);
    }

    // function: Function(address=134227140, size=110, name='mpz_not_inpl', path='build/py/mpz.o', has_indirect=False)
    public void mpz_not_inpl() throws Exception
    {
        call(this::mpz_not_inpl);
    }

    // function: Function(address=134227252, size=208, name='mpz_shl_inpl', path='build/py/mpz.o', has_indirect=False)
    public void mpz_shl_inpl() throws Exception
    {
        call(this::mpz_shl_inpl);
    }

    // function: Function(address=134227460, size=194, name='mpz_shr_inpl', path='build/py/mpz.o', has_indirect=False)
    public void mpz_shr_inpl() throws Exception
    {
        call(this::mpz_shr_inpl);
    }

    // function: Function(address=134227654, size=116, name='mpz_add_inpl', path='build/py/mpz.o', has_indirect=False)
    public void mpz_add_inpl() throws Exception
    {
        call(this::mpz_add_inpl);
    }

    // function: Function(address=134227770, size=130, name='mpz_sub_inpl', path='build/py/mpz.o', has_indirect=False)
    public void mpz_sub_inpl() throws Exception
    {
        call(this::mpz_sub_inpl);
    }

    // function: Function(address=134227900, size=310, name='mpz_and_inpl', path='build/py/mpz.o', has_indirect=False)
    public void mpz_and_inpl() throws Exception
    {
        call(this::mpz_and_inpl);
    }

    // function: Function(address=134228210, size=296, name='mpz_or_inpl', path='build/py/mpz.o', has_indirect=False)
    public void mpz_or_inpl() throws Exception
    {
        call(this::mpz_or_inpl);
    }

    // function: Function(address=134228506, size=218, name='mpz_xor_inpl', path='build/py/mpz.o', has_indirect=False)
    public void mpz_xor_inpl() throws Exception
    {
        call(this::mpz_xor_inpl);
    }

    // function: Function(address=134228724, size=262, name='mpz_mul_inpl', path='build/py/mpz.o', has_indirect=False)
    public void mpz_mul_inpl() throws Exception
    {
        call(this::mpz_mul_inpl);
    }

    // function: Function(address=134228986, size=132, name='mpz_pow_inpl', path='build/py/mpz.o', has_indirect=False)
    public void mpz_pow_inpl() throws Exception
    {
        call(this::mpz_pow_inpl);
    }

    // function: Function(address=134229120, size=688, name='mpz_divmod_inpl', path='build/py/mpz.o', has_indirect=False)
    public void mpz_divmod_inpl() throws Exception
    {
        call(this::mpz_divmod_inpl);
    }

    // function: Function(address=134229808, size=182, name='mpz_pow3_inpl', path='build/py/mpz.o', has_indirect=False)
    public void mpz_pow3_inpl() throws Exception
    {
        call(this::mpz_pow3_inpl);
    }

    // function: Function(address=134229990, size=40, name='mpz_hash', path='build/py/mpz.o', has_indirect=False)
    public void mpz_hash() throws Exception
    {
        call(this::mpz_hash);
    }

    // function: Function(address=134230032, size=56, name='mpz_as_int_checked', path='build/py/mpz.o', has_indirect=False)
    public void mpz_as_int_checked() throws Exception
    {
        call(this::mpz_as_int_checked);
    }

    // function: Function(address=134230088, size=142, name='mpz_as_bytes', path='build/py/mpz.o', has_indirect=False)
    public void mpz_as_bytes() throws Exception
    {
        call(this::mpz_as_bytes);
    }

    // function: Function(address=134230230, size=60, name='mpz_as_float', path='build/py/mpz.o', has_indirect=False)
    public void mpz_as_float() throws Exception
    {
        call(this::mpz_as_float);
    }

    // function: Function(address=134230290, size=288, name='mpz_as_str_inpl', path='build/py/mpz.o', has_indirect=False)
    public void mpz_as_str_inpl() throws Exception
    {
        call(this::mpz_as_str_inpl);
    }

    // function: Function(address=134230578, size=22, name='mp_reader_mem_readbyte', path='build/py/reader.o', has_indirect=True)
    public void mp_reader_mem_readbyte() throws Exception
    {
        call(this::mp_reader_mem_readbyte);
    }

    // function: Function(address=134230600, size=26, name='mp_reader_mem_close', path='build/py/reader.o', has_indirect=True)
    public void mp_reader_mem_close() throws Exception
    {
        call(this::mp_reader_mem_close);
    }

    // function: Function(address=134230628, size=48, name='mp_reader_new_mem', path='build/py/reader.o', has_indirect=False)
    public void mp_reader_new_mem() throws Exception
    {
        call(this::mp_reader_new_mem);
    }

    // function: Function(address=134230676, size=80, name='is_string_or_bytes', path='build/py/lexer.o', has_indirect=False)
    public void is_string_or_bytes() throws Exception
    {
        call(this::is_string_or_bytes);
    }

    // function: Function(address=134230756, size=96, name='next_char', path='build/py/lexer.o', has_indirect=False)
    public void next_char() throws Exception
    {
        call(this::next_char);
    }

    // function: Function(address=134230852, size=102, name='skip_whitespace', path='build/py/lexer.o', has_indirect=False)
    public void skip_whitespace() throws Exception
    {
        call(this::skip_whitespace);
    }

    // function: Function(address=134230956, size=1420, name='mp_lexer_to_next', path='build/py/lexer.o', has_indirect=False)
    public void mp_lexer_to_next() throws Exception
    {
        call(this::mp_lexer_to_next);
    }

    // function: Function(address=134232376, size=122, name='mp_lexer_new', path='build/py/lexer.o', has_indirect=False)
    public void mp_lexer_new() throws Exception
    {
        call(this::mp_lexer_new);
    }

    // function: Function(address=134232498, size=26, name='mp_lexer_new_from_str_len', path='build/py/lexer.o', has_indirect=False)
    public void mp_lexer_new_from_str_len() throws Exception
    {
        call(this::mp_lexer_new_from_str_len);
    }

    // function: Function(address=134232524, size=32, name='mp_lexer_new_from_file', path='build/py/lexer.o', has_indirect=False)
    public void mp_lexer_new_from_file() throws Exception
    {
        call(this::mp_lexer_new_from_file);
    }

    // function: Function(address=134232556, size=40, name='mp_lexer_free', path='build/py/lexer.o', has_indirect=False)
    public void mp_lexer_free() throws Exception
    {
        call(this::mp_lexer_free);
    }

    // function: Function(address=134232596, size=14, name='pop_result', path='build/py/parse.o', has_indirect=False)
    public void pop_result() throws Exception
    {
        call(this::pop_result);
    }

    // function: Function(address=134232612, size=20, name='peek_result', path='build/py/parse.o', has_indirect=False)
    public void peek_result() throws Exception
    {
        call(this::peek_result);
    }

    // function: Function(address=134232632, size=112, name='parser_alloc', path='build/py/parse.o', has_indirect=False)
    public void parser_alloc() throws Exception
    {
        call(this::parser_alloc);
    }

    // function: Function(address=134232744, size=48, name='push_result_node', path='build/py/parse.o', has_indirect=False)
    public void push_result_node() throws Exception
    {
        call(this::push_result_node);
    }

    // function: Function(address=134232792, size=70, name='push_rule', path='build/py/parse.o', has_indirect=False)
    public void push_rule() throws Exception
    {
        call(this::push_rule);
    }

    // function: Function(address=134232862, size=16, name='push_rule_from_arg', path='build/py/parse.o', has_indirect=False)
    public void push_rule_from_arg() throws Exception
    {
        call(this::push_rule_from_arg);
    }

    // function: Function(address=134232880, size=224, name='push_result_token', path='build/py/parse.o', has_indirect=False)
    public void push_result_token() throws Exception
    {
        call(this::push_result_token);
    }

    // function: Function(address=134233104, size=24, name='mp_parse_node_is_const_false', path='build/py/parse.o', has_indirect=False)
    public void mp_parse_node_is_const_false() throws Exception
    {
        call(this::mp_parse_node_is_const_false);
    }

    // function: Function(address=134233128, size=26, name='mp_parse_node_is_const_true', path='build/py/parse.o', has_indirect=False)
    public void mp_parse_node_is_const_true() throws Exception
    {
        call(this::mp_parse_node_is_const_true);
    }

    // function: Function(address=134233156, size=80, name='mp_parse_node_get_int_maybe', path='build/py/parse.o', has_indirect=False)
    public void mp_parse_node_get_int_maybe() throws Exception
    {
        call(this::mp_parse_node_get_int_maybe);
    }

    // function: Function(address=134233236, size=972, name='push_result_rule', path='build/py/parse.o', has_indirect=False)
    public void push_result_rule() throws Exception
    {
        call(this::push_result_rule);
    }

    // function: Function(address=134234208, size=40, name='mp_parse_node_extract_list', path='build/py/parse.o', has_indirect=False)
    public void mp_parse_node_extract_list() throws Exception
    {
        call(this::mp_parse_node_extract_list);
    }

    // function: Function(address=134234248, size=872, name='mp_parse', path='build/py/parse.o', has_indirect=False)
    public void mp_parse() throws Exception
    {
        call(this::mp_parse);
    }

    // function: Function(address=134235120, size=24, name='mp_parse_tree_clear', path='build/py/parse.o', has_indirect=False)
    public void mp_parse_tree_clear() throws Exception
    {
        call(this::mp_parse_tree_clear);
    }

    // function: Function(address=134235144, size=76, name='scope_new', path='build/py/scope.o', has_indirect=False)
    public void scope_new() throws Exception
    {
        call(this::scope_new);
    }

    // function: Function(address=134235220, size=24, name='scope_free', path='build/py/scope.o', has_indirect=False)
    public void scope_free() throws Exception
    {
        call(this::scope_free);
    }

    // function: Function(address=134235244, size=32, name='scope_find', path='build/py/scope.o', has_indirect=False)
    public void scope_find() throws Exception
    {
        call(this::scope_find);
    }

    // function: Function(address=134235276, size=70, name='scope_find_or_add_id', path='build/py/scope.o', has_indirect=False)
    public void scope_find_or_add_id() throws Exception
    {
        call(this::scope_find_or_add_id);
    }

    // function: Function(address=134235346, size=18, name='scope_find_global', path='build/py/scope.o', has_indirect=False)
    public void scope_find_global() throws Exception
    {
        call(this::scope_find_global);
    }

    // function: Function(address=134235364, size=88, name='scope_find_local_and_close_over', path='build/py/scope.o', has_indirect=False)
    public void scope_find_local_and_close_over() throws Exception
    {
        call(this::scope_find_local_and_close_over);
    }

    // function: Function(address=134235452, size=20, name='compile_increase_except_level', path='build/py/compile.o', has_indirect=False)
    public void compile_increase_except_level() throws Exception
    {
        call(this::compile_increase_except_level);
    }

    // function: Function(address=134235472, size=60, name='apply_to_single_or_list', path='build/py/compile.o', has_indirect=False)
    public void apply_to_single_or_list() throws Exception
    {
        call(this::apply_to_single_or_list);
    }

    // function: Function(address=134235532, size=20, name='compile_del_stmt', path='build/py/compile.o', has_indirect=False)
    public void compile_del_stmt() throws Exception
    {
        call(this::compile_del_stmt);
    }

    // function: Function(address=134235552, size=20, name='compile_import_name', path='build/py/compile.o', has_indirect=False)
    public void compile_import_name() throws Exception
    {
        call(this::compile_import_name);
    }

    // function: Function(address=134235572, size=44, name='scope_new_and_link', path='build/py/compile.o', has_indirect=False)
    public void scope_new_and_link() throws Exception
    {
        call(this::scope_new_and_link);
    }

    // function: Function(address=134235616, size=16, name='compile_trailer_period', path='build/py/compile.o', has_indirect=False)
    public void compile_trailer_period() throws Exception
    {
        call(this::compile_trailer_period);
    }

    // function: Function(address=134235632, size=12, name='compile_const_object', path='build/py/compile.o', has_indirect=False)
    public void compile_const_object() throws Exception
    {
        call(this::compile_const_object);
    }

    // function: Function(address=134235644, size=160, name='close_over_variables_etc', path='build/py/compile.o', has_indirect=False)
    public void close_over_variables_etc() throws Exception
    {
        call(this::close_over_variables_etc);
    }

    // function: Function(address=134235804, size=92, name='compile_funcdef_lambdef', path='build/py/compile.o', has_indirect=False)
    public void compile_funcdef_lambdef() throws Exception
    {
        call(this::compile_funcdef_lambdef);
    }

    // function: Function(address=134235896, size=40, name='compile_lambdef', path='build/py/compile.o', has_indirect=False)
    public void compile_lambdef() throws Exception
    {
        call(this::compile_lambdef);
    }

    // function: Function(address=134235936, size=42, name='compile_funcdef_helper', path='build/py/compile.o', has_indirect=False)
    public void compile_funcdef_helper() throws Exception
    {
        call(this::compile_funcdef_helper);
    }

    // function: Function(address=134235978, size=20, name='compile_error_set_line_isra_0', path='build/py/compile.o', has_indirect=False)
    public void compile_error_set_line_isra_0() throws Exception
    {
        call(this::compile_error_set_line_isra_0);
    }

    // function: Function(address=134236000, size=40, name='compile_syntax_error', path='build/py/compile.o', has_indirect=False)
    public void compile_syntax_error() throws Exception
    {
        call(this::compile_syntax_error);
    }

    // function: Function(address=134236040, size=16, name='compile_star_expr', path='build/py/compile.o', has_indirect=False)
    public void compile_star_expr() throws Exception
    {
        call(this::compile_star_expr);
    }

    // function: Function(address=134236056, size=64, name='compile_break_cont_stmt', path='build/py/compile.o', has_indirect=False)
    public void compile_break_cont_stmt() throws Exception
    {
        call(this::compile_break_cont_stmt);
    }

    // function: Function(address=134236120, size=168, name='compile_scope_func_lambda_param_isra_5', path='build/py/compile.o', has_indirect=False)
    public void compile_scope_func_lambda_param_isra_5() throws Exception
    {
        call(this::compile_scope_func_lambda_param_isra_5);
    }

    // function: Function(address=134236288, size=12, name='compile_scope_lambda_param', path='build/py/compile.o', has_indirect=True)
    public void compile_scope_lambda_param() throws Exception
    {
        call(this::compile_scope_lambda_param);
    }

    // function: Function(address=134236300, size=12, name='compile_scope_func_param', path='build/py/compile.o', has_indirect=True)
    public void compile_scope_func_param() throws Exception
    {
        call(this::compile_scope_func_param);
    }

    // function: Function(address=134236312, size=30, name='compile_yield_from_isra_6', path='build/py/compile.o', has_indirect=False)
    public void compile_yield_from_isra_6() throws Exception
    {
        call(this::compile_yield_from_isra_6);
    }

    // function: Function(address=134236342, size=34, name='compile_await_object_method', path='build/py/compile.o', has_indirect=False)
    public void compile_await_object_method() throws Exception
    {
        call(this::compile_await_object_method);
    }

    // function: Function(address=134236376, size=36, name='compile_load_id', path='build/py/compile.o', has_indirect=False)
    public void compile_load_id() throws Exception
    {
        call(this::compile_load_id);
    }

    // function: Function(address=134236412, size=36, name='compile_store_id', path='build/py/compile.o', has_indirect=False)
    public void compile_store_id() throws Exception
    {
        call(this::compile_store_id);
    }

    // function: Function(address=134236448, size=22, name='compile_funcdef', path='build/py/compile.o', has_indirect=False)
    public void compile_funcdef() throws Exception
    {
        call(this::compile_funcdef);
    }

    // function: Function(address=134236472, size=36, name='compile_delete_id', path='build/py/compile.o', has_indirect=False)
    public void compile_delete_id() throws Exception
    {
        call(this::compile_delete_id);
    }

    // function: Function(address=134236508, size=200, name='compile_node', path='build/py/compile.o', has_indirect=False)
    public void compile_node() throws Exception
    {
        call(this::compile_node);
    }

    // function: Function(address=134236708, size=388, name='c_assign', path='build/py/compile.o', has_indirect=False)
    public void c_assign() throws Exception
    {
        call(this::c_assign);
    }

    // function: Function(address=134237096, size=212, name='c_assign_tuple', path='build/py/compile.o', has_indirect=False)
    public void c_assign_tuple() throws Exception
    {
        call(this::c_assign_tuple);
    }

    // function: Function(address=134237308, size=228, name='c_if_cond', path='build/py/compile.o', has_indirect=False)
    public void c_if_cond() throws Exception
    {
        call(this::c_if_cond);
    }

    // function: Function(address=134237536, size=178, name='compile_scope_comp_iter', path='build/py/compile.o', has_indirect=False)
    public void compile_scope_comp_iter() throws Exception
    {
        call(this::compile_scope_comp_iter);
    }

    // function: Function(address=134237716, size=168, name='check_for_doc_string', path='build/py/compile.o', has_indirect=False)
    public void check_for_doc_string() throws Exception
    {
        call(this::check_for_doc_string);
    }

    // function: Function(address=134237884, size=448, name='compile_scope', path='build/py/compile.o', has_indirect=False)
    public void compile_scope() throws Exception
    {
        call(this::compile_scope);
    }

    // function: Function(address=134238332, size=22, name='compile_dictorsetmaker_item', path='build/py/compile.o', has_indirect=False)
    public void compile_dictorsetmaker_item() throws Exception
    {
        call(this::compile_dictorsetmaker_item);
    }

    // function: Function(address=134238354, size=132, name='compile_subscript', path='build/py/compile.o', has_indirect=False)
    public void compile_subscript() throws Exception
    {
        call(this::compile_subscript);
    }

    // function: Function(address=134238486, size=20, name='compile_trailer_bracket', path='build/py/compile.o', has_indirect=False)
    public void compile_trailer_bracket() throws Exception
    {
        call(this::compile_trailer_bracket);
    }

    // function: Function(address=134238506, size=66, name='text_c_tuple', path='build/py/compile.o', has_indirect=False)
    public void text_c_tuple() throws Exception
    {
        call(this::text_c_tuple);
    }

    // function: Function(address=134238572, size=12, name='compile_generic_tuple', path='build/py/compile.o', has_indirect=False)
    public void compile_generic_tuple() throws Exception
    {
        call(this::compile_generic_tuple);
    }

    // function: Function(address=134238584, size=140, name='compile_while_stmt', path='build/py/compile.o', has_indirect=False)
    public void compile_while_stmt() throws Exception
    {
        call(this::compile_while_stmt);
    }

    // function: Function(address=134238724, size=18, name='compile_yield_stmt', path='build/py/compile.o', has_indirect=False)
    public void compile_yield_stmt() throws Exception
    {
        call(this::compile_yield_stmt);
    }

    // function: Function(address=134238744, size=260, name='c_del_stmt', path='build/py/compile.o', has_indirect=True)
    public void c_del_stmt() throws Exception
    {
        call(this::c_del_stmt);
    }

    // function: Function(address=134239004, size=54, name='compile_generic_all_nodes', path='build/py/compile.o', has_indirect=False)
    public void compile_generic_all_nodes() throws Exception
    {
        call(this::compile_generic_all_nodes);
    }

    // function: Function(address=134239058, size=18, name='compile_power', path='build/py/compile.o', has_indirect=False)
    public void compile_power() throws Exception
    {
        call(this::compile_power);
    }

    // function: Function(address=134239076, size=228, name='compile_if_stmt', path='build/py/compile.o', has_indirect=False)
    public void compile_if_stmt() throws Exception
    {
        call(this::compile_if_stmt);
    }

    // function: Function(address=134239304, size=74, name='compile_comprehension', path='build/py/compile.o', has_indirect=False)
    public void compile_comprehension() throws Exception
    {
        call(this::compile_comprehension);
    }

    // function: Function(address=134239378, size=136, name='compile_atom_bracket', path='build/py/compile.o', has_indirect=False)
    public void compile_atom_bracket() throws Exception
    {
        call(this::compile_atom_bracket);
    }

    // function: Function(address=134239516, size=344, name='compile_trailer_paren_helper', path='build/py/compile.o', has_indirect=False)
    public void compile_trailer_paren_helper() throws Exception
    {
        call(this::compile_trailer_paren_helper);
    }

    // function: Function(address=134239860, size=86, name='compile_classdef_helper', path='build/py/compile.o', has_indirect=False)
    public void compile_classdef_helper() throws Exception
    {
        call(this::compile_classdef_helper);
    }

    // function: Function(address=134239946, size=22, name='compile_classdef', path='build/py/compile.o', has_indirect=False)
    public void compile_classdef() throws Exception
    {
        call(this::compile_classdef);
    }

    // function: Function(address=134239968, size=14, name='compile_trailer_paren', path='build/py/compile.o', has_indirect=False)
    public void compile_trailer_paren() throws Exception
    {
        call(this::compile_trailer_paren);
    }

    // function: Function(address=134239984, size=264, name='compile_decorated', path='build/py/compile.o', has_indirect=False)
    public void compile_decorated() throws Exception
    {
        call(this::compile_decorated);
    }

    // function: Function(address=134240248, size=304, name='compile_atom_brace', path='build/py/compile.o', has_indirect=False)
    public void compile_atom_brace() throws Exception
    {
        call(this::compile_atom_brace);
    }

    // function: Function(address=134240552, size=164, name='compile_funcdef_lambdef_param', path='build/py/compile.o', has_indirect=True)
    public void compile_funcdef_lambdef_param() throws Exception
    {
        call(this::compile_funcdef_lambdef_param);
    }

    // function: Function(address=134240716, size=300, name='compile_atom_expr_normal', path='build/py/compile.o', has_indirect=False)
    public void compile_atom_expr_normal() throws Exception
    {
        call(this::compile_atom_expr_normal);
    }

    // function: Function(address=134241016, size=76, name='compile_term', path='build/py/compile.o', has_indirect=False)
    public void compile_term() throws Exception
    {
        call(this::compile_term);
    }

    // function: Function(address=134241092, size=58, name='compile_binary_op', path='build/py/compile.o', has_indirect=False)
    public void compile_binary_op() throws Exception
    {
        call(this::compile_binary_op);
    }

    // function: Function(address=134241152, size=440, name='compile_expr_stmt', path='build/py/compile.o', has_indirect=False)
    public void compile_expr_stmt() throws Exception
    {
        call(this::compile_expr_stmt);
    }

    // function: Function(address=134241592, size=42, name='compile_factor_2', path='build/py/compile.o', has_indirect=False)
    public void compile_factor_2() throws Exception
    {
        call(this::compile_factor_2);
    }

    // function: Function(address=134241634, size=20, name='compile_not_test_2', path='build/py/compile.o', has_indirect=False)
    public void compile_not_test_2() throws Exception
    {
        call(this::compile_not_test_2);
    }

    // function: Function(address=134241654, size=80, name='compile_or_and_test', path='build/py/compile.o', has_indirect=False)
    public void compile_or_and_test() throws Exception
    {
        call(this::compile_or_and_test);
    }

    // function: Function(address=134241736, size=200, name='compile_comparison', path='build/py/compile.o', has_indirect=False)
    public void compile_comparison() throws Exception
    {
        call(this::compile_comparison);
    }

    // function: Function(address=134241936, size=80, name='compile_test_if_expr', path='build/py/compile.o', has_indirect=False)
    public void compile_test_if_expr() throws Exception
    {
        call(this::compile_test_if_expr);
    }

    // function: Function(address=134242016, size=672, name='compile_for_stmt', path='build/py/compile.o', has_indirect=False)
    public void compile_for_stmt() throws Exception
    {
        call(this::compile_for_stmt);
    }

    // function: Function(address=134242688, size=150, name='compile_with_stmt_helper', path='build/py/compile.o', has_indirect=False)
    public void compile_with_stmt_helper() throws Exception
    {
        call(this::compile_with_stmt_helper);
    }

    // function: Function(address=134242838, size=32, name='compile_with_stmt', path='build/py/compile.o', has_indirect=False)
    public void compile_with_stmt() throws Exception
    {
        call(this::compile_with_stmt);
    }

    // function: Function(address=134242872, size=412, name='compile_try_except', path='build/py/compile.o', has_indirect=False)
    public void compile_try_except() throws Exception
    {
        call(this::compile_try_except);
    }

    // function: Function(address=134243284, size=128, name='compile_try_finally', path='build/py/compile.o', has_indirect=False)
    public void compile_try_finally() throws Exception
    {
        call(this::compile_try_finally);
    }

    // function: Function(address=134243412, size=106, name='compile_try_stmt', path='build/py/compile.o', has_indirect=False)
    public void compile_try_stmt() throws Exception
    {
        call(this::compile_try_stmt);
    }

    // function: Function(address=134243518, size=498, name='compile_async_with_stmt_helper', path='build/py/compile.o', has_indirect=False)
    public void compile_async_with_stmt_helper() throws Exception
    {
        call(this::compile_async_with_stmt_helper);
    }

    // function: Function(address=134244016, size=358, name='compile_async_stmt', path='build/py/compile.o', has_indirect=False)
    public void compile_async_stmt() throws Exception
    {
        call(this::compile_async_stmt);
    }

    // function: Function(address=134244376, size=92, name='compile_yield_expr', path='build/py/compile.o', has_indirect=False)
    public void compile_yield_expr() throws Exception
    {
        call(this::compile_yield_expr);
    }

    // function: Function(address=134244468, size=112, name='compile_return_stmt', path='build/py/compile.o', has_indirect=False)
    public void compile_return_stmt() throws Exception
    {
        call(this::compile_return_stmt);
    }

    // function: Function(address=134244580, size=62, name='compile_atom_paren', path='build/py/compile.o', has_indirect=False)
    public void compile_atom_paren() throws Exception
    {
        call(this::compile_atom_paren);
    }

    // function: Function(address=134244644, size=44, name='compile_atom_expr_await', path='build/py/compile.o', has_indirect=False)
    public void compile_atom_expr_await() throws Exception
    {
        call(this::compile_atom_expr_await);
    }

    // function: Function(address=134244688, size=92, name='compile_assert_stmt', path='build/py/compile.o', has_indirect=False)
    public void compile_assert_stmt() throws Exception
    {
        call(this::compile_assert_stmt);
    }

    // function: Function(address=134244780, size=58, name='compile_raise_stmt', path='build/py/compile.o', has_indirect=False)
    public void compile_raise_stmt() throws Exception
    {
        call(this::compile_raise_stmt);
    }

    // function: Function(address=134244840, size=192, name='compile_global_nonlocal_stmt', path='build/py/compile.o', has_indirect=False)
    public void compile_global_nonlocal_stmt() throws Exception
    {
        call(this::compile_global_nonlocal_stmt);
    }

    // function: Function(address=134245032, size=256, name='do_import_name_isra_19', path='build/py/compile.o', has_indirect=False)
    public void do_import_name_isra_19() throws Exception
    {
        call(this::do_import_name_isra_19);
    }

    // function: Function(address=134245288, size=284, name='compile_import_from', path='build/py/compile.o', has_indirect=False)
    public void compile_import_from() throws Exception
    {
        call(this::compile_import_from);
    }

    // function: Function(address=134245572, size=44, name='compile_dotted_as_name', path='build/py/compile.o', has_indirect=True)
    public void compile_dotted_as_name() throws Exception
    {
        call(this::compile_dotted_as_name);
    }

    // function: Function(address=134245616, size=602, name='mp_compile', path='build/py/compile.o', has_indirect=False)
    public void mp_compile() throws Exception
    {
        call(this::mp_compile);
    }

    // function: Function(address=134246218, size=34, name='mp_emit_common_get_id_for_load', path='build/py/emitcommon.o', has_indirect=False)
    public void mp_emit_common_get_id_for_load() throws Exception
    {
        call(this::mp_emit_common_get_id_for_load);
    }

    // function: Function(address=134246252, size=50, name='mp_emit_common_get_id_for_modification', path='build/py/emitcommon.o', has_indirect=False)
    public void mp_emit_common_get_id_for_modification() throws Exception
    {
        call(this::mp_emit_common_get_id_for_modification);
    }

    // function: Function(address=134246302, size=60, name='mp_emit_common_id_op', path='build/py/emitcommon.o', has_indirect=False)
    public void mp_emit_common_id_op() throws Exception
    {
        call(this::mp_emit_common_id_op);
    }

    // function: Function(address=134246362, size=62, name='emit_write_uint', path='build/py/emitbc.o', has_indirect=False)
    public void emit_write_uint() throws Exception
    {
        call(this::emit_write_uint);
    }

    // function: Function(address=134246424, size=26, name='emit_get_cur_to_write_code_info', path='build/py/emitbc.o', has_indirect=True)
    public void emit_get_cur_to_write_code_info() throws Exception
    {
        call(this::emit_get_cur_to_write_code_info);
    }

    // function: Function(address=134246450, size=14, name='emit_write_code_info_byte', path='build/py/emitbc.o', has_indirect=False)
    public void emit_write_code_info_byte() throws Exception
    {
        call(this::emit_write_code_info_byte);
    }

    // function: Function(address=134246464, size=30, name='emit_get_cur_to_write_bytecode', path='build/py/emitbc.o', has_indirect=True)
    public void emit_get_cur_to_write_bytecode() throws Exception
    {
        call(this::emit_get_cur_to_write_bytecode);
    }

    // function: Function(address=134246494, size=14, name='emit_write_bytecode_byte', path='build/py/emitbc.o', has_indirect=False)
    public void emit_write_bytecode_byte() throws Exception
    {
        call(this::emit_write_bytecode_byte);
    }

    // function: Function(address=134246508, size=28, name='emit_write_bytecode_byte_uint', path='build/py/emitbc.o', has_indirect=False)
    public void emit_write_bytecode_byte_uint() throws Exception
    {
        call(this::emit_write_bytecode_byte_uint);
    }

    // function: Function(address=134246536, size=42, name='emit_write_bytecode_byte_raw_code', path='build/py/emitbc.o', has_indirect=False)
    public void emit_write_bytecode_byte_raw_code() throws Exception
    {
        call(this::emit_write_bytecode_byte_raw_code);
    }

    // function: Function(address=134246578, size=12, name='mp_emit_bc_delete_local', path='build/py/emitbc.o', has_indirect=False)
    public void mp_emit_bc_delete_local() throws Exception
    {
        call(this::mp_emit_bc_delete_local);
    }

    // function: Function(address=134246590, size=22, name='emit_write_bytecode_byte_qstr', path='build/py/emitbc.o', has_indirect=False)
    public void emit_write_bytecode_byte_qstr() throws Exception
    {
        call(this::emit_write_bytecode_byte_qstr);
    }

    // function: Function(address=134246612, size=42, name='emit_write_bytecode_byte_unsigned_label', path='build/py/emitbc.o', has_indirect=False)
    public void emit_write_bytecode_byte_unsigned_label() throws Exception
    {
        call(this::emit_write_bytecode_byte_unsigned_label);
    }

    // function: Function(address=134246656, size=48, name='emit_write_bytecode_byte_signed_label', path='build/py/emitbc.o', has_indirect=False)
    public void emit_write_bytecode_byte_signed_label() throws Exception
    {
        call(this::emit_write_bytecode_byte_signed_label);
    }

    // function: Function(address=134246704, size=38, name='emit_write_bytecode_byte_obj_constprop_8', path='build/py/emitbc.o', has_indirect=False)
    public void emit_write_bytecode_byte_obj_constprop_8() throws Exception
    {
        call(this::emit_write_bytecode_byte_obj_constprop_8);
    }

    // function: Function(address=134246742, size=10, name='emit_bc_new', path='build/py/emitbc.o', has_indirect=False)
    public void emit_bc_new() throws Exception
    {
        call(this::emit_bc_new);
    }

    // function: Function(address=134246752, size=16, name='emit_bc_set_max_num_labels', path='build/py/emitbc.o', has_indirect=False)
    public void emit_bc_set_max_num_labels() throws Exception
    {
        call(this::emit_bc_set_max_num_labels);
    }

    // function: Function(address=134246768, size=24, name='emit_bc_free', path='build/py/emitbc.o', has_indirect=False)
    public void emit_bc_free() throws Exception
    {
        call(this::emit_bc_free);
    }

    // function: Function(address=134246792, size=288, name='mp_emit_bc_start_pass', path='build/py/emitbc.o', has_indirect=False)
    public void mp_emit_bc_start_pass() throws Exception
    {
        call(this::mp_emit_bc_start_pass);
    }

    // function: Function(address=134247080, size=88, name='mp_emit_bc_end_pass', path='build/py/emitbc.o', has_indirect=False)
    public void mp_emit_bc_end_pass() throws Exception
    {
        call(this::mp_emit_bc_end_pass);
    }

    // function: Function(address=134247168, size=10, name='mp_emit_bc_last_emit_was_return_value', path='build/py/emitbc.o', has_indirect=False)
    public void mp_emit_bc_last_emit_was_return_value() throws Exception
    {
        call(this::mp_emit_bc_last_emit_was_return_value);
    }

    // function: Function(address=134247178, size=28, name='mp_emit_bc_adjust_stack_size', path='build/py/emitbc.o', has_indirect=False)
    public void mp_emit_bc_adjust_stack_size() throws Exception
    {
        call(this::mp_emit_bc_adjust_stack_size);
    }

    // function: Function(address=134247206, size=50, name='mp_emit_bc_load_local', path='build/py/emitbc.o', has_indirect=False)
    public void mp_emit_bc_load_local() throws Exception
    {
        call(this::mp_emit_bc_load_local);
    }

    // function: Function(address=134247256, size=48, name='mp_emit_bc_load_global', path='build/py/emitbc.o', has_indirect=False)
    public void mp_emit_bc_load_global() throws Exception
    {
        call(this::mp_emit_bc_load_global);
    }

    // function: Function(address=134247304, size=52, name='mp_emit_bc_store_local', path='build/py/emitbc.o', has_indirect=False)
    public void mp_emit_bc_store_local() throws Exception
    {
        call(this::mp_emit_bc_store_local);
    }

    // function: Function(address=134247356, size=32, name='mp_emit_bc_store_global', path='build/py/emitbc.o', has_indirect=False)
    public void mp_emit_bc_store_global() throws Exception
    {
        call(this::mp_emit_bc_store_global);
    }

    // function: Function(address=134247388, size=28, name='mp_emit_bc_delete_global', path='build/py/emitbc.o', has_indirect=False)
    public void mp_emit_bc_delete_global() throws Exception
    {
        call(this::mp_emit_bc_delete_global);
    }

    // function: Function(address=134247416, size=60, name='emit_bc_call_function_method_helper', path='build/py/emitbc.o', has_indirect=False)
    public void emit_bc_call_function_method_helper() throws Exception
    {
        call(this::emit_bc_call_function_method_helper);
    }

    // function: Function(address=134247476, size=152, name='mp_emit_bc_set_source_line', path='build/py/emitbc.o', has_indirect=False)
    public void mp_emit_bc_set_source_line() throws Exception
    {
        call(this::mp_emit_bc_set_source_line);
    }

    // function: Function(address=134247628, size=32, name='mp_emit_bc_label_assign', path='build/py/emitbc.o', has_indirect=False)
    public void mp_emit_bc_label_assign() throws Exception
    {
        call(this::mp_emit_bc_label_assign);
    }

    // function: Function(address=134247660, size=56, name='mp_emit_bc_import', path='build/py/emitbc.o', has_indirect=False)
    public void mp_emit_bc_import() throws Exception
    {
        call(this::mp_emit_bc_import);
    }

    // function: Function(address=134247716, size=56, name='mp_emit_bc_load_const_tok', path='build/py/emitbc.o', has_indirect=False)
    public void mp_emit_bc_load_const_tok() throws Exception
    {
        call(this::mp_emit_bc_load_const_tok);
    }

    // function: Function(address=134247772, size=144, name='mp_emit_bc_load_const_small_int', path='build/py/emitbc.o', has_indirect=False)
    public void mp_emit_bc_load_const_small_int() throws Exception
    {
        call(this::mp_emit_bc_load_const_small_int);
    }

    // function: Function(address=134247916, size=24, name='mp_emit_bc_load_const_str', path='build/py/emitbc.o', has_indirect=False)
    public void mp_emit_bc_load_const_str() throws Exception
    {
        call(this::mp_emit_bc_load_const_str);
    }

    // function: Function(address=134247940, size=22, name='mp_emit_bc_load_const_obj', path='build/py/emitbc.o', has_indirect=False)
    public void mp_emit_bc_load_const_obj() throws Exception
    {
        call(this::mp_emit_bc_load_const_obj);
    }

    // function: Function(address=134247962, size=20, name='mp_emit_bc_load_null', path='build/py/emitbc.o', has_indirect=False)
    public void mp_emit_bc_load_null() throws Exception
    {
        call(this::mp_emit_bc_load_null);
    }

    // function: Function(address=134247982, size=36, name='mp_emit_bc_load_method', path='build/py/emitbc.o', has_indirect=False)
    public void mp_emit_bc_load_method() throws Exception
    {
        call(this::mp_emit_bc_load_method);
    }

    // function: Function(address=134248018, size=20, name='mp_emit_bc_load_build_class', path='build/py/emitbc.o', has_indirect=False)
    public void mp_emit_bc_load_build_class() throws Exception
    {
        call(this::mp_emit_bc_load_build_class);
    }

    // function: Function(address=134248038, size=20, name='mp_emit_bc_dup_top', path='build/py/emitbc.o', has_indirect=False)
    public void mp_emit_bc_dup_top() throws Exception
    {
        call(this::mp_emit_bc_dup_top);
    }

    // function: Function(address=134248058, size=20, name='mp_emit_bc_dup_top_two', path='build/py/emitbc.o', has_indirect=False)
    public void mp_emit_bc_dup_top_two() throws Exception
    {
        call(this::mp_emit_bc_dup_top_two);
    }

    // function: Function(address=134248078, size=22, name='mp_emit_bc_pop_top', path='build/py/emitbc.o', has_indirect=False)
    public void mp_emit_bc_pop_top() throws Exception
    {
        call(this::mp_emit_bc_pop_top);
    }

    // function: Function(address=134248100, size=20, name='mp_emit_bc_rot_two', path='build/py/emitbc.o', has_indirect=False)
    public void mp_emit_bc_rot_two() throws Exception
    {
        call(this::mp_emit_bc_rot_two);
    }

    // function: Function(address=134248120, size=80, name='mp_emit_bc_attr', path='build/py/emitbc.o', has_indirect=False)
    public void mp_emit_bc_attr() throws Exception
    {
        call(this::mp_emit_bc_attr);
    }

    // function: Function(address=134248200, size=20, name='mp_emit_bc_rot_three', path='build/py/emitbc.o', has_indirect=False)
    public void mp_emit_bc_rot_three() throws Exception
    {
        call(this::mp_emit_bc_rot_three);
    }

    // function: Function(address=134248220, size=52, name='mp_emit_bc_subscr', path='build/py/emitbc.o', has_indirect=False)
    public void mp_emit_bc_subscr() throws Exception
    {
        call(this::mp_emit_bc_subscr);
    }

    // function: Function(address=134248272, size=24, name='mp_emit_bc_jump', path='build/py/emitbc.o', has_indirect=False)
    public void mp_emit_bc_jump() throws Exception
    {
        call(this::mp_emit_bc_jump);
    }

    // function: Function(address=134248296, size=34, name='mp_emit_bc_pop_jump_if', path='build/py/emitbc.o', has_indirect=False)
    public void mp_emit_bc_pop_jump_if() throws Exception
    {
        call(this::mp_emit_bc_pop_jump_if);
    }

    // function: Function(address=134248330, size=34, name='mp_emit_bc_jump_if_or_pop', path='build/py/emitbc.o', has_indirect=False)
    public void mp_emit_bc_jump_if_or_pop() throws Exception
    {
        call(this::mp_emit_bc_jump_if_or_pop);
    }

    // function: Function(address=134248364, size=100, name='mp_emit_bc_unwind_jump', path='build/py/emitbc.o', has_indirect=False)
    public void mp_emit_bc_unwind_jump() throws Exception
    {
        call(this::mp_emit_bc_unwind_jump);
    }

    // function: Function(address=134248464, size=36, name='mp_emit_bc_setup_block', path='build/py/emitbc.o', has_indirect=False)
    public void mp_emit_bc_setup_block() throws Exception
    {
        call(this::mp_emit_bc_setup_block);
    }

    // function: Function(address=134248500, size=22, name='mp_emit_bc_end_finally', path='build/py/emitbc.o', has_indirect=False)
    public void mp_emit_bc_end_finally() throws Exception
    {
        call(this::mp_emit_bc_end_finally);
    }

    // function: Function(address=134248522, size=38, name='mp_emit_bc_get_iter', path='build/py/emitbc.o', has_indirect=False)
    public void mp_emit_bc_get_iter() throws Exception
    {
        call(this::mp_emit_bc_get_iter);
    }

    // function: Function(address=134248560, size=24, name='mp_emit_bc_for_iter', path='build/py/emitbc.o', has_indirect=False)
    public void mp_emit_bc_for_iter() throws Exception
    {
        call(this::mp_emit_bc_for_iter);
    }

    // function: Function(address=134248584, size=12, name='mp_emit_bc_for_iter_end', path='build/py/emitbc.o', has_indirect=False)
    public void mp_emit_bc_for_iter_end() throws Exception
    {
        call(this::mp_emit_bc_for_iter_end);
    }

    // function: Function(address=134248596, size=20, name='mp_emit_bc_pop_block', path='build/py/emitbc.o', has_indirect=False)
    public void mp_emit_bc_pop_block() throws Exception
    {
        call(this::mp_emit_bc_pop_block);
    }

    // function: Function(address=134248616, size=54, name='mp_emit_bc_with_cleanup', path='build/py/emitbc.o', has_indirect=False)
    public void mp_emit_bc_with_cleanup() throws Exception
    {
        call(this::mp_emit_bc_with_cleanup);
    }

    // function: Function(address=134248670, size=20, name='mp_emit_bc_pop_except', path='build/py/emitbc.o', has_indirect=False)
    public void mp_emit_bc_pop_except() throws Exception
    {
        call(this::mp_emit_bc_pop_except);
    }

    // function: Function(address=134248690, size=26, name='mp_emit_bc_unary_op', path='build/py/emitbc.o', has_indirect=False)
    public void mp_emit_bc_unary_op() throws Exception
    {
        call(this::mp_emit_bc_unary_op);
    }

    // function: Function(address=134248716, size=68, name='mp_emit_bc_binary_op', path='build/py/emitbc.o', has_indirect=False)
    public void mp_emit_bc_binary_op() throws Exception
    {
        call(this::mp_emit_bc_binary_op);
    }

    // function: Function(address=134248784, size=40, name='mp_emit_bc_build', path='build/py/emitbc.o', has_indirect=False)
    public void mp_emit_bc_build() throws Exception
    {
        call(this::mp_emit_bc_build);
    }

    // function: Function(address=134248824, size=22, name='mp_emit_bc_store_map', path='build/py/emitbc.o', has_indirect=False)
    public void mp_emit_bc_store_map() throws Exception
    {
        call(this::mp_emit_bc_store_map);
    }

    // function: Function(address=134248846, size=52, name='mp_emit_bc_store_comp', path='build/py/emitbc.o', has_indirect=False)
    public void mp_emit_bc_store_comp() throws Exception
    {
        call(this::mp_emit_bc_store_comp);
    }

    // function: Function(address=134248898, size=24, name='mp_emit_bc_unpack_sequence', path='build/py/emitbc.o', has_indirect=False)
    public void mp_emit_bc_unpack_sequence() throws Exception
    {
        call(this::mp_emit_bc_unpack_sequence);
    }

    // function: Function(address=134248922, size=28, name='mp_emit_bc_unpack_ex', path='build/py/emitbc.o', has_indirect=False)
    public void mp_emit_bc_unpack_ex() throws Exception
    {
        call(this::mp_emit_bc_unpack_ex);
    }

    // function: Function(address=134248950, size=42, name='mp_emit_bc_make_function', path='build/py/emitbc.o', has_indirect=False)
    public void mp_emit_bc_make_function() throws Exception
    {
        call(this::mp_emit_bc_make_function);
    }

    // function: Function(address=134248992, size=54, name='mp_emit_bc_make_closure', path='build/py/emitbc.o', has_indirect=False)
    public void mp_emit_bc_make_closure() throws Exception
    {
        call(this::mp_emit_bc_make_closure);
    }

    // function: Function(address=134249046, size=18, name='mp_emit_bc_call_function', path='build/py/emitbc.o', has_indirect=False)
    public void mp_emit_bc_call_function() throws Exception
    {
        call(this::mp_emit_bc_call_function);
    }

    // function: Function(address=134249064, size=20, name='mp_emit_bc_call_method', path='build/py/emitbc.o', has_indirect=False)
    public void mp_emit_bc_call_method() throws Exception
    {
        call(this::mp_emit_bc_call_method);
    }

    // function: Function(address=134249084, size=26, name='mp_emit_bc_return_value', path='build/py/emitbc.o', has_indirect=False)
    public void mp_emit_bc_return_value() throws Exception
    {
        call(this::mp_emit_bc_return_value);
    }

    // function: Function(address=134249110, size=28, name='mp_emit_bc_raise_varargs', path='build/py/emitbc.o', has_indirect=False)
    public void mp_emit_bc_raise_varargs() throws Exception
    {
        call(this::mp_emit_bc_raise_varargs);
    }

    // function: Function(address=134249138, size=34, name='mp_emit_bc_yield', path='build/py/emitbc.o', has_indirect=False)
    public void mp_emit_bc_yield() throws Exception
    {
        call(this::mp_emit_bc_yield);
    }

    // function: Function(address=134249172, size=10, name='mp_emit_bc_start_except_handler', path='build/py/emitbc.o', has_indirect=False)
    public void mp_emit_bc_start_except_handler() throws Exception
    {
        call(this::mp_emit_bc_start_except_handler);
    }

    // function: Function(address=134249182, size=12, name='mp_emit_bc_end_except_handler', path='build/py/emitbc.o', has_indirect=False)
    public void mp_emit_bc_end_except_handler() throws Exception
    {
        call(this::mp_emit_bc_end_except_handler);
    }

    // function: Function(address=134249196, size=1208, name='mp_format_float', path='build/py/formatfloat.o', has_indirect=False)
    public void mp_format_float() throws Exception
    {
        call(this::mp_format_float);
    }

    // function: Function(address=134250404, size=122, name='mp_parse_num_base', path='build/py/parsenumbase.o', has_indirect=False)
    public void mp_parse_num_base() throws Exception
    {
        call(this::mp_parse_num_base);
    }

    // function: Function(address=134250528, size=32, name='unlikely_raise_exc', path='build/py/parsenum.o', has_indirect=False)
    public void unlikely_raise_exc() throws Exception
    {
        call(this::unlikely_raise_exc);
    }

    // function: Function(address=134250560, size=296, name='mp_parse_num_integer', path='build/py/parsenum.o', has_indirect=False)
    public void mp_parse_num_integer() throws Exception
    {
        call(this::mp_parse_num_integer);
    }

    // function: Function(address=134250856, size=632, name='mp_parse_num_decimal', path='build/py/parsenum.o', has_indirect=False)
    public void mp_parse_num_decimal() throws Exception
    {
        call(this::mp_parse_num_decimal);
    }

    // function: Function(address=134251488, size=24, name='mp_emit_glue_new_raw_code', path='build/py/emitglue.o', has_indirect=False)
    public void mp_emit_glue_new_raw_code() throws Exception
    {
        call(this::mp_emit_glue_new_raw_code);
    }

    // function: Function(address=134251512, size=44, name='mp_emit_glue_assign_bytecode', path='build/py/emitglue.o', has_indirect=False)
    public void mp_emit_glue_assign_bytecode() throws Exception
    {
        call(this::mp_emit_glue_assign_bytecode);
    }

    // function: Function(address=134251556, size=32, name='mp_make_function_from_raw_code', path='build/py/emitglue.o', has_indirect=False)
    public void mp_make_function_from_raw_code() throws Exception
    {
        call(this::mp_make_function_from_raw_code);
    }

    // function: Function(address=134251588, size=42, name='mp_make_closure_from_raw_code', path='build/py/emitglue.o', has_indirect=False)
    public void mp_make_closure_from_raw_code() throws Exception
    {
        call(this::mp_make_closure_from_raw_code);
    }

    // function: Function(address=134251630, size=26, name='read_bytes', path='build/py/persistentcode.o', has_indirect=False)
    public void read_bytes() throws Exception
    {
        call(this::read_bytes);
    }

    // function: Function(address=134251656, size=30, name='read_uint', path='build/py/persistentcode.o', has_indirect=False)
    public void read_uint() throws Exception
    {
        call(this::read_uint);
    }

    // function: Function(address=134251686, size=48, name='load_qstr', path='build/py/persistentcode.o', has_indirect=False)
    public void load_qstr() throws Exception
    {
        call(this::load_qstr);
    }

    // function: Function(address=134251736, size=416, name='load_raw_code', path='build/py/persistentcode.o', has_indirect=False)
    public void load_raw_code() throws Exception
    {
        call(this::load_raw_code);
    }

    // function: Function(address=134252152, size=68, name='mp_raw_code_load', path='build/py/persistentcode.o', has_indirect=False)
    public void mp_raw_code_load() throws Exception
    {
        call(this::mp_raw_code_load);
    }

    // function: Function(address=134252220, size=20, name='mp_raw_code_load_file', path='build/py/persistentcode.o', has_indirect=False)
    public void mp_raw_code_load_file() throws Exception
    {
        call(this::mp_raw_code_load_file);
    }

    // function: Function(address=134252240, size=120, name='mp_init', path='build/py/runtime.o', has_indirect=False)
    public void mp_init() throws Exception
    {
        call(this::mp_init);
    }

    // function: Function(address=134252360, size=2, name='mp_deinit', path='build/py/runtime.o', has_indirect=False)
    public void mp_deinit() throws Exception
    {
        call(this::mp_deinit);
    }

    // function: Function(address=134252364, size=104, name='mp_load_global', path='build/py/runtime.o', has_indirect=False)
    public void mp_load_global() throws Exception
    {
        call(this::mp_load_global);
    }

    // function: Function(address=134252468, size=48, name='mp_load_name', path='build/py/runtime.o', has_indirect=False)
    public void mp_load_name() throws Exception
    {
        call(this::mp_load_name);
    }

    // function: Function(address=134252516, size=44, name='mp_load_build_class', path='build/py/runtime.o', has_indirect=False)
    public void mp_load_build_class() throws Exception
    {
        call(this::mp_load_build_class);
    }

    // function: Function(address=134252560, size=24, name='mp_store_name', path='build/py/runtime.o', has_indirect=False)
    public void mp_store_name() throws Exception
    {
        call(this::mp_store_name);
    }

    // function: Function(address=134252584, size=24, name='mp_delete_name', path='build/py/runtime.o', has_indirect=False)
    public void mp_delete_name() throws Exception
    {
        call(this::mp_delete_name);
    }

    // function: Function(address=134252608, size=24, name='mp_store_global', path='build/py/runtime.o', has_indirect=False)
    public void mp_store_global() throws Exception
    {
        call(this::mp_store_global);
    }

    // function: Function(address=134252632, size=24, name='mp_delete_global', path='build/py/runtime.o', has_indirect=False)
    public void mp_delete_global() throws Exception
    {
        call(this::mp_delete_global);
    }

    // function: Function(address=134252656, size=264, name='mp_unary_op', path='build/py/runtime.o', has_indirect=False)
    public void mp_unary_op() throws Exception
    {
        call(this::mp_unary_op);
    }

    // function: Function(address=134252920, size=60, name='mp_call_function_n_kw', path='build/py/runtime.o', has_indirect=False)
    public void mp_call_function_n_kw() throws Exception
    {
        call(this::mp_call_function_n_kw);
    }

    // function: Function(address=134252980, size=14, name='mp_call_function_0', path='build/py/runtime.o', has_indirect=False)
    public void mp_call_function_0() throws Exception
    {
        call(this::mp_call_function_0);
    }

    // function: Function(address=134252994, size=16, name='mp_call_function_1', path='build/py/runtime.o', has_indirect=False)
    public void mp_call_function_1() throws Exception
    {
        call(this::mp_call_function_1);
    }

    // function: Function(address=134253012, size=64, name='checked_fun_call', path='build/py/runtime.o', has_indirect=False)
    public void checked_fun_call() throws Exception
    {
        call(this::checked_fun_call);
    }

    // function: Function(address=134253076, size=30, name='mp_call_method_n_kw', path='build/py/runtime.o', has_indirect=False)
    public void mp_call_method_n_kw() throws Exception
    {
        call(this::mp_call_method_n_kw);
    }

    // function: Function(address=134253108, size=172, name='mp_convert_member_lookup', path='build/py/runtime.o', has_indirect=False)
    public void mp_convert_member_lookup() throws Exception
    {
        call(this::mp_convert_member_lookup);
    }

    // function: Function(address=134253280, size=104, name='mp_load_method_maybe', path='build/py/runtime.o', has_indirect=True)
    public void mp_load_method_maybe() throws Exception
    {
        call(this::mp_load_method_maybe);
    }

    // function: Function(address=134253384, size=80, name='mp_load_method', path='build/py/runtime.o', has_indirect=True)
    public void mp_load_method() throws Exception
    {
        call(this::mp_load_method);
    }

    // function: Function(address=134253464, size=24, name='mp_load_attr', path='build/py/runtime.o', has_indirect=False)
    public void mp_load_attr() throws Exception
    {
        call(this::mp_load_attr);
    }

    // function: Function(address=134253488, size=68, name='mp_load_method_protected', path='build/py/runtime.o', has_indirect=False)
    public void mp_load_method_protected() throws Exception
    {
        call(this::mp_load_method_protected);
    }

    // function: Function(address=134253556, size=72, name='mp_store_attr', path='build/py/runtime.o', has_indirect=False)
    public void mp_store_attr() throws Exception
    {
        call(this::mp_store_attr);
    }

    // function: Function(address=134253628, size=112, name='mp_getiter', path='build/py/runtime.o', has_indirect=False)
    public void mp_getiter() throws Exception
    {
        call(this::mp_getiter);
    }

    // function: Function(address=134253740, size=76, name='mp_iternext_allow_raise', path='build/py/runtime.o', has_indirect=False)
    public void mp_iternext_allow_raise() throws Exception
    {
        call(this::mp_iternext_allow_raise);
    }

    // function: Function(address=134253816, size=128, name='mp_iternext', path='build/py/runtime.o', has_indirect=False)
    public void mp_iternext() throws Exception
    {
        call(this::mp_iternext);
    }

    // function: Function(address=134253944, size=628, name='mp_call_prepare_args_n_kw_var', path='build/py/runtime.o', has_indirect=False)
    public void mp_call_prepare_args_n_kw_var() throws Exception
    {
        call(this::mp_call_prepare_args_n_kw_var);
    }

    // function: Function(address=134254572, size=36, name='mp_call_method_n_kw_var', path='build/py/runtime.o', has_indirect=False)
    public void mp_call_method_n_kw_var() throws Exception
    {
        call(this::mp_call_method_n_kw_var);
    }

    // function: Function(address=134254608, size=168, name='mp_unpack_sequence', path='build/py/runtime.o', has_indirect=False)
    public void mp_unpack_sequence() throws Exception
    {
        call(this::mp_unpack_sequence);
    }

    // function: Function(address=134254776, size=264, name='mp_unpack_ex', path='build/py/runtime.o', has_indirect=False)
    public void mp_unpack_ex() throws Exception
    {
        call(this::mp_unpack_ex);
    }

    // function: Function(address=134255040, size=60, name='mp_make_raise_obj', path='build/py/runtime.o', has_indirect=False)
    public void mp_make_raise_obj() throws Exception
    {
        call(this::mp_make_raise_obj);
    }

    // function: Function(address=134255100, size=244, name='mp_resume', path='build/py/runtime.o', has_indirect=False)
    public void mp_resume() throws Exception
    {
        call(this::mp_resume);
    }

    // function: Function(address=134255344, size=36, name='mp_import_name', path='build/py/runtime.o', has_indirect=False)
    public void mp_import_name() throws Exception
    {
        call(this::mp_import_name);
    }

    // function: Function(address=134255380, size=204, name='mp_import_from', path='build/py/runtime.o', has_indirect=False)
    public void mp_import_from() throws Exception
    {
        call(this::mp_import_from);
    }

    // function: Function(address=134255584, size=58, name='mp_import_all', path='build/py/runtime.o', has_indirect=False)
    public void mp_import_all() throws Exception
    {
        call(this::mp_import_all);
    }

    // function: Function(address=134255644, size=108, name='mp_parse_compile_execute', path='build/py/runtime.o', has_indirect=False)
    public void mp_parse_compile_execute() throws Exception
    {
        call(this::mp_parse_compile_execute);
    }

    // function: Function(address=134255752, size=20, name='mp_raise_msg', path='build/py/runtime.o', has_indirect=False)
    public void mp_raise_msg() throws Exception
    {
        call(this::mp_raise_msg);
    }

    // function: Function(address=134255772, size=44, name='m_malloc_fail', path='build/py/runtime.o', has_indirect=False)
    public void m_malloc_fail() throws Exception
    {
        call(this::m_malloc_fail);
    }

    // function: Function(address=134255816, size=16, name='mp_raise_ValueError', path='build/py/runtime.o', has_indirect=False)
    public void mp_raise_ValueError() throws Exception
    {
        call(this::mp_raise_ValueError);
    }

    // function: Function(address=134255832, size=944, name='mp_binary_op', path='build/py/runtime.o', has_indirect=False)
    public void mp_binary_op() throws Exception
    {
        call(this::mp_binary_op);
    }

    // function: Function(address=134256776, size=16, name='mp_raise_TypeError', path='build/py/runtime.o', has_indirect=False)
    public void mp_raise_TypeError() throws Exception
    {
        call(this::mp_raise_TypeError);
    }

    // function: Function(address=134256792, size=24, name='mp_raise_OSError', path='build/py/runtime.o', has_indirect=False)
    public void mp_raise_OSError() throws Exception
    {
        call(this::mp_raise_OSError);
    }

    // function: Function(address=134256816, size=16, name='mp_raise_NotImplementedError', path='build/py/runtime.o', has_indirect=False)
    public void mp_raise_NotImplementedError() throws Exception
    {
        call(this::mp_raise_NotImplementedError);
    }

    // function: Function(address=134256832, size=20, name='mp_raise_recursion_depth', path='build/py/runtime.o', has_indirect=False)
    public void mp_raise_recursion_depth() throws Exception
    {
        call(this::mp_raise_recursion_depth);
    }

    // function: Function(address=134256852, size=56, name='mp_call_function_1_protected', path='build/py/runtime_utils.o', has_indirect=False)
    public void mp_call_function_1_protected() throws Exception
    {
        call(this::mp_call_function_1_protected);
    }

    // function: Function(address=134256908, size=36, name='mp_sched_lock', path='build/py/scheduler.o', has_indirect=False)
    public void mp_sched_lock() throws Exception
    {
        call(this::mp_sched_lock);
    }

    // function: Function(address=134256944, size=56, name='mp_sched_unlock', path='build/py/scheduler.o', has_indirect=False)
    public void mp_sched_unlock() throws Exception
    {
        call(this::mp_sched_unlock);
    }

    // function: Function(address=134257000, size=52, name='mp_handle_pending_tail', path='build/py/scheduler.o', has_indirect=False)
    public void mp_handle_pending_tail() throws Exception
    {
        call(this::mp_handle_pending_tail);
    }

    // function: Function(address=134257052, size=56, name='mp_handle_pending', path='build/py/scheduler.o', has_indirect=False)
    public void mp_handle_pending() throws Exception
    {
        call(this::mp_handle_pending);
    }

    // function: Function(address=134257108, size=60, name='mp_sched_schedule', path='build/py/scheduler.o', has_indirect=False)
    public void mp_sched_schedule() throws Exception
    {
        call(this::mp_sched_schedule);
    }

    // function: Function(address=134257168, size=12, name='mp_stack_set_top', path='build/py/stackctrl.o', has_indirect=False)
    public void mp_stack_set_top() throws Exception
    {
        call(this::mp_stack_set_top);
    }

    // function: Function(address=134257180, size=20, name='mp_stack_usage', path='build/py/stackctrl.o', has_indirect=False)
    public void mp_stack_usage() throws Exception
    {
        call(this::mp_stack_usage);
    }

    // function: Function(address=134257200, size=12, name='mp_stack_set_limit', path='build/py/stackctrl.o', has_indirect=False)
    public void mp_stack_set_limit() throws Exception
    {
        call(this::mp_stack_set_limit);
    }

    // function: Function(address=134257212, size=28, name='mp_stack_check', path='build/py/stackctrl.o', has_indirect=False)
    public void mp_stack_check() throws Exception
    {
        call(this::mp_stack_check);
    }

    // function: Function(address=134257240, size=96, name='mp_arg_check_num', path='build/py/argcheck.o', has_indirect=False)
    public void mp_arg_check_num() throws Exception
    {
        call(this::mp_arg_check_num);
    }

    // function: Function(address=134257336, size=200, name='mp_arg_parse_all', path='build/py/argcheck.o', has_indirect=False)
    public void mp_arg_parse_all() throws Exception
    {
        call(this::mp_arg_parse_all);
    }

    // function: Function(address=134257536, size=44, name='mp_arg_parse_all_kw_array', path='build/py/argcheck.o', has_indirect=False)
    public void mp_arg_parse_all_kw_array() throws Exception
    {
        call(this::mp_arg_parse_all_kw_array);
    }

    // function: Function(address=134257580, size=12, name='mp_arg_error_unimpl_kw', path='build/py/argcheck.o', has_indirect=False)
    public void mp_arg_error_unimpl_kw() throws Exception
    {
        call(this::mp_arg_error_unimpl_kw);
    }

    // function: Function(address=134257592, size=60, name='mp_warning', path='build/py/warning.o', has_indirect=False)
    public void mp_warning() throws Exception
    {
        call(this::mp_warning);
    }

    // function: Function(address=134257652, size=28, name='mp_map_init', path='build/py/map.o', has_indirect=False)
    public void mp_map_init() throws Exception
    {
        call(this::mp_map_init);
    }

    // function: Function(address=134257680, size=26, name='mp_map_init_fixed_table', path='build/py/map.o', has_indirect=False)
    public void mp_map_init_fixed_table() throws Exception
    {
        call(this::mp_map_init_fixed_table);
    }

    // function: Function(address=134257706, size=34, name='mp_map_deinit', path='build/py/map.o', has_indirect=False)
    public void mp_map_deinit() throws Exception
    {
        call(this::mp_map_deinit);
    }

    // function: Function(address=134257740, size=46, name='mp_map_clear', path='build/py/map.o', has_indirect=False)
    public void mp_map_clear() throws Exception
    {
        call(this::mp_map_clear);
    }

    // function: Function(address=134257788, size=512, name='mp_map_lookup', path='build/py/map.o', has_indirect=False)
    public void mp_map_lookup() throws Exception
    {
        call(this::mp_map_lookup);
    }

    // function: Function(address=134258300, size=116, name='mp_map_rehash', path='build/py/map.o', has_indirect=False)
    public void mp_map_rehash() throws Exception
    {
        call(this::mp_map_rehash);
    }

    // function: Function(address=134258416, size=20, name='mp_set_init', path='build/py/map.o', has_indirect=False)
    public void mp_set_init() throws Exception
    {
        call(this::mp_set_init);
    }

    // function: Function(address=134258436, size=222, name='mp_set_lookup', path='build/py/map.o', has_indirect=False)
    public void mp_set_lookup() throws Exception
    {
        call(this::mp_set_lookup);
    }

    // function: Function(address=134258660, size=100, name='mp_set_rehash', path='build/py/map.o', has_indirect=False)
    public void mp_set_rehash() throws Exception
    {
        call(this::mp_set_rehash);
    }

    // function: Function(address=134258760, size=62, name='mp_set_remove_first', path='build/py/map.o', has_indirect=False)
    public void mp_set_remove_first() throws Exception
    {
        call(this::mp_set_remove_first);
    }

    // function: Function(address=134258822, size=24, name='mp_set_clear', path='build/py/map.o', has_indirect=False)
    public void mp_set_clear() throws Exception
    {
        call(this::mp_set_clear);
    }

    // function: Function(address=134258846, size=2, name='mp_identity', path='build/py/obj.o', has_indirect=False)
    public void mp_identity() throws Exception
    {
        call(this::mp_identity);
    }

    // function: Function(address=134258848, size=32, name='mp_obj_get_type', path='build/py/obj.o', has_indirect=False)
    public void mp_obj_get_type() throws Exception
    {
        call(this::mp_obj_get_type);
    }

    // function: Function(address=134258880, size=14, name='mp_obj_get_type_str', path='build/py/obj.o', has_indirect=False)
    public void mp_obj_get_type_str() throws Exception
    {
        call(this::mp_obj_get_type_str);
    }

    // function: Function(address=134258896, size=52, name='mp_obj_print_helper', path='build/py/obj.o', has_indirect=False)
    public void mp_obj_print_helper() throws Exception
    {
        call(this::mp_obj_print_helper);
    }

    // function: Function(address=134258948, size=20, name='mp_obj_print', path='build/py/obj.o', has_indirect=False)
    public void mp_obj_print() throws Exception
    {
        call(this::mp_obj_print);
    }

    // function: Function(address=134258968, size=144, name='mp_obj_print_exception', path='build/py/obj.o', has_indirect=False)
    public void mp_obj_print_exception() throws Exception
    {
        call(this::mp_obj_print_exception);
    }

    // function: Function(address=134259112, size=36, name='mp_obj_is_callable', path='build/py/obj.o', has_indirect=False)
    public void mp_obj_is_callable() throws Exception
    {
        call(this::mp_obj_is_callable);
    }

    // function: Function(address=134259148, size=232, name='mp_obj_equal', path='build/py/obj.o', has_indirect=False)
    public void mp_obj_equal() throws Exception
    {
        call(this::mp_obj_equal);
    }

    // function: Function(address=134259380, size=88, name='mp_obj_get_int', path='build/py/obj.o', has_indirect=False)
    public void mp_obj_get_int() throws Exception
    {
        call(this::mp_obj_get_int);
    }

    // function: Function(address=134259468, size=36, name='mp_obj_get_int_truncated', path='build/py/obj.o', has_indirect=False)
    public void mp_obj_get_int_truncated() throws Exception
    {
        call(this::mp_obj_get_int_truncated);
    }

    // function: Function(address=134259504, size=76, name='mp_obj_get_int_maybe', path='build/py/obj.o', has_indirect=False)
    public void mp_obj_get_int_maybe() throws Exception
    {
        call(this::mp_obj_get_int_maybe);
    }

    // function: Function(address=134259580, size=96, name='mp_obj_get_float_maybe', path='build/py/obj.o', has_indirect=False)
    public void mp_obj_get_float_maybe() throws Exception
    {
        call(this::mp_obj_get_float_maybe);
    }

    // function: Function(address=134259676, size=48, name='mp_obj_get_float', path='build/py/obj.o', has_indirect=False)
    public void mp_obj_get_float() throws Exception
    {
        call(this::mp_obj_get_float);
    }

    // function: Function(address=134259724, size=140, name='mp_obj_get_complex', path='build/py/obj.o', has_indirect=False)
    public void mp_obj_get_complex() throws Exception
    {
        call(this::mp_obj_get_complex);
    }

    // function: Function(address=134259864, size=68, name='mp_obj_get_array', path='build/py/obj.o', has_indirect=False)
    public void mp_obj_get_array() throws Exception
    {
        call(this::mp_obj_get_array);
    }

    // function: Function(address=134259932, size=40, name='mp_obj_get_array_fixed_n', path='build/py/obj.o', has_indirect=False)
    public void mp_obj_get_array_fixed_n() throws Exception
    {
        call(this::mp_obj_get_array_fixed_n);
    }

    // function: Function(address=134259972, size=132, name='mp_get_index', path='build/py/obj.o', has_indirect=False)
    public void mp_get_index() throws Exception
    {
        call(this::mp_get_index);
    }

    // function: Function(address=134260104, size=30, name='mp_obj_id', path='build/py/obj.o', has_indirect=False)
    public void mp_obj_id() throws Exception
    {
        call(this::mp_obj_id);
    }

    // function: Function(address=134260136, size=52, name='mp_obj_len_maybe', path='build/py/obj.o', has_indirect=False)
    public void mp_obj_len_maybe() throws Exception
    {
        call(this::mp_obj_len_maybe);
    }

    // function: Function(address=134260188, size=100, name='mp_obj_is_true', path='build/py/obj.o', has_indirect=False)
    public void mp_obj_is_true() throws Exception
    {
        call(this::mp_obj_is_true);
    }

    // function: Function(address=134260288, size=44, name='mp_obj_len', path='build/py/obj.o', has_indirect=False)
    public void mp_obj_len() throws Exception
    {
        call(this::mp_obj_len);
    }

    // function: Function(address=134260332, size=100, name='mp_obj_subscr', path='build/py/obj.o', has_indirect=False)
    public void mp_obj_subscr() throws Exception
    {
        call(this::mp_obj_subscr);
    }

    // function: Function(address=134260432, size=2, name='mp_identity_getiter', path='build/py/obj.o', has_indirect=True)
    public void mp_identity_getiter() throws Exception
    {
        call(this::mp_identity_getiter);
    }

    // function: Function(address=134260434, size=34, name='mp_get_buffer', path='build/py/obj.o', has_indirect=False)
    public void mp_get_buffer() throws Exception
    {
        call(this::mp_get_buffer);
    }

    // function: Function(address=134260468, size=24, name='mp_get_buffer_raise', path='build/py/obj.o', has_indirect=False)
    public void mp_get_buffer_raise() throws Exception
    {
        call(this::mp_get_buffer_raise);
    }

    // function: Function(address=134260492, size=16, name='mp_generic_unary_op', path='build/py/obj.o', has_indirect=False)
    public void mp_generic_unary_op() throws Exception
    {
        call(this::mp_generic_unary_op);
    }

    // function: Function(address=134260508, size=44, name='array_unary_op', path='build/py/objarray.o', has_indirect=False)
    public void array_unary_op() throws Exception
    {
        call(this::array_unary_op);
    }

    // function: Function(address=134260552, size=40, name='array_iterator_new', path='build/py/objarray.o', has_indirect=False)
    public void array_iterator_new() throws Exception
    {
        call(this::array_iterator_new);
    }

    // function: Function(address=134260592, size=84, name='array_get_buffer', path='build/py/objarray.o', has_indirect=False)
    public void array_get_buffer() throws Exception
    {
        call(this::array_get_buffer);
    }

    // function: Function(address=134260676, size=68, name='array_new', path='build/py/objarray.o', has_indirect=False)
    public void array_new() throws Exception
    {
        call(this::array_new);
    }

    // function: Function(address=134260744, size=116, name='array_extend', path='build/py/objarray.o', has_indirect=False)
    public void array_extend() throws Exception
    {
        call(this::array_extend);
    }

    // function: Function(address=134260860, size=112, name='array_append', path='build/py/objarray.o', has_indirect=False)
    public void array_append() throws Exception
    {
        call(this::array_append);
    }

    // function: Function(address=134260972, size=38, name='array_it_iternext', path='build/py/objarray.o', has_indirect=False)
    public void array_it_iternext() throws Exception
    {
        call(this::array_it_iternext);
    }

    // function: Function(address=134261012, size=592, name='array_subscr', path='build/py/objarray.o', has_indirect=True)
    public void array_subscr() throws Exception
    {
        call(this::array_subscr);
    }

    // function: Function(address=134261604, size=312, name='array_binary_op', path='build/py/objarray.o', has_indirect=False)
    public void array_binary_op() throws Exception
    {
        call(this::array_binary_op);
    }

    // function: Function(address=134261916, size=180, name='array_construct', path='build/py/objarray.o', has_indirect=False)
    public void array_construct() throws Exception
    {
        call(this::array_construct);
    }

    // function: Function(address=134262096, size=50, name='array_make_new', path='build/py/objarray.o', has_indirect=False)
    public void array_make_new() throws Exception
    {
        call(this::array_make_new);
    }

    // function: Function(address=134262148, size=140, name='array_print', path='build/py/objarray.o', has_indirect=False)
    public void array_print() throws Exception
    {
        call(this::array_print);
    }

    // function: Function(address=134262288, size=100, name='bytearray_make_new', path='build/py/objarray.o', has_indirect=False)
    public void bytearray_make_new() throws Exception
    {
        call(this::bytearray_make_new);
    }

    // function: Function(address=134262388, size=36, name='mp_obj_new_memoryview', path='build/py/objarray.o', has_indirect=False)
    public void mp_obj_new_memoryview() throws Exception
    {
        call(this::mp_obj_new_memoryview);
    }

    // function: Function(address=134262424, size=102, name='memoryview_make_new', path='build/py/objarray.o', has_indirect=False)
    public void memoryview_make_new() throws Exception
    {
        call(this::memoryview_make_new);
    }

    // function: Function(address=134262528, size=32, name='mp_obj_new_bytearray_by_ref', path='build/py/objarray.o', has_indirect=False)
    public void mp_obj_new_bytearray_by_ref() throws Exception
    {
        call(this::mp_obj_new_bytearray_by_ref);
    }

    // function: Function(address=134262560, size=42, name='mp_obj_attrtuple_attr', path='build/py/objattrtuple.o', has_indirect=False)
    public void mp_obj_attrtuple_attr() throws Exception
    {
        call(this::mp_obj_attrtuple_attr);
    }

    // function: Function(address=134262604, size=92, name='mp_obj_attrtuple_print_helper', path='build/py/objattrtuple.o', has_indirect=False)
    public void mp_obj_attrtuple_print_helper() throws Exception
    {
        call(this::mp_obj_attrtuple_print_helper);
    }

    // function: Function(address=134262696, size=18, name='mp_obj_attrtuple_print', path='build/py/objattrtuple.o', has_indirect=False)
    public void mp_obj_attrtuple_print() throws Exception
    {
        call(this::mp_obj_attrtuple_print);
    }

    // function: Function(address=134262714, size=16, name='bool_binary_op', path='build/py/objbool.o', has_indirect=False)
    public void bool_binary_op() throws Exception
    {
        call(this::bool_binary_op);
    }

    // function: Function(address=134262730, size=26, name='bool_unary_op', path='build/py/objbool.o', has_indirect=False)
    public void bool_unary_op() throws Exception
    {
        call(this::bool_unary_op);
    }

    // function: Function(address=134262756, size=52, name='bool_make_new', path='build/py/objbool.o', has_indirect=False)
    public void bool_make_new() throws Exception
    {
        call(this::bool_make_new);
    }

    // function: Function(address=134262808, size=48, name='bool_print', path='build/py/objbool.o', has_indirect=False)
    public void bool_print() throws Exception
    {
        call(this::bool_print);
    }

    // function: Function(address=134262856, size=64, name='bound_meth_print', path='build/py/objboundmeth.o', has_indirect=False)
    public void bound_meth_print() throws Exception
    {
        call(this::bound_meth_print);
    }

    // function: Function(address=134262920, size=30, name='bound_meth_attr', path='build/py/objboundmeth.o', has_indirect=False)
    public void bound_meth_attr() throws Exception
    {
        call(this::bound_meth_attr);
    }

    // function: Function(address=134262952, size=60, name='mp_call_method_self_n_kw', path='build/py/objboundmeth.o', has_indirect=False)
    public void mp_call_method_self_n_kw() throws Exception
    {
        call(this::mp_call_method_self_n_kw);
    }

    // function: Function(address=134263012, size=18, name='bound_meth_call', path='build/py/objboundmeth.o', has_indirect=False)
    public void bound_meth_call() throws Exception
    {
        call(this::bound_meth_call);
    }

    // function: Function(address=134263032, size=28, name='mp_obj_new_bound_meth', path='build/py/objboundmeth.o', has_indirect=False)
    public void mp_obj_new_bound_meth() throws Exception
    {
        call(this::mp_obj_new_bound_meth);
    }

    // function: Function(address=134263060, size=60, name='cell_print', path='build/py/objcell.o', has_indirect=False)
    public void cell_print() throws Exception
    {
        call(this::cell_print);
    }

    // function: Function(address=134263120, size=4, name='mp_obj_cell_get', path='build/py/objcell.o', has_indirect=False)
    public void mp_obj_cell_get() throws Exception
    {
        call(this::mp_obj_cell_get);
    }

    // function: Function(address=134263124, size=4, name='mp_obj_cell_set', path='build/py/objcell.o', has_indirect=False)
    public void mp_obj_cell_set() throws Exception
    {
        call(this::mp_obj_cell_set);
    }

    // function: Function(address=134263128, size=24, name='mp_obj_new_cell', path='build/py/objcell.o', has_indirect=False)
    public void mp_obj_new_cell() throws Exception
    {
        call(this::mp_obj_new_cell);
    }

    // function: Function(address=134263152, size=148, name='closure_call', path='build/py/objclosure.o', has_indirect=False)
    public void closure_call() throws Exception
    {
        call(this::closure_call);
    }

    // function: Function(address=134263300, size=112, name='closure_print', path='build/py/objclosure.o', has_indirect=False)
    public void closure_print() throws Exception
    {
        call(this::closure_print);
    }

    // function: Function(address=134263412, size=48, name='mp_obj_new_closure', path='build/py/objclosure.o', has_indirect=False)
    public void mp_obj_new_closure() throws Exception
    {
        call(this::mp_obj_new_closure);
    }

    // function: Function(address=134263460, size=40, name='complex_attr', path='build/py/objcomplex.o', has_indirect=False)
    public void complex_attr() throws Exception
    {
        call(this::complex_attr);
    }

    // function: Function(address=134263500, size=160, name='complex_print', path='build/py/objcomplex.o', has_indirect=False)
    public void complex_print() throws Exception
    {
        call(this::complex_print);
    }

    // function: Function(address=134263660, size=28, name='mp_obj_new_complex', path='build/py/objcomplex.o', has_indirect=False)
    public void mp_obj_new_complex() throws Exception
    {
        call(this::mp_obj_new_complex);
    }

    // function: Function(address=134263688, size=156, name='complex_unary_op', path='build/py/objcomplex.o', has_indirect=False)
    public void complex_unary_op() throws Exception
    {
        call(this::complex_unary_op);
    }

    // function: Function(address=134263844, size=188, name='complex_make_new', path='build/py/objcomplex.o', has_indirect=False)
    public void complex_make_new() throws Exception
    {
        call(this::complex_make_new);
    }

    // function: Function(address=134264032, size=10, name='mp_obj_complex_get', path='build/py/objcomplex.o', has_indirect=False)
    public void mp_obj_complex_get() throws Exception
    {
        call(this::mp_obj_complex_get);
    }

    // function: Function(address=134264044, size=604, name='mp_obj_complex_binary_op', path='build/py/objcomplex.o', has_indirect=False)
    public void mp_obj_complex_binary_op() throws Exception
    {
        call(this::mp_obj_complex_binary_op);
    }

    // function: Function(address=134264648, size=14, name='complex_binary_op', path='build/py/objcomplex.o', has_indirect=False)
    public void complex_binary_op() throws Exception
    {
        call(this::complex_binary_op);
    }

    // function: Function(address=134264664, size=104, name='deque_make_new', path='build/py/objdeque.o', has_indirect=False)
    public void deque_make_new() throws Exception
    {
        call(this::deque_make_new);
    }

    // function: Function(address=134264768, size=68, name='deque_unary_op', path='build/py/objdeque.o', has_indirect=False)
    public void deque_unary_op() throws Exception
    {
        call(this::deque_unary_op);
    }

    // function: Function(address=134264836, size=56, name='deque_popleft', path='build/py/objdeque.o', has_indirect=False)
    public void deque_popleft() throws Exception
    {
        call(this::deque_popleft);
    }

    // function: Function(address=134264892, size=76, name='mp_obj_deque_append', path='build/py/objdeque.o', has_indirect=False)
    public void mp_obj_deque_append() throws Exception
    {
        call(this::mp_obj_deque_append);
    }

    // function: Function(address=134264968, size=24, name='dict_view_getiter', path='build/py/objdict.o', has_indirect=False)
    public void dict_view_getiter() throws Exception
    {
        call(this::dict_view_getiter);
    }

    // function: Function(address=134264992, size=24, name='dict_getiter', path='build/py/objdict.o', has_indirect=False)
    public void dict_getiter() throws Exception
    {
        call(this::dict_getiter);
    }

    // function: Function(address=134265016, size=28, name='dict_values', path='build/py/objdict.o', has_indirect=False)
    public void dict_values() throws Exception
    {
        call(this::dict_values);
    }

    // function: Function(address=134265044, size=16, name='mp_ensure_not_fixed', path='build/py/objdict.o', has_indirect=False)
    public void mp_ensure_not_fixed() throws Exception
    {
        call(this::mp_ensure_not_fixed);
    }

    // function: Function(address=134265060, size=24, name='dict_clear', path='build/py/objdict.o', has_indirect=False)
    public void dict_clear() throws Exception
    {
        call(this::dict_clear);
    }

    // function: Function(address=134265084, size=60, name='dict_unary_op', path='build/py/objdict.o', has_indirect=False)
    public void dict_unary_op() throws Exception
    {
        call(this::dict_unary_op);
    }

    // function: Function(address=134265144, size=92, name='dict_get_helper', path='build/py/objdict.o', has_indirect=False)
    public void dict_get_helper() throws Exception
    {
        call(this::dict_get_helper);
    }

    // function: Function(address=134265236, size=10, name='dict_setdefault', path='build/py/objdict.o', has_indirect=False)
    public void dict_setdefault() throws Exception
    {
        call(this::dict_setdefault);
    }

    // function: Function(address=134265246, size=10, name='dict_pop', path='build/py/objdict.o', has_indirect=False)
    public void dict_pop() throws Exception
    {
        call(this::dict_pop);
    }

    // function: Function(address=134265256, size=10, name='dict_get', path='build/py/objdict.o', has_indirect=False)
    public void dict_get() throws Exception
    {
        call(this::dict_get);
    }

    // function: Function(address=134265266, size=42, name='dict_iter_next', path='build/py/objdict.o', has_indirect=False)
    public void dict_iter_next() throws Exception
    {
        call(this::dict_iter_next);
    }

    // function: Function(address=134265308, size=58, name='dict_view_it_iternext', path='build/py/objdict.o', has_indirect=False)
    public void dict_view_it_iternext() throws Exception
    {
        call(this::dict_view_it_iternext);
    }

    // function: Function(address=134265368, size=120, name='dict_view_print', path='build/py/objdict.o', has_indirect=False)
    public void dict_view_print() throws Exception
    {
        call(this::dict_view_print);
    }

    // function: Function(address=134265488, size=232, name='dict_update', path='build/py/objdict.o', has_indirect=False)
    public void dict_update() throws Exception
    {
        call(this::dict_update);
    }

    // function: Function(address=134265720, size=72, name='dict_popitem', path='build/py/objdict.o', has_indirect=False)
    public void dict_popitem() throws Exception
    {
        call(this::dict_popitem);
    }

    // function: Function(address=134265792, size=220, name='dict_binary_op', path='build/py/objdict.o', has_indirect=False)
    public void dict_binary_op() throws Exception
    {
        call(this::dict_binary_op);
    }

    // function: Function(address=134266012, size=26, name='dict_view_binary_op', path='build/py/objdict.o', has_indirect=False)
    public void dict_view_binary_op() throws Exception
    {
        call(this::dict_view_binary_op);
    }

    // function: Function(address=134266040, size=164, name='dict_print', path='build/py/objdict.o', has_indirect=False)
    public void dict_print() throws Exception
    {
        call(this::dict_print);
    }

    // function: Function(address=134266204, size=28, name='dict_items', path='build/py/objdict.o', has_indirect=False)
    public void dict_items() throws Exception
    {
        call(this::dict_items);
    }

    // function: Function(address=134266232, size=28, name='dict_keys', path='build/py/objdict.o', has_indirect=False)
    public void dict_keys() throws Exception
    {
        call(this::dict_keys);
    }

    // function: Function(address=134266260, size=36, name='mp_obj_dict_get', path='build/py/objdict.o', has_indirect=False)
    public void mp_obj_dict_get() throws Exception
    {
        call(this::mp_obj_dict_get);
    }

    // function: Function(address=134266296, size=16, name='mp_obj_dict_init', path='build/py/objdict.o', has_indirect=False)
    public void mp_obj_dict_init() throws Exception
    {
        call(this::mp_obj_dict_init);
    }

    // function: Function(address=134266312, size=22, name='mp_obj_new_dict', path='build/py/objdict.o', has_indirect=False)
    public void mp_obj_new_dict() throws Exception
    {
        call(this::mp_obj_new_dict);
    }

    // function: Function(address=134266336, size=76, name='dict_fromkeys', path='build/py/objdict.o', has_indirect=False)
    public void dict_fromkeys() throws Exception
    {
        call(this::dict_fromkeys);
    }

    // function: Function(address=134266412, size=86, name='dict_copy', path='build/py/objdict.o', has_indirect=False)
    public void dict_copy() throws Exception
    {
        call(this::dict_copy);
    }

    // function: Function(address=134266500, size=80, name='dict_make_new', path='build/py/objdict.o', has_indirect=True)
    public void dict_make_new() throws Exception
    {
        call(this::dict_make_new);
    }

    // function: Function(address=134266580, size=6, name='mp_obj_dict_len', path='build/py/objdict.o', has_indirect=False)
    public void mp_obj_dict_len() throws Exception
    {
        call(this::mp_obj_dict_len);
    }

    // function: Function(address=134266586, size=28, name='mp_obj_dict_store', path='build/py/objdict.o', has_indirect=False)
    public void mp_obj_dict_store() throws Exception
    {
        call(this::mp_obj_dict_store);
    }

    // function: Function(address=134266614, size=22, name='mp_obj_dict_delete', path='build/py/objdict.o', has_indirect=False)
    public void mp_obj_dict_delete() throws Exception
    {
        call(this::mp_obj_dict_delete);
    }

    // function: Function(address=134266636, size=64, name='dict_subscr', path='build/py/objdict.o', has_indirect=False)
    public void dict_subscr() throws Exception
    {
        call(this::dict_subscr);
    }

    // function: Function(address=134266700, size=40, name='enumerate_iternext', path='build/py/objenumerate.o', has_indirect=False)
    public void enumerate_iternext() throws Exception
    {
        call(this::enumerate_iternext);
    }

    // function: Function(address=134266740, size=60, name='enumerate_make_new', path='build/py/objenumerate.o', has_indirect=False)
    public void enumerate_make_new() throws Exception
    {
        call(this::enumerate_make_new);
    }

    // function: Function(address=134266800, size=164, name='mp_obj_exception_print', path='build/py/objexcept.o', has_indirect=False)
    public void mp_obj_exception_print() throws Exception
    {
        call(this::mp_obj_exception_print);
    }

    // function: Function(address=134266964, size=128, name='mp_obj_exception_make_new', path='build/py/objexcept.o', has_indirect=True)
    public void mp_obj_exception_make_new() throws Exception
    {
        call(this::mp_obj_exception_make_new);
    }

    // function: Function(address=134267092, size=88, name='exc_add_strn', path='build/py/objexcept.o', has_indirect=True)
    public void exc_add_strn() throws Exception
    {
        call(this::exc_add_strn);
    }

    // function: Function(address=134267180, size=2, name='mp_init_emergency_exception_buf', path='build/py/objexcept.o', has_indirect=False)
    public void mp_init_emergency_exception_buf() throws Exception
    {
        call(this::mp_init_emergency_exception_buf);
    }

    // function: Function(address=134267184, size=20, name='mp_obj_exception_get_value', path='build/py/objexcept.o', has_indirect=False)
    public void mp_obj_exception_get_value() throws Exception
    {
        call(this::mp_obj_exception_get_value);
    }

    // function: Function(address=134267204, size=72, name='mp_obj_exception_attr', path='build/py/objexcept.o', has_indirect=False)
    public void mp_obj_exception_attr() throws Exception
    {
        call(this::mp_obj_exception_attr);
    }

    // function: Function(address=134267276, size=12, name='mp_obj_new_exception_args', path='build/py/objexcept.o', has_indirect=False)
    public void mp_obj_new_exception_args() throws Exception
    {
        call(this::mp_obj_new_exception_args);
    }

    // function: Function(address=134267288, size=12, name='mp_obj_new_exception', path='build/py/objexcept.o', has_indirect=False)
    public void mp_obj_new_exception() throws Exception
    {
        call(this::mp_obj_new_exception);
    }

    // function: Function(address=134267300, size=14, name='mp_obj_new_exception_arg1', path='build/py/objexcept.o', has_indirect=False)
    public void mp_obj_new_exception_arg1() throws Exception
    {
        call(this::mp_obj_new_exception_arg1);
    }

    // function: Function(address=134267316, size=148, name='mp_obj_new_exception_msg_varg', path='build/py/objexcept.o', has_indirect=False)
    public void mp_obj_new_exception_msg_varg() throws Exception
    {
        call(this::mp_obj_new_exception_msg_varg);
    }

    // function: Function(address=134267464, size=8, name='mp_obj_new_exception_msg', path='build/py/objexcept.o', has_indirect=False)
    public void mp_obj_new_exception_msg() throws Exception
    {
        call(this::mp_obj_new_exception_msg);
    }

    // function: Function(address=134267472, size=48, name='mp_obj_is_exception_type', path='build/py/objexcept.o', has_indirect=False)
    public void mp_obj_is_exception_type() throws Exception
    {
        call(this::mp_obj_is_exception_type);
    }

    // function: Function(address=134267520, size=12, name='mp_obj_is_exception_instance', path='build/py/objexcept.o', has_indirect=False)
    public void mp_obj_is_exception_instance() throws Exception
    {
        call(this::mp_obj_is_exception_instance);
    }

    // function: Function(address=134267532, size=32, name='mp_obj_exception_match', path='build/py/objexcept.o', has_indirect=False)
    public void mp_obj_exception_match() throws Exception
    {
        call(this::mp_obj_exception_match);
    }

    // function: Function(address=134267564, size=28, name='mp_obj_exception_clear_traceback', path='build/py/objexcept.o', has_indirect=False)
    public void mp_obj_exception_clear_traceback() throws Exception
    {
        call(this::mp_obj_exception_clear_traceback);
    }

    // function: Function(address=134267592, size=128, name='mp_obj_exception_add_traceback', path='build/py/objexcept.o', has_indirect=False)
    public void mp_obj_exception_add_traceback() throws Exception
    {
        call(this::mp_obj_exception_add_traceback);
    }

    // function: Function(address=134267720, size=44, name='mp_obj_exception_get_traceback', path='build/py/objexcept.o', has_indirect=False)
    public void mp_obj_exception_get_traceback() throws Exception
    {
        call(this::mp_obj_exception_get_traceback);
    }

    // function: Function(address=134267764, size=52, name='filter_iternext', path='build/py/objfilter.o', has_indirect=False)
    public void filter_iternext() throws Exception
    {
        call(this::filter_iternext);
    }

    // function: Function(address=134267816, size=50, name='filter_make_new', path='build/py/objfilter.o', has_indirect=False)
    public void filter_make_new() throws Exception
    {
        call(this::filter_make_new);
    }

    // function: Function(address=134267868, size=88, name='float_print', path='build/py/objfloat.o', has_indirect=False)
    public void float_print() throws Exception
    {
        call(this::float_print);
    }

    // function: Function(address=134267956, size=220, name='mp_obj_float_divmod', path='build/py/objfloat.o', has_indirect=False)
    public void mp_obj_float_divmod() throws Exception
    {
        call(this::mp_obj_float_divmod);
    }

    // function: Function(address=134268176, size=70, name='mp_float_hash', path='build/py/objfloat.o', has_indirect=False)
    public void mp_float_hash() throws Exception
    {
        call(this::mp_float_hash);
    }

    // function: Function(address=134268248, size=24, name='mp_obj_new_float', path='build/py/objfloat.o', has_indirect=False)
    public void mp_obj_new_float() throws Exception
    {
        call(this::mp_obj_new_float);
    }

    // function: Function(address=134268272, size=92, name='float_make_new', path='build/py/objfloat.o', has_indirect=False)
    public void float_make_new() throws Exception
    {
        call(this::float_make_new);
    }

    // function: Function(address=134268364, size=100, name='float_unary_op', path='build/py/objfloat.o', has_indirect=False)
    public void float_unary_op() throws Exception
    {
        call(this::float_unary_op);
    }

    // function: Function(address=134268464, size=4, name='mp_obj_float_get', path='build/py/objfloat.o', has_indirect=False)
    public void mp_obj_float_get() throws Exception
    {
        call(this::mp_obj_float_get);
    }

    // function: Function(address=134268468, size=560, name='mp_obj_float_binary_op', path='build/py/objfloat.o', has_indirect=False)
    public void mp_obj_float_binary_op() throws Exception
    {
        call(this::mp_obj_float_binary_op);
    }

    // function: Function(address=134269028, size=36, name='float_binary_op', path='build/py/objfloat.o', has_indirect=False)
    public void float_binary_op() throws Exception
    {
        call(this::float_binary_op);
    }

    // function: Function(address=134269064, size=24, name='fun_builtin_0_call', path='build/py/objfun.o', has_indirect=False)
    public void fun_builtin_0_call() throws Exception
    {
        call(this::fun_builtin_0_call);
    }

    // function: Function(address=134269088, size=30, name='fun_builtin_1_call', path='build/py/objfun.o', has_indirect=False)
    public void fun_builtin_1_call() throws Exception
    {
        call(this::fun_builtin_1_call);
    }

    // function: Function(address=134269118, size=30, name='fun_builtin_2_call', path='build/py/objfun.o', has_indirect=False)
    public void fun_builtin_2_call() throws Exception
    {
        call(this::fun_builtin_2_call);
    }

    // function: Function(address=134269148, size=30, name='fun_builtin_3_call', path='build/py/objfun.o', has_indirect=False)
    public void fun_builtin_3_call() throws Exception
    {
        call(this::fun_builtin_3_call);
    }

    // function: Function(address=134269180, size=132, name='fun_bc_call', path='build/py/objfun.o', has_indirect=False)
    public void fun_bc_call() throws Exception
    {
        call(this::fun_bc_call);
    }

    // function: Function(address=134269312, size=76, name='fun_builtin_var_call', path='build/py/objfun.o', has_indirect=False)
    public void fun_builtin_var_call() throws Exception
    {
        call(this::fun_builtin_var_call);
    }

    // function: Function(address=134269388, size=16, name='mp_obj_code_get_name', path='build/py/objfun.o', has_indirect=False)
    public void mp_obj_code_get_name() throws Exception
    {
        call(this::mp_obj_code_get_name);
    }

    // function: Function(address=134269404, size=20, name='mp_obj_fun_get_name', path='build/py/objfun.o', has_indirect=False)
    public void mp_obj_fun_get_name() throws Exception
    {
        call(this::mp_obj_fun_get_name);
    }

    // function: Function(address=134269424, size=28, name='mp_obj_fun_bc_attr', path='build/py/objfun.o', has_indirect=False)
    public void mp_obj_fun_bc_attr() throws Exception
    {
        call(this::mp_obj_fun_bc_attr);
    }

    // function: Function(address=134269452, size=32, name='fun_bc_print', path='build/py/objfun.o', has_indirect=False)
    public void fun_bc_print() throws Exception
    {
        call(this::fun_bc_print);
    }

    // function: Function(address=134269484, size=84, name='mp_obj_fun_bc_prepare_codestate', path='build/py/objfun.o', has_indirect=False)
    public void mp_obj_fun_bc_prepare_codestate() throws Exception
    {
        call(this::mp_obj_fun_bc_prepare_codestate);
    }

    // function: Function(address=134269568, size=92, name='mp_obj_new_fun_bc', path='build/py/objfun.o', has_indirect=False)
    public void mp_obj_new_fun_bc() throws Exception
    {
        call(this::mp_obj_new_fun_bc);
    }

    // function: Function(address=134269660, size=80, name='gen_wrap_call', path='build/py/objgenerator.o', has_indirect=False)
    public void gen_wrap_call() throws Exception
    {
        call(this::gen_wrap_call);
    }

    // function: Function(address=134269740, size=28, name='gen_instance_pend_throw', path='build/py/objgenerator.o', has_indirect=False)
    public void gen_instance_pend_throw() throws Exception
    {
        call(this::gen_instance_pend_throw);
    }

    // function: Function(address=134269768, size=32, name='gen_instance_print', path='build/py/objgenerator.o', has_indirect=False)
    public void gen_instance_print() throws Exception
    {
        call(this::gen_instance_print);
    }

    // function: Function(address=134269800, size=16, name='unlikely_gen_instance_throw_part_0', path='build/py/objgenerator.o', has_indirect=False)
    public void unlikely_gen_instance_throw_part_0() throws Exception
    {
        call(this::unlikely_gen_instance_throw_part_0);
    }

    // function: Function(address=134269816, size=184, name='mp_obj_gen_resume', path='build/py/objgenerator.o', has_indirect=False)
    public void mp_obj_gen_resume() throws Exception
    {
        call(this::mp_obj_gen_resume);
    }

    // function: Function(address=134270000, size=88, name='gen_resume_and_raise', path='build/py/objgenerator.o', has_indirect=False)
    public void gen_resume_and_raise() throws Exception
    {
        call(this::gen_resume_and_raise);
    }

    // function: Function(address=134270088, size=36, name='gen_instance_throw', path='build/py/objgenerator.o', has_indirect=False)
    public void gen_instance_throw() throws Exception
    {
        call(this::gen_instance_throw);
    }

    // function: Function(address=134270124, size=18, name='gen_instance_send', path='build/py/objgenerator.o', has_indirect=False)
    public void gen_instance_send() throws Exception
    {
        call(this::gen_instance_send);
    }

    // function: Function(address=134270144, size=16, name='gen_instance_iternext', path='build/py/objgenerator.o', has_indirect=False)
    public void gen_instance_iternext() throws Exception
    {
        call(this::gen_instance_iternext);
    }

    // function: Function(address=134270160, size=96, name='gen_instance_close', path='build/py/objgenerator.o', has_indirect=False)
    public void gen_instance_close() throws Exception
    {
        call(this::gen_instance_close);
    }

    // function: Function(address=134270256, size=84, name='it_iternext', path='build/py/objgetitemiter.o', has_indirect=False)
    public void it_iternext() throws Exception
    {
        call(this::it_iternext);
    }

    // function: Function(address=134270340, size=24, name='mp_obj_new_getitem_iter', path='build/py/objgetitemiter.o', has_indirect=False)
    public void mp_obj_new_getitem_iter() throws Exception
    {
        call(this::mp_obj_new_getitem_iter);
    }

    // function: Function(address=134270364, size=128, name='int_to_bytes', path='build/py/objint.o', has_indirect=False)
    public void int_to_bytes() throws Exception
    {
        call(this::int_to_bytes);
    }

    // function: Function(address=134270492, size=108, name='int_from_bytes', path='build/py/objint.o', has_indirect=False)
    public void int_from_bytes() throws Exception
    {
        call(this::int_from_bytes);
    }

    // function: Function(address=134270600, size=128, name='mp_obj_new_int_from_float', path='build/py/objint.o', has_indirect=False)
    public void mp_obj_new_int_from_float() throws Exception
    {
        call(this::mp_obj_new_int_from_float);
    }

    // function: Function(address=134270728, size=156, name='mp_obj_int_make_new', path='build/py/objint.o', has_indirect=False)
    public void mp_obj_int_make_new() throws Exception
    {
        call(this::mp_obj_int_make_new);
    }

    // function: Function(address=134270884, size=56, name='mp_int_format_size', path='build/py/objint.o', has_indirect=False)
    public void mp_int_format_size() throws Exception
    {
        call(this::mp_int_format_size);
    }

    // function: Function(address=134270940, size=278, name='mp_obj_int_formatted', path='build/py/objint.o', has_indirect=False)
    public void mp_obj_int_formatted() throws Exception
    {
        call(this::mp_obj_int_formatted);
    }

    // function: Function(address=134271218, size=62, name='mp_obj_int_print', path='build/py/objint.o', has_indirect=False)
    public void mp_obj_int_print() throws Exception
    {
        call(this::mp_obj_int_print);
    }

    // function: Function(address=134271280, size=100, name='mp_obj_int_binary_op_extra_cases', path='build/py/objint.o', has_indirect=False)
    public void mp_obj_int_binary_op_extra_cases() throws Exception
    {
        call(this::mp_obj_int_binary_op_extra_cases);
    }

    // function: Function(address=134271380, size=28, name='mp_obj_int_new_mpz', path='build/py/objint_mpz.o', has_indirect=False)
    public void mp_obj_int_new_mpz() throws Exception
    {
        call(this::mp_obj_int_new_mpz);
    }

    // function: Function(address=134271408, size=84, name='mp_obj_int_formatted_impl', path='build/py/objint_mpz.o', has_indirect=False)
    public void mp_obj_int_formatted_impl() throws Exception
    {
        call(this::mp_obj_int_formatted_impl);
    }

    // function: Function(address=134271492, size=30, name='mp_obj_int_from_bytes_impl', path='build/py/objint_mpz.o', has_indirect=False)
    public void mp_obj_int_from_bytes_impl() throws Exception
    {
        call(this::mp_obj_int_from_bytes_impl);
    }

    // function: Function(address=134271522, size=32, name='mp_obj_int_to_bytes_impl', path='build/py/objint_mpz.o', has_indirect=False)
    public void mp_obj_int_to_bytes_impl() throws Exception
    {
        call(this::mp_obj_int_to_bytes_impl);
    }

    // function: Function(address=134271554, size=40, name='mp_obj_int_sign', path='build/py/objint_mpz.o', has_indirect=False)
    public void mp_obj_int_sign() throws Exception
    {
        call(this::mp_obj_int_sign);
    }

    // function: Function(address=134271596, size=128, name='mp_obj_int_unary_op', path='build/py/objint_mpz.o', has_indirect=False)
    public void mp_obj_int_unary_op() throws Exception
    {
        call(this::mp_obj_int_unary_op);
    }

    // function: Function(address=134271724, size=30, name='mp_obj_new_int_from_ll', path='build/py/objint_mpz.o', has_indirect=False)
    public void mp_obj_new_int_from_ll() throws Exception
    {
        call(this::mp_obj_new_int_from_ll);
    }

    // function: Function(address=134271754, size=24, name='mp_obj_new_int', path='build/py/objint_mpz.o', has_indirect=False)
    public void mp_obj_new_int() throws Exception
    {
        call(this::mp_obj_new_int);
    }

    // function: Function(address=134271778, size=30, name='mp_obj_new_int_from_ull', path='build/py/objint_mpz.o', has_indirect=False)
    public void mp_obj_new_int_from_ull() throws Exception
    {
        call(this::mp_obj_new_int_from_ull);
    }

    // function: Function(address=134271808, size=208, name='mp_obj_int_pow3', path='build/py/objint_mpz.o', has_indirect=False)
    public void mp_obj_int_pow3() throws Exception
    {
        call(this::mp_obj_int_pow3);
    }

    // function: Function(address=134272016, size=22, name='mp_obj_new_int_from_uint', path='build/py/objint_mpz.o', has_indirect=False)
    public void mp_obj_new_int_from_uint() throws Exception
    {
        call(this::mp_obj_new_int_from_uint);
    }

    // function: Function(address=134272038, size=46, name='mp_obj_new_int_from_str_len', path='build/py/objint_mpz.o', has_indirect=False)
    public void mp_obj_new_int_from_str_len() throws Exception
    {
        call(this::mp_obj_new_int_from_str_len);
    }

    // function: Function(address=134272084, size=18, name='mp_obj_int_get_truncated', path='build/py/objint_mpz.o', has_indirect=False)
    public void mp_obj_int_get_truncated() throws Exception
    {
        call(this::mp_obj_int_get_truncated);
    }

    // function: Function(address=134272104, size=44, name='mp_obj_int_get_checked', path='build/py/objint_mpz.o', has_indirect=False)
    public void mp_obj_int_get_checked() throws Exception
    {
        call(this::mp_obj_int_get_checked);
    }

    // function: Function(address=134272148, size=648, name='mp_obj_int_binary_op', path='build/py/objint_mpz.o', has_indirect=False)
    public void mp_obj_int_binary_op() throws Exception
    {
        call(this::mp_obj_int_binary_op);
    }

    // function: Function(address=134272796, size=10, name='mp_obj_int_as_float_impl', path='build/py/objint_mpz.o', has_indirect=False)
    public void mp_obj_int_as_float_impl() throws Exception
    {
        call(this::mp_obj_int_as_float_impl);
    }

    // function: Function(address=134272808, size=28, name='list_getiter', path='build/py/objlist.o', has_indirect=False)
    public void list_getiter() throws Exception
    {
        call(this::list_getiter);
    }

    // function: Function(address=134272836, size=56, name='list_reverse', path='build/py/objlist.o', has_indirect=False)
    public void list_reverse() throws Exception
    {
        call(this::list_reverse);
    }

    // function: Function(address=134272892, size=28, name='list_it_iternext', path='build/py/objlist.o', has_indirect=True)
    public void list_it_iternext() throws Exception
    {
        call(this::list_it_iternext);
    }

    // function: Function(address=134272920, size=80, name='mp_obj_list_append', path='build/py/objlist.o', has_indirect=False)
    public void mp_obj_list_append() throws Exception
    {
        call(this::mp_obj_list_append);
    }

    // function: Function(address=134273000, size=76, name='list_insert', path='build/py/objlist.o', has_indirect=False)
    public void list_insert() throws Exception
    {
        call(this::list_insert);
    }

    // function: Function(address=134273076, size=44, name='list_clear', path='build/py/objlist.o', has_indirect=False)
    public void list_clear() throws Exception
    {
        call(this::list_clear);
    }

    // function: Function(address=134273120, size=208, name='mp_quicksort', path='build/py/objlist.o', has_indirect=False)
    public void mp_quicksort() throws Exception
    {
        call(this::mp_quicksort);
    }

    // function: Function(address=134273328, size=92, name='mp_obj_list_sort', path='build/py/objlist.o', has_indirect=False)
    public void mp_obj_list_sort() throws Exception
    {
        call(this::mp_obj_list_sort);
    }

    // function: Function(address=134273420, size=18, name='list_index', path='build/py/objlist.o', has_indirect=False)
    public void list_index() throws Exception
    {
        call(this::list_index);
    }

    // function: Function(address=134273440, size=124, name='list_pop', path='build/py/objlist.o', has_indirect=False)
    public void list_pop() throws Exception
    {
        call(this::list_pop);
    }

    // function: Function(address=134273564, size=32, name='mp_obj_list_remove', path='build/py/objlist.o', has_indirect=False)
    public void mp_obj_list_remove() throws Exception
    {
        call(this::mp_obj_list_remove);
    }

    // function: Function(address=134273596, size=36, name='list_extend_from_iter', path='build/py/objlist.o', has_indirect=False)
    public void list_extend_from_iter() throws Exception
    {
        call(this::list_extend_from_iter);
    }

    // function: Function(address=134273632, size=14, name='list_count', path='build/py/objlist.o', has_indirect=False)
    public void list_count() throws Exception
    {
        call(this::list_count);
    }

    // function: Function(address=134273648, size=84, name='list_print', path='build/py/objlist.o', has_indirect=False)
    public void list_print() throws Exception
    {
        call(this::list_print);
    }

    // function: Function(address=134273732, size=56, name='list_unary_op', path='build/py/objlist.o', has_indirect=False)
    public void list_unary_op() throws Exception
    {
        call(this::list_unary_op);
    }

    // function: Function(address=134273788, size=116, name='list_extend', path='build/py/objlist.o', has_indirect=False)
    public void list_extend() throws Exception
    {
        call(this::list_extend);
    }

    // function: Function(address=134273904, size=52, name='mp_obj_list_init', path='build/py/objlist.o', has_indirect=False)
    public void mp_obj_list_init() throws Exception
    {
        call(this::mp_obj_list_init);
    }

    // function: Function(address=134273956, size=22, name='list_new', path='build/py/objlist.o', has_indirect=False)
    public void list_new() throws Exception
    {
        call(this::list_new);
    }

    // function: Function(address=134273980, size=216, name='list_binary_op', path='build/py/objlist.o', has_indirect=False)
    public void list_binary_op() throws Exception
    {
        call(this::list_binary_op);
    }

    // function: Function(address=134274196, size=48, name='list_make_new', path='build/py/objlist.o', has_indirect=False)
    public void list_make_new() throws Exception
    {
        call(this::list_make_new);
    }

    // function: Function(address=134274244, size=34, name='mp_obj_new_list', path='build/py/objlist.o', has_indirect=False)
    public void mp_obj_new_list() throws Exception
    {
        call(this::mp_obj_new_list);
    }

    // function: Function(address=134274278, size=12, name='list_copy', path='build/py/objlist.o', has_indirect=False)
    public void list_copy() throws Exception
    {
        call(this::list_copy);
    }

    // function: Function(address=134274290, size=10, name='mp_obj_list_get', path='build/py/objlist.o', has_indirect=False)
    public void mp_obj_list_get() throws Exception
    {
        call(this::mp_obj_list_get);
    }

    // function: Function(address=134274300, size=4, name='mp_obj_list_set_len', path='build/py/objlist.o', has_indirect=False)
    public void mp_obj_list_set_len() throws Exception
    {
        call(this::mp_obj_list_set_len);
    }

    // function: Function(address=134274304, size=26, name='mp_obj_list_store', path='build/py/objlist.o', has_indirect=False)
    public void mp_obj_list_store() throws Exception
    {
        call(this::mp_obj_list_store);
    }

    // function: Function(address=134274332, size=440, name='list_subscr', path='build/py/objlist.o', has_indirect=False)
    public void list_subscr() throws Exception
    {
        call(this::list_subscr);
    }

    // function: Function(address=134274772, size=72, name='map_iternext', path='build/py/objmap.o', has_indirect=False)
    public void map_iternext() throws Exception
    {
        call(this::map_iternext);
    }

    // function: Function(address=134274844, size=88, name='map_make_new', path='build/py/objmap.o', has_indirect=False)
    public void map_make_new() throws Exception
    {
        call(this::map_make_new);
    }

    // function: Function(address=134274932, size=92, name='module_print', path='build/py/objmodule.o', has_indirect=False)
    public void module_print() throws Exception
    {
        call(this::module_print);
    }

    // function: Function(address=134275024, size=104, name='module_attr', path='build/py/objmodule.o', has_indirect=False)
    public void module_attr() throws Exception
    {
        call(this::module_attr);
    }

    // function: Function(address=134275128, size=68, name='mp_obj_new_module', path='build/py/objmodule.o', has_indirect=False)
    public void mp_obj_new_module() throws Exception
    {
        call(this::mp_obj_new_module);
    }

    // function: Function(address=134275196, size=28, name='mp_module_register', path='build/py/objmodule.o', has_indirect=False)
    public void mp_module_register() throws Exception
    {
        call(this::mp_module_register);
    }

    // function: Function(address=134275224, size=42, name='mp_module_call_init', path='build/py/objmodule.o', has_indirect=False)
    public void mp_module_call_init() throws Exception
    {
        call(this::mp_module_call_init);
    }

    // function: Function(address=134275268, size=60, name='mp_module_get', path='build/py/objmodule.o', has_indirect=False)
    public void mp_module_get() throws Exception
    {
        call(this::mp_module_get);
    }

    // function: Function(address=134275328, size=8, name='object___init__', path='build/py/objobject.o', has_indirect=False)
    public void object___init__() throws Exception
    {
        call(this::object___init__);
    }

    // function: Function(address=134275336, size=48, name='object___new__', path='build/py/objobject.o', has_indirect=False)
    public void object___new__() throws Exception
    {
        call(this::object___new__);
    }

    // function: Function(address=134275384, size=28, name='object_make_new', path='build/py/objobject.o', has_indirect=False)
    public void object_make_new() throws Exception
    {
        call(this::object_make_new);
    }

    // function: Function(address=134275412, size=8, name='polymorph_it_iternext', path='build/py/objpolyiter.o', has_indirect=False)
    public void polymorph_it_iternext() throws Exception
    {
        call(this::polymorph_it_iternext);
    }

    // function: Function(address=134275420, size=22, name='property_deleter', path='build/py/objproperty.o', has_indirect=False)
    public void property_deleter() throws Exception
    {
        call(this::property_deleter);
    }

    // function: Function(address=134275442, size=26, name='property_setter', path='build/py/objproperty.o', has_indirect=False)
    public void property_setter() throws Exception
    {
        call(this::property_setter);
    }

    // function: Function(address=134275468, size=26, name='property_getter', path='build/py/objproperty.o', has_indirect=False)
    public void property_getter() throws Exception
    {
        call(this::property_getter);
    }

    // function: Function(address=134275496, size=56, name='property_make_new', path='build/py/objproperty.o', has_indirect=False)
    public void property_make_new() throws Exception
    {
        call(this::property_make_new);
    }

    // function: Function(address=134275552, size=4, name='mp_obj_property_get', path='build/py/objproperty.o', has_indirect=False)
    public void mp_obj_property_get() throws Exception
    {
        call(this::mp_obj_property_get);
    }

    // function: Function(address=134275556, size=24, name='none_print', path='build/py/objnone.o', has_indirect=False)
    public void none_print() throws Exception
    {
        call(this::none_print);
    }

    // function: Function(address=134275580, size=72, name='namedtuple_asdict', path='build/py/objnamedtuple.o', has_indirect=False)
    public void namedtuple_asdict() throws Exception
    {
        call(this::namedtuple_asdict);
    }

    // function: Function(address=134275652, size=36, name='namedtuple_print', path='build/py/objnamedtuple.o', has_indirect=True)
    public void namedtuple_print() throws Exception
    {
        call(this::namedtuple_print);
    }

    // function: Function(address=134275688, size=32, name='mp_obj_namedtuple_find_field', path='build/py/objnamedtuple.o', has_indirect=False)
    public void mp_obj_namedtuple_find_field() throws Exception
    {
        call(this::mp_obj_namedtuple_find_field);
    }

    // function: Function(address=134275720, size=64, name='namedtuple_attr', path='build/py/objnamedtuple.o', has_indirect=True)
    public void namedtuple_attr() throws Exception
    {
        call(this::namedtuple_attr);
    }

    // function: Function(address=134275784, size=176, name='namedtuple_make_new', path='build/py/objnamedtuple.o', has_indirect=True)
    public void namedtuple_make_new() throws Exception
    {
        call(this::namedtuple_make_new);
    }

    // function: Function(address=134275960, size=56, name='mp_obj_new_namedtuple_base', path='build/py/objnamedtuple.o', has_indirect=False)
    public void mp_obj_new_namedtuple_base() throws Exception
    {
        call(this::mp_obj_new_namedtuple_base);
    }

    // function: Function(address=134276016, size=144, name='new_namedtuple_type', path='build/py/objnamedtuple.o', has_indirect=False)
    public void new_namedtuple_type() throws Exception
    {
        call(this::new_namedtuple_type);
    }

    // function: Function(address=134276160, size=50, name='range_it_iternext', path='build/py/objrange.o', has_indirect=False)
    public void range_it_iternext() throws Exception
    {
        call(this::range_it_iternext);
    }

    // function: Function(address=134276210, size=32, name='range_len', path='build/py/objrange.o', has_indirect=False)
    public void range_len() throws Exception
    {
        call(this::range_len);
    }

    // function: Function(address=134276244, size=52, name='range_unary_op', path='build/py/objrange.o', has_indirect=False)
    public void range_unary_op() throws Exception
    {
        call(this::range_unary_op);
    }

    // function: Function(address=134276296, size=24, name='range_getiter', path='build/py/objrange.o', has_indirect=False)
    public void range_getiter() throws Exception
    {
        call(this::range_getiter);
    }

    // function: Function(address=134276320, size=132, name='range_subscr', path='build/py/objrange.o', has_indirect=False)
    public void range_subscr() throws Exception
    {
        call(this::range_subscr);
    }

    // function: Function(address=134276452, size=104, name='range_make_new', path='build/py/objrange.o', has_indirect=False)
    public void range_make_new() throws Exception
    {
        call(this::range_make_new);
    }

    // function: Function(address=134276556, size=56, name='range_print', path='build/py/objrange.o', has_indirect=False)
    public void range_print() throws Exception
    {
        call(this::range_print);
    }

    // function: Function(address=134276612, size=96, name='range_binary_op', path='build/py/objrange.o', has_indirect=False)
    public void range_binary_op() throws Exception
    {
        call(this::range_binary_op);
    }

    // function: Function(address=134276708, size=52, name='range_attr', path='build/py/objrange.o', has_indirect=False)
    public void range_attr() throws Exception
    {
        call(this::range_attr);
    }

    // function: Function(address=134276760, size=30, name='reversed_iternext', path='build/py/objreversed.o', has_indirect=False)
    public void reversed_iternext() throws Exception
    {
        call(this::reversed_iternext);
    }

    // function: Function(address=134276790, size=84, name='reversed_make_new', path='build/py/objreversed.o', has_indirect=False)
    public void reversed_make_new() throws Exception
    {
        call(this::reversed_make_new);
    }

    // function: Function(address=134276876, size=36, name='is_set_or_frozenset', path='build/py/objset.o', has_indirect=False)
    public void is_set_or_frozenset() throws Exception
    {
        call(this::is_set_or_frozenset);
    }

    // function: Function(address=134276912, size=28, name='set_getiter', path='build/py/objset.o', has_indirect=False)
    public void set_getiter() throws Exception
    {
        call(this::set_getiter);
    }

    // function: Function(address=134276940, size=20, name='text_set_add', path='build/py/objset.o', has_indirect=False)
    public void text_set_add() throws Exception
    {
        call(this::text_set_add);
    }

    // function: Function(address=134276960, size=20, name='set_discard', path='build/py/objset.o', has_indirect=False)
    public void set_discard() throws Exception
    {
        call(this::set_discard);
    }

    // function: Function(address=134276980, size=38, name='set_update_int', path='build/py/objset.o', has_indirect=False)
    public void set_update_int() throws Exception
    {
        call(this::set_update_int);
    }

    // function: Function(address=134277020, size=36, name='set_update', path='build/py/objset.o', has_indirect=False)
    public void set_update() throws Exception
    {
        call(this::set_update);
    }

    // function: Function(address=134277056, size=44, name='set_symmetric_difference_update', path='build/py/objset.o', has_indirect=False)
    public void set_symmetric_difference_update() throws Exception
    {
        call(this::set_symmetric_difference_update);
    }

    // function: Function(address=134277100, size=60, name='set_isdisjoint', path='build/py/objset.o', has_indirect=False)
    public void set_isdisjoint() throws Exception
    {
        call(this::set_isdisjoint);
    }

    // function: Function(address=134277160, size=42, name='set_copy', path='build/py/objset.o', has_indirect=False)
    public void set_copy() throws Exception
    {
        call(this::set_copy);
    }

    // function: Function(address=134277202, size=20, name='set_union', path='build/py/objset.o', has_indirect=False)
    public void set_union() throws Exception
    {
        call(this::set_union);
    }

    // function: Function(address=134277222, size=20, name='set_symmetric_difference', path='build/py/objset.o', has_indirect=False)
    public void set_symmetric_difference() throws Exception
    {
        call(this::set_symmetric_difference);
    }

    // function: Function(address=134277244, size=16, name='set_clear', path='build/py/objset.o', has_indirect=False)
    public void set_clear() throws Exception
    {
        call(this::set_clear);
    }

    // function: Function(address=134277260, size=80, name='set_diff_int', path='build/py/objset.o', has_indirect=False)
    public void set_diff_int() throws Exception
    {
        call(this::set_diff_int);
    }

    // function: Function(address=134277340, size=16, name='set_diff_update', path='build/py/objset.o', has_indirect=False)
    public void set_diff_update() throws Exception
    {
        call(this::set_diff_update);
    }

    // function: Function(address=134277356, size=10, name='set_diff', path='build/py/objset.o', has_indirect=False)
    public void set_diff() throws Exception
    {
        call(this::set_diff);
    }

    // function: Function(address=134277368, size=180, name='set_print', path='build/py/objset.o', has_indirect=False)
    public void set_print() throws Exception
    {
        call(this::set_print);
    }

    // function: Function(address=134277548, size=40, name='set_remove', path='build/py/objset.o', has_indirect=False)
    public void set_remove() throws Exception
    {
        call(this::set_remove);
    }

    // function: Function(address=134277588, size=32, name='text_set_pop', path='build/py/objset.o', has_indirect=False)
    public void text_set_pop() throws Exception
    {
        call(this::text_set_pop);
    }

    // function: Function(address=134277620, size=42, name='set_it_iternext', path='build/py/objset.o', has_indirect=True)
    public void set_it_iternext() throws Exception
    {
        call(this::set_it_iternext);
    }

    // function: Function(address=134277664, size=116, name='set_unary_op', path='build/py/objset.o', has_indirect=False)
    public void set_unary_op() throws Exception
    {
        call(this::set_unary_op);
    }

    // function: Function(address=134277780, size=56, name='mp_obj_new_set', path='build/py/objset.o', has_indirect=False)
    public void mp_obj_new_set() throws Exception
    {
        call(this::mp_obj_new_set);
    }

    // function: Function(address=134277836, size=100, name='set_intersect_int_part_4', path='build/py/objset.o', has_indirect=False)
    public void set_intersect_int_part_4() throws Exception
    {
        call(this::set_intersect_int_part_4);
    }

    // function: Function(address=134277936, size=24, name='set_intersect_update', path='build/py/objset.o', has_indirect=False)
    public void set_intersect_update() throws Exception
    {
        call(this::set_intersect_update);
    }

    // function: Function(address=134277960, size=20, name='set_intersect', path='build/py/objset.o', has_indirect=False)
    public void set_intersect() throws Exception
    {
        call(this::set_intersect);
    }

    // function: Function(address=134277980, size=12, name='mp_obj_set_store', path='build/py/objset.o', has_indirect=False)
    public void mp_obj_set_store() throws Exception
    {
        call(this::mp_obj_set_store);
    }

    // function: Function(address=134277992, size=82, name='set_make_new', path='build/py/objset.o', has_indirect=False)
    public void set_make_new() throws Exception
    {
        call(this::set_make_new);
    }

    // function: Function(address=134278076, size=180, name='set_issubset_internal', path='build/py/objset.o', has_indirect=False)
    public void set_issubset_internal() throws Exception
    {
        call(this::set_issubset_internal);
    }

    // function: Function(address=134278256, size=16, name='set_issuperset', path='build/py/objset.o', has_indirect=False)
    public void set_issuperset() throws Exception
    {
        call(this::set_issuperset);
    }

    // function: Function(address=134278272, size=10, name='set_issubset', path='build/py/objset.o', has_indirect=False)
    public void set_issubset() throws Exception
    {
        call(this::set_issubset);
    }

    // function: Function(address=134278284, size=300, name='set_binary_op', path='build/py/objset.o', has_indirect=False)
    public void set_binary_op() throws Exception
    {
        call(this::set_binary_op);
    }

    // function: Function(address=134278584, size=16, name='singleton_print', path='build/py/objsingleton.o', has_indirect=False)
    public void singleton_print() throws Exception
    {
        call(this::singleton_print);
    }

    // function: Function(address=134278600, size=84, name='slice_print', path='build/py/objslice.o', has_indirect=False)
    public void slice_print() throws Exception
    {
        call(this::slice_print);
    }

    // function: Function(address=134278684, size=44, name='slice_attr', path='build/py/objslice.o', has_indirect=False)
    public void slice_attr() throws Exception
    {
        call(this::slice_attr);
    }

    // function: Function(address=134278728, size=32, name='mp_obj_new_slice', path='build/py/objslice.o', has_indirect=False)
    public void mp_obj_new_slice() throws Exception
    {
        call(this::mp_obj_new_slice);
    }

    // function: Function(address=134278760, size=16, name='mp_obj_slice_get', path='build/py/objslice.o', has_indirect=False)
    public void mp_obj_slice_get() throws Exception
    {
        call(this::mp_obj_slice_get);
    }

    // function: Function(address=134278776, size=56, name='arg_looks_integer', path='build/py/objstr.o', has_indirect=False)
    public void arg_looks_integer() throws Exception
    {
        call(this::arg_looks_integer);
    }

    // function: Function(address=134278832, size=40, name='arg_looks_numeric', path='build/py/objstr.o', has_indirect=False)
    public void arg_looks_numeric() throws Exception
    {
        call(this::arg_looks_numeric);
    }

    // function: Function(address=134278872, size=28, name='mp_obj_new_bytes_iterator', path='build/py/objstr.o', has_indirect=False)
    public void mp_obj_new_bytes_iterator() throws Exception
    {
        call(this::mp_obj_new_bytes_iterator);
    }

    // function: Function(address=134278900, size=56, name='bytes_it_iternext', path='build/py/objstr.o', has_indirect=True)
    public void bytes_it_iternext() throws Exception
    {
        call(this::bytes_it_iternext);
    }

    // function: Function(address=134278956, size=40, name='unlikely_bad_implicit_conversion', path='build/py/objstr.o', has_indirect=False)
    public void unlikely_bad_implicit_conversion() throws Exception
    {
        call(this::unlikely_bad_implicit_conversion);
    }

    // function: Function(address=134278996, size=232, name='str_count', path='build/py/objstr.o', has_indirect=False)
    public void str_count() throws Exception
    {
        call(this::str_count);
    }

    // function: Function(address=134279228, size=132, name='str_uni_istype', path='build/py/objstr.o', has_indirect=False)
    public void str_uni_istype() throws Exception
    {
        call(this::str_uni_istype);
    }

    // function: Function(address=134279360, size=16, name='str_isspace', path='build/py/objstr.o', has_indirect=False)
    public void str_isspace() throws Exception
    {
        call(this::str_isspace);
    }

    // function: Function(address=134279376, size=16, name='str_isalpha', path='build/py/objstr.o', has_indirect=False)
    public void str_isalpha() throws Exception
    {
        call(this::str_isalpha);
    }

    // function: Function(address=134279392, size=16, name='str_isdigit', path='build/py/objstr.o', has_indirect=False)
    public void str_isdigit() throws Exception
    {
        call(this::str_isdigit);
    }

    // function: Function(address=134279408, size=16, name='str_isupper', path='build/py/objstr.o', has_indirect=False)
    public void str_isupper() throws Exception
    {
        call(this::str_isupper);
    }

    // function: Function(address=134279424, size=16, name='str_islower', path='build/py/objstr.o', has_indirect=False)
    public void str_islower() throws Exception
    {
        call(this::str_islower);
    }

    // function: Function(address=134279440, size=48, name='str_to_int', path='build/py/objstr.o', has_indirect=False)
    public void str_to_int() throws Exception
    {
        call(this::str_to_int);
    }

    // function: Function(address=134279488, size=60, name='mp_obj_str_get_buffer', path='build/py/objstr.o', has_indirect=False)
    public void mp_obj_str_get_buffer() throws Exception
    {
        call(this::mp_obj_str_get_buffer);
    }

    // function: Function(address=134279548, size=200, name='mp_str_print_quoted', path='build/py/objstr.o', has_indirect=False)
    public void mp_str_print_quoted() throws Exception
    {
        call(this::mp_str_print_quoted);
    }

    // function: Function(address=134279748, size=116, name='mp_str_print_json', path='build/py/objstr.o', has_indirect=False)
    public void mp_str_print_json() throws Exception
    {
        call(this::mp_str_print_json);
    }

    // function: Function(address=134279864, size=96, name='str_print', path='build/py/objstr.o', has_indirect=False)
    public void str_print() throws Exception
    {
        call(this::str_print);
    }

    // function: Function(address=134279960, size=62, name='find_subbytes', path='build/py/objstr.o', has_indirect=False)
    public void find_subbytes() throws Exception
    {
        call(this::find_subbytes);
    }

    // function: Function(address=134280024, size=248, name='str_finder', path='build/py/objstr.o', has_indirect=False)
    public void str_finder() throws Exception
    {
        call(this::str_finder);
    }

    // function: Function(address=134280272, size=12, name='str_find', path='build/py/objstr.o', has_indirect=False)
    public void str_find() throws Exception
    {
        call(this::str_find);
    }

    // function: Function(address=134280284, size=14, name='str_rfind', path='build/py/objstr.o', has_indirect=False)
    public void str_rfind() throws Exception
    {
        call(this::str_rfind);
    }

    // function: Function(address=134280298, size=12, name='str_index', path='build/py/objstr.o', has_indirect=False)
    public void str_index() throws Exception
    {
        call(this::str_index);
    }

    // function: Function(address=134280310, size=14, name='str_rindex', path='build/py/objstr.o', has_indirect=False)
    public void str_rindex() throws Exception
    {
        call(this::str_rindex);
    }

    // function: Function(address=134280324, size=60, name='mp_obj_new_str_copy', path='build/py/objstr.o', has_indirect=False)
    public void mp_obj_new_str_copy() throws Exception
    {
        call(this::mp_obj_new_str_copy);
    }

    // function: Function(address=134280384, size=14, name='mp_obj_new_str_via_qstr', path='build/py/objstr.o', has_indirect=False)
    public void mp_obj_new_str_via_qstr() throws Exception
    {
        call(this::mp_obj_new_str_via_qstr);
    }

    // function: Function(address=134280400, size=108, name='mp_obj_new_str_from_vstr', path='build/py/objstr.o', has_indirect=False)
    public void mp_obj_new_str_from_vstr() throws Exception
    {
        call(this::mp_obj_new_str_from_vstr);
    }

    // function: Function(address=134280508, size=268, name='str_join', path='build/py/objstr.o', has_indirect=False)
    public void str_join() throws Exception
    {
        call(this::str_join);
    }

    // function: Function(address=134280776, size=106, name='str_center', path='build/py/objstr.o', has_indirect=False)
    public void str_center() throws Exception
    {
        call(this::str_center);
    }

    // function: Function(address=134280882, size=390, name='str_replace', path='build/py/objstr.o', has_indirect=False)
    public void str_replace() throws Exception
    {
        call(this::str_replace);
    }

    // function: Function(address=134281272, size=82, name='str_caseconv', path='build/py/objstr.o', has_indirect=False)
    public void str_caseconv() throws Exception
    {
        call(this::str_caseconv);
    }

    // function: Function(address=134281356, size=16, name='str_lower', path='build/py/objstr.o', has_indirect=False)
    public void str_lower() throws Exception
    {
        call(this::str_lower);
    }

    // function: Function(address=134281372, size=16, name='str_upper', path='build/py/objstr.o', has_indirect=False)
    public void str_upper() throws Exception
    {
        call(this::str_upper);
    }

    // function: Function(address=134281388, size=40, name='mp_obj_new_str', path='build/py/objstr.o', has_indirect=False)
    public void mp_obj_new_str() throws Exception
    {
        call(this::mp_obj_new_str);
    }

    // function: Function(address=134281428, size=204, name='mp_obj_str_make_new', path='build/py/objstr.o', has_indirect=False)
    public void mp_obj_str_make_new() throws Exception
    {
        call(this::mp_obj_str_make_new);
    }

    // function: Function(address=134281632, size=40, name='bytes_decode', path='build/py/objstr.o', has_indirect=False)
    public void bytes_decode() throws Exception
    {
        call(this::bytes_decode);
    }

    // function: Function(address=134281672, size=20, name='mp_obj_new_bytes', path='build/py/objstr.o', has_indirect=False)
    public void mp_obj_new_bytes() throws Exception
    {
        call(this::mp_obj_new_bytes);
    }

    // function: Function(address=134281692, size=280, name='bytes_make_new_part_4', path='build/py/objstr.o', has_indirect=False)
    public void bytes_make_new_part_4() throws Exception
    {
        call(this::bytes_make_new_part_4);
    }

    // function: Function(address=134281972, size=32, name='bytes_make_new', path='build/py/objstr.o', has_indirect=False)
    public void bytes_make_new() throws Exception
    {
        call(this::bytes_make_new);
    }

    // function: Function(address=134282004, size=44, name='str_encode', path='build/py/objstr.o', has_indirect=False)
    public void str_encode() throws Exception
    {
        call(this::str_encode);
    }

    // function: Function(address=134282048, size=32, name='mp_obj_new_str_of_type', path='build/py/objstr.o', has_indirect=False)
    public void mp_obj_new_str_of_type() throws Exception
    {
        call(this::mp_obj_new_str_of_type);
    }

    // function: Function(address=134282080, size=160, name='str_splitlines', path='build/py/objstr.o', has_indirect=False)
    public void str_splitlines() throws Exception
    {
        call(this::str_splitlines);
    }

    // function: Function(address=134282240, size=292, name='str_uni_strip', path='build/py/objstr.o', has_indirect=False)
    public void str_uni_strip() throws Exception
    {
        call(this::str_uni_strip);
    }

    // function: Function(address=134282532, size=14, name='str_strip', path='build/py/objstr.o', has_indirect=False)
    public void str_strip() throws Exception
    {
        call(this::str_strip);
    }

    // function: Function(address=134282546, size=14, name='str_lstrip', path='build/py/objstr.o', has_indirect=False)
    public void str_lstrip() throws Exception
    {
        call(this::str_lstrip);
    }

    // function: Function(address=134282560, size=14, name='str_rstrip', path='build/py/objstr.o', has_indirect=False)
    public void str_rstrip() throws Exception
    {
        call(this::str_rstrip);
    }

    // function: Function(address=134282576, size=204, name='str_partitioner', path='build/py/objstr.o', has_indirect=False)
    public void str_partitioner() throws Exception
    {
        call(this::str_partitioner);
    }

    // function: Function(address=134282780, size=10, name='str_partition', path='build/py/objstr.o', has_indirect=False)
    public void str_partition() throws Exception
    {
        call(this::str_partition);
    }

    // function: Function(address=134282790, size=12, name='str_rpartition', path='build/py/objstr.o', has_indirect=False)
    public void str_rpartition() throws Exception
    {
        call(this::str_rpartition);
    }

    // function: Function(address=134282804, size=132, name='bytes_subscr', path='build/py/objstr.o', has_indirect=False)
    public void bytes_subscr() throws Exception
    {
        call(this::bytes_subscr);
    }

    // function: Function(address=134282936, size=144, name='mp_obj_str_equal', path='build/py/objstr.o', has_indirect=False)
    public void mp_obj_str_equal() throws Exception
    {
        call(this::mp_obj_str_equal);
    }

    // function: Function(address=134283080, size=44, name='mp_obj_str_get_qstr', path='build/py/objstr.o', has_indirect=False)
    public void mp_obj_str_get_qstr() throws Exception
    {
        call(this::mp_obj_str_get_qstr);
    }

    // function: Function(address=134283124, size=48, name='mp_obj_str_get_str', path='build/py/objstr.o', has_indirect=False)
    public void mp_obj_str_get_str() throws Exception
    {
        call(this::mp_obj_str_get_str);
    }

    // function: Function(address=134283172, size=56, name='mp_obj_str_get_data', path='build/py/objstr.o', has_indirect=False)
    public void mp_obj_str_get_data() throws Exception
    {
        call(this::mp_obj_str_get_data);
    }

    // function: Function(address=134283228, size=1348, name='mp_obj_str_binary_op', path='build/py/objstr.o', has_indirect=True)
    public void mp_obj_str_binary_op() throws Exception
    {
        call(this::mp_obj_str_binary_op);
    }

    // function: Function(address=134284576, size=332, name='mp_obj_str_split', path='build/py/objstr.o', has_indirect=False)
    public void mp_obj_str_split() throws Exception
    {
        call(this::mp_obj_str_split);
    }

    // function: Function(address=134284908, size=292, name='str_rsplit', path='build/py/objstr.o', has_indirect=False)
    public void str_rsplit() throws Exception
    {
        call(this::str_rsplit);
    }

    // function: Function(address=134285200, size=116, name='str_startswith', path='build/py/objstr.o', has_indirect=False)
    public void str_startswith() throws Exception
    {
        call(this::str_startswith);
    }

    // function: Function(address=134285316, size=96, name='str_endswith', path='build/py/objstr.o', has_indirect=False)
    public void str_endswith() throws Exception
    {
        call(this::str_endswith);
    }

    // function: Function(address=134285412, size=1368, name='mp_obj_str_format_helper', path='build/py/objstr.o', has_indirect=False)
    public void mp_obj_str_format_helper() throws Exception
    {
        call(this::mp_obj_str_format_helper);
    }

    // function: Function(address=134286780, size=76, name='mp_obj_str_format', path='build/py/objstr.o', has_indirect=False)
    public void mp_obj_str_format() throws Exception
    {
        call(this::mp_obj_str_format);
    }

    // function: Function(address=134286856, size=16, name='mp_obj_str_intern_checked', path='build/py/objstr.o', has_indirect=False)
    public void mp_obj_str_intern_checked() throws Exception
    {
        call(this::mp_obj_str_intern_checked);
    }

    // function: Function(address=134286872, size=28, name='mp_obj_new_str_iterator', path='build/py/objstrunicode.o', has_indirect=False)
    public void mp_obj_new_str_iterator() throws Exception
    {
        call(this::mp_obj_new_str_iterator);
    }

    // function: Function(address=134286900, size=68, name='str_it_iternext', path='build/py/objstrunicode.o', has_indirect=True)
    public void str_it_iternext() throws Exception
    {
        call(this::str_it_iternext);
    }

    // function: Function(address=134286968, size=76, name='uni_unary_op', path='build/py/objstrunicode.o', has_indirect=False)
    public void uni_unary_op() throws Exception
    {
        call(this::uni_unary_op);
    }

    // function: Function(address=134287044, size=288, name='uni_print', path='build/py/objstrunicode.o', has_indirect=False)
    public void uni_print() throws Exception
    {
        call(this::uni_print);
    }

    // function: Function(address=134287332, size=196, name='str_index_to_ptr', path='build/py/objstrunicode.o', has_indirect=False)
    public void str_index_to_ptr() throws Exception
    {
        call(this::str_index_to_ptr);
    }

    // function: Function(address=134287528, size=220, name='str_subscr', path='build/py/objstrunicode.o', has_indirect=False)
    public void str_subscr() throws Exception
    {
        call(this::str_subscr);
    }

    // function: Function(address=134287748, size=10, name='stringio___exit__', path='build/py/objstringio.o', has_indirect=False)
    public void stringio___exit__() throws Exception
    {
        call(this::stringio___exit__);
    }

    // function: Function(address=134287760, size=36, name='stringio_print', path='build/py/objstringio.o', has_indirect=False)
    public void stringio_print() throws Exception
    {
        call(this::stringio_print);
    }

    // function: Function(address=134287796, size=164, name='stringio_write', path='build/py/objstringio.o', has_indirect=False)
    public void stringio_write() throws Exception
    {
        call(this::stringio_write);
    }

    // function: Function(address=134287960, size=164, name='stringio_make_new', path='build/py/objstringio.o', has_indirect=False)
    public void stringio_make_new() throws Exception
    {
        call(this::stringio_make_new);
    }

    // function: Function(address=134288124, size=94, name='stringio_ioctl', path='build/py/objstringio.o', has_indirect=False)
    public void stringio_ioctl() throws Exception
    {
        call(this::stringio_ioctl);
    }

    // function: Function(address=134288220, size=52, name='stringio_getvalue', path='build/py/objstringio.o', has_indirect=False)
    public void stringio_getvalue() throws Exception
    {
        call(this::stringio_getvalue);
    }

    // function: Function(address=134288272, size=60, name='stringio_read', path='build/py/objstringio.o', has_indirect=False)
    public void stringio_read() throws Exception
    {
        call(this::stringio_read);
    }

    // function: Function(address=134288332, size=28, name='tuple_it_iternext', path='build/py/objtuple.o', has_indirect=True)
    public void tuple_it_iternext() throws Exception
    {
        call(this::tuple_it_iternext);
    }

    // function: Function(address=134288360, size=28, name='mp_obj_tuple_getiter', path='build/py/objtuple.o', has_indirect=True)
    public void mp_obj_tuple_getiter() throws Exception
    {
        call(this::mp_obj_tuple_getiter);
    }

    // function: Function(address=134288388, size=120, name='mp_obj_tuple_print', path='build/py/objtuple.o', has_indirect=False)
    public void mp_obj_tuple_print() throws Exception
    {
        call(this::mp_obj_tuple_print);
    }

    // function: Function(address=134288508, size=20, name='tuple_index', path='build/py/objtuple.o', has_indirect=False)
    public void tuple_index() throws Exception
    {
        call(this::tuple_index);
    }

    // function: Function(address=134288528, size=16, name='tuple_count', path='build/py/objtuple.o', has_indirect=False)
    public void tuple_count() throws Exception
    {
        call(this::tuple_count);
    }

    // function: Function(address=134288544, size=92, name='mp_obj_tuple_unary_op', path='build/py/objtuple.o', has_indirect=True)
    public void mp_obj_tuple_unary_op() throws Exception
    {
        call(this::mp_obj_tuple_unary_op);
    }

    // function: Function(address=134288636, size=60, name='mp_obj_new_tuple', path='build/py/objtuple.o', has_indirect=False)
    public void mp_obj_new_tuple() throws Exception
    {
        call(this::mp_obj_new_tuple);
    }

    // function: Function(address=134288696, size=256, name='mp_obj_tuple_binary_op', path='build/py/objtuple.o', has_indirect=True)
    public void mp_obj_tuple_binary_op() throws Exception
    {
        call(this::mp_obj_tuple_binary_op);
    }

    // function: Function(address=134288952, size=116, name='mp_obj_tuple_subscr', path='build/py/objtuple.o', has_indirect=True)
    public void mp_obj_tuple_subscr() throws Exception
    {
        call(this::mp_obj_tuple_subscr);
    }

    // function: Function(address=134289068, size=140, name='mp_obj_tuple_make_new', path='build/py/objtuple.o', has_indirect=False)
    public void mp_obj_tuple_make_new() throws Exception
    {
        call(this::mp_obj_tuple_make_new);
    }

    // function: Function(address=134289208, size=10, name='mp_obj_tuple_get', path='build/py/objtuple.o', has_indirect=False)
    public void mp_obj_tuple_get() throws Exception
    {
        call(this::mp_obj_tuple_get);
    }

    // function: Function(address=134289218, size=14, name='mp_obj_tuple_del', path='build/py/objtuple.o', has_indirect=False)
    public void mp_obj_tuple_del() throws Exception
    {
        call(this::mp_obj_tuple_del);
    }

    // function: Function(address=134289232, size=88, name='instance_count_native_bases', path='build/py/objtype.o', has_indirect=False)
    public void instance_count_native_bases() throws Exception
    {
        call(this::instance_count_native_bases);
    }

    // function: Function(address=134289320, size=44, name='native_base_init_wrapper', path='build/py/objtype.o', has_indirect=False)
    public void native_base_init_wrapper() throws Exception
    {
        call(this::native_base_init_wrapper);
    }

    // function: Function(address=134289364, size=240, name='mp_obj_class_lookup', path='build/py/objtype.o', has_indirect=False)
    public void mp_obj_class_lookup() throws Exception
    {
        call(this::mp_obj_class_lookup);
    }

    // function: Function(address=134289604, size=160, name='super_attr', path='build/py/objtype.o', has_indirect=False)
    public void super_attr() throws Exception
    {
        call(this::super_attr);
    }

    // function: Function(address=134289764, size=36, name='static_class_method_make_new', path='build/py/objtype.o', has_indirect=False)
    public void static_class_method_make_new() throws Exception
    {
        call(this::static_class_method_make_new);
    }

    // function: Function(address=134289800, size=64, name='super_make_new', path='build/py/objtype.o', has_indirect=False)
    public void super_make_new() throws Exception
    {
        call(this::super_make_new);
    }

    // function: Function(address=134289864, size=16, name='type_print', path='build/py/objtype.o', has_indirect=False)
    public void type_print() throws Exception
    {
        call(this::type_print);
    }

    // function: Function(address=134289880, size=128, name='instance_subscr', path='build/py/objtype.o', has_indirect=True)
    public void instance_subscr() throws Exception
    {
        call(this::instance_subscr);
    }

    // function: Function(address=134290008, size=116, name='instance_binary_op', path='build/py/objtype.o', has_indirect=True)
    public void instance_binary_op() throws Exception
    {
        call(this::instance_binary_op);
    }

    // function: Function(address=134290124, size=160, name='instance_unary_op', path='build/py/objtype.o', has_indirect=True)
    public void instance_unary_op() throws Exception
    {
        call(this::instance_unary_op);
    }

    // function: Function(address=134290284, size=188, name='instance_print', path='build/py/objtype.o', has_indirect=True)
    public void instance_print() throws Exception
    {
        call(this::instance_print);
    }

    // function: Function(address=134290472, size=64, name='super_print', path='build/py/objtype.o', has_indirect=False)
    public void super_print() throws Exception
    {
        call(this::super_print);
    }

    // function: Function(address=134290536, size=560, name='mp_obj_instance_attr', path='build/py/objtype.o', has_indirect=True)
    public void mp_obj_instance_attr() throws Exception
    {
        call(this::mp_obj_instance_attr);
    }

    // function: Function(address=134291096, size=36, name='type_call', path='build/py/objtype.o', has_indirect=False)
    public void type_call() throws Exception
    {
        call(this::type_call);
    }

    // function: Function(address=134291132, size=74, name='instance_get_buffer', path='build/py/objtype.o', has_indirect=True)
    public void instance_get_buffer() throws Exception
    {
        call(this::instance_get_buffer);
    }

    // function: Function(address=134291206, size=86, name='instance_getiter', path='build/py/objtype.o', has_indirect=True)
    public void instance_getiter() throws Exception
    {
        call(this::instance_getiter);
    }

    // function: Function(address=134291292, size=80, name='check_for_special_accessors', path='build/py/objtype.o', has_indirect=False)
    public void check_for_special_accessors() throws Exception
    {
        call(this::check_for_special_accessors);
    }

    // function: Function(address=134291372, size=164, name='type_attr', path='build/py/objtype.o', has_indirect=False)
    public void type_attr() throws Exception
    {
        call(this::type_attr);
    }

    // function: Function(address=134291536, size=112, name='mp_obj_instance_call', path='build/py/objtype.o', has_indirect=True)
    public void mp_obj_instance_call() throws Exception
    {
        call(this::mp_obj_instance_call);
    }

    // function: Function(address=134291648, size=44, name='mp_obj_new_instance', path='build/py/objtype.o', has_indirect=False)
    public void mp_obj_new_instance() throws Exception
    {
        call(this::mp_obj_new_instance);
    }

    // function: Function(address=134291692, size=348, name='mp_obj_instance_make_new', path='build/py/objtype.o', has_indirect=True)
    public void mp_obj_instance_make_new() throws Exception
    {
        call(this::mp_obj_instance_make_new);
    }

    // function: Function(address=134292040, size=48, name='mp_obj_instance_is_callable', path='build/py/objtype.o', has_indirect=False)
    public void mp_obj_instance_is_callable() throws Exception
    {
        call(this::mp_obj_instance_is_callable);
    }

    // function: Function(address=134292088, size=404, name='mp_obj_new_type', path='build/py/objtype.o', has_indirect=False)
    public void mp_obj_new_type() throws Exception
    {
        call(this::mp_obj_new_type);
    }

    // function: Function(address=134292492, size=64, name='type_make_new', path='build/py/objtype.o', has_indirect=False)
    public void type_make_new() throws Exception
    {
        call(this::type_make_new);
    }

    // function: Function(address=134292556, size=32, name='mp_load_super_method', path='build/py/objtype.o', has_indirect=False)
    public void mp_load_super_method() throws Exception
    {
        call(this::mp_load_super_method);
    }

    // function: Function(address=134292588, size=96, name='mp_obj_is_subclass_fast', path='build/py/objtype.o', has_indirect=False)
    public void mp_obj_is_subclass_fast() throws Exception
    {
        call(this::mp_obj_is_subclass_fast);
    }

    // function: Function(address=134292684, size=120, name='mp_obj_is_subclass', path='build/py/objtype.o', has_indirect=False)
    public void mp_obj_is_subclass() throws Exception
    {
        call(this::mp_obj_is_subclass);
    }

    // function: Function(address=134292804, size=36, name='mp_builtin_issubclass', path='build/py/objtype.o', has_indirect=False)
    public void mp_builtin_issubclass() throws Exception
    {
        call(this::mp_builtin_issubclass);
    }

    // function: Function(address=134292840, size=16, name='mp_builtin_isinstance', path='build/py/objtype.o', has_indirect=False)
    public void mp_builtin_isinstance() throws Exception
    {
        call(this::mp_builtin_isinstance);
    }

    // function: Function(address=134292856, size=26, name='mp_instance_cast_to_native_base', path='build/py/objtype.o', has_indirect=False)
    public void mp_instance_cast_to_native_base() throws Exception
    {
        call(this::mp_instance_cast_to_native_base);
    }

    // function: Function(address=134292882, size=64, name='zip_iternext', path='build/py/objzip.o', has_indirect=False)
    public void zip_iternext() throws Exception
    {
        call(this::zip_iternext);
    }

    // function: Function(address=134292948, size=76, name='zip_make_new', path='build/py/objzip.o', has_indirect=False)
    public void zip_make_new() throws Exception
    {
        call(this::zip_make_new);
    }

    // function: Function(address=134293024, size=22, name='op_getitem', path='build/py/opmethods.o', has_indirect=False)
    public void op_getitem() throws Exception
    {
        call(this::op_getitem);
    }

    // function: Function(address=134293046, size=24, name='op_setitem', path='build/py/opmethods.o', has_indirect=False)
    public void op_setitem() throws Exception
    {
        call(this::op_setitem);
    }

    // function: Function(address=134293070, size=22, name='op_delitem', path='build/py/opmethods.o', has_indirect=False)
    public void op_delitem() throws Exception
    {
        call(this::op_delitem);
    }

    // function: Function(address=134293092, size=22, name='op_contains', path='build/py/opmethods.o', has_indirect=False)
    public void op_contains() throws Exception
    {
        call(this::op_contains);
    }

    // function: Function(address=134293114, size=38, name='mp_seq_multiply', path='build/py/sequence.o', has_indirect=False)
    public void mp_seq_multiply() throws Exception
    {
        call(this::mp_seq_multiply);
    }

    // function: Function(address=134293152, size=248, name='mp_seq_get_fast_slice_indexes', path='build/py/sequence.o', has_indirect=False)
    public void mp_seq_get_fast_slice_indexes() throws Exception
    {
        call(this::mp_seq_get_fast_slice_indexes);
    }

    // function: Function(address=134293400, size=70, name='mp_seq_extract_slice', path='build/py/sequence.o', has_indirect=False)
    public void mp_seq_extract_slice() throws Exception
    {
        call(this::mp_seq_extract_slice);
    }

    // function: Function(address=134293470, size=108, name='mp_seq_cmp_bytes', path='build/py/sequence.o', has_indirect=False)
    public void mp_seq_cmp_bytes() throws Exception
    {
        call(this::mp_seq_cmp_bytes);
    }

    // function: Function(address=134293580, size=152, name='mp_seq_cmp_objs', path='build/py/sequence.o', has_indirect=False)
    public void mp_seq_cmp_objs() throws Exception
    {
        call(this::mp_seq_cmp_objs);
    }

    // function: Function(address=134293732, size=104, name='mp_seq_index_obj', path='build/py/sequence.o', has_indirect=False)
    public void mp_seq_index_obj() throws Exception
    {
        call(this::mp_seq_index_obj);
    }

    // function: Function(address=134293836, size=40, name='mp_seq_count_obj', path='build/py/sequence.o', has_indirect=False)
    public void mp_seq_count_obj() throws Exception
    {
        call(this::mp_seq_count_obj);
    }

    // function: Function(address=134293876, size=36, name='mp_stream_close', path='build/py/stream.o', has_indirect=False)
    public void mp_stream_close() throws Exception
    {
        call(this::mp_stream_close);
    }

    // function: Function(address=134293912, size=36, name='stream_flush', path='build/py/stream.o', has_indirect=False)
    public void stream_flush() throws Exception
    {
        call(this::stream_flush);
    }

    // function: Function(address=134293948, size=140, name='stream_unbuffered_readline', path='build/py/stream.o', has_indirect=False)
    public void stream_unbuffered_readline() throws Exception
    {
        call(this::stream_unbuffered_readline);
    }

    // function: Function(address=134294088, size=46, name='stream_unbuffered_readlines', path='build/py/stream.o', has_indirect=False)
    public void stream_unbuffered_readlines() throws Exception
    {
        call(this::stream_unbuffered_readlines);
    }

    // function: Function(address=134294134, size=84, name='stream_seek', path='build/py/stream.o', has_indirect=False)
    public void stream_seek() throws Exception
    {
        call(this::stream_seek);
    }

    // function: Function(address=134294218, size=22, name='stream_tell', path='build/py/stream.o', has_indirect=False)
    public void stream_tell() throws Exception
    {
        call(this::stream_tell);
    }

    // function: Function(address=134294240, size=92, name='mp_stream_rw', path='build/py/stream.o', has_indirect=False)
    public void mp_stream_rw() throws Exception
    {
        call(this::mp_stream_rw);
    }

    // function: Function(address=134294332, size=384, name='stream_read_generic', path='build/py/stream.o', has_indirect=False)
    public void stream_read_generic() throws Exception
    {
        call(this::stream_read_generic);
    }

    // function: Function(address=134294716, size=10, name='stream_read', path='build/py/stream.o', has_indirect=False)
    public void stream_read() throws Exception
    {
        call(this::stream_read);
    }

    // function: Function(address=134294726, size=74, name='stream_readinto', path='build/py/stream.o', has_indirect=False)
    public void stream_readinto() throws Exception
    {
        call(this::stream_readinto);
    }

    // function: Function(address=134294800, size=64, name='mp_get_stream_raise', path='build/py/stream.o', has_indirect=False)
    public void mp_get_stream_raise() throws Exception
    {
        call(this::mp_get_stream_raise);
    }

    // function: Function(address=134294864, size=32, name='mp_stream_write', path='build/py/stream.o', has_indirect=False)
    public void mp_stream_write() throws Exception
    {
        call(this::mp_stream_write);
    }

    // function: Function(address=134294896, size=96, name='stream_write_method', path='build/py/stream.o', has_indirect=False)
    public void stream_write_method() throws Exception
    {
        call(this::stream_write_method);
    }

    // function: Function(address=134294992, size=10, name='mp_stream_write_adaptor', path='build/py/stream.o', has_indirect=True)
    public void mp_stream_write_adaptor() throws Exception
    {
        call(this::mp_stream_write_adaptor);
    }

    // function: Function(address=134295002, size=30, name='mp_stream_unbuffered_iter', path='build/py/stream.o', has_indirect=False)
    public void mp_stream_unbuffered_iter() throws Exception
    {
        call(this::mp_stream_unbuffered_iter);
    }

    // function: Function(address=134295032, size=208, name='mp_binary_get_size', path='build/py/binary.o', has_indirect=False)
    public void mp_binary_get_size() throws Exception
    {
        call(this::mp_binary_get_size);
    }

    // function: Function(address=134295240, size=174, name='mp_binary_get_val_array', path='build/py/binary.o', has_indirect=False)
    public void mp_binary_get_val_array() throws Exception
    {
        call(this::mp_binary_get_val_array);
    }

    // function: Function(address=134295414, size=82, name='mp_binary_get_int', path='build/py/binary.o', has_indirect=False)
    public void mp_binary_get_int() throws Exception
    {
        call(this::mp_binary_get_int);
    }

    // function: Function(address=134295496, size=168, name='mp_binary_get_val', path='build/py/binary.o', has_indirect=False)
    public void mp_binary_get_val() throws Exception
    {
        call(this::mp_binary_get_val);
    }

    // function: Function(address=134295664, size=38, name='mp_binary_set_int', path='build/py/binary.o', has_indirect=False)
    public void mp_binary_set_int() throws Exception
    {
        call(this::mp_binary_set_int);
    }

    // function: Function(address=134295704, size=236, name='mp_binary_set_val', path='build/py/binary.o', has_indirect=False)
    public void mp_binary_set_val() throws Exception
    {
        call(this::mp_binary_set_val);
    }

    // function: Function(address=134295940, size=126, name='mp_binary_set_val_array_from_int', path='build/py/binary.o', has_indirect=False)
    public void mp_binary_set_val_array_from_int() throws Exception
    {
        call(this::mp_binary_set_val_array_from_int);
    }

    // function: Function(address=134296068, size=132, name='mp_binary_set_val_array', path='build/py/binary.o', has_indirect=False)
    public void mp_binary_set_val_array() throws Exception
    {
        call(this::mp_binary_set_val_array);
    }

    // function: Function(address=134296200, size=20, name='mp_import_stat_any', path='build/py/builtinimport.o', has_indirect=False)
    public void mp_import_stat_any() throws Exception
    {
        call(this::mp_import_stat_any);
    }

    // function: Function(address=134296220, size=80, name='do_execute_raw_code', path='build/py/builtinimport.o', has_indirect=False)
    public void do_execute_raw_code() throws Exception
    {
        call(this::do_execute_raw_code);
    }

    // function: Function(address=134296300, size=34, name='do_load_from_lexer', path='build/py/builtinimport.o', has_indirect=False)
    public void do_load_from_lexer() throws Exception
    {
        call(this::do_load_from_lexer);
    }

    // function: Function(address=134296334, size=76, name='text_do_load', path='build/py/builtinimport.o', has_indirect=False)
    public void text_do_load() throws Exception
    {
        call(this::text_do_load);
    }

    // function: Function(address=134296410, size=50, name='stat_file_py_or_mpy', path='build/py/builtinimport.o', has_indirect=False)
    public void stat_file_py_or_mpy() throws Exception
    {
        call(this::stat_file_py_or_mpy);
    }

    // function: Function(address=134296460, size=36, name='stat_dir_or_file', path='build/py/builtinimport.o', has_indirect=False)
    public void stat_dir_or_file() throws Exception
    {
        call(this::stat_dir_or_file);
    }

    // function: Function(address=134296496, size=772, name='mp_builtin___import__', path='build/py/builtinimport.o', has_indirect=False)
    public void mp_builtin___import__() throws Exception
    {
        call(this::mp_builtin___import__);
    }

    // function: Function(address=134297268, size=20, name='mp_obj_is_package', path='build/py/builtinimport.o', has_indirect=False)
    public void mp_obj_is_package() throws Exception
    {
        call(this::mp_obj_is_package);
    }

    // function: Function(address=134297288, size=116, name='mp_builtin_compile', path='build/py/builtinevex.o', has_indirect=False)
    public void mp_builtin_compile() throws Exception
    {
        call(this::mp_builtin_compile);
    }

    // function: Function(address=134297404, size=240, name='eval_exec_helper', path='build/py/builtinevex.o', has_indirect=False)
    public void eval_exec_helper() throws Exception
    {
        call(this::eval_exec_helper);
    }

    // function: Function(address=134297644, size=10, name='mp_builtin_eval', path='build/py/builtinevex.o', has_indirect=False)
    public void mp_builtin_eval() throws Exception
    {
        call(this::mp_builtin_eval);
    }

    // function: Function(address=134297654, size=10, name='mp_builtin_exec', path='build/py/builtinevex.o', has_indirect=False)
    public void mp_builtin_exec() throws Exception
    {
        call(this::mp_builtin_exec);
    }

    // function: Function(address=134297664, size=10, name='mp_builtin_execfile', path='build/py/builtinevex.o', has_indirect=False)
    public void mp_builtin_execfile() throws Exception
    {
        call(this::mp_builtin_execfile);
    }

    // function: Function(address=134297674, size=44, name='mp_help_add_from_names', path='build/py/builtinhelp.o', has_indirect=False)
    public void mp_help_add_from_names() throws Exception
    {
        call(this::mp_help_add_from_names);
    }

    // function: Function(address=134297718, size=40, name='mp_help_add_from_map', path='build/py/builtinhelp.o', has_indirect=False)
    public void mp_help_add_from_map() throws Exception
    {
        call(this::mp_help_add_from_map);
    }

    // function: Function(address=134297760, size=412, name='mp_builtin_help', path='build/py/builtinhelp.o', has_indirect=False)
    public void mp_builtin_help() throws Exception
    {
        call(this::mp_builtin_help);
    }

    // function: Function(address=134298172, size=12, name='mp_builtin_globals', path='build/py/modbuiltins.o', has_indirect=False)
    public void mp_builtin_globals() throws Exception
    {
        call(this::mp_builtin_globals);
    }

    // function: Function(address=134298184, size=12, name='mp_builtin_locals', path='build/py/modbuiltins.o', has_indirect=False)
    public void mp_builtin_locals() throws Exception
    {
        call(this::mp_builtin_locals);
    }

    // function: Function(address=134298196, size=116, name='mp_builtin___build_class__', path='build/py/modbuiltins.o', has_indirect=False)
    public void mp_builtin___build_class__() throws Exception
    {
        call(this::mp_builtin___build_class__);
    }

    // function: Function(address=134298312, size=12, name='mp_builtin_abs', path='build/py/modbuiltins.o', has_indirect=False)
    public void mp_builtin_abs() throws Exception
    {
        call(this::mp_builtin_abs);
    }

    // function: Function(address=134298324, size=12, name='mp_builtin_hash', path='build/py/modbuiltins.o', has_indirect=False)
    public void mp_builtin_hash() throws Exception
    {
        call(this::mp_builtin_hash);
    }

    // function: Function(address=134298336, size=10, name='mp_builtin_iter', path='build/py/modbuiltins.o', has_indirect=False)
    public void mp_builtin_iter() throws Exception
    {
        call(this::mp_builtin_iter);
    }

    // function: Function(address=134298348, size=48, name='mp_builtin_all', path='build/py/modbuiltins.o', has_indirect=False)
    public void mp_builtin_all() throws Exception
    {
        call(this::mp_builtin_all);
    }

    // function: Function(address=134298396, size=48, name='mp_builtin_any', path='build/py/modbuiltins.o', has_indirect=False)
    public void mp_builtin_any() throws Exception
    {
        call(this::mp_builtin_any);
    }

    // function: Function(address=134298444, size=22, name='mp_builtin_bin', path='build/py/modbuiltins.o', has_indirect=False)
    public void mp_builtin_bin() throws Exception
    {
        call(this::mp_builtin_bin);
    }

    // function: Function(address=134298468, size=28, name='mp_builtin_callable', path='build/py/modbuiltins.o', has_indirect=False)
    public void mp_builtin_callable() throws Exception
    {
        call(this::mp_builtin_callable);
    }

    // function: Function(address=134298496, size=160, name='mp_builtin_chr', path='build/py/modbuiltins.o', has_indirect=False)
    public void mp_builtin_chr() throws Exception
    {
        call(this::mp_builtin_chr);
    }

    // function: Function(address=134298656, size=14, name='mp_builtin_divmod', path='build/py/modbuiltins.o', has_indirect=False)
    public void mp_builtin_divmod() throws Exception
    {
        call(this::mp_builtin_divmod);
    }

    // function: Function(address=134298670, size=16, name='mp_builtin_hex', path='build/py/modbuiltins.o', has_indirect=False)
    public void mp_builtin_hex() throws Exception
    {
        call(this::mp_builtin_hex);
    }

    // function: Function(address=134298686, size=16, name='mp_builtin_oct', path='build/py/modbuiltins.o', has_indirect=False)
    public void mp_builtin_oct() throws Exception
    {
        call(this::mp_builtin_oct);
    }

    // function: Function(address=134298702, size=52, name='mp_builtin_sum', path='build/py/modbuiltins.o', has_indirect=False)
    public void mp_builtin_sum() throws Exception
    {
        call(this::mp_builtin_sum);
    }

    // function: Function(address=134298756, size=224, name='mp_builtin_min_max', path='build/py/modbuiltins.o', has_indirect=False)
    public void mp_builtin_min_max() throws Exception
    {
        call(this::mp_builtin_min_max);
    }

    // function: Function(address=134298980, size=10, name='mp_builtin_max', path='build/py/modbuiltins.o', has_indirect=False)
    public void mp_builtin_max() throws Exception
    {
        call(this::mp_builtin_max);
    }

    // function: Function(address=134298990, size=10, name='mp_builtin_min', path='build/py/modbuiltins.o', has_indirect=False)
    public void mp_builtin_min() throws Exception
    {
        call(this::mp_builtin_min);
    }

    // function: Function(address=134299000, size=100, name='mp_builtin_ord', path='build/py/modbuiltins.o', has_indirect=False)
    public void mp_builtin_ord() throws Exception
    {
        call(this::mp_builtin_ord);
    }

    // function: Function(address=134299100, size=132, name='mp_builtin_print', path='build/py/modbuiltins.o', has_indirect=False)
    public void mp_builtin_print() throws Exception
    {
        call(this::mp_builtin_print);
    }

    // function: Function(address=134299232, size=44, name='mp_builtin_repr', path='build/py/modbuiltins.o', has_indirect=False)
    public void mp_builtin_repr() throws Exception
    {
        call(this::mp_builtin_repr);
    }

    // function: Function(address=134299276, size=108, name='mp_builtin_round', path='build/py/modbuiltins.o', has_indirect=False)
    public void mp_builtin_round() throws Exception
    {
        call(this::mp_builtin_round);
    }

    // function: Function(address=134299384, size=60, name='mp_builtin_sorted', path='build/py/modbuiltins.o', has_indirect=False)
    public void mp_builtin_sorted() throws Exception
    {
        call(this::mp_builtin_sorted);
    }

    // function: Function(address=134299444, size=44, name='mp_builtin_hasattr', path='build/py/modbuiltins.o', has_indirect=False)
    public void mp_builtin_hasattr() throws Exception
    {
        call(this::mp_builtin_hasattr);
    }

    // function: Function(address=134299488, size=68, name='mp_builtin_getattr', path='build/py/modbuiltins.o', has_indirect=False)
    public void mp_builtin_getattr() throws Exception
    {
        call(this::mp_builtin_getattr);
    }

    // function: Function(address=134299556, size=32, name='mp_builtin_setattr', path='build/py/modbuiltins.o', has_indirect=False)
    public void mp_builtin_setattr() throws Exception
    {
        call(this::mp_builtin_setattr);
    }

    // function: Function(address=134299588, size=10, name='mp_builtin_delattr', path='build/py/modbuiltins.o', has_indirect=False)
    public void mp_builtin_delattr() throws Exception
    {
        call(this::mp_builtin_delattr);
    }

    // function: Function(address=134299600, size=144, name='mp_builtin_dir', path='build/py/modbuiltins.o', has_indirect=False)
    public void mp_builtin_dir() throws Exception
    {
        call(this::mp_builtin_dir);
    }

    // function: Function(address=134299744, size=28, name='mp_builtin_next', path='build/py/modbuiltins.o', has_indirect=False)
    public void mp_builtin_next() throws Exception
    {
        call(this::mp_builtin_next);
    }

    // function: Function(address=134299772, size=34, name='mp_builtin_pow', path='build/py/modbuiltins.o', has_indirect=False)
    public void mp_builtin_pow() throws Exception
    {
        call(this::mp_builtin_pow);
    }

    // function: Function(address=134299808, size=76, name='mp_builtin___repl_print__', path='build/py/modbuiltins.o', has_indirect=False)
    public void mp_builtin___repl_print__() throws Exception
    {
        call(this::mp_builtin___repl_print__);
    }

    // function: Function(address=134299884, size=24, name='gc_disable', path='build/py/modgc.o', has_indirect=False)
    public void gc_disable() throws Exception
    {
        call(this::gc_disable);
    }

    // function: Function(address=134299908, size=24, name='gc_enable', path='build/py/modgc.o', has_indirect=False)
    public void gc_enable() throws Exception
    {
        call(this::gc_enable);
    }

    // function: Function(address=134299932, size=32, name='gc_isenabled', path='build/py/modgc.o', has_indirect=False)
    public void gc_isenabled() throws Exception
    {
        call(this::gc_isenabled);
    }

    // function: Function(address=134299964, size=28, name='py_gc_collect', path='build/py/modgc.o', has_indirect=False)
    public void py_gc_collect() throws Exception
    {
        call(this::py_gc_collect);
    }

    // function: Function(address=134299992, size=22, name='gc_mem_free', path='build/py/modgc.o', has_indirect=False)
    public void gc_mem_free() throws Exception
    {
        call(this::gc_mem_free);
    }

    // function: Function(address=134300014, size=22, name='gc_mem_alloc', path='build/py/modgc.o', has_indirect=False)
    public void gc_mem_alloc() throws Exception
    {
        call(this::gc_mem_alloc);
    }

    // function: Function(address=134300036, size=60, name='gc_threshold', path='build/py/modgc.o', has_indirect=False)
    public void gc_threshold() throws Exception
    {
        call(this::gc_threshold);
    }

    // function: Function(address=134300096, size=224, name='resource_stream', path='build/py/modio.o', has_indirect=False)
    public void resource_stream() throws Exception
    {
        call(this::resource_stream);
    }

    // function: Function(address=134300320, size=6, name='fabs_funcf', path='build/py/modmath.o', has_indirect=True)
    public void fabs_funcf() throws Exception
    {
        call(this::fabs_funcf);
    }

    // function: Function(address=134300328, size=20, name='log2f', path='build/py/modmath.o', has_indirect=True)
    public void log2f() throws Exception
    {
        call(this::log2f);
    }

    // function: Function(address=134300348, size=32, name='mp_math_isnan', path='build/py/modmath.o', has_indirect=False)
    public void mp_math_isnan() throws Exception
    {
        call(this::mp_math_isnan);
    }

    // function: Function(address=134300380, size=56, name='mp_math_isfinite', path='build/py/modmath.o', has_indirect=False)
    public void mp_math_isfinite() throws Exception
    {
        call(this::mp_math_isfinite);
    }

    // function: Function(address=134300436, size=56, name='mp_math_isinf', path='build/py/modmath.o', has_indirect=False)
    public void mp_math_isinf() throws Exception
    {
        call(this::mp_math_isinf);
    }

    // function: Function(address=134300492, size=24, name='mp_math_degrees', path='build/py/modmath.o', has_indirect=False)
    public void mp_math_degrees() throws Exception
    {
        call(this::mp_math_degrees);
    }

    // function: Function(address=134300516, size=24, name='mp_math_radians', path='build/py/modmath.o', has_indirect=False)
    public void mp_math_radians() throws Exception
    {
        call(this::mp_math_radians);
    }

    // function: Function(address=134300540, size=16, name='mp_math_trunc', path='build/py/modmath.o', has_indirect=False)
    public void mp_math_trunc() throws Exception
    {
        call(this::mp_math_trunc);
    }

    // function: Function(address=134300556, size=42, name='mp_math_modf', path='build/py/modmath.o', has_indirect=False)
    public void mp_math_modf() throws Exception
    {
        call(this::mp_math_modf);
    }

    // function: Function(address=134300598, size=30, name='mp_math_ldexp', path='build/py/modmath.o', has_indirect=False)
    public void mp_math_ldexp() throws Exception
    {
        call(this::mp_math_ldexp);
    }

    // function: Function(address=134300628, size=42, name='mp_math_frexp', path='build/py/modmath.o', has_indirect=False)
    public void mp_math_frexp() throws Exception
    {
        call(this::mp_math_frexp);
    }

    // function: Function(address=134300670, size=16, name='mp_math_floor', path='build/py/modmath.o', has_indirect=False)
    public void mp_math_floor() throws Exception
    {
        call(this::mp_math_floor);
    }

    // function: Function(address=134300686, size=12, name='copysign_funcf', path='build/py/modmath.o', has_indirect=True)
    public void copysign_funcf() throws Exception
    {
        call(this::copysign_funcf);
    }

    // function: Function(address=134300698, size=16, name='mp_math_ceil', path='build/py/modmath.o', has_indirect=False)
    public void mp_math_ceil() throws Exception
    {
        call(this::mp_math_ceil);
    }

    // function: Function(address=134300716, size=116, name='math_generic_1', path='build/py/modmath.o', has_indirect=False)
    public void math_generic_1() throws Exception
    {
        call(this::math_generic_1);
    }

    // function: Function(address=134300832, size=16, name='mp_math_lgamma', path='build/py/modmath.o', has_indirect=False)
    public void mp_math_lgamma() throws Exception
    {
        call(this::mp_math_lgamma);
    }

    // function: Function(address=134300848, size=16, name='mp_math_gamma', path='build/py/modmath.o', has_indirect=False)
    public void mp_math_gamma() throws Exception
    {
        call(this::mp_math_gamma);
    }

    // function: Function(address=134300864, size=16, name='mp_math_erfc', path='build/py/modmath.o', has_indirect=False)
    public void mp_math_erfc() throws Exception
    {
        call(this::mp_math_erfc);
    }

    // function: Function(address=134300880, size=16, name='mp_math_erf', path='build/py/modmath.o', has_indirect=False)
    public void mp_math_erf() throws Exception
    {
        call(this::mp_math_erf);
    }

    // function: Function(address=134300896, size=16, name='mp_math_fabs', path='build/py/modmath.o', has_indirect=False)
    public void mp_math_fabs() throws Exception
    {
        call(this::mp_math_fabs);
    }

    // function: Function(address=134300912, size=16, name='mp_math_atan', path='build/py/modmath.o', has_indirect=False)
    public void mp_math_atan() throws Exception
    {
        call(this::mp_math_atan);
    }

    // function: Function(address=134300928, size=16, name='mp_math_asin', path='build/py/modmath.o', has_indirect=False)
    public void mp_math_asin() throws Exception
    {
        call(this::mp_math_asin);
    }

    // function: Function(address=134300944, size=16, name='mp_math_acos', path='build/py/modmath.o', has_indirect=False)
    public void mp_math_acos() throws Exception
    {
        call(this::mp_math_acos);
    }

    // function: Function(address=134300960, size=16, name='mp_math_tan', path='build/py/modmath.o', has_indirect=False)
    public void mp_math_tan() throws Exception
    {
        call(this::mp_math_tan);
    }

    // function: Function(address=134300976, size=16, name='mp_math_sin', path='build/py/modmath.o', has_indirect=False)
    public void mp_math_sin() throws Exception
    {
        call(this::mp_math_sin);
    }

    // function: Function(address=134300992, size=16, name='mp_math_cos', path='build/py/modmath.o', has_indirect=False)
    public void mp_math_cos() throws Exception
    {
        call(this::mp_math_cos);
    }

    // function: Function(address=134301008, size=16, name='mp_math_atanh', path='build/py/modmath.o', has_indirect=False)
    public void mp_math_atanh() throws Exception
    {
        call(this::mp_math_atanh);
    }

    // function: Function(address=134301024, size=16, name='mp_math_asinh', path='build/py/modmath.o', has_indirect=False)
    public void mp_math_asinh() throws Exception
    {
        call(this::mp_math_asinh);
    }

    // function: Function(address=134301040, size=16, name='mp_math_acosh', path='build/py/modmath.o', has_indirect=False)
    public void mp_math_acosh() throws Exception
    {
        call(this::mp_math_acosh);
    }

    // function: Function(address=134301056, size=16, name='mp_math_tanh', path='build/py/modmath.o', has_indirect=False)
    public void mp_math_tanh() throws Exception
    {
        call(this::mp_math_tanh);
    }

    // function: Function(address=134301072, size=16, name='mp_math_sinh', path='build/py/modmath.o', has_indirect=False)
    public void mp_math_sinh() throws Exception
    {
        call(this::mp_math_sinh);
    }

    // function: Function(address=134301088, size=16, name='mp_math_cosh', path='build/py/modmath.o', has_indirect=False)
    public void mp_math_cosh() throws Exception
    {
        call(this::mp_math_cosh);
    }

    // function: Function(address=134301104, size=16, name='mp_math_log10', path='build/py/modmath.o', has_indirect=False)
    public void mp_math_log10() throws Exception
    {
        call(this::mp_math_log10);
    }

    // function: Function(address=134301120, size=16, name='mp_math_log2', path='build/py/modmath.o', has_indirect=False)
    public void mp_math_log2() throws Exception
    {
        call(this::mp_math_log2);
    }

    // function: Function(address=134301136, size=16, name='mp_math_expm1', path='build/py/modmath.o', has_indirect=False)
    public void mp_math_expm1() throws Exception
    {
        call(this::mp_math_expm1);
    }

    // function: Function(address=134301152, size=16, name='mp_math_exp', path='build/py/modmath.o', has_indirect=False)
    public void mp_math_exp() throws Exception
    {
        call(this::mp_math_exp);
    }

    // function: Function(address=134301168, size=16, name='mp_math_sqrt', path='build/py/modmath.o', has_indirect=False)
    public void mp_math_sqrt() throws Exception
    {
        call(this::mp_math_sqrt);
    }

    // function: Function(address=134301184, size=140, name='math_generic_2', path='build/py/modmath.o', has_indirect=False)
    public void math_generic_2() throws Exception
    {
        call(this::math_generic_2);
    }

    // function: Function(address=134301324, size=16, name='mp_math_fmod', path='build/py/modmath.o', has_indirect=False)
    public void mp_math_fmod() throws Exception
    {
        call(this::mp_math_fmod);
    }

    // function: Function(address=134301340, size=16, name='mp_math_copysign', path='build/py/modmath.o', has_indirect=False)
    public void mp_math_copysign() throws Exception
    {
        call(this::mp_math_copysign);
    }

    // function: Function(address=134301356, size=16, name='mp_math_atan2', path='build/py/modmath.o', has_indirect=False)
    public void mp_math_atan2() throws Exception
    {
        call(this::mp_math_atan2);
    }

    // function: Function(address=134301372, size=16, name='mp_math_pow', path='build/py/modmath.o', has_indirect=False)
    public void mp_math_pow() throws Exception
    {
        call(this::mp_math_pow);
    }

    // function: Function(address=134301388, size=116, name='mp_math_log', path='build/py/modmath.o', has_indirect=False)
    public void mp_math_log() throws Exception
    {
        call(this::mp_math_log);
    }

    // function: Function(address=134301504, size=66, name='mp_cmath_sin', path='build/py/modcmath.o', has_indirect=False)
    public void mp_cmath_sin() throws Exception
    {
        call(this::mp_cmath_sin);
    }

    // function: Function(address=134301570, size=70, name='mp_cmath_cos', path='build/py/modcmath.o', has_indirect=False)
    public void mp_cmath_cos() throws Exception
    {
        call(this::mp_cmath_cos);
    }

    // function: Function(address=134301640, size=102, name='mp_cmath_sqrt', path='build/py/modcmath.o', has_indirect=False)
    public void mp_cmath_sqrt() throws Exception
    {
        call(this::mp_cmath_sqrt);
    }

    // function: Function(address=134301744, size=84, name='mp_cmath_log10', path='build/py/modcmath.o', has_indirect=False)
    public void mp_cmath_log10() throws Exception
    {
        call(this::mp_cmath_log10);
    }

    // function: Function(address=134301828, size=72, name='mp_cmath_log', path='build/py/modcmath.o', has_indirect=False)
    public void mp_cmath_log() throws Exception
    {
        call(this::mp_cmath_log);
    }

    // function: Function(address=134301900, size=58, name='mp_cmath_exp', path='build/py/modcmath.o', has_indirect=False)
    public void mp_cmath_exp() throws Exception
    {
        call(this::mp_cmath_exp);
    }

    // function: Function(address=134301958, size=54, name='mp_cmath_rect', path='build/py/modcmath.o', has_indirect=False)
    public void mp_cmath_rect() throws Exception
    {
        call(this::mp_cmath_rect);
    }

    // function: Function(address=134302012, size=24, name='mp_cmath_phase', path='build/py/modcmath.o', has_indirect=False)
    public void mp_cmath_phase() throws Exception
    {
        call(this::mp_cmath_phase);
    }

    // function: Function(address=134302036, size=76, name='mp_cmath_polar', path='build/py/modcmath.o', has_indirect=False)
    public void mp_cmath_polar() throws Exception
    {
        call(this::mp_cmath_polar);
    }

    // function: Function(address=134302112, size=20, name='mp_micropython_pystack_use', path='build/py/modmicropython.o', has_indirect=False)
    public void mp_micropython_pystack_use() throws Exception
    {
        call(this::mp_micropython_pystack_use);
    }

    // function: Function(address=134302132, size=14, name='mp_micropython_mem_total', path='build/py/modmicropython.o', has_indirect=False)
    public void mp_micropython_mem_total() throws Exception
    {
        call(this::mp_micropython_mem_total);
    }

    // function: Function(address=134302146, size=14, name='mp_micropython_mem_current', path='build/py/modmicropython.o', has_indirect=False)
    public void mp_micropython_mem_current() throws Exception
    {
        call(this::mp_micropython_mem_current);
    }

    // function: Function(address=134302160, size=14, name='mp_micropython_mem_peak', path='build/py/modmicropython.o', has_indirect=False)
    public void mp_micropython_mem_peak() throws Exception
    {
        call(this::mp_micropython_mem_peak);
    }

    // function: Function(address=134302174, size=14, name='mp_micropython_stack_use', path='build/py/modmicropython.o', has_indirect=False)
    public void mp_micropython_stack_use() throws Exception
    {
        call(this::mp_micropython_stack_use);
    }

    // function: Function(address=134302188, size=92, name='mp_micropython_mem_info', path='build/py/modmicropython.o', has_indirect=False)
    public void mp_micropython_mem_info() throws Exception
    {
        call(this::mp_micropython_mem_info);
    }

    // function: Function(address=134302280, size=20, name='mp_micropython_kbd_intr', path='build/py/modmicropython.o', has_indirect=False)
    public void mp_micropython_kbd_intr() throws Exception
    {
        call(this::mp_micropython_kbd_intr);
    }

    // function: Function(address=134302300, size=16, name='mp_micropython_heap_unlock', path='build/py/modmicropython.o', has_indirect=False)
    public void mp_micropython_heap_unlock() throws Exception
    {
        call(this::mp_micropython_heap_unlock);
    }

    // function: Function(address=134302316, size=16, name='mp_micropython_heap_lock', path='build/py/modmicropython.o', has_indirect=False)
    public void mp_micropython_heap_lock() throws Exception
    {
        call(this::mp_micropython_heap_lock);
    }

    // function: Function(address=134302332, size=64, name='mp_micropython_qstr_info', path='build/py/modmicropython.o', has_indirect=False)
    public void mp_micropython_qstr_info() throws Exception
    {
        call(this::mp_micropython_qstr_info);
    }

    // function: Function(address=134302396, size=36, name='mp_micropython_schedule', path='build/py/modmicropython.o', has_indirect=False)
    public void mp_micropython_schedule() throws Exception
    {
        call(this::mp_micropython_schedule);
    }

    // function: Function(address=134302432, size=44, name='mp_micropython_opt_level', path='build/py/modmicropython.o', has_indirect=False)
    public void mp_micropython_opt_level() throws Exception
    {
        call(this::mp_micropython_opt_level);
    }

    // function: Function(address=134302476, size=36, name='get_fmt_type', path='build/py/modstruct.o', has_indirect=False)
    public void get_fmt_type() throws Exception
    {
        call(this::get_fmt_type);
    }

    // function: Function(address=134302512, size=44, name='get_fmt_num', path='build/py/modstruct.o', has_indirect=False)
    public void get_fmt_num() throws Exception
    {
        call(this::get_fmt_num);
    }

    // function: Function(address=134302556, size=102, name='calc_size_items', path='build/py/modstruct.o', has_indirect=False)
    public void calc_size_items() throws Exception
    {
        call(this::calc_size_items);
    }

    // function: Function(address=134302658, size=22, name='struct_calcsize', path='build/py/modstruct.o', has_indirect=False)
    public void struct_calcsize() throws Exception
    {
        call(this::struct_calcsize);
    }

    // function: Function(address=134302680, size=216, name='struct_unpack_from', path='build/py/modstruct.o', has_indirect=False)
    public void struct_unpack_from() throws Exception
    {
        call(this::struct_unpack_from);
    }

    // function: Function(address=134302896, size=160, name='struct_pack_into_internal', path='build/py/modstruct.o', has_indirect=False)
    public void struct_pack_into_internal() throws Exception
    {
        call(this::struct_pack_into_internal);
    }

    // function: Function(address=134303056, size=68, name='struct_pack', path='build/py/modstruct.o', has_indirect=False)
    public void struct_pack() throws Exception
    {
        call(this::struct_pack);
    }

    // function: Function(address=134303124, size=92, name='struct_pack_into', path='build/py/modstruct.o', has_indirect=False)
    public void struct_pack_into() throws Exception
    {
        call(this::struct_pack_into);
    }

    // function: Function(address=134303216, size=32, name='mp_sys_exit', path='build/py/modsys.o', has_indirect=False)
    public void mp_sys_exit() throws Exception
    {
        call(this::mp_sys_exit);
    }

    // function: Function(address=134303248, size=52, name='mp_sys_print_exception', path='build/py/modsys.o', has_indirect=False)
    public void mp_sys_print_exception() throws Exception
    {
        call(this::mp_sys_print_exception);
    }

    // function: Function(address=134303300, size=56, name='mp_sys_exc_info', path='build/py/modsys.o', has_indirect=False)
    public void mp_sys_exc_info() throws Exception
    {
        call(this::mp_sys_exc_info);
    }

    // function: Function(address=134303356, size=12, name='mp_sys_getsizeof', path='build/py/modsys.o', has_indirect=False)
    public void mp_sys_getsizeof() throws Exception
    {
        call(this::mp_sys_getsizeof);
    }

    // function: Function(address=134303368, size=28, name='mp_errno_to_str', path='build/py/moduerrno.o', has_indirect=False)
    public void mp_errno_to_str() throws Exception
    {
        call(this::mp_errno_to_str);
    }

    // function: Function(address=134303396, size=4844, name='mp_execute_bytecode', path='build/py/vm.o', has_indirect=False)
    public void mp_execute_bytecode() throws Exception
    {
        call(this::mp_execute_bytecode);
    }

    // function: Function(address=134308240, size=36, name='unlikely_fun_pos_args_mismatch', path='build/py/bc.o', has_indirect=False)
    public void unlikely_fun_pos_args_mismatch() throws Exception
    {
        call(this::unlikely_fun_pos_args_mismatch);
    }

    // function: Function(address=134308276, size=32, name='mp_decode_uint', path='build/py/bc.o', has_indirect=False)
    public void mp_decode_uint() throws Exception
    {
        call(this::mp_decode_uint);
    }

    // function: Function(address=134308308, size=12, name='mp_decode_uint_value', path='build/py/bc.o', has_indirect=False)
    public void mp_decode_uint_value() throws Exception
    {
        call(this::mp_decode_uint_value);
    }

    // function: Function(address=134308320, size=12, name='mp_decode_uint_skip', path='build/py/bc.o', has_indirect=False)
    public void mp_decode_uint_skip() throws Exception
    {
        call(this::mp_decode_uint_skip);
    }

    // function: Function(address=134308332, size=720, name='mp_setup_code_state', path='build/py/bc.o', has_indirect=False)
    public void mp_setup_code_state() throws Exception
    {
        call(this::mp_setup_code_state);
    }

    // function: Function(address=134309052, size=84, name='mp_opcode_format', path='build/py/bc.o', has_indirect=False)
    public void mp_opcode_format() throws Exception
    {
        call(this::mp_opcode_format);
    }

    // function: Function(address=134309136, size=54, name='str_startswith_word', path='build/py/repl.o', has_indirect=False)
    public void str_startswith_word() throws Exception
    {
        call(this::str_startswith_word);
    }

    // function: Function(address=134309192, size=388, name='mp_repl_continue_with_input', path='build/py/repl.o', has_indirect=False)
    public void mp_repl_continue_with_input() throws Exception
    {
        call(this::mp_repl_continue_with_input);
    }

    // function: Function(address=134309580, size=524, name='mp_repl_autocomplete', path='build/py/repl.o', has_indirect=False)
    public void mp_repl_autocomplete() throws Exception
    {
        call(this::mp_repl_autocomplete);
    }

    // function: Function(address=134310104, size=104, name='mp_small_int_mul_overflow', path='build/py/smallint.o', has_indirect=False)
    public void mp_small_int_mul_overflow() throws Exception
    {
        call(this::mp_small_int_mul_overflow);
    }

    // function: Function(address=134310208, size=32, name='mp_small_int_modulo', path='build/py/smallint.o', has_indirect=False)
    public void mp_small_int_modulo() throws Exception
    {
        call(this::mp_small_int_modulo);
    }

    // function: Function(address=134310240, size=30, name='mp_small_int_floor_divide', path='build/py/smallint.o', has_indirect=False)
    public void mp_small_int_floor_divide() throws Exception
    {
        call(this::mp_small_int_floor_divide);
    }

    // function: Function(address=134310270, size=72, name='mp_frozen_stat_helper', path='build/py/frozenmod.o', has_indirect=False)
    public void mp_frozen_stat_helper() throws Exception
    {
        call(this::mp_frozen_stat_helper);
    }

    // function: Function(address=134310344, size=104, name='mp_find_frozen_str', path='build/py/frozenmod.o', has_indirect=False)
    public void mp_find_frozen_str() throws Exception
    {
        call(this::mp_find_frozen_str);
    }

    // function: Function(address=134310448, size=36, name='mp_frozen_stat', path='build/py/frozenmod.o', has_indirect=False)
    public void mp_frozen_stat() throws Exception
    {
        call(this::mp_frozen_stat);
    }

    // function: Function(address=134310484, size=128, name='mp_find_frozen_module', path='build/py/frozenmod.o', has_indirect=False)
    public void mp_find_frozen_module() throws Exception
    {
        call(this::mp_find_frozen_module);
    }

    // function: Function(address=134310612, size=20, name='uctypes_struct_addressof', path='build/extmod/moductypes.o', has_indirect=False)
    public void uctypes_struct_addressof() throws Exception
    {
        call(this::uctypes_struct_addressof);
    }

    // function: Function(address=134310632, size=28, name='uctypes_struct_bytearray_at', path='build/extmod/moductypes.o', has_indirect=False)
    public void uctypes_struct_bytearray_at() throws Exception
    {
        call(this::uctypes_struct_bytearray_at);
    }

    // function: Function(address=134310660, size=26, name='uctypes_struct_bytes_at', path='build/extmod/moductypes.o', has_indirect=False)
    public void uctypes_struct_bytes_at() throws Exception
    {
        call(this::uctypes_struct_bytes_at);
    }

    // function: Function(address=134310686, size=150, name='get_aligned', path='build/extmod/moductypes.o', has_indirect=False)
    public void get_aligned() throws Exception
    {
        call(this::get_aligned);
    }

    // function: Function(address=134310836, size=66, name='uctypes_struct_make_new', path='build/extmod/moductypes.o', has_indirect=False)
    public void uctypes_struct_make_new() throws Exception
    {
        call(this::uctypes_struct_make_new);
    }

    // function: Function(address=134310904, size=88, name='uctypes_struct_print', path='build/extmod/moductypes.o', has_indirect=False)
    public void uctypes_struct_print() throws Exception
    {
        call(this::uctypes_struct_print);
    }

    // function: Function(address=134310992, size=112, name='set_aligned', path='build/extmod/moductypes.o', has_indirect=False)
    public void set_aligned() throws Exception
    {
        call(this::set_aligned);
    }

    // function: Function(address=134311104, size=236, name='uctypes_struct_size', path='build/extmod/moductypes.o', has_indirect=False)
    public void uctypes_struct_size() throws Exception
    {
        call(this::uctypes_struct_size);
    }

    // function: Function(address=134311340, size=64, name='uctypes_struct_sizeof', path='build/extmod/moductypes.o', has_indirect=False)
    public void uctypes_struct_sizeof() throws Exception
    {
        call(this::uctypes_struct_sizeof);
    }

    // function: Function(address=134311404, size=80, name='uctypes_struct_agg_size', path='build/extmod/moductypes.o', has_indirect=False)
    public void uctypes_struct_agg_size() throws Exception
    {
        call(this::uctypes_struct_agg_size);
    }

    // function: Function(address=134311484, size=34, name='uctypes_get_buffer', path='build/extmod/moductypes.o', has_indirect=False)
    public void uctypes_get_buffer() throws Exception
    {
        call(this::uctypes_get_buffer);
    }

    // function: Function(address=134311520, size=312, name='uctypes_struct_subscr', path='build/extmod/moductypes.o', has_indirect=False)
    public void uctypes_struct_subscr() throws Exception
    {
        call(this::uctypes_struct_subscr);
    }

    // function: Function(address=134311832, size=532, name='uctypes_struct_attr_op', path='build/extmod/moductypes.o', has_indirect=False)
    public void uctypes_struct_attr_op() throws Exception
    {
        call(this::uctypes_struct_attr_op);
    }

    // function: Function(address=134312364, size=34, name='uctypes_struct_attr', path='build/extmod/moductypes.o', has_indirect=False)
    public void uctypes_struct_attr() throws Exception
    {
        call(this::uctypes_struct_attr);
    }

    // function: Function(address=134312398, size=42, name='ujson_stream_next', path='build/extmod/modujson.o', has_indirect=False)
    public void ujson_stream_next() throws Exception
    {
        call(this::ujson_stream_next);
    }

    // function: Function(address=134312440, size=760, name='mod_ujson_load', path='build/extmod/modujson.o', has_indirect=False)
    public void mod_ujson_load() throws Exception
    {
        call(this::mod_ujson_load);
    }

    // function: Function(address=134313200, size=56, name='mod_ujson_loads', path='build/extmod/modujson.o', has_indirect=False)
    public void mod_ujson_loads() throws Exception
    {
        call(this::mod_ujson_loads);
    }

    // function: Function(address=134313256, size=44, name='mod_ujson_dump', path='build/extmod/modujson.o', has_indirect=False)
    public void mod_ujson_dump() throws Exception
    {
        call(this::mod_ujson_dump);
    }

    // function: Function(address=134313300, size=44, name='mod_ujson_dumps', path='build/extmod/modujson.o', has_indirect=False)
    public void mod_ujson_dumps() throws Exception
    {
        call(this::mod_ujson_dumps);
    }

    // function: Function(address=134313344, size=16, name='match_print', path='build/extmod/modure.o', has_indirect=False)
    public void match_print() throws Exception
    {
        call(this::match_print);
    }

    // function: Function(address=134313360, size=16, name='re_print', path='build/extmod/modure.o', has_indirect=False)
    public void re_print() throws Exception
    {
        call(this::re_print);
    }

    // function: Function(address=134313376, size=860, name='_compilecode', path='build/extmod/modure.o', has_indirect=False)
    public void _compilecode() throws Exception
    {
        call(this::_compilecode);
    }

    // function: Function(address=134314236, size=72, name='match_group', path='build/extmod/modure.o', has_indirect=False)
    public void match_group() throws Exception
    {
        call(this::match_group);
    }

    // function: Function(address=134314308, size=44, name='re1_5_sizecode', path='build/extmod/modure.o', has_indirect=False)
    public void re1_5_sizecode() throws Exception
    {
        call(this::re1_5_sizecode);
    }

    // function: Function(address=134314352, size=84, name='re1_5_compilecode', path='build/extmod/modure.o', has_indirect=False)
    public void re1_5_compilecode() throws Exception
    {
        call(this::re1_5_compilecode);
    }

    // function: Function(address=134314436, size=312, name='re1_5_dumpcode', path='build/extmod/modure.o', has_indirect=False)
    public void re1_5_dumpcode() throws Exception
    {
        call(this::re1_5_dumpcode);
    }

    // function: Function(address=134314748, size=92, name='mod_re_compile', path='build/extmod/modure.o', has_indirect=False)
    public void mod_re_compile() throws Exception
    {
        call(this::mod_re_compile);
    }

    // function: Function(address=134314840, size=52, name='_re1_5_classmatch', path='build/extmod/modure.o', has_indirect=False)
    public void _re1_5_classmatch() throws Exception
    {
        call(this::_re1_5_classmatch);
    }

    // function: Function(address=134314892, size=74, name='_re1_5_namedclassmatch', path='build/extmod/modure.o', has_indirect=False)
    public void _re1_5_namedclassmatch() throws Exception
    {
        call(this::_re1_5_namedclassmatch);
    }

    // function: Function(address=134314966, size=280, name='recursiveloop', path='build/extmod/modure.o', has_indirect=False)
    public void recursiveloop() throws Exception
    {
        call(this::recursiveloop);
    }

    // function: Function(address=134315246, size=26, name='re1_5_recursiveloopprog', path='build/extmod/modure.o', has_indirect=False)
    public void re1_5_recursiveloopprog() throws Exception
    {
        call(this::re1_5_recursiveloopprog);
    }

    // function: Function(address=134315272, size=120, name='ure_exec_isra_2', path='build/extmod/modure.o', has_indirect=False)
    public void ure_exec_isra_2() throws Exception
    {
        call(this::ure_exec_isra_2);
    }

    // function: Function(address=134315392, size=10, name='re_match', path='build/extmod/modure.o', has_indirect=False)
    public void re_match() throws Exception
    {
        call(this::re_match);
    }

    // function: Function(address=134315402, size=10, name='re_search', path='build/extmod/modure.o', has_indirect=False)
    public void re_search() throws Exception
    {
        call(this::re_search);
    }

    // function: Function(address=134315412, size=30, name='mod_re_match', path='build/extmod/modure.o', has_indirect=False)
    public void mod_re_match() throws Exception
    {
        call(this::mod_re_match);
    }

    // function: Function(address=134315442, size=30, name='mod_re_search', path='build/extmod/modure.o', has_indirect=False)
    public void mod_re_search() throws Exception
    {
        call(this::mod_re_search);
    }

    // function: Function(address=134315472, size=204, name='re_split', path='build/extmod/modure.o', has_indirect=False)
    public void re_split() throws Exception
    {
        call(this::re_split);
    }

    // function: Function(address=134315676, size=102, name='tinf_build_tree', path='build/extmod/moduzlib.o', has_indirect=False)
    public void tinf_build_tree() throws Exception
    {
        call(this::tinf_build_tree);
    }

    // function: Function(address=134315780, size=56, name='read_src_stream', path='build/extmod/moduzlib.o', has_indirect=True)
    public void read_src_stream() throws Exception
    {
        call(this::read_src_stream);
    }

    // function: Function(address=134315836, size=22, name='uzlib_get_byte', path='build/extmod/moduzlib.o', has_indirect=False)
    public void uzlib_get_byte() throws Exception
    {
        call(this::uzlib_get_byte);
    }

    // function: Function(address=134315858, size=36, name='tinf_getbit', path='build/extmod/moduzlib.o', has_indirect=False)
    public void tinf_getbit() throws Exception
    {
        call(this::tinf_getbit);
    }

    // function: Function(address=134315894, size=44, name='tinf_read_bits', path='build/extmod/moduzlib.o', has_indirect=False)
    public void tinf_read_bits() throws Exception
    {
        call(this::tinf_read_bits);
    }

    // function: Function(address=134315938, size=42, name='tinf_decode_symbol', path='build/extmod/moduzlib.o', has_indirect=False)
    public void tinf_decode_symbol() throws Exception
    {
        call(this::tinf_decode_symbol);
    }

    // function: Function(address=134315980, size=268, name='tinf_decode_trees', path='build/extmod/moduzlib.o', has_indirect=False)
    public void tinf_decode_trees() throws Exception
    {
        call(this::tinf_decode_trees);
    }

    // function: Function(address=134316248, size=30, name='tinf_get_le_uint32', path='build/extmod/moduzlib.o', has_indirect=False)
    public void tinf_get_le_uint32() throws Exception
    {
        call(this::tinf_get_le_uint32);
    }

    // function: Function(address=134316278, size=28, name='tinf_get_be_uint32', path='build/extmod/moduzlib.o', has_indirect=False)
    public void tinf_get_be_uint32() throws Exception
    {
        call(this::tinf_get_be_uint32);
    }

    // function: Function(address=134316308, size=640, name='uzlib_uncompress', path='build/extmod/moduzlib.o', has_indirect=False)
    public void uzlib_uncompress() throws Exception
    {
        call(this::uzlib_uncompress);
    }

    // function: Function(address=134316948, size=68, name='uzlib_zlib_parse_header', path='build/extmod/moduzlib.o', has_indirect=False)
    public void uzlib_zlib_parse_header() throws Exception
    {
        call(this::uzlib_zlib_parse_header);
    }

    // function: Function(address=134317016, size=20, name='tinf_skip_bytes', path='build/extmod/moduzlib.o', has_indirect=False)
    public void tinf_skip_bytes() throws Exception
    {
        call(this::tinf_skip_bytes);
    }

    // function: Function(address=134317036, size=24, name='tinf_get_uint16', path='build/extmod/moduzlib.o', has_indirect=False)
    public void tinf_get_uint16() throws Exception
    {
        call(this::tinf_get_uint16);
    }

    // function: Function(address=134317060, size=138, name='uzlib_gzip_parse_header', path='build/extmod/moduzlib.o', has_indirect=False)
    public void uzlib_gzip_parse_header() throws Exception
    {
        call(this::uzlib_gzip_parse_header);
    }

    // function: Function(address=134317200, size=184, name='decompio_make_new', path='build/extmod/moduzlib.o', has_indirect=False)
    public void decompio_make_new() throws Exception
    {
        call(this::decompio_make_new);
    }

    // function: Function(address=134317384, size=204, name='uzlib_adler32', path='build/extmod/moduzlib.o', has_indirect=False)
    public void uzlib_adler32() throws Exception
    {
        call(this::uzlib_adler32);
    }

    // function: Function(address=134317588, size=56, name='uzlib_crc32', path='build/extmod/moduzlib.o', has_indirect=False)
    public void uzlib_crc32() throws Exception
    {
        call(this::uzlib_crc32);
    }

    // function: Function(address=134317644, size=106, name='uzlib_uncompress_chksum', path='build/extmod/moduzlib.o', has_indirect=False)
    public void uzlib_uncompress_chksum() throws Exception
    {
        call(this::uzlib_uncompress_chksum);
    }

    // function: Function(address=134317752, size=60, name='decompio_read', path='build/extmod/moduzlib.o', has_indirect=False)
    public void decompio_read() throws Exception
    {
        call(this::decompio_read);
    }

    // function: Function(address=134317812, size=196, name='mod_uzlib_decompress', path='build/extmod/moduzlib.o', has_indirect=False)
    public void mod_uzlib_decompress() throws Exception
    {
        call(this::mod_uzlib_decompress);
    }

    // function: Function(address=134318008, size=32, name='get_heap', path='build/extmod/moduheapq.o', has_indirect=False)
    public void get_heap() throws Exception
    {
        call(this::get_heap);
    }

    // function: Function(address=134318040, size=72, name='heap_siftdown_isra_0', path='build/extmod/moduheapq.o', has_indirect=False)
    public void heap_siftdown_isra_0() throws Exception
    {
        call(this::heap_siftdown_isra_0);
    }

    // function: Function(address=134318112, size=112, name='heap_siftup', path='build/extmod/moduheapq.o', has_indirect=False)
    public void heap_siftup() throws Exception
    {
        call(this::heap_siftup);
    }

    // function: Function(address=134318224, size=36, name='mod_uheapq_heapify', path='build/extmod/moduheapq.o', has_indirect=False)
    public void mod_uheapq_heapify() throws Exception
    {
        call(this::mod_uheapq_heapify);
    }

    // function: Function(address=134318260, size=44, name='mod_uheapq_heappush', path='build/extmod/moduheapq.o', has_indirect=False)
    public void mod_uheapq_heappush() throws Exception
    {
        call(this::mod_uheapq_heappush);
    }

    // function: Function(address=134318304, size=64, name='mod_uheapq_heappop', path='build/extmod/moduheapq.o', has_indirect=False)
    public void mod_uheapq_heappop() throws Exception
    {
        call(this::mod_uheapq_heappop);
    }

    // function: Function(address=134318368, size=44, name='utimeq_unary_op', path='build/extmod/modutimeq.o', has_indirect=False)
    public void utimeq_unary_op() throws Exception
    {
        call(this::utimeq_unary_op);
    }

    // function: Function(address=134318412, size=68, name='utimeq_make_new', path='build/extmod/modutimeq.o', has_indirect=False)
    public void utimeq_make_new() throws Exception
    {
        call(this::utimeq_make_new);
    }

    // function: Function(address=134318480, size=40, name='mod_utimeq_peektime', path='build/extmod/modutimeq.o', has_indirect=False)
    public void mod_utimeq_peektime() throws Exception
    {
        call(this::mod_utimeq_peektime);
    }

    // function: Function(address=134318520, size=144, name='heap_siftdown_constprop_3', path='build/extmod/modutimeq.o', has_indirect=False)
    public void heap_siftdown_constprop_3() throws Exception
    {
        call(this::heap_siftdown_constprop_3);
    }

    // function: Function(address=134318664, size=276, name='mod_utimeq_heappop', path='build/extmod/modutimeq.o', has_indirect=False)
    public void mod_utimeq_heappop() throws Exception
    {
        call(this::mod_utimeq_heappop);
    }

    // function: Function(address=134318940, size=84, name='mod_utimeq_heappush', path='build/extmod/modutimeq.o', has_indirect=False)
    public void mod_utimeq_heappush() throws Exception
    {
        call(this::mod_utimeq_heappush);
    }

    // function: Function(address=134319024, size=364, name='sha256_transform', path='build/extmod/moduhashlib.o', has_indirect=False)
    public void sha256_transform() throws Exception
    {
        call(this::sha256_transform);
    }

    // function: Function(address=134319388, size=80, name='sha256_init', path='build/extmod/moduhashlib.o', has_indirect=False)
    public void sha256_init() throws Exception
    {
        call(this::sha256_init);
    }

    // function: Function(address=134319468, size=66, name='sha256_update', path='build/extmod/moduhashlib.o', has_indirect=False)
    public void sha256_update() throws Exception
    {
        call(this::sha256_update);
    }

    // function: Function(address=134319536, size=36, name='uhashlib_sha256_update', path='build/extmod/moduhashlib.o', has_indirect=False)
    public void uhashlib_sha256_update() throws Exception
    {
        call(this::uhashlib_sha256_update);
    }

    // function: Function(address=134319572, size=52, name='uhashlib_sha256_make_new', path='build/extmod/moduhashlib.o', has_indirect=False)
    public void uhashlib_sha256_make_new() throws Exception
    {
        call(this::uhashlib_sha256_make_new);
    }

    // function: Function(address=134319624, size=204, name='sha256_final', path='build/extmod/moduhashlib.o', has_indirect=False)
    public void sha256_final() throws Exception
    {
        call(this::sha256_final);
    }

    // function: Function(address=134319828, size=36, name='uhashlib_sha256_digest', path='build/extmod/moduhashlib.o', has_indirect=False)
    public void uhashlib_sha256_digest() throws Exception
    {
        call(this::uhashlib_sha256_digest);
    }

    // function: Function(address=134319864, size=136, name='mod_binascii_hexlify', path='build/extmod/modubinascii.o', has_indirect=False)
    public void mod_binascii_hexlify() throws Exception
    {
        call(this::mod_binascii_hexlify);
    }

    // function: Function(address=134320000, size=244, name='mod_binascii_b2a_base64', path='build/extmod/modubinascii.o', has_indirect=False)
    public void mod_binascii_b2a_base64() throws Exception
    {
        call(this::mod_binascii_b2a_base64);
    }

    // function: Function(address=134320244, size=132, name='mod_binascii_unhexlify', path='build/extmod/modubinascii.o', has_indirect=False)
    public void mod_binascii_unhexlify() throws Exception
    {
        call(this::mod_binascii_unhexlify);
    }

    // function: Function(address=134320376, size=196, name='mod_binascii_a2b_base64', path='build/extmod/modubinascii.o', has_indirect=False)
    public void mod_binascii_a2b_base64() throws Exception
    {
        call(this::mod_binascii_a2b_base64);
    }

    // function: Function(address=134320572, size=50, name='mod_binascii_crc32', path='build/extmod/modubinascii.o', has_indirect=False)
    public void mod_binascii_crc32() throws Exception
    {
        call(this::mod_binascii_crc32);
    }

    // function: Function(address=134320624, size=40, name='machine_mem_get_addr', path='build/extmod/machine_mem.o', has_indirect=False)
    public void machine_mem_get_addr() throws Exception
    {
        call(this::machine_mem_get_addr);
    }

    // function: Function(address=134320664, size=20, name='machine_mem_print', path='build/extmod/machine_mem.o', has_indirect=False)
    public void machine_mem_print() throws Exception
    {
        call(this::machine_mem_print);
    }

    // function: Function(address=134320684, size=92, name='machine_mem_subscr', path='build/extmod/machine_mem.o', has_indirect=False)
    public void machine_mem_subscr() throws Exception
    {
        call(this::machine_mem_subscr);
    }

    // function: Function(address=134320776, size=96, name='yasmarang', path='build/extmod/modurandom.o', has_indirect=False)
    public void yasmarang() throws Exception
    {
        call(this::yasmarang);
    }

    // function: Function(address=134320872, size=34, name='yasmarang_randbelow', path='build/extmod/modurandom.o', has_indirect=False)
    public void yasmarang_randbelow() throws Exception
    {
        call(this::yasmarang_randbelow);
    }

    // function: Function(address=134320906, size=66, name='mod_urandom_uniform', path='build/extmod/modurandom.o', has_indirect=False)
    public void mod_urandom_uniform() throws Exception
    {
        call(this::mod_urandom_uniform);
    }

    // function: Function(address=134320972, size=42, name='mod_urandom_randint', path='build/extmod/modurandom.o', has_indirect=False)
    public void mod_urandom_randint() throws Exception
    {
        call(this::mod_urandom_randint);
    }

    // function: Function(address=134321014, size=106, name='mod_urandom_randrange', path='build/extmod/modurandom.o', has_indirect=False)
    public void mod_urandom_randrange() throws Exception
    {
        call(this::mod_urandom_randrange);
    }

    // function: Function(address=134321120, size=52, name='mod_urandom_seed', path='build/extmod/modurandom.o', has_indirect=False)
    public void mod_urandom_seed() throws Exception
    {
        call(this::mod_urandom_seed);
    }

    // function: Function(address=134321172, size=44, name='mod_urandom_getrandbits', path='build/extmod/modurandom.o', has_indirect=False)
    public void mod_urandom_getrandbits() throws Exception
    {
        call(this::mod_urandom_getrandbits);
    }

    // function: Function(address=134321216, size=52, name='mod_urandom_choice', path='build/extmod/modurandom.o', has_indirect=False)
    public void mod_urandom_choice() throws Exception
    {
        call(this::mod_urandom_choice);
    }

    // function: Function(address=134321268, size=30, name='mod_urandom_random', path='build/extmod/modurandom.o', has_indirect=False)
    public void mod_urandom_random() throws Exception
    {
        call(this::mod_urandom_random);
    }

    // function: Function(address=134321298, size=62, name='mp_vfs_proxy_call', path='build/extmod/vfs.o', has_indirect=False)
    public void mp_vfs_proxy_call() throws Exception
    {
        call(this::mp_vfs_proxy_call);
    }

    // function: Function(address=134321360, size=160, name='mp_vfs_umount', path='build/extmod/vfs.o', has_indirect=False)
    public void mp_vfs_umount() throws Exception
    {
        call(this::mp_vfs_umount);
    }

    // function: Function(address=134321520, size=116, name='mp_vfs_getcwd', path='build/extmod/vfs.o', has_indirect=False)
    public void mp_vfs_getcwd() throws Exception
    {
        call(this::mp_vfs_getcwd);
    }

    // function: Function(address=134321636, size=112, name='mp_vfs_ilistdir_it_iternext', path='build/extmod/vfs.o', has_indirect=True)
    public void mp_vfs_ilistdir_it_iternext() throws Exception
    {
        call(this::mp_vfs_ilistdir_it_iternext);
    }

    // function: Function(address=134321748, size=140, name='mp_vfs_lookup_path', path='build/extmod/vfs.o', has_indirect=False)
    public void mp_vfs_lookup_path() throws Exception
    {
        call(this::mp_vfs_lookup_path);
    }

    // function: Function(address=134321888, size=156, name='mp_vfs_mount', path='build/extmod/vfs.o', has_indirect=False)
    public void mp_vfs_mount() throws Exception
    {
        call(this::mp_vfs_mount);
    }

    // function: Function(address=134322044, size=54, name='lookup_path', path='build/extmod/vfs.o', has_indirect=False)
    public void lookup_path() throws Exception
    {
        call(this::lookup_path);
    }

    // function: Function(address=134322100, size=48, name='mp_vfs_open', path='build/extmod/vfs.o', has_indirect=False)
    public void mp_vfs_open() throws Exception
    {
        call(this::mp_vfs_open);
    }

    // function: Function(address=134322148, size=72, name='mp_vfs_chdir', path='build/extmod/vfs.o', has_indirect=False)
    public void mp_vfs_chdir() throws Exception
    {
        call(this::mp_vfs_chdir);
    }

    // function: Function(address=134322220, size=104, name='mp_vfs_ilistdir', path='build/extmod/vfs.o', has_indirect=False)
    public void mp_vfs_ilistdir() throws Exception
    {
        call(this::mp_vfs_ilistdir);
    }

    // function: Function(address=134322324, size=50, name='mp_vfs_listdir', path='build/extmod/vfs.o', has_indirect=False)
    public void mp_vfs_listdir() throws Exception
    {
        call(this::mp_vfs_listdir);
    }

    // function: Function(address=134322376, size=60, name='mp_vfs_mkdir', path='build/extmod/vfs.o', has_indirect=False)
    public void mp_vfs_mkdir() throws Exception
    {
        call(this::mp_vfs_mkdir);
    }

    // function: Function(address=134322436, size=22, name='mp_vfs_remove', path='build/extmod/vfs.o', has_indirect=False)
    public void mp_vfs_remove() throws Exception
    {
        call(this::mp_vfs_remove);
    }

    // function: Function(address=134322458, size=46, name='mp_vfs_rename', path='build/extmod/vfs.o', has_indirect=False)
    public void mp_vfs_rename() throws Exception
    {
        call(this::mp_vfs_rename);
    }

    // function: Function(address=134322504, size=22, name='mp_vfs_rmdir', path='build/extmod/vfs.o', has_indirect=False)
    public void mp_vfs_rmdir() throws Exception
    {
        call(this::mp_vfs_rmdir);
    }

    // function: Function(address=134322528, size=60, name='mp_vfs_stat', path='build/extmod/vfs.o', has_indirect=False)
    public void mp_vfs_stat() throws Exception
    {
        call(this::mp_vfs_stat);
    }

    // function: Function(address=134322588, size=92, name='mp_vfs_statvfs', path='build/extmod/vfs.o', has_indirect=False)
    public void mp_vfs_statvfs() throws Exception
    {
        call(this::mp_vfs_statvfs);
    }

    // function: Function(address=134322680, size=124, name='mp_vfs_import_stat', path='build/extmod/vfs.o', has_indirect=False)
    public void mp_vfs_import_stat() throws Exception
    {
        call(this::mp_vfs_import_stat);
    }

    // function: Function(address=134322804, size=20, name='mp_reader_vfs_close', path='build/extmod/vfs_reader.o', has_indirect=True)
    public void mp_reader_vfs_close() throws Exception
    {
        call(this::mp_reader_vfs_close);
    }

    // function: Function(address=134322824, size=70, name='mp_reader_vfs_readbyte', path='build/extmod/vfs_reader.o', has_indirect=True)
    public void mp_reader_vfs_readbyte() throws Exception
    {
        call(this::mp_reader_vfs_readbyte);
    }

    // function: Function(address=134322896, size=96, name='mp_reader_new_file', path='build/extmod/vfs_reader.o', has_indirect=False)
    public void mp_reader_new_file() throws Exception
    {
        call(this::mp_reader_new_file);
    }

    // function: Function(address=134322992, size=28, name='time_ticks_diff', path='build/extmod/utime_mphal.o', has_indirect=False)
    public void time_ticks_diff() throws Exception
    {
        call(this::time_ticks_diff);
    }

    // function: Function(address=134323020, size=32, name='time_sleep', path='build/extmod/utime_mphal.o', has_indirect=False)
    public void time_sleep() throws Exception
    {
        call(this::time_sleep);
    }

    // function: Function(address=134323052, size=24, name='time_sleep_ms', path='build/extmod/utime_mphal.o', has_indirect=False)
    public void time_sleep_ms() throws Exception
    {
        call(this::time_sleep_ms);
    }

    // function: Function(address=134323076, size=32, name='time_ticks_add', path='build/extmod/utime_mphal.o', has_indirect=False)
    public void time_ticks_add() throws Exception
    {
        call(this::time_ticks_add);
    }

    // function: Function(address=134323108, size=24, name='time_ticks_ms', path='build/extmod/utime_mphal.o', has_indirect=False)
    public void time_ticks_ms() throws Exception
    {
        call(this::time_ticks_ms);
    }

    // function: Function(address=134323132, size=24, name='time_ticks_cpu', path='build/extmod/utime_mphal.o', has_indirect=False)
    public void time_ticks_cpu() throws Exception
    {
        call(this::time_ticks_cpu);
    }

    // function: Function(address=134323156, size=34, name='strn_print_strn', path='build/lib/utils/printf.o', has_indirect=True)
    public void strn_print_strn() throws Exception
    {
        call(this::strn_print_strn);
    }

    // function: Function(address=134323192, size=28, name='printf', path='build/lib/utils/printf.o', has_indirect=False)
    public void printf() throws Exception
    {
        call(this::printf);
    }

    // function: Function(address=134323220, size=20, name='putchar', path='build/lib/utils/printf.o', has_indirect=False)
    public void putchar() throws Exception
    {
        call(this::putchar);
    }

    // function: Function(address=134323240, size=34, name='puts', path='build/lib/utils/printf.o', has_indirect=False)
    public void puts() throws Exception
    {
        call(this::puts);
    }

    // function: Function(address=134323276, size=56, name='vsnprintf', path='build/lib/utils/printf.o', has_indirect=False)
    public void vsnprintf() throws Exception
    {
        call(this::vsnprintf);
    }

    // function: Function(address=134323332, size=22, name='snprintf', path='build/lib/utils/printf.o', has_indirect=False)
    public void snprintf() throws Exception
    {
        call(this::snprintf);
    }

    // function: Function(address=134323356, size=200, name='main', path='build/main.o', has_indirect=False)
    public void main() throws Exception
    {
        call(this::main);
    }

    // function: Function(address=134323556, size=44, name='Signal_Handler', path='build/machine.o', has_indirect=False)
    public void Signal_Handler() throws Exception
    {
        call(this::Signal_Handler);
    }

    // function: Function(address=134323600, size=14, name='_exit', path='build/machine.o', has_indirect=False)
    public void _exit() throws Exception
    {
        call(this::_exit);
    }

    // function: Function(address=134323614, size=16, name='_start', path='build/machine.o', has_indirect=False)
    public void _start() throws Exception
    {
        call(this::_start);
    }

    // function: Function(address=134323632, size=100, name='Reset_Handler', path='build/machine.o', has_indirect=False)
    public void Reset_Handler() throws Exception
    {
        call(this::Reset_Handler);
    }

    // function: Function(address=134323732, size=16, name='__fatal_error', path='build/machine.o', has_indirect=False)
    public void __fatal_error() throws Exception
    {
        call(this::__fatal_error);
    }

    // function: Function(address=134323748, size=12, name='nlr_jump_fail', path='build/machine.o', has_indirect=False)
    public void nlr_jump_fail() throws Exception
    {
        call(this::nlr_jump_fail);
    }

    // function: Function(address=134323760, size=16, name='mp_hal_stdin_rx_chr', path='build/mphalport.o', has_indirect=False)
    public void mp_hal_stdin_rx_chr() throws Exception
    {
        call(this::mp_hal_stdin_rx_chr);
    }

    // function: Function(address=134323776, size=32, name='mp_hal_stdout_tx_strn', path='build/mphalport.o', has_indirect=False)
    public void mp_hal_stdout_tx_strn() throws Exception
    {
        call(this::mp_hal_stdout_tx_strn);
    }

    // function: Function(address=134323808, size=40, name='mp_hal_delay_ms', path='build/mphalport.o', has_indirect=False)
    public void mp_hal_delay_ms() throws Exception
    {
        call(this::mp_hal_delay_ms);
    }

    // function: Function(address=134323848, size=12, name='mp_hal_ticks_ms', path='build/mphalport.o', has_indirect=False)
    public void mp_hal_ticks_ms() throws Exception
    {
        call(this::mp_hal_ticks_ms);
    }

    // function: Function(address=134323860, size=12, name='mp_hal_ticks_cpu', path='build/mphalport.o', has_indirect=False)
    public void mp_hal_ticks_cpu() throws Exception
    {
        call(this::mp_hal_ticks_cpu);
    }

    // function: Function(address=134323872, size=16, name='usystem_print_hook', path='build/modusystem.o', has_indirect=False)
    public void usystem_print_hook() throws Exception
    {
        call(this::usystem_print_hook);
    }

    // function: Function(address=134323888, size=32, name='usystem_debug', path='build/modusystem.o', has_indirect=False)
    public void usystem_debug() throws Exception
    {
        call(this::usystem_debug);
    }

    // function: Function(address=134323920, size=52, name='usystem_set_stdin_char', path='build/modusystem.o', has_indirect=False)
    public void usystem_set_stdin_char() throws Exception
    {
        call(this::usystem_set_stdin_char);
    }

    // function: Function(address=134323972, size=36, name='parse_2', path='build/modusystem.o', has_indirect=False)
    public void parse_2() throws Exception
    {
        call(this::parse_2);
    }

    // function: Function(address=134324008, size=30, name='usystem_syscall', path='build/modusystem.o', has_indirect=False)
    public void usystem_syscall() throws Exception
    {
        call(this::usystem_syscall);
    }

    // function: Function(address=134324038, size=20, name='usystem_signal', path='build/modusystem.o', has_indirect=False)
    public void usystem_signal() throws Exception
    {
        call(this::usystem_signal);
    }

    // function: Function(address=134324058, size=20, name='usystem_components', path='build/modusystem.o', has_indirect=False)
    public void usystem_components() throws Exception
    {
        call(this::usystem_components);
    }

    // function: Function(address=134324078, size=34, name='usystem_methods', path='build/modusystem.o', has_indirect=False)
    public void usystem_methods() throws Exception
    {
        call(this::usystem_methods);
    }

    // function: Function(address=134324112, size=32, name='usystem_annotations', path='build/modusystem.o', has_indirect=False)
    public void usystem_annotations() throws Exception
    {
        call(this::usystem_annotations);
    }

    // function: Function(address=134324144, size=20, name='usystem_get_stdout_str', path='build/modusystem.o', has_indirect=False)
    public void usystem_get_stdout_str() throws Exception
    {
        call(this::usystem_get_stdout_str);
    }

    // function: Function(address=134324164, size=36, name='gc_collect', path='build/gccollect.o', has_indirect=False)
    public void gc_collect() throws Exception
    {
        call(this::gc_collect);
    }

    // function: Function(address=134324200, size=10, name='vfs_openpie_file___exit__', path='build/openpie_vfs.o', has_indirect=False)
    public void vfs_openpie_file___exit__() throws Exception
    {
        call(this::vfs_openpie_file___exit__);
    }

    // function: Function(address=134324212, size=32, name='vfs_openpie_file_print', path='build/openpie_vfs.o', has_indirect=False)
    public void vfs_openpie_file_print() throws Exception
    {
        call(this::vfs_openpie_file_print);
    }

    // function: Function(address=134324244, size=24, name='unlikely_check_fd_is_open_isra_0_part_1', path='build/openpie_vfs.o', has_indirect=False)
    public void unlikely_check_fd_is_open_isra_0_part_1() throws Exception
    {
        call(this::unlikely_check_fd_is_open_isra_0_part_1);
    }

    // function: Function(address=134324268, size=18, name='vfs_openpie_file_fileno', path='build/openpie_vfs.o', has_indirect=False)
    public void vfs_openpie_file_fileno() throws Exception
    {
        call(this::vfs_openpie_file_fileno);
    }

    // function: Function(address=134324286, size=14, name='SVC_CALL_VFS', path='build/openpie_vfs.o', has_indirect=False)
    public void SVC_CALL_VFS() throws Exception
    {
        call(this::SVC_CALL_VFS);
    }

    // function: Function(address=134324300, size=16, name='SVC_CALL_VFS_OUT', path='build/openpie_vfs.o', has_indirect=False)
    public void SVC_CALL_VFS_OUT() throws Exception
    {
        call(this::SVC_CALL_VFS_OUT);
    }

    // function: Function(address=134324316, size=126, name='vfs_openpie_file_ioctl', path='build/openpie_vfs.o', has_indirect=False)
    public void vfs_openpie_file_ioctl() throws Exception
    {
        call(this::vfs_openpie_file_ioctl);
    }

    // function: Function(address=134324442, size=54, name='vfs_openpie_file_write', path='build/openpie_vfs.o', has_indirect=False)
    public void vfs_openpie_file_write() throws Exception
    {
        call(this::vfs_openpie_file_write);
    }

    // function: Function(address=134324496, size=52, name='vfs_openpie_file_read', path='build/openpie_vfs.o', has_indirect=False)
    public void vfs_openpie_file_read() throws Exception
    {
        call(this::vfs_openpie_file_read);
    }

    // function: Function(address=134324548, size=92, name='mp_vfs_openpie_file_open', path='build/openpie_vfs.o', has_indirect=False)
    public void mp_vfs_openpie_file_open() throws Exception
    {
        call(this::mp_vfs_openpie_file_open);
    }

    // function: Function(address=134324640, size=48, name='vfs_openpie_file_make_new', path='build/openpie_vfs.o', has_indirect=False)
    public void vfs_openpie_file_make_new() throws Exception
    {
        call(this::vfs_openpie_file_make_new);
    }

    // function: Function(address=134324688, size=36, name='gc_helper_get_regs_and_sp', path='build/gchelper_m0.o', has_indirect=False)
    public void gc_helper_get_regs_and_sp() throws Exception
    {
        call(this::gc_helper_get_regs_and_sp);
    }

    // function: Function(address=134324724, size=8, name='stdio_obj___exit__', path='build/lib/utils/sys_stdio_mphal.o', has_indirect=False)
    public void stdio_obj___exit__() throws Exception
    {
        call(this::stdio_obj___exit__);
    }

    // function: Function(address=134324732, size=16, name='stdio_obj_print', path='build/lib/utils/sys_stdio_mphal.o', has_indirect=False)
    public void stdio_obj_print() throws Exception
    {
        call(this::stdio_obj_print);
    }

    // function: Function(address=134324748, size=16, name='stdio_buffer_write', path='build/lib/utils/sys_stdio_mphal.o', has_indirect=False)
    public void stdio_buffer_write() throws Exception
    {
        call(this::stdio_buffer_write);
    }

    // function: Function(address=134324764, size=26, name='stdio_buffer_read', path='build/lib/utils/sys_stdio_mphal.o', has_indirect=False)
    public void stdio_buffer_read() throws Exception
    {
        call(this::stdio_buffer_read);
    }

    // function: Function(address=134324790, size=36, name='stdio_write', path='build/lib/utils/sys_stdio_mphal.o', has_indirect=False)
    public void stdio_write() throws Exception
    {
        call(this::stdio_write);
    }

    // function: Function(address=134324826, size=50, name='stdio_read', path='build/lib/utils/sys_stdio_mphal.o', has_indirect=False)
    public void stdio_read() throws Exception
    {
        call(this::stdio_read);
    }

    // function: Function(address=134324876, size=44, name='mp_hal_stdout_tx_strn_cooked', path='build/lib/utils/stdout_helpers.o', has_indirect=False)
    public void mp_hal_stdout_tx_strn_cooked() throws Exception
    {
        call(this::mp_hal_stdout_tx_strn_cooked);
    }

    // function: Function(address=134324920, size=18, name='mp_hal_stdout_tx_str', path='build/lib/utils/stdout_helpers.o', has_indirect=False)
    public void mp_hal_stdout_tx_str() throws Exception
    {
        call(this::mp_hal_stdout_tx_str);
    }

    // function: Function(address=134324940, size=28, name='mp_hal_set_interrupt_char', path='build/lib/utils/interrupt_char.o', has_indirect=False)
    public void mp_hal_set_interrupt_char() throws Exception
    {
        call(this::mp_hal_set_interrupt_char);
    }

    // function: Function(address=134324968, size=308, name='parse_compile_execute', path='build/lib/utils/pyexec.o', has_indirect=False)
    public void parse_compile_execute() throws Exception
    {
        call(this::parse_compile_execute);
    }

    // function: Function(address=134325276, size=160, name='pyexec_raw_repl', path='build/lib/utils/pyexec.o', has_indirect=False)
    public void pyexec_raw_repl() throws Exception
    {
        call(this::pyexec_raw_repl);
    }

    // function: Function(address=134325436, size=272, name='pyexec_friendly_repl', path='build/lib/utils/pyexec.o', has_indirect=False)
    public void pyexec_friendly_repl() throws Exception
    {
        call(this::pyexec_friendly_repl);
    }

    // function: Function(address=134325708, size=60, name='pyexec_frozen_module', path='build/lib/utils/pyexec.o', has_indirect=False)
    public void pyexec_frozen_module() throws Exception
    {
        call(this::pyexec_frozen_module);
    }

    // function: Function(address=134325768, size=70, name='memcpy', path='build/lib/libc/string0.o', has_indirect=False)
    public void memcpy() throws Exception
    {
        call(this::memcpy);
    }

    // function: Function(address=134325838, size=36, name='memmove', path='build/lib/libc/string0.o', has_indirect=False)
    public void memmove() throws Exception
    {
        call(this::memmove);
    }

    // function: Function(address=134325874, size=64, name='memset', path='build/lib/libc/string0.o', has_indirect=False)
    public void memset() throws Exception
    {
        call(this::memset);
    }

    // function: Function(address=134325938, size=36, name='memcmp', path='build/lib/libc/string0.o', has_indirect=False)
    public void memcmp() throws Exception
    {
        call(this::memcmp);
    }

    // function: Function(address=134325974, size=18, name='strlen', path='build/lib/libc/string0.o', has_indirect=False)
    public void strlen() throws Exception
    {
        call(this::strlen);
    }

    // function: Function(address=134325992, size=46, name='strcmp', path='build/lib/libc/string0.o', has_indirect=False)
    public void strcmp() throws Exception
    {
        call(this::strcmp);
    }

    // function: Function(address=134326038, size=68, name='strncmp', path='build/lib/libc/string0.o', has_indirect=False)
    public void strncmp() throws Exception
    {
        call(this::strncmp);
    }

    // function: Function(address=134326106, size=24, name='strchr', path='build/lib/libc/string0.o', has_indirect=False)
    public void strchr() throws Exception
    {
        call(this::strchr);
    }

    // function: Function(address=134326132, size=48, name='mp_hal_move_cursor_back', path='build/lib/mp-readline/readline.o', has_indirect=False)
    public void mp_hal_move_cursor_back() throws Exception
    {
        call(this::mp_hal_move_cursor_back);
    }

    // function: Function(address=134326180, size=36, name='readline_init', path='build/lib/mp-readline/readline.o', has_indirect=False)
    public void readline_init() throws Exception
    {
        call(this::readline_init);
    }

    // function: Function(address=134326216, size=96, name='readline_push_history', path='build/lib/mp-readline/readline.o', has_indirect=False)
    public void readline_push_history() throws Exception
    {
        call(this::readline_push_history);
    }

    // function: Function(address=134326312, size=628, name='readline_process_char', path='build/lib/mp-readline/readline.o', has_indirect=False)
    public void readline_process_char() throws Exception
    {
        call(this::readline_process_char);
    }

    // function: Function(address=134326940, size=20, name='readline', path='build/lib/mp-readline/readline.o', has_indirect=False)
    public void readline() throws Exception
    {
        call(this::readline);
    }

    // function: Function(address=134326960, size=98, name='scalbnf', path='build/lib/libm/math.o', has_indirect=False)
    public void scalbnf() throws Exception
    {
        call(this::scalbnf);
    }

    // function: Function(address=134327060, size=1696, name='powf', path='build/lib/libm/math.o', has_indirect=True)
    public void powf() throws Exception
    {
        call(this::powf);
    }

    // function: Function(address=134328756, size=344, name='expf', path='build/lib/libm/math.o', has_indirect=True)
    public void expf() throws Exception
    {
        call(this::expf);
    }

    // function: Function(address=134329100, size=664, name='expm1f', path='build/lib/libm/math.o', has_indirect=True)
    public void expm1f() throws Exception
    {
        call(this::expm1f);
    }

    // function: Function(address=134329764, size=36, name='__expo2f', path='build/lib/libm/math.o', has_indirect=False)
    public void __expo2f() throws Exception
    {
        call(this::__expo2f);
    }

    // function: Function(address=134329800, size=340, name='logf', path='build/lib/libm/math.o', has_indirect=False)
    public void logf() throws Exception
    {
        call(this::logf);
    }

    // function: Function(address=134330140, size=20, name='log10f', path='build/lib/libm/math.o', has_indirect=True)
    public void log10f() throws Exception
    {
        call(this::log10f);
    }

    // function: Function(address=134330160, size=144, name='coshf', path='build/lib/libm/math.o', has_indirect=True)
    public void coshf() throws Exception
    {
        call(this::coshf);
    }

    // function: Function(address=134330304, size=160, name='sinhf', path='build/lib/libm/math.o', has_indirect=True)
    public void sinhf() throws Exception
    {
        call(this::sinhf);
    }

    // function: Function(address=134330464, size=76, name='tanhf', path='build/lib/libm/math.o', has_indirect=True)
    public void tanhf() throws Exception
    {
        call(this::tanhf);
    }

    // function: Function(address=134330540, size=88, name='ceilf', path='build/lib/libm/math.o', has_indirect=False)
    public void ceilf() throws Exception
    {
        call(this::ceilf);
    }

    // function: Function(address=134330628, size=88, name='floorf', path='build/lib/libm/math.o', has_indirect=False)
    public void floorf() throws Exception
    {
        call(this::floorf);
    }

    // function: Function(address=134330716, size=48, name='truncf', path='build/lib/libm/math.o', has_indirect=False)
    public void truncf() throws Exception
    {
        call(this::truncf);
    }

    // function: Function(address=134330764, size=160, name='acoshf', path='build/lib/libm/acoshf.o', has_indirect=True)
    public void acoshf() throws Exception
    {
        call(this::acoshf);
    }

    // function: Function(address=134330924, size=80, name='text_R', path='build/lib/libm/asinfacosf.o', has_indirect=False)
    public void text_R() throws Exception
    {
        call(this::text_R);
    }

    // function: Function(address=134331004, size=196, name='asinf', path='build/lib/libm/asinfacosf.o', has_indirect=True)
    public void asinf() throws Exception
    {
        call(this::asinf);
    }

    // function: Function(address=134331200, size=288, name='acosf', path='build/lib/libm/asinfacosf.o', has_indirect=True)
    public void acosf() throws Exception
    {
        call(this::acosf);
    }

    // function: Function(address=134331488, size=200, name='asinhf', path='build/lib/libm/asinhf.o', has_indirect=True)
    public void asinhf() throws Exception
    {
        call(this::asinhf);
    }

    // function: Function(address=134331688, size=304, name='atan2f', path='build/lib/libm/atan2f.o', has_indirect=True)
    public void atan2f() throws Exception
    {
        call(this::atan2f);
    }

    // function: Function(address=134331992, size=456, name='atanf', path='build/lib/libm/atanf.o', has_indirect=True)
    public void atanf() throws Exception
    {
        call(this::atanf);
    }

    // function: Function(address=134332448, size=144, name='atanhf', path='build/lib/libm/atanhf.o', has_indirect=True)
    public void atanhf() throws Exception
    {
        call(this::atanhf);
    }

    // function: Function(address=134332592, size=692, name='__ieee754_rem_pio2f', path='build/lib/libm/ef_rem_pio2.o', has_indirect=False)
    public void __ieee754_rem_pio2f() throws Exception
    {
        call(this::__ieee754_rem_pio2f);
    }

    // function: Function(address=134333284, size=176, name='sqrtf', path='build/lib/libm/ef_sqrt.o', has_indirect=True)
    public void sqrtf() throws Exception
    {
        call(this::sqrtf);
    }

    // function: Function(address=134333460, size=1976, name='__ieee754_lgammaf_r', path='build/lib/libm/erf_lgamma.o', has_indirect=False)
    public void __ieee754_lgammaf_r() throws Exception
    {
        call(this::__ieee754_lgammaf_r);
    }

    // function: Function(address=134335436, size=208, name='fmodf', path='build/lib/libm/fmodf.o', has_indirect=True)
    public void fmodf() throws Exception
    {
        call(this::fmodf);
    }

    // function: Function(address=134335644, size=260, name='__kernel_cosf', path='build/lib/libm/kf_cos.o', has_indirect=False)
    public void __kernel_cosf() throws Exception
    {
        call(this::__kernel_cosf);
    }

    // function: Function(address=134335904, size=1428, name='__kernel_rem_pio2f', path='build/lib/libm/kf_rem_pio2.o', has_indirect=False)
    public void __kernel_rem_pio2f() throws Exception
    {
        call(this::__kernel_rem_pio2f);
    }

    // function: Function(address=134337332, size=236, name='__kernel_sinf', path='build/lib/libm/kf_sin.o', has_indirect=False)
    public void __kernel_sinf() throws Exception
    {
        call(this::__kernel_sinf);
    }

    // function: Function(address=134337568, size=604, name='__kernel_tanf', path='build/lib/libm/kf_tan.o', has_indirect=False)
    public void __kernel_tanf() throws Exception
    {
        call(this::__kernel_tanf);
    }

    // function: Function(address=134338172, size=448, name='log1pf', path='build/lib/libm/log1pf.o', has_indirect=False)
    public void log1pf() throws Exception
    {
        call(this::log1pf);
    }

    // function: Function(address=134338620, size=74, name='nearbyintf', path='build/lib/libm/nearbyintf.o', has_indirect=False)
    public void nearbyintf() throws Exception
    {
        call(this::nearbyintf);
    }

    // function: Function(address=134338696, size=108, name='cosf', path='build/lib/libm/sf_cos.o', has_indirect=True)
    public void cosf() throws Exception
    {
        call(this::cosf);
    }

    // function: Function(address=134338804, size=1208, name='erff', path='build/lib/libm/sf_erf.o', has_indirect=True)
    public void erff() throws Exception
    {
        call(this::erff);
    }

    // function: Function(address=134340012, size=1212, name='erfcf', path='build/lib/libm/sf_erf.o', has_indirect=True)
    public void erfcf() throws Exception
    {
        call(this::erfcf);
    }

    // function: Function(address=134341224, size=84, name='frexpf', path='build/lib/libm/sf_frexp.o', has_indirect=False)
    public void frexpf() throws Exception
    {
        call(this::frexpf);
    }

    // function: Function(address=134341308, size=64, name='ldexpf', path='build/lib/libm/sf_ldexp.o', has_indirect=False)
    public void ldexpf() throws Exception
    {
        call(this::ldexpf);
    }

    // function: Function(address=134341372, size=68, name='modff', path='build/lib/libm/sf_modf.o', has_indirect=False)
    public void modff() throws Exception
    {
        call(this::modff);
    }

    // function: Function(address=134341440, size=112, name='sinf', path='build/lib/libm/sf_sin.o', has_indirect=True)
    public void sinf() throws Exception
    {
        call(this::sinf);
    }

    // function: Function(address=134341552, size=68, name='tanf', path='build/lib/libm/sf_tan.o', has_indirect=True)
    public void tanf() throws Exception
    {
        call(this::tanf);
    }

    // function: Function(address=134341620, size=10, name='lgammaf', path='build/lib/libm/wf_lgamma.o', has_indirect=True)
    public void lgammaf() throws Exception
    {
        call(this::lgammaf);
    }

    // function: Function(address=134341630, size=26, name='tgammaf', path='build/lib/libm/wf_tgamma.o', has_indirect=True)
    public void tgammaf() throws Exception
    {
        call(this::tgammaf);
    }

    // function: Function(address=134341656, size=276, name='__aeabi_uidiv', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(_udivsi3.o)', has_indirect=False)
    public void __aeabi_uidiv() throws Exception
    {
        call(this::__aeabi_uidiv);
    }

    // function: Function(address=134341924, size=8, name='__aeabi_uidivmod', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(_udivsi3.o)', has_indirect=False)
    public void __aeabi_uidivmod() throws Exception
    {
        call(this::__aeabi_uidivmod);
    }

    // function: Function(address=134341932, size=468, name='__divsi3', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(_divsi3.o)', has_indirect=False)
    public void __divsi3() throws Exception
    {
        call(this::__divsi3);
    }

    // function: Function(address=134342392, size=8, name='__aeabi_idivmod', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(_divsi3.o)', has_indirect=False)
    public void __aeabi_idivmod() throws Exception
    {
        call(this::__aeabi_idivmod);
    }

    // function: Function(address=134342400, size=4, name='__aeabi_idiv0', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(_dvmd_tls.o)', has_indirect=False)
    public void __aeabi_idiv0() throws Exception
    {
        call(this::__aeabi_idiv0);
    }

    // function: Function(address=134342404, size=116, name='__aeabi_cfrcmple', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(_arm_cmpsf2.o)', has_indirect=False)
    public void __aeabi_cfrcmple() throws Exception
    {
        call(this::__aeabi_cfrcmple);
    }

    // function: Function(address=134342412, size=16, name='__aeabi_cfcmpeq', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(_arm_cmpsf2.o)', has_indirect=False)
    public void __aeabi_cfcmpeq() throws Exception
    {
        call(this::__aeabi_cfcmpeq);
    }

    // function: Function(address=134342428, size=12, name='__aeabi_fcmpeq', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(_arm_cmpsf2.o)', has_indirect=False)
    public void __aeabi_fcmpeq() throws Exception
    {
        call(this::__aeabi_fcmpeq);
    }

    // function: Function(address=134342440, size=20, name='__aeabi_fcmplt', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(_arm_cmpsf2.o)', has_indirect=False)
    public void __aeabi_fcmplt() throws Exception
    {
        call(this::__aeabi_fcmplt);
    }

    // function: Function(address=134342460, size=20, name='__aeabi_fcmple', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(_arm_cmpsf2.o)', has_indirect=False)
    public void __aeabi_fcmple() throws Exception
    {
        call(this::__aeabi_fcmple);
    }

    // function: Function(address=134342480, size=20, name='__aeabi_fcmpgt', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(_arm_cmpsf2.o)', has_indirect=False)
    public void __aeabi_fcmpgt() throws Exception
    {
        call(this::__aeabi_fcmpgt);
    }

    // function: Function(address=134342500, size=20, name='__aeabi_fcmpge', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(_arm_cmpsf2.o)', has_indirect=False)
    public void __aeabi_fcmpge() throws Exception
    {
        call(this::__aeabi_fcmpge);
    }

    // function: Function(address=134342520, size=48, name='__fixunssfsi', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(_fixunssfsi.o)', has_indirect=False)
    public void __fixunssfsi() throws Exception
    {
        call(this::__fixunssfsi);
    }

    // function: Function(address=134342568, size=820, name='__aeabi_fadd', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(addsf3.o)', has_indirect=False)
    public void __aeabi_fadd() throws Exception
    {
        call(this::__aeabi_fadd);
    }

    // function: Function(address=134343388, size=548, name='__aeabi_fdiv', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(divsf3.o)', has_indirect=False)
    public void __aeabi_fdiv() throws Exception
    {
        call(this::__aeabi_fdiv);
    }

    // function: Function(address=134343936, size=80, name='__eqsf2', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(eqsf2.o)', has_indirect=False)
    public void __eqsf2() throws Exception
    {
        call(this::__eqsf2);
    }

    // function: Function(address=134344016, size=156, name='__gesf2', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(gesf2.o)', has_indirect=False)
    public void __gesf2() throws Exception
    {
        call(this::__gesf2);
    }

    // function: Function(address=134344172, size=160, name='__ltsf2', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(lesf2.o)', has_indirect=False)
    public void __ltsf2() throws Exception
    {
        call(this::__ltsf2);
    }

    // function: Function(address=134344332, size=612, name='__aeabi_fmul', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(mulsf3.o)', has_indirect=False)
    public void __aeabi_fmul() throws Exception
    {
        call(this::__aeabi_fmul);
    }

    // function: Function(address=134344944, size=904, name='__aeabi_fsub', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(subsf3.o)', has_indirect=False)
    public void __aeabi_fsub() throws Exception
    {
        call(this::__aeabi_fsub);
    }

    // function: Function(address=134345848, size=44, name='__aeabi_fcmpun', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(unordsf2.o)', has_indirect=False)
    public void __aeabi_fcmpun() throws Exception
    {
        call(this::__aeabi_fcmpun);
    }

    // function: Function(address=134345892, size=64, name='__aeabi_f2iz', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(fixsfsi.o)', has_indirect=False)
    public void __aeabi_f2iz() throws Exception
    {
        call(this::__aeabi_f2iz);
    }

    // function: Function(address=134345956, size=148, name='__aeabi_i2f', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(floatsisf.o)', has_indirect=False)
    public void __aeabi_i2f() throws Exception
    {
        call(this::__aeabi_i2f);
    }

    // function: Function(address=134346104, size=128, name='__aeabi_ui2f', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(floatunsisf.o)', has_indirect=False)
    public void __aeabi_ui2f() throws Exception
    {
        call(this::__aeabi_ui2f);
    }

    // function: Function(address=134346232, size=116, name='__aeabi_i2d', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(floatsidf.o)', has_indirect=False)
    public void __aeabi_i2d() throws Exception
    {
        call(this::__aeabi_i2d);
    }

    // function: Function(address=134346348, size=164, name='__aeabi_f2d', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(extendsfdf2.o)', has_indirect=False)
    public void __aeabi_f2d() throws Exception
    {
        call(this::__aeabi_f2d);
    }

    // function: Function(address=134346512, size=264, name='__aeabi_d2f', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(truncdfsf2.o)', has_indirect=False)
    public void __aeabi_d2f() throws Exception
    {
        call(this::__aeabi_d2f);
    }

    // function: Function(address=134346776, size=60, name='__clzsi2', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(_clzsi2.o)', has_indirect=False)
    public void __clzsi2() throws Exception
    {
        call(this::__clzsi2);
    }

} // MicroPython
