package com.neog.work.consumerproducer;

import java.util.Queue;

public class Consumer implements  Runnable{

    private Queue<Object> queue;
    private int maxSize;

    public Consumer(Queue<Object> queue, int maxSize) {
        this.queue = queue;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        for(int i =0; i<50; i++) {
            synchronized (queue) {
                if (!queue.isEmpty()) {
                    queue.remove();
                    System.out.println("removing element");
                } else {
                    System.out.println("queue is empty so can't remove element");
                }
            }
        }
    }
}
