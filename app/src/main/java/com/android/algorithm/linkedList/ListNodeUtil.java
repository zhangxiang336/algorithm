package com.android.algorithm.linkedList;

public class ListNodeUtil {

    public static Integer[] fullIntArr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
//                  1
//                2   3
//             4   5  6   7
//          8    9

    public static Integer[] bstIntArr = {20, 15, 33, 12, 18, 25, 70, 8, 14};
    //                  20
//                15   33
//             12   18  25   70
//          8    14
    public static Integer[] dupIntArr = {1, 2, 3, 4, 5, 5, 5, 5, 5, 6, 7, 8, 9, 9};
//                  20
//                15   33
//             12   18  25   70
//          8    14


    public static ListNode<Integer> arrayToList(Integer[] array) {
        ListNode pre = null;
        ListNode head = null;
        ListNode listNode;
        for (int i = 0; i < array.length; i++) {

            listNode = new ListNode(array[i]);
            if (pre != null) {
                pre.next = listNode;
            } else {
                head = listNode;
            }
            pre = listNode;

        }
        return head;
    }

    public static void printList(ListNode<Integer> list) {
        if (list == null) {
            return;
        }
        ListNode<Integer> current = list;
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
    }
}