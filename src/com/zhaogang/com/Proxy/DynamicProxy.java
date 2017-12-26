package com.zhaogang.com.Proxy;

import java.io.FileOutputStream;
import java.lang.reflect.Proxy;
import sun.misc.ProxyGenerator;
/**
 * 
 * <pre>
 * 通过代理类创建对象
 * </pre>
 *
 * @author hao.gao
 * @version $Id: DynamicProxy.java, v 0.1 2017年12月12日 下午2:17:28 hao.gao Exp $
 */
public class DynamicProxy {

    public static void main(String[] args) {
      RealSubject real=new RealSubject();  
      
      Subject proxySubject=(Subject)Proxy.newProxyInstance(Subject.class.getClassLoader(),
          new Class[]{Subject.class},
          new ProxyHandler(real));
      
      proxySubject.doSomething();
      createProxyClassFile();
    }

    public static void createProxyClassFile(){
        String name="ProxySubject";
        byte[] data=ProxyGenerator.generateProxyClass(name, new Class[] {Subject.class});
        try {
            FileOutputStream out=new FileOutputStream(name+".class");
            out.write(data);
            out.close();
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
}
