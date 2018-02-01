package test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ListTest {

	public static void main(String[] args) {
		
		
		 List<Long> liLong=new ArrayList<Long>();
		 liLong.add(null);
		 liLong.add(null);
		 System.out.println(liLong);
		
		
        //List
		List list=new ArrayList(); 
		list.add("test1");
		list.add("test2");
		list.add("test3");
		for (Object object : list) {
			System.out.println(object);
		}
		
		//Set:如果遇到重复元素，不会添加
		Set set=new HashSet();
		set.add("test1");
		set.add("test2");
		if(set.add("test2")){
			System.out.println("add successful");
		}else{
			System.out.println("add failed");
		}
		
		
		Thread thread=new Thread();
		thread.start();
		thread.run();
		thread.getPriority();	
	}

}
