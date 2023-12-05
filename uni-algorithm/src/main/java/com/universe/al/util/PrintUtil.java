package com.universe.al.util;

import java.util.List;

/**
 * @author
 */
public class PrintUtil {

    public static <T> void printMatrix(List<List<T>> matrix) {
        System.out.println("[");
        for (List<T> row : matrix) {
            System.out.println("  " + row + ",");
        }
        System.out.println("]");
    }
}
