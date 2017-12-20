package com.zhaogang.com.observer;

import java.io.File;
import java.io.RandomAccessFile;


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
        System.out.println("鎴戞槸涓�涓ぇ瀛︾敓");
        System.out.println("鎴戞兂鏂囦欢"+myFile.getName()+"鍐欏叆濡備笅鍐呭锛�"+hearMes);        
        System.out.println("-------------------------");
       } catch (Exception e) {
            // TODO: handle exception
        }
    }

}
