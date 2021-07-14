package com.android.algorithm.tree.balanceTree;

import com.android.algorithm.tree.TreeNode;
import com.android.algorithm.tree.TreeNodeUtil;

/**
 * 判断是否是平衡二叉树
 * <p>
 * 思路：
 * 1、平衡问题====深度问题，
 * 2、是在计算最大深度过程中间过程的判断，因为平衡，包括子树。
 * <p>
 * 注意：虽然是判断题，但是深度计算过程中判断，返回值是int，不是boolean
 */
class IsBalanceTree {
    public  boolean isBalanceTree = true;

    public static void main(String[] args) {
        IsBalanceTree isBTree = new IsBalanceTree();
        TreeNode treeNode1 = TreeNodeUtil.arrayToTreeNode(TreeNodeUtil.fullIntArr);
        isBTree.isBalanceTree(treeNode1);
        System.out.println(isBTree.isBalanceTree);
    }

    private int isBalanceTree(TreeNode treeNode1) {
        //异常判断
        if (treeNode1 == null) {
            return 0;
        }
        //实现主体算法
        int left = isBalanceTree(treeNode1.left);
        int right = isBalanceTree(treeNode1.right);
        if (Math.abs(left - right) > 1) {
            isBalanceTree = false;
        }
        return Math.max(left, right)+1;
    }

}
