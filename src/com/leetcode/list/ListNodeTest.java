/**
 * Project Name: 邮乐支付系统
 * File Name: ListNodeTest
 * Package Name: com.leetcode.list
 * Date: 2019/6/13 10:35
 * Copyright (c) 2019, 上海邮乐网络技术有限公司
 * author：xiao.y
 */
package com.leetcode.list;

/**
 * ClassName: ListNodeTest <br>
 * Function: 链表. <br>
 * Date: 2019/6/13 10:35 <br>
 */
public class ListNodeTest {


    public static ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }

    /**
     * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     *
     * 示例：
     *
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     * @param l1
     * @param l2
     * @return
     * https://leetcode-cn.com/problems/merge-two-sorted-lists/solution/he-bing-liang-ge-you-xu-lian-biao-by-leetcode/
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 哨兵结点
        ListNode preHead = new ListNode(-1);
        ListNode prev = preHead;
        // 逐步迭代解法
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                prev.next = l2;
                l2 = l2.next;
            }else {
                prev.next = l1;
                l1 = l1.next;
            }
            prev = prev.next;
        }
        prev.next = (l1 == null?l2:l1);
        return preHead.next;
    }


    public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // odd nodes: let right half smaller
        if (fast != null) {
            slow = slow.next;
        }
        slow = reverse(slow);
        fast = head;

        while (slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(1);
        ListNodeTest test = new ListNodeTest();
        //System.out.println(test.isPalindrome(head));
        test.reverse(head);
    }




}
class ListNode {
    int val;
    ListNode next;

    ListNode(int x){
        this.val = x;
    }

}