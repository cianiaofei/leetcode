/*
 * add a pre node extra
 * the first node of the cycle has two pres
*/
package leetc;

import java.util.HashMap;

/**
 * Definition for singly-linked list.
 */
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
 }

public class Solution {
    public ListNode detectCycle(ListNode head) {
        //
    	if(head == null){
    		return null;
    	}
    	else{
    		//add the node of pre random value
    		ListNode pre = new ListNode(0);
    		pre.next = head;
    		HashMap<ListNode,ListNode> sonMapParent = new HashMap<>();
    		while(pre!=null){
    			if(pre.next==null){
    				return null;
    			}
    			else{
    				if(sonMapParent.containsKey(pre.next)){
    					return pre.next;
    				}
    				else{
    					sonMapParent.put(pre.next,pre);
    				}
    			}
    			pre = pre.next;
    		}
    		return null;
    	}
    }
} 