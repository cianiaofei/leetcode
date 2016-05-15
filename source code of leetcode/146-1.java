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
		int key;
		DataInfo next;
		DataInfo(int key){
			this.key = key;
		}
	}
    private HashMap<Integer,Integer> data = new HashMap<>();
    private DataInfo sortByUsedTime = new DataInfo(-1);
    private DataInfo tail = sortByUsedTime;
    private int currentCount = 0;
    private int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(data.get(key)==null){
        	return -1;
        }
        else{
        	resort(sortByUsedTime,key);
        	System.out.println(data.get(key));
        	return data.get(key);
        }
    }
    /*
     * �����ҵ��Ҹ�Ԫ�ص�λ�õ�ǰ��
     * �жϸ�Ԫ�ط��ʴ��������ӻ᲻��ʹԭ���������仯
     */
    private void resort(DataInfo sortByUsedTime, int key) {
		// TODO Auto-generated method stub
    		DataInfo pre = null;
    		while(sortByUsedTime!=null){
    			if(sortByUsedTime.next.key==key){
    				pre = sortByUsedTime;
    				DataInfo temp = pre.next;
    				if(temp.next==null){
    					return;
    				}
    				pre.next = sortByUsedTime.next.next;
    				temp.next = null;
    				tail.next = temp;
    				tail = temp;
    				break;
    			}
    			else{
    				sortByUsedTime = sortByUsedTime.next;
    			}
    		}
		}

	public void set(int key, int value) {
        if(data.get(key)!=null){
        	resort(sortByUsedTime,key);
        	data.put(key, value);
        }
        else{
        	if(currentCount<capacity){
        		data.put(key,value);
        		currentCount++;
        	}
        	else{
        		int leastKey = sortByUsedTime.next.key;
        		data.remove(leastKey);
        		DataInfo temp = sortByUsedTime.next;
        		if(tail==temp){
        			tail = sortByUsedTime;
        		}
        		sortByUsedTime.next = temp.next;
        		temp.next = null;
        		data.put(key, value);
        	}
        	tail.next = new DataInfo(key);
        	tail = tail.next;
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