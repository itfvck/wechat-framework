package com.itfvck.wechatframework.api.pay.protocol.report;

/**
 * 测速上报请求对象
 * <p>参考<a href="https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=9_8">开发文档</p>
 * <p/>
 * Created by xuwen on 2015-12-13.
 */
public class ReportResponse {

    private String result_code;

    public String getResult_code() {
        return result_code;
    }

    public void setResult_code(String result_code) {
        this.result_code = result_code;
    }

    @Override
    public String toString() {
        return "ReportResponse{" +
                "result_code='" + result_code + '\'' +
                '}';
    }
}
