package com.neog.work.semaphore;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Producer implements Runnable{
    private Queue<Object> queue;
    private int maxSize;
    private Semaphore producerSemaphore;
    private Semaphore consumerSemaphore;

    public Producer(Semaphore consumerSemaphore, Semaphore producerSemaphore, int maxSize, Queue<Object> queue) {
        this.consumerSemaphore = consumerSemaphore;
        this.producerSemaphore = producerSemaphore;
        this.maxSize = maxSize;
        this.queue = queue;
    }

    @Override
    public void run() {
        while(true){
            try {
                producerSemaphore.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(queue.size() < maxSize){
                System.out.println("Producer :: "+Thread.currentThread().getName());
                queue.add(new Object());
            }
            consumerSemaphore.release();
        }
    }
}
