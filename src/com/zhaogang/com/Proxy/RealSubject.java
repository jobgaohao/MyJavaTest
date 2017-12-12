package com.zhaogang.com.Proxy;

public class RealSubject implements Subject{

    @Override
    public void doSomething() {
      System.out.println("call doSomething");
    }
}
