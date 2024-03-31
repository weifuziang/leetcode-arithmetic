package com.wfz.classicInterviewQuestion.linkList.flipList;

public class FlipList {

    /**
     * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
     * @param args
     */

    public static void main(String[] args) {

        ListNode listNode5 = new ListNode(5, null);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);

        ListNode resultListNode = reverseList(listNode1);
        ListNode tmp=resultListNode;
        while (tmp != null){
            System.out.println(tmp.val);
            tmp=tmp.next;
        }


    }

    public static ListNode reverseList(ListNode head) {

        ListNode pre=null;
        ListNode curr= head;

        while(curr !=null){
            ListNode next=curr.next;
            curr.next=pre;
            pre=curr;
            curr=next;
        }

        return pre;

    }

    public static class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
