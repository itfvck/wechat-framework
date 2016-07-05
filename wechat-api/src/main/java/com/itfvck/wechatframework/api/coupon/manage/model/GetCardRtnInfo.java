package com.itfvck.wechatframework.api.coupon.manage.model;

import com.itfvck.wechatframework.core.common.BaseData;

public class GetCardRtnInfo extends BaseData {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1102093585220891282L;
	// 卡券相关信息
	private GetCardRtnInfoCard card;

	public GetCardRtnInfoCard getCard() {
		return card;
	}

	public void setCard(GetCardRtnInfoCard card) {
		this.card = card;
	}

}
