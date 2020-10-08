package cn.sxt.IO;


import java.io.*;

/**
 * 流的体系结构
 * 抽象基类                 节点流（文件流）                    缓冲流（处理流的一种）
 * (字节)InputStream              FileInputStream                 BufferedInputStream
 * (字节)OutputStream             FileOutputStream                BufferedOutputStream
 * (字符)Reader                   FileReader                      BufferedReader
 * (字符)Writer                   FileWriter                      BufferedWriter
 *
 * */

//要求：将hello。txt从磁盘读入到控制台输出
/*说明：1.为了能够将流关闭，需要使用try-catch-finally操作
        2.读入的时候一定要注意文件必须存在，否则会报FileNotFoundException异常
 */

public class testFileReaderWriter {

    public static void main(String[] args) throws IOException {
        testFileReaderWriter t = new testFileReaderWriter();
//        t.test02();
        t.testFileReaderFileWriter();
    }

//    public void testFileReader(){
//        FileReader fr = null;
//        try{
//            //1.实例化文件对象，指明要读取的文件
//            File f = new File("hello.txt");//在当前工作空间
//
//            //2.实例化具体的流
//            fr = new FileReader(f);
//
//            //3.read()每次读取一个字符，达到文件末尾返回-1
//            int data = fr.read();
//            while(data!=-1){
//                System.out.println((char)data);
//                data = fr.read();
//            }
//        }catch(Exception e){
//            e.printStackTrace();
//        }finally{
//            //4.关闭流
//            if(fr!=null){
//                try{
//                    fr.close();
//                }catch(Exception e){
//                    e.printStackTrace();
//                }
//            }
//        }
//    }

    //read()方法的重载：read(char[] cbuf)
    public void testFileReader02(){
        FileReader fr = null;
        try {
            //1.实例化File对象
            File file = new File("hello.txt");
            //2.实例化FileReader对象
            fr = new FileReader(file);
            //3.数据读入
            char[] cbuf = new char[5];
            int len;
            while((len = fr.read(cbuf))!=-1){
                for(int i = 0;i<len;i++){
                    System.out.print(cbuf[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(fr!=null){
                try{
                    //4.关闭流对象
                    fr.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    //输出流
    public void testFileWriter() throws IOException {
        //1.创建File类对象
        File file = new File("hello1.txt");
        //2.创建FileWriter流对象
        FileWriter fw = new FileWriter(file);
        //3.写入数据
        fw.write("hello\n");
        fw.write("world!");
        //4.关闭流
        fw.close();
    }

    /**
     * 从hello.txt中读取数据写入到hello2.txt中
     * */
    public void testFileReaderFileWriter() {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            //1.实例化File对象
            File srcFile = new File("hello.txt");
            File newFile = new File("hello2.txt");
            //2.实例化FileReader对象和FileWrtier对象
            fr = new FileReader(srcFile);
            fw = new FileWriter(newFile);
            //3.读出数据and写入数据
            char[] cbuf = new char[3];
            int len;
            while((len = fr.read(cbuf))!=-1){
                fw.write(cbuf,0,len); // 从cbuf的第0个读到第len个
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //4.关闭流
            try {
                if(fw!=null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fr!=null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
