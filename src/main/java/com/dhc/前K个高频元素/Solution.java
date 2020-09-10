package com.dhc.前K个高频元素;

import java.util.*;

/**
 * @author ：Haochen.Dai
 * @date ：Created in 2019/12/9 19:34
 * @description：
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 *
 * 示例 2:
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *
 * 说明：
 *
 *     你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 *     你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 *
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        long a = System.currentTimeMillis();
        System.out.println(new Solution().topKFrequent(nums, k));
        System.out.println(System.currentTimeMillis() - a);

        long b = System.currentTimeMillis();
        System.out.println(new Solution().topKFrequent1(nums, k));
        System.out.println(System.currentTimeMillis() - b);
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> map.get(o1) - map.get(o2));
        for (Integer i : map.keySet()) {
            maxHeap.add(i);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        List<Integer> list = new LinkedList<>();
        for (Integer integer : maxHeap) {
            list.add(integer);
        }
        Collections.reverse(list);
        return list;
    }

    public List<Integer> topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> list = new LinkedList<>();
        for (Integer i : map.keySet()) {
            list.add(i);
        }
        List<Integer> resultList = new LinkedList<>();
        for (int j = 0; j < k; j++) {
            int index = 0;
            int max = 0;
            for (int i = 0; i < list.size(); i++) {
                if (max < map.get(list.get(i))) {
                    max = map.get(list.get(i));
                    index = i;
                }
            }
            resultList.add(list.get(index));
            list.remove(index);
        }
        return resultList;
    }
}
