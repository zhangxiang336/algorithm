package com.android.algorithm.arr;

import java.util.*;

/**
 * 找出数组中重复的数字。
 * <p>
 * 示例  输入： [2, 3, 1, 0, 2, 5, 3] 输出：2 或 3
 * <p>
 * 思路：哈希表 (HashSet),哈希表的效率比迭代要好
 * <p>
 * 注意：１、
 */
class FindReapetNumber {

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 8, 3, 2};

        int resultLength = findRepeatNumber(arr);
        for (int i = 0; i < resultLength; i++) {
            System.out.println(arr[i]);
        }

    }

    public static int findRepeatNumber(int[] arrs) {
        Set<Integer> hashset = new HashSet<>();
        int index = 0;
        for (int i = 0; i < arrs.length; i++) {
            if (hashset.contains(arrs[i])) {
                arrs[index] = arrs[i];
                index++;
            }
            hashset.add(arrs[i]);
        }
        return index;
    }
}
