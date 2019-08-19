package com.demo.service;

/**
 * @author jzx
 * @date 2019/06/03 11:26
 * @Description:
 */
public class GreetingServiceImpl implements GreetingService {
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
