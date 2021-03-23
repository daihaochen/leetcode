package com.dhc.按结构分类.线性结构.链表相关.翻转链表III;

import com.dhc.按结构分类.线性结构.链表相关.ListNode;

import static com.dhc.按结构分类.线性结构.链表相关.ListUtil.buildListNode;
import static com.dhc.按结构分类.线性结构.链表相关.ListUtil.printList;

/**
 * @author haochen.dai
 * @Date: 2020-09-15 22:56
 * @Description:
 *
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 *  
 *
 * 示例：
 *
 * 给你这个链表：1->2->3->4->5
 *
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 *
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 *  
 *
 * 说明：
 *
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 * 思路：
 * 反转前k个节点
 * 记录k + 1个节点
 *
 * 把k+1个节点当做头结点
 * 反转 k+1 到 2k+1 之间节点
 *
 * 即将题目简化成：
 * 多次调用 反转前k个节点（即反转链表II的 reversePreN 方法） 的题目
 *
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        Solution solution = new Solution();
        ListNode result = solution.reverseKGroup(buildListNode(nums), 3);
        printList(result);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode result = null;
        ListNode pre = null;
        ListNode current = head;
        while (current != null) {
            ListNode headAfterReverse = reversePreN(current, k);
            if (pre != null) {
                pre.next = headAfterReverse;
            } else {
                result = headAfterReverse;
            }
            pre = current;
            current = current.next;
        }

        return result;

    }

    /**
     * 从某个节点开始，翻转节点后的N的节点
     * @param startNode 开始节点
     * @param length 需要翻转的节点数量
     * @return 翻转后的首节点
     */
    public ListNode reversePreN(ListNode startNode, int length) {
        // 如果小于length，不处理，直接返回头结点
        int nodeNums = 0;
        ListNode tempNode = startNode;
        while (tempNode != null) {
            nodeNums++;
            tempNode = tempNode.next;
        }
        if (nodeNums < length) {
            return startNode;
        }

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
