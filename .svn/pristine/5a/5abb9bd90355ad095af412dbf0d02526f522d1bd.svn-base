package org.xxpay.mgr.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.xxpay.mgr.interceptor.MchLogInterceptor;

/**
 * 
 * @file WebMvcConfig.java	
 * @author huanghongfei
 * @date 2017年12月9日 下午1:18:51
 * @declaration
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private MchLogInterceptor mchLogInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    	registry.addInterceptor(mchLogInterceptor);
    }

}
