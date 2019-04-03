package sso.config.mybatis;

import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import java.util.Properties;

/**
 * Created by fengmc on 2019/3/26
 */
@Data
@Configuration
public class MapperScanConfig {
    @Bean
    public MapperScannerConfigurer originalMysqMapper() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        //修改 package
        mapperScannerConfigurer.setBasePackage("com.aiwm.sample.sso.data.mapper");
        Properties properties = new Properties();
        properties.setProperty("mappers", "tk.mybatis.mapper.common.Mapper");
        mapperScannerConfigurer.setProperties(properties);
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("mysqlSessionFactory");
        return mapperScannerConfigurer;
    }
}
