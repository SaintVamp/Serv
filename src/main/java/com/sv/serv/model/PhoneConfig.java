package com.sv.serv.model;

import com.alibaba.fastjson.annotation.JSONField;

public class PhoneConfig {
	private int Active;
	private int JudgeMode;
	private int CloudPhoneType;
	private String DisableMsg;
	private String Package;
	private String ImageUrl;
	private String LinkUrl;

	public PhoneConfig ( ) {
		super();
		this.Active = 0;
		this.CloudPhoneType = 6;
		this.JudgeMode = 1;
		this.Package = "a.a.a";
		this.DisableMsg = "";
		this.ImageUrl = "";
		this.LinkUrl = "";
	}

	@JSONField(name = "Active")
	public int getActive ( ) {
		return Active;
	}

	public void setActive ( int active ) {
		Active = active;
	}

	@JSONField(name = "CloudPhoneType")
	public int getCloudPhoneType ( ) {
		return CloudPhoneType;
	}

	public void setCloudPhoneType ( int cloudPhoneType ) {
		CloudPhoneType = cloudPhoneType;
	}

	@JSONField(name = "JudgeMode")
	public int getJudgeMode ( ) {
		return JudgeMode;
	}

	public void setJudgeMode ( int judgeMode ) {
		JudgeMode = judgeMode;
	}

	@JSONField(name = "DisableMsg")
	public String getDisableMsg ( ) {
		return DisableMsg;
	}

	public void setDisableMsg ( String disableMsg ) {
		DisableMsg = disableMsg;
	}

	@JSONField(name = "ImageUrl")
	public String getImageUrl ( ) {
		return ImageUrl;
	}

	public void setImageUrl ( String imageUrl ) {
		ImageUrl = imageUrl;
	}

	@JSONField(name = "LinkUrl")
	public String getLinkUrl ( ) {
		return LinkUrl;
	}

	public void setLinkUrl ( String linkUrl ) {
		LinkUrl = linkUrl;
	}

	@JSONField(name = "Package")
	public String getPackage ( ) {
		return Package;
	}

	public void setPackage ( String aPackage ) {
		Package = aPackage;
	}
}
