package com.itfvck.wechatframework.api;

import org.junit.Test;

import com.itfvck.wechatframework.api.jsapi.WxJsSDKAPI;
import com.itfvck.wechatframework.api.jsapi.JSSDKParams;
import com.itfvck.wechatframework.api.token.WxAccessTokenAPI;

import junit.framework.TestCase;

public class JsSDKTest extends TestCase {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	@Test
	public void test() {
		String access_token = WxAccessTokenAPI.getAccess_token(BaseTestConf.appId, BaseTestConf.appSecret);
		System.out.println("access_token=" + access_token);
		String js_tiket = WxJsSDKAPI.getJs_tiket(access_token);
		System.out.println(js_tiket);
		JSSDKParams signatureJS_SDK = WxJsSDKAPI.signatureJS_SDK(js_tiket, "http://www.baidu.com", BaseTestConf.appId);
		System.out.println(signatureJS_SDK);
	}

}
