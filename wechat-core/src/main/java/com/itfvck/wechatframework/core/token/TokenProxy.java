package com.itfvck.wechatframework.core.token;

import com.itfvck.wechatframework.core.token.server.AccessTokenServer;
import com.itfvck.wechatframework.core.token.server.JsApiTicketServer;
import com.itfvck.wechatframework.core.token.server.TicketServer;
import com.itfvck.wechatframework.core.token.server.TokenServer;


/**
 * AccessToken代理
 * 所有获取accessToken的地方都通过此代理获得
 * 获得方法String token = AccessTokenProxy.token()
 * @author ChengNing
 * @date   2015年1月9日
 */
public class TokenProxy {
	
	/**
	 * 通过代理得到accessToken的串
	 */
	public static String accessToken(){
		TokenServer accessTokenServer = new AccessTokenServer();
		return accessTokenServer.token();
	}
	
	/**
	 * 通过代理得到jsapi_ticket
	 */
	public static String jsApiTicket(){
		TicketServer ticketServer = new JsApiTicketServer();
		return ticketServer.ticket();
	}
	

	
	
}
