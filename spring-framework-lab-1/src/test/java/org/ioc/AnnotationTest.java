package org.ioc;

import org.ioc.annotation.StudentService;
import org.ioc.annotation.impl.StudentServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName: AnnotationTest
 * @Author: zhoucx
 * @Date: 2020/3/8 15:41
 **/
public class AnnotationTest {


    ApplicationContext context;

    @Before
    public void before(){
        context = new ClassPathXmlApplicationContext("application-bean.xml");
    }

    @Test
    public void properties(){
        StudentService bean = context.getBean(StudentService.class);
        bean.queryAll();
    }

    @Test
    public void point(){
        StudentServiceImpl bean = context.getBean(StudentServiceImpl.class);
        bean.queryAll();
    }

}
