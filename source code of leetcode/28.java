package com.zongfei;
/**
 *28  kmp算法
 */
public class Solution {
    public int strStr(String haystack, String needle) {
    	if(haystack==null){
    		return -1;
    	}
    	else if(needle==null||needle.length()==0){
    		return 0;
    	}
        return findIndex(haystack.toCharArray(),needle.toCharArray());
    }
    public int[] next(char[] t) {  
        int[] next = new int[t.length];  
        next[0] = -1;  
        int i = 0;  
        int j = -1;  
        while (i < t.length - 1) {  
            if (j == -1 || t[i] == t[j]) {  
                i++;  
                j++;  
                if (t[i] != t[j]) {  
                    next[i] = j;  
                } else {  
                    next[i] = next[j];  
                }  
            } else {  
                j = next[j];  
            }  
        }  
        return next;  
    }  
  
    
    public  int findIndex(char[] s, char[] t) {  
        int[] next = next(t);  
        int i = 0;  
        int j = 0;  
        while (i <= s.length - 1 && j <= t.length - 1) {  
            if (j == -1 || s[i] == t[j]) {  
                i++;  
                j++;  
            } else {  
                j = next[j];  
            }  
        }  
        if (j < t.length) {  
            return -1;  
        } else  
            return i - t.length; 
    }  
}  
