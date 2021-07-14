package com.android.algorithm.bisection;

/**
 * 连续数字数组，找出缺失的数字
 * <p>
 * 注意：二分法，对比的值为arr1[mid]本来应该有的值（不缺失的情况下）
 */
class FindMissNumber {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 16, 17};
        FindMissNumber findMissNumber = new FindMissNumber();
        int resule = findMissNumber.findMissNumber(arr1);
        //返回的位置是确实的后一个12，需要-1
        System.out.println(arr1[resule] - 1);
    }

    private int findMissNumber(int[] arr1) {
        //异常判断
        if (arr1 == null || arr1.length == 0) {
            return -1;
        }
        //实现主体算法
        int start = 0;
        int end = arr1.length - 1;// 注意
        int ch = arr1[0];
        int mid;
        int midRealVal;
        while (start <= end) {
            mid = (start + end) / 2;
            midRealVal= mid + ch;
            if (arr1[mid] == midRealVal) {
                start = mid + 1;
            } else if (arr1[mid] > midRealVal) {
                end = mid - 1;
            }
        }
        return start;
    }
}
