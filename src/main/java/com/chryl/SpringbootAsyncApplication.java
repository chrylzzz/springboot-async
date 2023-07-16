package com.chryl;

import com.chryl.async.AsyncMethods;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync//必须开启异步
@SpringBootApplication
public class SpringbootAsyncApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringbootAsyncApplication.class, args);
        //async
        AsyncMethods asyncMethods = context.getBean("asyncMethods", AsyncMethods.class);
        for (int i = 0; i < 5; i++) {
//            asyncMethods.test1();
//            asyncMethods.test2();
//            asyncMethods.test3();
        }

    }

}
