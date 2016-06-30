package com.itfvck.wechatframework.web.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itfvck.wechatframework.core.common.BaseParams;
import com.itfvck.wechatframework.core.common.WechatParam;
import com.itfvck.wechatframework.core.support.WechatSupport;

public abstract class AbstractWechatService implements WechatWebService {
	protected WechatSupport wechatService;

	public WechatSupport getWechatService() {
		return wechatService;
	}

	public void setWechatService(WechatSupport wechatService) {
		this.wechatService = wechatService;
	}

	@Override
	public abstract boolean check(WechatParam params, List<BaseParams> baseParamList);

	@Override
	public abstract String getResponse(HttpServletRequest request, HttpServletResponse response, WechatParam params, List<BaseParams> baseParamList);

}
