package com.sv.serv.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.ToString;


@ToString
public class SvData {
	private String qqNum;
	private String authCode;
	private String device;
	private String startDt;
	private String endDt;
	private String localIp;
	private Integer price;
	private String updateDt;
	private String version;
	private String game;

	public SvData ( ) {

	}

	public SvData ( String qqNum, String authCode, String device, String startDt, String endDt, String localIp, Integer price, String updateDt, String version, String game ) {
		this.qqNum = qqNum;
		this.authCode = authCode;
		this.device = device;
		this.startDt = startDt;
		this.endDt = endDt;
		this.localIp = localIp;
		this.price = price;
		this.updateDt = updateDt;
		this.version = version;
		this.game = game;
	}

	@JSONField(name = "price")
	public Integer getPrice ( ) {
		return price;
	}

	@JSONField(name = "authCode")
	public String getAuthCode ( ) {
		return authCode;
	}

	@JSONField(name = "device")
	public String getDevice ( ) {
		return device;
	}

	@JSONField(name = "endDt")
	public String getEndDt ( ) {
		return endDt;
	}

	@JSONField(name = "game")
	public String getGame ( ) {
		return game;
	}

	@JSONField(name = "localIp")
	public String getLocalIp ( ) {
		return localIp;
	}

	@JSONField(name = "qqNum")
	public String getQqNum ( ) {
		return qqNum;
	}

	@JSONField(name = "startDt")
	public String getStartDt ( ) {
		return startDt;
	}

	@JSONField(name = "updateDt")
	public String getUpdateDt ( ) {
		return updateDt;
	}

	@JSONField(name = "version")
	public String getVersion ( ) {
		return version;
	}

	public void setVersion ( String version ) {
		this.version = version;
	}

	public void setAuthCode ( String authCode ) {
		this.authCode = authCode;
	}

	public void setDevice ( String device ) {
		this.device = device;
	}

	public void setEndDt ( String endDt ) {
		this.endDt = endDt;
	}

	public void setGame ( String game ) {
		this.game = game;
	}

	public void setLocalIp ( String localIp ) {
		this.localIp = localIp;
	}

	public void setPrice ( Integer price ) {
		this.price = price;
	}

	public void setQqNum ( String qqNum ) {
		this.qqNum = qqNum;
	}

	public void setStartDt ( String startDt ) {
		this.startDt = startDt;
	}

	public void setUpdateDt ( String updateDt ) {
		this.updateDt = updateDt;
	}
}

