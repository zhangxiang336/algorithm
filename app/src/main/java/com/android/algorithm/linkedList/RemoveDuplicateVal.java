package com.android.algorithm.linkedList;

/**
 * 删除重复元素
 * <p>
 * 思路：比较简单，两两比较就可以。
 * <p>
 * 注意：
 *  1、相同的第一个不删除，所以不需要造 pre。
 *  2、只有不相等的情况下，下标才往下移动
 */
class RemoveDuplicateVal {

    public static void main(String[] args) {
        RemoveDuplicateVal removeDuplicateVal = new RemoveDuplicateVal();
        ListNode<Integer> listNode = ListNodeUtil.arrayToList(ListNodeUtil.dupIntArr);
        removeDuplicateVal.removeDuplicateVal(listNode);
        ListNodeUtil.printList(listNode);
    }

    private void removeDuplicateVal(ListNode<Integer> node) {
        //异常判断
        if (node == null) {
            return;
        }
        ListNode<Integer> current = node;
        while (current != null && current.next != null) {
            if(current.val==current.next.val){
                current.next=current.next.next;
            }else {
                current=current.next;
            }
        }
    }
}
