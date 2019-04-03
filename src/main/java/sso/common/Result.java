package sso.common;



import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by fengmc on 2019/3/25
 *
 */
@Data
@NoArgsConstructor
public class Result<T> implements Serializable {

    private T data;
    private Integer code;
    private String desc;

    public Result(T t) {
        this.data = t;
        this.code = BaseCodeRes.SUCCESS.getCode();
        this.desc = BaseCodeRes.SUCCESS.getDesc();
    }
    
    public Result(Integer code, String desc)
    {
    	this.code = code;
        this.desc = desc;
    }
}
