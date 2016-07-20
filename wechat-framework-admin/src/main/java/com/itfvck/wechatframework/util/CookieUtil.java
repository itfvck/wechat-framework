package com.itfvck.wechatframework.util;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class CookieUtil {

	/**
	 * 
	 * 设置cookie
	 * 
	 * @param response
	 * 
	 * @param name
	 *            cookie名字
	 * 
	 * @param value
	 *            cookie值
	 * 
	 * @param maxAge
	 *            cookie生命周期 以秒为单位
	 * 
	 */

	public static void addCookie(HttpServletResponse response, String domain, String name, String value, Integer maxAge) {
		Cookie cookie = new Cookie(name, value);
		cookie.setPath("/");
		if (maxAge != null) {
			cookie.setMaxAge(maxAge);
		}
		if (domain != null) {
			cookie.setDomain(domain);
		}
		response.addCookie(cookie);

	}

	public static void deleteCookie(HttpServletResponse response, String name) {

		Cookie cookie = new Cookie(name, null);
		cookie.setPath("/");
		cookie.setMaxAge(0);
		response.addCookie(cookie);
	}

	/**
	 * 
	 * 根据名字获取cookie
	 * 
	 * @param request
	 * 
	 * @param key
	 *            cookie名字
	 * 
	 * @return
	 * 
	 */

	public static Cookie getCookieByName(HttpServletRequest request, String key) {
		Map<String, Cookie> cookieMap = ReadCookieMap(request);
		if (cookieMap.containsKey(key)) {
			Cookie cookie = (Cookie) cookieMap.get(key);
			return cookie;
		} else {
			return null;
		}
	}

	/**
	 * 
	 * 将cookie封装到Map里面
	 * 
	 * @param request
	 * 
	 * @return
	 * 
	 */
	private static Map<String, Cookie> ReadCookieMap(HttpServletRequest request) {
		Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
		Cookie[] cookies = request.getCookies();
		if (null != cookies) {
			for (Cookie cookie : cookies) {
				cookieMap.put(cookie.getName(), cookie);
			}
		}
		return cookieMap;
	}

	public static String getCookie(HttpServletRequest request, String key) throws UnsupportedEncodingException {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			if (cookies.length != 0) {
				for (int i = 0; i < cookies.length; i++) {
					if (cookies[i].getName().equalsIgnoreCase(key)) {
						return java.net.URLDecoder.decode(cookies[i].getValue().toString(), "utf-8");
					}
				}
			}
		}

		return null;
	}

	/**
	 * 根据key从cookie中获取对应的value
	 * 
	 * @param key
	 * @return
	 */
	public static String getValue(String key) {

		String value = "";

		// 从上下文获取request
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		// 获取当前域名的cookie
		if (request != null) {
			Cookie[] cookArray = request.getCookies();
			if (cookArray != null && cookArray.length > 0) {
				for (Cookie c : cookArray) {
					if (c.getName().equalsIgnoreCase(key)) {
						value = c.getValue().toString();
					}
				}
			}
		}
		return value;
	}

}
