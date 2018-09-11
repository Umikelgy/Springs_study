package com.lgy.demo.api;

import com.lgy.demo.entity.OrderCol;

import java.util.List;

/*
 *@description:
 *
 *@author 10068921(LgyTT)
 *@date 2018/9/3 11:25
 */
public interface IPublicDao<T> {
    public List<OrderCol> listOrder();
}
