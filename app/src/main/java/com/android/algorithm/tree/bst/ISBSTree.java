package com.android.algorithm.tree.bst;

import com.android.algorithm.tree.TreeNode;
import com.android.algorithm.tree.TreeNodeUtil;

import java.util.Stack;

/**
 * 判断是否是二叉搜索树。
 * 思路：中序遍历，后一个比前一个大。
 *     判断题，找到不符合的就可以。
 *
 */
class ISBSTree {
    //指向当前最大的节点
    private TreeNode<Integer> mixNode;

    public static void main(String[] args) {
        ISBSTree isbsTree = new ISBSTree();
        TreeNode<Integer> treeNode1 = TreeNodeUtil.arrayToTreeNode(TreeNodeUtil.bstIntArr);
        boolean isBST = isbsTree.isBSTree(treeNode1);
        System.out.println(isBST);
    }

    private boolean isBSTree(TreeNode treeNode1) {
        Stack<TreeNode> stack = new Stack<>();
        //异常判断
        if (treeNode1 == null) {
            return false;
        }

        //实现主体算法
        TreeNode<Integer> node = treeNode1;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            TreeNode<Integer> temp = stack.pop();
            if (mixNode == null || temp.val > mixNode.val) {
                mixNode = temp;
            } else {
                return false;
            }
            node = temp.right;
        }
        return true;
    }

}
