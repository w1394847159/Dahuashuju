package com.wufan.utils;

import com.wufan.pojo.Node;

/**
 * 单链表工具类
 */
public class LinkList {

    //头结点
    private Node head;
    private int size;

    //默认头结点
    public LinkList(){
        this.head = new Node();
    }

    //创建一个空链表，即创建一个头结点
    public void createList(){
        head.next = null;
        size = 0;
    }

    //产生n个结点大小的链表  尾插法
    public void createList(int n){
        head.next = null;
        //作为末尾结点
        Node old = new Node();
        for (int i = 0; i < n; i++) {
            //生成新的结点
            Node node = new Node();
            node.next = null;
            if(i == 0){
                //第一次插入将新结点作为头结点后继
                head.next = node;
            }
            else {
                //将新结点作为最末尾结点的后继
                old.next = node;
            }
            //将old变为最后的结点
            old = node;
            size += 1;
        }
    }

    // 尾插法
    public void createListnew(int n){
        Node old = new Node();
        head.next = old;
        for (int i = 0; i < n; i++) {
            //新建结点
            Node node = new Node();
            node.next = null;
            old.next = node;
            //将新结点作为尾结点
            old = node;
            size += 1;
        }

    }

    //默认将数据插入到最后
    public void add(Object e){
        Node node = new Node(e);
        Node old = head.next; //获取第一个结点
        //遍历获取最后一个结点
        for (int i = 0; i < size - 1; i++) {
            old = old.next; //第一次循环，old是第二个结点
        }
        //old为最后一个结点
        old.next = node;
        size += 1;
    }

    //插入指定位置
    public void add(Object e,int index){
        if(index < 1 || index > size) {
            throw new IndexOutOfBoundsException("输入的索引不正确");
        }
            Node node = new Node(e);
            Node old = head.next;
            //遍历获取指定位置前一个结点
            for (int i = 0; i < index - 1; i++) {
                old = old.next;
            }
            //插入前要将插入位置的后继结点赋值给新结点
            node.next = old.next;
            old.next = node;
            size += 1;

    }

    //删除指定位置结点
    public void remove(int index){
        if(index < 1 || index > size) {
            throw new IndexOutOfBoundsException("输入的索引不正确");
        }
        Node old = head.next;
        //遍历获取指定位置前一个结点
        for (int i = 0; i < index - 1; i++) {
            old = old.next;
        }
        //删除前要将删除位置后继结点赋值给新结点
        Node remo = old.next;  //要删除的结点
        old.next = remo.next;
        remo.del();
        size= size-1;
    }

    //显示所有结点
    public void showAll(){
        Node node = head.next;
        for (int i = 0; i < size; i++) {
            System.out.println(node.data);
            node = node.next;
        }
    }

    //整表删除
    public void delAll(){
        Node old = head.next; //第一个结点
        for (int i = 0; i < size; i++) {
            Node next = old.next; //下一个节点
            old.del(); //删除掉old结点
            old = next; //将old下一结点作为新的old
        }
        head.next = null; //将头结点下一结点置为空
        size = 0;
    }


    public static void main(String[] args) {
        LinkList linkList = new LinkList();
        linkList.createListnew(3);
        linkList.add(2);
        linkList.add(22);
        linkList.add(222);
        linkList.add(2,2);
        /*linkList.remove(3);
        linkList.delAll();*/
        linkList.showAll();
    }

}
