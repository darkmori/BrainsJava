/*
 * attend 테이블을 위한 DTO
 * 첫 칼럼인 seq는 프라이머리 키를 위한 컬럼이므로 DTO에선 사용 안함
 * 
 * ----------------------------------------------------
 * 		public class AttendDto implements Serializable
 * ----------------------------------------------------
 * private String id;
 * private String attend;
 * private String late;
 * private String early;
 * private String finish;
 * private String adate;
 * 
 * public AttendDto() //생성자
 * public AttendDto(String id, String attend, String late, String early, String finish, String adate) //생성자 오버로딩 - 각값에 받은거 넣어줌.
 * public String getAdate() 			//get-set 모음
 * public void setAdate(String adate)
 * public String getAttend()
 * public void setAttend(String attend)
 * public String getEarly()
 * public void setEarly(String early)
 * public String getFinish()
 * public void setFinish(String finish)
 * public String getId()
 * public void setId(String id)
 * public String getLate()
 * public void setLate(String late)
 * public String toString() //출력을 위한
 * 
 */

package com.project.dto;

import java.io.Serializable;
import java.sql.SQLException;

import com.project.dao.StudentDao;

public class AttendDto implements Serializable { // DTO 시리얼라이져블 받음

	private String id;
	private String attend;
	private String late;
	private String early;
	private String finish;
	private String adate;

	public AttendDto() {
	} // 생성자

	public AttendDto(String id, String attend, String late, String early, String finish, String adate) {
		this.id = id;
		this.attend = attend;
		this.late = late;
		this.early = early;
		this.finish = finish;
		this.adate = adate;
	}// 생성자 오버로딩..

	// 이하 각 변수에 대한 get/set
	public String getAdate() {
		return adate;
	}

	public void setAdate(String adate) {
		this.adate = adate;
	}

	public String getAttend() {
		return attend;
	}

	public void setAttend(String attend) {
		this.attend = attend;
	}

	public String getEarly() {
		return early;
	}

	public void setEarly(String early) {
		this.early = early;
	}

	public String getFinish() {
		return finish;
	}

	public void setFinish(String finish) {
		this.finish = finish;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLate() {
		return late;
	}

	public void setLate(String late) {
		this.late = late;
	}

	// com.project.util.StudentMethod.show에서 사용할 출력부
	public String toString() {
		StudentDao sDao = new StudentDao();
		String s = "";
		try {
			s = sDao.getStudent(this.id).getName();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "[ 이름 : " + s + "\t출석 : " + this.attend + "\t지각 : " + this.late + "\t조퇴 : " + this.early + "\t퇴근 : "
				+ this.finish + "\t시각 : " + this.adate + "  ]";
	}
}