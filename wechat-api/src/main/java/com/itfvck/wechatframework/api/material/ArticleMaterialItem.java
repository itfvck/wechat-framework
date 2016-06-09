package com.itfvck.wechatframework.api.material;

import java.util.List;

public class ArticleMaterialItem {
	private String media_id;// 要修改的图文消息的id
	private List<ArticleMaterial> content;//
	private List<ArticleMaterial> news_item;//

	private String update_time;// 这篇图文消息素材的最后更新时间

	public String getMedia_id() {
		return media_id;
	}

	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}

	public List<ArticleMaterial> getContent() {
		return content;
	}

	public void setContent(List<ArticleMaterial> content) {
		this.content = content;
	}

	public List<ArticleMaterial> getNews_item() {
		return news_item;
	}

	public void setNews_item(List<ArticleMaterial> news_item) {
		this.news_item = news_item;
	}

	public String getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}

}
