package com.itfvck.wechatframework.api.coupon.consume.model;

import com.itfvck.wechatframework.core.common.BaseData;

public class EncryptRtnInfo extends BaseData {
	private static final long serialVersionUID = -3155142271141403548L;
	// 卡券真实序列号
	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
