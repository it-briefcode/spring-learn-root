package com.aop;

import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {



    @Override
    public void test(){
        System.out.println("方法执行了···");
    }


}
