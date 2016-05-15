package leetc;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *116ϸ���߼��ϲ�����̫���  ����϶����������
 * ò�ƾ���һ����α�������
 */
 class TreeLinkNode {
     int val;
     TreeLinkNode left, right, next;
     TreeLinkNode(int x) { val = x; }
  }

 public class Solution {
    public void connect(TreeLinkNode root) {
        if(root==null){
        	return ;
        }
        else{
        	 Deque<TreeLinkNode> global = new ArrayDeque<>();
        	 global.add(root);
        	 root.next = null;
        	 while(!global.isEmpty()){//out while
        		 Deque<TreeLinkNode> loc = new ArrayDeque<>();
        		 TreeLinkNode pre = null;
        		 while(!global.isEmpty()){//inner while
        			 TreeLinkNode tln = global.remove();
        			 if(tln==null){
        				 return;
        			 }
        			 else{
        				 if(pre!=null){
        					 pre.next = tln.left;
        				 }
        				 if(tln.left==null){
        					 return;
        				 }
        				 tln.left.next = tln.right;
        				 loc.add(tln.left);
        				 loc.add(tln.right);
        				 pre = tln.right;
        				 if(tln.right==null){
        					 return;
        				 }
        			 }
        		 }//inner while
        		 pre.next = null;
        		 global = loc;
        	 }//out while
        }
    }
    public static void main(String[] args){
    	Solution s = new Solution();
    	TreeLinkNode root = new TreeLinkNode(1);
    	root.left = new TreeLinkNode(2);
    	root.right = new TreeLinkNode(3);
    	s.connect(root);
    	System.out.println("");;
    }
}