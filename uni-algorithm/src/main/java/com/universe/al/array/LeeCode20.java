package com.universe.al.array;

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
        //s长度不为偶数返回false
        int length = s.length();
        if (length % 2 == 1){
            return false;
        }
        //定义判断规则 **右括号为key**
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');

        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            //s包含括号
            if (map.containsKey(s.charAt(i))){

                //对不上 或者为空 不符合
                if (list.isEmpty() || (!Objects.equals(list.peek(), map.get(s.charAt(i))))){
                    return false;
                }
                //遇到右括号弹出来
                list.pop();
            }else {
                //左括号放进去
                list.push(s.charAt(i));
            }
        }
        return list.isEmpty();
    }
}
