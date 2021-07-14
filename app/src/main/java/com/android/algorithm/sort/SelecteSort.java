package com.android.algorithm.sort;

/**
 * 选择排序
 * 思路：每次找最小的，找到地i个小的，和i位置交换，
 * 注意：
 * 1、只要找出length-1个小的就好，也就是循环length-1就可以。
 * 2、交换替代位移：找到地i个小的，和i位置交换，不要使用位移。
 * 特点：时间复杂度O(n²)  空间复杂度O(1)  不稳定
 */
class SelecteSort {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 8, 9, 7, 11, 10, 15, 6};
        SelecteSort selecteSort = new SelecteSort();
        selecteSort.selecteSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    private void selecteSort(int[] arr) {
        //异常判断
        if (arr == null || arr.length == 0) {
            return;
        }
        //实现主体算法
        int temp;
        int min;
        for (int i = 0; i < arr.length - 1; i++) {
            min = 0;
            //min默认从0开始，j要从i+1开始比较。
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }
}
