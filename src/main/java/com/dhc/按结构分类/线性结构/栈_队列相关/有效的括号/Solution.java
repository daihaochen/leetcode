package com.dhc.按结构分类.线性结构.栈_队列相关.有效的括号;

import java.util.Stack;

/**
 * @author haochen.dai
 * @Date: 2020-09-24 11:42
 * @Description:
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 *
 *
 * 没啥好说的，栈
 */
public class Solution {


    public static void main(String[] args) {
        String s = "{[]{}";
        System.out.println(new Solution().isValid(s));
    }

    public boolean isValid(String s) {
        Stack<Character> brackets = new Stack<>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '{':
                    brackets.push('}');
                    break;
                case '[':
                    brackets.push(']');
                    break;
                case '(':
                    brackets.push(')');
                    break;
                default:
                    if (brackets.isEmpty() || brackets.pop() != c) {
                        return false;
                    }
            }

        }
        return brackets.isEmpty();
    }
}
