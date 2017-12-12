package test;

import java.util.Scanner;



/**
 * 输入一行字符，分别统计出其中英文字母、空格、数字和其它字符的个数。 1.程序分析：利用while语句,条件为输入的字符不为'\n'
 * @param args
 */
public class strIdentify {


	public static void main(String[] args) {
		System.out.print("请输入字符串：");
		Scanner sc=new Scanner(System.in);
	    int abcCount=0;
	    int spaceCount=0;
	    int numCount=0;
	    int otherCount=0;
	    String str=sc.nextLine();
	    char[] ch=str.toCharArray();
	    for (int i = 0; i < ch.length; i++) {
			if(Character.isDigit(ch[i]))
			{
				numCount++;
			}
			else if(Character.isSpace(ch[i])){
				spaceCount++;
			}
			else if(Character.isLetter(ch[i])){
				abcCount++;
			}
			else{
				otherCount++;
			}
		}
	    System.out.println("字母个数"+abcCount);
        System.out.println("数字个数"+numCount);
        System.out.println("空格个数"+spaceCount);
        System.out.println("其他字符个数"+otherCount);
	}

}
