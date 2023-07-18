package com.sv.serv.model;


import com.alibaba.fastjson.annotation.JSONField;


public class ToolUpdate extends ResponseTime {
	private String PackageName;
	private String AppName;
	private String UpdateContent;
	private String UpdateUrl;
	private String StudioProjectKey;
	private String DeviceName;
	private int UpdateType;
	private int InstanceDataUploadInterval;
	private int UpgradeMode;
	private long AppVersion;
	private long PackageSize;
	private long AppUpdateTime;


	public ToolUpdate ( ) {
	}

	public ToolUpdate ( long timestamp ) {
		super( timestamp );
	}

	@JSONField(name = "AppVersion")
	public long getAppVersion ( ) {
		return AppVersion;
	}

	public void setAppVersion ( long appVersion ) {
		AppVersion = appVersion;
	}

	@JSONField(name = "InstanceDataUploadInterval")
	public int getInstanceDataUploadInterval ( ) {
		return InstanceDataUploadInterval;
	}

	public void setInstanceDataUploadInterval ( int instanceDataUploadInterval ) {
		InstanceDataUploadInterval = instanceDataUploadInterval;
	}

	@JSONField(name = "UpdateType")
	public int getUpdateType ( ) {
		return UpdateType;
	}

	public void setUpdateType ( int updateType ) {
		UpdateType = updateType;
	}

	@JSONField(name = "UpgradeMode")
	public int getUpgradeMode ( ) {
		return UpgradeMode;
	}

	public void setUpgradeMode ( int upgradeMode ) {
		UpgradeMode = upgradeMode;
	}

	@JSONField(name = "AppUpdateTime")
	public long getAppUpdateTime ( ) {
		return AppUpdateTime;
	}

	public void setAppUpdateTime ( long appUpdateTime ) {
		AppUpdateTime = appUpdateTime;
	}

	@JSONField(name = "PackageSize")
	public long getPackageSize ( ) {
		return PackageSize;
	}

	public void setPackageSize ( long packageSize ) {
		PackageSize = packageSize;
	}

	@JSONField(name = "AppName")
	public String getAppName ( ) {
		return AppName;
	}

	public void setAppName ( String appName ) {
		AppName = appName;
	}

	@JSONField(name = "PackageName")
	public String getPackageName ( ) {
		return PackageName;
	}

	public void setPackageName ( String packageName ) {
		PackageName = packageName;
	}

	@JSONField(name = "StudioProjectKey")
	public String getStudioProjectKey ( ) {
		return StudioProjectKey;
	}

	public void setStudioProjectKey ( String studioProjectKey ) {
		StudioProjectKey = studioProjectKey;
	}

	@JSONField(name = "UpdateContent")
	public String getUpdateContent ( ) {
		return UpdateContent;
	}

	public void setUpdateContent ( String updateContent ) {
		UpdateContent = updateContent;
	}

	@JSONField(name = "UpdateUrl")
	public String getUpdateUrl ( ) {
		return UpdateUrl;
	}

	public void setUpdateUrl ( String updateUrl ) {
		UpdateUrl = updateUrl;
	}

	@JSONField(name = "DeviceName")
	public String getDeviceName ( ) {
		return DeviceName;
	}

	public void setDeviceName ( String deviceName ) {
		DeviceName = deviceName;
	}
}
