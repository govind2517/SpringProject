package com.neog.work.executorbasic;

public class Client {
    public static void main(String[] args) {
        for(int i=0; i<100; i++){
            Thread t = new Thread(new NumberPrinter(i));
            t.start();
        }
    }
}
