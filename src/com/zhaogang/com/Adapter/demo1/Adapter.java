package com.zhaogang.com.Adapter.demo1;

/**
 * ���ڽ�ps2�ӿڸ�ʽת����USB�ӿڸ�ʽ
 * @author hao.gao
 *
 */
public class Adapter extends Usber implements Ps2 {
	
	@Override
	public void isPs2() {
        super.isUsb();		
	}

}
