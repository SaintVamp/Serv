package com.sv.serv.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.ToString;


@ToString
public class ToolAlive {
	private String toolName;
	private String code;
	private String status;
	private String timestamp;

	public ToolAlive ( ) {
	}

	public ToolAlive ( String toolName, String code, String status, String timestamp ) {
		this.toolName = toolName;
		this.code = code;
		this.status = status;
		this.timestamp = timestamp;
	}

	@JSONField(name = "toolName")
	public String getToolName ( ) {
		return toolName;
	}

	public void setToolName ( String toolName ) {
		this.toolName = toolName;
	}

	@JSONField(name = "code")
	public String getCode ( ) {
		return code;
	}

	public void setCode ( String code ) {
		this.code = code;
	}

	@JSONField(name = "status")
	public String getStatus ( ) {
		return status;
	}

	public void setStatus ( String status ) {
		this.status = status;
	}

	@JSONField(name = "timestamp")
	public String getTimestamp ( ) {
		return timestamp;
	}

	public void setTimestamp ( String timestamp ) {
		this.timestamp = timestamp;
	}
}
