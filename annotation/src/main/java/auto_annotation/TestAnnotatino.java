package auto_annotation;

import auto_annotation.set_annotation.fruit.Apple;
import auto_annotation.set_annotation.fruit.FruitInfoUtil;

/*
 *@descripion:
 *
 *@author 10068921(LgyTT)
 *@date 2018/8/21 17:15
 */
public class TestAnnotatino {
    public static void main(String []args){

        FruitInfoUtil.getFruitInfo(Apple.class);
    }
}
