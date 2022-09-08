package com.sfbest.optimize.batch.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * 〈一句话功能简述〉<br>
 * 〈数据源2〉
 *
 * @author ZZH
 * @create 2022/9/7
 * @since 1.0.0
 */
@Configuration
@MapperScan(basePackages = "com.sfbest.optimize.batch.mapper.db2", sqlSessionTemplateRef = "gshopSqlSessionTemplate")
public class Db2DateSource {

    @Primary
    @Bean(name = "gshopDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.gshop")
    public DataSource gshopDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "gshopSqlSessionFactory")
    public SqlSessionFactory gshopSqlSessionFactory(@Qualifier("gshopDataSource") DataSource gshopDataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        //设置数据源
        sqlSessionFactoryBean.setDataSource(gshopDataSource);
        org.apache.ibatis.session.Configuration config = new org.apache.ibatis.session.Configuration();
        config.setMapUnderscoreToCamelCase(true);
        sqlSessionFactoryBean.setConfiguration(config);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:Mapper/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }


    @Bean(name = "gshopSqlSessionTemplate")
    public SqlSessionTemplate gshopSqlSessionTemplate(@Qualifier("gshopSqlSessionFactory") SqlSessionFactory gshopSqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(gshopSqlSessionFactory);
    }

    @Bean
    public PlatformTransactionManager financialTm(@Qualifier("gshopDataSource") DataSource gshopDataSource) {
        return new DataSourceTransactionManager(gshopDataSource);
    }

}

