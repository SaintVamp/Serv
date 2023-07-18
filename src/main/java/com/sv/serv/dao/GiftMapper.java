package com.sv.serv.dao;

import com.sv.serv.model.Gift;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GiftMapper {

	int count ( ) throws Exception;

	int insert ( Gift gift ) throws Exception;

	int deleteAll ( ) throws Exception;

	int delete ( Gift gift ) throws Exception;
}
