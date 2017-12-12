package test;

/**
 * 菲波那切数列
 * @author hao.gao
 * 有一对兔子，从出生后第1个月起每个月都生一对兔子，小兔子长到第1个月后每个月又生一对兔子，假如兔子都不死，问每个月的兔子总数为多少
 */
public class rabbit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int month=12;
       for (int i = 1; i <= month; i++) {
		System.out.println("第"+i+"月，共"+fib(i)+"兔子");
	   }
	}
	
	/**
	 * 递归算法
	 * @param month
	 * @return
	 */
	public static int fib(int month){
		if(month==1||month==2){
			return 1;
		}else{
			return fib(month-1)+fib(month-2);
		}
	}

}
