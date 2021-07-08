package com.codecool.hashtable;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class HashTable<K,V> {

    // Number of all buckets - Do not modify!
    private final int bucketsSize = 16;

    private List<List<Entry>> buckets;

    private int hashFunc(K key) {
        int hashCode;
        if (key != null) {
            hashCode = Objects.hash(key);
        } else {
            hashCode = 0;
        }
        return hashCode;
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
        int index = Math.abs(hashFunc(key)) % bucketsSize;
        return index;
    }

    private List<Entry> getBucketAtIndex(int position) {
        return buckets.get(position);
//        throw new RuntimeException("FIXME");
    }

    private Entry findEntryInBucket(K key, List<Entry> bucket) {
        for (int i = 0; i<bucket.size(); i++) {
            if (bucket.get(i).getKey().equals(key)) {
                return bucket.get(i);
            }
        }
        return null;
    }

    public V get(K key) {
        int index = 0;
        if (key != null) {
            index = getBucketIndexForKey(key);
        }
        int linkedLength = getBucketAtIndex(index).size();

        V value = null;
        for (int i=0;i<linkedLength;i++) {
            if (getBucketAtIndex(index).get(i).getKey().equals(key)) {
                value = (V) getBucketAtIndex(index).get(i).getValue();
//                List<Entry> bucket = getBucketAtIndex(index);
//                Entry current = findEntryInBucket(key, bucket);
//                value = (V) current.getValue();
            }
        }
        return value;
    }

    public void put(K key, V value) {
        int index = getBucketIndexForKey(key);
        List<Entry> bucket = getBucketAtIndex(index);

        if (bucket == null) {
            List<Entry> toAdd = new LinkedList<>();
            toAdd.add(new Entry(key, value));
            buckets.set(index, toAdd);
        } else {
            if (findEntryInBucket(key, bucket) == null) {
                getBucketAtIndex(index).add(new Entry(key, value));
            } else {
                findEntryInBucket(key,bucket).setValue(value);
            }
        }
    }

    public V remove(K key) {
        int index = getBucketIndexForKey(key);
        List<Entry> current = getBucketAtIndex(index);
        Entry toRemove = findEntryInBucket(key, current);
        current.remove(toRemove);
        return (V) toRemove.getValue();
    }

    public void clear() {
//        buckets.clear();
        for (int i =0; i<bucketsSize;i++) {
            getBucketAtIndex(i).clear();
        }
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

    public void setValue(V value){
        this.value = value;
    }

    public void setKey(K key) {
        this.key = key;
    }

}
