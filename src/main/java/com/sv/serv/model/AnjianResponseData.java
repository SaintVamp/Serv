package com.sv.serv.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.ToString;

@ToString
public class AnjianResponseData {
	private int Code;
	private String Message;
	private Object Data;

	public AnjianResponseData ( int code, String message ) {
		super();
		this.Code = code;
		this.Message = message;
	}

	@JSONField(name = "Code")
	public int getCode ( ) {
		return Code;
	}

	public void setCode ( int code ) {
		Code = code;
	}

	@JSONField(name = "Message")
	public String getMessage ( ) {
		return Message;
	}

	public void setMessage ( String message ) {
		Message = message;
	}

	@JSONField(name = "Data")
	public Object getData ( ) {
		return Data;
	}

	public void setData ( Object data ) {
		this.Data = data;
	}


}
