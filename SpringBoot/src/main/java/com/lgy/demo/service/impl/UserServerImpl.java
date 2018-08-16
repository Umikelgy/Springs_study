package com.lgy.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.lgy.demo.dao.TuserMapper;
import com.lgy.demo.entity.M_User;
import com.lgy.demo.entity.Tuser;
import com.lgy.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 *@author 10068921(LgyTT@alog.com)
 *@date 2018/8/14 16:14
 *@description:
    实现userServer接口
 */
@Service(value = "userService")
public class UserServerImpl implements UserService {
    @Autowired
    private TuserMapper tuserMapper;


    @Override
    public int addUser(Tuser tuser) {
        return tuserMapper.insert(tuser);
    }

    @Override
    public List<Tuser> findAllUser(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return tuserMapper.selectUser();
    }

    @Override
    public int insert_Test(M_User m_user) {
        return tuserMapper.insertN_msg(m_user);
    }
}
