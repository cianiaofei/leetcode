package com.ac;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	private List<List<String>> res = new ArrayList<List<String>>();
    public List<List<String>> partition(String s) {
    	if(s==null||s.length()==0){
    		return res;
    	}else{
    		for(int i = 0; i < s.length();i++){
    			if(isPlain(s.substring(0,i+1))){
    				String tmp = s.substring(0,i+1);
    				recurFunc(s.substring(i+1),tmp);
    			}
    		}
    		return res;
    	}
    }
    
    private void recurFunc(String str, String tmp) {
		// TODO Auto-generated method stub
		if(str.equals("")){
			StringToList(tmp);
		}else{
			for(int i = 0; i < str.length();i++){
				if(isPlain(str.substring(0,i+1))){
					recurFunc(str.substring(i+1),tmp+","+str.substring(0,i+1));
				}
			}
		}
	}
    

	private void StringToList(String tmp) {
		// TODO Auto-generated method stub
		String[] arrStr = tmp.split(",");
		List<String> list = new ArrayList<>();
		for(String str:arrStr){
			list.add(str);
		}
		res.add(list);
	}
	

	/**
     *判断是否为回文数 
     */
    public boolean isPlain(String str){
    	int start = 0,end = str.length()-1;
    	while(start<end){
    		if(!(str.charAt(start)==str.charAt(end))){
    			return false;
    		}
    		start++;
    		end--;
    	}
    	return true;
    }
    
    public static void main(String[] args){
    	Solution s = new Solution();
    	String str = "aab";
    	System.out.println(s.partition(str));
    }
}