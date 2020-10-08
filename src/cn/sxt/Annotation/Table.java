package cn.sxt.Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE) //指明这个注解应该属于哪种java成员，TYPE表示类或对象；METHOD表示方法；FIELD表示属性...
@Retention(RetentionPolicy.RUNTIME) //指明这个注解在哪一段生命周期被保留，RUNTIME表示运行时，可以被反射机制读取
public @interface Table {
    String[] value() default ""; //此注解的参数
}
