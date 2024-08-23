package com.wfz.classicInterviewQuestion.linkList.deleteLinkedList;



/**
 * 删除链表的倒数第N个节点
 * 页面检索词: 删除链表的倒数第
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

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;

        while (listNode1 != null) {
            System.out.println("==: "+listNode1.val);
            listNode1 = listNode1.next;
        }

        ListNode listNode = new delNthElement().removeNthFromEnd(listNode1, 1);

        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        //创建哑结点
        ListNode listNode = new ListNode(0, head);
        //获取链表的长度
        int length = getLength(listNode);
        for (int i = 1; i <= length; i++) {
            if(i==length-n){//找到要删除的节点的前一个节点
                head.next=head.next.next;
                return listNode.next;
            }
        }
        return listNode.next;
    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  private int getLength(ListNode head){
        int length=0;
        while(head !=null){
            length++;
            head=head.next;
        }
        return length;
  }

}
