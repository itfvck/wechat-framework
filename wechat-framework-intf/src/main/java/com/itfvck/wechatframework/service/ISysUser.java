package com.itfvck.wechatframework.service;

import java.util.List;
import java.util.Map;

import com.itfvck.wechatframework.entity.sys.Sysuser;

public interface ISysUser {

	public Sysuser getUser(String userId) throws Exception;

	public List<Sysuser> getUserList(Map<String, Object> map) throws Exception;

	public int getTotal(Map<String, Object> map) throws Exception;

	public Sysuser insertUser(Sysuser sysuser) throws Exception;

	public int updateUser(Sysuser sysuser) throws Exception;

	public int deleteUser(String userId) throws Exception;

	public Sysuser ifExist(String name) throws Exception;

}
