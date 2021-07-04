package com.codecool.hashtable;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HashTable<K,V> {

    // Number of all buckets - Do not modify!
    private final int bucketsSize = 16;

    private List<List<Entry>> buckets;

    private int hashFunc(K key) {
        int hash = 0;
        if (key instanceof Number) {
            hash = ((Number) key).intValue();
        } else if (key instanceof String) {
            for (int i=0; i<((String) key).length();i++) {
                hash += ((String) key).charAt(i);
            }
        }
        return hash;
    }

    public HashTable() {
        if (buckets == null) {
            buckets = new ArrayList<>();
            for (int i=0;i<bucketsSize;i++) {
                buckets.add(null);
            }
        }
    }


    private int getBucketIndexForKey(K key) {
        int index = hashFunc(key) % bucketsSize;
        return index;
//        throw new RuntimeException("FIXME");
    }

    private List<Entry> getBucketAtIndex(int position) {
        return buckets.get(position);
//        throw new RuntimeException("FIXME");
    }

    private Entry findEntryInBucket(K key, List<Entry> bucket) {
        throw new RuntimeException("FIXME");
    }

    public V get(K key) {
        int index = hashFunc(key) % bucketsSize;
        int linkedLength = getBucketAtIndex(index).size();
        System.out.println(getBucketAtIndex(index).size());
        V value = null;
        for (int i=0;i<linkedLength;i++) {
            System.out.println(getBucketAtIndex(index).get(i).getKey().toString());
//            if (getBucketAtIndex(index).get(i).getKey() == key) {
//                value = (V) getBucketAtIndex(index).get(i).getValue();
//            }
        }
//        throw new RuntimeException("FIXME");
        return value;
    }

    public void put(K key, V value) {
        int index = hashFunc(key) % bucketsSize;
        List<Entry> toAdd = new LinkedList<>();
        toAdd.add(new Entry(key, value));
        buckets.set(index, toAdd);
//        throw new RuntimeException("FIXME");
    }

    public V remove(K key) {
        throw new RuntimeException("FIXME");
    }

    public void clear() {
        throw new RuntimeException("FIXME");
    }
}

class Entry<K,V> {

    public K key;
    public V value;

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }

     public V getValue() {
        return value;
     }

    public K getKey() {
        return key;
    }

}
