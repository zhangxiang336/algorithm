package com.android.algorithm.arr;

/**
 * 最大连续1的个数
 * <p>
 * 示例  输入: [1,1,0,1,1,1] 输出: 3
 * <p>
 * 思路：因为是连续的，用记录联系每组的长度
 * <p>
 * 注意：１、
 */
class FindLengestOnes {

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 0, 1, 1};

        int i = findLengestOnes(arr);
        System.out.println(i);

    }

    public int findLengestOnes1(int[] nums) {

        int count = 0;
        int maxcount = 0;

        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 1) {
                count++;
                //这里可以改成 while
            } else {
                maxcount = Math.max(maxcount, count);
                count = 0;
            }
        }
        return Math.max(count, maxcount);

    }

    public static int findLengestOnes(int[] nums) {


        if (nums == null || nums.length == 0) {
            return 0;
        }
        int lengest = 0;
        int len = nums.length;
        int left = 0;
        int right = 0;

        while (right < len) {
            while (right < len && nums[right] == 1) {
                right++;
            }
            lengest = Math.max(lengest, right - left);
            while (right < len && nums[right] == 0) {
                right++;
            }

            left = right;

        }
        return lengest;
    }


}
