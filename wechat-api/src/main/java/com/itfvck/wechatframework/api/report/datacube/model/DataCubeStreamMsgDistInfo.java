package com.itfvck.wechatframework.api.report.datacube.model;

import java.util.List;

/**
 * 结果类--获取消息发送分布数据
 * 
 * @author luweichao
 *
 *         2015年1月27日
 */
public class DataCubeStreamMsgDistInfo extends DataCubeBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5377449616553229564L;

	private String count_interval;

	private List<DataCubeStreamMsgDistInfo> list;

	public List<DataCubeStreamMsgDistInfo> getList() {
		return list;
	}

	public void setList(List<DataCubeStreamMsgDistInfo> list) {
		this.list = list;
	}

	public String getCount_interval() {
		return count_interval;
	}

	public void setCount_interval(String count_interval) {
		this.count_interval = count_interval;
	}

}
