package com.neog.work.mergesort;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class Sorter implements Callable<List<Integer>> {

    private List<Integer> arrayToSort;
    private ExecutorService executorService;

    public Sorter(List<Integer> arrayToSort, ExecutorService executorService){
        this.arrayToSort = arrayToSort;
        this.executorService = executorService;
    }

    @Override
    public List<Integer> call() throws Exception {
        System.out.println("Thread :: "+Thread.currentThread().getName()+" and got list "+arrayToSort);
        if(arrayToSort.size() <= 1)
            return arrayToSort;

        int mid = arrayToSort.size()/2;
        List<Integer> leftArrayToSort = new ArrayList<>();
        for(int i=0; i<mid; i++){
            leftArrayToSort.add(arrayToSort.get(i));
        }

        List<Integer> rightArrayToSort = new ArrayList<>();
        for(int i=mid; i<arrayToSort.size(); i++) {
            rightArrayToSort.add(arrayToSort.get(i));
        }

        Sorter leftSorter = new Sorter(leftArrayToSort, executorService);
        Sorter rightSorter = new Sorter(rightArrayToSort, executorService);

        Future<List<Integer>> leftArrayFuture = executorService.submit(leftSorter);
        Future<List<Integer>> rightArrayFuture = executorService.submit(rightSorter);

        List<Integer> sortedArray = new ArrayList<>();

        int i=0, j=0;
        List<Integer> leftSortedArray = leftArrayFuture.get();
        List<Integer> rightSortedArray = rightArrayFuture.get();

        while(i < leftSortedArray.size() && j <rightSortedArray.size()){
            if(leftSortedArray.get(i) < rightSortedArray.get(j)){
                sortedArray.add(leftSortedArray.get(i));
                i++;
            }else{
                sortedArray.add(rightSortedArray.get(j));
                j++;
            }
        }

        while(i < leftSortedArray.size()){
            sortedArray.add(leftSortedArray.get(i));
            i++;
        }

        while(j < rightSortedArray.size()){
            sortedArray.add(rightSortedArray.get(j));
            j++;
        }
        System.out.println("Thread :: "+Thread.currentThread().getName()+" and returning list "+sortedArray);
        return sortedArray;
    }
}
