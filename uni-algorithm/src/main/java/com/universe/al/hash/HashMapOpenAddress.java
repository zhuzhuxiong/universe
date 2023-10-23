package com.universe.al.hash;

/**
 * @author l
 */
public class HashMapOpenAddress {

    private int size;
    private int capacity = 4;
    private final double loadFactor = 2.0 / 3.0;
    private final int extendRatio = 2;
    private Pair[] buckets;
    /**
     * 删除标记
     */
    private final Pair TOMBSTONE = new Pair(-1, "-1");

    public HashMapOpenAddress() {
        size = 0;
        buckets = new Pair[capacity];
    }

    private int hashFunc(int key) {
        return key % capacity;
    }

    private double loadFactor() {
        return (double) size / capacity;
    }

    private int findBucket(int key) {
        int index = hashFunc(key);
        int firstTombstone = -1;

        while (buckets[index] != null) {
            if (buckets[index].key == key) {
                if (firstTombstone != -1) {
                    buckets[firstTombstone] = buckets[index];
                    buckets[index] = TOMBSTONE;
                    return firstTombstone;
                }
                return index;
            }
            if (firstTombstone == -1 && buckets[index] == TOMBSTONE) {
                firstTombstone = index;
            }
            index = (index + 1) % capacity;
        }

        return firstTombstone == -1 ? index : firstTombstone;
    }

    public String get(int key) {
        int index = hashFunc(key);
        if (buckets[index] != null && buckets[index] != TOMBSTONE) {
            return buckets[index].value;
        }
        return null;
    }

    public void put(int key, String value) {
        if (loadFactor() > loadFactor) {
            extend();
        }
        int index = findBucket(key);
        if (buckets[index] != null && buckets[index] != TOMBSTONE) {
            buckets[index].value = value;
            return;
        }
        buckets[index] = new Pair(key, value);
        size++;
    }

    private void extend() {
        Pair[] tmp = buckets;
        capacity = capacity * extendRatio;
        buckets = new Pair[capacity];
        size = 0;
        for (Pair pair : tmp) {
            if (null != pair && TOMBSTONE != pair) {
                put(pair.key, pair.value);
            }
        }
    }

    public void remove(int key) {
        int index = hashFunc(key);
        if (buckets[index] != null && buckets[index] != TOMBSTONE) {
            buckets[index] = TOMBSTONE;
            size --;
        }
    }



}
