package com.example.task.Thread.interrupt;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: demo
 * @author: jiakang
 * @create: 2022-06-15 18:24
 **/
@RestController
public class InterruptDemo {

    Boolean isInterrupt = false;
    volatile Integer i;

    @GetMapping("/interrupt")
    public String test() {
        i = 0;
        isInterrupt = false;
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (i) {
                    for (int j = 0; j < 11; j++) {
                        System.out.println("j: " + j);
                        while (j == 10){
                            System.out.println("j: " + j);
                            isInterrupt = true;
                            break;
                        }
                    }
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (isInterrupt) {
                    System.out.println("条件达成，停止...");
                    break;
                }
            }
        });
        try {
            t1.start();
            t1.join();
            t2.start();
            t2.join();
        }catch (Exception e){

        }
        return "sucess";
    }
}
