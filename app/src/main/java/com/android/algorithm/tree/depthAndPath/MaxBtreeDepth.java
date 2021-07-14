package com.android.algorithm.tree.depthAndPath;

import com.android.algorithm.tree.TreeNode;
import com.android.algorithm.tree.TreeNodeUtil;

/**
 * 二叉树最大深度
 * 思路:
 * 1、递归一层加一
 * 2、取左右子树深度大的一个
 */
class MaxBtreeDepth {
    //内部子算法中公用的变量。

    public static void main(String[] args) {
        MaxBtreeDepth sampleBtree = new MaxBtreeDepth();
        TreeNode treeNode1 = TreeNodeUtil.arrayToTreeNode(TreeNodeUtil.fullIntArr);
        int maxDepth = sampleBtree.maxBtreeDepth(treeNode1);
        System.out.println(maxDepth);
    }

    private int maxBtreeDepth(TreeNode treeNode1) {
        //异常判断
        if (treeNode1 == null) {
            return 0;
        }
        //实现主体算法
        int depthLeft = maxBtreeDepth(treeNode1.left);
        int depthRight = maxBtreeDepth(treeNode1.right);
        return Math.max(depthLeft, depthRight)+1;
    }
}
