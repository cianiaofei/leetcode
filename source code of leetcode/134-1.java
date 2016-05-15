package com.zongfei;
/**
 *先用最暴力的方法试试
 *形成一个环形链表 果然超时了
 */
public class Solution {
	class Node{
		int value;
		Node next;
		Node(int value){
			this.value = value;
		}
	}
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas==null||gas.length==0){
        	return -1;
        }
        else{//环形链表
        	Node head = new Node(gas[0]);
        	head.next = new Node(cost[0]*(-1));
        	Node p = head.next;
        	for(int i = 1; i < gas.length;i++){///////////
        		p.next = new Node(gas[i]);
        		p.next.next = new Node(cost[i]*(-1));
        		p = p.next.next;
        	}//////////////
        	p.next = head;
        	int index = 0;
        	p = head;
        	while(index<gas.length){
        		if(isComplete(p)){
        			return index;
        		}
        		index++;
        		p = p.next.next;
        	}
        	return -1;
        }
    }
	private boolean isComplete(Node p) {
		Node place = p;
		int sum = p.value;
		p = p.next;
		while(p!=place){
			sum += p.value;
			p = p.next;
			if(sum<0){
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args){
		Solution s = new Solution();
		int[] gas = {5};
		int[] cost = {4};
		System.out.println(s.canCompleteCircuit(gas, cost));
	}
}