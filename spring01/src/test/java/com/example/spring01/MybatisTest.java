package com.example.spring01;

//import static org.junit.Assert.fail;
import java.util.logging.Logger;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class MybatisTest {

	//로깅	
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(MybatisTest.class);
	
	//의존관계 주입	
	@Inject
	private SqlSessionFactory sqlFactory;
	
	//test 코드 
	@Test
	public void testFactory() {
//		fail("Not yet implemented");
		logger.info("sqlFactory:"+sqlFactory);
	}

	@Test
	public void testSession() {
//		fail("Not yet implemented");
		try(SqlSession sqlSession = sqlFactory.openSession()){
			logger.info("sqlFactory:"+sqlFactory);
			logger.info("mybatis 연결 성공");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}