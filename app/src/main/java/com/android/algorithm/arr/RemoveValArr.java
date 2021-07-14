package com.android.algorithm.arr;

import java.util.Arrays;

/**
 *  移除元素 nums = [3,2,2,3], val = 3。
 * <p>
 * 思路：
 * <p>
 * 注意：1、不要使用固有思维：删除一个省下的移动
 *     2、如果放在一个新数组，逻辑简单，但是数组长度怎么确定？
 */
class RemoveValArr {

    public static void main(String[] args) {
        RemoveValArr removeValArr = new RemoveValArr();
        int[] arr = {1, 2, 3, 3, 5, 6};

        removeValArr.removeValArr(arr,3);

        //result
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    private void removeValArr(int[] arr, int val1) {
        //异常判断
        if (arr == null || arr.length == 0) {
            return;
        }
        int index = 0;
        for (int val : arr) {
            if (val!= val1) {
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

    }
}
