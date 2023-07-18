package com.sv.serv.service;

import com.sv.serv.dao.ToolUpdateMapper;
import com.sv.serv.model.ToolUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToolUpdateServImpl {
	@Autowired
	private ToolUpdateMapper toolUpdateMapper;


	public boolean isNeedUpdate ( String toolName, long version ) throws Exception {
		return toolUpdateMapper.getVersion( toolName ) > version;
	}


	public ToolUpdate getUpdateInfo ( String toolName ) throws Exception {
		return toolUpdateMapper.getUpdateInfo( toolName );
	}


	public int updateInfo ( ToolUpdate toolUpdate ) throws Exception {
		return toolUpdateMapper.update( toolUpdate );
	}
}
