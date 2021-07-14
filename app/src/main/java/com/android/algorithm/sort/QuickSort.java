package com.android.algorithm.sort;

/**
 * 快排
 * 思路：分支法： 找一个锚点，小的放在左边，大的放在右面，依次递归。。
 * 注意：
 * 1、快排是先整体 后部分。不能反过来，因为是一种排序的细化思想。
 * 2、
 * 特点：时间复杂度O(nlogn)  空间复杂度O(logn)  不稳定
 *
 * 总体空间复杂度即为 递归层数，最坏的空间复杂度是（o(n)此时发生了n次调用，退化成冒泡排序）
 */
class QuickSort {

    public static void main(String[] args) {
        int[] arr = {1, 2,12, 22,  3, 4, 8, 9, 7, 11, 10, 15, 6};
        QuickSort quickSort = new QuickSort();
        //从1开始？？？
        quickSort.quickSort(arr, 1, arr.length - 1);
        for (int i : arr) {
            System.out.println(i);
        }
    }


    public void quickSort(int[] arr, int start, int end) {
        if (arr.length < 1 || start < 0 || end >= arr.length || start > end) {
            return;
        }
        int point = partQuickSort(arr, start, end);
        //分段排序时候，不包括锚点
        if (point > start) {
            quickSort(arr, start, point - 1);
        }
        if (point < end) {
            quickSort(arr, point + 1, end);
        }
    }


    public  int partQuickSort(int[] arr, int start, int end) {
        //
        int mid = (start + end) / 2;
//        int mid = (int) (start + Math.random() * (end - start + 1));
        int smallIndex = start - 1;
        //为了避免锚点排序过程中变化，
        swap(arr, mid, end);
        //smallIndex其实是找到的第几个，小于arr[end]的数
        for (int i = start; i <= end; i++) {
            if (arr[i] <= arr[end]) {
                smallIndex++;
                if (i > smallIndex) {
                    swap(arr, i, smallIndex);
                }
            }
        }
        return smallIndex;
    }

    /**
     * 进行交换
     */
    public  void swap(int[] ints, int i, int j) {
        int temp = ints[i];
        ints[i] = ints[j];
        ints[j] = temp;
    }

}
