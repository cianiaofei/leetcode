package com.ac;

/**
 * Definition for a binary tree node.
 */
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

public class Solution {
    public int maxPathSum(TreeNode root) {
        if(root==null){
        	return 0;
        }
        else{
        	return maxSum(root);
        }
    }

	private int maxSum(TreeNode root) {
		// TODO Auto-generated method stub
		if(root.left==null&&root.right==null){
			return root.val;
		}
		else{
			int withRootLeft = root.val + deepTraverse(root.left);
			int withRootRight = root.val + deepTraverse(root.right);
			int noRootLeft = 
		}
		return 0;
	}

	private int deepTraverse(TreeNode tn) {
		// TODO Auto-generated method stub
		if(tn==null){
			return 0;
		}
		else{
			return tn.val + Math.max(deepTraverse(tn.left),deepTraverse(tn.right));
		}
	}
    
}