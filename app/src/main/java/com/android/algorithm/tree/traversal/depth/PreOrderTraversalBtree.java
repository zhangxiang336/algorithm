package com.android.algorithm.tree.traversal.depth;

import com.android.algorithm.tree.TreeNode;
import com.android.algorithm.tree.TreeNodeUtil;

import java.util.Stack;

/**
 * 非递归前序
 */
class PreOrderTraversalBtree {

    public static void main(String[] args) {
        PreOrderTraversalBtree preOrderTraversalBtree = new PreOrderTraversalBtree();
        TreeNode treeNode = TreeNodeUtil.arrayToTreeNode(TreeNodeUtil.fullIntArr);

        preOrderTraversalBtree.preOrderTraversalBtree(treeNode);
    }

    private void preOrderTraversalBtree(TreeNode treeNode1) {
        Stack<TreeNode> stack = new Stack<>();
        //异常判断
        if (treeNode1 == null) {
            return;
        }
        //实现主体算法
        TreeNode node = treeNode1;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                System.out.println(node.val);
                stack.push(node);
                node = node.left;
            }
            TreeNode popNode = stack.pop();
            node = popNode.right;
        }
    }

    private void preTraversalBTree(TreeNode<Integer> rootNode) {
        if (rootNode == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode<Integer> popNode;
        TreeNode<Integer> node = rootNode;
        while (!stack.empty() || node != null) {
            while (node != null) {
                stack.push(node);
                System.out.println(node.val);
                node = node.left;
            }
            popNode = stack.pop();
            node = popNode.right;
        }
    }
}
