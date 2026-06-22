package LFU;

import java.util.HashMap;
import java.util.Map;

public class LFUTTLCache<K, V> {

    class Node {
        K key;
        V value;
        int count;
        long ttl;
        Node next = null;
        Node prev = null;

        public Node(K key, V value, int count, long ttl) {
            this.key = key;
            this.value = value;
            this.count = count;
            this.ttl = ttl;
        }
    }

    class DoubleLinkedListLFU {

        Node  head = new Node(null, null, 0, 0);
        Node tail = new Node(null, null, 0, 0);
        int size = 0;

        public DoubleLinkedListLFU() {
            this.head.next = tail;
            this.tail.prev = head;
        }

        public void insertBegining(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            size++;
        }

        public void remove (Node node) {
            node.next.prev = node.prev;
            node.prev.next = node.next;
            size--;

        }

        public Node removeLast() {
            if(size <=0)
                return null;
            Node last = tail.prev;
            remove(last);
            return last;
        }

    }

    Map<K, Node> cache;
    Map<Integer, DoubleLinkedListLFU> frequencies;
    int leastFrequent = 0;
    int capacity = 100;

    public LFUTTLCache() {
        cache = new HashMap<>();
        frequencies= new HashMap<>();
        leastFrequent = 0;
    }

    public synchronized V getValue(K key) {
        Node node = cache.get(key);
        if(node == null)
            return null;

        if(System.currentTimeMillis() > node.ttl) {
            evictNode(node);
            return null;
        }
        updateCount(node);
        return node.value;

    }

    public synchronized void insert(K key, V value) {
        long newTTL = System.currentTimeMillis() + node.ttl;
        if(cache.containsKey(key)) {
            Node node = cache.get(key);
            node.ttl = newTTL;
            node.value = value;
            updateCount(node);
            return;
        }

        if(capacity <= cache.size()) {
           LRU();
        }

        Node newNode = new Node(key, value, 1, newTTL);
        cache.put(key, newNode);
        leastFrequent = 1;
        frequencies.computeIfAbsent(1, k->new DoubleLinkedListLFU()).insertBegining(newNode);

    }

    public void updateCount (Node node) {
        int currentFreq = node.count;
        DoubleLinkedListLFU list = frequencies.get(node.count);
        list.remove(node);

        if(currentFreq==leastFrequent && list.size==0) {
            leastFrequent++;
        }

        node.count = node.count+1;
        frequencies.computeIfAbsent(node.count, k-> new DoubleLinkedListLFU()).insertBegining(node);


    }

    public void LRU () {
        DoubleLinkedListLFU list = frequencies.get(leastFrequent);
        Node last = list.removeLast();
        if(last != null)
           cache.remove(last);

    }
    public void evictNode(Node node) {

        DoubleLinkedListLFU list = frequencies.get(node.count);
        if(list != null)
           list.remove(node);
        cache.remove(node.key);



    }




}
