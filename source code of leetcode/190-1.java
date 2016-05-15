package com.zongfei;

import java.util.Stack;

/**
 * 貌似没太大意思  190
 * 32位无符号整数 这个怎么表示
 * int占8个自己 用int表示可以
 * 有点可恶的是传入的参数是int类型的 还不能改
 * 不考虑溢出试试  题出的有点坑  果断用c++来做
 */
 public class Solution {
	 final int One = 1;
	public int reverseBits(int n) {
		int power = One;
		int sum = 0;
		Stack<Integer> stack = new Stack<Integer>();
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
		int n = 2;
		int i = 1;
		while(i!=32){
			n *= 2;
			i++;
		}
		System.out.println(n-1);
	}
}