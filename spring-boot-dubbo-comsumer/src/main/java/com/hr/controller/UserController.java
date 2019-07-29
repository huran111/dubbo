package com.hr.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.hr.dubbo.server.user.api.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 胡冉
 * @ClassName UserController
 * @Date 2019/7/29 14:52
 * @Version 2.0
 */
@RestController
public class UserController {
    @Reference(version = "${user.service.version}")
    private UserService userService;

    @HystrixCommand(fallbackMethod = "hiErro")
    @GetMapping(value = "hi")
    public String sayHello() {
        return userService.sayHello("huran");
    }

    public String hiErro() {
        return "HystrixCommand";
    }
}
