package com.sv.serv.controller;


import com.alibaba.fastjson.JSONObject;
import com.sv.serv.common.JsonUtil;
import com.sv.serv.common.ResponseCode;
import com.sv.serv.common.ResponseData;
import com.sv.serv.model.SvData;
import com.sv.serv.service.SvDataServImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Saint on 2017/2/9.
 */

@RestController
@RequestMapping("/ctrl")
public class ManageController {

	private static final Logger log = LogManager.getLogger( "control" );
	@Autowired
	private SvDataServImpl svDataServ;


	@RequestMapping(value = "/Health", method = RequestMethod.GET)
	public String Health ( ) {
		return "OK";
	}

	/**
	 * 注册接口
	 */
	@RequestMapping(value = "/Reg", method = RequestMethod.POST)
	public ResponseData Reg ( HttpServletRequest request ) {
		String pw = request.getHeader( "sv" );
		ResponseData result = new ResponseData( ResponseCode.SUCCESS, ResponseCode.SUCCESS_DESC );
		try {
			if ( pw.equals( "Wp2Sy1314@87881217" ) ) {
				SvData svData = JSONObject.parseObject( new JsonUtil().Map2String( request.getParameterMap() ), SvData.class );
				MessageDigest md = MessageDigest.getInstance( "MD5" );// 生成一个MD5加密计算摘要
				md.update( ( svData.getQqNum() + System.currentTimeMillis() / 1000 ).getBytes() );// 计算md5函数
                /*
                  digest()最后确定返回md5 hash值，返回值为8位字符串。
                  因为md5 hash值是16位的hex值，实际上就是8位的字符
                  BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
                  一个byte是八位二进制，也就是2位十六进制字符（2的8次方等于16的2次方）
                 */
				String authCode = new BigInteger( 1, md.digest() ).toString( 16 );
				authCode = authCode.replace( "+", "" ).replace( "-", "" ).replace( "/", "" ).replace( "_", "" ).replace( "=", "" ).replace( "*", "" );
				authCode = authCode.toUpperCase();
				svData.setAuthCode( authCode );
				int a = Integer.parseInt( svData.getGame() );
				switch ( a ) {
					case 1 -> svData.setGame( "EF" );
					case 2 -> svData.setGame( "MSI" );
					default -> svData.setGame( "no" );
				}
				log.info( "Reg data is:" + svData );
				svDataServ.reg( svData );
				result.setData( authCode );
			} else {
				result.setRetCode( "11111" );
				result.setRetInfo( "Wrong AuthKey." );
				log.info( "Reg has wrong AuthKey" );
			}
		} catch ( Exception e ) {
			result.setRetCode( "11111" );
			result.setRetInfo( "Wrong AuthKey." );
			e.printStackTrace();
			log.error( "Reg has error > " + e.getMessage() );
		}
		return result;
	}

	/**
	 * 修改接口
	 */
	@RequestMapping(value = "/RegEdit", method = RequestMethod.POST)
	public ResponseData RegEdit ( HttpServletRequest request ) {
		String pw = request.getHeader( "sv" );
		ResponseData result = new ResponseData( ResponseCode.SUCCESS, ResponseCode.SUCCESS_DESC );
		try {
			if ( pw.equals( "Wp2Sy1314@87881217" ) ) {
				SvData svData = JSONObject.parseObject( new JsonUtil().Map2String( request.getParameterMap() ), SvData.class );
				svData.setUpdateDt( String.valueOf( new Date().getTime() / 1000 ) );
				log.info( "RegEdit data is:" + svData );
				if ( svDataServ.update( svData ) > 0 ) {
					result.setRetCode( "00000" );
					result.setRetInfo( "SUCCESS" );
					result.setData( "OK" );
					log.info( "RegEdit has SUCCESS" );
				} else {
					result.setRetCode( "11111" );
					result.setRetInfo( "FAIL" );
					log.info( "RegEdit has FAIL" );
				}
			} else {
				result.setRetCode( "11111" );
				result.setRetInfo( "Wrong AuthKey." );
				log.info( "RegEdit has wrong AuthKey" );
			}
		} catch ( Exception e ) {
			result.setRetCode( "11111" );
			result.setRetInfo( "OY." );
			e.printStackTrace();
			log.error( "RegEdit has error > " + e.getMessage() );
		}
		return result;
	}

