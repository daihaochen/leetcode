package com.dhc.动态规划.T19正则表达式;

/**
 * @author haochen.dai
 * @Date: 2020-07-25 23:30
 *
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配。
 *
 */
public class Solution {

    private static char ANY_TIME_MATCH_SYMBOL = '*';
    private static char ALL_MATCH_SYMBOL = '.';

    public static void main(String[] args) {
        String string = "abbbbbbbbc";
        String pattern = "ab*bbc";
        System.out.println(new Solution().match(string, pattern));
    }

    public boolean match(String s, String pattern) {
        if (s == null || pattern == null || pattern.length() == 0) {
            return false;
        }
        if (s.length() == 0) {
            if (pattern.length() == 2 && pattern.charAt(1) == ANY_TIME_MATCH_SYMBOL) {
                return true;
            }
            return false;
        }
        if (pattern.charAt(0) == ANY_TIME_MATCH_SYMBOL) {
            return false;
        }


        return matchChar(s, pattern, s.length() - 1, pattern.length() - 1);
    }

    public boolean matchChar(String string, String pattern, int sIndex, int pIndex) {
        char s = string.charAt(sIndex);
        char p = pattern.charAt(pIndex);
        boolean isEqual = (p == ALL_MATCH_SYMBOL || s == p);

        if ((sIndex == 0 || pIndex == 0)) {
            if ((sIndex == pIndex) && isEqual) {
                return true;
            } else {
                return false;
            }
        }

        if (p == ANY_TIME_MATCH_SYMBOL) {
            if (pattern.charAt(pIndex - 1) == s || pattern.charAt(pIndex - 1) == ALL_MATCH_SYMBOL) {
                return matchChar(string, pattern, sIndex - 1, pIndex) || matchChar(string, pattern, --sIndex, pIndex - 2);
            } else {
                return matchChar(string, pattern, --sIndex, pIndex - 2);
            }
        } else if (isEqual) {
            return matchChar(string, pattern, --sIndex, --pIndex);
        }
        return false;
    }
}
