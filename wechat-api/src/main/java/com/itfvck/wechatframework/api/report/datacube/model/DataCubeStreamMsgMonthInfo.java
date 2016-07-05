package com.itfvck.wechatframework.api.report.datacube.model;

import java.util.List;

/**
 * 结果类--获取消息发送月数据
 * 
 * @author luweichao
 *
 *         2015年1月27日
 */
public class DataCubeStreamMsgMonthInfo extends DataCubeBase {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8992185298887037663L;
	private List<DataCubeStreamMsgMonthInfo> list;

	public List<DataCubeStreamMsgMonthInfo> getList() {
		return list;
	}

	public void setList(List<DataCubeStreamMsgMonthInfo> list) {
		this.list = list;
	}

}
