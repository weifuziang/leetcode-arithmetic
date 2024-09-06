package com.wfz.classicInterviewQuestion.linkList.mergingLinkedList;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例1：
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 *
 * 示例 2：
 *
 * 输入：l1 = [], l2 = []
 * 输出：[]
 *
 * 示例 3：
 *
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 */
public class merginLinkedList {

    public static void main(String[] args) {

        //创建实例1
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;

        ListNode listNode = new ListNode(1);
        ListNode listNode5 = new ListNode(3);
        ListNode listNode6 = new ListNode(4);
        listNode.next = listNode5;
        listNode5.next = listNode6;


        ListNode listNode4 = new merginLinkedList().mergeTwoLists(listNode1, listNode);
        while (listNode4 != null) {
            System.out.println(listNode4.val);
            listNode4 = listNode4.next;
        }


    }



    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        //极端情况处理
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        //创建头节点和尾节点，主要目的是head是为了返回时还知道我的脑袋在哪，tail是为了推进
        ListNode head = new ListNode();
        ListNode tail = head;
        //双链同开循环
        while(list1 != null || list2 != null){

            //单链表到头了的处理逻辑
             if(list1 == null){
                 tail.next=list2;
                  break;
             }
             if(list2 == null){
                    tail.next=list1;
                    break;
             }
         //比较大小，小的放前面，大的放后面，并加上循环推进的循环体
             if(list1.val < list2.val){
                    tail.next=list1;
                    list1=list1.next;
             }else{
                    tail.next=list2;
                    list2=list2.next;
             }
             //新链表的尾部推进
            tail = tail.next;

        }
        return head.next;

    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }