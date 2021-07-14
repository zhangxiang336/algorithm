package com.android.algorithm.tree.traversal.depth;

import com.android.algorithm.tree.TreeNode;
import com.android.algorithm.tree.TreeNodeUtil;

import java.util.Stack;

/**
 * 非递归中序
 */
class MidOrderTraversalBtree {

    public static void main(String[] args) {
        MidOrderTraversalBtree midOrderTraversalBtree = new MidOrderTraversalBtree();
        TreeNode treeNode = TreeNodeUtil.arrayToTreeNode(TreeNodeUtil.fullIntArr);

        midOrderTraversalBtree.midOrderTraversalBtree(treeNode);
    }

    private void midOrderTraversalBtree(TreeNode treeNode1) {
        Stack<TreeNode> stack = new Stack<>();
        //异常判断
        if (treeNode1 == null) {
            return;
        }
        //实现主体算法
        TreeNode node = treeNode1;
        while (node!=null||!stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            TreeNode popNode = stack.pop();
            System.out.println(popNode.val);
            node = popNode.right;
        }
    }
}
