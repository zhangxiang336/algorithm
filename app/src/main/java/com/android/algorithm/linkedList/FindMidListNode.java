package com.android.algorithm.linkedList;

/**
 * 找链表中点。
 *
 * 思路：快慢指针思想。
 *
 * 注意：
 * 只有基础的 ListNoe head。不是用现成的LinkedList。跟数组不同。
 *
 */
class FindMidListNode {
    //内部子算法中公用的变量。

    public static void main(String[] args) {
        FindMidListNode findMidListNode = new FindMidListNode();
        ListNode<Integer> listNode = ListNodeUtil.arrayToList(ListNodeUtil.fullIntArr);
        ListNode result=findMidListNode.findMidListNode(listNode);
        System.out.println(result.val);
    }

    private ListNode findMidListNode(ListNode<Integer> head) {
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
