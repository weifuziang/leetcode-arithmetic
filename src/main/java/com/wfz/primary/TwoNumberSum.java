package com.wfz.primary;

import java.util.Arrays;
import java.util.HashMap;

public class TwoNumberSum {

    /*
    两数之和

    给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。

    你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。

    你可以按任意顺序返回答案。

    示例 1：

    输入：nums = [2,7,11,15], target = 9
    输出：[0,1]
    解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。

    输入：nums = [3,2,4], target = 6
    输出：[1,2]

     */

    public static void main(String[] args) {

        int[] arr = new int[]{2, 7, 11, 15};

//        System.out.println(Arrays.toString(twoNumberSum(arr, 17)));
        System.out.println(Arrays.toString(twoSum(arr, 17)));


    }

    //方法1：复杂度为n
    private static int[] twoNumberSum(int[] arr, int target) {

        //因为要返回的是，对应数组中的下表，因此可以选用map同时保存数据组的value 和index
        //同时，又可以利用map的key值，进行判断。
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {

            int other = target - arr[i]; //使用target - 数组的元素，完了判断other在不在这个数组中

            if (map.containsKey(other)) {

                return new int[]{map.get(other), i};
            }

            map.put(arr[i], i);

        }

        throw new RuntimeException("数组中不存在两数之和为: " + target);


    }

    //方法2，复杂度比较高n*n/2
    public static  int[] twoSum(int[] nums, int target) {
        for(int i =0; i < nums.length ; i++){
            for(int j =i+1; j < nums.length ; j++){
                if(nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return null;

    }
}
