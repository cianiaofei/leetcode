package com.ac;

import java.util.HashMap;
import java.util.Map;

/**
 *299太简单了 没意思 
 */
public class Solution {
    public String getHint(String secret, String guess) {
    	Map<Character,Integer> map = new HashMap<Character,Integer>();
    	for(int i = 0; i < secret.length();i++){
    		if(map.containsKey(secret.charAt(i))){
    			int value = map.get(secret.charAt(i));
    			value++;
    			map.put(secret.charAt(i), value);
    		}
    		else{
    			map.put(secret.charAt(i),1);
    		}
    	}
    	int bulls = 0;
    	int cows = 0;
    	int index = 0;
    	while(index<secret.length()&&index<guess.length()){
    		if(guess.charAt(index)==secret.charAt(index)){
    			bulls++;
    			int temp = map.get(guess.charAt(index)) - 1;
    			if(temp==0){
    				map.remove(guess.charAt(index));
    			}
    			else{
    				map.put(guess.charAt(index),temp);
    			}
    		}
    		index++;
    	}
    	index = 0;
    	while(index<secret.length()&&index<guess.length()){
    		if(guess.charAt(index)!=secret.charAt(index)){
    			if(map.containsKey(guess.charAt(index))){
    				cows++;
    				int temp = map.get(guess.charAt(index)) - 1;
        			if(temp==0){
        				map.remove(guess.charAt(index));
        			}
        			else{
        				map.put(guess.charAt(index),temp);
        			}
    			}else{}
    		}
    		index++;
    	}
    	StringBuilder sb = new StringBuilder();
    	sb.append(bulls);
    	sb.append('A');
    	sb.append(cows);
    	sb.append('B');
        return sb.toString();
    }
    
    public static void main(String[] args){
    	Solution s = new Solution();
    	System.out.println(s.getHint("1122", "1222"));
    }
}