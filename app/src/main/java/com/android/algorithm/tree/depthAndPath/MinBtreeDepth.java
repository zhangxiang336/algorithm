package com.android.algorithm.tree.depthAndPath;

import com.android.algorithm.tree.TreeNode;
import com.android.algorithm.tree.TreeNodeUtil;

/**
 * 二叉树最小深度
 * 思路:
 * 1、只是最大深度max，换成了min
 * 2、单独处理下，只有一个子节点情况
 */
class MinBtreeDepth {
    //内部子算法中公用的变量。

    public static void main(String[] args) {
        MinBtreeDepth minBtreeDepth = new MinBtreeDepth();
        TreeNode treeNode1 = TreeNodeUtil.arrayToTreeNode(TreeNodeUtil.fullIntArr);
        int maxDepth = minBtreeDepth.minBtreeDepth(treeNode1);
        System.out.println(maxDepth);
    }

    private int minBtreeDepth(TreeNode treeNode1) {
        //异常判断
        if (treeNode1 == null) {
            return 0;
        }
        //实现主体算法
        int depthLeft = minBtreeDepth(treeNode1.left) ;
        int depthRight = minBtreeDepth(treeNode1.right);
        //处理只有一个子节点情况
        if (treeNode1.left == null || treeNode1.right == null) {
            return depthLeft + depthRight + 1;
        }
        return Math.min(depthLeft, depthRight)+1;
    }
}
