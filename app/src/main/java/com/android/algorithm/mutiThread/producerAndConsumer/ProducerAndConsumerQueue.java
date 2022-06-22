package com.android.algorithm.mutiThread.producerAndConsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 阻塞队列实现
 *
 * 思路：利用BlockingQueue 操作的同步性
 *
 * 注意：阻塞队列同步只能保证数据，存和取是同步的。例如：存完之后再取长度，已经不准。
 */

class ProducerAndConsumerQueue {

    private BlockingQueue<Integer> queue = new LinkedBlockingQueue<Integer>(10);

    public static void main(String[] args) {
        ProducerAndConsumerQueue pc = new ProducerAndConsumerQueue();
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
                try {
                    queue.put(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //BlockingQueue内部实现线程同步，这里已经不线程同步，queue.size()的值不准。
                System.out.println("生产者生产一条任务，当前队列长度为" + queue.size());
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
                try {
                    queue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("消费者消费一条任务，当前队列长度为" + queue.size());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}