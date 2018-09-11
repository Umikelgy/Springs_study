package auto_annotation.reflect;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/*
 *@descripion:
 *
 *@author 10068921(LgyTT)
 *@date 2018/8/22 15:21
 */
public class FieldTest {
    @Test
    public void testF() throws Exception {
        Class<?> cls=Class.forName("auto_annotation.reflect.FieldDemo");
        Object obj=cls.newInstance();

        Field field=cls.getField("num1");
//      获取修饰符
        System.out.println("修饰符"+ Modifier.toString(field.getModifiers()));
//       获取类型
        System.out.println("类型："+field.getType());
//       获取属性值
        System.out.println("属性值："+field.get(obj));
//        修改属性值
        field.set(obj,21);
        System.out.println("修改属性值后："+field.get(obj));

    }

}
