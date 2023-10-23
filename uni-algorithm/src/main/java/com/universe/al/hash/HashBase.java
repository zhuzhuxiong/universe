package com.universe.al.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author
 */
public class HashBase {

    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        System.out.println(1<<30);
        map.put(1,"1");
        map.put(2,"2");
        map.put(3,"3");
        map.get(1);
        map.remove(1);

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }

        for (Integer key : map.keySet()) {
            System.out.println("key:" + key);
        }

        for (String value : map.values()) {
            System.out.println("value:" + value);
        }



    }
}
