package com.android.algorithm.tree;

/**
 *判断是否是对称二叉树
 *
 * 思路： 对比两颗树类似。对比逻辑一样，就是left对比right的。
 */

public class IsSymTree {

    public static void main(String[] args) {
        IsSymTree reverseArr = new IsSymTree();
        TreeNode<Integer> treeNode1 = TreeNodeUtil.arrayToTreeNode(TreeNodeUtil.fullIntArr);
        if (treeNode1 == null) {
            return;
        }
        boolean isSame = reverseArr.isSymTree(treeNode1.left, treeNode1.right);
        System.out.println(isSame);
    }

    private boolean isSymTree(TreeNode treeNode1, TreeNode treeNode2) {

        if (treeNode1 == null && treeNode2 == null) {
            return true;
        }
        if (treeNode1 == null || treeNode2 == null) {
            return false;
        }
        if (treeNode1.val != treeNode2.val) {
            return false;
        }

        return isSymTree(treeNode1.left, treeNode2.right) &&
                isSymTree(treeNode1.right, treeNode2.left);
    }

}
