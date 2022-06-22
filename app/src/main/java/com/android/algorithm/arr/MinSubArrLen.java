package com.android.algorithm.arr;

import java.util.HashSet;
import java.util.Set;

/**
 * 长度最小的子数组
 * <p>
 * 示例  输入：s = 7, nums = [2,3,1,2,4,3] 输出：2
 * <p>
 * 思路：滑动窗口：就是通过不断调节子数组的起始位置和终止位置，进而得到我们想要的结果，滑动窗口也是双指针的一种。
 *
 * <p>
 * 注意：１、迭代的是窗口末端
 */
class MinSubArrLen {

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 1, 2, 2};
        int sum = 5;

        int resultLength = minSubArrayLen(arr, sum);
        System.out.println(resultLength);

    }

    public static int minSubArrayLen(int[] nums,int s) {

        int len = nums.length;
        int windowlen = Integer.MAX_VALUE;
        int start = 0;
        int sum = 0;
        for (int end = 0; end < len; end++) {
            sum += nums[end];
            while (sum >= s) {
                windowlen = Math.min(windowlen, end - start + 1);
                sum -= nums[start];
                start++;
            }
        }
        return windowlen == Integer.MAX_VALUE ? 0 : windowlen;

    }

}
