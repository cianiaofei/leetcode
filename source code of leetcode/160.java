/*
 *160
 * 思想：遍历两个链表  用HashMap存一下 
 */
package leetc;
import java.util.HashSet;
import java.util.Set;

/*
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
    public ListNode getIntersectionNode(ListNode headA,ListNode headB) {
    	if(headA==null||headB==null){
    		return null;
    	}
    	else{
    		Set<ListNode> set = new HashSet<>();
    		while(headA!=null){
    			set.add(headA);
    			headA = headA.next;
    		}
    		while(headB!=null){
    			if(set.contains(headB)){
    				return headB;
    			}
    			headB = headB.next;
    		}
    	}
    	return null;
    }
}