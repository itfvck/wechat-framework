package com.itfvck.wechatframework.api.wxstore.product.model;

import com.itfvck.wechatframework.core.common.BaseData;

public class AttrExtLocation extends BaseData {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2103462050772051004L;
	// 国家
	private String country;
	// 省份
	private String province;
	// 城市
	private String city;
	// 地址
	private String address;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
