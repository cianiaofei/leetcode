package com.zongfei;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 现在又内存超了 只能用邻接表试试了
 * 找所有的叶子再向上找一个 好像就可以
 * 完全理解错了题意 这里的深度对某棵树来说是最大深度
 * 还得是层次遍历呀 用的数组链表但还是超时 310
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
    		}
    		int minDeepth = Integer.MAX_VALUE;
    		List<Integer> minRootSet = new ArrayList<>();
    		for(int i = 0; i < n;i++){//for1
    			Set<Integer> color = new HashSet<>();
    			int locDeepth = 1;
    			List<Integer> list = new ArrayList<Integer>();
    			list.add(i);
    			color.add(i);
    			while(!list.isEmpty()){//一层层的处理 while1
    				List<Integer> layer = new ArrayList<>();
    				for(int ii = 0; ii < list.size();ii++){//for2 把下一层存起来
    					int index = list.get(ii);
    					Node curHead = nodes[index].next;
    					while(curHead!=null){//while2
    						if(!color.contains(curHead.value)){
    							color.add(curHead.value);
    							layer.add(curHead.value);
    						}
    						curHead = curHead.next;
    					}//while2
    				}//for2
    				if(!layer.isEmpty()){
    					locDeepth++;
    				}
    				list = layer;
    			}//while1
    			if(minDeepth==locDeepth){
    				minRootSet.add(i);
    			}
    			else if(minDeepth>locDeepth){
    				minRootSet.clear();
    				minRootSet.add(i);
    				minDeepth = locDeepth;
    			}
    			else{}
    		}//for1
    		return minRootSet;
    	}
	}
	public static void main(String[] args){
		Solution s = new Solution();
		int[][] edges = {{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};
		System.out.println(s.findMinHeightTrees(6, edges));
	}
}