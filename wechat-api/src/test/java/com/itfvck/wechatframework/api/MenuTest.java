package com.itfvck.wechatframework.api;

import org.junit.Test;

import com.itfvck.wechatframework.api.menu.Menu;
import com.itfvck.wechatframework.api.menu.WxMenuAPI;
import com.itfvck.wechatframework.api.token.WxAccessTokenAPI;

import junit.framework.TestCase;

public class MenuTest extends TestCase {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	@Test
	public void test() {
		String access_token = WxAccessTokenAPI.getAccess_token(BaseTestConf.appId, BaseTestConf.appSecret);
		System.out.println("access_token=" + access_token);
	}

	@Test
	public void testgetMenu() {
		String access_token = WxAccessTokenAPI.getAccess_token(BaseTestConf.appId, BaseTestConf.appSecret);
		System.out.println("access_token=" + access_token);
		Menu menu = WxMenuAPI.getMenu(access_token);
		System.out.println(menu);
	}

}
