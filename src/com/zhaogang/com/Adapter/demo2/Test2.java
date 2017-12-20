package com.zhaogang.com.Adapter.demo2;

/**
 * 我手中有个ps2插头的设备，但是主机上只有usb插头的插口，怎么办呢？弄个转换器，将ps2插头转换成为USB插头就可以使用了。
 * @author hao.gao
 *
 */
public class Test2 {

	public static void main(String[] args) {
		Ps2 usb=new Adapter(new Usber());
		usb.isPs2();
	}
}
