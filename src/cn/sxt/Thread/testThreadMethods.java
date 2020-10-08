package cn.sxt.Thread;

/**
 * Thread的常用方法
 * 1.currentThread():静态方法，返回执行当前代码的线程
 * 2.run():线程完成的主要任务
 * 3.start():启动线程；调用run()方法
 * 4.setName():给当前线程起名
 * 5.getName():返回当前线程名字
 * 6.yield():释放CPU执行权
 * 7.join():如果在线程a中调用线程b的join()方法，则等到线程b全部执行完毕后再接着执行线程a
 * 8.sleep(long millitime):让当前线程"睡眠"指定毫秒，在“睡眠”状态下，线程处于阻塞态
 * 9.isAlive():判断当前线程是否存活
 * */


class testMethods extends Thread{
    public void run(){
        for(int i = 0;i <100;i++){
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName()+":"+i);
                //睡眠
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
public class testThreadMethods {
    public static void main(String[] args) {
        testMethods t1 = new testMethods();
        t1.start();

        testMethods t2 = new testMethods();
        t2.start();

        for(int i = 0;i<100;i++){
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
            if(i % 20 == 0){
                try {
                    t2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}
