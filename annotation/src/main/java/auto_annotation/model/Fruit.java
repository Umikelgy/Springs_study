package auto_annotation.model;

/*
 *@description:
 *
 *@author 10068921(LgyTT)
 *@date 2018/11/21 10:41
 */
public class Fruit {
    private String name;
    private String color;
    private int pice;
    private String address;

    public void init(){
        name="Apple";
        color="RED";
        pice=10;
        address="HDU";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPice() {
        return pice;
    }

    public void setPice(int pice) {
        this.pice = pice;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
