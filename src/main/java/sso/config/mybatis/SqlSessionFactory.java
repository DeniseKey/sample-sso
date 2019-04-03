package sso.config.mybatis;

import com.aiwm.sample.sso.config.mybatis.plugin.ConfigUtils;
import lombok.Data;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Created by fengmc on 2019/3/26
 */
@Data
@Configuration
@ConditionalOnClass(DataSource.class)
public class SqlSessionFactory {
    @Bean
    public SqlSessionFactoryBean mysqlSessionFactory(@Qualifier("mysqlDataSource") DataSource mailManager) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(mailManager);
        ConfigUtils.getPlugins(sqlSessionFactoryBean);
        return sqlSessionFactoryBean;
    }
}
