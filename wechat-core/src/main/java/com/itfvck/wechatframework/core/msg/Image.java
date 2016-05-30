package com.itfvck.wechatframework.core.msg;

public class Image {
    private String MediaId;// 通过素材管理中的接口上传多媒体文件，得到的id。

    public Image(String mediaId) {
        this.MediaId = mediaId;
    }

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }
}
