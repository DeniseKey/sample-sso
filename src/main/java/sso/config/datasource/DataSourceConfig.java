package sso.config.datasource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.Data;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * Created by fengmc on 2019/3/25
 */
@ConfigurationProperties(prefix = "datasource")
@Data
@Configuration
public class DataSourceConfig {

    private HikariConfig mysqlConnect;


    @Bean(name = "mysqlDataSource", destroyMethod = "close")
    @Qualifier("mysqlDataSource")
    @Primary
    @RefreshScope
    public HikariDataSource mysqlDataSource() {
        return new HikariDataSource(mysqlConnect);
    }
}
