package com.android.algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 86137
 * Create at 2021/3/3.
 */
public class TreeNodeUtil {
    public static Integer[] intArr = {2, null, 4, 9, 8, null, null, 4};

//              2
//                   4
//                9     8
//                     4

    public static Integer[] fullIntArr = {1,2,3,4,5,6,7,8,9};
//                  1
//                2   3
//             4   5  6   7
//          8    9

    public static Integer[] bstIntArr = {20,15,33,12,18,25,70,8,14};
//                  20
//                15   33
//             12   18  25   70
//          8    14


    public static TreeNode arrayToTreeNode(Integer[] array) {
        if (array.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(array[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isLeft = true;
        for (int i = 1; i < array.length; i++) {
            TreeNode node = queue.peek();
            if (isLeft) {
                if (array[i] != null) {
                    node.left = new TreeNode(array[i]);
                    queue.offer(node.left);
                }
                isLeft = false;
            } else {
                if (array[i] != null) {
                    node.right = new TreeNode(array[i]);
                    queue.offer(node.right);
                }
                queue.poll();
                isLeft = true;
            }
        }
        return root;
    }
}