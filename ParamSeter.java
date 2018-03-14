package com.twohai.util;

import java.sql.PreparedStatement;

//用于处理占位符赋值
public interface ParamSeter {

	
	public void setValue(PreparedStatement stament);
}
