package com.dhc.动态规划.括号生成;

import java.util.LinkedList;
import java.util.List;

/**
 * @author ：Haochen.Dai
 * @date ：Created in 2019/12/25 20:18
 * @description：
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 * 动态规划，回溯法
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        StringBuffer sb = new StringBuffer();
        List<String> list = new LinkedList<>();
        recursion(n, n, sb, list);
        return list;
    }

    public void recursion(int n, int m, StringBuffer sb, List<String> list) {
        if (n == 0 && m == 0) {
            list.add(sb.toString());
            sb.setLength(0);
        }
        if (n != 0) {
            sb.append("(");
            recursion(n -1, m, sb, list);
        }
        if (m != 0 && m > n) {
            sb.append(")");
            recursion(n , m - 1, sb, list);
        }

    }
}
