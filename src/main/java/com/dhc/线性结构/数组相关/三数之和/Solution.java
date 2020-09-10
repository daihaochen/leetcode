package com.dhc.线性结构.数组相关.三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author haochen.dai
 * @Date: 2020-08-22 23:07
 * @Description:
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *  
 *
 * 示例：
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * 自己思路：从第一个数开始选定，需要在剩下的数中找到两个数相加为相反数，所以判断一个数需要3次遍历，时间复杂度为 O（n^3）
 *
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        new Solution().summationThree(nums).stream().forEach(num -> System.out.println(num));
    }


    /**
     * 时间只超过26%的人，为啥？？？？？
     * @param nums
     * @return
     */
    public List<List<Integer>> summationThree(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        //com.dhc.排序算法.快速排序.Sulotion.quickSort(0, nums.length - 1, nums);
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int target = -nums[i];
            if (target < 0) {
                break;
            }
            // 如果与上一个数相同，就直接跳过
            if (i == 0 || nums[i] != nums[i - 1]) {
                int p = i + 1;
                int q = nums.length - 1;
                // 保证第二个数在第三个数前，同时保证第二个数不会取重复的数，那么就能保证结果集里不重复
                while (p < q) {
                    // 保证第二个数不会取重复的数
                    if (p > i + 1 && nums[p] == nums[p - 1]) {
                        p++;
                        continue;
                    }
                    int current = nums[p] + nums[q];
                    // 相等代表找到我们想要的结果集，添加
                    if (current == target) {
                        result.add(Arrays.asList(nums[i], nums[p], nums[q]));
                        p++;
                        continue;
                    // 小于目标值，由于当前q是尾指针，无法右移使当前值加大，所以只能让p右移
                    } else if (current < target) {
                        p++;
                        continue;
                    // 大于目标值，左移q使得current减小
                    } else {
                        q--;
                        continue;
                    }
                }
            }
        }
        return result;
    }
}
