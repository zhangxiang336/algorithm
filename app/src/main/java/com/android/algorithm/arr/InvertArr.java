package com.android.algorithm.arr;

/**
 * 翻转数组
 *
 * 双指针：前后一个一个换
 */
class InvertArr {


    public static void main(String[] args) {
        String[] arr = {"1", "2", "3", "4", "5", "6"};
        InvertArr reverseArr = new InvertArr();
        reverseArr.multiThreadInvertArr(arr);

        //result
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    private void multiThreadInvertArr(String[] arr) {
        //异常判断
        if (arr == null || arr.length == 0) {
            return;
        }
        int start = 0;
        int end = arr.length - 1;
        String temp;
        while (start < end) {
            temp= arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }
}
