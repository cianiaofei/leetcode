package com.zongfei;

import java.util.Stack;

/**
 * 貌似没太大意思  190
 * 32位无符号整数 这个怎么表示
 * long占8个自己 用long表示可以
 * 有点可恶的是传入的参数是int类型的 还不能改
 */
 public class Solution {
	 final long One = 1;
	public long reverseBits(long n) {
		long power = One;
		long sum = 0;
		Stack<Long> stack = new Stack<Long>();
		while(n!=0){
			stack.push(n%2);
			n /= 2;
		}
		int len = stack.size();
		while(len!=32){
			power *= 2;
			len++;
		}
		while(!stack.isEmpty()){
			sum += power*stack.pop();
			power *= 2;
		}
		return sum;
	}
	public static void main(String[] args){
		Solution solution = new Solution();
		System.out.println(solution.reverseBits(43261596));
	}
}