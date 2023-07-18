package com.sv.serv.model;

import lombok.ToString;

@ToString
public class Anjian {
	private String package_name;
	private String attr;
	private String val;

	public String getVal ( ) {
		return val;
	}

	public void setVal ( String val ) {
		this.val = val;
	}

	public String getPackage_name ( ) {
		return package_name;
	}

	public void setPackage_name ( String package_name ) {
		this.package_name = package_name;
	}

	public String getAttr ( ) {
		return attr;
	}

	public void setAttr ( String attr ) {
		this.attr = attr;
	}
}
