package com.zongfei;

/**
 * 貌似没太大意思  190
 * 32位无符号整数 这个怎么表示
 * int占8个自己 用int表示可以
 * 有点可恶的是传入的参数是int类型的 还不能改
 * 不考虑溢出试试  题出的有点坑  果断用c++来做
 * 明白了   它表现形式虽然是带符号的 但是就当它是无符号的
 * 只关注  各个位就可以了
 * 考虑的还是比较底层的   计算机组成原理的东西都用上了
 */
 public class Solution {
	public int reverseBits(int n) {
		int sum = 0;
		int operate = Integer.MIN_VALUE;
		int power = 1;
		int index = 0;
		while(index!=32){
			sum += power * (((n&operate)>>31)&1);
			n = n << 1;
			power *= 2;
			index++;
		}
		return sum;
	}
	public static void main(String[] args){
		Solution solution = new Solution();
		System.out.println(solution.reverseBits(43261596));
	}
}