	/**
	 * 通过KEY查询信息
	 */
	@RequestMapping(value = "/SeaRegK", method = RequestMethod.POST)
	public ResponseData SeaRegK ( HttpServletRequest request ) {
		String pw = request.getHeader( "sv" );
		ResponseData result = new ResponseData( ResponseCode.SUCCESS, ResponseCode.SUCCESS_DESC );
		try {
			if ( pw.equals( "Wp2Sy1314@87881217" ) ) {
				SvData svData = JSONObject.parseObject( new JsonUtil().Map2String( request.getParameterMap() ), SvData.class );
				if ( svData.getAuthCode() == null || svData.getAuthCode().length() <= 0 ) {
					result = new ResponseData( "11111", "Wrong Key." );
					result.setData( "ERROR" );
					return result;
				}
				log.info( "SeaRegK param is > " + svData );
				List<SvData> list = svDataServ.search( svData );
				if ( list.isEmpty() ) {
					result = new ResponseData( "11111", "No Result." );
					result.setData( "ERROR" );
				} else {
					result.setData( list.get( 0 ) );
				}
			} else {
				result = new ResponseData( "11111", "Wrong AuthKey." );
				result.setData( "ERROR" );
			}
		} catch ( Exception e ) {
			e.printStackTrace();
			log.error( "SeaRegK has error:" + e.getMessage() );
			result = new ResponseData( ResponseCode.ERROR, ResponseCode.ERROR_DESC );
			result.setData( "ERROR" );
		}
		return result;
	}

	/**
	 * 通过QQ查询信息
	 */
	@RequestMapping(value = "/SeaRegQ", method = RequestMethod.POST)
	public ResponseData SeaRegQ ( HttpServletRequest request ) {
		String pw = request.getHeader( "sv" );
		ResponseData result = new ResponseData( ResponseCode.SUCCESS, ResponseCode.SUCCESS_DESC );
		try {
			if ( pw.equals( "Wp2Sy1314@87881217" ) ) {
				SvData svData = JSONObject.parseObject( new JsonUtil().Map2String( request.getParameterMap() ), SvData.class );
				if ( svData.getQqNum() == null || svData.getQqNum().length() <= 0 ) {
					result = new ResponseData( "11111", "Wrong QQ." );
					result.setData( "ERROR" );
					return result;
				}
				log.info( "SeaRegQ param is > " + svData );
				List<SvData> list = svDataServ.search( svData );
				if ( list.isEmpty() ) {
					result = new ResponseData( "11111", "No Result." );
					result.setData( "ERROR" );
				} else {
					result.setData( list );
				}
			} else {
				result = new ResponseData( "11111", "Wrong AuthKey." );
				result.setData( "ERROR" );
			}
		} catch ( Exception e ) {
			e.printStackTrace();
			log.error( "SeaRegQ has error:" + e.getMessage() );
			result = new ResponseData( ResponseCode.ERROR, ResponseCode.ERROR_DESC );
			result.setData( "ERROR" );
		}
		return result;
	}

