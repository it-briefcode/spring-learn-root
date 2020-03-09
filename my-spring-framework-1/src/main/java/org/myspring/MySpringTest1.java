package org.myspring;

import org.myspring.bean.BeanDefinition;
import org.myspring.bean.BeanFactory;
import org.myspring.bean.Student;

/**
 * @ClassName: MySpringTest1
 * @Author: zhoucx
 * @Date: 2020/3/7 17:46
 **/
public class MySpringTest1 {


    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {

        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setId("student");
        beanDefinition.setClassName("org.myspring.bean.Student");

        BeanFactory.addDefinition(beanDefinition);


        BeanFactory beanFactory = new BeanFactory();
        Student student = (Student) beanFactory.getBean("student");
        System.out.println(student);

    }
}
