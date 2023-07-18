package com.sv.serv.dao;

import com.sv.serv.model.MegapolisInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MegapolisInfoMapper {
	List<MegapolisInfo> list ( ) throws Exception;

	int count ( ) throws Exception;

	List<MegapolisInfo> select ( MegapolisInfo megapolisInfo ) throws Exception;

	int update ( MegapolisInfo megapolisInfo ) throws Exception;

	int insert ( MegapolisInfo megapolisInfo ) throws Exception;


}
