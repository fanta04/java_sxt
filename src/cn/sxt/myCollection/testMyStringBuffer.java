package cn.sxt.myCollection;



public class testMyStringBuffer implements IStringBuffer{
    String[] value;
    int size;

    //构造方法
    public testMyStringBuffer(){
        value = new String[16];
    }
    public testMyStringBuffer(int size){
        value = new String[size];
    }

    //检查位置是否合法
    void checkRange(int pos){
        if(pos<0||pos>value.length-1){
            try{
                throw new Exception();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    //扩容
    void growCapacity(){
        if(value.length<size){
//            int newCapacity = size+1;
//            String[] newString = new String[newCapacity];
//            for(int i = 0;i<value.length;i++){
//                newString[i] = value[i];
//            }
            String[] newString = new String[size*2+1];
            System.arraycopy(value,0,newString,0,value.length);
            value = newString;
        }
    }
    //追加字符串
    public void append(String str){
        insert(size,str);
    };

    //追加字符
    public void append(char c){
        insert(size,String.valueOf(c));
    };

    //指定位置插入字符
    public void insert(int pos,char b){
        //checkRange(pos);
        size++;
        growCapacity();
        for(int i = value.length-1;i>pos;i--){
            value[i] = value[i-1];
        }
        value[pos] = String.valueOf(b);

    };

    //指定位置插入字符串
    public void insert(int pos,String b){
        //checkRange(pos);
        size++;
        growCapacity();
        for(int i = value.length-1;i>pos;i--){
            value[i] = value[i-1];
        }
        value[pos] = b;
    };

    //从开始位置删除剩下的
    public void delete(int start){
        checkRange(start);
        delete(start,size-1);
    };

    //从开始位置删除结束位置-1
    public void delete(int start,int end){
        checkRange(start);
        checkRange(end);
        int gap = end-start+1;
        for(int i = end+1;i<value.length;i++){
            value[i-gap] = value[i];
        }
        size -= gap;
    };

    //反转
    public void reverse(){
        String t;
        for(int i = 0;i<value.length/2;i++){
            t = value[i];
            value[i] = value[size-i-1];
            value[size-i-1] = t;
        }
    };

    //返回长度
    public int length(){
        return value.length;
    };


    public static void main(String[] args) {
        testMyStringBuffer t = new testMyStringBuffer(2);
        t.append("abc");
        t.append("def");
        t.append("ghi");
        t.append("jkl");
        t.append("mno");
        t.append("pqr");
        t.append("stu");
        t.append("vwx");
        t.append("yz");
        System.out.println(t.size);
        t.delete(0);
        System.out.println(t.size);
        t.insert(0,"hey guys!");
        for(int i =0;i<t.size;i++){
            System.out.println(t.value[i]);
        }
    }
}
