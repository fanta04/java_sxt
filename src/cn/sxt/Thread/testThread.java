package cn.sxt.Thread;

/**
 * 多线程创建的方法：
 * 1.创建Thread类的子类
 * 2.重写Thread类的run()方法
 * 3.创建Thread类子类的对象
 * 4.调用子类对象start()方法
 * */

/**
* 测试：打印100以内的偶数
* */

//1.创建Thread类的子类
class myThread extends Thread{
    //2.重写Thread类的run()方法
    public void run(){
        for(int i = 0;i<100;i++){
            if(i%2 == 0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}
public class testThread {
    public static void main(String[] args) {
        //3.创建Thread类子类的对象
        myThread t1 = new myThread();
        //4.调用子类对象start()方法：①启动这个线程 ②调用这个线程对象的run方法
          //当线程执行完毕后不允许再次调用start方法，否则会报IllegalThreadStateException异常
        t1.start();

        myThread t2 = new myThread();
        t2.start();

        //main方法是主线程
        for (int i = 0; i < 100; i++) {
            if(i%2 == 0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}
