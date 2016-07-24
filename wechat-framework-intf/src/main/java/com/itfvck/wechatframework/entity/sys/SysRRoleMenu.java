package com.itfvck.wechatframework.entity.sys;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * SysRRoleMenu entity. @author MyEclipse Persistence Tools
 */
@Table(name = "sys_r_role_menu", catalog = "itfvck_weixin")
public class SysRRoleMenu implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9005085085917680282L;
	private Integer id;
	private Integer roleid;
	private Integer menuid;
	private Integer createUserId;
	private Date createTime;
	private Integer updateUserId;
	private Date updateTime;

	// Constructors

	/** default constructor */
	public SysRRoleMenu() {
	}

	/** full constructor */
	public SysRRoleMenu(Integer roleid, Integer menuid, Integer createUserId, Date createTime, Integer updateUserId, Date updateTime) {
		this.roleid = roleid;
		this.menuid = menuid;
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

	@Column(name = "roleid")
	public Integer getRoleid() {
		return this.roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	@Column(name = "menuid")
	public Integer getMenuid() {
		return this.menuid;
	}

	public void setMenuid(Integer menuid) {
		this.menuid = menuid;
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