package com.zongfei;
import java.util.HashSet;
/**
 *动态规划的处理方法 
 *主要是考虑边界问题
 *139效率仍然是 不高   
 */
import java.util.Set;

public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
    	if(s==null){
    		return false;
    	}
    	else{
    		boolean[] canBeBreak = new boolean[s.length()];
    		if(wordDict.contains(s.substring(s.length()-1,s.length()))){
    			canBeBreak[s.length()-1] = true;
    		}
    		for(int i = s.length()-1; i>=0;i--){
    			String curStr = s.substring(i,s.length());
    			for(int in = 1; in<=curStr.length();in++){
    				if(wordDict.contains(curStr.substring(0,in))){
    					if(in+i==s.length()){
    						canBeBreak[i] = true;
    					}
    					else{
    						if(canBeBreak[in+i]==true){
    							canBeBreak[i] = true;
    						}
    					}
    				}
    			}
    		}
    		return canBeBreak[0];
    	}
    }
    public static void main(String[] args){
    	String str = "leetcode";
    	Set<String> wordDict = new HashSet<>();
    	Solution s = new Solution();
    	wordDict.add("leet");
    	wordDict.add("code");
    	System.out.println(s.wordBreak(str, wordDict));
    }
}