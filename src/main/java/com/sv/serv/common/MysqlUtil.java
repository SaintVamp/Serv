package com.sv.serv.common;


import java.sql.*;
import java.util.HashMap;

public class MysqlUtil {


	public Connection open ( ) {
		try {
			Class.forName( "com.mysql.cj.jdbc.Driver" );
			String url = "jdbc:mysql://4.0.4.50:7848/SV?useSSL=false";
			String username = "sv";  //数据库用户名
			String password = "sv@8004";//数据库密码
			return DriverManager.getConnection( url, username, password );
		} catch ( ClassNotFoundException | SQLException e ) {
			e.printStackTrace();
			return null;
		}
	}

	public String pub_get ( String sql, String... columns ) throws Exception {
		Connection conn = open();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery( sql );
		StringBuilder r_str = new StringBuilder();
		HashMap<String, String> hashMap = new HashMap<>();
		while ( rs.next() ) {
			for ( String column : columns ) {
				hashMap.put( column, rs.getString( column ) );
				r_str.append( rs.getString( column ) ).append( "," );
			}
		}
		rs.close();
		stmt.close();
		conn.close();
		if ( r_str.length() > 0 ) {
			return r_str.deleteCharAt( r_str.lastIndexOf( "," ) ).toString();
		} else {
			return "";
		}
	}


	public int pub_set ( String sql ) throws Exception {
		Connection conn = open();
		Statement stmt = conn.createStatement();
		int rowcount = stmt.executeUpdate( sql );
		stmt.close();
		conn.close();
		return rowcount;
	}

//
//	public List<SvData> mongoDb ( ) {
//		try {
//			List<SvData> svDataList = new ArrayList<>();
//			MongoClientURI uri = new MongoClientURI( "mongodb://svtool:12086F465CEB74B3BD676C39DA07900C@39.100.245.149:30000/SV" );
//			MongoClient mongoClient = new MongoClient( uri );
//			MongoDatabase mongoDatabase = mongoClient.getDatabase( "SV" );
//			MongoCollection<Document> collection = mongoDatabase.getCollection( "svData" );
//			FindIterable<Document> findIterable = collection.find();
//			for ( Document svDataDoc : findIterable ) {
//				SvData svData = new SvData();
//				svData.setVersion( svDataDoc.getString( "version" ) );
//				svData.setAuthCode( svDataDoc.getString( "authCode" ) );
//				svData.setDevice( svDataDoc.getString( "device" ) );
//				svData.setEndDt( svDataDoc.getString( "endDt" ) );
//				svData.setUpdateDt( svDataDoc.getString( "updateDt" ) );
//				svData.setPrice( svDataDoc.getInteger( "price" ) );
//				svData.setGame( svDataDoc.getString( "game" ) );
//				svData.setStartDt( svDataDoc.getString( "startDt" ) );
//				svData.setLocalIp( svDataDoc.getString( "localIp" ) );
//				svData.setQqNum( svDataDoc.getString( "qqNum" ) );
//				svDataList.add( svData );
//			}
//
//			mongoClient.close();
//			return svDataList;
//		} catch ( Exception e ) {
//			System.err.println( e.getMessage() );
//			return null;
//		}
//	}
}
