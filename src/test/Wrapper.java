package test;

/**
 * 包装类型【为了将基本数据类型当成对象操作，java 引入了包装类型】
 * @author hao.gao
 *
 */
public class Wrapper {

	public static void main(String[] args) {
		Integer a=new Integer(3); 
		Integer b=new Integer(3);
		Integer c=3;//将3自动装箱成Integer类型
		Integer e=3;
		int d=3;
		int f=3;
		
		System.out.println(a==b);//两个引用没有引用同一个对象
		System.out.println(a==c);
		System.out.println(a==d);//a自动拆箱再跟c比较
		System.out.println(c==d);
		System.out.println(c==e);
		System.out.println(d==f);
		
		System.out.println("===========================");
		//如果整型字面量的值在-128到127之间，那么不会new新的Integer对象，而是直接引用常量池中的Integer对象，
		//所以上面的面试题中f1==f2的结果是true，而f3==f4的结果是false。
		Integer i1 = 100, i2 = 100, i3 = 150, i4 = 150;
        System.out.println(i1 == i2);
        System.out.println(i3 == i4);
        int f1 = 100, f2 = 100, f3 = 150, f4 = 150;
        System.out.println(f1 == f2);
        System.out.println(f3 == f4);
		
	}
}
