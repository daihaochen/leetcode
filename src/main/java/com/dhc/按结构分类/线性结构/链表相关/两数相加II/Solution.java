package com.dhc.按结构分类.线性结构.链表相关.两数相加II;

import com.dhc.按结构分类.线性结构.链表相关.ListNode;
import com.dhc.按结构分类.线性结构.链表相关.ListUtil;

import static com.dhc.按结构分类.线性结构.链表相关.ListUtil.buildListNode;

/**
 * @author Haochen.Dai
 * @date Created in 2020/9/7 19:50
 * @description
 *
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 *  
 *
 * 进阶：
 *
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 *
 * 倒叙一般都用栈处理
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4,5,6,7};
        int[] nums2 = {1,2,3,4,5,6,7};
        ListUtil.printList(new Solution().addTwoNumbers(ListUtil.buildListNode(nums1), ListUtil.buildListNode(nums2)));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        return null;








    }
}
