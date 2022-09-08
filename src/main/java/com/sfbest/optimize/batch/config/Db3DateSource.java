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
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * 〈一句话功能简述〉<br>
 * 〈数据源3〉
 *
 * @author ZZH
 * @create 2022/9/7
 * @since 1.0.0
 */
@Configuration
@MapperScan(basePackages = "com.sfbest.optimize.batch.mapper.db3", sqlSessionTemplateRef = "gstoreSqlSessionTemplate")
public class Db3DateSource {

    @Bean(name = "gstoreDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.gstore")
    public DataSource gstoreDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "gstoreSqlSessionFactory")
    public SqlSessionFactory gfmSqlSessionFactory(@Qualifier("gstoreDataSource") DataSource gstoreDataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        //设置数据源
        sqlSessionFactoryBean.setDataSource(gstoreDataSource);
        org.apache.ibatis.session.Configuration config = new org.apache.ibatis.session.Configuration();
        config.setMapUnderscoreToCamelCase(true);
        sqlSessionFactoryBean.setConfiguration(config);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:Mapper/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }


    @Bean(name = "gstoreSqlSessionTemplate")
    public SqlSessionTemplate gstoreSqlSessionTemplate(@Qualifier("gstoreSqlSessionFactory") SqlSessionFactory gstoreSqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(gstoreSqlSessionFactory);
    }
}

