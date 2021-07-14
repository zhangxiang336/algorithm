package com.android.algorithm.tree.traversal.recursion;

import android.view.View;
import android.view.ViewGroup;

/**
 * 递归,遍历View树
 */
public class RecursionPreTraversalViewTree {

    public static void main(String[] args) {
        RecursionPreTraversalViewTree preOrderTraversalViewTree = new RecursionPreTraversalViewTree();
//        TreeNode treeNode = TreeNodeUtil.arrayToTreeNode(TreeNodeUtil.fullIntArr);
//
//        preOrderTraversalViewTree.preOrderTraversalViewTree(treeNode);
    }

    public void recursionPreTraversalViewTree(View rootView) {
        //异常判断
        if (rootView == null) {
            return;
        }
        //实现主体算法
        System.out.println(rootView.getClass().getSimpleName());
        if (rootView instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) rootView;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View child = viewGroup.getChildAt(i);
                recursionPreTraversalViewTree(child);
            }
        }
    }
}
