package com.sv.serv.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.ToString;

@ToString
public class SvAuth {
	private String adminName;
	private String passWord;

	@JSONField(name = "adminName")
	public String getAdminName ( ) {
		return adminName;
	}

	@JSONField(name = "passWord")
	public String getPassWord ( ) {
		return passWord;
	}

	public void setAdminName ( String adminName ) {
		this.adminName = adminName;
	}

	public void setPassWord ( String passWord ) {
		this.passWord = passWord;
	}
}

