package kr.pe.ecmaxp.micropython.example;

import kr.pe.ecmaxp.thumbsk.CPU;
import org.jetbrains.annotations.NotNull;

abstract public class MicroPython_vals extends MicroPython_base
{
    public MicroPython_vals(@NotNull CPU cpu)
    {
        super(cpu);
    }

    // value: Function(address=134346432, size=70, name='gc_dump_alloc_table_str1_4', path='build/py/gc.o', has_indirect=False)
    protected int gc_dump_alloc_table_str1_4 = 0x0801f6c0;

    // value: Function(address=134346504, size=105, name='gc_dump_info_str1_4', path='build/py/gc.o', has_indirect=False)
    protected int gc_dump_info_str1_4 = 0x0801f708;

    // value: Function(address=134346609, size=93, name='rodata', path='build/py/qstr.o', has_indirect=False)
    protected int rodata = 0x0801f771;

    // value: Function(address=134346704, size=2264, name='mp_qstr_const_pool', path='build/py/qstr.o', has_indirect=False)
    protected int mp_qstr_const_pool = 0x0801f7d0;

    // value: Function(address=134348968, size=7, name='qstr_dump_data_str1_1', path='build/py/qstr.o', has_indirect=False)
    protected int qstr_dump_data_str1_1 = 0x080200a8;

    // value: Function(address=134348975, size=6178, name='str1_1', path='build/py/qstr.o', has_indirect=False)
    protected int str1_1 = 0x080200af;

    // value: Function(address=134355156, size=8, name='mp_plat_print', path='build/py/mpprint.o', has_indirect=False)
    protected int mp_plat_print = 0x080218d4;

    // value: Function(address=134355164, size=11, name='mp_vprintf_str1_1', path='build/py/mpprint.o', has_indirect=False)
    protected int mp_vprintf_str1_1 = 0x080218dc;

    // value: Function(address=134355175, size=17, name='pad_spaces', path='build/py/mpprint.o', has_indirect=False)
    protected int pad_spaces = 0x080218e7;

    // value: Function(address=134355192, size=17, name='pad_zeroes', path='build/py/mpprint.o', has_indirect=False)
    protected int pad_zeroes = 0x080218f8;

    // value: Function(address=134355209, size=128, name='rodata_attr', path='build/py/unicode.o', has_indirect=False)
    protected int rodata_attr = 0x08021909;

    // value: Function(address=134355337, size=86, name='mp_lexer_to_next_str1_1', path='build/py/lexer.o', has_indirect=False)
    protected int mp_lexer_to_next_str1_1 = 0x08021989;

    // value: Function(address=134355423, size=145, name='str1_1__2', path='build/py/lexer.o', has_indirect=False)
    protected int str1_1__2 = 0x080219df;

    // value: Function(address=134355568, size=42, name='tok_enc_kind', path='build/py/lexer.o', has_indirect=False)
    protected int tok_enc_kind = 0x08021a70;

    // value: Function(address=134355612, size=144, name='tok_kw', path='build/py/lexer.o', has_indirect=False)
    protected int tok_kw = 0x08021a9c;

    // value: Function(address=134355756, size=12, name='mp_constants_map', path='build/py/parse.o', has_indirect=False)
    protected int mp_constants_map = 0x08021b2c;

    // value: Function(address=134355768, size=16, name='mp_constants_table', path='build/py/parse.o', has_indirect=False)
    protected int mp_constants_table = 0x08021b38;

    // value: Function(address=134355784, size=85, name='mp_parse_str1_1', path='build/py/parse.o', has_indirect=False)
    protected int mp_parse_str1_1 = 0x08021b48;

    // value: Function(address=134355869, size=28, name='push_result_rule_str1_1', path='build/py/parse.o', has_indirect=False)
    protected int push_result_rule_str1_1 = 0x08021b9d;

    // value: Function(address=134355897, size=175, name='rule_act_table', path='build/py/parse.o', has_indirect=False)
    protected int rule_act_table = 0x08021bb9;

    // value: Function(address=134356072, size=890, name='rule_arg_combined_table', path='build/py/parse.o', has_indirect=False)
    protected int rule_arg_combined_table = 0x08021c68;

    // value: Function(address=134356962, size=175, name='rule_arg_offset_table', path='build/py/parse.o', has_indirect=False)
    protected int rule_arg_offset_table = 0x08021fe2;

    // value: Function(address=134357137, size=11, name='token_to_op_8357', path='build/py/parse.o', has_indirect=False)
    protected int token_to_op_8357 = 0x08022091;

    // value: Function(address=134357148, size=7, name='scope_simple_name_table', path='build/py/scope.o', has_indirect=False)
    protected int scope_simple_name_table = 0x0802209c;

    // value: Function(address=134357155, size=9, name='CSWTCH_222', path='build/py/compile.o', has_indirect=False)
    protected int CSWTCH_222 = 0x080220a3;

    // value: Function(address=134357164, size=11, name='CSWTCH_225', path='build/py/compile.o', has_indirect=False)
    protected int CSWTCH_225 = 0x080220ac;

    // value: Function(address=134357175, size=12, name='CSWTCH_230', path='build/py/compile.o', has_indirect=False)
    protected int CSWTCH_230 = 0x080220b7;

    // value: Function(address=134357187, size=27, name='c_assign_str1_1', path='build/py/compile.o', has_indirect=False)
    protected int c_assign_str1_1 = 0x080220c3;

    // value: Function(address=134357214, size=26, name='c_assign_tuple_str1_1', path='build/py/compile.o', has_indirect=False)
    protected int c_assign_tuple_str1_1 = 0x080220de;

    // value: Function(address=134357240, size=24, name='c_del_stmt_str1_1', path='build/py/compile.o', has_indirect=False)
    protected int c_del_stmt_str1_1 = 0x080220f8;

    // value: Function(address=134357264, size=60, name='compile_atom_brace_str1_1', path='build/py/compile.o', has_indirect=False)
    protected int compile_atom_brace_str1_1 = 0x08022110;

    // value: Function(address=134357324, size=25, name='compile_atom_expr_await_str1_1', path='build/py/compile.o', has_indirect=False)
    protected int compile_atom_expr_await_str1_1 = 0x0802214c;

    // value: Function(address=134357349, size=24, name='compile_atom_expr_normal_str1_1', path='build/py/compile.o', has_indirect=False)
    protected int compile_atom_expr_normal_str1_1 = 0x08022165;

    // value: Function(address=134357373, size=45, name='compile_break_cont_stmt_str1_1', path='build/py/compile.o', has_indirect=False)
    protected int compile_break_cont_stmt_str1_1 = 0x0802217d;

    // value: Function(address=134357418, size=30, name='compile_decorated_str1_1', path='build/py/compile.o', has_indirect=False)
    protected int compile_decorated_str1_1 = 0x080221aa;

    // value: Function(address=134357448, size=46, name='compile_funcdef_lambdef_param_str1_1', path='build/py/compile.o', has_indirect=False)
    protected int compile_funcdef_lambdef_param_str1_1 = 0x080221c8;

    // value: Function(address=134357496, size=232, name='compile_function', path='build/py/compile.o', has_indirect=False)
    protected int compile_function = 0x080221f8;

    // value: Function(address=134357728, size=131, name='compile_global_nonlocal_stmt_str1_1', path='build/py/compile.o', has_indirect=False)
    protected int compile_global_nonlocal_stmt_str1_1 = 0x080222e0;

    // value: Function(address=134357859, size=26, name='compile_return_stmt_str1_1', path='build/py/compile.o', has_indirect=False)
    protected int compile_return_stmt_str1_1 = 0x08022363;

    // value: Function(address=134357885, size=25, name='compile_scope_func_lambda_param_isra_5_str1_1', path='build/py/compile.o', has_indirect=False)
    protected int compile_scope_func_lambda_param_isra_5_str1_1 = 0x0802237d;

    // value: Function(address=134357910, size=29, name='compile_star_expr_str1_1', path='build/py/compile.o', has_indirect=False)
    protected int compile_star_expr_str1_1 = 0x08022396;

    // value: Function(address=134357939, size=141, name='compile_trailer_paren_helper_str1_1', path='build/py/compile.o', has_indirect=False)
    protected int compile_trailer_paren_helper_str1_1 = 0x080223b3;

    // value: Function(address=134358080, size=30, name='compile_try_except_str1_1', path='build/py/compile.o', has_indirect=False)
    protected int compile_try_except_str1_1 = 0x08022440;

    // value: Function(address=134358110, size=25, name='compile_yield_expr_str1_1', path='build/py/compile.o', has_indirect=False)
    protected int compile_yield_expr_str1_1 = 0x0802245e;

    // value: Function(address=134358136, size=8, name='mp_emit_bc_method_table_delete_id_ops', path='build/py/emitbc.o', has_indirect=False)
    protected int mp_emit_bc_method_table_delete_id_ops = 0x08022478;

    // value: Function(address=134358144, size=8, name='mp_emit_bc_method_table_load_id_ops', path='build/py/emitbc.o', has_indirect=False)
    protected int mp_emit_bc_method_table_load_id_ops = 0x08022480;

    // value: Function(address=134358152, size=8, name='mp_emit_bc_method_table_store_id_ops', path='build/py/emitbc.o', has_indirect=False)
    protected int mp_emit_bc_method_table_store_id_ops = 0x08022488;

    // value: Function(address=134358160, size=24, name='g_neg_pow', path='build/py/formatfloat.o', has_indirect=False)
    protected int g_neg_pow = 0x08022490;

    // value: Function(address=134358184, size=24, name='g_pos_pow', path='build/py/formatfloat.o', has_indirect=False)
    protected int g_pos_pow = 0x080224a8;

    // value: Function(address=134358208, size=26, name='mp_parse_num_decimal_str1_1', path='build/py/parsenum.o', has_indirect=False)
    protected int mp_parse_num_decimal_str1_1 = 0x080224c0;

    // value: Function(address=134358234, size=77, name='mp_parse_num_integer_str1_1', path='build/py/parsenum.o', has_indirect=False)
    protected int mp_parse_num_integer_str1_1 = 0x080224da;

    // value: Function(address=134358311, size=23, name='mp_raw_code_load_str1_1', path='build/py/persistentcode.o', has_indirect=False)
    protected int mp_raw_code_load_str1_1 = 0x08022527;

    // value: Function(address=134358334, size=37, name='checked_fun_call_str1_1', path='build/py/runtime.o', has_indirect=False)
    protected int checked_fun_call_str1_1 = 0x0802253e;

    // value: Function(address=134358371, size=87, name='m_malloc_fail_str1_1', path='build/py/runtime.o', has_indirect=False)
    protected int m_malloc_fail_str1_1 = 0x08022563;

    // value: Function(address=134358458, size=58, name='mp_binary_op_str1_1', path='build/py/runtime.o', has_indirect=False)
    protected int mp_binary_op_str1_1 = 0x080225ba;

    // value: Function(address=134358516, size=28, name='mp_call_function_n_kw_str1_1', path='build/py/runtime.o', has_indirect=False)
    protected int mp_call_function_n_kw_str1_1 = 0x080225f4;

    // value: Function(address=134358544, size=28, name='mp_getiter_str1_1', path='build/py/runtime.o', has_indirect=False)
    protected int mp_getiter_str1_1 = 0x08022610;

    // value: Function(address=134358572, size=22, name='mp_import_from_str1_1', path='build/py/runtime.o', has_indirect=False)
    protected int mp_import_from_str1_1 = 0x0802262c;

    // value: Function(address=134358594, size=31, name='mp_iternext_allow_raise_str1_1', path='build/py/runtime.o', has_indirect=False)
    protected int mp_iternext_allow_raise_str1_1 = 0x08022642;

    // value: Function(address=134358625, size=25, name='mp_load_global_str1_1', path='build/py/runtime.o', has_indirect=False)
    protected int mp_load_global_str1_1 = 0x08022661;

    // value: Function(address=134358650, size=73, name='mp_load_method_str1_1', path='build/py/runtime.o', has_indirect=False)
    protected int mp_load_method_str1_1 = 0x0802267a;

    // value: Function(address=134358723, size=42, name='mp_make_raise_obj_str1_1', path='build/py/runtime.o', has_indirect=False)
    protected int mp_make_raise_obj_str1_1 = 0x080226c3;

    // value: Function(address=134358768, size=8, name='mp_module___main__', path='build/py/runtime.o', has_indirect=False)
    protected int mp_module___main__ = 0x080226f0;

    // value: Function(address=134358776, size=60, name='mp_type_checked_fun', path='build/py/runtime.o', has_indirect=False)
    protected int mp_type_checked_fun = 0x080226f8;

    // value: Function(address=134358836, size=30, name='mp_unary_op_str1_1', path='build/py/runtime.o', has_indirect=False)
    protected int mp_unary_op_str1_1 = 0x08022734;

    // value: Function(address=134358866, size=75, name='mp_unpack_sequence_str1_1', path='build/py/runtime.o', has_indirect=False)
    protected int mp_unpack_sequence_str1_1 = 0x08022752;

    // value: Function(address=134358941, size=195, name='mp_arg_check_num_str1_1', path='build/py/argcheck.o', has_indirect=False)
    protected int mp_arg_check_num_str1_1 = 0x0802279d;

    // value: Function(address=134359136, size=66, name='mp_arg_error_unimpl_kw_str1_1', path='build/py/argcheck.o', has_indirect=False)
    protected int mp_arg_error_unimpl_kw_str1_1 = 0x08022860;

    // value: Function(address=134359202, size=86, name='mp_arg_parse_all_str1_1', path='build/py/argcheck.o', has_indirect=False)
    protected int mp_arg_parse_all_str1_1 = 0x080228a2;

    // value: Function(address=134359288, size=10, name='mp_warning_str1_1', path='build/py/warning.o', has_indirect=False)
    protected int mp_warning_str1_1 = 0x080228f8;

    // value: Function(address=134359298, size=68, name='hash_allocation_sizes', path='build/py/map.o', has_indirect=False)
    protected int hash_allocation_sizes = 0x08022902;

    // value: Function(address=134359368, size=12, name='mp_const_empty_map', path='build/py/map.o', has_indirect=False)
    protected int mp_const_empty_map = 0x08022948;

    // value: Function(address=134359380, size=37, name='mp_get_buffer_raise_str1_1', path='build/py/obj.o', has_indirect=False)
    protected int mp_get_buffer_raise_str1_1 = 0x08022954;

    // value: Function(address=134359417, size=58, name='mp_get_index_str1_1', path='build/py/obj.o', has_indirect=False)
    protected int mp_get_index_str1_1 = 0x08022979;

    // value: Function(address=134359476, size=8, name='mp_identity_obj', path='build/py/obj.o', has_indirect=False)
    protected int mp_identity_obj = 0x080229b4;

    // value: Function(address=134359484, size=33, name='mp_obj_equal_str1_1', path='build/py/obj.o', has_indirect=False)
    protected int mp_obj_equal_str1_1 = 0x080229bc;

    // value: Function(address=134359517, size=35, name='mp_obj_get_array_str1_1', path='build/py/obj.o', has_indirect=False)
    protected int mp_obj_get_array_str1_1 = 0x080229dd;

    // value: Function(address=134359552, size=45, name='mp_obj_get_array_fixed_n_str1_1', path='build/py/obj.o', has_indirect=False)
    protected int mp_obj_get_array_fixed_n_str1_1 = 0x08022a00;

    // value: Function(address=134359597, size=28, name='mp_obj_get_complex_str1_1', path='build/py/obj.o', has_indirect=False)
    protected int mp_obj_get_complex_str1_1 = 0x08022a2d;

    // value: Function(address=134359625, size=26, name='mp_obj_get_float_str1_1', path='build/py/obj.o', has_indirect=False)
    protected int mp_obj_get_float_str1_1 = 0x08022a49;

    // value: Function(address=134359651, size=24, name='mp_obj_get_int_str1_1', path='build/py/obj.o', has_indirect=False)
    protected int mp_obj_get_int_str1_1 = 0x08022a63;

    // value: Function(address=134359675, size=33, name='mp_obj_len_str1_1', path='build/py/obj.o', has_indirect=False)
    protected int mp_obj_len_str1_1 = 0x08022a7b;

    // value: Function(address=134359708, size=66, name='mp_obj_print_exception_str1_1', path='build/py/obj.o', has_indirect=False)
    protected int mp_obj_print_exception_str1_1 = 0x08022a9c;

    // value: Function(address=134359774, size=5, name='mp_obj_print_helper_str1_1', path='build/py/obj.o', has_indirect=False)
    protected int mp_obj_print_helper_str1_1 = 0x08022ade;

    // value: Function(address=134359779, size=121, name='mp_obj_subscr_str1_1', path='build/py/obj.o', has_indirect=False)
    protected int mp_obj_subscr_str1_1 = 0x08022ae3;

    // value: Function(address=134359900, size=8, name='array_append_obj', path='build/py/objarray.o', has_indirect=False)
    protected int array_append_obj = 0x08022b5c;

    // value: Function(address=134359908, size=8, name='array_extend_obj', path='build/py/objarray.o', has_indirect=False)
    protected int array_extend_obj = 0x08022b64;

    // value: Function(address=134359916, size=60, name='array_it_type', path='build/py/objarray.o', has_indirect=False)
    protected int array_it_type = 0x08022b6c;

    // value: Function(address=134359976, size=16, name='array_locals_dict', path='build/py/objarray.o', has_indirect=False)
    protected int array_locals_dict = 0x08022ba8;

    // value: Function(address=134359992, size=16, name='array_locals_dict_table', path='build/py/objarray.o', has_indirect=False)
    protected int array_locals_dict_table = 0x08022bb8;

    // value: Function(address=134360008, size=32, name='array_print_str1_1', path='build/py/objarray.o', has_indirect=False)
    protected int array_print_str1_1 = 0x08022bc8;

    // value: Function(address=134360040, size=117, name='array_subscr_str1_1', path='build/py/objarray.o', has_indirect=False)
    protected int array_subscr_str1_1 = 0x08022be8;

    // value: Function(address=134360160, size=60, name='mp_type_array', path='build/py/objarray.o', has_indirect=False)
    protected int mp_type_array = 0x08022c60;

    // value: Function(address=134360220, size=60, name='mp_type_bytearray', path='build/py/objarray.o', has_indirect=False)
    protected int mp_type_bytearray = 0x08022c9c;

    // value: Function(address=134360280, size=60, name='mp_type_memoryview', path='build/py/objarray.o', has_indirect=False)
    protected int mp_type_memoryview = 0x08022cd8;

    // value: Function(address=134360340, size=4, name='mp_obj_attrtuple_print_helper_str1_1', path='build/py/objattrtuple.o', has_indirect=False)
    protected int mp_obj_attrtuple_print_helper_str1_1 = 0x08022d14;

    // value: Function(address=134360344, size=60, name='mp_type_attrtuple', path='build/py/objattrtuple.o', has_indirect=False)
    protected int mp_type_attrtuple = 0x08022d18;

    // value: Function(address=134360404, size=8, name='mp_const_false_obj', path='build/py/objbool.o', has_indirect=False)
    protected int mp_const_false_obj = 0x08022d54;

    // value: Function(address=134360412, size=8, name='mp_const_true_obj', path='build/py/objbool.o', has_indirect=False)
    protected int mp_const_true_obj = 0x08022d5c;

    // value: Function(address=134360420, size=60, name='mp_type_bool', path='build/py/objbool.o', has_indirect=False)
    protected int mp_type_bool = 0x08022d64;

    // value: Function(address=134360480, size=18, name='bound_meth_print_str1_1', path='build/py/objboundmeth.o', has_indirect=False)
    protected int bound_meth_print_str1_1 = 0x08022da0;

    // value: Function(address=134360500, size=60, name='mp_type_bound_meth', path='build/py/objboundmeth.o', has_indirect=False)
    protected int mp_type_bound_meth = 0x08022db4;

    // value: Function(address=134360560, size=16, name='cell_print_str1_1', path='build/py/objcell.o', has_indirect=False)
    protected int cell_print_str1_1 = 0x08022df0;

    // value: Function(address=134360576, size=60, name='mp_type_cell', path='build/py/objcell.o', has_indirect=False)
    protected int mp_type_cell = 0x08022e00;

    // value: Function(address=134360636, size=31, name='closure_print_str1_1', path='build/py/objclosure.o', has_indirect=False)
    protected int closure_print_str1_1 = 0x08022e3c;

    // value: Function(address=134360668, size=60, name='closure_type', path='build/py/objclosure.o', has_indirect=False)
    protected int closure_type = 0x08022e5c;

    // value: Function(address=134360728, size=15, name='complex_print_str1_1', path='build/py/objcomplex.o', has_indirect=False)
    protected int complex_print_str1_1 = 0x08022e98;

    // value: Function(address=134360743, size=96, name='mp_obj_complex_binary_op_str1_1', path='build/py/objcomplex.o', has_indirect=False)
    protected int mp_obj_complex_binary_op_str1_1 = 0x08022ea7;

    // value: Function(address=134360840, size=60, name='mp_type_complex', path='build/py/objcomplex.o', has_indirect=False)
    protected int mp_type_complex = 0x08022f08;

    // value: Function(address=134360900, size=8, name='deque_append_obj', path='build/py/objdeque.o', has_indirect=False)
    protected int deque_append_obj = 0x08022f44;

    // value: Function(address=134360908, size=16, name='deque_locals_dict', path='build/py/objdeque.o', has_indirect=False)
    protected int deque_locals_dict = 0x08022f4c;

    // value: Function(address=134360924, size=16, name='deque_locals_dict_table', path='build/py/objdeque.o', has_indirect=False)
    protected int deque_locals_dict_table = 0x08022f5c;

    // value: Function(address=134360940, size=8, name='deque_popleft_obj', path='build/py/objdeque.o', has_indirect=False)
    protected int deque_popleft_obj = 0x08022f6c;

    // value: Function(address=134360948, size=60, name='mp_type_deque', path='build/py/objdeque.o', has_indirect=False)
    protected int mp_type_deque = 0x08022f74;

    // value: Function(address=134361008, size=8, name='dict_clear_obj', path='build/py/objdict.o', has_indirect=False)
    protected int dict_clear_obj = 0x08022fb0;

    // value: Function(address=134361016, size=8, name='dict_copy_obj', path='build/py/objdict.o', has_indirect=False)
    protected int dict_copy_obj = 0x08022fb8;

    // value: Function(address=134361024, size=12, name='dict_fromkeys_fun_obj', path='build/py/objdict.o', has_indirect=False)
    protected int dict_fromkeys_fun_obj = 0x08022fc0;

    // value: Function(address=134361036, size=8, name='dict_fromkeys_obj', path='build/py/objdict.o', has_indirect=False)
    protected int dict_fromkeys_obj = 0x08022fcc;

