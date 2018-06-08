package com.kosea.kmove30;

import java.util.List;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

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
				// 전체조회///
				List<Member> memberList = new ArrayList<Member>();

				memberList = session.selectList("org.mybatis.example.MemberMapper.selectAllMember");
				for (Member member : memberList) {
					String logMessage = member.getId().toString() + " " + member.getPass().toString() + " "
							+ member.getMno();
					member.pringLog(logMessage);
				}

				// Blog blog =
				// session.selectOne("org.mybatis.example.BlogMapper.selectBlog",101);
				// Member member=new Member();
				Member member = (Member) session.selectOne("org.mybatis.example.MemberMapper.selectMember", 102);
				member.pringLog("아이디:" + member.getId() + ", 패스워드:" + member.getPass() + " ,mno: " + member.getMno());
				// System.out.println("회원 번호: " + member.getMno());
				// System.out.println("회원 아이디: " + member.getId());
				// System.out.println("회원 비밀번호: " + member.getPass());
				///////////// 추가///////////////

				// Member newMember = new Member(102, "testID", "1234");

				// Member newMember = new Member();
				// newMember.setMno(105);
				// newMember.setId("광식");
				// newMember.setPass("1234");
				//
				// int insertCount =
				// session.insert("org.mybatis.example.MemberMapper.insertMember", newMember);
				// System.out.println("추가 건수:" + insertCount);

				// /// 수정///
				// String queryMapping = "org.mybatis.example.MemberMapper.updateMember";
				// Member updateMember = new Member(105, "HGDid", "HGDpw");
				// int updateCount = session.update(queryMapping, updateMember);
				// System.out.println("수정 건수:" + updateCount);

				///////////// 삭제///////////////
				// int deleteCount =
				// session.delete("org.mybatis.example.MemberMapper.deleteMember", 101);
				// System.out.println("삭제 건수:" + deleteCount);

			} finally {
				session.commit();
				session.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
