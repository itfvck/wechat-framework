package com.itfvck.wechatframework.api.report.datacube.model;

import java.util.List;

/**
 * 结果类--获取消息发送概况数据
 * 
 * @author luweichao
 *
 *         2015年1月27日
 */
public class DataCubeStreamMsgInfo extends DataCubeBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2698997871740985514L;
	private List<DataCubeStreamMsgInfo> list;

	public List<DataCubeStreamMsgInfo> getList() {
		return list;
	}

	public void setList(List<DataCubeStreamMsgInfo> list) {
		this.list = list;
	}
}
