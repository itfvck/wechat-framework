/**
 * 
 */
package com.itfvck.wechatframework.core.token.server;

import com.itfvck.wechatframework.core.common.WechatConfig;

/**
 * Ticket server适配器
 * @author ChengNing
 * @date   2015年1月29日
 */
public class JsApiTicketServer extends AbsServer implements TicketServer  {


	/**
	 * 
	 */
	public String ticket() {
		return super.token();
	}

	/**
	 * 
	 */
	@Override
	protected String getCustomerServerClass() {
		return WechatConfig.instance().getJsApiTicketServer();
	}

	/**
	 * 
	 */
	@Override
	public IServer defaultServer() {
		return JsApiTicketMemServer.instance();
	}

}
