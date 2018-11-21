package auto_annotation.set_annotation.fruit.fruitTest;

import auto_annotation.model.Fruit;

import java.lang.reflect.Field;

/*
 *@description:
 *
 *@author 10068921(LgyTT)
 *@date 2018/11/21 10:48
 */
public class Anno_Util {
    public static Fruit FruitInit(Class<?> clazz){
        Field[] fields = clazz.getDeclaredFields();
        Fruit fruit=new Fruit();
        for(Field field:fields){
            if(field.isAnnotationPresent(AnnoApple.class)){
                fruit.init();
                return fruit;
            }
        }
        return fruit;
    }
}
