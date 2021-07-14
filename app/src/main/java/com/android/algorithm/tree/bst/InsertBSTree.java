package com.android.algorithm.tree.bst;

import com.android.algorithm.tree.TreeNode;
import com.android.algorithm.tree.TreeNodeUtil;

/**
 * 给搜索二叉树插入一个节点
 *
 * 思路：按照比较大小，往某个位置插入，
 *      如果没有才插入，如果有则再递归上面流程。
 */
class InsertBSTree {

    public static void main(String[] args) {
        InsertBSTree insertBSTree = new InsertBSTree();
        int val = 100;
        TreeNode<Integer> treeNode1 = TreeNodeUtil.arrayToTreeNode(TreeNodeUtil.bstIntArr);
        insertBSTree.insertBSTree(treeNode1, val);
    }

    private TreeNode<Integer> insertBSTree(TreeNode<Integer> treeNode1, int val) {
        if (treeNode1 == null) {
            return new TreeNode<Integer>(val);
        }
        //实现主体算法
        if (treeNode1.val > val) {
            treeNode1.left = insertBSTree(treeNode1.left, val);
        }
        if (treeNode1.val < val) {
            treeNode1.right = insertBSTree(treeNode1.right, val);
        }


//        if (treeNode1.val > val) {
//            if (treeNode1.left == null) {
//                treeNode1.left = new TreeNode(val);
//            } else {
//                insertBSTree(treeNode1.left, val);
//            }
//        }
//        if (treeNode1.val < val) {
//            if (treeNode1.right == null) {
//                treeNode1.right = new TreeNode(val);
//            } else {
//                insertBSTree(treeNode1.right, val);
//            }
//        }
        return treeNode1;
    }

}
