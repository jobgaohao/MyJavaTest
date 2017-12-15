package com.zhaogang.com.observer;

import java.io.File;
import java.io.RandomAccessFile;

public class ProgrammerObserver implements Observer {

    File myFile;
    
    public ProgrammerObserver(String fileName) {
      myFile=new File(fileName);
    }
    
    
    
    @Override
    public void hearTelephone(String hearMess) {
        try{
            boolean boo = hearMess.contains("Java程序员")||hearMess.contains("软件");
            if(boo){
                RandomAccessFile out = new RandomAccessFile(myFile,"rw");
                out.seek(out.length());
                byte[] b = hearMess.getBytes();
                out.write(b);
                System.out.println("-------------------------");
                System.out.println("我是程序员");
                System.out.println("我向文件"+myFile.getName()+"写入如下内容："+hearMess);                
                System.out.println("-------------------------");
            }
            else{
                System.out.println("我是程序员，这次的信息中没有我需要的信息");
            }
        }
        catch(Exception exp){
            System.out.println(exp.toString());
        }
    
    }

}
