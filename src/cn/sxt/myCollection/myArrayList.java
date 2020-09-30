package cn.sxt.myCollection;

import java.util.ArrayList;

/**
 * 模拟实现JDK中的ArrayList类
 * */
public class myArrayList {
    Object[] value;
    int size;

    //构造方法
    public myArrayList(){
        value = new Object[16];
    }
    public myArrayList(int size){
        value = new Object[size];
    }

    //添加对象
    public void add(Object obj){
        value[size] = obj;
        size++;

        //扩容：开新数组赋给value
        if (size>=value.length){
            int newCapacity = size*2+2;
            Object[] newList = new Object[newCapacity];
            for(int i = 0;i<size;i++){
                newList[i] = value[i];
            }

            value = newList;
        }
    }

    //取出对象
    public Object get(int index){
        if(index<0||index>value.length-1)//[0,size-1]
        {
            try{                   //手动抛出一个异常
                throw new Exception();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return value[index];
    }

    //查看对象索引
    public int indexOf(Object obj){
        if(obj==null){
            return -1;
        }else{
            for(int i = 0;i<size;i++){
                if(obj==value[i]){
                    return i;
                }
            }
            return -1;
        }
    }

    //
    public Object set(int index,Object obj){
        if(index<0||index>value.length-1){
            try{
                throw new Exception();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        Object old = value[index];
        value[index] = obj;
        return old;
    }

    public static void main(String[] args) {
        myArrayList list = new myArrayList(2);
        list.add("abc");
        list.add(new Human("cqm"));
        list.add(new Human("fanta")); //扩容成功
        Human h = (Human)list.get(2);
        list.set(4,"def");

        System.out.println(h.getName());
        System.out.println(list.indexOf("abc"));
        System.out.println("###################");
        for(int i = 0;i<list.value.length;i++){
            System.out.println(list.get(i));
        }
    }
}
