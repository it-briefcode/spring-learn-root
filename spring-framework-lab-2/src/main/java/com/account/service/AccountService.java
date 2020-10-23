package com.account.service;

public interface AccountService {

    /**
     * 收入
     * @param name
     * @param balance
     */
    public void income(String name,Long balance);

    /**
     * 支出
     * @param name
     * @param balance
     */
    public void expenditrue(String name,Long balance);

    /**
     * 查询
     * @param name
     */
    public void selectAcount(String name);
}
