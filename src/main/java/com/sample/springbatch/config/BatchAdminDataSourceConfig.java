package com.sample.springbatch.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages ="com.sample.springbatch.mapper",sqlSessionFactoryRef = "batchAdminSqlSessionFactory")
public class BatchAdminDataSourceConfig {
    @Primary
    @Bean("batchAdminDataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource batchAdminDataSource() {

        return DataSourceBuilder.create().build();
    }


    @Bean(name = "batchAdminSqlSessionFactory")
    public SqlSessionFactory batchAdminSqlSessionFactory(@Qualifier("batchAdminDataSource") DataSource batchAdminDataSource, ApplicationContext applicationContext) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(batchAdminDataSource);
       // sqlSessionFactoryBean.setConfigLocation(applicationContext.getResource("classpath:comn/mybatis-config.xml"));
       // sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:comn/mapper/*-mapper.xml"));
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBean.getObject();
        sqlSessionFactory.getConfiguration().setMapUnderscoreToCamelCase(true);
        return sqlSessionFactory;
    }
    @Bean(name = "batchAdminSqlSessionTemplate")
    public SqlSessionTemplate db1SqlSessionTemplate(SqlSessionFactory batchAdminSqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(batchAdminSqlSessionFactory);
    }
}
