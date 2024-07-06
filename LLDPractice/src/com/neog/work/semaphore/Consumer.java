package com.neog.work.semaphore;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Consumer implements Runnable {
    private Queue<Object> queue;
    private int maxSize;
    private Semaphore producerSemaphore;
    private Semaphore consumerSemaphore;

    public Consumer(Semaphore consumerSemaphore, Semaphore producerSemaphore, int maxSize, Queue<Object> queue) {
        this.consumerSemaphore = consumerSemaphore;
        this.producerSemaphore = producerSemaphore;
        this.maxSize = maxSize;
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                consumerSemaphore.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (!queue.isEmpty()) {
                System.out.println("Consumer :: " + Thread.currentThread().getName());
                queue.remove();
            }
            producerSemaphore.release();
        }
    }
}