    // value: Function(address=134361044, size=12, name='dict_get_obj', path='build/py/objdict.o', has_indirect=False)
    protected int dict_get_obj = 0x08022fd4;

    // value: Function(address=134361056, size=8, name='dict_items_obj', path='build/py/objdict.o', has_indirect=False)
    protected int dict_items_obj = 0x08022fe0;

    // value: Function(address=134361064, size=8, name='dict_keys_obj', path='build/py/objdict.o', has_indirect=False)
    protected int dict_keys_obj = 0x08022fe8;

    // value: Function(address=134361072, size=16, name='dict_locals_dict', path='build/py/objdict.o', has_indirect=False)
    protected int dict_locals_dict = 0x08022ff0;

    // value: Function(address=134361088, size=112, name='dict_locals_dict_table', path='build/py/objdict.o', has_indirect=False)
    protected int dict_locals_dict_table = 0x08023000;

    // value: Function(address=134361200, size=12, name='dict_pop_obj', path='build/py/objdict.o', has_indirect=False)
    protected int dict_pop_obj = 0x08023070;

    // value: Function(address=134361212, size=31, name='dict_popitem_str1_1', path='build/py/objdict.o', has_indirect=False)
    protected int dict_popitem_str1_1 = 0x0802307c;

    // value: Function(address=134361244, size=8, name='dict_popitem_obj', path='build/py/objdict.o', has_indirect=False)
    protected int dict_popitem_obj = 0x0802309c;

    // value: Function(address=134361252, size=6, name='dict_print_str1_1', path='build/py/objdict.o', has_indirect=False)
    protected int dict_print_str1_1 = 0x080230a4;

    // value: Function(address=134361260, size=12, name='dict_setdefault_obj', path='build/py/objdict.o', has_indirect=False)
    protected int dict_setdefault_obj = 0x080230ac;

    // value: Function(address=134361272, size=38, name='dict_update_str1_1', path='build/py/objdict.o', has_indirect=False)
    protected int dict_update_str1_1 = 0x080230b8;

    // value: Function(address=134361312, size=12, name='dict_update_obj', path='build/py/objdict.o', has_indirect=False)
    protected int dict_update_obj = 0x080230e0;

    // value: Function(address=134361324, size=8, name='dict_values_obj', path='build/py/objdict.o', has_indirect=False)
    protected int dict_values_obj = 0x080230ec;

    // value: Function(address=134361332, size=60, name='dict_view_it_type', path='build/py/objdict.o', has_indirect=False)
    protected int dict_view_it_type = 0x080230f4;

    // value: Function(address=134361392, size=6, name='dict_view_print_str1_1', path='build/py/objdict.o', has_indirect=False)
    protected int dict_view_print_str1_1 = 0x08023130;

    // value: Function(address=134361400, size=60, name='dict_view_type', path='build/py/objdict.o', has_indirect=False)
    protected int dict_view_type = 0x08023138;

    // value: Function(address=134361460, size=12, name='mp_dict_view_names', path='build/py/objdict.o', has_indirect=False)
    protected int mp_dict_view_names = 0x08023174;

    // value: Function(address=134361472, size=60, name='mp_type_dict', path='build/py/objdict.o', has_indirect=False)
    protected int mp_type_dict = 0x08023180;

    // value: Function(address=134361532, size=60, name='mp_type_ordereddict', path='build/py/objdict.o', has_indirect=False)
    protected int mp_type_ordereddict = 0x080231bc;

    // value: Function(address=134361592, size=33, name='str1_1__3', path='build/py/objdict.o', has_indirect=False)
    protected int str1_1__3 = 0x080231f8;

    // value: Function(address=134361628, size=16, name='allowed_args_6525', path='build/py/objenumerate.o', has_indirect=False)
    protected int allowed_args_6525 = 0x0802321c;

    // value: Function(address=134361644, size=60, name='mp_type_enumerate', path='build/py/objenumerate.o', has_indirect=False)
    protected int mp_type_enumerate = 0x0802322c;

    // value: Function(address=134361704, size=16, name='mp_const_GeneratorExit_obj', path='build/py/objexcept.o', has_indirect=False)
    protected int mp_const_GeneratorExit_obj = 0x08023268;

    // value: Function(address=134361720, size=14, name='mp_obj_exception_print_str1_1', path='build/py/objexcept.o', has_indirect=False)
    protected int mp_obj_exception_print_str1_1 = 0x08023278;

    // value: Function(address=134361736, size=60, name='mp_type_ArithmeticError', path='build/py/objexcept.o', has_indirect=False)
    protected int mp_type_ArithmeticError = 0x08023288;

    // value: Function(address=134361796, size=60, name='mp_type_AssertionError', path='build/py/objexcept.o', has_indirect=False)
    protected int mp_type_AssertionError = 0x080232c4;

    // value: Function(address=134361856, size=60, name='mp_type_AttributeError', path='build/py/objexcept.o', has_indirect=False)
    protected int mp_type_AttributeError = 0x08023300;

    // value: Function(address=134361916, size=60, name='mp_type_BaseException', path='build/py/objexcept.o', has_indirect=False)
    protected int mp_type_BaseException = 0x0802333c;

    // value: Function(address=134361976, size=60, name='mp_type_EOFError', path='build/py/objexcept.o', has_indirect=False)
    protected int mp_type_EOFError = 0x08023378;

    // value: Function(address=134362036, size=60, name='mp_type_Exception', path='build/py/objexcept.o', has_indirect=False)
    protected int mp_type_Exception = 0x080233b4;

    // value: Function(address=134362096, size=60, name='mp_type_GeneratorExit', path='build/py/objexcept.o', has_indirect=False)
    protected int mp_type_GeneratorExit = 0x080233f0;

    // value: Function(address=134362156, size=60, name='mp_type_ImportError', path='build/py/objexcept.o', has_indirect=False)
    protected int mp_type_ImportError = 0x0802342c;

    // value: Function(address=134362216, size=60, name='mp_type_IndentationError', path='build/py/objexcept.o', has_indirect=False)
    protected int mp_type_IndentationError = 0x08023468;

    // value: Function(address=134362276, size=60, name='mp_type_IndexError', path='build/py/objexcept.o', has_indirect=False)
    protected int mp_type_IndexError = 0x080234a4;

    // value: Function(address=134362336, size=60, name='mp_type_KeyError', path='build/py/objexcept.o', has_indirect=False)
    protected int mp_type_KeyError = 0x080234e0;

    // value: Function(address=134362396, size=60, name='mp_type_KeyboardInterrupt', path='build/py/objexcept.o', has_indirect=False)
    protected int mp_type_KeyboardInterrupt = 0x0802351c;

    // value: Function(address=134362456, size=60, name='mp_type_LookupError', path='build/py/objexcept.o', has_indirect=False)
    protected int mp_type_LookupError = 0x08023558;

    // value: Function(address=134362516, size=60, name='mp_type_MemoryError', path='build/py/objexcept.o', has_indirect=False)
    protected int mp_type_MemoryError = 0x08023594;

    // value: Function(address=134362576, size=60, name='mp_type_NameError', path='build/py/objexcept.o', has_indirect=False)
    protected int mp_type_NameError = 0x080235d0;

    // value: Function(address=134362636, size=60, name='mp_type_NotImplementedError', path='build/py/objexcept.o', has_indirect=False)
    protected int mp_type_NotImplementedError = 0x0802360c;

    // value: Function(address=134362696, size=60, name='mp_type_OSError', path='build/py/objexcept.o', has_indirect=False)
    protected int mp_type_OSError = 0x08023648;

    // value: Function(address=134362756, size=60, name='mp_type_OverflowError', path='build/py/objexcept.o', has_indirect=False)
    protected int mp_type_OverflowError = 0x08023684;

    // value: Function(address=134362816, size=60, name='mp_type_RuntimeError', path='build/py/objexcept.o', has_indirect=False)
    protected int mp_type_RuntimeError = 0x080236c0;

    // value: Function(address=134362876, size=60, name='mp_type_StopAsyncIteration', path='build/py/objexcept.o', has_indirect=False)
    protected int mp_type_StopAsyncIteration = 0x080236fc;

    // value: Function(address=134362936, size=60, name='mp_type_StopIteration', path='build/py/objexcept.o', has_indirect=False)
    protected int mp_type_StopIteration = 0x08023738;

    // value: Function(address=134362996, size=60, name='mp_type_SyntaxError', path='build/py/objexcept.o', has_indirect=False)
    protected int mp_type_SyntaxError = 0x08023774;

    // value: Function(address=134363056, size=60, name='mp_type_SystemExit', path='build/py/objexcept.o', has_indirect=False)
    protected int mp_type_SystemExit = 0x080237b0;

    // value: Function(address=134363116, size=60, name='mp_type_TypeError', path='build/py/objexcept.o', has_indirect=False)
    protected int mp_type_TypeError = 0x080237ec;

    // value: Function(address=134363176, size=60, name='mp_type_UnicodeError', path='build/py/objexcept.o', has_indirect=False)
    protected int mp_type_UnicodeError = 0x08023828;

    // value: Function(address=134363236, size=60, name='mp_type_ValueError', path='build/py/objexcept.o', has_indirect=False)
    protected int mp_type_ValueError = 0x08023864;

    // value: Function(address=134363296, size=60, name='mp_type_ZeroDivisionError', path='build/py/objexcept.o', has_indirect=False)
    protected int mp_type_ZeroDivisionError = 0x080238a0;

    // value: Function(address=134363356, size=60, name='mp_type_filter', path='build/py/objfilter.o', has_indirect=False)
    protected int mp_type_filter = 0x080238dc;

    // value: Function(address=134363416, size=8, name='mp_const_float_e_obj', path='build/py/objfloat.o', has_indirect=False)
    protected int mp_const_float_e_obj = 0x08023918;

    // value: Function(address=134363424, size=8, name='mp_const_float_pi_obj', path='build/py/objfloat.o', has_indirect=False)
    protected int mp_const_float_pi_obj = 0x08023920;

    // value: Function(address=134363432, size=60, name='mp_type_float', path='build/py/objfloat.o', has_indirect=False)
    protected int mp_type_float = 0x08023928;

    // value: Function(address=134363492, size=22, name='fun_bc_print_str1_1', path='build/py/objfun.o', has_indirect=False)
    protected int fun_bc_print_str1_1 = 0x08023964;

    // value: Function(address=134363516, size=60, name='mp_type_fun_bc', path='build/py/objfun.o', has_indirect=False)
    protected int mp_type_fun_bc = 0x0802397c;

    // value: Function(address=134363576, size=60, name='mp_type_fun_builtin_0', path='build/py/objfun.o', has_indirect=False)
    protected int mp_type_fun_builtin_0 = 0x080239b8;

    // value: Function(address=134363636, size=60, name='mp_type_fun_builtin_1', path='build/py/objfun.o', has_indirect=False)
    protected int mp_type_fun_builtin_1 = 0x080239f4;

    // value: Function(address=134363696, size=60, name='mp_type_fun_builtin_2', path='build/py/objfun.o', has_indirect=False)
    protected int mp_type_fun_builtin_2 = 0x08023a30;

    // value: Function(address=134363756, size=60, name='mp_type_fun_builtin_3', path='build/py/objfun.o', has_indirect=False)
    protected int mp_type_fun_builtin_3 = 0x08023a6c;

    // value: Function(address=134363816, size=60, name='mp_type_fun_builtin_var', path='build/py/objfun.o', has_indirect=False)
    protected int mp_type_fun_builtin_var = 0x08023aa8;

    // value: Function(address=134363876, size=32, name='gen_instance_close_str1_1', path='build/py/objgenerator.o', has_indirect=False)
    protected int gen_instance_close_str1_1 = 0x08023ae4;

    // value: Function(address=134363908, size=8, name='gen_instance_close_obj', path='build/py/objgenerator.o', has_indirect=False)
    protected int gen_instance_close_obj = 0x08023b04;

    // value: Function(address=134363916, size=16, name='gen_instance_locals_dict', path='build/py/objgenerator.o', has_indirect=False)
    protected int gen_instance_locals_dict = 0x08023b0c;

    // value: Function(address=134363932, size=32, name='gen_instance_locals_dict_table', path='build/py/objgenerator.o', has_indirect=False)
    protected int gen_instance_locals_dict_table = 0x08023b1c;

    // value: Function(address=134363964, size=43, name='gen_instance_pend_throw_str1_1', path='build/py/objgenerator.o', has_indirect=False)
    protected int gen_instance_pend_throw_str1_1 = 0x08023b3c;

    // value: Function(address=134364008, size=8, name='gen_instance_pend_throw_obj', path='build/py/objgenerator.o', has_indirect=False)
    protected int gen_instance_pend_throw_obj = 0x08023b68;

    // value: Function(address=134364016, size=30, name='gen_instance_print_str1_1', path='build/py/objgenerator.o', has_indirect=False)
    protected int gen_instance_print_str1_1 = 0x08023b70;

    // value: Function(address=134364048, size=8, name='gen_instance_send_obj', path='build/py/objgenerator.o', has_indirect=False)
    protected int gen_instance_send_obj = 0x08023b90;

    // value: Function(address=134364056, size=12, name='gen_instance_throw_obj', path='build/py/objgenerator.o', has_indirect=False)
    protected int gen_instance_throw_obj = 0x08023b98;

    // value: Function(address=134364068, size=82, name='mp_obj_gen_resume_str1_1', path='build/py/objgenerator.o', has_indirect=False)
    protected int mp_obj_gen_resume_str1_1 = 0x08023ba4;

    // value: Function(address=134364152, size=60, name='mp_type_gen_instance', path='build/py/objgenerator.o', has_indirect=False)
    protected int mp_type_gen_instance = 0x08023bf8;

    // value: Function(address=134364212, size=60, name='mp_type_gen_wrap', path='build/py/objgenerator.o', has_indirect=False)
    protected int mp_type_gen_wrap = 0x08023c34;

    // value: Function(address=134364272, size=60, name='it_type', path='build/py/objgetitemiter.o', has_indirect=False)
    protected int it_type = 0x08023c70;

    // value: Function(address=134364332, size=12, name='int_from_bytes_fun_obj', path='build/py/objint.o', has_indirect=False)
    protected int int_from_bytes_fun_obj = 0x08023cac;

    // value: Function(address=134364344, size=8, name='int_from_bytes_obj', path='build/py/objint.o', has_indirect=False)
    protected int int_from_bytes_obj = 0x08023cb8;

    // value: Function(address=134364352, size=16, name='int_locals_dict', path='build/py/objint.o', has_indirect=False)
    protected int int_locals_dict = 0x08023cc0;

    // value: Function(address=134364368, size=16, name='int_locals_dict_table', path='build/py/objint.o', has_indirect=False)
    protected int int_locals_dict_table = 0x08023cd0;

    // value: Function(address=134364384, size=12, name='int_to_bytes_obj', path='build/py/objint.o', has_indirect=False)
    protected int int_to_bytes_obj = 0x08023ce0;

    // value: Function(address=134364396, size=16, name='log_base2_floor', path='build/py/objint.o', has_indirect=False)
    protected int log_base2_floor = 0x08023cec;

    // value: Function(address=134364412, size=50, name='mp_obj_new_int_from_float_str1_1', path='build/py/objint.o', has_indirect=False)
    protected int mp_obj_new_int_from_float_str1_1 = 0x08023cfc;

    // value: Function(address=134364464, size=60, name='mp_type_int', path='build/py/objint.o', has_indirect=False)
    protected int mp_type_int = 0x08023d30;

    // value: Function(address=134364524, size=4, name='maxsize_dig', path='build/py/objint_mpz.o', has_indirect=False)
    protected int maxsize_dig = 0x08023d6c;

    // value: Function(address=134364528, size=16, name='mp_maxsize_obj', path='build/py/objint_mpz.o', has_indirect=False)
    protected int mp_maxsize_obj = 0x08023d70;

    // value: Function(address=134364544, size=45, name='mp_obj_int_get_checked_str1_1', path='build/py/objint_mpz.o', has_indirect=False)
    protected int mp_obj_int_get_checked_str1_1 = 0x08023d80;

    // value: Function(address=134364589, size=41, name='mp_obj_int_pow3_str1_1', path='build/py/objint_mpz.o', has_indirect=False)
    protected int mp_obj_int_pow3_str1_1 = 0x08023dad;

    // value: Function(address=134364632, size=16, name='allowed_args_6472', path='build/py/objlist.o', has_indirect=False)
    protected int allowed_args_6472 = 0x08023dd8;

    // value: Function(address=134364648, size=8, name='list_append_obj', path='build/py/objlist.o', has_indirect=False)
    protected int list_append_obj = 0x08023de8;

    // value: Function(address=134364656, size=8, name='list_clear_obj', path='build/py/objlist.o', has_indirect=False)
    protected int list_clear_obj = 0x08023df0;

    // value: Function(address=134364664, size=8, name='list_copy_obj', path='build/py/objlist.o', has_indirect=False)
    protected int list_copy_obj = 0x08023df8;

    // value: Function(address=134364672, size=8, name='list_count_obj', path='build/py/objlist.o', has_indirect=False)
    protected int list_count_obj = 0x08023e00;

    // value: Function(address=134364680, size=8, name='list_extend_obj', path='build/py/objlist.o', has_indirect=False)
    protected int list_extend_obj = 0x08023e08;

    // value: Function(address=134364688, size=12, name='list_index_obj', path='build/py/objlist.o', has_indirect=False)
    protected int list_index_obj = 0x08023e10;

    // value: Function(address=134364700, size=8, name='list_insert_obj', path='build/py/objlist.o', has_indirect=False)
    protected int list_insert_obj = 0x08023e1c;

    // value: Function(address=134364708, size=16, name='list_locals_dict', path='build/py/objlist.o', has_indirect=False)
    protected int list_locals_dict = 0x08023e24;

    // value: Function(address=134364724, size=88, name='list_locals_dict_table', path='build/py/objlist.o', has_indirect=False)
    protected int list_locals_dict_table = 0x08023e34;

    // value: Function(address=134364812, size=20, name='list_pop_str1_1', path='build/py/objlist.o', has_indirect=False)
    protected int list_pop_str1_1 = 0x08023e8c;

    // value: Function(address=134364832, size=12, name='list_pop_obj', path='build/py/objlist.o', has_indirect=False)
    protected int list_pop_obj = 0x08023ea0;

    // value: Function(address=134364844, size=8, name='list_remove_obj', path='build/py/objlist.o', has_indirect=False)
    protected int list_remove_obj = 0x08023eac;

    // value: Function(address=134364852, size=8, name='list_reverse_obj', path='build/py/objlist.o', has_indirect=False)
    protected int list_reverse_obj = 0x08023eb4;

    // value: Function(address=134364860, size=12, name='list_sort_obj', path='build/py/objlist.o', has_indirect=False)
    protected int list_sort_obj = 0x08023ebc;

    // value: Function(address=134364872, size=60, name='mp_type_list', path='build/py/objlist.o', has_indirect=False)
    protected int mp_type_list = 0x08023ec8;

    // value: Function(address=134364932, size=60, name='mp_type_map', path='build/py/objmap.o', has_indirect=False)
    protected int mp_type_map = 0x08023f04;

    // value: Function(address=134364992, size=38, name='module_print_str1_1', path='build/py/objmodule.o', has_indirect=False)
    protected int module_print_str1_1 = 0x08023f40;

    // value: Function(address=134365032, size=12, name='mp_builtin_module_map', path='build/py/objmodule.o', has_indirect=False)
    protected int mp_builtin_module_map = 0x08023f68;

    // value: Function(address=134365044, size=200, name='mp_builtin_module_table', path='build/py/objmodule.o', has_indirect=False)
    protected int mp_builtin_module_table = 0x08023f74;

    // value: Function(address=134365244, size=12, name='mp_builtin_module_weak_links_map', path='build/py/objmodule.o', has_indirect=False)
    protected int mp_builtin_module_weak_links_map = 0x0802403c;

    // value: Function(address=134365256, size=112, name='mp_builtin_module_weak_links_table', path='build/py/objmodule.o', has_indirect=False)
    protected int mp_builtin_module_weak_links_table = 0x08024048;

    // value: Function(address=134365368, size=60, name='mp_type_module', path='build/py/objmodule.o', has_indirect=False)
    protected int mp_type_module = 0x080240b8;

    // value: Function(address=134365428, size=60, name='mp_type_object', path='build/py/objobject.o', has_indirect=False)
    protected int mp_type_object = 0x080240f4;

    // value: Function(address=134365488, size=8, name='object___init___obj', path='build/py/objobject.o', has_indirect=False)
    protected int object___init___obj = 0x08024130;

    // value: Function(address=134365496, size=32, name='object___new___str1_1', path='build/py/objobject.o', has_indirect=False)
    protected int object___new___str1_1 = 0x08024138;

    // value: Function(address=134365528, size=8, name='object___new___fun_obj', path='build/py/objobject.o', has_indirect=False)
    protected int object___new___fun_obj = 0x08024158;

    // value: Function(address=134365536, size=8, name='object___new___obj', path='build/py/objobject.o', has_indirect=False)
    protected int object___new___obj = 0x08024160;

    // value: Function(address=134365544, size=16, name='object_locals_dict', path='build/py/objobject.o', has_indirect=False)
    protected int object_locals_dict = 0x08024168;

    // value: Function(address=134365560, size=16, name='object_locals_dict_table', path='build/py/objobject.o', has_indirect=False)
    protected int object_locals_dict_table = 0x08024178;

    // value: Function(address=134365576, size=60, name='mp_type_polymorph_iter', path='build/py/objpolyiter.o', has_indirect=False)
    protected int mp_type_polymorph_iter = 0x08024188;

    // value: Function(address=134365636, size=32, name='allowed_args_6527', path='build/py/objproperty.o', has_indirect=False)
    protected int allowed_args_6527 = 0x080241c4;

    // value: Function(address=134365668, size=60, name='mp_type_property', path='build/py/objproperty.o', has_indirect=False)
    protected int mp_type_property = 0x080241e4;

    // value: Function(address=134365728, size=8, name='property_deleter_obj', path='build/py/objproperty.o', has_indirect=False)
    protected int property_deleter_obj = 0x08024220;

    // value: Function(address=134365736, size=8, name='property_getter_obj', path='build/py/objproperty.o', has_indirect=False)
    protected int property_getter_obj = 0x08024228;

    // value: Function(address=134365744, size=16, name='property_locals_dict', path='build/py/objproperty.o', has_indirect=False)
    protected int property_locals_dict = 0x08024230;

    // value: Function(address=134365760, size=24, name='property_locals_dict_table', path='build/py/objproperty.o', has_indirect=False)
    protected int property_locals_dict_table = 0x08024240;

