package com.zhaogang.com.arrayList;

import java.util.ArrayList;
import java.util.List;


/**
 * 
 * <pre>
 * 1.ArrayList的大小如何自动增长的。
 * 有人试图在arraylist中增加一个对象的时候，Java会去检查arraylist，以确保已存在的数组中有足够的容量来存储这个新的对象。
 * 如果没有足够容量的话，那么就会新建一个长度更长的数组，旧的数组就会使用Arrays.copyOf方法被复制到新的数组中去，
 * 现有的数组引用指向了新的数组
 * 
 * 2.什么情况下使用ArrayList,什么时候会选择LinkedList?
 * 当你遇到访问元素比插入或者是删除元素更加频繁的时候，你应该使用ArrayList。
 * 另外一方面，当你在某个特别的索引中，插入或者是删除元素更加频繁，或者你压根就不需要访问元素的时候，你会选择LinkedList。
 * 这里的主要原因是，在ArrayList中访问元素的最糟糕的时间复杂度是”1″，而在LinkedList中可能就是”n”了。
 * 在ArrayList中增加或者删除某个元素，通常会调用System.arraycopy方法，这是一种极为消耗资源的操作，
 * 因此，在频繁的插入或者是删除元素的情况下，LinkedList的性能会更加好一点。
 * 
 * 
 * 
 * </pre>
 *
 * @author hao.gao
 * @version $Id: Demo1.java, v 0.1 2017年10月27日 上午11:37:55 hao.gao Exp $
 */
public class Demo1 {

    public static void main(String[] args) {
        List<String> li=new ArrayList<String>();
        li.add("上海");
        li.add("武汉");
    }
}
