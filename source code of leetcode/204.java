package com.cc;
/**
 *不是什么新方法 之前这种方法接触过的
 *就是把一些点扣掉 从另一个角度考虑问题 
 */
public class Solution {
    public int countPrimes(int n) {
    	boolean[] isPrime = new boolean[n];
    	func(isPrime);
        for(int i = 2;i*i<n;i++){
        	if(isPrime[i]==false){
        		continue;
        	}
        	for(int index = i*i; index < n; index+=i){
        		isPrime[index] = false;
        	}
        }
        int res = 0;
        for(int i = 1; i < n;i++){
        	if(isPrime[i]==true){
        		res++;
        	}
        }
        return res;
    }
    
    private void func(boolean[] isPrime) {
		// TODO Auto-generated method stub
		for(int i = 2; i < isPrime.length;i++){
			isPrime[i] = true;
		}
	}

	public static void main(String[] args){
    	Solution s = new Solution();
    	System.out.println(s.countPrimes(5));
    }
}