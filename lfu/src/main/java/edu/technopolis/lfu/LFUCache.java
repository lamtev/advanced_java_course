package edu.technopolis.lfu;

import java.util.AbstractMap.SimpleEntry;
import java.util.*;
import java.util.Map.Entry;

public class LFUCache<K, V> implements Cache<K, V> {

    private static final int DEFAULT_CAPACITY = 10;
    private final int CAPACITY;
    private Map<K, V> blocks;
    private Queue<Entry<K, Integer>> queue;
    private Map<K, Integer> counters;

    public LFUCache(int capacity) {
        CAPACITY = capacity;
        blocks = new LinkedHashMap<>(CAPACITY);
        queue = new PriorityQueue<>(CAPACITY, Comparator.comparing(Entry::getValue));
        counters = new HashMap<>(CAPACITY);
    }

    public LFUCache() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public void put(K key, V value) {
        if (CAPACITY == size()) {
            removeLFUBlock();
        }
        blocks.put(key, value);
        queue.offer(new SimpleEntry<>(key, 1));
        counters.put(key, 1);
    }

    @Override
    public V get(K key) {
        if (blocks.containsKey(key)) {
            int counter = counters.get(key);
            counters.remove(key);
            queue.remove(new SimpleEntry<>(key, counter));
            queue.offer(new SimpleEntry<>(key, counter + 1));
            counters.put(key, counter + 1);
        }
        return blocks.get(key);
    }

    @Override
    public int size() {
        return blocks.size();
    }

    @Override
    public List<K> keysList() {
        List<K> keysList = new ArrayList<>();
        blocks.forEach((k, v) -> keysList.add(k));
        return keysList;
    }

    @Override
    public void clear() {
        blocks.clear();
        queue.clear();
        counters.clear();
    }

    private void removeLFUBlock() {
        K key = queue.poll().getKey();
        blocks.remove(key);
        counters.remove(key);
    }

}
