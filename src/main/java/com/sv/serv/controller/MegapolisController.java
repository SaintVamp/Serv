package com.sv.serv.controller;

import com.alibaba.fastjson.JSONObject;
import com.sv.serv.common.JsonUtil;
import com.sv.serv.common.ResponseCode;
import com.sv.serv.common.ResponseData;
import com.sv.serv.model.Gift;
import com.sv.serv.model.MegapolisInfo;
import com.sv.serv.model.Quest;
import com.sv.serv.model.SwitchInfo;
import com.sv.serv.service.GiftServImpl;
import com.sv.serv.service.MegapolisServImpl;
import com.sv.serv.service.QuestServImpl;
import com.sv.serv.service.SwitchServImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/megapolis")
public class MegapolisController {
	private static final Logger log = LogManager.getLogger( "megapolis" );
	@Autowired
	private MegapolisServImpl megapolisServ;
	@Autowired
	private GiftServImpl giftServ;
	@Autowired
	private SwitchServImpl switchServ;
	@Autowired
	private QuestServImpl questServ;

	@RequestMapping(value = "/Health")
	public String Health ( ) {
		log.info( "Health" );
		return "OK";
	}

	/**
	 * 用的Megapolis表
	 */

	@RequestMapping(value = "/getMegapolis/{flag}", method = RequestMethod.POST)
	public String getMegapolis ( HttpServletRequest request, @PathVariable String flag ) {
		try {
			MegapolisInfo megapolisInfo = JSONObject.parseObject( new JsonUtil().Map2String( request.getParameterMap() ), MegapolisInfo.class );
			log.info( "getMegapolis > " + megapolisInfo );
			return JSONObject.parseObject( JSONObject.toJSONString( megapolisServ.getMegapolis( megapolisInfo ) ) ).getString( flag );
		} catch ( Exception e ) {
			e.printStackTrace();
			log.error( "getMegapolis has error:" + e.getMessage() );
			return "Error";
		}
	}

	/**
	 * 用的Megapolis表
	 */

	@RequestMapping(value = "/setMegapolis", method = RequestMethod.POST)
	public String setGameVer ( HttpServletRequest request ) {
		try {
			MegapolisInfo megapolisInfo = JSONObject.parseObject( new JsonUtil().Map2String( request.getParameterMap() ), MegapolisInfo.class );
			log.info( "setMegapolis > " + megapolisInfo );
			return String.valueOf( megapolisServ.setMegapolis( megapolisInfo ) );
		} catch ( Exception e ) {
			e.printStackTrace();
			log.error( "setMegapolis has error:" + e.getMessage() );
			return "Error";
		}
	}

	/**
	 * 用的Megapolis表
	 */

	@RequestMapping(value = "/count", method = RequestMethod.POST)
	public String count ( ) {
		try {
			log.info( "count" );
			return String.valueOf( megapolisServ.count() );
		} catch ( Exception e ) {
			e.printStackTrace();
			log.error( "count has error:" + e.getMessage() );
			return "Error";
		}
	}

	/**
	 * 用的Gift表
	 */

	@RequestMapping(value = "/getRunning", method = RequestMethod.POST)
	public String getRunning ( ) {
		try {
			log.info( "getRunning" );
			return giftServ.getRunning();
		} catch ( Exception e ) {
			e.printStackTrace();
			log.error( "getRunning has error:" + e.getMessage() );
			return "Error";
		}
	}

	/**
	 * 用的Gift表
	 */

	@RequestMapping(value = "/setRunning", method = RequestMethod.POST)
	public String setRunning ( HttpServletRequest request ) {
		try {
			Gift gift = JSONObject.parseObject( new JsonUtil().Map2String( request.getParameterMap() ), Gift.class );
			log.info( "setRunning > " + gift );
			return String.valueOf( giftServ.setRunning( gift ) );
		} catch ( Exception e ) {
			e.printStackTrace();
			log.error( "setRunning has error:" + e.getMessage() );
			return "Error";
		}
	}

	/**
	 * 用的Gift表
	 */

	@RequestMapping(value = "/delRunningAll", method = RequestMethod.POST)
	public String delRunningAll ( ) {
		try {
			log.info( "delRunningAll" );
			return String.valueOf( giftServ.delRunningAll() );
		} catch ( Exception e ) {
			e.printStackTrace();
			log.error( "delRunningAll has error:" + e.getMessage() );
			return "Error";
		}
	}

	/**
	 * 用的Gift表
	 */

	@RequestMapping(value = "/delRunning", method = RequestMethod.POST)
	public String delRunning ( HttpServletRequest request ) {
		try {
			Gift gift = JSONObject.parseObject( new JsonUtil().Map2String( request.getParameterMap() ), Gift.class );
			log.info( "delRunning > " + gift );
			return String.valueOf( giftServ.setRunning( gift ) );
		} catch ( Exception e ) {
			e.printStackTrace();
			log.error( "delRunning has error:" + e.getMessage() );
			return "Error";
		}
	}

