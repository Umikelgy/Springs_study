package com.lgy.demo.dao;

import com.lgy.demo.entity.M_User;
import com.lgy.demo.entity.Tuser;

import java.util.List;

public interface TuserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(Tuser record);

    int insertSelective(Tuser record);

    Tuser selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(Tuser record);

    int updateByPrimaryKey(Tuser record);
    List<Tuser> selectUser();

    int insertN_msg(M_User m_user);
}