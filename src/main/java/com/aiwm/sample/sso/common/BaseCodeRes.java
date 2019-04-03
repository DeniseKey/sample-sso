package com.aiwm.sample.sso.common;

import lombok.Getter;


@Getter
public enum BaseCodeRes {
    SUCCESS(1, "成功"),
    FAILED(0, "失败"),
    CHECK_USER(2,"已存在"),
    MISSING_PARAM(-2, "参数缺失"),
    ERROR_PARAM(-3, "参数错误"),
    TIMESTAMP_OUT(3003, "请求链接失效"),
	SYSTEM_ERROR(9999, "系统异常");


    private Integer code;
    private String desc;

    BaseCodeRes(Integer code, String desc) {
        this.code = code;
        this.desc = desc;

    }

}
