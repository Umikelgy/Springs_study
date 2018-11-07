package com.lgy.demo.controller;

import com.lgy.demo.entity.M_User;
import com.lgy.demo.entity.Tuser;
import com.lgy.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/*
 *@author 10068921(LgyTT@alog.com)
 *@date 2018/8/13 16:07
 *@description:

 */
@RestController
@RequestMapping(value = "/user")
public class Mycontroller {
    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/add/{userId}",produces = {"application/json;charset=UTF-8"})
    public int addUser(Tuser user, @PathVariable("userId")Integer userId) {
        Tuser tuser=new Tuser(userId,"lgy","1234","123422");
        System.out.println(user.getUserName());
        if(user==null)
        return userService.addUser(tuser);
        else{
            System.out.println("tuserId="+tuser.getUserId());
            return 0;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/all/{pageNum}/{pageSize}",produces = {"application/json;charset=UTF-8"})
    public Object findAllUser(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize){
        if(userService.findAllUser(pageNum,pageSize)==null)
            return "the select sql is failed!!";
        else
        return userService.findAllUser(pageNum,pageSize);
    }
    @ResponseBody
    @RequestMapping("/addmsg")
    public int AddMsg(){
        M_User user=new M_User(21312,"lgy4","12321","12312334");
        return userService.insert_Test(user);
    //System.out.println("port=");
    }
}
