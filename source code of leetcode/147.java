package leetc;

/**
 * 147Definition for singly-linked list.
 * ָ��Ĳ���Ӧ�ü�
 * �ĸ��ط���bug�أ�
 */
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }

public class Solution {
    public ListNode insertionSortList(ListNode head) {
    	if(head==null||head.next==null){
    		return head;
    	}
    	else{
    		ListNode extraHead = new ListNode(-1);
            extraHead.next = head;
            ListNode place = extraHead;
            while(place.next!=null){//ÿ�ζ�����Сֵ 
            	head = place.next;
            	int min = Integer.MAX_VALUE;
            	ListNode minNode = head;
            	ListNode minPre = place;
            	ListNode pre = place;
            	while(head!=null){
            		if(head.val<min){
            			min = head.val;
            			minNode = head;
            			minPre = pre;
            		}
            		else{}
            		head = head.next;
            		pre = pre.next;
            	}//�ҵ���С�����ڵ�λ��
            	if(minPre == place){
            		place = place.next;
            	}
            	else{
            		minPre.next = minNode.next;
                	minNode.next = place.next;
                	place.next = minNode;
                	place = place.next;
            	}
            	
            }
            return extraHead.next;
    	}
    }
    public static void main(String[] args){
    	ListNode tn = new ListNode(4);
    	tn.next = new ListNode(19);
    	tn.next.next = new ListNode(14);
    	tn.next.next.next = new ListNode(5);
    	ListNode ln = tn.next.next.next;
    	ln.next = new ListNode(-3);
    	ln.next.next = new ListNode(1);
    	Solution s = new Solution();
    	s.insertionSortList(tn);
    }
}