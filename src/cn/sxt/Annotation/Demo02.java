package cn.sxt.Annotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 利用反射
 * */
public class Demo02 {

    public static void main(String[] args) {
        String path = "cn.sxt.Annotation.sxtStudent";
        try {

            Class<sxtStudent> clazz = (Class<sxtStudent>) Class.forName(path);

            //利用反射API调用构造方法，创建对象
            Constructor<sxtStudent> c = clazz.getDeclaredConstructor(String.class,int.class,int.class);
            sxtStudent stu01 = c.newInstance("cqm",22,101);
            System.out.println(stu01.getSname());

            //利用反射API调用普通方法
            sxtStudent stu02 = clazz.newInstance(); //调用无参构造器
            Method method = clazz.getDeclaredMethod("setSname", String.class);
            method.invoke(stu02,"fanta");
            //以上三句完成的功能等于： stu02.setSname("fanta");

            System.out.println(stu02.getSname());


            //利用反射API操作属性
            sxtStudent stu03 = clazz.newInstance();
            Field f = clazz.getDeclaredField("sname");
            f.setAccessible(true); //解开private封印,可以提高反射的效率
            f.set(stu03,"fanta04");
            //以上四句完成的功能等于： stu03.setSname("fanta04");
            System.out.println(stu03.getSname());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
