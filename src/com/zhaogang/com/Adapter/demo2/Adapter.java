package com.zhaogang.com.Adapter.demo2;

/**
 * 用于将ps2接口格式转换成为USB接口格式
 * @author hao.gao
 *
 */
public class Adapter  implements Ps2{
  
	 private Usb usb;
	 public Adapter(Usb usb){
		 this.usb=usb;
	 }
	
	@Override
	public void isPs2() {
		usb.isUsb();
	}

}
