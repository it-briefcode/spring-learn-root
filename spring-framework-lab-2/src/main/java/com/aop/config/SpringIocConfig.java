package com.aop.config;

import com.aop.IUserService;
import com.aop.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.aop")
@EnableAspectJAutoProxy
public class SpringIocConfig {

    @Bean
    public IUserService get(){
        return new UserService();
    }
}
