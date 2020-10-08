package cn.sxt.Thread;

/**
 * 需求：三个窗口卖100张票
 * */

class Window extends Thread{
    private static int num = 100;
    public void run(){
        while(num>0){
            System.out.println(Thread.currentThread().getName()+":"+num);
            num--;
        }
    }
    Window(String str){
        super(str);
    }
}

public class testTicketWindow {
    public static void main(String[] args) {
        Window w1 = new Window("window1");
        Window w2 = new Window("window2");
        Window w3 = new Window("window3");

        w1.start();
        w2.start();
        w3.start();
    }
}
