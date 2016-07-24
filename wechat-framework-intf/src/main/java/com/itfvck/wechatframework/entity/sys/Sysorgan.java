package com.itfvck.wechatframework.entity.sys;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Sysorgan entity. @author MyEclipse Persistence Tools
 */
@Table(name = "sysorgan", catalog = "itfvck_weixin")
public class Sysorgan implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -511889577420790413L;
	// Fields

	private Integer id;
	private String orgname;
	private String orgcode;
	private Integer principal;
	private String telephone;
	private String fox;
	private String address;
	private Integer state;
	private String note;
	private Integer orderno;
	private Integer createUserId;
	private Date createTime;
	private Integer updateUserId;
	private Date updateTime;

	// Constructors

	/** default constructor */
	public Sysorgan() {
	}

	/** full constructor */
	public Sysorgan(String orgname, String orgcode, Integer principal, String telephone, String fox, String address, Integer state, String note, Integer orderno,
	        Integer createUserId, Date createTime, Integer updateUserId, Date updateTime) {
		this.orgname = orgname;
		this.orgcode = orgcode;
		this.principal = principal;
		this.telephone = telephone;
		this.fox = fox;
		this.address = address;
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

	@Column(name = "orgname", length = 32)
	public String getOrgname() {
		return this.orgname;
	}

	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	@Column(name = "orgcode", length = 16)
	public String getOrgcode() {
		return this.orgcode;
	}

	public void setOrgcode(String orgcode) {
		this.orgcode = orgcode;
	}

	@Column(name = "principal")
	public Integer getPrincipal() {
		return this.principal;
	}

	public void setPrincipal(Integer principal) {
		this.principal = principal;
	}

	@Column(name = "telephone", length = 16)
	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Column(name = "fox", length = 16)
	public String getFox() {
		return this.fox;
	}

	public void setFox(String fox) {
		this.fox = fox;
	}

	@Column(name = "address", length = 64)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
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