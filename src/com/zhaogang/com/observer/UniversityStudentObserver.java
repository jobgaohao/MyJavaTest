package com.zhaogang.com.observer;

import java.io.File;
import java.io.RandomAccessFile;

import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;

public class UniversityStudentObserver implements Observer {

    File myFile;
    
    public UniversityStudentObserver(String fileName) {
        myFile=new File(fileName);
    }
    
    
    @Override
    public void hearTelephone(String hearMes) {
       try {
        RandomAccessFile out1=new RandomAccessFile(myFile, "rw");
        out1.seek(out1.length()); 
        byte[] b=hearMes.getBytes();
        out1.write(b);
        System.out.println("-------------------------");
        System.out.println("我是一个大学生");
        System.out.println("我想文件"+myFile.getName()+"写入如下内容："+hearMes);        
        System.out.println("-------------------------");
       } catch (Exception e) {
            // TODO: handle exception
        }
    }

}
