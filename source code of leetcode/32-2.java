package com.zongfei;

import java.util.Stack;

/**
 *32 貌似想到一种简单的方法  
 *遍历一次就可以  中间不连续的可以通过某种手段隔开
 */
public class Solution {
    public int longestValidParentheses(String s) {
    	if(s==null||s.length()==0){
    		return 0;
    	}
    	else{
    		Stack<Character> stack = new Stack<>();
    		char[] chs = s.toCharArray();
    		int maxSum = 0;
    		int sum = 0;
    		for(int i = 0; i < chs.length;i++){
    			if(chs[i]=='('){
    				stack.push(chs[i]);
    			}
    			else{
    				if(!stack.isEmpty()&&stack.peek()=='('){
    					stack.pop();
    					if(stack.isEmpty()||stack.peek()!='0'){
    						sum = 2;
    						maxSum = Math.max(maxSum,sum);
    					}
    					else{
    						sum += 2;
    						maxSum = Math.max(maxSum,sum);
    					}
    					stack.push('0');
    				}
    				else{
    					stack.push(chs[i]);
    				}
    			}
    		}
    		return maxSum;
    	}
    }
    public static void main(String[] args){
    	Solution s = new Solution();
    	System.out.println(s.longestValidParentheses("()(())"));
    }
}