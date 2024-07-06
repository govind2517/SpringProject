package com.neog.work.consumerproducer;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Client {
    public static void main(String[] args) {
        Queue<Object> queue = new ConcurrentLinkedDeque<>();
        Producer p1 = new Producer(queue, 5);
        Producer p2 = new Producer(queue, 5);
        Producer p3 = new Producer(queue, 5);
        Consumer c1 = new Consumer(queue, 5);
        Consumer c2 = new Consumer(queue, 5);
        Consumer c3 = new Consumer(queue, 5);
        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(p2);
        Thread t3 = new Thread(p3);
        Thread t4 = new Thread(c1);
        Thread t5 = new Thread(c2);
        Thread t6 = new Thread(c3);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
    }
}
