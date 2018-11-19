package com.imooc.config;

import com.imooc.filter.TimeFilter;
import com.imooc.interceptor.TimeInterceptor;
import com.imooc.interceptor.TimeInterceptor1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author hang
 */
@Configuration
public class WebConfig extends WebMvcConfigurationSupport {
    private final TimeInterceptor interceptor;

    private final TimeInterceptor1 interceptor1;


    @Autowired
    public WebConfig(TimeInterceptor interceptor, TimeInterceptor1 interceptor1) {
        this.interceptor = interceptor;
        this.interceptor1 = interceptor1;
    }

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor1);
        registry.addInterceptor(interceptor);
    }

    @Bean
    public FilterRegistrationBean bean(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        TimeFilter timeFilter = new TimeFilter();
        bean.setFilter(timeFilter);
        bean.setOrder(1000);
        bean.addUrlPatterns("/*");
        return bean;
    }
}
