package com.android.algorithm.tree.traversal.breadth;

import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 广度遍历、层次遍历View树
 *
 * getChildCount + getChildAt
 */
public class BreadthTraversalViewTree {

    public static void main(String[] args) {
        BreadthTraversalViewTree breadthTraversalViewTree = new BreadthTraversalViewTree();
        LinearLayout view = new LinearLayout(new ContextThemeWrapper());
        breadthTraversalViewTree.breadthTraversalViewTree(view);
    }

    public void breadthTraversalViewTree(View viewRoot) {
        Queue<View> queue = new LinkedList();
        //异常判断
        if (viewRoot == null) {
            return;
        }
        //实现主体算法
        queue.add(viewRoot);
        View view1;
        int conut;
        while (!queue.isEmpty()) {
            view1 = queue.poll();
            System.out.println(view1.getClass().getSimpleName());
            if (view1 instanceof ViewGroup) {
                conut = ((ViewGroup) view1).getChildCount();
                for (int j = 0; j < conut; j++) {
                    queue.add(((ViewGroup) view1).getChildAt(j));
                }
            }
        }
    }
}
