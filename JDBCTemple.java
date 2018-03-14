package com.twohai.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class JDBCTemple {

	//»Øµ÷º¯Êý
	public static void query(String sql,ParamSeter paramSet,ResultSeter rseter) throws SQLException{
		Connection conn = DemoC3p0.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		paramSet.setValue(pstmt);
		ResultSet rs = pstmt.executeQuery();
		rseter.handler(rs);
		DemoC3p0.close(pstmt, rs, conn);
	}
	public static int upDate(String sql
//			,ParamSeter paramSet
			) throws Exception{
		Connection conn = DemoC3p0.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
//		paramSet.setValue(pstmt);
		int rs= pstmt.executeUpdate();
		pstmt.close();
		conn.close();
		return rs;
		}
}
