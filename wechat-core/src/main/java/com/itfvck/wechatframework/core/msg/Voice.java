package com.itfvck.wechatframework.core.msg;

/**
 * 语音类
 */
public class Voice {
    private String MediaId;// 通过素材管理中的接口上传多媒体文件，得到的id

    public Voice(String mediaId) {
        this.MediaId = mediaId;
    }

    public String getMediaId() {
        return this.MediaId;
    }

    public void setMediaId(String mediaId) {
        this.MediaId = mediaId;
    }

}
