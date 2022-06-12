package com.example.task.Thread.waitnotifynotifyAll.producerandconsumer;

/**
 * @description: 存储多线程共享变量
 * @author: jiakang
 * @create: 2022-06-11 19:34
 **/
public class MyData {

    private volatile int j = 0;

    //增加方法
    public synchronized void add() {
        j++;
    }

    //删除方法
    public synchronized void del() {
        j--;
    }

    public int getData() {
        return j;
    }
}
