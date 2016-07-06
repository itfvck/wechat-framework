package com.itfvck.wechatframework.api.user.model;

import java.util.List;

/**
 * 关注者列表
 * 
 * @author Zhangxs
 * @version 2015-7-5
 */
public class Data {
	/**
	 * 用户列表
	 */
	private List<String> openid;
	private int errcode;// 错误码
	private String errmsg;// 错误信息

	public int getErrcode() {
		return errcode;
	}

	public void setErrcode(int errcode) {
		this.errcode = errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public List<String> getOpenid() {
		return openid;
	}

	public void setOpenid(List<String> openid) {
		this.openid = openid;
	}
}