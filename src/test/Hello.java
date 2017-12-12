package test;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.StringTokenizer;
	public class Hello{
		
		public static void main(String[] args) {
			// TODO Auto-generated method stub
	        A ab=new B();
	          ab=new B();
	          
	        LocalDateTime dt=LocalDateTime.now();
	        System.out.println(dt.getYear());
	        LocalDateTime yesterday=dt.minusDays(1);
	        LocalDateTime tomorrow=dt.plusDays(1);
	        System.out.println(yesterday);
	        System.out.println(tomorrow);
	        
	        int a=Integer.MAX_VALUE;
	        int b=Integer.MAX_VALUE;
	        int sum=a+b;
	        System.out.println("a="+a+",b="+b+",sum="+sum);
	        
	        final StringBuffer sb=new StringBuffer("sb");
	        //sb=new StringBuffer("");//final修饰的变量，引用变量不能变
	        sb.append(" append");
	      
	        doStringTokenizer("aa,bb,cc,dd,ee");
	        
	        
	        
		}

		
		/**
		 * 逗号分隔的字符串转换成数组
		 * @param str
		 */
		public static void doStringTokenizer(String str){
			//方法1
			if(str!=null&&str.indexOf(',')>=0){
				String[] result=str.split(",");
				for (int i = 0; i < result.length; i++) {
					System.out.println(result[i]);
				}
			}
			
			//方法2
			if(str!=null&&str.indexOf(',')>=0){
				StringTokenizer  tokener=new StringTokenizer(str,",");
				while (tokener.hasMoreElements()) {
					Object object = (Object) tokener.nextElement();
					System.out.println(object);
				}
			}
			
			
		}
}
