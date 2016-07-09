package com.itfvck.wechatframework.web.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itfvck.wechatframework.core.common.BaseParams;
import com.itfvck.wechatframework.core.common.WechatParam;
import com.itfvck.wechatframework.core.support.WechatSupport;

public abstract class AbstractWechatService implements WechatWebService {

	/**
	 * 微信消息处理器,用户可以自己实现WechatSupport，并在实现类加上注解@Service("wechatService")即可自定义消息处理
	 */
	protected WechatSupport wechatService;

	public WechatSupport getWechatService() {
		return wechatService;
	}

	public void setWechatService(WechatSupport wechatService) {
		this.wechatService = wechatService;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.itfvck.wechatframework.web.service.WechatWebService#check(com.itfvck.
	 * wechatframework.core.common.WechatParam, java.util.List)
	 */
	@Override
	public abstract boolean check(WechatParam params, List<BaseParams> baseParamList);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.itfvck.wechatframework.web.service.WechatWebService#getResponse(javax
	 * .servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse,
	 * com.itfvck.wechatframework.core.common.WechatParam, java.util.List)
	 */
	@Override
	public abstract String getResponse(HttpServletRequest request, HttpServletResponse response, WechatParam params, List<BaseParams> baseParamList);

}
