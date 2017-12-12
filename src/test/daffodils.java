package test;

/**
 * /**
 * 题目：打印出所有的"水仙花数"，所谓"水仙花数"是指一个三位数，其各位数字立方和等于该数本身。
 * 例如：153是一个"水仙花数"，因为153=1的三次方＋5的三次方＋3的三次方。
 * 1.程序分析：利用for循环控制100-999个数，每个数分解出个位，十位，百位。
 * 
 * @author hao.gao
 *
 */
public class daffodils {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int a,b,c;
        int data;
        for (int i = 100; i < 999; i++) {
			a=i/100;//百位
			b=(i-a*100)/10;//十位
			c=i-100*a-10*b;//个位
			data=a*a*a+b*b*b+c*c*c;
			if(data==i){
				System.out.println("水鲜花数字："+i);
			}
		}
	}

}
