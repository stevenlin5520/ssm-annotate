package com.steven.ssm.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 引入属性配置文件application.properties
 * @author steven
 */
@Configuration
@PropertySource("classpath:application.properties")
public class PropertiesConfig {

    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.driver}")
    private String driver;
    @Value("${spring.datasource.user}")
    private String user;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.web.view.prefix}")
    private String webViewPrefix;
    @Value("${spring.web.view.suffix}")
    private String webViewSuffix;
    @Value("${spring.web.static.handler}")
    private String webStaticHandler;
    @Value("${spring.web.static.resource}")
    private String webStaticResource;
    @Value("${spring.web.static.cache.period}")
    private Integer webStaticCachedPeriod;
    @Value("${mybatis.type.alias.package}")
    private String mybatisTypeAliasPackage;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getWebViewPrefix() {
        return webViewPrefix;
    }

    public void setWebViewPrefix(String webViewPrefix) {
        this.webViewPrefix = webViewPrefix;
    }

    public String getWebViewSuffix() {
        return webViewSuffix;
    }

    public void setWebViewSuffix(String webViewSuffix) {
        this.webViewSuffix = webViewSuffix;
    }

    public String getWebStaticHandler() {
        return webStaticHandler;
    }

    public void setWebStaticHandler(String webStaticHandler) {
        this.webStaticHandler = webStaticHandler;
    }

    public String getWebStaticResource() {
        return webStaticResource;
    }

    public void setWebStaticResource(String webStaticResource) {
        this.webStaticResource = webStaticResource;
    }

    public Integer getWebStaticCachedPeriod() {
        return webStaticCachedPeriod;
    }

    public void setWebStaticCachedPeriod(Integer webStaticCachedPeriod) {
        this.webStaticCachedPeriod = webStaticCachedPeriod;
    }

    public String getMybatisTypeAliasPackage() {
        return mybatisTypeAliasPackage;
    }

    public void setMybatisTypeAliasPackage(String mybatisTypeAliasPackage) {
        this.mybatisTypeAliasPackage = mybatisTypeAliasPackage;
    }
}
