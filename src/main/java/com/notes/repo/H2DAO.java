package com.notes.repo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.notes.util.DBUtil;

@Component
public class H2DAO {

	@Autowired
	private DBUtil dbUtil;
	
	public void initDB() {
		Connection con = null;
		Statement st = null;
		try {
			if(con == null)
				con = dbUtil.getConnetion();
			
			st = con.createStatement();
			
			StringBuilder sb = new StringBuilder();
			FileInputStream fis = new FileInputStream("sql/data.sql");
            Scanner sc = new Scanner(fis);
            while(sc.hasNextLine())
            	sb.append(sc.nextLine());
            sc.close();
			
            st.execute(sb.toString());
            
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if(con!=null && st != null) {
					con.close();
					st.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
