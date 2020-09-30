package cn.sxt.File;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class testFile {
    public static void main(String[] args) throws IOException {
        //创建一个文件
        File f = new File("d:/a.txt");
        System.out.println(f);
        //查看用户目录
        System.out.println(System.getProperty("user.dir"));

        //在工作空间的目录下创建文件
        File f2 = new File("bb.txt");
        System.out.println("File是否存在"+f2.exists());
        System.out.println("File是否是一个目录"+f2.isDirectory());
        System.out.println("File是否是一个文件"+f2.isFile());
        System.out.println("File是否存在"+new Date(f2.lastModified()));
        System.out.println("File的绝对路径"+f2.getAbsolutePath());

//        //创建目录
//        File f3 = new File("e:/电影/华语/大陆");
//        //f3.mkdir(); //mkdir()方法：只要路径中有一个目录不存在就创建失败
//        f3.mkdirs(); //mkdirs()方法：创建路径中所有的目录
//        System.out.println(f3.isDirectory());

        File f4 = new File("F:/Chrome下载");
        printFileTree(f4,0);

    }
    //递归打印文件树结构
    static void printFileTree(File f,int level){
        for(int i = 0;i<level;i++){
            System.out.print("--");
        }
        System.out.println(f.getName());
        if(f.isDirectory()){
            File[] files = f.listFiles();
            for(int i = 0;i<files.length;i++){
                printFileTree(files[i],level+1);
            }
        }
    }
}
