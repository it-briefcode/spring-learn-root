package org.ioc;

import org.ioc.annotation.config.SpringConfiguration;
import org.ioc.bean.Student;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName: JavaConfigTest
 * @Author: zhoucx
 * @Date: 2020/3/8 15:57
 **/
public class JavaConfigTest {

    ApplicationContext context;


    @Before
    public void before(){
        context = new AnnotationConfigApplicationContext(SpringConfiguration.class);

    }

    @Test
    public void getStudent(){
        Student bean = context.getBean(Student.class);
        System.out.println(bean);
    }
}
