package com.itfvck.wechatframework.api.coupon.location.model;

import com.itfvck.wechatframework.core.common.BaseData;

public class LocationInfo extends BaseData {
	private static final long serialVersionUID = -8121179304482906888L;
	// 图片地址
	private String filePathName;

	public String getFilePathName() {
		return filePathName;
	}

	public void setFilePathName(String filePathName) {
		this.filePathName = filePathName;
	}

}
