package com.wufan.utils;

import com.wufan.pojo.StackNode;

public class LinkStackPtr {

    private int count;
    private StackNode top;

    public LinkStackPtr(){
        count = 0;
        top = new StackNode();
    }

    //推送数据
    public void push(Object e){
        //创建新结点
        StackNode stackNode = new StackNode();
        stackNode.data = e;
        //将旧的栈顶作为新结点的后继
        stackNode.next = top;
        //将新结点作为栈顶
        top = stackNode;
        count++;
    }

    public Object pop(){
        if(count == 0){
            throw new IndexOutOfBoundsException("链栈为空");
        }
        //获取当前栈顶元素
        Object data = top.data;
        //将第二个元素作为栈顶元素
        top = top.next;
        count--;
        return data;
    }

    public void show(){
    StackNode node = top;
        for (int i = 0; i < count; i++) {
            System.out.println(node.data);
            node = node.next;
        }
    }


    public static void main(String[] args) {
        //创建空链栈
        LinkStackPtr ls = new LinkStackPtr();
        ls.push("hello");
        ls.push("hello y");
        ls.push("hello you");
        ls.pop();
        ls.show();
    }
}
