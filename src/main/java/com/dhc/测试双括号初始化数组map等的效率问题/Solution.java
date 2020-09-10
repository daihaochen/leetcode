package com.dhc.测试双括号初始化数组map等的效率问题;

import java.util.ArrayList;

/**
 * @author Haochen.Dai
 * @date Created in 2020/6/15 21:18
 * @description
 * 插入 1000W 数据，结果：
 *
 *  初始化大小为数据量大小，避免扩容
 *  normal 5500 ms
 *  doubleCurlyBraces 5500 ms
 *
 *  初始化大小为10，使其不断扩容
 *  normal 4700 ms
 *  doubleCurlyBraces 4700 ms
 *
 *  结论：基本一样...
 */
public class Solution {

    private static final int INIT_CAPACITY = 10000000;

    public static void main(String[] args) {
//        Solution.normal();
        Solution.doubleCurlyBraces();
    }

    public static void doubleCurlyBraces() {
        long startTime = System.currentTimeMillis();
        ArrayList<String> arrayList = new ArrayList<String>(10) {{
            for (int i = 0; i < INIT_CAPACITY; i++) {
                add("double" + (i * i));
            }
        }};
        System.out.println("doubleCurlyBraces: " + (System.currentTimeMillis() - startTime));
    }

    public static void normal() {
        long startTime = System.currentTimeMillis();
        ArrayList<String> arrayList = new ArrayList<>(10);
        for (int i = 0; i < INIT_CAPACITY; i++) {
            arrayList.add("normal" + (i * i));
        }
        System.out.println("normal: " + (System.currentTimeMillis() - startTime));
    }

}
