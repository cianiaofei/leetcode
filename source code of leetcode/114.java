package com.ac;

import java.util.Stack;

/**
 * 貌似超简单  加个栈就可以
 * Definition for a binary tree node.
 * time limited
 */
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
public class Solution {
    public void flatten(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        while(!(p==null&&stack.isEmpty())){
        	if(p.left==null&&p.right==null){
        		if(stack.isEmpty()){
        			return;
        		}
        		p.right = stack.pop();
        	}
        	else{
        		if(p.right!=null){
            		stack.push(p.right);
            	}
            	else{}
            	
            	if(p.left!=null){
            		p.right = p.left;
            	}
            	else{
            		p.right = stack.pop();
            	}
        	}
        	p = p.right;
        }
    }
    public static void main(String[] args){
    	Solution s = new Solution();
    	TreeNode tn = new TreeNode(3);
    	s.flatten(tn);
    }
}