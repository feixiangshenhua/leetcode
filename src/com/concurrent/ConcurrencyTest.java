/**
 * Project Name: 邮乐支付系统
 * File Name: ConcurrencyTest
 * Package Name: com.concurrent
 * Date: 2019/8/7 16:57
 * Copyright (c) 2019, 上海邮乐网络技术有限公司
 * author：xiao.y
 */
package com.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ClassName: ConcurrencyTest <br>
 * Function: 并发测试. <br>
 * Date: 2019/8/7 16:57 <br>
 */
public class ConcurrencyTest {
    /**
     * 请求总数
     */
    public static int clientTotal = 5000;

    /**
     * 同时并发执行的线程数
     */
    public static int threadTotal = 200;

    public static AtomicInteger count = new AtomicInteger();

    public static void main(String[] args) throws Exception {
        //定义线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        //定义信号量,给出允许并发的线程数目
        final Semaphore semaphore = new Semaphore(threadTotal);
        //统计计数结果
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        long start = System.currentTimeMillis();
        ConcurrencyTest test = new ConcurrencyTest();
        //将请求放入线程池
        for (int i = 0; i < clientTotal ; i++) {
            executorService.execute(() -> {
                try {
                    //信号量的获取
                    semaphore.acquire();
                    add();
                    countDownLatch.countDown();
                    //释放
                    semaphore.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        countDownLatch.await();
        //关闭线程池
        executorService.shutdown();
        long end = System.currentTimeMillis();
        System.out.println("count:" + count + "，用时 " +(end - start));
    }

    /**
     * 统计方法
     */
    private static void add() {
        count.incrementAndGet();
    }
}
