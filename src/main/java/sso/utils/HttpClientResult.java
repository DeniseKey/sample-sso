package sso.utils;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by fengmc on 2019/4/1
 */
@Data
public class HttpClientResult implements Serializable {
    /**
     * 响应状态码
     */
    private int code;

    /**
     * 响应数据
     */
    private String content;
}
