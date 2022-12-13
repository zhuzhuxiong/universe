package com.universe.al.array;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 * 示例 1：
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *
 * 作者：Krahets
 * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/50ywkd/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class ReplaceSpace {

    public static void main(String[] args) {
        String s = "We are happy.";
        String s1 = replaceSpace(s);
        System.out.println(s1);
        System.out.println(s);
    }

    /**
     * 别老想着在原串里搞，新建一个结果集接收
     * @param s
     * @return
     */
    public static String replaceSpace(String s) {
        String res = "";
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (chars[i] == ' '){
                res = res + "%20";
            }else {
                res = res + chars[i];
            }
        }
        return res;
    }
}
