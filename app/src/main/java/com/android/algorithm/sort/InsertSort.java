package com.android.algorithm.sort;

/**
 * 插入排序
 * 思路：操作第i，保证i插入到排好序的位置。
 * 注意：
 * 1、尝试插入是从第二个开始，所以i从1开始。但总数还是length-1
 * 2、位移需要位移的部分。
 * 特点：时间复杂度O(n²)  空间复杂度O(1)  不稳定
 */
class InsertSort {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 8, 9, 7, 11, 10, 15, 6};
        InsertSort insertSort = new InsertSort();
        insertSort.insertSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    private void insertSort(int[] arr) {
        //异常判断
        if (arr == null || arr.length == 0) {
            return;
        }
        //实现主体算法
        int temp;
        int j;
        for (int i = 1; i < arr.length; i++) {
            //先暂存你下，再给你找个合适的位置(在排序好的位置找)
            temp = arr[i];
            j = i;
            // &&条件控制需要移动的位置。
            while (j - 1 > 0 && arr[j - 1] > temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }


    private void insertSort1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int j;
        int current;
        for (int i = 1; i < arr.length; i++) {
            j = i;
            current = arr[i];
            while (j - 1 > 0 && arr[j - 1] > current) {//永远是跟current比较，不是前后比较。
                arr[j] = arr[j - 1];
                j--;
                continue;
            }
            arr[j] = current;
        }
    }
}
