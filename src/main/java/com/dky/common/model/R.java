package com.dky.common.model;

import com.dky.common.Code;

import java.util.HashMap;

/**
 * ${DESCRIPTION}
 *
 * @author bowen
 * @create 2017/12/25
 **/
public class R extends HashMap<String, Object> {

    private static final long serialVersionUID = 1L;

    public R() {
        put("code", Code.code_success);
        put("msg", "success");
        put("data", null);
    }

    public static R error() {
        return error(Code.code_error, "操作失败");
    }

    public static R Empty() {
        return Empty(Code.code_params_error, "参数为空");
    }

    public static R error(String msg) {
        return error(Code.code_error, msg);
    }

    public static R error(int code, String msg) {
        R r = new R();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static R Empty(int code, String msg) {
        R r = new R();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static R ok(Object data) {
        R r = new R();
        r.put("data", data);
        return r;
    }

    public static R ok() {
        return new R();
    }

    @Override
    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
