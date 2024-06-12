package com.wfz.classicInterviewQuestion.tree.binaryTree;

/**
 * 给定一个二叉树 root ，返回其最大深度。
 *
 * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
 *
 * 示例 1：
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：3
 *
 * 示例 2：
 *
 * 输入：root = [1,null,2]
 * 输出：2
 *
 *
 * 提示：
 *
 *     树中节点的数量在 [0, 104] 区间内。
 *     -100 <= Node.val <= 100
 */
public class maximumDepthOfaBinaryTree {
    public static void main(String[] args) {

//        TreeNode root = new TreeNode(3);
//        TreeNode leftRoot1 = new TreeNode(9);
//        TreeNode rightRoot1 = new TreeNode(20);
//        root.left=leftRoot1;
//        root.right=rightRoot1;
//        TreeNode leftRoot2 = new TreeNode(15);
//        TreeNode rightRoot2 = new TreeNode(7);
//        rightRoot1.left=leftRoot2;
//        rightRoot1.right=rightRoot2;
//        TreeNode leftRoot3 = new TreeNode(1);
//        TreeNode rightRoot3 = new TreeNode(2);
//        leftRoot1.left=leftRoot3;
//        leftRoot1.right=rightRoot3;
//        TreeNode leftRoot4 = new TreeNode(4);
//        TreeNode rightRoot4 = new TreeNode(9);
//        leftRoot3.left=leftRoot4;
//        leftRoot3.right=rightRoot4;
//
//
//        int depth = maxDepth(root);
//        System.out.println(depth);



        int depth1 = maxDepth(10);
        System.out.println(depth1);

    }

    public static int maxDepth(TreeNode root){

        if (root == null ){
            return 0;
        }else{
            int left=maxDepth(root.left);
            int right=maxDepth(root.right);
            return Math.max(left ,right) +1;
        }

    }



    public static int maxDepth(int root){

        if (root <= 0 ){
            return 0;
        }else{
            root=root-3;
            int left=maxDepth(root);
            return left +1;
        }

    }
}

  class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){};
    TreeNode(int val){this.val=val;}
    TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }

}
