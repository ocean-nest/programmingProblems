package lru;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRU {

    class Node {
        int key,value;
        Node prev,next;
        Node(int key, int value) {
            this.key = key;
            this.value =value;
        }
    }

    int capacity;
    Map<Integer,Node> map;
    Node head,tail;

    LRU(int capacity) {
        this.capacity = capacity;
        this.map = new LinkedHashMap<>();
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;

    }

    public void remove(Node rm) {
        rm.next.prev = rm.prev;
        rm.prev.next = rm.next;
        map.remove(rm.key);

    }
    public void insertAtHead(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    public int get(int key) {
        Node val = null;
        if(map.containsKey(key)) {
            val = map.get(key);
            remove(val);
            insertAtHead(val);
        }
        return val.value;
    }

    public void put(int key, int val) {
        if(map.containsKey(key)) {
            Node val1 = map.get(key);
            val1.value = val;
            map.put(key,val1);
            remove(val1);
            insertAtHead(val1);

        }
        else {
            if(map.size() == capacity) {
                Node lru = this.tail.prev;
                remove(lru);
            }
            Node newNode = new Node(key, val);
            insertAtHead(newNode);
            map.put(key, newNode);
        }
    }


}