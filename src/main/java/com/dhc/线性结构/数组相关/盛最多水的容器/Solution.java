package com.dhc.线性结构.数组相关.盛最多水的容器;

/**
 * @author Haochen.Dai
 * @date Created in 2020/8/20 19:36
 * @description
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i,
 * ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * <p>
 * <p>
 * <p>
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * Related Topics 数组 双指针
 * 👍 1761 👎 0
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(new Solution().maxArea(nums));
    }

    /**
     * 求最大面积
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length == 0 ? 0 : height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int width = right - left;
            int h = height[left] < height[right] ? height[left++] : height[right--];
            maxArea = Math.max(h * width, maxArea);
        }
        return maxArea;
    }
}
