package com.sv.serv.dao;

import com.sv.serv.model.Contract;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ContractMapper {
	String getAreaNum ( Contract contract ) throws Exception;

	int count ( ) throws Exception;

	List<Contract> list ( ) throws Exception;

	int insert ( Contract contract ) throws Exception;

	List<Contract> select ( Contract contract ) throws Exception;

	int update ( Contract contract ) throws Exception;

	void delete ( Contract contract ) throws Exception;

}
