package jaxb.shorp;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.math.BigDecimal;
import java.util.Date;

/*
 *@descripion:
 *
 *@author 10068921(LgyTT)
 *@date 2018/8/21 15:02
 */
@XmlType(name = "order",propOrder = {"shopName","orderNumber","price","amount","purDate","customer"})
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Order {
    @XmlElement
    private String shopName;

    @XmlAttribute
    private String orderNumber;

    @XmlElement
    private BigDecimal price;

    @XmlElement
    @XmlJavaTypeAdapter(value = DateAdapter.class)
    private Date purDate;

    @XmlElement
    private int amount;

    @XmlElement
    private Customer customer;

    public Order() {
    }

    public Order(String shopName, String orderNumber, BigDecimal price, Date purDate, int amount) {
        this.shopName = shopName;
        this.orderNumber = orderNumber;
        this.price = price;
        this.purDate = purDate;
        this.amount = amount;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getOrderNubmer() {
        return orderNumber;
    }

    public void setOrderNubmer(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getPurDate() {
        return purDate;
    }

    public void setPurDate(Date purDate) {
        this.purDate = purDate;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
