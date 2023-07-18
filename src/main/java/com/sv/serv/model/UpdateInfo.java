package com.sv.serv.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.ToString;

@ToString
public class UpdateInfo {
	private String ToolName;
	private String DownLoadPath;
	private String UpdateNotice;
	private String UpdateType;
	private String UpdateTime;
	private String FileSize;
	private String Version;
	private String Code;

	public UpdateInfo ( String ToolName, String DownLoadPath, String UpdateNotice, String UpdateType, String UpdateTime, String FileSize, String Version ) {
		this.ToolName = ToolName;
		this.DownLoadPath = DownLoadPath;
		this.UpdateNotice = UpdateNotice;
		this.UpdateType = UpdateType;
		this.UpdateTime = UpdateTime;
		this.FileSize = FileSize;
		this.Version = Version;
		this.Code = Code;
	}

	public UpdateInfo ( ) {
	}

	@JSONField(name = "DownLoadPath")
	public String getDownLoadPath ( ) {
		return DownLoadPath;
	}

	public void setDownLoadPath ( String downLoadPath ) {
		DownLoadPath = downLoadPath;
	}

	@JSONField(name = "FileSize")
	public String getFileSize ( ) {
		return FileSize;
	}

	public void setFileSize ( String fileSize ) {
		FileSize = fileSize;
	}

	@JSONField(name = "UpdateTime")
	public String getUpdateTime ( ) {
		return UpdateTime;
	}

	public void setUpdateTime ( String updateTime ) {
		UpdateTime = updateTime;
	}

	@JSONField(name = "Version")
	public String getVersion ( ) {
		return Version;
	}

	public void setVersion ( String version ) {
		Version = version;
	}

	@JSONField(name = "ToolName")
	public String getToolName ( ) {
		return ToolName;
	}

	public void setToolName ( String toolName ) {
		ToolName = toolName;
	}

	@JSONField(name = "UpdateNotice")
	public String getUpdateNotice ( ) {
		return UpdateNotice;
	}

	public void setUpdateNotice ( String updateNotice ) {
		UpdateNotice = updateNotice;
	}

	@JSONField(name = "UpdateType")
	public String getUpdateType ( ) {
		return UpdateType;
	}

	public void setUpdateType ( String updateType ) {
		UpdateType = updateType;
	}

	@JSONField(name="Code")
	public String getCode(){return Code;}

	public void setCode ( String code ) {
		Code = code;
	}
}
