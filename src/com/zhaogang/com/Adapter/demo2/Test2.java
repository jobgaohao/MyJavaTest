package com.zhaogang.com.Adapter.demo2;

/**
 * ʹ����������ps2�ӿ��ܹ�����USB
 * @author hao.gao
 *
 */
public class Test2 {

	public static void main(String[] args) {
		Ps2 usb=new Adapter(new Usber());
		usb.isPs2();
	}
}
