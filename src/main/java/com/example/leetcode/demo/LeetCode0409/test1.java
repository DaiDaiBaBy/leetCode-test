package com.example.leetcode.demo.LeetCode0409;

/**
 * @Description:
 * @Author: zhoufu
 * @Date: 11:00 2020/4/9
 */

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 示例：
 输入：n = 3
 输出：[
 "((()))",
 "(()())",
 "(())()",
 "()(())",
 "()()()"
 ]
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 核心是必须要先有一个左括号才能给字符串添加括号，且无论何时右括号的个数一定要小于等于左括号的个数
 */
//回溯法（递归算法问题）
public class test1 {
    public static void main(String[] args){
        Solution s = new Solution();
        int n = 2;
        System.out.println(s.getKuohao(n));
    }
    static class Solution{
    public List<String> getKuohao(int n){
        List<String> list = new ArrayList<>();
        add(list,"",0,0,n);
        return list;
    }
    public void add(List<String> list, String a, int left, int right, int n){
        if (left > n || right > n) {
            return;
        }
        if (left == n && right == n){
            list.add(a);
        }
        if (left >= right){
            String s = new String(a);
            add(list, a+"(",  left + 1, right, n);
            add(list, s + ")", left, right + 1, n);
            }
        }
    }
}
