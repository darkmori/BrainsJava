package com.kosea.kmove30;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisTest {

	public static void main(String[] args) {
		String resource = "mybatis-config.xml"; // src경로

		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

			SqlSession session = sqlSessionFactory.openSession();
			try {
				// Blog blog =
				// session.selectOne("org.mybatis.example.BlogMapper.selectBlog",101);
				// Member member=new Member();
				Member member = session.selectOne("org.mybatis.example.SelectMapper.selectMember", 101);

				System.out.println("회원 아이디: " + member.getPassword());

			} finally {
				session.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
