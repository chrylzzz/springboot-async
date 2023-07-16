package com.chryl.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * 方法直接写async
 * Created by Chr.yl on 2023/2/8.
 *
 * @author Chr.yl
 */
@Slf4j
@Component
public class AsyncMethods {

    @Async
    public void test1() {
        try {
            //暂停一会线程
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
        log.info("----------" + Thread.currentThread().getName());
    }


    @Async
    public void test3() {
        try {
            //暂停一会线程
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
        //制造异常
        System.out.println(10 / 0);
        log.info("----------" + Thread.currentThread().getName());
    }

    //指定线程池
//    @Async("myThreadPool")
//    public void test2() {
//        try {
//            //暂停一会线程
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//            Thread.currentThread().interrupt();
//        }
//        //制造异常
//        System.out.println(10 / 0);
//        log.info(Thread.currentThread().getName());
//
//
//    }

}
