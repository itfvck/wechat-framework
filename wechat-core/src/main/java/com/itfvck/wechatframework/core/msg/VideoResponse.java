package com.itfvck.wechatframework.core.msg;

/**
 * 视频
 */
public class VideoResponse {
    /**
     * 媒体文件ID
     */
    private String MediaId;
    private String Title;// 视频消息的标题
    private String Description;// 视频消息的描述

    public VideoResponse() {
    }

    public VideoResponse(String mediaId, String title, String description, String thumbMediaId) {
        this.MediaId = mediaId;
        this.Title = title;
        this.Description = description;
        this.ThumbMediaId = thumbMediaId;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    /**
     * 缩略图的媒体Id
     */
    private String ThumbMediaId;

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getThumbMediaId() {
        return ThumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        ThumbMediaId = thumbMediaId;
    }

}
