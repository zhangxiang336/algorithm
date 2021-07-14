package com.android.algorithm.mutiThread.orderLock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 3个线程交替打印 +1后 数字。
 * 利用多condition，唤醒特定线程，实现线程顺序性
 *
 * 注意：sleep不能省略，不然没有节奏。
 */

class MultiConditionLockExecutor {
    private static int nub = 0;
    ReentrantLock  Reentrantlock;
    private Lock lock = new ReentrantLock(true);
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    public static void main(String[] args) {
        Thread t;

        MultiConditionLockExecutor fairLockExecutor = new MultiConditionLockExecutor();
        fairLockExecutor.fairLockExecutor();
    }

        private void fairLockExecutor() {
        //实现主体算法
        int threadCount = 3;
        ExecutorService executorPool = Executors.newFixedThreadPool(threadCount);
        for (int i = 1; i <= threadCount; i++) {
            executorPool.execute(new Worker(i));
        }
    }
    class Worker implements Runnable {
        int threadNub;

        public Worker(int threadNub) {
            this.threadNub = threadNub;
        }
        @Override
        public void run() {
            while (true) {
                try {
                    lock.lock();
                    if (threadNub==1) {
                        nub++;
                        condition2.signal();
                        condition1.await();
                    } else if (threadNub==2){
                        nub++;
                        condition3.signal();
                        condition2.await();
                    } else if (threadNub==3){
                        nub++;
                        condition1.signal();
                        condition3.await();
                    }

                    System.out.println(Thread.currentThread().getName() + "---数字；" + nub);
                }  catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

//    /**
//     * 所有代码都在，同步块内，则利用公平锁实现
//     */
//    class Worker implements Callable<String> {
//        int threadNub;
//
//        public Worker(int threadNub) {
//            this.threadNub = threadNub;
//        }
//
//        @Override
//        public String call() throws Exception {
//            //实现分算法
//            while (true) {
//                try {
//                    lock.lock();
//                    if (threadNub==1) {
//                        nub++;
//                        condition2.signal();
//                        condition1.await();
//                    } else if (threadNub==2){
//                        nub++;
//                        condition3.signal();
//                        condition2.await();
//                    } else if (threadNub==3){
//                        nub++;
//                        condition1.signal();
//                        condition3.await();
//                    }
//
//                    System.out.println(Thread.currentThread().getName() + "---数字；" + nub);
//                } finally {
//                    lock.unlock();
//                }
//                Thread.sleep(50);
//            }
////            return "success";
//        }
//    }
}
