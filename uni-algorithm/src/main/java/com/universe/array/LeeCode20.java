package com.universe.array;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Objects;

/**
 * 栈方法：characters.peek(); -- 返回栈顶元素，但不删除
 *      characters.pop(); -- 返回栈顶元素，删除
 *
 *      1、奇数长度 FALSE
 *      2、
 * @author L
 */
public class LeeCode20 {

    public static void main(String[] args) {
        String s = "{[]}";
        String s1 = "()[{]}";
        boolean solution = new LeeCode20().solution(s1);
        System.out.println("solution:" + solution);
    }

    public boolean solution(String s){
        int length = s.length();
        if (length % 2 == 1){
            return false;
        }
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');

        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            if (map.containsKey(s.charAt(i))){
                if (list.isEmpty() || (!Objects.equals(list.peek(), map.get(s.charAt(i))))){
                    return false;
                }
                list.pop();
            }else {
                list.push(s.charAt(i));
            }
        }
        return list.isEmpty();
    }
}
