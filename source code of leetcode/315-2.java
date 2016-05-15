package com.zongfei;

import java.util.LinkedList;
import java.util.List;
/**
 *简单 从右往前 构造一个二叉排序树 貌似连续数组的二分查找  和 非线性结构的 二叉排序树挺像的  avl更好
 * 时间复杂度O(nlogn) 
 * 想错了 还是得用调表   二叉查找树  查找还可以  计算比它小的个数很麻烦
 * 用调表更不好做   加个哈希表貌似可以达到这个时间复杂度
 */
public class Solution {
	class TreeNode{
		int curValue;
		int count;
		TreeNode left;
		TreeNode right;
		int minThanIt;
		TreeNode(int curValue,int count){
			this.curValue = curValue;
			this.count = count;
		}
		TreeNode(){
			
		}
	}
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> list = new LinkedList<>();
        TreeNode tn = null;
        for(int i = nums.length-1;i>=0;i--){
        	if(i==nums.length-1){
        		tn = buildBT(tn,null,nums[i],list);
        	}
        	tn = buildBT(tn,null,nums[i],list);
        }
        return list;
    }
    //二叉排序树 又名二叉查找树
    public TreeNode buildBT(TreeNode root,TreeNode parent,int value,List<Integer> list){
    	if(root==null){
    		if(parent.curValue>value){
    			parent.left = new TreeNode(value,1);
    		}
    		else{
    			parent.right = new TreeNode(value,1);
    		}
    		if(parent==null){
    			list.add(0,0);
    		}
    		else if(root.curValue>parent.curValue){
    			int tnValue = parent.minThanIt + parent.count;
    			root.minThanIt = tnValue;
    			list.add(0,tnValue);
    		}
    		else{
    			int tnValue = parent.minThanIt - parent.count;
    			root.minThanIt = tnValue;
    			list.add(0,tnValue);
    		}
    	}
    	else{
    		if(root.curValue==value){
    			root.count++;
    			if(parent==null){
    				list.add(0,0);
    			}
    			else if(root.curValue>parent.curValue){
        			int tnValue = parent.minThanIt + parent.count;
        			root.minThanIt = tnValue;
        			list.add(0,tnValue);
        		}
        		else{
        			int tnValue = parent.minThanIt - parent.count;
        			root.minThanIt = tnValue;
        			list.add(0,tnValue);
        		}
    		}
    		else if(root.curValue>value){
    			root.minThanIt++;
    			buildBT(root.left,root,value,list);
    		}
    		else{
    			buildBT(root.right,root,value,list);
    		}
    	}
    	return root;
    }
    public static void main(String[] args){
    	Solution s = new Solution();
    	int[] nums = {5,2,6,1};
    	System.out.println(s.countSmaller(nums));
    }
}