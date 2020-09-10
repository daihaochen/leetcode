package com.dhc.求众数;

import java.util.List;

/**
 * User: Haochen.Dai
 * Date: 2019-12-29 23:16
 * Description:
 * 给定一个大小为 n 的数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 *
 * 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1)。
 */
/*
public class Solution {

    public List<Integer> majorityElement(List<Integer> nums) {
        int size = nums.size();
        vector<int> res;
        if (size == 0) {
            return res;
        }
        sort(nums.begin(), nums.end());
        int c = 1, m = nums[0];
        for (int i = 1; i < size; ++i) {
            if (nums[i] == m) {
                ++c;
            } else {
                if (c > (size / 3)) {
                    res.push_back(m);
                }
                c = 1;
                m = nums[i];
            }
        }
        if (c > (size / 3)) {
            res.push_back(m);
        }
        return res;
    }

}
*/

