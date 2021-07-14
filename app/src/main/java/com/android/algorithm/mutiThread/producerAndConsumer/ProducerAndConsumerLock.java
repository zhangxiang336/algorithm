package com.android.algorithm.mutiThread.producerAndConsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 86137
 * Create at 2021/2/24.
 */

class ProducerAndConsumerLock {

    private static final int MAX_LEN = 10;
    private Queue<Integer> queue = new LinkedList<Integer>();
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public static void main(String[] args) {
        ProducerAndConsumerLock pc = new ProducerAndConsumerLock();
        Producer producer = pc.new Producer();
        Consumer consumer = pc.new Consumer();
        producer.start();
        consumer.start();
    }

    class Producer extends Thread {
        @Override
        public void run() {
            producer();
        }

        private void producer() {
            while (true) {
                try {
                    lock.lock();
                    while (queue.size() == MAX_LEN) {
                        System.out.println("当前队列满");
                        condition.await();
                    }
                    queue.add(1);
                    condition.signal();
                    System.out.println("生产者生产一条任务，当前队列长度为" + queue.size());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
                // 只同步，需要线程安全的代码
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Consumer extends Thread {
        @Override
        public void run() {
            consumer();
        }

        private void consumer() {
            while (true) {
                try {
                    lock.lock();
                    while (queue.size() == 0) {
                        System.out.println("当前队列为空");
                        condition.await();
                    }
                    queue.poll();
                    condition.signal();
                    System.out.println("消费者消费一条任务，当前队列长度为" + queue.size());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
