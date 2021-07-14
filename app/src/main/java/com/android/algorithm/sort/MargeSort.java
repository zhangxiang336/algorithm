package com.android.algorithm.sort;

import java.util.Arrays;

/**
 * 归并排序
 * 思路：分支法： 先分成小段，段内排序，然后再段和段排序。
 * 注意：
 * 1、排序方式是先部分 后整体。不能反过来，因为整体排序过程是基于子排序的结果进行的。
 *
 * 特点：时间复杂度O(nlogn)  空间复杂度O(n)  不稳定
 */
class MargeSort {

    public static void main(String[] args) {
        int[] arr = {1, 2, 12, 22, 3, 4, 8, 9, 7, 11, 10, 15, 6};
        MargeSort margeSort = new MargeSort();
        int[] result= margeSort.mergeSort(arr);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public int[] mergeSort(int[] ints) {
        //递归退出条件
        if (ints.length <= 1) {
            return ints;
        }
        int mid = ints.length / 2;
        int[] left = Arrays.copyOfRange(ints, 0, mid);
        int[] right = Arrays.copyOfRange(ints, mid, ints.length);
        //递归来实现分支，对分制后的数据处理。
        return merge(mergeSort(left), mergeSort(right));
    }

    public int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        //两部分分别对比，插入结果。
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            //处理 一部分已经处理结束的情况。
            if (i >= left.length) {
                result[index] = right[j++];
            } else if (j >= right.length) {
                result[index] = left[i++];
            } else if (left[i] > right[j]) {
                result[index] = right[j++];
            } else {
                result[index] = left[i++];
            }
        }
        return result;
    }
}