    // value: Function(address=134365784, size=8, name='property_setter_obj', path='build/py/objproperty.o', has_indirect=False)
    protected int property_setter_obj = 0x08024258;

    // value: Function(address=134365792, size=4, name='mp_const_none_obj', path='build/py/objnone.o', has_indirect=False)
    protected int mp_const_none_obj = 0x08024260;

    // value: Function(address=134365796, size=60, name='mp_type_NoneType', path='build/py/objnone.o', has_indirect=False)
    protected int mp_type_NoneType = 0x08024264;

    // value: Function(address=134365856, size=5, name='none_print_str1_1', path='build/py/objnone.o', has_indirect=False)
    protected int none_print_str1_1 = 0x080242a0;

    // value: Function(address=134365864, size=8, name='mp_namedtuple_obj', path='build/py/objnamedtuple.o', has_indirect=False)
    protected int mp_namedtuple_obj = 0x080242a8;

    // value: Function(address=134365872, size=8, name='namedtuple_asdict_obj', path='build/py/objnamedtuple.o', has_indirect=False)
    protected int namedtuple_asdict_obj = 0x080242b0;

    // value: Function(address=134365880, size=20, name='namedtuple_attr_str1_1', path='build/py/objnamedtuple.o', has_indirect=False)
    protected int namedtuple_attr_str1_1 = 0x080242b8;

    // value: Function(address=134365900, size=133, name='namedtuple_make_new_str1_1', path='build/py/objnamedtuple.o', has_indirect=False)
    protected int namedtuple_make_new_str1_1 = 0x080242cc;

    // value: Function(address=134366033, size=133, name='namedtuple_print_str1_1', path='build/py/objnamedtuple.o', has_indirect=False)
    protected int namedtuple_print_str1_1 = 0x08024351;

    // value: Function(address=134366036, size=60, name='mp_type_range', path='build/py/objrange.o', has_indirect=False)
    protected int mp_type_range = 0x08024354;

    // value: Function(address=134366096, size=60, name='range_it_type', path='build/py/objrange.o', has_indirect=False)
    protected int range_it_type = 0x08024390;

    // value: Function(address=134366156, size=10, name='range_make_new_str1_1', path='build/py/objrange.o', has_indirect=False)
    protected int range_make_new_str1_1 = 0x080243cc;

    // value: Function(address=134366166, size=19, name='range_print_str1_1', path='build/py/objrange.o', has_indirect=False)
    protected int range_print_str1_1 = 0x080243d6;

    // value: Function(address=134366188, size=60, name='mp_type_reversed', path='build/py/objreversed.o', has_indirect=False)
    protected int mp_type_reversed = 0x080243ec;

    // value: Function(address=134366248, size=16, name='frozenset_locals_dict', path='build/py/objset.o', has_indirect=False)
    protected int frozenset_locals_dict = 0x08024428;

    // value: Function(address=134366264, size=72, name='frozenset_locals_dict_table', path='build/py/objset.o', has_indirect=False)
    protected int frozenset_locals_dict_table = 0x08024438;

    // value: Function(address=134366336, size=60, name='mp_type_frozenset', path='build/py/objset.o', has_indirect=False)
    protected int mp_type_frozenset = 0x08024480;

    // value: Function(address=134366396, size=60, name='mp_type_set', path='build/py/objset.o', has_indirect=False)
    protected int mp_type_set = 0x080244bc;

    // value: Function(address=134366456, size=8, name='set_add_obj', path='build/py/objset.o', has_indirect=False)
    protected int set_add_obj = 0x080244f8;

    // value: Function(address=134366464, size=8, name='set_clear_obj', path='build/py/objset.o', has_indirect=False)
    protected int set_clear_obj = 0x08024500;

    // value: Function(address=134366472, size=8, name='set_copy_obj', path='build/py/objset.o', has_indirect=False)
    protected int set_copy_obj = 0x08024508;

    // value: Function(address=134366480, size=12, name='set_diff_obj', path='build/py/objset.o', has_indirect=False)
    protected int set_diff_obj = 0x08024510;

    // value: Function(address=134366492, size=12, name='set_diff_update_obj', path='build/py/objset.o', has_indirect=False)
    protected int set_diff_update_obj = 0x0802451c;

    // value: Function(address=134366504, size=8, name='set_discard_obj', path='build/py/objset.o', has_indirect=False)
    protected int set_discard_obj = 0x08024528;

    // value: Function(address=134366512, size=8, name='set_intersect_obj', path='build/py/objset.o', has_indirect=False)
    protected int set_intersect_obj = 0x08024530;

    // value: Function(address=134366520, size=8, name='set_intersect_update_obj', path='build/py/objset.o', has_indirect=False)
    protected int set_intersect_update_obj = 0x08024538;

    // value: Function(address=134366528, size=8, name='set_isdisjoint_obj', path='build/py/objset.o', has_indirect=False)
    protected int set_isdisjoint_obj = 0x08024540;

    // value: Function(address=134366536, size=8, name='set_issubset_obj', path='build/py/objset.o', has_indirect=False)
    protected int set_issubset_obj = 0x08024548;

    // value: Function(address=134366544, size=8, name='set_issuperset_obj', path='build/py/objset.o', has_indirect=False)
    protected int set_issuperset_obj = 0x08024550;

    // value: Function(address=134366552, size=16, name='set_locals_dict', path='build/py/objset.o', has_indirect=False)
    protected int set_locals_dict = 0x08024558;

    // value: Function(address=134366568, size=144, name='set_locals_dict_table', path='build/py/objset.o', has_indirect=False)
    protected int set_locals_dict_table = 0x08024568;

    // value: Function(address=134366712, size=22, name='set_pop_str1_1', path='build/py/objset.o', has_indirect=False)
    protected int set_pop_str1_1 = 0x080245f8;

    // value: Function(address=134366736, size=8, name='set_pop_obj', path='build/py/objset.o', has_indirect=False)
    protected int set_pop_obj = 0x08024610;

    // value: Function(address=134366744, size=24, name='set_print_str1_1', path='build/py/objset.o', has_indirect=False)
    protected int set_print_str1_1 = 0x08024618;

    // value: Function(address=134366768, size=8, name='set_remove_obj', path='build/py/objset.o', has_indirect=False)
    protected int set_remove_obj = 0x08024630;

    // value: Function(address=134366776, size=8, name='set_symmetric_difference_obj', path='build/py/objset.o', has_indirect=False)
    protected int set_symmetric_difference_obj = 0x08024638;

    // value: Function(address=134366784, size=8, name='set_symmetric_difference_update_obj', path='build/py/objset.o', has_indirect=False)
    protected int set_symmetric_difference_update_obj = 0x08024640;

    // value: Function(address=134366792, size=8, name='set_union_obj', path='build/py/objset.o', has_indirect=False)
    protected int set_union_obj = 0x08024648;

    // value: Function(address=134366800, size=12, name='set_update_obj', path='build/py/objset.o', has_indirect=False)
    protected int set_update_obj = 0x08024650;

    // value: Function(address=134366812, size=8, name='mp_const_ellipsis_obj', path='build/py/objsingleton.o', has_indirect=False)
    protected int mp_const_ellipsis_obj = 0x0802465c;

    // value: Function(address=134366820, size=8, name='mp_const_notimplemented_obj', path='build/py/objsingleton.o', has_indirect=False)
    protected int mp_const_notimplemented_obj = 0x08024664;

    // value: Function(address=134366828, size=60, name='mp_type_singleton', path='build/py/objsingleton.o', has_indirect=False)
    protected int mp_type_singleton = 0x0802466c;

    // value: Function(address=134366888, size=60, name='mp_type_slice', path='build/py/objslice.o', has_indirect=False)
    protected int mp_type_slice = 0x080246a8;

    // value: Function(address=134366948, size=7, name='slice_print_str1_1', path='build/py/objslice.o', has_indirect=False)
    protected int slice_print_str1_1 = 0x080246e4;

    // value: Function(address=134366956, size=8, name='allowed_args_6617', path='build/py/objstr.o', has_indirect=False)
    protected int allowed_args_6617 = 0x080246ec;

    // value: Function(address=134366964, size=43, name='bad_implicit_conversion_str1_1', path='build/py/objstr.o', has_indirect=False)
    protected int bad_implicit_conversion_str1_1 = 0x080246f4;

    // value: Function(address=134367008, size=12, name='bytes_decode_obj', path='build/py/objstr.o', has_indirect=False)
    protected int bytes_decode_obj = 0x08024720;

    // value: Function(address=134367020, size=51, name='bytes_make_new_part_4_str1_1', path='build/py/objstr.o', has_indirect=False)
    protected int bytes_make_new_part_4_str1_1 = 0x0802472c;

    // value: Function(address=134367071, size=49, name='bytes_subscr_str1_1', path='build/py/objstr.o', has_indirect=False)
    protected int bytes_subscr_str1_1 = 0x0802475f;

    // value: Function(address=134367072, size=16, name='mp_const_empty_bytes_obj', path='build/py/objstr.o', has_indirect=False)
    protected int mp_const_empty_bytes_obj = 0x08024760;

    // value: Function(address=134367088, size=250, name='mp_obj_str_binary_op_str1_1', path='build/py/objstr.o', has_indirect=False)
    protected int mp_obj_str_binary_op_str1_1 = 0x08024770;

    // value: Function(address=134367338, size=630, name='mp_obj_str_format_helper_str1_1', path='build/py/objstr.o', has_indirect=False)
    protected int mp_obj_str_format_helper_str1_1 = 0x0802486a;

    // value: Function(address=134367968, size=9, name='mp_str_print_json_str1_1', path='build/py/objstr.o', has_indirect=False)
    protected int mp_str_print_json_str1_1 = 0x08024ae0;

    // value: Function(address=134367977, size=23, name='mp_str_print_quoted_str1_1', path='build/py/objstr.o', has_indirect=False)
    protected int mp_str_print_quoted_str1_1 = 0x08024ae9;

    // value: Function(address=134368000, size=60, name='mp_type_bytes', path='build/py/objstr.o', has_indirect=False)
    protected int mp_type_bytes = 0x08024b00;

    // value: Function(address=134368060, size=16, name='str8_locals_dict', path='build/py/objstr.o', has_indirect=False)
    protected int str8_locals_dict = 0x08024b3c;

    // value: Function(address=134368076, size=216, name='str8_locals_dict_table', path='build/py/objstr.o', has_indirect=False)
    protected int str8_locals_dict_table = 0x08024b4c;

    // value: Function(address=134368292, size=8, name='str_center_obj', path='build/py/objstr.o', has_indirect=False)
    protected int str_center_obj = 0x08024c24;

    // value: Function(address=134368300, size=12, name='str_count_obj', path='build/py/objstr.o', has_indirect=False)
    protected int str_count_obj = 0x08024c2c;

    // value: Function(address=134368312, size=12, name='str_encode_obj', path='build/py/objstr.o', has_indirect=False)
    protected int str_encode_obj = 0x08024c38;

    // value: Function(address=134368324, size=18, name='str_endswith_str1_1', path='build/py/objstr.o', has_indirect=False)
    protected int str_endswith_str1_1 = 0x08024c44;

    // value: Function(address=134368344, size=12, name='str_endswith_obj', path='build/py/objstr.o', has_indirect=False)
    protected int str_endswith_obj = 0x08024c58;

    // value: Function(address=134368356, size=12, name='str_find_obj', path='build/py/objstr.o', has_indirect=False)
    protected int str_find_obj = 0x08024c64;

    // value: Function(address=134368368, size=20, name='str_finder_str1_1', path='build/py/objstr.o', has_indirect=False)
    protected int str_finder_str1_1 = 0x08024c70;

    // value: Function(address=134368388, size=12, name='str_format_obj', path='build/py/objstr.o', has_indirect=False)
    protected int str_format_obj = 0x08024c84;

    // value: Function(address=134368400, size=12, name='str_index_obj', path='build/py/objstr.o', has_indirect=False)
    protected int str_index_obj = 0x08024c90;

    // value: Function(address=134368412, size=8, name='str_isalpha_obj', path='build/py/objstr.o', has_indirect=False)
    protected int str_isalpha_obj = 0x08024c9c;

    // value: Function(address=134368420, size=8, name='str_isdigit_obj', path='build/py/objstr.o', has_indirect=False)
    protected int str_isdigit_obj = 0x08024ca4;

    // value: Function(address=134368428, size=8, name='str_islower_obj', path='build/py/objstr.o', has_indirect=False)
    protected int str_islower_obj = 0x08024cac;

    // value: Function(address=134368436, size=8, name='str_isspace_obj', path='build/py/objstr.o', has_indirect=False)
    protected int str_isspace_obj = 0x08024cb4;

    // value: Function(address=134368444, size=8, name='str_isupper_obj', path='build/py/objstr.o', has_indirect=False)
    protected int str_isupper_obj = 0x08024cbc;

    // value: Function(address=134368452, size=69, name='str_join_str1_1', path='build/py/objstr.o', has_indirect=False)
    protected int str_join_str1_1 = 0x08024cc4;

    // value: Function(address=134368524, size=8, name='str_join_obj', path='build/py/objstr.o', has_indirect=False)
    protected int str_join_obj = 0x08024d0c;

    // value: Function(address=134368532, size=8, name='str_lower_obj', path='build/py/objstr.o', has_indirect=False)
    protected int str_lower_obj = 0x08024d14;

    // value: Function(address=134368540, size=12, name='str_lstrip_obj', path='build/py/objstr.o', has_indirect=False)
    protected int str_lstrip_obj = 0x08024d1c;

    // value: Function(address=134368552, size=8, name='str_partition_obj', path='build/py/objstr.o', has_indirect=False)
    protected int str_partition_obj = 0x08024d28;

    // value: Function(address=134368560, size=16, name='str_partitioner_str1_1', path='build/py/objstr.o', has_indirect=False)
    protected int str_partitioner_str1_1 = 0x08024d30;

    // value: Function(address=134368576, size=5, name='str_print_str1_1', path='build/py/objstr.o', has_indirect=False)
    protected int str_print_str1_1 = 0x08024d40;

    // value: Function(address=134368584, size=12, name='str_replace_obj', path='build/py/objstr.o', has_indirect=False)
    protected int str_replace_obj = 0x08024d48;

    // value: Function(address=134368596, size=12, name='str_rfind_obj', path='build/py/objstr.o', has_indirect=False)
    protected int str_rfind_obj = 0x08024d54;

    // value: Function(address=134368608, size=12, name='str_rindex_obj', path='build/py/objstr.o', has_indirect=False)
    protected int str_rindex_obj = 0x08024d60;

    // value: Function(address=134368620, size=8, name='str_rpartition_obj', path='build/py/objstr.o', has_indirect=False)
    protected int str_rpartition_obj = 0x08024d6c;

    // value: Function(address=134368628, size=15, name='str_rsplit_str1_1', path='build/py/objstr.o', has_indirect=False)
    protected int str_rsplit_str1_1 = 0x08024d74;

    // value: Function(address=134368644, size=12, name='str_rsplit_obj', path='build/py/objstr.o', has_indirect=False)
    protected int str_rsplit_obj = 0x08024d84;

    // value: Function(address=134368656, size=12, name='str_rstrip_obj', path='build/py/objstr.o', has_indirect=False)
    protected int str_rstrip_obj = 0x08024d90;

    // value: Function(address=134368668, size=12, name='str_split_obj', path='build/py/objstr.o', has_indirect=False)
    protected int str_split_obj = 0x08024d9c;

    // value: Function(address=134368680, size=12, name='str_splitlines_obj', path='build/py/objstr.o', has_indirect=False)
    protected int str_splitlines_obj = 0x08024da8;

    // value: Function(address=134368692, size=12, name='str_startswith_obj', path='build/py/objstr.o', has_indirect=False)
    protected int str_startswith_obj = 0x08024db4;

    // value: Function(address=134368704, size=12, name='str_strip_obj', path='build/py/objstr.o', has_indirect=False)
    protected int str_strip_obj = 0x08024dc0;

    // value: Function(address=134368716, size=8, name='str_upper_obj', path='build/py/objstr.o', has_indirect=False)
    protected int str_upper_obj = 0x08024dcc;

    // value: Function(address=134368724, size=7, name='whitespace_6723', path='build/py/objstr.o', has_indirect=False)
    protected int whitespace_6723 = 0x08024dd4;

    // value: Function(address=134368732, size=60, name='mp_type_str', path='build/py/objstrunicode.o', has_indirect=False)
    protected int mp_type_str = 0x08024ddc;

    // value: Function(address=134368792, size=66, name='str_index_to_ptr_str1_1', path='build/py/objstrunicode.o', has_indirect=False)
    protected int str_index_to_ptr_str1_1 = 0x08024e18;

    // value: Function(address=134368858, size=49, name='str_subscr_str1_1', path='build/py/objstrunicode.o', has_indirect=False)
    protected int str_subscr_str1_1 = 0x08024e5a;

    // value: Function(address=134368860, size=16, name='struni_locals_dict', path='build/py/objstrunicode.o', has_indirect=False)
    protected int struni_locals_dict = 0x08024e5c;

    // value: Function(address=134368876, size=216, name='struni_locals_dict_table', path='build/py/objstrunicode.o', has_indirect=False)
    protected int struni_locals_dict_table = 0x08024e6c;

    // value: Function(address=134369092, size=7, name='uni_print_str1_1', path='build/py/objstrunicode.o', has_indirect=False)
    protected int uni_print_str1_1 = 0x08024f44;

    // value: Function(address=134369100, size=16, name='bytesio_stream_p', path='build/py/objstringio.o', has_indirect=False)
    protected int bytesio_stream_p = 0x08024f4c;

    // value: Function(address=134369116, size=60, name='mp_type_bytesio', path='build/py/objstringio.o', has_indirect=False)
    protected int mp_type_bytesio = 0x08024f5c;

    // value: Function(address=134369176, size=60, name='mp_type_stringio', path='build/py/objstringio.o', has_indirect=False)
    protected int mp_type_stringio = 0x08024f98;

    // value: Function(address=134369236, size=12, name='stringio___exit___obj', path='build/py/objstringio.o', has_indirect=False)
    protected int stringio___exit___obj = 0x08024fd4;

    // value: Function(address=134369248, size=8, name='stringio_getvalue_obj', path='build/py/objstringio.o', has_indirect=False)
    protected int stringio_getvalue_obj = 0x08024fe0;

    // value: Function(address=134369256, size=16, name='stringio_locals_dict', path='build/py/objstringio.o', has_indirect=False)
    protected int stringio_locals_dict = 0x08024fe8;

    // value: Function(address=134369272, size=80, name='stringio_locals_dict_table', path='build/py/objstringio.o', has_indirect=False)
    protected int stringio_locals_dict_table = 0x08024ff8;

    // value: Function(address=134369352, size=37, name='stringio_print_str1_1', path='build/py/objstringio.o', has_indirect=False)
    protected int stringio_print_str1_1 = 0x08025048;

    // value: Function(address=134369392, size=16, name='stringio_stream_p', path='build/py/objstringio.o', has_indirect=False)
    protected int stringio_stream_p = 0x08025070;

    // value: Function(address=134369408, size=29, name='stringio_write_str1_1', path='build/py/objstringio.o', has_indirect=False)
    protected int stringio_write_str1_1 = 0x08025080;

    // value: Function(address=134369440, size=8, name='mp_const_empty_tuple_obj', path='build/py/objtuple.o', has_indirect=False)
    protected int mp_const_empty_tuple_obj = 0x080250a0;

    // value: Function(address=134369448, size=2, name='mp_obj_tuple_print_str1_1', path='build/py/objtuple.o', has_indirect=False)
    protected int mp_obj_tuple_print_str1_1 = 0x080250a8;

    // value: Function(address=134369450, size=49, name='mp_obj_tuple_subscr_str1_1', path='build/py/objtuple.o', has_indirect=False)
    protected int mp_obj_tuple_subscr_str1_1 = 0x080250aa;

    // value: Function(address=134369452, size=60, name='mp_type_tuple', path='build/py/objtuple.o', has_indirect=False)
    protected int mp_type_tuple = 0x080250ac;

    // value: Function(address=134369512, size=8, name='tuple_count_obj', path='build/py/objtuple.o', has_indirect=False)
    protected int tuple_count_obj = 0x080250e8;

    // value: Function(address=134369520, size=12, name='tuple_index_obj', path='build/py/objtuple.o', has_indirect=False)
    protected int tuple_index_obj = 0x080250f0;

    // value: Function(address=134369532, size=16, name='tuple_locals_dict', path='build/py/objtuple.o', has_indirect=False)
    protected int tuple_locals_dict = 0x080250fc;

    // value: Function(address=134369548, size=16, name='tuple_locals_dict_table', path='build/py/objtuple.o', has_indirect=False)
    protected int tuple_locals_dict_table = 0x0802510c;

    // value: Function(address=134369564, size=18, name='instance_print_str1_1', path='build/py/objtype.o', has_indirect=False)
    protected int instance_print_str1_1 = 0x0802511c;

    // value: Function(address=134369582, size=47, name='mp_binary_op_method_name', path='build/py/objtype.o', has_indirect=False)
    protected int mp_binary_op_method_name = 0x0802512e;

    // value: Function(address=134369632, size=8, name='mp_builtin_isinstance_obj', path='build/py/objtype.o', has_indirect=False)
    protected int mp_builtin_isinstance_obj = 0x08025160;

    // value: Function(address=134369640, size=35, name='mp_builtin_issubclass_str1_1', path='build/py/objtype.o', has_indirect=False)
    protected int mp_builtin_issubclass_str1_1 = 0x08025168;

    // value: Function(address=134369676, size=8, name='mp_builtin_issubclass_obj', path='build/py/objtype.o', has_indirect=False)
    protected int mp_builtin_issubclass_obj = 0x0802518c;

    // value: Function(address=134369684, size=21, name='mp_obj_instance_attr_str1_1', path='build/py/objtype.o', has_indirect=False)
    protected int mp_obj_instance_attr_str1_1 = 0x08025194;

    // value: Function(address=134369705, size=40, name='mp_obj_instance_make_new_str1_1', path='build/py/objtype.o', has_indirect=False)
    protected int mp_obj_instance_make_new_str1_1 = 0x080251a9;

    // value: Function(address=134369745, size=57, name='mp_obj_is_subclass_str1_1', path='build/py/objtype.o', has_indirect=False)
    protected int mp_obj_is_subclass_str1_1 = 0x080251d1;

    // value: Function(address=134369802, size=87, name='mp_obj_new_type_str1_1', path='build/py/objtype.o', has_indirect=False)
    protected int mp_obj_new_type_str1_1 = 0x0802520a;

