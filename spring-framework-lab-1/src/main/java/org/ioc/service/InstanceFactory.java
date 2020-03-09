package org.ioc.service;

import org.ioc.service.impl.StudentServiceImpl;

/**
 * @ClassName: InstanceFactory
 * @Author: zhoucx
 * @Date: 2020/3/7 17:25
 **/
public class InstanceFactory {


    public StudentService getInstance(){
        return new StudentServiceImpl();
    }
}
