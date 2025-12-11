package com.seashell.jsp_demo.filter_config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;

import com.seashell.jsp_demo.filter.DashboardFilter;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<DashboardFilter> dashboardFilter() {
        FilterRegistrationBean<DashboardFilter> reg = new FilterRegistrationBean<>();
        reg.setFilter(new DashboardFilter());
        reg.addUrlPatterns("/*");
        reg.setOrder(1);
        System.out.println("Registering DashboardFilter bean");
        return reg;
    }

/* 
    @Bean
    public FilterRegistrationBean<AuthFilter> authFilter() {
        FilterRegistrationBean<AuthFilter> reg = new FilterRegistrationBean<>();
        reg.setFilter(new AuthFilter());
        reg.addUrlPatterns("/secure/*");
        reg.setOrder(2);
        return reg;
    }
    */
}
