package com.sv.serv.controller;


import com.alibaba.fastjson.JSONObject;
import com.sv.serv.common.JsonUtil;
import com.sv.serv.common.ResponseCode;
import com.sv.serv.common.ResponseData;
import com.sv.serv.common.SVUtil;
import com.sv.serv.model.Contract;
import com.sv.serv.model.ToolAlive;
import com.sv.serv.service.ZukServImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import static com.sv.serv.common.SVUtil.ts2time;


@RestController
@RequestMapping("/zuk")
public class ZukController {
	private static final Logger log = LogManager.getLogger( "zuk" );
	@Autowired
	ZukServImpl zukServ;

	@RequestMapping(value = "/Health")
	public String Health ( ) {
		return "OK";
	}


	@RequestMapping(value = "/setToolHeart", method = RequestMethod.POST)
	public ResponseData setToolHeart ( HttpServletRequest request ) {
		ResponseData result = new ResponseData( ResponseCode.SUCCESS, ResponseCode.SUCCESS_DESC );
		try {
			ToolAlive toolAlive = JSONObject.parseObject( new JsonUtil().Map2String( request.getParameterMap() ), ToolAlive.class );
			log.info( "setToolHeart param is > " + toolAlive );
			result.setData( zukServ.setToolHeart( toolAlive ) );
		} catch ( Exception e ) {
			e.printStackTrace();
			log.error( "setToolHeart has error:" + e.getMessage() );
			result = new ResponseData( ResponseCode.ERROR, ResponseCode.ERROR_DESC );
			result.setData( "ERROR" );
		}
		return result;
	}


	@RequestMapping(value = "/getToolHeart", method = RequestMethod.POST)
	public ResponseData getToolHeart ( HttpServletRequest request ) {
		ResponseData result = new ResponseData( ResponseCode.SUCCESS, ResponseCode.SUCCESS_DESC );
		try {
			ToolAlive toolAlive = JSONObject.parseObject( new JsonUtil().Map2String( request.getParameterMap() ), ToolAlive.class );
			log.info( "getToolHeart param is > " + toolAlive );
			toolAlive.setTimestamp( "" );
			result.setData( zukServ.getToolHeart( toolAlive ) );
		} catch ( Exception e ) {
			e.printStackTrace();
			log.error( "getToolHeart has error:" + e.getMessage() );
			result = new ResponseData( ResponseCode.ERROR, ResponseCode.ERROR_DESC );
			result.setData( "ERROR" );
		}
		return result;
	}


	@RequestMapping(value = "/setContractOperation", method = RequestMethod.POST)
	public ResponseData setContractOperation ( HttpServletRequest request ) {
		ResponseData result = new ResponseData( ResponseCode.SUCCESS, ResponseCode.SUCCESS_DESC );
		try {
			Contract contract = JSONObject.parseObject( new JsonUtil().Map2String( request.getParameterMap() ), Contract.class );
			contract.setUpdateDt( SVUtil.ts2time( String.valueOf( System.currentTimeMillis() / 1000 ) ) );
			log.info( "setContractOperation param is > " + contract );
			result.setData( zukServ.setContractOperation( contract ) );
		} catch ( Exception e ) {
			e.printStackTrace();
			log.error( "setContractOperation has error:" + e.getMessage() );
			result = new ResponseData( ResponseCode.ERROR, ResponseCode.ERROR_DESC );
			result.setData( "ERROR" );
		}
		return result;
	}


	@RequestMapping(value = "/getContractOperation", method = RequestMethod.POST)
	public ResponseData getContractOperation ( HttpServletRequest request ) {
		ResponseData result = new ResponseData( ResponseCode.SUCCESS, ResponseCode.SUCCESS_DESC );
		try {
			Contract contract = JSONObject.parseObject( new JsonUtil().Map2String( request.getParameterMap() ), Contract.class );
			log.info( "getContractOperation param is > " + contract );
			result.setData( zukServ.getContractOperation( contract ) );
		} catch ( Exception e ) {
			e.printStackTrace();
			log.error( "getContractOperation has error:" + e.getMessage() );
			result = new ResponseData( ResponseCode.ERROR, ResponseCode.ERROR_DESC );
			result.setData( "ERROR" );
		}
		return result;
	}


