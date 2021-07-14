package com.android.algorithm;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * 算法demo
 * <p>
 * 思路：
 * <p>
 * 注意：
 */
class Sample {

    public static void main(String[] args) {
        Sample reverseArr = new Sample();
        reverseArr.multiThreadInvertArr();
    }

    private void multiThreadInvertArr() {
        int[] arr1 = {1, 2, 3, 4, 4, 4, 4, 4, 4, 5, 6};
        //异常判断
        if (arr1 == null || arr1.length == 0) {
            return;
        }
        //实现主体算法
        int threadCount = 2;
        ExecutorService executorPool = Executors.newFixedThreadPool(threadCount);
        executorPool.submit(new InsideClass());
    }

    class InsideClass implements Callable<String> {

        @Override
        public String call() throws Exception {
            //实现分算法
            return "success";
        }

    }
}
