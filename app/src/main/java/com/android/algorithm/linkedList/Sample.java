package com.android.algorithm.linkedList;

/**
 * 链表
 *
 * 思路：
 *
 * 注意：
 *
 *
 */
class Sample {
    //内部子算法中公用的变量。

    public static void main(String[] args) {
        Sample inverttNode = new Sample();
        ListNode<Integer> listNode = ListNodeUtil.arrayToList(ListNodeUtil.fullIntArr);
        ListNode result=inverttNode.inverttNode(listNode);
        System.out.println(result.val);
    }

    private ListNode inverttNode(ListNode<Integer> head) {
        //异常判断
        if (head == null || head.next == null) {
            return head;
        }
        //实现主体算法
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (fast != null&&fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

}
