package com.zongfei;
/**
 * 20 用下栈 超简单
 */
import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chs = s.toCharArray();
        for(int i = 0; i < chs.length;i++){
        	if(chs[i]=='('||chs[i]=='['||chs[i]=='{'){
        		stack.push(chs[i]);
        	}
        	else{
        		if(chs[i]==')'){
        			if(stack.isEmpty()){
        				return false;
        			}
        			else{
        				char ch = stack.pop();
        				if(ch!='('){
        					return false;
        				}
        			}
        		}
        		else if(chs[i]==']'){
        			if(stack.isEmpty()){
        				return false;
        			}
        			else{
        				char ch = stack.pop();
        				if(ch!='['){
        					return false;
        				}
        			}
        		}
        		else if(chs[i]=='}'){
        			if(stack.isEmpty()){
        				return false;
        			}
        			else{
        				char ch = stack.pop();
        				if(ch!='{'){
        					return false;
        				}
        			}
        		}
        	}
        }
        if(stack.isEmpty()){
        	return true;
        }
        return false;
    }
    public static void main(String[] args){
    	String str = "([])";
    	Solution s  = new Solution();
    	System.out.println(s.isValid(str));
    }
}