package com.itfvck.wechatframework.api;

import org.junit.Test;

import com.itfvck.wechatframework.api.token.AccessTokenAPI;

import junit.framework.TestCase;

public class AccessTokenTest extends TestCase {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	@Test
	public void test() {
		String access_token = AccessTokenAPI.getAccess_token(BaseTestConf.appId, BaseTestConf.appSecret);
		System.out.println("access_token=" + access_token);
	}

}
