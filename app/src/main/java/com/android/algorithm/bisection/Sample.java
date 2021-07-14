package com.android.algorithm.bisection;

/**
 * 二分法
 *
 * 注意：请使用下面固定公式。length-1 / <= / +1 -1
 */
class Sample {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 6};
        Sample sample = new Sample();
        int resule=sample.bisection(arr1, 6);
        System.out.println(resule);
    }

    private int bisection(int[] arr1, int val) {
        //异常判断
        if (arr1 == null || arr1.length == 0) {
            return -1;
        }
        //实现主体算法
        int start = 0;
        int end = arr1.length - 1;// 注意
        //左闭右闭对应下面的小于等于，以及加一减一。
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr1[mid] == val) {
                return mid;
            } else if (arr1[mid] < val) {
                start = mid + 1;
            } else if (arr1[mid] > val) {
                end = mid - 1;
            }
        }
        return -1;
    }
}
