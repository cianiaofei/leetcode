package com.zongfei;
/**
 *这个题蛮难的  因为可能存在多种分法并且最后只有一种是对的   
 *采用递归解决  每种都走一遍
 *139超时了
 */
import java.util.Set;

public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
    	if(s==null){
    		return false;
    	}
    	else{
    		for(int i = 0; i < s.length();i++){
    			if(wordDict.contains(s.substring(0,i))){
    				if(isWordBreak(s.substring(i,s.length()),wordDict)){
    					return true;
    				}
    			}
    		}
    	}
		return false;
    }
    public boolean isWordBreak(String str,Set<String> wordDict){
    	if(str==""){
    		return true;
    	}
    	else{
    		boolean canWordBreak = false;
    		for(int i = 1; i < str.length();i++){
    			if(wordDict.contains(str.substring(0,i))){
    				if(isWordBreak(str.substring(i,str.length()),wordDict)){
    					canWordBreak = true;
    					break;
    				}
    			}
    		}
    		return canWordBreak;
    	}
    }
}