package com.sv.serv.controller;

import com.alibaba.fastjson.JSONObject;
import com.sv.serv.common.HttpUtil;
import com.sv.serv.common.JsonUtil;
import com.sv.serv.common.ResponseCode;
import com.sv.serv.common.ResponseData;
import com.sv.serv.model.SimOperate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/local")
public class LocalController {

	private static final Logger log = LogManager.getLogger( "local" );
	private final String v_url = "http://4.0.4.20:50404/";


	@RequestMapping(value = "/Health")
	public String Health ( ) {
		return "OK";
	}

//
//
//    @RequestMapping(value = "/start", method = RequestMethod.GET)
//    public ResponseData startG(HttpServletRequest request) {
//        ResponseData result = new ResponseData(ResponseCode.SUCCESS, ResponseCode.SUCCESS_DESC);
//        String vid = request.getParameter("vid");
//        HttpUtil.Get(v_url + "start/" + vid);
//        result.setData("启动命令已发送");
//        return result;
//    }


	@RequestMapping(value = "/start", method = RequestMethod.POST)
	public ResponseData start ( HttpServletRequest request ) {
		ResponseData result = new ResponseData( ResponseCode.SUCCESS, ResponseCode.SUCCESS_DESC );
		try {
			SimOperate simOperate = JSONObject.parseObject( new JsonUtil().Map2String( request.getParameterMap() ), SimOperate.class );
			log.info( "start param is > " + simOperate );
			HttpUtil.Get( v_url + "start/" + simOperate.getId() );
			result.setData( "启动命令已发送" );
		} catch ( Exception e ) {
			log.error( "start has error:" + e.getMessage() );
			result = new ResponseData( ResponseCode.ERROR, ResponseCode.ERROR_DESC );
			result.setData( "ERROR" );
		}
		return result;
	}

//
//    @RequestMapping(value = "/reboot", method = RequestMethod.GET)
//    public ResponseData rebootG(HttpServletRequest request) {
//        ResponseData result = new ResponseData(ResponseCode.SUCCESS, ResponseCode.SUCCESS_DESC);
//        String vid = request.getParameter("vid");
//        HttpUtil.Get(v_url + "reboot/" + vid);
//        result.setData("重启命令已发送");
//        return result;
//    }


	@RequestMapping(value = "/reboot", method = RequestMethod.POST)
	public ResponseData reboot ( HttpServletRequest request ) {
		ResponseData result = new ResponseData( ResponseCode.SUCCESS, ResponseCode.SUCCESS_DESC );
		try {
			SimOperate simOperate = JSONObject.parseObject( new JsonUtil().Map2String( request.getParameterMap() ), SimOperate.class );
			log.info( "reboot param is > " + simOperate );
			HttpUtil.Get( v_url + "reboot/" + simOperate.getId() );
			result.setData( "重启命令已发送" );
		} catch ( Exception e ) {
			log.error( "reboot has error:" + e.getMessage() );
			result = new ResponseData( ResponseCode.ERROR, ResponseCode.ERROR_DESC );
			result.setData( "ERROR" );
		}
		return result;
	}

//
//    @RequestMapping(value = "/stop", method = RequestMethod.GET)
//    public ResponseData stopG(HttpServletRequest request) {
//        ResponseData result = new ResponseData(ResponseCode.SUCCESS, ResponseCode.SUCCESS_DESC);
//        String vid = request.getParameter("vid");
//        HttpUtil.Get(v_url + "stop/" + vid);
//        result.setData("停止命令已发送");
//        return result;
//    }


	@RequestMapping(value = "/stop", method = RequestMethod.POST)
	public ResponseData stop ( HttpServletRequest request ) {
		ResponseData result = new ResponseData( ResponseCode.SUCCESS, ResponseCode.SUCCESS_DESC );
		try {
			SimOperate simOperate = JSONObject.parseObject( new JsonUtil().Map2String( request.getParameterMap() ), SimOperate.class );
			log.info( "stop param is > " + simOperate );
			HttpUtil.Get( v_url + "stop/" + simOperate.getId() );
			result.setData( "停止命令已发送" );
		} catch ( Exception e ) {
			log.error( "stop has error:" + e.getMessage() );
			result = new ResponseData( ResponseCode.ERROR, ResponseCode.ERROR_DESC );
			result.setData( "ERROR" );
		}
		return result;
	}

//
//    @RequestMapping(value = "/sort", method = RequestMethod.GET)
//    public ResponseData sortG(HttpServletRequest request) {
//        ResponseData result = new ResponseData(ResponseCode.SUCCESS, ResponseCode.SUCCESS_DESC);
//        String vid = request.getParameter("vid");
//        HttpUtil.Get(v_url + "sort/" + vid);
//        result.setData("排列命令已发送");
//        return result;
//    }


	@RequestMapping(value = "/sort", method = RequestMethod.POST)
	public ResponseData sort ( HttpServletRequest request ) {
		ResponseData result = new ResponseData( ResponseCode.SUCCESS, ResponseCode.SUCCESS_DESC );
		try {
			SimOperate simOperate = JSONObject.parseObject( new JsonUtil().Map2String( request.getParameterMap() ), SimOperate.class );
			log.info( "sort param is > " + simOperate );
			HttpUtil.Get( v_url + "sort/" + simOperate.getId() );
			log.info( "排列命令已发送" );
		} catch ( Exception e ) {
			log.error( "stop has error:" + e.getMessage() );
			result = new ResponseData( ResponseCode.ERROR, ResponseCode.ERROR_DESC );
			result.setData( "ERROR" );
		}
		return result;
	}


	public void os_reboot ( ) {
		HttpUtil.Get( v_url + "pcreboot" );
//        log.info("ERROR:电脑没打开");
	}

}
