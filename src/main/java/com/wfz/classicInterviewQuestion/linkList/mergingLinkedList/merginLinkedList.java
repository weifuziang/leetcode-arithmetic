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


    }



    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        //极端情况处理
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode head = new ListNode();
        ListNode tail = head;
        while(list1 != null || list2 != null){
             if(list1 == null){
                 tail.next=list2;
                  break;
             }
                if(list2 == null){
                    tail.next=list1;
                    break;
                }
                if(list1.val < list2.val){
                    tail.next=list1;
                    list1=list2.next;
                }else{
                    tail.next=list2;
                    list2=list1.next;
                }
                list1=list1.next;
                list2=list2.next;
                tail=tail.next.next;


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