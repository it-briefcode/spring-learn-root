package org.myspring.annotation;

import org.myspring.bean.Student;

@Configuration
public class IocConfig {


    @Bean
    public Student getBean(){
        Student student = new Student();
        student.setAge(11);
        student.setAddress("fuzhou");
        student.setName("在jam和三");
        return student;
    }
}
