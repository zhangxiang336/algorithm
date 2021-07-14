package com.android.algorithm.mutiThread.orderLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 3个线程交替打印 ABC 10次。
 * 思路：利用多condition，唤醒特定线程，实现线程顺序性
 * 注意：sleep不能省略，不然没有节奏。
 */

class MultiConditionLockThread {
    private Lock lock = new ReentrantLock(true);
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    public static void main(String[] args) {
        Thread t;

        MultiConditionLockThread fairLockExecutor = new MultiConditionLockThread();
        fairLockExecutor.printABC();
    }

    public void printABC() {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        lock.lock();
                        System.out.print("A");
                        condition2.signal();
                        condition1.await();
                        //注意：sleep不能省略，不然没有节奏。
                        Thread.sleep(50);
                    } catch (InterruptedException e) {

                    } finally {
                        lock.unlock();
                    }
                }

            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        lock.lock();
                        System.out.print("B");
                        condition3.signal();
                        condition2.await();
                        Thread.sleep(50);
                    } catch (InterruptedException e) {

                    } finally {
                        lock.unlock();
                    }
                }
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        lock.lock();
                        System.out.print("C");
                        condition1.signal();
                        condition3.await();
                        Thread.sleep(50);
                    } catch (InterruptedException e) {

                    } finally {
                        lock.unlock();
                    }
                }
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }

}
