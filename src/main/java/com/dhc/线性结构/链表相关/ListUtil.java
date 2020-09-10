package com.dhc.线性结构.链表相关;

/**
 * @author haochen.dai
 * @Date: 2020-08-23 19:57
 * @Description:
 */
public class ListUtil {

    /**
     * 构建链表，无环的情况
     * @param nums
     * @return
     */
    public static ListNode buildListNode(int[] nums) {
        return buildListNode(nums, -1);
    }

    /**
     * 构建链表
     * @param nums
     * @param cycleIndex 环的位置，-1代表无环
     * @return
     */
    public static ListNode buildListNode(int[] nums, int cycleIndex) {
        if (nums.length == 0) {
            return null;
        }
        ListNode head = new ListNode(nums[0]);
        ListNode current = head;
        ListNode cycleNode = null;
        for (int i = 1; i < nums.length; i++) {
            ListNode nextNode = new ListNode(nums[i]);
            current.next = nextNode;
            current = current.next;
            // 判断是否有环
            if (i == cycleIndex) {
                cycleNode = nextNode;
            }
        }
        // 最后将环接上
        current.next = cycleNode;
        return head;
    }


    /**
     * 打印链表，无环才能用，不然死循环
     * @param head
     */
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.println(head.node);
            head = head.next;
        }
    }
}

