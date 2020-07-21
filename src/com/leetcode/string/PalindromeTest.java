/**
 * Project Name: 邮乐支付系统
 * File Name: PalindromeTest
 * Package Name: com.leetcode.string
 * Date: 2019/6/20 14:52
 * Copyright (c) 2019, 上海邮乐网络技术有限公司
 * author：xiao.y
 */
package com.leetcode.string;

/**
 * ClassName: PalindromeTest <br>
 * Function: 回文数判断. <br>
 * Date: 2019/6/20 14:52 <br>
 */
public class PalindromeTest {

    public static void main(String[] args) {
        PalindromeTest test = new PalindromeTest();
        System.out.println(test.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(test.isPalindrome("race a car"));
    }

    private static final char[]charMap = new char[256];
    static{
        for(int i=0;i<10;i++){
            charMap[i+'0'] = (char)(1+i);  // numeric
        }
        for(int i=0;i<26;i++){
            charMap[i+'a'] = charMap[i+'A'] = (char)(11+i);  //alphabetic, ignore cases
        }
    }
    public boolean isPalindrome(String s) {
        char[]pChars = s.toCharArray();
        int start = 0,end=pChars.length-1;
        char cS,cE;
        while(start<end){
            cS = charMap[pChars[start]];
            cE = charMap[pChars[end]];
            if(cS!=0 && cE!=0){
                if(cS!=cE)return false;
                start++;
                end--;
            }else{
                if(cS==0)start++;
                if(cE==0)end--;
            }
        }
        return true;
    }
}
