package com.itfvck.wechatframework.core;

import org.junit.Test;

import com.itfvck.wechatframework.core.common.BaseParams;
import com.itfvck.wechatframework.core.common.WechatParam;
import com.itfvck.wechatframework.core.mp.AesException;
import com.itfvck.wechatframework.core.mp.WXBizMsgCrypt;

import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class Encrty extends TestCase {

	@Test
	public void testdec() {
		StringBuilder postData = new StringBuilder();
		postData.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		postData.append("<xml><ToUserName><![CDATA[gh_8efcc54b626f]]></ToUserName>");
		postData.append("<Encrypt><![CDATA[YejMqz83ESe7+yzL46TtLz6RS32GluI5GHZ5skF3RoLUd6H6NM6QYyH0JkvGtp/CVtYChAyAPNZarcac+Y8vnD6BEgEQeL6LIYvqRAI3HJmAdFhPqFqdt");
		postData.append("rJNHriEA2yXOllYirxkl4uUmaKpQE9nJnek8Dfg2ZpDY9oMAvqeAI9D52tswcp9iAB4T8oi+oC1rJ7ALrQhvUtOG688DTqym2yeTn1IiMUJPOyDSjQLTN9ePB49CghWbPzkuskOn");
		postData.append("S/1Wi3zEfX9iGxI4WFeyNH75iIbNUZDJFMHgxF/rqKl+ZUsemVjTTYH3E5XtDFnwldH5r5474P8ClHr8UDnisp5hZoFhPCchiBlFFY32FiLWI2xb5ItjoOvApCfmUGaPEdC0pOSKrh3");
		postData.append("wd2eyO9AnGJKmUlAg1gLYm1dzFnHUxkBOi4=]]></Encrypt></xml>");
		try {
			WXBizMsgCrypt wxBizMsgCrypt = new WXBizMsgCrypt("123456", "jKNpnswdPlP7FlQbRqTjoJadIpptYhz46wZpVHF5Rjy", "wx4012ae791c4fda09");

			String decryptMsg = wxBizMsgCrypt.decryptMsg("e8d6e7770352400c7a8de449b4833cb8eab1b77c", "1467273748", "1423357748", postData.toString());

			System.out.println(decryptMsg);
		} catch (AesException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testencry() {
		StringBuilder postData = new StringBuilder();
		postData.append("<xml><ToUserName><![CDATA[gh_8efcc54b626f]]></ToUserName>");
		postData.append("<FromUserName><![CDATA[oJx8suPXmg2ljQilG3HXQ40iS6CA]]></FromUserName>");
		postData.append("<CreateTime>1467273748</CreateTime>");
		postData.append("<MsgType><![CDATA[text]]></MsgType>");
		postData.append("<Content><![CDATA[加密的东西啊。。。哈哈哈哈哈苏德]]></Content>");
		postData.append("<MsgId>6301892762365600423</MsgId></xml>");
		try {
			WXBizMsgCrypt wxBizMsgCrypt = new WXBizMsgCrypt("123456", "jKNpnswdPlP7FlQbRqTjoJadIpptYhz46wZpVHF5Rjy", "wx4012ae791c4fda09");
			String encryptMsg = wxBizMsgCrypt.encryptMsg(postData.toString(), "1467273748", "1423357748");
			System.out.println(encryptMsg);
		} catch (AesException e) {
			e.printStackTrace();
		}
	}
}
