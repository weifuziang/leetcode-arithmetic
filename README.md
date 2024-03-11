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

   2.2 搜索二维度矩阵

      a. 思路分析

         1. 在一维数组的解题思路的基础上，再次明确，行和列索引的左、中、右索引值，在遍历中的取值规则，同时，还要注意，每行数据搜索完之后，对于列索引要做初始化动作；

      b. 核心思想

         1. 做嵌套的 while + if 逻辑计算；
         2. 明确行和列对应的lef 、right、mid循环逻辑；
         3. 对于，每次行对于的列索引，搜索完，到新的行之后，要做列索引的初始化；
         4. 列索引的计算，在外层while和内层while循环中，都要做对应的逻辑处理；



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