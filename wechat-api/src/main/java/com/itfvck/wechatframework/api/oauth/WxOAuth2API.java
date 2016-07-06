package com.itfvck.wechatframework.api.oauth;

import java.util.Random;

import com.alibaba.fastjson.JSON;
import com.itfvck.wechatframework.api.user.model.UserInfo;
import com.itfvck.wechatframework.core.util.http.HttpUtils;

/**
 * @Description 微信公众号网页授权接口
 * @Author vcdemon
 * @CreationDate 2016年5月12日 上午9:21:53
 */
public class WxOAuth2API {

	/* 生成OAuth重定向URI（用户同意授权，获取code） */
	private static final String HTTPS_OPEN_WEIXIN_QQ_COM_CONNECT_OAUTH2_AUTHORIZE = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=%s&redirect_uri=%s&response_type=code&scope=%s&state=%s#wechat_redirect";
	/* 通过code换取网页授权access_token */
	private static final String HTTPS_API_WEIXIN_QQ_COM_SNS_OAUTH2_ACCESS_TOKEN = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code";
	/* 刷新access_token（如果需要） */
	private static final String HTTPS_API_WEIXIN_QQ_COM_SNS_OAUTH2_REFRESH_TOKEN = "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=%s&grant_type=refresh_token&refresh_token=%s";
	/* 拉取用户信息(需scope为 snsapi_userinfo) */
	private static final String HTTPS_API_WEIXIN_QQ_COM_SNS_USERINFO = "https://api.weixin.qq.com/sns/userinfo?access_token=%s&openid=%s&lang=%s";
	/* 检验授权凭证（access_token）是否有效 */
	private static final String HTTPS_API_WEIXIN_QQ_COM_SNS_AUTH = "https://api.weixin.qq.com/sns/auth?access_token=%s&openid=%s";

	/**
	 * @Description 生成OAuth重定向URI（用户同意授权，获取code）,默认snsapi_userinfo
	 *              <p>
	 *              第一步：用户同意授权，获取code ( 必须在微信客户端发起请求,如：微信公众号菜单链接，消息链接等) 传入appid、redirect_uri
	 * @param redirectURI
	 * @param appid
	 * @return
	 * @CreationDate 2016年5月9日 上午9:58:27
	 * @Author vcdemon
	 */
	public static String generateRedirectURI(String redirectURI, String appid) {
		return generateRedirectURI(redirectURI, "snsapi_userinfo", String.valueOf(new Random().nextInt(1000)), appid);
	}

	/**
	 * @Description 生成OAuth重定向URI（用户同意授权，获取code）,
	 *              <p>
	 *              第一步：用户同意授权，获取code ( 必须在微信客户端发起请求,如：微信公众号菜单链接，消息链接等) 传入appid、redirect_uri、scope、state
	 * @param redirectURI
	 * @param scope
	 * @param state
	 * @param appid
	 * @return
	 * @CreationDate 2016年5月9日 上午9:58:27
	 * @Author vcdemon
	 */
	public static String generateRedirectURI(String redirectURI, String scope, String state, String appid) {
		return String.format(HTTPS_OPEN_WEIXIN_QQ_COM_CONNECT_OAUTH2_AUTHORIZE, appid, redirectURI, scope, state);
	}

	/**
	 * @Description 第二步：通过code换取网页授权access_token,refresh_token,expires_in,openid ,unionid
	 * @param grant
	 *            传入appid、secret、code
	 * @return
	 * @CreationDate 2016年5月9日 下午12:17:37
	 * @Author vcdemon
	 */
	public static OAuthData getAccess_token(String appid, String secret, String code) {
		try {
			String responseBody = HttpUtils.get(String.format(HTTPS_API_WEIXIN_QQ_COM_SNS_OAUTH2_ACCESS_TOKEN, appid, secret, code));
			OAuthData grant = JSON.parseObject(responseBody, OAuthData.class);
			return grant;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @Description 第三步：刷新access_token（如果需要）
	 * @param grant
	 *            传入appid、refresh_token
	 * @return
	 * @CreationDate 2016年5月9日 下午12:16:24
	 * @Author vcdemon
	 */
	public static OAuthData getRefresh_token(String appid, String refresh_token) {
		try {
			String responseBody = HttpUtils.get(String.format(HTTPS_API_WEIXIN_QQ_COM_SNS_OAUTH2_REFRESH_TOKEN, appid, refresh_token));
			OAuthData grant = JSON.parseObject(responseBody, OAuthData.class);
			return grant;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @Description 第四步：拉取用户信息(需scope为 snsapi_userinfo)
	 * @param 传入access_token、openid
	 * @return
	 * @CreationDate 2016年5月9日 下午12:15:40
	 * @Author vcdemon
	 */
	public static UserInfo getUserInfo(String access_token, String openid) {
		return getUserInfo(access_token, openid, "zh_CN");
	}

	/**
	 * @Description 第四步：拉取用户信息(需scope为 snsapi_userinfo)
	 * @param 传入access_token、openid,language="zh_CN"
	 * @return
	 * @CreationDate 2016年5月9日 下午12:15:40
	 * @Author vcdemon
	 */
	public static UserInfo getUserInfo(String access_token, String openid, String language) {
		try {
			String responseBody = HttpUtils.get(String.format(HTTPS_API_WEIXIN_QQ_COM_SNS_USERINFO, access_token, openid, "zh_CN"));
			UserInfo user = JSON.parseObject(responseBody, UserInfo.class);
			return user;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @Description 检验授权凭证（access_token）是否有效
	 * @param grant
	 *            传入access_token、openid
	 * @return true有效
	 * @CreationDate 2016年5月9日 上午10:06:03
	 * @Author vcdemon
	 */
	public static boolean checkAccess_token(String access_token, String openid) {
		try {
			String responseBody = HttpUtils.get(String.format(HTTPS_API_WEIXIN_QQ_COM_SNS_AUTH, access_token, openid));
			OAuthData grant = JSON.parseObject(responseBody, OAuthData.class);
			long errcode = grant.getErrcode();
			if (errcode == 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
