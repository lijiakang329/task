package com.example.task.Thread.waitnotifynotifyAll;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @description: 测试多线程
 * @author: jiakang
 * @create: 2022-06-11 19:42
 **/
@Component
public class ThreadTest {

    @GetMapping("/test")
    public String test() {
        MyData data = new MyData();
        Thread t1 = new Thread(new Producer(data));
        Thread t12 = new Thread(new Producer(data));
        Thread t13 = new Thread(new Producer(data));
        Thread t21 = new Thread(new Producer(data));
        Thread t22 = new Thread(new Consumer(data));
        Thread t23 = new Thread(new Consumer(data));
        Thread t24 = new Thread(new Consumer(data));
        t21.start();
        t22.start();
        t23.start();
        t24.start();
        t1.start();
        t12.start();
        t13.start();
        return "Success!";
    }
}
