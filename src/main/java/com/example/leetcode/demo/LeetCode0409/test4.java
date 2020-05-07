package com.example.leetcode.demo.LeetCode0409;

/**
 * @Description:
 * @Author: zhoufu
 * @Date: 14:37 2020/4/17
 */

/**
 * 原题是shell命令统计词频
 * cat words.txt |  tr " " "\n" | sed -e '/^$/d' | sort | uniq -c | sort -rn | awk '{print $2,$1}'
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 现在我增加一个java代码实现词频统计功能(统计文件内容词频-中英文)
 * 步骤：
 * 1.新建文件txt
 * 2.输入一些英文单词
 * 3.统计各个单词出现的次数
 * 4.进行排序
 * 5.按照次数降序
 *
 * （文件读取，流操作）
 1，在电脑本地磁盘下创建一个名称为data的文本文件
 2.通过Map集合，以键值对的方式去存储单词和出现的次数
 3.定义一个文件字节读取流，去读取磁盘中的文件
 4.创建一个BufferReader(没有缓冲区时，每次读取操作都会导致一次文件读取操作（就是告诉操作系统内核我要读这个文件的这个部分，麻烦你帮我把它取过来）。
 有缓冲区时，会一次性读取很多数据，然后按要求分次交给上层调用者。)的缓冲流，将字符流对象传进去，提高读取的效率
 5.创建一个spilt数组，用来分割字符串，通过调用map的key值获取value，进行单词统计。
 6.利用TreeMap实现Comparator接口，对Map集合进行排序
 */
public class test4 {
    /**
     * map集合遍历方式一：使用keySet方法遍历， 缺点是：keySet方法只是返回了所有的键，没有值，
     *  Set<String> keys = map.keySet();//keySet()把map集合中的所有键都保存到一个Set类型的集合对象中返回
     *  Iterator<String> it = keys.iterator();
     *  while(it.hasNext()){
     *      String key = it.next();
     *      System.out.println("键："+ key + "值："+map.gey(key));
     *  }
     *
     *  map集遍历方式二：使用values方法遍历。缺点：values方法只返回所有的值，没有键
     *  Collection<String> c = map.values(); //values()把所有的值存储到一个Collection集合中返回
     *  Iterator<String> it = c.iterator();
     *  while(it.hasNext()){
     *      System.out.println("值："+it.next());
     *  }
     *
     *  map集合遍历方式三： 使用entry方法遍历
     *  Set<Map.Entry<String,String>> entrys = map.entrySet();
     *  Iterator<Map.Entry<String,String>> it = entrys.iterator();
     *  while(it.hasNext()){
     *      Map.Entry<String,String> entry = it.next();
     *      System.out.println("键："+ entry.getKey()+ "值：" + entry.getValue());
     *  }
     *
     */

    public static void main(String[] args) {
        String string = "";
        //通过键值对的方式去存储字符串和出现的次数
        Map<String, Integer>  map = new HashMap<String, Integer>();
        try {
            //定义一个文件字节读取流，去读取磁盘中的文件
            FileInputStream fileInputStream = new FileInputStream("C:\\tool\\develop\\data.txt");
            //创造一个bufferReader缓冲流，将字符流对象放入进去，提高读取的效率
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            String temp = "";
            try{
                //从BufferReader中读取下一行
                while ((temp =bufferedReader.readLine()) != null){
                    string = string + temp;   //读取到的文件信息
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        //创建一个split数组，分割字符串，来统计字符串出现的次数
        String[] splits = string.split("");
        for (int i = 0; i<splits.length; i++){
            //通过map.get(),通过键名来获取键值
            if (map.get(splits[i]) == null){
                //map.put()将键值存储在map集合中，如果存在，那么就覆盖该键值，不存在就新建一个
                map.put(splits[i],1);
            }else {
                int in = map.get(splits[i]);
                map.put(splits[i],++in);
            }
        }

        //利用TreeMap实现Comparator接口
        Comparator<Map.Entry<String, Integer>> entryComparator = new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
//                return o1.getValue() - o2.getValue();  //升序
                return o2.getValue() - o1.getValue();
            }
        };

        //map转换成list进行排序。Entry是Map中的一个静态内部类，用来表示Map中的每个键值对
        //map.EntrySet(),实现了Set接口，里面存放 是键值对
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
        //进行排序

        Collections.sort(list, entryComparator);
        //默认情况下，TreeMap对key进行升序排序
        System.out.println("----------map按照value降序排序-----------");
        for (Map.Entry<String, Integer> entry : list){
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }


    }
}
