package com.itfvck.wechatframework.entity.sys;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Sysdictreedata entity. @author MyEclipse Persistence Tools
 */
@Table(name = "sysdictreedata", catalog = "itfvck_weixin")
public class Sysdictreedata implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5095080543911407823L;
	// Fields

	private Integer id;
	private Integer pid;
	private Integer treeid;
	private Integer state;
	private String note;
	private Integer orderno;
	private Integer createUserId;
	private Date createTime;
	private Integer updateUserId;
	private Date updateTime;

	// Constructors

	/** default constructor */
	public Sysdictreedata() {
	}

	/** full constructor */
	public Sysdictreedata(Integer pid, Integer treeid, Integer state, String note, Integer orderno, Integer createUserId, Date createTime, Integer updateUserId, Date updateTime) {
		this.pid = pid;
		this.treeid = treeid;
		this.state = state;
		this.note = note;
		this.orderno = orderno;
		this.createUserId = createUserId;
		this.createTime = createTime;
		this.updateUserId = updateUserId;
		this.updateTime = updateTime;
	}

	// Property accessors
	@Id
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "pid")
	public Integer getPid() {
		return this.pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	@Column(name = "treeid")
	public Integer getTreeid() {
		return this.treeid;
	}

	public void setTreeid(Integer treeid) {
		this.treeid = treeid;
	}

	@Column(name = "state")
	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@Column(name = "note", length = 128)
	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Column(name = "orderno")
	public Integer getOrderno() {
		return this.orderno;
	}

	public void setOrderno(Integer orderno) {
		this.orderno = orderno;
	}

	@Column(name = "createUserId")
	public Integer getCreateUserId() {
		return this.createUserId;
	}

	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}

	@Column(name = "createTime", length = 19)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "updateUserId")
	public Integer getUpdateUserId() {
		return this.updateUserId;
	}

	public void setUpdateUserId(Integer updateUserId) {
		this.updateUserId = updateUserId;
	}

	@Column(name = "updateTime", length = 19)
	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}