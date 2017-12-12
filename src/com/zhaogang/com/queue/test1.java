package com.zhaogang.com.queue;

import java.util.LinkedList;
import java.util.Queue;

public class test1 {

    public static void main(String[] args) {
        Queue<String> queue=new LinkedList<>();
        queue.add("a");
        queue.offer("b");
        queue.offer("c");
        queue.offer("d");
        for (String q : queue) {
            System.out.println(q);
        }
        System.out.println("---------------------");
        System.out.println("poll="+queue.poll());
        for (String q : queue) {
            System.out.println(q);
        }
    }
}
