package com.android.algorithm.mutiThread.producerAndConsumer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 86137
 * Create at 2021/2/24.
 */

class ProducerAndConsumerSyn {

    private final int MAX_LEN = 10;
    private Queue<Integer> queue = new LinkedList<Integer>();

    public static void main(String[] args) {
        ProducerAndConsumerSyn pc = new ProducerAndConsumerSyn();
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
            while(true) {
                synchronized (queue) {
                    while (queue.size() == MAX_LEN) {
                        System.out.println("当前队列满");
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    queue.add(1);
                    queue.notify();
                    System.out.println("生产者生产一条任务，当前队列长度为" + queue.size());
                }
                try {
                    Thread.sleep(50);
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
                synchronized (queue) {
                    while (queue.size() == 0) {
                        System.out.println("当前队列为空");
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    queue.poll();
                    queue.notify();
                    System.out.println("消费者消费一条任务，当前队列长度为" + queue.size());
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}