package com.universe.al.array;

public class InversionStrings {

    public static void main(String[] args) {
        char[] s = {'a','b','c'};
        InversionStrings strings = new InversionStrings();
        strings.reverseString(s);

    }

    public void reverseString(char[] s) {
        int length = s.length;
        int i = 0;
        int j = length - 1;
        while (i < j){
            swap(s,i++,j--);
        }
    }

    private void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}
