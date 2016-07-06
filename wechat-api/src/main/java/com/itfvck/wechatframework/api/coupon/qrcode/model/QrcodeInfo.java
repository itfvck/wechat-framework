package com.itfvck.wechatframework.api.coupon.qrcode.model;

import com.itfvck.wechatframework.core.common.BaseData;

public class QrcodeInfo extends BaseData {

	private static final long serialVersionUID = 6392584179305332803L;
	// 名称
	private String action_name;
	// 卡卷对象
	private ActionInfo action_info;

	public String getAction_name() {
		return action_name;
	}

	public void setAction_name(String action_name) {
		this.action_name = action_name;
	}

	public ActionInfo getAction_info() {
		return action_info;
	}

	public void setAction_info(ActionInfo action_info) {
		this.action_info = action_info;
	}

}
