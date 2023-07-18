package com.sv.serv.dao.impl;

import com.sv.serv.common.MysqlUtil;
import com.sv.serv.dao.SvAuthMapper;
import com.sv.serv.model.SvAuth;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


@Repository
@Lazy()
public class SvAuthMapperImpl implements SvAuthMapper {
	public String login ( SvAuth svAuth ) throws Exception {
		Connection conn = new MysqlUtil().open();
		Statement stmt = conn.createStatement();
		String sql = "SELECT count(*) total FROM svAuth WHERE adminName = '" + svAuth.getAdminName() + "' AND passWord = '" + svAuth.getPassWord() + "'";
		ResultSet rs = stmt.executeQuery( sql );
		rs.next();
		stmt.close();
		conn.close();
		return String.valueOf( rs.getInt( "total" ) );
	}


}
