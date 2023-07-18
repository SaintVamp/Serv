package com.sv.serv.service;


import com.alibaba.fastjson.JSONObject;
import com.sv.serv.dao.ContractMapper;
import com.sv.serv.dao.ToolAliveMapper;
import com.sv.serv.model.Contract;
import com.sv.serv.model.ToolAlive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ZukServImpl {
	@Autowired
	private ContractMapper contractMapper;
	@Autowired
	private ToolAliveMapper toolAliveMapper;


	public String getAreaNum ( Contract contract ) throws Exception {
		List<Contract> list = contractMapper.select( contract );
		StringBuilder r = new StringBuilder();
		for ( Contract contract1 : list ) {
			r.append( contract1.getId() ).append( "," );
		}
		return r.toString().replaceFirst( ".$", "" );
	}


	public int setContractTime ( Contract contract ) throws Exception {
		return contractMapper.update( contract );
	}

	public String getContractTime ( Contract contract ) throws Exception {
		contract.setTimestamp( "" );
		List<Contract> contractList = contractMapper.select( contract );
		return contractList.get( 0 ).getTime();
	}


	public String getContractTimestamp ( Contract contract ) throws Exception {
		contract.setTimestamp( "" );
		List<Contract> contractList = contractMapper.select( contract );
		return contractList.get( 0 ).getTimestamp();
	}


	public Contract getContractOperation ( Contract contract ) throws Exception {
		contract.setOperation( "" );
		contract.setUpdateDt( "" );
		List<Contract> contractList = contractMapper.select( contract );
		return contractList.get( 0 );
	}


	public int setContractOperation ( Contract contract ) throws Exception {
		return contractMapper.update( contract );
	}


	public String getContractTimeAll ( ) throws Exception {
		Contract contract = new Contract( "", null, "", null, null, null, null );
		List<Contract> contractList = contractMapper.select( contract );
		return JSONObject.toJSONString( contractList );
	}


	public int setToolHeart ( ToolAlive toolAlive ) throws Exception {
		int i;
		ToolAlive toolAlive1 = new ToolAlive( toolAlive.getToolName(), toolAlive.getCode(), null, null );
		if ( toolAliveMapper.countParams( toolAlive1 ) > 0 ) {
			i = toolAliveMapper.update( toolAlive );
		} else {
			i = toolAliveMapper.insert( toolAlive );
		}
		return i;
	}


	public String getToolHeart ( ToolAlive toolAlive ) throws Exception {
		List<ToolAlive> toolAliveList = toolAliveMapper.select( toolAlive );
		return toolAliveList.get( 0 ).getTimestamp();
	}

}