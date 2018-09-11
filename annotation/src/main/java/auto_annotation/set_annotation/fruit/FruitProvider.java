package auto_annotation.set_annotation.fruit;

import java.lang.annotation.*;

/*
 *@descripion:
 *水果供应者注解
 *@author 10068921(LgyTT)
 *@date 2018/8/21 17:27
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitProvider {
    /**
     *@description 供应商id
     *@param
     *@return
     *@anthor  10068921(lgyTT)
     *@date  2018/8/21
     *@other
     */
    public int id() default -1;
    /**
     *@description 供应商名称
     *@param
     *@return
     *@anthor  10068921(lgyTT)
     *@date  2018/8/21
     *@other
     */
    public String name() default "";
    /**
     *@description 供应商地址
     *@param
     *@return
     *@anthor  10068921(lgyTT)
     *@date  2018/8/21
     *@other
     */
    public String address() default "";


}
