package com.myspring.test.service.impl;

import com.myspring.annotation.Service;
import com.myspring.test.service.HelloService;

@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public void query() {
        System.out.println("query......");
    }
}
