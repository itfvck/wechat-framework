package com.itfvck.wechatframework.api.coupon.qrcode.model;

import com.itfvck.wechatframework.core.common.BaseData;

public class QrcodeRtnInfo extends BaseData {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4194216513099124422L;
	// 获取的二维码ticket，凭借此ticket 可以在有效时间内换取二维码。
	private String ticket;

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

}
