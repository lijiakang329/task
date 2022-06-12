package com.example.task.Thread.waitnotifynotifyAll.producerandconsumer;

/**
 * @description: 消费者
 * @author: jiakang
 * @create: 2022-06-11 19:36
 **/
public class Consumer implements Runnable {

    private final MyData data;

    public Consumer(MyData data) {
        this.data = data;
    }

    /**
     * 所有等待的线程都有相同的条件谓词。
     * 所有线程在唤醒后执行相同的一组操作。
     * 只需一个线程即可在收到通知时唤醒。
     * @Param: @param
     * @return: void
     * @Author: jiakang
     * @Date: 2022/6/12
     */
    @Override
    public void run() {
        try {
            synchronized (data) {
                while (data.getData() == 0) {
                    System.out.println("【消费者线程等待...】没有面包了，等待消费者生产面包...");
                    data.wait();
                }
                data.del();
                System.out.println("消费了1个面包，可以生产了，" + "剩余: " + data.getData() + " 个面包");
                //data.notifyAll();
                data.notify();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
