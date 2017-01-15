package edu.technopolis.lfu;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class LFUCacheTest {

    private static final Map<String, Integer> blocks = new LinkedHashMap<>(10);

    static {
        blocks.put("A", 1);
        blocks.put("B", 2);
        blocks.put("C", 3);
        blocks.put("D", 4);
        blocks.put("E", 5);
        blocks.put("F", 6);
        blocks.put("G", 7);
        blocks.put("H", 8);
        blocks.put("I", 9);
        blocks.put("J", 10);
    }

    private static Cache<String, Integer> generateCache() {
        Cache<String, Integer> cache = new LFUCache<>();
        blocks.forEach(cache::put);
        return cache;
    }

    @Test
    public void testPut() {
        Cache<String, Integer> cache = generateCache();

        blocks.forEach((k, v) -> assertTrue(cache.keysList().contains(k)));
    }

    @Test
    public void test1() {
        Cache<String, Integer> cache = generateCache();

        cache.put("K", 11);
        assertNull(cache.get("A"));
    }

    private boolean keyIsNotOneOf(String key, String... keys) {
        int length = Arrays.stream(keys)
                .filter(k -> !k.equals(key))
                .toArray().length;
        return length == keys.length;
    }

    @Test
    public void test2() {
        Cache<String, Integer> cache = generateCache();

        blocks.keySet().forEach(cache::get);

        blocks.keySet().stream()
                .filter(key -> keyIsNotOneOf(key, "D"))
                .forEach(cache::get);

        cache.put("K", 11);
        assertNull(cache.get("D"));
    }

    @Test
    public void test3() {
        Cache<String, Integer> cache = generateCache();

        blocks.keySet().forEach(cache::get);

        blocks.keySet().stream()
                .filter(key -> keyIsNotOneOf(key, "D", "E", "F", "G", "H"))
                .forEach(cache::get);

        blocks.keySet().stream()
                .filter(key -> keyIsNotOneOf(key, "F"))
                .forEach(cache::get);

        cache.put("K", 11);
        assertNull(cache.get("F"));

    }

}