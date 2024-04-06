package com.wfz.classicInterviewQuestion.linkList.flipList;

public class FlipList2 {

    /**
     * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表
     * 输入：head = [1,2,3,4,5], left = 2, right = 4
     * 输出：[1,4,3,2,5]
     *
     * 示例 2：
     *
     * 输入：head = [5], left = 1, right = 1
     * 输出：[5]
     * @param args
     */
    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        ListNode listNode7 = new ListNode(7);
        ListNode listNode8 = new ListNode(8);
        ListNode listNode9 = new ListNode(9);
        listNode1.next=listNode2;
        listNode2.next=listNode3;
        listNode3.next=listNode4;
        listNode4.next=listNode5;
        listNode5.next=listNode6;
        listNode6.next=listNode7;
        listNode7.next=listNode8;
        listNode8.next=listNode9;


//        ListNode listNode1 = new ListNode(5);

        ListNode tmpBefore =listNode1;
        System.out.println("======翻转前======");
        System.out.println(tmpBefore.val);
        while (null !=tmpBefore.next){
            tmpBefore=tmpBefore.next;
            System.out.println(tmpBefore.val);
        }

//        ListNode listNode = myReverseBetween(listNode1, 1, 1);
        ListNode listNode = reverseBetween1(listNode1, 3, 5);

        ListNode tmp =listNode;
        System.out.println("======翻转后======");
        System.out.println("===="+tmp.val);
        while (null !=tmp.next){
            tmp=tmp.next;
            System.out.println("++++++"+tmp.val);

        }


    }

    /**
     * 自己写的方法：缺点是：
     * 1. 用元素本身做对比；
     * 2. 写死了循环次数6；
     * 3. 当链表节点小于等于2时，直接会出现空指针异常，直接加了if判断，也会出现链表无法翻转的问题；
     * @param head
     * @param left
     * @param right
     * @return
     */
    public static ListNode myReverseBetween(ListNode head, int left, int right) {

        //头节点之前在添加一个ListNode，就是我能遍历到head
        ListNode beforeHead = new ListNode(-1);
        beforeHead.next=head;
        ListNode tmp=beforeHead;
        //目标元素的上一个节点
        ListNode leftListNode = beforeHead;
        ListNode rightListNode = beforeHead;

        //循环找到指定的节点
        for (int i = 0; i < 6; i++) {
            if (tmp.next ==null){
                break;
            }
            if (left==tmp.next.val){
                leftListNode=tmp;
            }
            if (right==tmp.next.val){
                rightListNode=tmp;
            }
                tmp=tmp.next;
        }

            //目标节点
            ListNode leftTemp = leftListNode.next;
            ListNode rightTemp = rightListNode.next;

            //目标节点的下一个节点
            ListNode nextLeftNode = leftListNode.next.next;
            ListNode nextRightNode = rightListNode.next.next;

            //节点翻转
            leftListNode.next = rightTemp;
            rightTemp.next = nextLeftNode;

            rightListNode.next = leftTemp;
            leftTemp.next = nextRightNode;

        return head;
    }

    /**
     * 1. 要想链表的第一个节点也参与计算，则需要在链表第一个节点之前添加一个节点；
     * 2. 一次链表循环找到需要翻转的节点；
     * 3. 进行翻转操作；
     *      * 输入：head = [1,2,3,4,5], left = 2, right = 4
     * @param head
     * @param left
     * @param right
     * @return
     */
    public static ListNode reverseBetween1(ListNode head, int left, int right) {

        ListNode beforeHeadNode = new ListNode(-1);
        beforeHeadNode.next=head;

        //找到第一个需要翻转的元素的上一个，目的是为了截取子链表，所以left-1
        ListNode pre= beforeHeadNode;
        for (int i = 0; i < left - 1; i++) {
            pre=pre.next;
        }

        System.out.println("pre : " + pre.val);

        //在之前循环的链表基础上，找到第二个需要翻转的元素，目的是为了截取子链表,所以要right - left+1
        ListNode rightNode=pre;
        for (int i = 0; i < right - left+1; i++) {
            rightNode=rightNode.next;
        }

        System.out.println("rightNode : " + rightNode.val);



        //截取子链表(变量拉链袋啊哈哈)
        ListNode leftNode=pre.next;
        ListNode curr=rightNode.next;

        //切断链表
        pre.next=null;
        rightNode.next=null;

        //翻转,翻转完之后，leftNode该节点元素已经跑到最右边
        reverseLinkedList(leftNode);

        //接回原先的链表

        //这里比较难理解了，原因是：经过reverseLinkedList(leftNode)函数翻转后，由于没有函数没有返回变量，
        // 我可以用的首尾节点只能是leftListNode 和rightListNode变量，
        // 但此时leftListNode变量，所在的位置已经是rightListNode变量所在的位置，也就是最右端了；
        // 而rightListNode变量，所在的位置已经是leftListNode变量所在的位置，也就是最左端了;
        pre.next=rightNode;
        leftNode.next=curr;
        return beforeHeadNode.next;


    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {

      }
      ListNode(int val) {
          this.val = val;
      }
      ListNode(int val, ListNode next) {
          this.val = val;
          this.next = next;
      }
  }

    /**
     * 链表翻转
     * @param head
     */
    private  static  void reverseLinkedList(ListNode head){
        ListNode pre =null;
        ListNode curr=head;

        while (curr !=null){

            ListNode next=curr.next;
            curr.next=pre;
            pre=curr;
            curr=next;

        }

    }
}
