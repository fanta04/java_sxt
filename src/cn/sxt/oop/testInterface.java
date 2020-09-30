package cn.sxt.oop;


//测试接口
//接口的作用：打一个代码草稿，严格规范子类的实现
//子类需要实现接口中的所有方法
public class testInterface {
    public static void main(String args[]){
        //只能new实现接口的子类
        Volant v = new Angel();
        v.fly();
        Good g = new Goodman();
        g.helpOther();
    }
}


interface Volant{
    int FLY_HEIGHT = 100;
    void fly();
}

interface Good{
    void helpOther();
}

//子类可以继承多个接口
class Angel implements Volant,Good{
    public void fly(){
        System.out.println("angel fly"+FLY_HEIGHT);
    }
    public void helpOther(){
        System.out.println("helpOthers");
    }
}
class Goodman implements Good{
    public void helpOther(){
        System.out.println("Good Man Helps Others");
    }
}

/**
 * 接口可以实现多继承
 * */
interface A{
    void aaa();
}

interface B{
    void aaa();
}

interface C extends A,B{
    void aaa();
    void bbb();
    void ccc();
}

class myClass implements C{
    public void aaa(){

    }
    public void bbb(){

    }
    public void ccc(){

    }
}
