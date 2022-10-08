package com.notes.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DBUtil {

	@Autowired
	private DataSource h2DB;
	
	public Connection getConnetion() throws SQLException{
		if(h2DB != null)
			return h2DB.getConnection();
		else
			return null;
	}
	
}
