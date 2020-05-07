package com.example.leetcode.demo.LeetCode0409;

/**
 * @Description:
 * @Author: zhoufu
 * @Date: 14:54 2020/4/16
 */

import java.util.Scanner;

/**
 * 求s=a+aa+aaa+aaaa+aa...a的值，其中a是
 * 一个数字。例如2+22+222+2222+22222(此时共有5个
 * 数相加)，几个数相加有键盘控制。
 */
public class test3 {
    public static void main(String[] args){
        int b=0,s=0,i=1;
        String str=null;
        @SuppressWarnings("resource")
        Scanner in=new Scanner(System.in);
        System.out.println("请输入a的值：");
        int a=in.nextInt();
        System.out.println("请输入相加的个数n：");
        int n=in.nextInt();
        if(n==1){
            str="s="+a;
        }else if(n==2){
            str="s="+a+"+"+a+a;
        }else if(n==3){
            str="s="+a+"+"+a+a+"+"+a+a+a;
        }else if(n==4){
            str="s="+a+"+"+a+a+"+"+a+a+a+"+"+a+a+a+a;
        }else{
            str="s="+a+"+"+a+a+"+"+a+a+a+"+...+"+a+a+"..."+a;
        }
        while(i<=n){
            b+=a;
            s+=b;
            a=a*10;
            i++;
        }
        System.out.println(str+"=" + s);
    }
}
