/*
 * grade 테이블을 위한 DTO
 * 첫 칼럼인 seq는 프라이머리 키를 위한 컬럼이므로 DTO에선 사용 안함
 * 
 * ----------------------------------------------------
 * 		public class GradeDto implements Serializable
 * ----------------------------------------------------
 * private String id;
 * private String grade;
 * private String subject;
 * 
 * public GradeDto() //생성자
 * public GradeDto(String id, String grade, String subject) //생성자 오버로딩 - 각값에 받은거 넣어줌.
 * public String getGrade() 			//get-set 모음
 * public void setGrade(String grade)
 * public String getId()
 * public void setId(String id)
 * public String getSubject()
 * public void setSubject(String subject)
 * public String toString() //출력을 위한
 * 
 */

package com.project.dto;

import java.io.Serializable;
import java.sql.SQLException;

import com.project.dao.StudentDao;

public class GradeDto implements Serializable {

	private String id;
	private String grade;
	private String subject;

	public GradeDto() {

	}

	public GradeDto(String id, String grade, String subject) {
		this.id = id;
		this.grade = grade;
		this.subject = subject;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String toString() {
		StudentDao sDao = new StudentDao();
		String s = "";
		try {
			s = sDao.getStudent(this.id).getName();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "[이름 : " + s + "\t과목 : " + this.subject + "\t성적 : " + this.grade + "\t]";

	}
}
