package test;

import java.io.UnsupportedEncodingException;

public class WorldTest1 {

    
    public static void main(String[] args) throws UnsupportedEncodingException {
       
        String gbk = "12345一二三四五";//数据库10个长度 
        String iso = new String(gbk.getBytes("UTF-8"),"ISO-8859-1");   
        String utf8=new String(iso.getBytes("ISO-8859-1"),"UTF-8");   
        System.out.println(getWordCount(gbk)); 
        System.out.println(getWordCount(iso)); 
        System.out.println(getWordCount(utf8));         
        System.out.println(gbk.substring(0,10));
    }
    
    
    public static int getWordCount(String s)
    {
        int length = 0;
        for(int i = 0; i < s.length(); i++)
        {
            int ascii = Character.codePointAt(s, i);
            if(ascii >= 0 && ascii <=255)
                length++;
            else {
                length += 2;
            }
        }
        return length;
    }
}
