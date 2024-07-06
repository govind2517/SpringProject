package com.neog.work.consumerproducer;

import java.util.Queue;

public class Producer implements Runnable{
    private Queue<Object> queue;
    private int maxSize;

    public Producer(Queue<Object> queue, int maxSize) {
        this.queue = queue;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        for(int i =0; i<50; i++) {
            synchronized (queue) {
                if (queue.size() < maxSize) {
                    queue.add(new Object());
                    System.out.println("Adding in queue.");
                } else {
                    System.out.println("can't add in queue, it's full.");
                }
            }
        }
    }
}
