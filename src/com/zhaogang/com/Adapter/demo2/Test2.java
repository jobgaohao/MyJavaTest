package com.zhaogang.com.Adapter.demo2;

/**
 * 使用适配器将ps2接口能够试用USB
 * @author hao.gao
 *
 */
public class Test2 {

	public static void main(String[] args) {
		Ps2 usb=new Adapter(new Usber());
		usb.isPs2();
	}
}
