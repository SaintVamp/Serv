package com.sv.serv.service;

import com.sv.serv.dao.UpdateInfoMapper;
import com.sv.serv.model.UpdateInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateInfoServImpl {
	@Autowired
	private UpdateInfoMapper updateInfoMapper;


	public boolean isNeedUpdate ( String toolName, long version ) throws Exception {
		return Long.parseLong( updateInfoMapper.getVersion( toolName ) ) > version;
	}


	public UpdateInfo getUpdateInfo ( UpdateInfo updateInfo ) throws Exception {
		return updateInfoMapper.select( updateInfo ).get( 0 );
	}


	public int setUpdateInfo ( UpdateInfo updateInfo ) throws Exception {
		return updateInfoMapper.update( updateInfo );
	}
}
