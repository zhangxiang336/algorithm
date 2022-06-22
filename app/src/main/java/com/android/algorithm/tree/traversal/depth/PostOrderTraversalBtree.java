package com.android.algorithm.tree.traversal.depth;

import com.android.algorithm.tree.TreeNode;
import com.android.algorithm.tree.TreeNodeUtil;
import java.util.*;

/**
 * 非递归中序
 */
class PostOrderTraversalBtree {

    public static void main(String[] args) {
        PostOrderTraversalBtree midOrderTraversalBtree = new PostOrderTraversalBtree();
        TreeNode treeNode = TreeNodeUtil.arrayToTreeNode(TreeNodeUtil.fullIntArr);

        midOrderTraversalBtree.postTraversalBTree(treeNode);
    }

    private void postOrderTraversalBtree(TreeNode treeNode1) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> resultStack = new Stack<>();
        //异常判断
        if (treeNode1 == null) {
            return;
        }
        //实现主体算法
        TreeNode node = treeNode1;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                resultStack.push(node);
                stack.push(node);
                node = node.right;
            }
            TreeNode popNode = stack.pop();
            node = popNode.left;
        }
        while (resultStack.size() != 0) {
            System.out.println(resultStack.pop().val);
        }
    }
    private void postTraversalBTree(TreeNode<Integer> rootNode){
        if(rootNode==null){
            return;
        }
        Stack<TreeNode> stack=new Stack<>();
        Stack<TreeNode> stackResult=new Stack<>();
        TreeNode<Integer> node=rootNode;
        TreeNode<Integer> popNode;
        while (node!=null||!stack.isEmpty()) {
            while (node!=null) {
                stack.add(node);
                stackResult.add(node);
                node=node.right;
            }
            popNode=stack.pop();
            node=popNode.left;
        }

        while(!stackResult.empty()){
            System.out.println(stackResult.pop().val);
        }
    }

}
