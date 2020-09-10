package com.dhc.动态规划.不同的二叉搜索树;

/**
 * @author Haochen.Dai
 * @date Created in 2020/7/27 20:17
 * @description
 *
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 *
 * 示例:
 *
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 *    2     1
 * 1             2
 */
public class Solution {
    public static void main(String[] args) {

    }

    public int numOfBinarySearchTree(int start, int end) {
        int n = end - start;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum =+ numOfBinarySearchTree(start, i);
            sum =+ numOfBinarySearchTree(i, end);
        }
        return sum;
    }
}
