package com.wfz.classicInterviewQuestion.linkList.deleteLinkedList;



/**
 * 删除链表的倒数第N个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 *
 * 示例 2：
 *
 * 输入：head = [1], n = 1
 * 输出：[]
 *
 * 示例 3：
 *
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 */
public class delNthElement {
    public static void main(String[] args) {

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        //创建哑结点
        ListNode listNode = new ListNode(0, head);
        //获取链表的长度
        //int length = getLength(head);

    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

}
