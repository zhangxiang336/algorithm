package com.android.algorithm.tree.traversal.breadth;

import com.android.algorithm.tree.TreeNode;
import com.android.algorithm.tree.TreeNodeUtil;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 广度遍历、层次遍历+  遍历过程中获得层次信息。
 * <p>
 * 注意：是在标准广度遍历基础上，加了一层for循环
 */
class LevelTraversalBtree {

    public static void main(String[] args) {
        LevelTraversalBtree levelTraversalBtree = new LevelTraversalBtree();
        TreeNode treeNode = TreeNodeUtil.arrayToTreeNode(TreeNodeUtil.fullIntArr);

        levelTraversalBtree.levelTraversalBtree(treeNode);
    }

    private void levelTraversalBtree(TreeNode treeNode1) {
        Queue<TreeNode> queue = new LinkedList();
        //异常判断
        if (treeNode1 == null) {
            return;
        }
        //实现主体算法
        queue.add(treeNode1);
        TreeNode node;
        int level = 0;
        while (!queue.isEmpty()) {
            //注意：
            // 1、如果每层分别处理，通过for循环一层层取，一层层加
            // 2、要提前获取length，因为queue.size()在使用过程中会变。
            int length = queue.size();
            level++;
            for (int i = 0; i < length; i++) {
                node = queue.poll();
                System.out.println("第"+level+"层:"+node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
    }
}
