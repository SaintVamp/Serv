package com.sv.serv.service;

import com.sv.serv.dao.QuestMapper;
import com.sv.serv.model.Quest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestServImpl {
	@Autowired
	private QuestMapper questMapper;


	public String getQuest ( Quest quest ) throws Exception {
		Quest quest1 = questMapper.select( quest );
		return quest1.getFlag() + "," + quest1.getPositive();
	}


	public int setQuest ( Quest quest ) throws Exception {
		return questMapper.insert( quest );
	}
}
