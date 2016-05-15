package com.ac;

import java.util.Arrays;

/**
 * Definition for singly-linked list.
 */
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
    	if(lists==null||lists.length==0){
    		return null;
    	}
    	else if(lists.length==1){
    		return lists[0];
    	}
    	else{
    		ListNode[] ln = new ListNode[lists.length];
    		if(cpy(ln,lists)){
    			int[] arr = new int[lists.length];
    			return func(arr,lists);
    		}
    		else{
    			ListNode phead = new ListNode(1);
        		ListNode tail = phead;
        		while(!isEnd(ln)){
        			int min = Integer.MAX_VALUE;
        			ListNode curMin = null;
        			int index = 0;
        			for(int i = 0; i < ln.length;i++){
            			if(ln[i]!=null&&min>ln[i].val){
            				min = ln[i].val;
            				curMin = ln[i];
            				index = i;
            			}
            		}
        			ln[index] = ln[index].next;
        			tail.next = curMin;
        			tail = curMin;
        		}
        		return phead.next;
    		}
    	}
    }

	private ListNode func(int[] arr, ListNode[] lists) {
		// TODO Auto-generated method stub
		for(int i = 0; i < lists.length;i++){
			arr[i] = lists[i].val;
		}
		Arrays.sort(arr);
		ListNode pHead = new ListNode(0);
		ListNode hh = pHead;
		for(int a:arr){
			pHead.next = new ListNode(a);
			pHead = pHead.next;
		}
		return hh.next;
	}

	private boolean isEnd(ListNode[] ln) {
		// TODO Auto-generated method stub
		for(int i = 0; i < ln.length;i++){
			if(ln[i]!=null){
				return false;
			}
		}
		return true;
	}

	private boolean cpy(ListNode[] ln, ListNode[] lists) {
		boolean flag = true;
		// TODO Auto-generated method stub
		for(int i = 0; i < ln.length;i++){
			if(lists[i]==null||lists[i].next!=null){
				flag = false;
			}
			ln[i] = lists[i];
		}
		return flag;
	}
	
	public static void main(String[] args){
		ListNode ln = new ListNode(1);
		ListNode llln = new ListNode(0);
		ListNode[] lists = {llln,ln};
		Solution s = new Solution();
		ListNode lnl = s.mergeKLists(lists);
		System.out.println(lists);
	}
}