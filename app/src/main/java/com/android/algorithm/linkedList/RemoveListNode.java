package com.android.algorithm.linkedList;

/**
 * 删除元素ListNode
 * <p>
 * 思路：这种情况没办法，真正删除自己。把自己的值换成下一个的值，把next换成next.next
 * <p>
 * 注意：这是一种只知道要删除结果，不知道list本身的特殊场景。
 */
class RemoveListNode {

    public static void main(String[] args) {
        RemoveListNode removeListNode = new RemoveListNode();
        ListNode<Integer> listNode = ListNodeUtil.arrayToList(ListNodeUtil.fullIntArr);

        removeListNode.removeListNode(listNode);
        ListNodeUtil.printList(listNode);
    }

    private void removeListNode(ListNode<Integer> node) {
        //异常判断
        if (node == null) {
            return;
        }
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
