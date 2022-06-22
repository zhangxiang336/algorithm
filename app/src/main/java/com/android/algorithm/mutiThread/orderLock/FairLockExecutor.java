package com.android.algorithm.mutiThread.orderLock;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 3个线程交替工作(打印 +1后 数字)。
 * 则利用公平锁实现,--------尽量不用，侧重的是公平，不能保证有序，需要代码来保证。
 * <p>
 * 只适用于：所有代码都在同步块内。
 * <p>
 * 注意：
 * 1、sleep不能省略，不然没有节奏。
 * 2、公平锁，顺序输出，不保险。依赖顺序任务需要自动排队。
 * 3、 线程任务实在lock.lock();排队,退出逻辑不好控制。
 */

class FairLockExecutor {
    private static volatile int nub = 0;
    private static Lock lock = new ReentrantLock(true);

    public static void main(String[] args) {
        fairLockExecutor();
    }


    private static void fairLockExecutor() {
        //实现主体算法
        int threadCount = 10;
        ExecutorService executorPool = Executors.newFixedThreadPool(threadCount);
        for (int i = 0; i < threadCount; i++) {
            executorPool.submit(new Worker());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 所有代码都在，同步块内，则利用公平锁实现
     */
    static class Worker implements Callable<String> {

        @Override
        public String call() throws Exception {
            //实现分算法
            while (nub<100) { //注意：实际回打印到109
                try {
                    lock.lock();
                    nub++;
                    System.out.println(Thread.currentThread().getName() + "---数字；" + nub);
                    //这里理解给线程首次排队时间.
                    Thread.sleep(50);
                } finally {
                    lock.unlock();
                }
            }
            return null;
        }
    }
}
