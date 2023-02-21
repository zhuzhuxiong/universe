package com.universe.al.array;

/**
 * @author
 */
public class LeeCode14 {

    public static void main(String[] args) {
        String[] strs = {"aaa","aa","aaa"};
        String solution = new LeeCode14().solution(strs);
        System.out.println(solution);
    }

    /**
     * 横向对比
     * @param strs 输入
     * @return L
     *
     */
    public String solution(String[] strs) {
        if (null == strs || strs.length == 0){
            return "";
        }
        //第一个
        String fir = strs[0];
        //外循环
        for (int i = 1; i < strs.length; i++) {
            //从第二个开始
            String str = strs[i];
            //第一个 和 后续对比，去长度最短的
            int min = Math.min(fir.length(), str.length());
            //内循环条件 + 截取条件
            int index = 0;
            //和第一个对比
            while (index < min && fir.charAt(index) == str.charAt(index)){
                index++;
            }
            //截取
            fir  = fir.substring(0,index);
            if (fir.length() == 0){
                break;
            }

        }
        return fir;
    }

    /**
     * 纵向对比
     * @return L
     */
    public String solution2(String[] strs) {
        if (null == strs || 0 == strs.length){
            return "";
        }
        //数组长度 内循环
        int sLength = strs.length;
        //第一个长度 外循环
        int length = strs[0].length();
        //外循环
        for (int i = 0; i < length; i++) {
            //第一个为基准
            char c = strs[0].charAt(i);
            //每个 跟第一个的每个对比
            for (int j = 1; j < sLength; j++) {
                //循环终止条件： 元素长度最短，元素无公共子串
                if (i == strs[j].length() || c != strs[j].charAt(i)){
                    return strs[0].substring(0,i);
                }

            }
        }
        return strs[0];
    }

}
