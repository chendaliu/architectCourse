package pers.czl.architect.concurrent;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class HashMapTest {
    public static void main(String[] args) {
        Map<Object, Object> map = new HashMap<>(8);
        for (int i = 0; i < 10; i++) {
            map.put(i, i);
        }
    }
}
