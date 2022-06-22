package com.android.algorithm.arr;

/**
 * 和最大的最短子数组
 * <p>
 * 示例  输入：{1, -1, 2, 1, -2, 2,-1,3}  输出：5  , 以及范围　２到７
 * https://zhuanlan.zhihu.com/p/144385162
 * <p>
 * 思路：多层迭代暴力解法
 * 　　　分治法
 * 　　　动态规划:dp[i]  为原数组　ｉ项的数量和最大值。 dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
 *
 * <p>
 * 注意：１、本题不适用常规的　窗口移动方案
 */
class MaxSubArrs {

    public static void main(String[] args) {
        int[] arr = {1, -1, 2, 1, -2, 2, -1, 3, -1, 2};

        int resultLength = maxSubArray(arr);
        System.out.println(resultLength);

    }

    public static int maxSubArray(int[] nums) {

        int n = nums.length;
        if (n == 0) return 0;
        int[] dp = new int[n];
        // base case
        // 第一个元素前面没有子数组
        dp[0] = nums[0];
        // 状态转移方程
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
        }
        // 得到 nums 的最大子数组
        int res = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;
        for (int i = 0; i < n; i++) {
            System.out.print(dp[i]+",");
            if (dp[i] > res) {
                res = dp[i];
                end = i;
            }
            res = Math.max(res, dp[i]);
        }

        for (int i = 0; i <= end; i++) {
            if (dp[i] <= 0) {
                start = i + 1;
            }
        }
        System.out.println("start=" + start + "  end=" + end);
        return res;

    }

}
