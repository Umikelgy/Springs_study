package one;
/*
 *@author LgyTT@alog.com
 *@date 2018/8/7 15:36
 */

public class Employee {
    private String name;
    private int age;

    public Employee() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }
    private String testsue(Employee e){
        e.setName("jk");
        return e.getName();
    }
    public static void main(String[]args){
        Employee e=new Employee();
//        System.out.println(e.testsue(e));
//        String s=e.testsue(Employee::new);
    }

}
