package com.android.algorithm.mutiThread.producerAndConsumer;

import java.util.*;
import java.util.concurrent.locks.*;

/**
 * Lock+Thread实现
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
                    queue.remove();
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

    private static final int MAX = 10;
    ReentrantLock lock1 = new ReentrantLock();
    Condition condition1 = lock1.newCondition();
    Queue<Integer> queue1 = new LinkedList<>();


    class Producer1 extends Thread {
        @Override
        public void run(){

            try{
               lock1.lock();
                while(true){
                    while(queue1.size()==MAX){
                        condition1.await();
                    }
                    queue1.add(1);
                    condition1.signal();
                }

            }catch (InterruptedException e){

            }finally{
                lock1.unlock();
            }

        }
    }

    class Consumer1 extends Thread{

        @Override
        public void run(){
            while(true){
                try{
                    lock1.lock();
                    while(queue1.size()==0){
                        condition1.await();
                    }
                    queue.poll();
                    System.out.println(queue.size());
                    condition.signal();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    lock1.unlock();
                }



            }
        }

    }


}
