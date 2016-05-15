package com.ac;
import java.util.ArrayList;
import java.util.HashSet;
/**
 *140 类似分而治之的思想   time limit
 */
import java.util.List;
import java.util.Set;

public class Solution {
	private List<String> res = new ArrayList<String>();
    public List<String> wordBreak(String s, Set<String> wordDict) {
    	if(s==null){
    		return res;
    	}
    	recurFunc(s,wordDict,"");
    	return res;
    }
	public void recurFunc(String s, Set<String> wordDict, String str) {
		// TODO Auto-generated method stub
		if(wordDict.contains(s)){
			res.add((str +" "+s).trim());
			for(int i = 0; i < s.length()-1;i++){
				if(wordDict.contains(s.substring(0,i))){
					recurFunc(s.substring(i),wordDict,str+" "+s.substring(0,i));
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