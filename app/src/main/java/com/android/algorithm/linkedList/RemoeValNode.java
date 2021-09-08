package com.android.algorithm.linkedList;

/**
 * 删除值为val的元素(可多个)
 * <p>
 * 思路：链表删除元素,不要跟数组一样,val跟current的val比计较.因为处理起来是 pre currrent next三个的过程.
 * 所以直接用下一个 作比较current.next.val 这里是跟val比较.逻辑简单.
 *
 * 会带来一个问题:列表第一个元素符合条件的话, * 无法被处理.
 *
 * <p>
 * 注意：利用 添加虚拟head，current 这个开始处理即可.来解决删除第一个问题。
 *
 *
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
        ListNode<Integer> pre = new ListNode(val);//不是前后比,pre的赋值无所谓.
        pre.next = head;
        ListNode<Integer> current = pre;
        while (current != null && current.next != null) {
            if (current.next.val == val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return pre.next;
    }

}
