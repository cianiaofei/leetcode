package com.zongfei;
/**
 * 29这题应该不难
 *可能可以用位操作吧 如果不是2的次幂好像既不能用位操作了
 *试试一直减是不是会超时 
 *主要还是展示了位操作的效率超级高  并没有太大意思
 */
public class Solution {
    public int divide(int dividend, int divisor) {
    	if(divisor==0){
    		return Integer.MAX_VALUE;
    	}
    	else if(divisor==-2147483648){
    		if(dividend==divisor){
    			return 1;
    		}
    		else{
    			return 0;
    		}
    	}
    	else if(Math.abs(dividend)<Math.abs(divisor)&&dividend!=-2147483648){
    		return 0;
    	}
    	else if(dividend==-2147483648&&divisor==-1){
    		return 2147483647;
    	}
    	else{
    		boolean isMax = false;
    		if(dividend==-2147483648){
    			dividend++;
    			isMax = true;
    		}
    		boolean isPositiveDividend,isPositiveDivisor;
    		if(dividend>=0){
    			isPositiveDividend = true;
    		}
    		else{
    			isPositiveDividend = false;
    		}
    		if(divisor>0){
    			isPositiveDivisor = true;
    		}
    		else{
    			isPositiveDivisor = false;
    		}
    		dividend = Math.abs(dividend);
    		divisor = Math.abs(divisor);
    		int temp = divisor;
    		int res = 1;
    		while((divisor<<1)<=dividend){
    			if((divisor<<1)<divisor||(res<<1)<res){
    				break;
    			}
    			res = res << 1;
    			divisor = divisor << 1;
    		}
    		if(isPositiveDivisor==isPositiveDividend){
    			if(isMax){
    				return res+divide(dividend-divisor+1,temp);
    			}
    			return res+divide(dividend-divisor,temp);
    		}
    		else{
    			if(isMax){
    				return -res+divide(dividend-divisor+1,-temp);
    			}
    			return -res+divide(dividend-divisor,-temp);
    		}
    	}
    }
    public static void main(String[] args){
    	Solution s = new Solution();
    	int x = -2147483648;
    	System.out.println(x/(-1));
    	System.out.println(s.divide(x,-1));
    }
}