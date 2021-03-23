package com.dhc.按结构分类.线性结构.栈_队列相关.滑动窗口最大值;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author haochen.dai
 * @Date: 2020-09-26 21:03
 * @Description: 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回滑动窗口中的最大值。
 * <p>
 *  
 * <p>
 * 进阶：
 * <p>
 * 你能在线性时间复杂度内解决此题吗？
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 * <p>
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * 1 <= k <= nums.length
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {1, -1};
        int slidingWeight = 1;
        for (int i : new Solution().maxSlidingWindow(nums, slidingWeight)) {
            System.out.println(i);
        }

    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            Integer peek = deque.peek();
            // 判断队列第一个是否还在滑动窗口的范围
            if (peek != null && peek < i - k + 1) {
                deque.pollFirst();
            }

            // 判断队列尾部是否小于当前元素，小的话依次出栈
            while (deque.peek() != null && nums[deque.getLast()] < nums[i]) {
                deque.removeLast();
            }

            deque.addLast(i);

            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.getFirst()];
            }
        }
        return result;
    }

}
