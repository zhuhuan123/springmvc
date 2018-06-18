package stdemo;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.std.dao.UserMapper;
import com.std.model.User;

import java.io.*;
import java.util.List;

import junit.framework.TestCase;

public class TestMapper extends TestCase {
	/**
	 * 自动扫描文件的操作，不涉及spring
	 */
	public void test() {
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		try {
			InputStream  in = Resources.getResourceAsStream("mybatis-config.xml");
			SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(in);
			SqlSession sqlSession =sqlSessionFactory.openSession();
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			List<User> list = userMapper.findByUser();
			for(User u:list) {
				System.out.println(u);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
