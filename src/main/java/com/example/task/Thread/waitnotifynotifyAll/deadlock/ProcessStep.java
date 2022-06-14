package com.example.task.Thread.waitnotifynotifyAll.deadlock;

/**
 * @description: thread
 * @author: jiakang
 * @create: 2022-06-12 23:31
 **/
public final class ProcessStep implements Runnable {

    private static final Object lock = new Object();
    private static int time = 0;
    private final int step;

    public ProcessStep(int step) {
        this.step = step;
    }

    @Override
    public void run() {
        try {
            synchronized (lock) {
                while (time != step) {
                    System.out.println("--- time : " + time + " step : " + step + " ---");
                    lock.wait();
                }
                System.out.println("time : " + time + " step : " + step);
                time++;
                lock.notify();
            }
        } catch (Exception ie) {
            Thread.currentThread().interrupt(); // Reset interrupted status
        }
    }
}
