package com.universe.array;

/**
 * 验证回文
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 解释："amanaplanacanalpanama" 是回文串
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xne8id/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Palindrome {

    public static void main(String[] args) {

    }

    /**
     * 双指针
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
}
