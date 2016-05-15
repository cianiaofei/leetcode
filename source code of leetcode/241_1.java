package com.zongfei;

import java.util.ArrayList;
import java.util.List;
/**
 *很有意思的题目 241
 *这个题主要是不好找突破口    如果能想到   一个操作符要么最后计算要么不是就ok了
 *从操作符下手  而不是括号
 *主要是计算的先后顺序 没头绪   很难 
 *参考了一种比较好理解的做法是每一个操作符都可能是最后一个用来计算   好理解但是明显有重叠子问题存在 
 */
public class Solution {
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
        			List<Integer> leftList = calResult(input.substring(0,i));
        			List<Integer> rightList = calResult(input.substring(i+1,input.length()));
        			switch(ch){
    				case '+':
    					func(leftList,rightList,res,'+');
    					break;
    				case '-':
    					func(leftList,rightList,res,'-');
    					break;
    				case '*':
    					func(leftList,rightList,res,'*');
        			}
        		}
        	}
        }
        if(res.isEmpty()){
        	res.add(Integer.valueOf(input));
        }
        return res;
    }
    public List<Integer> calResult(String str){
    	List<Integer> list = new ArrayList<Integer>();
    	for(int i = 0; i < str.length();i++){
    		char ch = str.charAt(i);
    		if(((ch-'0')|('9'-ch))>=0){
    			//在0到9之间;
    		}
    		else{
    			List<Integer> leftList = calResult(str.substring(0,i));
    			List<Integer> rightList = calResult(str.substring(i+1,str.length()));
    			switch(ch){
				case '+':
					func(leftList,rightList,list,'+');
					break;
				case '-':
					func(leftList,rightList,list,'-');
					break;
				case '*':
					func(leftList,rightList,list,'*');
					break;
    			}
    		}
    	}
    	if(list.isEmpty()){
    		list.add(Integer.valueOf(str));
    	}
    	return list;
    }
    public void func(List<Integer> left,List<Integer> right,
    		List<Integer> list,Character ch){
    	switch(ch){
    		case '+':
    			for(int i = 0; i < left.size();i++){
    				for(int j = 0; j < right.size();j++){
    					list.add(left.get(i)+right.get(j));
    				}
    			}
    		break;
    		case '-':
    			for(int i = 0; i < left.size();i++){
    				for(int j = 0; j < right.size();j++){
    					list.add(left.get(i)-right.get(j));
    				}
    			}
    		break;
    		case '*':
    			for(int i = 0; i < left.size();i++){
    				for(int j = 0; j < right.size();j++){
    					list.add(left.get(i)*right.get(j));
    				}
    			}
    		break;
    	}
    }
    public static void main(String[] args){
    	String input = "2*3-4*5";
    	Solution s = new Solution();
    	System.out.println(s.diffWaysToCompute(input));
    }
}