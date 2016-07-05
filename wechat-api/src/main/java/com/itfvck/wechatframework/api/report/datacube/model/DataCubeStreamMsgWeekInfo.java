package com.itfvck.wechatframework.api.report.datacube.model;

import java.util.List;

/**
 * 结果类--获取消息发送周数据
 * 
 * @author luweichao
 *
 *         2015年1月27日
 */
public class DataCubeStreamMsgWeekInfo extends DataCubeBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5224886136169067196L;
	private List<DataCubeStreamMsgWeekInfo> list;

	public List<DataCubeStreamMsgWeekInfo> getList() {
		return list;
	}

	public void setList(List<DataCubeStreamMsgWeekInfo> list) {
		this.list = list;
	}

}
