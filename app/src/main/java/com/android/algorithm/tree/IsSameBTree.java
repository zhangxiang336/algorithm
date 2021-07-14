package com.android.algorithm.tree;

/**
 *判断两棵树是否相同
 *
 *记住：对比公式
 */

public class IsSameBTree {

    public static void main(String[] args) {
        IsSameBTree reverseArr = new IsSameBTree();
        TreeNode<Integer> treeNode1 = TreeNodeUtil.arrayToTreeNode(TreeNodeUtil.fullIntArr);
        TreeNode<Integer> treeNode2 = TreeNodeUtil.arrayToTreeNode(TreeNodeUtil.fullIntArr);
        boolean isSame = reverseArr.sameBTree(treeNode1, treeNode2);
        System.out.println(isSame);
    }

    private boolean sameBTree(TreeNode treeNode1, TreeNode treeNode2) {
        //两个节点对比对比的逻辑：公式
        if (treeNode1 == null && treeNode2 == null) {
            return true;
        }
        if (treeNode1 == null || treeNode2 == null) {
            return false;
        }
        if (treeNode1.val != treeNode2.val) {
            return false;
        }

        return sameBTree(treeNode1.left, treeNode2.left) &&
                sameBTree(treeNode1.right, treeNode2.right);
    }


}
