package com.neog.work.treesize;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Node root = new Node(1);
        Node left = new Node(2);
        Node right = new Node(3);
        left.left = new Node(5);
        left.right = new Node(6);
        root.left = left;
        root.right = right;
        right.left = new Node(7);

        ExecutorService es = Executors.newFixedThreadPool(10);

        TreeSizeCalculator calc = new TreeSizeCalculator(root, es);
        Future<Integer> ans = es.submit(calc);
        System.out.print("ans :: " +ans.get());
        es.shutdown();
    }


}

class TreeSizeCalculator2{
    public Node root;

    public TreeSizeCalculator2(Node root){
        this.root = root;
    }

    public int getTreeSize(Node root){
        Node curr = root;
        if(curr == null) return 0;

        // else we need to find the size of tree
        return 1 + (getTreeSize(root.left) + getTreeSize(root.right));
    }
}
