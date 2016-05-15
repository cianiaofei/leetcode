package leetc;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 138其实就是图的复制
 * Definition for singly-linked list with a random pointer.
 * 本质上感觉是图的复制操作   采用广度优先遍历
 */
class RandomListNode {
     int label;
     RandomListNode next, random;
     RandomListNode(int x) { this.label = x; }
 }

 public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null){
        	return head;
        }
        else{
        	HashMap<RandomListNode,RandomListNode> hm = new HashMap<RandomListNode,RandomListNode>();
        	RandomListNode root = new RandomListNode(head.label);
        	Set<RandomListNode> set = new HashSet<RandomListNode>();
        	Deque<RandomListNode> deque = new ArrayDeque<RandomListNode>();
        	set.add(head);
        	deque.add(head);
        	hm.put(head,root);
        	///////////////////////////
        	while(!deque.isEmpty()){
        		RandomListNode temp = deque.remove();
        		RandomListNode rln = hm.get(temp);
        		if(temp.next!=null&&set.contains(temp.next)){
        			rln.next = hm.get(temp.next); 
        		}
        		if(temp.next!=null&&!set.contains(temp.next)){
        			deque.add(temp.next);
        			set.add(temp.next);
        			rln.next = new RandomListNode(temp.next.label);
        			hm.put(temp.next,rln.next);
        		}
        		if(temp.random!=null&&set.contains(temp.random)){
        			rln.random = hm.get(temp.random); 
        		}
        		if(temp.random!=null&&!set.contains(temp.random)){
        			deque.add(temp.random);
        			set.add(temp.random);
        			rln.random = new RandomListNode(temp.random.label);
        			hm.put(temp.random,rln.random);
        		}
        	}
        	return root;
        }
    }
    public static void main(String[] args){
    	RandomListNode rln = new RandomListNode(-1);
    	rln.random = new RandomListNode(-1);
    	Solution s = new Solution();
    	s.copyRandomList(rln);
    }
}