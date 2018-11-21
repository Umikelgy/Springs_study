package auto_annotation.set_annotation.fruit.fruitTest;

import auto_annotation.model.Fruit;

/*
 *@description:
 *
 *@author 10068921(LgyTT)
 *@date 2018/11/21 10:51
 */
public class FruitInitMain {
    @AnnoApple
    private static Fruit fruit;
    public static void main(String[]args){
        fruit=Anno_Util.FruitInit(FruitInitMain.class);
        System.out.println(fruit.getName());
    }
}
