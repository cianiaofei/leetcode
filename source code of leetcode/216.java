/*
 * 216 还是递归  每个要么用要么不用
*/
package leetc;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	List<List<Integer>> result = new ArrayList<List<Integer>>();
	List<String> list = new ArrayList<String>();
    public List<List<Integer>> combinationSum3(int k, int n) {
    	String str = "";
    	combination(k,n,1,str);
    	for(int i = 0; i < list.size();i++){
    		result.add(strToInt(list.get(i)));
    	}
        return result;
    }
    public List<Integer> strToInt(String str){
    	List<Integer> list = new ArrayList<Integer>();
    	String[] result = str.split(",");
    	for(int i = 0; i < result.length;i++){
    		if(!result[i].equals("")){
    			list.add(Integer.valueOf(result[i]));
    		}
    	}
    	return list;
    }
    public void combination(int k,int n,int index,String str){
    	if(index>9||k==0){
    		return;
    	}
    	else{
    		int dis = n - index;
    		if(dis<0){
    			return ;
    		}
    		else{
    			if(dis==0&&k==1){
    				str += ","+index;
    				list.add(str);
    				return;
    			}
    			else if(dis==0&&k!=1){
    				return ;
    			}
    			else if(dis!=0&&k==1){
    				combination(k,n,++index,str);
    			}
    			else{
    				combination(k,n,index+1,str);
    				str += ","+index;
    				combination(--k,dis,++index,str);
    			}
    		}
    	}
    }
    public static void main(String[] args){
    		Solution s = new Solution();
    		System.out.println(s.combinationSum3(3,8));
    }
}