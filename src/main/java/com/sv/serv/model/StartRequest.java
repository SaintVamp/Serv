package com.sv.serv.model;


import com.alibaba.fastjson.annotation.JSONField;

public class StartRequest {
	private int AppId;
	private int IsRedFinger;
	private int TemplateFileId;
	private long AppVersion;
	private long ClientTimestamp;
	private String RegCode;
	private String AppInfo;
	private String DeviceCode;
	private String DeviceId;
	private String TemplateVersion;

	@JSONField(name = "ClientTimestamp")
	public long getClientTimestamp ( ) {
		return ClientTimestamp;
	}

	public void setClientTimestamp ( long clientTimestamp ) {
		ClientTimestamp = clientTimestamp;
	}

	@JSONField(name = "AppVersion")
	public long getAppVersion ( ) {
		return AppVersion;
	}

	public void setAppVersion ( long appVersion ) {
		AppVersion = appVersion;
	}

	@JSONField(name = "AppId")
	public int getAppId ( ) {
		return AppId;
	}

	public void setAppId ( int appId ) {
		AppId = appId;
	}

	@JSONField(name = "IsRedFinger")
	public int getIsRedFinger ( ) {
		return IsRedFinger;
	}

	public void setIsRedFinger ( int isRedFinger ) {
		IsRedFinger = isRedFinger;
	}

	@JSONField(name = "TemplateFileId")
	public int getTemplateFileId ( ) {
		return TemplateFileId;
	}

	public void setTemplateFileId ( int templateFileId ) {
		TemplateFileId = templateFileId;
	}

	@JSONField(name = "AppInfo")
	public String getAppInfo ( ) {
		return AppInfo;
	}

	public void setAppInfo ( String appInfo ) {
		AppInfo = appInfo;
	}

	@JSONField(name = "DeviceCode")
	public String getDeviceCode ( ) {
		return DeviceCode;
	}

	public void setDeviceCode ( String deviceCode ) {
		DeviceCode = deviceCode;
	}

	@JSONField(name = "DeviceId")
	public String getDeviceId ( ) {
		return DeviceId;
	}

	public void setDeviceId ( String deviceId ) {
		DeviceId = deviceId;
	}

	@JSONField(name = "RegCode")
	public String getRegCode ( ) {
		return RegCode;
	}

	public void setRegCode ( String regCode ) {
		RegCode = regCode;
	}

	@JSONField(name = "TemplateVersion")
	public String getTemplateVersion ( ) {
		return TemplateVersion;
	}

	public void setTemplateVersion ( String templateVersion ) {
		TemplateVersion = templateVersion;
	}
}
