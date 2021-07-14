package com.android.algorithm.stackAndQueue;

import java.util.Stack;

/**
 * 括号序列
 * <p>
 * 思路：栈回溯。
 * <p>
 * 注意：
 * 当有很多可能性时，用peek来做逻辑判断后，最后在取出来
 */
class IsPairsChar {

    public static void main(String[] args) {
        String str = "{}[][][]{[]}";
        IsPairsChar isPairsChar = new IsPairsChar();
        boolean result = isPairsChar.isPairsChar(str);
        System.out.println(result);
    }

    private boolean isPairsChar(String str) {

        //异常判断
        if (str == null) {
            return false;
        }

        char[] arr = str.toCharArray();
        int length = arr.length;
        Stack<Character> stack = new Stack();

        for (int i = 0; i < length; i++) {
            //左半部分，就入栈
            if (stack.isEmpty() || arr[i] == '(' || arr[i] == '[' || arr[i] == '{') {
                stack.push(arr[i]);
                continue;
            }
            //非坐半部分，就跟栈顶的比较。比较完再取出来。
            if (arr[i] == '}' && stack.peek() != '{')
                return false;
            else if (arr[i] == ')' && stack.peek() != '(')
                return false;
            else if (arr[i] == ']' && stack.peek() != '[')
                return false;
            else if (stack.isEmpty())
                return false;
            stack.pop();
        }
        //最后
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

}
