package com.android.algorithm.string;

import java.util.Stack;

/**
 * 子序问题：判断s是不是s1的子序
 * <p>
 * 注意：1、双指针 思想。
 *      2、
 *      其他方案：https://blog.csdn.net/weixin_45759791/article/details/107044136
 */
class IsSubSequence {

    public static void main(String[] args) {
        IsSubSequence isSubSequence = new IsSubSequence();
        String str = "we are you";
        String str1 = "are ";
        boolean result = isSubSequence.isSubSequence(str.toCharArray(), str1.toCharArray());
        System.out.println(result);
    }

    private boolean isSubSequence(char[] fullArr, char[] arr) {
        //异常判断
        if (arr == null || arr.length == 0 ||
                fullArr == null || fullArr.length == 0) {
            return false;
        }
        int j = 0;
        for (int i = 0; i < fullArr.length; i++) {
            if (fullArr[i] == arr[j]) {
                j++;
                if (j == arr.length) {
                    return true;
                }
            }else {
                j = 0;
            }
        }

        return false;
    }
}
