package com.android.algorithm.tree;

/**
 * 翻转二叉树
 * <p>
 * 思路：从上到下，左右交换。
 * 上层左右交换后，就已经实现了对称。下层左右交换就可以。
 * <p>
 * 注意：
 * 1、交换时，不用考虑是否为null，为null交换后符合要求。
 */

class InvertBtree {

    public static void main(String[] args) {
        InvertBtree invertBtree = new InvertBtree();
        TreeNode<Integer> treeNode1 = TreeNodeUtil.arrayToTreeNode(TreeNodeUtil.fullIntArr);
        invertBtree.invertBtree(treeNode1);
    }

    private void invertBtree(TreeNode<Integer> treeNode1) {
        //异常判断
        if (treeNode1 == null) {
            return;
        }
        //实现主体算法
        TreeNode<Integer> temp = treeNode1.left;
        treeNode1.left = treeNode1.right;
        treeNode1.right = temp;
        invertBtree(treeNode1.left);
        invertBtree(treeNode1.right);
    }

    private void invertBTree1(TreeNode<Integer> head) {
        if (head == null) {
            return;
        }

        TreeNode<Integer> temp = head.left;
        head.left = head.right;
        head.right = temp;
        invertBTree1(head.left);
        invertBTree1(head.right);
    }
}
