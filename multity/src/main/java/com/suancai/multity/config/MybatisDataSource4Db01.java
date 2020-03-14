package com.suancai.multity.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @Author Bruce
 * @Date: 2020/3/14 11:46
 * @Description db01数据配置文件
 */
@Configuration
@MapperScan(basePackages = "com.suancai.multity.dao.db01",sqlSessionFactoryRef = "db01SqlSessionFactory")
public class MybatisDataSource4Db01 {

    /**
     * db1数据源
     */
    @Primary
    @Bean(name = "db01DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.db01")
    public DataSource dataSource(){
        return DataSourceBuilder.create().build();
    }

    /**
     * 配置sqlsessionFactory
     * @return
     */
    @Primary
    @Bean(name = "db01SqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("db01DataSource") DataSource dataSource) throws Exception{
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/db01/*.xml"));
        return bean.getObject();
    }

    /**
     * 配置transactionManager
     * @return
     */
    @Bean(name = "db01TransactionManager")
    public DataSourceTransactionManager dataSourceTransactionManager(@Qualifier("db01DataSource") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }
}
