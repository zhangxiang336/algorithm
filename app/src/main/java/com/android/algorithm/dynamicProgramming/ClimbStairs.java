package com.android.algorithm.dynamicProgramming;

/**
 * 需要 n 阶你才能到达楼顶。每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 思路：动态规划：没有固定思路的问题，就找规律，子规律。
 * <p>
 * 注意：前两在任何情况向都要赋值（n>2的情况）
 */
class ClimbStairs {

    public static void main(String[] args) {
        ClimbStairs climbStairs = new ClimbStairs();

        int n = climbStairs.climbStairs(5);
        System.out.println(n);
    }

    private int climbStairs(int n) {
        int[] dpResult = new int[n];//
        //异常判断
        if (n == 1) {
            return 1;
        }
        dpResult[0] = 1;//注意：不管n等于几都要赋值。
        dpResult[1] = 2;

        for (int i = 2; i < n; i++) {
            dpResult[i] = dpResult[i - 1] + dpResult[i - 2];
        }
        return dpResult[n - 1];//长度是n的，最后一个下标是n-1.
    }


    private int climbStairs1(int n) {
        int[] result = new int[n];
        if (n == 0 || n == 1) {
            return n;
        }
        result[0] = 1;
        result[1] = 2;
        for (int i = 2; i < n; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result[n - 1];
    }

}
