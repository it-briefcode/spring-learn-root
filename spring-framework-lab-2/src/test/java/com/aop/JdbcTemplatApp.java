package com.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class JdbcTemplatApp {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //查询
    @Test
    public void query(){
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from dept");
        System.out.println(maps);
    }


    //更新
    @Test
    public void update(){
        int count = jdbcTemplate.update("update dept set DNAME=? where DEPTNO=10", "张三");
        System.out.println(count);
    }

}
