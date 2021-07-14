package com.android.algorithm.mutiThread.orderLock;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 3个线程交替打印 +1后 数字。
 * 则利用公平锁实现,只适用于：所有代码都在同步块内。
 *
 * 注意：sleep不能省略，不然没有节奏。
 */

class FairLockExecutor {
    private static int nub = 0;
    private Lock lock = new ReentrantLock(true);

    public static void main(String[] args) {
        FairLockExecutor fairLockExecutor = new FairLockExecutor();
        fairLockExecutor.fairLockExecutor();
    }


    private void fairLockExecutor() {
        //实现主体算法
        int threadCount = 10;
        ExecutorService executorPool = Executors.newFixedThreadPool(threadCount);
        for (int i = 0; i < threadCount; i++) {
            executorPool.submit(new Worker());
        }
    }

    /**
     * 所有代码都在，同步块内，则利用公平锁实现
     */
    class Worker implements Callable<String> {

        @Override
        public String call() throws Exception {
            //实现分算法
            while (true) {
                try {
                    lock.lock();
                    nub++;
                    System.out.println(Thread.currentThread().getName() + "---数字；" + nub);
                    Thread.sleep(50);
                } finally {
                    lock.unlock();
                }
            }
//            return "success";
        }
    }
}
