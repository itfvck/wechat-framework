package com.itfvck.wechatframework.core.common;

import javax.servlet.http.HttpServletRequest;

public class WechatParam {

	private String signature;
	private String timestamp;
	private String nonce;
	private String echostr;
	private String encrypt_type;
	private String msg_signature;
	private String openid;

	public WechatParam() {

	}

	public WechatParam(HttpServletRequest request) {
		this.signature = request.getParameter("signature");
		this.timestamp = request.getParameter("timestamp");
		this.nonce = request.getParameter("nonce");
		this.echostr = request.getParameter("echostr");
		this.encrypt_type = request.getParameter("encrypt_type");
		this.msg_signature = request.getParameter("msg_signature");
	}

	public WechatParam(String signature, String timestamp, String nonce, String echostr, String encrypt_type, String msg_signature) {
		this.signature = signature;
		this.timestamp = timestamp;
		this.nonce = nonce;
		this.echostr = echostr;
		this.encrypt_type = encrypt_type;
		this.msg_signature = msg_signature;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getNonce() {
		return nonce;
	}

	public void setNonce(String nonce) {
		this.nonce = nonce;
	}

	public String getEchostr() {
		return echostr;
	}

	public void setEchostr(String echostr) {
		this.echostr = echostr;
	}

	public String getEncrypt_type() {
		return encrypt_type;
	}

	public void setEncrypt_type(String encrypt_type) {
		this.encrypt_type = encrypt_type;
	}

	public String getMsg_signature() {
		return msg_signature;
	}

	public void setMsg_signature(String msg_signature) {
		this.msg_signature = msg_signature;
	}

	@Override
	public String toString() {
		return "WechatParam [signature=" + signature + ", timestamp=" + timestamp + ", nonce=" + nonce + ", echostr=" + echostr + ", encrypt_type=" + encrypt_type
				+ ", msg_signature=" + msg_signature + "]";
	}

}
