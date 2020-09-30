package cn.sxt.StringBuilder;
/**
 * 测试StringBuilder（线程不安全，效率高）和StringBuffer（线程安全，效率低）
 * */
public class test01 {
    public static void main(String args[]){
        StringBuilder str1 = new StringBuilder(); //初始化数组长度为16
        StringBuilder str2 = new StringBuilder(32); //初始化数组长度为32
        StringBuilder str3 = new StringBuilder("123");
        str3.append("abc");

        /**
         * StringBuilder扩容：原数组长度*2+2-->新数组-->赋给原数组
         * **/
        StringBuilder s = new StringBuilder();
        for(int i  = 0;i<100;i++){
            s.append(i);
        }
        System.out.println(s);
    }
}
