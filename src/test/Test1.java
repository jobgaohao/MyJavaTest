package test;

public class Test1 {
  public static void main(String[] args) {

      long successNum=0;
      String a=",张三丰,";
      People people=new People();
      people.setName("张三");
      doOperate(successNum,people);
      System.out.println(successNum);
      System.out.println(people.getName());   
      String remark="你好呀，我的国";
      System.out.println(remark.substring(0, 3));
      
      System.out.println("张三丰".replace("三",""));
      System.out.println("张三丰".replace("三"," "));
      StringBuffer sb=new StringBuffer();
      System.out.println("SB"+sb.deleteCharAt(sb.length()-1));
          
  }
  
  public static void doOperate(long successNum,People people){
      successNum=successNum+1;
      people.setName("李四");
  }
}
