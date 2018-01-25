package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class intArray {

	public static void main(String[] args) {			
		testArrays();		
	}
	
	/**
	 * int[] a={1,3,5,7,9}
	 * int[] b={2,4,6,8,10}
	 * int[] c={1,10,2,9,3,8,4,7,5,6}
	 * 按顺序输出次的最大最小
	 */
	public static void testArrays(){
		int[] a={1,3,5,7,9};
		int[] b={2,4,6,8,10};
		int[] c=contact(a, b);
		List lis=new ArrayList<>();
		Arrays.sort(c);
		for (int i = 0; i < c.length; i++) {
			if(i>=c.length/2){				
				break;
			}
			else{
				lis.add(c[i]);
				lis.add(c[c.length-i-1]);				
			}			
		}
		System.out.println(lis);
	}
	
	public static int[] contact(int a[],int b[]){
		int[] f=new int[a.length+b.length];
		for (int i = 0; i < f.length; i++) {
			if(i<a.length){
				f[i]=a[i];
			}else{
				f[i]=b[i-a.length];
			}
		}
		return f;
	}
		
	public static void intSort(){
		int[] a={10,9,2,11,12,3};		
		Arrays.sort(a,1,4);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}
