package com.dhc.线性结构.链表相关.翻转链表;


import com.dhc.线性结构.链表相关.ListNode;

import static com.dhc.线性结构.链表相关.ListUtil.*;

/**
 * @author haochen.daiØ
 * @Date: 2020-08-23 15:39
 * @Description: 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        Solution solution = new Solution();
        ListNode result = solution.reverseList3(buildListNode(nums));
        printList(result);
    }


    /**
     * 迭代法
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode current = head;
        while (current.next != null) {
            ListNode temp = current.next;
            current.next = pre;
            pre = current;
            current = temp;
        }
        current.next = pre;
        return current;
    }

    /**
     * 递归
     *
     * @param resultHead
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode resultHead, ListNode head) {
        if (head == null) {
            return resultHead;
        }
        ListNode temp = head.next;
        head.next = resultHead;
        return reverseList2(head, temp);
    }

    /**
     * 题解
     *
     * @param head
     * @return
     */
    public ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList3(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }


}
