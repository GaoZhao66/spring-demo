package com.cmb.auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author gaozhao
 * @创建时间 2019/12/19
 * @描述
 **/
@RestController
@RequestMapping("/app/api")
public class AppController {

    @GetMapping("hello")
    public String hello(){
        return "hello,app";
    }

}
