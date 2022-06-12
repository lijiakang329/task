package com.example.task.Thread.waitnotifynotifyAll;

/**
 * @description: 生产者
 * @author: jiakang
 * @create: 2022-06-11 19:27
 **/
public class Producer implements Runnable {

    private MyData data;

    public Producer(MyData data) {
        this.data = data;
    }

    public void run() {
        try {
            synchronized (data) {
                while (data.getData() > 0) {
                    System.out.println("【生产者线程等待...】目前还有 " + data.getData() + " 个面包，等待消费者线程消费...");
                    wait();
                }
                data.add();
                System.out.println("生产出了1个面包，可以消费了," + "剩余: " + data.getData() + " 个面包");
                //this.notifyAll();
                notify();
            }
        } catch (Exception e) {
        }
    }

}
