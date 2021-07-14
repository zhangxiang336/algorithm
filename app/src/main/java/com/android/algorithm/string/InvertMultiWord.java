package com.android.algorithm.string;

import java.util.Stack;

/**
 * 翻转一句话里的单词  we air ---ew ria
 * <p>
 * 注意：1、部分翻转字符串（数组），也是在原数组上操作
 *      2、空格不翻转，所以不需要进出栈并且修改值。
 *      3。遇到空格和字符串的结束后一个，进行翻转操作，所以遍历时多遍历一个。
 */
class InvertMultiWord {

    public static void main(String[] args) {
        InvertMultiWord invertMultiWord = new InvertMultiWord();
        String str = "we are you";
        invertMultiWord.invertMultiWord(str.toCharArray());
    }

    private void invertMultiWord(char[] arr) {
        Stack<Character> stack = new Stack<>();
        //异常判断
        if (arr == null || arr.length == 0) {
            return;
        }
        for (int i = 0; i <= arr.length; i++) {
            if (i == arr.length || arr[i] == ' ') {
                while (!stack.isEmpty()) {
                    arr[i - stack.size()] = stack.pop();
                }
            }else {
                stack.push(arr[i]);
            }
        }

        //result
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