	/**
	 * 删除注册信息
	 */
	//20171224091841,20181220091841,1518585081,355060010302300,0:0,5694462221514090044
	@RequestMapping(value = "/UnReg", method = RequestMethod.POST)
	public ResponseData UnReg ( HttpServletRequest request ) {
		String pw = request.getHeader( "sv" );
		ResponseData result = new ResponseData( ResponseCode.SUCCESS, ResponseCode.SUCCESS_DESC );
		try {
			if ( pw.equals( "Wp2Sy1314@87881217" ) ) {
				SvData svData = JSONObject.parseObject( new JsonUtil().Map2String( request.getParameterMap() ), SvData.class );
				if ( svData.getAuthCode().length() <= 0 ) {
					result = new ResponseData( "11111", "Wrong Key." );
					result.setData( "ERROR" );
					return result;
				}
				if ( svDataServ.delete( svData ) > 0 ) {
					result.setData( "OK." );
				} else {
					result.setRetCode( "11111" );
					result.setRetInfo( "FAIL." );
				}
			} else {
				result.setRetCode( "11111" );
				result.setRetInfo( "Wrong AuthKey." );
			}
		} catch ( Exception e ) {
			result.setRetCode( "11111" );
			result.setRetInfo( "Wrong." );
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 统计总收入
	 */
	@RequestMapping(value = "/CouA", method = RequestMethod.POST)
	public ResponseData CouA ( HttpServletRequest request ) {
		String pw = request.getHeader( "sv" );
		ResponseData result = new ResponseData( ResponseCode.SUCCESS, ResponseCode.SUCCESS_DESC );
		try {
			if ( pw.equals( "Wp2Sy1314@87881217" ) ) {
				List<SvData> LsvData = svDataServ.countAll();
				if ( LsvData == null ) {
					result.setRetCode( "11111" );
					result.setRetInfo( "No Result." );
				} else {
					long totalPrice = 0;
					for ( SvData svData : LsvData ) {
						totalPrice = totalPrice + svData.getPrice();
					}
					result.setData( totalPrice );
				}
			} else {
				result.setRetCode( "11111" );
				result.setRetInfo( "Wrong AuthKey." );
			}
		} catch ( Exception e ) {
			result.setRetCode( "11111" );
			result.setRetInfo( "Wrong." );
			e.printStackTrace();
		}
		return result;
	}


	/**
	 * 辅助登录接口
	 */
	@RequestMapping(value = "/LogInTwo", method = RequestMethod.GET)
	public String LogInTwo ( HttpServletRequest request ) {
		return auth1( request.getParameter( "k" ), request.getParameter( "d" ), request.getParameter( "ip" ), request.getParameter( "ver" ), request.getParameter( "g" ) );
	}

	private String auth1 ( String k, String d, String ip, String ver, String game ) {
		try {
			if ( k == null || k.length() <= 0 ) {
				k = "00000000000000000000";
			} else {
				k = k.replace( " ", "" );
				k = k.replace( "\\r", "" );
				k = k.replace( "\\n", "" );
				k = k.replace( "\\t", "" );
				k = k.toUpperCase();
			}
			if ( d == null || d.length() <= 0 ) {
				d = "0";
			}
			if ( ip == null || ip.length() <= 0 ) {
				ip = "0";
			}
			if ( ver == null || ver.length() <= 0 ) {
				ver = "0";
			}
			if ( game == null || game.length() <= 0 ) {
				game = "EF";
			} else {
				int a = Integer.parseInt( game );
				switch ( a ) {
					case 1 -> game = "EF";
					case 2 -> game = "MSI";
					default -> game = "no";
				}
			}
			SvData svData = new SvData( "", k, "", "", "", "", 999999, "", "", "" );
			List<SvData> list = svDataServ.search( svData );
			if ( list.isEmpty() ) {
				return "997-0";
			} else {
				SvData svData1 = list.get( 0 );
				svData1.setUpdateDt( String.valueOf( new Date().getTime() / 1000 ) );
				if ( !svData1.getGame().equals( game ) ) {
					return "996-0";
				}
				SimpleDateFormat df = new SimpleDateFormat( "yyyyMMddHHmmss" );//设置日期格式

				long nDate, start, end;
				nDate = new Date().getTime() / 1000;
				start = df.parse( svData1.getStartDt() ).getTime() / 1000;
				end = df.parse( svData1.getEndDt() ).getTime() / 1000;
				if ( nDate >= start && nDate <= end ) {
					svData1.setPrice( 0 );
					svData1.setDevice( d );
					svData1.setLocalIp( ip );
					svData1.setVersion( ver );
					svDataServ.update( svData1 );//更新数据的时间
					int day = Long.valueOf( ( end - nDate ) / ( 60 * 60 * 24 ) ).intValue();
					return "100-" + day;
				} else {
					return "101-0";
				}
			}
		} catch ( Exception e ) {
			e.printStackTrace();
			return "998-0";
		}
	}

	/**
	 * 辅助登出接口
	 */
	@RequestMapping(value = "/IsLogOutTwo", method = RequestMethod.GET)
	public String IsLogOutTwo ( HttpServletRequest request ) {
		String k = request.getParameter( "k" );
		String d = request.getParameter( "d" );
		return ILO1( k, d );
	}

	private String ILO1 ( String k, String d ) {
		if ( k == null || k.length() <= 0 ) {
			k = "00000000000000000000";
		} else {
			k = k.toUpperCase();
		}
		if ( d == null || d.length() <= 0 ) {
			d = "0";
		}
		SvData svData = new SvData();
		svData.setAuthCode( k );
		svData.setDevice( "" );
		try {
			List<SvData> list = svDataServ.search( svData );
			if ( list.get( 0 ).getDevice().equals( d ) ) {
				return "100";
			} else {
				return "101";
			}
		} catch ( Exception e ) {
			return "101";
		}
	}
}
