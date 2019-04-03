package com.aiwm.sample.sso.common;


public class ResultHandler {
    public static <T> Result<T> success(T data) {
        return result(data, BaseCodeRes.SUCCESS.getCode(), BaseCodeRes.SUCCESS.getDesc());
    }

    public static <T> Result<T> fail(T data) {
        return result(data, BaseCodeRes.FAILED.getCode(), BaseCodeRes.FAILED.getDesc());
    }

    public static <T> Result<T> missingParam(T data) {
        return result(data, BaseCodeRes.MISSING_PARAM.getCode(), BaseCodeRes.MISSING_PARAM.getDesc());
    }

    public static <T> Result<T> result(T data, int code, String desc) {
        Result<T> result = new Result<>();
        result.setData(data);
        result.setCode(code);
        result.setDesc(desc);
        return result;
    }
}
