package com.itfvck.wechatframework.api.coupon.manage.model;

import com.itfvck.wechatframework.core.common.BaseData;

public class GetCardDetailRtnInfo extends BaseData {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7596839244321993780L;
	// 卡券详细信息
	private Card card;

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

}
