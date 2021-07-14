package com.android.algorithm.tree.traversal.depth;

import android.view.View;
import android.view.ViewGroup;

import com.android.algorithm.tree.TreeNode;

import java.util.Stack;

import dalvik.system.DexClassLoader;

/**
 * 非递归,前序，遍历View树
 *  深度遍历
 *
 *  （前序）-------哪头放就哪头出，并且要倒序放？？？树是不是没有前中后之分了，因为没有左右之分，
 */
public class DepthTraversalViewTree {

    public static void main(String[] args) {
        DepthTraversalViewTree depthTraversalViewTree = new DepthTraversalViewTree();
//        TreeNode treeNode = TreeNodeUtil.arrayToTreeNode(TreeNodeUtil.fullIntArr);
//
//        preOrderTraversalViewTree.preOrderTraversalViewTree(treeNode);
    }

    public void depthTraversalViewTree(View view) {
        Stack<View> stack = new Stack<>();
        //异常判断
        if (view == null) {
            return;
        }
        //实现主体算法
        stack.push(view);
        View temp;
        while (!stack.isEmpty()) {
           temp=stack.pop();
            System.out.println(temp.getClass().getSimpleName());
            if(temp instanceof ViewGroup){
               int count=((ViewGroup)temp).getChildCount();
               for (int i = count-1; i >=0; i--) {
                   stack.push(((ViewGroup)temp).getChildAt(i));
               }
           }
        }
    }
}
