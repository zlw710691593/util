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
	   //�����ļ�ֻ��Ҫ��һ�Σ�д�ھ�̬�����
	   //��̬����ÿ����һ�Σ�ִ��һ�Σ�io
	   File file = new File("F:/Eclipse/works/2H_TAXI/src/com/twohai/util/db.properti");
	   Map<String, String> map =null;
	   try {
		BufferedReader buffReader = new BufferedReader(new FileReader(file));
		String line=null;//�������ÿһ�ж�ȡ������
		map= new HashMap<String,String>();
		while((line=buffReader.readLine())!=null){
			//driver=com.mysql.jdbc.Driver,����map��
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
		//��С���ӳ�����
		datasource.setMinPoolSize(Integer.parseInt(map.get("min")));
		//������ӳ�����
		datasource.setMaxPoolSize(Integer.parseInt(map.get("max")));
		//��ʼ�����ӳ�����
		datasource.setInitialPoolSize(Integer.parseInt(map.get("init")));
		//���Ӳ���ʱ��ÿ�δ�����������
		datasource.setAcquireIncrement(Integer.parseInt(map.get("increment")));
		//???1.����2.url,3.username4.password
		try {
			datasource.setDriverClass(map.get("driver"));
			datasource.setJdbcUrl(map.get("url"));
			datasource.setUser(map.get("username"));
			datasource.setPassword(map.get("password"));
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
	   
	   
   }
	//���ӳأ���̬���޸��������������棬���Ч��
	//c3p0,dbcp(aphache),druid����Ͱ�aa
	
	static{
		
	}
	//ͨ���������������Ӷ���
	public static Connection getConnection(){
		Connection conn=null;
		try {
			conn = datasource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
		
	//�ر���Դ�Ĺ��ܣ�����������ӣ�ͨ���ķ�����query��update
	public static void close(Statement stmt,ResultSet rs,Connection conn){
			//1.�ȹر�rs
			//2.�ر�������
			//3.�ر�����
		//��һ����ȫ������Ϊ�յ�ʱ��رջᱨ��
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
