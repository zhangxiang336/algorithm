package com.android.algorithm.tree;

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
    //内部子算法中公用的变量。

    public static void main(String[] args) {
        Sample sampleBtree = new Sample();
        TreeNode treeNode1 = TreeNodeUtil.arrayToTreeNode(TreeNodeUtil.fullIntArr);
        sampleBtree.multiThreadInvertArr(treeNode1);
    }

    private void multiThreadInvertArr(TreeNode treeNode1) {
        //异常判断
        if (treeNode1 == null) {
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
