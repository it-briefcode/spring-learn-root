package org.ioc.annotation.impl;

import org.ioc.annotation.StudentService;
import org.ioc.bean.Student;
import org.ioc.dao.StudentDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: StudentServiceImpl
 * @Author: zhoucx
 * @Date: 2020/3/8 15:25
 **/
@Service
public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao = new StudentDao();

    @Value("${tag}")
    private String tag;

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTag() {
        return tag;
    }

    @Override
    public List<Student> queryAll() {
        return studentDao.queryAll();
    }
}
