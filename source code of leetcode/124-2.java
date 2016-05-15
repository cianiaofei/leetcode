package leetc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * ͼ��������ȱ���
 *124 
 * ת�����������������
 * ���ǳ�ʱ  �Ҹо�����һ��Ӧ�þͿ�����  ��ô���� �ú�����
 */
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
public class Solution {
    public int maxPathSum(TreeNode root) {
    	if(root==null){
    		return 0;
    	}
    	else{
    		HashMap<TreeNode,Integer> sum = new HashMap<>();
    		sum.put(null,0);
    		List<TreeNode> list = new ArrayList<TreeNode>();
    		storeNode(root,list);
    		int max = Integer.MIN_VALUE;
    		for(int i = 0; i < list.size();i++){
    			int curMax = 0;
    			if(sum.containsKey(list.get(i))){
    				curMax = sum.get(list.get(i));
    			}
    			else{
    				curMax = calMax(list.get(i),sum);
    				sum.put(list.get(i), curMax);
    			}
    			if(max < curMax){
    				max = curMax;
    			}
    		}
    		return max;
    	}
    }
    /**
     * �Ըýڵ�Ϊ��ʱ�����ֵ
     * �������  �� �� ��+��+��
     */
    public int calMax(TreeNode tn,HashMap<TreeNode,Integer> sum){
    	if(tn==null){
    		return 0;
    	}
    	else{
    		int left = 0;
    		if(sum.containsKey(tn.left)){
    			left = tn.val + sum.get(tn.left);
    		}
    		else{
    			int temp = calMax(tn.left,sum);
    			sum.put(tn.left, temp);
    			left = tn.val + temp;
    		}
    		
    		int right = 0;
    		if(sum.containsKey(tn.right)){
    			right = tn.val + sum.get(tn.right);
    		}
    		else{
    			int temp = calMax(tn.right,sum);
    			sum.put(tn.right, temp);
    			right = tn.val + temp;
    		}
    		int cleft = left;
    		int cright = right;
    		if(left-tn.val<0){
    			cleft = tn.val;
    		}
    		if(right-tn.val<0){
    			cright = tn.val;
    		}
    		int crossRoot = cleft + cright - tn.val;
    		return Math.max(Math.max(left, right), crossRoot);
    	}
    }
    
    /*
     * �Ѹ����ڵ������
     */
    public void storeNode(TreeNode root,List<TreeNode> list){
    	if(root==null){
    		return ;
    	}
    	else{
    		list.add(root);
    		storeNode(root.left,list);
    		storeNode(root.right,list);
    	}
    }
    
    public static void main(String[] args){
    	TreeNode tn = new TreeNode(2);
    	tn.left = new TreeNode(-1);
    	//tn.right = new TreeNode(3);
    	tn.left.left = new TreeNode(-2);
    	//tn.right.right = new TreeNode(5);
    	Solution s = new Solution();
    	System.out.println(s.maxPathSum(tn));
    }
}