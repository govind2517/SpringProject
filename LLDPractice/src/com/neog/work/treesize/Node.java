package com.neog.work.treesize;

public class Node {
    public Integer data;
    public Node left, right;

    public Node(int data){
        this.data = data;
        left = right = null;
    }
}
