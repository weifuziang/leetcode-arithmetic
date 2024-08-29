package com.wfz.classicInterviewQuestion.linkList.queryLinkendList;

import java.util.HashSet;

/**
 * 141. 环形链表
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 *
 * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 *
 * 提示：
 *
 *     链表中节点的数目范围是 [0, 104]
 *     -105 <= Node.val <= 105
 *     pos 为 -1 或者链表中的一个 有效索引 。
 */
public class CircularLinkedListDiscovery {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(3);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(0);
        ListNode listNode4 = new ListNode(-4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode2;

//        System.out.println(new CircularLinkedListDiscovery().hasCycle(listNode1));
        System.out.println(new CircularLinkedListDiscovery().hasCycle2(listNode1));

    }

    //方案1: 使用HashSet
    public boolean hasCycle(ListNode head){
        HashSet<ListNode> listNodes = new HashSet<>();
        while(head != null){
            if(!listNodes.add(head)){
                return true;
            }
            head = head.next;
        }
        return false;

    }

    //方案2: 快慢指针
    public boolean hasCycle2(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while (fast !=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                return true;
            }
        }
        return false;
    }

}


 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
 }
