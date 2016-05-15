/*
 * 146 �ò�����û������ �ֳ�ʱ��
 * hard���ǲ�һ��  ����û����������������o(1)ʱ�����ҵ������е�Ԫ��
 * HashMap�е�value��˫��������þͿ��Խ��   
 */
package leetc;

import java.util.HashMap;

/*
 *  HashMap�ײ�����������
 *  TreeMap�ײ��Ǻ����
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
     * �����ҵ��Ҹ�Ԫ�ص�λ�õ�ǰ��
     * �жϸ�Ԫ�ط��ʴ��������ӻ᲻��ʹԭ���������仯
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