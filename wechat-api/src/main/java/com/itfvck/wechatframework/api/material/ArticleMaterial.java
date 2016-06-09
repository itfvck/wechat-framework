package com.itfvck.wechatframework.api.material;

import java.util.List;

public class ArticleMaterial {
	private String media_id;// 要修改的图文消息的id
	private String index;// 要更新的文章在图文消息中的位置（多图文消息时，此字段才有意义），第一篇为0

	private String title;// 标题
	private String thumb_media_id;// 是 图文消息的封面图片素材id（必须是永久mediaID）
	private String author;// 是作者
	private String digest;// 图文消息的摘要，仅有单图文消息才有摘要，多图文此处为空
	private String show_cover_pic;// 是否显示封面，0为false，即不显示，1为true，即显示
	private String content;// 图文消息的具体内容，支持HTML标签，必须少于2万字符，小于1M，且此处会去除JS
	private String content_source_url;// 图文消息的原文地址，即点击“阅读原文”后的URL
	private String url;// 图文页的URL
	private List<ArticleMaterial> articles;// 新增图文素材

	private Integer total_count;// 该类型的素材的总数
	private Integer item_count;// 本次调用获取的素材的数量

	private List<ArticleMaterialItem> item;//

	public Integer getTotal_count() {
		return total_count;
	}

	public void setTotal_count(Integer total_count) {
		this.total_count = total_count;
	}

	public int getItem_count() {
		return item_count;
	}

	public void setItem_count(int item_count) {
		this.item_count = item_count;
	}

	public List<ArticleMaterialItem> getItem() {
		return item;
	}

	public void setItem(List<ArticleMaterialItem> item) {
		this.item = item;
	}

	private String errcode;
	private String errmsg;

	public String getMedia_id() {
		return media_id;
	}

	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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

	public List<ArticleMaterial> getNews_item() {
		return news_item;
	}

	public void setNews_item(List<ArticleMaterial> news_item) {
		this.news_item = news_item;
	}

	private List<ArticleMaterial> news_item;// 获取图文素材的

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getThumb_media_id() {
		return thumb_media_id;
	}

	public void setThumb_media_id(String thumb_media_id) {
		this.thumb_media_id = thumb_media_id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDigest() {
		return digest;
	}

	public void setDigest(String digest) {
		this.digest = digest;
	}

	public String getShow_cover_pic() {
		return show_cover_pic;
	}

	public void setShow_cover_pic(String show_cover_pic) {
		this.show_cover_pic = show_cover_pic;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContent_source_url() {
		return content_source_url;
	}

	public void setContent_source_url(String content_source_url) {
		this.content_source_url = content_source_url;
	}

	public List<ArticleMaterial> getArticles() {
		return articles;
	}

	public void setArticles(List<ArticleMaterial> articles) {
		this.articles = articles;
	}

}
