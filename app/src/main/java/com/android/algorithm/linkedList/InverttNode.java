package com.android.algorithm.linkedList;

/**
 * 翻转链表
 * <p>
 * 思路：1原列表的头current ，一步步指向新 列表的头 current.next=newHead;
 * 2.current就是新的头
 * current后移.本该current=current.next,但是current.next变了,所以要先暂存current.next.
 * <p>
 * 注意：
 */
class InverttNode {
    //内部子算法中公用的变量。

    public static void main(String[] args) {
        InverttNode inverttNode = new InverttNode();
        ListNode<Integer> listNode = ListNodeUtil.arrayToList(ListNodeUtil.fullIntArr);
        ListNode result = inverttNode.inverttNode(listNode);
        ListNodeUtil.printList(result);
    }

    private ListNode inverttNode(ListNode<Integer> head) {
        //异常判断
        if (head == null || head.next == null) {
            return head;
        }
        //实现主体算法
        ListNode newHead = null;
        ListNode current = head;
        ListNode temp = null;  //用来缓存current.next。

        while (current != null) {//每个都需要挪新列表
            temp = current.next;
            current.next = newHead;
            newHead = current;  //current 变成新newhead
            current = temp;
        }

        return newHead;
    }


    private ListNode<Integer> invertList(ListNode<Integer> head) {
        if (head == null||head.next==null) {
            return head;
        }
        ListNode<Integer> newHead = null;
        ListNode<Integer> temp = null;
        ListNode<Integer> current = head;
        while (current.next != null) {
            temp = current.next;
            current.next = newHead;
            newHead = current;
            current = temp;
        }

        return newHead;

    }
}
