package com.wfz.classicInterviewQuestion.linkList.deleteLinkedList;

import java.util.HashSet;

/**
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 *
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 *
 * 输入：head = [1,1,1,2,3]
 * 输出：[2,3]
 *
 */
public class removeDuplicateDelement {

    public static void main(String[] args) {

            ListNode listNode1 = new ListNode(1);
            ListNode listNode2 = new ListNode(1);
            ListNode listNode3 = new ListNode(1);
            ListNode listNode3_3 = new ListNode(1);
            ListNode listNode4 = new ListNode(2);
            ListNode listNode5 = new ListNode(3);
            ListNode listNode6 = new ListNode(3);
            ListNode listNode7 = new ListNode(3);
            ListNode listNode8 = new ListNode(4);
            listNode1.next = listNode2;
            listNode2.next = listNode3;
            listNode3.next = listNode3_3;
            listNode3_3.next = listNode4;
            listNode4.next = listNode5;
            listNode5.next = listNode6;
            listNode6.next = listNode7;
            listNode7.next = listNode8;

            ListNode listNodeTmp = listNode1;
            while (listNodeTmp != null) {
                System.out.println("init: "+listNodeTmp.val);
                listNodeTmp = listNodeTmp.next;
            }

            ListNode listNode = new removeDuplicateDelement().deleteDuplicates2(listNode1);

            while (listNode != null) {
                System.out.println("deal:==  "+listNode.val);
                listNode = listNode.next;
            }

    }


    //方法1： 使用hashset自动去重，有值则返回false，无值则返回true,此时的空间复杂度为O(n)，时间复杂度为O(n)，
    // 因为该链表本身就是有序的链表，所以可直接使用相邻的两个元素进行比较，具体优化请看方法2

    //回顾评价： 此方法解题错误， 此题是将重复的元素全部删掉，而不是只保留一个
//    public ListNode deleteDuplicates(ListNode head) {
//
//        HashSet<Integer> hasSet = new HashSet<>();
//        //亚节点
//        ListNode listNode = new ListNode(0, head);
//        while (listNode.next != null){
//            if(!hasSet.add(listNode.next.val)){
//                listNode.next = listNode.next.next;
//            }else{
//                listNode = listNode.next;
//            }
//        }
//        return head;
//
//    }

    //方法2： 优化方法1，使用相邻的两个元素进行比较，时间复杂度为O(n) 空间复杂度为O(1)
    public ListNode deleteDuplicates2(ListNode head) {
        //亚节点
        ListNode dummy = new ListNode(0, head);
        ListNode curr= dummy;
        while(curr.next !=null && curr.next.next !=null){
            if(curr.next.val == curr.next.next.val){//将后面所有相同的元素都删掉，包括它自己
                int x = curr.next.val;
                while(curr.next !=null && curr.next.val ==x){
                    curr.next = curr.next.next;
                }
            }else{
                curr = curr.next;
            }
        }

        return dummy.next;

    }

}


class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
