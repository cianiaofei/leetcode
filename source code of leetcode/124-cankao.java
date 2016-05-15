package com.ac;

/**
 * Definition for a binary tree node.
 * ������һ�ַ�ʽ˼���������
 * ÿ���㶼����Ϊ��   ȫ������һ��ȡ����
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
			return root.val + Math.max(left,right);//������ҵ�һ����֧
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