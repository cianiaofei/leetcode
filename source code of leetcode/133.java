package leetc;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;

/**
 * 133 
 * ͼ����ȸ���  ��ʵ����ͼ�ı��� +����ϸ��
 * Definition for undirected graph.
 * �ص㣺ò��ѹ��������ô�鷳 һ�α����Ϳ��Խ������   ���������� Ҫ���������Ҫô�������
 */
class UndirectedGraphNode {
     int label;
     List<UndirectedGraphNode> neighbors;
     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 }

 public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node==null){
        	return node;
        }
        else{
        	HashMap<Integer,UndirectedGraphNode> hm = new HashMap<>();
        	HashMap<UndirectedGraphNode,UndirectedGraphNode> target = new HashMap<>();
        	UndirectedGraphNode root = new UndirectedGraphNode(node.label);
        	Deque<UndirectedGraphNode> deque = new ArrayDeque<UndirectedGraphNode>();
        	hm.put(root.label,root);
        	target.put(node, root);
        	deque.add(node);
        	while(!deque.isEmpty()){
        		UndirectedGraphNode temp = deque.remove();
        		UndirectedGraphNode cur = target.get(temp);
        		List<UndirectedGraphNode> sourceList = temp.neighbors;
        		for(int i = 0; i < sourceList.size();i++){
        			UndirectedGraphNode neighbor = sourceList.get(i);
        			if(hm.get(neighbor.label)!=null){//�Ѿ�����
        				cur.neighbors.add(target.get(neighbor));
        			}
        			else{//////////////
        				UndirectedGraphNode newNode = new UndirectedGraphNode(neighbor.label);
        				cur.neighbors.add(newNode);
        				hm.put(neighbor.label,neighbor);
        				target.put(neighbor,newNode);
        				deque.add(neighbor);
        			}
        		}
        	}
        	return root;
        }
    }
    public static void main(String[] args){
    	Solution s = new Solution();
    	UndirectedGraphNode root = new UndirectedGraphNode(0);
    	root.neighbors.add(root);
    	root.neighbors.add(root);
    	System.out.println(s.cloneGraph(root));
    }
}