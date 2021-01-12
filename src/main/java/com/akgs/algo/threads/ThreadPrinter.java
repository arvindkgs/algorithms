package com.akgs.algo.threads;

public class ThreadPrinter {
    static Object lock = new Object();
    static volatile boolean set = false;
    static volatile int value = 0;
    public static void main(String[] args) {
        //Incrementer Printer
        //Incrementer
        Thread incrementer = new Thread(new Incrementer(), "Incrementer");
        Thread printer = new Thread(new Printer(),"Printer");
        incrementer.start();
        printer.start();
    }

    public static class Incrementer implements Runnable{

        @Override
        public synchronized void run() {
            try {
                while(true){
                    synchronized (lock) {
                        while (set) {
                            lock.wait();
                        }
                        value++;
                        set = true;
                        lock.notify();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class Printer implements Runnable{

        @Override
        public synchronized void run() {
            try {
                while (true) {
                    synchronized (lock) {
                        while (!set) {
                            lock.wait();
                        }
                        set = false;
                        System.out.println("value = " + value);
                        lock.notify();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
