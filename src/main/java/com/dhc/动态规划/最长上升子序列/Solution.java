package com.dhc.动态规划.最长上升子序列;

/**
 * @author ：Haochen.Dai
 * @date ：Created in 2019/11/26 20:52
 * @description：
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 *
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 *
 * 说明:
 *
 *     可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 *     你算法的时间复杂度应该为 O(n2) 。
 *
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 *
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
//        System.out.println(new Solution().lengthOfLIS(nums));
        System.out.println(new Solution().dynamicProgram(nums));
    }

    public int lengthOfLIS(int[] nums) {
        return recursion(nums, Integer.MIN_VALUE, 0);
    }

    /**
     * 递归（超时答案）
     * @param nums
     * @param lastNum
     * @param currentIndex
     * @return
     */
    public int recursion(int[] nums, int lastNum, int currentIndex) {
        if (currentIndex == nums.length) {
            return 0;
        }
        int addThisNumLength = 0;
        if (nums[currentIndex] > lastNum) {
            addThisNumLength = recursion(nums, nums[currentIndex], currentIndex + 1) + 1;
        }
        int notAddThisNumLength = recursion(nums, lastNum, currentIndex + 1);
        return Math.max(addThisNumLength, notAddThisNumLength);
    }

    /**
     * 优化递归，用数组记录中间的计算结果
     * @param nums
     * @param lastNum
     * @param currentIndex
     * @return
     */
    public int recursionOptimization(int[] nums, int lastNum, int currentIndex) {
        if (currentIndex == nums.length) {
            return 0;
        }
        int addThisNumLength = 0;
        if (nums[currentIndex] > lastNum) {
            addThisNumLength = recursion(nums, nums[currentIndex], currentIndex + 1) + 1;
        }
        int notAddThisNumLength = recursion(nums, lastNum, currentIndex + 1);
        return Math.max(addThisNumLength, notAddThisNumLength);
    }

    public int dynamicProgram(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int maxDp = 0;
        int[] dp = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int maxLength = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]){
                    maxLength = Math.max(dp[j] + 1, maxLength);
                }
            }
            dp[i] = maxLength;
            maxDp = Math.max(maxLength, maxDp);
        }
        return maxDp;
    }

}
