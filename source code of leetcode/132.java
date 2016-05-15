package com.ac;
/**
 *��̬�滮  �ڼ�������� ������ļ���������Ϣ    
 *�����ǰ��������Ƿ�Ϊ������ȫ����������
 *������Ϣ������ ������ʹ��
 *132 
 */
public class Solution {
    public int minCut(String s) {
        if(s==null||s.length()==0){
        	return 0;
        }
        else{
        	int[] cut = new int[s.length()];
        	boolean[][] isPlain = new boolean[s.length()][s.length()];
        	char[] arr = s.toCharArray();
        	for(int i = 0; i < s.length();i++){
        		int min = Integer.MAX_VALUE;
        		for(int j = 0; j <= i; j++){
        			if(arr[i]==arr[j]&&(i<=j+1||isPlain[j+1][i-1])){
        				isPlain[j][i] = true;
        				min = (j == 0? 0 : Math.min(min,cut[j-1]+1));
        			}
        		}
        		cut[i] = min;
        	}///put for
        	return cut[s.length()-1];
        }
    }
    
    public static void main(String[] args){
    	String str = "aaa";
    	Solution s  = new Solution();
    	System.out.println(s.minCut(str));
    }
}