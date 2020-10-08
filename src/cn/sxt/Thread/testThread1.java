package cn.sxt.Thread;

/**
 * 另一种创建多线程的方式：
 * 1.创建一个继承Runnable接口的类
 * 2.实现run()方法
 * 3.实例化这个类
 * 4.将这个类作为参数传入Thread类的构造器中，创建一个Thread对象
 * 5.调用start()方法
 * */


//1.创建一个继承Runnable接口的类
class mThread implements Runnable{
    //2.实现run()方法
    public void run(){
        for (int i = 0; i < 100; i++) {
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}
public class testThread1 {
    public static void main(String[] args) {
        //3.实例化这个类
        mThread m = new mThread();
        //4.将这个类作为参数传入Thread类的构造器中，创建一个Thread对象
        Thread t1 = new Thread(m);
        //5.调用start()方法
        t1.start();
    }
}
