package com.android.algorithm.tree;

/**
 * 判断两棵树是否相同
 * <p>
 * 记住：对比公式
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


    private boolean isSameTree(TreeNode<Integer> head1, TreeNode<Integer> head2) {
        if (head1 == null && head2 == null) {
            return true;
        }
        if (head1.val != head2.val) {
            return false;
        }
        return isSameTree(head1.left, head2.left) && isSameTree(head1.right, head2.right);
    }
}
