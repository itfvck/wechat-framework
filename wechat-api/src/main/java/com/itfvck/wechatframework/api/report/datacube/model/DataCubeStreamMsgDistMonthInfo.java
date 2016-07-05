package com.itfvck.wechatframework.api.report.datacube.model;

import java.util.List;

/**
 * 结果类--获取消息发送分布月数据
 * 
 * @author luweichao
 *
 *         2015年1月27日
 */
public class DataCubeStreamMsgDistMonthInfo extends DataCubeBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8039446536588019441L;

	private String count_interval;

	private List<DataCubeStreamMsgDistMonthInfo> list;

	public List<DataCubeStreamMsgDistMonthInfo> getList() {
		return list;
	}

	public void setList(List<DataCubeStreamMsgDistMonthInfo> list) {
		this.list = list;
	}

	public String getCount_interval() {
		return count_interval;
	}

	public void setCount_interval(String count_interval) {
		this.count_interval = count_interval;
	}

}
