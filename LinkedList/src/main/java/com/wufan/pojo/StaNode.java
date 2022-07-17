package com.wufan.pojo;

/**
 * 静态链表结点pojo类
 */
public class StaNode {

    public Object data;
    public int cur;

    public StaNode(Object data) {
        this.data = data;
    }

    public StaNode() {
        this.data = null;
    }

    public void del(){
        this.data = null;
        this.cur = 0;
    }

}
