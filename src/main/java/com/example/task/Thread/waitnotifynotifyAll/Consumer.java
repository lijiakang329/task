package com.example.task.Thread.waitnotifynotifyAll;

/**
 * @description: 消费者
 * @author: jiakang
 * @create: 2022-06-11 19:36
 **/
public class Consumer implements Runnable {

    private MyData data;

    public Consumer(MyData data) {
        this.data = data;
    }

    @Override
    public void run() {
        try {
            synchronized (data) {
                while (data.getData() == 0) {
                    System.out.println("没有面包了，等待消费者生产面包...");
                    this.wait();
                }
                Thread.sleep(1000);
                data.del();
                System.out.println("消费了1个面包，可以生产了，" + "剩余: " + data.getData() + " 个面包");
                this.notifyAll();
            }
        } catch (Exception e) {
        }
    }

}
