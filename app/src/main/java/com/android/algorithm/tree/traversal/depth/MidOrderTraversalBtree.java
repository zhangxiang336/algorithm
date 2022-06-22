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
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            TreeNode popNode = stack.pop();
            System.out.println(popNode.val);
            node = popNode.right;
        }
    }

    private void traversalMidBTree(TreeNode<Integer> rootNode) {
        if (rootNode == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode<Integer> node = rootNode;
        TreeNode popNode;
        while (!stack.empty() || node != null) {
            while (node != null) {
                //跟广度遍历不同，不提前放rootNode。广度遍历是根据取出来的判断是否要放。
                //深度遍历是根据自身判断要不要放，然后再取。
                stack.push(node);
                node = node.left;
            }
            popNode = stack.pop();
            System.out.println(popNode.val);
            node = popNode.right;
        }
    }
}
