package com.android.algorithm.mutiThread;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.view.SurfaceView;
import android.view.TextureView;
import android.widget.TextView;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


class Sample {
    private String[] arr1 = {"1", "2", "3", "4", "5"};

    public static void main(String[] args) {
        Sample reverseArr = new Sample();
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