    // value: Function(address=134369892, size=60, name='mp_type_classmethod', path='build/py/objtype.o', has_indirect=False)
    protected int mp_type_classmethod = 0x08025264;

    // value: Function(address=134369952, size=60, name='mp_type_staticmethod', path='build/py/objtype.o', has_indirect=False)
    protected int mp_type_staticmethod = 0x080252a0;

    // value: Function(address=134370012, size=60, name='mp_type_super', path='build/py/objtype.o', has_indirect=False)
    protected int mp_type_super = 0x080252dc;

    // value: Function(address=134370072, size=60, name='mp_type_type', path='build/py/objtype.o', has_indirect=False)
    protected int mp_type_type = 0x08025318;

    // value: Function(address=134370132, size=9, name='mp_unary_op_method_name', path='build/py/objtype.o', has_indirect=False)
    protected int mp_unary_op_method_name = 0x08025354;

    // value: Function(address=134370144, size=12, name='native_base_init_wrapper_obj', path='build/py/objtype.o', has_indirect=False)
    protected int native_base_init_wrapper_obj = 0x08025360;

    // value: Function(address=134370156, size=9, name='super_print_str1_1', path='build/py/objtype.o', has_indirect=False)
    protected int super_print_str1_1 = 0x0802536c;

    // value: Function(address=134370165, size=3, name='to_check_7087', path='build/py/objtype.o', has_indirect=False)
    protected int to_check_7087 = 0x08025375;

    // value: Function(address=134370168, size=53, name='type_attr_str1_1', path='build/py/objtype.o', has_indirect=False)
    protected int type_attr_str1_1 = 0x08025378;

    // value: Function(address=134370221, size=29, name='type_call_str1_1', path='build/py/objtype.o', has_indirect=False)
    protected int type_call_str1_1 = 0x080253ad;

    // value: Function(address=134370250, size=28, name='type_make_new_str1_1', path='build/py/objtype.o', has_indirect=False)
    protected int type_make_new_str1_1 = 0x080253ca;

    // value: Function(address=134370278, size=13, name='type_print_str1_1', path='build/py/objtype.o', has_indirect=False)
    protected int type_print_str1_1 = 0x080253e6;

    // value: Function(address=134370292, size=60, name='mp_type_zip', path='build/py/objzip.o', has_indirect=False)
    protected int mp_type_zip = 0x080253f4;

    // value: Function(address=134370352, size=8, name='mp_op_contains_obj', path='build/py/opmethods.o', has_indirect=False)
    protected int mp_op_contains_obj = 0x08025430;

    // value: Function(address=134370360, size=8, name='mp_op_delitem_obj', path='build/py/opmethods.o', has_indirect=False)
    protected int mp_op_delitem_obj = 0x08025438;

    // value: Function(address=134370368, size=8, name='mp_op_getitem_obj', path='build/py/opmethods.o', has_indirect=False)
    protected int mp_op_getitem_obj = 0x08025440;

    // value: Function(address=134370376, size=8, name='mp_op_setitem_obj', path='build/py/opmethods.o', has_indirect=False)
    protected int mp_op_setitem_obj = 0x08025448;

    // value: Function(address=134370384, size=26, name='mp_seq_get_fast_slice_indexes_str1_1', path='build/py/sequence.o', has_indirect=False)
    protected int mp_seq_get_fast_slice_indexes_str1_1 = 0x08025450;

    // value: Function(address=134370410, size=23, name='mp_seq_index_obj_str1_1', path='build/py/sequence.o', has_indirect=False)
    protected int mp_seq_index_obj_str1_1 = 0x0802546a;

    // value: Function(address=134370433, size=31, name='mp_get_stream_raise_str1_1', path='build/py/stream.o', has_indirect=False)
    protected int mp_get_stream_raise_str1_1 = 0x08025481;

    // value: Function(address=134370464, size=8, name='mp_stream_close_obj', path='build/py/stream.o', has_indirect=False)
    protected int mp_stream_close_obj = 0x080254a0;

    // value: Function(address=134370472, size=8, name='mp_stream_flush_obj', path='build/py/stream.o', has_indirect=False)
    protected int mp_stream_flush_obj = 0x080254a8;

    // value: Function(address=134370480, size=12, name='mp_stream_read_obj', path='build/py/stream.o', has_indirect=False)
    protected int mp_stream_read_obj = 0x080254b0;

    // value: Function(address=134370492, size=12, name='mp_stream_readinto_obj', path='build/py/stream.o', has_indirect=False)
    protected int mp_stream_readinto_obj = 0x080254bc;

    // value: Function(address=134370504, size=12, name='mp_stream_seek_obj', path='build/py/stream.o', has_indirect=False)
    protected int mp_stream_seek_obj = 0x080254c8;

    // value: Function(address=134370516, size=8, name='mp_stream_tell_obj', path='build/py/stream.o', has_indirect=False)
    protected int mp_stream_tell_obj = 0x080254d4;

    // value: Function(address=134370524, size=12, name='mp_stream_unbuffered_readline_obj', path='build/py/stream.o', has_indirect=False)
    protected int mp_stream_unbuffered_readline_obj = 0x080254dc;

    // value: Function(address=134370536, size=8, name='mp_stream_unbuffered_readlines_obj', path='build/py/stream.o', has_indirect=False)
    protected int mp_stream_unbuffered_readlines_obj = 0x080254e8;

    // value: Function(address=134370544, size=12, name='mp_stream_write_obj', path='build/py/stream.o', has_indirect=False)
    protected int mp_stream_write_obj = 0x080254f0;

    // value: Function(address=134370556, size=13, name='mp_binary_get_size_str1_1', path='build/py/binary.o', has_indirect=False)
    protected int mp_binary_get_size_str1_1 = 0x080254fc;

    // value: Function(address=134370569, size=64, name='mp_builtin___import___str1_1', path='build/py/builtinimport.o', has_indirect=False)
    protected int mp_builtin___import___str1_1 = 0x08025509;

    // value: Function(address=134370636, size=12, name='mp_builtin___import___obj', path='build/py/builtinimport.o', has_indirect=False)
    protected int mp_builtin___import___obj = 0x0802554c;

    // value: Function(address=134370648, size=17, name='mp_builtin_compile_str1_1', path='build/py/builtinevex.o', has_indirect=False)
    protected int mp_builtin_compile_str1_1 = 0x08025558;

    // value: Function(address=134370668, size=12, name='mp_builtin_compile_obj', path='build/py/builtinevex.o', has_indirect=False)
    protected int mp_builtin_compile_obj = 0x0802556c;

    // value: Function(address=134370680, size=12, name='mp_builtin_eval_obj', path='build/py/builtinevex.o', has_indirect=False)
    protected int mp_builtin_eval_obj = 0x08025578;

    // value: Function(address=134370692, size=12, name='mp_builtin_exec_obj', path='build/py/builtinevex.o', has_indirect=False)
    protected int mp_builtin_exec_obj = 0x08025584;

    // value: Function(address=134370704, size=12, name='mp_builtin_execfile_obj', path='build/py/builtinevex.o', has_indirect=False)
    protected int mp_builtin_execfile_obj = 0x08025590;

    // value: Function(address=134370716, size=60, name='mp_type_code', path='build/py/builtinevex.o', has_indirect=False)
    protected int mp_type_code = 0x0802559c;

    // value: Function(address=134370776, size=63, name='mp_builtin_help_str1_1', path='build/py/builtinhelp.o', has_indirect=False)
    protected int mp_builtin_help_str1_1 = 0x080255d8;

    // value: Function(address=134370840, size=12, name='mp_builtin_help_obj', path='build/py/builtinhelp.o', has_indirect=False)
    protected int mp_builtin_help_obj = 0x08025618;

    // value: Function(address=134370852, size=8, name='mp_module_array', path='build/py/modarray.o', has_indirect=False)
    protected int mp_module_array = 0x08025624;

    // value: Function(address=134370860, size=16, name='mp_module_array_globals', path='build/py/modarray.o', has_indirect=False)
    protected int mp_module_array_globals = 0x0802562c;

    // value: Function(address=134370876, size=16, name='mp_module_array_globals_table', path='build/py/modarray.o', has_indirect=False)
    protected int mp_module_array_globals_table = 0x0802563c;

    // value: Function(address=134370892, size=24, name='allowed_args_7824', path='build/py/modbuiltins.o', has_indirect=False)
    protected int allowed_args_7824 = 0x0802564c;

    // value: Function(address=134370916, size=12, name='mp_builtin___build_class___obj', path='build/py/modbuiltins.o', has_indirect=False)
    protected int mp_builtin___build_class___obj = 0x08025664;

    // value: Function(address=134370928, size=8, name='mp_builtin___repl_print___obj', path='build/py/modbuiltins.o', has_indirect=False)
    protected int mp_builtin___repl_print___obj = 0x08025670;

    // value: Function(address=134370936, size=8, name='mp_builtin_abs_obj', path='build/py/modbuiltins.o', has_indirect=False)
    protected int mp_builtin_abs_obj = 0x08025678;

    // value: Function(address=134370944, size=8, name='mp_builtin_all_obj', path='build/py/modbuiltins.o', has_indirect=False)
    protected int mp_builtin_all_obj = 0x08025680;

    // value: Function(address=134370952, size=8, name='mp_builtin_any_obj', path='build/py/modbuiltins.o', has_indirect=False)
    protected int mp_builtin_any_obj = 0x08025688;

    // value: Function(address=134370960, size=8, name='mp_builtin_bin_obj', path='build/py/modbuiltins.o', has_indirect=False)
    protected int mp_builtin_bin_obj = 0x08025690;

    // value: Function(address=134370968, size=8, name='mp_builtin_callable_obj', path='build/py/modbuiltins.o', has_indirect=False)
    protected int mp_builtin_callable_obj = 0x08025698;

    // value: Function(address=134370976, size=33, name='mp_builtin_chr_str1_1', path='build/py/modbuiltins.o', has_indirect=False)
    protected int mp_builtin_chr_str1_1 = 0x080256a0;

    // value: Function(address=134371012, size=8, name='mp_builtin_chr_obj', path='build/py/modbuiltins.o', has_indirect=False)
    protected int mp_builtin_chr_obj = 0x080256c4;

    // value: Function(address=134371020, size=8, name='mp_builtin_delattr_obj', path='build/py/modbuiltins.o', has_indirect=False)
    protected int mp_builtin_delattr_obj = 0x080256cc;

    // value: Function(address=134371028, size=12, name='mp_builtin_dir_obj', path='build/py/modbuiltins.o', has_indirect=False)
    protected int mp_builtin_dir_obj = 0x080256d4;

    // value: Function(address=134371040, size=8, name='mp_builtin_divmod_obj', path='build/py/modbuiltins.o', has_indirect=False)
    protected int mp_builtin_divmod_obj = 0x080256e0;

    // value: Function(address=134371048, size=12, name='mp_builtin_getattr_obj', path='build/py/modbuiltins.o', has_indirect=False)
    protected int mp_builtin_getattr_obj = 0x080256e8;

    // value: Function(address=134371060, size=8, name='mp_builtin_globals_obj', path='build/py/modbuiltins.o', has_indirect=False)
    protected int mp_builtin_globals_obj = 0x080256f4;

    // value: Function(address=134371068, size=8, name='mp_builtin_hasattr_obj', path='build/py/modbuiltins.o', has_indirect=False)
    protected int mp_builtin_hasattr_obj = 0x080256fc;

    // value: Function(address=134371076, size=8, name='mp_builtin_hash_obj', path='build/py/modbuiltins.o', has_indirect=False)
    protected int mp_builtin_hash_obj = 0x08025704;

    // value: Function(address=134371084, size=8, name='mp_builtin_hex_obj', path='build/py/modbuiltins.o', has_indirect=False)
    protected int mp_builtin_hex_obj = 0x0802570c;

    // value: Function(address=134371092, size=8, name='mp_builtin_id_obj', path='build/py/modbuiltins.o', has_indirect=False)
    protected int mp_builtin_id_obj = 0x08025714;

    // value: Function(address=134371100, size=8, name='mp_builtin_iter_obj', path='build/py/modbuiltins.o', has_indirect=False)
    protected int mp_builtin_iter_obj = 0x0802571c;

    // value: Function(address=134371108, size=8, name='mp_builtin_len_obj', path='build/py/modbuiltins.o', has_indirect=False)
    protected int mp_builtin_len_obj = 0x08025724;

    // value: Function(address=134371116, size=8, name='mp_builtin_locals_obj', path='build/py/modbuiltins.o', has_indirect=False)
    protected int mp_builtin_locals_obj = 0x0802572c;

    // value: Function(address=134371124, size=12, name='mp_builtin_max_obj', path='build/py/modbuiltins.o', has_indirect=False)
    protected int mp_builtin_max_obj = 0x08025734;

    // value: Function(address=134371136, size=25, name='mp_builtin_min_max_str1_1', path='build/py/modbuiltins.o', has_indirect=False)
    protected int mp_builtin_min_max_str1_1 = 0x08025740;

    // value: Function(address=134371164, size=12, name='mp_builtin_min_obj', path='build/py/modbuiltins.o', has_indirect=False)
    protected int mp_builtin_min_obj = 0x0802575c;

    // value: Function(address=134371176, size=8, name='mp_builtin_next_obj', path='build/py/modbuiltins.o', has_indirect=False)
    protected int mp_builtin_next_obj = 0x08025768;

    // value: Function(address=134371184, size=8, name='mp_builtin_oct_obj', path='build/py/modbuiltins.o', has_indirect=False)
    protected int mp_builtin_oct_obj = 0x08025770;

    // value: Function(address=134371192, size=58, name='mp_builtin_ord_str1_1', path='build/py/modbuiltins.o', has_indirect=False)
    protected int mp_builtin_ord_str1_1 = 0x08025778;

    // value: Function(address=134371252, size=8, name='mp_builtin_ord_obj', path='build/py/modbuiltins.o', has_indirect=False)
    protected int mp_builtin_ord_obj = 0x080257b4;

    // value: Function(address=134371260, size=12, name='mp_builtin_pow_obj', path='build/py/modbuiltins.o', has_indirect=False)
    protected int mp_builtin_pow_obj = 0x080257bc;

    // value: Function(address=134371272, size=12, name='mp_builtin_print_obj', path='build/py/modbuiltins.o', has_indirect=False)
    protected int mp_builtin_print_obj = 0x080257c8;

    // value: Function(address=134371284, size=8, name='mp_builtin_repr_obj', path='build/py/modbuiltins.o', has_indirect=False)
    protected int mp_builtin_repr_obj = 0x080257d4;

    // value: Function(address=134371292, size=12, name='mp_builtin_round_obj', path='build/py/modbuiltins.o', has_indirect=False)
    protected int mp_builtin_round_obj = 0x080257dc;

    // value: Function(address=134371304, size=8, name='mp_builtin_setattr_obj', path='build/py/modbuiltins.o', has_indirect=False)
    protected int mp_builtin_setattr_obj = 0x080257e8;

    // value: Function(address=134371312, size=43, name='mp_builtin_sorted_str1_1', path='build/py/modbuiltins.o', has_indirect=False)
    protected int mp_builtin_sorted_str1_1 = 0x080257f0;

    // value: Function(address=134371356, size=12, name='mp_builtin_sorted_obj', path='build/py/modbuiltins.o', has_indirect=False)
    protected int mp_builtin_sorted_obj = 0x0802581c;

    // value: Function(address=134371368, size=12, name='mp_builtin_sum_obj', path='build/py/modbuiltins.o', has_indirect=False)
    protected int mp_builtin_sum_obj = 0x08025828;

    // value: Function(address=134371380, size=8, name='mp_module_builtins', path='build/py/modbuiltins.o', has_indirect=False)
    protected int mp_module_builtins = 0x08025834;

    // value: Function(address=134371388, size=16, name='mp_module_builtins_globals', path='build/py/modbuiltins.o', has_indirect=False)
    protected int mp_module_builtins_globals = 0x0802583c;

    // value: Function(address=134371404, size=776, name='mp_module_builtins_globals_table', path='build/py/modbuiltins.o', has_indirect=False)
    protected int mp_module_builtins_globals_table = 0x0802584c;

    // value: Function(address=134372180, size=8, name='mp_module_collections', path='build/py/modcollections.o', has_indirect=False)
    protected int mp_module_collections = 0x08025b54;

    // value: Function(address=134372188, size=16, name='mp_module_collections_globals', path='build/py/modcollections.o', has_indirect=False)
    protected int mp_module_collections_globals = 0x08025b5c;

    // value: Function(address=134372204, size=32, name='mp_module_collections_globals_table', path='build/py/modcollections.o', has_indirect=False)
    protected int mp_module_collections_globals_table = 0x08025b6c;

    // value: Function(address=134372236, size=8, name='gc_collect_obj', path='build/py/modgc.o', has_indirect=False)
    protected int gc_collect_obj = 0x08025b8c;

    // value: Function(address=134372244, size=8, name='gc_disable_obj', path='build/py/modgc.o', has_indirect=False)
    protected int gc_disable_obj = 0x08025b94;

    // value: Function(address=134372252, size=8, name='gc_enable_obj', path='build/py/modgc.o', has_indirect=False)
    protected int gc_enable_obj = 0x08025b9c;

    // value: Function(address=134372260, size=8, name='gc_isenabled_obj', path='build/py/modgc.o', has_indirect=False)
    protected int gc_isenabled_obj = 0x08025ba4;

    // value: Function(address=134372268, size=8, name='gc_mem_alloc_obj', path='build/py/modgc.o', has_indirect=False)
    protected int gc_mem_alloc_obj = 0x08025bac;

    // value: Function(address=134372276, size=8, name='gc_mem_free_obj', path='build/py/modgc.o', has_indirect=False)
    protected int gc_mem_free_obj = 0x08025bb4;

    // value: Function(address=134372284, size=12, name='gc_threshold_obj', path='build/py/modgc.o', has_indirect=False)
    protected int gc_threshold_obj = 0x08025bbc;

    // value: Function(address=134372296, size=8, name='mp_module_gc', path='build/py/modgc.o', has_indirect=False)
    protected int mp_module_gc = 0x08025bc8;

    // value: Function(address=134372304, size=16, name='mp_module_gc_globals', path='build/py/modgc.o', has_indirect=False)
    protected int mp_module_gc_globals = 0x08025bd0;

    // value: Function(address=134372320, size=64, name='mp_module_gc_globals_table', path='build/py/modgc.o', has_indirect=False)
    protected int mp_module_gc_globals_table = 0x08025be0;

    // value: Function(address=134372384, size=8, name='mp_module_io', path='build/py/modio.o', has_indirect=False)
    protected int mp_module_io = 0x08025c20;

    // value: Function(address=134372392, size=16, name='mp_module_io_globals', path='build/py/modio.o', has_indirect=False)
    protected int mp_module_io_globals = 0x08025c28;

    // value: Function(address=134372408, size=56, name='mp_module_io_globals_table', path='build/py/modio.o', has_indirect=False)
    protected int mp_module_io_globals_table = 0x08025c38;

    // value: Function(address=134372464, size=8, name='resource_stream_obj', path='build/py/modio.o', has_indirect=False)
    protected int resource_stream_obj = 0x08025c70;

    // value: Function(address=134372472, size=18, name='math_generic_1_str1_1', path='build/py/modmath.o', has_indirect=False)
    protected int math_generic_1_str1_1 = 0x08025c78;

    // value: Function(address=134372492, size=8, name='mp_math_acos_obj', path='build/py/modmath.o', has_indirect=False)
    protected int mp_math_acos_obj = 0x08025c8c;

    // value: Function(address=134372500, size=8, name='mp_math_acosh_obj', path='build/py/modmath.o', has_indirect=False)
    protected int mp_math_acosh_obj = 0x08025c94;

    // value: Function(address=134372508, size=8, name='mp_math_asin_obj', path='build/py/modmath.o', has_indirect=False)
    protected int mp_math_asin_obj = 0x08025c9c;

    // value: Function(address=134372516, size=8, name='mp_math_asinh_obj', path='build/py/modmath.o', has_indirect=False)
    protected int mp_math_asinh_obj = 0x08025ca4;

    // value: Function(address=134372524, size=8, name='mp_math_atan2_obj', path='build/py/modmath.o', has_indirect=False)
    protected int mp_math_atan2_obj = 0x08025cac;

    // value: Function(address=134372532, size=8, name='mp_math_atan_obj', path='build/py/modmath.o', has_indirect=False)
    protected int mp_math_atan_obj = 0x08025cb4;

    // value: Function(address=134372540, size=8, name='mp_math_atanh_obj', path='build/py/modmath.o', has_indirect=False)
    protected int mp_math_atanh_obj = 0x08025cbc;

    // value: Function(address=134372548, size=8, name='mp_math_ceil_obj', path='build/py/modmath.o', has_indirect=False)
    protected int mp_math_ceil_obj = 0x08025cc4;

    // value: Function(address=134372556, size=8, name='mp_math_copysign_obj', path='build/py/modmath.o', has_indirect=False)
    protected int mp_math_copysign_obj = 0x08025ccc;

    // value: Function(address=134372564, size=8, name='mp_math_cos_obj', path='build/py/modmath.o', has_indirect=False)
    protected int mp_math_cos_obj = 0x08025cd4;

    // value: Function(address=134372572, size=8, name='mp_math_cosh_obj', path='build/py/modmath.o', has_indirect=False)
    protected int mp_math_cosh_obj = 0x08025cdc;

    // value: Function(address=134372580, size=8, name='mp_math_degrees_obj', path='build/py/modmath.o', has_indirect=False)
    protected int mp_math_degrees_obj = 0x08025ce4;

    // value: Function(address=134372588, size=8, name='mp_math_erf_obj', path='build/py/modmath.o', has_indirect=False)
    protected int mp_math_erf_obj = 0x08025cec;

    // value: Function(address=134372596, size=8, name='mp_math_erfc_obj', path='build/py/modmath.o', has_indirect=False)
    protected int mp_math_erfc_obj = 0x08025cf4;

    // value: Function(address=134372604, size=8, name='mp_math_exp_obj', path='build/py/modmath.o', has_indirect=False)
    protected int mp_math_exp_obj = 0x08025cfc;

    // value: Function(address=134372612, size=8, name='mp_math_expm1_obj', path='build/py/modmath.o', has_indirect=False)
    protected int mp_math_expm1_obj = 0x08025d04;

    // value: Function(address=134372620, size=8, name='mp_math_fabs_obj', path='build/py/modmath.o', has_indirect=False)
    protected int mp_math_fabs_obj = 0x08025d0c;

    // value: Function(address=134372628, size=8, name='mp_math_floor_obj', path='build/py/modmath.o', has_indirect=False)
    protected int mp_math_floor_obj = 0x08025d14;

