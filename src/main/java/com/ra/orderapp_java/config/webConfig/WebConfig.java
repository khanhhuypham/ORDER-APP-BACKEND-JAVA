//package com.ra.orderapp_java.config.webConfig;
//
//import com.ra.orderapp_java.filter.CustomURLFilter;
//import com.ra.orderapp_java.interceptor.Interceptor;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class WebConfig implements WebMvcConfigurer {
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new Interceptor())
//                .addPathPatterns("/**");
//    }
//
//
//    @Bean
//    public FilterRegistrationBean<CustomURLFilter> filterRegistrationBean() {
//        FilterRegistrationBean<CustomURLFilter> registrationBean = new FilterRegistrationBean<>();
//        CustomURLFilter customURLFilter = new CustomURLFilter();
//
//        registrationBean.setFilter(customURLFilter);
//        registrationBean.addUrlPatterns("/greeting/*");
//        registrationBean.setOrder(2);  //set precedence
//        return registrationBean;
//    }
//}
