package test140_149;

import java.util.HashMap;

public class Test146 {
    class LRUCache {
        private int capacity;
        private DLinkedListNode first = new DLinkedListNode();
        private DLinkedListNode last = new DLinkedListNode();
        private HashMap<Integer,DLinkedListNode> map;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<Integer,DLinkedListNode>(capacity);
            first.next = last;
            last.pre = first;
        }
        
        public int get(int key) {
            if(map.containsKey(key)){
                DLinkedListNode node = map.get(key);
                DLinkedListNode next = node.next;
                DLinkedListNode pre = node.pre;
                next.pre = pre;
                pre.next = next;

                first.next.pre = node;
                node.next = first.next;
                first.next = node;
                node.pre = first;

                return node.value;
            }
            return -1;
        }
        
        public void put(int key, int value) {
            if(map.containsKey(key)){
                map.get(key).value = value;

                DLinkedListNode node = map.get(key);
                DLinkedListNode next = node.next;
                DLinkedListNode pre = node.pre;
                next.pre = pre;
                pre.next = next;

                first.next.pre = node;
                node.next = first.next;
                first.next = node;
                node.pre = first;
            }
            else{
                if(map.size() == capacity){
                    DLinkedListNode toRemove = last.pre;
                    last.pre.pre.next = last;
                    last.pre = last.pre.pre;
                    map.remove(toRemove.key);
                }
                

                DLinkedListNode node = new DLinkedListNode(key, value);
                map.put(key, node);
                first.next.pre = node;
                node.next = first.next;
                first.next = node;
                node.pre = first;
            }
        }
    }

    //双向链表节点（实现插入与删除的O(1)时间复杂度）
    class DLinkedListNode{
        public DLinkedListNode next;
        public DLinkedListNode pre;
        public int key;
        public int value;

        public DLinkedListNode(int key,int value){
            this.key = key;
            this.value = value;
        }
        DLinkedListNode(){}
    }
}