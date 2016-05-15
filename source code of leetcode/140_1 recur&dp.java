package com.ac;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
/**
 *140 类似分而治之的思想   time limit
 *dp 难点 在于 前面的未必就可以分解 并且引入新的字符之后会对原来产生影响
 *所以呢  只记录那些可以的
 *在这里递归中夹杂着dp很麻烦的
 */
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {
	private Map<String,List<String>> map = new HashMap<String,List<String>>();
	private List<String> res = new ArrayList<String>();
    public List<String> wordBreak(String s, Set<String> wordDict) {
    	if(s==null){
    		return res;
    	}
    	recurFunc(s,0,wordDict,"");
    	return res;
    }
	public void recurFunc(String s,int start, Set<String> wordDict, String str) {
		// TODO Auto-generated method stub
		if(wordDict.contains(s.substring(start))){
			res.add((str +" "+s).trim());
			if(map.containsKey(s.substring(start))){
				
			}
			for(int i = start; i < s.length()-1;i++){
				if(wordDict.contains(s.substring(start,i))){
					recurFunc(s,i,wordDict,str+" "+s.substring(start,i));
					if(map.containsKey(s.substring(0,i))){
						map.get(s.substring(0,i)).add(str);
					}
					else{
						ArrayList<String> temp = new ArrayList<String>();
						temp.add(str);
						map.put(s.substring(0,i),temp);
					}
				}
			}
		}
		else{
			for(int i = 0; i < s.length();i++){
				if(wordDict.contains(s.substring(0,i))){
					recurFunc(s.substring(i),wordDict,str+" "+s.substring(0,i));
				}
			}
		}
	}
	public static void main(String[] args){
		Solution solution = new Solution();
		String s = "catsanddog";
		String[] dict = {"cat", "cats", "and", "sand", "dog"};
		Set<String> set = new HashSet<String>();
		for(int i = 0; i < dict.length;i++){
			set.add(dict[i]);
		}
		solution.wordBreak(s,set);
		System.out.println(solution.res);
	}
}