    // value: Function(address=134372636, size=8, name='mp_math_fmod_obj', path='build/py/modmath.o', has_indirect=False)
    protected int mp_math_fmod_obj = 0x08025d1c;

    // value: Function(address=134372644, size=8, name='mp_math_frexp_obj', path='build/py/modmath.o', has_indirect=False)
    protected int mp_math_frexp_obj = 0x08025d24;

    // value: Function(address=134372652, size=8, name='mp_math_gamma_obj', path='build/py/modmath.o', has_indirect=False)
    protected int mp_math_gamma_obj = 0x08025d2c;

    // value: Function(address=134372660, size=8, name='mp_math_isfinite_obj', path='build/py/modmath.o', has_indirect=False)
    protected int mp_math_isfinite_obj = 0x08025d34;

    // value: Function(address=134372668, size=8, name='mp_math_isinf_obj', path='build/py/modmath.o', has_indirect=False)
    protected int mp_math_isinf_obj = 0x08025d3c;

    // value: Function(address=134372676, size=8, name='mp_math_isnan_obj', path='build/py/modmath.o', has_indirect=False)
    protected int mp_math_isnan_obj = 0x08025d44;

    // value: Function(address=134372684, size=8, name='mp_math_ldexp_obj', path='build/py/modmath.o', has_indirect=False)
    protected int mp_math_ldexp_obj = 0x08025d4c;

    // value: Function(address=134372692, size=8, name='mp_math_lgamma_obj', path='build/py/modmath.o', has_indirect=False)
    protected int mp_math_lgamma_obj = 0x08025d54;

    // value: Function(address=134372700, size=8, name='mp_math_log10_obj', path='build/py/modmath.o', has_indirect=False)
    protected int mp_math_log10_obj = 0x08025d5c;

    // value: Function(address=134372708, size=8, name='mp_math_log2_obj', path='build/py/modmath.o', has_indirect=False)
    protected int mp_math_log2_obj = 0x08025d64;

    // value: Function(address=134372716, size=12, name='mp_math_log_obj', path='build/py/modmath.o', has_indirect=False)
    protected int mp_math_log_obj = 0x08025d6c;

    // value: Function(address=134372728, size=8, name='mp_math_modf_obj', path='build/py/modmath.o', has_indirect=False)
    protected int mp_math_modf_obj = 0x08025d78;

    // value: Function(address=134372736, size=8, name='mp_math_pow_obj', path='build/py/modmath.o', has_indirect=False)
    protected int mp_math_pow_obj = 0x08025d80;

    // value: Function(address=134372744, size=8, name='mp_math_radians_obj', path='build/py/modmath.o', has_indirect=False)
    protected int mp_math_radians_obj = 0x08025d88;

    // value: Function(address=134372752, size=8, name='mp_math_sin_obj', path='build/py/modmath.o', has_indirect=False)
    protected int mp_math_sin_obj = 0x08025d90;

    // value: Function(address=134372760, size=8, name='mp_math_sinh_obj', path='build/py/modmath.o', has_indirect=False)
    protected int mp_math_sinh_obj = 0x08025d98;

    // value: Function(address=134372768, size=8, name='mp_math_sqrt_obj', path='build/py/modmath.o', has_indirect=False)
    protected int mp_math_sqrt_obj = 0x08025da0;

    // value: Function(address=134372776, size=8, name='mp_math_tan_obj', path='build/py/modmath.o', has_indirect=False)
    protected int mp_math_tan_obj = 0x08025da8;

    // value: Function(address=134372784, size=8, name='mp_math_tanh_obj', path='build/py/modmath.o', has_indirect=False)
    protected int mp_math_tanh_obj = 0x08025db0;

    // value: Function(address=134372792, size=8, name='mp_math_trunc_obj', path='build/py/modmath.o', has_indirect=False)
    protected int mp_math_trunc_obj = 0x08025db8;

    // value: Function(address=134372800, size=8, name='mp_module_math', path='build/py/modmath.o', has_indirect=False)
    protected int mp_module_math = 0x08025dc0;

    // value: Function(address=134372808, size=16, name='mp_module_math_globals', path='build/py/modmath.o', has_indirect=False)
    protected int mp_module_math_globals = 0x08025dc8;

    // value: Function(address=134372824, size=328, name='mp_module_math_globals_table', path='build/py/modmath.o', has_indirect=False)
    protected int mp_module_math_globals_table = 0x08025dd8;

    // value: Function(address=134373152, size=8, name='mp_cmath_cos_obj', path='build/py/modcmath.o', has_indirect=False)
    protected int mp_cmath_cos_obj = 0x08025f20;

    // value: Function(address=134373160, size=8, name='mp_cmath_exp_obj', path='build/py/modcmath.o', has_indirect=False)
    protected int mp_cmath_exp_obj = 0x08025f28;

    // value: Function(address=134373168, size=8, name='mp_cmath_log10_obj', path='build/py/modcmath.o', has_indirect=False)
    protected int mp_cmath_log10_obj = 0x08025f30;

    // value: Function(address=134373176, size=8, name='mp_cmath_log_obj', path='build/py/modcmath.o', has_indirect=False)
    protected int mp_cmath_log_obj = 0x08025f38;

    // value: Function(address=134373184, size=8, name='mp_cmath_phase_obj', path='build/py/modcmath.o', has_indirect=False)
    protected int mp_cmath_phase_obj = 0x08025f40;

    // value: Function(address=134373192, size=8, name='mp_cmath_polar_obj', path='build/py/modcmath.o', has_indirect=False)
    protected int mp_cmath_polar_obj = 0x08025f48;

    // value: Function(address=134373200, size=8, name='mp_cmath_rect_obj', path='build/py/modcmath.o', has_indirect=False)
    protected int mp_cmath_rect_obj = 0x08025f50;

    // value: Function(address=134373208, size=8, name='mp_cmath_sin_obj', path='build/py/modcmath.o', has_indirect=False)
    protected int mp_cmath_sin_obj = 0x08025f58;

    // value: Function(address=134373216, size=8, name='mp_cmath_sqrt_obj', path='build/py/modcmath.o', has_indirect=False)
    protected int mp_cmath_sqrt_obj = 0x08025f60;

    // value: Function(address=134373224, size=8, name='mp_module_cmath', path='build/py/modcmath.o', has_indirect=False)
    protected int mp_module_cmath = 0x08025f68;

    // value: Function(address=134373232, size=16, name='mp_module_cmath_globals', path='build/py/modcmath.o', has_indirect=False)
    protected int mp_module_cmath_globals = 0x08025f70;

    // value: Function(address=134373248, size=96, name='mp_module_cmath_globals_table', path='build/py/modcmath.o', has_indirect=False)
    protected int mp_module_cmath_globals_table = 0x08025f80;

    // value: Function(address=134373344, size=8, name='mp_micropython_heap_lock_obj', path='build/py/modmicropython.o', has_indirect=False)
    protected int mp_micropython_heap_lock_obj = 0x08025fe0;

    // value: Function(address=134373352, size=8, name='mp_micropython_heap_unlock_obj', path='build/py/modmicropython.o', has_indirect=False)
    protected int mp_micropython_heap_unlock_obj = 0x08025fe8;

    // value: Function(address=134373360, size=8, name='mp_micropython_kbd_intr_obj', path='build/py/modmicropython.o', has_indirect=False)
    protected int mp_micropython_kbd_intr_obj = 0x08025ff0;

    // value: Function(address=134373368, size=8, name='mp_micropython_mem_current_obj', path='build/py/modmicropython.o', has_indirect=False)
    protected int mp_micropython_mem_current_obj = 0x08025ff8;

    // value: Function(address=134373376, size=57, name='mp_micropython_mem_info_str1_1', path='build/py/modmicropython.o', has_indirect=False)
    protected int mp_micropython_mem_info_str1_1 = 0x08026000;

    // value: Function(address=134373436, size=12, name='mp_micropython_mem_info_obj', path='build/py/modmicropython.o', has_indirect=False)
    protected int mp_micropython_mem_info_obj = 0x0802603c;

    // value: Function(address=134373448, size=8, name='mp_micropython_mem_peak_obj', path='build/py/modmicropython.o', has_indirect=False)
    protected int mp_micropython_mem_peak_obj = 0x08026048;

    // value: Function(address=134373456, size=8, name='mp_micropython_mem_total_obj', path='build/py/modmicropython.o', has_indirect=False)
    protected int mp_micropython_mem_total_obj = 0x08026050;

    // value: Function(address=134373464, size=12, name='mp_micropython_opt_level_obj', path='build/py/modmicropython.o', has_indirect=False)
    protected int mp_micropython_opt_level_obj = 0x08026058;

    // value: Function(address=134373476, size=8, name='mp_micropython_pystack_use_obj', path='build/py/modmicropython.o', has_indirect=False)
    protected int mp_micropython_pystack_use_obj = 0x08026064;

    // value: Function(address=134373484, size=72, name='mp_micropython_qstr_info_str1_1', path='build/py/modmicropython.o', has_indirect=False)
    protected int mp_micropython_qstr_info_str1_1 = 0x0802606c;

    // value: Function(address=134373556, size=12, name='mp_micropython_qstr_info_obj', path='build/py/modmicropython.o', has_indirect=False)
    protected int mp_micropython_qstr_info_obj = 0x080260b4;

    // value: Function(address=134373568, size=20, name='mp_micropython_schedule_str1_1', path='build/py/modmicropython.o', has_indirect=False)
    protected int mp_micropython_schedule_str1_1 = 0x080260c0;

    // value: Function(address=134373588, size=8, name='mp_micropython_schedule_obj', path='build/py/modmicropython.o', has_indirect=False)
    protected int mp_micropython_schedule_obj = 0x080260d4;

    // value: Function(address=134373596, size=8, name='mp_micropython_stack_use_obj', path='build/py/modmicropython.o', has_indirect=False)
    protected int mp_micropython_stack_use_obj = 0x080260dc;

    // value: Function(address=134373604, size=8, name='mp_module_micropython', path='build/py/modmicropython.o', has_indirect=False)
    protected int mp_module_micropython = 0x080260e4;

    // value: Function(address=134373612, size=16, name='mp_module_micropython_globals', path='build/py/modmicropython.o', has_indirect=False)
    protected int mp_module_micropython_globals = 0x080260ec;

    // value: Function(address=134373628, size=112, name='mp_module_micropython_globals_table', path='build/py/modmicropython.o', has_indirect=False)
    protected int mp_module_micropython_globals_table = 0x080260fc;

    // value: Function(address=134373740, size=16, name='mp_module_struct_globals', path='build/py/modstruct.o', has_indirect=False)
    protected int mp_module_struct_globals = 0x0802616c;

    // value: Function(address=134373756, size=48, name='mp_module_struct_globals_table', path='build/py/modstruct.o', has_indirect=False)
    protected int mp_module_struct_globals_table = 0x0802617c;

    // value: Function(address=134373804, size=8, name='mp_module_ustruct', path='build/py/modstruct.o', has_indirect=False)
    protected int mp_module_ustruct = 0x080261ac;

    // value: Function(address=134373812, size=8, name='struct_calcsize_obj', path='build/py/modstruct.o', has_indirect=False)
    protected int struct_calcsize_obj = 0x080261b4;

    // value: Function(address=134373820, size=12, name='struct_pack_into_obj', path='build/py/modstruct.o', has_indirect=False)
    protected int struct_pack_into_obj = 0x080261bc;

    // value: Function(address=134373832, size=12, name='struct_pack_obj', path='build/py/modstruct.o', has_indirect=False)
    protected int struct_pack_obj = 0x080261c8;

    // value: Function(address=134373844, size=17, name='struct_unpack_from_str1_1', path='build/py/modstruct.o', has_indirect=False)
    protected int struct_unpack_from_str1_1 = 0x080261d4;

    // value: Function(address=134373864, size=12, name='struct_unpack_from_obj', path='build/py/modstruct.o', has_indirect=False)
    protected int struct_unpack_from_obj = 0x080261e8;

    // value: Function(address=134373876, size=8, name='impl_fields', path='build/py/modsys.o', has_indirect=False)
    protected int impl_fields = 0x080261f4;

    // value: Function(address=134373884, size=8, name='mp_module_sys', path='build/py/modsys.o', has_indirect=False)
    protected int mp_module_sys = 0x080261fc;

    // value: Function(address=134373892, size=16, name='mp_module_sys_globals', path='build/py/modsys.o', has_indirect=False)
    protected int mp_module_sys_globals = 0x08026204;

    // value: Function(address=134373908, size=128, name='mp_module_sys_globals_table', path='build/py/modsys.o', has_indirect=False)
    protected int mp_module_sys_globals_table = 0x08026214;

    // value: Function(address=134374036, size=8, name='mp_sys_exc_info_obj', path='build/py/modsys.o', has_indirect=False)
    protected int mp_sys_exc_info_obj = 0x08026294;

    // value: Function(address=134374044, size=12, name='mp_sys_exit_obj', path='build/py/modsys.o', has_indirect=False)
    protected int mp_sys_exit_obj = 0x0802629c;

    // value: Function(address=134374056, size=8, name='mp_sys_getsizeof_obj', path='build/py/modsys.o', has_indirect=False)
    protected int mp_sys_getsizeof_obj = 0x080262a8;

    // value: Function(address=134374064, size=20, name='mp_sys_implementation_obj', path='build/py/modsys.o', has_indirect=False)
    protected int mp_sys_implementation_obj = 0x080262b0;

    // value: Function(address=134374084, size=20, name='mp_sys_implementation_version_info_obj', path='build/py/modsys.o', has_indirect=False)
    protected int mp_sys_implementation_version_info_obj = 0x080262c4;

    // value: Function(address=134374104, size=12, name='mp_sys_print_exception_obj', path='build/py/modsys.o', has_indirect=False)
    protected int mp_sys_print_exception_obj = 0x080262d8;

    // value: Function(address=134374116, size=8, name='mp_sys_stdout_print', path='build/py/modsys.o', has_indirect=False)
    protected int mp_sys_stdout_print = 0x080262e4;

    // value: Function(address=134374124, size=20, name='mp_sys_version_info_obj', path='build/py/modsys.o', has_indirect=False)
    protected int mp_sys_version_info_obj = 0x080262ec;

    // value: Function(address=134374144, size=6, name='str1_1__4', path='build/py/modsys.o', has_indirect=False)
    protected int str1_1__4 = 0x08026300;

    // value: Function(address=134374152, size=16, name='version_obj', path='build/py/modsys.o', has_indirect=False)
    protected int version_obj = 0x08026308;

    // value: Function(address=134374168, size=16, name='errorcode_dict', path='build/py/moduerrno.o', has_indirect=False)
    protected int errorcode_dict = 0x08026318;

    // value: Function(address=134374184, size=176, name='errorcode_table', path='build/py/moduerrno.o', has_indirect=False)
    protected int errorcode_table = 0x08026328;

    // value: Function(address=134374360, size=8, name='mp_module_uerrno', path='build/py/moduerrno.o', has_indirect=False)
    protected int mp_module_uerrno = 0x080263d8;

    // value: Function(address=134374368, size=16, name='mp_module_uerrno_globals', path='build/py/moduerrno.o', has_indirect=False)
    protected int mp_module_uerrno_globals = 0x080263e0;

    // value: Function(address=134374384, size=192, name='mp_module_uerrno_globals_table', path='build/py/moduerrno.o', has_indirect=False)
    protected int mp_module_uerrno_globals_table = 0x080263f0;

    // value: Function(address=134374576, size=1024, name='entry_table_7003', path='build/py/vm.o', has_indirect=False)
    protected int entry_table_7003 = 0x080264b0;

    // value: Function(address=134375600, size=140, name='mp_execute_bytecode_str1_4', path='build/py/vm.o', has_indirect=False)
    protected int mp_execute_bytecode_str1_4 = 0x080268b0;

    // value: Function(address=134375740, size=137, name='mp_setup_code_state_str1_1', path='build/py/bc.o', has_indirect=False)
    protected int mp_setup_code_state_str1_1 = 0x0802693c;

    // value: Function(address=134375877, size=64, name='opcode_format_table', path='build/py/bc.o', has_indirect=False)
    protected int opcode_format_table = 0x080269c5;

    // value: Function(address=134375941, size=8, name='import_str_6476', path='build/py/repl.o', has_indirect=False)
    protected int import_str_6476 = 0x08026a05;

    // value: Function(address=134375949, size=4, name='mp_repl_autocomplete_str1_1', path='build/py/repl.o', has_indirect=False)
    protected int mp_repl_autocomplete_str1_1 = 0x08026a0d;

    // value: Function(address=134375953, size=38, name='mp_repl_continue_with_input_str1_1', path='build/py/repl.o', has_indirect=False)
    protected int mp_repl_continue_with_input_str1_1 = 0x08026a11;

    // value: Function(address=134375956, size=8, name='mp_module_uctypes', path='build/extmod/moductypes.o', has_indirect=False)
    protected int mp_module_uctypes = 0x08026a14;

    // value: Function(address=134375964, size=16, name='mp_module_uctypes_globals', path='build/extmod/moductypes.o', has_indirect=False)
    protected int mp_module_uctypes_globals = 0x08026a1c;

    // value: Function(address=134375980, size=240, name='mp_module_uctypes_globals_table', path='build/extmod/moductypes.o', has_indirect=False)
    protected int mp_module_uctypes_globals_table = 0x08026a2c;

    // value: Function(address=134376220, size=16, name='type2char_6468', path='build/extmod/moductypes.o', has_indirect=False)
    protected int type2char_6468 = 0x08026b1c;

    // value: Function(address=134376236, size=8, name='uctypes_struct_addressof_obj', path='build/extmod/moductypes.o', has_indirect=False)
    protected int uctypes_struct_addressof_obj = 0x08026b2c;

    // value: Function(address=134376244, size=18, name='uctypes_struct_attr_op_str1_1', path='build/extmod/moductypes.o', has_indirect=False)
    protected int uctypes_struct_attr_op_str1_1 = 0x08026b34;

    // value: Function(address=134376264, size=8, name='uctypes_struct_bytearray_at_obj', path='build/extmod/moductypes.o', has_indirect=False)
    protected int uctypes_struct_bytearray_at_obj = 0x08026b48;

    // value: Function(address=134376272, size=8, name='uctypes_struct_bytes_at_obj', path='build/extmod/moductypes.o', has_indirect=False)
    protected int uctypes_struct_bytes_at_obj = 0x08026b50;

    // value: Function(address=134376280, size=32, name='uctypes_struct_print_str1_1', path='build/extmod/moductypes.o', has_indirect=False)
    protected int uctypes_struct_print_str1_1 = 0x08026b58;

    // value: Function(address=134376312, size=74, name='uctypes_struct_size_str1_1', path='build/extmod/moductypes.o', has_indirect=False)
    protected int uctypes_struct_size_str1_1 = 0x08026b78;

    // value: Function(address=134376388, size=8, name='uctypes_struct_sizeof_obj', path='build/extmod/moductypes.o', has_indirect=False)
    protected int uctypes_struct_sizeof_obj = 0x08026bc4;

    // value: Function(address=134376396, size=48, name='uctypes_struct_subscr_str1_1', path='build/extmod/moductypes.o', has_indirect=False)
    protected int uctypes_struct_subscr_str1_1 = 0x08026bcc;

    // value: Function(address=134376444, size=60, name='uctypes_struct_type', path='build/extmod/moductypes.o', has_indirect=False)
    protected int uctypes_struct_type = 0x08026bfc;

    // value: Function(address=134376504, size=8, name='mod_ujson_dump_obj', path='build/extmod/modujson.o', has_indirect=False)
    protected int mod_ujson_dump_obj = 0x08026c38;

    // value: Function(address=134376512, size=8, name='mod_ujson_dumps_obj', path='build/extmod/modujson.o', has_indirect=False)
    protected int mod_ujson_dumps_obj = 0x08026c40;

    // value: Function(address=134376520, size=21, name='mod_ujson_load_str1_1', path='build/extmod/modujson.o', has_indirect=False)
    protected int mod_ujson_load_str1_1 = 0x08026c48;

    // value: Function(address=134376544, size=8, name='mod_ujson_load_obj', path='build/extmod/modujson.o', has_indirect=False)
    protected int mod_ujson_load_obj = 0x08026c60;

    // value: Function(address=134376552, size=8, name='mod_ujson_loads_obj', path='build/extmod/modujson.o', has_indirect=False)
    protected int mod_ujson_loads_obj = 0x08026c68;

    // value: Function(address=134376560, size=8, name='mp_module_ujson', path='build/extmod/modujson.o', has_indirect=False)
    protected int mp_module_ujson = 0x08026c70;

    // value: Function(address=134376568, size=16, name='mp_module_ujson_globals', path='build/extmod/modujson.o', has_indirect=False)
    protected int mp_module_ujson_globals = 0x08026c78;

    // value: Function(address=134376584, size=40, name='mp_module_ujson_globals_table', path='build/extmod/modujson.o', has_indirect=False)
    protected int mp_module_ujson_globals_table = 0x08026c88;

    // value: Function(address=134376624, size=8, name='match_group_obj', path='build/extmod/modure.o', has_indirect=False)
    protected int match_group_obj = 0x08026cb0;

    // value: Function(address=134376632, size=16, name='match_locals_dict', path='build/extmod/modure.o', has_indirect=False)
    protected int match_locals_dict = 0x08026cb8;

    // value: Function(address=134376648, size=8, name='match_locals_dict_table', path='build/extmod/modure.o', has_indirect=False)
    protected int match_locals_dict_table = 0x08026cc8;

    // value: Function(address=134376656, size=15, name='match_print_str1_1', path='build/extmod/modure.o', has_indirect=False)
    protected int match_print_str1_1 = 0x08026cd0;

    // value: Function(address=134376672, size=60, name='match_type', path='build/extmod/modure.o', has_indirect=False)
    protected int match_type = 0x08026ce0;

    // value: Function(address=134376732, size=15, name='mod_re_compile_str1_1', path='build/extmod/modure.o', has_indirect=False)
    protected int mod_re_compile_str1_1 = 0x08026d1c;

    // value: Function(address=134376748, size=12, name='mod_re_compile_obj', path='build/extmod/modure.o', has_indirect=False)
    protected int mod_re_compile_obj = 0x08026d2c;

    // value: Function(address=134376760, size=12, name='mod_re_match_obj', path='build/extmod/modure.o', has_indirect=False)
    protected int mod_re_match_obj = 0x08026d38;

    // value: Function(address=134376772, size=12, name='mod_re_search_obj', path='build/extmod/modure.o', has_indirect=False)
    protected int mod_re_search_obj = 0x08026d44;

    // value: Function(address=134376784, size=16, name='mp_module_re_globals', path='build/extmod/modure.o', has_indirect=False)
    protected int mp_module_re_globals = 0x08026d50;

