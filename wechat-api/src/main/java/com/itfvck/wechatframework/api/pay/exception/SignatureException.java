package com.itfvck.wechatframework.api.pay.exception;

/**
 * 签名异常 Created by xuwen on 2015-12-12.
 */
public class SignatureException extends Exception {

    private static final long serialVersionUID = 100727283674031652L;

    public SignatureException() {
        super("返回结果的签名校验失败，数据可能已经被篡改");
    }

}
