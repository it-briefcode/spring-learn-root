package org.ioc.annotation.config;

import org.ioc.bean.Student;
import org.springframework.context.annotation.*;

/**
 * @ClassName: SpringConfiguration
 * @Author: zhoucx
 * @Date: 2020/3/8 15:53
 **/
@Configuration
@ComponentScan(basePackages = "org.ioc")
@Import(JdbcConfig.class)
public class SpringConfiguration {

    //spring容器初始化时，会调用配置类的无参构造函数
    public SpringConfiguration(){
        System.out.println("容器启动初始化。。。");
    }

    @Bean
    //@Scope("singleton")
    public Student getStudent(){
        return new Student();
    }
}
