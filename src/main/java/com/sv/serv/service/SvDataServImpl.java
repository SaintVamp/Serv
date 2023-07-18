package com.sv.serv.service;

import com.sv.serv.dao.SvDataMapper;
import com.sv.serv.model.SvData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SvDataServImpl {
	@Autowired
	private SvDataMapper svDataMapper;

	public int reg ( SvData svData ) throws Exception {
		return svDataMapper.insert( svData );
	}

	public int update ( SvData svData ) throws Exception {
		return svDataMapper.update( svData );
	}

	public List<SvData> search ( SvData svData ) throws Exception {
		return svDataMapper.select( svData );
	}

	public List<SvData> countAll ( ) throws Exception {
		return svDataMapper.list();
	}

	public int delete ( SvData svData ) throws Exception {
		return svDataMapper.delete( svData );
	}

}
