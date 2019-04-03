package com.aiwm.sample.sso.aop;

import com.alibaba.fastjson.serializer.PropertyFilter;
import com.alibaba.fastjson.serializer.ValueFilter;

import java.util.List;

/**
 * Created by fengmc on 2019/3/25
 */
public class JsonFilter implements PropertyFilter, ValueFilter {


    @Override
    public boolean apply(Object object, String name, Object value) {
        if (value instanceof byte[]) {
            return false;
        }
        return true;
    }

    @Override
    public Object process(Object object, String name, Object value) {
        if (value instanceof List) {
            List list = (List) value;
            return "size=" + list.size();
        }
        return value;
    }
}
