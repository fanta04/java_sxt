package cn.sxt.IO;

import java.io.*;

/**
 * 缓冲流比文件流更加节省效率
 * */
public class BufferedTest {
    public static void main(String[] args) {
        BufferedTest b = new BufferedTest();
//        b.test01();
        b.test02();
    }

    //用缓冲流实现文件的复制
    public void test01(){
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //1.造文件
            File srcFile = new File("签名.png");
            File dexFile = new File("签名2.png");
            //2.造流
            //2.1造文件流
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(dexFile);
            //2.2造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            //3.读取文件，写入文件
            byte[] buf = new byte[5];
            int len;
            while((len = bis.read(buf))!=-1){
                bos.write(buf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭流
            //先关外面的流，再关里面的流（里面的流可以不用关）
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //使用BufferedReader和BufferedWriter实现文本文件的复制
    public void test02(){
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            //造文件流和缓冲流
            br = new BufferedReader(new FileReader(new File("hello.txt")));
            bw = new BufferedWriter(new FileWriter(new File("hello3.txt")));
            //读取文件，写入文件
            //方式一：使用char[]数组
//            char[] cbuf = new char[5];
//            int len;
//            while((len = br.read(cbuf))!=-1){
//                bw.write(cbuf,0,len);
//            }
            //方式二：使用readLine()
            String data;
            while((data = br.readLine())!=null){
                bw.write(data+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流
            if(bw!=null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(br!=null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
