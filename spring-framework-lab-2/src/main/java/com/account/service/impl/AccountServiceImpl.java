package com.account.service.impl;

import com.account.dao.AccountDao;
import com.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    /**
     * 收入
     *
     * @param name
     * @param balance
     */
    @Override
    public void income(String name, Long balance) {

    }

    /**
     * 支出
     *
     * @param name
     * @param balance
     */
    @Override
    public void expenditrue(String name, Long balance) {

    }

    /**
     * 查询
     *
     * @param name
     */
    @Override
    public void selectAcount(String name) {
        accountDao.selectAcount(name);
    }
}