	/**
	 * 用的Quest表
	 */

	@RequestMapping(value = "/getQuest", method = RequestMethod.POST)
	public String getQuest ( HttpServletRequest request ) {
		try {
			Quest quest = JSONObject.parseObject( new JsonUtil().Map2String( request.getParameterMap() ), Quest.class );
			log.info( "getQuest > " + quest );
			return questServ.getQuest( quest );
		} catch ( Exception e ) {
			e.printStackTrace();
			log.error( "getQuest has error:" + e.getMessage() );
			return "Error";
		}
	}

	/**
	 * 用的Quest表
	 */

	@RequestMapping(value = "/setQuest", method = RequestMethod.POST)
	public String setQuest ( HttpServletRequest request ) {
		try {
			Quest quest = JSONObject.parseObject( new JsonUtil().Map2String( request.getParameterMap() ), Quest.class );
			log.info( "setQuest > " + quest );
			return String.valueOf( questServ.setQuest( quest ) );
		} catch ( Exception e ) {
			e.printStackTrace();
			log.error( "setQuest has error:" + e.getMessage() );
			return "Error";
		}
	}


	/**
	 * 用的Switch表
	 */

	@RequestMapping(value = "/getSwitchAll", method = RequestMethod.POST)
	public ResponseData getSwitchAll ( ) {
		ResponseData result = new ResponseData( ResponseCode.SUCCESS, ResponseCode.SUCCESS_DESC );
		try {
			log.info( "getSwitchAll" );
			result.setData( switchServ.getSwitchAll() );
		} catch ( Exception e ) {
			e.printStackTrace();
			log.error( "getSwitchAll has error:" + e.getMessage() );
			result = new ResponseData( ResponseCode.ERROR, ResponseCode.ERROR_DESC );
			result.setData( "getSwitchAll has error" );
		}
		return result;
	}

	/**
	 * 用的Switch表
	 */

	@RequestMapping(value = "/getSwitch", method = RequestMethod.POST)
	public ResponseData getSwitch ( HttpServletRequest request ) {
		ResponseData result = new ResponseData( ResponseCode.SUCCESS, ResponseCode.SUCCESS_DESC );
		try {
			SwitchInfo switchInfo = JSONObject.parseObject( new JsonUtil().Map2String( request.getParameterMap() ), SwitchInfo.class );
			log.info( "getSwitch > " + switchInfo );
			result.setData( switchServ.getSwitch( switchInfo ) );
		} catch ( Exception e ) {
			e.printStackTrace();
			log.error( "getSwitch has error:" + e.getMessage() );
			result = new ResponseData( ResponseCode.ERROR, ResponseCode.ERROR_DESC );
			result.setData( "getSwitch has error" );
		}
		return result;
	}

	/**
	 * 用的Switch表
	 */

	@RequestMapping(value = "/setSwitch", method = RequestMethod.POST)
	public ResponseData setSwitch ( HttpServletRequest request ) {
		ResponseData result = new ResponseData( ResponseCode.SUCCESS, ResponseCode.SUCCESS_DESC );
		try {
			SwitchInfo switchInfo = JSONObject.parseObject( new JsonUtil().Map2String( request.getParameterMap() ), SwitchInfo.class );
			log.info( "setSwitch > " + switchInfo );
			result.setData( switchServ.setSwitch( switchInfo ) );
		} catch ( Exception e ) {
			e.printStackTrace();
			log.error( "setSwitch has error:" + e.getMessage() );
			result = new ResponseData( ResponseCode.ERROR, ResponseCode.ERROR_DESC );
			result.setData( "setSwitch has error" );
		}
		return result;
	}

	/**
	 * 用的Switch表
	 */

	@RequestMapping(value = "/addSwitch", method = RequestMethod.POST)
	public ResponseData addSwitch ( HttpServletRequest request ) {
		ResponseData result = new ResponseData( ResponseCode.SUCCESS, ResponseCode.SUCCESS_DESC );
		try {
			SwitchInfo switchInfo = JSONObject.parseObject( new JsonUtil().Map2String( request.getParameterMap() ), SwitchInfo.class );
			log.info( "addSwitch > " + switchInfo );
			result.setData( switchServ.addSwitch( switchInfo ) );
		} catch ( Exception e ) {
			e.printStackTrace();
			log.error( "addSwitch has error:" + e.getMessage() );
			result = new ResponseData( ResponseCode.ERROR, ResponseCode.ERROR_DESC );
			result.setData( "addSwitch has error" );
		}
		return result;
	}
}
