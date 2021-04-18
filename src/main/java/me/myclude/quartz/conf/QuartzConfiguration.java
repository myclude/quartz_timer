package me.myclude.quartz.conf;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.quartz.QuartzDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Slf4j
@Configuration
@EnableAutoConfiguration
public class QuartzConfiguration {

    @Bean
    @QuartzDataSource
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public DataSource quartzDataSource() {
        return DataSourceBuilder.create().build();
    }


}
