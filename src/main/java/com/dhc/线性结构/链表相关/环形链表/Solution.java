package com.dhc.线性结构.链表相关.环形链表;

import com.dhc.线性结构.链表相关.ListNode;

import static com.dhc.线性结构.链表相关.ListUtil.*;

/**
 * @author haochen.dai
 * @Date: 2020-09-01 22:53
 * @Description:
 * 给定一个链表，判断链表中是否有环。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 *  
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {3, 2, 0, -4};
        Solution solution = new Solution();
        System.out.println(solution.hasCycle(buildListNode(nums, 1)));
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode first = head;
        ListNode second = head;
        while (second.next != null && second.next.next != null) {
            first = first.next;
            second = second.next.next;
            if (first == second) {
                return true;
            }
        }
        return false;
    }
}
