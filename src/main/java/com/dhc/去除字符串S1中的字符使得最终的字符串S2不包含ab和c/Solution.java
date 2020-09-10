package com.dhc.去除字符串S1中的字符使得最终的字符串S2不包含ab和c;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：Haochen.Dai
 * @date ：Created in 2019/12/10 16:26
 * @description： 主要注意 acccb, accccabccccb这样的形式，删除c和ab之后反而会出现新的ab
 */
public class Solution {

    public static void main(String[] args) {
//abcahjsdhjshjadshjashjhjsdbabccacccccabcccccccbacccccccsb   jsdbabaabbasb
        System.out.println(new Solution().removeString("aeebaacccbb"));
//        ahjsdhjshjadshjashjhjsdbasb
//        ahjsdhjshjadshjashjhjsdbasb
    }

    public String removeString(String S1) {

        char[] chars = S1.toCharArray();

        List<Character> result = new ArrayList<>();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'a') {
                i = startWithA(result, chars, i);
            } else if (chars[i] != 'c') {
                result.add(chars[i]);
            }
        }
        StringBuffer sb = new StringBuffer();
        for (Character character : result) {
            sb.append(character);
        }
        return sb.toString();
    }

    public int startWithA(List<Character> list, char[] chars, int i) {
        List<Character> mayResult = new ArrayList<>();
        mayResult.add(chars[i]);
        for (int j = i + 1; j < chars.length; j++) {
            if (chars[j] == 'c') {
                continue;
            } else if (chars[j] == 'b') {
                mayResult.clear();
                return j;
            } else if (chars[j] == 'a') {
                j = startWithA(list, chars, j);
            } else {
                mayResult.add(chars[j]);
                list.addAll(mayResult);
                return j;
            }
        }
        return chars.length;
    }


}
