package leetc;

/**
 * 25
 * Definition for singly-linked list.
 * 其实就是对指针的操作
 */ 
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
  }

 public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null||k==1){
        	return head;
        }
        else{
        	ListNode cpHead = head;
        	//定位head 和 extra
        	int index = 1;
        	ListNode extra = null;
        	while(head!=null){
        		if(index==2){
        			extra = head;
        		}
        		if(index==k){
        			break;
        		}
        		head = head.next;
        		index++;
        	}//////head 现在指着将来的头
        	ListNode cpExtra = extra;
        	if(head==null){
        		return cpHead;
        	}
        	////////////////////////////////////////////////////////////////////
        	while(cpHead!=null){//while
        		ListNode[] ln = new ListNode[k+1];
        		int kk = 1;
        		while(kk <= k){
        			if(cpHead==null){
        				break;
        			}
        			else{
        				ln[kk] = cpHead;
        				cpHead = cpHead.next;
        				kk++;
        			}
        		}//while
        		kk--;
        		if(kk<k){
        			extra.next = ln[1];
        			return head;
        		}
        		int kkk = kk;
        		while(kk!=1){
        			ln[kk].next = ln[kk-1];
        			kk--;
        		}
        		if(extra!=cpExtra)
        		extra.next = ln[kkk];
        		extra = ln[1];
        	}
        	extra.next = null;
        }
        return head;
    }
    public static void main(String[] args){
    	ListNode ln = new ListNode(1);
    	ln.next = new ListNode(2);
    	ln.next.next = new ListNode(3);
    	ln.next.next.next = new ListNode(4);
    	ln.next.next.next.next = new ListNode(5);
    	Solution s = new Solution();
    	s.reverseKGroup(ln, 5);
    }
}