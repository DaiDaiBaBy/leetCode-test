package com.example.leetcode.demo.LeetCode0409;

/**
 * @Description:
 * @Author: zhoufu
 * @Date: 12:43 2020/5/6
 */

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.*;

/**
 * 词频统计升级版
 */
public class test7 {
    public static void main(String[] args) throws Exception {
        //输出文本文件
         PrintStream ps = new PrintStream(new FileOutputStream("C:\\tool\\develop\\word.txt"));
             System.setOut(ps);
             //待读取文本文件
             BufferedReader br = new BufferedReader(new FileReader("C:\\tool\\develop\\data.txt"));
             List<String> list = new ArrayList<String>();
             String readLine = null;
             while((readLine=br.readLine())!=null){
                 String [] onlyWord = readLine.split("[a-zA-Z']+");//只有字母
                 for(String word : onlyWord){
                 if(word.length()!=0){
                 list.add(word);
              }
         }
     }

         br.close();//关闭流操作
         Map<String,Integer> map = new TreeMap<String, Integer>();//利用 TreeMap进行统计并且排序
         for(String mapWord : list){
         if(map.get(mapWord)!=null){
            map.put(mapWord, map.get(mapWord)+1);
         }else{
           map.put(mapWord, 1);
            }
         }
    SortMap(map);
   }

 public static void SortMap(Map<String,Integer>oldmap){
         ArrayList<Map.Entry<String, Integer>>newList = new ArrayList<Map.Entry<String,Integer>>(oldmap.entrySet());
            Collections.sort(newList,new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
             return o2.getValue()-o1.getValue();//降
             }
       });
             for(int i=0;i<newList.size();i++){
             System.out.println(newList.get(i).getKey()+": "+ newList.get(i).getValue());
         }
     }
}
