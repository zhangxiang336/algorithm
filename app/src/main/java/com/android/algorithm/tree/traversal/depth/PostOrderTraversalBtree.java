package com.android.algorithm.tree.traversal.depth;

/**
 * 非递归中序
 */
class PostOrderTraversalBtree {

//    public static void main(String[] args) {
//        PostOrderTraversalBtree midOrderTraversalBtree = new PostOrderTraversalBtree();
//        TreeNode treeNode = TreeNodeUtil.arrayToTreeNode(TreeNodeUtil.fullIntArr);
//
//        midOrderTraversalBtree.postOrderTraversalBtree(treeNode);
//    }
//
//    private void postOrderTraversalBtree(TreeNode treeNode1) {
//        Stack<TreeNode> stack = new Stack<>();
//        Stack<TreeNode> resultStack = new Stack<>();
//        //异常判断
//        if (treeNode1 == null) {
//            return;
//        }
//        //实现主体算法
//        TreeNode node = treeNode1;
//        while (node != null || !stack.isEmpty()) {
//            while (node != null) {
//                resultStack.push(node);
//                stack.push(node);
//                node = node.right;
//            }
//            TreeNode popNode = stack.pop();
//            node = popNode.left;
//        }
//        while (resultStack.size() != 0) {
//            System.out.println(resultStack.pop().val);
//        }
//    }


    public static void main(String[] args) throws InterruptedException {
        NoVisibility_Demonstration t = new NoVisibility_Demonstration();
        t.start();
        t.thread = Thread.currentThread();
        System.out.println("start: " + t.keepRunning);
        Thread.sleep(1000);
        t.keepRunning = false;
        Thread.sleep(1000);
        System.out.println("keepRunning " + t.keepRunning);
        t.keepRunning2 = false;
        System.out.println("end: keepRunning2:" + t.keepRunning2);
    }

    static class NoVisibility_Demonstration extends Thread {
        boolean keepRunning = true;
        boolean keepRunning2 = true;
        Thread thread;

        public void run() {
            try {
                int x = 1;
                while (keepRunning) {
//                    System.out.println("如果你不注释这一行，程序会正常停止！");
                    thread.join();
                    x++;

                }
                System.out.println("finish:" + x);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
