学习的内容：
1. 面试经典150道题： https://leetcode.cn/studyplan/top-interview-150/
   

系统学习内容：《面试经典150道题》
1. 数组/字符串
    
   1.1 合并两个有序数组 com.wfz.classicInterviewQuestion.ArrayString.mergeTwoSortedArrays.MergeTwoSortedArrays
   
        a. 思路分析
            两个有序的队列，合并成一条队d'f'd'j'fa'j列，只需要使用双指针，依次取两个队列中的元素，谁大，则留下谁，小的下次继续比；
   
        b. 核心思想
            1. 双指针变量，谁被移除，则指针下移一次，没有被移除的，指针不变；
            2. 使用一次while + if 处理；
            3. while处理是：只要两个指针任意一个没有到尽头，就一直循环下去；
            4. if的处理是：区分指针不同状态下的处理逻辑；
   
   1.2 移除元素 com.wfz.classicInterviewQuestion.ArrayString.removeElement.RemoveElement

        a. 思路分析：
   
            要求有最优解，则需要看清题目中，对于最后的数组是可以乱序的，只需要计算出不等于val的数据即可；

        b. 核心思想：

            1. 双针遍历时，可以考虑首尾各一个，同时向中间遍历，可以减少时间复杂度，具体编程中可使用while（left <= right）；
            2. 紧扣题目的要求，可允许结果数组的乱序来，来促使我们找到最优解的思路；
            3. 题目虽为移除元素，实则可以只做物理删除，覆盖数组前面的元素，后面的没用的元素可以放着，不做任何处理

   1.3 删除有序数组中的重复项 com.wfz.classicInterviewQuestion.ArrayString.removeDuplicatesInOrderedAraay.RemoveDuplicatesInOrderedAraay

      a. 思路分析
            
         1. 前提是有序的数组，则即使是有相同的元素也是紧密相连的，
         2. 因此相同元素的删除，也就是比较前后两个元素，
         3. 如果不相同，则把后者元素放到前者元素的下一个位置即可；

      b. 核心思想
         1. 比较一个数组中两个元素的是，直接使用双指针+while；
         2. 指针p1是慢指针，若比较后的元素，不相同，则存储的位置p1+1；
         3. 指针p2是快指针,需要不停的前进，获取新的元素和慢指针p1做比较的；
         4. 只是逻辑删除，做数组的覆盖，后面需要的元素可以继续存储在数组后面；

2. 二分查找   
   
   2.1 搜索插入位置 com.wfz.classicInterviewQuestion.binarySearch.searchForInsertionLocation.SearchForInsertionLocation
      
      a. 思路分析

         1. 常规的二分查找方法使用

      b. 核心思想

         1. 二分查找需要的变量是：left mid right 因此，可以在刚开始的时候就把变量名创建好；
         2. 可以使用while(left <= right)做为循环判断的条件；
         3. 中间元素的寻找一定是mid=（left + right）/2
         4. 如果没有找到target，那么插入位置一定是left指定的指针值，因为,在升序的数组中，left=mid+1应该是符合要求的最后一次计算；
         5. 如果是降序，那就应该是right=mid-1了；

   2.2 搜索二维度矩阵 com.wfz.classicInterviewQuestion.binarySearch.SearchForTwoDimensionalMatrix.SearchForTwoDimensionalMatrix

      a. 思路分析

         1. 自己的思路：在一维数组的解题思路的基础上，再次明确，行和列索引的左、中、右索引值，在遍历中的取值规则，同时，还要注意，每行数据搜索完之后，对于列索引要做初始化动作；
         2. 优化后的思维： 由于行和列都是递增的序列，因此，可以首先拿出第一列，做二分查找，找到一个不大于target的最小元素x，获取x元素对应的行数据，再进行该行数据的二分查找即可；

      b. 核心思想

         自己的思路：
   
         1. 做嵌套的 while + if 逻辑计算；
         2. 明确行和列对应的lef 、right、mid循环逻辑；
         3. 对于，每次行对于的列索引，搜索完，到新的行之后，要做列索引的初始化；
         4. 列索引的计算，在外层while和内层while循环中，都要做对应的逻辑处理；

         优化后的思路：

         1. 寻找元素可能存在的目标行过程中，可以类比之前做过的，如果二分查找过程中，如果没有找到，可以使用返回可插入的位置；
         2. 由于列级别也是递增的，所以，可能存在的行索引，最后一定是：left-1

