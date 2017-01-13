package edu.technopolis.lfu;

public interface Cache<K, V> {
    void put(K key, V value);
    V get(K key);
    int size();
}
