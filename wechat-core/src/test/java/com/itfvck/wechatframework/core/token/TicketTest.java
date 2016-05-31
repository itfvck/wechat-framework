package com.itfvck.wechatframework.core.token;

import org.junit.Test;

public class TicketTest {
	
	@Test
	public void test(){
		String jsapiTicket = TokenProxy.jsApiTicket();
		String expi = "";
		System.out.println(jsapiTicket);
	}

}
