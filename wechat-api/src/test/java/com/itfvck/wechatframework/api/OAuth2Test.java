package com.itfvck.wechatframework.api;

import org.junit.Test;

import com.itfvck.wechatframework.api.oauth.OAuth2API;
import com.itfvck.wechatframework.api.oauth.OAuthData;
import com.itfvck.wechatframework.api.token.AccessTokenAPI;

import junit.framework.TestCase;

public class OAuth2Test extends TestCase {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	@Test
	public void test() {
		String access_token = AccessTokenAPI.getAccess_token(BaseTestConf.appId, BaseTestConf.appSecret);
		System.out.println("access_token=" + access_token);
		String generateRedirectURI = OAuth2API.generateRedirectURI("http://itfvck.ittun.com/", BaseTestConf.appId);
		System.out.println(generateRedirectURI);
	}

	@Test
	public void test2() {
		OAuthData access_token2 = OAuth2API.getAccess_token(BaseTestConf.appId, BaseTestConf.appSecret, "011WUSDy0lwaXl1rPVFy04cPDy0WUSDD");
		System.out.println(access_token2.getAccess_token());
	}

	@Test
	public void test3() {
		OAuthData access_token2 = OAuth2API.getAccess_token(BaseTestConf.appId, BaseTestConf.appSecret, "011WUSDy0lwaXl1rPVFy04cPDy0WUSDD");
		OAuthData refresh_token = OAuth2API.getRefresh_token(BaseTestConf.appId, access_token2.getRefresh_token());
		System.out.println(refresh_token);
	}

	@Test
	public void test4() {
		OAuthData access_token2 = OAuth2API.getAccess_token(BaseTestConf.appId, BaseTestConf.appSecret, "001AnTG40D7rBw175oI40Q0RG40AnTGo");
	}

}
