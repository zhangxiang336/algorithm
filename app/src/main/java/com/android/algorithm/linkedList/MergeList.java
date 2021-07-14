package com.android.algorithm.linkedList;

/**
 * 合并两个有序列表
 * <p>
 * 思路：递归
 * <p>
 * 注意：
 */
class MergeList {
    //内部子算法中公用的变量。

    public static void main(String[] args) {
        MergeList mergeList = new MergeList();
        ListNode<Integer> listNode = ListNodeUtil.arrayToList(ListNodeUtil.fullIntArr);
        ListNode<Integer> listNode1 = ListNodeUtil.arrayToList(ListNodeUtil.fullIntArr);
        ListNode result = mergeList.mergeList(listNode, listNode1);
        ListNodeUtil.printList(result);
    }

    private ListNode mergeList(ListNode<Integer> head1, ListNode<Integer> head2) {
        //异常判断
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        //实现主体算法
        if (head1.val < head2.val) {
            head1.next=mergeList(head1.next,head2);
            return head1;
        } else  {
            head2.next=mergeList(head1,head2.next);
            return head2;
        }
    }

}
