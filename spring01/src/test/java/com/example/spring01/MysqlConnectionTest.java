package com.example.spring01;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class MysqlConnectionTest {

	private static final Logger logger = LoggerFactory.getLogger(MysqlConnectionTest.class);
	
	private static final String DRIVER ="com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/spring?autoReconnect=true&serverTimezone=UTC";
	private static final String USER="spring";
	private static final String PW="1234";
	
	@Test // Junit이 테스트 하는 method
	public void test() throws Exception {
	
		Class.forName(DRIVER);//드라이버 로딩 

		//connection = DriverManager.getConnection("jdbc:mysql:주소:포트/DB명" , "username", "password");			
		
		try(Connection conn = DriverManager.getConnection(URL, USER, PW))
			{
				logger.info("mysql 연결 성공");
			}
		 catch(Exception e) {
			e.printStackTrace();
		}
	}
}