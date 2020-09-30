package cn.sxt.myCollection;

public class testArrayCopy {
    public static void main(String[] args) {
        String[] s = {"aa","bb","cc","dd","ee","ff"};
        String t[] = testCopy2(s,2);
    }

    public static void testCopy(){
        String[] str1 = {"aa","bb","cc","dd","ee"};
        String[] str2 = new String[10];
        System.arraycopy(str1,1,str2,0,3);
        for(int i = 0;i<str2.length;i++){
            System.out.println(str2[i]);
        }
    }

    //测试删除数组元素（本质上还是数组的拷贝）
    public static String[] testCopy2(String[] str1,int index){
        //删除第index个元素
        System.arraycopy(str1,index+1,str1,index, str1.length-index-1);
        for(int i = 0;i<str1.length;i++){
            System.out.println(str1[i]);
        }
        return str1;
    }
}
