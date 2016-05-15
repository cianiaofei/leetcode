package com.zongfei;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 现在又内存超了 只能用邻接表试试了
 * 找所有的叶子再向上找一个 好像就可以
 */
class Node{
	int value;
	Node next;
	Node(){
		
	}
	Node(int value){
		this.value = value;
	}
}
public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    	if(edges==null){
    		return null;
    	}
    	else if(edges.length==0){
    		List<Integer> list = new ArrayList<>();
    		list.add(0);
    		return list;
    	}
    	else{
    		int[] times = new int[n];
    		Node[] nodes = new Node[n];//没分配内存
    		for(int i = 0; i < n;i++){
    			nodes[i] = new Node();
    		}
    		for(int i = 0;i < edges.length;i++){
    			int nodex = edges[i][0];
    			int nodey = edges[i][1];
    			if(times[nodex]!=2){
    				Node temp = nodes[nodex].next;
    				nodes[nodex].next = new Node(nodey);
    				nodes[nodex].next.next = temp;
    				times[nodex]++;
    			}
    			if(times[nodey]!=2){
    				Node temp = nodes[nodey].next;
    				nodes[nodey].next = new Node(nodex);
    				nodes[nodey].next.next = temp;
    				times[nodey]++;
    			}
    		}
    		/////////////////////////////////////
    		List<Integer> minRootSet = new ArrayList<>();
    		Set<Integer> set = new HashSet<>();
    		for(int i = 0; i < n;i++){
    			if(times[i]==1){
    				int nodeValue = nodes[i].next.value;
    				if(!set.contains(nodeValue)){
    					set.add(nodeValue);
    					minRootSet.add(nodeValue);
    				}
    			}
    		}
    		return minRootSet;
    	}
	}
	public static void main(String[] args){
		Solution s = new Solution();
		int[][] edges = {};
		System.out.println(s.findMinHeightTrees(1, edges));
	}
}