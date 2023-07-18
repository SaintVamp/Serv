package com.sv.serv.dao;

import com.sv.serv.model.SwitchInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SwitchInfoMapper {
	List<SwitchInfo> list ( ) throws Exception;

	List<SwitchInfo> select ( SwitchInfo switchInfo ) throws Exception;

	int update ( SwitchInfo switchInfo ) throws Exception;

	int insert ( SwitchInfo switchInfo ) throws Exception;


}
