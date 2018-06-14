/*
 * student 테이블을 위한 DTO
 * 첫 칼럼인 seq는 프라이머리 키를 위한 컬럼이므로 DTO에선 사용 안함
 * 
 * ----------------------------------------------------
 * 		public class StudentDto implements Serializable
 * ----------------------------------------------------
 * private String id;
 * private String password;
 * private String name;
 * private int no;
 * private String addr;
 * private String birthday;
 *  
 * public StudentDto() //생성자
 * public StudentDto(String id, String password, String name, int no,  String addr, String birthday) //생성자 오버로딩 - 각값에 받은거 넣어줌.
 * public String getAddr() 			//get-set 모음
 * public void setAddr(String addr)
 * public String getBirth()
 * public void setBirth(String birthday)
 * public String getId()
 * public void setId(String id)
 * public String getName()
 * public void setName(String name)
 * public int getNo()
 * public void setNo(int no)
 * public String getPass()
 * public void setPass(String password)
 * public String toString() //출력을 위한
 * 
 */

package com.project.dto;

import java.io.Serializable;

public class StudentDto implements Serializable {

	private String id;
	private String password;
	private String name;
	private int no;
	private String addr;
	private String birthday;

	public StudentDto() {
	}

	public StudentDto(String id, String password, String name, int no, String addr, String birthday) {
		this.id = id;
		this.name = name;
		this.addr = addr;
		this.no = no;
		this.password = password;
		this.birthday = birthday;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getBirth() {
		return birthday;
	}

	public void setBirth(String birthday) {
		this.birthday = birthday;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getPass() {
		return password;
	}

	public void setPass(String password) {
		this.password = password;
	}

	public String toString() {
		return "[ ID : " + this.id + "\t비밀번호 : " + this.password + "\t이름 : " + this.name + "\t주소 : " + this.addr
				+ "\t생년월일 : " + this.birthday + "]";
	}

}