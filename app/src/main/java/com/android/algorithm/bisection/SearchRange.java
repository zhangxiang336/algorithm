package com.android.algorithm.bisection;

/**
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 * 思路：思路跟有序数组插入位置相同：
 * 1、开始位置=计算左侧插入位置
 * 2、结束位置=右侧插入位置-1
 * 注意：判断边界问题。
 */
class SearchRange {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 4, 4, 4, 4, 4, 5, 6};
        SearchRange searchRange = new SearchRange();
        int[] resule = searchRange.searchRange(arr1, 4);
        for (int i : resule) {
            System.out.println(i);
        }
    }

    private int[] searchRange(int[] arr1, int val) {
        //异常判断
        if (arr1 == null || arr1.length == 0) {
            return null;
        }
        int[] result = new int[2];

        //实现主体算法
        int start = 0;
        int end = arr1.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr1[mid] == val) {
                end = mid - 1;
            } else if (arr1[mid] < val) {
                start = mid + 1;
            } else if (arr1[mid] > val) {
                end = mid - 1;
            }
        }
        //排除边界问题
        if (start != arr1.length) {
            result[0] = start;
        }

        start = 0;
        end = arr1.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr1[mid] == val) {
                start = mid + 1;
            } else if (arr1[mid] < val) {
                start = mid + 1;
            } else if (arr1[mid] > val) {
                end = mid - 1;
            }
        }
        //排除边界问题
        if (start != 0) {
            result[1] = start - 1;
        }
        return result;
    }
}
