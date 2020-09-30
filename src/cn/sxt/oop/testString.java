package cn.sxt.oop;

public class testString {
    public static void main(String args[]){
        String str1 = "abc"; // 指向常量池
        String str2 = "abc";// 指向常量池
        System.out.println("str1和str2指向的对象是否相等："+str1==str2); //指向的对象是否相等
        System.out.println("str1和str2的内容是否相等："+str1.equals(str2)); //内容是否相等

        System.out.println("str1中索引位置1的字母为："+str1.charAt(1));

        String str3 = new String ("def"); // 指向不同对象
        String str4 = new String ("def"); // 指向不同对象
        System.out.println("str3和str4指向的对象是否相等："+str3==str4);

        System.out.println("str2中a的索引位置为："+str2.indexOf('a'));

        System.out.println(str4.replace('e','#'));
    }
}
