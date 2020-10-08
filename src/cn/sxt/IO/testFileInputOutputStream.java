package cn.sxt.IO;

import java.io.*;

/**
 * 用字节流处理文本文件可能会出现乱码
 * 字符流可以处理（.txt,.java,.c,.cpp）等文件
 * 字节流可以处理（.jpg,.mp3,.mp4,.avi,.ppt,.doc）等文件
 * */
public class testFileInputOutputStream {
    public static void main(String[] args) {
        testFileInputOutputStream t = new testFileInputOutputStream();
//        t.test();
//        t.fileInputOutputTest();
        t.testCopy();
    }

    public void test()  {
        FileInputStream fis = null;
        try {
            //1.创建File对象
            File file = new File("hello.txt");
            //2.创建流对象
            fis = new FileInputStream(file);
            //3.读取文件
            byte[] buf = new byte[5];
            int len;
            while((len = fis.read(buf))!=-1){
                String str = new String(buf,0,len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭流
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    //实现图片的复制
    public void fileInputOutputTest() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File srcFile = new File("签名.png");
            File desFile = new File("签名1.png");

            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(desFile);

            byte[] buffer = new byte[5];
            int len;
            while((len = fis.read(buffer))!=-1){
                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //实现任意文件的复制
    public void copy(String srcPath,String dexPath){
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            File srcFile = new File(srcPath);
            File desFile = new File(dexPath);

            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(desFile);

            byte[] buffer = new byte[1024];
            int len;
            while((len = fis.read(buffer))!=-1){
                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void testCopy(){
        String srcPath = "C:\\Users\\陈绮萌\\Desktop\\桌面.jpg";
        String dexpath = "C:\\Users\\陈绮萌\\Desktop\\桌面01.jpg";

        long st = System.currentTimeMillis();
        copy(srcPath,dexpath);
        long ed = System.currentTimeMillis();
        System.out.println(ed-st); //57
    }
}
