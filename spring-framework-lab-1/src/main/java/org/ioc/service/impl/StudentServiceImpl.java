package org.ioc.service.impl;

import org.ioc.bean.Student;
import org.ioc.dao.StudentDao;
import org.ioc.service.StudentService;

import java.util.List;

/**
 * @ClassName: StudentServiceImpl
 * @Author: zhoucx
 * @Date: 2020/3/7 17:14
 **/
public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao = new StudentDao();
    @Override
    public List<Student> queryAll() {
        return studentDao.queryAll();
    }
}
