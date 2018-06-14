/*
 * penalty 테이블을 위한 DTO
 * 첫 칼럼인 seq는 프라이머리 키를 위한 컬럼이므로 DTO에선 사용 안함
 * 
 * ----------------------------------------------------
 * 		public class PenaltyDto implements Serializable
 * ----------------------------------------------------
 * private String id;
 * private int amount;
 * private String why;
 * private String pdate;
 *  
 * public PenaltyDto() //생성자
 * public PenaltyDto(String id, int amount, String why,  String pdate) //생성자 오버로딩 - 각값에 받은거 넣어줌.
 * public int getAmount() 			//get-set 모음
 * public void setAmount(int amount)
 * public String getId()
 * public void setId(String id)
 * public String getPdate()
 * public void setPdate(String pdate)
 * public String getWhy()
 * public void setWhy(String why)
 * public String toString() //출력을 위한
 * 
 */

package com.project.dto;

import java.io.Serializable;
import java.sql.SQLException;

import com.project.dao.StudentDao;

public class PenaltyDto implements Serializable {

	private String id;
	private int amount;
	private String why;
	private String pdate;

	public PenaltyDto() {

	}

	public PenaltyDto(String id, int amount, String why, String pdate) {
		this.id = id;
		this.amount = amount;
		this.why = why;

		this.pdate = pdate;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPdate() {
		return pdate;
	}

	public void setPdate(String pdate) {
		this.pdate = pdate;
	}

	public String getWhy() {
		return why;
	}

	public void setWhy(String why) {
		this.why = why;
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
		return "[ 이름 : " + s + "\t금액 : " + this.amount + "\t이유 : " + this.why + "\t\t시각 : " + this.pdate + "\t]";

	}
}
