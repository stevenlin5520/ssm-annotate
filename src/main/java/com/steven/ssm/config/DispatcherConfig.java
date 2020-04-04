package com.steven.ssm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import java.util.Properties;

/**
 * 配置SpringMVC的视图解析器，静态资源等
 * 		1 包组件扫描
 * 		2 处理器映射器mvc
 * 		3 处理器适配器mvc
 * 		4 视图解析器 （前缀 后缀）
 * 		5 全局的异常处理器
 */
@Configuration
@EnableWebMvc   //启动SpringMVC配置
public class DispatcherConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private PropertiesConfig propertiesConfig;

    /**
     * 视图解析器配置  定义跳转的文件的前后缀
     * @return
     */
    @Bean
    public InternalResourceViewResolver internalResourceViewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix(propertiesConfig.getWebViewPrefix());
        resolver.setSuffix(propertiesConfig.getWebViewSuffix());
        return resolver;
    }

    /**
     * 设置统一错误处理要跳转的视图
     * @return
     */
    @Bean
    public SimpleMappingExceptionResolver simpleMappingExceptionResolver() {
        SimpleMappingExceptionResolver simpleMappingExceptionResolver = new SimpleMappingExceptionResolver();
        Properties properties = new Properties();
        properties.getProperty("java.lang.Exception", "error");
        simpleMappingExceptionResolver.setExceptionMappings(properties);
        return simpleMappingExceptionResolver;
    }

    /**
     * 添加静态资源
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(propertiesConfig.getWebStaticHandler()).addResourceLocations(propertiesConfig.getWebStaticResource()).setCachePeriod(propertiesConfig.getWebStaticCachedPeriod());
    }

    /**
     * 添加拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
    }
}
