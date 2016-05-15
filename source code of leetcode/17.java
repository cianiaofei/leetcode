package com.zongfei;
import java.util.ArrayList;
/**
 *dp问题  17
 */
import java.util.List;

public class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits==null||digits.length()==0){
        	return new ArrayList<String>();
        }
        else{
        	String[] dict = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz", ""};
        	List<StringBuilder> temp = new ArrayList<StringBuilder>();
        	for(int i = 0; i < digits.length();i++){
        		if(dict[digits.charAt(i)-'0']==""){
    				continue;
    			}
        		if(temp.isEmpty()){
        			char ch = dict[digits.charAt(i)-'0'].charAt(0);
        			for(int in = 0;in<dict[digits.charAt(i)-'0'].length();in++){
            			temp.add(new StringBuilder().append((char)(ch+in)));
            		}
        		}
        		else{
        			List<StringBuilder> tp = new ArrayList<StringBuilder>();
        			char ch = dict[digits.charAt(i)-'0'].charAt(0);
        			for(int offset = 0;offset<dict[digits.charAt(i)-'0'].length();offset++){
        				for(int in = 0; in < temp.size();in++){
        					tp.add(new StringBuilder(temp.get(in)).append((char)(ch+offset)));
        				}
        			}
        			temp = tp;
        		}
        	}
        	List<String> res = new ArrayList<String>();
        	for(int i = 0; i < temp.size();i++){
        		res.add(temp.get(i).toString());
        	}
        	return res;
        }
    }
    public static void main(String[] args){
    	Solution s = new Solution();
    	System.out.println(s.letterCombinations("23"));
    }
}




