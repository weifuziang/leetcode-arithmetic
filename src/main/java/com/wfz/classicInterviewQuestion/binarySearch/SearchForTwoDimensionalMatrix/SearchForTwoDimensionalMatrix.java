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
        int[][] matrix={{1,3,5,7},{10,11,16,20},{23,30,34,60}};
//        int target=3;
        int target=60;
        System.out.println(MySearchMatrix(matrix,target));

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
}
