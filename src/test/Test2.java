package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test2 {

    public static void main(String[] args) {
        long b=001;
        long c=012;
        System.out.println("b:"+b);
        System.out.println("c:"+c);
        
        System.out.println(isInvoiceNumeric("012"));
        System.out.println(isInvoiceNumeric("0 1 2"));
        System.out.println(isInvoiceNumeric("a 0 1 2"));
        System.out.println(isInvoiceNumeric("1234"));
        System.out.println(isInvoiceNumeric("91!^&*"));
    }
    
    public static boolean isInvoiceNumeric(String str){ 
        Pattern pattern = Pattern.compile("[0-9]*"); 
        Matcher isNum = pattern.matcher(str);
        if( !isNum.matches() ){
            return false; 
        } 
        return true;
     }
}
