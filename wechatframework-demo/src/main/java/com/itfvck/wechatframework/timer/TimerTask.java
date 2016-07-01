package com.itfvck.wechatframework.timer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itfvck.wechatframework.token.TokenProxy;

@Repository(value = "timertaskService")
public class TimerTask {
	static Logger logger = LoggerFactory.getLogger(TimerTask.class);
	// private long time = 0;

	@Autowired
	private TokenProxy tokenProxy;

	/**
	 * 定时更新access_token,jsapi_ticket
	 */
	public void run() {
		// logger.info("系统中access_token:" + tokenProxy.accessToken("wx44d483e10bee9fc1", "353df047c6100ad4922e08f150306bbe"));
		logger.info("系统中jsapi_ticket:" + tokenProxy.jsTiket("wx44d483e10bee9fc1", "353df047c6100ad4922e08f150306bbe"));
	}

}