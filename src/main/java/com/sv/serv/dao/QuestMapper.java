package com.sv.serv.dao;

import com.sv.serv.model.Quest;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QuestMapper {

	Quest select ( Quest quest ) throws Exception;

	int insert ( Quest quest ) throws Exception;

}
