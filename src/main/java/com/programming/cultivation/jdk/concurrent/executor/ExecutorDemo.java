package com.programming.cultivation.jdk.concurrent.executor;

import java.util.concurrent.*;

/**
 * @author biyue
 * @since 2019/12/23
 */
public class ExecutorDemo {


    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newFixedThreadPool();

        BlockingQueue queue = new ArrayBlockingQueue(10);
        ExecutorService service = new ThreadPoolExecutor(10,10,10L, TimeUnit.MINUTES,queue);

    }

}
