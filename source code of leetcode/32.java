package com.zongfei;

import java.util.Stack;

/**
 *32 
 */
public class Solution {
    public int longestValidParentheses(String s) {
    	if(s==null||s.length()==0){
    		return 0;
    	}
    	else{
    		Stack<Character> stack = new Stack<>();
    		char[] chs = s.toCharArray();
    		int sum = 0;
    		for(int i = 0; i < chs.length;i++){
    			if(chs[i]=='('){
    				stack.push(chs[i]);
    			}
    			else{
    				if(!stack.isEmpty()&&stack.peek()=='('){
    					stack.pop();
    					sum += 2;
    				}
    				else{
    					stack.push(chs[i]);
    				}
    			}
    		}
    		return sum;
    	}
    }
    public static void main(String[] args){
    	Solution s = new Solution();
    	System.out.println(s.longestValidParentheses("()(()"));
    }
}