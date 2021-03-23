package com.dhc.按结构分类.线性结构.链表相关.删除中间的某个节点;

import com.dhc.按结构分类.线性结构.链表相关.ListNode;
import com.dhc.按结构分类.线性结构.链表相关.ListUtil;

import static com.dhc.按结构分类.线性结构.链表相关.ListUtil.buildListNode;

/**
 * @author Haochen.Dai
 * @date Created in 2020/9/7 19:27
 * @description
 * 实现一种算法，删除单向链表中间的某个节点（即不是第一个或最后一个节点），假定你只能访问该节点。
 *
 *  
 *
 * 示例：
 *
 * 输入：单向链表a->b->c->d->e->f中的节点c
 * 结果：不返回任何数据，但该链表变为a->b->d->e->f
 *
 * 思路，因为无法得到该节点的前一个节点，所以无法改变上一个节点的next指针
 * 于是将该节点的值和next都替换为下一个的值，就实现了删除自身。
 *
 */
public class Solution {


    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        ListNode head = ListUtil.buildListNode(nums);
        new Solution().deleteNode(head.next.next);
        ListUtil.printList(head);
    }

    /**
     * 删除某个节点
     *
     * @param node 需要删除的节点
     */
    public void deleteNode(ListNode node) {
        ListNode nextNode = node.next;
        node.node = nextNode.node;
        node.next = nextNode.next;
    }
}
