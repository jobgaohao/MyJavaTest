package com.zhaogang.com.Adapter.demo1;

/**
 * 手上有个ps2插头的设备，但是主机上只有USB插头接口，通过适配器将Ps2接口转换成USB接口
 * @author hao.gao
 *
 */
public class Test1 {

	 public static void main(String[] args) {
		 Ps2 usb=new Adapter();
		 usb.isPs2();
	}
}
