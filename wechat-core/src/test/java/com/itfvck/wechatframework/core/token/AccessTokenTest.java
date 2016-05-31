package com.itfvck.wechatframework.core.token;


import org.junit.Test;

public class AccessTokenTest {

	@Test
	public void testRequest() {
		AccessToken accessToken = new AccessToken();
		accessToken.request();
		String result = accessToken.getToken();
	}

}
