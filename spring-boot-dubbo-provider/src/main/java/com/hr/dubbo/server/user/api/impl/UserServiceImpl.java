package com.hr.dubbo.server.user.api.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.hr.dubbo.server.user.api.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

/**
 * @author 胡冉
 * @ClassName UserServiceImpl
 * @Date 2019/7/29 14:11
 * @Version 2.0
 */
@Service(version = "${user.service.version}")
public class UserServiceImpl implements UserService {
    @HystrixCommand(commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",
            value = "2000"), @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),})
    @Override
    public String sayHello(String message) {
       // System.out.println(System.currentTimeMillis());
        throw new RuntimeException("出现异常");
       // return "hello" + message;
    }
}
