package com.neog.work.semaphore;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.Semaphore;

public class Client {

    public static void main(String[] args) {
        Queue<Object> queue = new ConcurrentLinkedDeque<>();
        Semaphore producerSemaphore = new Semaphore(6);
        Semaphore consumerSemaphore = new Semaphore(0);

        Producer p1 = new Producer(consumerSemaphore, producerSemaphore, 5, queue);
        Producer p2 = new Producer(consumerSemaphore, producerSemaphore, 5, queue);
        Producer p3 = new Producer(consumerSemaphore, producerSemaphore, 5, queue);

        Consumer c1 = new Consumer(consumerSemaphore, producerSemaphore, 5, queue);
        Consumer c2 = new Consumer(consumerSemaphore, producerSemaphore, 5, queue);
        Consumer c3 = new Consumer(consumerSemaphore, producerSemaphore, 5, queue);
        Consumer c4 = new Consumer(consumerSemaphore, producerSemaphore, 5, queue);
        Consumer c5 = new Consumer(consumerSemaphore, producerSemaphore, 5, queue);

        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(p2);
        Thread t3 = new Thread(p3);

        Thread t4 = new Thread(c1);
        Thread t5 = new Thread(c2);
        Thread t6 = new Thread(c3);
        Thread t7 = new Thread(c4);
        Thread t8 = new Thread(c5);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
    }
}
