package com.android.algorithm.linkedList;

/**
 * 删除值为val的元素
 * <p>
 * 思路：利用 添加虚拟head，来处理第一个问题。
 * <p>
 * 注意：
 */
class RemoeValNode {

    public static void main(String[] args) {
        RemoeValNode remoeValNode = new RemoeValNode();
        ListNode<Integer> listNode = ListNodeUtil.arrayToList(ListNodeUtil.fullIntArr);
        ListNode result = remoeValNode.remoeValNode(listNode, 5);
        ListNodeUtil.printList(result);
    }

    private ListNode remoeValNode(ListNode<Integer> head, int val) {
        //异常判断
        if (head == null) {
            return head;
        }
        //实现主体算法
        ListNode<Integer> pre = new ListNode(val-1);
        pre.next = head;
        ListNode<Integer> current = pre;
        while (current != null && current.next != null) {
            if (current.next.val == val) {
                current.next = current.next.next;
            }
            current = current.next;
        }

        return pre.next;
    }

}
