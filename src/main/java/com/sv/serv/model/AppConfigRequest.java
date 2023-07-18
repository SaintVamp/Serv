package com.sv.serv.model;

import com.alibaba.fastjson.annotation.JSONField;

public class AppConfigRequest {
	private int ANDROID_DEVICE;
	private int DeviceType;
	private int AppId;
	private int IsRedFinger;
	private int TemplateFileId;
	private long ClientTimestamp;
	private String AppInfo;
	private String AppVersion;
	private String DeviceCode;
	private String DeviceId;
	private String TemplateVersion;


	@JSONField(name = "TemplateVersion")
	public String getTemplateVersion ( ) {
		return TemplateVersion;
	}

	public void setTemplateVersion ( String templateVersion ) {
		TemplateVersion = templateVersion;
	}

	@JSONField(name = "DeviceId")
	public String getDeviceId ( ) {
		return DeviceId;
	}

	public void setDeviceId ( String deviceId ) {
		DeviceId = deviceId;
	}

	@JSONField(name = "DeviceCode")
	public String getDeviceCode ( ) {
		return DeviceCode;
	}

	public void setDeviceCode ( String deviceCode ) {
		DeviceCode = deviceCode;
	}

	@JSONField(name = "AppInfo")
	public String getAppInfo ( ) {
		return AppInfo;
	}

	public void setAppInfo ( String appInfo ) {
		AppInfo = appInfo;
	}

	@JSONField(name = "AppVersion")
	public String getAppVersion ( ) {
		return AppVersion;
	}

	public void setAppVersion ( String appVersion ) {
		AppVersion = appVersion;
	}

	@JSONField(name = "ClientTimestamp")
	public long getClientTimestamp ( ) {
		return ClientTimestamp;
	}

	public void setClientTimestamp ( long clientTimestamp ) {
		ClientTimestamp = clientTimestamp;
	}

	@JSONField(name = "TemplateFileId")
	public int getTemplateFileId ( ) {
		return TemplateFileId;
	}

	public void setTemplateFileId ( int templateFileId ) {
		TemplateFileId = templateFileId;
	}

	@JSONField(name = "IsRedFinger")
	public int getIsRedFinger ( ) {
		return IsRedFinger;
	}

	public void setIsRedFinger ( int isRedFinger ) {
		IsRedFinger = isRedFinger;
	}

	@JSONField(name = "AppId")
	public int getAppId ( ) {
		return AppId;
	}

	public void setAppId ( int appId ) {
		AppId = appId;
	}

	@JSONField(name = "ANDROID_DEVICE")
	public int getANDROID_DEVICE ( ) {
		return ANDROID_DEVICE;
	}

	public void setANDROID_DEVICE ( int ANDROID_DEVICE ) {
		this.ANDROID_DEVICE = ANDROID_DEVICE;
	}

	@JSONField(name = "DeviceType")
	public int getDeviceType ( ) {
		return DeviceType;
	}

	public void setDeviceType ( int deviceType ) {
		DeviceType = deviceType;
	}
}
