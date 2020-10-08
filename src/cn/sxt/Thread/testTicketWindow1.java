package cn.sxt.Thread;

/**
 * 同步机制解决线程安全问题
 *
 * 方法一：同步代码块
 * synchronized（同步监视器）{
 *     //需要被同步的代码
 * }
 * 说明：1.需要被同步的代码，指的是操作共享数据的代码
 *      2.同步监视器，俗称锁，任何对象都可以充当锁。但是多个线程必须公用一把锁！
 *
 * 方式二：同步方法
 * 如果操作共享数据的操作被完整的写在一个方法体中，则可以将这个方法声明为synchronized同步的
 * */

class window implements Runnable{
    private static int tickets = 100;
    Object obj = new Object();

    public void run(){
        //方式一
//        while(true){
//            synchronized (obj) {
//                if(tickets>0){
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println(Thread.currentThread().getName()+":"+tickets);
//                    tickets--;
//                }
//                else break;
//            }
//        }
        //方式二
        while(true){
            show();
            if(tickets==0)break;
        }
    }

    private synchronized void show(){//同步监视器是this对象
        if(tickets>0){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+":"+tickets);
            tickets--;
        }
    }
}
public class testTicketWindow1 {
    public static void main(String[] args) {
        window w = new window();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.start();
        t2.start();
        t3.start();
    }
}
