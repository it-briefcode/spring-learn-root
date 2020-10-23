package com.account.bean;

import lombok.Data;

@Data
public class Account {

    private Integer id;

    private String name;

    private String transactionTime;

    private Long balance;
}