    // value: Function(address=134376800, size=40, name='mp_module_re_globals_table', path='build/extmod/modure.o', has_indirect=False)
    protected int mp_module_re_globals_table = 0x08026d60;

    // value: Function(address=134376840, size=8, name='mp_module_ure', path='build/extmod/modure.o', has_indirect=False)
    protected int mp_module_ure = 0x08026d88;

    // value: Function(address=134376848, size=138, name='re1_5_dumpcode_str1_1', path='build/extmod/modure.o', has_indirect=False)
    protected int re1_5_dumpcode_str1_1 = 0x08026d90;

    // value: Function(address=134376988, size=16, name='re_locals_dict', path='build/extmod/modure.o', has_indirect=False)
    protected int re_locals_dict = 0x08026e1c;

    // value: Function(address=134377004, size=24, name='re_locals_dict_table', path='build/extmod/modure.o', has_indirect=False)
    protected int re_locals_dict_table = 0x08026e2c;

    // value: Function(address=134377028, size=12, name='re_match_obj', path='build/extmod/modure.o', has_indirect=False)
    protected int re_match_obj = 0x08026e44;

    // value: Function(address=134377040, size=8, name='re_print_str1_1', path='build/extmod/modure.o', has_indirect=False)
    protected int re_print_str1_1 = 0x08026e50;

    // value: Function(address=134377048, size=12, name='re_search_obj', path='build/extmod/modure.o', has_indirect=False)
    protected int re_search_obj = 0x08026e58;

    // value: Function(address=134377060, size=28, name='re_split_str1_1', path='build/extmod/modure.o', has_indirect=False)
    protected int re_split_str1_1 = 0x08026e64;

    // value: Function(address=134377088, size=12, name='re_split_obj', path='build/extmod/modure.o', has_indirect=False)
    protected int re_split_obj = 0x08026e80;

    // value: Function(address=134377100, size=60, name='re_type', path='build/extmod/modure.o', has_indirect=False)
    protected int re_type = 0x08026e8c;

    // value: Function(address=134377160, size=19, name='clcidx', path='build/extmod/moduzlib.o', has_indirect=False)
    protected int clcidx = 0x08026ec8;

    // value: Function(address=134377180, size=16, name='decompio_locals_dict', path='build/extmod/moduzlib.o', has_indirect=False)
    protected int decompio_locals_dict = 0x08026edc;

    // value: Function(address=134377196, size=24, name='decompio_locals_dict_table', path='build/extmod/moduzlib.o', has_indirect=False)
    protected int decompio_locals_dict_table = 0x08026eec;

    // value: Function(address=134377220, size=19, name='decompio_make_new_str1_1', path='build/extmod/moduzlib.o', has_indirect=False)
    protected int decompio_make_new_str1_1 = 0x08026f04;

    // value: Function(address=134377240, size=16, name='decompio_stream_p', path='build/extmod/moduzlib.o', has_indirect=False)
    protected int decompio_stream_p = 0x08026f18;

    // value: Function(address=134377256, size=60, name='decompio_type', path='build/extmod/moduzlib.o', has_indirect=False)
    protected int decompio_type = 0x08026f28;

    // value: Function(address=134377316, size=60, name='dist_base', path='build/extmod/moduzlib.o', has_indirect=False)
    protected int dist_base = 0x08026f64;

    // value: Function(address=134377376, size=30, name='dist_bits', path='build/extmod/moduzlib.o', has_indirect=False)
    protected int dist_bits = 0x08026fa0;

    // value: Function(address=134377406, size=60, name='length_base', path='build/extmod/moduzlib.o', has_indirect=False)
    protected int length_base = 0x08026fbe;

    // value: Function(address=134377466, size=30, name='length_bits', path='build/extmod/moduzlib.o', has_indirect=False)
    protected int length_bits = 0x08026ffa;

    // value: Function(address=134377496, size=12, name='mod_uzlib_decompress_obj', path='build/extmod/moduzlib.o', has_indirect=False)
    protected int mod_uzlib_decompress_obj = 0x08027018;

    // value: Function(address=134377508, size=8, name='mp_module_uzlib', path='build/extmod/moduzlib.o', has_indirect=False)
    protected int mp_module_uzlib = 0x08027024;

    // value: Function(address=134377516, size=16, name='mp_module_uzlib_globals', path='build/extmod/moduzlib.o', has_indirect=False)
    protected int mp_module_uzlib_globals = 0x0802702c;

    // value: Function(address=134377532, size=24, name='mp_module_uzlib_globals_table', path='build/extmod/moduzlib.o', has_indirect=False)
    protected int mp_module_uzlib_globals_table = 0x0802703c;

    // value: Function(address=134377556, size=64, name='tinf_crc32tab', path='build/extmod/moduzlib.o', has_indirect=False)
    protected int tinf_crc32tab = 0x08027054;

    // value: Function(address=134377620, size=20, name='get_heap_str1_1', path='build/extmod/moduheapq.o', has_indirect=False)
    protected int get_heap_str1_1 = 0x08027094;

    // value: Function(address=134377640, size=8, name='mod_uheapq_heapify_obj', path='build/extmod/moduheapq.o', has_indirect=False)
    protected int mod_uheapq_heapify_obj = 0x080270a8;

    // value: Function(address=134377648, size=11, name='mod_uheapq_heappop_str1_1', path='build/extmod/moduheapq.o', has_indirect=False)
    protected int mod_uheapq_heappop_str1_1 = 0x080270b0;

    // value: Function(address=134377660, size=8, name='mod_uheapq_heappop_obj', path='build/extmod/moduheapq.o', has_indirect=False)
    protected int mod_uheapq_heappop_obj = 0x080270bc;

    // value: Function(address=134377668, size=8, name='mod_uheapq_heappush_obj', path='build/extmod/moduheapq.o', has_indirect=False)
    protected int mod_uheapq_heappush_obj = 0x080270c4;

    // value: Function(address=134377676, size=8, name='mp_module_uheapq', path='build/extmod/moduheapq.o', has_indirect=False)
    protected int mp_module_uheapq = 0x080270cc;

    // value: Function(address=134377684, size=16, name='mp_module_uheapq_globals', path='build/extmod/moduheapq.o', has_indirect=False)
    protected int mp_module_uheapq_globals = 0x080270d4;

    // value: Function(address=134377700, size=32, name='mp_module_uheapq_globals_table', path='build/extmod/moduheapq.o', has_indirect=False)
    protected int mp_module_uheapq_globals_table = 0x080270e4;

    // value: Function(address=134377732, size=8, name='mod_utimeq_heappop_obj', path='build/extmod/modutimeq.o', has_indirect=False)
    protected int mod_utimeq_heappop_obj = 0x08027104;

    // value: Function(address=134377740, size=15, name='mod_utimeq_heappush_str1_1', path='build/extmod/modutimeq.o', has_indirect=False)
    protected int mod_utimeq_heappush_str1_1 = 0x0802710c;

    // value: Function(address=134377756, size=12, name='mod_utimeq_heappush_obj', path='build/extmod/modutimeq.o', has_indirect=False)
    protected int mod_utimeq_heappush_obj = 0x0802711c;

    // value: Function(address=134377768, size=8, name='mod_utimeq_peektime_obj', path='build/extmod/modutimeq.o', has_indirect=False)
    protected int mod_utimeq_peektime_obj = 0x08027128;

    // value: Function(address=134377776, size=8, name='mp_module_utimeq', path='build/extmod/modutimeq.o', has_indirect=False)
    protected int mp_module_utimeq = 0x08027130;

    // value: Function(address=134377784, size=16, name='mp_module_utimeq_globals', path='build/extmod/modutimeq.o', has_indirect=False)
    protected int mp_module_utimeq_globals = 0x08027138;

    // value: Function(address=134377800, size=16, name='mp_module_utimeq_globals_table', path='build/extmod/modutimeq.o', has_indirect=False)
    protected int mp_module_utimeq_globals_table = 0x08027148;

    // value: Function(address=134377816, size=16, name='utimeq_locals_dict', path='build/extmod/modutimeq.o', has_indirect=False)
    protected int utimeq_locals_dict = 0x08027158;

    // value: Function(address=134377832, size=24, name='utimeq_locals_dict_table', path='build/extmod/modutimeq.o', has_indirect=False)
    protected int utimeq_locals_dict_table = 0x08027168;

    // value: Function(address=134377856, size=60, name='utimeq_type', path='build/extmod/modutimeq.o', has_indirect=False)
    protected int utimeq_type = 0x08027180;

    // value: Function(address=134377916, size=256, name='rodata_k', path='build/extmod/moduhashlib.o', has_indirect=False)
    protected int rodata_k = 0x080271bc;

    // value: Function(address=134378172, size=8, name='mp_module_uhashlib', path='build/extmod/moduhashlib.o', has_indirect=False)
    protected int mp_module_uhashlib = 0x080272bc;

    // value: Function(address=134378180, size=16, name='mp_module_uhashlib_globals', path='build/extmod/moduhashlib.o', has_indirect=False)
    protected int mp_module_uhashlib_globals = 0x080272c4;

    // value: Function(address=134378196, size=16, name='mp_module_uhashlib_globals_table', path='build/extmod/moduhashlib.o', has_indirect=False)
    protected int mp_module_uhashlib_globals_table = 0x080272d4;

    // value: Function(address=134378212, size=8, name='uhashlib_sha256_digest_obj', path='build/extmod/moduhashlib.o', has_indirect=False)
    protected int uhashlib_sha256_digest_obj = 0x080272e4;

    // value: Function(address=134378220, size=16, name='uhashlib_sha256_locals_dict', path='build/extmod/moduhashlib.o', has_indirect=False)
    protected int uhashlib_sha256_locals_dict = 0x080272ec;

    // value: Function(address=134378236, size=16, name='uhashlib_sha256_locals_dict_table', path='build/extmod/moduhashlib.o', has_indirect=False)
    protected int uhashlib_sha256_locals_dict_table = 0x080272fc;

    // value: Function(address=134378252, size=60, name='uhashlib_sha256_type', path='build/extmod/moduhashlib.o', has_indirect=False)
    protected int uhashlib_sha256_type = 0x0802730c;

    // value: Function(address=134378312, size=8, name='uhashlib_sha256_update_obj', path='build/extmod/moduhashlib.o', has_indirect=False)
    protected int uhashlib_sha256_update_obj = 0x08027348;

    // value: Function(address=134378320, size=18, name='mod_binascii_a2b_base64_str1_1', path='build/extmod/modubinascii.o', has_indirect=False)
    protected int mod_binascii_a2b_base64_str1_1 = 0x08027350;

    // value: Function(address=134378340, size=8, name='mod_binascii_a2b_base64_obj', path='build/extmod/modubinascii.o', has_indirect=False)
    protected int mod_binascii_a2b_base64_obj = 0x08027364;

    // value: Function(address=134378348, size=8, name='mod_binascii_b2a_base64_obj', path='build/extmod/modubinascii.o', has_indirect=False)
    protected int mod_binascii_b2a_base64_obj = 0x0802736c;

    // value: Function(address=134378356, size=12, name='mod_binascii_crc32_obj', path='build/extmod/modubinascii.o', has_indirect=False)
    protected int mod_binascii_crc32_obj = 0x08027374;

    // value: Function(address=134378368, size=12, name='mod_binascii_hexlify_obj', path='build/extmod/modubinascii.o', has_indirect=False)
    protected int mod_binascii_hexlify_obj = 0x08027380;

    // value: Function(address=134378380, size=38, name='mod_binascii_unhexlify_str1_1', path='build/extmod/modubinascii.o', has_indirect=False)
    protected int mod_binascii_unhexlify_str1_1 = 0x0802738c;

    // value: Function(address=134378420, size=8, name='mod_binascii_unhexlify_obj', path='build/extmod/modubinascii.o', has_indirect=False)
    protected int mod_binascii_unhexlify_obj = 0x080273b4;

    // value: Function(address=134378428, size=16, name='mp_module_binascii_globals', path='build/extmod/modubinascii.o', has_indirect=False)
    protected int mp_module_binascii_globals = 0x080273bc;

    // value: Function(address=134378444, size=48, name='mp_module_binascii_globals_table', path='build/extmod/modubinascii.o', has_indirect=False)
    protected int mp_module_binascii_globals_table = 0x080273cc;

    // value: Function(address=134378492, size=8, name='mp_module_ubinascii', path='build/extmod/modubinascii.o', has_indirect=False)
    protected int mp_module_ubinascii = 0x080273fc;

    // value: Function(address=134378500, size=8, name='machine_mem16_obj', path='build/extmod/machine_mem.o', has_indirect=False)
    protected int machine_mem16_obj = 0x08027404;

    // value: Function(address=134378508, size=8, name='machine_mem32_obj', path='build/extmod/machine_mem.o', has_indirect=False)
    protected int machine_mem32_obj = 0x0802740c;

    // value: Function(address=134378516, size=8, name='machine_mem8_obj', path='build/extmod/machine_mem.o', has_indirect=False)
    protected int machine_mem8_obj = 0x08027414;

    // value: Function(address=134378524, size=40, name='machine_mem_get_addr_str1_1', path='build/extmod/machine_mem.o', has_indirect=False)
    protected int machine_mem_get_addr_str1_1 = 0x0802741c;

    // value: Function(address=134378564, size=16, name='machine_mem_print_str1_1', path='build/extmod/machine_mem.o', has_indirect=False)
    protected int machine_mem_print_str1_1 = 0x08027444;

    // value: Function(address=134378580, size=60, name='machine_mem_type', path='build/extmod/machine_mem.o', has_indirect=False)
    protected int machine_mem_type = 0x08027454;

    // value: Function(address=134378640, size=8, name='mod_urandom_choice_obj', path='build/extmod/modurandom.o', has_indirect=False)
    protected int mod_urandom_choice_obj = 0x08027490;

    // value: Function(address=134378648, size=8, name='mod_urandom_getrandbits_obj', path='build/extmod/modurandom.o', has_indirect=False)
    protected int mod_urandom_getrandbits_obj = 0x08027498;

    // value: Function(address=134378656, size=8, name='mod_urandom_randint_obj', path='build/extmod/modurandom.o', has_indirect=False)
    protected int mod_urandom_randint_obj = 0x080274a0;

    // value: Function(address=134378664, size=8, name='mod_urandom_random_obj', path='build/extmod/modurandom.o', has_indirect=False)
    protected int mod_urandom_random_obj = 0x080274a8;

    // value: Function(address=134378672, size=12, name='mod_urandom_randrange_obj', path='build/extmod/modurandom.o', has_indirect=False)
    protected int mod_urandom_randrange_obj = 0x080274b0;

    // value: Function(address=134378684, size=8, name='mod_urandom_seed_obj', path='build/extmod/modurandom.o', has_indirect=False)
    protected int mod_urandom_seed_obj = 0x080274bc;

    // value: Function(address=134378692, size=8, name='mod_urandom_uniform_obj', path='build/extmod/modurandom.o', has_indirect=False)
    protected int mod_urandom_uniform_obj = 0x080274c4;

    // value: Function(address=134378700, size=8, name='mp_module_urandom', path='build/extmod/modurandom.o', has_indirect=False)
    protected int mp_module_urandom = 0x080274cc;

    // value: Function(address=134378708, size=16, name='mp_module_urandom_globals', path='build/extmod/modurandom.o', has_indirect=False)
    protected int mp_module_urandom_globals = 0x080274d4;

    // value: Function(address=134378724, size=64, name='mp_module_urandom_globals_table', path='build/extmod/modurandom.o', has_indirect=False)
    protected int mp_module_urandom_globals_table = 0x080274e4;

    // value: Function(address=134378788, size=16, name='allowed_args_6655', path='build/extmod/vfs.o', has_indirect=False)
    protected int allowed_args_6655 = 0x08027524;

    // value: Function(address=134378804, size=32, name='allowed_args_6689', path='build/extmod/vfs.o', has_indirect=False)
    protected int allowed_args_6689 = 0x08027534;

    // value: Function(address=134378836, size=8, name='mp_vfs_chdir_obj', path='build/extmod/vfs.o', has_indirect=False)
    protected int mp_vfs_chdir_obj = 0x08027554;

    // value: Function(address=134378844, size=8, name='mp_vfs_getcwd_obj', path='build/extmod/vfs.o', has_indirect=False)
    protected int mp_vfs_getcwd_obj = 0x0802755c;

    // value: Function(address=134378852, size=12, name='mp_vfs_ilistdir_obj', path='build/extmod/vfs.o', has_indirect=False)
    protected int mp_vfs_ilistdir_obj = 0x08027564;

    // value: Function(address=134378864, size=12, name='mp_vfs_listdir_obj', path='build/extmod/vfs.o', has_indirect=False)
    protected int mp_vfs_listdir_obj = 0x08027570;

    // value: Function(address=134378876, size=8, name='mp_vfs_mkdir_obj', path='build/extmod/vfs.o', has_indirect=False)
    protected int mp_vfs_mkdir_obj = 0x0802757c;

    // value: Function(address=134378884, size=12, name='mp_vfs_mount_obj', path='build/extmod/vfs.o', has_indirect=False)
    protected int mp_vfs_mount_obj = 0x08027584;

    // value: Function(address=134378896, size=12, name='mp_vfs_open_obj', path='build/extmod/vfs.o', has_indirect=False)
    protected int mp_vfs_open_obj = 0x08027590;

    // value: Function(address=134378908, size=8, name='mp_vfs_remove_obj', path='build/extmod/vfs.o', has_indirect=False)
    protected int mp_vfs_remove_obj = 0x0802759c;

    // value: Function(address=134378916, size=8, name='mp_vfs_rename_obj', path='build/extmod/vfs.o', has_indirect=False)
    protected int mp_vfs_rename_obj = 0x080275a4;

    // value: Function(address=134378924, size=8, name='mp_vfs_rmdir_obj', path='build/extmod/vfs.o', has_indirect=False)
    protected int mp_vfs_rmdir_obj = 0x080275ac;

    // value: Function(address=134378932, size=8, name='mp_vfs_stat_obj', path='build/extmod/vfs.o', has_indirect=False)
    protected int mp_vfs_stat_obj = 0x080275b4;

    // value: Function(address=134378940, size=8, name='mp_vfs_statvfs_obj', path='build/extmod/vfs.o', has_indirect=False)
    protected int mp_vfs_statvfs_obj = 0x080275bc;

    // value: Function(address=134378948, size=8, name='mp_vfs_umount_obj', path='build/extmod/vfs.o', has_indirect=False)
    protected int mp_vfs_umount_obj = 0x080275c4;

    // value: Function(address=134378956, size=8, name='mp_utime_sleep_ms_obj', path='build/extmod/utime_mphal.o', has_indirect=False)
    protected int mp_utime_sleep_ms_obj = 0x080275cc;

    // value: Function(address=134378964, size=8, name='mp_utime_sleep_obj', path='build/extmod/utime_mphal.o', has_indirect=False)
    protected int mp_utime_sleep_obj = 0x080275d4;

    // value: Function(address=134378972, size=8, name='mp_utime_ticks_add_obj', path='build/extmod/utime_mphal.o', has_indirect=False)
    protected int mp_utime_ticks_add_obj = 0x080275dc;

    // value: Function(address=134378980, size=8, name='mp_utime_ticks_cpu_obj', path='build/extmod/utime_mphal.o', has_indirect=False)
    protected int mp_utime_ticks_cpu_obj = 0x080275e4;

    // value: Function(address=134378988, size=8, name='mp_utime_ticks_diff_obj', path='build/extmod/utime_mphal.o', has_indirect=False)
    protected int mp_utime_ticks_diff_obj = 0x080275ec;

    // value: Function(address=134378996, size=8, name='mp_utime_ticks_ms_obj', path='build/extmod/utime_mphal.o', has_indirect=False)
    protected int mp_utime_ticks_ms_obj = 0x080275f4;

    // value: Function(address=134379004, size=8105, name='mp_frozen_str_content', path='build/build/frozen.o', has_indirect=False)
    protected int mp_frozen_str_content = 0x080275fc;

    // value: Function(address=134387109, size=13, name='mp_frozen_str_names', path='build/build/frozen.o', has_indirect=False)
    protected int mp_frozen_str_names = 0x080295a5;

    // value: Function(address=134387124, size=4, name='mp_frozen_str_sizes', path='build/build/frozen.o', has_indirect=False)
    protected int mp_frozen_str_sizes = 0x080295b4;

    // value: Function(address=134387128, size=275, name='bytecode_data__bios__lt_module_gt_', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int bytecode_data__bios__lt_module_gt_ = 0x080295b8;

    // value: Function(address=134387403, size=47, name='bytecode_data__bios__lt_module_gt__Command', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int bytecode_data__bios__lt_module_gt__Command = 0x080296cb;

    // value: Function(address=134387450, size=25, name='bytecode_data__bios__lt_module_gt__Command___call__', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int bytecode_data__bios__lt_module_gt__Command___call__ = 0x080296fa;

    // value: Function(address=134387475, size=23, name='bytecode_data__bios__lt_module_gt__Command___init__', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int bytecode_data__bios__lt_module_gt__Command___init__ = 0x08029713;

    // value: Function(address=134387498, size=54, name='bytecode_data__bios__lt_module_gt__Command___repr__', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int bytecode_data__bios__lt_module_gt__Command___repr__ = 0x0802972a;

    // value: Function(address=134387552, size=60, name='bytecode_data__bios__lt_module_gt___cls', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int bytecode_data__bios__lt_module_gt___cls = 0x08029760;

    // value: Function(address=134387612, size=79, name='bytecode_data__bios__lt_module_gt__main', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int bytecode_data__bios__lt_module_gt__main = 0x0802979c;

    // value: Function(address=134387691, size=42, name='bytecode_data__bios__lt_module_gt__mem_info', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int bytecode_data__bios__lt_module_gt__mem_info = 0x080297eb;

    // value: Function(address=134387733, size=84, name='bytecode_data__boot__lt_module_gt_', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int bytecode_data__boot__lt_module_gt_ = 0x08029815;

    // value: Function(address=134387817, size=105, name='bytecode_data_component__lt_module_gt_', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int bytecode_data_component__lt_module_gt_ = 0x08029869;

    // value: Function(address=134387922, size=54, name='bytecode_data_component__lt_module_gt__Component', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int bytecode_data_component__lt_module_gt__Component = 0x080298d2;

    // value: Function(address=134387976, size=60, name='bytecode_data_component__lt_module_gt__ComponentMethod', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int bytecode_data_component__lt_module_gt__ComponentMethod = 0x08029908;

    // value: Function(address=134388036, size=35, name='bytecode_data_component__lt_module_gt__ComponentMethod___call__', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int bytecode_data_component__lt_module_gt__ComponentMethod___call__ = 0x08029944;