	@RequestMapping(value = { "/getContractTimeAll" }, method = RequestMethod.GET)
	public ResponseData getContractTimeAll ( ) {
		ResponseData result = new ResponseData( ResponseCode.SUCCESS, ResponseCode.SUCCESS_DESC );
		try {
			log.info( "getContractTimeAll param is null" );
			result.setData( zukServ.getContractTimeAll() );
		} catch ( Exception e ) {
			e.printStackTrace();
			log.error( "getContractTimeAll has error:" + e.getMessage() );
			result = new ResponseData( ResponseCode.ERROR, ResponseCode.ERROR_DESC );
			result.setData( "ERROR" );
		}
		return result;
	}


	@RequestMapping(value = "/getAreaNum", method = RequestMethod.POST)
	public ResponseData getAreaNum ( HttpServletRequest request ) {
		ResponseData result = new ResponseData( ResponseCode.SUCCESS, ResponseCode.SUCCESS_DESC );
		try {
			Contract contract = JSONObject.parseObject( new JsonUtil().Map2String( request.getParameterMap() ), Contract.class );
			log.info( "getAreaNum param is > " + contract );
			result.setData( zukServ.getAreaNum( contract ) );
		} catch ( Exception e ) {
			e.printStackTrace();
			log.error( "getAreaNum has error:" + e.getMessage() );
			result = new ResponseData( ResponseCode.ERROR, ResponseCode.ERROR_DESC );
			result.setData( "ERROR" );
		}
		return result;
	}


	@RequestMapping(value = "/getContractTime", method = RequestMethod.POST)
	public ResponseData getContractTime ( HttpServletRequest request ) {
		ResponseData result = new ResponseData( ResponseCode.SUCCESS, ResponseCode.SUCCESS_DESC );
		try {
			Contract contract = JSONObject.parseObject( new JsonUtil().Map2String( request.getParameterMap() ), Contract.class );
			log.info( "getContractTime param is > " + contract );
			result.setData( zukServ.getContractTime( contract ) );
		} catch ( Exception e ) {
			e.printStackTrace();
			log.error( "getContractTime has error:" + e.getMessage() );
			result = new ResponseData( ResponseCode.ERROR, ResponseCode.ERROR_DESC );
			result.setData( "getContractTime has error" );
		}
		return result;
	}


	@RequestMapping(value = "/setContractTime", method = RequestMethod.POST)
	public ResponseData setContractTime ( HttpServletRequest request ) {
		ResponseData result = new ResponseData( ResponseCode.SUCCESS, ResponseCode.SUCCESS_DESC );
		try {
			Contract contract = JSONObject.parseObject( new JsonUtil().Map2String( request.getParameterMap() ), Contract.class );
			contract.setTime( ts2time( contract.getTimestamp() ) );
			log.info( "setContractTime param is > " + contract );
			result.setData( zukServ.setContractTime( contract ) );
		} catch ( Exception e ) {
			e.printStackTrace();
			log.error( "setContractTime has error:" + e.getMessage() );
			result = new ResponseData( ResponseCode.ERROR, ResponseCode.ERROR_DESC );
			result.setData( "setContractTime has error" );
		}
		return result;
	}

	@RequestMapping(value = "/getContractTimestamp", method = RequestMethod.POST)
	public ResponseData getContractTimestamp ( HttpServletRequest request ) {
		ResponseData result = new ResponseData( ResponseCode.SUCCESS, ResponseCode.SUCCESS_DESC );
		try {
			Contract contract = JSONObject.parseObject( new JsonUtil().Map2String( request.getParameterMap() ), Contract.class );
			log.info( "getContractTime param is > " + contract );
			result.setData( zukServ.getContractTimestamp( contract ) );
		} catch ( Exception e ) {
			e.printStackTrace();
			log.error( "getContractTime has error:" + e.getMessage() );
			result = new ResponseData( ResponseCode.ERROR, ResponseCode.ERROR_DESC );
			result.setData( "getContractTime has error" );
		}
		return result;
	}


	@RequestMapping(value = "/setContractTimestamp", method = RequestMethod.POST)
	public ResponseData setContractTimestamp ( HttpServletRequest request ) {
		ResponseData result = new ResponseData( ResponseCode.SUCCESS, ResponseCode.SUCCESS_DESC );
		try {
			Contract contract = JSONObject.parseObject( new JsonUtil().Map2String( request.getParameterMap() ), Contract.class );
			contract.setTime( ts2time( String.valueOf( contract.getTimestamp() ) ) );
			log.info( "setContractTime param is > " + contract );
			result.setData( zukServ.setContractTime( contract ) );
		} catch ( Exception e ) {
			e.printStackTrace();
			log.error( "setContractTime has error:" + e.getMessage() );
			result = new ResponseData( ResponseCode.ERROR, ResponseCode.ERROR_DESC );
			result.setData( "setContractTime has error" );
		}
		return result;
	}

}
