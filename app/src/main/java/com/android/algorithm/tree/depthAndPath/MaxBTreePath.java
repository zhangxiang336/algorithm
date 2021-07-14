package com.android.algorithm.tree.depthAndPath;

import com.android.algorithm.tree.TreeNode;
import com.android.algorithm.tree.TreeNodeUtil;

/**
 * MinBtreeDepth
 * 思路:
 * 1、意深度和直径的关系。 一个node 的直径length=左右最大深度和-2；
 * <p>
 * 注意：
 * 不一定经过root节点；
 *
 * 跟深度区别：计算路径，必须左、右都+1，取最大。因为影响路径长度。
 *            计算深度，可以取左、右中大+1，我们只关心最大值。
 */
class MaxBTreePath {
    //内部子算法中公用的变量。

    static int max;

    public static void main(String[] args) {
        MaxBTreePath minBtreeDepth = new MaxBTreePath();
        TreeNode treeNode1 = TreeNodeUtil.arrayToTreeNode(TreeNodeUtil.fullIntArr);
        minBtreeDepth.minBtreeDepth(treeNode1);
        System.out.println(max);
    }

    private int minBtreeDepth(TreeNode treeNode1) {
        //异常判断
        if (treeNode1 == null) {
            return 0;
        }
        //实现主体算法
        int depthLeft = minBtreeDepth(treeNode1.left)+1;
        int depthRight = minBtreeDepth(treeNode1.right)+1;
        int maxlength = depthLeft + depthRight - 2;
        max = Math.max(maxlength, max);
        return Math.max(depthLeft, depthRight);
    }
}
