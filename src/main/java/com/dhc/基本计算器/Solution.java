package com.dhc.基本计算器;


/**
 * @author ：Haochen.Dai
 * @date ：Created in 2019/12/12 15:40
 * @description：
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 *
 * 字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
 *
 * 示例 1:
 *
 * 输入: "3+2*2"
 * 输出: 7
 *
 * 示例 2:
 *
 * 输入: " 3/2 "
 * 输出: 1
 *
 * 示例 3:
 *
 * 输入: " 3+5 / 2 "
 * 输出: 5
 */
public class Solution {
    public static void main(String[] args) {
        new Solution().calculate("+1+2+2*9-9-8/4");
    }
    public int calculate(String s) {
        int result = 0;
        String[] numArray = s.split("[+\\|\\-\\|*\\|/]");
        String[] symbolArray = s.split("[0-9]+");
        for (int i = 0; i < numArray.length; i++) {
            if ("+".equals(symbolArray[i+1]) || "-".equals(symbolArray[i+1])) {
                //TODO 感觉满简单的，就不写了，哈哈哈哈哈哈啊
            }
        }
        return 0;
    }
}