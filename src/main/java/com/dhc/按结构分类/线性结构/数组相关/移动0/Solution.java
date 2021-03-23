package com.dhc.按结构分类.线性结构.数组相关.移动0;

import java.util.Arrays;

/**
 * @author haochen.dai
 * @Date: 2020-08-17 23:31
 * @Description:
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 * 思路：双指针
 *
 */
public class Solution {

    public static void main(String[] args) {
        int[] ints = {0, 1, 0, 3, 12};
        new Solution().moveZeroes(ints);
        Arrays.stream(ints).forEach(i -> System.out.println(i));
    }

    public void moveZeroes(int[] nums) {
        int notZeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[notZeroIndex++] = nums[i];
            }
        }
        for (int i = notZeroIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
