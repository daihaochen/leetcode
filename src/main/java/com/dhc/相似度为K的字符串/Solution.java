package com.dhc.相似度为K的字符串;

import java.util.ArrayList;

/**
 * @author ：Haochen.Dai
 * @date ：Created in 2019/11/26 16:17
 * @description：
 * 如果可以通过将 A 中的两个小写字母精确地交换位置 K 次得到与 B 相等的字符串，我们称字符串 A 和 B 的相似度为 K（K 为非负整数）。
 * 给定两个字母异位词 A 和 B ，返回 A 和 B 的相似度 K 的最小值。
 *
 * 示例 1：
 *
 * 输入：A = "ab", B = "ba"
 * 输出：1
 *
 * 示例 2：
 *
 * 输入：A = "abc", B = "bca"
 * 输出：2
 *
 * 示例 3：
 *
 * 输入：A = "abac", B = "baca"
 * 输出：2
 *
 * 示例 4：
 *
 * 输入：A = "aabc", B = "abca"
 * 输出：2
 *
 *
 *
 * 提示：
 *
 *     1 <= A.length == B.length <= 20
 *     A 和 B 只包含集合 {'a', 'b', 'c', 'd', 'e', 'f'} 中的小写字母。
 *
 */
public class Solution {
    public static void main(String[] args) {
        //TODO 深度优先搜索
        System.out.println(new Solution().kSimilarity("ab", "ba"));//1
        System.out.println(new Solution().kSimilarity("abc", "bca"));//2
        System.out.println(new Solution().kSimilarity("abac", "baca"));//2
        System.out.println(new Solution().kSimilarity("cbca", "abcc"));//1
        System.out.println(new Solution().kSimilarity( "abccaacceecdeea", "bcaacceeccdeaae"));//9
        System.out.println(new Solution().kSimilarity( "abcdeabcdeabcdeabcde", "aaaabbbbccccddddeeee"));//8
    }

    public int kSimilarity(String A, String B) {
        int k = 0;
        char[] aChar = A.toCharArray();
        char[] bChar = B.toCharArray();

        for (int i = 0; i < aChar.length; i++) {
            if (aChar[i] == bChar[i]) {
                continue;
            } else {
                int index = indexOf(aChar[i], aChar, bChar, i);
                if (index != -1) {
                    bChar[index] = bChar[i];
                    bChar[i] = '0';
                    k++;
                }
            }
        }
        return k;
    }

    private int indexOf(char c,  char[] chars, char[] chars2, int index) {
        for (int i = index; i < chars2.length; i++) {
            if (c == chars2[i] && chars[i] != chars2[i]) {
                return i;
            }
        }
        return -1;
    }
}
