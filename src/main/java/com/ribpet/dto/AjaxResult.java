package com.ribpet.dto;

import com.ribpet.constants.HttpStatus;

import java.util.HashMap;
import java.util.Objects;

public class AjaxResult extends HashMap<String, Object> {

    private static final long   serialVersionUID = 242180064461040653L;

    // 状态码
    private static final String CODE_TAG         = "code";

    // 返回内容
    private static final String MSG_TAG          = "msg";

    // 数据对象
    private static final String DATA_TAG         = "data";

    public AjaxResult() {
        // DO NOTHING
    }

    public AjaxResult(int code, String msg) {
        super.put(CODE_TAG, code);
        super.put(MSG_TAG, msg);
    }

    public AjaxResult(int code, String msg, Object data) {
        this(code, msg);

        if (Objects.nonNull(data)) {
            super.put(DATA_TAG, data);
        }
    }

    public static AjaxResult success() {
        return AjaxResult.success("操作成功");
    }

    public static AjaxResult success(Object object) {
        return AjaxResult.success("操作成功", object);
    }

    public static AjaxResult success(String msg) {
        return AjaxResult.success(msg, null);
    }

    public static AjaxResult success(String msg, Object data) {
        return new AjaxResult(HttpStatus.OK, msg, data);
    }

    public static AjaxResult error() {
        return AjaxResult.success("操作失败");
    }

    public static AjaxResult error(Object object) {
        return AjaxResult.error("操作失败", object);
    }

    public static AjaxResult error(String msg) {
        return AjaxResult.error(msg, null);
    }

    public static AjaxResult error(String msg, Object data) {
        return new AjaxResult(HttpStatus.INTERNAL_SERVER_ERROR, msg, data);
    }
}