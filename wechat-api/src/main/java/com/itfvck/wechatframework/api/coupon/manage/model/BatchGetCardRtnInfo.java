package com.itfvck.wechatframework.api.coupon.manage.model;

import java.util.List;

import com.itfvck.wechatframework.core.common.BaseData;

public class BatchGetCardRtnInfo extends BaseData {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8079315619825923659L;
	// 卡id 列表
	private List<String> card_id_list;
	// 该商户名下card_id 总数
	private Integer total_num;

	public List<String> getCard_id_list() {
		return card_id_list;
	}

	public void setCard_id_list(List<String> card_id_list) {
		this.card_id_list = card_id_list;
	}

	public Integer getTotal_num() {
		return total_num;
	}

	public void setTotal_num(Integer total_num) {
		this.total_num = total_num;
	}

}
