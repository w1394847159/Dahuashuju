package com.wufan.utils;

import com.wufan.pojo.Node;
import com.wufan.pojo.StaNode;

import java.util.List;

/**
 * 静态链表实现类
 */
public class StaLinkList {
    private int MAXSIZE;
    private StaNode[] List;
    private int size;

    public StaLinkList() {
    }

    //初始化静态链表
    public void InitList(int len){
        MAXSIZE = len;
        List = new StaNode[len]; //创建len长度数组，数组中还是空，每一个位置需重新添加结点
        //最后一个结点存储第一个有值元素下标
        for (int i = 0; i < len - 1; i++) {
            //添加新结点
            List[i] = new StaNode();
            List[i].cur = i+1;
            List[i].data = null;
        }
        List[len-1] = new StaNode();
        List[len-1].cur = 1; //初始化时指向第一个元素
        size = 0;
    }

    //获取备用链表
    public int Malloc_SSL(){
        int i = List[0].cur;  //获取空闲列表第一个元素的下标
        if(i != 0) {
            List[0].cur = List[i].cur;
        }
        return i;

    }

    //添加元素，默认添加到末尾
    public void add(Object e){
        int i = Malloc_SSL();
        StaNode node = List[MAXSIZE -1]; //头结点
        for (int j = 0; j < size; j++) {
            node = List[node.cur];
        }
        node.cur = i;
        List[i].cur = 0;
        List[i].data = e;
        sizeInc();
    }

    //Index位置处插入元素
    //空闲空间第一个位置放入元素
    public void ListInsert(int index,Object e){
        int k = MAXSIZE -1;
        int j = Malloc_SSL();
        if(j != 0){
            List[j] =new StaNode();
            List[j].data = e;
            //找到index-1的位置
            for (int i = 1; i < index; i++) {
                k = List[k].cur;
            }
            List[j].cur = List[k].cur;
            List[k].cur = j;
            sizeInc();
        }
    }

    //Index删除元素
    public Object ListDelete(int index){
        int k = MAXSIZE - 1;
        for (int i = 1; i < index; i++) {
            k = List[k].cur;
        }
        int j = List[k].cur;
        Object data = List[j].data;
        List[k].cur = List[j].cur;
        Free_SSL(j); //释放结点
        sizeDel();
        return data;


    }

    public void Free_SSL(int j){
        List[j].cur = List[0].cur;  //把第一个元素的cur值赋值给要删除的元素
        List[0].cur = j; //
        List[j].data = null;
    }

    public void sizeDel(){
        size -= 1;
        int rest = (MAXSIZE -2 -size); //剩余空间
        if(rest < 0){
            throw new IndexOutOfBoundsException("无剩余空间");
        }
        else {
            System.out.println("剩余可用空间：" + rest);
        }
    }

    public void show(){
        //找到头结点
        int k = MAXSIZE -1;
        for (int i = 0; i < size; i++) {
            k = List[k].cur;
            System.out.println(List[k].data);
        }
    }



    public void sizeInc(){
        size += 1;
        int rest = (MAXSIZE -2 -size); //剩余空间
        if(rest < 0){
            throw new IndexOutOfBoundsException("无剩余空间");
        }
        else {
            System.out.println("剩余可用空间：" + rest);
        }
    }


    public static void main(String[] args) {
        StaLinkList staLinkList = new StaLinkList();
        staLinkList.InitList(1000);
        staLinkList.add("阿里山");
        staLinkList.add("的姑娘");
        staLinkList.ListInsert(2,"最最美");
        Object o = staLinkList.ListDelete(1);
        staLinkList.show();
        System.out.println("删除元素是"+ o);
    }
}
