package lru.lruSimple;

import java.util.LinkedHashMap;
import java.util.Map;

public class SimpleLRUCache<K, V> {

    private final int capacity;
    private final Map<K,V> cacaheMap;

    public SimpleLRUCache(int capacity) {
        this.capacity = capacity;
        this.cacaheMap = new LinkedHashMap<>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
                return size() > SimpleLRUCache.this.capacity;
            }
        };
    }

    public synchronized V get(K key) {
        return cacaheMap.get(key);
    }

    public synchronized void put(K key, V value) {
        cacaheMap.put(key, value);
    }

    public synchronized int size() {
        return cacaheMap.size();
    }

}
