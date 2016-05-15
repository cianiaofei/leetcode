/*
 * 146 好不容易没错误了 又超时了
 * hard就是不一样  还是没想清楚用链表如何在o(1)时间内找到被命中的元素
 * HashMap中的value放双链表的引用就可以解决   
 */
package leetc;

import java.util.HashMap;

/*
 *  HashMap底层是数组链表
 *  TreeMap底层是红黑树
 */
public class LRUCache {
	class DataInfo{
		int value;
		int key;
		DataInfo prev;
		DataInfo next;
		DataInfo(int key,int value){
			this.key = key;
			this.value = value;
		}
	}
    private HashMap<Integer,DataInfo> data = new HashMap<>();
    private DataInfo sortByUsedTime = new DataInfo(-1,-1);
    private DataInfo tail = sortByUsedTime;
    private int currentCount = 0;
    private int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(data.get(key)==null){
        	System.out.println(-1);
        	return -1;
        }
        else{
        	resort(key);
        	System.out.println(data.get(key).value);
        	return data.get(key).value;
        }
    }
    /*
     * 首先找到找个元素的位置的前驱
     * 判断该元素访问次数的增加会不会使原来排序发生变化
     */
    private void resort(int key) {
		// TODO Auto-generated method stub
    	DataInfo target = data.get(key);
    	if(target.next==null){
    		return ;
    	}
    	else{
    		target.prev.next = target.next;
    		target.next.prev = target.prev;
    		tail.next = target;
    		target.prev = tail;
    		target.next = null;
    		tail = target;
    	}
	}

	public void set(int key, int value) {
        if(data.get(key)!=null){
        	resort(key);
        	data.get(key).value = value;
        }
        else{
        	DataInfo newNode = new DataInfo(key,value);
        	if(currentCount<capacity){
        		data.put(key,newNode);
        		currentCount++;
        	}
        	else{
        		int leastKey = sortByUsedTime.next.key;
        		data.remove(leastKey);
        		DataInfo temp = sortByUsedTime.next;
        		if(tail==temp){
        			tail = sortByUsedTime;
        			tail.next = null;
        			data.put(key,newNode);
        			tail.next = newNode;
                	newNode.prev = tail;
                	tail = newNode;
        			return;
        		}
        		sortByUsedTime.next = temp.next;
        		temp.next.prev = sortByUsedTime;
        		temp.next = null;
        		temp.prev = null;
        		data.put(key,newNode);
        	}
        	tail.next = newNode;
        	newNode.prev = tail;
        	tail = newNode;
        }
    }
	public static void main(String[] args){
		LRUCache lru = new LRUCache(1);
		lru.set(2, 1);
		lru.get(2);
		lru.set(3,2);
		lru.get(2);
		lru.get(3);
	}
}