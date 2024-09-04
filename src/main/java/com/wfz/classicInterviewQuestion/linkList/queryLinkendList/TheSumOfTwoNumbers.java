package com.wfz.classicInterviewQuestion.linkList.queryLinkendList;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例 1
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807
 *
 * 示例 2：
 *
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 *
 * 示例 3：
 *
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 *
 *
 *
 */
public class TheSumOfTwoNumbers {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;

        ListNode listNode4 = new ListNode(5);
        ListNode listNode5 = new ListNode(6);
        ListNode listNode6 = new ListNode(4);
        listNode4.next = listNode5;
        listNode5.next = listNode6;

        ListNode listNodeTmp = listNode1;
        while (listNodeTmp != null) {
            System.out.println("==: "+listNodeTmp.val);
            listNodeTmp = listNodeTmp.next;
        }

        ListNode listNode = new TheSumOfTwoNumbers().addTwoNumbers(listNode1, listNode4);

        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

        //按照上述示例3，写一个样例
         ListNode listNode7 = new ListNode(9);
         ListNode listNode8 = new ListNode(9);
         ListNode listNode9 = new ListNode(9);

         ListNode listNode10 = new ListNode(9);
         ListNode listNode11 = new ListNode(9);
         ListNode listNode12 = new ListNode(9);
         ListNode listNode13 = new ListNode(9);
         listNode7.next = listNode8;
         listNode8.next = listNode9;

         listNode10.next = listNode11;
         listNode11.next = listNode12;
         listNode12.next = listNode13;
        ListNode listNode14 = new TheSumOfTwoNumbers().addTwoNumbers(listNode7, listNode10);
        while (listNode14 != null) {
            System.out.println(listNode14.val);
            listNode14 = listNode14.next;
        }


    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

         ListNode head=null,tail=null;
         //进位
         int carry=0;
         while(l1 !=null || l2 !=null){
             int n1=l1 !=null ? l1.val : 0;
             int n2=l2 !=null ? l2.val : 0;
             int sum=n1+n2+carry;
             if(head==null){
                 head=tail=new ListNode(sum%10);
             }else{
                 tail.next=new ListNode(sum%10);
                 tail=tail.next;
             }
             //取进位值作为下一次的进位计算
                carry=sum/10;

             //循环体，l1和l2都不为空的时候，继续往下走
             //如果l1不为空，继续往下走
                if(l1 !=null){
                    l1=l1.next;
                }
                //如果l2不为空，继续往下走
                if(l2 !=null){
                    l2=l2.next;
                }

             //如果l1不为空，继续往下走,先放一个占位节点元素
             if(carry > 0){
                 tail.next=new ListNode(carry);
             }
         }
         return head;

    }
}
