package com.universe.al.hash;

import java.util.ArrayList;
import java.util.List;

/**
 * @author
 */
public class HashArray {

    private List<Pair> bucket;

    public HashArray() {
        bucket = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            bucket.add(null);
        }
    }

    private int hashFunc(int hash) {
        //key 或者hash值对 容量进行取余，计算落到数组的哪个位置，获取index；
        return hash % 100;
    }

    public void put(int key, String value) {
        Pair pair = new Pair(key, value);
        bucket.set(hashFunc(key), pair);
    }

    public String get(int key) {
        Pair pair = bucket.get(hashFunc(key));
        if (null != pair) {
            return pair.value;
        }
        return null;
    }

    public void remove(int key) {
        bucket.set(hashFunc(key), null);
    }

    public List<Pair> PairSet() {
        ArrayList<Pair> pairs = new ArrayList<>();
        for (Pair pair : bucket) {
            if (null != pair) {
                pairs.add(pair);
            }
        }
        return pairs;
    }

    public List<Integer> keySet() {
        ArrayList<Integer> keys = new ArrayList<>();
        for (Pair pair : bucket) {
            if (null != pair) {
                keys.add(pair.key);
            }
        }
        return keys;
    }

    public void print(){
        for (Pair pair : PairSet()) {
            System.out.println(pair.key + "-->" + pair.value);
        }
    }

    public static void main(String[] args) {
        HashArray hash = new HashArray();

        hash.put(1,"a");
        hash.put(2,"b");
        hash.put(3,"c");

        hash.print();

        System.out.println(hash.get(3));

        hash.remove(3);
        hash.print();

        System.out.println(hash.PairSet());
        System.out.println(hash.keySet());

    }


}