    // value: Function(address=134388071, size=29, name='bytecode_data_component__lt_module_gt__ComponentMethod___init__', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int bytecode_data_component__lt_module_gt__ComponentMethod___init__ = 0x08029967;

    // value: Function(address=134388100, size=70, name='bytecode_data_component__lt_module_gt__ComponentMethod___repr__', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int bytecode_data_component__lt_module_gt__ComponentMethod___repr__ = 0x08029984;

    // value: Function(address=134388170, size=33, name='bytecode_data_component__lt_module_gt__ComponentMethod_doc', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int bytecode_data_component__lt_module_gt__ComponentMethod_doc = 0x080299ca;

    // value: Function(address=134388203, size=46, name='bytecode_data_component__lt_module_gt__Component___dir__', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int bytecode_data_component__lt_module_gt__Component___dir__ = 0x080299eb;

    // value: Function(address=134388249, size=24, name='bytecode_data_component__lt_module_gt__Component___getattr__', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int bytecode_data_component__lt_module_gt__Component___getattr__ = 0x08029a19;

    // value: Function(address=134388273, size=29, name='bytecode_data_component__lt_module_gt__Component___init__', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int bytecode_data_component__lt_module_gt__Component___init__ = 0x08029a31;

    // value: Function(address=134388302, size=32, name='bytecode_data_component__lt_module_gt__Component___repr__', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int bytecode_data_component__lt_module_gt__Component___repr__ = 0x08029a4e;

    // value: Function(address=134388334, size=55, name='bytecode_data_component__lt_module_gt__Monitor', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int bytecode_data_component__lt_module_gt__Monitor = 0x08029a6e;

    // value: Function(address=134388389, size=27, name='bytecode_data_component__lt_module_gt__Monitor___getattr__', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int bytecode_data_component__lt_module_gt__Monitor___getattr__ = 0x08029aa5;

    // value: Function(address=134388416, size=55, name='bytecode_data_component__lt_module_gt__Monitor___init__', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int bytecode_data_component__lt_module_gt__Monitor___init__ = 0x08029ac0;

    // value: Function(address=134388471, size=243, name='bytecode_data_component__lt_module_gt__Monitor_putChar', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int bytecode_data_component__lt_module_gt__Monitor_putChar = 0x08029af7;

    // value: Function(address=134388714, size=64, name='bytecode_data_component__lt_module_gt__Monitor_scroll', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int bytecode_data_component__lt_module_gt__Monitor_scroll = 0x08029bea;

    // value: Function(address=134388778, size=34, name='bytecode_data_component__lt_module_gt__components', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int bytecode_data_component__lt_module_gt__components = 0x08029c2a;

    // value: Function(address=134388812, size=41, name='bytecode_data_component__lt_module_gt__components__lt_dictcomp_gt_', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int bytecode_data_component__lt_module_gt__components__lt_dictcomp_gt_ = 0x08029c4c;

    // value: Function(address=134388853, size=218, name='bytecode_data_handler__lt_module_gt_', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int bytecode_data_handler__lt_module_gt_ = 0x08029c75;

    // value: Function(address=134389071, size=116, name='bytecode_data_handler__lt_module_gt__print_handler', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int bytecode_data_handler__lt_module_gt__print_handler = 0x08029d4f;

    // value: Function(address=134389187, size=334, name='bytecode_data_handler__lt_module_gt__signal_handle', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int bytecode_data_handler__lt_module_gt__signal_handle = 0x08029dc3;

    // value: Function(address=134389521, size=31, name='bytecode_data_handler__lt_module_gt__signal_handler', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int bytecode_data_handler__lt_module_gt__signal_handler = 0x08029f11;

    // value: Function(address=134389552, size=16, name='bytecode_data_main__lt_module_gt_', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int bytecode_data_main__lt_module_gt_ = 0x08029f30;

    // value: Function(address=134389568, size=144, name='bytecode_data_system__lt_module_gt_', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int bytecode_data_system__lt_module_gt_ = 0x08029f40;

    // value: Function(address=134389712, size=30, name='bytecode_data_system__lt_module_gt__ExternalException', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int bytecode_data_system__lt_module_gt__ExternalException = 0x08029fd0;

    // value: Function(address=134389742, size=70, name='bytecode_data_system__lt_module_gt__annotations', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int bytecode_data_system__lt_module_gt__annotations = 0x08029fee;

    // value: Function(address=134389812, size=30, name='bytecode_data_system__lt_module_gt__components', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int bytecode_data_system__lt_module_gt__components = 0x0802a034;

    // value: Function(address=134389842, size=36, name='bytecode_data_system__lt_module_gt__debug', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int bytecode_data_system__lt_module_gt__debug = 0x0802a052;

    // value: Function(address=134389878, size=56, name='bytecode_data_system__lt_module_gt__methods', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int bytecode_data_system__lt_module_gt__methods = 0x0802a076;

    // value: Function(address=134389934, size=35, name='bytecode_data_system__lt_module_gt__parse', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int bytecode_data_system__lt_module_gt__parse = 0x0802a0ae;

    // value: Function(address=134389969, size=76, name='bytecode_data_system__lt_module_gt__raw_syscall', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int bytecode_data_system__lt_module_gt__raw_syscall = 0x0802a0d1;

    // value: Function(address=134390045, size=33, name='bytecode_data_system__lt_module_gt__signal', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int bytecode_data_system__lt_module_gt__signal = 0x0802a11d;

    // value: Function(address=134390078, size=116, name='bytecode_data_system__lt_module_gt__syscall', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int bytecode_data_system__lt_module_gt__syscall = 0x0802a13e;

    // value: Function(address=134390194, size=87, name='bytecode_data_vfs__lt_module_gt_', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int bytecode_data_vfs__lt_module_gt_ = 0x0802a1b2;

    // value: Function(address=134390281, size=123, name='bytecode_data_vfs__lt_module_gt__FileSystem', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int bytecode_data_vfs__lt_module_gt__FileSystem = 0x0802a209;

    // value: Function(address=134390404, size=63, name='bytecode_data_vfs__lt_module_gt__FileSystem___init__', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int bytecode_data_vfs__lt_module_gt__FileSystem___init__ = 0x0802a284;

    // value: Function(address=134390467, size=28, name='bytecode_data_vfs__lt_module_gt__FileSystem___repr__', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int bytecode_data_vfs__lt_module_gt__FileSystem___repr__ = 0x0802a2c3;

    // value: Function(address=134390495, size=46, name='bytecode_data_vfs__lt_module_gt__FileSystem_chdir', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int bytecode_data_vfs__lt_module_gt__FileSystem_chdir = 0x0802a2df;

    // value: Function(address=134390541, size=21, name='bytecode_data_vfs__lt_module_gt__FileSystem_getcwd', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int bytecode_data_vfs__lt_module_gt__FileSystem_getcwd = 0x0802a30d;

    // value: Function(address=134390562, size=95, name='bytecode_data_vfs__lt_module_gt__FileSystem_ilistdir', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int bytecode_data_vfs__lt_module_gt__FileSystem_ilistdir = 0x0802a322;

    // value: Function(address=134390657, size=114, name='bytecode_data_vfs__lt_module_gt__FileSystem_mkdir', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int bytecode_data_vfs__lt_module_gt__FileSystem_mkdir = 0x0802a381;

    // value: Function(address=134390771, size=35, name='bytecode_data_vfs__lt_module_gt__FileSystem_mount', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int bytecode_data_vfs__lt_module_gt__FileSystem_mount = 0x0802a3f3;

    // value: Function(address=134390806, size=31, name='bytecode_data_vfs__lt_module_gt__FileSystem_open', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int bytecode_data_vfs__lt_module_gt__FileSystem_open = 0x0802a416;

    // value: Function(address=134390837, size=49, name='bytecode_data_vfs__lt_module_gt__FileSystem_remove', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int bytecode_data_vfs__lt_module_gt__FileSystem_remove = 0x0802a435;

    // value: Function(address=134390886, size=61, name='bytecode_data_vfs__lt_module_gt__FileSystem_rename', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int bytecode_data_vfs__lt_module_gt__FileSystem_rename = 0x0802a466;

    // value: Function(address=134390947, size=106, name='bytecode_data_vfs__lt_module_gt__FileSystem_rmdir', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int bytecode_data_vfs__lt_module_gt__FileSystem_rmdir = 0x0802a4a3;

    // value: Function(address=134391053, size=111, name='bytecode_data_vfs__lt_module_gt__FileSystem_stat', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int bytecode_data_vfs__lt_module_gt__FileSystem_stat = 0x0802a50d;

    // value: Function(address=134391164, size=31, name='bytecode_data_vfs__lt_module_gt__FileSystem_statvfs', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int bytecode_data_vfs__lt_module_gt__FileSystem_statvfs = 0x0802a57c;

    // value: Function(address=134391195, size=18, name='bytecode_data_vfs__lt_module_gt__FileSystem_umount', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int bytecode_data_vfs__lt_module_gt__FileSystem_umount = 0x0802a59b;

    // value: Function(address=134391216, size=16, name='const_obj__bios__lt_module_gt__0', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int const_obj__bios__lt_module_gt__0 = 0x0802a5b0;

    // value: Function(address=134391232, size=16, name='const_obj_component__lt_module_gt__ComponentMethod___repr___0', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int const_obj_component__lt_module_gt__ComponentMethod___repr___0 = 0x0802a5c0;

    // value: Function(address=134391248, size=16, name='const_obj_component__lt_module_gt__Component___repr___0', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int const_obj_component__lt_module_gt__Component___repr___0 = 0x0802a5d0;

    // value: Function(address=134391264, size=16, name='const_obj_handler__lt_module_gt__signal_handle_0', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int const_obj_handler__lt_module_gt__signal_handle_0 = 0x0802a5e0;

    // value: Function(address=134391280, size=16, name='const_obj_system__lt_module_gt__0', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int const_obj_system__lt_module_gt__0 = 0x0802a5f0;

    // value: Function(address=134391296, size=16, name='const_obj_vfs__lt_module_gt__FileSystem___repr___0', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int const_obj_vfs__lt_module_gt__FileSystem___repr___0 = 0x0802a600;

    // value: Function(address=134391312, size=20, name='const_table_data__bios__lt_module_gt_', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int const_table_data__bios__lt_module_gt_ = 0x0802a610;

    // value: Function(address=134391332, size=12, name='const_table_data__bios__lt_module_gt__Command', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int const_table_data__bios__lt_module_gt__Command = 0x0802a624;

    // value: Function(address=134391344, size=4, name='const_table_data__bios__lt_module_gt__Command___call__', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int const_table_data__bios__lt_module_gt__Command___call__ = 0x0802a630;

    // value: Function(address=134391348, size=8, name='const_table_data__bios__lt_module_gt__Command___init__', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int const_table_data__bios__lt_module_gt__Command___init__ = 0x0802a634;

    // value: Function(address=134391356, size=4, name='const_table_data__bios__lt_module_gt__Command___repr__', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int const_table_data__bios__lt_module_gt__Command___repr__ = 0x0802a63c;

    // value: Function(address=134391360, size=16, name='const_table_data_component__lt_module_gt_', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int const_table_data_component__lt_module_gt_ = 0x0802a640;

    // value: Function(address=134391376, size=16, name='const_table_data_component__lt_module_gt__Component', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int const_table_data_component__lt_module_gt__Component = 0x0802a650;

    // value: Function(address=134391392, size=16, name='const_table_data_component__lt_module_gt__ComponentMethod', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int const_table_data_component__lt_module_gt__ComponentMethod = 0x0802a660;

    // value: Function(address=134391408, size=4, name='const_table_data_component__lt_module_gt__ComponentMethod___call__', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int const_table_data_component__lt_module_gt__ComponentMethod___call__ = 0x0802a670;

    // value: Function(address=134391412, size=12, name='const_table_data_component__lt_module_gt__ComponentMethod___init__', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int const_table_data_component__lt_module_gt__ComponentMethod___init__ = 0x0802a674;

    // value: Function(address=134391424, size=8, name='const_table_data_component__lt_module_gt__ComponentMethod___repr__', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int const_table_data_component__lt_module_gt__ComponentMethod___repr__ = 0x0802a680;

    // value: Function(address=134391432, size=4, name='const_table_data_component__lt_module_gt__ComponentMethod_doc', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int const_table_data_component__lt_module_gt__ComponentMethod_doc = 0x0802a688;

    // value: Function(address=134391436, size=4, name='const_table_data_component__lt_module_gt__Component___dir__', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int const_table_data_component__lt_module_gt__Component___dir__ = 0x0802a68c;

    // value: Function(address=134391440, size=8, name='const_table_data_component__lt_module_gt__Component___getattr__', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int const_table_data_component__lt_module_gt__Component___getattr__ = 0x0802a690;

    // value: Function(address=134391448, size=12, name='const_table_data_component__lt_module_gt__Component___init__', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int const_table_data_component__lt_module_gt__Component___init__ = 0x0802a698;

    // value: Function(address=134391460, size=8, name='const_table_data_component__lt_module_gt__Component___repr__', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int const_table_data_component__lt_module_gt__Component___repr__ = 0x0802a6a4;

    // value: Function(address=134391468, size=16, name='const_table_data_component__lt_module_gt__Monitor', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int const_table_data_component__lt_module_gt__Monitor = 0x0802a6ac;

    // value: Function(address=134391484, size=8, name='const_table_data_component__lt_module_gt__Monitor___getattr__', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int const_table_data_component__lt_module_gt__Monitor___getattr__ = 0x0802a6bc;

    // value: Function(address=134391492, size=8, name='const_table_data_component__lt_module_gt__Monitor___init__', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int const_table_data_component__lt_module_gt__Monitor___init__ = 0x0802a6c4;

    // value: Function(address=134391500, size=8, name='const_table_data_component__lt_module_gt__Monitor_putChar', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int const_table_data_component__lt_module_gt__Monitor_putChar = 0x0802a6cc;

    // value: Function(address=134391508, size=4, name='const_table_data_component__lt_module_gt__Monitor_scroll', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int const_table_data_component__lt_module_gt__Monitor_scroll = 0x0802a6d4;

    // value: Function(address=134391512, size=4, name='const_table_data_component__lt_module_gt__components', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int const_table_data_component__lt_module_gt__components = 0x0802a6d8;

    // value: Function(address=134391516, size=4, name='const_table_data_component__lt_module_gt__components__lt_dictcomp_gt_', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int const_table_data_component__lt_module_gt__components__lt_dictcomp_gt_ = 0x0802a6dc;

    // value: Function(address=134391520, size=12, name='const_table_data_handler__lt_module_gt_', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int const_table_data_handler__lt_module_gt_ = 0x0802a6e0;

    // value: Function(address=134391532, size=4, name='const_table_data_handler__lt_module_gt__print_handler', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int const_table_data_handler__lt_module_gt__print_handler = 0x0802a6ec;

    // value: Function(address=134391536, size=8, name='const_table_data_handler__lt_module_gt__signal_handle', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int const_table_data_handler__lt_module_gt__signal_handle = 0x0802a6f0;

    // value: Function(address=134391544, size=4, name='const_table_data_handler__lt_module_gt__signal_handler', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int const_table_data_handler__lt_module_gt__signal_handler = 0x0802a6f8;

    // value: Function(address=134391548, size=40, name='const_table_data_system__lt_module_gt_', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int const_table_data_system__lt_module_gt_ = 0x0802a6fc;

    // value: Function(address=134391588, size=8, name='const_table_data_system__lt_module_gt__annotations', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int const_table_data_system__lt_module_gt__annotations = 0x0802a724;

    // value: Function(address=134391596, size=4, name='const_table_data_system__lt_module_gt__methods', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int const_table_data_system__lt_module_gt__methods = 0x0802a72c;

    // value: Function(address=134391600, size=4, name='const_table_data_system__lt_module_gt__parse', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int const_table_data_system__lt_module_gt__parse = 0x0802a730;

    // value: Function(address=134391604, size=4, name='const_table_data_vfs__lt_module_gt_', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int const_table_data_vfs__lt_module_gt_ = 0x0802a734;

    // value: Function(address=134391608, size=56, name='const_table_data_vfs__lt_module_gt__FileSystem', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int const_table_data_vfs__lt_module_gt__FileSystem = 0x0802a738;

    // value: Function(address=134391664, size=8, name='const_table_data_vfs__lt_module_gt__FileSystem___init__', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int const_table_data_vfs__lt_module_gt__FileSystem___init__ = 0x0802a770;

    // value: Function(address=134391672, size=8, name='const_table_data_vfs__lt_module_gt__FileSystem___repr__', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int const_table_data_vfs__lt_module_gt__FileSystem___repr__ = 0x0802a778;

    // value: Function(address=134391680, size=8, name='const_table_data_vfs__lt_module_gt__FileSystem_chdir', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int const_table_data_vfs__lt_module_gt__FileSystem_chdir = 0x0802a780;

    // value: Function(address=134391688, size=4, name='const_table_data_vfs__lt_module_gt__FileSystem_getcwd', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int const_table_data_vfs__lt_module_gt__FileSystem_getcwd = 0x0802a788;

    // value: Function(address=134391692, size=8, name='const_table_data_vfs__lt_module_gt__FileSystem_ilistdir', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int const_table_data_vfs__lt_module_gt__FileSystem_ilistdir = 0x0802a78c;

    // value: Function(address=134391700, size=8, name='const_table_data_vfs__lt_module_gt__FileSystem_mkdir', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int const_table_data_vfs__lt_module_gt__FileSystem_mkdir = 0x0802a794;

    // value: Function(address=134391708, size=12, name='const_table_data_vfs__lt_module_gt__FileSystem_mount', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int const_table_data_vfs__lt_module_gt__FileSystem_mount = 0x0802a79c;

    // value: Function(address=134391720, size=12, name='const_table_data_vfs__lt_module_gt__FileSystem_open', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int const_table_data_vfs__lt_module_gt__FileSystem_open = 0x0802a7a8;

    // value: Function(address=134391732, size=8, name='const_table_data_vfs__lt_module_gt__FileSystem_remove', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int const_table_data_vfs__lt_module_gt__FileSystem_remove = 0x0802a7b4;

    // value: Function(address=134391740, size=12, name='const_table_data_vfs__lt_module_gt__FileSystem_rename', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int const_table_data_vfs__lt_module_gt__FileSystem_rename = 0x0802a7bc;

    // value: Function(address=134391752, size=8, name='const_table_data_vfs__lt_module_gt__FileSystem_rmdir', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int const_table_data_vfs__lt_module_gt__FileSystem_rmdir = 0x0802a7c8;

    // value: Function(address=134391760, size=8, name='const_table_data_vfs__lt_module_gt__FileSystem_stat', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int const_table_data_vfs__lt_module_gt__FileSystem_stat = 0x0802a7d0;

    // value: Function(address=134391768, size=8, name='const_table_data_vfs__lt_module_gt__FileSystem_statvfs', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int const_table_data_vfs__lt_module_gt__FileSystem_statvfs = 0x0802a7d8;

    // value: Function(address=134391776, size=4, name='const_table_data_vfs__lt_module_gt__FileSystem_umount', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int const_table_data_vfs__lt_module_gt__FileSystem_umount = 0x0802a7e0;

    // value: Function(address=134391780, size=28, name='mp_frozen_mpy_content', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int mp_frozen_mpy_content = 0x0802a7e4;

    // value: Function(address=134391808, size=69, name='mp_frozen_mpy_names', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int mp_frozen_mpy_names = 0x0802a800;

    // value: Function(address=134391880, size=296, name='mp_qstr_frozen_const_pool', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int mp_qstr_frozen_const_pool = 0x0802a848;

    // value: Function(address=134392176, size=16, name='raw_code__bios__lt_module_gt_', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int raw_code__bios__lt_module_gt_ = 0x0802a970;

    // value: Function(address=134392192, size=16, name='raw_code__bios__lt_module_gt__Command', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int raw_code__bios__lt_module_gt__Command = 0x0802a980;

    // value: Function(address=134392208, size=16, name='raw_code__bios__lt_module_gt__Command___call__', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int raw_code__bios__lt_module_gt__Command___call__ = 0x0802a990;

    // value: Function(address=134392224, size=16, name='raw_code__bios__lt_module_gt__Command___init__', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int raw_code__bios__lt_module_gt__Command___init__ = 0x0802a9a0;

    // value: Function(address=134392240, size=16, name='raw_code__bios__lt_module_gt__Command___repr__', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int raw_code__bios__lt_module_gt__Command___repr__ = 0x0802a9b0;

    // value: Function(address=134392256, size=16, name='raw_code__bios__lt_module_gt___cls', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int raw_code__bios__lt_module_gt___cls = 0x0802a9c0;

    // value: Function(address=134392272, size=16, name='raw_code__bios__lt_module_gt__main', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int raw_code__bios__lt_module_gt__main = 0x0802a9d0;

    // value: Function(address=134392288, size=16, name='raw_code__bios__lt_module_gt__mem_info', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int raw_code__bios__lt_module_gt__mem_info = 0x0802a9e0;

    // value: Function(address=134392304, size=16, name='raw_code__boot__lt_module_gt_', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int raw_code__boot__lt_module_gt_ = 0x0802a9f0;

    // value: Function(address=134392320, size=16, name='raw_code_component__lt_module_gt_', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int raw_code_component__lt_module_gt_ = 0x0802aa00;

    // value: Function(address=134392336, size=16, name='raw_code_component__lt_module_gt__Component', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int raw_code_component__lt_module_gt__Component = 0x0802aa10;

    // value: Function(address=134392352, size=16, name='raw_code_component__lt_module_gt__ComponentMethod', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int raw_code_component__lt_module_gt__ComponentMethod = 0x0802aa20;

    // value: Function(address=134392368, size=16, name='raw_code_component__lt_module_gt__ComponentMethod___call__', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int raw_code_component__lt_module_gt__ComponentMethod___call__ = 0x0802aa30;

    // value: Function(address=134392384, size=16, name='raw_code_component__lt_module_gt__ComponentMethod___init__', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int raw_code_component__lt_module_gt__ComponentMethod___init__ = 0x0802aa40;

    // value: Function(address=134392400, size=16, name='raw_code_component__lt_module_gt__ComponentMethod___repr__', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int raw_code_component__lt_module_gt__ComponentMethod___repr__ = 0x0802aa50;

    // value: Function(address=134392416, size=16, name='raw_code_component__lt_module_gt__ComponentMethod_doc', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int raw_code_component__lt_module_gt__ComponentMethod_doc = 0x0802aa60;

    // value: Function(address=134392432, size=16, name='raw_code_component__lt_module_gt__Component___dir__', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int raw_code_component__lt_module_gt__Component___dir__ = 0x0802aa70;

