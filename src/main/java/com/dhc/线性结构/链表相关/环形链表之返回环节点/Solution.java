package com.dhc.线性结构.链表相关.环形链表之返回环节点;

import com.dhc.线性结构.链表相关.ListNode;

import static com.dhc.线性结构.链表相关.ListUtil.buildListNode;


/**
 * @author haochen.dai
 * @Date: 2020-09-01 23:14
 * @Description: 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * <p>
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * <p>
 * 说明：不允许修改给定的链表。
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {3, 2, 0, -4};
        Solution solution = new Solution();
        System.out.println(solution.detectCycle(buildListNode(nums, 1)).node);
    }


    /**
     * 得到入环的第一个节点
     * @param head 链表头结点
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode intersectNode = hasCycle(head);
        if (intersectNode == null) {
            return null;
        }
        int cycleSize = getCycleSize(intersectNode);
        ListNode first = head;
        ListNode second = head;
        while (cycleSize > 0) {
            second = second.next;
            cycleSize--;
        }

        while (first != second) {
            first = first.next;
            second = second.next;
        }

        return first;
    }

    /**
     * 将环形链表那题的返回值改为返回重合的节点
     * @param head
     * @return
     */
    public ListNode hasCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode first = head;
        ListNode second = head;
        while (second.next != null && second.next.next != null) {
            first = first.next;
            second = second.next.next;
            if (first == second) {
                return first;
            }
        }
        return null;
    }


    /**
     * 判断环的长度
     * @param intersectNode 在环内相交的节点
     */
    public int getCycleSize(ListNode intersectNode) {
        int size = 1;
        ListNode temp = intersectNode;
        while (true) {
            if (temp == null) {
                return 0;
            }
            temp = temp.next;
            if (temp == intersectNode) {
                return size;
            } else {
                size++;
            }
        }
    }
}
