package com.sv.serv.model;

import com.alibaba.fastjson.annotation.JSONField;

public class VersionUpdateRequest {
	private int AppId;
	private int IsRedFinger;
	private int IsScriptHotUpgrade;
	private int TemplateFileId;
	private long ClientTimestamp;
	private long ScriptVersion;
	private String AppInfo;
	private String AppVersion;
	private String DeviceCode;
	private String DeviceId;
	private String DeviceName;
	private String ScriptId;
	private String TemplateVersion;

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

	@JSONField(name = "IsScriptHotUpgrade")
	public int getIsScriptHotUpgrade ( ) {
		return IsScriptHotUpgrade;
	}

	public void setIsScriptHotUpgrade ( int isScriptHotUpgrade ) {
		IsScriptHotUpgrade = isScriptHotUpgrade;
	}

	@JSONField(name = "TemplateFileId")
	public int getTemplateFileId ( ) {
		return TemplateFileId;
	}

	public void setTemplateFileId ( int templateFileId ) {
		TemplateFileId = templateFileId;
	}

	@JSONField(name = "ClientTimestamp")
	public long getClientTimestamp ( ) {
		return ClientTimestamp;
	}

	public void setClientTimestamp ( long clientTimestamp ) {
		ClientTimestamp = clientTimestamp;
	}

	@JSONField(name = "ScriptVersion")
	public long getScriptVersion ( ) {
		return ScriptVersion;
	}

	public void setScriptVersion ( long scriptVersion ) {
		ScriptVersion = scriptVersion;
	}

	public void setScriptVersion ( int scriptVersion ) {
		ScriptVersion = scriptVersion;
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

	@JSONField(name = "DeviceName")
	public String getDeviceName ( ) {
		return DeviceName;
	}

	public void setDeviceName ( String deviceName ) {
		DeviceName = deviceName;
	}

	@JSONField(name = "ScriptId")
	public String getScriptId ( ) {
		return ScriptId;
	}

	public void setScriptId ( String scriptId ) {
		ScriptId = scriptId;
	}

	@JSONField(name = "TemplateVersion")
	public String getTemplateVersion ( ) {
		return TemplateVersion;
	}

	public void setTemplateVersion ( String templateVersion ) {
		TemplateVersion = templateVersion;
	}
}
