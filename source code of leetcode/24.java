package com.zongfei;

/**
 * 24
 * Definition for singly-linked list.
 */ 
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
 }
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null){
        	return head;
        }
        else{
        	ListNode former = head;
        	ListNode latter = head.next;
        	ListNode pHead = new ListNode(0);
            pHead.next = latter;
        	ListNode pre = pHead;
        	while(latter!=null){//while 1
        		ListNode ln = latter.next;
        		latter.next = former;
        		pre.next = latter;
        		pre = former;
        		former = ln;
        		if(former==null){
        			pre.next = null;
        			break;
        		}
        		else{
        			latter = former.next;
        		}
        	}//while 1
        	if(pre.next!=null){
        		pre.next = former;
        	}
        	return pHead.next;
        }
    }
    public static void main(String[] args){
    	Solution s = new Solution();
    	ListNode ln = new ListNode(1);
    	s.swapPairs(ln);
    }
}