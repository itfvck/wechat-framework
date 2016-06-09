package com.itfvck.wechatframework.api.material;

import java.io.File;
import java.util.List;

public class MediaFile {
	private String type;// 素材的类型，图片（image）、视频（video）、语音 （voice）、图文（news）
	private File file;
	private String createdTimestamp;// 文件创建时间戳，上传之后返回
	private String url;// 新增的图片素材的图片URL
	private String title;// 视频素材的标题
	private String introduction;// 视频素材的描述
	private String down_url;// 获取视频消息素材下载地址
	private String errcode;
	private String errmsg;
	private String media_id;//
	private String created_at;//
	private String name;// 文件名称
	private String update_time;// 这篇图文消息素材的最后更新时间

	private Integer voice_count;// 语音总数量
	private Integer video_count;// 视频总数量
	private Integer image_count;// 图片总数量
	private Integer news_count;// 图文总数量

	private Integer total_count;// 该类型的素材的总数
	private Integer item_count;// 本次调用获取的素材的数量
	private List<MediaFile> item;//

	private Integer offset;// 从全部素材的该偏移位置开始返回，0表示从第一个素材 返回
	private Integer count;// 返回素材的数量，取值在1到20之间

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getOffset() {
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}

	public Integer getTotal_count() {
		return total_count;
	}

	public void setTotal_count(Integer total_count) {
		this.total_count = total_count;
	}

	public Integer getItem_count() {
		return item_count;
	}

	public void setItem_count(Integer item_count) {
		this.item_count = item_count;
	}

	public List<MediaFile> getItem() {
		return item;
	}

	public void setItem(List<MediaFile> item) {
		this.item = item;
	}

	public Integer getVoice_count() {
		return voice_count;
	}

	public void setVoice_count(Integer voice_count) {
		this.voice_count = voice_count;
	}

	public Integer getVideo_count() {
		return video_count;
	}

	public void setVideo_count(Integer video_count) {
		this.video_count = video_count;
	}

	public Integer getImage_count() {
		return image_count;
	}

	public void setImage_count(Integer image_count) {
		this.image_count = image_count;
	}

	public Integer getNews_count() {
		return news_count;
	}

	public void setNews_count(Integer news_count) {
		this.news_count = news_count;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getMedia_id() {
		return media_id;
	}

	public MediaFile setMedia_id(String media_id) {
		this.media_id = media_id;
		return this;
	}

	public MediaFile() {
	}

	public File getFile() {
		return file;
	}

	public MediaFile setFile(File file) {
		this.file = file;
		return this;
	}

	public String getCreatedTimestamp() {
		return createdTimestamp;
	}

	public void setCreatedTimestamp(String createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getDown_url() {
		return down_url;
	}

	public void setDown_url(String down_url) {
		this.down_url = down_url;
	}

	public String getErrcode() {
		return errcode;
	}

	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
}
