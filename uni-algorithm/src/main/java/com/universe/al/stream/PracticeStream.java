package com.universe.al.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PracticeStream {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        list.forEach(System.out::println);
        System.out.println(list.stream().filter(s -> !s.isEmpty()).count());
        list.stream().map(s -> s + "i").collect(Collectors.toList()).forEach(System.out::println);


    }
}
