package com.example.task.Thread.waitnotifynotifyAll.deadlock;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @description: test
 * @author: jiakang
 * @create: 2022-06-12 23:35
 **/
@Controller
public class TestClass {

    @GetMapping("/deadlock")
    public String test() {
//        for (int i = 50; i >= 0; i--) {
//            new Thread(new ProcessStep(i)).start();
//        }
        Thread t = new Thread(new ProcessStep(1314));
        Thread t2 = new Thread(new ProcessStep(888));
        System.out.println("线程是否存活: " + t.isAlive());
        System.out.println("线程状态: " + t.getState());

        try {
            t.start();
            t2.start();
//            t2.start();
//            t2.join();
            System.out.println("线程状态: " + t.getState());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("线程状态: " + t.getState());
        System.out.println("线程2状态: " + t2.getState());
        return "success";
    }
}
