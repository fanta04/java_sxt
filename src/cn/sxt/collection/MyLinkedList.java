package cn.sxt.collection;

import java.util.List;

public class MyLinkedList{
    private Node first;
    private Node last;
    private int size;

    //直接在链表尾部插入
    public void add(Object o){
        if(first==null){
            Node node = new Node();
            node.setObj(o);
            node.setNext(null);
            node.setPrivious(null);

            first = node;
            last = node;
        }else{
            Node node = new Node();
            node.setObj(o);
            node.setPrivious(last);
            node.setNext(null);
            last.setNext(node);

            last = node;
        }

        size++;
    }

    //检查边界，抛出异常
    public void rangeCheck(int index){
        if(index<0||index>size){
            try {
                throw new Exception();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    //找结点
    public Node node(int index){
        Node temp = null;
        if(first!=null){
            temp = first;
            for(int i = 0;i<index;i++){
                temp = temp.next;
            }
        }
        return temp;
    }

    //取出结点
    public Object get(int index){
        rangeCheck(index);
        Node temp = node(index);
        return temp.obj;
    }

    //移除结点
    public void remove(int index){
        rangeCheck(index);

        Node temp = node(index);

        if(temp!=null){
            Node pre = temp.getPrivious();
            Node nex = temp.getNext();
            pre.setNext(nex);
            nex.setPrivious(pre);
        }else{
            last = temp;
            Node pre = temp.getPrivious();
            pre.setNext(null);
        }

        size--;
    }

    public void insert(int index,Object o){
        rangeCheck(index);
        Node temp = node(index);

        Node n = new Node();
        n.setObj(o);
        if(temp!=null){
//            System.out.println(temp.obj);
            Node pre = temp.getPrivious();
            pre.setNext(n);
            temp.setPrivious(n);
            n.setPrivious(pre);
            n.setNext(temp);
        }else{
            this.add(n);
        }

        size++;
    }


    
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("ddd");
        list.insert(2,"hey guys!");
        System.out.println(list.get(3));
        System.out.println(list.get(2));
        System.out.println(list.size);
    }
}
