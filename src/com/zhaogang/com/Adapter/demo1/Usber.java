package com.zhaogang.com.Adapter.demo1;

/**
 * 具体的USB接口格式
 * @author hao.gao
 *
 */
public class Usber implements Usb {

	@Override
	public void isUsb() {
		System.out.println("USB 接口");
	}

}
