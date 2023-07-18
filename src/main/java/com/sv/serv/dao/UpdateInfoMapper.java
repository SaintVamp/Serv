package com.sv.serv.dao;


import com.sv.serv.model.UpdateInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UpdateInfoMapper {


	String getVersion ( String toolName ) throws Exception;

	List<UpdateInfo> select ( UpdateInfo updateInfo ) throws Exception;

	int insert ( UpdateInfo updateInfo ) throws Exception;

	int update ( UpdateInfo updateInfo ) throws Exception;

	int delete ( UpdateInfo updateInfo ) throws Exception;

	int count ( ) throws Exception;

	List<UpdateInfo> list ( ) throws Exception;

}
