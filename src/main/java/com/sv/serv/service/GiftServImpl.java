package com.sv.serv.service;

import com.sv.serv.dao.GiftMapper;
import com.sv.serv.model.Gift;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GiftServImpl {
	@Autowired
	private GiftMapper giftMapper;


	public String getRunning ( ) throws Exception {
		return String.valueOf( giftMapper.count() );
	}


	public int setRunning ( Gift gift ) throws Exception {
		return giftMapper.insert( gift );
	}


	public int delRunningAll ( ) throws Exception {
		return giftMapper.deleteAll();
	}


	public int delRunning ( Gift gift ) throws Exception {
		return giftMapper.delete( gift );
	}
}
