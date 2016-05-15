package com.zongfei;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 *很有意思的题目 241
 *主要是计算的先后顺序 没头绪   很难 
 *参考了一种比较好理解的做法是每一个操作符都可能是最后一个用来计算   好理解但是明显有重叠子问题存在 
 *实现是错误的   左右两边都有多种可能性
 */
public class Solution {
	Set<Integer> set = new HashSet<Integer>();
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<Integer>();
        if(input==null||input.length()==0){
        	;
        }
        else{
        	for(int i = 0; i < input.length();i++){
        		char ch = input.charAt(i);
        		if(((ch-'0')|('9'-ch))>=0){
        			//在0到9之间;
        		}
        		else{
        			switch(ch){
        				case '+':
        					res.add(calResult(input.substring(0,i))+
                					calResult(input.substring(i+1,input.length())));
        					break;
        				case '-':
        					res.add(calResult(input.substring(0,i))-
                					calResult(input.substring(i+1,input.length())));
        					break;
        				case '*':
        					res.add(calResult(input.substring(0,i))*
                					calResult(input.substring(i+1,input.length())));
        					break;
        			}
        		}
        	}
        }
        return res;
    }
    public int calResult(String str){
    	for(int i = 0; i < str.length();i++){
    		char ch = str.charAt(i);
    		if(((ch-'0')|('9'-ch))>=0){
    			//在0到9之间;
    		}
    		else{
    			switch(ch){
				case '+':
					return calResult(str.substring(0,i))+
        					calResult(str.substring(i+1,str.length()));
				case '-':
					return calResult(str.substring(0,i))-
        					calResult(str.substring(i+1,str.length()));
				case '*':
					return calResult(str.substring(0,i))*
        					calResult(str.substring(i+1,str.length()));
				
    			}
    		}
    	}
    	return Integer.valueOf(str);
    }
}