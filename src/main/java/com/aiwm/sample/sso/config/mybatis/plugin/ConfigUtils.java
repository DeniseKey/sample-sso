package com.aiwm.sample.sso.config.mybatis.plugin;

import com.github.pagehelper.PageHelper;
import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.SqlSessionFactoryBean;

import java.util.Properties;

/**
 * Created by fengmc on 2019/3/26
 */
public class ConfigUtils {
    public static void getPlugins(SqlSessionFactoryBean sqlSessionFactoryBean) {
        Interceptor pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("dialect", "mysql");
        properties.setProperty("pageSizeZero", "true");
        pageHelper.setProperties(properties);
        sqlSessionFactoryBean.setPlugins(new Interceptor[]{new PerformanceInterceptor(), pageHelper});
    }
}
