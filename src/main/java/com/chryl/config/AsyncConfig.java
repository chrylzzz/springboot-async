package com.chryl.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by Chr.yl on 2023/2/8.
 *
 * @author Chr.yl
 */
@Slf4j
@Configuration
public class AsyncConfig implements AsyncConfigurer {

    //获取当前机器的核数
    public static final int cpuNum = Runtime.getRuntime().availableProcessors();

    /**
     * 获取线程池
     *
     * @return
     */
    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(cpuNum);//核心线程大小
        taskExecutor.setMaxPoolSize(cpuNum * 2);//最大线程大小
        taskExecutor.setQueueCapacity(500);//队列最大容量
        //当提交的任务个数大于QueueCapacity，就需要设置该参数，但spring提供的都不太满足业务场景，可以自定义一个，也可以注意不要超过QueueCapacity即可
        taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        taskExecutor.setWaitForTasksToCompleteOnShutdown(true);
        taskExecutor.setAwaitTerminationSeconds(60);
        //设置进程名前缀
        taskExecutor.setThreadNamePrefix("Chryl-Thread-");
        taskExecutor.initialize();
        return taskExecutor;
    }

    /**
     * 异常处理
     *
     * @return
     */
    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return (throwable, method, objects) -> {
            //可以做一些其他的业务处理，比如：异常记录日志
            log.error("class: {}", method.getDeclaringClass().getName());
            log.error("method：{}", method.getName());
            log.error("type：{}", throwable.getClass().getName());
            log.error("exception：{}", throwable.getMessage());
        };
    }


    //自定义线程池
//    @Bean
//    public ThreadPoolExecutor myThreadPool() {
//        return new ThreadPoolExecutor(4,
//                5,
//                60,
//                TimeUnit.SECONDS,
//                new LinkedBlockingQueue<>(10),
//                new NamedThreadFactory("hard-study"),
//                new ThreadPoolExecutor.AbortPolicy()
//        );
//    }


    public static void main(String[] args) {
        System.out.println(cpuNum);
    }
}
