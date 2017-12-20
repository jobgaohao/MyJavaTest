package com.zhaogang.com.Adapter.demo2;

/**
 * AdapterÊÊÅäÆ÷£¬½«Ps2×ª»»³ÉUsb
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
