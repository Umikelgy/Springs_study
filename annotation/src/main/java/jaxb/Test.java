package jaxb;

import jaxb.shorp.Address;
import jaxb.shorp.Customer;
import jaxb.shorp.Order;
import jaxb.shorp.Shop;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/*
 *@descripion:
 *测试生成xml的测试类
 *@author 10068921(LgyTT)
 *@date 2018/8/21 15:45
 */
public class Test {
    public static void main(String[] args) throws JAXBException, IOException{
        Set<Order> orders = new HashSet<Order>();

        Address address1 = new Address("China", "ShangHai", "ShangHai", "Huang", "200000");
        Customer customer1 = new Customer("Jim", "male", "13699990000", address1);
        Order order1=new Order("Mart","LH59900",new BigDecimal(60),new Date(),1);
        order1.setCustomer(customer1);

        Address address2 = new Address("China", "JiangSu", "NanJing", "ZhongYangLu", "210000");
        Customer customer2 = new Customer("David", "male", "13699991000", address2);
        Order order2 = new Order("Mart", "LH59800", new BigDecimal(80), new Date(), 1);
        order2.setCustomer(customer2);

        orders.add(order1);
        orders.add(order2);

        Address address3 = new Address("China", "ZheJiang", "HangZhou", "XiHuRoad", "310000");
        Shop shop = new Shop("CHMart", "100000", "EveryThing",address3);
        shop.setOrders(orders);


        FileWriter writer = null;
        JAXBContext context = JAXBContext.newInstance(Shop.class);
        try {
            Marshaller marshal = context.createMarshaller();
            marshal.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshal.marshal(shop, System.out);

            writer = new FileWriter("shop.xml");
            marshal.marshal(shop, writer);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Unmarshaller unmarshal = context.createUnmarshaller();
        FileReader reader = new FileReader("shop.xml") ;
        Shop shop1 = (Shop)unmarshal.unmarshal(reader);

        Set<Order> orders1 = shop1.getOrders();
        for(Order order : orders1){
            System.out.println("***************************");
            System.out.println(order.getOrderNubmer());
            System.out.println(order.getCustomer().getName());
            System.out.println("***************************");
        }
    }

}
