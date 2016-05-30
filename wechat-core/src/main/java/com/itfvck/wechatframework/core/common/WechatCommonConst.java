package com.itfvck.wechatframework.core.common;

public enum WechatCommonConst {
    AES("aes");

    private final String value;

    private WechatCommonConst(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
