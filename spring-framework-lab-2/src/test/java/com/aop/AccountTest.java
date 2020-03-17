package com.aop;

import com.account.dao.AccountDao;
import com.account.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountTest {


    @Autowired
    private AccountService accountService;
    @Autowired
    private AccountDao accountDao;

    @Test
    public void test(){
        accountDao.income("as",233l);
    }

}
