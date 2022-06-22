package com.android.algorithm.arr;

import java.util.Arrays;

/**
 * 有序数组删除重复项
 * <p>
 * 思路：去除不符合条件的，相当于把符合条件的留下来。
 * 因为数组是固定内存地址的，对删除和添加复杂，所以是把符合条件的重拍。省下的位置置初始值。
 * <p>
 * 注意：1、不要使用固有思维：删除一个省下的移动
 * 2、如果放在一个新数组，逻辑简单，但是数组长度怎么确定？
 *
 * 实现:
 *     1,遍历数组,取值var
 *     2,指针遍历结果数组,index.
 *     3.var跟index 前面一个值对比.大于的话则放在index位置.
 */
class RemoveDumplicateArr {

    public static void main(String[] args) {
        RemoveDumplicateArr reverseArr = new RemoveDumplicateArr();
        int[] arr = {1, 2, 3, 3, 5, 6};

        reverseArr.removeDumpArr(arr);
    }

    private void removeDumpArr(int[] arr) {
        //异常判断
        if (arr == null || arr.length == 0) {
            return;
        }
        int index = 0;
        for (int val : arr) {
            if (index == 0 || arr[index - 1] < val) {
                arr[index] = val;
                index++;
            }
        }

        //后面置初始值
//        for (int i = arr.length - 1; i > index-1; i--) {
//            arr[i] = 0;
//        }
        //或者用工具类截取有效数组
        arr = Arrays.copyOf(arr, index);

        //result
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
