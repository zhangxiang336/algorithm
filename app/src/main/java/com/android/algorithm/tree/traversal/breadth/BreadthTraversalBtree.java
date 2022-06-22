package com.android.algorithm.tree.traversal.breadth;

import com.android.algorithm.tree.TreeNode;
import com.android.algorithm.tree.TreeNodeUtil;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 广度遍历
 */
class BreadthTraversalBtree {

    public static void main(String[] args) {
        BreadthTraversalBtree breadthTraversalBtree = new BreadthTraversalBtree();
        TreeNode treeNode = TreeNodeUtil.arrayToTreeNode(TreeNodeUtil.fullIntArr);

        breadthTraversalBtree.breadthTraversalBtree(treeNode);
    }

    private void breadthTraversalBtree(TreeNode treeNode1) {
        Queue<TreeNode> queue = new LinkedList();
        //异常判断
        if (treeNode1 == null) {
            return;
        }
        //实现主体算法
        queue.add(treeNode1);
        TreeNode node;
        while (!queue.isEmpty()) {
            node = queue.poll();
            System.out.println(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    private void traversal(TreeNode<Integer> node) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (node == null) {
            return;
        }
        queue.add(node);
        TreeNode<Integer> node1;
        while (!queue.isEmpty()) {
            node1 = queue.poll();
            System.out.println(node1.val);
            if (node1.left != null) {
                queue.add(node1.left);
            }
            if (node1.right != null) {
                queue.add(node1.right);
            }
        }
    }
}
