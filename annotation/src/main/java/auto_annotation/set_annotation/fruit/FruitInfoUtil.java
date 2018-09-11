package auto_annotation.set_annotation.fruit;

/*
 *@descripion:
 *
 *@author 10068921(LgyTT)
 *@date 2018/8/21 17:36
 */
import java.lang.reflect.Field;

/**
 * 注解处理器
 */
public class FruitInfoUtil {
    public static void getFruitInfo(Class<?> clazz){

        String strFruitName=" 水果名称：";
        String strFruitColor=" 水果颜色：";
        String strFruitProvicer="供应商信息：";
/*
* Field是Java的反射类，获取类的信息
* 获取对象的方法：
*        - getFields(): 获取类中public类型的属性
*　　　  - getField(String name)： 获取类特定的方法，name参数指定了属性的名称
*　　　　- getDeclaredFields(): 获取类中所有的属性(public、protected、default、private),但不包括继承的属性。
*　　　　- getDeclaredField(String name): 获取类特定的方法，name参数指定了属性的名称
* */
        Field[] fields = clazz.getDeclaredFields();

        for(Field field :fields){
            if(field.isAnnotationPresent(FruitName.class)){
                FruitName fruitName = (FruitName) field.getAnnotation(FruitName.class);
                strFruitName=strFruitName+fruitName.value();
                System.out.println(strFruitName);
            }
            else if(field.isAnnotationPresent(FruitColor.class)){
                FruitColor fruitColor= (FruitColor) field.getAnnotation(FruitColor.class);
                strFruitColor=strFruitColor+fruitColor.fruitColor().toString();
                System.out.println(strFruitColor);
            }
            else if(field.isAnnotationPresent(FruitProvider.class)){
                FruitProvider fruitProvider= (FruitProvider) field.getAnnotation(FruitProvider.class);
                strFruitProvicer=" 供应商编号："+fruitProvider.id()+" 供应商名称："+fruitProvider.name()+" 供应商地址："+fruitProvider.address();
                System.out.println(strFruitProvicer);
            }
        }
    }
}