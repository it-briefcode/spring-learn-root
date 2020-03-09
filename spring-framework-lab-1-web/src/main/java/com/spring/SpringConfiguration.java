package com.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @ClassName: com.spring.SpringConfiguration
 * @Author: zhoucx
 * @Date: 2020/3/8 15:53
 **/
@Configuration
@ComponentScan(basePackages = "com.spring")
public class SpringConfiguration {

    //spring容器初始化时，会调用配置类的无参构造函数
    public SpringConfiguration(){
        System.out.println("容器启动初始化。。。");
    }

}
