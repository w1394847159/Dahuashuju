package com.wufan.utils;

import com.wufan.pojo.BinNode;

import java.util.Scanner;

public class BinaryTree {


    /**
     * 创建二叉树
     */
    public static void createBiTree(BinNode binNode){
        System.out.println("输入：");
        Scanner scanner = new Scanner(System.in);
        char c = scanner.next().charAt(0);
        if(c == '#'){
            binNode = null;
        }
        else {
            binNode.data = c;
            binNode.leftNode = new BinNode();
            binNode.rigthNode = new BinNode();
            //使用前序遍历法，左孩子遍历结束后遍历右孩子
            createBiTree(binNode.leftNode);
            createBiTree(binNode.rigthNode);
        }

    }

    //二叉树展示,前序遍历
    public static void show(BinNode binNode){

        //先遍历左孩子，再遍历右孩子
    if(binNode != null){

        show(binNode.leftNode);
        System.out.println(binNode.data);
        show(binNode.rigthNode);
    }
    }


    public static void main(String[] args) {

        BinNode binNode = new BinNode();
        createBiTree(binNode);
        show(binNode);
    }
}
