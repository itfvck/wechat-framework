package com.itfvck.wechatframework.api.report.datacube.model;

import java.util.List;

/**
 * 结果类--获取消息分送分时数据
 * 
 * @author luweichao
 *
 *         2015年1月27日
 */
public class DataCubeStreamMsgHourInfo extends DataCubeBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6734186149819303006L;

	/** 时间 **/
	private String ref_hour;

	private List<DataCubeStreamMsgHourInfo> list;

	public List<DataCubeStreamMsgHourInfo> getList() {
		return list;
	}

	public void setList(List<DataCubeStreamMsgHourInfo> list) {
		this.list = list;
	}

	public String getRef_hour() {
		return ref_hour;
	}

	public void setRef_hour(String ref_hour) {
		this.ref_hour = ref_hour;
	}

}
