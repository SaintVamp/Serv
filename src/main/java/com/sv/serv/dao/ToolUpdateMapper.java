package com.sv.serv.dao;

import com.sv.serv.model.ToolUpdate;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ToolUpdateMapper {

	ToolUpdate getUpdateInfo ( String toolName ) throws Exception;

	Long getVersion ( String toolName ) throws Exception;

	int insert ( ToolUpdate toolUpdate ) throws Exception;

	int update ( ToolUpdate toolUpdate ) throws Exception;

	int delete ( ToolUpdate toolUpdate ) throws Exception;

	int count ( ) throws Exception;

	List<ToolUpdate> list ( ) throws Exception;

}
