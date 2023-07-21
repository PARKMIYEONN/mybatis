package board.dao;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyConfig {
	
	   //session을 이용해서 select update delete 등을 실행하게 해준다 
	private SqlSession session;
	
	public MyConfig() {
		String resource = "mybatis-config.xml";
		try {
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		session = sqlSessionFactory.openSession();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	   // 넘겨줘야 하는애 있어야 하니 getInstanse 메소드 하나 만들어준다
	public SqlSession getInstance() {
		return session;
	}

}
