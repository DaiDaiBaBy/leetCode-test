package com.example.leetcode.demo.LeetCode0409;

/**
 * @Description:
 * @Author: zhoufu
 * @Date: 13:38 2020/4/16
 */
/**
 * 假设你正在爬楼梯，需要n步你才能到达顶部。但每次你只能爬一步或者两步，你能有多少种不同的方法爬到楼顶部？
 */
//给定 n 是一个正整数。
/**
 只有1个台阶的时候    总共有1种走法   f(1) = 1
 只有2个台阶的时候    总共有2种走法   f(2) = 2
 只有3个台阶的时候    总共有3种走法   f(3) = 3   f(n) = f(n-1) + f(n+1)  //n>2
 只有4个台阶的时候    总共有5种走法
 只有5个台阶的时候    总共有8种走法
 ......
 */
//递归
public class test2 {

    public static void main(String[] args){
        int n = 5; //台阶数
        System.out.println(new ClimbFloor().climbFloor(n));
    }

    static class ClimbFloor {
        public int climbFloor(int n){
            return floors(n);
        }

        public int floors(int n) {
            if (n <= 0) {
                return -1;
            } else if (n == 1 || n == 2) {
                return n;
            } else {
                return floors(n - 1) + floors(n - 2);
            }
        }
    }
}
