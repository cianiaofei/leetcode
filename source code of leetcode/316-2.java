package leetc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 316这个题得花了我好几天 搞得我想骂人
 * 细节考虑的足够清楚之后在写代码吧
 * 贪心算法  利用各字符最后一次出现的位置
 */
public class Solution {
    public String removeDuplicateLetters(String s) {
        if(s==null||s.length()<2){
        	return s;
        }
        else{
        	Set<Character> kinds = new HashSet<Character>();
        	List<Integer> lastPlace = new ArrayList<Integer>();
        	for(int i = s.length()-1; i > -1;i--){//
        		if(!kinds.contains(s.charAt(i))){
        			lastPlace.add(i);
        			kinds.add(s.charAt(i));
        		}
        	}//
        	StringBuilder sb = new StringBuilder();
        	storeSB(kinds,lastPlace,sb,s.toCharArray(),0);
        	return sb.toString();
        }
    }
    /**
     * 新增一个函数 找第一个 小于等于并且没出现过的字符
     */
    public int findNextPlace(char[] chs,int start,int end,Set<Character> used){
    	for(int i = start;i<end;i++){
    		if(chs[i]<=chs[end]&&used.contains(chs[i])){
    			return i;
    		}
    	}
    	for(int i = start;i<end;i++){
    		if(used.contains(chs[i])){
    			return i;
    		}
    	}
    	return end;
    }
    
    public void storeSB(Set<Character> kinds,List<Integer> lastPlace,StringBuilder sb, 
    		char[] chs,int start){
    	if(lastPlace.size()==0){
    		return;
    	}
    	else{
    		int curEnd = lastPlace.get(lastPlace.size()-1);
    		while(!lastPlace.isEmpty()){
    			if(!kinds.contains(chs[curEnd])){
    				lastPlace.remove(lastPlace.size()-1);
    				if(!lastPlace.isEmpty()){
    					curEnd = lastPlace.get(lastPlace.size()-1);
    				}
    				else{
    					return ;
    				}
    			}
    			else{
    				break;
    			}
    		}
    		int minPlace = findMinPlace(chs,start,curEnd,kinds);
    		if(chs[minPlace]==chs[curEnd]){
    			if(kinds.contains(chs[minPlace])){
    				sb.append(chs[minPlace]);
    				kinds.remove(chs[minPlace]);
    			}
    			lastPlace.remove(lastPlace.size()-1);
    			if(lastPlace.isEmpty()){
    				return ;
    			}
    			int end = lastPlace.get(lastPlace.size()-1);
    			storeSB(kinds,lastPlace,sb,chs,findNextPlace(chs,minPlace+1,end,kinds));
    		}
    		else{
    			if(chs[minPlace]<chs[curEnd]&&kinds.contains(chs[minPlace])){
					sb.append(chs[minPlace]);
					kinds.remove(chs[minPlace]);
				}
    			storeSB(kinds,lastPlace,sb,chs,findNextPlace(chs,minPlace+1,curEnd,kinds));
    		}
    	}
    }
    
	public int findMinPlace(char[] chs,int start,int end,Set<Character> kinds){
    	int minPlace = start;
    	for(int i = start+1; i <= end;i++){
    		if(chs[minPlace]>chs[i] && kinds.contains(chs[i])){
    			minPlace = i;
    		}
    	}
    	return minPlace;
    }
	
    public static void main(String[] args){
    	Solution s = new Solution();
    	System.out.println(s.removeDuplicateLetters("bxshkpdwcsjdbikywvioxrypfzfbppydfilfxxtouzzjxaymjpmdoevv"));
    }
}