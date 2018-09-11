package com.lgy.demo.controller;


import com.lgy.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/*
 *@description:
 *
 *@author 10068921(LgyTT)
 *@date 2018/9/3 11:37
 */
//@RestController
@RequestMapping("/col")
public class OrderColController {
    @Autowired
    private OrderService orderService;
    @GetMapping
    public String findAll(){
        return null;
//        return JSON.toJSONString(orderService.findAll());
    }

}
