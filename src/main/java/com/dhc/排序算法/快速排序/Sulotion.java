package com.dhc.排序算法.快速排序;

/**
 * User: Haochen.Dai
 * Date: 2019-12-21 23:24
 * Description: 快速排序 O(nlogn) 不稳定 递归
 */
public class Sulotion {
    public static void main(String[] args) {
        int[] i = {2,4,1,7,3,9,5,11};
        quickSort(0, i.length - 1, i);
        for (int i1 : i) {
            System.out.println(i1);
        }
    }


    public static void quickSort(int start, int end, int[] array) {
        int midNum = array[start];
        int i = start;
        int j = end;
        while (i < j) {
            while (i < j && array[i] < midNum) {
                i++;
            }
            while (i < j && array[j] > midNum) {
                j--;
            }
            if (i <= j && array[i] == array[j]) {
                i++;
            } else {
                array[i] = array[i] ^ array[j];
                array[j] = array[i] ^ array[j];
                array[i] = array[i] ^ array[j];
            }
        }
        if (i - 1 > start) {
            quickSort(start, i - 1, array);
        }
        if (j + 1 < end) {
            quickSort(j + 1, end, array);
        }
    }
}
