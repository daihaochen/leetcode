package com.dhc.线性结构.链表相关.两两交换链表中的节点;


import com.dhc.线性结构.链表相关.ListNode;
import org.springframework.scheduling.annotation.Scheduled;

import static com.dhc.线性结构.链表相关.ListUtil.buildListNode;
import static com.dhc.线性结构.链表相关.ListUtil.printList;

/**
 * @author haochen.dai
 * @Date: 2020-08-23 19:56
 *
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *  
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        printList(new Solution().swapPairs(buildListNode(nums)));
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode secondNode = head.next;
        head.next = swapPairs(head.next.next);;
        secondNode.next = head;
        return secondNode;
    }
}
