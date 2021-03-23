package com.dhc.按结构分类.线性结构.链表相关.两数相加;

import com.dhc.按结构分类.线性结构.链表相关.ListNode;

import static com.dhc.按结构分类.线性结构.链表相关.ListUtil.buildListNode;
import static com.dhc.按结构分类.线性结构.链表相关.ListUtil.printList;

/**
 * @author Haochen.Dai
 * @date Created in 2020/6/7 11:07
 * @description 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class Solution {



    public static void main(String[] args) {
        int[] nums1 = {2, 4, 3, 1};
        int[] nums2 = {5, 6, 4};
        ListNode ln1 = buildListNode(nums1);
        ListNode ln2 = buildListNode(nums2);
        printList(new Solution().addNumbers(ln1, ln2));
    }

    public ListNode addNumbers(ListNode ln1, ListNode ln2) {
        int sum = ln1.node + ln2.node;
        int remainder = sum % 10;
        int quotient = sum / 10;
        ListNode result = new ListNode(remainder);
        ListNode current = result;

        while (ln1.next != null || ln2.next != null) {
            int nextVal1 = ln1.next == null ? 0 : ln1.next.node;
            int nextVal2 = ln2.next == null ? 0 : ln2.next.node;
            int nextSum = nextVal1 + nextVal2 + quotient;
            remainder = nextSum % 10;
            quotient = nextSum / 10;
            current.next = new ListNode(remainder);

            current = current.next;
            ln1 = ln1.next;
            ln2 = ln2.next;
        }
        return result;
    }

}
