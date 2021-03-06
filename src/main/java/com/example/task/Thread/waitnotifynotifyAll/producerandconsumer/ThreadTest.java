package com.example.task.Thread.waitnotifynotifyAll.producerandconsumer;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @description: 测试多线程
 * @author: jiakang
 * @create: 2022-06-11 19:42
 **/
@Component
@Controller
public class ThreadTest {

    @GetMapping("/test")
    public String test() {
        System.out.println("--------------------[Testing]--------------------");
        MyData data = new MyData();
        for(int i=0;i<10;i++) {
            new Thread(new Producer(data)).start();
        }
        for(int i=0;i<10;i++) {
            new Thread(new Consumer(data)).start();
        }
        System.out.println("Main thread is end");
        return "Success!";
    }
}
