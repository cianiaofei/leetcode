package com.ac;


/**
 * 递归很神奇   先把框架搞出来 再去考虑细节对不对
 */
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
public class Solution {
    public void flatten(TreeNode root) {
    	if(root==null){
    		return ;
    	}
    	flatten(root.left);
    	flatten(root.right);
    	if(root.left==null){
    		return;
    	}
    	else{
    		TreeNode tmp = root.right;
    		root.right = root.left;
    		root.left = null;
    		while(root.right!=null){
    			root = root.right;
    		}
    		root.right = tmp;
    	}
    }
    public static void main(String[] args){
    	Solution s = new Solution();
    	TreeNode tn = new TreeNode(3);
    	s.flatten(tn);
    }
}