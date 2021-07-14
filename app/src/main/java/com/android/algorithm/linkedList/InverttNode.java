package com.android.algorithm.linkedList;

/**
 * 翻转链表
 *
 * 思路：是原列表的头 ，一步步指向新列表的头 current.next=pre;
 *
 * 注意：
 *
 */
class InverttNode {
    //内部子算法中公用的变量。

    public static void main(String[] args) {
        InverttNode inverttNode = new InverttNode();
        ListNode<Integer> listNode = ListNodeUtil.arrayToList(ListNodeUtil.fullIntArr);
        ListNode result=inverttNode.inverttNode(listNode);
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
        ListNode temp = null;

        while (current!=null) {
            temp= current.next;
            current.next=newHead;
            newHead=current;
            current=temp;
        }

        return newHead;
    }

}
