package com.sv.serv.service;

import com.sv.serv.dao.SvAuthMapper;
import com.sv.serv.model.SvAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SvAuthServImpl {

	@Autowired
	private SvAuthMapper svAuthMapper;


	public String login ( SvAuth svAuth ) {
		try {
			return svAuthMapper.login( svAuth );
		} catch ( Exception e ) {
			return "";
		}
	}


}
