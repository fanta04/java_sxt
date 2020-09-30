package cn.sxt.collection;

public class MyMap01 {
    Map[] m = new Map[90];
    int size;

    public void put(Object key,Object value){
        Map mm = new Map(key,value);
        m[size++] = mm;
    }

    public Object get(Object key){
        for(int i = 0 ;i<size;i++){
            if(m[i].key.equals(key)){
                return m[i].value;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        MyMap01 m = new MyMap01();
        m.put("cqm","fanta");
        System.out.println(m.get("cqm"));
    }
}

class Map{
    Object key;
    Object value;

    public Map(Object key, Object value) {
        this.key = key;
        this.value = value;
    }
}