    // value: Function(address=134392448, size=16, name='raw_code_component__lt_module_gt__Component___getattr__', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int raw_code_component__lt_module_gt__Component___getattr__ = 0x0802aa80;

    // value: Function(address=134392464, size=16, name='raw_code_component__lt_module_gt__Component___init__', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int raw_code_component__lt_module_gt__Component___init__ = 0x0802aa90;

    // value: Function(address=134392480, size=16, name='raw_code_component__lt_module_gt__Component___repr__', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int raw_code_component__lt_module_gt__Component___repr__ = 0x0802aaa0;

    // value: Function(address=134392496, size=16, name='raw_code_component__lt_module_gt__Monitor', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int raw_code_component__lt_module_gt__Monitor = 0x0802aab0;

    // value: Function(address=134392512, size=16, name='raw_code_component__lt_module_gt__Monitor___getattr__', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int raw_code_component__lt_module_gt__Monitor___getattr__ = 0x0802aac0;

    // value: Function(address=134392528, size=16, name='raw_code_component__lt_module_gt__Monitor___init__', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int raw_code_component__lt_module_gt__Monitor___init__ = 0x0802aad0;

    // value: Function(address=134392544, size=16, name='raw_code_component__lt_module_gt__Monitor_putChar', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int raw_code_component__lt_module_gt__Monitor_putChar = 0x0802aae0;

    // value: Function(address=134392560, size=16, name='raw_code_component__lt_module_gt__Monitor_scroll', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int raw_code_component__lt_module_gt__Monitor_scroll = 0x0802aaf0;

    // value: Function(address=134392576, size=16, name='raw_code_component__lt_module_gt__components', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int raw_code_component__lt_module_gt__components = 0x0802ab00;

    // value: Function(address=134392592, size=16, name='raw_code_component__lt_module_gt__components__lt_dictcomp_gt_', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int raw_code_component__lt_module_gt__components__lt_dictcomp_gt_ = 0x0802ab10;

    // value: Function(address=134392608, size=16, name='raw_code_handler__lt_module_gt_', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int raw_code_handler__lt_module_gt_ = 0x0802ab20;

    // value: Function(address=134392624, size=16, name='raw_code_handler__lt_module_gt__print_handler', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int raw_code_handler__lt_module_gt__print_handler = 0x0802ab30;

    // value: Function(address=134392640, size=16, name='raw_code_handler__lt_module_gt__signal_handle', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int raw_code_handler__lt_module_gt__signal_handle = 0x0802ab40;

    // value: Function(address=134392656, size=16, name='raw_code_handler__lt_module_gt__signal_handler', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int raw_code_handler__lt_module_gt__signal_handler = 0x0802ab50;

    // value: Function(address=134392672, size=16, name='raw_code_main__lt_module_gt_', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int raw_code_main__lt_module_gt_ = 0x0802ab60;

    // value: Function(address=134392688, size=16, name='raw_code_system__lt_module_gt_', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int raw_code_system__lt_module_gt_ = 0x0802ab70;

    // value: Function(address=134392704, size=16, name='raw_code_system__lt_module_gt__ExternalException', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int raw_code_system__lt_module_gt__ExternalException = 0x0802ab80;

    // value: Function(address=134392720, size=16, name='raw_code_system__lt_module_gt__annotations', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int raw_code_system__lt_module_gt__annotations = 0x0802ab90;

    // value: Function(address=134392736, size=16, name='raw_code_system__lt_module_gt__components', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int raw_code_system__lt_module_gt__components = 0x0802aba0;

    // value: Function(address=134392752, size=16, name='raw_code_system__lt_module_gt__debug', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int raw_code_system__lt_module_gt__debug = 0x0802abb0;

    // value: Function(address=134392768, size=16, name='raw_code_system__lt_module_gt__methods', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int raw_code_system__lt_module_gt__methods = 0x0802abc0;

    // value: Function(address=134392784, size=16, name='raw_code_system__lt_module_gt__parse', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int raw_code_system__lt_module_gt__parse = 0x0802abd0;

    // value: Function(address=134392800, size=16, name='raw_code_system__lt_module_gt__raw_syscall', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int raw_code_system__lt_module_gt__raw_syscall = 0x0802abe0;

    // value: Function(address=134392816, size=16, name='raw_code_system__lt_module_gt__signal', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int raw_code_system__lt_module_gt__signal = 0x0802abf0;

    // value: Function(address=134392832, size=16, name='raw_code_system__lt_module_gt__syscall', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int raw_code_system__lt_module_gt__syscall = 0x0802ac00;

    // value: Function(address=134392848, size=16, name='raw_code_vfs__lt_module_gt_', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int raw_code_vfs__lt_module_gt_ = 0x0802ac10;

    // value: Function(address=134392864, size=16, name='raw_code_vfs__lt_module_gt__FileSystem', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int raw_code_vfs__lt_module_gt__FileSystem = 0x0802ac20;

    // value: Function(address=134392880, size=16, name='raw_code_vfs__lt_module_gt__FileSystem___init__', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int raw_code_vfs__lt_module_gt__FileSystem___init__ = 0x0802ac30;

    // value: Function(address=134392896, size=16, name='raw_code_vfs__lt_module_gt__FileSystem___repr__', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int raw_code_vfs__lt_module_gt__FileSystem___repr__ = 0x0802ac40;

    // value: Function(address=134392912, size=16, name='raw_code_vfs__lt_module_gt__FileSystem_chdir', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int raw_code_vfs__lt_module_gt__FileSystem_chdir = 0x0802ac50;

    // value: Function(address=134392928, size=16, name='raw_code_vfs__lt_module_gt__FileSystem_getcwd', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int raw_code_vfs__lt_module_gt__FileSystem_getcwd = 0x0802ac60;

    // value: Function(address=134392944, size=16, name='raw_code_vfs__lt_module_gt__FileSystem_ilistdir', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int raw_code_vfs__lt_module_gt__FileSystem_ilistdir = 0x0802ac70;

    // value: Function(address=134392960, size=16, name='raw_code_vfs__lt_module_gt__FileSystem_mkdir', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int raw_code_vfs__lt_module_gt__FileSystem_mkdir = 0x0802ac80;

    // value: Function(address=134392976, size=16, name='raw_code_vfs__lt_module_gt__FileSystem_mount', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int raw_code_vfs__lt_module_gt__FileSystem_mount = 0x0802ac90;

    // value: Function(address=134392992, size=16, name='raw_code_vfs__lt_module_gt__FileSystem_open', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int raw_code_vfs__lt_module_gt__FileSystem_open = 0x0802aca0;

    // value: Function(address=134393008, size=16, name='raw_code_vfs__lt_module_gt__FileSystem_remove', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int raw_code_vfs__lt_module_gt__FileSystem_remove = 0x0802acb0;

    // value: Function(address=134393024, size=16, name='raw_code_vfs__lt_module_gt__FileSystem_rename', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int raw_code_vfs__lt_module_gt__FileSystem_rename = 0x0802acc0;

    // value: Function(address=134393040, size=16, name='raw_code_vfs__lt_module_gt__FileSystem_rmdir', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int raw_code_vfs__lt_module_gt__FileSystem_rmdir = 0x0802acd0;

    // value: Function(address=134393056, size=16, name='raw_code_vfs__lt_module_gt__FileSystem_stat', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int raw_code_vfs__lt_module_gt__FileSystem_stat = 0x0802ace0;

    // value: Function(address=134393072, size=16, name='raw_code_vfs__lt_module_gt__FileSystem_statvfs', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int raw_code_vfs__lt_module_gt__FileSystem_statvfs = 0x0802acf0;

    // value: Function(address=134393088, size=16, name='raw_code_vfs__lt_module_gt__FileSystem_umount', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int raw_code_vfs__lt_module_gt__FileSystem_umount = 0x0802ad00;

    // value: Function(address=134393104, size=901, name='str1_1__5', path='build/build/frozen_mpy.o', has_indirect=False)
    protected int str1_1__5 = 0x0802ad10;

    // value: Function(address=134394005, size=156, name='openpie_help_text', path='build/help.o', has_indirect=False)
    protected int openpie_help_text = 0x0802b095;

    // value: Function(address=134394161, size=14, name='nlr_jump_fail_str1_1', path='build/machine.o', has_indirect=False)
    protected int nlr_jump_fail_str1_1 = 0x0802b131;

    // value: Function(address=134394176, size=16, name='machine_module_globals', path='build/modmachine.o', has_indirect=False)
    protected int machine_module_globals = 0x0802b140;

    // value: Function(address=134394192, size=32, name='machine_module_globals_table', path='build/modmachine.o', has_indirect=False)
    protected int machine_module_globals_table = 0x0802b150;

    // value: Function(address=134394224, size=8, name='mp_module_machine', path='build/modmachine.o', has_indirect=False)
    protected int mp_module_machine = 0x0802b170;

    // value: Function(address=134394232, size=8, name='mp_module_uos', path='build/moduos.o', has_indirect=False)
    protected int mp_module_uos = 0x0802b178;

    // value: Function(address=134394240, size=16, name='uos_module_globals', path='build/moduos.o', has_indirect=False)
    protected int uos_module_globals = 0x0802b180;

    // value: Function(address=134394256, size=104, name='uos_module_globals_table', path='build/moduos.o', has_indirect=False)
    protected int uos_module_globals_table = 0x0802b190;

    // value: Function(address=134394360, size=8, name='mp_module_utime', path='build/modutime.o', has_indirect=False)
    protected int mp_module_utime = 0x0802b1f8;

    // value: Function(address=134394368, size=16, name='time_module_globals', path='build/modutime.o', has_indirect=False)
    protected int time_module_globals = 0x0802b200;

    // value: Function(address=134394384, size=56, name='time_module_globals_table', path='build/modutime.o', has_indirect=False)
    protected int time_module_globals_table = 0x0802b210;

    // value: Function(address=134394440, size=8, name='mp_module_usystem', path='build/modusystem.o', has_indirect=False)
    protected int mp_module_usystem = 0x0802b248;

    // value: Function(address=134394448, size=8, name='usystem_annotations_obj', path='build/modusystem.o', has_indirect=False)
    protected int usystem_annotations_obj = 0x0802b250;

    // value: Function(address=134394456, size=8, name='usystem_components_obj', path='build/modusystem.o', has_indirect=False)
    protected int usystem_components_obj = 0x0802b258;

    // value: Function(address=134394464, size=8, name='usystem_debug_obj', path='build/modusystem.o', has_indirect=False)
    protected int usystem_debug_obj = 0x0802b260;

    // value: Function(address=134394472, size=8, name='usystem_get_stdout_str_obj', path='build/modusystem.o', has_indirect=False)
    protected int usystem_get_stdout_str_obj = 0x0802b268;

    // value: Function(address=134394480, size=8, name='usystem_methods_obj', path='build/modusystem.o', has_indirect=False)
    protected int usystem_methods_obj = 0x0802b270;

    // value: Function(address=134394488, size=16, name='usystem_module_globals', path='build/modusystem.o', has_indirect=False)
    protected int usystem_module_globals = 0x0802b278;

    // value: Function(address=134394504, size=80, name='usystem_module_globals_table', path='build/modusystem.o', has_indirect=False)
    protected int usystem_module_globals_table = 0x0802b288;

    // value: Function(address=134394584, size=8, name='usystem_print_hook_obj', path='build/modusystem.o', has_indirect=False)
    protected int usystem_print_hook_obj = 0x0802b2d8;

    // value: Function(address=134394592, size=8, name='usystem_set_stdin_char_obj', path='build/modusystem.o', has_indirect=False)
    protected int usystem_set_stdin_char_obj = 0x0802b2e0;

    // value: Function(address=134394600, size=8, name='usystem_signal_obj', path='build/modusystem.o', has_indirect=False)
    protected int usystem_signal_obj = 0x0802b2e8;

    // value: Function(address=134394608, size=8, name='usystem_syscall_obj', path='build/modusystem.o', has_indirect=False)
    protected int usystem_syscall_obj = 0x0802b2f0;

    // value: Function(address=134394616, size=24, name='allowed_args_7517', path='build/openpie_vfs.o', has_indirect=False)
    protected int allowed_args_7517 = 0x0802b2f8;

    // value: Function(address=134394640, size=16, name='fileio_stream_p', path='build/openpie_vfs.o', has_indirect=False)
    protected int fileio_stream_p = 0x0802b310;

    // value: Function(address=134394656, size=60, name='mp_type_vfs_openpie_fileio', path='build/openpie_vfs.o', has_indirect=False)
    protected int mp_type_vfs_openpie_fileio = 0x0802b320;

    // value: Function(address=134394716, size=60, name='mp_type_vfs_openpie_textio', path='build/openpie_vfs.o', has_indirect=False)
    protected int mp_type_vfs_openpie_textio = 0x0802b35c;

    // value: Function(address=134394776, size=16, name='rawfile_locals_dict', path='build/openpie_vfs.o', has_indirect=False)
    protected int rawfile_locals_dict = 0x0802b398;

    // value: Function(address=134394792, size=96, name='rawfile_locals_dict_table', path='build/openpie_vfs.o', has_indirect=False)
    protected int rawfile_locals_dict_table = 0x0802b3a8;

    // value: Function(address=134394888, size=16, name='textio_stream_p', path='build/openpie_vfs.o', has_indirect=False)
    protected int textio_stream_p = 0x0802b408;

    // value: Function(address=134394904, size=12, name='vfs_openpie_file___exit___obj', path='build/openpie_vfs.o', has_indirect=False)
    protected int vfs_openpie_file___exit___obj = 0x0802b418;

    // value: Function(address=134394916, size=8, name='vfs_openpie_file_fileno_obj', path='build/openpie_vfs.o', has_indirect=False)
    protected int vfs_openpie_file_fileno_obj = 0x0802b424;

    // value: Function(address=134394924, size=14, name='vfs_openpie_file_print_str1_1', path='build/openpie_vfs.o', has_indirect=False)
    protected int vfs_openpie_file_print_str1_1 = 0x0802b42c;

    // value: Function(address=134394940, size=8, name='mp_sys_stderr_obj', path='build/lib/utils/sys_stdio_mphal.o', has_indirect=False)
    protected int mp_sys_stderr_obj = 0x0802b43c;

    // value: Function(address=134394948, size=8, name='mp_sys_stdin_obj', path='build/lib/utils/sys_stdio_mphal.o', has_indirect=False)
    protected int mp_sys_stdin_obj = 0x0802b444;

    // value: Function(address=134394956, size=8, name='mp_sys_stdout_obj', path='build/lib/utils/sys_stdio_mphal.o', has_indirect=False)
    protected int mp_sys_stdout_obj = 0x0802b44c;

    // value: Function(address=134394964, size=8, name='stdio_buffer_obj', path='build/lib/utils/sys_stdio_mphal.o', has_indirect=False)
    protected int stdio_buffer_obj = 0x0802b454;

    // value: Function(address=134394972, size=16, name='stdio_buffer_obj_stream_p', path='build/lib/utils/sys_stdio_mphal.o', has_indirect=False)
    protected int stdio_buffer_obj_stream_p = 0x0802b45c;

    // value: Function(address=134394988, size=60, name='stdio_buffer_obj_type', path='build/lib/utils/sys_stdio_mphal.o', has_indirect=False)
    protected int stdio_buffer_obj_type = 0x0802b46c;

    // value: Function(address=134395048, size=16, name='stdio_locals_dict', path='build/lib/utils/sys_stdio_mphal.o', has_indirect=False)
    protected int stdio_locals_dict = 0x0802b4a8;

    // value: Function(address=134395064, size=80, name='stdio_locals_dict_table', path='build/lib/utils/sys_stdio_mphal.o', has_indirect=False)
    protected int stdio_locals_dict_table = 0x0802b4b8;

    // value: Function(address=134395144, size=12, name='stdio_obj___exit___obj', path='build/lib/utils/sys_stdio_mphal.o', has_indirect=False)
    protected int stdio_obj___exit___obj = 0x0802b508;

    // value: Function(address=134395156, size=15, name='stdio_obj_print_str1_1', path='build/lib/utils/sys_stdio_mphal.o', has_indirect=False)
    protected int stdio_obj_print_str1_1 = 0x0802b514;

    // value: Function(address=134395172, size=16, name='stdio_obj_stream_p', path='build/lib/utils/sys_stdio_mphal.o', has_indirect=False)
    protected int stdio_obj_stream_p = 0x0802b524;

    // value: Function(address=134395188, size=60, name='stdio_obj_type', path='build/lib/utils/sys_stdio_mphal.o', has_indirect=False)
    protected int stdio_obj_type = 0x0802b534;

    // value: Function(address=134395248, size=86, name='parse_compile_execute_str1_1', path='build/lib/utils/pyexec.o', has_indirect=False)
    protected int parse_compile_execute_str1_1 = 0x0802b570;

    // value: Function(address=134395334, size=181, name='pyexec_friendly_repl_str1_1', path='build/lib/utils/pyexec.o', has_indirect=False)
    protected int pyexec_friendly_repl_str1_1 = 0x0802b5c6;

    // value: Function(address=134395515, size=28, name='pyexec_frozen_module_str1_1', path='build/lib/utils/pyexec.o', has_indirect=False)
    protected int pyexec_frozen_module_str1_1 = 0x0802b67b;

    // value: Function(address=134395543, size=30, name='pyexec_raw_repl_str1_1', path='build/lib/utils/pyexec.o', has_indirect=False)
    protected int pyexec_raw_repl_str1_1 = 0x0802b697;

    // value: Function(address=134395573, size=10, name='mp_hal_move_cursor_back_str1_1', path='build/lib/mp-readline/readline.o', has_indirect=False)
    protected int mp_hal_move_cursor_back_str1_1 = 0x0802b6b5;

    // value: Function(address=134395583, size=4, name='readline_process_char_str1_1', path='build/lib/mp-readline/readline.o', has_indirect=False)
    protected int readline_process_char_str1_1 = 0x0802b6bf;

    // value: Function(address=134395588, size=8, name='rodata_bp', path='build/lib/libm/math.o', has_indirect=False)
    protected int rodata_bp = 0x0802b6c4;

    // value: Function(address=134395596, size=8, name='rodata_dp_h', path='build/lib/libm/math.o', has_indirect=False)
    protected int rodata_dp_h = 0x0802b6cc;

    // value: Function(address=134395604, size=8, name='rodata_dp_l', path='build/lib/libm/math.o', has_indirect=False)
    protected int rodata_dp_l = 0x0802b6d4;

    // value: Function(address=134395612, size=8, name='rodata_half', path='build/lib/libm/math.o', has_indirect=False)
    protected int rodata_half = 0x0802b6dc;

    // value: Function(address=134395620, size=16, name='atanhi', path='build/lib/libm/atanf.o', has_indirect=False)
    protected int atanhi = 0x0802b6e4;

    // value: Function(address=134395636, size=16, name='atanlo', path='build/lib/libm/atanf.o', has_indirect=False)
    protected int atanlo = 0x0802b6f4;

    // value: Function(address=134395652, size=128, name='npio2_hw', path='build/lib/libm/ef_rem_pio2.o', has_indirect=False)
    protected int npio2_hw = 0x0802b704;

    // value: Function(address=134395780, size=792, name='two_over_pi', path='build/lib/libm/ef_rem_pio2.o', has_indirect=False)
    protected int two_over_pi = 0x0802b784;

    // value: Function(address=134396572, size=44, name='rodata_PIo2', path='build/lib/libm/kf_rem_pio2.o', has_indirect=False)
    protected int rodata_PIo2 = 0x0802ba9c;

    // value: Function(address=134396616, size=12, name='init_jk', path='build/lib/libm/kf_rem_pio2.o', has_indirect=False)
    protected int init_jk = 0x0802bac8;

    // value: Function(address=134396628, size=128, name='rodata__2', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(divsf3.o)', has_indirect=False)
    protected int rodata__2 = 0x0802bad4;

    // value: Function(address=134396756, size=64, name='rodata__3', path='/opt/gcc-arm-none-eabi-7-2018-q2-update/bin/../lib/gcc/arm-none-eabi/7.3.1/thumb/v6-m/libgcc.a(mulsf3.o)', has_indirect=False)
    protected int rodata__3 = 0x0802bb54;

    // value: Function(address=536870912, size=4, name='yasmarang_d', path='build/extmod/modurandom.o', has_indirect=False)
    protected int yasmarang_d = 0x20000000;

    // value: Function(address=536870916, size=4, name='yasmarang_n', path='build/extmod/modurandom.o', has_indirect=False)
    protected int yasmarang_n = 0x20000004;

    // value: Function(address=536870920, size=4, name='yasmarang_pad', path='build/extmod/modurandom.o', has_indirect=False)
    protected int yasmarang_pad = 0x20000008;

    // value: Function(address=536870924, size=1, name='pyexec_mode_kind', path='build/lib/utils/pyexec.o', has_indirect=False)
    protected int pyexec_mode_kind = 0x2000000c;

    // value: Function(address=536870928, size=3, name='mp_dynamic_compiler', path='build/py/mpstate.o', has_indirect=False)
    protected int mp_dynamic_compiler = 0x20000010;

    // value: Function(address=536870932, size=4, name='utimeq_id', path='build/extmod/modutimeq.o', has_indirect=False)
    protected int utimeq_id = 0x20000014;

    // value: Function(address=536870936, size=1, name='yasmarang_dat', path='build/extmod/modurandom.o', has_indirect=False)
    protected int yasmarang_dat = 0x20000018;

    // value: Function(address=536870940, size=40000, name='pystack_6802', path='build/main.o', has_indirect=False)
    protected int pystack_6802 = 0x2000001c;

    // value: Function(address=536910940, size=4, name='print_hook', path='build/modusystem.o', has_indirect=False)
    protected int print_hook = 0x20009c5c;

    // value: Function(address=536910944, size=4, name='pyexec_system_exit', path='build/lib/utils/pyexec.o', has_indirect=False)
    protected int pyexec_system_exit = 0x20009c60;

    // value: Function(address=536910948, size=1, name='repl_display_debugging_info', path='build/lib/utils/pyexec.o', has_indirect=False)
    protected int repl_display_debugging_info = 0x20009c64;

    // value: Function(address=536910952, size=28, name='bss_rl', path='build/lib/mp-readline/readline.o', has_indirect=False)
    protected int bss_rl = 0x20009c68;

    // value: Function(address=536910980, size=804, name='mp_state_ctx', path='build/py/mpstate.o', has_indirect=False)
    protected int mp_state_ctx = 0x20009c84;

    // value: Function(address=536911784, size=4, name='mp_interrupt_char', path='build/lib/utils/interrupt_char.o', has_indirect=False)
    protected int mp_interrupt_char = 0x20009fa8;


}
