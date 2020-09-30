package cn.sxt.collection;

public class Node {
     Node privious;
     Object obj;
     Node next;


    public Node(){

    }
    public Node(Node privious, Object obj, Node next) {
        this.privious = privious;
        this.obj = obj;
        this.next = next;
    }

    public Node getPrivious() {
        return privious;
    }

    public void setPrivious(Node privious) {
        this.privious = privious;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
