package com.sv.serv.service;


import com.sv.serv.dao.MegapolisInfoMapper;
import com.sv.serv.model.MegapolisInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MegapolisServImpl {
	@Autowired
	private MegapolisInfoMapper megapolisInfoMapper;


	public MegapolisInfo getMegapolis ( MegapolisInfo megapolisInfo ) throws Exception {
		return megapolisInfoMapper.select( megapolisInfo ).get( 0 );
	}


	public int setMegapolis ( MegapolisInfo megapolisInfo ) throws Exception {
		return megapolisInfoMapper.insert( megapolisInfo );
	}


	public int count ( ) throws Exception {
		return megapolisInfoMapper.count();
	}


	public String getUnsentDay ( ) throws Exception {
		List<MegapolisInfo> list = megapolisInfoMapper.select( new MegapolisInfo( "", null, null, null, null, null, null, "0", null, null, null, null, null, null, null, null ) );
		StringBuilder r = new StringBuilder();
		for ( MegapolisInfo megapolisInfo : list ) {
			r.append( megapolisInfo.getId() ).append( "," );
		}
		return r.toString().replaceFirst( ".$", "" );
	}
}