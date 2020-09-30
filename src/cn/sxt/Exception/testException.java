package cn.sxt.Exception;

import sun.util.locale.provider.JRELocaleProviderAdapter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class testException {
    public static void main(String[] args) {
        FileReader reader = null;
        try {
            reader = new FileReader("e:/sxt/bb.txt");
            char c = (char)reader.read();
            System.out.println(c);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            System.out.println("无论如何我都要被执行！");
            try {
                if(reader!=null){
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
