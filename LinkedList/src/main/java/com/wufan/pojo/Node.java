package com.wufan.pojo;

/**
 * 节点实体类
 */
public class Node {

    //数据
    public Object data;
    //下一结点
    public Node next;

    public Node(Object e) {
        this.data = e;
        this.next = null;
    }

    public Node(){
        this.data = null;
        this.next = null;
    }

    public void del(){
        this.data = null;
        this.next = null;
    }
}
