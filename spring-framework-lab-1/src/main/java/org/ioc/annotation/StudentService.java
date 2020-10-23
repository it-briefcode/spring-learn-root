package org.ioc.annotation;

import org.ioc.bean.Student;

import java.util.List;

/**
 * @ClassName: StudentService
 * @Author: zhoucx
 * @Date: 2020/3/7 17:13
 **/
public interface StudentService {

    public List<Student> queryAll();
}
