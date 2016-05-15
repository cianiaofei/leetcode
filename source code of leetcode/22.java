package com.zongfei;
/**
 *22 dp问题
 *变量生命周期如果不注意有时还是挺坑的 
 */
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(n==0){
        	return new ArrayList<String>();
        }
        else{
        	res.add(new ArrayList<String>());
        	List<String> inList = new ArrayList<String>();
        	inList.add("()");
        	res.add(inList);
        	for(int i = 2; i <= n;i++){
        		List<String> temp = new ArrayList<String>();
        		for(int left = 1; left <= i;left++){
        			List<String> ll = res.get(left-1);
        			List<String> cur = new ArrayList<String>(ll);
        			if(left==1){
        				StringBuilder sb = new StringBuilder();
        				sb.append("()");
        				List<String> right = res.get(i-left);
        				for(int rt = 0; rt < right.size();rt++){
        					StringBuilder ss = new StringBuilder(sb);
                			ss.append(right.get(rt));
                			temp.add(ss.toString());
        				}
        			}
        			while(!cur.isEmpty()){
        				StringBuilder sb = new StringBuilder();
        				String inner = cur.remove(0);
    					sb.append('(');
            			sb.append(inner);
            			sb.append(')');
        				List<String> right = res.get(i-left);
        				boolean flag = false;
        				for(int rt = 0; rt < right.size();rt++){
        					StringBuilder ss = new StringBuilder(sb);
                			ss.append(right.get(rt));
                			flag = true;
                			temp.add(ss.toString());
        				}
        				if(!flag){
        					temp.add(sb.toString());
        				}
        			}
        		}
        		res.add(temp);
        	}
        }
        return res.get(n);
    }
    public static void main(String[] args){
    	Solution s = new Solution();
    	System.out.println(s.generateParenthesis(4));
    }
}