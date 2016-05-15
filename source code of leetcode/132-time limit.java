package com.ac;


public class Solution {
	
	private int min = Integer.MAX_VALUE;
	
	public int minCut(String s) {
		if(s==null||s.length()==0||isPlain(s)){
			return 0;
		}else{
			for(int i = 0; i < s.length()-1;i++){
    			if(isPlain(s.substring(0,i+1))){
    				String tmp = s.substring(0,i+1);
    				recurFunc(s.substring(i+1),0);
    			}
			}
			return min;
		}
    }

    
    private void recurFunc(String str, int curValue) {
		// TODO Auto-generated method stub
		if(str.equals("")){
			min = Math.min(min, curValue);
		}else{
			for(int i = 0; i < str.length();i++){
				if(isPlain(str.substring(0,i+1))){
					recurFunc(str.substring(i+1),curValue+1);
				}
			}
		}
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
    	String str = "fifgbeajcacehiicccfecbfhhgfiiecdcjjffbghdidbhbdbfbfjccgbbdcjheccfbhafehieabbdfeigbiaggchaeghaijfbjhi";
    	System.out.println(s.minCut(str));
    }
}