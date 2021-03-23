package com.dhc.按结构分类.线性结构.数组相关.寻找两个正序数组的中位数;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Haochen.Dai
 * @date Created in 2020/8/21 10:45
 * @description 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * 则中位数是 2.0
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * 则中位数是 (2 + 3)/2 = 2.5
 * <p>
 * Related Topics 数组 二分查找 分治算法
 * 👍 3087 👎 0
 * <p>
 * <p>
 * 思路1：合并两个数组，根据新数组长度求中位数，时间复杂度 m + n
 * 思路2： 根据m+n计算出中位数的位置，然后两个指针从两个数组的头部开始走，走到对应位置
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        System.out.println(new Solution().searchMedian2(nums1, nums2));
    }

    /**
     * 思路1：合并两个数组，根据新数组长度求中位数
     * 时间复杂度 O(m+n)
     * 空间复杂度 o(m+n)
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public float searchMedian(int[] nums1, int[] nums2) {
        int numsSize = nums1.length + nums2.length;
        List<Integer> nums = new ArrayList();
        int i = 0;
        int j = 0;

        while (i < nums1.length || j < nums2.length) {
                if (i >= nums1.length) {
                    nums.add(nums2[j++]);
                } else if (j >= nums2.length) {
                    nums.add(nums1[i++]);
                } else {
                    nums.add(nums1[i] < nums2[j] ? nums1[i++] : nums2[j++]);
                }
        }


        if ((numsSize & 1) == 1) {
            return nums.get(numsSize / 2);
        } else {
            return (float)((nums.get(numsSize / 2) + nums.get(numsSize / 2 - 1))) / 2f;
        }

    }

    /**
     * 思路2：根据m+n计算出中位数的位置，然后两个指针从两个数组的头部开始走
     * @param nums1
     * @param nums2
     * @return
     */
    public float searchMedian2(int[] nums1, int[] nums2) {
        int sizeSum = nums1.length + nums2.length;
        int medianIndex1 = (sizeSum - 1) / 2;
        int medianIndex2 = sizeSum / 2;
        int median1 = 0;
        int median2 = 0;

        int i = 0;
        int j = 0;
        while (i < nums1.length || j < nums2.length) {
            int temp;
            if (i >= nums1.length) {
                temp = nums2[j++];
            } else if (j >= nums2.length) {
                temp = nums1[i++];
            } else {
                temp = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
            }
            if (i + j - 1 == medianIndex1) {
                median1 = temp;
            }
            if (i + j - 1 == medianIndex2) {
                median2 = temp;
                break;
            }
        }
        return (float)(median1 + median2) / 2f;
    }

}
