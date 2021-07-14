package com.android.algorithm.mutiThread;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 多线程翻转数组
 *
 *
 *
 */

class MultiThreadInvertArr {
    private String[] arr1 = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"
            , "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

    public static void main(String[] args) {
        MultiThreadInvertArr reverseArr = new MultiThreadInvertArr();
        reverseArr.multiThreadInvertArr();
    }

    private void multiThreadInvertArr() {
        if (arr1 == null || arr1.length == 0) {
            return;
        }
        int threadCount = 8;
        CountDownLatch latch = new CountDownLatch(threadCount);
        ExecutorService executorPool = Executors.newFixedThreadPool(threadCount);
        for (int i = 0; i < threadCount && i <= arr1.length / 2; i++) {
            executorPool.submit(new ReverseTask(latch, threadCount, i));
        }
        //不打印结果的话，不需要，是用CountDownlatch来实现线程等待。。
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < arr1.length; i++) {
            System.out.println(arr1[i]);
        }
    }

    class ReverseTask implements Callable<String> {
        private int threadNum = 0;
        private int step;
        private CountDownLatch latch;

        public ReverseTask(CountDownLatch latch, int threadCount, int num) {
            step = threadCount;
            this.latch = latch;
            threadNum = num;
        }

        @Override
        public String call() throws Exception {
            Thread.currentThread().setName("name:" + threadNum);
            reverseArr1(arr1);
            latch.countDown();
            return "success";
        }

        private void reverseArr1(String[] arr) {
            if (arr == null) {
                return;
            }
            int end = arr1.length - 1 - threadNum;
            int start = threadNum;
            while (end > start) {
                String temp = arr[end];
                arr[end] = arr[start];
                arr[start] = temp;
                start += step;
                end -= step;
            }
        }
    }
}
