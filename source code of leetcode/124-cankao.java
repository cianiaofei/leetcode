package com.ac;

/**
 * Definition for a binary tree node.
 * 用另外一种方式思考这个问题
 * 每个点都可能为根   全部遍历一遍取最大的
 */
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

public class Solution {
	int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root==null){
        	return 0;
        }
        else{
        	maxSum(root);
        	return max;
        }
    }

	private int maxSum(TreeNode root) {
		// TODO Auto-generated method stub
		if(root==null){
			return Integer.MIN_VALUE;
		}
		else{
			int left = Math.max(maxSum(root.left),0);
			int right = Math.max(maxSum(root.right),0);
			max = Math.max(max,root.val+left+right);
			return root.val + Math.max(left,right);//左或者右的一个分支
		}
	}
	public static void main(String[] args){
		Solution s = new Solution();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		System.out.println(s.maxPathSum(root));
	}
}