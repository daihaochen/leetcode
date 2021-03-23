package com.dhc.按结构分类.线性结构.栈_队列相关.接雨水;

import java.util.Stack;

/**
 * @author haochen.dai
 * @Date: 2020-09-26 21:08
 * @Description: 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * <p>
 * <p>
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] nums1 = {4, 2, 3};
        System.out.println(new Solution().trap(nums));
    }


    public int trap(int[] height) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            // 如果栈为空，或者小于栈顶直接添加元素
            // 否则做出栈计算面积的处理
            while (!stack.empty() && height[stack.peek()] < height[i]) {
                // 维护单调递减栈，下一个值小于前一个值直接入栈
                // 大于的话，循环出栈到当前值小于栈顶,并记录出去的最后一个值
                int lastHeight = 0;
                while (!stack.isEmpty() && height[stack.peek()] <= height[i]) {
                    lastHeight = stack.pop();
                }

                if (!stack.empty()) {
                    int top = stack.peek();
                    int currentHeight = Math.min(height[top], height[i]);
                    result += (currentHeight - height[lastHeight]) * (i - top - 1);
                }
            }
            stack.push(i);
        }
        return result;
    }
}