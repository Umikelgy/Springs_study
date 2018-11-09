package com.lgy.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

/*
 *@author 10068921(LgyTT@alog.com)
 *@date 2018/8/13 16:08
 *@description:
 */
@RestController
@SpringBootApplication
@MapperScan("com.lgy.springboot.dao")
public class DemoApplication {
    public static void main(String []args){
        SpringApplication.run(DemoApplication.class,args);

    }
}
