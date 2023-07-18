package com.sv.serv.dao;

import com.sv.serv.model.ToolAlive;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ToolAliveMapper {
	int count ( ) throws Exception;

	int countParams ( ToolAlive toolAlive ) throws Exception;

	List<ToolAlive> list ( ) throws Exception;

	List<ToolAlive> select ( ToolAlive toolAlive ) throws Exception;

	int insert ( ToolAlive toolAlive ) throws Exception;

	int update ( ToolAlive toolAlive ) throws Exception;


}
