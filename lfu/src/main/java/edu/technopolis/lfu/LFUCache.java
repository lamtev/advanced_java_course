package edu.technopolis.lfu;

import java.util.HashMap;
import java.util.Map;

public class LFUCache<K, V> implements Cache<K, V> {

    private static final int DEFAULT_CAPACITY = 10;
    private final int CAPACITY;
    private Map<K, V> cache;

    public LFUCache(int capacity) {
        CAPACITY = capacity;
        cache = new HashMap<>(capacity);
    }

    public LFUCache() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public void put(K key, V value) {
        //TODO
    }

    @Override
    public V get(K key) {
        return cache.get(key);
    }

    @Override
    public int size() {
        return cache.size();
    }
}
