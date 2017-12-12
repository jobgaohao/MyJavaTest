package test;

import java.math.BigDecimal;

public class TestSplit {

    public static void main(String[] args) {
        
        testSplitDemo();
    }
    
    @Deprecated
    public static void testSplitDemo(){
        String str="12345一二三四五";
        String[] strList=str.split(",");
        String myStr0 = strList[0];
        String myStr1 = strList[1];
        System.out.println(myStr0);
        System.out.println(myStr1);
    }
    
    public  static void testAdd(){
        BigDecimal dtlSum = BigDecimal.ZERO;
        for (int i = 1; i <= 5; i++) {
            dtlSum=dtlSum.add( new BigDecimal(i) );
        }
        System.out.println(dtlSum);
    }

}
