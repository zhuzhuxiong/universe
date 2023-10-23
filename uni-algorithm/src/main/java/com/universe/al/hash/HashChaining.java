package com.universe.al.hash;

import java.util.ArrayList;
import java.util.List;

/**
 * hash 链式地址方式
 * @author l
 */
public class HashChaining {

    /** 键值对数量 */
    private int size;

    /** 容量 */
    private int capacity;

    /** 负载因子 */
    private double loadFactor;

    /** 扩容倍数 */
    private int extendRatio;

    /** 桶 */
    private List<List<Pair>> bucket;

    public HashChaining(){
        this.size = 0;
        this.capacity = 4;
        this.loadFactor = 2.0/3.0;
        this.extendRatio = 2;

        /** 初始化容器 */
        bucket = new ArrayList<List<Pair>>(capacity);
        for (int i = 0; i < capacity; i++) {
            bucket.add(new ArrayList<>());
        }
    }

    private int hashFunc(int key) {
        return key % capacity;
    }

    private double loadFactor(){
        return (double)size/capacity;
    }

    public String get(int key) {
        int index = hashFunc(key);
        List<Pair> list = bucket.get(index);
        for (Pair pair : list) {
            if (null != pair && pair.key == key) {
                return pair.value;
            }
        }
        return null;
    }
    
    public void put(int key, String value){
        if (loadFactor() > loadFactor) {
            extend();
        }
        int index = hashFunc(key);
        List<Pair> pairs = bucket.get(index);
        for (Pair pair : pairs) {
            if (pair != null && pair.key == key) {
                pair.value = value;
                return;
            }
        }
        Pair pair = new Pair(key, value);
        pairs.add(pair);
        size++;
    }
    
    private void extend(){
        /** 旧的数据暂存，bucket变量要给新的用 */
        List<List<Pair>> bucketTmp = bucket;

        /** 计算扩容后的容量 */
        capacity = capacity * extendRatio;
        /** 初始化新的容器 */
        bucket = new ArrayList<List<Pair>>(capacity);
        for (int i = 0; i < capacity; i++) {
            bucket.add(new ArrayList<>());
        }
        size = 0;
        /** 双循环 转移旧数据 */
        for (List<Pair> pairs : bucketTmp) {
            for (Pair pair : pairs) {
                put(pair.key,pair.value);
            }
        }
    }

    public void remove(int key) {
        int index = hashFunc(key);
        List<Pair> pairs = bucket.get(index);
        for (Pair pair : pairs) {
            if (pair != null && pair.key == key){
                pairs.remove(pair);
                size --;
                break;
            }
        }
    }

    public static void main(String[] args) {
        int hashCode = Integer.hashCode(12);
        int code = "".hashCode();
    }
}
