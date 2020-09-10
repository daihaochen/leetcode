package com.dhc.动态规划.数字三角形;

/**
 * @author ：Haochen.Dai
 * @date ：Created in 2019/12/22 15:58
 * @description：
 *
 *             7
 *           3   8
 *         8   1   0
 *       2   7   4   4
 *     4   5   2   6   5
 *
 *
 *  在上面的数字三角形中寻找一条从顶部到底边的路径，使得路径上所经过的数字之和最大。
 *  路径上的每一步都只能往左下或 右下走。只需要求出这个最大和即可，不必给出具体路径。
 *  三角形的行数大于1小于等于100，数字为 0 - 99
 *
 *  转化为
 *     7
 *     3   8
 *     8   1   0
 *     2   7   4   4
 *     4   5   2   6   5
 *
 * 每次只能往下或者右下走，即当在[i,j]的时候只有两种可能的行动 [i + 1, j], [i + 1, j + 1]
 * 假设三角形只有一行
 * 则结果为 7
 *
 */
public class Solution {

    int[][] array = {
            {7},
            {3, 8},
            {8, 1, 0},
            {2, 7, 4, 4},
            {4, 5, 2, 6, 5},
    };
    int[][] maxNum = new int[5][5];
    int[] maxNum2 = new int[5];

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.recursion(0, 0));

        System.out.println(s.recursionOptimization(0, 0));
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(s.maxNum[i][j] + ",");
            }
            System.out.println();
        }

        System.out.println(s.recurrence());
    }

    /**
     * 递归，过多重复计算，时间复杂度为2^n（可以转化为斐波那契数列每行的和计算）
     */
    public int recursion(int i, int j) {
        if (i == 4) {
            return array[i][j];
        }  else {
            return Math.max(recursion(i + 1, j), recursion(i + 1, j + 1)) + array[i][j];
        }
    }


    /**
     * 优化递归，将计算得到的值放入二维数组中(再优化可以放到一维数组里，见下方)，再次遇到重复的计算直接取结果，
     * 时间复杂度为n^2（可以看做遍历这个刚创建的三角形二维数组的时间复杂度 n * n / 2 = n^2）
     */
    public int recursionOptimization(int i, int j) {
        if (maxNum[i][j] != 0) {
            return maxNum[i][j];
        }
        if (i == 4) {
            maxNum[i][j] = array[i][j];
            return maxNum[i][j];
        }  else {
            maxNum[i][j] = Math.max(recursionOptimization(i + 1, j), recursionOptimization(i + 1, j + 1)) + array[i][j];
            return maxNum[i][j];
        }
    }

    /**
     * 递推，将结果放到数组中（同上，这里优化放到一维数组中），时间复杂度O（n）
     */
    public int recurrence() {
        for (int i = 4; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                if (i == 4) {
                    maxNum2[j] = array[i][j];
                } else {
                    maxNum2[j] = Math.max(maxNum2[j], maxNum2[j + 1]) + array[i][j];
                }
            }
        }
        return maxNum2[0];
    }


}
