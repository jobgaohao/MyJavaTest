package com.zhaogang.com.Adapter.demo1;

/**
 * 用于将ps2接口格式转换成为USB接口格式
 * @author hao.gao
 *
 */
public class Adapter extends Usber implements Ps2 {
	
	@Override
	public void isPs2() {
        super.isUsb();		
	}

}
