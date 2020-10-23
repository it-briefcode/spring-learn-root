package com.account.dao.impl;

import com.account.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Component
public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {

    @Resource(name = "dataSource")
    public void MyDataSource(DataSource dataSource){
        super.setDataSource(dataSource);
    }

    @Override
    public void income(String name, Long balance) {
        getJdbcTemplate().update("update user set id = id+100 where id=101;");
    }

    @Override
    public void expenditrue(String name, Long balance) {

    }

    @Override
    public void selectAcount(String name) {
        List<Map<String, Object>> maps = getJdbcTemplate().queryForList("select * from dept");
        System.out.println(maps);
    }
}
