package com.dhc.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author haochen.dai
 * @Date: 2021-03-23 08:26
 * @Description:
 */
public class MapUtil {

    public static <E, K> void putToList(Map<K, List<E>> map, K key, E element) {
        List<E> value = map.getOrDefault(key, new ArrayList<>());
        value.add(element);
        map.put(key, value);
    }

    public static void main(String[] args) {
        Map<String, List<String>> map = new HashMap<>();
        map.put("a", null);
        System.out.println(map.getOrDefault("a", new ArrayList<>()));

    }
}
