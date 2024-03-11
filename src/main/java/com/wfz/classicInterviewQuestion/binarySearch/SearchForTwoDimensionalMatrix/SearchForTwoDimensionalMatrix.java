package com.wfz.classicInterviewQuestion.binarySearch.SearchForTwoDimensionalMatrix;

public class SearchForTwoDimensionalMatrix {
    /**
     * 给你一个满足下述两条属性的 m x n 整数矩阵：
     *
     *     每行中的整数从左到右按非严格递增顺序排列。
     *     每行的第一个整数大于前一行的最后一个整数。
     *
     * 给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false
     *
     * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
     * 输出：true
     *
     * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
     * 输出：false
     * @param args
     */
    public static void main(String[] args) {
        int[][] matrix={{1,3,5,7},{10,11,16,20},{23,30,34,60},{65,75,80,81}};
//        int target=3;
        int target=20;
//        System.out.println(MySearchMatrix(matrix,target));
        System.out.println(searchMatrix(matrix,target));

    }

    /**
     * 自己的解题思路，在一维数组的解题思路的基础上，再次明确，行和列索引的左、中、右索引值，在遍历中的取值规则，
     * 同时，还要注意，每行数据搜索完之后，对于列索引要做初始化动作；
     * @param matrix
     * @param target
     * @return
     */
    public static boolean MySearchMatrix(int[][] matrix, int target) {

        //列数
        int left=0;
        int right=matrix[0].length-1;

        //行数
        int up=0;
        int down=matrix.length-1;

        //行级别数据的判断
        while (up <=down){

            int mid2=(up + down)/2;
            int mid1 =(right+left)/2;
            if (target == matrix[mid2][mid1]){
                return true;
            }

            if (target <= matrix[mid2][mid1]){
                down=mid2-1;
            }else{
                up=mid2+1;
            }
            //列级别数据的判断
            while (left<=right){

                if (target == matrix[mid2][mid1]){
                    return true;
                }
                if (target <= matrix[mid2][mid1]){
                    right=mid1-1;
                }else{
                    left=mid1+1;
                }
                mid1 =(right+left)/2;
            }
            //每行数据做完判断之后，代表列的索引要做一次初始化
             left=0;
             right=matrix[0].length-1;

        }

        return false;
    }


    /**
     * standard optimal solution : 整个矩阵从左到右递增矩阵，因此第一步，可以直接拿第一列数据，做一个二分查找，
     * 找出一个不大于target元素的行索引，然后在此行索引的基础上，继续使用二分查找的方法去找对应的元素；
     * 重点强调的是：在进列级别的二分查找，找到目标的行索引时，最终需要的目标行索引一定是lef-1，因为，即使在列查找中也是递增的序列；
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrix(int[][] matrix, int target) {

        int rowIndex = columSearh(matrix, target);
        System.out.println(rowIndex);

       return rowSearch(matrix,rowIndex,target);

    }

    public static  int columSearh(int[][] matrix, int target){

        int low =0;
        int high=matrix.length-1;
        while (low <= high){
            int mid=((high-low)/2 +low);
            if (matrix[mid][0] == target){
                return mid;
            }
            if (matrix[mid][0] < target){
                low=mid +1;
            }else{
                high=mid-1;
            }
        }

        return low-1;



    }

    public static  boolean rowSearch(int[][] matrix, int rowIndex, int target){


        int left =0;
        int right=matrix[rowIndex].length-1;
        while (left <= right){
            int mid=((right-left)/2 +left);
            if (matrix[rowIndex][mid] == target){
                return true;
            }
            if (matrix[rowIndex][mid] < target){
                left=mid +1;
            }else{
                right=mid-1;
            }
        }

        return false;

    }


    }
