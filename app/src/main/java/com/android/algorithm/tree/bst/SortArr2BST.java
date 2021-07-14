package com.android.algorithm.tree.bst;

import com.android.algorithm.tree.TreeNode;

/**
 * 有序数组 转  搜索二叉树
 *
 * 1、创建、转二叉树，就是new TreeNode 组装的过程。
 * 2、思路：找中间节点，作为上一个的左右节点，递归实现。
 *
 */

class SortArr2BST {

    public static void main(String[] args) {
        SortArr2BST sortArr2BST = new SortArr2BST();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        sortArr2BST.sortArr2BST(arr, 0, arr.length - 1);
    }


    private TreeNode<Integer> sortArr2BST(int[] arr, int start, int end) {
        //异常判断
        if (start <= end) {
            return null;
        }
        //实现主体算法
        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(arr[mid]);
        node.left = sortArr2BST(arr, start, mid);
        node.right = sortArr2BST(arr, mid, end);
        return node;
    }

}
