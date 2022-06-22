package com.android.algorithm.mutiThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class SampleLock {
    private String[] arr1 = {"1", "2", "3", "4", "5"};
    private static Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public static void main(String[] args) {
        SampleLock reverseArr = new SampleLock();
        reverseArr.multiThreadInvertArr();
    }

    private void multiThreadInvertArr() {
        //异常判断
        if (arr1 == null || arr1.length == 0) {
            return;
        }
        //实现主体算法
        int threadCount = 2;
        ExecutorService executorPool = Executors.newFixedThreadPool(threadCount);
        executorPool.submit(new Worker());

    }

    class Worker implements Callable<String> {

        @Override
        public String call()  {
            //实现分算法
            return "success";
        }

    }
}
