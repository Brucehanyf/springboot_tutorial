package com.suancai.multity.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @Author Bruce
 * @Date: 2020/3/14 11:46
 * @Description db02数据配置文件
 */
@Configuration
@MapperScan(basePackages = "com.suancai.multity.dao.db02",sqlSessionFactoryRef = "db02SqlSessionFactory")
public class MybatisDataSource4Db02 {

    /**
     * db2数据源
     */
    @Bean(name = "db02DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.db02")
    public DataSource dataSource(){
        return DataSourceBuilder.create().build();
    }

    /**
     * 配置sqlsessionFactory
     * @return
     */
    @Bean(name = "db02SqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("db02DataSource") DataSource dataSource) throws Exception{
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/db02/*.xml"));
        return bean.getObject();
    }

    /**
     * 配置transactionManager
     * @return
     */
    @Bean(name = "db02TransactionManager")
    public DataSourceTransactionManager dataSourceTransactionManager(@Qualifier("db02DataSource") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }
}
