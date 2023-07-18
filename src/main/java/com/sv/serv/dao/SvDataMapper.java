package com.sv.serv.dao;

import com.sv.serv.model.SvData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SvDataMapper {
	int insert ( SvData svData ) throws Exception;

	int update ( SvData svData ) throws Exception;

	int delete ( SvData svData ) throws Exception;

	List<SvData> select ( SvData svData ) throws Exception;

	List<SvData> list ( ) throws Exception;

	int count ( ) throws Exception;
}
