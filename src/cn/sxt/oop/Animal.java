package cn.sxt.oop;

//抽象类:为子类提供实现模板
public abstract class Animal {
    //抽象方法：1.没有实现 2.子类必须实现
    //严格规范子类的实现
    abstract public void shout();
    public void run(){
        System.out.println("run!");
    }

    public static void main(String args[]){
        Dog d = new Dog();
        d.shout();
        d.run();
    }
}

class Dog extends Animal{
    public void shout(){
        System.out.println("wow!");
    }
}

