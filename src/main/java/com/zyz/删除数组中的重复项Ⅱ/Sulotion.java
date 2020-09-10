package com.zyz.删除数组中的重复项Ⅱ;

import java.util.Arrays;

/**
 *
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的
 *
 * 给定 nums = [1,1,1,2
 * 函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2,
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 *
 * 给定 nums = [0,0,1,1,1,1,2,3,3],
 *
 * 函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。
 */

public class Sulotion {
    public static void main(String[] args) {
        int []nums={1,1,1,1,1,1,1,2,2,2,2,3,4,5,5,5,6};
        removeDuplicates(nums,2);
        System.out.println(Arrays.toString(nums));
    }
    private static int removeDuplicates(int[] nums,int k){
        if(nums.length<0 ||nums==null){
            return 0;
        }
        if(nums.length<k){
           return nums.length;
        }
        int index=k-1;
        for(int i=k;i<nums.length;i++){
            if(nums[i]!=nums[index-k+1]){
                index++;
                nums[index]=nums[i];
            }
        }
        System.out.println(index+1);
        return index+1;
    }
}
