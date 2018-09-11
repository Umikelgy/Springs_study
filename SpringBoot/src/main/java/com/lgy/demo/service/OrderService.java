package com.lgy.demo.service;

import com.lgy.demo.api.ColRepository;
import com.lgy.demo.api.IPublicDao;
import com.lgy.demo.entity.OrderCol;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/*
 *@description:
 *
 *@author 10068921(LgyTT)
 *@date 2018/9/3 11:30
 */
//@Service
public class OrderService {
    @Autowired
    private ColRepository colRepository;
    @Autowired
    private IPublicDao<OrderCol> orderColIPublicDao;
    public void save(OrderCol orderCol){
      //  colRepository.save(orderCol);
    }
//    public OrderCol findOne(String id){
//        return colRepository.findOne(id);
//    }
//    public List<OrderCol> findAll(){
//        return colRepository.findAll();
//    }
//
//
//    public void deleteById(String id) {
//        colRepository.delete(id);
//    }
}
