package com.itfvck.wechatframework.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itfvck.wechatframework.api.user.model.UserInfo;
import com.itfvck.wechatframework.common.Constant;

@Service(value = "loginUserUtil")
public class LoginUserUtil {
	@Autowired
	private RedisSessionUtil redisSessionUtil;

	public UserInfo getUser() {
		return redisSessionUtil.getObject(Constant.SYS_LOGINUSER, UserInfo.class);
	}

	public String getOpenid() {
		UserInfo user = getUser();
		if (user != null) {
			return user.getOpenid();
		} else {
			return null;
		}
	}

	public String getNickname() {
		UserInfo user = getUser();
		if (user != null) {
			return user.getNickname();
		} else {
			return null;
		}
	}

	public String getUnionid() {
		UserInfo user = getUser();
		if (user != null) {
			return user.getUnionid();
		} else {
			return null;
		}
	}
}
