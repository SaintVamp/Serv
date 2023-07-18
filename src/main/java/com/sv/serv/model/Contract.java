package com.sv.serv.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.ToString;

@ToString
public class Contract {
	private String name;
	private String id;
	private String time;
	private String timestamp;
	private String flag;
	private String operation;
	private String updateDt;

	public Contract ( ) {
	}

	public Contract ( String name, String id, String time, String timestamp, String flag, String operation, String updateDt ) {
		this.name = name;
		this.id = id;
		this.time = time;
		this.timestamp = timestamp;
		this.flag = flag;
		this.operation = operation;
		this.updateDt = updateDt;
	}

	@JSONField(name = "updateDt")
	public String getUpdateDt ( ) {
		return updateDt;
	}

	public void setUpdateDt ( String updateDt ) {
		this.updateDt = updateDt;
	}

	@JSONField(name = "operation")
	public String getOperation ( ) {
		return operation;
	}

	public void setOperation ( String operation ) {
		this.operation = operation;
	}

	@JSONField(name = "time")
	public String getTime ( ) {
		return time;
	}

	public void setTime ( String time ) {
		this.time = time;
	}

	@JSONField(name = "id")
	public String getId ( ) {
		return id;
	}

	public void setId ( String id ) {
		this.id = id;
	}

	@JSONField(name = "name")
	public String getName ( ) {
		return name;
	}

	public void setName ( String name ) {
		this.name = name;
	}

	@JSONField(name = "flag")
	public String getFlag ( ) {
		return flag;
	}

	public void setFlag ( String flag ) {
		this.flag = flag;
	}

	@JSONField(name = "timestamp")
	public String getTimestamp ( ) {
		return timestamp;
	}

	public void setTimestamp ( String timestamp ) {
		this.timestamp = timestamp;
	}
}
