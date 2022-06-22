package com.android.algorithm.bisection;

/**
 * 连续有序数字数组，找出缺失的数字
 * <p>
 * 思路：二分法，arr1[mid]  和 本来应该有的值（不缺失的情况下）对比大小
 * <p>
 * 注意:mid位置上的值,只能 等于或者大于 本应该有的值.
 */
class FindMissNumber {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 16, 17};
        int resule = findMissNumber(arr1);
        //返回的位置是确实的后一个12的位置，需要-1.
        //不是下标-1.下标-1不是缺失的数字.
        System.out.println(arr1[resule] - 1);
    }

    private static int findMissNumber(int[] arr1) {
        //异常判断
        if (arr1 == null || arr1.length == 0) {
            return -1;
        }
        //实现主体算法
        int start = 0;
        int end = arr1.length - 1;
        int ch = arr1[0];
        int mid;
        int midRealVal;
        while (start <= end) {
            mid = (start + end) / 2;
            midRealVal = mid + ch;
            if (arr1[mid] == midRealVal) {
                start = mid + 1;
            } else if (arr1[mid] > midRealVal) {
                end = mid - 1;
            }
        }
        return start;
    }

    private int findMissNub(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int midVal = 0;
        int start = 0;
        int end = arr.length - 1;
        int mid;
        while (start <= end) {
            mid = (start + end) / 2;
            midVal = arr[0] + mid;
            if (midVal == arr[mid]) {
                start = mid + 1;
            } else if (midVal < arr[mid]) {
                end = mid - 1;
            }
        }
        return arr[start] - 1;
    }
}
