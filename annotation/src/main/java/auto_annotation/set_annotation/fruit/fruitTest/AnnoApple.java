package auto_annotation.set_annotation.fruit.fruitTest;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/*
 *@description:
 *
 *@author 10068921(LgyTT)
 *@date 2018/11/21 10:45
 */
@Target(FIELD)
@Retention(RUNTIME)
@Documented
public @interface AnnoApple {

}
