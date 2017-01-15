package edu.technopolis.lfu;

import java.util.List;

public interface Cache<K, V> {
    void put(K key, V value);

    V get(K key);

    int size();

    List<K> keysList();

    void clear();
}
