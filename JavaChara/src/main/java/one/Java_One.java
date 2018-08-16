package one;/*
 *@author LgyTT@alog.com
 *@date 2018/8/6 17:07
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.function.Supplier;

public class Java_One {
    String b;
    public void happy(double money, String con) {
        System.out.println(money+con);
    }
    public List<Integer> getNumList(int num, Supplier<Integer> sup) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Integer n = sup.get();
            list.add(n);
        }
        return list;
    }
    /*Lambda表达式*/
    private void LambdaT1(){
        String[] atp = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka",
                "David Ferrer","Roger Federer",
                "Andy Murray","Tomas Berdych",
                "Juan Martin Del Potro"};
        List<String> players =  Arrays.asList(atp);
// 使用 lambda 表达式以及函数操作(functional operation)
//        players.forEach((player)  -> System.out.println(player+";"));
// 在 Java 8 中使用双冒号操作符(double colon operator)
        players.forEach(System.out::println);
    }
    private void ThreadT(Thread thread){
        thread.start();
    }
    private String TTLa(){
        return b;
    }
    //TTLa1((int a,String b)->b+a);
    private void LambdaT2()//匿名内部类的表达
    {
        Java_One one=new Java_One();
        one.ThreadT(new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("CCT");
            }
        }){

        });
        one.ThreadT(new Thread(() -> {System.out.println("HelloWord+Lambda");}));
    }
    private void tESTt(InClass i){
        i.doSin();
    }
    private String mlj(Employee e){
        e.setAge(22);
        e.setName("jlll");
        return e.getName();
    }
    public static void main(String[]args){
        Java_One one=new Java_One();
       // one.LambdaT2();
       List<Integer> list=one.getNumList(10,()->(int)(Math.random()*100));
     // list.forEach(System.out::print);
      Employee empl=new Employee("lgy",22);
      //  Supplier<String> bc=one::TTLa;
       String bcc=one.mlj(new Employee(){
           String name1;
           @Override
           public String getName() {
               return name1;
           }

           @Override
           public void setName(String name) {
               name1=name;
           }
       });
       one.tESTt(new InClass() {
           @Override
           public void doSin() {
               System.out.println("jjlk");
           }
       });
       one.tESTt(()->System.out.println("jlkd"));

       //String b=one.mlj(()->return "ljll");
       //System.out.println(bcc);

    }
}
