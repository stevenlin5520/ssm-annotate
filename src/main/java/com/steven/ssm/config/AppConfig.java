package com.steven.ssm.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.io.IOException;

/**
 * Spring与Mybatis整合
 * @author steven
 */
@Configuration  //配置类（类似于***.xml）
@ComponentScan("com.steven.ssm")  //扫描自定义的组件(repository service component controller)
@PropertySource("classpath:application.properties") // 读取application.properties
@MapperScan("com.steven.ssm.dao") //扫描Mybatis的Mapper接口
@EnableTransactionManagement //开启事务管理
public class AppConfig {

    /**
     * 注入数据源
     * @param propertiesConfig
     * @return
     */
    @Bean
    public DataSource dataSource(PropertiesConfig propertiesConfig) throws PropertyVetoException {
        DataSource dataSource = new ComboPooledDataSource();
        ((ComboPooledDataSource) dataSource).setUser(propertiesConfig.getUser());
        ((ComboPooledDataSource) dataSource).setPassword(propertiesConfig.getPassword());
        ((ComboPooledDataSource) dataSource).setDriverClass(propertiesConfig.getDriver());
        ((ComboPooledDataSource) dataSource).setJdbcUrl(propertiesConfig.getUrl());

        return dataSource;
    }

    /**
     * 配置Mybatis的SqlSessionFactoryBean工厂，将SqlSessionFactory交给Spring MVC管理
     * @param dataSource
     * @param propertiesConfig
     * @return
     */
    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource, PropertiesConfig propertiesConfig) throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setTypeAliasesPackage(propertiesConfig.getMybatisTypeAliasPackage());

        return sqlSessionFactoryBean;
    }

    /**
     * 配置spring的声明式事务
     * @return
     */
    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager(dataSource);
        return dataSourceTransactionManager;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        return propertySourcesPlaceholderConfigurer;
    }
}
