package com.android.algorithm.mutiThread.producerAndConsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 86137
 * Create at 2021/2/25.
 */

class ProducerAndConsumerLockExecutor {
    private Queue<Integer> queue = new LinkedList<>();
    private final static int MIX_SIZE = 10;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public static void main(String[] args) {
        ProducerAndConsumerLockExecutor producerAndConsumerLockExecutor = new ProducerAndConsumerLockExecutor();
        producerAndConsumerLockExecutor.producerAndConsumerLockExecutor();
    }

    private void producerAndConsumerLockExecutor() {
        //异常判断
        if (queue == null) {
            queue = new LinkedList<>();
        }
        //实现主体算法
        int threadCount = 2;
        ExecutorService executorPool = Executors.newFixedThreadPool(threadCount);
        executorPool.submit(new Producor());
        executorPool.submit(new Consumer());
    }

    class Producor implements Callable<String> {

        @Override
        public String call() throws Exception {
            //实现分算法
            while (true) {
                try {
                    lock.lock();
                    while (queue.size() == MIX_SIZE) {
                        condition.await();
                    }
                    queue.add(1);
                    System.out.println("生产一个，队列长队" + queue.size());
                    condition.signal();
                } finally {
                    lock.unlock();
                }
                Thread.sleep(200);
            }
//            return "success";
        }
    }

    class Consumer implements Callable<String> {

        @Override
        public String call() throws Exception {
            //实现分算法
            while (true) {
                try {
                    lock.lock();
                    while (queue.size() == 0) {
                        condition.await();
                    }
                    queue.poll();
                    System.out.println("消费一个，队列长队" + queue.size());
                    condition.signal();
                } finally {
                    lock.unlock();
                }
                Thread.sleep(200);
            }
//            return "success";
        }
    }
}
