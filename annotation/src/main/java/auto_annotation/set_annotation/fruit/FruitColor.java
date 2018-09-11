package auto_annotation.set_annotation.fruit;

import java.lang.annotation.*;

/*
 *@descripion:
 *水果颜色注解
 *@author 10068921(LgyTT)
 *@date 2018/8/21 17:20
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitColor {
    /**
     *@description 颜色枚举
     *@param
     *@return
     *@anthor  10068921(lgyTT)
     *@date  2018/8/21
     *@other
     */
    public enum Color{BULE,RED,GREEN}
    /**
     *@description 颜色属性
     *@param
     *@return
     *@anthor  10068921(lgyTT)
     *@date  2018/8/21
     *@other
     */
    Color fruitColor( ) default Color.GREEN;
}
