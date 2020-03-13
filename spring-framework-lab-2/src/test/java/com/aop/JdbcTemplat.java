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
public class JdbcTemplat {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Test
    public void jdbc(){
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from dept");
        System.out.println(maps);
    }
}
