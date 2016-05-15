package com.zongfei;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * 一层层的去叶子
 * 不知道怎么证明它的正确性 记住得了
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
    		List<Integer> leaf = new ArrayList<>();
    		Node[] nodes = new Node[n];//没分配内存
    		for(int i = 0; i < n;i++){
    			nodes[i] = new Node();
    		}
    		for(int i = 0;i < edges.length;i++){
    			int nodex = edges[i][0];
    			int nodey = edges[i][1];
    			Node tempx = nodes[nodex].next;
    			nodes[nodex].next = new Node(nodey);
    			nodes[nodex].next.next = tempx;
    			Node tempy = nodes[nodey].next;
    			nodes[nodey].next = new Node(nodex);
    			nodes[nodey].next.next = tempy;
    			times[nodex]++;
    			times[nodey]++;
    		}
    		////////find leaf
    		Set<Integer> kinds = new HashSet<>();
    		for(int i = 0; i < n;i++){
    			kinds.add(i);
    		}
    		for(int i = 0; i < n;i++){
    			if(times[i]==1){
    				leaf.add(i);
    				kinds.remove(i);
    			}
    		}
    		if(kinds.isEmpty()){
    			return leaf;
    		}
    		while(!leaf.isEmpty()){
    			List<Integer> newLeaf = new ArrayList<>();
    			for(int i = 0; i <leaf.size();i++){
    				Node curHead = nodes[leaf.get(i)].next;
    				while(curHead!=null){//while2
    					times[curHead.value]--;
    					if(times[curHead.value]==1){
    						newLeaf.add(curHead.value);
    						kinds.remove(curHead.value);
    					}
    					curHead = curHead.next;
    				}//while2
    			}
    			if(kinds.isEmpty()){
    				return newLeaf;
    			}
    			else{
    				leaf = newLeaf;
    			}
    		}
    		List<Integer> ll = new ArrayList<>();
    		Iterator<Integer> ite = kinds.iterator();
    		while(ite.hasNext()){
    			ll.add(ite.next());
    		}
    		return ll;
    	}
	}
	public static void main(String[] args){
		Solution s = new Solution();
		int[][] edges = {{0,1},{0,2},{0,3},{3,4},{4,5}};
		System.out.println(s.findMinHeightTrees(6, edges));
	}
}