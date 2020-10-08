package cn.sxt.Annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 利用反射获取类的信息
 * */
public class Demo01 {
    public static void main(String[] args) {
        String path = "cn.sxt.Annotation.sxtStudent";
        try {

            Class clazz = Class.forName(path);

            //获取类的名字
            System.out.println(clazz.getName()); // 获取包名+类名：cn.sxt.Annotation.sxtStudent
            System.out.println(clazz.getSimpleName()); // 获取类名：sxtStudent

            //获取属性信息
            //Field[] fields = clazz.getFields(); //获取public的属性
            Field[] fields = clazz.getDeclaredFields(); // 获取所有属性
            for(Field f:fields){
                System.out.println("属性：" + f);
            }

            Field f = clazz.getDeclaredField("sname"); // 获取指定的属性
            System.out.println("指定属性："+f);

            //获取方法信息
            Method[] methods = clazz.getDeclaredMethods(); //获得所有方法
            for(Method m:methods){
                System.out.println("方法：" + m);
            }

            Method m01 = clazz.getDeclaredMethod("getSage"); //获取无参的方法
            Method m02 = clazz.getDeclaredMethod("setSage", int.class); //获取有参的方法，后面还要加上该方法参数的类型

            Method m03 = clazz.getDeclaredMethod("setSid", int.class); //获取重载的方法，可以根据后面加上不同类型来分辨
            Method m04 = clazz.getDeclaredMethod("setSid", int.class,String.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
