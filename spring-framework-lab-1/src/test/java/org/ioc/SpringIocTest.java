package org.ioc;

import org.ioc.bean.ConstructorBean;
import org.ioc.bean.ListBean;
import org.ioc.bean.Student;
import org.ioc.service.StudentService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sun.dc.path.FastPathProducer;

import java.util.List;

/**
 * @ClassName: SpringIocTest
 * @Author: zhoucx
 * @Date: 2020/3/7 11:05
 **/
public class SpringIocTest {

    ApplicationContext context;

    @Before
    public void before(){
        context = new ClassPathXmlApplicationContext("application-bean.xml");
    }

    @Test
    public void getBean(){

        ApplicationContext context = new ClassPathXmlApplicationContext("application-bean.xml");

        Student student = (Student) context.getBean("student");

        System.out.println(student);


    }

    @Test
    public void studentService(){
        //解析配置文件，创建spring容器
        ApplicationContext context = new ClassPathXmlApplicationContext("application-bean.xml");
        //从容器中获取相应的bean，通过id获取
        StudentService studentService = (StudentService) context.getBean("studentService");
        List<Student> students = studentService.queryAll();
        System.out.println(students);
        //通过类型获取
        StudentService bean = context.getBean(StudentService.class);
        bean.queryAll();
    }

    @Test
    public void factoryBean(){
        //听过工厂方法获取bean
        ApplicationContext context = new ClassPathXmlApplicationContext("application-bean.xml");

        StudentService studentService3 = (StudentService) context.getBean("studentService3");
        List<Student> students = studentService3.queryAll();
        System.out.println(students);

    }

    @Test
    public void staticFactory(){
        ApplicationContext context = new ClassPathXmlApplicationContext("application-bean.xml");

        StudentService studentService2 = (StudentService) context.getBean("studentService2");
        List<Student> students = studentService2.queryAll();
        System.out.println(students);
    }

    @Test
    public void constructorTest(){
        ConstructorBean constructor = (ConstructorBean) context.getBean("constructor");
        System.out.println(constructor.getId());
    }

    @Test
    public void listBean(){
        ListBean listbean = (ListBean) context.getBean("listbean");
        System.out.println(listbean);
    }


}
