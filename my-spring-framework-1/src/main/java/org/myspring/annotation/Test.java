package org.myspring.annotation;

import org.myspring.bean.Student;

public class Test {


    public static void main(String[] args) throws Exception {
        ApplicationContext context = new AnnotationConfigApplicationContext(IocConfig.class);
        Student bean = context.getBean(Student.class);
        Student bean2 = context.getBean(Student.class);
        System.out.println(bean);
        System.out.println(bean2);
    }
}
