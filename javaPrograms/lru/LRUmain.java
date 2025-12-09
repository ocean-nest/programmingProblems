package lru;

public class LRUmain {
    public static void main(String args[]) {
        LRU lru = new LRU(3);
        lru.put(1,1);
        lru.put(2,2);
        lru.put(3,3);
        lru.put(4,4);
        lru.put(5,5);

        System.out.println(lru.map);
    }
}
