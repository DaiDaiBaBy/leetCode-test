package com.example.leetcode.demo.LeetCode0409;

/**
 * @Description:
 * @Author: zhoufu
 * @Date: 13:57 2020/4/24
 */

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 字符          数值
 I             1
 V             5
 X             10
 L             50
 C             100
 D             500
 M             1000
 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 */
public class test6 {

    /**
     * linkedMap在于存储数据你想保持进入的顺序与被取出的顺序一致的话，
     * 优先考虑LinkedMap，hashMap键只能允许为一条为空，value可以允许为多条为空，键唯一，但值可以多个
     * linkedMap键和值都不可以为空
     * @param args
     */
    public static void main(String[] args) {
     int num = 1994;
     System.out.println("结果：" + intToRoman(num));
    }

    public static String intToRoman(int num){
        Map<Integer,String> map = new LinkedHashMap<>();
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40,"XL");
        map.put(10,"X");
        map.put(9,"IX");
        map.put(5,"V");
        map.put(4, "IV");
        map.put(1,"I");

        StringBuilder sb = new StringBuilder();
        for (Integer key : map.keySet()){
        int n = num / key;
        if (n == 0) continue;
        for (int i = n ; i > 0; i--){
            sb.append(map.get(key));
        }
        num -= n * key;
        if (num == 0){
            break;
        }
        }
        return sb.toString();
    }
}
