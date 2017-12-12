package test;

import java.math.BigDecimal;
public class AA {

    public static void main(String[] args) {
        BigDecimal bd=new BigDecimal(0.03);
        BigDecimal bd1=new BigDecimal(0.17);
        
        BigDecimal bd2= bd.multiply(bd1)
        .divide(BigDecimal.ONE.add(bd1),2, BigDecimal.ROUND_HALF_UP);
        System.out.println(bd2);
    }

}
