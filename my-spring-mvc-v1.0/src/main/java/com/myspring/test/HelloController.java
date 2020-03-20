package com.myspring.test;

import com.myspring.annotation.Autowired;
import com.myspring.annotation.Controller;
import com.myspring.annotation.RequestMapping;
import com.myspring.test.service.HelloService;

@Controller
public class HelloController {

    @Autowired("com.mvc.service")
    private HelloService helloService;

    @RequestMapping("/hello")
    public String hello(){
        helloService.query();
        return "hello";
    }


}