3. 链表

      3.1 链表翻转11 com.wfz.classicInterviewQuestion.linkList.flipList.FlipList2

      a. 思路分析 
         1. 此问题是要翻转一段链表中，某一截的元素，因此，首选要做的就是先找到这一截链表的开始和结束元素的位置；
         2. 当找到开始和结束的元素之后，我们要记录的是变量是，链表开始元素leftListNode的前一个元素pre，以及链表结束元素rightListNode，此时做的目的是为了方便截取链表；
         3. 截取之后，做被截取链表的翻转，具体思路看《3.2 链表翻转》,截取元素操作为：pre.next=null,rightListNode.next=null,当然,在截取需要的链表之前，也要记录一下截取前后的链表，即，
            leftListNode=pre.next,curr=rightListNode.next；
         4. 翻转后的链表，由于没有返回新的链表名称（也没有必要，如果有新的，又需要找新链表的开始和结束的位置了），因此，此时的开始位置放的是翻转后的结束元素，
            此时的结束位置放的是链表翻转后的开始元素（自我理解，"同位不同值"）；
         5. 截断链表的接回操作，根据上述《4.》的思想，preListNode.next=rightListNode;leftListNode.next=curr

      b. 核心思想
         1. 链表截取再接上的思路；
         2. 截取链表时，要记录在截取操作中，前中后各个范围段的链表；
         3. 极端情况，为了链表的第一个元素，也能正常的参与计算，所以，我们需要在链表的开始位置模拟出来一个虚拟的元素，即，   ListNode beforeHead = new ListNode(-1);

      3.2 链表翻转 com.wfz.classicInterviewQuestion.linkList.flipList.FlipList
      
      a. 思路分析
         1. 需要重新命名一个变量pre=null, 然后，在该变量上做target链表的翻转操作；
         2. 具体的翻转操作，就是需要 while 循环，需要不停的在pre前面追加元素，同时也需要pre元素不停的指向target链表的next元素；
   
      b. 核心思想
         1. 需要另起炉灶，慢慢挨个追加;同时，也要接住next元素，来持续循环遍历;
         2. while循环需要有动态变化的变量值持续判断，即所谓的指针curr;
         2. pre=null ; curr=head; while(curr !=null){ next=curr.next;curr.next=pre;pre=curr;curr=next}
   
      3.3 删除链表的倒数第N个节点 com.wfz.classicInterviewQuestion.linkList.deleteLinkedList.delNthElement

        a. 思路分析
             1. 需要找到倒数第N个节点，首先需要找到链表的长度，然后，再找到倒数第N个节点；
             2. 找到倒数第N个节点后，需要找到倒数第N个节点的前一个节点，然后，将前一个节点的next指向倒数第N个节点的next即可；
             3. 为了方便操作，我们需要在链表的头部添加一个虚拟节点，即，ListNode beforeHead = new ListNode(-1);beforeHead.next=head;
             4. 在进行链表循环，查找前一个节点时，我们在for循环里主要操作的就是 初始的i值，或者边界值length-n,当然具体的for循环可以是
                for(int i=0;i<length-n;i++)或者for(int i=1;i<length-n;i++)；
        b. 核心思想
             1. 链表在进行循环找到目标节点时，需要记录原始的链表，因此需要重新定义一个变量，来记录原始的链表，此时新变量的链表和旧链表的变量实际上在存储空间上指向了同一个链表，
                因此新变量指向的量表，发生了变化，旧链表也是会跟着发生变化的；
             2. 链表循环的方式，curr=curr.next,这种方式，可以在循环中，不断的更新curr的值，来实现链表的遍历,此时只做了循环，不会对原始链表的结构造成影响；
   

       3.4 环形链表 com/wfz/classicInterviewQuestion/linkList/queryLinkendList/CircularLinkedListDiscovery.java

         a. 思路分析
            方法1： 1. 直接用哈希表hashset（可自动去重）来存储链表的节点，如果有重复的节点，那么就是环形链表；
                   2. 且其中hashset的add()方法在添加的时候，如果里面有已经存在的元素，则会返回false；
   
            方法2： 1. 快慢指针法，快指针每次走两步，慢指针每次走一步，如果有环，那么快慢指针一定会相遇；

         b. 核心思想
            1. 方法1 主要是借用外部存储空间，可自动去重的特性，来判断链表是否有环；
            2. 方法2 主要是通过快慢指针的方式，来判断链表是否有环；其中，要考虑到快慢指针只有相差一步，才一定能相遇；
               对于初始化fast和slow指针的位置，要考虑到，fast和slow指针的位置，要么在链表的头部，要么在链表的第二个元素位置，这主要取决于你用"while do" 还是"do while"循环体了；


   
4. 树

    4.1 二叉树的最大深度

    a. 思路分析
        从根节点开始，依次递归遍历左右子树，每次递归的深度+1，最后返回最大的深度值；
    b. 核心思想
       递归过程中，要深刻理解方法的入栈和出栈；
   




实战面试题复盘：
1. com.wfz.primary -- 初级水平题目
   
    1.1 买卖股票的最佳时机 com.wfz.primary.StockPurchase                                  
   
        a. 思路分析:
        
        b. 核心思想
    
    1.2 买卖股票的最佳时机2 com.wfz.primary.StockPurchase2
    
    1.3 两数之和 com.wfz.primary.TwoNumberSum
    
    1.4 拼写单词 com.wfz.primary.WordSpelling
   
        a. 思路分析:
        
        b. 核心思想
            使用hash表解决问题
    
    1.5 最长回文子串 com.wfz.primary.LongestPalindrome
    
    


2. com.wfz.medium -- 中级水平题目


3. com.wfz.higherlevel -- 高级水平题目