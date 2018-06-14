/*
 * 메인에서 사용하는 로그인 및 회원가입처리
 * 
 * --------------------------------------------------
 * 				public class LogInProcess
 * --------------------------------------------------
 * 
 * public LogInProcess()		-> 생성자
 * public void loginView()		-> 로그인 메뉴 출력
 * public StudentDto login()	-> 로그인 처리
 * public void joinView()		-> 회원 가입 문구 출력
 * public void join()			-> 회원 가입 처리
 * 
 * 
 */

package com.project.main;

import java.sql.SQLException;

import com.project.dao.StudentDao;
import com.project.dto.StudentDto;
import com.project.util.StudentMethod;
import com.project.util.SceneUtil;

public class LogInProcess {
	public LogInProcess() {
	} // LogInProcess

	// 로그인 화면 출력
	public void loginView() {
		System.out.println("--------------------------------------------------");
		System.out.println("\t\t학생관리 프로그램");
		System.out.println("--------------------------------------------------");
		System.out.println("\t\t로그인 ----> 1번");
		System.out.println("\t\t회원가입 --> 2번");
		System.out.println("--------------------------------------------------");
	}// loginView

	// 로그인 처리
	public StudentDto login() {

		StudentDto sdto = new StudentDto();
		// 입력 받자 아이디랑 패스워드.
		String inputId = "";
		String inputPw = "";

		StudentDao dao = new StudentDao();
		int rp = 0;
		while (rp == 0) { // 아이디 없으면 계속 반복
			System.out.print("ID : ");
			inputId = StudentMethod.input();
			if (!dao.hasId(inputId)) { // 있는 아이디 인지 검사
				System.out.println("없는 아이디입니다. 다시 입력해 주세요.");
				System.out.println();
			} else {
				rp = 1;
			}
		} // while

		System.out.print("PASSWORD : ");
		inputPw = StudentMethod.input();

		// id, pw 둘중 하나라도 입력안하면 다시 입력~
		if (inputId.equals("") || inputPw.equals("")) {
			System.out.println("잘못 입력하셨습니다.");
			System.out.println();
			return null;
		} // if

		try {
			sdto = dao.getStudent(inputId);
			// 입력한 password와 db에 저장된 password 가 틀리면 retry.
			// System.out.println(dao.getStudent(inputId).getPassword());
			// if((dao.getStudent(inputId).getPassword()).trim().equals(inputPw)){
			if (sdto.getPass().trim().equals(inputPw)) {
				if (dao.getStudent(inputId).getNo() == 0) {
					// ADMINMENU로.
					StudentTestMain.status = SceneUtil.ADMINMENU;

				} else {
					// USERMENU로.
					StudentTestMain.status = SceneUtil.USERMENU;
					System.out.println("--------------------------------------------------"); // 로긴하면 환영메세지 출력
					System.out.println("\t\t" + dao.getStudent(inputId).getName().trim() + "님 환영합니다.");
					System.out.println("--------------------------------------------------");
					System.out.println();
				} // if-else : getStudent
			} else {
				System.out.println("패스워드가 틀렸습니다. 다시 입력해 주세요.");
				System.out.println();
			} // if-else : getPass
		} catch (SQLException e) {
			e.printStackTrace();
		} // try-cathc

		return sdto;
	}// login

	// 회원가입화면.
	public void joinView() {
		System.out.println();
		System.out.println("--------------------------------------------------");
		System.out.println("\t\t회원가입 하세요.");
		System.out.println("--------------------------------------------------");
	} // joinView

	// 회원가입 처리
	public void join() {
		String newId = "", newPw = "", newName = "", newAddr = "", newBirth = "", newPw2 = "";
		int rp = 0;
		StudentDao sdao = new StudentDao();

		while (rp == 0) { // 아이디 사용중이면 반복
			System.out.print("ID : ");
			newId = StudentMethod.input();
			if (sdao.hasId(newId)) { // 사용중인 아이디인지 검사
				System.out.println("이미 사용중인 아이디입니다.");
				System.out.println();
			} else if (newId.length() > 7) {
				System.out.println("아이디는 7자 이하만 가능합니다.");
				System.out.println();
			} else {
				rp = 1;
			}
		} // while

		rp = 0;
		while (rp == 0) { // 비밀번호 2개 같지 않으면 다시..
			System.out.print("PASSWORD : ");
			newPw = StudentMethod.input();

			System.out.print("PASSWORD 재확인 : ");
			newPw2 = StudentMethod.input();

			if (!newPw.equals(newPw2)) {
				System.out.println("비밀번호를 잘못 입력하셨습니다. 다시 입력하세요.");
				System.out.println();
			} else if (newPw.length() > 7) {
				System.out.println("비밀번호는 7자 이하만 가능합니다. 다시 입력하세요.");
				System.out.println();
			} else {
				rp = 1;
			}
		} // while

		while (rp == 1) {
			System.out.print("이름 : ");
			newName = StudentMethod.input();
			if (newName.length() > 7) {
				System.out.println("이름은 7자 이하만 가능합니다. 다시 입력하세요.");
				System.out.println();
			} else {
				rp = 0;
			}
		}

		while (rp == 0) {
			System.out.print("주소 : ");
			newAddr = StudentMethod.input();
			if (newAddr.length() > 20) {
				System.out.println("주소는 20자 이하만 가능합니다. 다시 입력하세요.");
				System.out.println();
			} else {
				rp = 1;
			}
		}

		while (rp == 0) {
			System.out.print("생년월일(년/월/일) : ");
			newBirth = StudentMethod.input();
			if (newBirth.length() > 20) {
				System.out.println("생년월일는 10자 이하만 가능합니다. 다시 입력하세요.");
				System.out.println();
			} else {
				rp = 1;
			}
		}

		StudentDao dao = new StudentDao();
		boolean result = false;
		try {
			result = dao.joinStudent(newId, newPw, newName, 1, newAddr, newBirth); // 회원가입처리..
		} catch (SQLException e) {
			e.printStackTrace();
		} // try-catchW

		if (result) { // 회원가입 성공하면...
			try {
				System.out.println(dao.getStudent(newId).getName().trim() + "님의 회원가입이 완료되었습니다.");
				System.out.println();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} else {
			System.out.println("회원 가입 실패!");
		} // if-else
	} // join

}// class
