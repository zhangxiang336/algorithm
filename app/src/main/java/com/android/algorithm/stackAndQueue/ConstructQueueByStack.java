package com.android.algorithm.stackAndQueue;

import java.util.Stack;

/**
 * 用栈实现队列
 * <p>
 * 思路：1、利用两个栈，放在栈1.取的时候，把栈1的数据放到栈2。就实现了先进先出。
 *      2、
 * <p>
 * 注意：
 * 1、当有很多可能性时，用peek来做逻辑判断后，最后在
 */
class ConstructQueueByStack {

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue();
        for (int i = 0; i < 5; i++) {
            queue.add(i);
        }
        while (!queue.empty()) {
            System.out.println(queue.poll());
            System.out.println(queue.peek());
        }
    }

    static class Queue<T> {
        private Stack<T> stack1;
        private Stack<T> stack2;

        /**
         * Initialize your data structure here.
         */
        public Queue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void add(T x) {
            stack1.push(x);

        }

        public T poll() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }

        /**
         * Get the front element.
         */
        public T peek() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            if (!stack2.isEmpty()) {
                return stack2.peek();
            }
            return null;

        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return stack1.isEmpty() && stack2.isEmpty();
        }
    }

}
