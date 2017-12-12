package com.zhaogang.com.queue;

import java.util.LinkedList;

public class test2 {
    public static void main(String[] args) {
         LinkedList<String> list=new LinkedList<String>();
         list.add("1");
         list.add("2");
         list.add("3");
         list.add("4");
         System.out.println(list);
         list.addFirst("0");
         System.out.println(list);
         list.addLast("5");
         System.out.println(list);
         System.out.println("获取链表的第一个元素："+list.getFirst());
         System.out.println("获取链表的最后一个元素："+list.getLast());
         //删除链表数据
         list.subList(2, 3).clear();
         System.out.println(list);
    }
}
