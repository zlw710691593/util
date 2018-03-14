package com.twohai.util;

import java.beans.PropertyVetoException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@SuppressWarnings("resource")
public class DemoC3p0 {
	private static ComboPooledDataSource datasource;
   static{
	   //配置文件只需要读一次，写在静态代码块
	   //静态方法每调用一次，执行一次，io
	   File file = new File("F:/Eclipse/works/2H_TAXI/src/com/twohai/util/db.properti");
	   Map<String, String> map =null;
	   try {
		BufferedReader buffReader = new BufferedReader(new FileReader(file));
		String line=null;//保存的是每一行读取的内容
		map= new HashMap<String,String>();
		while((line=buffReader.readLine())!=null){
			//driver=com.mysql.jdbc.Driver,存在map中
			String[] split = line.split("=");
			map.put(split[0], split[1]);
		}
	   
	   } catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   	datasource=new ComboPooledDataSource();
		//最小连接池数量
		datasource.setMinPoolSize(Integer.parseInt(map.get("min")));
		//最大连接池数量
		datasource.setMaxPoolSize(Integer.parseInt(map.get("max")));
		//初始化连接池数量
		datasource.setInitialPoolSize(Integer.parseInt(map.get("init")));
		//连接不够时，每次创建三个连接
		datasource.setAcquireIncrement(Integer.parseInt(map.get("increment")));
		//???1.驱动2.url,3.username4.password
		try {
			datasource.setDriverClass(map.get("driver"));
			datasource.setJdbcUrl(map.get("url"));
			datasource.setUser(map.get("username"));
			datasource.setPassword(map.get("password"));
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
	   
	   
   }
	//连接池：动态的修改连接数量，缓存，提高效率
	//c3p0,dbcp(aphache),druid阿里巴巴aa
	
	static{
		
	}
	//通过这个方法获得连接对象
	public static Connection getConnection(){
		Connection conn=null;
		try {
			conn = datasource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
		
	//关闭资源的功能，负责管理连接，通过的方法，query，update
	public static void close(Statement stmt,ResultSet rs,Connection conn){
			//1.先关闭rs
			//2.关闭适配器
			//3.关闭连接
		//做一个安全防护，为空的时候关闭会报错
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(stmt!=null){
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	
		
		
		

}
