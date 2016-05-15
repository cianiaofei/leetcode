/*
 *173 ����˼������ȶ�BST����������� ��ʱ���Ǵ�С�����˳��
 */
package leetc;

import java.util.Vector;

/*
 * Definition for binary tree
 */
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

public class BSTIterator {
	private int index = 0;
	private Vector<Integer> sortVec = new Vector<>();
	/*
	 * ������� ������浽sortVec��
	 */
    public BSTIterator(TreeNode root) {
        inOrder(root);
    }
    /*
     * �������������
     * ˳����������
     */
    public void inOrder(TreeNode tn){
    	if(tn==null){
    		return;
    	}
    	else{
    		if(tn.left!=null){
    			inOrder(tn.left);
    		}
    		sortVec.add(tn.val);
    		if(tn.right!=null){
    			inOrder(tn.right);
    		}
    	} 
    }
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(index!=sortVec.size()){
        	return true;
        }
        return false;
    }

    /** @return the next smallest number */
    public int next() {
        return sortVec.get(index++);
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */