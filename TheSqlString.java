package com.twohai.util;

import java.util.Date;

public class TheSqlString {
	public static String selectAllCar(){
		String sql="SELECT t_car.id,model,t_comments,t_brand.name,brand_id,t_category.name,category_id,rent,status from (t_car INNER JOIN t_brand ON t_car.brand_id=t_brand.id INNER JOIN t_category ON t_category.id=t_car.category_id) where useable='0'";
		return sql;
	}
	public static String selectTheCar(){
		String sql="SELECT t_car.id,model,t_comments,t_brand.name,brand_id,t_category.name,category_id,rent,status from t_car INNER JOIN t_brand ON t_car.brand_id=t_brand.id INNER JOIN t_category ON t_category.id=t_car.category_id where t_car.id=? and useable='0'";
		return sql;
	}
	public static String selectTheCar1(){
		String sql="SELECT t_car.id,model,t_comments,t_brand.name,brand_id,t_category.name,category_id,rent,status from t_car INNER JOIN t_brand ON t_car.brand_id=t_brand.id INNER JOIN t_category ON t_category.id=t_car.category_id INNER JOIN t_record on t_record.car_id=t_car.id INNER JOIN t_user on t_user.id=t_record.user_id where t_car.id=? and useable='0' and t_record.user_id=? AND return_date IS NULL";
		return sql;
	}
	public static String adminSelectTheCar(){
		String sql="SELECT t_car.id,model,t_comments,t_brand.name,brand_id,t_category.name,category_id,rent,status,useable from t_car INNER JOIN t_brand ON t_car.brand_id=t_brand.id INNER JOIN t_category ON t_category.id=t_car.category_id where t_car.id=?";
		return sql;
	}
	public static String selectUserNameAndPassword(){
		String sql="select username,password,id,type from t_user where username=? And password=? and type='0'";
		return sql;
	}
	public static String selectUserNameAndPassword1(){
		String sql="select username,password,id,type from t_user where username=? And password=? and type='1'";
		return sql;
	}
	public static String selectUser(){
		String sql="select * from user where type=0";
		return sql;
	}
	public static String selectUserName(){
		String sql="select username from t_user where username=?";
		return sql;
	}
	public static String updateUserNameAndPassword(String name, String password,String sex,String id_number,String tel,String addr){
	String sql="insert into t_user(username,password,sex,id_number,tel,addr,type) values('"+name+"','"+password+"','"+sex+"','"+id_number+"','"+tel+"','"+addr+"',"+0+")";
	return sql;
	}
	public static String selectBrand(){
		String sql="select * from t_brand";
		return sql;
	}
	public static String selectTheCarforBrand(){
		String sql="SELECT t_car.id,model,t_comments,t_brand.name,brand_id,t_category.name,category_id,rent,status from t_car INNER JOIN t_brand ON t_car.brand_id=t_brand.id INNER JOIN t_category ON t_category.id=t_car.category_id where brand_id=? and useable='0'";
		return sql;
	}
	public static String adminSelectTheCarforBrand(){
		String sql="SELECT t_car.id,model,t_comments,t_brand.name,brand_id,t_category.name,category_id,rent,status,useable from t_car INNER JOIN t_brand ON t_car.brand_id=t_brand.id INNER JOIN t_category ON t_category.id=t_car.category_id where brand_id=?";
		return sql;
	}
	public static String selectTheCarforCategory(){
		String sql="SELECT t_car.id,model,t_comments,t_brand.name,brand_id,t_category.name,category_id,rent,status from t_car INNER JOIN t_brand ON t_car.brand_id=t_brand.id INNER JOIN t_category ON t_category.id=t_car.category_id where category_id=? and useable='0'";
		return sql;
	}
	public static String adminSelectTheCarforCategory(){
		String sql="SELECT t_car.id,model,t_comments,t_brand.name,brand_id,t_category.name,category_id,rent,status,useable from t_car INNER JOIN t_brand ON t_car.brand_id=t_brand.id INNER JOIN t_category ON t_category.id=t_car.category_id where category_id=?";
		return sql;
	}
	public static String selectCategory(){
		String sql="select * from t_category";
		return sql;
	}
	public static String selectUserid(){
		String sql="select id from t_user where username=?";
		return sql;
	}
	public static String selectUserRecord(){
		String sql="SELECT t_record.id,t_car.id,model,t_user.id,t_user.username,rent,rent*(return_date-start_date),t_comments,t_brand.name,t_category.name,start_date,return_date FROM (t_car INNER JOIN t_brand ON t_car.brand_id=t_brand.id INNER JOIN t_category ON t_category.id=t_car.category_id INNER JOIN t_record ON t_record.car_id=t_car.id INNER JOIN t_user ON t_user.id=t_record.user_id) where t_record.user_id=?";
		return sql;
	}
	public static String selectCarRecord(){
		String sql="SELECT t_record.id,t_car.id,model,rent,t_comments,t_brand.name,t_category.name,start_date,return_date FROM (t_car INNER JOIN t_brand ON t_car.brand_id=t_brand.id INNER JOIN t_category ON t_category.id=t_car.category_id INNER JOIN t_record ON t_record.car_id=t_car.id INNER JOIN t_user ON t_user.id=t_record.user_id) where t_car.id=?";
		return sql;
	}
	public static String selectAllCarOrderByRentAsc(){
		String sql="SELECT t_car.id,model,t_comments,t_brand.name,brand_id,t_category.name,category_id,rent,status from (t_car INNER JOIN t_brand ON t_car.brand_id=t_brand.id INNER JOIN t_category ON t_category.id=t_car.category_id) where useable='0' GROUP BY rent ";
		return sql;
	}
	public static String adminSelectAllCarOrderByRentAsc(){
		String sql="SELECT t_car.id,model,t_comments,t_brand.name,brand_id,t_category.name,category_id,rent,status,useable from (t_car INNER JOIN t_brand ON t_car.brand_id=t_brand.id INNER JOIN t_category ON t_category.id=t_car.category_id) GROUP BY rent";
		return sql;
	}
	public static String selectAllCarOrderByRentDesc(){
		String sql="SELECT t_car.id,model,t_comments,t_brand.name,brand_id,t_category.name,category_id,rent,status from (t_car INNER JOIN t_brand ON t_car.brand_id=t_brand.id INNER JOIN t_category ON t_category.id=t_car.category_id) where useable='0' GROUP BY rent DESC";
		return sql;
	}
	public static String adminSelectAllCarOrderByRentDesc(){
		String sql="SELECT t_car.id,model,t_comments,t_brand.name,brand_id,t_category.name,category_id,rent,status,useable from (t_car INNER JOIN t_brand ON t_car.brand_id=t_brand.id INNER JOIN t_category ON t_category.id=t_car.category_id) GROUP BY rent DESC";
		return sql;
	}
	public static String insertRecord(int user_id,int car_id){
		String sql="INSERT INTO t_record(user_id,car_id,start_date) VALUES('"+user_id+"','"+car_id+"',now())";
		return sql;
	}
	public static String updateRecord(int car_id,int user_id){
		String sql="update t_record SET return_date=now() WHERE return_date IS NULL and car_id='"+car_id+"' and user_id='"+user_id+"'";
		return sql;
	}
	public static String updateRecord2(int car_id){
		String sql="update t_record INNER JOIN t_car ON t_car.id=car_id SET payment=rent*(return_date-start_date) WHERE  car_id='"+car_id+"'";
		return sql;
	}
	public static String updateCarStatuON(int id){
		String sql="UPDATE t_car SET status='·ñ' WHERE id='"+id+"'";
		return sql;
		}
	public static String updateCarStatuOFF(int id){
		String sql="UPDATE t_car SET status='ÊÇ' WHERE id='"+id+"'";
		return sql;
		}
	public static String selectReturnCar(){
		String sql="SELECT t_car.id,model,rent,rent*(return_date-start_date),t_comments,t_brand.name,t_category.name,start_date,return_date FROM (t_car INNER JOIN t_brand ON t_car.brand_id=t_brand.id INNER JOIN t_category ON t_category.id=t_car.category_id INNER JOIN t_record ON t_record.car_id=t_car.id INNER JOIN t_user ON t_user.id=t_record.user_id) where t_car.id=? AND t_user.id=?";
		return sql;
	}
	public static String adminSelectAllCar(){
		String sql="SELECT t_car.id,model,t_comments,t_brand.name,brand_id,t_category.name,category_id,rent,status,useable from (t_car INNER JOIN t_brand ON t_car.brand_id=t_brand.id INNER JOIN t_category ON t_category.id=t_car.category_id)";
		return sql;
	}
	public static String adminInsertCar(int brand_id,int category_id,String model,String car_number,String t_comments,String color,float price, float rent,String status,int userable){
		String sql="insert into t_car(car_number,brand_id,model,color,category_id,t_comments,price,rent,status,useable) values('"+car_number+"','"+brand_id+"','"+model+"','"+color+"','"+category_id+"','"+t_comments+"','"+price+"','"+rent+"','"+status+"','"+userable+"')";
		return sql;
	}
	public static String adminUpdateRent(float rent,int car_id){
		String sql="update t_car set rent='"+rent+"' where id='"+car_id+"'";
		return sql;
	}
	public static String adminUpdateUseable(int useable,int car_id){
		String sql="update t_car set useable='"+useable+"' where id='"+car_id+"'";
		return sql;
	}
	public static String selectAllRecord(){
		String sql="SELECT t_record.id,t_car.id,model,t_user.id,t_user.username,rent,rent*(return_date-start_date),t_comments,t_brand.name,t_category.name,start_date,return_date FROM (t_car INNER JOIN t_brand ON t_car.brand_id=t_brand.id INNER JOIN t_category ON t_category.id=t_car.category_id INNER JOIN t_record ON t_record.car_id=t_car.id INNER JOIN t_user ON t_user.id=t_record.user_id)";
		return sql;
	}
}
