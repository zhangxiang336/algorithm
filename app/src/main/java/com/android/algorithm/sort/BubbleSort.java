package com.android.algorithm.sort;

/**
 * 冒泡排序
 * 思路：依次比较大的往后冒泡（交换）
 * 注意：
 * 1、只要找出length-1个大的就好，也就是循环length-1就可以。
 * 2、
 * 特点：时间复杂度O(n²)  空间复杂度O(1)  稳定
 */
class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 8, 9, 7, 11, 10, 15, 6};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bubbleSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    private void bubbleSort(int[] arr) {
        //异常判断
        if (arr == null || arr.length == 0) {
            return;
        }
        //实现主体算法

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                //j我要大，我就和后面的交换
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    /**
     * 进行交换
     */
    public void swap(int[] ints, int i, int j) {
        int temp = ints[i];
        ints[i] = ints[j];
        ints[j] = temp;
    }

    private void bubbleSort1(int[] arr) {//数组也是传的引用，没有新数组的话，不需要单独返回，
        if (arr == null || arr.length == 0) {
            return;
        }
        int length = arr.length;
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < length - i; j++) {//j一定要从0开始。
                if (arr[j] > arr[j + 1]) {
                    swap1(arr, j, j + 1);
                }
            }
        }
    }

    private void swap1(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
