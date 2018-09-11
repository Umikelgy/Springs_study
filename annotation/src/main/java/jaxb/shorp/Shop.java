package jaxb.shorp;

import javax.xml.bind.annotation.*;
import java.util.Set;

/*
 *@descripion:
 *
 *@author 10068921(LgyTT)
 *@date 2018/8/21 14:49
 */
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "shop",propOrder = {"name","number","describer","address","orders"})
@XmlRootElement(name = "CHMart")
public class Shop {
    @XmlAttribute
    private String name;
    @XmlElement
    private String number;
    @XmlElement
    private String describer;
    @XmlElement
    private Address address;
    @XmlElementWrapper(name = "orders")
    @XmlElement(name = "order")
    private Set<Order> orders;

    public Shop() {
    }

    public Shop(String name, String number, String describer, Address address) {
        this.name = name;
        this.number = number;
        this.describer = describer;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDescriber() {
        return describer;
    }

    public void setDescriber(String describer) {
        this.describer = describer;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}
