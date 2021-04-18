package me.myclude.quartz.conf;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@MapperScan(basePackages = {"me.myclude.quartz.**.mapper"})
public class MybatisConfiguration {

//    @Bean(name = "mybatisDataSources")
//    @ConfigurationProperties(prefix = "spring.datasource")
//    public DataSource dataSource() {
//        return new HikariDataSource();
//    }
//
//    @Bean
//    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }
//
//    @Bean
//    public SqlSessionFactory sqlSessionFactory(@Qualifier("mybatisDataSources") DataSource dataSource)
//        throws Exception {
//
//        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//        sqlSessionFactoryBean.setDataSource(dataSource);
//        Resource[] resources = new PathMatchingResourcePatternResolver()
//                .getResources("classpath:mapper/**/*_Mapper.xml");
//        sqlSessionFactoryBean.setMapperLocations(resources);
//
//        return sqlSessionFactoryBean.getObject();
//    }
}
