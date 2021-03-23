package com.dhc.按结构分类.线性结构.链表相关.翻转链表II;

import com.dhc.按结构分类.线性结构.链表相关.ListNode;

import static com.dhc.按结构分类.线性结构.链表相关.ListUtil.buildListNode;
import static com.dhc.按结构分类.线性结构.链表相关.ListUtil.printList;

/**
 * @author haochen.dai
 * @Date: 2020-09-15 22:52
 * @Description:
 *
 * 转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 *
 * 思路：
 * 遍历到底m个节点，记录length = n-m，就变成了翻转前 length 个节点,最后再把 m 的前一个节点的指针指向翻转后的第一个
 *
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        Solution solution = new Solution();
        ListNode result = solution.reverseBetween(buildListNode(nums), 2, 4);
        printList(result);
    }


    /**
     * 翻转m到n之间的节点
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode preNode = null;
        ListNode startNode = head;
        int length = n - m + 1;
        for (int i = m - 1; i > 0; i--) {
            preNode = startNode;
            startNode = startNode.next;
        }

        // 翻转
        ListNode afterReverseNode = reversePreN(startNode, length);

        // 如果需要翻转的节点不是第一个，需要改变一下pre.next
        if (preNode != null) {
            preNode.next = afterReverseNode;
            return head;
        }
        return afterReverseNode;

    }

    /**
     * 从某个节点开始，翻转节点后的N的节点
     * @param startNode 开始节点
     * @param length 需要翻转的节点数量
     * @return 翻转后的首节点
     */
    public ListNode reversePreN(ListNode startNode, int length) {
        ListNode preNode = null;
        ListNode current = startNode;
        int counter = 0;
        while (counter < length && current != null) {
            ListNode temp = current.next;
            current.next = preNode;
            preNode = current;
            current = temp;
            counter++;
        }
        startNode.next = current;
        return preNode;
    }

}
