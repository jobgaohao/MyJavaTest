package com.zhaogang.com.buffer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class BufferTest {
  public static void main(String[] args) throws IOException {
      noBufferWrite();
      bufferWrite();
  }
  
  
  public static void noBufferWrite() throws IOException{
      Writer writer=new FileWriter(new File("buffer.txt"));
      long begin=System.currentTimeMillis();
      for (int i = 0; i < 500000000; i++) {
          writer.write(i);
      }
      writer.close();
      System.out.println("无缓冲耗时："+(System.currentTimeMillis()-begin));
  }
  
  public static void bufferWrite() throws IOException{
      Writer writer=new BufferedWriter(new FileWriter(new File("buffer.txt")));
      long begin=System.currentTimeMillis();
      for (int i = 0; i < 500000000; i++) {
          writer.write(i);
      }
      writer.close();
      System.out.println("缓冲耗时："+(System.currentTimeMillis()-begin));
  }
}
