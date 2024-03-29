package com.android.algorithm.mutiThread.orderLock;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 3个线程交替打印 +1后 数字。
 * 利用多个condition，唤醒特定线程，实现线程顺序性
 * <p>
 * 注意：
 * 1、需要保证线程的首次执行顺序。
 * 2.condition是释放锁,当前线程进入等待队列.
 * 3、顺序输出的，尽量不要用一个condition来控制，不容易控制顺序。
 * <p>
 * 思路:condition 依次唤醒,同步性容易控制.
 */

class MultiConditionLockExecutor {
    private static int nub = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    public static void main(String[] args) {
        MultiConditionLockExecutor fairLockExecutor = new MultiConditionLockExecutor();
        fairLockExecutor.fairLockExecutor();
    }

    private void fairLockExecutor() {
        //实现主体算法
        int threadCount = 3;
        ExecutorService executorPool = Executors.newFixedThreadPool(threadCount);
        try {
            executorPool.submit(new Worker1("A"));
            Thread.sleep(20);
            executorPool.submit(new Worker2("B"));
            Thread.sleep(20);
            executorPool.submit(new Worker3("C"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    class Worker1 implements Callable<String> {
        String str;

        public Worker1(String ch) {
            str = ch;
        }

        @Override
        public String call() throws Exception {
            while (nub < 100) {
                try {
                    lock.lock();
                    nub++;
                    System.out.println(Thread.currentThread().getName() + "---数字；" + nub + str);
                    condition2.signal();
                    condition1.await();//因为是这里排队，唤醒之后，是下一次完成逻辑
                } finally {
                    lock.unlock();
                }
//                Thread.sleep(50);
            }
            return null;
        }
    }

    class Worker2 implements Callable<String> {
        String str;

        public Worker2(String ch) {
            str = ch;
        }

        @Override
        public String call() throws Exception {
            while (nub < 100) {
                try {
                    lock.lock();
                    nub++;
                    System.out.println(Thread.currentThread().getName() + "---数字；" + nub + str);
                    condition3.signal();
                    condition2.await();
                } finally {
                    lock.unlock();
                }
//                Thread.sleep(50);
            }
            return null;
        }
    }

    class Worker3 implements Callable<String> {
        String str;

        public Worker3(String ch) {
            str = ch;
        }

        @Override
        public String call() throws Exception {
            while (nub < 100) {
                try {
                    lock.lock();
                    nub++;
                    System.out.println(Thread.currentThread().getName() + "---数字；" + nub + str);
                    condition1.signal();
                    condition3.await();
                } finally {
                    lock.unlock();
                }
//                Thread.sleep(50);
            }
            return null;
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
