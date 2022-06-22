package com.android.algorithm.arr;

/**
 * 给你一个未排序的整数数组，请你找出其中没有出现的最小的 正整数。
 * <p>
 * 示例  输入: [1,2,0] 输出: 3    输入: [3,4,-1,1] 输出: 2
 * <p>
 * 思路：题目本省，限定了有效数据为从１开始的正整数。例如，没有１　，那结果就是１.
 * 所以：将有效正整数用过交换,放到对应ｉｎｄｅｘ上，对比缺少的数字就行了。
 * <p>
 * 注意：１、一次交换之后，有可能当前，还具备交换条件（正整数），所以是一个循环操作。
 * ２、原数组都是正整数的情况下，最大数，作为ｉｎｄｅｘ会超出数组长度。所以实际是跟跟　ｎｕｍ－１的下标交换。
 * ３、交换条件，正整数,并且不等于ｉ＋１，两个交换的数不相等，防止死循环
 */
class FindFirstMissPositive {

    public static void main(String[] args) {
        int[] arr = {1, -2, 3, 2, 5, 6};

        int i = findFirstPositive(arr);
        System.out.println(i);

    }

    public static int firstMissingPositive(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 1;
        }
        for (int i = 0; i < len; ++i) {
            //交换条件，正整数,并且不等于ｉ＋１，两个交换的数不相等，防止死循环
            while (nums[i] > 0 && nums[i] < len + 1 && nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        //遍历寻找缺失的正整数
        for (int i = 0; i < len; ++i) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return len + 1;
    }

    //交换(异或实现)
    public static void swap(int[] nums, int i, int j) {
        if (i != j) {
            nums[i] ^= nums[j];
            nums[j] ^= nums[i];
            nums[i] ^= nums[j];
        }
    }

    public static int findFirstPositive(int arr[]) {
        int len = arr.length;
        if (len == 0) {
            return 1;
        }
        for (int i = 0; i < len; i++) {
            while (arr[i] > 0 && arr[i] < len&& arr[i] != i + 1 && arr[i] != arr[arr[i] - 1]){
                swap(arr, i, arr[i] - 1);
            }
        }

        for (int i = 0; i < len; i++) {
            if (arr[i] != i + 1) {
                return i + 1;
            }
        }
        return len + 1;

    }
}
