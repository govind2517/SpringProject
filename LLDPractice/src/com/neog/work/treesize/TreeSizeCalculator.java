package com.neog.work.treesize;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class TreeSizeCalculator implements Callable<Integer> {
    private Node root;
    private ExecutorService executorService;

    public TreeSizeCalculator(Node root, ExecutorService executorService){
        this.root = root;
        this.executorService = executorService;
    }

    @Override
    public Integer call() throws Exception {
        if(this.root == null)
            return 0;

        Node leftNode = this.root.left;
        Node rightnode = this.root.right;

        TreeSizeCalculator leftCalc = new TreeSizeCalculator(leftNode, executorService);
        TreeSizeCalculator rightCalc = new TreeSizeCalculator(rightnode, executorService);

        Future<Integer> leftCalcFuture = executorService.submit(leftCalc);
        Future<Integer> rightCalcFuture = executorService.submit(rightCalc);

        return ((leftCalcFuture.get() + rightCalcFuture.get()) + 1);
    }
}
