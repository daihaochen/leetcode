package com.dhc.宝石与石头;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author ：Haochen.Dai
 * @date ：Created in 2019/12/9 17:12
 * @description：
 *  给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 *
 * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
 *
 * 示例 1:
 *
 * 输入: J = "aA", S = "aAAbbbb"
 * 输出: 3
 *
 * 示例 2:
 *
 * 输入: J = "z", S = "ZZ"
 * 输出: 0
 *
 * 注意:
 *
 *     S 和 J 最多含有50个字母。
 *      J 中的字符不重复。
 *
 *
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().numJewelsInStones1("aA", "aAAbbbb"));
        System.out.println(new Solution().numJewelsInStones2("aA", "aAAbbbb"));
        System.out.println(new Solution().numJewelsInStones3("aA", "aAAbbbb"));

        System.out.println(new Solution().numJewelsInStones1("z", "ZZ"));
        System.out.println(new Solution().numJewelsInStones2("z", "ZZ"));
        System.out.println(new Solution().numJewelsInStones3("z", "ZZ"));
    }

    /**
     * 暴力破解
     * @param J
     * @param S
     * @return
     */
    public int numJewelsInStones1(String J, String S) {
        int num = 0;
        char[] chars = S.toCharArray();
        for (char c : chars) {
            if (J.contains(c + "")) {
                num++;
            }
        }
        return num;
    }

    /**
     * hashMap
     * @param J
     * @param S
     * @return
     */
    public int numJewelsInStones2(String J, String S) {
        int num = 0;
        char[] sChars = S.toCharArray();
        char[] jChars = J.toCharArray();
        Set<Character> set = new HashSet<>();
        for (char c : jChars) {
            set.add(c);
        }

        for (char c : sChars) {
            if (set.contains(c)) {
                num++;
            }
        }
        return num;
    }

    /**
     * 通过ASCII当数组下表（类似hashMap的原理）
     * @param J
     * @param S
     * @return
     */
    public int numJewelsInStones3(String J, String S) {
        int num = 0;
        char[] sChars = S.toCharArray();
        char[] jChars = J.toCharArray();
        int[] hashInt = new int[127];
        for (char c : jChars) {
            hashInt[c] = c;
        }

        for (char c : sChars) {
            if (hashInt[c] != 0) {
                num++;
            }
        }
        return num;
    }
}
