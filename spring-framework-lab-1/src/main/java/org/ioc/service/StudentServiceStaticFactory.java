package org.ioc.service;

import org.ioc.service.impl.StudentServiceImpl;

/**
 * @ClassName: StudentServiceStaticFactory
 * @Author: zhoucx
 * @Date: 2020/3/7 17:23
 **/
public class StudentServiceStaticFactory {


    public static StudentService getStudentService(){
        return new StudentServiceImpl();
    }
}
