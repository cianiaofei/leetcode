package com.zongfei;

import java.util.Stack;

/**
 *32 貌似想到一种简单的方法  
 *遍历一次就可以  中间不连续的可以通过某种手段隔开
 *将问题转化成另一个问题 很神奇的解法  这一步转换很巧妙
 */
public class Solution {
    public int longestValidParentheses(String s) {
    	if(s==null||s.length()==0){
    		return 0;
    	}
    	else{
    		Stack<Integer> stack = new Stack<>();
    		int[] transData = new int[s.length()];
    		char[] chs = s.toCharArray();
    		for(int i = 0; i < chs.length;i++){//for
    			if(chs[i]=='('){
    				stack.push(i);
    			}
    			else{
    				if(!stack.isEmpty()){
    					transData[i] = 1;
    					transData[stack.pop()] = 1;
    				}
    			}
    		}//for
    		int sum = 0;
    		int maxSum = 0;
    		for(int i = 0; i < transData.length;i++){
    			if(transData[i]==1){
    				sum++;
    			}
    			else{
    				maxSum = Math.max(sum,maxSum);
    				sum = 0;
    			}
    		}
    		maxSum = Math.max(sum,maxSum);
    		return maxSum;
    	}//else
    }
    public static void main(String[] args){
    	Solution s = new Solution();
    	System.out.println(s.longestValidParentheses("()(())"));
    }
}