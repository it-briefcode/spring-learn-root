package org.ioc;

import org.ioc.annotation.StudentService;
import org.ioc.bean.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @ClassName: JavaTest
 * @Author: zhoucx
 * @Date: 2020/3/11 19:40
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-bean.xml")
public class JavaTest {
    @Autowired
    private StudentService studentService;


    @Test
    public void test(){
        List<Student> students = studentService.queryAll();
        System.out.println(students);
    }
}
