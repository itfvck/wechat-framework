package com.itfvck.wechatframework.api.report.datacube.model;

import java.util.List;

/**
 * 结果类--获取消息发送分布周数据
 * 
 * @author luweichao
 *
 *         2015年1月27日
 */
public class DataCubeStreamMsgDistWeekInfo extends DataCubeBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7850225449160661028L;
	private String count_interval;
	private List<DataCubeStreamMsgDistWeekInfo> list;

	public List<DataCubeStreamMsgDistWeekInfo> getList() {
		return list;
	}

	public void setList(List<DataCubeStreamMsgDistWeekInfo> list) {
		this.list = list;
	}

	public String getCount_interval() {
		return count_interval;
	}

	public void setCount_interval(String count_interval) {
		this.count_interval = count_interval;
	}

}
