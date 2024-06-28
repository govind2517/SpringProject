package com.neog.work.mergesort;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> listToSort = List.of(10,2,8,4,1,6,4,5,20,50,30,1,5);
        // this one will not work when input is too much high, all thread are used from pool and waiting for child to complete so that they can start, but no thread is free to pick next task
        // ExecutorService es = Executors.newFixedThreadPool(10);

        ExecutorService es = Executors.newCachedThreadPool(); // this will work as required it will create thread, and utilize once they required
        Sorter sorter = new Sorter(listToSort, es);
        Future<List<Integer>> sorterFuture = es.submit(sorter);

        List<Integer> sortedList = sorterFuture.get();
        System.out.println(sortedList);
        es.shutdown();
    }
}
