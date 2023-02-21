package com.universe.al.array;

/**
 * 验证回文
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * 示例 1:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 解释："amanaplanacanalpanama" 是回文串
 * @author l
 */
public class LeeCode9 {

    public static void main(String[] args) {
        int num = -1221;
        boolean b = solution2(num);
        System.out.println(b);
    }

    /**
     * 双指针 字符串
     * @param s
     * @return
     */
    public static boolean solution1(String s){
        if (s.length() == 0){
            return true;
        }
        char[] chars = s.toCharArray();
        int i = 0,j = chars.length - 1;
        while (i < j){
            while (!Character.isLetterOrDigit(chars[i]) && i < j){
                i++;
            }
            while (!Character.isLetterOrDigit(chars[j]) && i < j){
                j--;
            }
            if (Character.toLowerCase(chars[i]) != Character.toLowerCase(chars[j])){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    /**
     *  数字回文：1、变成字符串；2、翻转数字对比（可能超过Integer.max-但是超过了就不可能是回文）--> 翻转一半数字
     * @param x
     * @return
     */
    public static boolean solution2(int x){
        //负数不回文；
        //个位为0，但num不是0 不回文；
        if (x < 0 || (x % 10 ==0 && x != 0)){
            return false;
        }
        int rev = 0;
        //当取余后原数（x / 10）小于等于翻转后的数字（rev * 10 + x % 10），即完成一半
        while (x > rev){
            rev = rev * 10 + x % 10;
            x = x / 10;
        }
        // x的长度为奇数是 中间数不影响回文
        return x == rev || x == rev / 10;

    }

    /**
     * 整个翻转 对比原数字；翻转后大于Integer.MAX_VALUE 不是回文
     *
     * @param x
     * @return
     */
    public static boolean solution3(int x){
        if (x < 0 || (x % 10 ==0 && x != 0)){
            return false;
        }
        int rev = 0;
        //与方法2区别：循环终止条件
        int o = x;
        while (x > 0){
            rev = rev * 10 + x % 10;
            x = x / 10;
            if (rev >= Integer.MAX_VALUE){
                return false;
            }
        }
        return o == rev;
    }

    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)){
            return false;
        }
        int y = 0;
        int o = x;
        while (x > y){
            y = y * 10 + x % 10;
            x = x/10;
            if (y > Integer.MAX_VALUE){
                return false;
            }
        }
        return o == y;
    }
}
