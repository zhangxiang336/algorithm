package com.android.algorithm.arr;

import java.util.*;

/**
 *  在整数数组 nums 找和为 target的两个数。nums = [2, 7, 11, 15], target = 9  。所以返回 [0, 1]
 *
 * <p>
 * 思路：
 * <p>
 * 注意：
 */
class TowSum {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 5, 6};

        int[] result= twoSum(arr,9);

        //result
        for (int i = 0; i < result.length; i++) {
            System.out.println(arr[result[i]]);
        }
    }

    private static int[] twoSum(int[] nums, int target) {
        if(nums.length < 2){
            return new int[0];
        }
        int[] rearr = new int[2];
        //查询元素
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++ ){
                //发现符合条件情况
                if(nums[i] + nums[j] ==target){
                    rearr[0] = i;
                    rearr[1] = j;
                }
            }
        }
        return rearr;
    }

    public int[] twoSum1(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++){
            //如果存在则返回
            if(map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }
            //不存在则存入
            map.put(nums[i],i);

        }
        return new int[0];

    }
}
