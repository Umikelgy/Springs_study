package com.lgy.demo.service;

import com.lgy.demo.entity.M_User;
import com.lgy.demo.entity.Tuser;

import java.util.List;

/*
 *@author 10068921(LgyTT@alog.com)
 *@date 2018/8/14 16:09
 *@description:
    访问数据库的接口
 */
public interface UserService {
    int addUser(Tuser tuser);
    List<Tuser> findAllUser(int pageNum,int pageSize);
    int insert_Test(M_User m_user);
}
